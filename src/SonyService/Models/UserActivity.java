package SonyService.Models;

public class UserActivity {
    private int id;
    private int userId;
    private String mediaType; // Movie, Music, TV Show
    private String mediaName; // Foreign key -> movie/music/tvShow id
    private String actionType; // Played, Rated
    private int actionValue; // PLayed (0, 1) for true false, and Rating

    public UserActivity() {}

    public UserActivity(int id, int userId, String mediaType, String mediaName, String actionType, int actionValue) {
        this.id = id;
        this.userId = userId;
        this.mediaType = mediaType;
        this.mediaName = mediaName;
        this.actionType = actionType;
        this.actionValue = actionValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public int getActionValue() {
        return actionValue;
    }

    public void setActionValue(int actionValue) {
        this.actionValue = actionValue;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }



}
