package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveCommentTipViewBinding.class */
public final class LiveCommentTipViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f12158a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12159c;
    private final CardView d;

    private LiveCommentTipViewBinding(CardView cardView, ImageView imageView, TextView textView, TextView textView2) {
        this.d = cardView;
        this.f12158a = imageView;
        this.b = textView;
        this.f12159c = textView2;
    }

    public static LiveCommentTipViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_comment_tip_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveCommentTipViewBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_content);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                if (textView2 != null) {
                    return new LiveCommentTipViewBinding((CardView) view, imageView, textView, textView2);
                }
                str = "tvName";
            } else {
                str = "tvContent";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public CardView getRoot() {
        return this.d;
    }
}
