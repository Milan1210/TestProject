
package com.simphony_test.app.API.obj;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class RegUserRes {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("isInfluencer")
    @Expose
    private Boolean isInfluencer;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Boolean getIsInfluencer() {
        return isInfluencer;
    }

    public void setIsInfluencer(Boolean isInfluencer) {
        this.isInfluencer = isInfluencer;
    }

}