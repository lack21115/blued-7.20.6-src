package com.alipay.sdk.app;

import com.alipay.sdk.app.OpenAuthTask;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/e.class */
/* synthetic */ class e {
    static final /* synthetic */ int[] a;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
    static {
        int[] iArr = new int[OpenAuthTask.BizType.values().length];
        a = iArr;
        try {
            iArr[OpenAuthTask.BizType.Deduct.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[OpenAuthTask.BizType.AccountAuth.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[OpenAuthTask.BizType.Invoice.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
