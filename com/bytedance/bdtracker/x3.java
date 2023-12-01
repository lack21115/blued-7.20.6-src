package com.bytedance.bdtracker;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/x3.class */
public interface x3 extends IInterface {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/x3$a.class */
    public static abstract class a extends Binder implements x3 {

        /* renamed from: com.bytedance.bdtracker.x3$a$a  reason: collision with other inner class name */
        /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/x3$a$a.class */
        public static class C0143a implements x3 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f7731a;

            public C0143a(IBinder iBinder) {
                this.f7731a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7731a;
            }
        }

        public static x3 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof x3)) ? new C0143a(iBinder) : (x3) queryLocalInterface;
        }
    }
}
