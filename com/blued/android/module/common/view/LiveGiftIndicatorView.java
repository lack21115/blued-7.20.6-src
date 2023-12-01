package com.blued.android.module.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/LiveGiftIndicatorView.class */
public class LiveGiftIndicatorView extends LinearLayout {
    private Context a;
    private final List<ImageView> b;
    private int c;
    private int d;
    private int e;
    private int f;

    public LiveGiftIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new ArrayList();
        this.c = 8;
        this.e = R.drawable.live_gift_indicator_point_nomal;
        this.f = R.drawable.live_gift_indicator_point_select;
        this.a = context;
        setOrientation(0);
        this.d = DisplayUtil.a(context, this.c);
    }

    public void a(int i) {
        int size = this.b.size();
        while (true) {
            int i2 = size;
            if (i2 >= i) {
                return;
            }
            RelativeLayout relativeLayout = new RelativeLayout(this.a);
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.d + DisplayUtil.a(getContext(), 4.0f), this.d);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            ImageView imageView = new ImageView(this.a);
            if (i2 == 0) {
                imageView.setImageResource(this.f);
            } else {
                imageView.setImageResource(this.e);
            }
            relativeLayout.addView(imageView, layoutParams2);
            addView(relativeLayout, layoutParams);
            this.b.add(imageView);
            size = i2 + 1;
        }
    }

    public void b(int i) {
        for (ImageView imageView : this.b) {
            imageView.setImageResource(this.e);
        }
        List<ImageView> list = this.b;
        if (list == null || list.size() <= i) {
            return;
        }
        this.b.get(i).setImageResource(this.f);
    }

    public void setIndicatorCount(int i) {
        a(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.b.size()) {
                return;
            }
            if (i3 >= i) {
                this.b.get(i3).setVisibility(8);
                ((View) this.b.get(i3).getParent()).setVisibility(8);
            } else {
                this.b.get(i3).setVisibility(0);
                ((View) this.b.get(i3).getParent()).setVisibility(0);
            }
            i2 = i3 + 1;
        }
    }

    public void setNormalImgRes(int i) {
        this.e = i;
    }

    public void setSelectedImgRes(int i) {
        this.f = i;
    }
}
