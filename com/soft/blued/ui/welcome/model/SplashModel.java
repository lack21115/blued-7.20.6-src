package com.soft.blued.ui.welcome.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/model/SplashModel.class */
public final class SplashModel {
    private int code;
    private boolean isSuccess;
    private String msg;
    private SplashEntity splashEntity;

    public SplashModel(boolean z, int i, String msg) {
        Intrinsics.e(msg, "msg");
        this.msg = "";
        this.isSuccess = z;
        this.code = i;
        this.msg = msg;
    }

    public SplashModel(boolean z, SplashEntity splashEntity) {
        this.msg = "";
        this.isSuccess = z;
        this.splashEntity = splashEntity;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final SplashEntity getSplashEntity() {
        return this.splashEntity;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setMsg(String str) {
        Intrinsics.e(str, "<set-?>");
        this.msg = str;
    }

    public final void setSplashEntity(SplashEntity splashEntity) {
        this.splashEntity = splashEntity;
    }

    public final void setSuccess(boolean z) {
        this.isSuccess = z;
    }
}
