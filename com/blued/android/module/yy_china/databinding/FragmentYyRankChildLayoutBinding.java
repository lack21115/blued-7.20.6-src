package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyRankChildLayoutBinding.class */
public final class FragmentYyRankChildLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeableImageView f16531a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeConstraintLayout f16532c;
    public final ConstraintLayout d;
    public final LinearLayout e;
    public final RecyclerView f;
    public final SmartRefreshLayout g;
    public final TextView h;
    public final TextView i;
    public final ShapeTextView j;
    public final TextView k;
    public final TextView l;
    private final SmartRefreshLayout m;

    private FragmentYyRankChildLayoutBinding(SmartRefreshLayout smartRefreshLayout, ShapeableImageView shapeableImageView, ImageView imageView, ShapeConstraintLayout shapeConstraintLayout, ConstraintLayout constraintLayout, LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout2, TextView textView, TextView textView2, ShapeTextView shapeTextView, TextView textView3, TextView textView4) {
        this.m = smartRefreshLayout;
        this.f16531a = shapeableImageView;
        this.b = imageView;
        this.f16532c = shapeConstraintLayout;
        this.d = constraintLayout;
        this.e = linearLayout;
        this.f = recyclerView;
        this.g = smartRefreshLayout2;
        this.h = textView;
        this.i = textView2;
        this.j = shapeTextView;
        this.k = textView3;
        this.l = textView4;
    }

    public static FragmentYyRankChildLayoutBinding a(View view) {
        String str;
        ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.img_my_avatar);
        if (shapeableImageView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.img_unit);
            if (imageView != null) {
                ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.ll_bottom_layout);
                if (shapeConstraintLayout != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.ll_hasdata_view);
                    if (constraintLayout != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_nodata_view);
                        if (linearLayout != null) {
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rank_list_view);
                            if (recyclerView != null) {
                                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_view);
                                if (smartRefreshLayout != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_my_order);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_nickname);
                                        if (textView2 != null) {
                                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_send_gift);
                                            if (shapeTextView != null) {
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_tips_text);
                                                if (textView3 != null) {
                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_wandou);
                                                    if (textView4 != null) {
                                                        return new FragmentYyRankChildLayoutBinding((SmartRefreshLayout) view, shapeableImageView, imageView, shapeConstraintLayout, constraintLayout, linearLayout, recyclerView, smartRefreshLayout, textView, textView2, shapeTextView, textView3, textView4);
                                                    }
                                                    str = "tvWandou";
                                                } else {
                                                    str = "tvTipsText";
                                                }
                                            } else {
                                                str = "tvSendGift";
                                            }
                                        } else {
                                            str = "tvNickname";
                                        }
                                    } else {
                                        str = "tvMyOrder";
                                    }
                                } else {
                                    str = "refreshView";
                                }
                            } else {
                                str = "rankListView";
                            }
                        } else {
                            str = "llNodataView";
                        }
                    } else {
                        str = "llHasdataView";
                    }
                } else {
                    str = "llBottomLayout";
                }
            } else {
                str = "imgUnit";
            }
        } else {
            str = "imgMyAvatar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public SmartRefreshLayout getRoot() {
        return this.m;
    }
}
