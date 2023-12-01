package com.soft.blued.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/LayoutAdDownLoadAppDialogBinding.class */
public final class LayoutAdDownLoadAppDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeLinearLayout f15688a;
    public final ShapeLinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f15689c;
    public final ImageView d;
    public final LinearLayout e;
    public final ShapeLinearLayout f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    private final ConstraintLayout m;

    private LayoutAdDownLoadAppDialogBinding(ConstraintLayout constraintLayout, ShapeLinearLayout shapeLinearLayout, ShapeLinearLayout shapeLinearLayout2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ShapeLinearLayout shapeLinearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.m = constraintLayout;
        this.f15688a = shapeLinearLayout;
        this.b = shapeLinearLayout2;
        this.f15689c = imageView;
        this.d = imageView2;
        this.e = linearLayout;
        this.f = shapeLinearLayout3;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
        this.j = textView4;
        this.k = textView5;
        this.l = textView6;
    }

    public static LayoutAdDownLoadAppDialogBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LayoutAdDownLoadAppDialogBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_ad_down_load_app_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LayoutAdDownLoadAppDialogBinding a(View view) {
        String str;
        ShapeLinearLayout findViewById = view.findViewById(2131362547);
        if (findViewById != null) {
            ShapeLinearLayout findViewById2 = view.findViewById(R.id.btn_download);
            if (findViewById2 != null) {
                ImageView imageView = (ImageView) view.findViewById(2131365060);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_close_btn);
                    if (imageView2 != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_conceal_and_permission);
                        if (linearLayout != null) {
                            ShapeLinearLayout findViewById3 = view.findViewById(2131369470);
                            if (findViewById3 != null) {
                                TextView textView = (TextView) view.findViewById(2131370891);
                                if (textView != null) {
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_app_size);
                                    if (textView2 != null) {
                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_author_name);
                                        if (textView3 != null) {
                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_conceal);
                                            if (textView4 != null) {
                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_permission);
                                                if (textView5 != null) {
                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_version_code);
                                                    if (textView6 != null) {
                                                        return new LayoutAdDownLoadAppDialogBinding((ConstraintLayout) view, findViewById, findViewById2, imageView, imageView2, linearLayout, findViewById3, textView, textView2, textView3, textView4, textView5, textView6);
                                                    }
                                                    str = "tvVersionCode";
                                                } else {
                                                    str = "tvPermission";
                                                }
                                            } else {
                                                str = "tvConceal";
                                            }
                                        } else {
                                            str = "tvAuthorName";
                                        }
                                    } else {
                                        str = "tvAppSize";
                                    }
                                } else {
                                    str = "tvAppName";
                                }
                            } else {
                                str = "rootView";
                            }
                        } else {
                            str = "llConcealAndPermission";
                        }
                    } else {
                        str = "ivCloseBtn";
                    }
                } else {
                    str = "ivAppIcon";
                }
            } else {
                str = "btnDownload";
            }
        } else {
            str = "btnCancel";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.m;
    }
}
