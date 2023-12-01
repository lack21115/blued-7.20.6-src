package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/VerifyWrapper.class */
public class VerifyWrapper extends BaseWrapper {
    protected VerifyWrapper(Map<String, Object> map) {
        super(map);
    }

    public static VerifyWrapper wrapper(Map<String, Object> map) {
        return new VerifyWrapper(map);
    }

    public String getChecksum() {
        try {
            return (String) get(OapsKey.KEY_CK);
        } catch (ag e) {
            return "";
        }
    }

    public String getId() {
        try {
            return (String) get(OapsKey.KEY_SRC);
        } catch (ag e) {
            return "";
        }
    }

    public String getTimestamp() {
        try {
            return (String) get("ts");
        } catch (ag e) {
            return "";
        }
    }

    public VerifyWrapper setChecksum(String str) {
        return (VerifyWrapper) set(OapsKey.KEY_CK, str);
    }

    public VerifyWrapper setId(String str) {
        return (VerifyWrapper) set(OapsKey.KEY_SRC, str);
    }

    public VerifyWrapper setTimestamp(String str) {
        return (VerifyWrapper) set("ts", String.valueOf(str));
    }
}
