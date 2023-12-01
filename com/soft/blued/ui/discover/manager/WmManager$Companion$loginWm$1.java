package com.soft.blued.ui.discover.manager;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.google.gson.Gson;
import com.soft.blued.ui.discover.model.WmLoginModel;
import com.soft.blued.ui.discover.model.WmModel;
import com.web.library.groups.webviewsdk.core.WebViewSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/manager/WmManager$Companion$loginWm$1.class */
public final class WmManager$Companion$loginWm$1 extends StringHttpResponseHandler {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String str) {
        WmLoginModel wmLoginModel;
        Gson gson = new Gson();
        WebViewSdk webViewSdk = WebViewSdk.getInstance();
        WmModel wmModel = (WmModel) gson.fromJson(str, (Class<Object>) WmModel.class);
        String str2 = null;
        if (wmModel != null && (wmLoginModel = wmModel.data) != null) {
            str2 = wmLoginModel.appTicket;
        }
        webViewSdk.setAppTicket(str2);
    }

    /* renamed from: a */
    public void onSuccess(final String str) {
        Log.v("drb", String.valueOf(Intrinsics.a("loginWm:", str)));
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.soft.blued.ui.discover.manager.-$$Lambda$WmManager$Companion$loginWm$1$TkZVxIS70NPdE20KKaHFdhvp18I
            @Override // java.lang.Runnable
            public final void run() {
                WmManager$Companion$loginWm$1.b(str);
            }
        });
    }
}
