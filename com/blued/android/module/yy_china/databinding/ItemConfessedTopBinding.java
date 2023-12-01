package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYLivingStreamView;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemConfessedTopBinding.class */
public final class ItemConfessedTopBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Group f16578a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeableImageView f16579c;
    public final ImageView d;
    public final ShapeableImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final YYLivingStreamView i;
    public final YYLivingStreamView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final ShapeTextView o;
    public final TextView p;
    private final ConstraintLayout q;

    private ItemConfessedTopBinding(ConstraintLayout constraintLayout, Group group, ImageView imageView, ShapeableImageView shapeableImageView, ImageView imageView2, ShapeableImageView shapeableImageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, YYLivingStreamView yYLivingStreamView, YYLivingStreamView yYLivingStreamView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, ShapeTextView shapeTextView, TextView textView5) {
        this.q = constraintLayout;
        this.f16578a = group;
        this.b = imageView;
        this.f16579c = shapeableImageView;
        this.d = imageView2;
        this.e = shapeableImageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = imageView5;
        this.i = yYLivingStreamView;
        this.j = yYLivingStreamView2;
        this.k = textView;
        this.l = textView2;
        this.m = textView3;
        this.n = textView4;
        this.o = shapeTextView;
        this.p = textView5;
    }

    public static ItemConfessedTopBinding a(View view) {
        String str;
        Group group = (Group) view.findViewById(R.id.gro);
        if (group != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg_card);
            if (imageView != null) {
                ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv_user_1);
                if (shapeableImageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_user_1_tag);
                    if (imageView2 != null) {
                        ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.iv_user_2);
                        if (shapeableImageView2 != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_user_2_tag);
                            if (imageView3 != null) {
                                ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_yh_y);
                                if (imageView4 != null) {
                                    ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_yh_z);
                                    if (imageView5 != null) {
                                        YYLivingStreamView yYLivingStreamView = (YYLivingStreamView) view.findViewById(R.id.live_1);
                                        if (yYLivingStreamView != null) {
                                            YYLivingStreamView yYLivingStreamView2 = (YYLivingStreamView) view.findViewById(R.id.live_2);
                                            if (yYLivingStreamView2 != null) {
                                                TextView textView = (TextView) view.findViewById(R.id.ti);
                                                if (textView != null) {
                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_con_num);
                                                    if (textView2 != null) {
                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_con_ti);
                                                        if (textView3 != null) {
                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_con_time);
                                                            if (textView4 != null) {
                                                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_content);
                                                                if (shapeTextView != null) {
                                                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_null);
                                                                    if (textView5 != null) {
                                                                        return new ItemConfessedTopBinding((ConstraintLayout) view, group, imageView, shapeableImageView, imageView2, shapeableImageView2, imageView3, imageView4, imageView5, yYLivingStreamView, yYLivingStreamView2, textView, textView2, textView3, textView4, shapeTextView, textView5);
                                                                    }
                                                                    str = "tvNull";
                                                                } else {
                                                                    str = "tvContent";
                                                                }
                                                            } else {
                                                                str = "tvConTime";
                                                            }
                                                        } else {
                                                            str = "tvConTi";
                                                        }
                                                    } else {
                                                        str = "tvConNum";
                                                    }
                                                } else {
                                                    str = "ti";
                                                }
                                            } else {
                                                str = "live2";
                                            }
                                        } else {
                                            str = "live1";
                                        }
                                    } else {
                                        str = "ivYhZ";
                                    }
                                } else {
                                    str = "ivYhY";
                                }
                            } else {
                                str = "ivUser2Tag";
                            }
                        } else {
                            str = "ivUser2";
                        }
                    } else {
                        str = "ivUser1Tag";
                    }
                } else {
                    str = "ivUser1";
                }
            } else {
                str = "ivBgCard";
            }
        } else {
            str = "gro";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.q;
    }
}
