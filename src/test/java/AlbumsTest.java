import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.AlbumsService;
import spec.ResponseSpec;

public class AlbumsTest extends  BaseServiceTest{
    @Test
    public void getAlbumsRequest() {

        Response response = albumsService.AlbumGet(ResponseSpec.checkStatusCodeOk());
        Assertions.assertEquals("quidem molestiae enim", response.jsonPath().getString("title[0]"));
    }

}
