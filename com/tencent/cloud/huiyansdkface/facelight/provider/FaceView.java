package com.tencent.cloud.huiyansdkface.facelight.provider;

import android.graphics.RectF;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/provider/FaceView.class */
public interface FaceView {
    void onUpdateErrorTip(String str);

    void onUpdateErrorTipTextColor(int i);

    void onUpdateFaceBorder(int i);

    void onUpdateLongTipVisibility(int i);

    void onUpdateNetworkRetry();

    void onUpdateRealFaceRect(RectF rectF);

    void onUpdateTip(String str);

    void onUpdateTipTextColor(int i);
}
