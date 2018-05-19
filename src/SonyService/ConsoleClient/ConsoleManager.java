package SonyService.ConsoleClient;

import SonyService.Database.MovieRepository;
import SonyService.Models.Movie;
import SonyService.RESTClient.RESTClient;

import java.util.Scanner;

public class ConsoleManager {

    private Scanner scanner;

    public ConsoleManager() {
        scanner = new Scanner(System.in);

        System.out.println("Console Client started.");
        mainChoiceTree();
    }

    private void mainChoiceTree() {
        System.out.println("Choose an action:");
        System.out.println("1. Insert a movie.");
        System.out.println("2. Exit.");

        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                //TODO: insert movie
                break;
            case 2:
                System.out.println("Exiting the Console Client.");
                return;
            default:
                System.out.println("Invalid input.");
                mainChoiceTree();
                break;
        }
    }

    private void insertMovie() {
        System.out.print("\033[H\033[2J");

        Movie movie = new Movie();

        System.out.println("Movie title:");
        movie.setTitle(scanner.next());
        System.out.println("Movie description:");
        movie.setDescription(scanner.next());
        System.out.println("Movie poster url:");
        movie.setImageUrl(scanner.next());
        System.out.println("Movie video url:");
        movie.setVideoUrl(scanner.next());

        MovieRepository movieRepo = new MovieRepository();
        movieRepo.addMovie(movie);

        RESTClient client = new RESTClient();
        client.PostMovie(movie);


    }


}
