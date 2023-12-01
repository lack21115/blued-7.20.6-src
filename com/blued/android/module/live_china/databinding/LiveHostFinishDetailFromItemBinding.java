package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveHostFinishDetailFromItemBinding.class */
public final class LiveHostFinishDetailFromItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f12241a;
    public final View b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeConstraintLayout f12242c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    private final FrameLayout g;

    private LiveHostFinishDetailFromItemBinding(FrameLayout frameLayout, View view, View view2, ShapeConstraintLayout shapeConstraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.g = frameLayout;
        this.f12241a = view;
        this.b = view2;
        this.f12242c = shapeConstraintLayout;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
    }

    public static LiveHostFinishDetailFromItemBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.divide_1);
        if (findViewById != null) {
            View findViewById2 = view.findViewById(R.id.divide_2);
            if (findViewById2 != null) {
                ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.item_view);
                if (shapeConstraintLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_des);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_tip);
                            if (textView3 != null) {
                                return new LiveHostFinishDetailFromItemBinding((FrameLayout) view, findViewById, findViewById2, shapeConstraintLayout, textView, textView2, textView3);
                            }
                            str = "tvTip";
                        } else {
                            str = "tvName";
                        }
                    } else {
                        str = "tvDes";
                    }
                } else {
                    str = "itemView";
                }
            } else {
                str = "divide2";
            }
        } else {
            str = "divide1";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.g;
    }
}
