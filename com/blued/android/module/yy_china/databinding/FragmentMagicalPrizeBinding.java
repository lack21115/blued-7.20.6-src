package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentMagicalPrizeBinding.class */
public final class FragmentMagicalPrizeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16477a;
    public final View b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16478c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;
    private final ConstraintLayout g;

    private FragmentMagicalPrizeBinding(ConstraintLayout constraintLayout, ImageView imageView, View view, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2) {
        this.g = constraintLayout;
        this.f16477a = imageView;
        this.b = view;
        this.f16478c = imageView2;
        this.d = imageView3;
        this.e = textView;
        this.f = textView2;
    }

    public static FragmentMagicalPrizeBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.btn_got);
        if (imageView != null) {
            View findViewById = view.findViewById(R.id.cover_view);
            if (findViewById != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.img_prize);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.root_view);
                    if (imageView3 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_find_out);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_prize_name);
                            if (textView2 != null) {
                                return new FragmentMagicalPrizeBinding((ConstraintLayout) view, imageView, findViewById, imageView2, imageView3, textView, textView2);
                            }
                            str = "tvPrizeName";
                        } else {
                            str = "tvFindOut";
                        }
                    } else {
                        str = "rootView";
                    }
                } else {
                    str = "imgPrize";
                }
            } else {
                str = "coverView";
            }
        } else {
            str = "btnGot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
