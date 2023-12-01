package com.anythink.core.common.b;

import android.content.Context;
import android.view.View;
import com.anythink.core.api.ATNetworkConfirmInfo;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/l.class */
public interface l {
    void onAdClicked(View view);

    void onAdDislikeButtonClick();

    void onAdImpressed();

    void onAdVideoEnd();

    void onAdVideoProgress(int i);

    void onAdVideoStart();

    void onDeeplinkCallback(boolean z);

    void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo);
}
