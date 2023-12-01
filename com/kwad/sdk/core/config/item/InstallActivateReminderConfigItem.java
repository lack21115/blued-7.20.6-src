package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/InstallActivateReminderConfigItem.class */
public final class InstallActivateReminderConfigItem extends b<InstallActivateReminderConfig> {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/InstallActivateReminderConfigItem$InstallActivateReminderConfig.class */
    public static class InstallActivateReminderConfig extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -6457271849826128465L;
        public int noticeTotalCount = 3;
        public int perAppNoticeCount = 2;
        public int noticeAppearTime = 15000;
        public int noticeContinueTime = 15000;
    }

    public InstallActivateReminderConfigItem() {
        super("installActivateReminderConfig", new InstallActivateReminderConfig());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        JSONObject jSONObject;
        InstallActivateReminderConfig value = getValue();
        InstallActivateReminderConfig installActivateReminderConfig = value;
        if (value == null) {
            installActivateReminderConfig = new InstallActivateReminderConfig();
        }
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            jSONObject = null;
        }
        if (jSONObject != null) {
            installActivateReminderConfig.parseJson(jSONObject);
        }
        setValue(installActivateReminderConfig);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        String key;
        String str;
        if (getValue() == null || getValue().toJson() == null) {
            key = getKey();
            str = "";
        } else {
            key = getKey();
            str = getValue().toJson().toString();
        }
        editor.putString(key, str);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(uX());
            return;
        }
        InstallActivateReminderConfig installActivateReminderConfig = new InstallActivateReminderConfig();
        installActivateReminderConfig.parseJson(optJSONObject);
        setValue(installActivateReminderConfig);
    }
}
