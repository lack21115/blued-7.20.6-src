package com.kwad.sdk.core.e.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/a/a.class */
public interface a extends IInterface {

    /* renamed from: com.kwad.sdk.core.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/a/a$a.class */
    public static final class C0562a implements a {
        private final IBinder ahM;

        public C0562a(IBinder iBinder) {
            this.ahM = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.ahM;
        }

        public final String getID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.ahM.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return readString;
            } catch (Exception e) {
                obtain.recycle();
                obtain2.recycle();
                return null;
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }
    }
}
