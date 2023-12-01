package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyKtvPrizeDialogBinding.class */
public final class FragmentYyKtvPrizeDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f16521a;
    public final ShapeableImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16522c;
    public final TextView d;
    public final TextView e;
    private final ConstraintLayout f;

    private FragmentYyKtvPrizeDialogBinding(ConstraintLayout constraintLayout, View view, ShapeableImageView shapeableImageView, TextView textView, TextView textView2, TextView textView3) {
        this.f = constraintLayout;
        this.f16521a = view;
        this.b = shapeableImageView;
        this.f16522c = textView;
        this.d = textView2;
        this.e = textView3;
    }

    public static FragmentYyKtvPrizeDialogBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv_singer_header);
            if (shapeableImageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.iv_singer_name);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_hand_count);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_prize_count);
                        if (textView3 != null) {
                            return new FragmentYyKtvPrizeDialogBinding((ConstraintLayout) view, findViewById, shapeableImageView, textView, textView2, textView3);
                        }
                        str = "tvPrizeCount";
                    } else {
                        str = "tvHandCount";
                    }
                } else {
                    str = "ivSingerName";
                }
            } else {
                str = "ivSingerHeader";
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
