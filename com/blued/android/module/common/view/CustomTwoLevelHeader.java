package com.blued.android.module.common.view;

import android.content.Context;
import android.util.AttributeSet;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.header.TwoLevelHeader;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/CustomTwoLevelHeader.class */
public class CustomTwoLevelHeader extends TwoLevelHeader {
    RefreshState a;
    RefreshLayout b;
    private boolean o;

    public CustomTwoLevelHeader(Context context) {
        super(context);
        this.o = false;
    }

    public CustomTwoLevelHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = false;
    }

    public void a() {
        this.o = true;
        RefreshLayout refreshLayout = this.b;
        if (refreshLayout != null) {
            a(refreshLayout, this.a, RefreshState.i);
        }
    }

    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        this.a = refreshState;
        if (refreshLayout != null) {
            this.b = refreshLayout;
        }
        if (refreshState2 != RefreshState.i || this.o) {
            super.a(refreshLayout, refreshState, refreshState2);
        }
        this.o = false;
    }
}
