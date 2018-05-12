package com.sony;

import com.sony.Models.Movie;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService()
public class SonyService {
  public static List<Movie> movieList;

  private static DatabaseConnector DB = new DatabaseConnector();


  @WebMethod
  public void getMovieStats(@WebParam(name = "studentId") int studentId,
                                @WebParam(name = "classId")int classId)
  {

  }

  @WebMethod
  // Sends movie to Mediaroids
  public Movie[] sendMovies() {

    return new Movie[1];
  }

  @WebMethod
  // Receives Mediaroids User Activity Data
  // Streams, Plays, Ratings
  public void getUserActivity() {

  }
}
