package com.blued.android.module.external_sense_library.contract;

import android.graphics.Rect;
import android.os.Handler;
import com.blued.android.module.external_sense_library.config.BluedBeautifyKey;
import com.blued.android.module.external_sense_library.config.BluedFilterType;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/contract/ISenseTimeProcessor.class */
public interface ISenseTimeProcessor {
    void adjustViewPort(int i, int i2);

    void changeCustomEvent();

    void changeSticker(String str, String str2);

    void changeSticker(String str, String str2, ISetStickerListener iSetStickerListener);

    void disableObjectTracking();

    int drawFrame(int i, int i2, int i3, boolean z);

    void enableBeautify(boolean z);

    void enableObject(boolean z);

    void enableSticker(boolean z);

    Rect getIndexRect();

    byte[] getOutputBuffer();

    long getStickerTriggerAction();

    void handlePreviewFrame(byte[] bArr, int i, int i2, int i3);

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void onSurfaceCreated();

    void onSurfaceDestroyed();

    void removeAllStickers();

    void resetIndexRect();

    void setBeautyParam(BluedBeautifyKey.KEY key, float f);

    void setCameraFacing(boolean z);

    void setFilterStrength(float f);

    void setFilterStyle(BluedFilterType.FILER filer);

    void setHandler(Handler handler);

    void setIndexRect(int i, int i2, boolean z);

    void setNeedSaveFrame(boolean z);

    void setObjectTrackRect();

    void switchCamera();
}
