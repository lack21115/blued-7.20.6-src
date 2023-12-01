package com.kwad.components.offline.api.adLive;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.api.SdkConfig;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/adLive/IAdLiveOfflineCompo.class */
public interface IAdLiveOfflineCompo extends IOfflineCompo {
    public static final String IMPL = "com.kwad.sdk.AdLiveOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.adLive";

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/adLive/IAdLiveOfflineCompo$AdLiveState.class */
    public enum AdLiveState {
        READY,
        SO_FAIL
    }

    IAdLiveEndRequest getAdLiveEndRequest(String str);

    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2);

    AdLiveState getState();

    IAdLiveOfflineView getView(Context context, int i);

    void initReal(Context context, SdkConfig sdkConfig, IAdLiveOfflineCompoInitConfig iAdLiveOfflineCompoInitConfig, InitCallBack initCallBack);

    void onConfigRefresh(Context context, JSONObject jSONObject);
}
