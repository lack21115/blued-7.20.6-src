package com.soft.blued.utils.password;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.gson.annotations.SerializedName;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/password/PasswordCheckResultModel.class */
public class PasswordCheckResultModel {
    @SerializedName(BridgeUtil.UNDERLINE_STR)
    public String encrypted;
    public String password;
    private int strength_level;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStrength_level() {
        return this.strength_level * 10;
    }
}
