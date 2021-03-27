package service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;

public class CommentService  extends RequestSpec {

    public CommentService() {
        super("https://jsonplaceholder.typicode.com");
    }
    public static String requestBody = "{\n" +
            "  \"name\": \"foo\",\n" +
            "  \"body\": \"baz\",\n" +
            "  \"postId\": \"1\",\n" +
            "  \"id\": \"1\" \n" +
            " \"email\": \"asiye@deneme.com\",\n}";
    private static String requestBodyComments =  "{\n" +
            "  \"name\": \"foo\",\n" +
            "  \"body\": \"bar\",\n" +
            "  \"postId\": \"1\" \n}"+
            " \"email\": \"asiye@deneme.com\" \n}";


    public Response CommentGet(ResponseSpecification responseSpecification){
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get("/comments")
                .then()
                .spec(responseSpecification)
                .extract()
                .response();
    }
    public Response CommentPut(ResponseSpecification responseSpecification){
        return  RestAssured.given()
                .spec(super.getRequestSpecification())
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put("/comments/1")
                .then()
                .extract()
                .response();
    }
    public Response CommentPost(ResponseSpecification responseSpecification){
        return  RestAssured.given()
                .spec(super.getRequestSpecification())
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyComments)
                .when()
                .post("/comments")
                .then()
                .extract()
                .response();
    }

    public Response CommentDelete(ResponseSpecification responseSpecification){
        return  RestAssured.given()
                .spec(super.getRequestSpecification())
                .header("Content-type", "application/json")
                .when()
                .delete("/comments/1")
                .then()
                .extract()
                .response();
    }
}
