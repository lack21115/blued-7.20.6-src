package com.blued.android.modules;

import com.blued.android.module.base.payment.IPayment;
import com.blued.android.module.base.payment.PaymentProxy;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/PaymentModule.class */
class PaymentModule {

    /* renamed from: a  reason: collision with root package name */
    private static IPayment f18631a = new IPayment() { // from class: com.blued.android.modules.PaymentModule.1
    };

    PaymentModule() {
    }

    public static void a() {
        PaymentProxy.a().a(f18631a);
    }
}
