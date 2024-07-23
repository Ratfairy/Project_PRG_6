package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Service;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.LayananListVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.LayananVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.SparepartListVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.SparepartVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.LayananModel;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.SparepartModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LayananService
{
    @GET("layanan/getLayanan")
    Call<LayananListVO> getLayanan();

    @GET("layanan/getLayananById")
    Call<LayananVO> getLayananById(@Query("bja_id") Integer idLayanan);

    @POST("layanan/saveLayanan")
    Call<LayananVO> saveLayanan(@Body LayananModel layanan);

    @POST("layanan/updateLayanan")
    Call<LayananVO> updateLayanan(@Body LayananModel updatelayanan);

    @POST("layanan/deleteLayanan")
    Call<LayananVO> deleteLayanan(@Query("bja_id") Integer idLayanan);
}
