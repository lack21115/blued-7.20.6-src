package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mapsdk.internal.mf;
import com.tencent.mapsdk.internal.p4;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/lf.class */
public class lf extends n4 {
    private Context d;
    private TextView e;
    private mf.a f;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/lf$a.class */
    public class a implements Runnable {
        public final /* synthetic */ ViewGroup b;

        public a(ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.addView(lf.this.e);
        }
    }

    public lf(Context context, TencentMapContext tencentMapContext) {
        this.d = context;
        this.e = new oc(this.d, tencentMapContext);
    }

    private Bitmap e() {
        this.e.setTextSize(18.0f);
        this.e.setTextColor(-16777216);
        this.e.setText("鉴权失败,请检查你的key");
        return b7.a(this.e);
    }

    @Override // com.tencent.mapsdk.internal.p4
    public void a() {
    }

    @Override // com.tencent.mapsdk.internal.i5
    public void a(int i, int i2) {
    }

    public void a(mf.a aVar) {
        this.f = aVar;
    }

    @Override // com.tencent.mapsdk.internal.p4
    public void a(p4.b bVar) {
    }

    @Override // com.tencent.mapsdk.internal.p4
    public boolean a(ViewGroup viewGroup, Bundle bundle) {
        if (viewGroup == null || this.e == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.e.setLayoutParams(layoutParams);
        int measuredWidth = viewGroup.getMeasuredWidth();
        int measuredHeight = viewGroup.getMeasuredHeight();
        Bitmap e = e();
        ca.b(new a(viewGroup));
        mf.a aVar = this.f;
        if (aVar != null) {
            aVar.a(e, measuredWidth, measuredHeight);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mapsdk.internal.n4
    public View[] c() {
        return new View[0];
    }

    @Override // com.tencent.mapsdk.internal.p4
    public p4.b getPosition() {
        return null;
    }
}
