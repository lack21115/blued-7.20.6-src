package com.scwang.smartrefresh.layout.api;

import android.view.View;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.listener.OnStateChangedListener;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/api/RefreshInternal.class */
public interface RefreshInternal extends OnStateChangedListener {
    int a(RefreshLayout refreshLayout, boolean z);

    void a(float f, int i, int i2);

    void a(RefreshKernel refreshKernel, int i, int i2);

    void a(RefreshLayout refreshLayout, int i, int i2);

    void a(boolean z, float f, int i, int i2, int i3);

    void b(RefreshLayout refreshLayout, int i, int i2);

    boolean b();

    SpinnerStyle getSpinnerStyle();

    View getView();

    void setPrimaryColors(int... iArr);
}
