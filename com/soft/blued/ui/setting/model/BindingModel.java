package com.soft.blued.ui.setting.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/model/BindingModel.class */
public class BindingModel {
    @SerializedName("_")
    public String encrypted;
    public String safe_email;

    public String getEncrypted() {
        return this.encrypted;
    }

    public String getSafeEmail() {
        return this.safe_email;
    }

    public void setEncrypted(String str) {
        this.encrypted = str;
    }

    public void setSafeEmail(String str) {
        this.safe_email = str;
    }
}
