package com.soft.blued.http;

import android.provider.Contacts;
import android.provider.SearchIndexablesContract;
import android.text.TextUtils;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.soft.blued.utils.Logger;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/MsgGroupHttpUtils.class */
public class MsgGroupHttpUtils {
    public static void a(IRequestHost iRequestHost, int i, int i2, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("size", i2 + "");
        HttpManager.a(BluedHttpUrl.q() + "/groups/mine", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(IRequestHost iRequestHost, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        HttpManager.a(BluedHttpUrl.q() + "/groups/super", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(IRequestHost iRequestHost, String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(Contacts.GroupMembership.GROUP_ID, str);
        HttpManager.a(BluedHttpUrl.q() + "/groups/info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(IRequestHost iRequestHost, String str, String str2, int i, int i2, String str3, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(Contacts.GroupMembership.GROUP_ID, str);
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("size", i2 + "");
        a2.put("desc_type", str2);
        a2.put("search", str3);
        HttpManager.a(BluedHttpUrl.q() + "/groups/members", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(IRequestHost iRequestHost, String str, String str2, int i, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(Contacts.GroupMembership.GROUP_ID, str);
        a2.put("uid", str2);
        a2.put("group_role", i + "");
        HttpManager.b(BluedHttpUrl.q() + "/groups/members", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(IRequestHost iRequestHost, String str, String str2, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(Contacts.GroupMembership.GROUP_ID, str);
        a2.put(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, str2);
        HttpManager.a(BluedHttpUrl.q() + "/groups/members/search", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(IRequestHost iRequestHost, String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, int i5, BluedUIHttpResponse bluedUIHttpResponse, Map<String, String>... mapArr) {
        Map<String, String> a2 = BluedHttpTools.a();
        if (mapArr != null && mapArr.length > 0) {
            for (Map.Entry<String, String> entry : mapArr[0].entrySet()) {
                a2.put(entry.getKey(), entry.getValue());
            }
        }
        a2.put(Contacts.GroupMembership.GROUP_ID, str);
        if (!TextUtils.isEmpty(str2)) {
            a2.put("group_cover", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            a2.put("group_title", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            a2.put("group_desc", str4);
        }
        if (i != -1) {
            a2.put("group_status", i + "");
        }
        if (i2 != -1) {
            a2.put("allow_join", i2 + "");
        }
        if (i3 != -1) {
            a2.put("message_is_mute", i3 + "");
        }
        if (i4 != -1) {
            a2.put("at_message_is_mute", i4 + "");
        }
        if (i5 != -1) {
            a2.put("notice_is_mute", i5 + "");
        }
        HttpManager.b(BluedHttpUrl.q() + "/groups/info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(IRequestHost iRequestHost, String str, Map<String, String> map, BluedUIHttpResponse bluedUIHttpResponse) {
        a(iRequestHost, str, null, null, null, -1, -1, -1, -1, -1, bluedUIHttpResponse, map);
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/groups/config", bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/chat/bubble", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(IRequestHost iRequestHost, int i, int i2, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("size", i2 + "");
        HttpManager.a(BluedHttpUrl.q() + "/groups/notice", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(IRequestHost iRequestHost, String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(Contacts.GroupMembership.GROUP_ID, str);
        HttpManager.b(BluedHttpUrl.q() + "/groups/members?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(IRequestHost iRequestHost, String str, String str2, int i, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(Contacts.GroupMembership.GROUP_ID, str);
        a2.put("allow_join", i + "");
        if (!TextUtils.isEmpty(str2)) {
            a2.put("reason", str2);
        }
        HttpManager.b(BluedHttpUrl.q() + "/groups/members?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(IRequestHost iRequestHost, int i, int i2, BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("id", i + "");
        a2.put("result", i2 + "");
        HttpManager.b(BluedHttpUrl.q() + "/groups/notice", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(IRequestHost iRequestHost, String str, BluedUIHttpResponse bluedUIHttpResponse) {
        Logger.c("reportChat", "ajaxParams : " + str);
        BluedHttpTools.b();
        HttpManager.b(BluedHttpUrl.q() + "/blued/newreport/chat-group/user", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(str).h();
    }
}
