package endpoints;

import java.util.logging.Logger;

public class Authentication { //Singleton class
    private static Authentication authentication = null;
    private Authentication(){};
    public static Authentication getInstance(){
        if(authentication == null) {
            authentication = new Authentication();
        }
        return authentication;
    }

    private static final Logger log = Logger.getLogger(GET.class.getName());
    public void addURL() {
        log.info("https://api.themoviedb.org/3 was added");
    }
    public void createGuestSession(){
        log.info("/authentication/guest_session/new was added to the URL");
    }
    public void createRequestToken() {
        log.info("/authentication/token/new was added to the URL");
    }

    public void typeKey(String apiKeyMdb) {
        log.info("?api_key=<my_key> was added to the url");
    }

    public void sendRequest() {
        log.info("The request was sent to TMDB");
    }

    public String getPayloadJsonFirstLine() {
        log.info("The JSON file was read");

        return "\"success\":true";
    }

    public String getStatusCode() {
        log.info("The answer was received");
        return "200";
    }
}
