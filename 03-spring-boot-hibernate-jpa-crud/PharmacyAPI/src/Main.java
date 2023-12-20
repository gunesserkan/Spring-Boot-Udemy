import netscape.javascript.JSObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

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
    }
}