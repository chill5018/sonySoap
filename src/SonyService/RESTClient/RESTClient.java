package SonyService.RESTClient;

import SonyService.Models.Movie;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.net.HttpURLConnection;
import java.net.URL;

public class RESTClient {


    public boolean PostMovie(Movie movie) {
        try {
            String payload = String.format("{\"title\":\"%s\", \"description\":\"%s\", \"posterUrl\":\"%s\", \"videoUrl\":\"%s\"}",
                    movie.getTitle(), movie.getDescription(), movie.getImageUrl(), movie.getVideoUrl());

            StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_FORM_URLENCODED);


            HttpClient client = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost("http://localhost:8888/movies/add");
            request.setEntity(entity);

            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            return (statusCode >= 200) && (statusCode < 300);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
