package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.LiveFansLevelView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveHostFinishDetailItemBinding.class */
public final class LiveHostFinishDetailItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f12243a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12244c;
    public final LiveFansLevelView d;
    public final LiveFansLevelView e;
    public final ImageView f;
    public final ShapeFrameLayout g;
    public final ImageView h;
    public final ImageView i;
    public final LinearLayout j;
    public final ShapeConstraintLayout k;
    public final ShapeTextView l;
    public final ShapeTextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    private final ShapeConstraintLayout q;

    private LiveHostFinishDetailItemBinding(ShapeConstraintLayout shapeConstraintLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LiveFansLevelView liveFansLevelView, LiveFansLevelView liveFansLevelView2, ImageView imageView3, ShapeFrameLayout shapeFrameLayout, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, ShapeConstraintLayout shapeConstraintLayout2, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, TextView textView, TextView textView2, TextView textView3) {
        this.q = shapeConstraintLayout;
        this.f12243a = frameLayout;
        this.b = imageView;
        this.f12244c = imageView2;
        this.d = liveFansLevelView;
        this.e = liveFansLevelView2;
        this.f = imageView3;
        this.g = shapeFrameLayout;
        this.h = imageView4;
        this.i = imageView5;
        this.j = linearLayout;
        this.k = shapeConstraintLayout2;
        this.l = shapeTextView;
        this.m = shapeTextView2;
        this.n = textView;
        this.o = textView2;
        this.p = textView3;
    }

    public static LiveHostFinishDetailItemBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_des);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_avatar);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_beans);
                if (imageView2 != null) {
                    LiveFansLevelView liveFansLevelView = (LiveFansLevelView) view.findViewById(R.id.iv_fans_level);
                    if (liveFansLevelView != null) {
                        LiveFansLevelView liveFansLevelView2 = (LiveFansLevelView) view.findViewById(R.id.iv_fans_level_1);
                        if (liveFansLevelView2 != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_noble);
                            if (imageView3 != null) {
                                ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.iv_online_user_avatar);
                                if (shapeFrameLayout != null) {
                                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_rich_level);
                                    if (imageView4 != null) {
                                        ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_vip);
                                        if (imageView5 != null) {
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_des);
                                            if (linearLayout != null) {
                                                ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.main_view);
                                                if (shapeConstraintLayout != null) {
                                                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_atten);
                                                    if (shapeTextView != null) {
                                                        ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_attend);
                                                        if (shapeTextView2 != null) {
                                                            TextView textView = (TextView) view.findViewById(R.id.tv_des);
                                                            if (textView != null) {
                                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_num);
                                                                if (textView2 != null) {
                                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_online_user_nickname);
                                                                    if (textView3 != null) {
                                                                        return new LiveHostFinishDetailItemBinding((ShapeConstraintLayout) view, frameLayout, imageView, imageView2, liveFansLevelView, liveFansLevelView2, imageView3, shapeFrameLayout, imageView4, imageView5, linearLayout, shapeConstraintLayout, shapeTextView, shapeTextView2, textView, textView2, textView3);
                                                                    }
                                                                    str = "tvOnlineUserNickname";
                                                                } else {
                                                                    str = "tvNum";
                                                                }
                                                            } else {
                                                                str = "tvDes";
                                                            }
                                                        } else {
                                                            str = "tvAttend";
                                                        }
                                                    } else {
                                                        str = "tvAtten";
                                                    }
                                                } else {
                                                    str = "mainView";
                                                }
                                            } else {
                                                str = "llDes";
                                            }
                                        } else {
                                            str = "ivVip";
                                        }
                                    } else {
                                        str = "ivRichLevel";
                                    }
                                } else {
                                    str = "ivOnlineUserAvatar";
                                }
                            } else {
                                str = "ivNoble";
                            }
                        } else {
                            str = "ivFansLevel1";
                        }
                    } else {
                        str = "ivFansLevel";
                    }
                } else {
                    str = "ivBeans";
                }
            } else {
                str = "ivAvatar";
            }
        } else {
            str = "flDes";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.q;
    }
}
