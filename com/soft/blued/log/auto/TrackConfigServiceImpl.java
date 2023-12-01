package com.soft.blued.log.auto;

import com.blued.android.module.common.user.model.UserInfo;
import com.blued.track.auth.ITrackConfigService;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/auto/TrackConfigServiceImpl.class */
public class TrackConfigServiceImpl implements ITrackConfigService {
    @Override // com.blued.track.auth.ITrackConfigService
    public String a() {
        return "MAIN";
    }

    @Override // com.blued.track.auth.ITrackConfigService
    public String b() {
        return UserInfo.getInstance().getLoginUserInfo().uid;
    }
}
