package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.vivo.push.PushClient;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.e;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.p;
import com.vivo.push.util.r;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/sdk/PushServiceReceiver.class */
public class PushServiceReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f41118a;
    private static Handler b;

    /* renamed from: c  reason: collision with root package name */
    private static a f41119c = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/vivo/push/sdk/PushServiceReceiver$a.class */
    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f41120a;
        private String b;

        a() {
        }

        static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f41120a = ContextDelegate.getContext(context);
            aVar.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo a2 = r.a(this.f41120a);
            if (!(a2 != null ? a2.isConnectedOrConnecting() : false)) {
                p.d("PushServiceReceiver", this.f41120a.getPackageName() + ": 无网络  by " + this.b);
                Context context = this.f41120a;
                p.a(context, "触发静态广播:无网络(" + this.b + "," + this.f41120a.getPackageName() + ")");
                return;
            }
            p.d("PushServiceReceiver", this.f41120a.getPackageName() + ": 执行开始出发动作: " + this.b);
            Context context2 = this.f41120a;
            p.a(context2, "触发静态广播(" + this.b + "," + this.f41120a.getPackageName() + ")");
            e.a().a(this.f41120a);
            if (ClientConfigManagerImpl.getInstance(this.f41120a).isCancleBroadcastReceiver()) {
                return;
            }
            try {
                PushClient.getInstance(this.f41120a).initialize();
            } catch (VivoPushException e) {
                e.printStackTrace();
                Context context3 = this.f41120a;
                p.a(context3, " 初始化异常 error= " + e.getMessage());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context context2 = ContextDelegate.getContext(context);
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || Intent.ACTION_POWER_CONNECTED.equals(action) || Intent.ACTION_POWER_DISCONNECTED.equals(action)) {
            if (f41118a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f41118a = handlerThread;
                handlerThread.start();
                b = new Handler(f41118a.getLooper());
            }
            p.d("PushServiceReceiver", context2.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + b);
            a.a(f41119c, context2, action);
            b.removeCallbacks(f41119c);
            b.postDelayed(f41119c, 2000L);
        }
    }
}
