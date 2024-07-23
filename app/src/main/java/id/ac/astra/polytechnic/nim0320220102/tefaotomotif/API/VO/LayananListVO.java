package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API.VO;

import java.util.List;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Model.LayananModel;

public class LayananListVO
{
    private int status;

    private List<LayananModel> data;

    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<LayananModel> getData() {
        return data;
    }

    public void setData(List<LayananModel> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
