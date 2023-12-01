package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.d;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/kwai/f.class */
public final class f {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> ahG = new LinkedBlockingQueue<>(1);
    private ServiceConnection ahE = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.f.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                f.this.ahG.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public f(Context context) {
        this.mContext = context;
    }

    private String wJ() {
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 64);
            if (packageInfo == null) {
                return null;
            }
            Signature[] signatureArr = packageInfo.signatures;
            String str = null;
            if (signatureArr != null) {
                str = null;
                if (signatureArr.length > 0) {
                    byte[] digest = MessageDigest.getInstance(AppSigning.SHA1).digest(signatureArr[0].toByteArray());
                    StringBuilder sb = new StringBuilder();
                    for (byte b : digest) {
                        sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                    }
                    str = sb.toString();
                }
            }
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    public final String getOAID() {
        String str;
        Context context;
        String str2 = "";
        String str3 = str2;
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            boolean bindService = this.mContext.bindService(intent, this.ahE, 1);
            str3 = str2;
            new StringBuilder("getOAID isBin=").append(bindService);
            if (bindService) {
                String str4 = str2;
                try {
                    str = new d.a(this.ahG.take()).getSerID(this.mContext.getPackageName(), wJ(), "OUID");
                    str4 = str;
                    str2 = str;
                    new StringBuilder("getOAID oaid").append(str);
                    context = this.mContext;
                } catch (Exception e) {
                    String str5 = str2;
                    str = str2;
                    context = this.mContext;
                } catch (Throwable th) {
                    this.mContext.unbindService(this.ahE);
                    String str6 = str4;
                    throw th;
                }
                String str7 = str;
                context.unbindService(this.ahE);
                return str;
            }
            return "";
        } catch (Exception e2) {
            return str3;
        }
    }
}
