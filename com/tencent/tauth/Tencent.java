package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.GameAppOperation;
import com.tencent.open.LocationApi;
import com.tencent.open.SocialApi;
import com.tencent.open.TaskGuide;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.wpa.WPA;
import com.tencent.open.yyb.AppbarAgent;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tauth/Tencent.class */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    private static final String TAG = "openSDK_LOG.Tencent";
    private static Tencent sInstance;
    private AppbarAgent mAgent;
    private LocationApi mLocationApi;
    private final QQAuth mQQAuth;

    private Tencent(String str, Context context) {
        Global.setContext(context.getApplicationContext());
        this.mQQAuth = QQAuth.createInstance(str, context);
    }

    private static boolean checkManifestConfig(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
                return true;
            } catch (PackageManager.NameNotFoundException e) {
                f.e(TAG, "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
                return false;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            f.e(TAG, "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
            return false;
        }
    }

    public static Tencent createInstance(String str, Context context) {
        synchronized (Tencent.class) {
            try {
                Global.setContext(context.getApplicationContext());
                f.c(TAG, "createInstance()  -- start");
                if (sInstance == null) {
                    sInstance = new Tencent(str, context);
                } else if (!str.equals(sInstance.getAppId())) {
                    sInstance.logout(context);
                    sInstance = new Tencent(str, context);
                }
                if (checkManifestConfig(context, str)) {
                    f.c(TAG, "createInstance()  -- end");
                    return sInstance;
                }
                return null;
            } finally {
            }
        }
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleResultData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        f.c(TAG, sb.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static boolean onActivityResultData(int i, int i2, Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResultData() reqcode = ");
        sb.append(i);
        sb.append(", resultcode = ");
        sb.append(i2);
        sb.append(", data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        f.c(TAG, sb.toString());
        return UIListenerManager.getInstance().onActivityResult(i, i2, intent, iUiListener);
    }

    public void addToQQFavorites(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new GameAppOperation(getQQToken()).addToQQFavorites(activity, bundle, iUiListener);
    }

    public int ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "ask()");
        new SocialApi(this.mQQAuth.getQQToken()).ask(activity, bundle, iUiListener);
        return 0;
    }

    public void bindQQGroup(Activity activity, Bundle bundle) {
        new GameAppOperation(getQQToken()).bindQQGroup(activity, bundle);
    }

    public int brag(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "brag()");
        new SocialApi(this.mQQAuth.getQQToken()).brag(activity, bundle, iUiListener);
        return 0;
    }

    public int challenge(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "challenge()");
        new SocialApi(this.mQQAuth.getQQToken()).challenge(activity, bundle, iUiListener);
        return 0;
    }

    public void checkActivityAvailable(Activity activity, String str, IUiListener iUiListener) {
        f.c(TAG, "checkActivityAvailable()");
        new GameAppOperation(getQQToken()).isActivityAvailable(activity, str, iUiListener);
    }

    public void checkLogin(IUiListener iUiListener) {
        f.c(TAG, "checkLogin()");
        this.mQQAuth.checkLogin(iUiListener);
    }

    public boolean checkPrizeByIntent(Activity activity, Intent intent) {
        f.c(TAG, "checkPrizeByIntent()");
        if (intent == null) {
            f.e(TAG, "-->check by prize by intent, intent is null.");
            return false;
        }
        return intent.getBooleanExtra(AuthActivity.ACTION_SHARE_PRIZE, false);
    }

    public int deleteLocation(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "deleteLocation()");
        if (this.mLocationApi == null) {
            this.mLocationApi = new LocationApi(this.mQQAuth.getQQToken());
        }
        this.mLocationApi.deleteLocation(activity, bundle, iUiListener);
        return 0;
    }

    public void exchangePrize(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "exchangePrize()");
        new GameAppOperation(getQQToken()).exchangePrize(activity, bundle, iUiListener);
    }

    public String getAccessToken() {
        return this.mQQAuth.getQQToken().getAccessToken();
    }

    public String getAppId() {
        return this.mQQAuth.getQQToken().getAppId();
    }

    public long getExpiresIn() {
        return this.mQQAuth.getQQToken().getExpireTimeInSecond();
    }

    public String getOpenId() {
        return this.mQQAuth.getQQToken().getOpenId();
    }

    public QQToken getQQToken() {
        return this.mQQAuth.getQQToken();
    }

    public void getWPAUserOnlineState(String str, IUiListener iUiListener) {
        f.c(TAG, "getWPAUserOnlineState()");
        new WPA(getQQToken()).getWPAUserOnlineState(str, iUiListener);
    }

    public int gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "gift()");
        new SocialApi(this.mQQAuth.getQQToken()).gift(activity, bundle, iUiListener);
        return 0;
    }

    public void grade(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "grade()");
        new SocialApi(this.mQQAuth.getQQToken()).grade(activity, bundle, iUiListener);
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleLoginData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        f.c(TAG, sb.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public int invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "invite()");
        new SocialApi(this.mQQAuth.getQQToken()).invite(activity, bundle, iUiListener);
        return 0;
    }

    public boolean isReady() {
        return isSessionValid() && getOpenId() != null;
    }

    public boolean isSessionValid() {
        return this.mQQAuth.isSessionValid();
    }

    public boolean isSupportSSOLogin(Activity activity) {
        if (SystemUtils.getAppVersionName(activity, "com.tencent.mobileqq") == null) {
            return false;
        }
        return SystemUtils.checkMobileQQ(activity);
    }

    public boolean joinQQGroup(Activity activity, String str) {
        f.c(TAG, "joinQQGroup()");
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + str));
        try {
            activity.startActivity(intent);
            d.a().a(this.mQQAuth.getQQToken().getOpenId(), this.mQQAuth.getQQToken().getAppId(), Constants.VIA_JOIN_GROUP, "13", "18", "0");
            return true;
        } catch (Exception e) {
            d.a().a(this.mQQAuth.getQQToken().getOpenId(), this.mQQAuth.getQQToken().getAppId(), Constants.VIA_JOIN_GROUP, "13", "18", "1");
            return false;
        }
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        f.c(TAG, "login() with activity, scope is " + str);
        return this.mQQAuth.login(activity, str, iUiListener);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        f.c(TAG, "login() with fragment, scope is " + str);
        return this.mQQAuth.login(fragment, str, iUiListener, "");
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        f.c(TAG, "loginServerSide() with activity, scope = " + str + ",server_side");
        QQAuth qQAuth = this.mQQAuth;
        return qQAuth.login(activity, str + ",server_side", iUiListener);
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        f.c(TAG, "loginServerSide() with fragment, scope = " + str + ",server_side");
        QQAuth qQAuth = this.mQQAuth;
        return qQAuth.login(fragment, str + ",server_side", iUiListener, "");
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, String str2, String str3, String str4) {
        f.c(TAG, "loginWithOEM() with activity, scope = " + str);
        return this.mQQAuth.loginWithOEM(activity, str, iUiListener, str2, str3, str4);
    }

    public void logout(Context context) {
        f.c(TAG, "logout()");
        this.mQQAuth.getQQToken().setAccessToken(null, "0");
        this.mQQAuth.getQQToken().setOpenId(null);
    }

    public void makeFriend(Activity activity, Bundle bundle) {
        new GameAppOperation(getQQToken()).makeFriend(activity, bundle);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        f.c(TAG, "onActivityResult() deprecated, will do nothing");
        return false;
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "publishToQzone()");
        new QzonePublish(activity, this.mQQAuth.getQQToken()).publishToQzone(activity, bundle, iUiListener);
    }

    public void queryUnexchangePrize(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "queryUnexchangePrize()");
        new GameAppOperation(getQQToken()).queryUnexchangePrize(activity, bundle, iUiListener);
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        f.c(TAG, "reAuth() with activity, scope = " + str);
        return this.mQQAuth.reAuth(activity, str, iUiListener);
    }

    public int reactive(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "reactive()");
        new SocialApi(this.mQQAuth.getQQToken()).reactive(activity, bundle, iUiListener);
        return 0;
    }

    public void releaseResource() {
    }

    public void reportDAU() {
        this.mQQAuth.reportDAU();
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        f.c(TAG, "request()");
        return HttpUtils.request(this.mQQAuth.getQQToken(), Global.getContext(), str, bundle, str2);
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener, Object obj) {
        f.c(TAG, "requestAsync()");
        HttpUtils.requestAsync(this.mQQAuth.getQQToken(), Global.getContext(), str, bundle, str2, iRequestListener);
    }

    public int searchNearby(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "searchNearby()");
        if (this.mLocationApi == null) {
            this.mLocationApi = new LocationApi(this.mQQAuth.getQQToken());
        }
        this.mLocationApi.searchNearby(activity, bundle, iUiListener);
        return 0;
    }

    public void sendToMyComputer(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new GameAppOperation(getQQToken()).sendToMyComputer(activity, bundle, iUiListener);
    }

    public void setAccessToken(String str, String str2) {
        f.a(TAG, "setAccessToken(), expiresIn = " + str2 + "");
        this.mQQAuth.setAccessToken(str, str2);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "setAvatar()");
        String string = bundle.getString("picture");
        new QQAvatar(this.mQQAuth.getQQToken()).setAvatar(activity, Uri.parse(string), iUiListener, bundle.getInt("exitAnim"));
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener, int i, int i2) {
        f.c(TAG, "setAvatar()");
        bundle.putInt("exitAnim", i2);
        activity.overridePendingTransition(i, 0);
        setAvatar(activity, bundle, iUiListener);
    }

    public void setOpenId(String str) {
        f.a(TAG, "setOpenId() --start");
        this.mQQAuth.setOpenId(Global.getContext(), str);
        f.a(TAG, "setOpenId() --end");
    }

    public void sharePrizeToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "sharePrizeToQQ()");
        new GameAppOperation(getQQToken()).sharePrizeToQQ(activity, bundle, iUiListener);
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "shareToQQ()");
        new QQShare(activity, this.mQQAuth.getQQToken()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "shareToQzone()");
        new QzoneShare(activity, this.mQQAuth.getQQToken()).shareToQzone(activity, bundle, iUiListener);
    }

    public void shareToTroopBar(Activity activity, Bundle bundle, IUiListener iUiListener) {
        new GameAppOperation(getQQToken()).shareToTroopBar(activity, bundle, iUiListener);
    }

    public void showTaskGuideWindow(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "showTaskGuideWindow()");
        new TaskGuide(activity, this.mQQAuth.getQQToken()).showTaskGuideWindow(activity, bundle, iUiListener);
    }

    public void startAppbar(Activity activity, String str) {
        f.c(TAG, "startAppbar()");
        if (this.mAgent == null) {
            this.mAgent = new AppbarAgent(this.mQQAuth.getQQToken());
        }
        this.mAgent.startAppbar(activity, str);
    }

    public void startAppbarLabel(Activity activity, String str) {
        f.c(TAG, "startAppbarLabel()");
        if (this.mAgent == null) {
            this.mAgent = new AppbarAgent(this.mQQAuth.getQQToken());
        }
        this.mAgent.startAppbarLabel(activity, str);
    }

    public void startAppbarThread(Activity activity, String str) {
        f.c(TAG, "startAppbarThread()");
        if (this.mAgent == null) {
            this.mAgent = new AppbarAgent(this.mQQAuth.getQQToken());
        }
        this.mAgent.startAppbarThread(activity, str);
    }

    public int startWPAConversation(Activity activity, String str, String str2) {
        return startWPAConversation(activity, WPA.CHAT_TYPE_WPA, str, str2);
    }

    public int startWPAConversation(Activity activity, String str, String str2, String str3) {
        f.c(TAG, "startWPAConversation()");
        return new WPA(getQQToken()).startWPAConversation(activity, str, str2, str3);
    }

    public int story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "story()");
        new SocialApi(this.mQQAuth.getQQToken()).story(activity, bundle, iUiListener);
        return 0;
    }

    public void voice(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "voice()");
        new SocialApi(this.mQQAuth.getQQToken()).voice(activity, bundle, iUiListener);
    }
}
