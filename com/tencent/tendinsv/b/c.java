package com.tencent.tendinsv.b;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/b/c.class */
public class c implements k {

    /* renamed from: a  reason: collision with root package name */
    private Class f25310a = null;
    private String b;

    @Override // com.tencent.tendinsv.b.k
    public String b(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            try {
                this.b = String.valueOf(this.f25310a.getMethod("getOAID", Context.class).invoke(this.f25310a.newInstance(), context));
            } catch (Throwable th) {
                this.b = null;
            }
        }
        return this.b;
    }

    @Override // com.tencent.tendinsv.b.k
    public boolean b_(Context context) {
        try {
            this.f25310a = Class.forName("com.android.id.impl.IdProviderImpl");
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
