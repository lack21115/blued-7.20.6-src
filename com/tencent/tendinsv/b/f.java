package com.tencent.tendinsv.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/b/f.class */
public class f implements k {

    /* renamed from: a  reason: collision with root package name */
    private static String f39004a;
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f39005c = false;
    private static final CountDownLatch d = new CountDownLatch(1);
    private String e;
    private String f;
    private String g;
    private String h;
    private h i;
    private String j;
    private String k;

    public f(String str, String str2, String str3, String str4) {
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
    }

    public String a() {
        return "OUID";
    }

    public int b() {
        return 1;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0054 -> B:12:0x004c). Please submit an issue!!! */
    @Override // com.tencent.tendinsv.b.k
    public String b(Context context) {
        h hVar;
        if (!TextUtils.isEmpty(f39004a) || (hVar = this.i) == null || hVar.a() == null) {
            return f39004a;
        }
        try {
            String a2 = this.i.a().a(d(context), e(context), a(), b());
            f39004a = a2;
            if (!TextUtils.isEmpty(a2)) {
                context.unbindService(this.i);
            }
        } catch (Throwable th) {
        }
        return f39004a;
    }

    @Override // com.tencent.tendinsv.b.k
    public boolean b_(Context context) {
        if (f39005c) {
            return b;
        }
        if (context == null || TextUtils.isEmpty(this.e)) {
            b = false;
        } else {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.e, 0);
                if (Build.VERSION.SDK_INT >= 28) {
                    return packageInfo != null && packageInfo.getLongVersionCode() >= 1;
                }
                b = packageInfo != null && packageInfo.versionCode >= 1;
            } catch (Throwable th) {
                return false;
            }
        }
        f39005c = true;
        return b;
    }

    @Override // com.tencent.tendinsv.b.k
    public boolean c_(Context context) {
        if (context == null || TextUtils.isEmpty(this.e)) {
            return false;
        }
        if (this.i == null) {
            this.i = new h(this.h, d);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(this.f)) {
            intent.setPackage(this.e);
        } else {
            intent.setComponent(new ComponentName(this.e, this.f));
        }
        if (!TextUtils.isEmpty(this.g)) {
            intent.setAction(this.g);
        }
        return this.i.a(context, intent);
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.j)) {
            this.j = context.getPackageName();
        }
        return this.j;
    }

    public String e(Context context) {
        if (TextUtils.isEmpty(this.k)) {
            try {
                this.j = d(context);
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(this.j, 64).signatures;
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] digest = MessageDigest.getInstance(AppSigning.SHA1).digest(signatureArr[0].toByteArray());
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : digest) {
                        sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                    }
                    this.k = sb.toString();
                }
            } catch (Throwable th) {
            }
        }
        return this.k;
    }

    public String f(Context context) {
        return null;
    }

    public String g(Context context) {
        return null;
    }
}
