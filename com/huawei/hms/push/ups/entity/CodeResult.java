package com.huawei.hms.push.ups.entity;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/ups/entity/CodeResult.class */
public class CodeResult {

    /* renamed from: a  reason: collision with root package name */
    private int f9256a;
    private String b;

    public CodeResult() {
    }

    public CodeResult(int i) {
        this.f9256a = i;
    }

    public CodeResult(int i, String str) {
        this.f9256a = i;
        this.b = str;
    }

    public String getReason() {
        return this.b;
    }

    public int getReturnCode() {
        return this.f9256a;
    }

    public void setReason(String str) {
        this.b = str;
    }

    public void setReturnCode(int i) {
        this.f9256a = i;
    }
}
