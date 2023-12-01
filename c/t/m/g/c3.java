package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/c3.class */
public class c3 {
    public static Message a(Handler handler, int i, int i2, int i3, Object obj) {
        Message message = handler == null ? new Message() : handler.obtainMessage(i);
        message.what = i;
        message.arg1 = i2;
        message.arg2 = i3;
        message.obj = obj;
        return message;
    }

    public static void a(Handler handler, int i) {
        if (handler != null) {
            handler.removeMessages(i);
        }
    }

    public static boolean a(Handler handler) {
        return a(handler == null ? null : handler.getLooper());
    }

    public static boolean a(Handler handler, int i, long j) {
        return a(handler, handler == null ? null : handler.obtainMessage(i), j);
    }

    public static boolean a(Handler handler, Message message) {
        return a(handler, message, 0L);
    }

    public static boolean a(Handler handler, Message message, long j) {
        if (message == null || !a(handler)) {
            return false;
        }
        return handler.sendMessageDelayed(message, j);
    }

    public static boolean a(Handler handler, Runnable runnable) {
        return a(handler, runnable, 0L);
    }

    public static boolean a(Handler handler, Runnable runnable, long j) {
        if (runnable == null || !a(handler)) {
            return false;
        }
        return handler.postDelayed(runnable, j);
    }

    public static boolean a(Looper looper) {
        return looper != null && looper.getThread().isAlive();
    }

    public static void b(Handler handler) {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public static boolean b(Handler handler, int i) {
        return a(handler, i, 0L);
    }

    public static boolean b(Handler handler, int i, int i2, int i3, Object obj) {
        if (handler == null) {
            return false;
        }
        return a(handler, a(handler, i, i2, i3, obj));
    }
}
