package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogFeedStyleBinding.class */
public final class DialogFeedStyleBinding implements ViewBinding {
    public final ShapeTextView a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final ConstraintLayout e;
    public final ShapeTextView f;
    public final CheckBox g;
    public final CheckBox h;
    public final CheckBox i;
    public final CheckBox j;
    public final View k;
    public final ImageView l;
    public final ImageView m;
    public final ImageView n;
    public final View o;
    public final ShapeConstraintLayout p;
    public final ConstraintLayout q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    private final ConstraintLayout u;

    private DialogFeedStyleBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ImageView imageView, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, ShapeTextView shapeTextView2, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, View view, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view2, ShapeConstraintLayout shapeConstraintLayout, ConstraintLayout constraintLayout3, TextView textView3, TextView textView4, TextView textView5) {
        this.u = constraintLayout;
        this.a = shapeTextView;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
        this.e = constraintLayout2;
        this.f = shapeTextView2;
        this.g = checkBox;
        this.h = checkBox2;
        this.i = checkBox3;
        this.j = checkBox4;
        this.k = view;
        this.l = imageView2;
        this.m = imageView3;
        this.n = imageView4;
        this.o = view2;
        this.p = shapeConstraintLayout;
        this.q = constraintLayout3;
        this.r = textView3;
        this.s = textView4;
        this.t = textView5;
    }

    public static DialogFeedStyleBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_cancel);
        if (shapeTextView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.btn_dialog_close);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.btn_post_all);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.btn_post_data);
                    if (textView2 != null) {
                        ConstraintLayout findViewById = view.findViewById(R.id.btn_post_text);
                        if (findViewById != null) {
                            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.btn_preview);
                            if (shapeTextView2 != null) {
                                CheckBox checkBox = (CheckBox) view.findViewById(R.id.check_box_audience);
                                if (checkBox != null) {
                                    CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.check_box_beans);
                                    if (checkBox2 != null) {
                                        CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.check_box_duration);
                                        if (checkBox3 != null) {
                                            CheckBox checkBox4 = (CheckBox) view.findViewById(R.id.check_box_wish);
                                            if (checkBox4 != null) {
                                                View findViewById2 = view.findViewById(R.id.cover_view);
                                                if (findViewById2 != null) {
                                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.img_btn_all);
                                                    if (imageView2 != null) {
                                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.img_btn_data);
                                                        if (imageView3 != null) {
                                                            ImageView imageView4 = (ImageView) view.findViewById(R.id.img_btn_text);
                                                            if (imageView4 != null) {
                                                                View findViewById3 = view.findViewById(R.id.line_post);
                                                                if (findViewById3 != null) {
                                                                    ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.ll_post_all);
                                                                    if (shapeConstraintLayout != null) {
                                                                        ConstraintLayout findViewById4 = view.findViewById(R.id.ll_post_data);
                                                                        if (findViewById4 != null) {
                                                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_item_title);
                                                                            if (textView3 != null) {
                                                                                TextView textView4 = (TextView) view.findViewById(R.id.tv_post_title);
                                                                                if (textView4 != null) {
                                                                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_title);
                                                                                    if (textView5 != null) {
                                                                                        return new DialogFeedStyleBinding((ConstraintLayout) view, shapeTextView, imageView, textView, textView2, findViewById, shapeTextView2, checkBox, checkBox2, checkBox3, checkBox4, findViewById2, imageView2, imageView3, imageView4, findViewById3, shapeConstraintLayout, findViewById4, textView3, textView4, textView5);
                                                                                    }
                                                                                    str = "tvTitle";
                                                                                } else {
                                                                                    str = "tvPostTitle";
                                                                                }
                                                                            } else {
                                                                                str = "tvItemTitle";
                                                                            }
                                                                        } else {
                                                                            str = "llPostData";
                                                                        }
                                                                    } else {
                                                                        str = "llPostAll";
                                                                    }
                                                                } else {
                                                                    str = "linePost";
                                                                }
                                                            } else {
                                                                str = "imgBtnText";
                                                            }
                                                        } else {
                                                            str = "imgBtnData";
                                                        }
                                                    } else {
                                                        str = "imgBtnAll";
                                                    }
                                                } else {
                                                    str = "coverView";
                                                }
                                            } else {
                                                str = "checkBoxWish";
                                            }
                                        } else {
                                            str = "checkBoxDuration";
                                        }
                                    } else {
                                        str = "checkBoxBeans";
                                    }
                                } else {
                                    str = "checkBoxAudience";
                                }
                            } else {
                                str = "btnPreview";
                            }
                        } else {
                            str = "btnPostText";
                        }
                    } else {
                        str = "btnPostData";
                    }
                } else {
                    str = "btnPostAll";
                }
            } else {
                str = "btnDialogClose";
            }
        } else {
            str = "btnCancel";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.u;
    }
}
