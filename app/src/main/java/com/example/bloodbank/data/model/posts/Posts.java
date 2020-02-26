
package com.example.bloodbank.data.model.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Posts {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("postsPagination")
    @Expose
    private PostsPagination postsPagination;

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

    public PostsPagination getPostsPagination() {
        return postsPagination;
    }

    public void setPostsPagination(PostsPagination postsPagination) {
        this.postsPagination = postsPagination;
    }

}
