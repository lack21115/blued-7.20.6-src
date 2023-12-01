package com.blued.android.module.common.base.mvi;

import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/BaseListFragment$initView$3.class */
public final class BaseListFragment$initView$3 extends RecyclerView.AdapterDataObserver {
    final /* synthetic */ BaseListFragment<VM, M> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseListFragment$initView$3(BaseListFragment<VM, M> baseListFragment) {
        this.a = baseListFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BaseListFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.s();
    }

    public void onChanged() {
        super.onChanged();
        NoDataAndLoadFailView c = this.a.c();
        if (c == null) {
            return;
        }
        final BaseListFragment<VM, M> baseListFragment = this.a;
        c.postDelayed(new Runnable() { // from class: com.blued.android.module.common.base.mvi.-$$Lambda$BaseListFragment$initView$3$pqLMVmkwiMr-SpLSI1H9I1NJQUs
            @Override // java.lang.Runnable
            public final void run() {
                BaseListFragment$initView$3.a(BaseListFragment.this);
            }
        }, 200L);
    }
}
