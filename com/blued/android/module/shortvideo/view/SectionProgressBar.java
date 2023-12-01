package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.observer.ReturnObserver;
import java.util.LinkedList;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/SectionProgressBar.class */
public class SectionProgressBar extends View implements EventObserver, ReturnObserver {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList<Long> f15907a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f15908c;
    private Paint d;
    private Paint e;
    private Paint f;
    private boolean g;
    private boolean h;
    private float i;
    private float j;
    private float k;
    private volatile State l;
    private float m;
    private float n;
    private long o;
    private long p;
    private int q;

    /* renamed from: com.blued.android.module.shortvideo.view.SectionProgressBar$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/SectionProgressBar$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15909a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[EventType.VALUE.values().length];
            f15909a = iArr;
            try {
                iArr[EventType.VALUE.SHINE_ENDRECORD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15909a[EventType.VALUE.CONFIG_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15909a[EventType.VALUE.SAVE_FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15909a[EventType.VALUE.SELECT_LAST_SECOTION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15909a[EventType.VALUE.CONCAT_SECOTION.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15909a[EventType.VALUE.DELECT_LAST_SECOTION.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/SectionProgressBar$State.class */
    public enum State {
        START,
        PAUSE
    }

    public SectionProgressBar(Context context) {
        super(context);
        this.f15907a = new LinkedList<>();
        this.g = true;
        this.h = false;
        this.l = State.PAUSE;
        a(context);
    }

    public SectionProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15907a = new LinkedList<>();
        this.g = true;
        this.h = false;
        this.l = State.PAUSE;
        a(context);
    }

    public SectionProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15907a = new LinkedList<>();
        this.g = true;
        this.h = false;
        this.l = State.PAUSE;
        a(context);
    }

    private void a(Context context) {
        this.q = getResources().getDisplayMetrics().widthPixels;
        this.b = new Paint();
        this.f15908c = new Paint();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new Paint();
        setBackgroundColor(Color.parseColor("#4C000000"));
        this.f15908c.setStyle(Paint.Style.FILL);
        this.f15908c.setColor(getResources().getColor(R.color.stv_yellow_color));
        this.b.setStyle(Paint.Style.FILL);
        this.b.setColor(getResources().getColor(R.color.nafio_b));
        this.d.setStyle(Paint.Style.FILL);
        this.d.setColor(getResources().getColor(R.color.nafio_b));
        this.e.setStyle(Paint.Style.FILL);
        this.e.setColor(getResources().getColor(R.color.nafio_b));
        this.f.setStyle(Paint.Style.FILL);
        this.f.setColor(Color.parseColor("#ff0000"));
    }

    public void a() {
        if (getVisibility() == 8) {
            setVisibility(0);
        }
    }

    public void a(long j) {
        synchronized (this) {
            this.n = 0.0f;
            this.f15907a.add(Long.valueOf(j));
        }
    }

    public void a(Context context, long j) {
        float f = (float) j;
        this.k = f;
        float f2 = this.q / f;
        this.i = f2;
        this.m = f2;
    }

    @Override // com.blued.android.module.shortvideo.observer.EventObserver
    public void a(EventType.VALUE value) {
        switch (AnonymousClass1.f15909a[value.ordinal()]) {
            case 1:
                setCurrentState(State.PAUSE);
                return;
            case 2:
                b();
                return;
            case 3:
                a();
                return;
            case 4:
                a(true);
                return;
            case 5:
            case 6:
                a(false);
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.module.shortvideo.observer.ReturnObserver
    public void a(EventType.VALUE value, boolean z) {
        if (z && value == EventType.VALUE.SHINE_RECORD) {
            a(false);
            a();
        }
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b() {
        if (getVisibility() == 0) {
            setVisibility(8);
        }
    }

    public void c() {
        ObserverMgr.a().a((EventObserver) this);
        ObserverMgr.a().a((ReturnObserver) this);
    }

    public void d() {
    }

    public void e() {
        ObserverMgr.a().b((EventObserver) this);
        ObserverMgr.a().b((ReturnObserver) this);
    }

    public void f() {
    }

    public void g() {
        synchronized (this) {
            if (i()) {
                this.f15907a.removeLast();
            }
        }
    }

    public void h() {
        synchronized (this) {
            if (i()) {
                this.f15907a.clear();
            }
        }
    }

    public boolean i() {
        boolean isEmpty;
        synchronized (this) {
            isEmpty = this.f15907a.isEmpty();
        }
        return !isEmpty;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.p;
        if (j == 0 || currentTimeMillis - j >= 500) {
            this.g = !this.g;
            this.p = System.currentTimeMillis();
        }
        synchronized (this) {
            i = 0;
            if (!this.f15907a.isEmpty()) {
                float f = 0.0f;
                int size = this.f15907a.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    Long l = this.f15907a.get(i2);
                    float f2 = i;
                    int longValue = (int) (((((float) l.longValue()) - f) * this.i) + f2);
                    if (i2 == size - 1 && this.g && this.h) {
                        this.f15908c.setAlpha(100);
                        canvas.drawRect(f2, 0.0f, longValue, getMeasuredHeight(), this.f15908c);
                    } else {
                        this.f15908c.setAlpha(255);
                        canvas.drawRect(f2, 0.0f, longValue, getMeasuredHeight(), this.f15908c);
                    }
                    float f3 = longValue;
                    float f4 = f3 + 2.0f;
                    canvas.drawRect(f3, 0.0f, f4, getMeasuredHeight(), this.e);
                    i = (int) f4;
                    f = (float) l.longValue();
                    i2++;
                }
            }
            if (this.f15907a.isEmpty()) {
                canvas.drawRect(this.j, 0.0f, this.j + 2.0f, getMeasuredHeight(), this.d);
            } else if (i <= this.j) {
                canvas.drawRect(this.j, 0.0f, this.j + 2.0f, getMeasuredHeight(), this.d);
            }
        }
        if (this.l == State.START) {
            this.n += this.m * ((float) (currentTimeMillis - this.o));
        }
        this.f15908c.setAlpha(255);
        float f5 = i;
        if (this.n + f5 <= getMeasuredWidth()) {
            canvas.drawRect(f5, 0.0f, f5 + this.n, getMeasuredHeight(), this.f15908c);
        } else {
            canvas.drawRect(f5, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.f15908c);
        }
        if (this.g) {
            float f6 = this.n;
            canvas.drawRect(f5 + f6, 0.0f, f5 + 2.0f + f6, getMeasuredHeight(), this.b);
        }
        this.o = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.l = state;
        if (this.l == State.PAUSE) {
            this.n = 0.0f;
        }
    }

    public void setFirstPointPre(float f) {
        this.j = this.q * f;
    }
}
