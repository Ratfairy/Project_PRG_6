package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.ApiUtils;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Service.UserService;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.UserListVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.UserVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository
{
    private static final String TAG = "UserRepository";
    private static UserRepository INSTANCE;
    private UserService mUserService;

    private UserRepository(Context context) {
        mUserService = ApiUtils.getUserService();
    }

    public static void initialize(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository(context);
        }
    }

    public static UserRepository get() {
        return INSTANCE;
    }

    public MutableLiveData<UserVO> getDatalogin(String username, String password) {
        Log.d(TAG, "getDatalogin().called");
        MutableLiveData<UserVO> data = new MutableLiveData<>();
        Call<UserVO> call = mUserService.login(username, password);
        call.enqueue(new Callback<UserVO>() {
            @Override
            public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                if(response.isSuccessful() && response.body() != null){
                    data.setValue(response.body());
                    Log.d(TAG, "getUserLogin.onResponse() called");
                }else {
                    Log.e(TAG, "Terjadi kesalahan");
                }
            }

            @Override
            public void onFailure(Call<UserVO> call, Throwable throwable) {
                Log.e("Error API Call : ", throwable.getMessage());
            }
        });

        return data;
    }

    public MutableLiveData<UserVO> getUser(String username) {
        Log.d(TAG, "getUserByNim().called");
        MutableLiveData<UserVO> data = new MutableLiveData<>();
        Call<UserVO> call = mUserService.getUser(username);
        call.enqueue(new Callback<UserVO>() {
            @Override
            public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(TAG, "getUserByNim().onResponse");
                    data.setValue(response.body());
                } else {
                    Log.e(TAG, "Terjadi kesalahan");
                }
            }

            @Override
            public void onFailure(Call<UserVO> call, Throwable throwable) {
                Log.e(TAG, "Error API Call : " + throwable.getMessage());
            }
        });

        return data;
    }

    public MutableLiveData<UserListVO> getAllUser(String prodi) {
        MutableLiveData<UserListVO> data = new MutableLiveData<>();

        Call<UserListVO> call = mUserService.getAllUser(prodi);

        call.enqueue(new Callback<UserListVO>() {
            @Override
            public void onResponse(Call<UserListVO> call, Response<UserListVO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(TAG, "getAllUser().onResponse");
                    data.setValue(response.body());
                } else {
                    Log.e(TAG, "Mengambil data gagal");
                }
            }

            @Override
            public void onFailure(Call<UserListVO> call, Throwable throwable) {
                Log.e(TAG, "Error API Call : " + throwable.getMessage());
            }
        });
        return data;
    }

    public void saveUser(UserModel user, final messageCallback callback) {
        Log.i(TAG, "saveUser() called");
        Call<UserVO> call = mUserService.saveUser(user);
        call.enqueue(new Callback<UserVO>() {
            @Override
            public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(TAG, "saveUser().onResponse");
                    callback.onSuccess(response.body().getMessage());
                } else {
                    callback.onError("Menyimpan data gagal");
                }
            }

            @Override
            public void onFailure(Call<UserVO> call, Throwable throwable) {
                Log.e(TAG, "Error API Call : " + throwable.getMessage());
            }
        });
    }
    public interface messageCallback {
        void onSuccess(String message);

        void onError(String error);
    }
}
