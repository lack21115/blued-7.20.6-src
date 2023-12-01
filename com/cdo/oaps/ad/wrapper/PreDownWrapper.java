package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/PreDownWrapper.class */
public class PreDownWrapper extends IDWrapper {
    public static final int OPERATOR_TYPE_CANCEL = 1;
    public static final int OPERATOR_TYPE_START = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final String f7935a = "type";

    protected PreDownWrapper(Map<String, Object> map) {
        super(map);
    }

    public static PreDownWrapper wrapper(Map<String, Object> map) {
        return new PreDownWrapper(map);
    }

    public String getChannelPkg() {
        try {
            return (String) get(OapsKey.KEY_CHANEL_PKG);
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

    public int getType() {
        try {
            return getInt("type");
        } catch (ag e) {
            return -1;
        }
    }

    public PreDownWrapper setChannelPkg(String str) {
        return (PreDownWrapper) set(OapsKey.KEY_CHANEL_PKG, str);
    }

    public PreDownWrapper setPkgName(String str) {
        return (PreDownWrapper) set("pkg", str);
    }

    public PreDownWrapper setType(int i) {
        return (PreDownWrapper) set("type", Integer.valueOf(i));
    }
}
