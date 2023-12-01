package com.blued.community.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FeedGuessLikeDialogBinding.class */
public final class FeedGuessLikeDialogBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final LinearLayout c;
    public final TextView d;
    public final TextView e;
    public final ShapeTextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    private final ShapeLinearLayout j;

    private FeedGuessLikeDialogBinding(ShapeLinearLayout shapeLinearLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, ShapeTextView shapeTextView, TextView textView3, TextView textView4, TextView textView5) {
        this.j = shapeLinearLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = linearLayout;
        this.d = textView;
        this.e = textView2;
        this.f = shapeTextView;
        this.g = textView3;
        this.h = textView4;
        this.i = textView5;
    }

    public static FeedGuessLikeDialogBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_author_header);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_feed_img);
            if (imageView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_author_header);
                if (linearLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_author_name);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_cancel);
                        if (textView2 != null) {
                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_confirm);
                            if (shapeTextView != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.tvContent);
                                if (textView3 != null) {
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_feed_content);
                                    if (textView4 != null) {
                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_title);
                                        if (textView5 != null) {
                                            return new FeedGuessLikeDialogBinding((ShapeLinearLayout) view, imageView, imageView2, linearLayout, textView, textView2, shapeTextView, textView3, textView4, textView5);
                                        }
                                        str = "tvTitle";
                                    } else {
                                        str = "tvFeedContent";
                                    }
                                } else {
                                    str = "tvContent";
                                }
                            } else {
                                str = "tvConfirm";
                            }
                        } else {
                            str = "tvCancel";
                        }
                    } else {
                        str = "tvAuthorName";
                    }
                } else {
                    str = "llAuthorHeader";
                }
            } else {
                str = "ivFeedImg";
            }
        } else {
            str = "ivAuthorHeader";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ShapeLinearLayout getRoot() {
        return this.j;
    }
}
