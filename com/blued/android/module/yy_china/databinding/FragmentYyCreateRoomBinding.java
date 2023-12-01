package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyCreateRoomBinding.class */
public final class FragmentYyCreateRoomBinding implements ViewBinding {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public final ImageView G;
    public final ImageView H;
    private final ConstraintLayout I;
    public final EditText a;
    public final FrameLayout b;
    public final Group c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;
    public final ShapeTextView m;
    public final LinearLayout n;
    public final ConstraintLayout o;
    public final ConstraintLayout p;
    public final ConstraintLayout q;
    public final RecyclerView r;
    public final RecyclerView s;
    public final RecyclerView t;
    public final ShapeRelativeLayout u;
    public final TextView v;
    public final ShapeTextView w;
    public final TextView x;
    public final ShapeTextView y;
    public final TextView z;

    private FragmentYyCreateRoomBinding(ConstraintLayout constraintLayout, EditText editText, FrameLayout frameLayout, Group group, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ShapeTextView shapeTextView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, ShapeRelativeLayout shapeRelativeLayout, TextView textView, ShapeTextView shapeTextView2, TextView textView2, ShapeTextView shapeTextView3, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ImageView imageView10, ImageView imageView11) {
        this.I = constraintLayout;
        this.a = editText;
        this.b = frameLayout;
        this.c = group;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = imageView5;
        this.i = imageView6;
        this.j = imageView7;
        this.k = imageView8;
        this.l = imageView9;
        this.m = shapeTextView;
        this.n = linearLayout;
        this.o = constraintLayout2;
        this.p = constraintLayout3;
        this.q = constraintLayout4;
        this.r = recyclerView;
        this.s = recyclerView2;
        this.t = recyclerView3;
        this.u = shapeRelativeLayout;
        this.v = textView;
        this.w = shapeTextView2;
        this.x = textView2;
        this.y = shapeTextView3;
        this.z = textView3;
        this.A = textView4;
        this.B = textView5;
        this.C = textView6;
        this.D = textView7;
        this.E = textView8;
        this.F = textView9;
        this.G = imageView10;
        this.H = imageView11;
    }

