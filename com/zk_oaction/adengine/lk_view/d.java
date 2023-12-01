package com.zk_oaction.adengine.lk_view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/d.class */
public class d extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f42044a;
    private List<com.zk_oaction.adengine.lk_sdk.interfaces.a> b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<com.zk_oaction.adengine.lk_sdk.interfaces.a, Long> f42045c;
    private List<com.zk_oaction.adengine.lk_sdk.interfaces.a> d;
    private List<com.zk_oaction.adengine.lk_sdk.interfaces.a> e;
    private ArrayList<View.OnTouchListener> f;
    private Scroller g;
    private Rect h;
    private int i;
    private Handler j;
    private long k;
    private float l;
    private float m;
    private GestureDetector n;
    private boolean o;
    private boolean p;
    private float q;
    private float r;
    private ArrayList<View> s;

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/d$a.class */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            try {
                if (i == 0) {
                    if (d.this.e.isEmpty()) {
                        return;
                    }
                    for (com.zk_oaction.adengine.lk_sdk.interfaces.a aVar : d.this.e) {
                        aVar.d();
                    }
                } else if (i == 1) {
                    if (d.this.d != null) {
                        d.this.d.clear();
                    }
                    if (d.this.e != null) {
                        d.this.e.clear();
                    }
                    if (d.this.f42044a == null || d.this.f42044a.k == null) {
                        return;
                    }
                    d.this.f42044a.k.d();
                } else if (i == 2) {
                    if (d.this.d.isEmpty() || d.this.e.isEmpty()) {
                        for (com.zk_oaction.adengine.lk_sdk.interfaces.a aVar2 : d.this.b) {
                            g gVar = (g) message.obj;
                            aVar2.c(gVar.f42052a, gVar.b);
                            aVar2.d(gVar.f42052a, gVar.b);
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/d$b.class */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/d$c.class */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f42048a;

        c(View view) {
            this.f42048a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.addView(this.f42048a);
        }
    }

    /* renamed from: com.zk_oaction.adengine.lk_view.d$d  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/d$d.class */
    class RunnableC1116d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f42049a;

        RunnableC1116d(View view) {
            this.f42049a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.removeView(this.f42049a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/d$e.class */
    public class e implements GestureDetector.OnGestureListener {
        e() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            try {
                if (d.this.f42044a != null && d.this.f42044a.k != null) {
                    d.this.f42044a.k.a(motionEvent, motionEvent2, f, f2);
                    d.this.o = true;
                }
                for (com.zk_oaction.adengine.lk_sdk.interfaces.a aVar : d.this.b) {
                    if (aVar instanceof com.zk_oaction.adengine.lk_unlock.b) {
                        aVar.c(d.this.q, d.this.r);
                        aVar.d(d.this.q, d.this.r);
                    }
                }
                return true;
            } catch (Throwable th) {
                return true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (d.this.f42044a == null || d.this.f42044a.k == null) {
                return;
            }
            d.this.f42044a.k.d();
            d.this.p = true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/d$f.class */
    public class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.n != null) {
                d.this.n.onTouchEvent(motionEvent);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/d$g.class */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        private float f42052a;
        private float b;

        public g(d dVar, float f, float f2) {
            this.f42052a = f;
            this.b = f2;
        }
    }

    public d(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar.j);
        this.k = 0L;
        this.q = 0.0f;
        this.r = 0.0f;
        this.f42044a = cVar;
        this.s = new ArrayList<>();
        this.b = new CopyOnWriteArrayList();
        this.f42045c = new HashMap<>();
        this.d = new CopyOnWriteArrayList();
        this.e = new CopyOnWriteArrayList();
        this.f = new ArrayList<>();
        this.j = new a(Looper.getMainLooper());
        this.g = new Scroller(this.f42044a.j, new BounceInterpolator());
        if (this.f42044a != null) {
            Thread currentThread = Thread.currentThread();
            com.zk_oaction.adengine.lk_sdk.c cVar2 = this.f42044a;
            if (currentThread == cVar2.w) {
                b();
                return;
            }
            cVar2.y.post(new b());
        }
    }

    private void a(MotionEvent motionEvent) {
        try {
            this.e.clear();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            long uptimeMillis = SystemClock.uptimeMillis();
            Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.a> it = this.f42044a.q.iterator();
            while (it.hasNext()) {
                com.zk_oaction.adengine.lk_sdk.interfaces.a next = it.next();
                if (!next.c() && next.a(x, y) && !this.d.contains(next) && this.b.contains(next) && uptimeMillis - this.f42045c.get(next).longValue() <= 100) {
                    this.e.add(next);
                }
            }
        } catch (Throwable th) {
        }
    }

    private void a(MotionEvent motionEvent, float f2, float f3) {
        this.l = f2;
        this.m = f3;
        com.zk_oaction.adengine.lk_sdk.c cVar = this.f42044a;
        float f4 = cVar.t;
        float f5 = f2 / f4;
        float f6 = f3 / f4;
        cVar.a("touch_x", "" + f5);
        com.zk_oaction.adengine.lk_sdk.c cVar2 = this.f42044a;
        cVar2.a("touch_y", "" + f6);
        com.zk_oaction.adengine.lk_interfaces.a aVar = this.f42044a.k;
        if (aVar != null) {
            aVar.a(motionEvent, (int) f2, (int) f3);
        }
        com.zk_oaction.adengine.lk_sdk.c cVar3 = this.f42044a;
        if (cVar3.A) {
            cVar3.a("touch_pressure", "" + motionEvent.getPressure());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.n = new GestureDetector(getContext(), new e());
        a(new f());
    }

    private void b(MotionEvent motionEvent, float f2, float f3) {
        com.zk_oaction.adengine.lk_sdk.c cVar = this.f42044a;
        cVar.a("touch_x", "" + (f2 / this.f42044a.t));
        com.zk_oaction.adengine.lk_sdk.c cVar2 = this.f42044a;
        cVar2.a("touch_y", "" + (f3 / this.f42044a.t));
        com.zk_oaction.adengine.lk_interfaces.a aVar = this.f42044a.k;
        if (aVar != null) {
            aVar.b(motionEvent, (int) f2, (int) f3);
        }
        com.zk_oaction.adengine.lk_sdk.c cVar3 = this.f42044a;
        if (cVar3.A) {
            cVar3.a("touch_pressure", "" + motionEvent.getPressure());
        }
        if (this.d.isEmpty()) {
            for (com.zk_oaction.adengine.lk_sdk.interfaces.a aVar2 : this.b) {
                aVar2.c(f2, f3);
            }
        }
        try {
            float f4 = f2 - this.l;
            float f5 = f3 - this.m;
            if (Math.sqrt((f4 * f4) + (f5 * f5)) > this.f42044a.j.getResources().getDisplayMetrics().density * 10.0f) {
                this.j.removeMessages(1);
            }
        } catch (Throwable th) {
        }
    }

    private void c(MotionEvent motionEvent, float f2, float f3) {
        Handler handler;
        com.zk_oaction.adengine.lk_sdk.c cVar = this.f42044a;
        float f4 = cVar.t;
        float f5 = f2 / f4;
        float f6 = f3 / f4;
        cVar.a("touch_x", "" + f5);
        com.zk_oaction.adengine.lk_sdk.c cVar2 = this.f42044a;
        cVar2.a("touch_y", "" + f6);
        com.zk_oaction.adengine.lk_interfaces.a aVar = this.f42044a.k;
        if (aVar != null) {
            aVar.c(motionEvent, (int) f2, (int) f3);
        }
        com.zk_oaction.adengine.lk_sdk.c cVar3 = this.f42044a;
        if (cVar3.A) {
            cVar3.a("touch_pressure", "" + motionEvent.getPressure());
        }
        Handler handler2 = this.j;
        if (handler2 != null) {
            handler2.removeMessages(1);
            this.j.removeMessages(2);
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = new g(this, f2, f3);
            this.j.sendMessage(obtain);
        }
        this.q = f2;
        this.r = f3;
        if (this.e.isEmpty() || (handler = this.j) == null) {
            return;
        }
        handler.sendEmptyMessageDelayed(0, 300L);
    }

    private void d(MotionEvent motionEvent, float f2, float f3) {
        com.zk_oaction.adengine.lk_sdk.c cVar = this.f42044a;
        cVar.a("touch_x", "" + (f2 / this.f42044a.t));
        com.zk_oaction.adengine.lk_sdk.c cVar2 = this.f42044a;
        cVar2.a("touch_y", "" + (f3 / this.f42044a.t));
        com.zk_oaction.adengine.lk_sdk.c cVar3 = this.f42044a;
        if (cVar3.A) {
            cVar3.a("touch_pressure", "" + motionEvent.getPressure());
        }
        if (this.d.isEmpty() || this.e.isEmpty()) {
            for (com.zk_oaction.adengine.lk_sdk.interfaces.a aVar : this.b) {
                aVar.c(f2, f3);
                aVar.e(f2, f3);
            }
        }
    }

    public int a() {
        ArrayList<View> arrayList = this.s;
        return arrayList != null ? arrayList.size() : super.getChildCount();
    }

    public View a(int i) {
        ArrayList<View> arrayList = this.s;
        return (arrayList == null || i >= arrayList.size()) ? super.getChildAt(i) : this.s.get(i);
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.f.add(onTouchListener);
    }

    public void a(View view) {
        this.s.add(view);
        Thread currentThread = Thread.currentThread();
        com.zk_oaction.adengine.lk_sdk.c cVar = this.f42044a;
        if (currentThread == cVar.w) {
            addView(view);
            return;
        }
        cVar.y.post(new c(view));
    }

    public void a(com.zk_oaction.adengine.lk_sdk.interfaces.b bVar) {
        if ((bVar instanceof com.zk_oaction.adengine.lk_view.b) || (bVar instanceof TextView)) {
            a((View) bVar);
        } else if (bVar instanceof com.zk_oaction.adengine.lk_view.f) {
            Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = ((com.zk_oaction.adengine.lk_view.f) bVar).d().iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
    }

    public void b(View view) {
        try {
            this.s.remove(view);
            Thread currentThread = Thread.currentThread();
            com.zk_oaction.adengine.lk_sdk.c cVar = this.f42044a;
            if (currentThread == cVar.w) {
                removeView(view);
                return;
            }
            cVar.y.post(new RunnableC1116d(view));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.g.computeScrollOffset()) {
            setTranslationY(this.g.getCurrY());
            setTranslationX(this.g.getCurrX());
            postInvalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f42044a.B) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.i = motionEvent.getPointerId(0);
        } else if (motionEvent.getAction() == 1) {
            a(motionEvent);
        }
        if (motionEvent.findPointerIndex(this.i) != 0) {
            return true;
        }
        if (motionEvent.getAction() == 6) {
            motionEvent.setAction(1);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect = this.h;
        if (rect != null) {
            canvas.clipRect(rect);
        }
        super.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                com.zk_oaction.adengine.lk_sdk.c cVar = this.f42044a;
                float f2 = cVar.t;
                float f3 = x / f2;
                float f4 = y / f2;
                cVar.a("touch_x", "" + f3);
                com.zk_oaction.adengine.lk_sdk.c cVar2 = this.f42044a;
                cVar2.a("touch_y", "" + f4);
                com.zk_oaction.adengine.lk_sdk.c cVar3 = this.f42044a;
                cVar3.a("touch_begin_x", "" + f3);
                com.zk_oaction.adengine.lk_sdk.c cVar4 = this.f42044a;
                cVar4.a("touch_begin_y", "" + f4);
                this.d.clear();
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.k == 0) {
                    this.k = uptimeMillis;
                }
                Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.a> it = this.f42044a.q.iterator();
                while (it.hasNext()) {
                    com.zk_oaction.adengine.lk_sdk.interfaces.a next = it.next();
                    if (next.c() || !next.a(x, y)) {
                        this.b.remove(next);
                        this.f42045c.remove(next);
                    } else {
                        if (this.b.contains(next) && uptimeMillis - this.f42045c.get(next).longValue() <= 300) {
                            this.d.add(next);
                            this.e.remove(next);
                        }
                        this.f42045c.put(next, Long.valueOf(uptimeMillis));
                        if (!this.b.contains(next)) {
                            this.b.add(next);
                        }
                    }
                }
                if (this.d.isEmpty()) {
                    for (com.zk_oaction.adengine.lk_sdk.interfaces.a aVar : this.b) {
                        aVar.b(x, y);
                    }
                    return false;
                }
                for (com.zk_oaction.adengine.lk_sdk.interfaces.a aVar2 : this.d) {
                    this.e.remove(aVar2);
                    aVar2.a();
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= getChildCount()) {
                return;
            }
            View childAt = getChildAt(i6);
            childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            i5 = i6 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                a(motionEvent, x, y);
            } else if (action == 1) {
                c(motionEvent, x, y);
            } else if (action == 2) {
                b(motionEvent, x, y);
            } else if (action == 3) {
                d(motionEvent, x, y);
            }
            Iterator<View.OnTouchListener> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().onTouch(null, motionEvent);
            }
            return true;
        } catch (Throwable th) {
            return true;
        }
    }
}
