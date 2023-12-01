package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogChooseASongBinding.class */
public final class DialogChooseASongBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16303a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16304c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    private final ShapeConstraintLayout g;

    private DialogChooseASongBinding(ShapeConstraintLayout shapeConstraintLayout, SquareImageView squareImageView, TextView textView, ShapeTextView shapeTextView, TextView textView2, TextView textView3, TextView textView4) {
        this.g = shapeConstraintLayout;
        this.f16303a = squareImageView;
        this.b = textView;
        this.f16304c = shapeTextView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
    }

    public static DialogChooseASongBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_choose_a_song, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogChooseASongBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_con);
        if (squareImageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_con);
            if (textView != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_dg);
                if (shapeTextView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_music_name);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
                        if (textView3 != null) {
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_us_name);
                            if (textView4 != null) {
                                return new DialogChooseASongBinding((ShapeConstraintLayout) view, squareImageView, textView, shapeTextView, textView2, textView3, textView4);
                            }
                            str = "tvUsName";
                        } else {
                            str = "tvTitle";
                        }
                    } else {
                        str = "tvMusicName";
                    }
                } else {
                    str = "tvDg";
                }
            } else {
                str = "tvCon";
            }
        } else {
            str = "ivCon";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.g;
    }
}
