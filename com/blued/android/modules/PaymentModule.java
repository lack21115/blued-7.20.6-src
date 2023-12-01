package com.blued.android.modules;

import com.blued.android.module.base.payment.IPayment;
import com.blued.android.module.base.payment.PaymentProxy;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/PaymentModule.class */
class PaymentModule {
    private static IPayment a = new IPayment() { // from class: com.blued.android.modules.PaymentModule.1
    };

    PaymentModule() {
    }

    public static void a() {
        PaymentProxy.a().a(a);
    }
}
