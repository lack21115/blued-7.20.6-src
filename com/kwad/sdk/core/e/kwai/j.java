package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.f;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/kwai/j.class */
public final class j {
    public Context mContext;
    private final LinkedBlockingQueue<IBinder> ahG = new LinkedBlockingQueue<>(1);
    private ServiceConnection ahE = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.j.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                j.this.ahG.put(iBinder);
            } catch (Exception e) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public j(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str;
        Context context;
        String str2 = "";
        String str3 = str2;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", this.mContext.getPackageName());
            boolean bindService = this.mContext.bindService(intent, this.ahE, 1);
            str3 = str2;
            new StringBuilder("getOAID isBind=").append(bindService);
            if (bindService) {
                String str4 = str2;
                try {
                    str = new f.a(this.ahG.take()).getOAID();
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
