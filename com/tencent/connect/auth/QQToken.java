package com.tencent.connect.auth;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/auth/QQToken.class */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f22477a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f22478c;
    private int d = 1;
    private long e = -1;

    public QQToken(String str) {
        this.f22477a = str;
    }

    public String getAccessToken() {
        return this.b;
    }

    public String getAppId() {
        return this.f22477a;
    }

    public int getAuthSource() {
        return this.d;
    }

    public long getExpireTimeInSecond() {
        return this.e;
    }

    public String getOpenId() {
        return this.f22478c;
    }

    public boolean isSessionValid() {
        return this.b != null && System.currentTimeMillis() < this.e;
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.b = str;
        this.e = 0L;
        if (str2 != null) {
            this.e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.f22477a = str;
    }

    public void setAuthSource(int i) {
        this.d = i;
    }

    public void setOpenId(String str) {
        this.f22478c = str;
    }
}
