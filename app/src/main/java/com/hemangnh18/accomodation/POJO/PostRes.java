package com.hemangnh18.accomodation.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostRes{

    @SerializedName("responce")
    @Expose
    private Responce responce;

    public Responce getResponce() {
        return responce;
    }

    public void setResponce(Responce responce) {
        this.responce = responce;
    }


    public class Responce {

        @SerializedName("value")
        @Expose
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
}