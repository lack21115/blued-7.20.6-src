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

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16506a;
    public final View b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f16507c;
    public final ImageView d;
    public final LinearLayout e;
    public final RecyclerView f;
    public final CommonTopTitleNoTrans g;
    private final ConstraintLayout h;

    private FragmentYyHomeRoomsBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.h = constraintLayout;
        this.f16506a = constraintLayout2;
        this.b = view;
        this.f16507c = frameLayout;
        this.d = imageView;
        this.e = linearLayout;
        this.f = recyclerView;
        this.g = commonTopTitleNoTrans;
    }

    public static FragmentYyHomeRoomsBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.con);
        if (constraintLayout != null) {
            View findViewById = view.findViewById(R.id.cover_view);
            if (findViewById != null) {
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fra);
                if (frameLayout != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_bott_back);
                    if (imageView != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_bott);
                        if (linearLayout != null) {
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_bott);
                            if (recyclerView != null) {
                                CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.top_title);
                                if (commonTopTitleNoTrans != null) {
                                    return new FragmentYyHomeRoomsBinding((ConstraintLayout) view, constraintLayout, findViewById, frameLayout, imageView, linearLayout, recyclerView, commonTopTitleNoTrans);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
