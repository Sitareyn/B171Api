package get_requests;

import baseUrl.ContactListBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get06 extends ContactListBaseUrl {
     /*
        Given
            https://thinking-tester-contact-list.herokuapp.com/contacts
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
     */

    @Test
    public void get06() {
        //Set the Url
        spec.pathParam("first","contacts");

        //Set theh expected data

        //Send the request and get the responce
        Response response=given(spec).when().get("{first}");
        response.prettyPrint();

        //Do Assertion
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);

    }
}
