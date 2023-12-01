package com.baidu.aip.face;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.baidu.aip.face.PreviewView;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/TexturePreviewView.class */
public class TexturePreviewView extends FrameLayout implements PreviewView {
    private Handler handler;
    private boolean mirrored;
    private PreviewView.ScaleType scaleType;
    private TextureView textureView;
    private int videoHeight;
    private int videoWidth;

    public TexturePreviewView(Context context) {
        super(context);
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.mirrored = true;
        this.scaleType = PreviewView.ScaleType.CROP_INSIDE;
        this.handler = new Handler(Looper.getMainLooper());
        init();
    }

    public TexturePreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.mirrored = true;
        this.scaleType = PreviewView.ScaleType.CROP_INSIDE;
        this.handler = new Handler(Looper.getMainLooper());
        init();
    }

    public TexturePreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.mirrored = true;
        this.scaleType = PreviewView.ScaleType.CROP_INSIDE;
        this.handler = new Handler(Looper.getMainLooper());
        init();
    }

    private void init() {
        TextureView textureView = new TextureView(getContext());
        this.textureView = textureView;
        addView(textureView);
    }

    private PreviewView.ScaleType resolveScaleType() {
        if (getHeight() <= 0 || this.videoHeight <= 0) {
            return PreviewView.ScaleType.CROP_INSIDE;
        }
        float width = (getWidth() * 1.0f) / getHeight();
        float f = (this.videoWidth * 1.0f) / this.videoHeight;
        PreviewView.ScaleType scaleType = this.scaleType;
        PreviewView.ScaleType scaleType2 = scaleType;
        if (scaleType == PreviewView.ScaleType.CROP_INSIDE) {
            scaleType2 = width > f ? PreviewView.ScaleType.FIT_WIDTH : PreviewView.ScaleType.FIT_HEIGHT;
        }
        return scaleType2;
    }

    @Override // com.baidu.aip.face.PreviewView
    public PreviewView.ScaleType getScaleType() {
        return this.scaleType;
    }

    @Override // com.baidu.aip.face.PreviewView
    public TextureView getTextureView() {
        return this.textureView;
    }

    @Override // com.baidu.aip.face.PreviewView
    public void mapFromOriginalRect(RectF rectF) {
        int width = getWidth();
        int height = getHeight();
        if (this.videoWidth == 0 || this.videoHeight == 0 || width == 0 || height == 0) {
            return;
        }
        Matrix matrix = new Matrix();
        if (resolveScaleType() == PreviewView.ScaleType.FIT_HEIGHT) {
            int i = this.videoWidth;
            int i2 = this.videoHeight;
            int i3 = (((i * height) / i2) - width) / 2;
            float f = (height * 1.0f) / i2;
            matrix.postScale(f, f);
            matrix.postTranslate(-i3, 0.0f);
        } else {
            int i4 = this.videoHeight;
            int i5 = this.videoWidth;
            int i6 = (((i4 * width) / i5) - height) / 2;
            float f2 = (width * 1.0f) / i5;
            matrix.postScale(f2, f2);
            matrix.postTranslate(0.0f, -i6);
        }
        matrix.mapRect(rectF);
        if (this.mirrored) {
            float f3 = width - rectF.right;
            float width2 = rectF.width();
            rectF.left = f3;
            rectF.right = width2 + f3;
        }
    }

    @Override // com.baidu.aip.face.PreviewView
    public void mapFromOriginalRectEx(RectF rectF) {
        int width = getWidth();
        int height = getHeight();
        if (this.videoWidth == 0 || this.videoHeight == 0 || width == 0 || height == 0) {
            return;
        }
        Matrix matrix = new Matrix();
        float f = width;
        float f2 = (1.0f * f) / this.videoWidth;
        matrix.postScale(f2, f2);
        matrix.mapRect(rectF);
        if (this.mirrored) {
            float f3 = f - rectF.right;
            float width2 = rectF.width();
            rectF.left = f3;
            rectF.right = width2 + f3;
        }
    }

    @Override // com.baidu.aip.face.PreviewView
    public void mapToOriginalRect(RectF rectF) {
        int width = getWidth();
        int height = getHeight();
        if (this.videoWidth == 0 || this.videoHeight == 0 || width == 0 || height == 0) {
            return;
        }
        Matrix matrix = new Matrix();
        if (resolveScaleType() == PreviewView.ScaleType.FIT_HEIGHT) {
            int i = this.videoWidth;
            int i2 = this.videoHeight;
            int i3 = (((i * height) / i2) - width) / 2;
            float f = (i2 * 1.0f) / height;
            matrix.postTranslate(i3, 0.0f);
            matrix.postScale(f, f);
        } else {
            int i4 = this.videoHeight;
            int i5 = this.videoWidth;
            int i6 = (((i4 * width) / i5) - height) / 2;
            float f2 = (i5 * 1.0f) / width;
            matrix.postTranslate(0.0f, i6);
            matrix.postScale(f2, f2);
        }
        matrix.mapRect(rectF);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        int height = getHeight();
        if (this.videoWidth == 0 || this.videoHeight == 0 || width == 0 || height == 0) {
            return;
        }
        if (resolveScaleType() == PreviewView.ScaleType.FIT_HEIGHT) {
            int i5 = (((this.videoWidth * height) / this.videoHeight) - width) / 2;
            this.textureView.layout(i - i5, i2, i3 + i5, i4);
            return;
        }
        int i6 = (((this.videoHeight * width) / this.videoWidth) - height) / 2;
        this.textureView.layout(i, i2 - i6, i3, i4 + i6);
    }

    public void setMirrored(boolean z) {
        this.mirrored = z;
    }

    @Override // com.baidu.aip.face.PreviewView
    public void setPreviewSize(int i, int i2) {
        if (this.videoWidth == i && this.videoHeight == i2) {
            return;
        }
        this.videoWidth = i;
        this.videoHeight = i2;
        this.handler.post(new Runnable() { // from class: com.baidu.aip.face.TexturePreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                TexturePreviewView.this.requestLayout();
            }
        });
    }

    @Override // com.baidu.aip.face.PreviewView
    public void setScaleType(PreviewView.ScaleType scaleType) {
    }
}
