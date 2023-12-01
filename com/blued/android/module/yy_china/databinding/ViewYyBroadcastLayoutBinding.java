package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyBroadcastLayoutBinding.class */
public final class ViewYyBroadcastLayoutBinding implements ViewBinding {
    public final ShapeTextView a;
    public final EditText b;
    public final FrameLayout c;
    public final ImageView d;
    public final ImageView e;
    public final LinearLayout f;
    public final ScrollView g;
    public final TextView h;
    private final RelativeLayout i;

    private ViewYyBroadcastLayoutBinding(RelativeLayout relativeLayout, ShapeTextView shapeTextView, EditText editText, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ScrollView scrollView, TextView textView) {
        this.i = relativeLayout;
        this.a = shapeTextView;
        this.b = editText;
        this.c = frameLayout;
        this.d = imageView;
        this.e = imageView2;
        this.f = linearLayout;
        this.g = scrollView;
        this.h = textView;
    }

    public static ViewYyBroadcastLayoutBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_save);
        if (shapeTextView != null) {
            EditText editText = (EditText) view.findViewById(R.id.et_broadcast_view);
            if (editText != null) {
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_loading_view);
                if (frameLayout != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_close);
                        if (imageView2 != null) {
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_root);
                            if (linearLayout != null) {
                                ScrollView scrollView = (ScrollView) view.findViewById(R.id.scll);
                                if (scrollView != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_title);
                                    if (textView != null) {
                                        return new ViewYyBroadcastLayoutBinding((RelativeLayout) view, shapeTextView, editText, frameLayout, imageView, imageView2, linearLayout, scrollView, textView);
                                    }
                                    str = "tvTitle";
                                } else {
                                    str = "scll";
                                }
                            } else {
                                str = "llRoot";
                            }
                        } else {
                            str = "ivClose";
                        }
                    } else {
                        str = "iv";
                    }
                } else {
                    str = "flLoadingView";
                }
            } else {
                str = "etBroadcastView";
            }
        } else {
            str = "btnSave";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.i;
    }
}
