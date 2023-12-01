package com.weimob.library.groups.imageloader.drawee;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/drawee/ImageDraweeView.class */
public class ImageDraweeView extends SimpleDraweeView {
    private boolean isAutoDetach;

    public ImageDraweeView(Context context) {
        super(context);
        this.isAutoDetach = true;
    }

    public ImageDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isAutoDetach = true;
        checkFrescoAttrs(context, attributeSet);
    }

    public ImageDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isAutoDetach = true;
        checkFrescoAttrs(context, attributeSet);
    }

    public ImageDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isAutoDetach = true;
        checkFrescoAttrs(context, attributeSet);
    }

    public ImageDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        this.isAutoDetach = true;
    }

    private void checkFrescoAttrs(Context context, AttributeSet attributeSet) {
        if (context.obtainStyledAttributes(attributeSet, R.styleable.GenericDraweeHierarchy).getIndexCount() > 0) {
            throw new IllegalStateException("禁止在xml中配置属性，请使用 DisplayImageOptions");
        }
    }

    public void detach() {
        this.isAutoDetach = true;
        super.doDetach();
    }

    protected void doDetach() {
        if (this.isAutoDetach) {
            super.doDetach();
        }
    }

    public boolean isAutoDetach() {
        return this.isAutoDetach;
    }

    protected void onDetachedFromWindow() {
        if (this.isAutoDetach) {
            super.onDetachedFromWindow();
        }
    }

    public void onStartTemporaryDetach() {
        if (this.isAutoDetach) {
            super.onStartTemporaryDetach();
        }
    }

    public void setAutoDetach(boolean z) {
        this.isAutoDetach = z;
    }
}
