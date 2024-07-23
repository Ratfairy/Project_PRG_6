package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.ApiUtils;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Service.LayananService;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.LayananListVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.LayananVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.LayananVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.LayananVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.LayananVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.LayananModel;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.SparepartModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayananRepository
{
    private static final String TAG = "LayananRepository";
    private static LayananRepository INSTANCE;
    private LayananService mLayananService;

    private LayananRepository (Context context){
        mLayananService = ApiUtils.getLayananService();
    }

    public static void initialize(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new LayananRepository(context);
        }
    }

    public static LayananRepository get(){
        return INSTANCE;
    }

    public MutableLiveData<LayananListVO> getAllLayanan() {
        Log.i(TAG, "getAllLayanan() called");
        MutableLiveData<LayananListVO> dataLayanan = new MutableLiveData<>();

        Call<LayananListVO> call = mLayananService.getLayanan();
        call.enqueue(new Callback<LayananListVO>() {
            @Override
            public void onResponse(Call<LayananListVO> call, Response<LayananListVO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    dataLayanan.setValue(response.body());
                    Log.d(TAG, "getAllLayanan.onResponse() called");
                    Log.d(TAG, response.body().getData().toString());
                } else {
                    // Logika untuk menangani kasus ketika response body null atau response tidak sukses
                    Log.e(TAG, "Response unsuccessful or body is null");
                }
            }

            @Override
            public void onFailure(Call<LayananListVO> call, Throwable throwable) {
                Log.e("Error API Call : ", throwable.getMessage());
            }
        });

        return dataLayanan;
    }

    public void saveLayanan(LayananModel layanan, final LayananRepository.messageCallback callback){
        Log.i(TAG, "saveLayanan() called");
        Call<LayananVO> call = mLayananService.saveLayanan(layanan);
        call.enqueue(new Callback<LayananVO>() {
            @Override
            public void onResponse(Call<LayananVO> call, Response<LayananVO> response) {
                Log.d(TAG, "saveLayanan.onResponse() called");
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getMessage());
                } else {
                    callback.onError("Save Sparepart Gagal");
                }
            }

            @Override
            public void onFailure(Call<LayananVO> call, Throwable throwable) {
                Log.e("Error API Call : ", throwable.getMessage());
            }
        });
    }

    public MutableLiveData<LayananVO> getLayananById(Integer idLayanan) {
        Log.i(TAG, "getLayananById() called");
        MutableLiveData<LayananVO> dataLogin = new MutableLiveData<>();

        Call<LayananVO> call = mLayananService.getLayananById(idLayanan);
        call.enqueue(new Callback<LayananVO>() {
            @Override
            public void onResponse(Call<LayananVO> call, Response<LayananVO> response) {
                if(response.isSuccessful() && response.body() != null){
                    dataLogin.setValue(response.body());
                    Log.d(TAG, "getUserLogin.onResponse() called");
                }else {
                    Log.e(TAG, "Terjadi kesalahan");
                }
            }

            @Override
            public void onFailure(Call<LayananVO> call, Throwable throwable) {
                Log.e("Error API Call : ", throwable.getMessage());
            }
        });

        return dataLogin;
    }

    public void updateLayanan(LayananModel updateLayanan, final LayananRepository.messageCallback callback){
        Log.i(TAG, "updateLayanan() called");
        Call<LayananVO> call = mLayananService.updateLayanan(updateLayanan);
        call.enqueue(new Callback<LayananVO>() {
            @Override
            public void onResponse(Call<LayananVO> call, Response<LayananVO> response) {
                Log.d(TAG, "updateLayanan.onResponse() called");
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getMessage());
                    Log.d(TAG, response.message());
                } else {
                    callback.onError("Update Alamat Gagal");
                }
            }

            @Override
            public void onFailure(Call<LayananVO> call, Throwable throwable) {
                Log.e("Error API Call : ", throwable.getMessage());
            }
        });
    }

    public void deletLayanan(Integer idLayanan, final LayananRepository.messageCallback callback){
        Log.i(TAG, "deletLayanan() called");
        Call<LayananVO> call = mLayananService.deleteLayanan(idLayanan);
        call.enqueue(new Callback<LayananVO>() {
            @Override
            public void onResponse(Call<LayananVO> call, Response<LayananVO> response) {
                Log.d(TAG, "deletLayanan.onResponse() called");
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getMessage());
                } else {
                    callback.onError("Registrasi Gagal");
                }
            }

            @Override
            public void onFailure(Call<LayananVO> call, Throwable throwable) {
                Log.e("Error API Call : ", throwable.getMessage());
            }
        });
    }

    public interface messageCallback {
        void onSuccess(String message);
        void onError(String error);
    }
}
