package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.anythink.expressad.video.module.a.a.m;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.repackage.a.a.a.a;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/a/a/a/a/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public org.repackage.a.a.a.a f44103a = null;
    public String b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f44104c = null;
    public final Object d = new Object();
    public ServiceConnection e = new b(this);

    /* loaded from: source-3503164-dex2jar.jar:org/repackage/a/a/a/a/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f44105a = new c(null);
    }

    public /* synthetic */ c(b bVar) {
    }

    public String a(Context context, String str) {
        synchronized (this) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                if (this.f44103a != null) {
                    try {
                        return b(context, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        return "";
                    }
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.e, 1)) {
                    synchronized (this.d) {
                        try {
                            this.d.wait(m.ag);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (this.f44103a == null) {
                    return "";
                }
                try {
                    return b(context, str);
                } catch (RemoteException e3) {
                    e3.printStackTrace();
                    return "";
                }
            }
            throw new IllegalStateException("Cannot run on MainThread");
        }
    }

    public boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo != null && packageInfo.getLongVersionCode() >= 1;
            }
            boolean z = false;
            if (packageInfo != null) {
                z = false;
                if (packageInfo.versionCode >= 1) {
                    z = true;
                }
            }
            return z;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final String b(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f44104c)) {
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                signatureArr = null;
            }
            String str2 = null;
            if (signatureArr != null) {
                str2 = null;
                if (signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance(AppSigning.SHA1);
                        str2 = null;
                        if (messageDigest != null) {
                            byte[] digest = messageDigest.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b : digest) {
                                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                            }
                            str2 = sb.toString();
                        }
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                        str2 = null;
                    }
                }
            }
            this.f44104c = str2;
        }
        String a2 = ((a.AbstractBinderC1133a.C1134a) this.f44103a).a(this.b, this.f44104c, str);
        String str3 = a2;
        if (TextUtils.isEmpty(a2)) {
            str3 = "";
        }
        return str3;
    }
}
