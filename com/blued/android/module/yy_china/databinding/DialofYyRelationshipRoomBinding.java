package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYRelationShipThemeTabView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialofYyRelationshipRoomBinding.class */
public final class DialofYyRelationshipRoomBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16292a;
    public final SquareImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16293c;
    public final YYRelationShipThemeTabView d;
    public final ViewPager e;
    private final ConstraintLayout f;

    private DialofYyRelationshipRoomBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, SquareImageView squareImageView2, ImageView imageView, YYRelationShipThemeTabView yYRelationShipThemeTabView, ViewPager viewPager) {
        this.f = constraintLayout;
        this.f16292a = squareImageView;
        this.b = squareImageView2;
        this.f16293c = imageView;
        this.d = yYRelationShipThemeTabView;
        this.e = viewPager;
    }

    public static DialofYyRelationshipRoomBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.btn_relationship_about);
        if (squareImageView != null) {
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.btn_relationship_rank);
            if (squareImageView2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
                if (imageView != null) {
                    YYRelationShipThemeTabView yYRelationShipThemeTabView = (YYRelationShipThemeTabView) view.findViewById(R.id.tablayout);
                    if (yYRelationShipThemeTabView != null) {
                        ViewPager viewPager = (ViewPager) view.findViewById(R.id.type_view_pager);
                        if (viewPager != null) {
                            return new DialofYyRelationshipRoomBinding((ConstraintLayout) view, squareImageView, squareImageView2, imageView, yYRelationShipThemeTabView, viewPager);
                        }
                        str = "typeViewPager";
                    } else {
                        str = "tablayout";
                    }
                } else {
                    str = "ivBack";
                }
            } else {
                str = "btnRelationshipRank";
            }
        } else {
            str = "btnRelationshipAbout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
