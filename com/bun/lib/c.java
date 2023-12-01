package com.bun.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: source-7206380-dex2jar.jar:com/bun/lib/c.class */
public interface c extends IInterface {

    /* loaded from: source-7206380-dex2jar.jar:com/bun/lib/c$a.class */
    public static abstract class a extends Binder implements c {

        /* renamed from: com.bun.lib.c$a$a  reason: collision with other inner class name */
        /* loaded from: source-7206380-dex2jar.jar:com/bun/lib/c$a$a.class */
        static class C0298a implements c {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f21119a;

            C0298a(IBinder iBinder) {
                this.f21119a = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.bun.lib.c
            public native boolean c();

            @Override // com.bun.lib.c
            public native String getAAID();

            @Override // com.bun.lib.c
            public native String getOAID();

            @Override // com.bun.lib.c
            public native String getVAID();

            @Override // com.bun.lib.c
            public native boolean isSupported();

            @Override // com.bun.lib.c
            public native void shutDown();
        }

        public static native c a(IBinder iBinder);
    }

    boolean c();

    String getAAID();

    String getOAID();

    String getVAID();

    boolean isSupported();

    void shutDown();
}
