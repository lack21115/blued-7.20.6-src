package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.FragmentTabHost;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/MyFragmentTabHost.class */
public class MyFragmentTabHost extends FragmentTabHost {
    public MyFragmentTabHost(Context context) {
        super(context);
    }

    public MyFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.fragment.app.FragmentTabHost, android.widget.TabHost, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
