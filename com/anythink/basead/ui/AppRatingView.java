package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/AppRatingView.class */
public class AppRatingView extends LinearLayout {
    private Context a;
    private List<StarLevelView> b;
    private int c;
    private int d;

    public AppRatingView(Context context) {
        this(context, null, 0);
    }

    public AppRatingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppRatingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        setStarSizeInDp(17);
        setStarMargin(8);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setRating(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.b.size()) {
                return;
            }
            StarLevelView starLevelView = this.b.get(i3);
            if (i3 < i) {
                starLevelView.setState(true);
            } else {
                starLevelView.setState(false);
            }
            i2 = i3 + 1;
        }
    }

    public void setStarMargin(int i) {
        this.d = i;
    }

    public void setStarNum(int i) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.clear();
        removeAllViews();
        setOrientation(0);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            StarLevelView starLevelView = new StarLevelView(getContext());
            int i4 = this.c;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
            if (i3 != i - 1) {
                layoutParams.setMargins(0, 0, dip2px(getContext(), this.d), 0);
            }
            starLevelView.setLayoutParams(layoutParams);
            addView(starLevelView);
            this.b.add(starLevelView);
            i2 = i3 + 1;
        }
    }

    public void setStarSizeInDp(int i) {
        this.c = dip2px(this.a, i);
    }
}
