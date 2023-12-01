package com.alipay.sdk.app;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/k.class */
public enum k {
    SUCCEEDED(OpenAuthTask.OK, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    PARAMS_ERROR(4001, "参数错误"),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");
    
    private int h;
    private String i;

    k(int i, String str) {
        this.h = i;
        this.i = str;
    }

    public static k b(int i) {
        return i != 4001 ? i != 5000 ? i != 8000 ? i != 9000 ? i != 6001 ? i != 6002 ? FAILED : NETWORK_ERROR : CANCELED : SUCCEEDED : PAY_WAITTING : DOUBLE_REQUEST : PARAMS_ERROR;
    }

    public int a() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(String str) {
        this.i = str;
    }

    public String b() {
        return this.i;
    }
}
