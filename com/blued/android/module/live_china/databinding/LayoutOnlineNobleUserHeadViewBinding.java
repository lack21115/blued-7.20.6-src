package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LayoutOnlineNobleUserHeadViewBinding.class */
public final class LayoutOnlineNobleUserHeadViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f12106a;

    private LayoutOnlineNobleUserHeadViewBinding(RelativeLayout relativeLayout) {
        this.f12106a = relativeLayout;
    }

    public static LayoutOnlineNobleUserHeadViewBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LayoutOnlineNobleUserHeadViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_online_noble_user_head_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LayoutOnlineNobleUserHeadViewBinding a(View view) {
        if (view != null) {
            return new LayoutOnlineNobleUserHeadViewBinding((RelativeLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.f12106a;
    }
}
