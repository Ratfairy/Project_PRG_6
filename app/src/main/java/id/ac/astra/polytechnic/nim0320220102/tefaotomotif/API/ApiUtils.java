package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Service.UserService;

public class ApiUtils
{
    public static final String API_BASE_URL = "http://10.1.11.121:8080/";

    public ApiUtils() {
    }

    public static UserService getUserService(){
        return RetrofitClient.getClient(API_BASE_URL).create(UserService.class);
    }
}
