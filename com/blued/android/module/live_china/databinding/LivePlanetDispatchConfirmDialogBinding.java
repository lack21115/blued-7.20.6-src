package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LivePlanetDispatchConfirmDialogBinding.class */
public final class LivePlanetDispatchConfirmDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f12364a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12365c;
    public final RelativeLayout d;
    public final ShapeTextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    private final FrameLayout j;

    private LivePlanetDispatchConfirmDialogBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, ShapeTextView shapeTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.j = frameLayout;
        this.f12364a = frameLayout2;
        this.b = imageView;
        this.f12365c = imageView2;
        this.d = relativeLayout;
        this.e = shapeTextView;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
    }

    public static LivePlanetDispatchConfirmDialogBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LivePlanetDispatchConfirmDialogBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_planet_dispatch_confirm_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LivePlanetDispatchConfirmDialogBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_root);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_checkbox);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_close);
                if (imageView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_checkbox);
                    if (relativeLayout != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_affirm);
                        if (shapeTextView != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_checkbox);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_dispatch_count);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_dispatch_hint);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_title);
                                        if (textView4 != null) {
                                            return new LivePlanetDispatchConfirmDialogBinding((FrameLayout) view, frameLayout, imageView, imageView2, relativeLayout, shapeTextView, textView, textView2, textView3, textView4);
                                        }
                                        str = "tvTitle";
                                    } else {
                                        str = "tvDispatchHint";
                                    }
                                } else {
                                    str = "tvDispatchCount";
                                }
                            } else {
                                str = "tvCheckbox";
                            }
                        } else {
                            str = "tvAffirm";
                        }
                    } else {
                        str = "rlCheckbox";
                    }
                } else {
                    str = "ivClose";
                }
            } else {
                str = "ivCheckbox";
            }
        } else {
            str = "flRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.j;
    }
}
