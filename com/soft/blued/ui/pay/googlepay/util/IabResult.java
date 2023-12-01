package com.soft.blued.ui.pay.googlepay.util;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabResult.class */
public class IabResult {

    /* renamed from: a  reason: collision with root package name */
    int f33010a;
    String b;

    public IabResult(int i, String str) {
        this.f33010a = i;
        if (str == null || str.trim().length() == 0) {
            this.b = IabHelper.a(i);
            return;
        }
        this.b = str + " (response: " + IabHelper.a(i) + ")";
    }

    public String a() {
        return this.b;
    }

    public String toString() {
        return "IabResult: " + a();
    }
}
