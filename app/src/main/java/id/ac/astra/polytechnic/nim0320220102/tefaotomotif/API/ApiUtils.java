package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Service.LayananService;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Service.SparepartService;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Service.UserService;

public class ApiUtils
{
    public static final String API_BASE_URL = "http://192.168.223.196:8080/";

    public ApiUtils() {
    }

    public static UserService getUserService(){
        return RetrofitClient.getClient(API_BASE_URL).create(UserService.class);
    }

    public static SparepartService getSparepartService(){
        return RetrofitClient.getClient(API_BASE_URL).create(SparepartService.class);
    }
    public static LayananService getLayananService(){
        return RetrofitClient.getClient(API_BASE_URL).create(LayananService.class);
    }
}
