package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bp;
import com.baidu.mobads.sdk.internal.w;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/FeedNativeView.class */
public class FeedNativeView extends RelativeLayout {
    private View mAdView;
    private Context mContext;
    private ClassLoader mLoader;

    public FeedNativeView(Context context) {
        super(context);
        init(context);
    }

    public FeedNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FeedNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mLoader = bp.a(context);
        View view = (View) ar.a(w.e, this.mLoader, new Class[]{Context.class}, context);
        this.mAdView = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void changeViewLayoutParams(Object obj) {
        if (this.mAdView != null) {
            ar.a(w.e, this.mAdView, this.mLoader, "changeLayoutParams", new Class[]{Object.class}, obj);
        }
    }

    public int getAdContainerHeight() {
        if (this.mAdView != null) {
            Object a2 = ar.a(w.e, this.mAdView, this.mLoader, "getAdContainerHeight", new Class[0], new Object[0]);
            if (a2 instanceof Number) {
                return ((Integer) a2).intValue();
            }
            return 0;
        }
        return 0;
    }

    public int getAdContainerWidth() {
        if (this.mAdView != null) {
            Object a2 = ar.a(w.e, this.mAdView, this.mLoader, "getAdContainerWidth", new Class[0], new Object[0]);
            if (a2 instanceof Number) {
                return ((Integer) a2).intValue();
            }
            return 0;
        }
        return 0;
    }

    public RelativeLayout getContainerView() {
        if (this.mAdView != null) {
            return (RelativeLayout) ar.a(w.e, this.mAdView, this.mLoader, "getAdView", new Class[0], new Object[0]);
        }
        return null;
    }

    public void setAdData(XAdNativeResponse xAdNativeResponse) {
        if (this.mAdView != null) {
            ar.a(w.e, this.mAdView, this.mLoader, "setAdResponse", new Class[]{Object.class}, xAdNativeResponse);
        }
    }
}
