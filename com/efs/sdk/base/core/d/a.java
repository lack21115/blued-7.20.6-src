package com.efs.sdk.base.core.d;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/d/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f21762a;
    public byte b;

    /* renamed from: c  reason: collision with root package name */
    public int f21763c = 0;
    public String d = "none";
    public int e = 1;
    long f = 0;
    int g = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, byte b) {
        this.b = (byte) 2;
        this.f21762a = str;
        if (b <= 0 || 3 < b) {
            throw new IllegalArgumentException("log protocol flag invalid : ".concat(String.valueOf((int) b)));
        }
        this.b = b;
    }
}
