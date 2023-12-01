package c.t.m.g;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.provider.Settings;
import android.text.TextUtils;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/g1.class */
public final class g1 implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f3768a;
    public Context b;

    public g1(IBinder iBinder, Context context) {
        this.f3768a = iBinder;
        this.b = context;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3768a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x002c, code lost:
        if (r0.readInt() == 0) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean e() {
        /*
            r6 = this;
            android.os.Parcel r0 = android.os.Parcel.obtain()
            r9 = r0
            android.os.Parcel r0 = android.os.Parcel.obtain()
            r10 = r0
            r0 = 0
            r8 = r0
            r0 = r9
            java.lang.String r1 = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService"
            r0.writeInterfaceToken(r1)     // Catch: java.lang.Throwable -> L48
            r0 = r6
            android.os.IBinder r0 = r0.f3768a     // Catch: java.lang.Throwable -> L48
            r1 = 1
            r2 = r9
            r3 = r10
            r4 = 0
            boolean r0 = r0.transact(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L48
            r0 = r10
            r0.readException()     // Catch: java.lang.Throwable -> L48
            r0 = r10
            int r0 = r0.readInt()     // Catch: java.lang.Throwable -> L48
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L3b
            goto L3d
        L32:
            r0 = r9
            r0.recycle()
            r0 = r10
            r0.recycle()
        L3b:
            r0 = 1
            r8 = r0
        L3d:
            r0 = r9
            r0.recycle()
            r0 = r10
            r0.recycle()
            r0 = r8
            return r0
        L48:
            r11 = move-exception
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.g1.e():boolean");
    }

    public String f() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            this.f3768a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            str = null;
        }
        obtain.recycle();
        obtain2.recycle();
        return str;
    }

    public String g() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(this.b.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(this.b.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    if (!TextUtils.isEmpty(string2)) {
                        return "get oaid failed";
                    }
                }
                return string;
            } catch (Throwable th) {
                th.printStackTrace();
                return "get oaid failed";
            }
        }
        return null;
    }
}
