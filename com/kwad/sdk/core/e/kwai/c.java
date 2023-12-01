package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.c;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/kwai/c.class */
public final class c {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> ahG = new LinkedBlockingQueue<>(1);
    private ServiceConnection ahE = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.c.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                c.this.ahG.put(iBinder);
            } catch (Exception e) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public c(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str;
        Context context;
        String str2 = "";
        String str3 = str2;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            str3 = str2;
            if (this.mContext.bindService(intent, this.ahE, 1)) {
                try {
                    str = new c.a(this.ahG.take()).getOaid();
                    str2 = str;
                    new StringBuilder("getOAID oaid:").append(str);
                    context = this.mContext;
                } catch (Exception e) {
                    String str4 = str2;
                    str = str2;
                    context = this.mContext;
                }
                str3 = str;
                context.unbindService(this.ahE);
                return str;
            }
            return "";
        } catch (Exception e2) {
            return str3;
        }
    }
}
