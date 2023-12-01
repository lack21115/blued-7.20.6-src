package com.getui.gtc.g.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Pair;
import com.igexin.push.GtPushInterface;
import com.kuaishou.weapon.p0.t;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/g/a/a.class */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static PackageInfo f22010c;

    /* renamed from: a  reason: collision with root package name */
    Handler f22011a;
    public GtPushInterface b;

    public a(final b bVar) {
        final HandlerThread handlerThread = new HandlerThread("Plugin Handler Thread");
        handlerThread.start();
        this.f22011a = new Handler(handlerThread.getLooper()) { // from class: com.getui.gtc.g.a.a.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                try {
                } catch (Exception e) {
                    com.getui.gtc.i.c.a.a(e);
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(false);
                    }
                }
                if (message.what < 0) {
                    if (bVar != null) {
                        bVar.a(false);
                        return;
                    }
                    return;
                }
                boolean loadSdk = a.this.b.loadSdk(message.getData());
                if (bVar != null) {
                    bVar.a(loadSdk);
                }
                handlerThread.quit();
                a.this.f22011a = null;
            }
        };
    }

    public static Pair<ServiceInfo, Class> a(Context context, Class cls) {
        boolean z;
        try {
            if (f22010c == null) {
                f22010c = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
            }
            ServiceInfo[] serviceInfoArr = f22010c.services;
            if (serviceInfoArr != null && serviceInfoArr.length > 0) {
                int length = serviceInfoArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    ServiceInfo serviceInfo = serviceInfoArr[i2];
                    try {
                        Class<?> cls2 = Class.forName(serviceInfo.name);
                        if (cls2 == cls) {
                            continue;
                        } else {
                            Class<? super Object> cls3 = cls2;
                            for (int i3 = 5; cls3 != null && cls != null && i3 > 0; i3--) {
                                if (cls3 == cls) {
                                    z = true;
                                    break;
                                } else if (cls3.getSuperclass() == null) {
                                    break;
                                } else {
                                    cls3 = cls3.getSuperclass();
                                }
                            }
                            z = false;
                            if (z) {
                                return Pair.create(serviceInfo, cls2);
                            }
                            continue;
                        }
                    } catch (Throwable th) {
                    }
                    i = i2 + 1;
                }
            }
        } catch (Throwable th2) {
            com.getui.gtc.i.c.a.a(" findGtImplClassInManifest error", th2);
        }
        return Pair.create(null, null);
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        Bundle bundle = new Bundle();
        bundle.putString(t.q, str);
        bundle.putString("od", str2);
        bundle.putString(AdvanceSetting.CLEAR_NOTIFICATION, str3);
        bundle.putString("ad", str4);
        bundle.putString("gd", str5);
        Message obtain = Message.obtain();
        obtain.setData(bundle);
        obtain.what = 0;
        Handler handler = this.f22011a;
        if (handler != null) {
            obtain.setTarget(handler);
            obtain.sendToTarget();
        }
    }
}
