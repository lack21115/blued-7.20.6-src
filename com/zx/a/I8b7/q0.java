package com.zx.a.I8b7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0.class */
public class q0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f28476a;
    public static volatile q0 b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f28477c;
    public static boolean d = false;

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$a.class */
    public interface a {
        boolean a(Context context);

        String b(Context context);

        boolean c(Context context);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$b.class */
    public static class b implements a {
        public static String f;
        public static boolean g = false;
        public static boolean h = false;
        public static final CountDownLatch i = new CountDownLatch(1);

        /* renamed from: a  reason: collision with root package name */
        public String f28478a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f28479c;
        public String d;
        public e e;

        public b(String str, String str2, String str3, String str4) {
            this.f28478a = str;
            this.b = str2;
            this.f28479c = str3;
            this.d = str4;
        }

        public int a() {
            return 1;
        }

        @Override // com.zx.a.I8b7.q0.a
        public boolean a(Context context) {
            if (context == null || TextUtils.isEmpty(this.f28478a)) {
                return false;
            }
            if (this.e == null) {
                this.e = new e(this.d, i);
            }
            Intent intent = new Intent();
            if (TextUtils.isEmpty(this.b)) {
                intent.setPackage(this.f28478a);
            } else {
                intent.setComponent(new ComponentName(this.f28478a, this.b));
            }
            if (!TextUtils.isEmpty(this.f28479c)) {
                intent.setAction(this.f28479c);
            }
            return this.e.a(context, intent);
        }

        public String b() {
            return null;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0056 -> B:14:0x004e). Please submit an issue!!! */
        @Override // com.zx.a.I8b7.q0.a
        public String b(Context context) {
            e eVar;
            d dVar;
            e eVar2;
            if (!TextUtils.isEmpty(f) || (eVar = this.e) == null || (dVar = eVar.f28483a) == null) {
                return f;
            }
            try {
                String a2 = dVar.a(d(context), e(context), b(), a());
                f = a2;
                if (!TextUtils.isEmpty(a2) && (eVar2 = this.e) != null) {
                    context.unbindService(eVar2);
                }
            } catch (Throwable th) {
            }
            return f;
        }

        @Override // com.zx.a.I8b7.q0.a
        public boolean c(Context context) {
            if (h) {
                return g;
            }
            if (context == null || TextUtils.isEmpty(this.f28478a)) {
                g = false;
            } else {
                try {
                    PackageInfo a2 = p2.a(this.f28478a, 0);
                    if (Build.VERSION.SDK_INT >= 28) {
                        if (a2 != null) {
                            return a2.getLongVersionCode() >= 1;
                        }
                        return false;
                    }
                    boolean z = false;
                    if (a2 != null) {
                        z = false;
                        if (a2.versionCode >= 1) {
                            z = true;
                        }
                    }
                    g = z;
                } catch (Throwable th) {
                    return false;
                }
            }
            h = true;
            return g;
        }

        public String d(Context context) {
            return null;
        }

        public String e(Context context) {
            return null;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$c.class */
    public static class c implements a {
        public static String e;
        public static boolean f = false;

        /* renamed from: a  reason: collision with root package name */
        public String f28480a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f28481c;
        public boolean d = false;

        public c(String str, String str2) {
            this.f28480a = str;
            this.b = str2;
        }

        @Override // com.zx.a.I8b7.q0.a
        public boolean a(Context context) {
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x006a, code lost:
            if (r8 == null) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x006d, code lost:
            r8.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x005d, code lost:
            if (r8 != null) goto L9;
         */
        @Override // com.zx.a.I8b7.q0.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String b(android.content.Context r8) {
            /*
                r7 = this;
                java.lang.String r0 = com.zx.a.I8b7.q0.c.e
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L83
                java.lang.String r0 = "content://"
                java.lang.StringBuilder r0 = com.zx.a.I8b7.m2.a(r0)
                r9 = r0
                r0 = r9
                r1 = r7
                java.lang.String r1 = r1.f28480a
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r9
                java.lang.String r1 = "/"
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r9
                r1 = r7
                java.lang.String r1 = r1.b
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r9
                java.lang.String r0 = r0.toString()
                android.net.Uri r0 = android.net.Uri.parse(r0)
                r9 = r0
                r0 = r8
                android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L87
                r1 = r9
                r2 = 0
                r3 = 0
                r4 = r7
                java.lang.String[] r4 = r4.f28481c     // Catch: java.lang.Throwable -> L87
                r5 = 0
                android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L87
                r8 = r0
                r0 = r8
                if (r0 == 0) goto L5c
                r0 = r8
                boolean r0 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L8b
                r0 = r8
                r1 = r8
                java.lang.String r2 = "value"
                int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L8b
                java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L8b
                com.zx.a.I8b7.q0.c.e = r0     // Catch: java.lang.Throwable -> L8b
            L5c:
                r0 = r8
                if (r0 == 0) goto L83
                goto L6d
            L63:
                r0 = 0
                r8 = r0
            L65:
                r0 = 0
                com.zx.a.I8b7.q0.c.e = r0     // Catch: java.lang.Throwable -> L76
                r0 = r8
                if (r0 == 0) goto L83
            L6d:
                r0 = r8
                r0.close()
                goto L83
            L76:
                r9 = move-exception
                r0 = r8
                if (r0 == 0) goto L81
                r0 = r8
                r0.close()
            L81:
                r0 = r9
                throw r0
            L83:
                java.lang.String r0 = com.zx.a.I8b7.q0.c.e
                return r0
            L87:
                r8 = move-exception
                goto L63
            L8b:
                r9 = move-exception
                goto L65
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.q0.c.b(android.content.Context):java.lang.String");
        }

        @Override // com.zx.a.I8b7.q0.a
        public boolean c(Context context) {
            if (this.d) {
                return f;
            }
            if (context == null) {
                return false;
            }
            try {
                PackageManager c2 = d3.c(context);
                f = (c2 == null || c2.resolveContentProvider(this.f28480a, 0) == null) ? false : true;
            } catch (Throwable th) {
                f = false;
            }
            this.d = true;
            return f;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$d.class */
    public static class d implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f28482a;
        public String b;

        public d(IBinder iBinder, String str) {
            this.f28482a = iBinder;
            this.b = str;
        }

        public String a(String str, String str2, String str3, int i) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(this.b);
                if (!TextUtils.isEmpty(str)) {
                    obtain.writeString(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    obtain.writeString(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    obtain.writeString(str3);
                }
                this.f28482a.transact(i, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } catch (Throwable th) {
                try {
                    obtain.recycle();
                    obtain2.recycle();
                    return "";
                } catch (Exception e) {
                    return "";
                }
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f28482a;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$e.class */
    public static class e implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public d f28483a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public CountDownLatch f28484c;
        public IBinder d;

        public e(String str, CountDownLatch countDownLatch) {
            this.b = str;
            this.f28484c = countDownLatch;
        }

        public boolean a(Context context, Intent intent) {
            d dVar;
            if (this.f28483a != null) {
                return true;
            }
            try {
                boolean bindService = context.bindService(intent, this, 1);
                this.f28484c.await(1L, TimeUnit.SECONDS);
                IBinder iBinder = this.d;
                String str = this.b;
                if (iBinder == null) {
                    dVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(str);
                    dVar = queryLocalInterface instanceof d ? (d) queryLocalInterface : new d(iBinder, str);
                }
                this.f28483a = dVar;
                return bindService;
            } catch (Throwable th) {
                return false;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.d = iBinder;
                this.f28484c.countDown();
            } catch (Throwable th) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f28483a = null;
            this.d = null;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$f.class */
    public static class f extends b {
        public f() {
            super("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService", "com.asus.msa.action.ACCESS_DID", "com.asus.msa.SupplementaryDID.IDidAidlInterface");
        }

        @Override // com.zx.a.I8b7.q0.b
        public int a() {
            return 2;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$g.class */
    public static class g extends b {
        public g() {
            super("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService", null, "com.coolpad.deviceidsupport.IDeviceIdManager");
        }

        @Override // com.zx.a.I8b7.q0.b
        public int a() {
            return 2;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$h.class */
    public static class h extends b {
        public h() {
            super("com.huawei.hwid", null, "com.uodis.opendevice.OPENIDS_SERVICE", "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$i.class */
    public static class i extends c {
        public i() {
            super("com.meizu.flyme.openidsdk", "");
        }

        @Override // com.zx.a.I8b7.q0.c, com.zx.a.I8b7.q0.a
        public String b(Context context) {
            this.f28481c = new String[]{"oaid"};
            return super.b(context);
        }

        @Override // com.zx.a.I8b7.q0.c, com.zx.a.I8b7.q0.a
        public boolean c(Context context) {
            if (super.c(context)) {
                c.f = true;
            } else {
                try {
                    Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"support"}, null);
                    if (query == null) {
                        return false;
                    }
                    query.moveToFirst();
                    int columnIndex = query.getColumnIndex("value");
                    if (columnIndex >= 0) {
                        String string = query.getString(columnIndex);
                        if (TextUtils.isEmpty(string)) {
                            return false;
                        }
                        c.f = "0".equals(string);
                    } else {
                        c.f = false;
                    }
                } catch (Throwable th) {
                    c.f = false;
                    return false;
                }
            }
            this.d = true;
            return c.f;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$j.class */
    public static class j extends b {
        public String j;
        public String k;

        public j() {
            super("com.heytap.openid", "com.heytap.openid.IdentifyService", "action.com.heytap.openid.OPEN_ID_SERVICE", "com.heytap.openid.IOpenID");
        }

        @Override // com.zx.a.I8b7.q0.b
        public String b() {
            return "OUID";
        }

        @Override // com.zx.a.I8b7.q0.b
        public String d(Context context) {
            if (TextUtils.isEmpty(this.k)) {
                this.k = context.getPackageName();
            }
            return this.k;
        }

        @Override // com.zx.a.I8b7.q0.b
        public String e(Context context) {
            if (TextUtils.isEmpty(this.j)) {
                try {
                    if (TextUtils.isEmpty(this.k)) {
                        this.k = context.getPackageName();
                    }
                    String str = this.k;
                    this.k = str;
                    Signature[] signatureArr = p2.a(str, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        byte[] digest = MessageDigest.getInstance(AppSigning.SHA1).digest(signatureArr[0].toByteArray());
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        this.j = sb.toString();
                    }
                } catch (Throwable th) {
                }
            }
            return this.j;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$k.class */
    public static class k extends b {
        public k() {
            super("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService", null, "com.samsung.android.deviceidservice.IDeviceIdService");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$l.class */
    public static class l extends c {
        public l() {
            super("com.vivo.vms.IdProvider", "IdentifierId/OAID");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$m.class */
    public static class m implements a {
        public static String b;

        /* renamed from: a  reason: collision with root package name */
        public Class f28485a = null;

        @Override // com.zx.a.I8b7.q0.a
        public boolean a(Context context) {
            return true;
        }

        @Override // com.zx.a.I8b7.q0.a
        public String b(Context context) {
            if (TextUtils.isEmpty(b)) {
                try {
                    b = String.valueOf(this.f28485a.getMethod("getOAID", Context.class).invoke(this.f28485a.newInstance(), context));
                } catch (Throwable th) {
                    b = null;
                }
            }
            return b;
        }

        @Override // com.zx.a.I8b7.q0.a
        public boolean c(Context context) {
            try {
                this.f28485a = Class.forName("com.android.id.impl.IdProviderImpl");
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q0$n.class */
    public static class n extends b {
        public n() {
            super("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService", null, "com.zui.deviceidservice.IDeviceidInterface");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static {
        boolean z;
        a nVar;
        String upperCase = Build.MANUFACTURER.toUpperCase();
        upperCase.getClass();
        switch (upperCase.hashCode()) {
            case -2053026509:
                if (upperCase.equals("LENOVO")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case -1712043046:
                if (upperCase.equals("SAMSUNG")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1706170181:
                if (upperCase.equals("XIAOMI")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1134767290:
                if (upperCase.equals("BLACKSHARK")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 89198:
                if (upperCase.equals("ZUI")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2018896:
                if (upperCase.equals("ASUS")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2255112:
                if (upperCase.equals("IQOO")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2432928:
                if (upperCase.equals(com.tencent.tendinsv.utils.r.d)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2634924:
                if (upperCase.equals(com.tencent.tendinsv.utils.r.f)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 68924490:
                if (upperCase.equals("HONOR")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 73239724:
                if (upperCase.equals("MEIZU")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 77852109:
                if (upperCase.equals("REDMI")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1670208650:
                if (upperCase.equals("COOLPAD")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1972178256:
                if (upperCase.equals("HUA_WEI")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2141820391:
                if (upperCase.equals("HUAWEI")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
            case true:
                nVar = new n();
                break;
            case true:
                nVar = new k();
                break;
            case true:
            case true:
            case true:
                nVar = new m();
                break;
            case true:
                nVar = new f();
                break;
            case true:
            case true:
                nVar = new l();
                break;
            case true:
                nVar = new j();
                break;
            case true:
            case true:
            case true:
                nVar = new h();
                break;
            case true:
                nVar = new i();
                break;
            case true:
                nVar = new g();
                break;
            default:
                nVar = null;
                break;
        }
        f28476a = nVar;
    }
}
