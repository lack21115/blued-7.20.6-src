package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentEventSignBinding.class */
public final class FragmentEventSignBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f18858a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f18859c;
    public final FrameLayout d;
    public final View e;
    public final TextView f;
    private final LinearLayout g;

    private FragmentEventSignBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, ImageView imageView2, FrameLayout frameLayout, View view, TextView textView2) {
        this.g = linearLayout;
        this.f18858a = imageView;
        this.b = textView;
        this.f18859c = imageView2;
        this.d = frameLayout;
        this.e = view;
        this.f = textView2;
    }

    public static FragmentEventSignBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static FragmentEventSignBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_event_sign, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentEventSignBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.event_sign_close);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.event_sign_des);
            if (textView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.event_sign_dlg_bg);
                if (imageView2 != null) {
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.event_sign_inner_bg);
                    if (frameLayout != null) {
                        View findViewById = view.findViewById(R.id.event_sign_outer_bg);
                        if (findViewById != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.event_sign_title);
                            if (textView2 != null) {
                                return new FragmentEventSignBinding((LinearLayout) view, imageView, textView, imageView2, frameLayout, findViewById, textView2);
                            }
                            str = "eventSignTitle";
                        } else {
                            str = "eventSignOuterBg";
                        }
                    } else {
                        str = "eventSignInnerBg";
                    }
                } else {
                    str = "eventSignDlgBg";
                }
            } else {
                str = "eventSignDes";
            }
        } else {
            str = "eventSignClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.g;
    }
}
