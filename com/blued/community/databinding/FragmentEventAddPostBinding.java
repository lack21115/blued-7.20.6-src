package com.blued.community.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;
import com.blued.community.view.EditInputNumView;
import com.blued.community.view.SelectionEditText;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentEventAddPostBinding.class */
public final class FragmentEventAddPostBinding implements ViewBinding {
    public final ToggleButton A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public final ShapeTextView H;
    public final TextView I;
    private final ConstraintLayout J;

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f18849a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f18850c;
    public final SelectionEditText d;
    public final SelectionEditText e;
    public final EditText f;
    public final EditText g;
    public final ImageView h;
    public final ImageView i;
    public final EditInputNumView j;
    public final EditInputNumView k;
    public final EditInputNumView l;
    public final ImageView m;
    public final ImageView n;
    public final ImageView o;
    public final ShapeLinearLayout p;
    public final ConstraintLayout q;
    public final ShapeLinearLayout r;
    public final ShapeLinearLayout s;
    public final ShapeLinearLayout t;
    public final ShapeLinearLayout u;
    public final ShapeLinearLayout v;
    public final ShapeFrameLayout w;
    public final ShapeFrameLayout x;
    public final RecyclerView y;
    public final RecyclerView z;

    private FragmentEventAddPostBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, EditText editText, SelectionEditText selectionEditText, SelectionEditText selectionEditText2, EditText editText2, EditText editText3, ImageView imageView, ImageView imageView2, EditInputNumView editInputNumView, EditInputNumView editInputNumView2, EditInputNumView editInputNumView3, ImageView imageView3, ImageView imageView4, ImageView imageView5, ShapeLinearLayout shapeLinearLayout, ConstraintLayout constraintLayout2, ShapeLinearLayout shapeLinearLayout2, ShapeLinearLayout shapeLinearLayout3, ShapeLinearLayout shapeLinearLayout4, ShapeLinearLayout shapeLinearLayout5, ShapeLinearLayout shapeLinearLayout6, ShapeFrameLayout shapeFrameLayout, ShapeFrameLayout shapeFrameLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, ToggleButton toggleButton, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ShapeTextView shapeTextView, TextView textView8) {
        this.J = constraintLayout;
        this.f18849a = linearLayout;
        this.b = textView;
        this.f18850c = editText;
        this.d = selectionEditText;
        this.e = selectionEditText2;
        this.f = editText2;
        this.g = editText3;
        this.h = imageView;
        this.i = imageView2;
        this.j = editInputNumView;
        this.k = editInputNumView2;
        this.l = editInputNumView3;
        this.m = imageView3;
        this.n = imageView4;
        this.o = imageView5;
        this.p = shapeLinearLayout;
        this.q = constraintLayout2;
        this.r = shapeLinearLayout2;
        this.s = shapeLinearLayout3;
        this.t = shapeLinearLayout4;
        this.u = shapeLinearLayout5;
        this.v = shapeLinearLayout6;
        this.w = shapeFrameLayout;
        this.x = shapeFrameLayout2;
        this.y = recyclerView;
        this.z = recyclerView2;
        this.A = toggleButton;
        this.B = textView2;
        this.C = textView3;
        this.D = textView4;
        this.E = textView5;
        this.F = textView6;
        this.G = textView7;
        this.H = shapeTextView;
        this.I = textView8;
    }

    public static FragmentEventAddPostBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.btn_location);
        if (linearLayout != null) {
            TextView textView = (TextView) view.findViewById(R.id.btntxt_add_pic);
            if (textView != null) {
                EditText editText = (EditText) view.findViewById(R.id.edt_address);
                if (editText != null) {
                    SelectionEditText selectionEditText = (SelectionEditText) view.findViewById(R.id.edt_content);
                    if (selectionEditText != null) {
                        SelectionEditText selectionEditText2 = (SelectionEditText) view.findViewById(R.id.edt_hyperlinks);
                        if (selectionEditText2 != null) {
                            EditText editText2 = (EditText) view.findViewById(R.id.edt_number);
                            if (editText2 != null) {
                                EditText editText3 = (EditText) view.findViewById(R.id.edt_title);
                                if (editText3 != null) {
                                    ImageView imageView = (ImageView) view.findViewById(R.id.img_add);
                                    if (imageView != null) {
                                        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_add_pic_btn);
                                        if (imageView2 != null) {
                                            EditInputNumView editInputNumView = (EditInputNumView) view.findViewById(R.id.inv_address);
                                            if (editInputNumView != null) {
                                                EditInputNumView editInputNumView2 = (EditInputNumView) view.findViewById(R.id.inv_content);
                                                if (editInputNumView2 != null) {
                                                    EditInputNumView editInputNumView3 = (EditInputNumView) view.findViewById(R.id.inv_title);
                                                    if (editInputNumView3 != null) {
                                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_close);
                                                        if (imageView3 != null) {
                                                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_offline);
                                                            if (imageView4 != null) {
                                                                ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_online);
                                                                if (imageView5 != null) {
                                                                    ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.lay_add_pic);
                                                                    if (shapeLinearLayout != null) {
                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.ll_title);
                                                                        if (constraintLayout != null) {
                                                                            ShapeLinearLayout shapeLinearLayout2 = (ShapeLinearLayout) view.findViewById(R.id.ly_date);
                                                                            if (shapeLinearLayout2 != null) {
                                                                                ShapeLinearLayout shapeLinearLayout3 = (ShapeLinearLayout) view.findViewById(R.id.ly_hyperlinks);
                                                                                if (shapeLinearLayout3 != null) {
                                                                                    ShapeLinearLayout shapeLinearLayout4 = (ShapeLinearLayout) view.findViewById(R.id.ly_join_review);
                                                                                    if (shapeLinearLayout4 != null) {
                                                                                        ShapeLinearLayout shapeLinearLayout5 = (ShapeLinearLayout) view.findViewById(R.id.ly_location);
                                                                                        if (shapeLinearLayout5 != null) {
                                                                                            ShapeLinearLayout shapeLinearLayout6 = (ShapeLinearLayout) view.findViewById(R.id.ly_number);
                                                                                            if (shapeLinearLayout6 != null) {
                                                                                                ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.ly_offline);
                                                                                                if (shapeFrameLayout != null) {
                                                                                                    ShapeFrameLayout shapeFrameLayout2 = (ShapeFrameLayout) view.findViewById(R.id.ly_online);
                                                                                                    if (shapeFrameLayout2 != null) {
                                                                                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_add_photo);
                                                                                                        if (recyclerView != null) {
                                                                                                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_event_type);
                                                                                                            if (recyclerView2 != null) {
                                                                                                                ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.tgb_join_review);
                                                                                                                if (toggleButton != null) {
                                                                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_add_cover);
                                                                                                                    if (textView2 != null) {
                                                                                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_city);
                                                                                                                        if (textView3 != null) {
                                                                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_date);
                                                                                                                            if (textView4 != null) {
                                                                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_number_tip);
                                                                                                                                if (textView5 != null) {
                                                                                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_offline);
                                                                                                                                    if (textView6 != null) {
                                                                                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_online);
                                                                                                                                        if (textView7 != null) {
                                                                                                                                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_post);
                                                                                                                                            if (shapeTextView != null) {
                                                                                                                                                TextView textView8 = (TextView) view.findViewById(R.id.tv_title);
                                                                                                                                                if (textView8 != null) {
                                                                                                                                                    return new FragmentEventAddPostBinding((ConstraintLayout) view, linearLayout, textView, editText, selectionEditText, selectionEditText2, editText2, editText3, imageView, imageView2, editInputNumView, editInputNumView2, editInputNumView3, imageView3, imageView4, imageView5, shapeLinearLayout, constraintLayout, shapeLinearLayout2, shapeLinearLayout3, shapeLinearLayout4, shapeLinearLayout5, shapeLinearLayout6, shapeFrameLayout, shapeFrameLayout2, recyclerView, recyclerView2, toggleButton, textView2, textView3, textView4, textView5, textView6, textView7, shapeTextView, textView8);
                                                                                                                                                }
                                                                                                                                                str = "tvTitle";
                                                                                                                                            } else {
                                                                                                                                                str = "tvPost";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "tvOnline";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "tvOffline";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "tvNumberTip";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "tvDate";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "tvCity";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "tvAddCover";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "tgbJoinReview";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "rvEventType";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "rvAddPhoto";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "lyOnline";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "lyOffline";
                                                                                                }
                                                                                            } else {
                                                                                                str = "lyNumber";
                                                                                            }
                                                                                        } else {
                                                                                            str = "lyLocation";
                                                                                        }
                                                                                    } else {
                                                                                        str = "lyJoinReview";
                                                                                    }
                                                                                } else {
                                                                                    str = "lyHyperlinks";
                                                                                }
                                                                            } else {
                                                                                str = "lyDate";
                                                                            }
                                                                        } else {
                                                                            str = "llTitle";
                                                                        }
                                                                    } else {
                                                                        str = "layAddPic";
                                                                    }
                                                                } else {
                                                                    str = "ivOnline";
                                                                }
                                                            } else {
                                                                str = "ivOffline";
                                                            }
                                                        } else {
                                                            str = "ivClose";
                                                        }
                                                    } else {
                                                        str = "invTitle";
                                                    }
                                                } else {
                                                    str = "invContent";
                                                }
                                            } else {
                                                str = "invAddress";
                                            }
                                        } else {
                                            str = "imgAddPicBtn";
                                        }
                                    } else {
                                        str = "imgAdd";
                                    }
                                } else {
                                    str = "edtTitle";
                                }
                            } else {
                                str = "edtNumber";
                            }
                        } else {
                            str = "edtHyperlinks";
                        }
                    } else {
                        str = "edtContent";
                    }
                } else {
                    str = "edtAddress";
                }
            } else {
                str = "btntxtAddPic";
            }
        } else {
            str = "btnLocation";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.J;
    }
}
