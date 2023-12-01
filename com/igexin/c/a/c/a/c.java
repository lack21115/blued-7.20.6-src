package com.igexin.c.a.c.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.igexin.push.core.ServiceManager;
import com.igexin.sdk.IUserLoggerInterface;
import com.igexin.sdk.PushManager;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/c/a/c.class */
public final class c extends Handler implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9646a = "SERVER_LOG";

    /* renamed from: c  reason: collision with root package name */
    private static final String f9647c = "LogController";
    public b b;
    private Messenger d;
    private Messenger e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/c/a/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f9648a = new c((byte) 0);

        private a() {
        }
    }

    private c() {
        super(Looper.getMainLooper());
        this.b = new com.igexin.c.a.c.a.a();
    }

    /* synthetic */ c(byte b) {
        this();
    }

    public static c a() {
        return a.f9648a;
    }

    private void a(Context context, IUserLoggerInterface iUserLoggerInterface) {
        if (iUserLoggerInterface == null) {
            e.a(f9647c, "user logger register parameter can not be null!");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        a(applicationContext);
        this.b.a(iUserLoggerInterface);
        this.b.a();
        a("[LogController] Sdk version = " + PushManager.getInstance().getVersion(applicationContext));
    }

    public final void a(Context context) {
        com.igexin.c.a.c.a.a("try to bind log server", new Object[0]);
        try {
            Intent intent = new Intent(context, ServiceManager.getInstance().b(context));
            intent.setType(f9646a);
            context.bindService(intent, this, 1);
        } catch (Exception e) {
            e.a(f9647c, "bind service error = " + e.toString());
        }
    }

    public final void a(String str) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 2) {
            return;
        }
        String string = message.getData().getString(d.d);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!string.contains("\n")) {
            this.b.a(string);
            return;
        }
        String[] split = string.split("\n");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.b.a(split[i2]);
            i = i2 + 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.igexin.c.a.c.a.a("remote log service connected ", new Object[0]);
        try {
            this.e = new Messenger(iBinder);
            if (this.d == null) {
                this.d = new Messenger(this);
            }
            Message obtain = Message.obtain();
            obtain.replyTo = this.d;
            obtain.what = 1;
            this.e.send(obtain);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(f9647c, "Client sent Message to Service error = ".concat(String.valueOf(e)));
            a("Client sent Message to Service error = ".concat(String.valueOf(e)));
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.e = null;
    }
}
