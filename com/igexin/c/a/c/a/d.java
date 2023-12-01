package com.igexin.c.a.c.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.igexin.push.core.ServiceManager;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/c/a/d.class */
public class d extends Handler {
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9649c = 2;
    public static final String d = "log_data";
    private static final String e = d.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public final Messenger f9650a;
    private final StringBuffer f;
    private Messenger g;

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/c/a/d$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final d f9651a = new d((byte) 0);

        private a() {
        }
    }

    private d() {
        super(Looper.getMainLooper());
        this.f9650a = new Messenger(this);
        this.f = new StringBuffer();
    }

    /* synthetic */ d(byte b2) {
        this();
    }

    public static d a() {
        return a.f9651a;
    }

    private void a(Message message) {
        this.g = message.replyTo;
        try {
            if (this.f.length() > 0) {
                b(this.f.toString());
                this.f.setLength(0);
                this.f.trimToSize();
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void b(String str) {
        try {
            Message obtain = Message.obtain();
            obtain.what = 2;
            Bundle bundle = new Bundle();
            bundle.putString(d, str);
            obtain.setData(bundle);
            this.g.send(obtain);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private boolean b() {
        return this.f.length() > 0;
    }

    private IBinder c() {
        return this.f9650a.getBinder();
    }

    public final void a(String str) {
        if (com.igexin.push.f.c.a(ServiceManager.b)) {
            if (this.g != null) {
                b(str);
            } else if (this.f.length() + str.length() < 2560) {
                StringBuffer stringBuffer = this.f;
                stringBuffer.append(str);
                stringBuffer.append("\n");
            } else if (this.f.length() > 2560 || this.f.length() + 135 <= 2560) {
            } else {
                StringBuffer stringBuffer2 = this.f;
                stringBuffer2.append("Warning! the log cache is too long to show the full content,we suggest you call initialize and setDebugLogger in a short time interval.");
                stringBuffer2.append("\n");
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z = true;
        if (message.what != 1) {
            super.handleMessage(message);
            return;
        }
        this.g = message.replyTo;
        try {
            if (this.f.length() <= 0) {
                z = false;
            }
            if (z) {
                b(this.f.toString());
                this.f.setLength(0);
                this.f.trimToSize();
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
