package com.soft.blued.ui.community.auto;

import com.blued.android.module.common.listener.LocationHelperNew;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.community.auto.ICommunityLocationService;
import com.soft.blued.utils.DeviceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/auto/CommunityLocationServiceImpl.class */
public class CommunityLocationServiceImpl implements ICommunityLocationService {
    @Override // com.blued.community.auto.ICommunityLocationService, com.blued.community.auto.ICommunityOtherService, com.blued.community.auto.ICommunityShowPageService, com.blued.community.auto.ICommunityTrackService
    public String a() {
        return "MAIN";
    }

    @Override // com.blued.community.auto.ICommunityLocationService
    public void a(LocationHelperNew.LocationFinishListener locationFinishListener) {
        DeviceUtils.a(locationFinishListener);
    }

    @Override // com.blued.community.auto.ICommunityLocationService
    public String e() {
        return CommonPreferences.u();
    }

    @Override // com.blued.community.auto.ICommunityLocationService
    public String f() {
        return CommonPreferences.v();
    }
}
