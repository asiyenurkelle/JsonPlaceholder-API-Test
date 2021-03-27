import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spec.ResponseSpec;

public class UsersTest extends BaseServiceTest{
    @Test
    public void getUsersRequest() {

        Response response = usersService.UsersGet(ResponseSpec.checkStatusCodeOk());
        Assertions.assertEquals("Leanne Graham", response.jsonPath().getString("name[0]"));
        Assertions.assertEquals("Bret", response.jsonPath().getString("username[0]"));
        Assertions.assertEquals("Sincere@april.biz", response.jsonPath().getString("email[0]"));
        Assertions.assertEquals("Kulas Light", response.jsonPath().getString("address[0].street"));
        Assertions.assertEquals("92998-3874", response.jsonPath().getString("address[0].zipcode"));
    }
}
