package com.tencent.qmsp.sdk.g.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.g.g.d;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/g/e.class */
public class e {
    public static final e f = new e();

    /* renamed from: a  reason: collision with root package name */
    public d f24954a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f24955c;
    public final Object d = new Object();
    public ServiceConnection e = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/g/e$a.class */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e.this.f24954a = d.a.a(iBinder);
            synchronized (e.this.d) {
                e.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            e.this.f24954a = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
        if (r6.f24954a == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(android.content.Context r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = r6
            monitor-enter(r0)
            android.os.Looper r0 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> L92
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L92
            if (r0 == r1) goto L88
            r0 = r6
            com.tencent.qmsp.sdk.g.g.d r0 = r0.f24954a     // Catch: java.lang.Throwable -> L92
            if (r0 != 0) goto L72
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L92
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L92
            r9 = r0
            r0 = r9
            android.content.ComponentName r1 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L92
            r2 = r1
            java.lang.String r3 = "com.heytap.openid"
            java.lang.String r4 = "com.heytap.openid.IdentifyService"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L92
            android.content.Intent r0 = r0.setComponent(r1)     // Catch: java.lang.Throwable -> L92
            r0 = r9
            java.lang.String r1 = "action.com.heytap.openid.OPEN_ID_SERVICE"
            android.content.Intent r0 = r0.setAction(r1)     // Catch: java.lang.Throwable -> L92
            r0 = r7
            r1 = r9
            r2 = r6
            android.content.ServiceConnection r2 = r2.e     // Catch: java.lang.Throwable -> L92
            r3 = 1
            boolean r0 = r0.bindService(r1, r2, r3)     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L66
            r0 = r6
            java.lang.Object r0 = r0.d     // Catch: java.lang.Throwable -> L92
            r9 = r0
            r0 = r9
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L92
            r0 = r6
            java.lang.Object r0 = r0.d     // Catch: java.lang.Throwable -> L52 java.lang.InterruptedException -> L56
            r1 = 3000(0xbb8, double:1.482E-320)
            r0.wait(r1)     // Catch: java.lang.Throwable -> L52 java.lang.InterruptedException -> L56
            goto L5d
        L52:
            r7 = move-exception
            goto L62
        L56:
            r10 = move-exception
            r0 = r10
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L52
        L5d:
            r0 = r9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L52
            goto L66
        L62:
            r0 = r9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L52
            r0 = r7
            throw r0     // Catch: java.lang.Throwable -> L92
        L66:
            r0 = r6
            com.tencent.qmsp.sdk.g.g.d r0 = r0.f24954a     // Catch: java.lang.Throwable -> L92
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L72
            goto L81
        L72:
            r0 = r6
            r1 = r7
            r2 = r8
            java.lang.String r0 = r0.b(r1, r2)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L92
            r7 = r0
            goto L84
        L7c:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L92
        L81:
            java.lang.String r0 = ""
            r7 = r0
        L84:
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L92
            r0 = r7
            return r0
        L88:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L92
            r1 = r0
            java.lang.String r2 = "Cannot run on MainThread"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L92
            throw r0     // Catch: java.lang.Throwable -> L92
        L92:
            r7 = move-exception
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L92
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qmsp.sdk.g.g.e.a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0039 -> B:20:0x003d). Please submit an issue!!! */
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
        if (TextUtils.isEmpty(this.f24955c)) {
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
            this.f24955c = str2;
        }
        String a2 = ((d.a.C0829a) this.f24954a).a(this.b, this.f24955c, str);
        String str3 = a2;
        if (TextUtils.isEmpty(a2)) {
            str3 = "";
        }
        return str3;
    }
}
