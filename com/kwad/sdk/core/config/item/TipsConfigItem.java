package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/TipsConfigItem.class */
public final class TipsConfigItem extends b<TipConfigData> {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/TipsConfigItem$TipConfigData.class */
    public static class TipConfigData implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 268961350883157950L;
        private String tipInfo;
        private transient Map<String, String> tipMap = new HashMap();
        private int tipShowSwitch;

        private void genTipMap(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.tipMap.put(next, jSONObject.optString(next, ""));
            }
        }

        public String getTipInfoData() {
            return this.tipInfo;
        }

        public int getTipShowSwitch() {
            return this.tipShowSwitch;
        }

        public String getTips(String str) {
            return this.tipMap.get(str);
        }

        public boolean isShowTips() {
            return this.tipShowSwitch == 0;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            setTipInfoData(jSONObject.optString("tipInfo"));
            this.tipShowSwitch = jSONObject.optInt("tipShowSwitch", 0);
        }

        public void setTipInfoData(String str) {
            this.tipInfo = str;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str) || com.igexin.push.core.b.l.equalsIgnoreCase(str)) {
                return;
            }
            try {
                genTipMap(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            }
        }

        public void setTipShowSwitch(int i) {
            this.tipShowSwitch = i;
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "tipShowSwitch", this.tipShowSwitch);
            t.putValue(jSONObject, "tipInfo", this.tipInfo);
            return jSONObject;
        }
    }

    public TipsConfigItem() {
        super("tipConfig", new TipConfigData());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        TipConfigData value = getValue();
        TipConfigData tipConfigData = value;
        if (value == null) {
            tipConfigData = new TipConfigData();
        }
        tipConfigData.setTipShowSwitch(sharedPreferences.getInt("tipsSwitch", 0));
        tipConfigData.setTipInfoData(sharedPreferences.getString("tipsInfo", ""));
        setValue(tipConfigData);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putInt("tipsSwitch", getValue().getTipShowSwitch());
        editor.putString("tipsInfo", getValue().getTipInfoData() != null ? getValue().getTipInfoData() : "");
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(uX());
            return;
        }
        TipConfigData tipConfigData = new TipConfigData();
        tipConfigData.parseJson(optJSONObject);
        setValue(tipConfigData);
    }
}
