package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/HomeWrapper.class */
public class HomeWrapper extends BaseWrapper {
    protected HomeWrapper(Map<String, Object> map) {
        super(map);
    }

    public static HomeWrapper wrapper(Map<String, Object> map) {
        return new HomeWrapper(map);
    }

    public String getModule() {
        try {
            return (String) get("m");
        } catch (ag e) {
            return "";
        }
    }

    public int getPageKey() {
        try {
            return getInt("pk");
        } catch (ag e) {
            return 0;
        }
    }

    public HomeWrapper setModule(String str) {
        return (HomeWrapper) set("m", str);
    }

    public HomeWrapper setPageKey(int i) {
        return (HomeWrapper) set("pk", Integer.valueOf(i));
    }
}
