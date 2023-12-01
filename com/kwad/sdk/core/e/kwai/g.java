package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.e;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/kwai/g.class */
public final class g {
    private final LinkedBlockingQueue<IBinder> ahD = new LinkedBlockingQueue<>(1);
    private ServiceConnection ahE = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.g.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                g.this.ahD.put(iBinder);
            } catch (Exception e) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str;
        Context context;
        String str2 = "";
        String str3 = str2;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            str3 = str2;
            if (this.mContext.bindService(intent, this.ahE, 1)) {
                String str4 = str2;
                try {
                    str = new e.a(this.ahD.take()).getID();
                    str4 = str;
                    str2 = str;
                    new StringBuilder("getOAID oaid:").append(str);
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
