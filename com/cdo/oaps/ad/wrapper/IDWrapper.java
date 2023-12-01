package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/IDWrapper.class */
public class IDWrapper extends BaseWrapper {
    public IDWrapper(Map<String, Object> map) {
        super(map);
    }

    public static IDWrapper wrapper(Map<String, Object> map) {
        return new IDWrapper(map);
    }

    public long getId() {
        try {
            return getLong("id");
        } catch (ag | NumberFormatException e) {
            return -1L;
        }
    }

    public IDWrapper setId(long j) {
        return (IDWrapper) set("id", Long.valueOf(j));
    }
}
