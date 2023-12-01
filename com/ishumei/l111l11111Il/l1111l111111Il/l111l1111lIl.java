package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l1111l111111Il/l111l1111lIl.class */
public final class l111l1111lIl extends l111l1111lI1l {
    private Context l1111l111111Il;
    private final LinkedBlockingQueue<IBinder> l111l11111lIl = new LinkedBlockingQueue<>(1);
    private ServiceConnection l111l11111I1l = new ServiceConnection() { // from class: com.ishumei.l111l11111Il.l1111l111111Il.l111l1111lIl.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                l111l1111lIl.this.l111l11111lIl.put(iBinder);
            } catch (Throwable th) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public l111l1111lIl(Context context) {
        this.l1111l111111Il = context;
    }

    private static String l1111l111111Il(Context context, String str) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return "";
            }
            byte[] byteArray = signatureArr[0].toByteArray();
            MessageDigest messageDigest = MessageDigest.getInstance(AppSigning.SHA1);
            if (messageDigest != null) {
                byte[] digest = messageDigest.digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                }
                return sb.toString();
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    private String l1111l111111Il(IBinder iBinder) {
        String packageName = this.l1111l111111Il.getPackageName();
        String l1111l111111Il = l1111l111111Il(this.l1111l111111Il, packageName);
        try {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            obtain.writeString(packageName);
            obtain.writeString(l1111l111111Il);
            obtain.writeString("OUID");
            iBinder.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            try {
                obtain.recycle();
                obtain2.recycle();
                return readString;
            } catch (Exception e) {
                return readString;
            }
        } catch (Exception e2) {
            return "";
        }
    }

    @Override // com.ishumei.l111l11111Il.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = "";
        String str2 = str;
        if (this.l1111l111111Il.bindService(intent, this.l111l11111I1l, 1)) {
            try {
                str2 = l1111l111111Il(this.l111l11111lIl.take());
                str = str2;
                this.l1111l111111Il.unbindService(this.l111l11111I1l);
            } catch (Throwable th) {
                return str;
            }
        }
        return str2;
    }
}
