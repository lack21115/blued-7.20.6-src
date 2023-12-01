package com.youzan.androidsdk;

import android.app.Application;
import android.content.Context;
import com.youzan.androidsdk.tool.AppSigning;
import com.youzan.androidsdk.tool.HttpCookie;
import com.youzan.androidsdk.tool.Preference;
import com.youzan.androidsdk.tool.SessionManager;
import com.youzan.androidsdk.tool.UserAgent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/YouzanSDKAdapter.class */
public abstract class YouzanSDKAdapter {
    public Application ctx;
    public boolean isInCheckList;
    public long kdtId;
    private volatile boolean ready = false;
    private List<String> hostList = new ArrayList();
    public boolean isBoundMobile = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void clearCookieByHost(Context context, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void clearLocalStorage();

    public List<String> getHostList() {
        return this.hostList;
    }

    public void init(Context context, String str, String str2, boolean z, boolean z2) {
        this.ctx = (Application) context.getApplicationContext();
        UserAgent.setupUA(context, str, true);
        Preference.instance().init(context);
        String str3 = AppSigning.getSingInfo(context, context.getPackageName(), AppSigning.SHA1).get(0);
        YouzanLog.i("appsigning = " + str3);
        if (!z2) {
            UserAgent.checkCertification(str, str2, context.getPackageName(), str3, z, new CheckCallback() { // from class: com.youzan.androidsdk.YouzanSDKAdapter.1
                @Override // com.youzan.androidsdk.CheckCallback
                public final void checkBack(int i, List<String> list) {
                    if (i != 1) {
                        YouzanLog.e("❌ -----clientId 校验失败，请填入正确的clientId");
                        return;
                    }
                    YouzanSDKAdapter.this.initWeb();
                    YouzanLog.e("✅️ clientId 校验成功");
                    YouzanSDKAdapter.this.ready = true;
                    YouzanSDKAdapter.this.setHostList(list);
                }
            });
            return;
        }
        initWeb();
        this.ready = true;
    }

    public abstract void initWeb();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void isDebug(boolean z) {
        YouzanLog.isDebug(z);
    }

    public boolean isReady() {
        return this.ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void loadConversation(WebViewCompat webViewCompat, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void saveCookies(Context context, List<HttpCookie> list);

    public void setHostList(List<String> list) {
        if (list != null) {
            this.hostList = list;
        }
    }

    public void sync(Context context, YouzanToken youzanToken) {
        if (this.hostList.size() > 0) {
            SessionManager.registerMoreHost(context, this.hostList, youzanToken);
        } else {
            SessionManager.register(context, youzanToken);
        }
    }

    public void userLogout(Context context) {
        if (this.hostList.size() > 0) {
            SessionManager.unregisterMoreHost(context, this.hostList);
        } else {
            SessionManager.unregister(context);
        }
    }

    public void yzLogin(boolean z, Map<String, String> map, final YzLoginCallback yzLoginCallback) {
        UserAgent.login(z, map, new LoginCallback() { // from class: com.youzan.androidsdk.YouzanSDKAdapter.2
            @Override // com.youzan.androidsdk.LoginCallback
            public final void loginBack(String str) {
                if (str != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        YouzanToken youzanToken = new YouzanToken(jSONObject);
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        YouzanSDKAdapter.this.kdtId = optJSONObject.optLong("grant_id");
                        YouzanSDKAdapter.this.isBoundMobile = optJSONObject.optBoolean("is_bound_mobile");
                        YouzanSDKAdapter.this.isInCheckList = optJSONObject.optBoolean("is_in_check_list");
                        YouzanSDK.sync(YouzanSDKAdapter.this.ctx, youzanToken);
                        yzLoginCallback.onSuccess(youzanToken);
                    } catch (Exception e) {
                        e.printStackTrace();
                        yzLoginCallback.onFail(str);
                    }
                }
            }
        });
    }
}
