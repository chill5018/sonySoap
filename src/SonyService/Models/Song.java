package SonyService.Models;

public class Song extends Content {

    private String streamUrl;

    public Song() {
        super();
    }

    public Song(String title, String description, String streamUrl) {
        super(title, description);
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }
}
