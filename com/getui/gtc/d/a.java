package com.getui.gtc.d;

import android.os.Handler;
import android.os.HandlerThread;
import com.getui.gtc.BuildConfig;
import com.getui.gtc.api.GtcIdCallback;
import com.getui.gtc.api.SdkInfo;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.entity.a;
import com.getui.gtc.g.c;
import com.getui.gtc.i.d.b;
import com.getui.gtc.server.ServerManager;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/d/a.class */
public final class a {

    /* renamed from: a */
    final c f8316a;
    private final Handler b;

    /* renamed from: com.getui.gtc.d.a$a */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/d/a$a.class */
    public static final class C0172a {

        /* renamed from: a */
        private static final a f8321a = new a((byte) 0);
    }

    private a() {
        c cVar;
        b unused;
        HandlerThread handlerThread = new HandlerThread("Gtc HandlerThread");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper());
        cVar = c.a.f8418a;
        this.f8316a = cVar;
        com.getui.gtc.c.b.a();
        unused = b.a.f8430a;
        com.getui.gtc.a.a.a();
        this.b.post(new Runnable() { // from class: com.getui.gtc.d.a.3
            {
                a.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    SdkInfo.Builder psUrl = new SdkInfo.Builder().moduleName("GTC").version(BuildConfig.VERSION_NAME).appid(com.getui.gtc.c.b.f8313a).cid(com.getui.gtc.c.b.d).psUrl(String.format("%s/api.php?format=json&t=1", ServerManager.getServer("gtc.cs")));
                    try {
                        Class.forName("com.igexin.push.extension.distribution.gbd.stub.PushExtension");
                        psUrl.addStub("com.igexin.push.extension.distribution.gbd.stub.PushExtension", false);
                        Class.forName("com.igexin.push.extension.distribution.gws.stub.PushExtension");
                        psUrl.addStub("com.igexin.push.extension.distribution.gws.stub.PushExtension", false);
                    } catch (ClassNotFoundException e) {
                    }
                    a.this.f8316a.a(psUrl.build());
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.a(th);
                }
            }
        });
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public final String a(final GtcIdCallback gtcIdCallback) {
        this.b.post(new Runnable() { // from class: com.getui.gtc.d.a.1
            {
                a.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.getui.gtc.c.b.a(gtcIdCallback);
                } catch (Exception e) {
                    com.getui.gtc.i.c.a.b(e);
                }
            }
        });
        return com.getui.gtc.c.b.d;
    }

    public final void a(final SdkInfo sdkInfo) {
        this.b.post(new Runnable() { // from class: com.getui.gtc.d.a.2
            {
                a.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.f8316a.a(sdkInfo);
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.a(th);
                }
            }
        });
    }

    public final void a(final int[] iArr) {
        this.b.post(new Runnable() { // from class: com.getui.gtc.d.a.4
            {
                a.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.getui.gtc.entity.a a2;
                a.C0181a b;
                try {
                    if (iArr == null) {
                        return;
                    }
                    com.getui.gtc.i.c.a.a("remove gtcFile id: " + Arrays.toString(iArr));
                    int[] iArr2 = iArr;
                    int length = iArr2.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            return;
                        }
                        int i3 = iArr2[i2];
                        Map<String, Map<String, String>> a3 = com.getui.gtc.dyc.b.a.a(GtcProvider.context());
                        if (a3 == null) {
                            return;
                        }
                        Iterator<Map.Entry<String, Map<String, String>>> it = a3.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Map.Entry<String, Map<String, String>> next = it.next();
                            Map<String, String> value = next.getValue();
                            if (value != null && (a2 = com.getui.gtc.entity.a.a(value)) != null && (b = a2.b(i3)) != null) {
                                com.getui.gtc.i.c.a.a("found gtcFile id: " + i3 + ", remove it");
                                a.this.f8316a.a(b.f8396c);
                                a2.f8394a.remove(i3);
                                value.put("ext_infos", a2.a());
                                com.getui.gtc.dyc.b.a.a(GtcProvider.context(), next.getKey(), value);
                                break;
                            }
                        }
                        i = i2 + 1;
                    }
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.a(th);
                }
            }
        });
    }
}
