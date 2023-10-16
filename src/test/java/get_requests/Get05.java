package get_requests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class Get05 extends PetStoreBaseUrl {
        /*
        Given
            https://petstore.swagger.io/v2/pet/findByStatus?status=available
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            Listede id değeri 9898 olan bir eleman olmalı
        And
            Listede name değeri "Pamuk" olan bir eleman olmalı
        And
            Listede name değerleri "Pamuk", "doggie", "fish" olan elemanlar olmalı
        And
            Listede en az 200 tane eleman olmalı
        And
            Listede 500'den az eleman olmalı
        And
            Listenin ilk elemanın category - id değeri 0 olmalı
        And
            Listenin ilk elemanın photoUrls değeri "string" olmalı
        And
            Listenin ilk elemanın tag - id değeri 0 olmalı
*/

    @Test
    public void get05() {
        spec.pathParams("first","pet","second","findByStatus")
                .queryParam("status","available");

        //Set the expected data

        //Send the request and get the responce
        Response response=given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
       response
               .then()
               .statusCode(200)
               .contentType(ContentType.JSON)
               .body("id", hasItem(9898))
               .body("name", hasItem("Pamuk"))
               .body("name", hasItems("Pamuk", "doggie", "fish"))
               .body("id", hasSize(greaterThan(200)))
               .body("id", hasSize(lessThan(500)))
               .body("[0].category.id", equalTo(0))
               .body("[0].photoUrls[0]", equalTo("string"))
               .body("[0].tags[0].id", equalTo(0));







    }


}
