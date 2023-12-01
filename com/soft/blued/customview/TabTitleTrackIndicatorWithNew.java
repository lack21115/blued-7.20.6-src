package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.module.common.view.ColorTrackView;
import com.blued.android.module.common.view.TabTitleTrackIndicatorWithDot;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/TabTitleTrackIndicatorWithNew.class */
public class TabTitleTrackIndicatorWithNew extends TabTitleTrackIndicatorWithDot {
    public TabTitleTrackIndicatorWithNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TabTitleTrackIndicatorWithNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(final int i, String str) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_tabtitle_new, (ViewGroup) null);
        ColorTrackView findViewById = inflate.findViewById(2131362978);
        findViewById.setText(str);
        findViewById.setTextSize(this.o);
        findViewById.setTextOriginColor(this.q);
        findViewById.setTextChangeColor(this.r);
        findViewById.setFocusable(true);
        if (i == 0) {
            findViewById.setProgress(1.0f);
            findViewById.setTextSize(this.p);
        }
        this.x.add(findViewById);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131367999);
        linearLayout.setLayoutParams(this.c);
        linearLayout.setPadding(this.k, this.m, this.l, this.n);
        ImageView imageView = (ImageView) inflate.findViewById(2131364507);
        imageView.setVisibility(4);
        if (this.y != null) {
            this.y.add(imageView);
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(2131364707);
        if (this.B) {
            imageView2.setVisibility(4);
        } else {
            imageView2.setVisibility(8);
        }
        if (this.z != null) {
            this.z.add(imageView2);
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.TabTitleTrackIndicatorWithNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TabTitleTrackIndicatorWithNew.this.A = true;
                TabTitleTrackIndicatorWithNew.this.f.setCurrentItem(i);
            }
        });
        this.e.addView(linearLayout);
    }
}
