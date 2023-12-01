package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/BootGuideWrapper.class */
public class BootGuideWrapper extends BaseWrapper {
    protected BootGuideWrapper(Map<String, Object> map) {
        super(map);
    }

    public static BootGuideWrapper wrapper(Map<String, Object> map) {
        return new BootGuideWrapper(map);
    }

    public String getAction() {
        try {
            return (String) get("action");
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

    public BootGuideWrapper setAction(String str) {
        return (BootGuideWrapper) set("action", str);
    }

    public BootGuideWrapper setPkgName(String str) {
        return (BootGuideWrapper) set("pkg", str);
    }
}
