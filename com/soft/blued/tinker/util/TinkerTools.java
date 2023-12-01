package com.soft.blued.tinker.util;

import com.blued.android.core.AppInfo;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.loader.TinkerRuntimeException;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/util/TinkerTools.class */
public class TinkerTools {
    public static String a() {
        try {
            Tinker with = Tinker.with(AppInfo.d());
            return (with == null || !with.isTinkerLoaded()) ? "0" : with.getTinkerLoadResultIfPresent().getPackageConfigByName("patchCode");
        } catch (TinkerRuntimeException e) {
            e.printStackTrace();
            return "0";
        }
    }
}
