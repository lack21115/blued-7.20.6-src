package com.blued.android.module.common.widget.emoji.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/view/EmoticonsIndicatorView.class */
public class EmoticonsIndicatorView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f11163a;
    private ArrayList<ImageView> b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f11164c;
    private Bitmap d;
    private int e;
    private int f;

    public EmoticonsIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 12;
        this.f11163a = context;
        setOrientation(0);
        this.f = DensityUtils.a(this.f11163a, this.e);
        this.f11164c = BitmapFactory.decodeResource(getResources(), R.drawable.indicator_point_select);
        this.d = BitmapFactory.decodeResource(getResources(), R.drawable.indicator_point_nomal);
    }

    public void a(int i) {
        if (this.b != null) {
            return;
        }
        this.b = new ArrayList<>();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            RelativeLayout relativeLayout = new RelativeLayout(this.f11163a);
            int i4 = this.f;
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            ImageView imageView = new ImageView(this.f11163a);
            if (i3 == 0) {
                imageView.setImageBitmap(this.f11164c);
                relativeLayout.addView(imageView, layoutParams2);
            } else {
                imageView.setImageBitmap(this.d);
                relativeLayout.addView(imageView, layoutParams2);
            }
            addView(relativeLayout, layoutParams);
            this.b.add(imageView);
            i2 = i3 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        if (r5 == r4) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r4, int r5) {
        /*
            r3 = this;
            r0 = r4
            if (r0 < 0) goto L12
            r0 = r5
            if (r0 < 0) goto L12
            r0 = r4
            r7 = r0
            r0 = r5
            r6 = r0
            r0 = r5
            r1 = r4
            if (r0 != r1) goto L17
        L12:
            r0 = 0
            r7 = r0
            r0 = 0
            r6 = r0
        L17:
            r0 = r3
            java.util.ArrayList<android.widget.ImageView> r0 = r0.b
            int r0 = r0.size()
            if (r0 <= 0) goto L46
            r0 = r3
            java.util.ArrayList<android.widget.ImageView> r0 = r0.b
            r1 = r7
            java.lang.Object r0 = r0.get(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1 = r3
            android.graphics.Bitmap r1 = r1.d
            r0.setImageBitmap(r1)
            r0 = r3
            java.util.ArrayList<android.widget.ImageView> r0 = r0.b
            r1 = r6
            java.lang.Object r0 = r0.get(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1 = r3
            android.graphics.Bitmap r1 = r1.f11164c
            r0.setImageBitmap(r1)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.widget.emoji.view.EmoticonsIndicatorView.a(int, int):void");
    }

    public void b(int i) {
        Iterator<ImageView> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().setImageBitmap(this.d);
        }
        this.b.get(i).setImageBitmap(this.f11164c);
    }

    public void setIndicatorCount(int i) {
        ArrayList<ImageView> arrayList = this.b;
        if (arrayList == null || i > arrayList.size()) {
            return;
        }
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
}
