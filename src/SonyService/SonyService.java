package SonyService;

import SonyService.ConsoleClient.ConsoleManager;
import SonyService.Database.MovieRepository;
import SonyService.Database.SongRepository;
import SonyService.Database.UserActivityRepository;
import SonyService.Models.Movie;
import SonyService.Models.Song;
import SonyService.Models.UserActivity;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;

@WebService()
public class SonyService {

  private static MovieRepository movieRepo= new MovieRepository();
  private static SongRepository songRepo = new SongRepository();
  private static UserActivityRepository activityRepo = new UserActivityRepository();

  public static void main(String[] argv) {

    Object implementor = new SonyService();
    String address = "http://localhost:9000/SonyService";
    Endpoint.publish(address, implementor);


    System.out.println("The Console Client is starting...");
    ConsoleManager consoleManager = new ConsoleManager();


  }


  @WebMethod
  /**
   * Searches a movie by id and returns it.
   */
  public Movie getMovie(@WebParam(name = "Id") int id) {
    return movieRepo.getMovie(id);
  }

  @WebMethod
  /**
   * Searches a song by id and returns it.
   */
  public Song getSong(@WebParam(name = "Id") int id) {
    return songRepo.getSong(id);
  }

  @WebMethod
  /**
   * Adds a list of movies to the database.
   */
  public void sendMovies(@WebParam(name= "Movie List") ArrayList<Movie> movies) {
    movieRepo.addMovies(movies);
  }

  @WebMethod
  /**
   * Adds a list of songs to the database.
   */
  public void sendSongs(@WebParam(name= "Song.java List") ArrayList<Song> songs) {
    songRepo.addSongs(songs);
  }


  @WebMethod
  /**
   * Adds the user activity to the database.
   */
  public void sendUserActivity(@WebParam(name = "User Activity List") ArrayList<UserActivity> activity) {
    activityRepo.addUserActivity(activity);
  }

}
