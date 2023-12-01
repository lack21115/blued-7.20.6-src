package com.baidu.aip.face;

import android.graphics.RectF;
import android.view.TextureView;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/PreviewView.class */
public interface PreviewView {

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/PreviewView$ScaleType.class */
    public enum ScaleType {
        FIT_WIDTH,
        FIT_HEIGHT,
        CROP_INSIDE
    }

    ScaleType getScaleType();

    TextureView getTextureView();

    void mapFromOriginalRect(RectF rectF);

    void mapFromOriginalRectEx(RectF rectF);

    void mapToOriginalRect(RectF rectF);

    void setPreviewSize(int i, int i2);

    void setScaleType(ScaleType scaleType);
}
