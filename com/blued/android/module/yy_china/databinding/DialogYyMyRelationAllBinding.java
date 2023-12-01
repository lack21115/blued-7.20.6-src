package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYRoomRelationShipRankTabView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyMyRelationAllBinding.class */
public final class DialogYyMyRelationAllBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ViewPager c;
    public final YYRoomRelationShipRankTabView d;
    public final CommonTopTitleNoTrans e;
    private final ConstraintLayout f;

    private DialogYyMyRelationAllBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ViewPager viewPager, YYRoomRelationShipRankTabView yYRoomRelationShipRankTabView, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.f = constraintLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = viewPager;
        this.d = yYRoomRelationShipRankTabView;
        this.e = commonTopTitleNoTrans;
    }

    public static DialogYyMyRelationAllBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView2 != null) {
                ViewPager findViewById = view.findViewById(R.id.room_view_pager);
                if (findViewById != null) {
                    YYRoomRelationShipRankTabView yYRoomRelationShipRankTabView = (YYRoomRelationShipRankTabView) view.findViewById(R.id.tablayout);
                    if (yYRoomRelationShipRankTabView != null) {
                        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.top_title);
                        if (commonTopTitleNoTrans != null) {
                            return new DialogYyMyRelationAllBinding((ConstraintLayout) view, imageView, imageView2, findViewById, yYRoomRelationShipRankTabView, commonTopTitleNoTrans);
                        }
                        str = "topTitle";
                    } else {
                        str = "tablayout";
                    }
                } else {
                    str = "roomViewPager";
                }
            } else {
                str = "ivBack";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
