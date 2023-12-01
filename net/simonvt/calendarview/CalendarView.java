package net.simonvt.calendarview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import cn.blued.blued_third_library.R;
import com.google.android.material.timepicker.TimeModel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: source-3503164-dex2jar.jar:net/simonvt/calendarview/CalendarView.class */
public class CalendarView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f43802a = CalendarView.class.getSimpleName();
    private int A;
    private long B;
    private boolean C;
    private int D;
    private int E;
    private OnDateChangeListener F;
    private ScrollStateRunnable G;
    private Calendar H;
    private Calendar I;
    private Calendar J;
    private Calendar K;
    private final DateFormat L;
    private Locale M;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private int f43803c;
    private Drawable d;
    private final int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private int r;
    private float s;
    private float t;
    private WeeksAdapter u;
    private ListView v;
    private TextView w;
    private ViewGroup x;
    private String[] y;
    private int z;

    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/calendarview/CalendarView$OnDateChangeListener.class */
    public interface OnDateChangeListener {
        void a(CalendarView calendarView, int i, int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/calendarview/CalendarView$ScrollStateRunnable.class */
    public class ScrollStateRunnable implements Runnable {
        private AbsListView b;

        /* renamed from: c  reason: collision with root package name */
        private int f43807c;

        private ScrollStateRunnable() {
        }

        public void a(AbsListView absListView, int i) {
            this.b = absListView;
            this.f43807c = i;
            CalendarView.this.removeCallbacks(this);
            CalendarView.this.postDelayed(this, 40L);
        }

        @Override // java.lang.Runnable
        public void run() {
            CalendarView.this.E = this.f43807c;
            if (this.f43807c == 0 && CalendarView.this.D != 0) {
                View childAt = this.b.getChildAt(0);
                if (childAt == null) {
                    return;
                }
                int bottom = childAt.getBottom() - CalendarView.this.m;
                if (bottom > CalendarView.this.m) {
                    if (CalendarView.this.C) {
                        this.b.smoothScrollBy(bottom - childAt.getHeight(), 500);
                    } else {
                        this.b.smoothScrollBy(bottom, 500);
                    }
                }
            }
            CalendarView.this.D = this.f43807c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/calendarview/CalendarView$WeekView.class */
    public class WeekView extends View {
        private final Rect b;

        /* renamed from: c  reason: collision with root package name */
        private final Paint f43809c;
        private final Paint d;
        private String[] e;
        private boolean[] f;
        private boolean g;
        private boolean h;
        private Calendar i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;
        private boolean o;
        private int p;
        private int q;
        private int r;
        private int s;
        private Locale t;

        public WeekView(Context context) {
            super(context);
            this.b = new Rect();
            this.f43809c = new Paint();
            this.d = new Paint();
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.o = false;
            this.p = -1;
            this.r = -1;
            this.s = -1;
            this.t = context.getResources().getConfiguration().locale;
            d();
        }

        private void a(Canvas canvas) {
            int i;
            if (this.o) {
                this.f43809c.setColor(CalendarView.this.f);
                this.b.top = CalendarView.this.b;
                this.b.bottom = this.n;
                boolean f = CalendarView.this.f();
                int i2 = 0;
                if (f) {
                    this.b.left = 0;
                    this.b.right = this.r - 2;
                } else {
                    Rect rect = this.b;
                    if (CalendarView.this.q) {
                        i2 = this.m / this.q;
                    }
                    rect.left = i2;
                    this.b.right = this.r - 2;
                }
                canvas.drawRect(this.b, this.f43809c);
                if (f) {
                    this.b.left = this.s + 3;
                    Rect rect2 = this.b;
                    if (CalendarView.this.q) {
                        int i3 = this.m;
                        i = i3 - (i3 / this.q);
                    } else {
                        i = this.m;
                    }
                    rect2.right = i;
                } else {
                    this.b.left = this.s + 3;
                    this.b.right = this.m;
                }
                canvas.drawRect(this.b, this.f43809c);
            }
        }

        private void b(Canvas canvas) {
            int textSize = ((int) ((this.n + this.f43809c.getTextSize()) / 2.0f)) - CalendarView.this.b;
            int i = this.q;
            int i2 = i * 2;
            this.f43809c.setTextAlign(Paint.Align.CENTER);
            this.f43809c.setTextSize(CalendarView.this.f43803c);
            int i3 = 0;
            if (!CalendarView.this.f()) {
                if (CalendarView.this.q) {
                    this.f43809c.setColor(CalendarView.this.j);
                    canvas.drawText(this.e[0], this.m / i2, textSize, this.f43809c);
                    i3 = 1;
                }
                while (i3 < i) {
                    this.d.setColor(this.f[i3] ? CalendarView.this.g : CalendarView.this.h);
                    canvas.drawText(this.e[i3], (((i3 * 2) + 1) * this.m) / i2, textSize, this.d);
                    i3++;
                }
                return;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                int i6 = i - 1;
                if (i5 >= i6) {
                    break;
                }
                this.d.setColor(this.f[i5] ? CalendarView.this.g : CalendarView.this.h);
                canvas.drawText(this.e[i6 - i5], (((i5 * 2) + 1) * this.m) / i2, textSize, this.d);
                i4 = i5 + 1;
            }
            if (CalendarView.this.q) {
                this.f43809c.setColor(CalendarView.this.j);
                int i7 = this.m;
                canvas.drawText(this.e[0], i7 - (i7 / i2), textSize, this.f43809c);
            }
        }

        private void c(Canvas canvas) {
            float f;
            int i;
            int firstVisiblePosition = CalendarView.this.v.getFirstVisiblePosition();
            int i2 = firstVisiblePosition;
            if (CalendarView.this.v.getChildAt(0).getTop() < 0) {
                i2 = firstVisiblePosition + 1;
            }
            if (i2 == this.l) {
                return;
            }
            this.f43809c.setColor(CalendarView.this.i);
            this.f43809c.setStrokeWidth(CalendarView.this.b);
            float f2 = 0.0f;
            if (CalendarView.this.f()) {
                if (CalendarView.this.q) {
                    int i3 = this.m;
                    i = i3 - (i3 / this.q);
                } else {
                    i = this.m;
                }
                f = i;
                f2 = 0.0f;
            } else {
                if (CalendarView.this.q) {
                    f2 = this.m / this.q;
                }
                f = this.m;
            }
            canvas.drawLine(f2, 0.0f, f, 0.0f, this.f43809c);
        }

        private void d() {
            this.f43809c.setFakeBoldText(false);
            this.f43809c.setAntiAlias(true);
            this.f43809c.setStyle(Paint.Style.FILL);
            this.d.setFakeBoldText(true);
            this.d.setAntiAlias(true);
            this.d.setStyle(Paint.Style.FILL);
            this.d.setTextAlign(Paint.Align.CENTER);
            this.d.setTextSize(CalendarView.this.f43803c);
        }

        private void d(Canvas canvas) {
            if (this.o) {
                CalendarView.this.d.setBounds(this.r - (CalendarView.this.e / 2), CalendarView.this.b, this.r + (CalendarView.this.e / 2), this.n);
                CalendarView.this.d.draw(canvas);
                CalendarView.this.d.setBounds(this.s - (CalendarView.this.e / 2), CalendarView.this.b, this.s + (CalendarView.this.e / 2), this.n);
                CalendarView.this.d.draw(canvas);
            }
        }

        private void e() {
            if (this.o) {
                boolean f = CalendarView.this.f();
                int i = this.p - CalendarView.this.z;
                int i2 = i;
                if (i < 0) {
                    i2 = i + 7;
                }
                int i3 = i2;
                if (CalendarView.this.q) {
                    i3 = i2;
                    if (!f) {
                        i3 = i2 + 1;
                    }
                }
                if (f) {
                    this.r = (((CalendarView.this.r - 1) - i3) * this.m) / this.q;
                } else {
                    this.r = (i3 * this.m) / this.q;
                }
                this.s = this.r + (this.m / this.q);
            }
        }

        public int a() {
            return this.j;
        }

        public void a(int i, int i2, int i3) {
            int i4;
            this.p = i2;
            this.o = i2 != -1;
            this.q = CalendarView.this.q ? CalendarView.this.r + 1 : CalendarView.this.r;
            this.l = i;
            CalendarView.this.H.setTimeInMillis(CalendarView.this.J.getTimeInMillis());
            CalendarView.this.H.add(3, this.l);
            CalendarView.this.H.setFirstDayOfWeek(CalendarView.this.z);
            int i5 = this.q;
            this.e = new String[i5];
            this.f = new boolean[i5];
            if (CalendarView.this.q) {
                this.e[0] = String.format(this.t, TimeModel.NUMBER_FORMAT, Integer.valueOf(CalendarView.this.H.get(3)));
                i4 = 1;
            } else {
                i4 = 0;
            }
            CalendarView.this.H.add(5, CalendarView.this.z - CalendarView.this.H.get(7));
            this.i = (Calendar) CalendarView.this.H.clone();
            this.j = CalendarView.this.H.get(2);
            this.h = true;
            while (i4 < this.q) {
                boolean z = CalendarView.this.H.get(2) == i3;
                this.f[i4] = z;
                this.g |= z;
                this.h = (!z) & this.h;
                if (CalendarView.this.H.before(CalendarView.this.J) || CalendarView.this.H.after(CalendarView.this.K)) {
                    this.e[i4] = "";
                } else {
                    this.e[i4] = String.format(this.t, TimeModel.NUMBER_FORMAT, Integer.valueOf(CalendarView.this.H.get(5)));
                }
                CalendarView.this.H.add(5, 1);
                i4++;
            }
            if (CalendarView.this.H.get(5) == 1) {
                CalendarView.this.H.add(5, -1);
            }
            this.k = CalendarView.this.H.get(2);
            e();
        }

        public boolean a(float f, Calendar calendar) {
            int i;
            int i2;
            int i3;
            boolean f2 = CalendarView.this.f();
            if (f2) {
                if (CalendarView.this.q) {
                    int i4 = this.m;
                    i3 = i4 - (i4 / this.q);
                } else {
                    i3 = this.m;
                }
                i2 = 0;
                i = i3;
            } else {
                int i5 = CalendarView.this.q ? this.m / this.q : 0;
                i = this.m;
                i2 = i5;
            }
            float f3 = i2;
            if (f < f3 || f > i) {
                calendar.clear();
                return false;
            }
            int i6 = (int) (((f - f3) * CalendarView.this.r) / (i - i2));
            int i7 = i6;
            if (f2) {
                i7 = (CalendarView.this.r - 1) - i6;
            }
            calendar.setTimeInMillis(this.i.getTimeInMillis());
            calendar.add(5, i7);
            return true;
        }

        public int b() {
            return this.k;
        }

        public Calendar c() {
            return this.i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            a(canvas);
            b(canvas);
            c(canvas);
            d(canvas);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public void onMeasure(int i, int i2) {
            this.n = ((CalendarView.this.v.getHeight() - CalendarView.this.v.getPaddingTop()) - CalendarView.this.v.getPaddingBottom()) / CalendarView.this.p;
            setMeasuredDimension(View.MeasureSpec.getSize(i), this.n);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            this.m = i;
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/calendarview/CalendarView$WeeksAdapter.class */
    public class WeeksAdapter extends BaseAdapter implements View.OnTouchListener {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private GestureDetector f43811c;
        private int d;
        private final Calendar e = Calendar.getInstance();
        private int f;

        /* loaded from: source-3503164-dex2jar.jar:net/simonvt/calendarview/CalendarView$WeeksAdapter$CalendarGestureListener.class */
        class CalendarGestureListener extends GestureDetector.SimpleOnGestureListener {
            CalendarGestureListener() {
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }
        }

        public WeeksAdapter(Context context) {
            this.f43811c = new GestureDetector(CalendarView.this.getContext(), new CalendarGestureListener());
            b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.b = CalendarView.this.a(this.e);
            CalendarView calendarView = CalendarView.this;
            this.f = calendarView.a(calendarView.K);
            if (CalendarView.this.J.get(7) == CalendarView.this.z && CalendarView.this.K.get(7) == CalendarView.this.z) {
                return;
            }
            this.f++;
        }

        private void b(Calendar calendar) {
            a(calendar);
            CalendarView.this.setMonthDisplayed(calendar);
        }

        public Calendar a() {
            return this.e;
        }

        public void a(int i) {
            if (this.d == i) {
                return;
            }
            this.d = i;
            notifyDataSetChanged();
        }

        public void a(Calendar calendar) {
            if (calendar.get(6) == this.e.get(6) && calendar.get(1) == this.e.get(1)) {
                return;
            }
            this.e.setTimeInMillis(calendar.getTimeInMillis());
            this.b = CalendarView.this.a(this.e);
            this.d = this.e.get(2);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            WeekView weekView;
            if (view != null) {
                weekView = (WeekView) view;
            } else {
                CalendarView calendarView = CalendarView.this;
                weekView = new WeekView(calendarView.getContext());
                weekView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
                weekView.setClickable(true);
                weekView.setOnTouchListener(this);
            }
            weekView.a(i, this.b == i ? this.e.get(7) : -1, this.d);
            return weekView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (CalendarView.this.v.isEnabled() && this.f43811c.onTouchEvent(motionEvent)) {
                if (!((WeekView) view).a(motionEvent.getX(), CalendarView.this.H) || CalendarView.this.H.before(CalendarView.this.J) || CalendarView.this.H.after(CalendarView.this.K)) {
                    return true;
                }
                b(CalendarView.this.H);
                return true;
            }
            return false;
        }
    }

    public CalendarView(Context context) {
        this(context, null);
    }

    public CalendarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CalendarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.m = 2;
        this.n = 12;
        this.o = 20;
        this.r = 7;
        this.s = 0.05f;
        this.t = 0.333f;
        this.C = false;
        this.D = 0;
        this.E = 0;
        this.G = new ScrollStateRunnable();
        this.L = new SimpleDateFormat("MM/dd/yyyy");
        setCurrentLocale(context.getResources().getConfiguration().locale);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CalendarView, R.attr.calendarViewStyle, 0);
        this.q = obtainStyledAttributes.getBoolean(R.styleable.CalendarView_cv_showWeekNumber, true);
        this.z = obtainStyledAttributes.getInt(R.styleable.CalendarView_cv_firstDayOfWeek, Calendar.getInstance().getFirstDayOfWeek());
        String string = obtainStyledAttributes.getString(R.styleable.CalendarView_cv_minDate);
        if (TextUtils.isEmpty(string) || !a(string, this.J)) {
            a("01/01/1900", this.J);
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.CalendarView_cv_maxDate);
        if (TextUtils.isEmpty(string2) || !a(string2, this.K)) {
            a("01/01/2100", this.K);
        }
        if (this.K.before(this.J)) {
            throw new IllegalArgumentException("Max date cannot be before min date.");
        }
        this.p = obtainStyledAttributes.getInt(R.styleable.CalendarView_cv_shownWeekCount, 6);
        this.f = obtainStyledAttributes.getColor(R.styleable.CalendarView_cv_selectedWeekBackgroundColor, 0);
        this.g = obtainStyledAttributes.getColor(R.styleable.CalendarView_cv_focusedMonthDateColor, 0);
        this.h = obtainStyledAttributes.getColor(R.styleable.CalendarView_cv_unfocusedMonthDateColor, 0);
        this.i = obtainStyledAttributes.getColor(R.styleable.CalendarView_cv_weekSeparatorLineColor, 0);
        this.j = obtainStyledAttributes.getColor(R.styleable.CalendarView_cv_weekNumberColor, 0);
        this.d = obtainStyledAttributes.getDrawable(R.styleable.CalendarView_cv_selectedDateVerticalBar);
        this.l = obtainStyledAttributes.getResourceId(R.styleable.CalendarView_cv_dateTextAppearance, 16973894);
        a();
        this.k = obtainStyledAttributes.getResourceId(R.styleable.CalendarView_cv_weekDayTextAppearance, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.CalendarView_cv_dividerHorizontal);
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.n = (int) TypedValue.applyDimension(1, 12.0f, displayMetrics);
        this.m = (int) TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.o = (int) TypedValue.applyDimension(1, 20.0f, displayMetrics);
        this.e = (int) TypedValue.applyDimension(1, 6.0f, displayMetrics);
        this.b = (int) TypedValue.applyDimension(1, 1.0f, displayMetrics);
        View inflate = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.calendar_view, (ViewGroup) null, false);
        addView(inflate);
        this.v = (ListView) findViewById(16908298);
        this.x = (ViewGroup) inflate.findViewById(R.id.cv_day_names);
        this.w = (TextView) inflate.findViewById(R.id.cv_month_name);
        ((ImageView) findViewById(R.id.cv_divider)).setImageDrawable(drawable);
        d();
        e();
        c();
        this.H.setTimeInMillis(System.currentTimeMillis());
        if (this.H.before(this.J)) {
            a(this.J, false, true, true);
        } else if (this.K.before(this.H)) {
            a(this.K, false, true, true);
        } else {
            a(this.H, false, true, true);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Calendar calendar) {
        if (calendar.before(this.J)) {
            throw new IllegalArgumentException("fromDate: " + this.J.getTime() + " does not precede toDate: " + calendar.getTime());
        }
        return (int) ((((calendar.getTimeInMillis() + calendar.getTimeZone().getOffset(calendar.getTimeInMillis())) - (this.J.getTimeInMillis() + this.J.getTimeZone().getOffset(this.J.getTimeInMillis()))) + ((this.J.get(7) - this.z) * 86400000)) / 604800000);
    }

    private Calendar a(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    private void a() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(this.l, R.styleable.TextAppearanceCompatStyleable);
        this.f43803c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearanceCompatStyleable_android_textSize, 14);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        this.G.a(absListView, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        WeekView weekView = (WeekView) absListView.getChildAt(0);
        if (weekView == null) {
            return;
        }
        long firstVisiblePosition = (absListView.getFirstVisiblePosition() * weekView.getHeight()) - weekView.getBottom();
        long j = this.B;
        if (firstVisiblePosition < j) {
            this.C = true;
        } else if (firstVisiblePosition <= j) {
            return;
        } else {
            this.C = false;
        }
        if (weekView.getBottom() < this.n) {
            i4 = 1;
        }
        if (this.C) {
            weekView = (WeekView) absListView.getChildAt(i4 + 2);
        } else if (i4 != 0) {
            weekView = (WeekView) absListView.getChildAt(i4);
        }
        int a2 = this.C ? weekView.a() : weekView.b();
        int i5 = (this.A == 11 && a2 == 0) ? 1 : (this.A == 0 && a2 == 11) ? -1 : a2 - this.A;
        if ((!this.C && i5 > 0) || (this.C && i5 < 0)) {
            Calendar c2 = weekView.c();
            if (this.C) {
                c2.add(5, -7);
            } else {
                c2.add(5, 7);
            }
            setMonthDisplayed(c2);
        }
        this.B = firstVisiblePosition;
        this.D = this.E;
    }

    private void a(Calendar calendar, boolean z, boolean z2, boolean z3) {
        if (calendar.before(this.J) || calendar.after(this.K)) {
            throw new IllegalArgumentException("Time not between " + this.J.getTime() + " and " + this.K.getTime());
        }
        int firstVisiblePosition = this.v.getFirstVisiblePosition();
        View childAt = this.v.getChildAt(0);
        int i = firstVisiblePosition;
        if (childAt != null) {
            i = firstVisiblePosition;
            if (childAt.getTop() < 0) {
                i = firstVisiblePosition + 1;
            }
        }
        int i2 = (this.p + i) - 1;
        int i3 = i2;
        if (childAt != null) {
            i3 = i2;
            if (childAt.getTop() > this.o) {
                i3 = i2 - 1;
            }
        }
        if (z2) {
            this.u.a(calendar);
        }
        int a2 = a(calendar);
        if (a2 >= i && a2 <= i3 && !z3) {
            if (z2) {
                setMonthDisplayed(calendar);
                return;
            }
            return;
        }
        this.I.setTimeInMillis(calendar.getTimeInMillis());
        this.I.set(5, 1);
        setMonthDisplayed(this.I);
        int a3 = this.I.before(this.J) ? 0 : a(this.I);
        this.D = 2;
        if (z) {
            this.v.smoothScrollToPositionFromTop(a3, this.m, 1000);
            return;
        }
        this.v.setSelectionFromTop(a3, this.m);
        a(this.v, 0);
    }

    private boolean a(String str, Calendar calendar) {
        try {
            calendar.setTime(this.L.parse(str));
            return true;
        } catch (ParseException e) {
            String str2 = f43802a;
            Log.w(str2, "Date: " + str + " not in format: MM/dd/yyyy");
            return false;
        }
    }

    private boolean a(Calendar calendar, Calendar calendar2) {
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    private void b() {
        int childCount = this.v.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            this.v.getChildAt(i2).invalidate();
            i = i2 + 1;
        }
    }

    private void c() {
        if (this.u == null) {
            WeeksAdapter weeksAdapter = new WeeksAdapter(getContext());
            this.u = weeksAdapter;
            weeksAdapter.registerDataSetObserver(new DataSetObserver() { // from class: net.simonvt.calendarview.CalendarView.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    if (CalendarView.this.F != null) {
                        Calendar a2 = CalendarView.this.u.a();
                        CalendarView.this.F.a(CalendarView.this, a2.get(1), a2.get(2), a2.get(5));
                    }
                }
            });
            this.v.setAdapter((ListAdapter) this.u);
        }
        this.u.notifyDataSetChanged();
    }

    private void d() {
        int i = this.r;
        this.y = new String[i];
        int i2 = this.z;
        int i3 = i2;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                break;
            }
            this.y[i4 - this.z] = DateUtils.getDayOfWeekString(i4 > 7 ? i4 - 7 : i4, 50);
            i3 = i4 + 1;
        }
        TextView textView = (TextView) this.x.getChildAt(0);
        if (this.q) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        int childCount = this.x.getChildCount();
        int i5 = 1;
        while (true) {
            int i6 = i5;
            if (i6 >= childCount) {
                this.x.invalidate();
                return;
            }
            TextView textView2 = (TextView) this.x.getChildAt(i6);
            if (this.k > -1) {
                textView2.setTextAppearance(getContext(), this.k);
            }
            if (i6 < this.r + 1) {
                textView2.setText(this.y[i6 - 1]);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            i5 = i6 + 1;
        }
    }

    private void e() {
        this.v.setDivider(null);
        this.v.setItemsCanFocus(true);
        this.v.setVerticalScrollBarEnabled(false);
        this.v.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: net.simonvt.calendarview.CalendarView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                CalendarView.this.a(absListView, i, i2, i3);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                CalendarView.this.a(absListView, i);
            }
        });
        if (Build.VERSION.SDK_INT >= 11) {
            this.v.setFriction(this.s);
            this.v.setVelocityScale(this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return false;
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals(this.M)) {
            return;
        }
        this.M = locale;
        this.H = a(this.H, locale);
        this.I = a(this.I, locale);
        this.J = a(this.J, locale);
        this.K = a(this.K, locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMonthDisplayed(Calendar calendar) {
        int i = calendar.get(2);
        if (this.A != i) {
            this.A = i;
            this.u.a(i);
            long timeInMillis = calendar.getTimeInMillis();
            this.w.setText(DateUtils.formatDateRange(getContext(), timeInMillis, timeInMillis, 52));
            this.w.invalidate();
        }
    }

    public void a(long j, boolean z, boolean z2) {
        this.H.setTimeInMillis(j);
        if (a(this.H, this.u.e)) {
            return;
        }
        a(this.H, z, true, z2);
    }

    public long getDate() {
        return this.u.e.getTimeInMillis();
    }

    public int getDateTextAppearance() {
        return this.l;
    }

    public int getFirstDayOfWeek() {
        return this.z;
    }

    public int getFocusedMonthDateColor() {
        return this.g;
    }

    public long getMaxDate() {
        return this.K.getTimeInMillis();
    }

    public long getMinDate() {
        return this.J.getTimeInMillis();
    }

    public Drawable getSelectedDateVerticalBar() {
        return this.d;
    }

    public int getSelectedWeekBackgroundColor() {
        return this.f;
    }

    public boolean getShowWeekNumber() {
        return this.q;
    }

    public int getShownWeekCount() {
        return this.p;
    }

    public int getUnfocusedMonthDateColor() {
        return this.g;
    }

    public int getWeekDayTextAppearance() {
        return this.k;
    }

    public int getWeekNumberColor() {
        return this.j;
    }

    public int getWeekSeparatorLineColor() {
        return this.i;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.v.isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(CalendarView.class.getName());
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CalendarView.class.getName());
    }

    public void setDate(long j) {
        a(j, false, false);
    }

    public void setDateTextAppearance(int i) {
        if (this.l != i) {
            this.l = i;
            a();
            b();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.v.setEnabled(z);
    }

    public void setFirstDayOfWeek(int i) {
        if (this.z == i) {
            return;
        }
        this.z = i;
        this.u.b();
        this.u.notifyDataSetChanged();
        d();
    }

    public void setFocusedMonthDateColor(int i) {
        if (this.g == i) {
            return;
        }
        this.g = i;
        int childCount = this.v.getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            WeekView weekView = (WeekView) this.v.getChildAt(i3);
            if (weekView.g) {
                weekView.invalidate();
            }
            i2 = i3 + 1;
        }
    }

    public void setMaxDate(long j) {
        this.H.setTimeInMillis(j);
        if (a(this.H, this.K)) {
            return;
        }
        this.K.setTimeInMillis(j);
        this.u.b();
        Calendar calendar = this.u.e;
        if (calendar.after(this.K)) {
            setDate(this.K.getTimeInMillis());
        } else {
            a(calendar, false, true, false);
        }
    }

    public void setMinDate(long j) {
        this.H.setTimeInMillis(j);
        if (a(this.H, this.J)) {
            return;
        }
        this.J.setTimeInMillis(j);
        Calendar calendar = this.u.e;
        if (calendar.before(this.J)) {
            this.u.a(this.J);
        }
        this.u.b();
        if (calendar.before(this.J)) {
            setDate(this.H.getTimeInMillis());
        } else {
            a(calendar, false, true, false);
        }
    }

    public void setOnDateChangeListener(OnDateChangeListener onDateChangeListener) {
        this.F = onDateChangeListener;
    }

    public void setSelectedDateVerticalBar(int i) {
        setSelectedDateVerticalBar(getResources().getDrawable(i));
    }

    public void setSelectedDateVerticalBar(Drawable drawable) {
        if (this.d == drawable) {
            return;
        }
        this.d = drawable;
        int childCount = this.v.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            WeekView weekView = (WeekView) this.v.getChildAt(i2);
            if (weekView.o) {
                weekView.invalidate();
            }
            i = i2 + 1;
        }
    }

    public void setSelectedWeekBackgroundColor(int i) {
        if (this.f == i) {
            return;
        }
        this.f = i;
        int childCount = this.v.getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            WeekView weekView = (WeekView) this.v.getChildAt(i3);
            if (weekView.o) {
                weekView.invalidate();
            }
            i2 = i3 + 1;
        }
    }

    public void setShowWeekNumber(boolean z) {
        if (this.q == z) {
            return;
        }
        this.q = z;
        this.u.notifyDataSetChanged();
        d();
    }

    public void setShownWeekCount(int i) {
        if (this.p != i) {
            this.p = i;
            invalidate();
        }
    }

    public void setUnfocusedMonthDateColor(int i) {
        if (this.h == i) {
            return;
        }
        this.h = i;
        int childCount = this.v.getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            WeekView weekView = (WeekView) this.v.getChildAt(i3);
            if (weekView.h) {
                weekView.invalidate();
            }
            i2 = i3 + 1;
        }
    }

    public void setWeekDayTextAppearance(int i) {
        if (this.k != i) {
            this.k = i;
            d();
        }
    }

    public void setWeekNumberColor(int i) {
        if (this.j != i) {
            this.j = i;
            if (this.q) {
                b();
            }
        }
    }

    public void setWeekSeparatorLineColor(int i) {
        if (this.i != i) {
            this.i = i;
            b();
        }
    }
}
