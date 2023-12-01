package com.soft.blued.http;

import android.content.Context;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.live.base.manager.LiveDataManager;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/FlashVideoHttpUtils.class */
public class FlashVideoHttpUtils {
    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("video", str);
        b.put("from", Integer.valueOf(LiveDataManager.a().g()));
        HttpManager.b(BluedHttpUrl.q() + "/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/verify", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }
}
