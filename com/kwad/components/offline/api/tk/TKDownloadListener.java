package com.kwad.components.offline.api.tk;

import com.kwad.components.offline.api.tk.model.StyleTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/tk/TKDownloadListener.class */
public interface TKDownloadListener {
    void onFailed(String str);

    void onSuccess(StyleTemplate styleTemplate);
}
