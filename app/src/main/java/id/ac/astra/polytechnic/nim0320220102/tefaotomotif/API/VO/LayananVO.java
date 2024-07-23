package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.LayananModel;

public class LayananVO
{
    private int status;

    private LayananModel data;

    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LayananModel getData() {
        return data;
    }

    public void setData(LayananModel data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
