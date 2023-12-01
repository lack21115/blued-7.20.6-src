package c.t.m.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import c.t.m.g.k1;
import c.t.m.g.v0;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/b1.class */
public class b1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f3709a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public k1 f3710c;
    public ServiceConnection d = new a();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/b1$a.class */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b1.this.f3710c = k1.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b1.this.f3710c = null;
        }
    }

    public b1(Context context) {
        this.f3709a = context;
    }

    public String a(v0.b bVar) {
        String str;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (this.f3709a.bindService(intent, this.d, 1)) {
                try {
                    SystemClock.sleep(com.anythink.expressad.video.module.a.a.m.ag);
                } catch (Exception e) {
                }
                if (this.f3710c != null) {
                    String a2 = a("OUID");
                    boolean a3 = a();
                    str = a2;
                    if (bVar != null) {
                        bVar.a(a2, a3);
                        return a2;
                    }
                    return str;
                }
            }
            str = null;
            return str;
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }

    public final String a(String str) {
        Signature[] signatureArr;
        String packageName = this.f3709a.getPackageName();
        if (this.b == null) {
            try {
                signatureArr = this.f3709a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e) {
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
                    } catch (Exception e2) {
                        str2 = null;
                    }
                }
            }
            this.b = str2;
        }
        return ((k1.a.C0038a) this.f3710c).a(packageName, this.b, str);
    }

    public final boolean a() {
        try {
            PackageInfo packageInfo = this.f3709a.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
            boolean z = false;
            if (packageInfo != null) {
                z = false;
                if (longVersionCode >= 1) {
                    z = true;
                }
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}
