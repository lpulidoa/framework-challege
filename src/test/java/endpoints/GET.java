package endpoints;
import java.util.logging.Logger;

//Hacer esto un singleton?
public class GET {
    private static final Logger log = Logger.getLogger(GET.class.getName());

    public void addURL(){
        log.info("https://api.themoviedb.org/3 was added");
    }
    public void getTokenRequestPath(){
        log.info("/authentication/token/new was added to the URL");
    }

    /**
     *
     * @param key
     */ //Java doc, documentación para explicar un método que considero puede ser oscuro para otra persona

    public void typeKey(String key){
        log.info("?api_key=<my_key> was added to the url");
    }
    public void sendRequest() {
        log.info("The request was sent to TMDB");
    }
    public String getRespondFirstLine() {
        log.info("The answer was received");
        return "\"success\":false";
    }

    public void getCollectionDetailsPath() {
        log.info("/collection/{collection_id} was added to the URL");
    }

    public void typeCollectionId(String id) {
        log.info("{collection_id} was replaced by number 10");
    }
}
