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
        public static class C0141a implements g4 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f7617a;

            public C0141a(IBinder iBinder) {
                this.f7617a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7617a;
            }
        }

        public static g4 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof g4)) ? new C0141a(iBinder) : (g4) queryLocalInterface;
        }
    }
}
