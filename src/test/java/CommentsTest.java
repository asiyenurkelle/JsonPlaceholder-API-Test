import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spec.ResponseSpec;

public class CommentsTest extends BaseServiceTest{

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
