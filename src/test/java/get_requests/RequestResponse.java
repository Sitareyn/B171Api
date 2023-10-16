package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    public static void main(String[] args) {
        String url ="https://petstore.swagger.io/v2/pet/9898";

       Response response= given().when().get(url);
       response.prettyPrint();

       // Statüs code nasil yazdirilir
        System.out.println("Status Code"+response.statusCode());

      // Content Type nasil yazdirilir?
        System.out.println("Content Type"+response.contentType());

      // Status Line nasil yazdirilir
        System.out.println("Status Line"+response.statusLine());

     // Header boluumunden bir baslik nasil yazdirilir
        System.out.println("Header | Server"+response.header("Server"));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
    //Header bolumundeki tüm basliklar nasil yazdirilir
        System.out.println("Headers"+response.headers());

    //Time bilgisi nasil yazdirilir
        System.out.println("Time"+response.time());

    }
}

