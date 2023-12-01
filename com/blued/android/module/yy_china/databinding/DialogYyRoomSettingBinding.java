package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyRoomSettingBinding.class */
public final class DialogYyRoomSettingBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final ShapeableImageView d;
    public final ShapeableImageView e;
    public final ShapeableImageView f;
    public final RelativeLayout g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final LinearLayout j;
    public final LinearLayout k;
    public final LinearLayout l;
    public final RecyclerView m;
    public final RecyclerView n;
    public final ToggleButton o;
    public final ToggleButton p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    private final ShapeConstraintLayout x;

    private DialogYyRoomSettingBinding(ShapeConstraintLayout shapeConstraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, ShapeableImageView shapeableImageView3, RelativeLayout relativeLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, RecyclerView recyclerView, RecyclerView recyclerView2, ToggleButton toggleButton, ToggleButton toggleButton2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.x = shapeConstraintLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = shapeableImageView;
        this.e = shapeableImageView2;
        this.f = shapeableImageView3;
        this.g = relativeLayout;
        this.h = linearLayout;
        this.i = linearLayout2;
        this.j = linearLayout3;
        this.k = linearLayout4;
        this.l = linearLayout5;
        this.m = recyclerView;
        this.n = recyclerView2;
        this.o = toggleButton;
        this.p = toggleButton2;
        this.q = textView;
        this.r = textView2;
        this.s = textView3;
        this.t = textView4;
        this.u = textView5;
        this.v = textView6;
        this.w = textView7;
    }

    public static DialogYyRoomSettingBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_fans_notic_more);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_more);
                if (imageView3 != null) {
                    ShapeableImageView findViewById = view.findViewById(R.id.iv_user_1);
                    if (findViewById != null) {
                        ShapeableImageView findViewById2 = view.findViewById(R.id.iv_user_2);
                        if (findViewById2 != null) {
                            ShapeableImageView findViewById3 = view.findViewById(R.id.iv_user_3);
                            if (findViewById3 != null) {
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.ll_fans_notic);
                                if (relativeLayout != null) {
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_hello_code);
                                    if (linearLayout != null) {
                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_room_id);
                                        if (linearLayout2 != null) {
                                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_room_name);
                                            if (linearLayout3 != null) {
                                                LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_room_note);
                                                if (linearLayout4 != null) {
                                                    LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.ll_room_settring_user);
                                                    if (linearLayout5 != null) {
                                                        RecyclerView findViewById4 = view.findViewById(R.id.rcv_room_background);
                                                        if (findViewById4 != null) {
                                                            RecyclerView findViewById5 = view.findViewById(R.id.rcv_room_type);
                                                            if (findViewById5 != null) {
                                                                ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.tb_bean_num_listen);
                                                                if (toggleButton != null) {
                                                                    ToggleButton toggleButton2 = (ToggleButton) view.findViewById(R.id.tb_fans_notic_listen);
                                                                    if (toggleButton2 != null) {
                                                                        TextView textView = (TextView) view.findViewById(R.id.tv_beans);
                                                                        if (textView != null) {
                                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_clear_bean_num);
                                                                            if (textView2 != null) {
                                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_fans_notic);
                                                                                if (textView3 != null) {
                                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_hello_code);
                                                                                    if (textView4 != null) {
                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_id);
                                                                                        if (textView5 != null) {
                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_name);
                                                                                            if (textView6 != null) {
                                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_note);
                                                                                                if (textView7 != null) {
                                                                                                    return new DialogYyRoomSettingBinding((ShapeConstraintLayout) view, imageView, imageView2, imageView3, findViewById, findViewById2, findViewById3, relativeLayout, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, findViewById4, findViewById5, toggleButton, toggleButton2, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                                                                                }
                                                                                                str = "tvNote";
                                                                                            } else {
                                                                                                str = "tvName";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvId";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvHelloCode";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvFansNotic";
                                                                                }
                                                                            } else {
                                                                                str = "tvClearBeanNum";
                                                                            }
                                                                        } else {
                                                                            str = "tvBeans";
                                                                        }
                                                                    } else {
                                                                        str = "tbFansNoticListen";
                                                                    }
                                                                } else {
                                                                    str = "tbBeanNumListen";
                                                                }
                                                            } else {
                                                                str = "rcvRoomType";
                                                            }
                                                        } else {
                                                            str = "rcvRoomBackground";
                                                        }
                                                    } else {
                                                        str = "llRoomSettringUser";
                                                    }
                                                } else {
                                                    str = "llRoomNote";
                                                }
                                            } else {
                                                str = "llRoomName";
                                            }
                                        } else {
                                            str = "llRoomId";
                                        }
                                    } else {
                                        str = "llHelloCode";
                                    }
                                } else {
                                    str = "llFansNotic";
                                }
                            } else {
                                str = "ivUser3";
                            }
                        } else {
                            str = "ivUser2";
                        }
                    } else {
                        str = "ivUser1";
                    }
                } else {
                    str = "ivMore";
                }
            } else {
                str = "ivFansNoticMore";
            }
        } else {
            str = "ivBack";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.x;
    }
}
