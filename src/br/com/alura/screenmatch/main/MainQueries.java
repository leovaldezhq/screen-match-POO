package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.Title;
import br.com.alura.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;
import java.util.Scanner;

public class MainQueries {
    public static void main(String []args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search a movie: ");
        var search = scanner.nextLine();

        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("Error loading config.properties");
        }

        try {
        String apiKey =  properties.getProperty("omdb.apikey");
        String address = "http://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        TitleOmdb omdbTitle = gson.fromJson(json, TitleOmdb.class);
        System.out.println(omdbTitle);

            Title title = new Title (omdbTitle);
            System.out.println("Converted title");
            System.out.println(title);
        } catch (NumberFormatException e) {
            System.out.println("The following error has occurred: ");
            System.out.println(e.getMessage());
        }

    }

}