package com.blued.android.module.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/ObservableScrollView.class */
public class ObservableScrollView extends ScrollView {
    private ScrollViewListener a;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/ObservableScrollView$ScrollViewListener.class */
    public interface ScrollViewListener {
        void onScrollChanged(ObservableScrollView observableScrollView, int i, int i2, int i3, int i4);
    }

    public ObservableScrollView(Context context) {
        super(context);
        this.a = null;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        ScrollViewListener scrollViewListener = this.a;
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.a = scrollViewListener;
    }
}
