package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/OnlineServiceWrapper.class */
public class OnlineServiceWrapper extends BaseWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21540a = "gr";

    protected OnlineServiceWrapper(Map<String, Object> map) {
        super(map);
    }

    public static OnlineServiceWrapper wrapper(Map<String, Object> map) {
        return new OnlineServiceWrapper(map);
    }

    public int getGrade() {
        try {
            return getInt(f21540a);
        } catch (ag | NumberFormatException e) {
            return 0;
        }
    }

    public OnlineServiceWrapper setGrade(int i) {
        return (OnlineServiceWrapper) set(f21540a, Integer.valueOf(i));
    }
}
