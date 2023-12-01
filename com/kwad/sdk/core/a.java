package com.kwad.sdk.core;

import android.text.TextUtils;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a.class */
public final class a {
    private ConcurrentHashMap<String, DownloadParams> abw;
    private ConcurrentHashMap<String, AdTemplate> abx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a$a.class */
    public static final class C0553a {
        private static final a aby = new a((byte) 0);
    }

    private a() {
        this.abw = new ConcurrentHashMap<>();
        this.abx = new ConcurrentHashMap<>();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static a tS() {
        return C0553a.aby;
    }

    public final void a(String str, DownloadParams downloadParams) {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return;
        }
        this.abw.put(str, downloadParams);
        ((e) ServiceProvider.get(e.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, downloadParams.toJson().toString()).apply();
    }

    public final DownloadParams bu(String str) {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return null;
        }
        DownloadParams downloadParams = this.abw.get(str);
        if (downloadParams != null) {
            return downloadParams;
        }
        String string = ((e) ServiceProvider.get(e.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        DownloadParams downloadParams2 = new DownloadParams();
        try {
            downloadParams2.parseJson(new JSONObject(string));
            return downloadParams2;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            return null;
        }
    }

    public final void bv(String str) {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return;
        }
        this.abw.remove(str);
        ((e) ServiceProvider.get(e.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public final AdTemplate bw(String str) {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return null;
        }
        AdTemplate adTemplate = this.abx.get(str);
        if (adTemplate != null) {
            return adTemplate;
        }
        String string = ((e) ServiceProvider.get(e.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        AdTemplate adTemplate2 = new AdTemplate();
        try {
            adTemplate2.parseJson(new JSONObject(string));
            return adTemplate2;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void bx(String str) {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return;
        }
        this.abx.remove(str);
        ((e) ServiceProvider.get(e.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public final void c(String str, AdTemplate adTemplate) {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return;
        }
        this.abx.put(str, adTemplate);
        ((e) ServiceProvider.get(e.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, adTemplate.toJson().toString()).apply();
    }
}
