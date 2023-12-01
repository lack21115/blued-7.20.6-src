package com.cmic.gen.sdk.tencent.c.d;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/d/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f21648a;
    private String b;

    private a(int i, String str) {
        this.f21648a = i;
        this.b = str;
    }

    public static a a(int i) {
        switch (i) {
            case 102102:
                return new a(102102, "网络异常");
            case 102223:
                return new a(102223, "数据解析异常");
            case 102508:
                return new a(102508, "数据网络切换失败");
            case 200025:
                return new a(200025, "登录超时");
            case 200039:
                return new a(200039, "电信取号接口失败");
            case 200050:
                return new a(200050, "EOF异常");
            default:
                return new a(i, "网络异常");
        }
    }

    public int a() {
        return this.f21648a;
    }

    public String b() {
        return this.b;
    }
}
