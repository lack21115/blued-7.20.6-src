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
        public static class C0140a implements f4 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f7613a;

            public C0140a(IBinder iBinder) {
                this.f7613a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7613a;
            }
        }

        public static f4 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof f4)) ? new C0140a(iBinder) : (f4) queryLocalInterface;
        }
    }
}
