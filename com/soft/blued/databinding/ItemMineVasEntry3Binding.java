package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemMineVasEntry3Binding.class */
public final class ItemMineVasEntry3Binding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f29238a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29239c;
    public final ImageView d;
    public final ShapeConstraintLayout e;
    public final ShapeConstraintLayout f;
    public final LinearLayout g;
    public final TextView h;
    public final TextView i;
    public final ShapeTextView j;
    public final ShapeTextView k;
    public final TextView l;
    public final TextView m;
    private final LinearLayout n;

    private ItemMineVasEntry3Binding(LinearLayout linearLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ImageView imageView, ImageView imageView2, ShapeConstraintLayout shapeConstraintLayout, ShapeConstraintLayout shapeConstraintLayout2, LinearLayout linearLayout2, TextView textView, TextView textView2, ShapeTextView shapeTextView3, ShapeTextView shapeTextView4, TextView textView3, TextView textView4) {
        this.n = linearLayout;
        this.f29238a = shapeTextView;
        this.b = shapeTextView2;
        this.f29239c = imageView;
        this.d = imageView2;
        this.e = shapeConstraintLayout;
        this.f = shapeConstraintLayout2;
        this.g = linearLayout2;
        this.h = textView;
        this.i = textView2;
        this.j = shapeTextView3;
        this.k = shapeTextView4;
        this.l = textView3;
        this.m = textView4;
    }

    public static ItemMineVasEntry3Binding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.iv_dot_1);
        if (shapeTextView != null) {
            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.iv_dot_2);
            if (shapeTextView2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon_1);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_icon_2);
                    if (imageView2 != null) {
                        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.ll_all_1);
                        if (shapeConstraintLayout != null) {
                            ShapeConstraintLayout shapeConstraintLayout2 = (ShapeConstraintLayout) view.findViewById(R.id.ll_all_2);
                            if (shapeConstraintLayout2 != null) {
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_vas);
                                if (linearLayout != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_des_1);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_des_2);
                                        if (textView2 != null) {
                                            ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.tv_time1);
                                            if (shapeTextView3 != null) {
                                                ShapeTextView shapeTextView4 = (ShapeTextView) view.findViewById(R.id.tv_time2);
                                                if (shapeTextView4 != null) {
                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_title_1);
                                                    if (textView3 != null) {
                                                        TextView textView4 = (TextView) view.findViewById(2131372756);
                                                        if (textView4 != null) {
                                                            return new ItemMineVasEntry3Binding((LinearLayout) view, shapeTextView, shapeTextView2, imageView, imageView2, shapeConstraintLayout, shapeConstraintLayout2, linearLayout, textView, textView2, shapeTextView3, shapeTextView4, textView3, textView4);
                                                        }
                                                        str = "tvTitle2";
                                                    } else {
                                                        str = "tvTitle1";
                                                    }
                                                } else {
                                                    str = "tvTime2";
                                                }
                                            } else {
                                                str = "tvTime1";
                                            }
                                        } else {
                                            str = "tvDes2";
                                        }
                                    } else {
                                        str = "tvDes1";
                                    }
                                } else {
                                    str = "llVas";
                                }
                            } else {
                                str = "llAll2";
                            }
                        } else {
                            str = "llAll1";
                        }
                    } else {
                        str = "ivIcon2";
                    }
                } else {
                    str = "ivIcon1";
                }
            } else {
                str = "ivDot2";
            }
        } else {
            str = "ivDot1";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.n;
    }
}
