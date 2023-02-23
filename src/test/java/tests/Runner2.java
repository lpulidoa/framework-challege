package tests;

import endpoints.Authentication;
import endpoints.Collection;
import endpoints.Movie;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.logging.Logger;

public class Runner2 {

    private static final Logger log = Logger.getLogger(Runner.class.getName());
    private final Authentication authentication = Authentication.getInstance();


    @Test
    public void GET_successful_create_guest_session(){

        authentication.addURL();
        authentication.createGuestSession();
        log.info(System.getenv("API_KEY_MDB"));
        authentication.typeKey(System.getenv("API_KEY_MDB"));
        authentication.sendRequest();

        Assert.assertEquals(authentication.getStatusCode(),"200", "The request failed");
        Assert.assertEquals(authentication.getPayloadJsonFirstLine(),"\"success\": true", "The request failed");
    }
    @Test
    public void GET_successful_token_request(){

        authentication.addURL();
        authentication.createRequestToken();
        log.info(System.getenv("API_KEY_MDB"));
        authentication.typeKey(System.getenv("API_KEY_MDB"));
        authentication.sendRequest();

        Assert.assertEquals(authentication.getStatusCode(),"200", "The request failed");
        Assert.assertEquals(authentication.getPayloadJsonFirstLine(),"\"success\":true", "The request failed");
    }

    @Test
    public void GET_successful_collection_details(){

        Collection collection = new Collection(10);

        collection.addURL();
        collection.getDetails();
        collection.typeCollectionId(collection.getCollectionId());
        collection.typeKey(System.getenv("API_KEY_MDB"));
        collection.sendRequest();

        Assert.assertEquals(collection.getStatusCode(),"200", "The request failed");
        Assert.assertEquals(collection.getPayloadJsonFirstLine(),"\"id\": "+collection.getCollectionId(), "The wrong details were received");
    }
    @Test
    public void GET_unsuccessful_collection_images(){

        Collection collection = new Collection(0);

        collection.addURL();
        collection.getImages();
        collection.typeCollectionId(collection.getCollectionId());
        collection.typeKey(System.getenv("API_KEY_MDB"));
        collection.sendRequest();

        Assert.assertEquals(collection.getStatusCode(),"404", "The request should have failed");
        Assert.assertEquals(collection.searchPayloadJson(),"\"status_message\": \"The resource you requested could not be found.\"", "The wrong details were received");
    }

    @Test
    public void GET_successful_movie_alternative_names(){

        Movie movie = new Movie(550);

        movie.addURL();
        movie.getAlternativeTitles();
        movie.typeMovieId(movie.getMovieId());
        movie.typeKey(System.getenv("API_KEY_MDB"));
        movie.sendRequest();

        Assert.assertEquals(movie.getStatusCode(),"200", "The request failed");
        Assert.assertEquals(movie.getPayloadJsonFirstLine(),"\"id\": "+movie.getMovieId(), "The wrong details were received");
        Assert.assertEquals(movie.searchPayloadJson(),"\"titles\":[","The alternative titles were nor received");
    }

    // tener un JSON con el URL, con los paths. Buscar parsing tool jackson(en lo posible) gson(más sencillo, menos poderoso)
    // hacer la implementación de un reporte --> buscar cómo incluir un allure report
    // objetivo de un archivo .properties

}
