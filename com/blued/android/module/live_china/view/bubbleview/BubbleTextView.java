package com.blued.android.module.live_china.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.bubbleview.BubbleDrawable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/bubbleview/BubbleTextView.class */
public class BubbleTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private BubbleDrawable f15332a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f15333c;
    private float d;
    private float e;
    private int f;
    private BubbleDrawable.ArrowLocation g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.bubbleview.BubbleTextView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/bubbleview/BubbleTextView$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15334a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[BubbleDrawable.ArrowLocation.values().length];
            f15334a = iArr;
            try {
                iArr[BubbleDrawable.ArrowLocation.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15334a[BubbleDrawable.ArrowLocation.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15334a[BubbleDrawable.ArrowLocation.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15334a[BubbleDrawable.ArrowLocation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public BubbleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public BubbleTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a() {
        a(getWidth(), getHeight());
    }

    private void a(int i, int i2) {
        a(0, i, 0, i2);
    }

    private void a(int i, int i2, int i3, int i4) {
        this.f15332a = new BubbleDrawable.Builder().a(new RectF(i, i3, i2, i4)).a(this.g).a(BubbleDrawable.BubbleType.COLOR).b(this.f15333c).c(this.d).a(this.b).a(this.f).d(this.e).a(this.h).a();
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleView);
            this.b = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowWidth, BubbleDrawable.Builder.f15330a);
            this.d = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowHeight, BubbleDrawable.Builder.b);
            this.f15333c = obtainStyledAttributes.getDimension(R.styleable.BubbleView_angle, BubbleDrawable.Builder.f15331c);
            this.e = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowPosition, BubbleDrawable.Builder.d);
            this.f = obtainStyledAttributes.getColor(R.styleable.BubbleView_bubbleColor, BubbleDrawable.Builder.e);
            this.g = BubbleDrawable.ArrowLocation.a(obtainStyledAttributes.getInt(R.styleable.BubbleView_arrowLocation, 0));
            this.h = obtainStyledAttributes.getBoolean(R.styleable.BubbleView_arrowCenter, false);
            obtainStyledAttributes.recycle();
        }
        b();
    }

    private void b() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i = AnonymousClass1.f15334a[this.g.ordinal()];
        if (i == 1) {
            paddingLeft = (int) (paddingLeft + this.b);
        } else if (i == 2) {
            paddingRight = (int) (paddingRight + this.b);
        } else if (i == 3) {
            paddingTop = (int) (paddingTop + this.d);
        } else if (i == 4) {
            paddingBottom = (int) (paddingBottom + this.d);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        BubbleDrawable bubbleDrawable = this.f15332a;
        if (bubbleDrawable != null) {
            bubbleDrawable.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        a(i, i2);
    }
}
