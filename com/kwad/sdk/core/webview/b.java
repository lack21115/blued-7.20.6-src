package com.kwad.sdk.core.webview;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.widget.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/b.class */
public final class b {
    public ViewGroup LD;
    public WebView Lc;
    public e app;
    public af apq;
    public boolean apr = true;
    public boolean aps = true;
    private List<AdTemplate> apt = null;
    public JSONObject mReportExtData;
    public int mScreenOrientation;

    public final AdTemplate getAdTemplate() {
        List<AdTemplate> list = this.apt;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.apt.get(0);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.apt = arrayList;
        arrayList.add(adTemplate);
        if (adTemplate.mPlayAgain != null) {
            this.apt.add(adTemplate.mPlayAgain);
        }
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (AdTemplate adTemplate : list) {
            arrayList.add(adTemplate);
        }
        this.apt = arrayList;
    }

    public final List<AdTemplate> yT() {
        return this.apt;
    }

    public final boolean yU() {
        List<AdTemplate> list = this.apt;
        return list == null || list.size() == 0;
    }
}
