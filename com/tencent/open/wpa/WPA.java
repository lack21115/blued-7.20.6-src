package com.tencent.open.wpa;

import android.app.Activity;
import android.content.Context;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.d;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/wpa/WPA.class */
public class WPA extends BaseApi {
    public static final String CHAT_TYPE_GROUP = "group";
    public static final String CHAT_TYPE_WPA = "wpa";

    public WPA(Context context, QQAuth qQAuth, QQToken qQToken) {
        super(qQAuth, qQToken);
    }

    public WPA(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public WPA(QQToken qQToken) {
        super(qQToken);
    }

    public void getWPAUserOnlineState(String str, IUiListener iUiListener) {
        try {
            if (str == null) {
                d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_WAP_STATE, "15", "18", "1");
                throw new Exception("uin null");
            } else if (str.length() < 5) {
                d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_WAP_STATE, "15", "18", "1");
                throw new Exception("uin length < 5");
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= str.length()) {
                        HttpUtils.requestAsync(this.mToken, Global.getContext(), "http://webpresence.qq.com/getonline?Type=1&" + str + ":", null, "GET", new BaseApi.TempRequestListener(iUiListener));
                        d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_WAP_STATE, "15", "18", "0");
                        return;
                    } else if (!Character.isDigit(str.charAt(i2))) {
                        d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_WAP_STATE, "15", "18", "1");
                        throw new Exception("uin not digit");
                    } else {
                        i = i2 + 1;
                    }
                }
            }
        } catch (Exception e) {
            if (iUiListener != null) {
                iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_ERROR, null));
            }
            d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_WAP_STATE, "15", "18", "1");
        }
    }

    public int startWPAConversation(Activity activity, String str, String str2) {
        return startWPAConversation(activity, CHAT_TYPE_WPA, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int startWPAConversation(android.app.Activity r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.wpa.WPA.startWPAConversation(android.app.Activity, java.lang.String, java.lang.String, java.lang.String):int");
    }
}
