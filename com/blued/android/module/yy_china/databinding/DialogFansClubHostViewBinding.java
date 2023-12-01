package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogFansClubHostViewBinding.class */
public final class DialogFansClubHostViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f16332a;
    public final ShapeableImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16333c;
    public final ConstraintLayout d;
    public final SmartRefreshLayout e;
    public final ConstraintLayout f;
    public final ConstraintLayout g;
    public final RecyclerView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    private final ConstraintLayout m;

    private DialogFansClubHostViewBinding(ConstraintLayout constraintLayout, View view, ShapeableImageView shapeableImageView, ImageView imageView, ConstraintLayout constraintLayout2, SmartRefreshLayout smartRefreshLayout, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.m = constraintLayout;
        this.f16332a = view;
        this.b = shapeableImageView;
        this.f16333c = imageView;
        this.d = constraintLayout2;
        this.e = smartRefreshLayout;
        this.f = constraintLayout3;
        this.g = constraintLayout4;
        this.h = recyclerView;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
        this.l = textView4;
    }

    public static DialogFansClubHostViewBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.img_host_avatar);
            if (shapeableImageView != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.img_q_a);
                if (imageView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.ll_author_view);
                    if (constraintLayout != null) {
                        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.ll_refresh_view);
                        if (smartRefreshLayout != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.root_cover_view);
                            if (constraintLayout2 != null) {
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.root_view);
                                if (constraintLayout3 != null) {
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fans_list);
                                    if (recyclerView != null) {
                                        TextView textView = (TextView) view.findViewById(R.id.tv_author_name);
                                        if (textView != null) {
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_club_name);
                                            if (textView2 != null) {
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_member_amount);
                                                if (textView3 != null) {
                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_member_count);
                                                    if (textView4 != null) {
                                                        return new DialogFansClubHostViewBinding((ConstraintLayout) view, findViewById, shapeableImageView, imageView, constraintLayout, smartRefreshLayout, constraintLayout2, constraintLayout3, recyclerView, textView, textView2, textView3, textView4);
                                                    }
                                                    str = "tvMemberCount";
                                                } else {
                                                    str = "tvMemberAmount";
                                                }
                                            } else {
                                                str = "tvClubName";
                                            }
                                        } else {
                                            str = "tvAuthorName";
                                        }
                                    } else {
                                        str = "rvFansList";
                                    }
                                } else {
                                    str = "rootView";
                                }
                            } else {
                                str = "rootCoverView";
                            }
                        } else {
                            str = "llRefreshView";
                        }
                    } else {
                        str = "llAuthorView";
                    }
                } else {
                    str = "imgQA";
                }
            } else {
                str = "imgHostAvatar";
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.m;
    }
}
