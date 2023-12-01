package com.blued.android.module.common.utils.click;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/SingleItemChildClickProxy.class */
public class SingleItemChildClickProxy implements BaseQuickAdapter.OnItemChildClickListener {

    /* renamed from: a  reason: collision with root package name */
    private BaseQuickAdapter.OnItemChildClickListener f10925a;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f10926c = 1000;
    private IClickAgain d;

    public SingleItemChildClickProxy(BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener) {
        this.f10925a = onItemChildClickListener;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        if (System.currentTimeMillis() - this.b >= this.f10926c) {
            this.f10925a.onItemChildClick(baseQuickAdapter, view, i);
            this.b = System.currentTimeMillis();
            return;
        }
        IClickAgain iClickAgain = this.d;
        if (iClickAgain != null) {
            iClickAgain.onAgain();
        }
    }
}
