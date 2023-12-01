package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/view/ResizeableLayout.class */
public class ResizeableLayout extends RelativeLayout {
    private int mHeight;
    private SizeChangeListener mSizeChangeListener;
    private int mWidth;

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/view/ResizeableLayout$SizeChangeListener.class */
    public interface SizeChangeListener {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public ResizeableLayout(Context context) {
        super(context);
        this.mHeight = 0;
        this.mSizeChangeListener = null;
        this.mWidth = 0;
    }

    public ResizeableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHeight = 0;
        this.mSizeChangeListener = null;
        this.mWidth = 0;
    }

    public ResizeableLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHeight = 0;
        this.mSizeChangeListener = null;
        this.mWidth = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        SizeChangeListener sizeChangeListener = this.mSizeChangeListener;
        if (sizeChangeListener != null) {
            sizeChangeListener.onSizeChanged(getWidth(), getHeight(), this.mWidth, this.mHeight);
        }
        this.mHeight = getHeight();
        this.mWidth = getWidth();
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setSizeChangeListener(SizeChangeListener sizeChangeListener) {
        this.mSizeChangeListener = sizeChangeListener;
    }
}
