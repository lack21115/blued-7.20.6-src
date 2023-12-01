package com.kwad.components.offline.tk;

import android.content.Context;
import com.kwad.components.core.offline.init.DefaultOfflineCompo;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaView;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.tk.kwai.g;
import com.kwad.sdk.components.l;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/tk/TkCompoImpl.class */
public class TkCompoImpl extends DefaultOfflineCompo implements com.kwad.components.core.offline.api.a.c {
    private final ITkOfflineCompo mOfflineCompo;

    public TkCompoImpl(ITkOfflineCompo iTkOfflineCompo) {
        super(iTkOfflineCompo);
        this.mOfflineCompo = iTkOfflineCompo;
    }

    @Override // com.kwad.components.core.offline.api.a.c
    public StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i) {
        return this.mOfflineCompo.checkStyleTemplateById(context, str, str2, str3, i);
    }

    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        return TkCompoImpl.class;
    }

    @Override // com.kwad.components.core.offline.api.a.c
    public String getJsBaseDir(Context context, String str) {
        return this.mOfflineCompo.getJsBaseDir(context, str);
    }

    @Override // com.kwad.components.core.offline.api.a.c
    public ITkOfflineCompo.TKState getState() {
        return this.mOfflineCompo.getState();
    }

    public String getTKVersion() {
        return this.mOfflineCompo.getTKVersion();
    }

    @Override // com.kwad.components.core.offline.api.a.c
    public l getView(Context context, String str, int i, int i2) {
        IOfflineCompoTachikomaView view = this.mOfflineCompo.getView(context, str, i, i2);
        if (view == null) {
            return null;
        }
        return new g(view);
    }

    @Override // com.kwad.components.core.offline.init.DefaultOfflineCompo, com.kwad.sdk.components.a
    public void init(Context context) {
    }

    @Override // com.kwad.components.core.offline.api.a.c
    public void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i, TKDownloadListener tKDownloadListener) {
        this.mOfflineCompo.loadTkFileByTemplateId(context, str, str2, str3, i, tKDownloadListener);
    }

    public void onConfigRefresh(Context context, JSONObject jSONObject) {
        this.mOfflineCompo.onConfigRefresh(context, jSONObject);
    }

    @Override // com.kwad.components.core.offline.api.a.c
    public void onDestroy() {
        this.mOfflineCompo.onDestroy();
    }
}
