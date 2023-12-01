package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l1111l111111Il/l11l1111I11l.class */
public final class l11l1111I11l extends l111l1111lI1l {
    public final LinkedBlockingQueue<IBinder> l1111l111111Il = new LinkedBlockingQueue<>(1);
    private ServiceConnection l111l11111I1l = new ServiceConnection() { // from class: com.ishumei.l111l11111Il.l1111l111111Il.l11l1111I11l.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                l11l1111I11l.this.l1111l111111Il.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private Context l111l11111lIl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l11l1111I11l(Context context) {
        this.l111l11111lIl = context;
    }

    @Override // com.ishumei.l111l11111Il.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.l111l11111lIl.bindService(intent, this.l111l11111I1l, 1)) {
            String str = "";
            try {
                IBinder take = this.l1111l111111Il.take();
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                take.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                str = readString;
                this.l111l11111lIl.unbindService(this.l111l11111I1l);
                return readString;
            } catch (InterruptedException e) {
                return str;
            }
        }
        return "";
    }
}
