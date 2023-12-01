package com.bytedance.bdtracker;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/f4.class */
public interface f4 extends IInterface {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/f4$a.class */
    public static abstract class a extends Binder implements f4 {

        /* renamed from: com.bytedance.bdtracker.f4$a$a  reason: collision with other inner class name */
        /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/f4$a$a.class */
        public static class C0310a implements f4 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f21219a;

            public C0310a(IBinder iBinder) {
                this.f21219a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21219a;
            }
        }

        public static f4 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof f4)) ? new C0310a(iBinder) : (f4) queryLocalInterface;
        }
    }
}
