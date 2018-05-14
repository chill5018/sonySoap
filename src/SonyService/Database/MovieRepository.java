package SonyService.Database;

import SonyService.Models.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieRepository {

    private DatabaseConnector DB;

    public MovieRepository() {
        this.DB = new DatabaseConnector();
    }

    public ArrayList<Movie> getMoviesFromDatabase() {
        ArrayList<Movie> movieList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM movies";
            PreparedStatement stmt = DB.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Movie m = new Movie();

                m.setId(rs.getInt("id"));
                m.setTitle(rs.getString("title"));
                m.setDescription(rs.getString("movie_description"));
                m.setImageUrl(rs.getString("image_url"));
                m.setVideoUrl(rs.getString("video_url"));

                movieList.add(m);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    public void addMovies(ArrayList<Movie> movies) {
        try {

            String sql = "INSERT INTO movies VALUES(?, ?, ?, ?)";
            Connection conn = DB.getConn();
            conn.setAutoCommit(false);

            for (Movie m : movies) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, m.getTitle());
                stmt.setString(2, m.getDescription());
                stmt.setString(3, m.getImageUrl());
                stmt.setString(4, m.getVideoUrl());
                stmt.executeUpdate();
            }

            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Movie getMovie(int id) {
        Movie result = null;
        try {
            String sqlCom = "SELECT * FROM movies WHERE id=?";
            PreparedStatement stmt = DB.getConn().prepareStatement(sqlCom);
            stmt.setObject(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                result = new Movie();
                result.setId(id);
                result.setTitle(resultSet.getString("title"));
                result.setDescription(resultSet.getString("movie_description"));
                result.setImageUrl(resultSet.getString("image_url"));
                result.setVideoUrl(resultSet.getString("video_url"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
//
//    public Movie getMovie(String title) {
//        Movie result = null;
//        try {
//            String sqlCom = "SELECT * FROM movies WHERE title=?";
//            PreparedStatement stmt = DB.getConn().prepareStatement(sqlCom);
//            stmt.setObject(1, title);
//            ResultSet resultSet = stmt.executeQuery();
//
//            if (resultSet.next()) {
//                result = new Movie();
//                result.setId(resultSet.getInt("id"));
//                result.setTitle(resultSet.getString("title"));
//                result.setDescription(resultSet.getString("movie_description"));
//                result.setImageUrl(resultSet.getString("image_url"));
//                result.setVideoUrl(resultSet.getString("video_url"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

}
