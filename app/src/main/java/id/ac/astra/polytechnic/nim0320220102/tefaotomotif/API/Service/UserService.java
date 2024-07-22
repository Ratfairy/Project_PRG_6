package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Service;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.UserListVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.UserVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService
{
    @GET("user/login")
    Call<UserVO> login (@Query("username") String username, @Query("password") String password);

    @GET("user/getUser")
    Call<UserVO> getUser (@Query("username") String username);

    @GET("user/getUsers")
    Call<UserListVO> getAllUser(@Query("role") String role);

    @POST("user/addUser")
    Call<UserVO> saveUser(@Body UserModel user);
}
