import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spec.ResponseSpec;

public class ToDosTest extends BaseServiceTest{
    @Test
    public void getPhotosRequest() {

        Response response = photosService.PhotosGet(ResponseSpec.checkStatusCodeOk());
        Assertions.assertEquals("accusamus beatae ad facilis cum similique qui sunt", response.jsonPath().getString("title[0]"));
    }
}
