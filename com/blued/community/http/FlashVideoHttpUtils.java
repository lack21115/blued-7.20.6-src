package com.blued.community.http;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/http/FlashVideoHttpUtils.class */
public class FlashVideoHttpUtils {
    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, int i2, String str, IRequestHost iRequestHost) {
        String str2 = CommunityHttpUtils.a() + "/ticktocks/catch";
        Map<String, String> a = BluedHttpTools.a();
        a.put("page", i + "");
        a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, i2 + "");
        if (!TextUtils.isEmpty(str)) {
            a.put("from", str);
        }
        HttpManager.a(str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, int i2, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("page", i + "");
        a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, i2 + "");
        a.put("feed_id", str2);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/users/" + str + "/timeline/catch", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }
}
