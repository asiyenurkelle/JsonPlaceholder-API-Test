package service;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;


public class PostService extends RequestSpec {
    public PostService() {
        super("https://jsonplaceholder.typicode.com");
    }
    public static String requestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"baz\",\n" +
            "  \"userId\": \"1\",\n" +
            "  \"id\": \"1\" \n}";

    private static String requestBodyPost =  "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"bar\",\n" +
            "  \"userId\": \"1\" \n}";


    public Response PostGet(ResponseSpecification responseSpecification){
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .spec(responseSpecification)
                .extract()
                .response();
    }
    public Response PostPut(ResponseSpecification responseSpecification){
        return  RestAssured.given()
                .spec(super.getRequestSpecification())
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put("/posts/1")
                .then()
                .extract()
                .response();
    }
    public Response PostPost(ResponseSpecification responseSpecification){
        return  RestAssured.given()
                .spec(super.getRequestSpecification())
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPost)
                .when()
                .post("/posts")
                .then()
                .extract()
                .response();
    }
    public Response PostDelete(ResponseSpecification responseSpecification){
        return  RestAssured.given()
                .spec(super.getRequestSpecification())
                .header("Content-type", "application/json")
                .when()
                .delete("/posts/1")
                .then()
                .extract()
                .response();
    }


}
