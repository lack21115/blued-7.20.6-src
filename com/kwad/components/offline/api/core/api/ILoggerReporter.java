package com.kwad.components.offline.api.core.api;

import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/api/ILoggerReporter.class */
public interface ILoggerReporter {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/api/ILoggerReporter$Category.class */
    public @interface Category {
        public static final String APM_LOG = "ad_client_apm_log";
        public static final String ERROR_LOG = "ad_client_error_log";
    }

    void reportEvent(String str, BusinessType businessType, String str2, JSONObject jSONObject);
}
