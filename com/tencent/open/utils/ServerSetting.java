package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
import com.tencent.open.a.f;
import com.umeng.analytics.pro.at;
import java.lang.ref.WeakReference;
import java.net.URL;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/ServerSetting.class */
public class ServerSetting {
    public static final String APP_DETAIL_PAGE = "http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1";
    public static final String CGI_FETCH_QQ_URL = "http://fusion.qq.com/cgi-bin/qzapps/mapp_getappinfo.cgi";
    public static final String DEFAULT_CGI_AUTHORIZE = "http://openmobile.qq.com/oauth2.0/m_authorize?";
    public static final String DEFAULT_LOCAL_STORAGE_URI = "http://qzs.qq.com";
    public static final String DEFAULT_REDIRECT_URI = "auth://tauth.qq.com/";
    public static final String DEFAULT_URL_ASK = "http://qzs.qq.com/open/mobile/request/sdk_request.html?";
    public static final String DEFAULT_URL_BRAG = "http://qzs.qq.com/open/mobile/brag/sdk_brag.html?";
    public static final String DEFAULT_URL_GIFT = "http://qzs.qq.com/open/mobile/request/sdk_request.html?";
    public static final String DEFAULT_URL_GRAPH_BASE = "https://openmobile.qq.com/";
    public static final String DEFAULT_URL_INVITE = "http://qzs.qq.com/open/mobile/invite/sdk_invite.html?";
    public static final String DEFAULT_URL_REACTIVE = "http://qzs.qq.com/open/mobile/reactive/sdk_reactive.html?";
    public static final String DEFAULT_URL_REPORT = "http://wspeed.qq.com/w.cgi";
    public static final String DEFAULT_URL_SEND_STORY = "http://qzs.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?";
    public static final String DEFAULT_URL_VOICE = "http://qzs.qq.com/open/mobile/not_support.html?";
    public static final String DOWNLOAD_QQ_URL = "http://qzs.qq.com/open/mobile/login/qzsjump.html?";
    public static final String DOWNLOAD_QQ_URL_COMMON = "http://qzs.qq.com/open/mobile/sdk_common/down_qq.htm?";
    public static final int ENVIRONMENT_EXPERIENCE = 1;
    public static final int ENVIRONMENT_NORMOL = 0;
    public static final String KEY_HOST_ANALY = "analy.qq.com";
    public static final String KEY_HOST_APPIC = "appic.qq.com";
    public static final String KEY_HOST_APP_SUPPORT = "appsupport.qq.com";
    public static final String KEY_HOST_FUSION = "fusion.qq.com";
    public static final String KEY_HOST_I_GTIMG = "i.gtimg.cn";
    public static final String KEY_HOST_MAPP_QZONE = "mapp.qzone.qq.com";
    public static final String KEY_HOST_OPEN_MOBILE = "openmobile.qq.com";
    public static final String KEY_HOST_QZAPP_QLOGO = "qzapp.qlogo.cn";
    public static final String KEY_HOST_QZS_QQ = "qzs.qq.com";
    public static final String KEY_OPEN_ENV = "OpenEnvironment";
    public static final String KEY_OPEN_SETTING = "OpenSettings";
    public static final String NEED_QQ_VERSION_TIPS_URL = "http://openmobile.qq.com/oauth2.0/m_jump_by_version?";
    public static final String URL_FUSION_BASE = "http://fusion.qq.com";
    public static final String URL_FUSION_CGI_BASE = "http://fusion.qq.com/cgi-bin";
    public static final String URL_PRIZE_EXCHANGE = "http://fusion.qq.com/cgi-bin/prize_sharing/exchange_prize.cgi";
    public static final String URL_PRIZE_GET_ACTIVITY_STATE = "http://fusion.qq.com/cgi-bin/prize_sharing/get_activity_state.cgi";
    public static final String URL_PRIZE_MAKE_SHARE_URL = "http://fusion.qq.com/cgi-bin/prize_sharing/make_share_url.cgi";
    public static final String URL_PRIZE_QUERY_UNEXCHANGE = "http://fusion.qq.com/cgi-bin/prize_sharing/query_unexchange_prize.cgi";

    /* renamed from: a  reason: collision with root package name */
    private static ServerSetting f24591a;
    private volatile WeakReference<SharedPreferences> b = null;

    public static ServerSetting getInstance() {
        ServerSetting serverSetting;
        synchronized (ServerSetting.class) {
            try {
                if (f24591a == null) {
                    f24591a = new ServerSetting();
                }
                serverSetting = f24591a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return serverSetting;
    }

    public void changeServer() {
        this.b = null;
    }

    public String getEnvUrl(Context context, String str) {
        if (this.b == null || this.b.get() == null) {
            this.b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Get host error. url=");
                sb.append(str);
                f.e("openSDK_LOG.ServerSetting", sb.toString());
                return str;
            }
            String string = this.b.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                String replace = str.replace(host, string);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("return environment url : ");
                sb2.append(replace);
                f.a("openSDK_LOG.ServerSetting", sb2.toString());
                return replace;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("host=");
            sb3.append(host);
            sb3.append(", envHost=");
            sb3.append(string);
            f.a("openSDK_LOG.ServerSetting", sb3.toString());
            return str;
        } catch (Exception e) {
            f.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e.getMessage());
            return str;
        }
    }

    public void setEnvironment(Context context, int i) {
        SharedPreferences.Editor edit;
        if (context != null && (this.b == null || this.b.get() == null)) {
            this.b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        if (i != 0 && i != 1) {
            f.e("openSDK_LOG.ServerSetting", "切换环境参数错误，正式环境为0，体验环境为1");
        } else if (i != 0) {
            if (i == 1 && (edit = this.b.get().edit()) != null) {
                edit.putInt("ServerType", 1);
                edit.putString(KEY_OPEN_ENV, at.b);
                edit.putString(KEY_HOST_QZS_QQ, "testmobile.qq.com");
                edit.putString(KEY_HOST_OPEN_MOBILE, "test.openmobile.qq.com");
                edit.commit();
                changeServer();
                Toast.makeText(context, "已切换到体验环境", 0).show();
            }
        } else {
            SharedPreferences.Editor edit2 = this.b.get().edit();
            if (edit2 == null) {
                return;
            }
            edit2.putInt("ServerType", 0);
            edit2.putString(KEY_OPEN_ENV, "formal");
            edit2.putString(KEY_HOST_QZS_QQ, KEY_HOST_QZS_QQ);
            edit2.putString(KEY_HOST_OPEN_MOBILE, KEY_HOST_OPEN_MOBILE);
            edit2.commit();
            changeServer();
            Toast.makeText(context, "已切换到正式环境", 0).show();
        }
    }
}
