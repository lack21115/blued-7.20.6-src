package com.blued.community.http;

import android.text.TextUtils;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/http/FlashVideoHttpUtils.class */
public class FlashVideoHttpUtils {
    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, int i2, String str, IRequestHost iRequestHost) {
        String str2 = CommunityHttpUtils.a() + "/ticktocks/catch";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("size", i2 + "");
        if (!TextUtils.isEmpty(str)) {
            a2.put("from", str);
        }
        HttpManager.a(str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, int i2, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("size", i2 + "");
        a2.put("feed_id", str2);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/users/" + str + "/timeline/catch", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }
}
