package s_a.s_a.s_a.a;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.anythink.core.api.ErrorCode;

/* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f44181a;
    public static boolean b;

    public static Context a(Context context) {
        Context context2 = context;
        if (context != null) {
            context2 = context;
            if (context.getApplicationContext() != null) {
                context2 = context.getApplicationContext();
            }
        }
        return context2;
    }

    public static boolean a() {
        String str;
        if (!f44181a) {
            str = ErrorCode.networkError;
        } else if (!b) {
            str = ErrorCode.serverError;
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            return true;
        } else {
            str = "1003";
        }
        Log.e("IDHelper", str);
        return false;
    }
}
