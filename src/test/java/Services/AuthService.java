package Services;

import java.util.HashMap;
import java.util.Map;

public class AuthService extends BaseApiService{

    public static Map<String, Object> login() {
        Map<String, Object> loginBody = new HashMap<>();
        loginBody.put("username", System.getProperty("catchyLabUsername"));
        loginBody.put("password", System.getProperty("catchyLabPassword"));
        return makeHTTPRequest("POST", "loginEndpoint", null, loginBody);
    }

}
