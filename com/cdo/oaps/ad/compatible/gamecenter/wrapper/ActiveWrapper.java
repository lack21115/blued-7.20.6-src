package com.cdo.oaps.ad.compatible.gamecenter.wrapper;

import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.wrapper.IDWrapper;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/compatible/gamecenter/wrapper/ActiveWrapper.class */
public class ActiveWrapper extends IDWrapper {

    /* renamed from: a  reason: collision with root package name */
    final String f21523a;

    protected ActiveWrapper(Map<String, Object> map) {
        super(map);
        this.f21523a = "ac";
    }

    public static ActiveWrapper wrapper(Map<String, Object> map) {
        return new ActiveWrapper(map);
    }

    public int getActiveCode() {
        try {
            return getInt("ac");
        } catch (ag | NumberFormatException e) {
            return -1;
        }
    }

    public ActiveWrapper setActiveCode(int i) {
        return (ActiveWrapper) set("ac", Integer.valueOf(i));
    }
}
