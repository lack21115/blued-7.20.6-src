package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYRoomRelationShipRankTabView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyMyRelationRankAllBinding.class */
public final class DialogYyMyRelationRankAllBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16444a;
    public final ViewPager b;

    /* renamed from: c  reason: collision with root package name */
    public final YYRoomRelationShipRankTabView f16445c;
    public final CommonTopTitleNoTrans d;
    private final ConstraintLayout e;

    private DialogYyMyRelationRankAllBinding(ConstraintLayout constraintLayout, ImageView imageView, ViewPager viewPager, YYRoomRelationShipRankTabView yYRoomRelationShipRankTabView, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.e = constraintLayout;
        this.f16444a = imageView;
        this.b = viewPager;
        this.f16445c = yYRoomRelationShipRankTabView;
        this.d = commonTopTitleNoTrans;
    }

    public static DialogYyMyRelationRankAllBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        if (imageView != null) {
            ViewPager viewPager = (ViewPager) view.findViewById(R.id.room_view_pager);
            if (viewPager != null) {
                YYRoomRelationShipRankTabView yYRoomRelationShipRankTabView = (YYRoomRelationShipRankTabView) view.findViewById(R.id.tablayout);
                if (yYRoomRelationShipRankTabView != null) {
                    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.top_title);
                    if (commonTopTitleNoTrans != null) {
                        return new DialogYyMyRelationRankAllBinding((ConstraintLayout) view, imageView, viewPager, yYRoomRelationShipRankTabView, commonTopTitleNoTrans);
                    }
                    str = "topTitle";
                } else {
                    str = "tablayout";
                }
            } else {
                str = "roomViewPager";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
