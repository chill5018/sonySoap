package SonyService.Database;

import SonyService.Models.Movie;
import SonyService.Models.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SongRepository {

    private DatabaseConnector DB;

    public SongRepository() {
        this.DB = new DatabaseConnector();
    }

    public ArrayList<Song> getSongsFromDatabase() {
        ArrayList<Song> songsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM songs";
            PreparedStatement stmt = DB.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Song s = new Song();

                s.setId(rs.getInt("id"));
                s.setTitle(rs.getString("title"));
                s.setDescription(rs.getString("description"));
                s.setStreamUrl(rs.getString("stream_url"));
                songsList.add(s);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songsList;
    }

    public void addSongs(ArrayList<Song> songs) {
        try {

            String sql = "INSERT INTO movies VALUES(?, ?, ?, ?)";
            Connection conn = DB.getConn();
            conn.setAutoCommit(false);

            for (Song s : songs) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, s.getTitle());
                stmt.setString(2, s.getDescription());
                stmt.setString(4, s.getStreamUrl());
                stmt.executeUpdate();
            }

            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Song getSong(int id) {
        Song result = null;
        try {
            String sqlCom = "SELECT * FROM songs WHERE id=?";
            PreparedStatement stmt = DB.getConn().prepareStatement(sqlCom);
            stmt.setObject(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                result = new Song();
                result.setId(id);
                result.setTitle(resultSet.getString("title"));
                result.setDescription(resultSet.getString("movie_description"));
                result.setStreamUrl(resultSet.getString("stream_url"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

//    public Song.java getSong(String title) {
//        Song.java result = null;
//        try {
//            String sqlCom = "SELECT * FROM songs WHERE title=?";
//            PreparedStatement stmt = DB.getConn().prepareStatement(sqlCom);
//            stmt.setObject(1, title);
//            ResultSet resultSet = stmt.executeQuery();
//
//            if (resultSet.next()) {
//                result = new Song.java();
//                result.setId(resultSet.getInt("id"));
//                result.setTitle(resultSet.getString("title"));
//                result.setDescription(resultSet.getString("movie_description"));
//                result.setStreamUrl(resultSet.getString("video_url"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
}
