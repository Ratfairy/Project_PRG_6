package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.ApiUtils;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Service.SparepartService;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.SparepartListVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.SparepartVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.SparepartModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SparepartRepository
{
    private static final String TAG = "SparepartRepository";
    private static SparepartRepository INSTANCE;
    private SparepartService mSparepartService;

    private SparepartRepository (Context context){
        mSparepartService = ApiUtils.getSparepartService();
    }

    public static void initialize(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SparepartRepository(context);
        }
    }

    public static SparepartRepository get(){
        return INSTANCE;
    }

    public MutableLiveData<SparepartListVO> getAllSparepart() {
        Log.i(TAG, "getAllSparepart() called");
        MutableLiveData<SparepartListVO> dataLayanan = new MutableLiveData<>();

        Call<SparepartListVO> call = mSparepartService.getAllSparepart();
        call.enqueue(new Callback<SparepartListVO>() {
            @Override
            public void onResponse(Call<SparepartListVO> call, Response<SparepartListVO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    dataLayanan.setValue(response.body());
                    Log.d(TAG, "getAllSparepart.onResponse() called");
                    Log.d(TAG, response.body().getData().toString());
                } else {
                    // Logika untuk menangani kasus ketika response body null atau response tidak sukses
                    Log.e(TAG, "Response unsuccessful or body is null");
                }
            }

            @Override
            public void onFailure(Call<SparepartListVO> call, Throwable throwable) {
                Log.e("Error API Call : ", throwable.getMessage());
            }
        });

        return dataLayanan;
    }

    public MutableLiveData<SparepartVO> getSparepartById(Integer idSparepart) {
        Log.i(TAG, "getSparepartById() called");
        MutableLiveData<SparepartVO> dataLogin = new MutableLiveData<>();

        Call<SparepartVO> call = mSparepartService.getSparepartById(idSparepart);
        call.enqueue(new Callback<SparepartVO>() {
            @Override
            public void onResponse(Call<SparepartVO> call, Response<SparepartVO> response) {
                if(response.isSuccessful() && response.body() != null){
                    dataLogin.setValue(response.body());
                    Log.d(TAG, "getSparepartById.onResponse() called");
                }else {
                    Log.e(TAG, "Terjadi kesalahan");
                }
            }

            @Override
            public void onFailure(Call<SparepartVO> call, Throwable throwable) {
                Log.e("Error API Call : ", throwable.getMessage());
            }
        });

        return dataLogin;
    }

    public void saveSparepart(SparepartModel sparepart, final messageCallback callback){
        Log.i(TAG, "saveSparepart() called");
        Call<SparepartVO> call = mSparepartService.saveSparepart(sparepart);
        call.enqueue(new Callback<SparepartVO>() {
            @Override
            public void onResponse(Call<SparepartVO> call, Response<SparepartVO> response) {
                Log.d(TAG, "saveSparepart.onResponse() called");
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getMessage());
                } else {
                    callback.onError("Save Sparepart Gagal");
                }
            }

            @Override
            public void onFailure(Call<SparepartVO> call, Throwable throwable) {
                Log.e("Error API Call : ", throwable.getMessage());
            }
        });
    }

    public void updateSparepart(SparepartModel updateSparepart, final messageCallback callback){
        Log.i(TAG, "updateSparepart() called");
        Call<SparepartVO> call = mSparepartService.updateSparepart(updateSparepart);
        call.enqueue(new Callback<SparepartVO>() {
            @Override
            public void onResponse(Call<SparepartVO> call, Response<SparepartVO> response) {
                Log.d(TAG, "updateSparepart.onResponse() called");
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getMessage());
                    Log.d(TAG, response.message());
                } else {
                    callback.onError("Update Alamat Gagal");
                }
            }

            @Override
            public void onFailure(Call<SparepartVO> call, Throwable throwable) {
                Log.e("Error API Call : ", throwable.getMessage());
            }
        });
    }

    public void deleteSparepart(Integer IdSparepart, final messageCallback callback){
        Log.i(TAG, "deleteAlamat() called");
        Call<SparepartVO> call = mSparepartService.deleteSparepart(IdSparepart);
        call.enqueue(new Callback<SparepartVO>() {
            @Override
            public void onResponse(Call<SparepartVO> call, Response<SparepartVO> response) {
                Log.d(TAG, "deleteAlamat.onResponse() called");
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getMessage());
                } else {
                    callback.onError("Registrasi Gagal");
                }
            }

            @Override
            public void onFailure(Call<SparepartVO> call, Throwable throwable) {
                Log.e("Error API Call : ", throwable.getMessage());
            }
        });
    }
    public interface messageCallback {
        void onSuccess(String message);
        void onError(String error);
    }



}
