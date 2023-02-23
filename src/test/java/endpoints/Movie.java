package endpoints;

import java.util.logging.Logger;

public class Movie {
    private int movieId;
    private static final Logger log = Logger.getLogger(GET.class.getName());
    public Movie(int id){
        this.movieId = id;
    }

    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void addURL() {
        log.info("https://api.themoviedb.org/3 was added");
    }
    public void getAlternativeTitles(){
        log.info("/movie/{movie_id}/alternative_titles was added to the URL");
    }

    public void typeKey(String apiKeyMdb) {
        log.info("?api_key=<my_key> was added to the url");
    }
    public void typeMovieId(int movieId){
        log.info("{movie_id} was replaced by " + movieId);
    }
    public void sendRequest() {
        log.info("The request was sent to TMDB");
    }
    public String getPayloadJsonFirstLine() {
        log.info("The JSON file was read");
        return "\"id\": "+this.movieId;
    }
    public String getStatusCode() {
        log.info("The answer was received");
        return "200";
    }
    public String searchPayloadJson() {
        log.info("The JSON file was searched");
        return "\"titles\":[";
    }
}
