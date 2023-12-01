package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.scrollpicker.StringScrollPicker;
import com.soft.blued.R;
import com.soft.blued.ui.find.view.ExpandLinearLayout;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/LayoutFilterCommonSelectorBinding.class */
public final class LayoutFilterCommonSelectorBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f15701a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final StringScrollPicker f15702c;
    public final StringScrollPicker d;
    public final ExpandLinearLayout e;
    public final TextView f;
    public final TextView g;
    private final LinearLayout h;

    private LayoutFilterCommonSelectorBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, ImageView imageView, StringScrollPicker stringScrollPicker, StringScrollPicker stringScrollPicker2, ExpandLinearLayout expandLinearLayout, TextView textView, TextView textView2) {
        this.h = linearLayout;
        this.f15701a = relativeLayout;
        this.b = imageView;
        this.f15702c = stringScrollPicker;
        this.d = stringScrollPicker2;
        this.e = expandLinearLayout;
        this.f = textView;
        this.g = textView2;
    }

    public static LayoutFilterCommonSelectorBinding a(View view) {
        String str;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.filter_item_select_view);
        if (relativeLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_filter_item_arrow);
            if (imageView != null) {
                StringScrollPicker findViewById = view.findViewById(R.id.ssp_filter_left);
                if (findViewById != null) {
                    StringScrollPicker findViewById2 = view.findViewById(R.id.ssp_filter_right);
                    if (findViewById2 != null) {
                        ExpandLinearLayout expandLinearLayout = (ExpandLinearLayout) view.findViewById(R.id.ssp_filter_root_view);
                        if (expandLinearLayout != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_filter_item_select_content);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_filter_select_title);
                                if (textView2 != null) {
                                    return new LayoutFilterCommonSelectorBinding((LinearLayout) view, relativeLayout, imageView, findViewById, findViewById2, expandLinearLayout, textView, textView2);
                                }
                                str = "tvFilterSelectTitle";
                            } else {
                                str = "tvFilterItemSelectContent";
                            }
                        } else {
                            str = "sspFilterRootView";
                        }
                    } else {
                        str = "sspFilterRight";
                    }
                } else {
                    str = "sspFilterLeft";
                }
            } else {
                str = "ivFilterItemArrow";
            }
        } else {
            str = "filterItemSelectView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.h;
    }
}
