package com.soft.blued.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentVirtualImageSettingBinding.class */
public final class FragmentVirtualImageSettingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeFrameLayout f29031a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29032c;
    public final TextView d;
    private final RelativeLayout e;

    private FragmentVirtualImageSettingBinding(RelativeLayout relativeLayout, ShapeFrameLayout shapeFrameLayout, TextView textView, TextView textView2, TextView textView3) {
        this.e = relativeLayout;
        this.f29031a = shapeFrameLayout;
        this.b = textView;
        this.f29032c = textView2;
        this.d = textView3;
    }

    public static FragmentVirtualImageSettingBinding a(View view) {
        String str;
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.sfl_display_selected_bg);
        if (shapeFrameLayout != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_delete_vi);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.tv_display_avatar);
                if (textView2 != null) {
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_display_none);
                    if (textView3 != null) {
                        return new FragmentVirtualImageSettingBinding((RelativeLayout) view, shapeFrameLayout, textView, textView2, textView3);
                    }
                    str = "tvDisplayNone";
                } else {
                    str = "tvDisplayAvatar";
                }
            } else {
                str = "tvDeleteVi";
            }
        } else {
            str = "sflDisplaySelectedBg";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.e;
    }
}
