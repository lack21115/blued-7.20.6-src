package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.view.PhotoGridView;
import com.soft.blued.R;
import com.soft.blued.ui.find.view.FilterCommonPhotoGridView;
import com.soft.blued.ui.find.view.FilterCommonScrollSelectorView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/LayoutBasicsFilterBinding.class */
public final class LayoutBasicsFilterBinding implements ViewBinding {
    public final TextView A;
    private final LinearLayout B;

    /* renamed from: a  reason: collision with root package name */
    public final FilterCommonScrollSelectorView f15693a;
    public final FilterCommonScrollSelectorView b;

    /* renamed from: c  reason: collision with root package name */
    public final FilterCommonPhotoGridView f15694c;
    public final FilterCommonPhotoGridView d;
    public final FilterCommonPhotoGridView e;
    public final RelativeLayout f;
    public final FilterCommonPhotoGridView g;
    public final FilterCommonScrollSelectorView h;
    public final PhotoGridView i;
    public final PhotoGridView j;
    public final PhotoGridView k;
    public final ImageView l;
    public final LinearLayout m;
    public final RelativeLayout n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    private LayoutBasicsFilterBinding(LinearLayout linearLayout, FilterCommonScrollSelectorView filterCommonScrollSelectorView, FilterCommonScrollSelectorView filterCommonScrollSelectorView2, FilterCommonPhotoGridView filterCommonPhotoGridView, FilterCommonPhotoGridView filterCommonPhotoGridView2, FilterCommonPhotoGridView filterCommonPhotoGridView3, RelativeLayout relativeLayout, FilterCommonPhotoGridView filterCommonPhotoGridView4, FilterCommonScrollSelectorView filterCommonScrollSelectorView3, PhotoGridView photoGridView, PhotoGridView photoGridView2, PhotoGridView photoGridView3, ImageView imageView, LinearLayout linearLayout2, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        this.B = linearLayout;
        this.f15693a = filterCommonScrollSelectorView;
        this.b = filterCommonScrollSelectorView2;
        this.f15694c = filterCommonPhotoGridView;
        this.d = filterCommonPhotoGridView2;
        this.e = filterCommonPhotoGridView3;
        this.f = relativeLayout;
        this.g = filterCommonPhotoGridView4;
        this.h = filterCommonScrollSelectorView3;
        this.i = photoGridView;
        this.j = photoGridView2;
        this.k = photoGridView3;
        this.l = imageView;
        this.m = linearLayout2;
        this.n = relativeLayout2;
        this.o = textView;
        this.p = textView2;
        this.q = textView3;
        this.r = textView4;
        this.s = textView5;
        this.t = textView6;
        this.u = textView7;
        this.v = textView8;
        this.w = textView9;
        this.x = textView10;
        this.y = textView11;
        this.z = textView12;
        this.A = textView13;
    }

