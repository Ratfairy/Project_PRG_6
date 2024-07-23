package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Repository.SparepartRepository;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.SparepartListVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.SparepartVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.SparepartModel;

public class SparepartViewModel extends ViewModel
{
    private static final String TAG = "SparepartViewModel";

    private MutableLiveData<SparepartListVO> getAllSparepartResponse = new MutableLiveData<>();
    private MutableLiveData<SparepartVO> getSparepartResponse = new MutableLiveData<>();
    private MutableLiveData<String> successMessage = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    private final SparepartRepository mSparepartRepository;

    public SparepartViewModel (){
        mSparepartRepository = SparepartRepository.get();
    }

    public LiveData<SparepartListVO> getAllSparepartResponse(){
        return getAllSparepartResponse;
    }

    public LiveData<SparepartVO> getSparepartResponse(){
        return getSparepartResponse;
    }

    public LiveData<String> getSuccessResponse(){
        return successMessage;
    }

    public LiveData<String> getErrorResponse(){
        return errorMessage;
    }

    public void getAllSparepart(){
    Log.i(TAG, "getAllSparepart() called");
    getAllSparepartResponse = mSparepartRepository.getAllSparepart();
    }

    public void getSparepartById(Integer idSparepart){
        Log.i(TAG, "getSparepartById() called");
        getSparepartResponse = mSparepartRepository.getSparepartById(idSparepart);
    }

    public void saveSparepart(SparepartModel sparepart){
        Log.i(TAG, "saveSparepart() called");
        mSparepartRepository.saveSparepart(sparepart, new SparepartRepository.messageCallback()
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

    public void updateSpare(SparepartModel updateSparepart){
        Log.i(TAG, "updateSpare() called");
        mSparepartRepository.updateSparepart(updateSparepart, new SparepartRepository.messageCallback(){
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

    public void deleteSparepart(Integer idSparepart){
        Log.i(TAG, "deleteAlamat() called");
        mSparepartRepository.deleteSparepart(idSparepart, new SparepartRepository.messageCallback()
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
