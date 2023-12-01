package com.soft.blued.ui.community.auto;

import com.blued.android.module.common.listener.LocationHelperNew;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.community.auto.ICommunityLocationService;
import com.soft.blued.utils.DeviceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/auto/CommunityLocationServiceImpl.class */
public class CommunityLocationServiceImpl implements ICommunityLocationService {
    public String a() {
        return "MAIN";
    }

    public void a(LocationHelperNew.LocationFinishListener locationFinishListener) {
        DeviceUtils.a(locationFinishListener);
    }

    public String e() {
        return CommonPreferences.u();
    }

    public String f() {
        return CommonPreferences.v();
    }
}
