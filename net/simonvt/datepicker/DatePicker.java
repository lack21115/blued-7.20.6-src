package net.simonvt.datepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.blued.blued_third_library.R;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import net.simonvt.calendarview.CalendarView;
import net.simonvt.numberpicker.NumberPicker;

/* loaded from: source-3503164-dex2jar.jar:net/simonvt/datepicker/DatePicker.class */
public class DatePicker extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f43813a = DatePicker.class.getSimpleName();
    private final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private final NumberPicker f43814c;
    private final NumberPicker d;
    private final NumberPicker e;
    private final EditText f;
    private final EditText g;
    private final EditText h;
    private final CalendarView i;
    private Locale j;
    private OnDateChangedListener k;
    private String[] l;
    private final DateFormat m;
    private int n;
    private Calendar o;
    private Calendar p;
    private Calendar q;
    private Calendar r;
    private boolean s;

    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/datepicker/DatePicker$OnDateChangedListener.class */
    public interface OnDateChangedListener {
        void a(DatePicker datePicker, int i, int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/datepicker/DatePicker$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: net.simonvt.datepicker.DatePicker.SavedState.1
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
        private final int f43817a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f43818c;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f43817a = parcel.readInt();
            this.b = parcel.readInt();
            this.f43818c = parcel.readInt();
        }

        private SavedState(Parcelable parcelable, int i, int i2, int i3) {
            super(parcelable);
            this.f43817a = i;
            this.b = i2;
            this.f43818c = i3;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f43817a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.f43818c);
        }
    }

    public DatePicker(Context context) {
        this(context, null);
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    public DatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new SimpleDateFormat("MM/dd/yyyy");
        this.s = true;
        setCurrentLocale(context.getResources().getConfiguration().locale);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DatePicker, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.DatePicker_dp_spinnersShown, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.DatePicker_dp_calendarViewShown, true);
        int i2 = obtainStyledAttributes.getInt(R.styleable.DatePicker_dp_startYear, 1900);
        int i3 = obtainStyledAttributes.getInt(R.styleable.DatePicker_dp_endYear, 2100);
        String string = obtainStyledAttributes.getString(R.styleable.DatePicker_dp_minDate);
        String string2 = obtainStyledAttributes.getString(R.styleable.DatePicker_dp_maxDate);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.DatePicker_dp_internalLayout, R.layout.date_picker_holo);
        obtainStyledAttributes.recycle();
        ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(resourceId, (ViewGroup) this, true);
        NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() { // from class: net.simonvt.datepicker.DatePicker.1
            @Override // net.simonvt.numberpicker.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i4, int i5) {
                DatePicker.this.f();
                DatePicker.this.o.setTimeInMillis(DatePicker.this.r.getTimeInMillis());
                if (numberPicker == DatePicker.this.f43814c) {
                    int actualMaximum = DatePicker.this.o.getActualMaximum(5);
                    if (i4 == actualMaximum && i5 == 1) {
                        DatePicker.this.o.add(5, 1);
                    } else if (i4 == 1 && i5 == actualMaximum) {
                        DatePicker.this.o.add(5, -1);
                    } else {
                        DatePicker.this.o.add(5, i5 - i4);
                    }
                } else if (numberPicker == DatePicker.this.d) {
                    if (i4 == 11 && i5 == 0) {
                        DatePicker.this.o.add(2, 1);
                    } else if (i4 == 0 && i5 == 11) {
                        DatePicker.this.o.add(2, -1);
                    } else {
                        DatePicker.this.o.add(2, i5 - i4);
                    }
                } else if (numberPicker != DatePicker.this.e) {
                    throw new IllegalArgumentException();
                } else {
                    DatePicker.this.o.set(1, i5);
                }
                DatePicker datePicker = DatePicker.this;
                datePicker.a(datePicker.o.get(1), DatePicker.this.o.get(2), DatePicker.this.o.get(5));
                DatePicker.this.b();
                DatePicker.this.c();
                DatePicker.this.d();
            }
        };
        this.b = (LinearLayout) findViewById(R.id.pickers);
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendar_view);
        this.i = calendarView;
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() { // from class: net.simonvt.datepicker.DatePicker.2
            @Override // net.simonvt.calendarview.CalendarView.OnDateChangeListener
            public void a(CalendarView calendarView2, int i4, int i5, int i6) {
                DatePicker.this.a(i4, i5, i6);
                DatePicker.this.b();
                DatePicker.this.d();
            }
        });
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.day);
        this.f43814c = numberPicker;
        numberPicker.setFormatter(NumberPicker.getTwoDigitFormatter());
        this.f43814c.setOnLongPressUpdateInterval(100L);
        this.f43814c.setOnValueChangedListener(onValueChangeListener);
        this.f = (EditText) this.f43814c.findViewById(R.id.np__numberpicker_input);
        NumberPicker numberPicker2 = (NumberPicker) findViewById(R.id.month);
        this.d = numberPicker2;
        numberPicker2.setMinValue(0);
        this.d.setMaxValue(this.n - 1);
        this.d.setDisplayedValues(this.l);
        this.d.setOnLongPressUpdateInterval(200L);
        this.d.setOnValueChangedListener(onValueChangeListener);
        this.g = (EditText) this.d.findViewById(R.id.np__numberpicker_input);
        NumberPicker numberPicker3 = (NumberPicker) findViewById(R.id.year);
        this.e = numberPicker3;
        numberPicker3.setOnLongPressUpdateInterval(100L);
        this.e.setOnValueChangedListener(onValueChangeListener);
        this.h = (EditText) this.e.findViewById(R.id.np__numberpicker_input);
        if (z || z2) {
            setSpinnersShown(z);
            setCalendarViewShown(z2);
        } else {
            setSpinnersShown(true);
        }
        this.o.clear();
        if (TextUtils.isEmpty(string)) {
            this.o.set(i2, 0, 1);
        } else if (!a(string, this.o)) {
            this.o.set(i2, 0, 1);
        }
        setMinDate(this.o.getTimeInMillis());
        this.o.clear();
        if (TextUtils.isEmpty(string2)) {
            this.o.set(i3, 11, 31);
        } else if (!a(string2, this.o)) {
            this.o.set(i3, 11, 31);
        }
        setMaxDate(this.o.getTimeInMillis());
        this.r.setTimeInMillis(System.currentTimeMillis());
        a(this.r.get(1), this.r.get(2), this.r.get(5), (OnDateChangedListener) null);
        a();
        e();
        if (Build.VERSION.SDK_INT < 16 || getImportantForAccessibility() != 0) {
            return;
        }
        setImportantForAccessibility(1);
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

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
        throw new java.lang.IllegalArgumentException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() {
        /*
            r5 = this;
            r0 = r5
            android.widget.LinearLayout r0 = r0.b     // Catch: java.lang.Exception -> L87
            r0.removeAllViews()     // Catch: java.lang.Exception -> L87
            r0 = r5
            android.content.Context r0 = r0.getContext()     // Catch: java.lang.Exception -> L87
            char[] r0 = android.text.format.DateFormat.getDateFormatOrder(r0)     // Catch: java.lang.Exception -> L87
            r9 = r0
            r0 = r9
            int r0 = r0.length     // Catch: java.lang.Exception -> L87
            r7 = r0
            r0 = 0
            r6 = r0
        L16:
            r0 = r6
            r1 = r7
            if (r0 >= r1) goto L86
            r0 = r9
            r1 = r6
            char r0 = r0[r1]
            r8 = r0
            r0 = r8
            r1 = 77
            if (r0 == r1) goto L6a
            r0 = r8
            r1 = 100
            if (r0 == r1) goto L52
            r0 = r8
            r1 = 121(0x79, float:1.7E-43)
            if (r0 != r1) goto L4a
            r0 = r5
            android.widget.LinearLayout r0 = r0.b     // Catch: java.lang.Exception -> L87
            r1 = r5
            net.simonvt.numberpicker.NumberPicker r1 = r1.e     // Catch: java.lang.Exception -> L87
            r0.addView(r1)     // Catch: java.lang.Exception -> L87
            r0 = r5
            r1 = r5
            net.simonvt.numberpicker.NumberPicker r1 = r1.e     // Catch: java.lang.Exception -> L87
            r2 = r7
            r3 = r6
            r0.a(r1, r2, r3)     // Catch: java.lang.Exception -> L87
            goto L7f
        L4a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Exception -> L87
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L87
            throw r0     // Catch: java.lang.Exception -> L87
        L52:
            r0 = r5
            android.widget.LinearLayout r0 = r0.b     // Catch: java.lang.Exception -> L87
            r1 = r5
            net.simonvt.numberpicker.NumberPicker r1 = r1.f43814c     // Catch: java.lang.Exception -> L87
            r0.addView(r1)     // Catch: java.lang.Exception -> L87
            r0 = r5
            r1 = r5
            net.simonvt.numberpicker.NumberPicker r1 = r1.f43814c     // Catch: java.lang.Exception -> L87
            r2 = r7
            r3 = r6
            r0.a(r1, r2, r3)     // Catch: java.lang.Exception -> L87
            goto L7f
        L6a:
            r0 = r5
            android.widget.LinearLayout r0 = r0.b     // Catch: java.lang.Exception -> L87
            r1 = r5
            net.simonvt.numberpicker.NumberPicker r1 = r1.d     // Catch: java.lang.Exception -> L87
            r0.addView(r1)     // Catch: java.lang.Exception -> L87
            r0 = r5
            r1 = r5
            net.simonvt.numberpicker.NumberPicker r1 = r1.d     // Catch: java.lang.Exception -> L87
            r2 = r7
            r3 = r6
            r0.a(r1, r2, r3)     // Catch: java.lang.Exception -> L87
        L7f:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L16
        L86:
            return
        L87:
            r9 = move-exception
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.simonvt.datepicker.DatePicker.a():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3) {
        this.r.set(i, i2, i3);
        if (this.r.before(this.p)) {
            this.r.setTimeInMillis(this.p.getTimeInMillis());
        } else if (this.r.after(this.q)) {
            this.r.setTimeInMillis(this.q.getTimeInMillis());
        }
    }

    private void a(NumberPicker numberPicker, int i, int i2) {
        ((TextView) numberPicker.findViewById(R.id.np__numberpicker_input)).setImeOptions(i2 < i - 1 ? 5 : 6);
    }

    private boolean a(String str, Calendar calendar) {
        try {
            calendar.setTime(this.m.parse(str));
            return true;
        } catch (ParseException e) {
            String str2 = f43813a;
            Log.w(str2, "Date: " + str + " not in format: MM/dd/yyyy");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.r.equals(this.p)) {
            this.f43814c.setMinValue(this.r.get(5));
            this.f43814c.setMaxValue(this.r.getActualMaximum(5));
            this.f43814c.setWrapSelectorWheel(false);
            this.d.setDisplayedValues(null);
            this.d.setMinValue(this.r.get(2));
            this.d.setMaxValue(this.r.getActualMaximum(2));
            this.d.setWrapSelectorWheel(false);
        } else if (this.r.equals(this.q)) {
            this.f43814c.setMinValue(this.r.getActualMinimum(5));
            this.f43814c.setMaxValue(this.r.get(5));
            this.f43814c.setWrapSelectorWheel(false);
            this.d.setDisplayedValues(null);
            this.d.setMinValue(this.r.getActualMinimum(2));
            this.d.setMaxValue(this.r.get(2));
            this.d.setWrapSelectorWheel(false);
        } else {
            this.f43814c.setMinValue(1);
            this.f43814c.setMaxValue(this.r.getActualMaximum(5));
            this.f43814c.setWrapSelectorWheel(true);
            this.d.setDisplayedValues(null);
            this.d.setMinValue(0);
            this.d.setMaxValue(11);
            this.d.setWrapSelectorWheel(true);
        }
        this.d.setDisplayedValues((String[]) CVArrays.a(this.l, this.d.getMinValue(), this.d.getMaxValue() + 1));
        this.e.setMinValue(this.p.get(1));
        this.e.setMaxValue(this.q.get(1));
        this.e.setWrapSelectorWheel(false);
        this.e.setValue(this.r.get(1));
        this.d.setValue(this.r.get(2));
        this.f43814c.setValue(this.r.get(5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.i.a(this.r.getTimeInMillis(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        sendAccessibilityEvent(4);
        OnDateChangedListener onDateChangedListener = this.k;
        if (onDateChangedListener != null) {
            onDateChangedListener.a(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    private void e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            if (inputMethodManager.isActive(this.h)) {
                this.h.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this.g)) {
                this.g.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this.f)) {
                this.f.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals(this.j)) {
            return;
        }
        this.j = locale;
        this.o = a(this.o, locale);
        this.p = a(this.p, locale);
        this.q = a(this.q, locale);
        this.r = a(this.r, locale);
        int actualMaximum = this.o.getActualMaximum(2) + 1;
        this.n = actualMaximum;
        this.l = new String[actualMaximum];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.n) {
                return;
            }
            this.l[i2] = DateUtils.getMonthString(i2 + 0, 20);
            i = i2 + 1;
        }
    }

    public void a(int i, int i2, int i3, OnDateChangedListener onDateChangedListener) {
        a(i, i2, i3);
        b();
        c();
        this.k = onDateChangedListener;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public CalendarView getCalendarView() {
        return this.i;
    }

    public boolean getCalendarViewShown() {
        return this.i.isShown();
    }

    public int getDayOfMonth() {
        return this.r.get(5);
    }

    public long getMaxDate() {
        return this.i.getMaxDate();
    }

    public long getMinDate() {
        return this.i.getMinDate();
    }

    public int getMonth() {
        return this.r.get(2);
    }

    public boolean getSpinnersShown() {
        return this.b.isShown();
    }

    public int getYear() {
        return this.r.get(1);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.s;
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
        accessibilityEvent.setClassName(DatePicker.class.getName());
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DatePicker.class.getName());
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onPopulateAccessibilityEvent(accessibilityEvent);
        }
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), this.r.getTimeInMillis(), 20));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        a(savedState.f43817a, savedState.b, savedState.f43818c);
        b();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth());
    }

    public void setCalendarViewShown(boolean z) {
        this.i.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (this.s == z) {
            return;
        }
        super.setEnabled(z);
        this.f43814c.setEnabled(z);
        this.d.setEnabled(z);
        this.e.setEnabled(z);
        this.i.setEnabled(z);
        this.s = z;
    }

    public void setInputTextEnable(boolean z) {
        this.f43814c.setInputTextEnable(z);
        this.d.setInputTextEnable(z);
        this.e.setInputTextEnable(z);
    }

    public void setMaxDate(long j) {
        this.o.setTimeInMillis(j);
        if (this.o.get(1) != this.q.get(1) || this.o.get(6) == this.q.get(6)) {
            this.q.setTimeInMillis(j);
            this.i.setMaxDate(j);
            if (this.r.after(this.q)) {
                this.r.setTimeInMillis(this.q.getTimeInMillis());
                c();
            }
            b();
        }
    }

    public void setMinDate(long j) {
        this.o.setTimeInMillis(j);
        if (this.o.get(1) != this.p.get(1) || this.o.get(6) == this.p.get(6)) {
            this.p.setTimeInMillis(j);
            this.i.setMinDate(j);
            if (this.r.before(this.p)) {
                this.r.setTimeInMillis(this.p.getTimeInMillis());
                c();
            }
            b();
        }
    }

    public void setSpinnersShown(boolean z) {
        this.b.setVisibility(z ? 0 : 8);
    }

    public void setWheelTextColor(int i) {
        this.f43814c.setWheelTextColor(i);
        this.d.setWheelTextColor(i);
        this.e.setWheelTextColor(i);
        postInvalidate();
    }
}
