package service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;

public class ToDosService extends RequestSpec {
    public ToDosService() {
        super("https://jsonplaceholder.typicode.com");
    }
    public Response ToDosGet(ResponseSpecification responseSpecification){
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get("/todos")
                .then()
                .spec(responseSpecification)
                .extract()
                .response();
    }
}
