package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/ItemFeedPostLocationBinding.class */
public final class ItemFeedPostLocationBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f18967a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f18968c;
    private final LinearLayout d;

    private ItemFeedPostLocationBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.d = linearLayout;
        this.f18967a = imageView;
        this.b = textView;
        this.f18968c = textView2;
    }

    public static ItemFeedPostLocationBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static ItemFeedPostLocationBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_feed_post_location, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemFeedPostLocationBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivSelect);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tvLocation);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.tvName);
                if (textView2 != null) {
                    return new ItemFeedPostLocationBinding((LinearLayout) view, imageView, textView, textView2);
                }
                str = "tvName";
            } else {
                str = "tvLocation";
            }
        } else {
            str = "ivSelect";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
