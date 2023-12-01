package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l1111l111111Il/l111l11111lIl.class */
public final class l111l11111lIl extends l111l1111lI1l {
    private Context l1111l111111Il;
    private final LinkedBlockingQueue<IBinder> l111l11111lIl = new LinkedBlockingQueue<>(1);
    private ServiceConnection l111l11111I1l = new ServiceConnection() { // from class: com.ishumei.l111l11111Il.l1111l111111Il.l111l11111lIl.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                l111l11111lIl.this.l111l11111lIl.put(iBinder);
            } catch (Exception e) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public l111l11111lIl(Context context) {
        this.l1111l111111Il = context;
    }

    @Override // com.ishumei.l111l11111Il.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        try {
            this.l1111l111111Il.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (this.l1111l111111Il.bindService(intent, this.l111l11111I1l, 1)) {
                try {
                    IBinder take = this.l111l11111lIl.take();
                    String str = null;
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                        take.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        String readString = obtain2.readString();
                        obtain.recycle();
                        str = readString;
                    } catch (Throwable th) {
                        try {
                            th.printStackTrace();
                            obtain.recycle();
                        } catch (Throwable th2) {
                            obtain.recycle();
                            obtain2.recycle();
                            throw th2;
                        }
                    }
                    obtain2.recycle();
                    this.l1111l111111Il.unbindService(this.l111l11111I1l);
                    return str;
                } catch (Exception e) {
                    this.l1111l111111Il.unbindService(this.l111l11111I1l);
                    return "";
                }
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
