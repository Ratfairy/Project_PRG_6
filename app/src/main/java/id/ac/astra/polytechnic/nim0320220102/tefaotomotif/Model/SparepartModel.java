package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SparepartModel
{
    @SerializedName("IdSparepart")
    @Expose
    private Integer idSparepart;
    @SerializedName("namaSparepart")
    @Expose
    private String namaSparepart;
    @SerializedName("hargaSparepart")
    @Expose
    private Integer hargaSparepart;
    @SerializedName("satuanSparepart")
    @Expose
    private Integer satuanSparepart;
    @SerializedName("merkSparepart")
    @Expose
    private String merkSparepart;
    @SerializedName("deskripsiSparepart")
    @Expose
    private String deskripsiSparepart;
    @SerializedName("statusSparepart")
    @Expose
    private String statusSparepart;

    public SparepartModel()
    {

    }

    public SparepartModel(Integer idSparepart, String namaSparepart, Integer hargaSparepart, Integer satuanSparepart, String merkSparepart, String deskripsiSparepart, String statusSparepart) {
        this.idSparepart = idSparepart;
        this.namaSparepart = namaSparepart;
        this.hargaSparepart = hargaSparepart;
        this.satuanSparepart = satuanSparepart;
        this.merkSparepart = merkSparepart;
        this.deskripsiSparepart = deskripsiSparepart;
        this.statusSparepart = statusSparepart;
    }

    public Integer getIdSparepart() {
        return idSparepart;
    }

    public void setIdSparepart(Integer idSparepart) {
        this.idSparepart = idSparepart;
    }

    public String getNamaSparepart() {
        return namaSparepart;
    }

    public void setNamaSparepart(String namaSparepart) {
        this.namaSparepart = namaSparepart;
    }

    public Integer getHargaSparepart() {
        return hargaSparepart;
    }

    public void setHargaSparepart(Integer hargaSparepart) {
        this.hargaSparepart = hargaSparepart;
    }

    public Integer getSatuanSparepart() {
        return satuanSparepart;
    }

    public void setSatuanSparepart(Integer satuanSparepart) {
        this.satuanSparepart = satuanSparepart;
    }

    public String getMerkSparepart() {
        return merkSparepart;
    }

    public void setMerkSparepart(String merkSparepart) {
        this.merkSparepart = merkSparepart;
    }

    public String getDeskripsiSparepart() {
        return deskripsiSparepart;
    }

    public void setDeskripsiSparepart(String deskripsiSparepart) {
        this.deskripsiSparepart = deskripsiSparepart;
    }

    public String getStatusSparepart() {
        return statusSparepart;
    }

    public void setStatusSparepart(String statusSparepart) {
        this.statusSparepart = statusSparepart;
    }
}
