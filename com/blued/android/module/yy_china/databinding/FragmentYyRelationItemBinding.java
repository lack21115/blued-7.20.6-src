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

    /* renamed from: a  reason: collision with root package name */
    public final AppBarLayout f16541a;
    public final ShapeConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16542c;
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
        this.f16541a = appBarLayout;
        this.b = shapeConstraintLayout;
        this.f16542c = shapeTextView;
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
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.appbar);
        if (appBarLayout != null) {
            ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.bg_shape_content);
            if (shapeConstraintLayout != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.bg_shape_line);
                if (shapeTextView != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.iv_user_null);
                    if (linearLayout != null) {
                        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.ll_vp_pro);
                        if (shapeFrameLayout != null) {
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rec_task);
                            if (recyclerView != null) {
                                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rec_user);
                                if (recyclerView2 != null) {
                                    ShapeFrameLayout shapeFrameLayout2 = (ShapeFrameLayout) view.findViewById(R.id.shape_fra_task);
                                    if (shapeFrameLayout2 != null) {
                                        ShapeFrameLayout shapeFrameLayout3 = (ShapeFrameLayout) view.findViewById(R.id.shape_fra_users);
                                        if (shapeFrameLayout3 != null) {
                                            TextView textView = (TextView) view.findViewById(R.id.tv_null_user);
                                            if (textView != null) {
                                                ViewPager viewPager = (ViewPager) view.findViewById(R.id.user_view_pager);
                                                if (viewPager != null) {
                                                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.vp_pro_view);
                                                    if (shapeTextView2 != null) {
                                                        return new FragmentYyRelationItemBinding((ConstraintLayout) view, appBarLayout, shapeConstraintLayout, shapeTextView, linearLayout, shapeFrameLayout, recyclerView, recyclerView2, shapeFrameLayout2, shapeFrameLayout3, textView, viewPager, shapeTextView2);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.m;
    }
}
