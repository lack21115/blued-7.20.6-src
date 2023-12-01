package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentLiveBackgroundMusicBinding.class */
public final class FragmentLiveBackgroundMusicBinding implements ViewBinding {
    public final LinearLayout a;
    private final LinearLayout b;

    private FragmentLiveBackgroundMusicBinding(LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.b = linearLayout;
        this.a = linearLayout2;
    }

    public static FragmentLiveBackgroundMusicBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static FragmentLiveBackgroundMusicBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_live_background_music, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentLiveBackgroundMusicBinding a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll);
        if (linearLayout != null) {
            return new FragmentLiveBackgroundMusicBinding((LinearLayout) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("ll"));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.b;
    }
}
