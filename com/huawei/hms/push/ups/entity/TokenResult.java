package com.huawei.hms.push.ups.entity;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/ups/entity/TokenResult.class */
public class TokenResult extends CodeResult {

    /* renamed from: c  reason: collision with root package name */
    private String f22865c;

    public TokenResult() {
    }

    public TokenResult(int i) {
        super(i);
    }

    public TokenResult(int i, String str) {
        super(i, str);
    }

    public TokenResult(String str) {
        this.f22865c = str;
    }

    public String getToken() {
        return this.f22865c;
    }

    public void setToken(String str) {
        this.f22865c = str;
    }
}
