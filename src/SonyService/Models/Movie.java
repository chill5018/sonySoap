package SonyService.Models;

public class Movie extends Content {
    private String imageUrl;
    private String videoUrl;

    public Movie()  {
        super();
    }

    public Movie(String title, String description, String imageUrl, String videoUrl) {
        super(title, description);
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
