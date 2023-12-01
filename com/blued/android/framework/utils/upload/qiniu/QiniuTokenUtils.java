package com.blued.android.framework.utils.upload.qiniu;

import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.http.BluedHttpTools;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/QiniuTokenUtils.class */
public class QiniuTokenUtils {
    public static void a(String str, int i, StringHttpResponseHandler stringHttpResponseHandler, IRequestHost iRequestHost) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("number_images", i + "");
        HttpManager.a(str, stringHttpResponseHandler, iRequestHost).b(BluedHttpTools.a(true)).a(a).h();
    }
}
