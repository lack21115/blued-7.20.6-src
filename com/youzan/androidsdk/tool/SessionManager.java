package com.youzan.androidsdk.tool;

import android.content.Context;
import android.text.TextUtils;
import com.youzan.androidsdk.HtmlStorage;
import com.youzan.androidsdk.YouzanToken;
import com.youzan.androidsdk.account.Token;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/SessionManager.class */
public final class SessionManager {
    private SessionManager() {
    }

    public static void register(Context context, YouzanToken youzanToken) {
        HtmlStorage.Synchronize.set(context, youzanToken.getCookieKey(), youzanToken.getCookieValue());
        if (!TextUtils.isEmpty(youzanToken.getCookieValue())) {
            HtmlStorage.Synchronize.sessionId(context, youzanToken.getCookieValue());
        }
        Token.save(youzanToken);
    }

    public static void registerMoreHost(Context context, List<String> list, YouzanToken youzanToken) {
        if (!TextUtils.isEmpty(youzanToken.getCookieValue())) {
            HtmlStorage.Synchronize.sessionId(context, youzanToken.getCookieValue());
        }
        HtmlStorage.Synchronize.set(context, list, youzanToken.getCookieKey(), youzanToken.getCookieValue());
        Token.save(youzanToken);
    }

    public static void unregister(Context context) {
        HtmlStorage.Manager.clear(context);
        Token.clear(context);
    }

    public static void unregisterMoreHost(Context context, List<String> list) {
        HtmlStorage.Manager.clear(context, list);
        Token.clear(context);
    }
}
