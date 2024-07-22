package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.ViewModel;

import android.util.Log;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Repository.UserRepository;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.UserListVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.UserVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.UserModel;

public class UserViewModel extends ViewModel
{
    private static final String TAG = "UserViewModel";

    private MutableLiveData<UserListVO> getAllUserResponse = new MutableLiveData<>();
    private MutableLiveData<UserVO> getResponse = new MutableLiveData<>();
    private MutableLiveData<String> successMessage = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    private final UserRepository mUserRepository;

    public UserViewModel (){
        mUserRepository = UserRepository.get();
    }

    public LiveData<UserListVO> getAllUserResponse(){
        return getAllUserResponse;
    }

    public LiveData<UserVO> getLoginResponse(){
        return getResponse;
    }
    public LiveData<UserVO> getUserResponse(){
        return getResponse;
    }

    public LiveData<String> getSuccessMessage() {
        return successMessage;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void getAllUser(String role){
        Log.i(TAG, "getAllUser() called");
        getAllUserResponse = mUserRepository.getAllUser(role);
    }

    public void getUserLogin(String username, String password){
        Log.i(TAG, "getUserLogin() called");
        getResponse = mUserRepository.getDatalogin(username, password);
    }


    public void saveUser(UserModel user){
        Log.i(TAG, "saveUser() called");
        mUserRepository.saveUser(user, new UserRepository.messageCallback() {
            @Override
            public void onSuccess(String message) {
                successMessage.postValue(message);
            }

            @Override
            public void onError(String error) {
                errorMessage.postValue(error);
            }
        });
    }
}
