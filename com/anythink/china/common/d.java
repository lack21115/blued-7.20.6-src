package com.anythink.china.common;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.anythink.china.activity.TransparentActivity;
import java.util.Random;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/d.class */
public final class d {
    public static final String a = "android.permission.READ_PHONE_STATE";
    public static final String b = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/d$a.class */
    public interface a {
        void a();
    }

    private static void a(Context context, a aVar, String... strArr) {
        if (context == null || Build.VERSION.SDK_INT < 23) {
            Log.i("PermissionManager", "Build.VERSION.SDK_INT below 23 does not require permission");
            return;
        }
        int nextInt = new Random().nextInt(1000000000);
        if (aVar != null) {
            TransparentActivity.e.put(Integer.valueOf(nextInt), aVar);
        }
        Intent intent = new Intent(context, TransparentActivity.class);
        intent.putExtra("type", 1000);
        intent.putExtra(TransparentActivity.b, nextInt);
        intent.putExtra(TransparentActivity.d, strArr);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static boolean a(Context context, String str) {
        try {
            return ActivityCompat.checkSelfPermission(context, str) == 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
