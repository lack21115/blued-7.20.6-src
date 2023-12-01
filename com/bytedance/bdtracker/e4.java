package com.bytedance.bdtracker;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/e4.class */
public interface e4 extends IInterface {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/e4$a.class */
    public static abstract class a extends Binder implements e4 {

        /* renamed from: com.bytedance.bdtracker.e4$a$a  reason: collision with other inner class name */
        /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/e4$a$a.class */
        public static class C0309a implements e4 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f21213a;

            public C0309a(IBinder iBinder) {
                this.f21213a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21213a;
            }
        }

        public static e4 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof e4)) ? new C0309a(iBinder) : (e4) queryLocalInterface;
        }
    }
}
