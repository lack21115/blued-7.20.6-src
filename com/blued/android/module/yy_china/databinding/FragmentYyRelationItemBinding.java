package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyRelationItemBinding.class */
public final class FragmentYyRelationItemBinding implements ViewBinding {
    public final AppBarLayout a;
    public final ShapeConstraintLayout b;
    public final ShapeTextView c;
    public final LinearLayout d;
    public final ShapeFrameLayout e;
    public final RecyclerView f;
    public final RecyclerView g;
    public final ShapeFrameLayout h;
    public final ShapeFrameLayout i;
    public final TextView j;
    public final ViewPager k;
    public final ShapeTextView l;
    private final ConstraintLayout m;

    private FragmentYyRelationItemBinding(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ShapeConstraintLayout shapeConstraintLayout, ShapeTextView shapeTextView, LinearLayout linearLayout, ShapeFrameLayout shapeFrameLayout, RecyclerView recyclerView, RecyclerView recyclerView2, ShapeFrameLayout shapeFrameLayout2, ShapeFrameLayout shapeFrameLayout3, TextView textView, ViewPager viewPager, ShapeTextView shapeTextView2) {
        this.m = constraintLayout;
        this.a = appBarLayout;
        this.b = shapeConstraintLayout;
        this.c = shapeTextView;
        this.d = linearLayout;
        this.e = shapeFrameLayout;
        this.f = recyclerView;
        this.g = recyclerView2;
        this.h = shapeFrameLayout2;
        this.i = shapeFrameLayout3;
        this.j = textView;
        this.k = viewPager;
        this.l = shapeTextView2;
    }

    public static FragmentYyRelationItemBinding a(View view) {
        String str;
        AppBarLayout findViewById = view.findViewById(R.id.appbar);
        if (findViewById != null) {
            ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.bg_shape_content);
            if (shapeConstraintLayout != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.bg_shape_line);
                if (shapeTextView != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.iv_user_null);
                    if (linearLayout != null) {
                        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.ll_vp_pro);
                        if (shapeFrameLayout != null) {
                            RecyclerView findViewById2 = view.findViewById(R.id.rec_task);
                            if (findViewById2 != null) {
                                RecyclerView findViewById3 = view.findViewById(R.id.rec_user);
                                if (findViewById3 != null) {
                                    ShapeFrameLayout shapeFrameLayout2 = (ShapeFrameLayout) view.findViewById(R.id.shape_fra_task);
                                    if (shapeFrameLayout2 != null) {
                                        ShapeFrameLayout shapeFrameLayout3 = (ShapeFrameLayout) view.findViewById(R.id.shape_fra_users);
                                        if (shapeFrameLayout3 != null) {
                                            TextView textView = (TextView) view.findViewById(R.id.tv_null_user);
                                            if (textView != null) {
                                                ViewPager findViewById4 = view.findViewById(R.id.user_view_pager);
                                                if (findViewById4 != null) {
                                                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.vp_pro_view);
                                                    if (shapeTextView2 != null) {
                                                        return new FragmentYyRelationItemBinding((ConstraintLayout) view, findViewById, shapeConstraintLayout, shapeTextView, linearLayout, shapeFrameLayout, findViewById2, findViewById3, shapeFrameLayout2, shapeFrameLayout3, textView, findViewById4, shapeTextView2);
                                                    }
                                                    str = "vpProView";
                                                } else {
                                                    str = "userViewPager";
                                                }
                                            } else {
                                                str = "tvNullUser";
                                            }
                                        } else {
                                            str = "shapeFraUsers";
                                        }
                                    } else {
                                        str = "shapeFraTask";
                                    }
                                } else {
                                    str = "recUser";
                                }
                            } else {
                                str = "recTask";
                            }
                        } else {
                            str = "llVpPro";
                        }
                    } else {
                        str = "ivUserNull";
                    }
                } else {
                    str = "bgShapeLine";
                }
            } else {
                str = "bgShapeContent";
            }
        } else {
            str = "appbar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.m;
    }
}
