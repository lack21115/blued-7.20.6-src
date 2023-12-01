package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopMsgListCheatBinding.class */
public final class PopMsgListCheatBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f15855a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f15856c;
    public final TextView d;
    private final FrameLayout e;

    private PopMsgListCheatBinding(FrameLayout frameLayout, TextView textView, TextView textView2, ShapeTextView shapeTextView, TextView textView3) {
        this.e = frameLayout;
        this.f15855a = textView;
        this.b = textView2;
        this.f15856c = shapeTextView;
        this.d = textView3;
    }

    public static PopMsgListCheatBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.tv_close);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(2131371186);
            if (textView2 != null) {
                ShapeTextView findViewById = view.findViewById(R.id.tv_info);
                if (findViewById != null) {
                    TextView textView3 = (TextView) view.findViewById(2131372754);
                    if (textView3 != null) {
                        return new PopMsgListCheatBinding((FrameLayout) view, textView, textView2, findViewById, textView3);
                    }
                    str = "tvTitle";
                } else {
                    str = "tvInfo";
                }
            } else {
                str = "tvContent";
            }
        } else {
            str = "tvClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
