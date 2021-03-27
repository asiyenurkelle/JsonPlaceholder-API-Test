package service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;

public class UsersService extends RequestSpec {
    public UsersService() {
        super("https://jsonplaceholder.typicode.com");
    }
    public Response UsersGet(ResponseSpecification responseSpecification){
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get("/users")
                .then()
                .spec(responseSpecification)
                .extract()
                .response();
    }
}
