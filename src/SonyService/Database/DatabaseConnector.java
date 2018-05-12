package SonyService.Database;

import SonyService.Models.Movie;
import SonyService.SonyService;

import java.sql.*;

public class DatabaseConnector {
    static final String DB_URL = "jdbc:mysql://localhost/kea";
    static final String DB_USER = "root";
    static final String DB_PASS = "teamtreehouse";

    private Connection conn = null;
    private Statement stmt = null;

    public void connectDatabase() {
        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.print("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");


        try {
            conn = DriverManager
                    .getConnection(DB_URL, DB_USER, DB_PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Loading from XML Sheets");
            e.printStackTrace();
            return;
        }

        if (conn != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public Connection getConn() {
        return conn;
    }

    public Movie getMoviesFromDatabase() {
//        try {
//            String sql = "SELECT * FROM movies";
//
//            stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
                Movie m = new Movie();

                m.setDescription("Hello Movies Desc");
                m.setTitle("Happy Gilmore");
                m.setImageUrl("https://google.com");
                m.setVideoUrl("https://google.com");
                m.setId(1);

//                m.setId(rs.getInt("id_student"));
//                m.setTitle(rs.getString("title"));
//                m.setDescription(rs.getString("movie_description"));
//                m.setImageUrl(rs.getString("image_url"));
//                m.setVideoUrl(rs.getString("video_url"));

//                SonyService.movieList.add(m);

                return m;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }


}
