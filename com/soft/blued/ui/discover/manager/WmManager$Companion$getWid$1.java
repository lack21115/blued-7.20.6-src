package com.soft.blued.ui.discover.manager;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.google.gson.Gson;
import com.soft.blued.ui.discover.model.WmLoginModel;
import com.soft.blued.ui.discover.model.WmModel;
import com.soft.blued.utils.BluedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/manager/WmManager$Companion$getWid$1.class */
public final class WmManager$Companion$getWid$1 extends StringHttpResponseHandler {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String str) {
        WmLoginModel wmLoginModel = ((WmModel) new Gson().fromJson(str, (Class<Object>) WmModel.class)).data;
        BluedPreferences.ar(wmLoginModel == null ? null : wmLoginModel.superWid);
    }

    /* renamed from: a */
    public void onSuccess(final String str) {
        Log.v("drb", String.valueOf(Intrinsics.a("getWid:", str)));
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.soft.blued.ui.discover.manager.-$$Lambda$WmManager$Companion$getWid$1$EKIK0cvA7kughJtOfUsvCny1HC0
            @Override // java.lang.Runnable
            public final void run() {
                WmManager$Companion$getWid$1.b(str);
            }
        });
    }
}
