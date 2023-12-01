package com.kwad.components.offline.api.tk;

import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/tk/TkLoggerReporter.class */
public final class TkLoggerReporter {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/tk/TkLoggerReporter$Holder.class */
    public static final class Holder {
        private static final TkLoggerReporter sInstance = new TkLoggerReporter();

        private Holder() {
        }
    }

    private TkLoggerReporter() {
    }

    public static TkLoggerReporter get() {
        return Holder.sInstance;
    }

    private void reportEvent(String str, String str2, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(str, BusinessType.TACHIKOMA, str2, jSONObject);
    }

    public final void reportTKDownload(String str, JSONObject jSONObject) {
        reportEvent(str, "ad_tk_download_performance", jSONObject);
    }

    public final void reportTKPerform(String str, JSONObject jSONObject) {
        reportEvent(str, "ad_tk_render_performance", jSONObject);
    }

    public final void reportTKSODownload(String str, JSONObject jSONObject) {
        reportEvent(str, "ad_tk_so_download_event", jSONObject);
    }

    public final void reportTKSOLoad(String str, JSONObject jSONObject) {
        reportEvent(str, "ad_tk_so_load_performence", jSONObject);
    }
}
