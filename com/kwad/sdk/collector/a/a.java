package com.kwad.sdk.collector.a;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.webkit.WebView;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.f;
import com.kwad.sdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/a/a.class */
public class a extends com.kwad.sdk.i.a {
    private static AtomicBoolean abn = new AtomicBoolean(false);
    public static volatile Message abo;
    private HandlerC0381a abl = new HandlerC0381a((byte) 0);
    private Messenger abm = new Messenger(this.abl);

    /* renamed from: com.kwad.sdk.collector.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/a/a$a.class */
    static final class HandlerC0381a extends Handler {
        private WeakReference<Service> abq;

        private HandlerC0381a() {
        }

        /* synthetic */ HandlerC0381a(byte b) {
            this();
        }

        public final void a(Service service) {
            if (service != null) {
                this.abq = new WeakReference<>(service);
            } else {
                this.abq = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            b.d("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.abq;
            Service service = weakReference != null ? weakReference.get() : null;
            if (service == null) {
                return;
            }
            if (!a.tN().get()) {
                b.d("RemoteService", "save buffered message");
                a.abo = Message.obtain(message);
                return;
            }
            final Messenger messenger = message.replyTo;
            int i = message.what;
            b.d("RemoteService", "handleMessage what: " + i);
            if (i != 100) {
                return;
            }
            final Bundle bundle = new Bundle();
            f.a(service, new f.b() { // from class: com.kwad.sdk.collector.a.a.a.1
                @Override // com.kwad.sdk.utils.f.b
                public final void l(List<com.kwad.sdk.collector.model.b> list) {
                    b.d("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                    if (list != null && !list.isEmpty()) {
                        b.d("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                        JSONArray z = f.a.z(list);
                        String str = null;
                        String jSONArray = z != null ? z.toString() : null;
                        b.d("RemoteService", "resultJson :" + jSONArray);
                        if (jSONArray != null) {
                            AppStatusRules CD = f.CD();
                            ArrayList<AppStatusRules.Strategy> allStrategy = CD != null ? CD.getAllStrategy() : null;
                            if (allStrategy != null) {
                                str = t.C(allStrategy).toString();
                            }
                            bundle.putString("resultJson", jSONArray);
                            bundle.putString("allStrategyJson", str);
                        }
                    }
                    try {
                        Message obtain = Message.obtain();
                        obtain.what = 101;
                        obtain.setData(bundle);
                        messenger.send(obtain);
                    } catch (RemoteException e) {
                    }
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    for (com.kwad.sdk.collector.model.b bVar : list) {
                        bVar.destroy();
                    }
                }
            });
        }
    }

    public static void a(Context context, ServiceConnection serviceConnection) {
        b.d("RemoteService", "bindASService");
        context.bindService(new Intent(context, ServiceProxyRemote.class), serviceConnection, 1);
    }

    private static boolean aC(Context context) {
        String processName = ap.getProcessName(context);
        return (processName == null || context.getPackageName().equals(processName)) ? false : true;
    }

    public static void b(Context context, ServiceConnection serviceConnection) {
        b.d("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            b.printStackTrace(e);
        }
    }

    public static void register() {
        try {
            com.kwad.sdk.service.a.a(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), a.class);
        } catch (Throwable th) {
        }
    }

    public static AtomicBoolean tN() {
        return abn;
    }

    @Override // com.kwad.sdk.i.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(Service service, Intent intent) {
        return this.abm.getBinder();
    }

    @Override // com.kwad.sdk.i.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(ap.getProcessName(service.getApplicationContext()));
            } catch (Exception e) {
                b.d("RemoteService", "WebView has already been initialized " + e.getMessage());
            }
        }
        b.d("RemoteService", "onCreate processName:" + ap.getProcessName(service));
        if (SystemUtil.isInMainProcess(service)) {
            abn.set(true);
        } else {
            d.a(service, new d.a() { // from class: com.kwad.sdk.collector.a.a.1
                @Override // com.kwad.sdk.collector.d.a
                public final void bo(String str) {
                    b.e("RemoteService", "onLoadError: " + str);
                    a.abn.set(false);
                }

                @Override // com.kwad.sdk.collector.d.a
                public final void onLoaded() {
                    b.d("RemoteService", "onLoaded");
                    a.abn.set(true);
                    if (a.abo != null) {
                        a.this.abl.handleMessage(a.abo);
                        a.abo = null;
                    }
                }
            });
        }
        this.abl.a(service);
    }

    @Override // com.kwad.sdk.i.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(Service service) {
        super.onDestroy(service);
        b.d("RemoteService", "onDestroy");
        this.abl.a(null);
        if (aC(service)) {
            b.d("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }
}
