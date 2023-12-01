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
    public final ImageView a;
    public final ViewPager b;
    public final YYRoomRelationShipRankTabView c;
    public final CommonTopTitleNoTrans d;
    private final ConstraintLayout e;

    private DialogYyMyRelationRankAllBinding(ConstraintLayout constraintLayout, ImageView imageView, ViewPager viewPager, YYRoomRelationShipRankTabView yYRoomRelationShipRankTabView, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.e = constraintLayout;
        this.a = imageView;
        this.b = viewPager;
        this.c = yYRoomRelationShipRankTabView;
        this.d = commonTopTitleNoTrans;
    }

    public static DialogYyMyRelationRankAllBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        if (imageView != null) {
            ViewPager findViewById = view.findViewById(R.id.room_view_pager);
            if (findViewById != null) {
                YYRoomRelationShipRankTabView yYRoomRelationShipRankTabView = (YYRoomRelationShipRankTabView) view.findViewById(R.id.tablayout);
                if (yYRoomRelationShipRankTabView != null) {
                    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.top_title);
                    if (commonTopTitleNoTrans != null) {
                        return new DialogYyMyRelationRankAllBinding((ConstraintLayout) view, imageView, findViewById, yYRoomRelationShipRankTabView, commonTopTitleNoTrans);
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

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
