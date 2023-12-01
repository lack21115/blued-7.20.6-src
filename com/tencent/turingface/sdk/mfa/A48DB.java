package com.tencent.turingface.sdk.mfa;

import com.tencent.turingface.sdk.mfa.BfUKf;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/A48DB.class */
public final class A48DB {

    /* renamed from: a  reason: collision with root package name */
    public static final A48DB f39857a = new A48DB();
    public CvowV b;

    public final tmnyR a(byte[] bArr) {
        BfUKf bfUKf = this.b.b;
        if (bfUKf == null) {
            return tmnyR.a(-20000);
        }
        try {
            System.currentTimeMillis();
            BfUKf.spXPg onHttpPost = bfUKf.onHttpPost(bArr);
            if (onHttpPost == null) {
                return tmnyR.a(-20000);
            }
            int i = onHttpPost.errCode;
            return i != 0 ? tmnyR.a(i - 20000) : new tmnyR(0, onHttpPost.data, 0, 0);
        } catch (Throwable th) {
            return tmnyR.a(-20000);
        }
    }
}
