package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SlopeLoadingView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentGoodsWallBrandBinding.class */
public final class FragmentGoodsWallBrandBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f11915a;
    public final ConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f11916c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final SlopeLoadingView h;
    public final RecyclerView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    private final RelativeLayout q;

    private FragmentGoodsWallBrandBinding(RelativeLayout relativeLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, SlopeLoadingView slopeLoadingView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.q = relativeLayout;
        this.f11915a = constraintLayout;
        this.b = constraintLayout2;
        this.f11916c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = imageView5;
        this.h = slopeLoadingView;
        this.i = recyclerView;
        this.j = textView;
        this.k = textView2;
        this.l = textView3;
        this.m = textView4;
        this.n = textView5;
        this.o = textView6;
        this.p = textView7;
    }

    public static FragmentGoodsWallBrandBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_goods_wall_brand, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentGoodsWallBrandBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_brand_award);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_custom_gallery);
            if (constraintLayout2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_avatar);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_avatar_frame);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_brand_award_check);
                        if (imageView3 != null) {
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_custom_gallery_check);
                            if (imageView4 != null) {
                                ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_info);
                                if (imageView5 != null) {
                                    SlopeLoadingView slopeLoadingView = (SlopeLoadingView) view.findViewById(R.id.loading);
                                    if (slopeLoadingView != null) {
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
                                        if (recyclerView != null) {
                                            TextView textView = (TextView) view.findViewById(R.id.tv_brand_award_check);
                                            if (textView != null) {
                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_brand_award_title);
                                                if (textView2 != null) {
                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_brand_count);
                                                    if (textView3 != null) {
                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_custom_gallery_check);
                                                        if (textView4 != null) {
                                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_custom_gallery_title);
                                                            if (textView5 != null) {
                                                                TextView textView6 = (TextView) view.findViewById(R.id.tv_name);
                                                                if (textView6 != null) {
                                                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_name_suffix);
                                                                    if (textView7 != null) {
                                                                        return new FragmentGoodsWallBrandBinding((RelativeLayout) view, constraintLayout, constraintLayout2, imageView, imageView2, imageView3, imageView4, imageView5, slopeLoadingView, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                                                    }
                                                                    str = "tvNameSuffix";
                                                                } else {
                                                                    str = "tvName";
                                                                }
                                                            } else {
                                                                str = "tvCustomGalleryTitle";
                                                            }
                                                        } else {
                                                            str = "tvCustomGalleryCheck";
                                                        }
                                                    } else {
                                                        str = "tvBrandCount";
                                                    }
                                                } else {
                                                    str = "tvBrandAwardTitle";
                                                }
                                            } else {
                                                str = "tvBrandAwardCheck";
                                            }
                                        } else {
                                            str = "rvList";
                                        }
                                    } else {
                                        str = "loading";
                                    }
                                } else {
                                    str = "ivInfo";
                                }
                            } else {
                                str = "ivCustomGalleryCheck";
                            }
                        } else {
                            str = "ivBrandAwardCheck";
                        }
                    } else {
                        str = "ivAvatarFrame";
                    }
                } else {
                    str = "ivAvatar";
                }
            } else {
                str = "clCustomGallery";
            }
        } else {
            str = "clBrandAward";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.q;
    }
}
