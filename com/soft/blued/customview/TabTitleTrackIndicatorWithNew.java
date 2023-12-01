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

    @Override // com.blued.android.module.common.view.TabTitleTrackIndicatorWithDot
    public void a(final int i, String str) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_tabtitle_new, (ViewGroup) null);
        ColorTrackView colorTrackView = (ColorTrackView) inflate.findViewById(2131362978);
        colorTrackView.setText(str);
        colorTrackView.setTextSize(this.o);
        colorTrackView.setTextOriginColor(this.q);
        colorTrackView.setTextChangeColor(this.r);
        colorTrackView.setFocusable(true);
        if (i == 0) {
            colorTrackView.setProgress(1.0f);
            colorTrackView.setTextSize(this.p);
        }
        this.x.add(colorTrackView);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131367999);
        linearLayout.setLayoutParams(this.f11061c);
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
