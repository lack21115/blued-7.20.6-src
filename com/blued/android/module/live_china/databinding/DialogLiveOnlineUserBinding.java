package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveOnlineUserBinding.class */
public final class DialogLiveOnlineUserBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ShapeTextView b;
    public final ShapeTextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final ViewPager2 h;
    private final ShapeRelativeLayout i;

    private DialogLiveOnlineUserBinding(ShapeRelativeLayout shapeRelativeLayout, ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, ViewPager2 viewPager2) {
        this.i = shapeRelativeLayout;
        this.a = constraintLayout;
        this.b = shapeTextView;
        this.c = shapeTextView2;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
        this.h = viewPager2;
    }

    public static DialogLiveOnlineUserBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveOnlineUserBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_online_user, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveOnlineUserBinding a(View view) {
        String str;
        ConstraintLayout findViewById = view.findViewById(R.id.cl_online_user_title);
        if (findViewById != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.stv_online_noble_user_sel_bar);
            if (shapeTextView != null) {
                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.stv_online_user_sel_bar);
                if (shapeTextView2 != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_online_noble_user_count);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_online_noble_user_title);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_online_user_count);
                            if (textView3 != null) {
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_online_user_title);
                                if (textView4 != null) {
                                    ViewPager2 findViewById2 = view.findViewById(R.id.vp2_online_user);
                                    if (findViewById2 != null) {
                                        return new DialogLiveOnlineUserBinding((ShapeRelativeLayout) view, findViewById, shapeTextView, shapeTextView2, textView, textView2, textView3, textView4, findViewById2);
                                    }
                                    str = "vp2OnlineUser";
                                } else {
                                    str = "tvOnlineUserTitle";
                                }
                            } else {
                                str = "tvOnlineUserCount";
                            }
                        } else {
                            str = "tvOnlineNobleUserTitle";
                        }
                    } else {
                        str = "tvOnlineNobleUserCount";
                    }
                } else {
                    str = "stvOnlineUserSelBar";
                }
            } else {
                str = "stvOnlineNobleUserSelBar";
            }
        } else {
            str = "clOnlineUserTitle";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ShapeRelativeLayout getRoot() {
        return this.i;
    }
}
