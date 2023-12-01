package com.blued.android.module.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/ObservableScrollView.class */
public class ObservableScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private ScrollViewListener f11010a;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/ObservableScrollView$ScrollViewListener.class */
    public interface ScrollViewListener {
        void onScrollChanged(ObservableScrollView observableScrollView, int i, int i2, int i3, int i4);
    }

    public ObservableScrollView(Context context) {
        super(context);
        this.f11010a = null;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11010a = null;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11010a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        ScrollViewListener scrollViewListener = this.f11010a;
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.f11010a = scrollViewListener;
    }
}
