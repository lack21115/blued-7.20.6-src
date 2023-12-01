package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l1111l111111Il/l1111l111111Il.class */
public final class l1111l111111Il extends l111l1111lI1l {
    private Context l1111l111111Il;
    private final LinkedBlockingQueue<IBinder> l111l11111lIl = new LinkedBlockingQueue<>(1);
    private ServiceConnection l111l11111I1l = new ServiceConnection() { // from class: com.ishumei.l111l11111Il.l1111l111111Il.l1111l111111Il.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                l1111l111111Il.this.l111l11111lIl.put(iBinder);
            } catch (Exception e) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public l1111l111111Il(Context context) {
        this.l1111l111111Il = context;
    }

    @Override // com.ishumei.l111l11111Il.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        String str;
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        String str2 = "";
        if (this.l1111l111111Il.bindService(intent, this.l111l11111I1l, 1)) {
            String str3 = "";
            try {
                IBinder take = this.l111l11111lIl.take();
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                String str4 = "";
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    take.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                    str4 = str;
                    this.l1111l111111Il.unbindService(this.l111l11111I1l);
                } catch (Throwable th) {
                    str = str4;
                }
                String str5 = str;
                obtain.recycle();
                str3 = str;
                obtain2.recycle();
                str2 = str;
            } catch (Exception e) {
                return str3;
            }
        }
        return str2;
    }
}
