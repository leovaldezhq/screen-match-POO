package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.YearConversionErrorException;
import br.com.alura.screenmatch.models.Title;
import br.com.alura.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class MainQueries {
    public static void main(String []args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String search = "";
        List<Title> titles = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!search.equalsIgnoreCase("quit")) {
            System.out.println("Search a movie: ");
            search = scanner.nextLine();

            if(search.equalsIgnoreCase("quit")) {
                break;
            }
        }

        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("Error loading config.properties");
        }

        String apiKey =  properties.getProperty("omdb.apikey");
        String address = "http://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=" + apiKey;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            TitleOmdb omdbTitle = gson.fromJson(json, TitleOmdb.class);
            System.out.println(omdbTitle);

            Title title = new Title (omdbTitle);
            System.out.println("Converted title");
            System.out.println(title);

            titles.add(title);
        } catch (NumberFormatException e) {
            System.out.println("The following error has occurred: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Argument error has occurred.");
        } catch (YearConversionErrorException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(titles);

        FileWriter writer = new FileWriter("movies.json");
        writer.write(gson.toJson(titles));
        writer.close();
    }
}