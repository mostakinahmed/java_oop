import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.Scanner;

interface Reportable {
    void showReport();
}

class Location {
    private String cityName;

    public Location(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}

class District {
    private String id;
    private String name;

    public District(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class DistrictWeather extends Location implements Reportable {

    private double temp;
    private int humidity;
    private String description;

    public DistrictWeather(String cityName, double temp, int humidity, String description) {
        super(cityName);
        this.temp = temp;
        this.humidity = humidity;
        this.description = description;
    }

    public void showReport() {
        System.out.println("\n-------- WEATHER REPORT ----------");
        System.out.println("City        : " + getCityName());
        System.out.println("Temperature : " + temp + " °C");
        System.out.println("Humidity    : " + humidity + " %");
        System.out.println("Condition   : " + description);
        System.out.println("----------------------------------------");
    }
}

// Main class
public class WeatherApp {

    private static final String API_KEY = "2ac1f233d3718fd3d0d1cc7795c46cc9";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("----- BANGLADESH DISTRICT WEATHER ----");

            List<District> districts = fetchDistricts();

            if (districts.size() == 0) {
                System.out.println("Failed to load districts.");
                return;
            }

            while (true) {

                for (int i = 0; i < districts.size(); i++) {
                    System.out.printf("%2d. %-15s", (i + 1), districts.get(i).getName());
                    if ((i + 1) % 4 == 0)
                        System.out.println();
                }

                System.out.print("\n\nEnter District ID (0 to exit): ");
                int choice = sc.nextInt();

                // exit
                if (choice == 0) {
                    System.out.println("Exiting program... Goodbye!");
                    break;
                }

                if (choice < 1 || choice > districts.size()) {
                    System.out.println("Invalid choice!\n");
                    continue;
                }

                String city = districts.get(choice - 1).getName();

                System.out.println("Fetching weather for " + city + "...");

                String json = fetchWeather(city);

                double temp = Double.parseDouble(extractValue(json, "temp"));
                int humidity = Integer.parseInt(extractValue(json, "humidity"));
                String desc = extractValue(json, "description");

                Reportable report = new DistrictWeather(city, temp, humidity, desc);
                report.showReport();
            }

        } catch (java.lang.Exception e) {
            System.out.println("Error occurred!");
        }
    }

    private static List<District> fetchDistricts() {
        List<District> list = new ArrayList<>();
        try {
            for (String part : HttpClient.newHttpClient().send(
                    HttpRequest.newBuilder(URI.create("https://bdopenapi.vercel.app/api/geo/districts")).build(),
                    HttpResponse.BodyHandlers.ofString()).body().split("\\{")) {

                if (part.contains("\"name\"")) {
                    String id = extractJson(part, "id"),
                            name = extractJson(part, "name");
                    if (id != null && name != null)
                        list.add(new District(id, name));
                }
            }
        } catch (java.lang.Exception e) {
        }
        return list;
    }

    private static String fetchWeather(String city) {
        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + API_KEY + "&units=metric";

            return HttpClient.newHttpClient()
                    .send(HttpRequest.newBuilder(URI.create(url)).build(),
                            HttpResponse.BodyHandlers.ofString())
                    .body();

        } catch (java.lang.Exception e) {
            System.out.println("Failed to fetch weather!");
            return "";
        }
    }

    // parse weather
    private static String extractValue(String data, String key) {
        try {
            String search = "\"" + key + "\":";
            int start = data.indexOf(search) + search.length();

            if (key.equals("temp") || key.equals("humidity")) {
                int end = data.indexOf(",", start);
                return data.substring(start, end);
            } else {
                start = data.indexOf("\"", start) + 1;
                int end = data.indexOf("\"", start);
                return data.substring(start, end);
            }

        } catch (java.lang.Exception e) {
            return "0";
        }
    }

    // parse district
    private static String extractJson(String data, String key) {

        try {
            String search = "\"" + key + "\":\"";
            int start = data.indexOf(search) + search.length();
            int end = data.indexOf("\"", start);

            return data.substring(start, end);

        } catch (java.lang.Exception e) {
            return null;
        }
    }
}