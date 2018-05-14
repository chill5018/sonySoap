package SonyService.Database;

import SonyService.Models.Content;
import SonyService.Models.UserActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserActivityRepository {

    private DatabaseConnector DB;

    public UserActivityRepository() {
        this.DB = new DatabaseConnector();
    }

    public Content getContent(int contentId, String mediaType) {

        if(mediaType.equals("movie"))
            return new MovieRepository().getMovie(contentId);
        //TODO: add more media types

        return null;
    }

    public void addUserActivity(ArrayList<UserActivity> activityList) {
        try {

            String sql = "INSERT INTO userActivity VALUES(?, ?, ?, ?, ?)";
            Connection conn = DB.getConn();
            conn.setAutoCommit(false);

            for (UserActivity ua : activityList) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, ua.getUserId());
                stmt.setString(2, ua.getMediaType());
                stmt.setInt(3, getContent(ua.getId(), ua.getMediaType()).getId());
                stmt.setString(4, ua.getActionType());
                stmt.setInt(5, ua.getActionValue());

                stmt.executeUpdate();
            }

            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
