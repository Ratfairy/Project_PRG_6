package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserModel implements Serializable
{
    @SerializedName("id")
    @Expose
    private Integer idUser;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("noHp")
    @Expose
    private String noHp;
    @SerializedName("status")
    @Expose
    private String status;

    public UserModel(Integer idUser, String nama, String role, String noHp, String status) {
        this.idUser = idUser;
        this.nama = nama;
        this.role = role;
        this.noHp = noHp;
        this.status = status;
    }

    public UserModel() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
