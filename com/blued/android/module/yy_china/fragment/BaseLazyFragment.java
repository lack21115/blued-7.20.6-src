package com.blued.android.module.yy_china.fragment;

import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/BaseLazyFragment.class */
public class BaseLazyFragment extends BaseFragment {
    private final String a = "BaseLazyFragment";
    private boolean b;

    public void a() {
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.d(Intrinsics.a(this.a, (Object) " --> onDestroyView ... "));
        this.b = false;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        LogUtils.d(this.a + " --> onResume isLoad: " + this.b);
        if (this.b) {
            return;
        }
        a();
        this.b = true;
    }
}
