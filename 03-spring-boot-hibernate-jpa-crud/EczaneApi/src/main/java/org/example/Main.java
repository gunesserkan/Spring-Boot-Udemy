package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // client (istemci) oluşturma
        var client = HttpClient.newHttpClient();

        //request (sorgu) oluşturma
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.collectapi.com/health/dutyPharmacy?ilce=%C3%87ankaya&il=Ankara"))
                .header("authorization", "apikey 2RoZPPqljetf25ok1OeOpC:0gL64YtZw4nNu1LVIfUeOK")
                .header("content-type", "application/json")
                .build();

        // BodyHandlers.discarding()
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

        JsonArray resultArray = jsonResponse.getAsJsonArray("result");

        for (int i = 0; i < resultArray.size(); i++) {

            Eczane eczane = new Gson().fromJson(resultArray.get(i).getAsJsonObject(), Eczane.class);

            System.out.println("Ad: " + eczane.getName() + " ");
            System.out.println("Semt: " + eczane.getDist() + " ");
            System.out.println("Adres: " + eczane.getAddress() + " ");
            System.out.println("Telefon: " + eczane.getPhone() + " ");
            System.out.println("Konum: " + eczane.getLoc() + " ");
            System.out.println();
        }


    }
}
