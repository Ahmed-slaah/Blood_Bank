
package com.example.bloodbank.data.model.login;

import com.example.bloodbank.data.model.register.Client;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("api_token")
    @Expose
    private String apiToken;
    @SerializedName("client")
    @Expose
    private Client client;

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
