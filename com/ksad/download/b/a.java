package com.ksad.download.b;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.ksad.download.DownloadTask;
import com.ksad.download.c;
import com.kwad.sdk.api.proxy.app.DownloadService;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/ksad/download/b/a.class */
public class a extends com.kwad.sdk.i.a {
    private c bD;
    private Service bF;
    private final Map<String, Integer> bE = new ConcurrentHashMap();
    private final HandlerC0292a bG = new HandlerC0292a(this);

    /* renamed from: com.ksad.download.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/ksad/download/b/a$a.class */
    static final class HandlerC0292a extends Handler {
        final WeakReference<a> bH;

        public HandlerC0292a(a aVar) {
            this.bH = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = this.bH.get();
            if (aVar != null && message.what == 1) {
                if (aVar.bD == null || !aVar.bD.S()) {
                    sendEmptyMessageDelayed(1, 30000L);
                } else {
                    aVar.bF.stopSelf();
                }
            }
        }
    }

    private void b(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            int intExtra = intent.getIntExtra("download_service_type_tag", 0);
            String stringExtra = intent.getStringExtra("download_service_id_tag");
            DownloadTask.DownloadRequest downloadRequest = (DownloadTask.DownloadRequest) intent.getSerializableExtra("download_service_args_tag");
            Integer num = this.bE.get(stringExtra);
            if (intExtra == 1) {
                this.bE.put(stringExtra, Integer.valueOf(this.bD.a(downloadRequest, (com.ksad.download.a) null)));
            } else if (intExtra == 2) {
                this.bD.pause(num.intValue());
            } else if (intExtra == 3) {
                this.bD.resume(num.intValue());
            } else if (intExtra != 4) {
            } else {
                this.bD.cancel(num.intValue());
            }
        } catch (Exception e) {
        }
    }

    public static void register() {
        com.kwad.sdk.service.a.a(DownloadService.class, a.class);
    }

    @Override // com.kwad.sdk.i.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.bF = service;
        this.bD = c.M();
        this.bG.sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // com.kwad.sdk.i.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        b(intent);
        return super.onStartCommand(service, intent, i, i2);
    }
}
