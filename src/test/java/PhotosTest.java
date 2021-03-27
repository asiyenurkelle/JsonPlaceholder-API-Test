import io.restassured.response.Response;
import org.jsoup.Connection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spec.ResponseSpec;

public class PhotosTest extends BaseServiceTest {
    @Test
    public void getPhotosRequest() {

        Response response = photosService.PhotosGet(ResponseSpec.checkStatusCodeOk());
        Assertions.assertEquals("accusamus beatae ad facilis cum similique qui sunt", response.jsonPath().getString("title[0]"));
    }
}
