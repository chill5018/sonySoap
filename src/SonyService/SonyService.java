package SonyService;

import SonyService.Database.DatabaseConnector;
import SonyService.Models.Movie;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

@WebService()
public class SonyService {
  public static List<Movie> movieList;

  private static DatabaseConnector DB = new DatabaseConnector();

  public static void main(String[] argv) {
    movieList = new ArrayList<>();

    DB.connectDatabase();


    Object implementor = new SonyService();
    String address = "http://localhost:9000/SonyService";
    Endpoint.publish(address, implementor);
  }


  @WebMethod
  public void getMovieStats(@WebParam(name = "studentId") int studentId,
                                @WebParam(name = "classId")int classId)
  {

  }

  @WebMethod
  // Sends movie to Mediaroids
  public Movie sendMovies(@WebParam(name = "content_receiver") String contentReceiver) {

    // Sets the movie list with Data
//    Movie m = DB.getMoviesFromDatabase();

    return DB.getMoviesFromDatabase();

    // Return the movies list
//    return movieList;
  }

  @WebMethod
  // Receives Mediaroids User Activity Data
  // Streams, Plays, Ratings
  public void getUserActivity() {

  }
}
