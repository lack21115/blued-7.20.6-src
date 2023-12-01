package com.soft.blued.ui.discover.manager;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.google.gson.Gson;
import com.soft.blued.ui.discover.manager.WmManager;
import com.soft.blued.ui.discover.model.WmModel;
import com.soft.blued.utils.BluedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/manager/WmManager$Companion$getAccessToken$1.class */
public final class WmManager$Companion$getAccessToken$1 extends StringHttpResponseHandler {
    WmManager$Companion$getAccessToken$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String str) {
        String str2 = ((WmModel) new Gson().fromJson(str, (Class<Object>) WmModel.class)).access_token;
        BluedPreferences.aq(str2);
        WmManager.Companion companion = WmManager.f16153a;
        Intrinsics.c(str2, "token");
        companion.a(str2);
        WmManager.f16153a.b(str2);
    }

    /* renamed from: a */
    public void onSuccess(final String str) {
        Log.v("drb", String.valueOf(Intrinsics.a("getAccessToken:", str)));
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.soft.blued.ui.discover.manager.-$$Lambda$WmManager$Companion$getAccessToken$1$-gW966dkHuD1gGH9Aew5oCDLfEg
            @Override // java.lang.Runnable
            public final void run() {
                WmManager$Companion$getAccessToken$1.b(str);
            }
        });
    }
}
