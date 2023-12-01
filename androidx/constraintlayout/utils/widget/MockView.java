package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/utils/widget/MockView.class */
public class MockView extends View {

    /* renamed from: a  reason: collision with root package name */
    protected String f2236a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f2237c;
    private Paint d;
    private boolean e;
    private boolean f;
    private Rect g;
    private int h;
    private int i;
    private int j;
    private int k;

    public MockView(Context context) {
        super(context);
        this.b = new Paint();
        this.f2237c = new Paint();
        this.d = new Paint();
        this.e = true;
        this.f = true;
        this.f2236a = null;
        this.g = new Rect();
        this.h = Color.argb(255, 0, 0, 0);
        this.i = Color.argb(255, 200, 200, 200);
        this.j = Color.argb(255, 50, 50, 50);
        this.k = 4;
        a(context, null);
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Paint();
        this.f2237c = new Paint();
        this.d = new Paint();
        this.e = true;
        this.f = true;
        this.f2236a = null;
        this.g = new Rect();
        this.h = Color.argb(255, 0, 0, 0);
        this.i = Color.argb(255, 200, 200, 200);
        this.j = Color.argb(255, 50, 50, 50);
        this.k = 4;
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Paint();
        this.f2237c = new Paint();
        this.d = new Paint();
        this.e = true;
        this.f = true;
        this.f2236a = null;
        this.g = new Rect();
        this.h = Color.argb(255, 0, 0, 0);
        this.i = Color.argb(255, 200, 200, 200);
        this.j = Color.argb(255, 50, 50, 50);
        this.k = 4;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    break;
                }
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MockView_mock_label) {
                    this.f2236a = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MockView_mock_showDiagonals) {
                    this.e = obtainStyledAttributes.getBoolean(index, this.e);
                } else if (index == R.styleable.MockView_mock_diagonalsColor) {
                    this.h = obtainStyledAttributes.getColor(index, this.h);
                } else if (index == R.styleable.MockView_mock_labelBackgroundColor) {
                    this.j = obtainStyledAttributes.getColor(index, this.j);
                } else if (index == R.styleable.MockView_mock_labelColor) {
                    this.i = obtainStyledAttributes.getColor(index, this.i);
                } else if (index == R.styleable.MockView_mock_showLabel) {
                    this.f = obtainStyledAttributes.getBoolean(index, this.f);
                }
                i = i2 + 1;
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f2236a == null) {
            try {
                this.f2236a = context.getResources().getResourceEntryName(getId());
            } catch (Exception e) {
            }
        }
        this.b.setColor(this.h);
        this.b.setAntiAlias(true);
        this.f2237c.setColor(this.i);
        this.f2237c.setAntiAlias(true);
        this.d.setColor(this.j);
        this.k = Math.round(this.k * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i = width;
        int i2 = height;
        if (this.e) {
            i = width - 1;
            i2 = height - 1;
            float f = i;
            float f2 = i2;
            canvas.drawLine(0.0f, 0.0f, f, f2, this.b);
            canvas.drawLine(0.0f, f2, f, 0.0f, this.b);
            canvas.drawLine(0.0f, 0.0f, f, 0.0f, this.b);
            canvas.drawLine(f, 0.0f, f, f2, this.b);
            canvas.drawLine(f, f2, 0.0f, f2, this.b);
            canvas.drawLine(0.0f, f2, 0.0f, 0.0f, this.b);
        }
        String str = this.f2236a;
        if (str == null || !this.f) {
            return;
        }
        this.f2237c.getTextBounds(str, 0, str.length(), this.g);
        float width2 = (i - this.g.width()) / 2.0f;
        float height2 = ((i2 - this.g.height()) / 2.0f) + this.g.height();
        this.g.offset((int) width2, (int) height2);
        Rect rect = this.g;
        rect.set(rect.left - this.k, this.g.top - this.k, this.g.right + this.k, this.g.bottom + this.k);
        canvas.drawRect(this.g, this.d);
        canvas.drawText(this.f2236a, width2, height2, this.f2237c);
    }
}
