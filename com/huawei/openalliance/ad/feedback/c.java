package com.huawei.openalliance.ad.feedback;

import android.view.View;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.utils.aa;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/feedback/c.class */
public class c {
    private int I;
    private final List<View> V = new ArrayList();
    private int Z = 0;

    public int Code() {
        return this.I;
    }

    public void Code(int i) {
        this.Z = i;
    }

    public void Code(int i, int i2, int i3, int i4, int i5, int i6) {
        if (aa.Code(this.V)) {
            return;
        }
        if (i != -1) {
            if (i == 0) {
                int size = ((((this.V.size() - 1) * i6) + i5) - this.Z) / (this.V.size() + 1);
                for (View view : this.V) {
                    int i7 = i3 + size;
                    view.layout(i7, i4, view.getMeasuredWidth() + i7, view.getMeasuredHeight() + i4);
                    i3 = i7 + view.getMeasuredWidth();
                }
                return;
            } else if (i != 1) {
                ge.V("FlowLayoutLine", "lineMode error");
                return;
            } else {
                for (View view2 : this.V) {
                    view2.layout(i3, i4, view2.getMeasuredWidth() + i3, view2.getMeasuredHeight() + i4);
                    i3 += view2.getMeasuredWidth() + i6;
                }
                return;
            }
        }
        int i8 = i3 + (i5 - this.Z) + i2 + i6;
        int size2 = this.V.size();
        while (true) {
            int i9 = size2 - 1;
            if (i9 < 0) {
                return;
            }
            this.V.get(i9).layout(i8, i4, this.V.get(i9).getMeasuredWidth() + i8, this.V.get(i9).getMeasuredHeight() + i4);
            i8 += this.V.get(i9).getMeasuredWidth() + i6;
            size2 = i9;
        }
    }

    public void Code(View view) {
        this.V.add(view);
        if (this.I < view.getMeasuredHeight()) {
            this.I = view.getMeasuredHeight();
        }
    }
}
