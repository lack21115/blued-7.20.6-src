package com.soft.blued.utils.third.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/model/TXOneLoginResult.class */
public final class TXOneLoginResult {
    private String innerCode = "";
    private String innerDesc = "";
    private String message = "";
    private String number = "";
    private String telecom = "";
    private String protocolName = "";
    private String protocolUrl = "";
    private String token = "";

    public final String getInnerCode() {
        return this.innerCode;
    }

    public final String getInnerDesc() {
        return this.innerDesc;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String getProtocolName() {
        return this.protocolName;
    }

    public final String getProtocolUrl() {
        return this.protocolUrl;
    }

    public final String getTelecom() {
        return this.telecom;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setInnerCode(String str) {
        Intrinsics.e(str, "<set-?>");
        this.innerCode = str;
    }

    public final void setInnerDesc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.innerDesc = str;
    }

    public final void setMessage(String str) {
        Intrinsics.e(str, "<set-?>");
        this.message = str;
    }

    public final void setNumber(String str) {
        Intrinsics.e(str, "<set-?>");
        this.number = str;
    }

    public final void setProtocolName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.protocolName = str;
    }

    public final void setProtocolUrl(String str) {
        Intrinsics.e(str, "<set-?>");
        this.protocolUrl = str;
    }

    public final void setTelecom(String str) {
        Intrinsics.e(str, "<set-?>");
        this.telecom = str;
    }

    public final void setToken(String str) {
        Intrinsics.e(str, "<set-?>");
        this.token = str;
    }

    public String toString() {
        return "TXOneLoginResult(innerCode='" + this.innerCode + "', innerDesc='" + this.innerDesc + "', message='" + this.message + "', number='" + this.number + "', telecom='" + this.telecom + "', protocolName='" + this.protocolName + "', protocolUrl='" + this.protocolUrl + "', token='" + this.token + "')";
    }
}
