package Services;

import java.util.HashMap;
import java.util.Map;

public class AccountService extends BaseApiService{

    public AccountService() {
        super();
    }

    public static Map<String, Object> getAccountInformation() {
        String token = AuthService.login().get("access_token").toString();
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Authorization", "Bearer " + token);
        return makeHTTPRequest("GET", "accountsEndpoint", headers, null);
    }


}
