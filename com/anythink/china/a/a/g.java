package com.anythink.china.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.china.a.a.h;
import java.security.MessageDigest;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/g.class */
public final class g {
    h a;
    ServiceConnection b = new ServiceConnection() { // from class: com.anythink.china.a.a.g.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.a = h.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            g.this.a = null;
        }
    };
    private Context c;

    public g(Context context) {
        this.c = context;
    }

    private String a(String str) {
        Signature[] signatureArr;
        String packageName = this.c.getPackageName();
        try {
            signatureArr = this.c.getPackageManager().getPackageInfo(packageName, 64).signatures;
        } catch (Exception e) {
            e.printStackTrace();
            signatureArr = null;
        }
        String str2 = null;
        if (signatureArr != null) {
            str2 = null;
            if (signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    str2 = null;
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str2 = null;
                }
            }
        }
        return ((h.a.C0044a) this.a).a(packageName, str2, str);
    }

    public final String a(com.anythink.china.a.a aVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return "";
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = "";
        if (this.c.bindService(intent, this.b, 1)) {
            try {
                SystemClock.sleep(3000L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            str = "";
            if (this.a != null) {
                str = a("OUID");
                aVar.a(str, false);
            }
        }
        if (TextUtils.isEmpty(str)) {
            aVar.a();
        }
        return str;
    }
}
