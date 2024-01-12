package com.example.sripepayment.dto;

import com.google.gson.annotations.SerializedName;

public class CreatePaymentItem {
    @SerializedName("id")
    String id;

    public String getId() {
        return id;
    }
}
