import io.restassured.response.Response;
import model.GetResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spec.ResponseSpec;


public class JsonPlaceHolderAPI extends BaseServiceTest {

    @Test
    public void getRequest() {

        Response response = postService.PostGet(ResponseSpec.checkStatusCodeOk());
        Assertions.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
    }
    @Test
    public void putRequest() {
        Response response = postService.PostPut(ResponseSpec.checkStatusCodeOk());
        GetResponse as= response.as(GetResponse.class);
        Assertions.assertEquals("foo",as.getTitle());
        Assertions.assertEquals("baz", as.getBody());
        Assertions.assertEquals("1", as.getUserId());
        Assertions.assertEquals("1", as.getId());
    }
    @Test
    public void postRequest() {
        Response response = postService.PostPost(ResponseSpec.checkStatusCodeCreated());
        GetResponse as= response.as(GetResponse.class);
        Assertions.assertEquals("foo", as.getTitle());
        Assertions.assertEquals("bar", as.getBody());
        Assertions.assertEquals("1", as.getUserId());
        Assertions.assertEquals("101",as.getId());
    }
    @Test
    public void deleteRequest() {
        Response response = postService.PostDelete(ResponseSpec.checkStatusCodeOk());

    }


}