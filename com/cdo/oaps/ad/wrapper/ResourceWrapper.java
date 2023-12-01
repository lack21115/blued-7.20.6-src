package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/ResourceWrapper.class */
public class ResourceWrapper extends IDWrapper {
    public ResourceWrapper(Map<String, Object> map) {
        super(map);
    }

    public static ResourceWrapper wrapper(Map<String, Object> map) {
        return new ResourceWrapper(map);
    }

    public String getAdContent() {
        try {
            return (String) get(OapsKey.KEY_ADCONTENT);
        } catch (ag e) {
            return "";
        }
    }

    public int getAdId() {
        try {
            return getInt(OapsKey.KEY_ADID);
        } catch (ag e) {
            return -1;
        }
    }

    public String getAdPos() {
        try {
            return (String) get(OapsKey.KEY_ADPOS);
        } catch (ag e) {
            return "";
        }
    }

    public boolean getAutoDown() {
        try {
            return getBoolean(OapsKey.KEY_AUTO_DOWN);
        } catch (ag e) {
            return false;
        }
    }

    public String getCaller() {
        try {
            return (String) get(OapsKey.KEY_CALLER);
        } catch (ag e) {
            return "";
        }
    }

    public String getChannelPkg() {
        try {
            return (String) get(OapsKey.KEY_CHANEL_PKG);
        } catch (ag e) {
            return "";
        }
    }

    public String getDlDesc() {
        try {
            return (String) get(OapsKey.KEY_DL_DESC);
        } catch (ag e) {
            return "";
        }
    }

    public String getPkgName() {
        try {
            return (String) get("pkg");
        } catch (ag e) {
            return "";
        }
    }

    public String getReference() {
        try {
            return (String) get(OapsKey.KEY_REF);
        } catch (ag e) {
            return "";
        }
    }

    public String getStyle() {
        try {
            return (String) get("style");
        } catch (ag e) {
            return "";
        }
    }

    public String getToken() {
        try {
            return (String) get("token");
        } catch (ag e) {
            return "";
        }
    }

    public String getTraceId() {
        try {
            return (String) get("traceId");
        } catch (ag e) {
            return "";
        }
    }

    public ResourceWrapper setAdContent(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_ADCONTENT, str);
    }

    public ResourceWrapper setAdId(int i) {
        return (ResourceWrapper) set(OapsKey.KEY_ADID, Integer.valueOf(i));
    }

    public ResourceWrapper setAdPos(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_ADPOS, str);
    }

    public ResourceWrapper setAutoDown(boolean z) {
        return (ResourceWrapper) set(OapsKey.KEY_AUTO_DOWN, Boolean.valueOf(z));
    }

    public ResourceWrapper setCaller(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_CALLER, str);
    }

    public ResourceWrapper setChannelPkg(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_CHANEL_PKG, str);
    }

    public ResourceWrapper setDlDesc(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_DL_DESC, str);
    }

    public ResourceWrapper setPkgName(String str) {
        return (ResourceWrapper) set("pkg", str);
    }

    public ResourceWrapper setReference(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_REF, str);
    }

    public ResourceWrapper setStyle(String str) {
        return (ResourceWrapper) set("style", str);
    }

    public ResourceWrapper setToken(String str) {
        return (ResourceWrapper) set("token", str);
    }

    public ResourceWrapper setTraceId(String str) {
        return (ResourceWrapper) set("traceId", str);
    }
}
