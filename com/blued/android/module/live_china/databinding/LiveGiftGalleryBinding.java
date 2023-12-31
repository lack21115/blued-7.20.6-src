package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveGiftGalleryBinding.class */
public final class LiveGiftGalleryBinding implements ViewBinding {
    public final LiveGiftGalleryHeaderBinding a;
    public final LinearLayout b;
    public final RecyclerView c;
    private final RelativeLayout d;

    private LiveGiftGalleryBinding(RelativeLayout relativeLayout, LiveGiftGalleryHeaderBinding liveGiftGalleryHeaderBinding, LinearLayout linearLayout, RecyclerView recyclerView) {
        this.d = relativeLayout;
        this.a = liveGiftGalleryHeaderBinding;
        this.b = linearLayout;
        this.c = recyclerView;
    }

    public static LiveGiftGalleryBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LiveGiftGalleryBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_gift_gallery, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveGiftGalleryBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.header_root);
        if (findViewById != null) {
            LiveGiftGalleryHeaderBinding a = LiveGiftGalleryHeaderBinding.a(findViewById);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_default);
            if (linearLayout != null) {
                RecyclerView findViewById2 = view.findViewById(R.id.rv_list);
                if (findViewById2 != null) {
                    return new LiveGiftGalleryBinding((RelativeLayout) view, a, linearLayout, findViewById2);
                }
                str = "rvList";
            } else {
                str = "llDefault";
            }
        } else {
            str = "headerRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.d;
    }
}
