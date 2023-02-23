package tests;

import endpoints.GET;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.logging.Logger;

//EN ESTA CAPA NO DEBERÍA HABER VARIABLES NI MÉTODOS, COMPLETAMENTE LEGIBLE PARA CUALQUIER PERSONA
public class Runner {

    private static final Logger log = Logger.getLogger(Runner.class.getName());
    //@Test
    public void GET_successful_token_request(){ //Clase Autenticathion con método token ---> Hacer uso de singleton para crear una única session ID para hacer todas las requests de autenticaciones
        GET get = new GET();  // Hacer una sola instancia?  //usar factory para crear instancias de GET y POST

        get.addURL();
        get.getTokenRequestPath();
        log.info(System.getenv("API_KEY_MDB"));
        get.typeKey(System.getenv("API_KEY_MDB"));
        get.sendRequest();
        //Assert.assertEquals(get.getStatusCode(),"200", "The request failed");  OTRO TIPO DE ASSERTION
        //poner múltiples assertions por test. Revisar el payload (response headers, json, status code) y escoger cuáles campos son importantes para la lógica del negocio
        Assert.assertEquals(get.getRespondFirstLine(),"\"success\":true", "The request failed");
    }

    //@Test
    public void GET_successful_collection_details(){ //Clase collection
        GET get = new GET();
        String collectionId = "10";

        get.addURL();
        get.getCollectionDetailsPath();
        //get.typeCollectionId("10");   ESTE 10 NO ES LEGIBLE, ERROR DE CLEAN CODE LLAMADO NÚMERO MÁGICO
        get.typeCollectionId(collectionId);
        get.typeKey(System.getenv("API_KEY_MDB"));
        get.sendRequest();
        Assert.assertEquals(get.getRespondFirstLine(),"\"id\":10");
    }

    // mi patrón singleton
    // tener un JSON con el URL, con los paths. Buscar parsing tool jackson(en lo posible) gson(más sencillo, menos poderoso)
    // hacer la impelemtación de un reporte --> buscar cómo incluir un allure report
    // objetivo de un archivo .properties

}
