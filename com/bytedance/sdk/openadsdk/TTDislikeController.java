package com.bytedance.sdk.openadsdk;

import android.content.Context;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTDislikeController.class */
public interface TTDislikeController {
    @Deprecated
    void onDislikeEvent(Context context, boolean z);

    void onDislikeSelected(FilterWord filterWord);

    @Deprecated
    void openWebPage(Context context, boolean z);
}
