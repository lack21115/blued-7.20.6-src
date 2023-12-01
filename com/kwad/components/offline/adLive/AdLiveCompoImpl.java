package com.kwad.components.offline.adLive;

import android.content.Context;
import com.kwad.components.core.offline.init.DefaultOfflineCompo;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/adLive/AdLiveCompoImpl.class */
public class AdLiveCompoImpl extends DefaultOfflineCompo implements com.kwad.components.core.offline.api.kwai.a {
    private final IAdLiveOfflineCompo mOfflineCompo;

    public AdLiveCompoImpl(IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        super(iAdLiveOfflineCompo);
        this.mOfflineCompo = iAdLiveOfflineCompo;
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public IAdLiveEndRequest getAdLiveEndRequest(String str) {
        return this.mOfflineCompo.getAdLiveEndRequest(str);
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2) {
        return this.mOfflineCompo.getAdLivePlayModule(iAdLiveOfflineView, str, str2);
    }

    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        return AdLiveCompoImpl.class;
    }

    public IAdLiveOfflineCompo.AdLiveState getState() {
        return this.mOfflineCompo.getState();
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public IAdLiveOfflineView getView(Context context, int i) {
        return this.mOfflineCompo.getView(context, i);
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public boolean hasLiveCompoReady() {
        return this.mOfflineCompo.getState() == IAdLiveOfflineCompo.AdLiveState.READY;
    }

    public void onConfigRefresh(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mOfflineCompo.onConfigRefresh(context, jSONObject);
        }
    }
}
