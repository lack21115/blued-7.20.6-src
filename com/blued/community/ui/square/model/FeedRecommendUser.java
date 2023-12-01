package com.blued.community.ui.square.model;

import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.community.model.LiveRecommendModel;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/model/FeedRecommendUser.class */
public class FeedRecommendUser extends LiveRecommendModel {
    public String relationship;
    public int show_type;

    public FeedRecommendUser(BluedLoginResult bluedLoginResult) {
        super(bluedLoginResult);
    }
}
