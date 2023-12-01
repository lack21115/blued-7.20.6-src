package com.huawei.hms.ads.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.NativeWindowImageView;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/MediaView.class */
public class MediaView extends RelativeLayout {
    private ImageView.ScaleType B;
    private NativeVideoView Code;
    private b I;
    private NativeWindowImageView V;

    public MediaView(Context context) {
        super(context);
        Code(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Code(context);
    }

    private void Code(Context context) {
        setGravity(17);
        NativeVideoView nativeVideoView = new NativeVideoView(context);
        this.Code = nativeVideoView;
        nativeVideoView.setAudioFocusType(1);
        this.Code.setVisibility(4);
        addView(this.Code);
        this.V = new NativeWindowImageView(context);
        this.V.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.V.setVisibility(4);
        addView(this.V);
        this.I = new b(this.Code, this.V);
    }

    public void Code() {
        this.Code.destroyView();
    }

    public b getMediaViewAdapter() {
        return this.I;
    }

    public NativeWindowImageView getNativeWindowImageView() {
        return this.V;
    }

    public NativeVideoView getVideoView() {
        return this.Code;
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.B = scaleType;
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.Code.setMediaContent(mediaContent);
    }

    public void setRectCornerRadius(float f) {
        this.V.setRectCornerRadius(f);
        this.Code.setRectCornerRadius(f);
    }
}
