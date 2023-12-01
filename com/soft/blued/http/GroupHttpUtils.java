package com.soft.blued.http;

import android.content.Context;
import android.provider.SearchIndexablesContract;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.utils.CommonPreferences;
import com.cdo.oaps.ad.OapsKey;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/GroupHttpUtils.class */
public class GroupHttpUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15968a = GroupHttpUtils.class.getSimpleName();

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/qiniu?filter=token&action=groups&gid=" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("filter", str2);
        HttpManager.a(BluedHttpUrl.q() + "/groups/" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        a2.put(OapsKey.KEY_SIZE, str3);
        HttpManager.a(BluedHttpUrl.q() + "/groups/users/" + str + "/information", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, str);
        a2.put("sort", str2);
        a2.put(WBPageConstants.ParamKey.PAGE, str3);
        a2.put(OapsKey.KEY_SIZE, str4);
        HttpManager.a(BluedHttpUrl.q() + "/groups/search", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, String str5, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        if (!StringUtils.d(str2)) {
            a2.put("name", str);
        }
        a2.put("description", str2);
        a2.put("city", str3);
        a2.put("longitude", str4);
        a2.put("latitude", str5);
        HttpManager.b(BluedHttpUrl.q() + "/groups", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String[] strArr, IRequestHost iRequestHost) {
        Map c2 = BluedHttpTools.c();
        c2.put("target_id", strArr);
        HttpManager.b(BluedHttpUrl.q() + "/groups/" + str + "/members?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(c2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, Object obj, IRequestHost iRequestHost) {
        Map b = BluedHttpTools.b();
        b.put("groups", obj);
        HttpManager.b(BluedHttpUrl.q() + "/groups/users/" + str + "/setting?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, boolean z, IRequestHost iRequestHost) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String[] strArr, boolean z) {
        String str2 = BluedHttpUrl.q() + "/groups/" + str + "/members";
        if (!z) {
            Map a2 = BluedHttpTools.a();
            a2.put("target_id", strArr[0]);
            HttpManager.b(str2, bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
            return;
        }
        Map c2 = BluedHttpTools.c();
        c2.put("target_id", strArr);
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    break;
                }
                Logger.b(f15968a, "inGroupForInvite  group   target_id", Integer.valueOf(i2), ":", strArr[i2]);
                i = i2 + 1;
            }
        }
        HttpManager.b(str2, bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(c2)).h();
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        HttpManager.a(BluedHttpUrl.q() + "/groups/" + str + "/me", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("message", str2);
        HttpManager.b(BluedHttpUrl.q() + "/groups/" + str + "/members", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, str2);
        a2.put("filter", str3);
        HttpManager.a(BluedHttpUrl.q() + "/groups/" + str + "/members/search", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, String str5, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        if (!StringUtils.d(str2)) {
            a2.put("name", str2);
        }
        if (!StringUtils.d(str3)) {
            a2.put("description", str3);
        }
        if (!StringUtils.d(str4)) {
            a2.put("city", str4);
        }
        if (!StringUtils.d(str5)) {
            a2.put("type", str5);
        }
        HttpManager.b(BluedHttpUrl.q() + "/groups/" + str + "?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        if (!StringUtils.d(str)) {
            a2.put("name", str);
        }
        HttpManager.b(BluedHttpUrl.q() + "/groups/check", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/groups/users/" + str + "/information/" + str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void c(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("members", str2);
        a2.put("is_vip", str3);
        HttpManager.a(BluedHttpUrl.q() + "/groups/" + str + "/members/upgrade", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void c(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, String str5, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("sort", str2);
        a2.put(WBPageConstants.ParamKey.PAGE, str3);
        a2.put(OapsKey.KEY_SIZE, str4);
        a2.put("filter", str5);
        HttpManager.a(BluedHttpUrl.q() + "/groups/" + str + "/members", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void d(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        if (!StringUtils.d(str)) {
            a2.put("description", str);
        }
        HttpManager.b(BluedHttpUrl.q() + "/groups/check", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void d(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("iid", str2);
        HttpManager.b(BluedHttpUrl.q() + "/groups/users/" + str + "/information", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void d(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("iid", str2);
        a2.put("filter", str3);
        HttpManager.b(BluedHttpUrl.q() + "/groups/users/" + str + "/information", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void d(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, String str5, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("filter", str);
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        a2.put(OapsKey.KEY_SIZE, str3);
        a2.put("location", str4);
        a2.put("type", str5);
        HttpManager.a(BluedHttpUrl.q() + "/groups", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void e(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/groups/" + str + "/members?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void e(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("filter", "location");
        a2.put(WBPageConstants.ParamKey.PAGE, str);
        a2.put(OapsKey.KEY_SIZE, str2);
        a2.put("location", "");
        a2.put("type", "");
        a2.put("sort", "distance");
        a2.put("longitude", CommonPreferences.u());
        a2.put("latitude", CommonPreferences.v());
        HttpManager.a(BluedHttpUrl.q() + "/groups", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void f(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.b(BluedHttpUrl.q() + "/groups/" + str + "?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void f(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("reason", str2);
        HttpManager.b(BluedHttpUrl.q() + "/blued/objectionable/groups/" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void g(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        HttpManager.a(BluedHttpUrl.q() + "/groups/users/" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void g(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("target_id", str2);
        HttpManager.b(BluedHttpUrl.q() + "/groups/" + str + "/admins", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void h(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        HttpManager.a(BluedHttpUrl.q() + "/groups/" + str + "/admins", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void h(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("target_id", str2);
        HttpManager.b(BluedHttpUrl.q() + "/groups/" + str + "/admins?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void i(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("filter", str);
        a2.put("return", "force");
        HttpManager.a(BluedHttpUrl.q() + "/groups/classify", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void i(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        HttpManager.b(BluedHttpUrl.q() + "/groups/users/" + str + "/information/" + str2 + "?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void j(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        HttpManager.b(BluedHttpUrl.q() + "/groups/users/" + str + "/information/clean", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void j(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map a2 = BluedHttpTools.a();
        a2.put("avatar", str);
        a2.put("gid", str2);
        HttpManager.b(BluedHttpUrl.q() + "/groups/" + str2 + "/attachments", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void k(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(BluedHttpUrl.q() + "/users/" + str + "/verify", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }
}
