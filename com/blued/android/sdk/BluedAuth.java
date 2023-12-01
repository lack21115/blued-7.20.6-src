package com.blued.android.sdk;

import android.content.Context;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import com.blued.android.sdk.a.b;
import com.blued.android.sdk.a.c;
import com.blued.android.sdk.a.d;
import com.blued.android.sdk.a.e;
import com.blued.android.sdk.a.g;
import com.blued.android.sdk.model.BluedEntity;
import com.blued.android.sdk.model.ModelCallback;
import com.blued.android.sdk.model.TokenModel;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/BluedAuth.class */
public class BluedAuth {

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/BluedAuth$AuthCallback.class */
    public interface AuthCallback {
        void onCancel();

        void onFailed(int i);

        void onSuccess(String str, int i);
    }

    public static void handleResponse(Intent intent, AuthCallback authCallback) {
        if (authCallback != null && b.d.equals(intent.getAction())) {
            new b(authCallback).a(intent);
        }
    }

    public static boolean startAuth(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setAction(b.f18652c);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setPackage("com.soft.blued");
        intent.putExtra("app_key", str);
        intent.putExtra("secret_key", str2);
        intent.putExtra("pkg_name", context.getPackageName());
        if (!g.a(context, intent)) {
            g.a(context);
            return false;
        }
        intent.setFlags(67108864);
        context.startActivity(intent);
        return true;
    }

    public static void updateToken(String str, String str2, String str3, ModelCallback<TokenModel> modelCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        HashMap hashMap = new HashMap();
        hashMap.put(ExifInterface.GPS_DIRECTION_TRUE, valueOf);
        hashMap.put("access_token", str3);
        c.a(e.a(d.a() + "/oauth2/refresh", hashMap), e.a(str, str2, str3, valueOf), new TypeToken<BluedEntity<TokenModel>>() { // from class: com.blued.android.sdk.BluedAuth.1
        }.getType(), modelCallback);
    }
}
