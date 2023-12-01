package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.soft.blued.R;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/LockPatternView.class */
public class LockPatternView extends View {
    private final Rect A;
    private int B;
    private int C;
    private int D;
    private final Matrix E;
    private final Matrix F;

    /* renamed from: a  reason: collision with root package name */
    private boolean f28448a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f28449c;
    private OnPatternListener d;
    private ArrayList<Cell> e;
    private boolean[][] f;
    private float g;
    private float h;
    private long i;
    private DisplayMode j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private float o;
    private final int p;
    private float q;
    private float r;
    private float s;
    private Bitmap t;
    private Bitmap u;
    private Bitmap v;
    private Bitmap w;
    private Bitmap x;
    private final Path y;
    private final Rect z;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/LockPatternView$Cell.class */
    public static class Cell {

        /* renamed from: c  reason: collision with root package name */
        static Cell[][] f28450c = (Cell[][]) Array.newInstance(Cell.class, 3, 3);

        /* renamed from: a  reason: collision with root package name */
        int f28451a;
        int b;

        static {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 3) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < 3) {
                        f28450c[i2][i4] = new Cell(i2, i4);
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            }
        }

        private Cell(int i, int i2) {
            b(i, i2);
            this.f28451a = i;
            this.b = i2;
        }

        public static Cell a(int i, int i2) {
            Cell cell;
            synchronized (Cell.class) {
                try {
                    b(i, i2);
                    cell = f28450c[i][i2];
                } catch (Throwable th) {
                    throw th;
                }
            }
            return cell;
        }

        private static void b(int i, int i2) {
            if (i < 0 || i > 2) {
                throw new IllegalArgumentException("row must be in range 0-2");
            }
            if (i2 < 0 || i2 > 2) {
                throw new IllegalArgumentException("column must be in range 0-2");
            }
        }

        public int a() {
            return this.f28451a;
        }

        public int b() {
            return this.b;
        }

        public String toString() {
            return "(row=" + this.f28451a + ",clmn=" + this.b + ")";
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/LockPatternView$DisplayMode.class */
    public enum DisplayMode {
        Correct,
        Animate,
        Wrong
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/LockPatternView$OnPatternListener.class */
    public interface OnPatternListener {
        void a();

        void a(List<Cell> list);

        void b();

        void b(List<Cell> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/LockPatternView$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.soft.blued.customview.LockPatternView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final String f28454a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f28455c;
        private final boolean d;
        private final boolean e;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f28454a = parcel.readString();
            this.b = parcel.readInt();
            this.f28455c = ((Boolean) parcel.readValue(null)).booleanValue();
            this.d = ((Boolean) parcel.readValue(null)).booleanValue();
            this.e = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        private SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3) {
            super(parcelable);
            this.f28454a = str;
            this.b = i;
            this.f28455c = z;
            this.d = z2;
            this.e = z3;
        }

        public String a() {
            return this.f28454a;
        }

        public int b() {
            return this.b;
        }

        public boolean c() {
            return this.f28455c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f28454a);
            parcel.writeInt(this.b);
            parcel.writeValue(Boolean.valueOf(this.f28455c));
            parcel.writeValue(Boolean.valueOf(this.d));
            parcel.writeValue(Boolean.valueOf(this.e));
        }
    }

    public LockPatternView(Context context) {
        this(context, null);
    }

    public LockPatternView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28448a = false;
        this.b = new Paint();
        this.f28449c = new Paint();
        this.e = new ArrayList<>(9);
        this.f = (boolean[][]) Array.newInstance(Boolean.TYPE, 3, 3);
        this.g = -1.0f;
        this.h = -1.0f;
        this.j = DisplayMode.Correct;
        this.k = true;
        this.l = false;
        this.m = true;
        this.n = false;
        this.o = 0.1f;
        this.p = 128;
        this.q = 0.6f;
        this.y = new Path();
        this.z = new Rect();
        this.A = new Rect();
        this.E = new Matrix();
        this.F = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LockPatternView);
        String string = obtainStyledAttributes.getString(0);
        if ("square".equals(string)) {
            this.D = 0;
        } else if ("lock_width".equals(string)) {
            this.D = 1;
        } else if ("lock_height".equals(string)) {
            this.D = 2;
        } else {
            this.D = 0;
        }
        setClickable(true);
        this.f28449c.setAntiAlias(true);
        this.f28449c.setDither(true);
        this.f28449c.setAlpha(128);
        this.f28449c.setStyle(Paint.Style.STROKE);
        this.f28449c.setStrokeJoin(Paint.Join.ROUND);
        this.f28449c.setStrokeCap(Paint.Cap.ROUND);
        this.t = a(R.drawable.circle_default_empty_gray);
        this.u = a(R.drawable.circle_btn_touched_blue);
        this.v = a(R.drawable.circle_btn_touched_red);
        this.w = a(R.drawable.triangle_arrow_blue);
        this.x = a(R.drawable.triangle_arrow_red);
        Bitmap bitmap = this.t;
        Bitmap bitmap2 = this.u;
        Bitmap bitmap3 = this.v;
        for (int i = 0; i < 3; i++) {
            Bitmap bitmap4 = new Bitmap[]{bitmap, bitmap2, bitmap3}[i];
            this.B = Math.max(this.B, bitmap4.getWidth());
            this.C = Math.max(this.C, bitmap4.getHeight());
        }
        obtainStyledAttributes.recycle();
    }

    private int a(float f) {
        float f2 = this.s;
        float f3 = this.q * f2;
        float paddingTop = getPaddingTop();
        float f4 = (f2 - f3) / 2.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return -1;
            }
            float f5 = (i2 * f2) + paddingTop + f4;
            if (f >= f5 && f <= f5 + f3) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    private int a(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i2 = Math.max(size, i2);
        } else if (mode != 0) {
            return size;
        }
        return i2;
    }

    private Bitmap a(int i) {
        return BitmapFactory.decodeResource(getContext().getResources(), i);
    }

    private Cell a(float f, float f2) {
        Cell b = b(f, f2);
        Cell cell = null;
        if (b != null) {
            ArrayList<Cell> arrayList = this.e;
            if (!arrayList.isEmpty()) {
                Cell cell2 = arrayList.get(arrayList.size() - 1);
                int i = b.f28451a - cell2.f28451a;
                int i2 = b.b - cell2.b;
                int i3 = cell2.f28451a;
                int i4 = cell2.b;
                int i5 = i3;
                if (Math.abs(i) == 2) {
                    i5 = i3;
                    if (Math.abs(i2) != 1) {
                        i5 = cell2.f28451a + (i > 0 ? 1 : -1);
                    }
                }
                int i6 = i4;
                if (Math.abs(i2) == 2) {
                    i6 = i4;
                    if (Math.abs(i) != 1) {
                        int i7 = cell2.b;
                        int i8 = -1;
                        if (i2 > 0) {
                            i8 = 1;
                        }
                        i6 = i7 + i8;
                    }
                }
                cell = Cell.a(i5, i6);
            }
            if (cell != null && !this.f[cell.f28451a][cell.b]) {
                a(cell);
            }
            a(b);
            if (this.m) {
                performHapticFeedback(1, 3);
            }
            return b;
        }
        return null;
    }

    public static String a(List<Cell> list) {
        if (list == null) {
            return "";
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return Arrays.toString(bArr);
            }
            Cell cell = list.get(i2);
            bArr[i2] = (byte) ((cell.a() * 3) + cell.b());
            i = i2 + 1;
        }
    }

    public static List<Cell> a(String str) {
        ArrayList arrayList = new ArrayList();
        byte[] bytes = str.getBytes();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bytes.length) {
                return arrayList;
            }
            byte b = bytes[i2];
            arrayList.add(Cell.a(b / 3, b % 3));
            i = i2 + 1;
        }
    }

    private void a(Canvas canvas, float f, float f2, Cell cell, Cell cell2) {
        boolean z = this.j != DisplayMode.Wrong;
        int i = cell2.f28451a;
        int i2 = cell.f28451a;
        int i3 = cell2.b;
        int i4 = cell.b;
        int i5 = (((int) this.r) - this.B) / 2;
        int i6 = (((int) this.s) - this.C) / 2;
        Bitmap bitmap = z ? this.w : this.x;
        int i7 = this.B;
        int i8 = this.C;
        float degrees = (float) Math.toDegrees((float) Math.atan2(i - i2, i3 - i4));
        float min = Math.min(this.r / this.B, 1.0f);
        float min2 = Math.min(this.s / this.C, 1.0f);
        this.E.setTranslate(f + i5, f2 + i6);
        this.E.preTranslate(this.B / 2, this.C / 2);
        this.E.preScale(min / 1.3f, min2 / 1.3f);
        this.E.preTranslate((-this.B) / 2, (-this.C) / 2);
        this.E.preRotate(degrees + 90.0f, i7 / 2.0f, i8 / 2.0f);
        this.E.preTranslate((i7 - bitmap.getWidth()) / 2.0f, 0.0f);
        canvas.drawBitmap(bitmap, this.E, this.b);
    }

    private void a(Canvas canvas, int i, int i2, boolean z) {
        Bitmap bitmap;
        if (!z || (this.l && this.j != DisplayMode.Wrong)) {
            bitmap = this.t;
        } else if (this.n) {
            bitmap = this.u;
        } else if (this.j == DisplayMode.Wrong) {
            bitmap = this.v;
        } else if (this.j != DisplayMode.Correct && this.j != DisplayMode.Animate) {
            throw new IllegalStateException("unknown display mode " + this.j);
        } else {
            bitmap = this.u;
        }
        int i3 = this.B;
        int i4 = this.C;
        float f = this.r;
        int i5 = (int) ((f - i3) / 2.0f);
        int i6 = (int) ((this.s - i4) / 2.0f);
        float min = Math.min(f / i3, 1.0f);
        float min2 = Math.min(this.s / this.C, 1.0f);
        this.F.setTranslate(i + i5, i2 + i6);
        this.F.preTranslate(this.B / 2, this.C / 2);
        this.F.preScale(min, min2);
        this.F.preTranslate((-this.B) / 2, (-this.C) / 2);
        canvas.drawBitmap(bitmap, this.F, this.b);
    }

    private void a(MotionEvent motionEvent) {
        float f = this.r * this.o * 0.5f;
        int historySize = motionEvent.getHistorySize();
        this.A.setEmpty();
        int i = 0;
        boolean z = false;
        while (i < historySize + 1) {
            float historicalX = i < historySize ? motionEvent.getHistoricalX(i) : motionEvent.getX();
            float historicalY = i < historySize ? motionEvent.getHistoricalY(i) : motionEvent.getY();
            Cell a2 = a(historicalX, historicalY);
            int size = this.e.size();
            if (a2 != null && size == 1) {
                this.n = true;
                e();
            }
            float abs = Math.abs(historicalX - this.g);
            float abs2 = Math.abs(historicalY - this.h);
            if (abs > 0.0f || abs2 > 0.0f) {
                z = true;
            }
            if (this.n && size > 0) {
                Cell cell = this.e.get(size - 1);
                float b = b(cell.b);
                float c2 = c(cell.f28451a);
                float min = Math.min(b, historicalX) - f;
                float max = Math.max(b, historicalX) + f;
                float min2 = Math.min(c2, historicalY) - f;
                float max2 = Math.max(c2, historicalY) + f;
                float f2 = max;
                float f3 = max2;
                float f4 = min2;
                float f5 = min;
                if (a2 != null) {
                    float f6 = this.r * 0.5f;
                    float f7 = this.s * 0.5f;
                    float b2 = b(a2.b);
                    float c3 = c(a2.f28451a);
                    f5 = Math.min(b2 - f6, min);
                    f2 = Math.max(b2 + f6, max);
                    f4 = Math.min(c3 - f7, min2);
                    f3 = Math.max(c3 + f7, max2);
                }
                this.A.union(Math.round(f5), Math.round(f4), Math.round(f2), Math.round(f3));
            }
            i++;
        }
        this.g = motionEvent.getX();
        this.h = motionEvent.getY();
        if (z) {
            this.z.union(this.A);
            invalidate(this.z);
            this.z.set(this.A);
        }
    }

    private void a(Cell cell) {
        this.f[cell.a()][cell.b()] = true;
        this.e.add(cell);
        d();
    }

    private float b(int i) {
        float paddingLeft = getPaddingLeft();
        float f = this.r;
        return paddingLeft + (i * f) + (f / 2.0f);
    }

    private int b(float f) {
        float f2 = this.r;
        float f3 = this.q * f2;
        float paddingLeft = getPaddingLeft();
        float f4 = (f2 - f3) / 2.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return -1;
            }
            float f5 = (i2 * f2) + paddingLeft + f4;
            if (f >= f5 && f <= f5 + f3) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    private Cell b(float f, float f2) {
        int b;
        int a2 = a(f2);
        if (a2 >= 0 && (b = b(f)) >= 0 && !this.f[a2][b]) {
            return Cell.a(a2, b);
        }
        return null;
    }

    private void b(MotionEvent motionEvent) {
        if (this.e.isEmpty()) {
            return;
        }
        this.n = false;
        f();
        invalidate();
    }

    private float c(int i) {
        float paddingTop = getPaddingTop();
        float f = this.s;
        return paddingTop + (i * f) + (f / 2.0f);
    }

    private void c(MotionEvent motionEvent) {
        h();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Cell a2 = a(x, y);
        if (a2 != null) {
            this.n = true;
            this.j = DisplayMode.Correct;
            e();
        } else if (this.n) {
            this.n = false;
            g();
        }
        if (a2 != null) {
            float b = b(a2.b);
            float c2 = c(a2.f28451a);
            float f = this.r / 2.0f;
            float f2 = this.s / 2.0f;
            invalidate((int) (b - f), (int) (c2 - f2), (int) (b + f), (int) (c2 + f2));
        }
        this.g = x;
        this.h = y;
    }

    private void d() {
        OnPatternListener onPatternListener = this.d;
        if (onPatternListener != null) {
            onPatternListener.a(this.e);
        }
    }

    private void e() {
        OnPatternListener onPatternListener = this.d;
        if (onPatternListener != null) {
            onPatternListener.a();
        }
    }

    private void f() {
        OnPatternListener onPatternListener = this.d;
        if (onPatternListener != null) {
            onPatternListener.b(this.e);
        }
    }

    private void g() {
        OnPatternListener onPatternListener = this.d;
        if (onPatternListener != null) {
            onPatternListener.b();
        }
    }

    private void h() {
        this.e.clear();
        i();
        this.j = DisplayMode.Correct;
        invalidate();
    }

    private void i() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < 3) {
                    this.f[i2][i4] = false;
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public void a() {
        h();
    }

    public void a(DisplayMode displayMode, List<Cell> list) {
        this.e.clear();
        this.e.addAll(list);
        i();
        for (Cell cell : list) {
            this.f[cell.a()][cell.b()] = true;
        }
        setDisplayMode(displayMode);
    }

    public void b() {
        this.k = false;
    }

    public void c() {
        this.k = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return this.B * 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return this.B * 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        int elapsedRealtime;
        ArrayList<Cell> arrayList = this.e;
        int size = arrayList.size();
        boolean[][] zArr = this.f;
        if (this.j == DisplayMode.Animate) {
            int elapsedRealtime2 = (((int) (SystemClock.elapsedRealtime() - this.i)) % ((size + 1) * 700)) / 700;
            i();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= elapsedRealtime2) {
                    break;
                }
                Cell cell = arrayList.get(i2);
                zArr[cell.a()][cell.b()] = true;
                i = i2 + 1;
            }
            if (elapsedRealtime2 > 0 && elapsedRealtime2 < size) {
                float f = (elapsedRealtime % 700) / 700.0f;
                Cell cell2 = arrayList.get(elapsedRealtime2 - 1);
                float b = b(cell2.b);
                float c2 = c(cell2.f28451a);
                Cell cell3 = arrayList.get(elapsedRealtime2);
                float b2 = b(cell3.b);
                float c3 = c(cell3.f28451a);
                this.g = b + ((b2 - b) * f);
                this.h = c2 + (f * (c3 - c2));
            }
            invalidate();
        }
        float f2 = this.r;
        float f3 = this.s;
        this.f28449c.setStrokeWidth(3.0f);
        Path path = this.y;
        path.rewind();
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        boolean z2 = !this.l || this.j == DisplayMode.Wrong;
        boolean z3 = (this.b.getFlags() & 2) != 0;
        this.b.setFilterBitmap(true);
        if (z2) {
            int i3 = 0;
            boolean z4 = false;
            while (true) {
                z = z4;
                if (i3 >= size) {
                    break;
                }
                Cell cell4 = arrayList.get(i3);
                if (!zArr[cell4.f28451a][cell4.b]) {
                    break;
                }
                float b3 = b(cell4.b);
                float c4 = c(cell4.f28451a);
                if (i3 == 0) {
                    path.moveTo(b3, c4);
                } else {
                    path.lineTo(b3, c4);
                }
                i3++;
                z4 = true;
            }
            if ((this.n || this.j == DisplayMode.Animate) && z) {
                path.lineTo(this.g, this.h);
            }
            if (this.j != DisplayMode.Wrong) {
                this.f28449c.setColor(Color.parseColor("#3494f4"));
            } else {
                this.f28449c.setColor(Color.parseColor("#fc5255"));
            }
            canvas.drawPath(path, this.f28449c);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 3) {
                break;
            }
            float f4 = paddingTop;
            float f5 = i5;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < 3) {
                    a(canvas, (int) (paddingLeft + (i7 * f2)), (int) (f4 + (f5 * f3)), zArr[i5][i7]);
                    i6 = i7 + 1;
                }
            }
            i4 = i5 + 1;
        }
        boolean z5 = z3;
        if (z2) {
            int i8 = 0;
            while (true) {
                z5 = z3;
                if (i8 >= size - 1) {
                    break;
                }
                Cell cell5 = arrayList.get(i8);
                i8++;
                Cell cell6 = arrayList.get(i8);
                if (!zArr[cell6.f28451a][cell6.b]) {
                    z5 = z3;
                    break;
                }
                a(canvas, paddingLeft + (cell5.b * f2), paddingTop + (cell5.f28451a * f3), cell5, cell6);
            }
        }
        this.b.setFilterBitmap(z5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int a2 = a(i, suggestedMinimumWidth);
        int a3 = a(i2, suggestedMinimumHeight);
        int i3 = this.D;
        if (i3 == 0) {
            a2 = Math.min(a2, a3);
            a3 = a2;
        } else if (i3 == 1) {
            a3 = Math.min(a2, a3);
        } else if (i3 == 2) {
            a2 = Math.min(a2, a3);
        }
        setMeasuredDimension(a2, a3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        try {
            a(DisplayMode.Correct, a(savedState.a()));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        this.j = DisplayMode.values()[savedState.b()];
        this.k = savedState.c();
        this.l = savedState.d();
        this.m = savedState.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), a(this.e), this.j.ordinal(), this.k, this.l, this.m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.r = ((i - getPaddingLeft()) - getPaddingRight()) / 3.0f;
        this.s = ((i2 - getPaddingTop()) - getPaddingBottom()) / 3.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.k && isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                c(motionEvent);
                return true;
            } else if (action == 1) {
                b(motionEvent);
                return true;
            } else if (action == 2) {
                a(motionEvent);
                return true;
            } else if (action != 3) {
                return false;
            } else {
                if (this.n) {
                    this.n = false;
                    h();
                    g();
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.j = displayMode;
        if (displayMode == DisplayMode.Animate) {
            if (this.e.size() == 0) {
                throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
            }
            this.i = SystemClock.elapsedRealtime();
            Cell cell = this.e.get(0);
            this.g = b(cell.b());
            this.h = c(cell.a());
            i();
        }
        invalidate();
    }

    public void setInStealthMode(boolean z) {
        this.l = z;
    }

    public void setOnPatternListener(OnPatternListener onPatternListener) {
        this.d = onPatternListener;
    }

    public void setTactileFeedbackEnabled(boolean z) {
        this.m = z;
    }
}
