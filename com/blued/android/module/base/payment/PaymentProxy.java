package com.blued.android.module.base.payment;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/payment/PaymentProxy.class */
public class PaymentProxy implements IPayment {
    private static PaymentProxy a = new PaymentProxy();
    private IPayment b = null;

    private PaymentProxy() {
    }

    public static PaymentProxy a() {
        return a;
    }

    public void a(IPayment iPayment) {
        this.b = iPayment;
    }
}
