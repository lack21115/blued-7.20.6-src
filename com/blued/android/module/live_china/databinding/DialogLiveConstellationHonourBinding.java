package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveConstellationHonourBinding.class */
public final class DialogLiveConstellationHonourBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final ImageView c;
    public final FrameLayout d;
    public final RecyclerView e;
    private final FrameLayout f;

    private DialogLiveConstellationHonourBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, FrameLayout frameLayout3, RecyclerView recyclerView) {
        this.f = frameLayout;
        this.a = frameLayout2;
        this.b = imageView;
        this.c = imageView2;
        this.d = frameLayout3;
        this.e = recyclerView;
    }

    public static DialogLiveConstellationHonourBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveConstellationHonourBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_constellation_honour, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveConstellationHonourBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_constellation_main);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_constellation_close);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.live_constellation_item_bg_frame);
                if (imageView2 != null) {
                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.ll_default);
                    if (frameLayout2 != null) {
                        RecyclerView findViewById = view.findViewById(R.id.recycler_spoken);
                        if (findViewById != null) {
                            return new DialogLiveConstellationHonourBinding((FrameLayout) view, frameLayout, imageView, imageView2, frameLayout2, findViewById);
                        }
                        str = "recyclerSpoken";
                    } else {
                        str = "llDefault";
                    }
                } else {
                    str = "liveConstellationItemBgFrame";
                }
            } else {
                str = "ivConstellationClose";
            }
        } else {
            str = "flConstellationMain";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f;
    }
}
