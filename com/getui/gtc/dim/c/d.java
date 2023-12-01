package com.getui.gtc.dim.c;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.tendinsv.utils.r;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    static boolean f21948a = false;
    public static ThreadPoolExecutor b;

    /* renamed from: c  reason: collision with root package name */
    private static final a f21949c;
    private static volatile d d;
    private static Context e;
    private static boolean f = false;
    private b g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$a.class */
    public interface a {
        boolean a(Context context);

        String b(Context context);

        boolean c(Context context);
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$b.class */
    public interface b {
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$c.class */
    static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private static String f21950a;
        private static boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        private static boolean f21951c = false;
        private static final CountDownLatch d = new CountDownLatch(1);
        private final String e;
        private final String f;
        private final String g;
        private final String h;
        private f i;

        public c(String str, String str2, String str3, String str4) {
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = str4;
        }

        protected String a() {
            return null;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public boolean a(Context context) {
            if (f21951c) {
                return b;
            }
            boolean z = false;
            if (context != null) {
                if (TextUtils.isEmpty(this.e)) {
                    z = false;
                } else {
                    try {
                        PackageInfo a2 = com.getui.gtc.dim.e.d.a(this.e, 0);
                        if (Build.VERSION.SDK_INT >= 28) {
                            if (a2 != null) {
                                return a2.getLongVersionCode() >= 1;
                            }
                            return false;
                        }
                        z = false;
                        if (a2 != null) {
                            z = false;
                            if (a2.versionCode > 0) {
                                z = true;
                            }
                        }
                    } catch (Throwable th) {
                        return false;
                    }
                }
            }
            b = z;
            f21951c = true;
            return b;
        }

        protected int b() {
            return 1;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005b -> B:14:0x0053). Please submit an issue!!! */
        @Override // com.getui.gtc.dim.c.d.a
        public String b(Context context) {
            f fVar;
            if (!TextUtils.isEmpty(f21950a) || (fVar = this.i) == null || fVar.f21955a == null) {
                return f21950a;
            }
            try {
                String a2 = this.i.f21955a.a(d(context), e(context), a(), b());
                f21950a = a2;
                if (!TextUtils.isEmpty(a2) && this.i != null) {
                    context.unbindService(this.i);
                }
            } catch (Throwable th) {
            }
            return f21950a;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public boolean c(Context context) {
            if (context == null || TextUtils.isEmpty(this.e)) {
                return false;
            }
            if (this.i == null) {
                this.i = new f(this.h, d);
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

        protected String d(Context context) {
            return null;
        }

        protected String e(Context context) {
            return null;
        }
    }

    /* renamed from: com.getui.gtc.dim.c.d$d  reason: collision with other inner class name */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$d.class */
    public static class C0346d implements a {
        protected static boolean b = false;
        private static String d;

        /* renamed from: a  reason: collision with root package name */
        String[] f21952a;

        /* renamed from: c  reason: collision with root package name */
        protected boolean f21953c = false;
        private String e;
        private String f;

        public C0346d(String str, String str2) {
            this.e = str;
            this.f = str2;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public boolean a(Context context) {
            if (this.f21953c) {
                return b;
            }
            if (context == null) {
                return false;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                b = (packageManager == null || packageManager.resolveContentProvider(this.e, 0) == null) ? false : true;
            } catch (Throwable th) {
                b = false;
            }
            this.f21953c = true;
            return b;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x006e, code lost:
            if (r8 == null) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0071, code lost:
            r8.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0061, code lost:
            if (r8 != null) goto L9;
         */
        @Override // com.getui.gtc.dim.c.d.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String b(android.content.Context r8) {
            /*
                r7 = this;
                java.lang.String r0 = com.getui.gtc.dim.c.d.C0346d.d
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L87
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = r0
                java.lang.String r2 = "content://"
                r1.<init>(r2)
                r9 = r0
                r0 = r9
                r1 = r7
                java.lang.String r1 = r1.e
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r9
                java.lang.String r1 = "/"
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r9
                r1 = r7
                java.lang.String r1 = r1.f
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r9
                java.lang.String r0 = r0.toString()
                android.net.Uri r0 = android.net.Uri.parse(r0)
                r9 = r0
                r0 = r8
                android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L8b
                r1 = r9
                r2 = 0
                r3 = 0
                r4 = r7
                java.lang.String[] r4 = r4.f21952a     // Catch: java.lang.Throwable -> L8b
                r5 = 0
                android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L8b
                r8 = r0
                r0 = r8
                if (r0 == 0) goto L60
                r0 = r8
                boolean r0 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L8f
                r0 = r8
                r1 = r8
                java.lang.String r2 = "value"
                int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L8f
                java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L8f
                com.getui.gtc.dim.c.d.C0346d.d = r0     // Catch: java.lang.Throwable -> L8f
            L60:
                r0 = r8
                if (r0 == 0) goto L87
                goto L71
            L67:
                r0 = 0
                r8 = r0
            L69:
                r0 = 0
                com.getui.gtc.dim.c.d.C0346d.d = r0     // Catch: java.lang.Throwable -> L7a
                r0 = r8
                if (r0 == 0) goto L87
            L71:
                r0 = r8
                r0.close()
                goto L87
            L7a:
                r9 = move-exception
                r0 = r8
                if (r0 == 0) goto L85
                r0 = r8
                r0.close()
            L85:
                r0 = r9
                throw r0
            L87:
                java.lang.String r0 = com.getui.gtc.dim.c.d.C0346d.d
                return r0
            L8b:
                r8 = move-exception
                goto L67
            L8f:
                r9 = move-exception
                goto L69
            */
            throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.dim.c.d.C0346d.b(android.content.Context):java.lang.String");
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final boolean c(Context context) {
            return true;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$e.class */
    public static final class e implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f21954a;
        private String b;

        private e(IBinder iBinder, String str) {
            this.f21954a = iBinder;
            this.b = str;
        }

        static e a(IBinder iBinder, String str) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(str);
            return queryLocalInterface instanceof e ? (e) queryLocalInterface : new e(iBinder, str);
        }

        final String a(String str, String str2, String str3, int i) {
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
                this.f21954a.transact(i, obtain, obtain2, 0);
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
        public final IBinder asBinder() {
            return this.f21954a;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$f.class */
    public static final class f implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        e f21955a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private CountDownLatch f21956c;
        private IBinder d;

        f(String str, CountDownLatch countDownLatch) {
            this.b = str;
            this.f21956c = countDownLatch;
        }

        final boolean a(Context context, Intent intent) {
            if (context == null) {
                return false;
            }
            if (this.f21955a != null) {
                return true;
            }
            try {
                boolean bindService = context.bindService(intent, this, 1);
                this.f21956c.await(1L, TimeUnit.SECONDS);
                this.f21955a = e.a(this.d, this.b);
                return bindService;
            } catch (Throwable th) {
                return false;
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.d = iBinder;
                this.f21956c.countDown();
            } catch (Throwable th) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            this.f21955a = null;
            this.d = null;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$g.class */
    public static final class g extends c {
        public g() {
            super(a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQ="), a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQuU3VwcGxlbWVudGFyeURJRFNlcnZpY2U="), a("Y29tLmFzdXMubXNhLmFjdGlvbi5BQ0NFU1NfRElE"), a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQuSURpZEFpZGxJbnRlcmZhY2U="));
        }

        private static String a(String str) {
            return new String(Base64.decode(str, 0));
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.c
        protected final int b() {
            return 2;
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(Context context) {
            return super.c(context);
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$h.class */
    public static final class h extends c {
        public h() {
            super("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService", null, "com.coolpad.deviceidsupport.IDeviceIdManager");
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.c
        protected final int b() {
            return 2;
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(Context context) {
            return super.c(context);
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$i.class */
    public static final class i extends c {
        public i() {
            super("com.huawei.hwid", null, "com.uodis.opendevice.OPENIDS_SERVICE", "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(Context context) {
            return super.c(context);
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$j.class */
    public static final class j extends C0346d {
        public j() {
            super("com.meizu.flyme.openidsdk", "");
        }

        @Override // com.getui.gtc.dim.c.d.C0346d, com.getui.gtc.dim.c.d.a
        public final boolean a(Context context) {
            if (super.a(context)) {
                b = true;
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
                        b = "0".equals(string);
                    } else {
                        b = false;
                    }
                } catch (Throwable th) {
                    b = false;
                    return false;
                }
            }
            this.f21953c = true;
            return b;
        }

        @Override // com.getui.gtc.dim.c.d.C0346d, com.getui.gtc.dim.c.d.a
        public final String b(Context context) {
            this.f21952a = new String[]{"oaid"};
            return super.b(context);
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$k.class */
    static final class k implements a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f21957a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private String f21958c;

        private k() {
            this.f21957a = false;
            this.b = false;
            this.f21958c = null;
        }

        /* synthetic */ k(byte b) {
            this();
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final boolean a(Context context) {
            if (this.b) {
                return this.f21957a;
            }
            if (context == null) {
                return false;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                this.f21957a = (packageManager == null || packageManager.resolveContentProvider("cn.nubia.identity", 0) == null) ? false : true;
            } catch (Throwable th) {
                this.f21957a = false;
            }
            this.b = true;
            return this.f21957a;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final String b(Context context) {
            Bundle call;
            try {
                if (TextUtils.isEmpty(this.f21958c)) {
                    Uri parse = Uri.parse("content://cn.nubia.identity/identity");
                    if (Build.VERSION.SDK_INT >= 17) {
                        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                        if (acquireContentProviderClient != null) {
                            call = acquireContentProviderClient.call("getOAID", null, null);
                            try {
                                if (Build.VERSION.SDK_INT >= 24) {
                                    Class.forName("android.content.ContentProviderClient").getMethod("close", new Class[0]).invoke(acquireContentProviderClient, new Object[0]);
                                } else {
                                    acquireContentProviderClient.release();
                                }
                            } catch (Throwable th) {
                            }
                        } else {
                            call = null;
                        }
                    } else {
                        call = context.getContentResolver().call(parse, "getOAID", null, null);
                    }
                    if (call == null) {
                        return this.f21958c;
                    }
                    if (call.getInt("code", -1) == 0) {
                        this.f21958c = call.getString("id");
                    }
                }
            } catch (Throwable th2) {
                this.f21958c = null;
            }
            return this.f21958c;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final boolean c(Context context) {
            return true;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$l.class */
    public static final class l extends c {

        /* renamed from: a  reason: collision with root package name */
        private String f21959a;
        private String b;

        public l() {
            super("com.heytap.openid", "com.heytap.openid.IdentifyService", "action.com.heytap.openid.OPEN_ID_SERVICE", "com.heytap.openid.IOpenID");
        }

        @Override // com.getui.gtc.dim.c.d.c
        protected final String a() {
            return "OUID";
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(Context context) {
            return super.c(context);
        }

        @Override // com.getui.gtc.dim.c.d.c
        protected final String d(Context context) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = context.getPackageName();
            }
            return this.b;
        }

        @Override // com.getui.gtc.dim.c.d.c
        protected final String e(Context context) {
            if (TextUtils.isEmpty(this.f21959a)) {
                try {
                    String d = d(context);
                    this.b = d;
                    Signature[] signatureArr = com.getui.gtc.dim.e.d.a(d, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        byte[] digest = MessageDigest.getInstance(AppSigning.SHA1).digest(signatureArr[0].toByteArray());
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        this.f21959a = sb.toString();
                    }
                } catch (Throwable th) {
                }
            }
            return this.f21959a;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$m.class */
    public static final class m extends c {
        public m() {
            super("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService", null, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(Context context) {
            return super.c(context);
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$n.class */
    public static final class n extends C0346d {
        public n() {
            super("com.vivo.vms.IdProvider", "IdentifierId/OAID");
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$o.class */
    public static final class o implements a {
        private static String b;

        /* renamed from: a  reason: collision with root package name */
        private Class<?> f21960a = null;

        @Override // com.getui.gtc.dim.c.d.a
        public final boolean a(Context context) {
            try {
                this.f21960a = Class.forName("com.android.id.impl.IdProviderImpl");
                return true;
            } catch (Throwable th) {
                return false;
            }
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final String b(Context context) {
            if (TextUtils.isEmpty(b)) {
                try {
                    b = String.valueOf(this.f21960a.getMethod("getOAID", Context.class).invoke(this.f21960a.newInstance(), context));
                } catch (Throwable th) {
                    b = null;
                }
            }
            return b;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final boolean c(Context context) {
            return true;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/d$p.class */
    public static final class p extends c {
        public p() {
            super("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService", null, "com.zui.deviceidservice.IDeviceidInterface");
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(Context context) {
            return super.c(context);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static {
        boolean z;
        a lVar;
        String upperCase = Build.MANUFACTURER.toUpperCase();
        switch (upperCase.hashCode()) {
            case -2053026509:
                if (upperCase.equals("LENOVO")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1881642058:
                if (upperCase.equals("REALME")) {
                    z = true;
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
            case -602397472:
                if (upperCase.equals("ONEPLUS")) {
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
            case 89200:
                if (upperCase.equals("ZUK")) {
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
                if (upperCase.equals(r.d)) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 2634924:
                if (upperCase.equals(r.f)) {
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
            case 74632627:
                if (upperCase.equals("NUBIA")) {
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
            case 630905871:
                if (upperCase.equals("MOTOLORA")) {
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
            case true:
                lVar = new l();
                break;
            case true:
            case true:
                lVar = new n();
                break;
            case true:
            case true:
            case true:
                lVar = new o();
                break;
            case true:
            case true:
            case true:
                lVar = new i();
                break;
            case true:
                lVar = new j();
                break;
            case true:
                lVar = new m();
                break;
            case true:
            case true:
            case true:
            case true:
                lVar = new p();
                break;
            case true:
                lVar = new g();
                break;
            case true:
                lVar = new h();
                break;
            case true:
                lVar = new k((byte) 0);
                break;
            default:
                lVar = null;
                break;
        }
        f21949c = lVar;
    }

    public static d a() {
        if (d == null) {
            synchronized (d.class) {
                try {
                    if (d == null) {
                        d = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        if (f21949c == null || context == null) {
            return;
        }
        e = context.getApplicationContext();
        boolean c2 = c();
        f = c2;
        if (c2) {
            f21948a = f21949c.c(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        String str = null;
        try {
            if (e == null) {
                return null;
            }
            if (f21949c != null) {
                if (!f21948a) {
                    return null;
                }
                str = f21949c.b(e);
            }
            return str;
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean c() {
        try {
            if (e == null || f21949c == null) {
                return false;
            }
            return f21949c.a(e);
        } catch (Throwable th) {
            return false;
        }
    }
}
