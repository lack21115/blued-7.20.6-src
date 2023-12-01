package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.b;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/kwai/b.class */
public final class b {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> ahG = new LinkedBlockingQueue<>(1);
    private ServiceConnection ahE = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.ahG.put(iBinder);
            } catch (Exception e) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getOAID() {
        Context context;
        StringBuilder sb = "";
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            sb = "";
            if (this.mContext.bindService(intent, this.ahE, 1)) {
                String str = "";
                String str2 = "";
                try {
                    b.a aVar = new b.a(this.ahG.take());
                    String wK = aVar.wK();
                    boolean wL = aVar.wL();
                    sb = new StringBuilder("getOAID oaid:");
                    sb.append(wK);
                    sb.append("--boos:");
                    str = wK;
                    str2 = wK;
                    sb.append(wL);
                    context = this.mContext;
                    str2 = wK;
                } catch (Exception e) {
                    String str3 = str2;
                    context = this.mContext;
                } catch (Throwable th) {
                    this.mContext.unbindService(this.ahE);
                    String str4 = str;
                    throw th;
                }
                context.unbindService(this.ahE);
                return str2;
            }
            return "";
        } catch (Exception e2) {
            return sb;
        }
    }
}
