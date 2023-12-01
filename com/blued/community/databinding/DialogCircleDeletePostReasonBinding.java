package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/DialogCircleDeletePostReasonBinding.class */
public final class DialogCircleDeletePostReasonBinding implements ViewBinding {
    public final RadioButton a;
    public final RadioButton b;
    public final RadioButton c;
    public final RadioButton d;
    public final RadioButton e;
    public final RadioButton f;
    public final ImageView g;
    public final ShapeLinearLayout h;
    public final RadioGroup i;
    public final FrameLayout j;
    public final TextView k;
    private final FrameLayout l;

    private DialogCircleDeletePostReasonBinding(FrameLayout frameLayout, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, ImageView imageView, ShapeLinearLayout shapeLinearLayout, RadioGroup radioGroup, FrameLayout frameLayout2, TextView textView) {
        this.l = frameLayout;
        this.a = radioButton;
        this.b = radioButton2;
        this.c = radioButton3;
        this.d = radioButton4;
        this.e = radioButton5;
        this.f = radioButton6;
        this.g = imageView;
        this.h = shapeLinearLayout;
        this.i = radioGroup;
        this.j = frameLayout2;
        this.k = textView;
    }

    public static DialogCircleDeletePostReasonBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogCircleDeletePostReasonBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_circle_delete_post_reason, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogCircleDeletePostReasonBinding a(View view) {
        String str;
        RadioButton radioButton = (RadioButton) view.findViewById(R.id.RadioButton1);
        if (radioButton != null) {
            RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.RadioButton2);
            if (radioButton2 != null) {
                RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.RadioButton3);
                if (radioButton3 != null) {
                    RadioButton radioButton4 = (RadioButton) view.findViewById(R.id.RadioButton4);
                    if (radioButton4 != null) {
                        RadioButton radioButton5 = (RadioButton) view.findViewById(R.id.RadioButton5);
                        if (radioButton5 != null) {
                            RadioButton radioButton6 = (RadioButton) view.findViewById(R.id.RadioButton6);
                            if (radioButton6 != null) {
                                ImageView imageView = (ImageView) view.findViewById(R.id.ivClose);
                                if (imageView != null) {
                                    ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.layoutReadAuth);
                                    if (shapeLinearLayout != null) {
                                        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
                                        if (radioGroup != null) {
                                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.rootLayout);
                                            if (frameLayout != null) {
                                                TextView textView = (TextView) view.findViewById(R.id.tvDelete);
                                                if (textView != null) {
                                                    return new DialogCircleDeletePostReasonBinding((FrameLayout) view, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, imageView, shapeLinearLayout, radioGroup, frameLayout, textView);
                                                }
                                                str = "tvDelete";
                                            } else {
                                                str = "rootLayout";
                                            }
                                        } else {
                                            str = "radioGroup";
                                        }
                                    } else {
                                        str = "layoutReadAuth";
                                    }
                                } else {
                                    str = "ivClose";
                                }
                            } else {
                                str = "RadioButton6";
                            }
                        } else {
                            str = "RadioButton5";
                        }
                    } else {
                        str = "RadioButton4";
                    }
                } else {
                    str = "RadioButton3";
                }
            } else {
                str = "RadioButton2";
            }
        } else {
            str = "RadioButton1";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.l;
    }
}
