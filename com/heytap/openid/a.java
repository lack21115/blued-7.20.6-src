package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/openid/a.class */
public interface a extends IInterface {

    /* renamed from: com.heytap.openid.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/heytap/openid/a$a.class */
    public static abstract class AbstractBinderC0384a extends Binder implements a {

        /* renamed from: com.heytap.openid.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-7994992-dex2jar.jar:com/heytap/openid/a$a$a.class */
        public static class C0385a implements a {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f22267a;

            public C0385a(IBinder iBinder) {
                this.f22267a = iBinder;
            }

            public native String a(String str, String str2, String str3);

            @Override // android.os.IInterface
            public native IBinder asBinder();
        }

        public static native a a(IBinder iBinder);
    }
}
