package com.blued.android.module.common.utils.click;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/SingleItemChildClickProxy.class */
public class SingleItemChildClickProxy implements BaseQuickAdapter.OnItemChildClickListener {
    private BaseQuickAdapter.OnItemChildClickListener a;
    private long b = 0;
    private long c = 1000;
    private IClickAgain d;

    public SingleItemChildClickProxy(BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener) {
        this.a = onItemChildClickListener;
    }

    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        if (System.currentTimeMillis() - this.b >= this.c) {
            this.a.onItemChildClick(baseQuickAdapter, view, i);
            this.b = System.currentTimeMillis();
            return;
        }
        IClickAgain iClickAgain = this.d;
        if (iClickAgain != null) {
            iClickAgain.onAgain();
        }
    }
}
