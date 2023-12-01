package com.cdo.oaps.ad;

import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/OapsWrapper.class */
public class OapsWrapper extends ai {
    public static final String KEY_HOST = "host";
    public static final String KEY_PATH = "path";
    public static final String KEY_SCHEME = "scheme";

    public OapsWrapper(Map<String, Object> map) {
        super(map);
    }

    public static OapsWrapper wrapper(Map<String, Object> map) {
        return new OapsWrapper(map);
    }

    public final String getHost() {
        try {
            return (String) get("host");
        } catch (ag e) {
            return "";
        }
    }

    public final String getPath() {
        try {
            return (String) get(KEY_PATH);
        } catch (ag e) {
            return "";
        }
    }

    public final String getScheme() {
        try {
            return (String) get("scheme");
        } catch (ag e) {
            return "";
        }
    }

    public final OapsWrapper setHost(String str) {
        return (OapsWrapper) super.set("host", str);
    }

    public final OapsWrapper setPath(String str) {
        return (OapsWrapper) super.set(KEY_PATH, str);
    }

    public final OapsWrapper setScheme(String str) {
        return (OapsWrapper) super.set("scheme", str);
    }
}
