package com.blued.android.module.common.web.modelloader.model;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/modelloader/model/ResponseModel.class */
public class ResponseModel {
    public int code;
    public String data;
    public String message;

    public ResponseModel(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public ResponseModel(int i, String str, String str2) {
        this.code = i;
        this.message = str;
        this.data = str2;
    }
}
