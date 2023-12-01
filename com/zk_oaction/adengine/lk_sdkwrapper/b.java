package com.zk_oaction.adengine.lk_sdkwrapper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.wrapper_oaction.ZkViewSDK;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdkwrapper/b.class */
public class b extends a {
    private int j;

    public b(Context context, int i, String str, HashMap<ZkViewSDK.KEY, Object> hashMap, int i2, Map map, ZkViewSDK.a aVar) {
        super(context, i, str, hashMap, i2, map, aVar);
    }

    private void b(int i) {
        View view;
        if (i == 0 || (view = this.f41956a) == null || view.getMeasuredWidth() == 0 || this.f41956a.getMeasuredWidth() == i) {
            return;
        }
        float measuredWidth = (i * 1.0f) / this.f41956a.getMeasuredWidth();
        this.f41956a.setScaleX(measuredWidth);
        this.f41956a.setScaleY(measuredWidth);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zk_oaction.adengine.lk_sdkwrapper.a, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int measuredWidth;
        int measuredHeight;
        if (getChildCount() == 0) {
            super.onMeasure(i, i2);
            return;
        }
        if (getParent() != null) {
            this.j = ((View) getParent()).getMeasuredWidth();
        }
        try {
            if (this.f41956a != null) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                if (size >= 0 && size2 >= 0) {
                    float d = this.e.e().d();
                    float e = this.e.e().e();
                    float f = this.e.e().f();
                    b(size, size2);
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (e * d), 1073741824);
                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((int) (d * f), 1073741824);
                    this.f41956a.measure(makeMeasureSpec, makeMeasureSpec2);
                    ViewGroup viewGroup = (ViewGroup) this.f41956a;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= viewGroup.getChildCount()) {
                            break;
                        }
                        viewGroup.getChildAt(i4).measure(makeMeasureSpec, makeMeasureSpec2);
                        i3 = i4 + 1;
                    }
                    f();
                    if (this.j == 0 || this.f41956a.getMeasuredWidth() == 0) {
                        measuredWidth = this.f41956a.getMeasuredWidth();
                        measuredHeight = this.f41956a.getMeasuredHeight();
                    } else {
                        b(this.j);
                        measuredWidth = this.j;
                        measuredHeight = (int) (((this.j * 1.0f) / this.f41956a.getMeasuredWidth()) * this.f41956a.getMeasuredHeight());
                    }
                    setMeasuredDimension(measuredWidth, measuredHeight);
                    return;
                }
            }
            super.onMeasure(i, i2);
        } catch (Throwable th) {
            super.onMeasure(i, i2);
            a(th.getMessage());
        }
    }
}
