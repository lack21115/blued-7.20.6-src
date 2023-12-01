package com.tencent.tendinsv.b;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/b/e.class */
public class e implements k {

    /* renamed from: a  reason: collision with root package name */
    private static String f25312a;
    private Class b = null;

    @Override // com.tencent.tendinsv.b.k
    public String b(Context context) {
        if (TextUtils.isEmpty(f25312a)) {
            try {
                f25312a = String.valueOf(this.b.getMethod("getOAID", Context.class).invoke(this.b.newInstance(), context));
            } catch (Throwable th) {
                f25312a = null;
            }
        }
        return f25312a;
    }

    @Override // com.tencent.tendinsv.b.k
    public boolean b_(Context context) {
        try {
            this.b = Class.forName("com.android.id.impl.IdProviderImpl");
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // com.tencent.tendinsv.b.k
    public boolean c_(Context context) {
        return true;
    }
}
