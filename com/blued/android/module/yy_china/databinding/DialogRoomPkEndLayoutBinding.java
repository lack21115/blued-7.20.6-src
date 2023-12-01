package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.HollowView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogRoomPkEndLayoutBinding.class */
public final class DialogRoomPkEndLayoutBinding implements ViewBinding {
    public final View a;
    public final HollowView b;
    public final HollowView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ShapeableImageView g;
    public final ShapeableImageView h;
    public final RecyclerView i;
    public final RecyclerView j;
    private final ConstraintLayout k;

    private DialogRoomPkEndLayoutBinding(ConstraintLayout constraintLayout, View view, HollowView hollowView, HollowView hollowView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.k = constraintLayout;
        this.a = view;
        this.b = hollowView;
        this.c = hollowView2;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = shapeableImageView;
        this.h = shapeableImageView2;
        this.i = recyclerView;
        this.j = recyclerView2;
    }

    public static DialogRoomPkEndLayoutBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            HollowView hollowView = (HollowView) view.findViewById(R.id.fl_left_bg);
            if (hollowView != null) {
                HollowView hollowView2 = (HollowView) view.findViewById(R.id.fl_right_bg);
                if (hollowView2 != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.img_background);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_left_pk_result);
                        if (imageView2 != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.img_right_pk_result);
                            if (imageView3 != null) {
                                ShapeableImageView findViewById2 = view.findViewById(R.id.pk_left);
                                if (findViewById2 != null) {
                                    ShapeableImageView findViewById3 = view.findViewById(R.id.pk_right);
                                    if (findViewById3 != null) {
                                        RecyclerView findViewById4 = view.findViewById(R.id.rv_blue_rank);
                                        if (findViewById4 != null) {
                                            RecyclerView findViewById5 = view.findViewById(R.id.rv_red_rank);
                                            if (findViewById5 != null) {
                                                return new DialogRoomPkEndLayoutBinding((ConstraintLayout) view, findViewById, hollowView, hollowView2, imageView, imageView2, imageView3, findViewById2, findViewById3, findViewById4, findViewById5);
                                            }
                                            str = "rvRedRank";
                                        } else {
                                            str = "rvBlueRank";
                                        }
                                    } else {
                                        str = "pkRight";
                                    }
                                } else {
                                    str = "pkLeft";
                                }
                            } else {
                                str = "imgRightPkResult";
                            }
                        } else {
                            str = "imgLeftPkResult";
                        }
                    } else {
                        str = "imgBackground";
                    }
                } else {
                    str = "flRightBg";
                }
            } else {
                str = "flLeftBg";
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.k;
    }
}
