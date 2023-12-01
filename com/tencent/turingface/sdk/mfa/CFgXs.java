package com.tencent.turingface.sdk.mfa;

import android.os.Build;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/CFgXs.class */
public final class CFgXs {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<String> f39863a = new AtomicReference<>();

    public static String a() {
        String str;
        AtomicReference<String> atomicReference = f39863a;
        String str2 = atomicReference.get();
        if (str2 == null) {
            synchronized (atomicReference) {
                String str3 = atomicReference.get();
                str = str3;
                if (str3 == null) {
                    str = Build.MODEL;
                    atomicReference.set(str);
                }
            }
            return str;
        }
        return str2;
    }
}
