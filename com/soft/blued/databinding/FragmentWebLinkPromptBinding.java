package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentWebLinkPromptBinding.class */
public final class FragmentWebLinkPromptBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f15346a;
    public final CommonTopTitleNoTrans b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f15347c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    private final LinearLayout g;

    private FragmentWebLinkPromptBinding(LinearLayout linearLayout, ImageView imageView, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.g = linearLayout;
        this.f15346a = imageView;
        this.b = commonTopTitleNoTrans;
        this.f15347c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
    }

    public static FragmentWebLinkPromptBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_prompt_icon);
        if (imageView != null) {
            CommonTopTitleNoTrans findViewById = view.findViewById(R.id.top_title);
            if (findViewById != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_prompt_continue);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_prompt_desc);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_prompt_title);
                        if (textView3 != null) {
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_prompt_url);
                            if (textView4 != null) {
                                return new FragmentWebLinkPromptBinding((LinearLayout) view, imageView, findViewById, textView, textView2, textView3, textView4);
                            }
                            str = "tvPromptUrl";
                        } else {
                            str = "tvPromptTitle";
                        }
                    } else {
                        str = "tvPromptDesc";
                    }
                } else {
                    str = "tvPromptContinue";
                }
            } else {
                str = "topTitle";
            }
        } else {
            str = "ivPromptIcon";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.g;
    }
}
