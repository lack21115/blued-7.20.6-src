package com.blued.android.module.common.db.model;

import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "UserAccountsModel")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/model/UserAccountsModel.class */
public class UserAccountsModel {
    public static final String ACCOUNT_THREE_ONECLICK = "onclick";
    public static final String ACCOUNT_THREE_WEIXIN = "weixin";
    public static final int ACCOUNT_TYPE_EMAIL = 0;
    public static final int ACCOUNT_TYPE_PHONE = 1;
    public static final int ACCOUNT_TYPE_THREE = 2;
    @DatabaseField
    private String accessToken;
    @DatabaseField(defaultValue = "")
    private String aliasUserId;
    private BluedLoginResult bluedLoginResult;
    @DatabaseField
    private String extra;
    @DatabaseField(columnName = "id", generatedId = true)
    private int id;
    @DatabaseField
    private boolean isSycOk = false;
    @DatabaseField
    private long lastHandleTime;
    @DatabaseField(defaultValue = "0", index = true)
    private int loginType;
    @DatabaseField
    private String loginresult;
    @DatabaseField
    private String passwordSha;
    @DatabaseField(index = true)
    private String uid;
    @DatabaseField(index = true)
    private String username;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAliasUserId() {
        return this.aliasUserId;
    }

    public BluedLoginResult getBluedLoginResult() {
        if (this.bluedLoginResult == null) {
            synchronized (this) {
                this.bluedLoginResult = UserInfo.getInstance().getLoginResultForV1(this);
            }
        }
        return this.bluedLoginResult;
    }

    public String getExtra() {
        return this.extra;
    }

    public int getId() {
        return this.id;
    }

    public long getLastHandleTime() {
        return this.lastHandleTime;
    }

    public int getLoginType() {
        return this.loginType;
    }

    public String getLoginresult() {
        return this.loginresult;
    }

    public String getPasswordSha() {
        return this.passwordSha;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isSycOk() {
        return this.isSycOk;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setAliasUserId(String str) {
        this.aliasUserId = str;
    }

    public void setBluedLoginResult(BluedLoginResult bluedLoginResult) {
        this.bluedLoginResult = bluedLoginResult;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLastHandleTime(long j) {
        this.lastHandleTime = j;
    }

    public void setLoginType(int i) {
        this.loginType = i;
    }

    public void setLoginresult(String str) {
        this.loginresult = str;
    }

    public void setPasswordSha(String str) {
        this.passwordSha = str;
    }

    public void setSycOk(boolean z) {
        this.isSycOk = z;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