    public static LayoutBasicsFilterBinding a(View view) {
        String str;
        FilterCommonScrollSelectorView filterCommonScrollSelectorView = (FilterCommonScrollSelectorView) view.findViewById(R.id.filter_age_view);
        if (filterCommonScrollSelectorView != null) {
            FilterCommonScrollSelectorView filterCommonScrollSelectorView2 = (FilterCommonScrollSelectorView) view.findViewById(R.id.filter_height_view);
            if (filterCommonScrollSelectorView2 != null) {
                FilterCommonPhotoGridView filterCommonPhotoGridView = (FilterCommonPhotoGridView) view.findViewById(R.id.filter_his_favorite_type_view);
                if (filterCommonPhotoGridView != null) {
                    FilterCommonPhotoGridView filterCommonPhotoGridView2 = (FilterCommonPhotoGridView) view.findViewById(R.id.filter_his_tag_view);
                    if (filterCommonPhotoGridView2 != null) {
                        FilterCommonPhotoGridView filterCommonPhotoGridView3 = (FilterCommonPhotoGridView) view.findViewById(R.id.filter_make_friends_view);
                        if (filterCommonPhotoGridView3 != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.filter_more_chosen_item);
                            if (relativeLayout != null) {
                                FilterCommonPhotoGridView filterCommonPhotoGridView4 = (FilterCommonPhotoGridView) view.findViewById(R.id.filter_relation_view);
                                if (filterCommonPhotoGridView4 != null) {
                                    FilterCommonScrollSelectorView filterCommonScrollSelectorView3 = (FilterCommonScrollSelectorView) view.findViewById(R.id.filter_weight_view);
                                    if (filterCommonScrollSelectorView3 != null) {
                                        PhotoGridView photoGridView = (PhotoGridView) view.findViewById(R.id.gv_he_is);
                                        if (photoGridView != null) {
                                            PhotoGridView photoGridView2 = (PhotoGridView) view.findViewById(R.id.gv_portrait);
                                            if (photoGridView2 != null) {
                                                PhotoGridView photoGridView3 = (PhotoGridView) view.findViewById(R.id.gv_shape);
                                                if (photoGridView3 != null) {
                                                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_more_filter_header_arrow);
                                                    if (imageView != null) {
                                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_more_filter_view);
                                                        if (linearLayout != null) {
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_more_filter_item);
                                                            if (relativeLayout2 != null) {
                                                                TextView textView = (TextView) view.findViewById(R.id.tv_chosen_his_tags);
                                                                if (textView != null) {
                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_chosen_his_tags_content);
                                                                    if (textView2 != null) {
                                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_chosen_his_types);
                                                                        if (textView3 != null) {
                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_chosen_his_types_content);
                                                                            if (textView4 != null) {
                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_chosen_make_friends);
                                                                                if (textView5 != null) {
                                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_chosen_make_friends_content);
                                                                                    if (textView6 != null) {
                                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_chosen_portrait);
                                                                                        if (textView7 != null) {
                                                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_chosen_portrait_content);
                                                                                            if (textView8 != null) {
                                                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_chosen_relation);
                                                                                                if (textView9 != null) {
                                                                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_chosen_relation_content);
                                                                                                    if (textView10 != null) {
                                                                                                        TextView textView11 = (TextView) view.findViewById(R.id.tv_more_filter_select_content);
                                                                                                        if (textView11 != null) {
                                                                                                            TextView textView12 = (TextView) view.findViewById(R.id.tv_more_filter_title);
                                                                                                            if (textView12 != null) {
                                                                                                                TextView textView13 = (TextView) view.findViewById(R.id.tv_portrait);
                                                                                                                if (textView13 != null) {
                                                                                                                    return new LayoutBasicsFilterBinding((LinearLayout) view, filterCommonScrollSelectorView, filterCommonScrollSelectorView2, filterCommonPhotoGridView, filterCommonPhotoGridView2, filterCommonPhotoGridView3, relativeLayout, filterCommonPhotoGridView4, filterCommonScrollSelectorView3, photoGridView, photoGridView2, photoGridView3, imageView, linearLayout, relativeLayout2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13);
                                                                                                                }
                                                                                                                str = "tvPortrait";
                                                                                                            } else {
                                                                                                                str = "tvMoreFilterTitle";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "tvMoreFilterSelectContent";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "tvChosenRelationContent";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvChosenRelation";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvChosenPortraitContent";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvChosenPortrait";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvChosenMakeFriendsContent";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvChosenMakeFriends";
                                                                                }
                                                                            } else {
                                                                                str = "tvChosenHisTypesContent";
                                                                            }
                                                                        } else {
                                                                            str = "tvChosenHisTypes";
                                                                        }
                                                                    } else {
                                                                        str = "tvChosenHisTagsContent";
                                                                    }
                                                                } else {
                                                                    str = "tvChosenHisTags";
                                                                }
                                                            } else {
                                                                str = "rlMoreFilterItem";
                                                            }
                                                        } else {
                                                            str = "llMoreFilterView";
                                                        }
                                                    } else {
                                                        str = "ivMoreFilterHeaderArrow";
                                                    }
                                                } else {
                                                    str = "gvShape";
                                                }
                                            } else {
                                                str = "gvPortrait";
                                            }
                                        } else {
                                            str = "gvHeIs";
                                        }
                                    } else {
                                        str = "filterWeightView";
                                    }
                                } else {
                                    str = "filterRelationView";
                                }
                            } else {
                                str = "filterMoreChosenItem";
                            }
                        } else {
                            str = "filterMakeFriendsView";
                        }
                    } else {
                        str = "filterHisTagView";
                    }
                } else {
                    str = "filterHisFavoriteTypeView";
                }
            } else {
                str = "filterHeightView";
            }
        } else {
            str = "filterAgeView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.B;
    }
}
