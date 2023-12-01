package com.igexin.push.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.message.BindAliasCmdMessage;
import com.igexin.sdk.message.FeedbackCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.igexin.sdk.message.QueryTagCmdMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.igexin.sdk.message.UnBindAliasCmdMessage;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/l.class */
public final class l extends Handler implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23572a = "MsgServerSender";

    /* renamed from: c  reason: collision with root package name */
    private static volatile l f23573c;
    private static final int e = 1;
    private static final int f = 2;
    private static Context h;
    private final ConcurrentLinkedQueue<Intent> b;
    private final a d;
    private volatile Messenger g;
    private AtomicBoolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/l$a.class */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        static final int f23574a = 1;
        static final int b = 2;

        /* renamed from: c  reason: collision with root package name */
        static final int f23575c = 3;
        static final int d = 0;
        static final int e = 1;
        final Handler f;

        a() {
            HandlerThread handlerThread = new HandlerThread("GTIS-HANDLER");
            handlerThread.start();
            this.f = new Handler(handlerThread.getLooper()) { // from class: com.igexin.push.core.l.a.1
                @Override // android.os.Handler
                public final void handleMessage(Message message) {
                    if (message == null) {
                        return;
                    }
                    try {
                        int i = message.what;
                        boolean z = true;
                        if (i == 1) {
                            if (l.this.a((IBinder) message.obj)) {
                                removeMessages(2);
                                removeMessages(3);
                                removeMessages(1);
                                l.a(l.this);
                            }
                        } else if (i == 2 || i == 3) {
                            l lVar = l.this;
                            if (message.arg1 != 0) {
                                z = false;
                            }
                            l.a(lVar, z);
                        }
                    } catch (Throwable th) {
                        l.this.i.set(false);
                        com.igexin.c.a.c.a.a(th);
                    }
                }
            };
        }

        private Handler a() {
            return this.f;
        }
    }

    private l() {
        super(Looper.getMainLooper());
        this.i = new AtomicBoolean(false);
        this.d = new a();
        this.b = new ConcurrentLinkedQueue<>();
        Message.obtain(this.d.f, 3, 1, 0).sendToTarget();
    }

    public static l a() {
        if (f23573c == null) {
            synchronized (l.class) {
                try {
                    if (f23573c == null) {
                        f23573c = new l();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f23573c;
    }

    private void a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", PushConsts.GET_SDKSERVICEPID);
        bundle.putInt("pid", i);
        a(bundle);
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        h = context.getApplicationContext();
        ServiceManager.b = context.getApplicationContext();
    }

    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        if (this.g == null) {
            com.igexin.c.a.c.a.a(f23572a, "realSend, remoteMessenger is null");
            com.igexin.c.a.c.a.a("MsgServerSender|realSend, remoteMessenger is null", new Object[0]);
        }
        Bundle extras = intent.getExtras();
        if (extras == null || extras.get("action") == null || !(extras.get("action") instanceof Integer)) {
            return;
        }
        com.igexin.c.a.c.a.a("MsgServerSender|realSend action = ".concat(String.valueOf(extras.getInt("action"))), new Object[0]);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = intent;
        try {
            this.g.send(obtain);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("MsgServerSender|realSend iservice error = " + e2.toString(), new Object[0]);
            if (e2 instanceof DeadObjectException) {
                Message.obtain(this.d.f, 2, 0, 0).sendToTarget();
            }
        }
    }

    static /* synthetic */ void a(l lVar) {
        while (!lVar.b.isEmpty()) {
            Intent poll = lVar.b.poll();
            if (poll != null) {
                lVar.a(poll);
            }
        }
    }

    static /* synthetic */ void a(l lVar, boolean z) {
        if (z && lVar.g != null) {
            lVar.g = null;
        }
        if (lVar.i.get()) {
            return;
        }
        com.igexin.c.a.c.a.a("MsgServerSender|try to bind iservice", new Object[0]);
        try {
            lVar.i.set(true);
            if (e.l == null) {
                e.l = h;
            }
            Intent intent = new Intent(e.l, ServiceManager.getInstance().c(e.l));
            intent.setType(e.l.getPackageName());
            e.l.bindService(intent, lVar, 1);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.e.a(f23572a, "bind iservice error = " + th.toString());
            com.igexin.c.a.c.a.a(th);
            lVar.i.set(false);
        }
    }

    private void a(String str, String str2, String str3, String str4, long j) {
        if (e.f23495a != null && e.f23495a.equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 10010);
            bundle.putSerializable(PushConsts.KEY_CMD_MSG, new FeedbackCmdMessage(str2, str3, str4, j, PushConsts.THIRDPART_FEEDBACK));
            a(bundle);
        }
        Intent d = d();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("action", PushConsts.THIRDPART_FEEDBACK);
        bundle2.putString("appid", str);
        bundle2.putString("taskid", str2);
        bundle2.putString("actionid", str3);
        bundle2.putString("result", str4);
        bundle2.putLong("timestamp", j);
        d.putExtras(bundle2);
        e.l.sendBroadcast(d);
    }

    private static void a(String str, String str2, String str3, byte[] bArr) {
        Intent intent = new Intent();
        intent.setAction(b.G.concat(String.valueOf(str3)));
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10001);
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("appid", str3);
        bundle.putString("payloadid", str2 + ":" + str);
        bundle.putString("packagename", e.g);
        bundle.putByteArray("payload", bArr);
        intent.putExtras(bundle);
        intent.setPackage(e.l.getPackageName());
        e.l.sendBroadcast(intent);
    }

    private void a(boolean z) {
        if (z && this.g != null) {
            this.g = null;
        }
        if (this.i.get()) {
            return;
        }
        com.igexin.c.a.c.a.a("MsgServerSender|try to bind iservice", new Object[0]);
        try {
            this.i.set(true);
            if (e.l == null) {
                e.l = h;
            }
            Intent intent = new Intent(e.l, ServiceManager.getInstance().c(e.l));
            intent.setType(e.l.getPackageName());
            e.l.bindService(intent, this, 1);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.e.a(f23572a, "bind iservice error = " + th.toString());
            com.igexin.c.a.c.a.a(th);
            this.i.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(IBinder iBinder) {
        if (iBinder == null) {
            this.i.set(false);
            return false;
        }
        try {
            this.g = new Messenger(iBinder);
            this.i.set(false);
            return true;
        } catch (Throwable th) {
            this.i.set(false);
            throw th;
        }
    }

    private void b(Intent intent) {
        if (this.g != null) {
            a(intent);
            return;
        }
        this.b.add(intent);
        Message.obtain(this.d.f, 2, 1, 0).sendToTarget();
    }

    public static Intent d() {
        Intent intent = new Intent();
        intent.setAction(b.G + e.f23495a);
        intent.setPackage(e.l.getPackageName());
        return intent;
    }

    private void e() {
        this.g = null;
    }

    private void f() {
        if (this.i.get()) {
            return;
        }
        com.igexin.c.a.c.a.a("MsgServerSender|try to bind iservice", new Object[0]);
        try {
            this.i.set(true);
            if (e.l == null) {
                e.l = h;
            }
            Intent intent = new Intent(e.l, ServiceManager.getInstance().c(e.l));
            intent.setType(e.l.getPackageName());
            e.l.bindService(intent, this, 1);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.e.a(f23572a, "bind iservice error = " + th.toString());
            com.igexin.c.a.c.a.a(th);
            this.i.set(false);
        }
    }

    private void g() {
        Message obtain = Message.obtain();
        obtain.what = 2;
        try {
            this.g.send(obtain);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("MsgServerSender|send clent to iservice error = " + e2.toString(), new Object[0]);
            if (e2 instanceof DeadObjectException) {
                Message.obtain(this.d.f, 2, 0, 0).sendToTarget();
            }
        }
    }

    private void h() {
        while (!this.b.isEmpty()) {
            Intent poll = this.b.poll();
            if (poll != null) {
                a(poll);
            }
        }
    }

    private void i() {
        Bundle bundle = new Bundle();
        bundle.putInt("action", PushConsts.ACTION_NOTIFICATION_ENABLE);
        a(bundle);
    }

    private static Class j() {
        return ServiceManager.getInstance().c(e.l);
    }

    public final void a(Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        b(intent);
    }

    public final void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10013);
        bundle.putString(PushConsts.KEY_DEVICE_TOKEN, str);
        a(bundle);
    }

    public final void a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new SetTagCmdMessage(str, str2, PushConsts.SET_TAG_RESULT));
        a(bundle);
    }

    public final void a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new QueryTagCmdMessage(str, str2, str3, 10012));
        a(bundle);
    }

    public final void a(String str, String str2, String str3, String str4) {
        byte[] msgExtra;
        com.igexin.c.a.c.a.a("startapp|broadcastPayload", new Object[0]);
        if (str4 != null) {
            msgExtra = str4.getBytes();
        } else {
            com.igexin.push.core.a.b.d();
            PushTaskBean pushTaskBean = e.ah.get(com.igexin.push.core.a.b.a(str, str2));
            msgExtra = pushTaskBean != null ? pushTaskBean.getMsgExtra() : null;
        }
        if (msgExtra == null) {
            com.igexin.c.a.c.a.a("startapp|broadcast|payload is empty!", new Object[0]);
            return;
        }
        new String(msgExtra);
        com.igexin.c.a.c.a.a("startapp|broadcast|payload = " + new String(msgExtra), new Object[0]);
        if (e.f23495a != null && e.f23495a.equals(str3)) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 10001);
            bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(str, str2, str2 + ":" + str, msgExtra));
            a(bundle);
        }
        Intent intent = new Intent();
        intent.setAction(b.G.concat(String.valueOf(str3)));
        Bundle bundle2 = new Bundle();
        bundle2.putInt("action", 10001);
        bundle2.putString("taskid", str);
        bundle2.putString("messageid", str2);
        bundle2.putString("appid", str3);
        bundle2.putString("payloadid", str2 + ":" + str);
        bundle2.putString("packagename", e.g);
        bundle2.putByteArray("payload", msgExtra);
        intent.putExtras(bundle2);
        intent.setPackage(e.l.getPackageName());
        e.l.sendBroadcast(intent);
    }

    public final void b() {
        Bundle bundle = new Bundle();
        bundle.putInt("action", PushConsts.GET_SDKONLINESTATE);
        bundle.putBoolean(PushConsts.KEY_ONLINE_STATE, e.u);
        a(bundle);
        Intent d = d();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("action", PushConsts.GET_SDKONLINESTATE);
        bundle2.putBoolean(PushConsts.KEY_ONLINE_STATE, e.u);
        d.putExtras(bundle2);
        e.l.sendBroadcast(d);
    }

    public final void b(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new BindAliasCmdMessage(str, str2, 10010));
        a(bundle);
    }

    public final void b(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10011);
        bundle.putSerializable("notification_arrived", new GTNotificationMessage(str, str2, str3, str4));
        a(bundle);
    }

    public final void c() {
        com.igexin.c.a.c.a.b(f23572a, "broadcastClientId|" + e.A);
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10002);
        bundle.putString(PushConsts.KEY_CLIENT_ID, e.A);
        a(bundle);
        Intent d = d();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("action", 10002);
        bundle2.putString(PushConsts.KEY_CLIENT_ID, e.A);
        d.putExtras(bundle2);
        e.l.sendBroadcast(d);
    }

    public final void c(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new UnBindAliasCmdMessage(str, str2, 10011));
        a(bundle);
    }

    public final void c(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10012);
        bundle.putSerializable(PushConsts.KEY_NOTIFICATION_CLICKED, new GTNotificationMessage(str, str2, str3, str4));
        a(bundle);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        super.handleMessage(message);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.igexin.c.a.c.a.a("MsgServerSender|remote iservice connected ", new Object[0]);
        Message.obtain(this.d.f, 1, iBinder).sendToTarget();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.igexin.c.a.c.a.a("MsgServerSender|remote iservice disConnected ~~~", new Object[0]);
        this.i.set(false);
        this.g = null;
    }
}
