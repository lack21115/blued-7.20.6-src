package com.blued.android.provider;

import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.provider.IAppInfoProvider;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/provider/AppInfoProvider.class */
public class AppInfoProvider implements IAppInfoProvider {
    @Override // com.blued.android.framework.provider.IAppInfoProvider
    public String a() {
        return "1";
    }

    @Override // com.blued.android.framework.provider.IAppInfoProvider
    public String b() {
        return BluedSkinUtils.c() ? "light" : "dark";
    }
}
