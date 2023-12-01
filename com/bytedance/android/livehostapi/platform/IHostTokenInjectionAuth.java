package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import com.bytedance.android.live.base.IService;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/livehostapi/platform/IHostTokenInjectionAuth.class */
public interface IHostTokenInjectionAuth extends IService {
    TokenInfo getTokenInfo();

    boolean isLogin();

    void onTokenInvalid(TokenInfo tokenInfo, TokenRefreshCallback tokenRefreshCallback, Activity activity, Map<String, String> map);
}
