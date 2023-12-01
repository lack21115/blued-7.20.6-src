package com.anythink.expressad.videocommon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.anythink.expressad.foundation.h.i;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/view/StarLevelView.class */
public class StarLevelView extends LinearLayout {
    public StarLevelView(Context context) {
        super(context);
        setOrientation(0);
    }

    public StarLevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
    }

    public StarLevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
    }

    public void initScore(double d) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= ((int) d)) {
                break;
            }
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(i.a(getContext(), "anythink_video_common_full_star", i.f7952c));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i2 != 0) {
                layoutParams.setMargins(5, 0, 5, 0);
            }
            addView(imageView, layoutParams);
            i = i2 + 1;
        }
        int i3 = (int) (50.0d - (d * 10.0d));
        if (i3 <= 0) {
            return;
        }
        if (i3 > 1 && i3 < 10) {
            if (i3 <= 0 || i3 >= 5) {
                ImageView imageView2 = new ImageView(getContext());
                imageView2.setImageResource(i.a(getContext(), "anythink_video_common_full_star", i.f7952c));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(5, 0, 5, 0);
                addView(imageView2, layoutParams2);
            } else {
                ImageView imageView3 = new ImageView(getContext());
                imageView3.setImageResource(i.a(getContext(), "anythink_video_common_full_star", i.f7952c));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(5, 0, 5, 0);
                addView(imageView3, layoutParams3);
            }
        }
        int i4 = i3 / 10;
        if (i4 <= 0) {
            return;
        }
        int i5 = i3 % (i4 * 10);
        if (i5 > 0 && i5 < 5) {
            ImageView imageView4 = new ImageView(getContext());
            imageView4.setImageResource(i.a(getContext(), "anythink_video_common_full_while_star", i.f7952c));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.setMargins(5, 0, 5, 0);
            addView(imageView4, layoutParams4);
        } else if (i5 >= 5 && i5 <= 9) {
            ImageView imageView5 = new ImageView(getContext());
            imageView5.setImageResource(i.a(getContext(), "anythink_video_common_half_star", i.f7952c));
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.setMargins(5, 0, 5, 0);
            addView(imageView5, layoutParams5);
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= i4) {
                return;
            }
            ImageView imageView6 = new ImageView(getContext());
            imageView6.setImageResource(i.a(getContext(), "anythink_video_common_full_while_star", i.f7952c));
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams6.setMargins(5, 0, 5, 0);
            addView(imageView6, layoutParams6);
            i6 = i7 + 1;
        }
    }
}
