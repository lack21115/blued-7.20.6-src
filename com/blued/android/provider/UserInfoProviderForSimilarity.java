package com.blued.android.provider;

import com.blued.android.framework.provider.IUserInfoProvider;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.UserRelationshipUtils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/provider/UserInfoProviderForSimilarity.class */
public class UserInfoProviderForSimilarity implements IUserInfoProvider {
    @Override // com.blued.android.framework.provider.IUserInfoProvider
    public String a() {
        return UserInfo.getInstance().getLoginUserInfo().getUid();
    }

    @Override // com.blued.android.framework.provider.IUserInfoProvider
    public void a(String str) {
        UserRelationshipUtils.a(str, new int[0]);
    }

    @Override // com.blued.android.framework.provider.IUserInfoProvider
    public String b() {
        return UserInfo.getInstance().getAccessToken();
    }

    @Override // com.blued.android.framework.provider.IUserInfoProvider
    public void c() {
        Logger.c("loginInBackground", new Object[0]);
        UserRelationshipUtils.b();
    }

    @Override // com.blued.android.framework.provider.IUserInfoProvider
    public void d() {
        BluedConfig.a().d();
    }
}
