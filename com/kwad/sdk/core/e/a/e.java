package com.kwad.sdk.core.e.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/a/e.class */
public interface e extends IInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/a/e$a.class */
    public static final class a implements e {
        private IBinder ahN;

        public a(IBinder iBinder) {
            this.ahN = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.ahN;
        }

        public final String getID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                this.ahN.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Exception e) {
                obtain2.recycle();
                obtain.recycle();
                return null;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
    }
}
