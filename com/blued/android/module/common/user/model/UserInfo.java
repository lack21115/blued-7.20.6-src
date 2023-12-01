package com.blued.android.module.common.user.model;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.R;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.db.model.UserAccountsModel;
import com.blued.android.module.common.user.LoginRegisterUtils;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.android.statistics.BluedStatistics;
import com.blued.track.bytedance.ByteDanceLogHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/user/model/UserInfo.class */
public class UserInfo {
    private static final String ABTEST_KEY = "ImG7loR8sa/j+x4Gno/itw==";
    private static final String TAG = UserInfo.class.getSimpleName();
    private static volatile UserInfo instance;
    private String accessToken;
    private String bindPhoneNum;
    private String boundMail;
    private String boundWechat;
    private BluedLoginResult defaultLoginUserInfo = new BluedLoginResult();
    private int loginType;
    private BluedLoginResult loginUserInfo;
    private String userName;
    private double userPrice;

    private UserInfo() {
        getLoginUserInfo();
    }

    public static UserInfo getInstance() {
        if (instance == null) {
            synchronized (UserInfo.class) {
                try {
                    if (instance == null) {
                        instance = new UserInfo();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getBindPhoneNum() {
        return this.bindPhoneNum;
    }

    public String getBoundMail() {
        return this.boundMail;
    }

    public String getBoundWechat() {
        return this.boundWechat;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ab, code lost:
        if (r0.contains("�") != false) goto L27;
     */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.blued.android.module.common.user.model.UserInfo$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.blued.android.module.common.user.model.BluedLoginResult getLoginResultForV1(com.blued.android.module.common.db.model.UserAccountsModel r7) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.user.model.UserInfo.getLoginResultForV1(com.blued.android.module.common.db.model.UserAccountsModel):com.blued.android.module.common.user.model.BluedLoginResult");
    }

    public BluedLoginResult getLoginResultFromDB() {
        UserAccountsModel d = UserAccountsVDao.a().d();
        Logger.c("getLoginResultFromDB", "UserRenew ua : " + d);
        if (d != null) {
            setUserName(d.getUsername());
        }
        if (d != null) {
            setAccessToken(d.getAccessToken());
        }
        if (d != null) {
            setLoginType(d.getLoginType());
        }
        try {
            int i = this.loginType;
            if (i == 0 || i == 1) {
                if (TextUtils.isEmpty(this.userName)) {
                    return null;
                }
                return getLoginResultForV1(d);
            } else if (i != 2 || TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.accessToken)) {
                return null;
            } else {
                return getLoginResultForV1(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getLoginType() {
        return this.loginType;
    }

    public BluedLoginResult getLoginUserInfo() {
        if (this.loginUserInfo == null) {
            synchronized (UserInfo.class) {
                try {
                    BluedLoginResult loginResultFromDB = getLoginResultFromDB();
                    this.loginUserInfo = loginResultFromDB;
                    if (loginResultFromDB == null) {
                        this.loginUserInfo = this.defaultLoginUserInfo;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.loginUserInfo;
    }

    public String getUserName() {
        return this.userName;
    }

    public double getUserPrice() {
        return this.userPrice;
    }

    public boolean isBindPhone() {
        if (getLoginType() == 0) {
            return true;
        }
        if (getLoginUserInfo().getVerified_bindings() == null) {
            return false;
        }
        return (TextUtils.isEmpty(getLoginUserInfo().getVerified_bindings().mobile) && TextUtils.isEmpty(getLoginUserInfo().getVerified_bindings().relation_mobile)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isLogin() {
        /*
            r3 = this;
            java.lang.Class<com.blued.android.module.common.user.model.UserInfo> r0 = com.blued.android.module.common.user.model.UserInfo.class
            monitor-enter(r0)
            r0 = r3
            java.lang.String r0 = r0.getUserName()     // Catch: java.lang.Throwable -> L6b
            r8 = r0
            r0 = r3
            java.lang.String r0 = r0.getAccessToken()     // Catch: java.lang.Throwable -> L6b
            r9 = r0
            r0 = 0
            r6 = r0
            com.blued.android.module.common.user.model.UserInfo r0 = getInstance()     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L6b
            int r0 = r0.getLoginType()     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L6b
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L42
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L42
            r0 = r4
            r1 = 2
            if (r0 == r1) goto L2b
            r0 = r6
            r5 = r0
            goto L66
        L2b:
            r0 = r6
            r5 = r0
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L6b
            if (r0 != 0) goto L66
            r0 = r6
            r5 = r0
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L6b
            if (r0 != 0) goto L66
            goto L73
        L42:
            r0 = r6
            r5 = r0
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L6b
            if (r0 != 0) goto L66
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L6b
            r7 = r0
            r0 = r6
            r5 = r0
            r0 = r7
            if (r0 != 0) goto L66
            goto L73
        L5d:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L6b
            r0 = r6
            r5 = r0
        L66:
            java.lang.Class<com.blued.android.module.common.user.model.UserInfo> r0 = com.blued.android.module.common.user.model.UserInfo.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6b
            r0 = r5
            return r0
        L6b:
            r8 = move-exception
            java.lang.Class<com.blued.android.module.common.user.model.UserInfo> r0 = com.blued.android.module.common.user.model.UserInfo.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6b
            r0 = r8
            throw r0
        L73:
            r0 = 1
            r5 = r0
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.user.model.UserInfo.isLogin():boolean");
    }

    public void logout(boolean z) {
        CommonPreferences.a(false);
        synchronized (UserInfo.class) {
            try {
                if (z) {
                    String str = TAG;
                    Logger.e(str, this.userName + "=切换不清除token=" + this.accessToken);
                } else {
                    setAccessToken("");
                    UserAccountsVDao.a().f();
                    UserAccountsVDao.a().g();
                }
                this.loginUserInfo = null;
                setBindPhoneNum("");
                setBoundMail("");
                setBoundWechat("");
                BluedStatistics.e().e();
                BluedStatistics.a().f("");
                BluedStatistics.a(null);
                BluedStatistics.g().a(ABTEST_KEY, "", null);
                BluedDeviceIdentity.a().c();
                instance = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void saveUserInfo(String str, int i, String str2, BluedLoginResult bluedLoginResult, String... strArr) {
        if (bluedLoginResult == null) {
            return;
        }
        synchronized (UserInfo.class) {
            if (strArr != null) {
                try {
                    try {
                        if (strArr.length > 0 && !TextUtils.isEmpty(strArr[0])) {
                            UserAccountsModel d = UserAccountsVDao.a().d();
                            d.setAliasUserId(bluedLoginResult.uid);
                            UserAccountsVDao.a().b().update(d);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.d(R.string.common_net_error);
                    }
                } finally {
                }
            }
            setLoginUserInfo(bluedLoginResult);
            this.userName = str;
            String str3 = TAG;
            Logger.c(str3, "IM=token==raw=" + bluedLoginResult.getAccess_token());
            this.accessToken = LoginRegisterUtils.a(bluedLoginResult.getAccess_token());
            this.loginType = i;
            UserAccountsModel userAccountsModel = new UserAccountsModel();
            userAccountsModel.setExtra("");
            userAccountsModel.setLoginresult(str2);
            userAccountsModel.setUid(bluedLoginResult.getUid());
            userAccountsModel.setLastHandleTime(System.currentTimeMillis());
            userAccountsModel.setUsername(str);
            userAccountsModel.setLoginType(i);
            userAccountsModel.setAccessToken(LoginRegisterUtils.a(bluedLoginResult.getAccess_token()));
            if (strArr != null && strArr.length > 0) {
                userAccountsModel.setAliasUserId(strArr[0]);
            }
            UserAccountsVDao.a().a(userAccountsModel);
            BluedStatistics.a().f(bluedLoginResult.getUid());
            BluedStatistics.a(BluedHttpTools.d());
            BluedStatistics.g().a(ABTEST_KEY, EncryptTool.b(getInstance().getLoginUserInfo().getUid()), null);
            BluedStatistics.e().b();
            BluedDeviceIdentity.a().b();
            ByteDanceLogHelper.a(getInstance().getLoginUserInfo().getUid());
        }
    }

    public void setAccessToken(String str) {
        synchronized (this) {
            this.accessToken = str;
            String str2 = TAG;
            Logger.c(str2, "setAccessToken===" + str);
            ChatManager.getInstance().updateUserToken(str);
        }
    }

    public void setBindPhoneNum(String str) {
        this.bindPhoneNum = str;
    }

    public void setBoundMail(String str) {
        this.boundMail = str;
    }

    public void setBoundWechat(String str) {
        this.boundWechat = str;
    }

    public void setLoginType(int i) {
        this.loginType = i;
    }

    public void setLoginUserInfo(BluedLoginResult bluedLoginResult) {
        synchronized (UserInfo.class) {
            try {
                this.loginUserInfo = bluedLoginResult;
                if (bluedLoginResult == null) {
                    this.loginUserInfo = this.defaultLoginUserInfo;
                }
            } finally {
            }
        }
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setUserPrice(double d) {
        this.userPrice = d;
    }
}
