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
import com.soft.blued.ui.find.view.FilterCommonScrollSelectorView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/LayoutVipFilterBinding.class */
public final class LayoutVipFilterBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ExpandLinearLayout f15748a;
    public final FilterCommonScrollSelectorView b;

    /* renamed from: c  reason: collision with root package name */
    public final FilterCommonScrollSelectorView f15749c;
    public final PhotoGridView d;
    public final PhotoGridView e;
    public final ImageView f;
    public final RelativeLayout g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    private final LinearLayout k;

    private LayoutVipFilterBinding(LinearLayout linearLayout, ExpandLinearLayout expandLinearLayout, FilterCommonScrollSelectorView filterCommonScrollSelectorView, FilterCommonScrollSelectorView filterCommonScrollSelectorView2, PhotoGridView photoGridView, PhotoGridView photoGridView2, ImageView imageView, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3) {
        this.k = linearLayout;
        this.f15748a = expandLinearLayout;
        this.b = filterCommonScrollSelectorView;
        this.f15749c = filterCommonScrollSelectorView2;
        this.d = photoGridView;
        this.e = photoGridView2;
        this.f = imageView;
        this.g = relativeLayout;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
    }

    public static LayoutVipFilterBinding a(View view) {
        String str;
        ExpandLinearLayout expandLinearLayout = (ExpandLinearLayout) view.findViewById(R.id.ell_constellation_view);
        if (expandLinearLayout != null) {
            FilterCommonScrollSelectorView filterCommonScrollSelectorView = (FilterCommonScrollSelectorView) view.findViewById(R.id.filter_distance_view);
            if (filterCommonScrollSelectorView != null) {
                FilterCommonScrollSelectorView filterCommonScrollSelectorView2 = (FilterCommonScrollSelectorView) view.findViewById(R.id.filter_online_time_view);
                if (filterCommonScrollSelectorView2 != null) {
                    PhotoGridView photoGridView = (PhotoGridView) view.findViewById(R.id.gv_constellation);
                    if (photoGridView != null) {
                        PhotoGridView photoGridView2 = (PhotoGridView) view.findViewById(R.id.gv_priority);
                        if (photoGridView2 != null) {
                            ImageView imageView = (ImageView) view.findViewById(R.id.iv_constellation_header_arrow);
                            if (imageView != null) {
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_constellation_item_header);
                                if (relativeLayout != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_constellation_header);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_constellation_select_content);
                                        if (textView2 != null) {
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_priority);
                                            if (textView3 != null) {
                                                return new LayoutVipFilterBinding((LinearLayout) view, expandLinearLayout, filterCommonScrollSelectorView, filterCommonScrollSelectorView2, photoGridView, photoGridView2, imageView, relativeLayout, textView, textView2, textView3);
                                            }
                                            str = "tvPriority";
                                        } else {
                                            str = "tvConstellationSelectContent";
                                        }
                                    } else {
                                        str = "tvConstellationHeader";
                                    }
                                } else {
                                    str = "rlConstellationItemHeader";
                                }
                            } else {
                                str = "ivConstellationHeaderArrow";
                            }
                        } else {
                            str = "gvPriority";
                        }
                    } else {
                        str = "gvConstellation";
                    }
                } else {
                    str = "filterOnlineTimeView";
                }
            } else {
                str = "filterDistanceView";
            }
        } else {
            str = "ellConstellationView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.k;
    }
}
