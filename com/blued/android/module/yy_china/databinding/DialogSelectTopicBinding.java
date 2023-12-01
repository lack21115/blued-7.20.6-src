package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYTopicListView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogSelectTopicBinding.class */
public final class DialogSelectTopicBinding implements ViewBinding {
    public final EditText a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ShapeConstraintLayout e;
    public final RecyclerView f;
    public final YYTopicListView g;
    public final ShapeTextView h;
    public final ShapeTextView i;
    private final RelativeLayout j;

    private DialogSelectTopicBinding(RelativeLayout relativeLayout, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ShapeConstraintLayout shapeConstraintLayout, RecyclerView recyclerView, YYTopicListView yYTopicListView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2) {
        this.j = relativeLayout;
        this.a = editText;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = shapeConstraintLayout;
        this.f = recyclerView;
        this.g = yYTopicListView;
        this.h = shapeTextView;
        this.i = shapeTextView2;
    }

    public static DialogSelectTopicBinding a(View view) {
        String str;
        EditText editText = (EditText) view.findViewById(R.id.ed);
        if (editText != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_bg);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_ref);
                    if (imageView3 != null) {
                        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.ll);
                        if (shapeConstraintLayout != null) {
                            RecyclerView findViewById = view.findViewById(R.id.rcv);
                            if (findViewById != null) {
                                YYTopicListView yYTopicListView = (YYTopicListView) view.findViewById(R.id.topic);
                                if (yYTopicListView != null) {
                                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_click_ok_false);
                                    if (shapeTextView != null) {
                                        ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_click_ok_true);
                                        if (shapeTextView2 != null) {
                                            return new DialogSelectTopicBinding((RelativeLayout) view, editText, imageView, imageView2, imageView3, shapeConstraintLayout, findViewById, yYTopicListView, shapeTextView, shapeTextView2);
                                        }
                                        str = "tvClickOkTrue";
                                    } else {
                                        str = "tvClickOkFalse";
                                    }
                                } else {
                                    str = "topic";
                                }
                            } else {
                                str = "rcv";
                            }
                        } else {
                            str = "ll";
                        }
                    } else {
                        str = "ivRef";
                    }
                } else {
                    str = "ivBg";
                }
            } else {
                str = "ivBack";
            }
        } else {
            str = "ed";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.j;
    }
}
