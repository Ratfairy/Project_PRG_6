package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.UserModel;

public class UserVO
{
    private int status;

    private UserModel data;

    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserModel getData() {
        return data;
    }

    public void setData(UserModel data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
