package com.tencent.tendinsv.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/b/b.class */
public class b implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f25309a;
    private String b;

    private b(IBinder iBinder, String str) {
        this.f25309a = iBinder;
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(IBinder iBinder, String str) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(str);
        return queryLocalInterface instanceof b ? (b) queryLocalInterface : new b(iBinder, str);
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
            this.f25309a.transact(i, obtain, obtain2, 0);
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
        return this.f25309a;
    }
}
