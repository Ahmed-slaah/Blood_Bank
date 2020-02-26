
package com.example.bloodbank.data.model.donationRequests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DonationRequests {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("donationRequestPagination")
    @Expose
    private DonationRequestPagination donationRequestPagination;

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

    public DonationRequestPagination getDonationRequestPagination() {
        return donationRequestPagination;
    }

    public void setDonationRequestPagination(DonationRequestPagination donationRequestPagination) {
        this.donationRequestPagination = donationRequestPagination;
    }

}
