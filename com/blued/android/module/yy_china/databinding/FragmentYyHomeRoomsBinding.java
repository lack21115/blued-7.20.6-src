package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyHomeRoomsBinding.class */
public final class FragmentYyHomeRoomsBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final FrameLayout c;
    public final ImageView d;
    public final LinearLayout e;
    public final RecyclerView f;
    public final CommonTopTitleNoTrans g;
    private final ConstraintLayout h;

    private FragmentYyHomeRoomsBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.h = constraintLayout;
        this.a = constraintLayout2;
        this.b = view;
        this.c = frameLayout;
        this.d = imageView;
        this.e = linearLayout;
        this.f = recyclerView;
        this.g = commonTopTitleNoTrans;
    }

    public static FragmentYyHomeRoomsBinding a(View view) {
        String str;
        ConstraintLayout findViewById = view.findViewById(R.id.con);
        if (findViewById != null) {
            View findViewById2 = view.findViewById(R.id.cover_view);
            if (findViewById2 != null) {
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fra);
                if (frameLayout != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_bott_back);
                    if (imageView != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_bott);
                        if (linearLayout != null) {
                            RecyclerView findViewById3 = view.findViewById(R.id.rcv_bott);
                            if (findViewById3 != null) {
                                CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.top_title);
                                if (commonTopTitleNoTrans != null) {
                                    return new FragmentYyHomeRoomsBinding((ConstraintLayout) view, findViewById, findViewById2, frameLayout, imageView, linearLayout, findViewById3, commonTopTitleNoTrans);
                                }
                                str = "topTitle";
                            } else {
                                str = "rcvBott";
                            }
                        } else {
                            str = "llBott";
                        }
                    } else {
                        str = "ivBottBack";
                    }
                } else {
                    str = "fra";
                }
            } else {
                str = "coverView";
            }
        } else {
            str = "con";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
