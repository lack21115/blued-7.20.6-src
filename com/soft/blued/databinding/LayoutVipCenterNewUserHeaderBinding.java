package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/LayoutVipCenterNewUserHeaderBinding.class */
public final class LayoutVipCenterNewUserHeaderBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f15746a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ItemVipCenterBannerBinding f15747c;
    public final LinearLayout d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final RecyclerView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final LinearLayout o;
    private final LinearLayout p;

    private LayoutVipCenterNewUserHeaderBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ItemVipCenterBannerBinding itemVipCenterBannerBinding, LinearLayout linearLayout4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout5) {
        this.p = linearLayout;
        this.f15746a = linearLayout2;
        this.b = linearLayout3;
        this.f15747c = itemVipCenterBannerBinding;
        this.d = linearLayout4;
        this.e = imageView;
        this.f = imageView2;
        this.g = imageView3;
        this.h = imageView4;
        this.i = recyclerView;
        this.j = textView;
        this.k = textView2;
        this.l = textView3;
        this.m = textView4;
        this.n = textView5;
        this.o = linearLayout5;
    }

    public static LayoutVipCenterNewUserHeaderBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.agreement_layout);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.banner_root_view);
            if (linearLayout2 != null) {
                View findViewById = view.findViewById(R.id.banner_view);
                if (findViewById != null) {
                    ItemVipCenterBannerBinding a2 = ItemVipCenterBannerBinding.a(findViewById);
                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.btn_to_be_vip);
                    if (linearLayout3 != null) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_agreement_btn);
                        if (imageView != null) {
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_to_be_vip);
                            if (imageView2 != null) {
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_user_avatar);
                                if (imageView3 != null) {
                                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_vip_new_user_top_right_bg);
                                    if (imageView4 != null) {
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.option_list_recycler_view);
                                        if (recyclerView != null) {
                                            TextView textView = (TextView) view.findViewById(R.id.tv_agreement_text);
                                            if (textView != null) {
                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_select_option_desc);
                                                if (textView2 != null) {
                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_to_be_vip);
                                                    if (textView3 != null) {
                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_user_name);
                                                        if (textView4 != null) {
                                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_vip_state);
                                                            if (textView5 != null) {
                                                                LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.user_info_view);
                                                                if (linearLayout4 != null) {
                                                                    return new LayoutVipCenterNewUserHeaderBinding((LinearLayout) view, linearLayout, linearLayout2, a2, linearLayout3, imageView, imageView2, imageView3, imageView4, recyclerView, textView, textView2, textView3, textView4, textView5, linearLayout4);
                                                                }
                                                                str = "userInfoView";
                                                            } else {
                                                                str = "tvVipState";
                                                            }
                                                        } else {
                                                            str = "tvUserName";
                                                        }
                                                    } else {
                                                        str = "tvToBeVip";
                                                    }
                                                } else {
                                                    str = "tvSelectOptionDesc";
                                                }
                                            } else {
                                                str = "tvAgreementText";
                                            }
                                        } else {
                                            str = "optionListRecyclerView";
                                        }
                                    } else {
                                        str = "ivVipNewUserTopRightBg";
                                    }
                                } else {
                                    str = "ivUserAvatar";
                                }
                            } else {
                                str = "ivToBeVip";
                            }
                        } else {
                            str = "ivAgreementBtn";
                        }
                    } else {
                        str = "btnToBeVip";
                    }
                } else {
                    str = "bannerView";
                }
            } else {
                str = "bannerRootView";
            }
        } else {
            str = "agreementLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.p;
    }
}
