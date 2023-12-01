package com.opos.cmn.func.dl.base.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.anythink.expressad.video.module.a.a.m;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/d/a.class */
public class a {
    private static final String d = a.class.getSimpleName();
    private static volatile a e;

    /* renamed from: a  reason: collision with root package name */
    public Context f11219a;
    public BroadcastReceiver b;

    /* renamed from: c  reason: collision with root package name */
    public List<c> f11220c = new ArrayList();
    private Handler f = new HandlerC0471a();

    /* renamed from: com.opos.cmn.func.dl.base.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/d/a$a.class */
    final class HandlerC0471a extends Handler {
        public HandlerC0471a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String str = a.d;
            com.opos.cmn.an.f.a.b(str, "mList size=" + a.this.f11220c.size());
            int i = message.what;
            if (i == 0) {
                for (c cVar : a.this.f11220c) {
                    cVar.b();
                }
            } else if (i == 1) {
                for (c cVar2 : a.this.f11220c) {
                    cVar2.a();
                }
            } else if (i == 2) {
                for (c cVar3 : a.this.f11220c) {
                    cVar3.c();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/d/a$b.class */
    public final class b extends BroadcastReceiver {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            NetworkInfo activeNetworkInfo;
            com.opos.cmn.an.f.a.b(a.d, "NetWorkReceiver onReceive");
            ConnectivityManager connectivityManager = (ConnectivityManager) a.this.f11219a.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                a.a(a.this, 2);
                return;
            }
            int type = activeNetworkInfo.getType();
            boolean z = type == 0;
            boolean z2 = type == 1;
            if (z) {
                a.a(a.this, 1);
            } else if (z2) {
                a.a(a.this, 0);
            }
            com.opos.cmn.an.f.a.b(a.d, "download net change to type:".concat(String.valueOf(type)));
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/d/a$c.class */
    public interface c {
        void a();

        void b();

        void c();
    }

    private a(Context context) {
        this.f11219a = context;
    }

    public static a a(Context context) {
        if (e == null) {
            synchronized (a.class) {
                try {
                    if (e == null) {
                        e = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    static /* synthetic */ void a(a aVar, int i) {
        aVar.a();
        aVar.f.sendEmptyMessageDelayed(i, m.ag);
    }

    public final void a() {
        this.f.removeCallbacksAndMessages(null);
    }
}
