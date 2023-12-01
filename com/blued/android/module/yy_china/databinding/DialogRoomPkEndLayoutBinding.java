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

    /* renamed from: a  reason: collision with root package name */
    public final View f16401a;
    public final HollowView b;

    /* renamed from: c  reason: collision with root package name */
    public final HollowView f16402c;
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
        this.f16401a = view;
        this.b = hollowView;
        this.f16402c = hollowView2;
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
                                ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.pk_left);
                                if (shapeableImageView != null) {
                                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.pk_right);
                                    if (shapeableImageView2 != null) {
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_blue_rank);
                                        if (recyclerView != null) {
                                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_red_rank);
                                            if (recyclerView2 != null) {
                                                return new DialogRoomPkEndLayoutBinding((ConstraintLayout) view, findViewById, hollowView, hollowView2, imageView, imageView2, imageView3, shapeableImageView, shapeableImageView2, recyclerView, recyclerView2);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.k;
    }
}
