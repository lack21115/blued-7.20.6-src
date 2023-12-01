package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYKtvPro2View;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewKtvGiftProBinding.class */
public final class ViewKtvGiftProBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16860a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16861c;
    public final ShapeLinearLayout d;
    public final YYKtvPro2View e;
    private final ConstraintLayout f;

    private ViewKtvGiftProBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ShapeLinearLayout shapeLinearLayout, YYKtvPro2View yYKtvPro2View) {
        this.f = constraintLayout;
        this.f16860a = constraintLayout2;
        this.b = textView;
        this.f16861c = textView2;
        this.d = shapeLinearLayout;
        this.e = yYKtvPro2View;
    }

    public static ViewKtvGiftProBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_ktv_gift_pro, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewKtvGiftProBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cons);
        if (constraintLayout != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_add_ktv_num);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.tv_ktv_num);
                if (textView2 != null) {
                    ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.tv_music_pro_style);
                    if (shapeLinearLayout != null) {
                        YYKtvPro2View yYKtvPro2View = (YYKtvPro2View) view.findViewById(R.id.yy_pro);
                        if (yYKtvPro2View != null) {
                            return new ViewKtvGiftProBinding((ConstraintLayout) view, constraintLayout, textView, textView2, shapeLinearLayout, yYKtvPro2View);
                        }
                        str = "yyPro";
                    } else {
                        str = "tvMusicProStyle";
                    }
                } else {
                    str = "tvKtvNum";
                }
            } else {
                str = "tvAddKtvNum";
            }
        } else {
            str = "cons";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
