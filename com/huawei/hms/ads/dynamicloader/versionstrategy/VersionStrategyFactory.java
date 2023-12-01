package com.huawei.hms.ads.dynamicloader.versionstrategy;

import com.huawei.hms.ads.uiengineloader.af;
import com.huawei.hms.ads.uiengineloader.ag;
import com.huawei.hms.ads.uiengineloader.ah;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamicloader/versionstrategy/VersionStrategyFactory.class */
public class VersionStrategyFactory {
    public static final int PREFER_DECOMPRESS = 1;
    public static final int PREFER_HIGHEST_OR_DECOMPRESS = 2;

    public static ah getVersionPolicy(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return new ag();
        }
        return new af();
    }
}
