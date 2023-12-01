package com.soft.blued.ui.login_register.AreaCode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.soft.blued.R;
import com.soft.blued.ui.user.adapter.CountryAdapter;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/AreaCode/AreaCodeSectionBar.class */
public class AreaCodeSectionBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private String[] f31352a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f31353c;
    private ListView d;
    private AreaCodeIndexer e;
    private int f;
    private Paint g;
    private Context h;

    public AreaCodeSectionBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AreaCodeSectionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f31352a = new String[0];
        this.b = 10;
        this.f31353c = 10 + 4;
        this.h = context;
        a();
    }

    public static int a(float f, Context context) {
        return (int) ((f * (context.getResources().getDisplayMetrics().densityDpi / 160.0f)) + 0.5d);
    }

    private void a() {
        this.f31352a = this.h.getResources().getStringArray(R.array.area_code_array);
        this.b = a(this.b, getContext());
        this.f31353c = a(this.f31353c, getContext());
        Paint paint = new Paint();
        this.g = paint;
        paint.setColor(BluedSkinUtils.a(this.h, 2131101528));
        this.g.setTextSize(this.b);
        this.g.setTextAlign(Paint.Align.CENTER);
        this.g.setAntiAlias(true);
    }

    public void a(ListView listView, CountryAdapter countryAdapter) {
        this.d = listView;
        if (countryAdapter == null) {
            throw new RuntimeException("ListView must set Adapter or Adapter must implements Indexer interface");
        }
        this.e = countryAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = this.f31352a;
            if (i2 >= strArr.length) {
                super.onDraw(canvas);
                return;
            }
            String valueOf = String.valueOf(strArr[i2]);
            float measuredWidth = getMeasuredWidth() / 2;
            int i3 = this.f31353c;
            canvas.drawText(valueOf, measuredWidth, i3 + (i2 * i3) + this.f, this.g);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f = (getMeasuredHeight() / 2) - ((this.f31353c * this.f31352a.length) / 2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int a2;
        int y = (((int) motionEvent.getY()) - this.f) / this.f31353c;
        String[] strArr = this.f31352a;
        if (y >= strArr.length) {
            i = strArr.length - 1;
        } else {
            i = y;
            if (y < 0) {
                i = 0;
            }
        }
        if ((motionEvent.getAction() == 0 || motionEvent.getAction() == 2) && (a2 = this.e.a(String.valueOf(this.f31352a[i]))) != -1) {
            this.d.setSelection(a2);
            return true;
        }
        return true;
    }

    public void setListView(ListView listView) {
        this.d = listView;
        AreaCodeSelectorAdapter areaCodeSelectorAdapter = (AreaCodeSelectorAdapter) listView.getAdapter();
        if (areaCodeSelectorAdapter == null) {
            throw new RuntimeException("ListView must set Adapter or Adapter must implements Indexer interface");
        }
        this.e = areaCodeSelectorAdapter;
    }
}
