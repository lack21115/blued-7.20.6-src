package c.t.m.g;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t6.class */
public class t6 {
    public static t6 e;
    public static boolean f = false;

    /* renamed from: a  reason: collision with root package name */
    public final File f3951a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f3952c;
    public HandlerThread d;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t6$a.class */
    public class a implements Runnable {
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t6$b.class */
    public final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public File f3953a;

        public b(Looper looper) {
            super(looper);
            this.f3953a = a();
        }

        public /* synthetic */ b(t6 t6Var, Looper looper, a aVar) {
            this(looper);
        }

        public final File a() {
            File file = t6.this.f3951a;
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, "dexlog");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            File file = this.f3953a;
            if (file == null || !"dexlog".equals(file.getName())) {
                this.f3953a = a();
            }
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.f3953a, true));
                bufferedOutputStream.write(message.obj.toString().getBytes("GBK"));
                bufferedOutputStream.flush();
            } catch (IOException e) {
                this.f3953a = null;
            }
        }
    }

    public t6(Context context, File file) {
        this.f3951a = file;
        boolean z = file != null && (file.exists() || file.mkdirs());
        this.b = z;
        if (z) {
            HandlerThread handlerThread = new HandlerThread("log_worker", 10);
            this.d = handlerThread;
            handlerThread.start();
            this.f3952c = new b(this, this.d.getLooper(), null);
        }
        if (f) {
            String str = "log dir=" + this.f3951a;
            boolean z2 = this.b;
        }
    }

    public static t6 a() {
        return e;
    }

    public static t6 a(Context context, File file) {
        if (e == null) {
            synchronized (t6.class) {
                try {
                    if (e == null) {
                        e = new t6(context, file);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    public void a(String str, int i, String str2) {
        if (b()) {
            this.f3952c.obtainMessage(1, DateFormat.format("yyyy-MM-dd kk:mm:ss", System.currentTimeMillis()) + ":" + str + ":" + str2 + "\n").sendToTarget();
        }
    }

    public final boolean b() {
        return this.b && this.f3952c != null;
    }
}
