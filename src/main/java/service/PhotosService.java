package service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spec.RequestSpec;
import spec.ResponseSpec;

public class PhotosService extends RequestSpec {

    public PhotosService() {
        super("https://jsonplaceholder.typicode.com");
    }

    public Response PhotosGet(ResponseSpecification responseSpecification){
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get("/photos")
                .then()
                .spec(responseSpecification)
                .extract()
                .response();
    }
}
