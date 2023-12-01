package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/k.class */
public final class k {
    private final String ZO;
    private final String ZP;
    private final String ZQ;
    private Resources ZR;
    private ClassLoader ZS;
    private IKsAdSDK ZU;

    private k(String str, String str2, String str3) {
        this.ZO = str;
        this.ZP = str2;
        this.ZQ = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k a(Context context, ClassLoader classLoader, String str) {
        k b;
        synchronized (k.class) {
            try {
                try {
                    b = b(context, classLoader, h.n(context, str), h.o(context, str), h.p(context, str));
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k b(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            k kVar = new k(str, str2, str3);
            kVar.c(context, classLoader);
            return kVar;
        }
        throw new RuntimeException("mApk not a file");
    }

    private void c(Context context, ClassLoader classLoader) {
        tr();
        Resources a2 = q.a(context, context.getResources(), this.ZO);
        ClassLoader a3 = e.a(context, classLoader, this.ZO, this.ZP, this.ZQ);
        IKsAdSDK a4 = Loader.a(a3);
        this.ZR = a2;
        this.ZS = a3;
        this.ZU = a4;
        int sDKType = a4.getSDKType();
        if (sDKType == 1) {
            return;
        }
        throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
    }

    private void tr() {
        if (TextUtils.isEmpty(this.ZO)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.ZO);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ClassLoader getClassLoader() {
        return this.ZS;
    }

    public final String toString() {
        return "ExternalPackage{mApk='" + this.ZO + "', mDexDir='" + this.ZP + "', mNativeLibDir='" + this.ZQ + "', mResource=" + this.ZR + ", mClassLoader=" + this.ZS + ", mKsSdk=" + this.ZU + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Resources tp() {
        return this.ZR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final IKsAdSDK tq() {
        return this.ZU;
    }
}
