package com.weimob.library.groups.imageloader.drawee;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.weimob.library.groups.imageloader.core.DisplayImageOptions;
import com.weimob.library.groups.imageloader.core.ImageLoader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/drawee/RichTextView.class */
public class RichTextView extends TextView {
    private MultiDraweeHolder<GenericDraweeHierarchy> mMultiDraweeHolder;

    public RichTextView(Context context) {
        super(context);
        init();
    }

    public RichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public RichTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public RichTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        this.mMultiDraweeHolder = new MultiDraweeHolder<>();
    }

    public void addDraweeHolder(DraweeHolder<GenericDraweeHierarchy> draweeHolder) {
        if (draweeHolder != null) {
            this.mMultiDraweeHolder.add(draweeHolder);
        }
    }

    public List<DraweeHolder> getOldDraweeHolderList() {
        ArrayList arrayList = new ArrayList();
        int size = this.mMultiDraweeHolder.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return arrayList;
            }
            arrayList.add(this.mMultiDraweeHolder.get(i2));
            i = i2 + 1;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mMultiDraweeHolder.onAttach();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mMultiDraweeHolder.onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.mMultiDraweeHolder.onAttach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mMultiDraweeHolder.onDetach();
    }

    public void release() {
        this.mMultiDraweeHolder.clear();
    }

    public void setRichText(String str, int i, int i2) {
        setRichText(str, new DisplayImageOptions.Builder(getContext()).targetSize(i, i2).cornersRadius(5.0f).build());
    }

    public void setRichText(String str, DisplayImageOptions displayImageOptions) {
        ImageLoader.getInstance().displayRichText(str, this, displayImageOptions);
    }
}
