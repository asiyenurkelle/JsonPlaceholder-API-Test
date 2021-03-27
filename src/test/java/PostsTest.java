import io.restassured.response.Response;
import model.GetResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spec.ResponseSpec;


public class PostsTest extends BaseServiceTest {

    @Test
    public void getPostRequest() {

        Response response = postService.PostGet(ResponseSpec.checkStatusCodeOk());
        Assertions.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
    }
    @Test
    public void putPostRequest() {
        Response response = postService.PostPut(ResponseSpec.checkStatusCodeOk());
        GetResponse as= response.as(GetResponse.class);
        Assertions.assertEquals("foo",as.getTitle());
        Assertions.assertEquals("baz", as.getBody());
        Assertions.assertEquals("1", as.getUserId());
        Assertions.assertEquals("1", as.getId());
    }
    @Test
    public void postPostRequest() {
        Response response = postService.PostPost(ResponseSpec.checkStatusCodeCreated());
        GetResponse as= response.as(GetResponse.class);
        Assertions.assertEquals("foo", as.getTitle());
        Assertions.assertEquals("bar", as.getBody());
        Assertions.assertEquals("1", as.getUserId());
        Assertions.assertEquals("101",as.getId());
    }
    @Test
    public void deletePostRequest() {
        Response response = postService.PostDelete(ResponseSpec.checkStatusCodeOk());
    }

    @Test
    public void getCommentsRequest() {

        Response response = commentService.CommentGet(ResponseSpec.checkStatusCodeOk());
        Assertions.assertEquals("quo vero reiciendis velit similique earum", response.jsonPath().getString("name[1]"));
        Assertions.assertEquals("Jayne_Kuhic@sydney.com", response.jsonPath().getString("email[1]"));
    }

    @Test
    public void deleteCommentRequest() {
        Response response = commentService.CommentDelete(ResponseSpec.checkStatusCodeOk());
    }

}