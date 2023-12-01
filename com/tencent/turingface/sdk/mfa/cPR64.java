package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/cPR64.class */
public final class cPR64 extends RYhXO {
    public static final String b = kC0XR.a(kC0XR.i);

    @Override // com.tencent.turingface.sdk.mfa.RYhXO
    public final String a(IBinder iBinder) throws Exception {
        Context context;
        Signature[] signatureArr;
        synchronized (i3cNc.class) {
            try {
                context = i3cNc.f39958a;
            } catch (Throwable th) {
                throw th;
            }
        }
        String packageName = context.getPackageName();
        try {
            signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
        } catch (Throwable th2) {
            signatureArr = null;
        }
        String str = null;
        if (signatureArr != null) {
            str = null;
            if (signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(AppSigning.SHA1);
                    if (messageDigest == null) {
                        str = null;
                    } else {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        int length = digest.length;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= length) {
                                break;
                            }
                            sb.append(Integer.toHexString((digest[i2] & 255) | 256).substring(1, 3));
                            i = i2 + 1;
                        }
                        str = sb.toString();
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    str = null;
                }
            }
        }
        String a2 = kC0XR.a(kC0XR.j);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(b);
            obtain.writeString(packageName);
            obtain.writeString(str);
            obtain.writeString(a2);
            iBinder.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
