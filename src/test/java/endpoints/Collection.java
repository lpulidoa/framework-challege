package endpoints;

import java.util.logging.Logger;

public class Collection {
    private int collectionId;
    private static final Logger log = Logger.getLogger(GET.class.getName());
    public Collection(int id){
        this.collectionId = id;
    }

    public int getCollectionId() {
        return collectionId;
    }
    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public void addURL() {
        log.info("https://api.themoviedb.org/3 was added");
    }
    public void getDetails(){
        log.info("/collection/{collection_id} was added to the URL");
    }
    public void getImages(){
        log.info("/collection/{collection_id}/images was added to the URL");
    }
    public void typeKey(String apiKeyMdb) {
        log.info("?api_key=<my_key> was added to the url");
    }
    public void typeCollectionId(int collectionId){
        log.info("{collection_id} was replaced by " + collectionId);
    }
    public void sendRequest() {
        log.info("The request was sent to TMDB");
    }
    public String getPayloadJsonFirstLine() {
        log.info("The JSON file was read");
        return "\"id\": "+this.collectionId;
    }
    public String searchPayloadJson() {
        log.info("The JSON file was searched");
        return "\"status_message\": \"The resource you requested could not be found.\"";
    }
    public String getStatusCode() {
        log.info("The answer was received");
        return "200";
    }
}
