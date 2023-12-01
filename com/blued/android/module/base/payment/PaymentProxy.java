package com.blued.android.module.base.payment;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/payment/PaymentProxy.class */
public class PaymentProxy implements IPayment {

    /* renamed from: a  reason: collision with root package name */
    private static PaymentProxy f10430a = new PaymentProxy();
    private IPayment b = null;

    private PaymentProxy() {
    }

    public static PaymentProxy a() {
        return f10430a;
    }

    public void a(IPayment iPayment) {
        this.b = iPayment;
    }
}
