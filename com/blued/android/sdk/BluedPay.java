package com.blued.android.sdk;

import android.content.Context;
import android.content.Intent;
import com.blued.android.sdk.a.f;
import com.blued.android.sdk.a.g;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/BluedPay.class */
public class BluedPay {

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/BluedPay$PayCallback.class */
    public interface PayCallback {
        void onCancel();

        void onFailed(int i);

        void onSuccess(int i);
    }

    public static void handleResponse(Intent intent, PayCallback payCallback) {
        if (payCallback != null && f.d.equals(intent.getAction())) {
            new f(payCallback).a(intent);
        }
    }

    public static boolean pay(Context context, String str, String str2, String str3, int i) {
        Intent intent = new Intent();
        intent.setAction(f.f18660c);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setPackage("com.soft.blued");
        intent.putExtra("app_key", str);
        intent.putExtra("pkg_name", context.getPackageName());
        intent.putExtra("secret_key", str2);
        intent.putExtra("app_token", str3);
        intent.putExtra("goods_id", i);
        if (!g.a(context, intent)) {
            g.a(context);
            return false;
        }
        intent.setFlags(67108864);
        context.startActivity(intent);
        return true;
    }
}
