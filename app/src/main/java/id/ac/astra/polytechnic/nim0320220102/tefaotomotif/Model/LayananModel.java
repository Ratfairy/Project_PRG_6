package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LayananModel
{
    @SerializedName("idLayanan")
    @Expose
    private Integer IdLayanan;
    @SerializedName("nama")
    @Expose
    private String namaLayanan;
    @SerializedName("harga")
    @Expose
    private Integer hargaLayanan;
    @SerializedName("estimasi")
    @Expose
    private Integer estimasiLayanan;
    @SerializedName("status")
    @Expose
    private Integer statusLayanan;

    public LayananModel(Integer idLayanan, String namaLayanan, Integer hargaLayanan, Integer estimasiLayanan, Integer statusLayanan) {
        IdLayanan = idLayanan;
        this.namaLayanan = namaLayanan;
        this.hargaLayanan = hargaLayanan;
        this.estimasiLayanan = estimasiLayanan;
        this.statusLayanan = statusLayanan;
    }

    public LayananModel()
    {

    }

    public Integer getIdLayanan() {
        return IdLayanan;
    }

    public void setIdLayanan(Integer idLayanan) {
        IdLayanan = idLayanan;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }

    public Integer getHargaLayanan() {
        return hargaLayanan;
    }

    public void setHargaLayanan(Integer hargaLayanan) {
        this.hargaLayanan = hargaLayanan;
    }

    public Integer getEstimasiLayanan() {
        return estimasiLayanan;
    }

    public void setEstimasiLayanan(Integer estimasiLayanan) {
        this.estimasiLayanan = estimasiLayanan;
    }

    public Integer getStatusLayanan() {
        return statusLayanan;
    }

    public void setStatusLayanan(Integer statusLayanan) {
        this.statusLayanan = statusLayanan;
    }
}
