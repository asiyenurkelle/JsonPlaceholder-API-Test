package service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;

public class AlbumsService  extends RequestSpec {
    public AlbumsService() {
        super("https://jsonplaceholder.typicode.com");
    }
    public Response AlbumGet(ResponseSpecification responseSpecification){
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get("/albums")
                .then()
                .spec(responseSpecification)
                .extract()
                .response();
    }
}
