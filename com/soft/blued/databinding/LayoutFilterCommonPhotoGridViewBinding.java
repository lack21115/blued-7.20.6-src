package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.view.PhotoGridView;
import com.soft.blued.R;
import com.soft.blued.ui.find.view.ExpandLinearLayout;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/LayoutFilterCommonPhotoGridViewBinding.class */
public final class LayoutFilterCommonPhotoGridViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final PhotoGridView f29389a;
    public final PhotoGridView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29390c;
    public final ExpandLinearLayout d;
    public final RelativeLayout e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    private final LinearLayout j;

    private LayoutFilterCommonPhotoGridViewBinding(LinearLayout linearLayout, PhotoGridView photoGridView, PhotoGridView photoGridView2, ImageView imageView, ExpandLinearLayout expandLinearLayout, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.j = linearLayout;
        this.f29389a = photoGridView;
        this.b = photoGridView2;
        this.f29390c = imageView;
        this.d = expandLinearLayout;
        this.e = relativeLayout;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
    }

    public static LayoutFilterCommonPhotoGridViewBinding a(View view) {
        String str;
        PhotoGridView photoGridView = (PhotoGridView) view.findViewById(R.id.filter_common_photo_grid_view1);
        if (photoGridView != null) {
            PhotoGridView photoGridView2 = (PhotoGridView) view.findViewById(R.id.filter_common_photo_grid_view2);
            if (photoGridView2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_filter_header_arrow);
                if (imageView != null) {
                    ExpandLinearLayout expandLinearLayout = (ExpandLinearLayout) view.findViewById(R.id.ll_two_level_view);
                    if (expandLinearLayout != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_filter_item_header);
                        if (relativeLayout != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_filter_common_gv_title1);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_filter_common_gv_title2);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_filter_common_header);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_filter_header_select_content);
                                        if (textView4 != null) {
                                            return new LayoutFilterCommonPhotoGridViewBinding((LinearLayout) view, photoGridView, photoGridView2, imageView, expandLinearLayout, relativeLayout, textView, textView2, textView3, textView4);
                                        }
                                        str = "tvFilterHeaderSelectContent";
                                    } else {
                                        str = "tvFilterCommonHeader";
                                    }
                                } else {
                                    str = "tvFilterCommonGvTitle2";
                                }
                            } else {
                                str = "tvFilterCommonGvTitle1";
                            }
                        } else {
                            str = "rlFilterItemHeader";
                        }
                    } else {
                        str = "llTwoLevelView";
                    }
                } else {
                    str = "ivFilterHeaderArrow";
                }
            } else {
                str = "filterCommonPhotoGridView2";
            }
        } else {
            str = "filterCommonPhotoGridView1";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.j;
    }
}
