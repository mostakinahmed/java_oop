import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

// 1. ABSTRACTION: Interface defining the contract for any report
interface Reportable {
    void showReport();
}

// 2. ENCAPSULATION: Base class to hold location data
class Location {
    private String cityName; // Private field

    public Location(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() { // Public getter
        return cityName;
    }
}

// 3. INHERITANCE: DistrictWeather "is a" Location
class DistrictWeather extends Location implements Reportable {
    private double temp;
    private int humidity;
    private String description;

    public DistrictWeather(String cityName, double temp, int humidity, String description) {
        super(cityName); // Calling parent constructor
        this.temp = temp;
        this.humidity = humidity;
        this.description = description;
    }

    // 4. POLYMORPHISM: Overriding the interface method
    @Override
    public void showReport() {
        System.out.println("\n------ WEATHER REPORT: " + getCityName().toUpperCase() + " ------");
        System.out.println("Temperature : " + temp + "°C");
        System.out.println("Humidity    : " + humidity + "%");
        System.out.println("Condition   : " + description);
        System.out.println("------------------------------------------");
    }
}

public class Weather {
    private static final String API_KEY = "2ac1f233d3718fd3d0d1cc7795c46cc9";
    private static final String[] DISTRICTS = {
            "Dhaka", "Faridpur", "Gazipur", "Gopalganj", "Madaripur", "Manikganj", "Munshiganj", "Narayanganj",
            "Narsingdi", "Rajbari", "Shariatpur", "Tangail",
            "Bagerhat", "Chuadanga", "Jessore", "Jhenaidah", "Khulna", "Kushtia", "Magura", "Meherpur", "Narail",
            "Satkhira",
            "Bogra", "Joypurhat", "Naogaon", "Natore", "Chapainawabganj", "Pabna", "Rajshahi", "Sirajganj",
            "Dinajpur", "Gaibandha", "Kurigram", "Lalmonirhat", "Nilphamari", "Panchagarh", "Rangpur", "Thakurgaon",
            "Barguna", "Barisal", "Bhola", "Jhalokati", "Patuakhali", "Pirojpur",
            "Bandarban", "Brahmanbaria", "Chandpur", "Chattogram", "Comilla", "Cox's Bazar", "Feni", "Khagrachhari",
            "Lakshmipur", "Noakhali", "Rangamati",
            "Habiganj", "Moulvibazar", "Sunamganj", "Sylhet",
            "Jamalpur", "Mymensingg", "Netrokona", "Sherpur"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== REAL-TIME BANGLADESH DISTRICT WEATHER ===");

        // Show 64 Districts with IDs
        for (int i = 0; i < DISTRICTS.length; i++) {
            System.out.printf("%2d. %-15s", (i + 1), DISTRICTS[i]);
            if ((i + 1) % 4 == 0)
                System.out.println();
        }

        try {
            System.out.print("\n\nEnter District ID (1-64): ");
            int choice = sc.nextInt();
            String cityName = DISTRICTS[choice - 1];

            System.out.println("Fetching data for " + cityName + "...");
            String jsonResponse = fetchWeather(cityName);

            // Manual Parsing (As requested)
            double temp = Double.parseDouble(extractValue(jsonResponse, "temp"));
            int humidity = Integer.parseInt(extractValue(jsonResponse, "humidity"));
            String desc = extractValue(jsonResponse, "description");

            // Create Object (OOP in action)
            Reportable myWeather = new DistrictWeather(cityName, temp, humidity, desc);
            myWeather.showReport();

        } catch (java.lang.Exception e) {
            System.out.println("Error: Please enter a valid ID and check internet.");
        }
    }

    // Helper: Simple API Fetcher
    private static String fetchWeather(String cityName) throws java.lang.Exception {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + API_KEY
                + "&units=metric";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }

    // Helper: Manual String Extraction
    private static String extractValue(String data, String key) {
        if (key.equals("temp") || key.equals("humidity")) {
            String search = "\"" + key + "\":";
            int start = data.indexOf(search) + search.length();
            int end = data.indexOf(",", start);
            if (data.indexOf("}", start) < end && data.indexOf("}", start) != -1)
                end = data.indexOf("}", start);
            return data.substring(start, end);
        } else {
            String search = "\"" + key + "\":\"";
            int start = data.indexOf(search) + search.length();
            int end = data.indexOf("\"", start);
            return data.substring(start, end);
        }
    }
}