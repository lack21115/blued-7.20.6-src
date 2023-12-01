package com.blued.android.sdk.a;

import android.content.Intent;
import com.blued.android.sdk.BluedPay;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/a/f.class */
public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final String f18660c = "com.blued.android.sdk.action.pay";
    public static final String d = "com.blued.android.sdk.action.pay_result";
    public static final String e = "extra_pay_balance_int";
    private BluedPay.PayCallback f;

    public f(BluedPay.PayCallback payCallback) {
        this.f = payCallback;
    }

    public void a(Intent intent) {
        String action = intent.getAction();
        if (this.f != null && d.equals(action)) {
            int intExtra = intent.getIntExtra(a.f18649a, 2);
            if (intExtra == 0) {
                this.f.onSuccess(intent.getIntExtra(e, 0));
            } else if (intExtra == 2) {
                this.f.onCancel();
            } else {
                this.f.onFailed(intent.getIntExtra(a.b, 0));
            }
        }
    }
}
