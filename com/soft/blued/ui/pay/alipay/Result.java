package com.soft.blued.ui.pay.alipay;

import com.alipay.sdk.util.i;
import com.alipay.sdk.util.l;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/alipay/Result.class */
public class Result {

    /* renamed from: a  reason: collision with root package name */
    public String f32995a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f32996c;

    public Result(String str) {
        try {
            String[] split = str.split(";");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                String str2 = split[i2];
                if (str2.startsWith(l.f4671a)) {
                    this.f32995a = a(str2, l.f4671a);
                }
                if (str2.startsWith("result")) {
                    this.b = a(str2, "result");
                }
                if (str2.startsWith(l.b)) {
                    this.f32996c = a(str2, l.b);
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(i.d));
    }

    public String a() {
        return this.f32995a;
    }

    public String toString() {
        return "resultStatus={" + this.f32995a + "};memo={" + this.f32996c + "};result={" + this.b + i.d;
    }
}
