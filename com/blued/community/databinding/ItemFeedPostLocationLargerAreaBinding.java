package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/ItemFeedPostLocationLargerAreaBinding.class */
public final class ItemFeedPostLocationLargerAreaBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f18969a;
    private final LinearLayout b;

    private ItemFeedPostLocationLargerAreaBinding(LinearLayout linearLayout, TextView textView) {
        this.b = linearLayout;
        this.f18969a = textView;
    }

    public static ItemFeedPostLocationLargerAreaBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static ItemFeedPostLocationLargerAreaBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_feed_post_location_larger_area, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemFeedPostLocationLargerAreaBinding a(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tvFooterName);
        if (textView != null) {
            return new ItemFeedPostLocationLargerAreaBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tvFooterName"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.b;
    }
}
