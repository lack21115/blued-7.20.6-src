package com.tencent.tmsqmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.tmsqmsp.oaid2.g0;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/h0.class */
public class h0 {
    public static final h0 f = new h0();

    /* renamed from: a  reason: collision with root package name */
    public g0 f39631a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f39632c;
    public final Object d = new Object();
    public ServiceConnection e = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/h0$a.class */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            h0.this.f39631a = g0.a.a(iBinder);
            synchronized (h0.this.d) {
                h0.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h0.this.f39631a = null;
        }
    }

    public String a(Context context, String str) {
        String b;
        synchronized (this) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot run on MainThread");
            }
            if (this.f39631a == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.e, 1)) {
                    synchronized (this.d) {
                        try {
                            this.d.wait(com.anythink.expressad.video.module.a.a.m.ag);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (this.f39631a != null) {
                    try {
                        b = b(context, str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                b = "";
            } else {
                try {
                    b = b(context, str);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        return b;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0037 -> B:18:0x003b). Please submit an issue!!! */
    public boolean a(Context context) {
        boolean z = true;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        z = Build.VERSION.SDK_INT < 28 ? false : false;
        return z;
    }

    public final String b(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f39632c)) {
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
            this.f39632c = str2;
        }
        String a2 = ((g0.a.C1037a) this.f39631a).a(this.b, this.f39632c, str);
        String str3 = a2;
        if (TextUtils.isEmpty(a2)) {
            str3 = "";
        }
        return str3;
    }
}
