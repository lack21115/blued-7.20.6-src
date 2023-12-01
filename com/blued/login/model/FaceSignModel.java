package com.blued.login.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/model/FaceSignModel.class */
public final class FaceSignModel {
    private String face_id = "";
    private String order_no = "";
    private String nonce = "";
    private String nonce_sign = "";
    private String api_version = "";
    private String app_id = "";
    private String license = "";

    public final String getApi_version() {
        return this.api_version;
    }

    public final String getApp_id() {
        return this.app_id;
    }

    public final String getFace_id() {
        return this.face_id;
    }

    public final String getLicense() {
        return this.license;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getNonce_sign() {
        return this.nonce_sign;
    }

    public final String getOrder_no() {
        return this.order_no;
    }

    public final void setApi_version(String str) {
        Intrinsics.e(str, "<set-?>");
        this.api_version = str;
    }

    public final void setApp_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.app_id = str;
    }

    public final void setFace_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.face_id = str;
    }

    public final void setLicense(String str) {
        Intrinsics.e(str, "<set-?>");
        this.license = str;
    }

    public final void setNonce(String str) {
        Intrinsics.e(str, "<set-?>");
        this.nonce = str;
    }

    public final void setNonce_sign(String str) {
        Intrinsics.e(str, "<set-?>");
        this.nonce_sign = str;
    }

    public final void setOrder_no(String str) {
        Intrinsics.e(str, "<set-?>");
        this.order_no = str;
    }
}
