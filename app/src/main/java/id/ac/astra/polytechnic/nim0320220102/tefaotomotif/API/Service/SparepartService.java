package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.Service;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.SparepartListVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.SparepartVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.UserListVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO.UserVO;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.SparepartModel;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SparepartService
{
    @GET("sparepart/getAllSparepart")
    Call<SparepartListVO> getAllSparepart();

    @GET("sparepart/getSparepartById")
    Call<SparepartVO> getSparepartById(@Query("IdSparepart") Integer idSparepart);

    @POST("sparepart/saveSparepart")
    Call<SparepartVO> saveSparepart(@Body SparepartModel sparepart);

    @POST("sparepart/updateSparepart")
    Call<SparepartVO> updateSparepart(@Body SparepartModel Updatesparepart);

    @POST("sparepart/deleteSparepart")
    Call<SparepartVO> deleteSparepart(@Query("IdSparepart") Integer idSparepart);


}
