package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/UsersNotificationLayoutBinding.class */
public final class UsersNotificationLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f15920a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f15921c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;
    public final TextView m;
    public final TextView n;
    private final ShapeConstraintLayout o;

    private UsersNotificationLayoutBinding(ShapeConstraintLayout shapeConstraintLayout, ConstraintLayout constraintLayout, ImageView imageView, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, TextView textView, TextView textView2) {
        this.o = shapeConstraintLayout;
        this.f15920a = constraintLayout;
        this.b = imageView;
        this.f15921c = frameLayout;
        this.d = frameLayout2;
        this.e = frameLayout3;
        this.f = imageView2;
        this.g = imageView3;
        this.h = imageView4;
        this.i = imageView5;
        this.j = imageView6;
        this.k = imageView7;
        this.l = imageView8;
        this.m = textView;
        this.n = textView2;
    }

    public static UsersNotificationLayoutBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_feed_img);
        if (constraintLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.feed_img);
            if (imageView != null) {
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_header_view);
                if (frameLayout != null) {
                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_status_bar);
                    if (frameLayout2 != null) {
                        FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.fl_video);
                        if (frameLayout3 != null) {
                            ImageView imageView2 = (ImageView) view.findViewById(2131364232);
                            if (imageView2 != null) {
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.img_chat);
                                if (imageView3 != null) {
                                    ImageView imageView4 = (ImageView) view.findViewById(R.id.img_live_new_icon);
                                    if (imageView4 != null) {
                                        ImageView imageView5 = (ImageView) view.findViewById(R.id.img_notification_bg);
                                        if (imageView5 != null) {
                                            ImageView imageView6 = (ImageView) view.findViewById(R.id.img_verify);
                                            if (imageView6 != null) {
                                                ImageView imageView7 = (ImageView) view.findViewById(R.id.tv_bg_1);
                                                if (imageView7 != null) {
                                                    ImageView imageView8 = (ImageView) view.findViewById(R.id.tv_bg_2);
                                                    if (imageView8 != null) {
                                                        TextView textView = (TextView) view.findViewById(R.id.tv_notification_content);
                                                        if (textView != null) {
                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_notification_title);
                                                            if (textView2 != null) {
                                                                return new UsersNotificationLayoutBinding((ShapeConstraintLayout) view, constraintLayout, imageView, frameLayout, frameLayout2, frameLayout3, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, textView, textView2);
                                                            }
                                                            str = "tvNotificationTitle";
                                                        } else {
                                                            str = "tvNotificationContent";
                                                        }
                                                    } else {
                                                        str = "tvBg2";
                                                    }
                                                } else {
                                                    str = "tvBg1";
                                                }
                                            } else {
                                                str = "imgVerify";
                                            }
                                        } else {
                                            str = "imgNotificationBg";
                                        }
                                    } else {
                                        str = "imgLiveNewIcon";
                                    }
                                } else {
                                    str = "imgChat";
                                }
                            } else {
                                str = "headerView";
                            }
                        } else {
                            str = "flVideo";
                        }
                    } else {
                        str = "flStatusBar";
                    }
                } else {
                    str = "flHeaderView";
                }
            } else {
                str = "feedImg";
            }
        } else {
            str = "clFeedImg";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.o;
    }
}
