
package com.example.bloodbank.data.model.reset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reset {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("resetData")
    @Expose
    private ResetData resetData;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResetData getResetData() {
        return resetData;
    }

    public void setResetData(ResetData resetData) {
        this.resetData = resetData;
    }

}
