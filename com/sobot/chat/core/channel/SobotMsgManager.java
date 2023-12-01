package com.sobot.chat.core.channel;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.api.a;
import com.sobot.chat.api.model.SobotMsgCenterModel;
import com.sobot.chat.api.model.ZhiChiPushMessage;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.SobotCache;
import com.sobot.chat.utils.ZhiChiConfig;
import com.sobot.chat.utils.ZhiChiConstant;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/channel/SobotMsgManager.class */
public class SobotMsgManager {
    private static SobotMsgManager instance;
    private SobotCache mCache;
    private Context mContext;
    private ZhiChiApi zhiChiApi = null;
    private HashMap<String, ZhiChiConfig> configs = new HashMap<>();
    private ZhiChiConfig config = new ZhiChiConfig();

    private SobotMsgManager(Context context) {
        this.mContext = context;
        this.mCache = SobotCache.get(context.getApplicationContext());
    }

    public static SobotMsgManager getInstance(Context context) {
        if (instance == null) {
            instance = new SobotMsgManager(context.getApplicationContext());
        }
        return instance;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r6 == 0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getLastMsg(java.lang.String r5) {
        /*
            r4 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L1d
            r1 = r0
            r2 = r5
            r1.<init>(r2)     // Catch: org.json.JSONException -> L1d
            r8 = r0
            r0 = r8
            java.lang.String r1 = "msg"
            java.lang.String r0 = r0.optString(r1)     // Catch: org.json.JSONException -> L1d
            r7 = r0
            r0 = r8
            java.lang.String r1 = "msgType"
            int r0 = r0.optInt(r1)     // Catch: org.json.JSONException -> L1d
            r6 = r0
            goto L27
        L1d:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
            java.lang.String r0 = ""
            r7 = r0
            r0 = -1
            r6 = r0
        L27:
            r0 = r6
            r1 = -1
            if (r0 == r1) goto L4d
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L4d
            r0 = r6
            r1 = 4
            if (r0 == r1) goto L4b
            r0 = r6
            r1 = 5
            if (r0 != r1) goto L3f
            r0 = r7
            return r0
        L3f:
            r0 = r6
            r1 = 1
            if (r0 != r1) goto L47
            java.lang.String r0 = "[图片]"
            return r0
        L47:
            r0 = r6
            if (r0 != 0) goto L4f
        L4b:
            r0 = r7
            return r0
        L4d:
            r0 = r7
            r5 = r0
        L4f:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.core.channel.SobotMsgManager.getLastMsg(java.lang.String):java.lang.String");
    }

    public static String getMsgCenterDataKey(String str, String str2) {
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        String str4 = str;
        if (str == null) {
            str4 = "";
        }
        return str4 + BridgeUtil.UNDERLINE_STR + str3 + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.SOBOT_MSG_CENTER_DATA;
    }

    public static String getMsgCenterListKey(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2 + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.SOBOT_MSG_CENTER_LIST;
    }

    public int addUnreadCount(ZhiChiPushMessage zhiChiPushMessage, String str, String str2) {
        int i = 0;
        if (zhiChiPushMessage != null) {
            if (TextUtils.isEmpty(zhiChiPushMessage.getAppId())) {
                return 0;
            }
            String appId = zhiChiPushMessage.getAppId();
            String str3 = str2;
            if (str2 == null) {
                str3 = "";
            }
            SobotMsgCenterModel sobotMsgCenterModel = (SobotMsgCenterModel) this.mCache.getAsObject(getMsgCenterDataKey(appId, str3));
            i = 0;
            if (sobotMsgCenterModel != null) {
                int unreadCount = sobotMsgCenterModel.getUnreadCount() + 1;
                sobotMsgCenterModel.setUnreadCount(unreadCount);
                sobotMsgCenterModel.setSenderName(zhiChiPushMessage.getAname());
                sobotMsgCenterModel.setSenderFace(zhiChiPushMessage.getAface());
                sobotMsgCenterModel.setLastMsg(getLastMsg(zhiChiPushMessage.getContent()));
                sobotMsgCenterModel.setLastDateTime(str);
                this.mCache.put(getMsgCenterDataKey(appId, str3), sobotMsgCenterModel);
                Context context = this.mContext;
                i = unreadCount;
                if (context != null) {
                    SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_LAST_MSG_CONTENT, sobotMsgCenterModel.getLastMsg());
                    i = unreadCount;
                }
            }
        }
        return i;
    }

    public void clearAllConfig() {
        SharedPreferencesUtil.getStringData(this.mContext, ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
        this.config.clearCache();
    }

    public void clearAllUnreadCount(Context context, String str) {
        if (context == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        ArrayList arrayList = (ArrayList) SobotCache.get(context).getAsObject(getMsgCenterListKey(str2));
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return;
            }
            String str3 = (String) arrayList.get(i2);
            SobotMsgCenterModel sobotMsgCenterModel = (SobotMsgCenterModel) this.mCache.getAsObject(getMsgCenterDataKey(str3, str2));
            if (sobotMsgCenterModel != null) {
                sobotMsgCenterModel.setUnreadCount(0);
                this.mCache.put(getMsgCenterDataKey(str3, str2), sobotMsgCenterModel);
            }
            i = i2 + 1;
        }
    }

    public void clearConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferencesUtil.getStringData(this.mContext, ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
        this.config.clearCache();
    }

    public void clearMsgCenter(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        SobotCache sobotCache = SobotCache.get(context);
        ArrayList arrayList = (ArrayList) sobotCache.getAsObject(getMsgCenterListKey(str3));
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        arrayList.remove(str);
        sobotCache.put(getMsgCenterListKey(str3), arrayList);
    }

    public ZhiChiConfig getConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ZhiChiConfig();
        }
        SharedPreferencesUtil.getStringData(this.mContext, ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
        return this.config;
    }

    public SobotMsgCenterModel getMsgCenterModel(String str, String str2) {
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        return (SobotMsgCenterModel) this.mCache.getAsObject(getMsgCenterDataKey(str, str3));
    }

    public int getUnreadCount(String str, boolean z, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        SobotMsgCenterModel sobotMsgCenterModel = (SobotMsgCenterModel) this.mCache.getAsObject(getMsgCenterDataKey(str, str3));
        if (sobotMsgCenterModel != null) {
            int unreadCount = sobotMsgCenterModel.getUnreadCount();
            if (z) {
                sobotMsgCenterModel.setUnreadCount(0);
                this.mCache.put(getMsgCenterDataKey(str, str3), sobotMsgCenterModel);
            }
            return unreadCount;
        }
        return 0;
    }

    public ZhiChiApi getZhiChiApi() {
        if (this.zhiChiApi == null) {
            synchronized (SobotMsgManager.class) {
                try {
                    if (this.zhiChiApi == null) {
                        this.zhiChiApi = a.a(this.mContext);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.zhiChiApi;
    }

    public void initSobotSDK(Context context, String str, String str2) {
        try {
            getInstance(context).getZhiChiApi().config(null, str);
        } catch (Exception e) {
        }
    }

    public boolean isActiveOperator(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        SharedPreferencesUtil.getStringData(this.mContext, ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
        return false;
    }
}
