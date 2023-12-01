package com.bytedance.bdtracker;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/g4.class */
public interface g4 extends IInterface {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/g4$a.class */
    public static abstract class a extends Binder implements g4 {

        /* renamed from: com.bytedance.bdtracker.g4$a$a  reason: collision with other inner class name */
        /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/g4$a$a.class */
        public static class C0311a implements g4 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f21223a;

            public C0311a(IBinder iBinder) {
                this.f21223a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21223a;
            }
        }

        public static g4 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof g4)) ? new C0311a(iBinder) : (g4) queryLocalInterface;
        }
    }
}
