package com.blued.login.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.login.R;
import net.simonvt.datepicker.DatePicker;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/databinding/FmFinishProfile2Binding.class */
public final class FmFinishProfile2Binding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final DatePicker f6907a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f6908c;
    public final RelativeLayout d;
    public final CommonTopTitleNoTrans e;
    public final TextView f;
    public final TextView g;
    public final ShapeTextView h;
    private final ConstraintLayout i;

    private FmFinishProfile2Binding(ConstraintLayout constraintLayout, DatePicker datePicker, FrameLayout frameLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView, TextView textView2, ShapeTextView shapeTextView) {
        this.i = constraintLayout;
        this.f6907a = datePicker;
        this.b = frameLayout;
        this.f6908c = relativeLayout;
        this.d = relativeLayout2;
        this.e = commonTopTitleNoTrans;
        this.f = textView;
        this.g = textView2;
        this.h = shapeTextView;
    }

    public static FmFinishProfile2Binding a(View view) {
        String str;
        DatePicker findViewById = view.findViewById(R.id.datePicker);
        if (findViewById != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fm_hw);
            if (frameLayout != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_birthday);
                if (relativeLayout != null) {
                    RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_hw);
                    if (relativeLayout2 != null) {
                        CommonTopTitleNoTrans findViewById2 = view.findViewById(R.id.title);
                        if (findViewById2 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_birthday);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_height_weight);
                                if (textView2 != null) {
                                    ShapeTextView findViewById3 = view.findViewById(R.id.tv_next);
                                    if (findViewById3 != null) {
                                        return new FmFinishProfile2Binding((ConstraintLayout) view, findViewById, frameLayout, relativeLayout, relativeLayout2, findViewById2, textView, textView2, findViewById3);
                                    }
                                    str = "tvNext";
                                } else {
                                    str = "tvHeightWeight";
                                }
                            } else {
                                str = "tvBirthday";
                            }
                        } else {
                            str = "title";
                        }
                    } else {
                        str = "rlHw";
                    }
                } else {
                    str = "rlBirthday";
                }
            } else {
                str = "fmHw";
            }
        } else {
            str = "datePicker";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.i;
    }
}