    public static FragmentYyCreateRoomBinding a(View view) {
        String str;
        EditText editText = (EditText) view.findViewById(R.id.ed);
        if (editText != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_outside_view);
            if (frameLayout != null) {
                Group findViewById = view.findViewById(R.id.gro_masked_guide);
                if (findViewById != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.img_model_mask_icon);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_model_normal_icon);
                        if (imageView2 != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.img_question);
                            if (imageView3 != null) {
                                ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_back);
                                if (imageView4 != null) {
                                    ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_background);
                                    if (imageView5 != null) {
                                        ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_background_ani);
                                        if (imageView6 != null) {
                                            ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_ed);
                                            if (imageView7 != null) {
                                                ImageView imageView8 = (ImageView) view.findViewById(R.id.iv_mask_guide);
                                                if (imageView8 != null) {
                                                    ImageView imageView9 = (ImageView) view.findViewById(R.id.iv_mask_guide_back);
                                                    if (imageView9 != null) {
                                                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.iv_select_im_notic);
                                                        if (shapeTextView != null) {
                                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_im_notic);
                                                            if (linearLayout != null) {
                                                                ConstraintLayout findViewById2 = view.findViewById(R.id.ll_mask_layout);
                                                                if (findViewById2 != null) {
                                                                    ConstraintLayout findViewById3 = view.findViewById(R.id.ll_mask_model);
                                                                    if (findViewById3 != null) {
                                                                        ConstraintLayout findViewById4 = view.findViewById(R.id.ll_normal_model);
                                                                        if (findViewById4 != null) {
                                                                            RecyclerView findViewById5 = view.findViewById(R.id.rcv);
                                                                            if (findViewById5 != null) {
                                                                                RecyclerView findViewById6 = view.findViewById(R.id.rcv_bg);
                                                                                if (findViewById6 != null) {
                                                                                    RecyclerView findViewById7 = view.findViewById(R.id.rcv_label);
                                                                                    if (findViewById7 != null) {
                                                                                        ShapeRelativeLayout shapeRelativeLayout = (ShapeRelativeLayout) view.findViewById(R.id.sha);
                                                                                        if (shapeRelativeLayout != null) {
                                                                                            TextView textView = (TextView) view.findViewById(R.id.tv_background_title);
                                                                                            if (textView != null) {
                                                                                                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_create);
                                                                                                if (shapeTextView2 != null) {
                                                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_ktv_notice);
                                                                                                    if (textView2 != null) {
                                                                                                        ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.tv_mask_guide);
                                                                                                        if (shapeTextView3 != null) {
                                                                                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_model_mask_text);
                                                                                                            if (textView3 != null) {
                                                                                                                TextView textView4 = (TextView) view.findViewById(R.id.tv_model_normal_text);
                                                                                                                if (textView4 != null) {
                                                                                                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_model_title);
                                                                                                                    if (textView5 != null) {
                                                                                                                        TextView textView6 = (TextView) view.findViewById(R.id.tv_right);
                                                                                                                        if (textView6 != null) {
                                                                                                                            TextView textView7 = (TextView) view.findViewById(R.id.tv_room_play_info);
                                                                                                                            if (textView7 != null) {
                                                                                                                                TextView textView8 = (TextView) view.findViewById(R.id.tv_ti);
                                                                                                                                if (textView8 != null) {
                                                                                                                                    TextView textView9 = (TextView) view.findViewById(R.id.tv_title);
                                                                                                                                    if (textView9 != null) {
                                                                                                                                        ImageView imageView10 = (ImageView) view.findViewById(R.id.view_border_mask);
                                                                                                                                        if (imageView10 != null) {
                                                                                                                                            ImageView imageView11 = (ImageView) view.findViewById(R.id.view_border_normal);
                                                                                                                                            if (imageView11 != null) {
                                                                                                                                                return new FragmentYyCreateRoomBinding((ConstraintLayout) view, editText, frameLayout, findViewById, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, shapeTextView, linearLayout, findViewById2, findViewById3, findViewById4, findViewById5, findViewById6, findViewById7, shapeRelativeLayout, textView, shapeTextView2, textView2, shapeTextView3, textView3, textView4, textView5, textView6, textView7, textView8, textView9, imageView10, imageView11);
                                                                                                                                            }
                                                                                                                                            str = "viewBorderNormal";
                                                                                                                                        } else {
                                                                                                                                            str = "viewBorderMask";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "tvTitle";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "tvTi";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "tvRoomPlayInfo";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "tvRight";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "tvModelTitle";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "tvModelNormalText";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "tvModelMaskText";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "tvMaskGuide";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "tvKtvNotice";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvCreate";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvBackgroundTitle";
                                                                                            }
                                                                                        } else {
                                                                                            str = "sha";
                                                                                        }
                                                                                    } else {
                                                                                        str = "rcvLabel";
                                                                                    }
                                                                                } else {
                                                                                    str = "rcvBg";
                                                                                }
                                                                            } else {
                                                                                str = "rcv";
                                                                            }
                                                                        } else {
                                                                            str = "llNormalModel";
                                                                        }
                                                                    } else {
                                                                        str = "llMaskModel";
                                                                    }
                                                                } else {
                                                                    str = "llMaskLayout";
                                                                }
                                                            } else {
                                                                str = "llImNotic";
                                                            }
                                                        } else {
                                                            str = "ivSelectImNotic";
                                                        }
                                                    } else {
                                                        str = "ivMaskGuideBack";
                                                    }
                                                } else {
                                                    str = "ivMaskGuide";
                                                }
                                            } else {
                                                str = "ivEd";
                                            }
                                        } else {
                                            str = "ivBackgroundAni";
                                        }
                                    } else {
                                        str = "ivBackground";
                                    }
                                } else {
                                    str = "ivBack";
                                }
                            } else {
                                str = "imgQuestion";
                            }
                        } else {
                            str = "imgModelNormalIcon";
                        }
                    } else {
                        str = "imgModelMaskIcon";
                    }
                } else {
                    str = "groMaskedGuide";
                }
            } else {
                str = "flOutsideView";
            }
        } else {
            str = "ed";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.I;
    }
}
