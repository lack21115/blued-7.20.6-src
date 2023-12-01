package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import com.blued.android.module.live.base.view.GiftHitLoadingView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftHitLoadingView.class */
public class YYGiftHitLoadingView extends GiftHitLoadingView {
    public YYGiftHitLoadingView(Context context) {
        super(context);
    }

    public YYGiftHitLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.blued.android.module.live.base.view.GiftHitLoadingView
    public void a() {
        super.a();
        this.c.setVisibility(8);
    }

    @Override // com.blued.android.module.live.base.view.GiftHitLoadingView
    public void b() {
        this.b.setImageResource(R.drawable.animation00);
        this.b.setVisibility(0);
        this.a.setImageResource(0);
        setLoadFloorVisibility(8);
        this.d = 0;
    }

    @Override // com.blued.android.module.live.base.view.GiftHitLoadingView
    public void setResources(int i) {
        switch (i) {
            case 2:
                this.b.setImageResource(R.drawable.animation7);
                return;
            case 3:
                this.b.setImageResource(R.drawable.animation6);
                return;
            case 4:
                this.b.setImageResource(R.drawable.animation5);
                return;
            case 5:
                this.b.setImageResource(R.drawable.animation4);
                return;
            case 6:
                this.b.setImageResource(R.drawable.animation3);
                return;
            case 7:
                this.b.setImageResource(R.drawable.animation2);
                return;
            case 8:
                this.b.setImageResource(R.drawable.animation1);
                return;
            case 9:
                this.b.setImageResource(R.drawable.animation0);
                return;
            default:
                this.b.setImageResource(R.drawable.animation00);
                this.a.setImageResource(0);
                setLoadFloorVisibility(8);
                return;
        }
    }
}
