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


    public static Map<String, Object> getAccountTransactions() {
        String token = AuthService.login().get("access_token").toString();
        String banckAccountId = getAccountInformation().get("bank_account_id").toString();
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Authorization", "Bearer " + token);
        String requestURL = System.getProperty("apiBaseURL") + System.getProperty("transactionsEndpoint") + banckAccountId + "/transactions?clientId=web";
        System.out.println(requestURL);
        return makeHTTPRequest("GET", requestURL, headers, null);
    }


}
