package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.PopLiveActivityWebView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveMultiBinding.class */
public final class DialogLiveMultiBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CardView f11790a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f11791c;
    public final TextView d;
    public final PopLiveActivityWebView e;
    private final ConstraintLayout f;

    private DialogLiveMultiBinding(ConstraintLayout constraintLayout, CardView cardView, ImageView imageView, ImageView imageView2, TextView textView, PopLiveActivityWebView popLiveActivityWebView) {
        this.f = constraintLayout;
        this.f11790a = cardView;
        this.b = imageView;
        this.f11791c = imageView2;
        this.d = textView;
        this.e = popLiveActivityWebView;
    }

    public static DialogLiveMultiBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveMultiBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_multi, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveMultiBinding a(View view) {
        String str;
        CardView cardView = (CardView) view.findViewById(R.id.cv_content);
        if (cardView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_img);
                if (imageView2 != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_auto_close);
                    if (textView != null) {
                        PopLiveActivityWebView popLiveActivityWebView = (PopLiveActivityWebView) view.findViewById(R.id.web_view);
                        if (popLiveActivityWebView != null) {
                            return new DialogLiveMultiBinding((ConstraintLayout) view, cardView, imageView, imageView2, textView, popLiveActivityWebView);
                        }
                        str = "webView";
                    } else {
                        str = "tvAutoClose";
                    }
                } else {
                    str = "ivImg";
                }
            } else {
                str = "ivClose";
            }
        } else {
            str = "cvContent";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
