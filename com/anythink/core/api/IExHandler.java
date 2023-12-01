package com.anythink.core.api;

import android.content.Context;
import com.anythink.core.c.a;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.f.b;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/IExHandler.class */
public interface IExHandler {
    boolean checkDebuggerDevice(Context context, String str);

    int checkDownloadType(i iVar, j jVar);

    ATEventInterface createDownloadListener(ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd, ATEventInterface aTEventInterface);

    String fillCDataParam(String str);

    void fillRequestData(JSONObject jSONObject, a aVar);

    void fillRequestDeviceData(JSONObject jSONObject, int i);

    void fillTestDeviceData(JSONObject jSONObject, a aVar);

    String getUniqueId(Context context);

    void handleOfferClick(Context context, j jVar, i iVar, String str, String str2, Runnable runnable, b bVar);

    void initDeviceInfo(Context context);

    void openApkConfirmDialog(Context context, i iVar, j jVar, com.anythink.core.common.f.a aVar);
}
