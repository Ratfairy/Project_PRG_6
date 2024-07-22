package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO;

import java.util.List;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.UserModel;

public class UserListVO
{
    private int status;

    private List<UserModel> data;

    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<UserModel> getData() {
        return data;
    }

    public void setData(List<UserModel> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
