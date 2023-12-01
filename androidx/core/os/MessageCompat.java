package androidx.core.os;

import android.os.Build;
import android.os.Message;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/MessageCompat.class */
public final class MessageCompat {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2466a = true;
    private static boolean b = true;

    private MessageCompat() {
    }

    public static boolean isAsynchronous(Message message) {
        if (Build.VERSION.SDK_INT >= 22) {
            return message.isAsynchronous();
        }
        if (!b || Build.VERSION.SDK_INT < 16) {
            return false;
        }
        try {
            return message.isAsynchronous();
        } catch (NoSuchMethodError e) {
            b = false;
            return false;
        }
    }

    public static void setAsynchronous(Message message, boolean z) {
        if (Build.VERSION.SDK_INT >= 22) {
            message.setAsynchronous(z);
        } else if (!f2466a || Build.VERSION.SDK_INT < 16) {
        } else {
            try {
                message.setAsynchronous(z);
            } catch (NoSuchMethodError e) {
                f2466a = false;
            }
        }
    }
}
