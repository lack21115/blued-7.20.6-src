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
        String token = ((WmModel) new Gson().fromJson(str, (Class<Object>) WmModel.class)).access_token;
        BluedPreferences.aq(token);
        WmManager.Companion companion = WmManager.f29843a;
        Intrinsics.c(token, "token");
        companion.a(token);
        WmManager.f29843a.b(token);
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: a */
    public void onSuccess(final String str) {
        Log.v("drb", String.valueOf(Intrinsics.a("getAccessToken:", (Object) str)));
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.soft.blued.ui.discover.manager.-$$Lambda$WmManager$Companion$getAccessToken$1$-gW966dkHuD1gGH9Aew5oCDLfEg
            @Override // java.lang.Runnable
            public final void run() {
                WmManager$Companion$getAccessToken$1.b(String.this);
            }
        });
    }
}
