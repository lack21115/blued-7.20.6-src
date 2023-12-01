package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogConfessedUserListBinding.class */
public final class DialogConfessedUserListBinding implements ViewBinding {
    public final ShapeConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final SquareImageView e;
    public final ImageView f;
    public final LinearLayout g;
    public final RecyclerView h;
    public final SmartRefreshLayout i;
    private final ConstraintLayout j;

    private DialogConfessedUserListBinding(ConstraintLayout constraintLayout, ShapeConstraintLayout shapeConstraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, SquareImageView squareImageView, ImageView imageView4, LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        this.j = constraintLayout;
        this.a = shapeConstraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = squareImageView;
        this.f = imageView4;
        this.g = linearLayout;
        this.h = recyclerView;
        this.i = smartRefreshLayout;
    }

    public static DialogConfessedUserListBinding a(View view) {
        String str;
        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.con);
        if (shapeConstraintLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_bg);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_close);
                    if (imageView3 != null) {
                        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_null);
                        if (squareImageView != null) {
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_top_bg);
                            if (imageView4 != null) {
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_null);
                                if (linearLayout != null) {
                                    RecyclerView findViewById = view.findViewById(R.id.recycler_view);
                                    if (findViewById != null) {
                                        SmartRefreshLayout findViewById2 = view.findViewById(R.id.refresh_layout);
                                        if (findViewById2 != null) {
                                            return new DialogConfessedUserListBinding((ConstraintLayout) view, shapeConstraintLayout, imageView, imageView2, imageView3, squareImageView, imageView4, linearLayout, findViewById, findViewById2);
                                        }
                                        str = "refreshLayout";
                                    } else {
                                        str = "recyclerView";
                                    }
                                } else {
                                    str = "llNull";
                                }
                            } else {
                                str = "ivTopBg";
                            }
                        } else {
                            str = "ivNull";
                        }
                    } else {
                        str = "ivClose";
                    }
                } else {
                    str = "ivBg";
                }
            } else {
                str = "ivBack";
            }
        } else {
            str = "con";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.j;
    }
}
