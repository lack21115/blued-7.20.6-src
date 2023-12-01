package com.kwad.components.core.offline.api.a;

import android.content.Context;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.l;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/offline/api/a/c.class */
public interface c extends com.kwad.sdk.components.a {
    StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i);

    String getJsBaseDir(Context context, String str);

    ITkOfflineCompo.TKState getState();

    l getView(Context context, String str, int i, int i2);

    void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i, TKDownloadListener tKDownloadListener);

    void onDestroy();
}
