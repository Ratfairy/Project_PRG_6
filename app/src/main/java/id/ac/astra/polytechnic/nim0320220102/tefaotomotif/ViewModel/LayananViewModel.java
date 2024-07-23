package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Repository.LayananRepository;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.LayananListVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.LayananVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.LayananModel;


public class LayananViewModel extends ViewModel
{
    private static final String TAG = "LayananViewModel";

    private MutableLiveData<LayananListVO> getAllLayananResponse = new MutableLiveData<>();
    private MutableLiveData<LayananVO> getLayananResponse = new MutableLiveData<>();
    private MutableLiveData<String> successMessage = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    private final LayananRepository mLayananRepository;

    public LayananViewModel (){
        mLayananRepository = LayananRepository.get();
    }

    public LiveData<LayananListVO> getAllLayananResponse(){
        return getAllLayananResponse;
    }

    public LiveData<LayananVO> getLayananResponse(){
        return getLayananResponse;
    }

    public LiveData<String> getSuccessResponse(){
        return successMessage;
    }

    public LiveData<String> getErrorResponse(){
        return errorMessage;
    }

    public void getAllLayanan(){
        Log.i(TAG, "getAllLayanan() called");
        getAllLayananResponse = mLayananRepository.getAllLayanan();
    }

    public void getLayananById(Integer idLayanan){
        Log.i(TAG, "getLayananById() called");
        getLayananResponse = mLayananRepository.getLayananById(idLayanan);
    }

    public void saveLayanan(LayananModel layanan){
        Log.i(TAG, "saveLayanan() called");
        mLayananRepository.saveLayanan(layanan, new LayananRepository.messageCallback()
        {
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

    public void updateLayanan(LayananModel updateLayanan){
        Log.i(TAG, "updateLayanan() called");
        mLayananRepository.updateLayanan(updateLayanan, new LayananRepository.messageCallback(){
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

    public void deleteLayanan(Integer idLayanan){
        Log.i(TAG, "deleteLayanan() called");
        mLayananRepository.deletLayanan(idLayanan, new LayananRepository.messageCallback()
        {
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
