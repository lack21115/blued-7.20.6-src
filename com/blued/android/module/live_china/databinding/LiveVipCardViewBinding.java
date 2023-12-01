package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveVipCardViewBinding.class */
public final class LiveVipCardViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f12429a;
    public final Group b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12430c;
    public final ImageView d;
    public final ImageView e;
    public final ShapeTextView f;
    public final ShapeTextView g;
    public final ShapeTextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    private final ConstraintLayout l;

    private LiveVipCardViewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Group group, ImageView imageView, ImageView imageView2, ImageView imageView3, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ShapeTextView shapeTextView3, TextView textView, TextView textView2, TextView textView3) {
        this.l = constraintLayout;
        this.f12429a = constraintLayout2;
        this.b = group;
        this.f12430c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = shapeTextView;
        this.g = shapeTextView2;
        this.h = shapeTextView3;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
    }

    public static LiveVipCardViewBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_root);
        if (constraintLayout != null) {
            Group group = (Group) view.findViewById(R.id.group_progress);
            if (group != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_ornament);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_title);
                        if (imageView3 != null) {
                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.progress);
                            if (shapeTextView != null) {
                                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.progress_base);
                                if (shapeTextView2 != null) {
                                    ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.tv_current_level_tag);
                                    if (shapeTextView3 != null) {
                                        TextView textView = (TextView) view.findViewById(R.id.tv_desc);
                                        if (textView != null) {
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_left_level);
                                            if (textView2 != null) {
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_right_level);
                                                if (textView3 != null) {
                                                    return new LiveVipCardViewBinding((ConstraintLayout) view, constraintLayout, group, imageView, imageView2, imageView3, shapeTextView, shapeTextView2, shapeTextView3, textView, textView2, textView3);
                                                }
                                                str = "tvRightLevel";
                                            } else {
                                                str = "tvLeftLevel";
                                            }
                                        } else {
                                            str = "tvDesc";
                                        }
                                    } else {
                                        str = "tvCurrentLevelTag";
                                    }
                                } else {
                                    str = "progressBase";
                                }
                            } else {
                                str = "progress";
                            }
                        } else {
                            str = "ivTitle";
                        }
                    } else {
                        str = "ivOrnament";
                    }
                } else {
                    str = "ivBg";
                }
            } else {
                str = "groupProgress";
            }
        } else {
            str = "clRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.l;
    }
}
