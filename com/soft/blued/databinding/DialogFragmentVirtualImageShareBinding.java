package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/DialogFragmentVirtualImageShareBinding.class */
public final class DialogFragmentVirtualImageShareBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CardView f28701a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f28702c;
    public final LinearLayout d;
    public final ShapeTextView e;
    public final ShapeTextView f;
    public final TextView g;
    public final TextView h;
    private final LinearLayout i;

    private DialogFragmentVirtualImageShareBinding(LinearLayout linearLayout, CardView cardView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, TextView textView, TextView textView2) {
        this.i = linearLayout;
        this.f28701a = cardView;
        this.b = imageView;
        this.f28702c = imageView2;
        this.d = linearLayout2;
        this.e = shapeTextView;
        this.f = shapeTextView2;
        this.g = textView;
        this.h = textView2;
    }

    public static DialogFragmentVirtualImageShareBinding a(View view) {
        String str;
        CardView cardView = (CardView) view.findViewById(R.id.card_user_face);
        if (cardView != null) {
            ImageView imageView = (ImageView) view.findViewById(2131365207);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_user_face);
                if (imageView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(2131366879);
                    if (linearLayout != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.post_feed_btn);
                        if (shapeTextView != null) {
                            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.to_photo_btn);
                            if (shapeTextView2 != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_pop_content);
                                if (textView != null) {
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_pop_title);
                                    if (textView2 != null) {
                                        return new DialogFragmentVirtualImageShareBinding((LinearLayout) view, cardView, imageView, imageView2, linearLayout, shapeTextView, shapeTextView2, textView, textView2);
                                    }
                                    str = "tvPopTitle";
                                } else {
                                    str = "tvPopContent";
                                }
                            } else {
                                str = "toPhotoBtn";
                            }
                        } else {
                            str = "postFeedBtn";
                        }
                    } else {
                        str = "linearLayout";
                    }
                } else {
                    str = "ivUserFace";
                }
            } else {
                str = "ivClose";
            }
        } else {
            str = "cardUserFace";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.i;
    }
}
