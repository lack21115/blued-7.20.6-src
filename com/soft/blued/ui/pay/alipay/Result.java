package com.soft.blued.ui.pay.alipay;

import com.huawei.openalliance.ad.constant.t;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/alipay/Result.class */
public class Result {

    /* renamed from: a  reason: collision with root package name */
    public String f19304a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f19305c;

    public Result(String str) {
        try {
            String[] split = str.split(t.aE);
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                String str2 = split[i2];
                if (str2.startsWith("resultStatus")) {
                    this.f19304a = a(str2, "resultStatus");
                }
                if (str2.startsWith("result")) {
                    this.b = a(str2, "result");
                }
                if (str2.startsWith("memo")) {
                    this.f19305c = a(str2, "memo");
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    public String a() {
        return this.f19304a;
    }

    public String toString() {
        return "resultStatus={" + this.f19304a + "};memo={" + this.f19305c + "};result={" + this.b + "}";
    }
}
