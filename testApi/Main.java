import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

/**
 * Nagar Sheba: Public Utility & Complaint Management System
 * Feature: Dynamic Location Selector using Bangladesh Geo-Location API
 * Author: Mostakin Ahmed (DIU)
 */
public class Main {
    private static final String BASE_URL = "https://bdopenapi.vercel.app/api/geo";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   NAGAR SHEBA: LOCATION SELECTOR");
        System.out.println("=========================================");

        try {
            // STEP 1: Fetch and Filter Divisions
            System.out.println("\n[STEP 1] Fetching Divisions...");
            String divData = fetchSync("/divisions");
            printFilteredData(divData, null, null); 

            System.out.print("\n>>> Enter Division ID to select: ");
            String selectedDivId = scanner.nextLine();

            // STEP 2: Fetch and Filter Districts
            System.out.println("\n[STEP 2] Fetching Districts for Division ID: " + selectedDivId);
            String distData = fetchSync("/districts");
            printFilteredData(distData, "division_id", selectedDivId);

            System.out.print("\n>>> Enter District ID to select: ");
            String selectedDistId = scanner.nextLine();

            // STEP 3: Fetch and Filter Upazilas
            System.out.println("\n[STEP 3] Fetching Upazilas for District ID: " + selectedDistId);
            String upzData = fetchSync("/upazilas");
            printFilteredData(upzData, "district_id", selectedDistId);

            System.out.println("\n=========================================");
            System.out.println("SUCCESS: Location selection finalized.");
            System.out.println("=========================================");

        } catch (java.lang.Exception e) {
            // Using fully qualified name to avoid the "Unresolved compilation" error
            System.out.println("\n[Error]: Could not connect to API.");
            System.out.println("Details: " + e.getMessage());
        }
    }

    /**
     * Splits JSON string and extracts values manually to avoid external libraries.
     */
    private static void printFilteredData(String data, String filterKey, String filterValue) {
        // Splitting by the end of JSON objects
        String[] items = data.split("\\},");
        boolean found = false;

        for (String item : items) {
            // Logic: If filterKey is null (for Divisions), show all. 
            // Otherwise, check if the object contains the specific ID pair.
            boolean matchesFilter = (filterKey == null) || 
                                    item.contains("\"" + filterKey + "\":\"" + filterValue + "\"");

            if (matchesFilter) {
                String id = extractValue(item, "id");
                String name = extractValue(item, "name");
                String bnName = extractValue(item, "bn_name");

                if (!id.isEmpty() && !name.isEmpty()) {
                    System.out.printf("  ID: %-4s | %-15s (%s)\n", id, name, bnName);
                    found = true;
                }
            }
        }
        
        if (!found) {
            System.out.println("  No data found for this selection.");
        }
    }

    /**
     * Finds a value by key using substring logic. 
     * Handles JSON format like "name":"Dhaka"
     */
    private static String extractValue(String item, String key) {
        String searchKey = "\"" + key + "\":\"";
        int startIndex = item.indexOf(searchKey);
        
        if (startIndex == -1) return ""; 
        
        startIndex += searchKey.length();
        int endIndex = item.indexOf("\"", startIndex);
        
        if (endIndex == -1) return "";
        
        return item.substring(startIndex, endIndex);
    }

    /**
     * Helper to perform a Synchronous GET request.
     */
    private static String fetchSync(String endpoint) throws java.lang.Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .header("Accept", "application/json")
                .GET()
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() != 200) {
            throw new java.lang.Exception("HTTP Error: " + response.statusCode());
        }
        
        return response.body();
    }
}