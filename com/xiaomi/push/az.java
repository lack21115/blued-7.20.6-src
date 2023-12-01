package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/az.class */
public class az implements as {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f27576a;

    /* renamed from: a  reason: collision with other field name */
    private Context f160a;

    /* renamed from: a  reason: collision with other field name */
    private ServiceConnection f161a;

    /* renamed from: a  reason: collision with other field name */
    private volatile int f159a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile a f162a = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f163a = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/az$a.class */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        String f164a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f27578c;
        String d;

        private a() {
            this.f164a = null;
            this.b = null;
            this.f27578c = null;
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/az$b.class */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (az.this.f162a != null) {
                return;
            }
            new Thread(new bb(this, iBinder)).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/az$c.class */
    static class c {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public az(Context context) {
        this.f160a = context;
        a();
    }

    private void a() {
        boolean z;
        this.f161a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        int i = 1;
        try {
            z = this.f160a.bindService(intent, this.f161a, 1);
        } catch (Exception e) {
            z = false;
        }
        if (!z) {
            i = 2;
        }
        this.f159a = i;
    }

    private void a(String str) {
        if (this.f159a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f163a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m8344a("oppo's " + str + " wait...");
                this.f163a.wait(com.anythink.expressad.video.module.a.a.m.ag);
            } catch (Exception e) {
            }
        }
    }

    public static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                f27576a = longVersionCode >= 1;
                return z;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        try {
            Signature[] signatureArr = this.f160a.getPackageManager().getPackageInfo(this.f160a.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance(AppSigning.SHA1);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b  reason: collision with other method in class */
    public void m8467b() {
        ServiceConnection serviceConnection = this.f161a;
        if (serviceConnection != null) {
            try {
                this.f160a.unbindService(serviceConnection);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a */
    public String mo8458a() {
        a("getOAID");
        if (this.f162a == null) {
            return null;
        }
        return this.f162a.b;
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a */
    public boolean mo8459a() {
        return f27576a;
    }
}
