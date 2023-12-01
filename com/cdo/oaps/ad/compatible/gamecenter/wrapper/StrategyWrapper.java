package com.cdo.oaps.ad.compatible.gamecenter.wrapper;

import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.wrapper.IDWrapper;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/compatible/gamecenter/wrapper/StrategyWrapper.class */
public class StrategyWrapper extends IDWrapper {

    /* renamed from: a  reason: collision with root package name */
    final String f7918a;

    protected StrategyWrapper(Map<String, Object> map) {
        super(map);
        this.f7918a = "tab";
    }

    public static StrategyWrapper wrapper(Map<String, Object> map) {
        return new StrategyWrapper(map);
    }

    public int getTab() {
        try {
            return getInt("tab");
        } catch (ag | NumberFormatException e) {
            return -1;
        }
    }

    public StrategyWrapper setTab(int i) {
        return (StrategyWrapper) set("tab", Integer.valueOf(i));
    }
}
