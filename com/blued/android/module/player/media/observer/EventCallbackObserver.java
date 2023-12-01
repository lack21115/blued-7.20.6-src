package com.blued.android.module.player.media.observer;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/observer/EventCallbackObserver.class */
public class EventCallbackObserver {
    private static EventCallbackObserver a = new EventCallbackObserver();
    private ArrayList<EventCallBackListener> b = new ArrayList<>();

    private EventCallbackObserver() {
    }

    public static EventCallbackObserver a() {
        return a;
    }

    public void a(float f, float f2, float f3) {
        synchronized (this) {
            Iterator<EventCallBackListener> it = this.b.iterator();
            while (it.hasNext()) {
                EventCallBackListener next = it.next();
                if (next != null) {
                    next.a(f, f2, f3);
                }
            }
        }
    }

    public void a(int i) {
        synchronized (this) {
            Iterator<EventCallBackListener> it = this.b.iterator();
            while (it.hasNext()) {
                EventCallBackListener next = it.next();
                if (next != null) {
                    next.a(i);
                }
            }
        }
    }

    public void a(View view) {
        synchronized (this) {
            Iterator<EventCallBackListener> it = this.b.iterator();
            while (it.hasNext()) {
                EventCallBackListener next = it.next();
                if (next != null) {
                    next.a(view);
                }
            }
        }
    }

    public void a(EventCallBackListener eventCallBackListener) {
        synchronized (this) {
            if (eventCallBackListener != null) {
                this.b.add(eventCallBackListener);
            }
        }
    }

    public void a(Object... objArr) {
        synchronized (this) {
            Iterator<EventCallBackListener> it = this.b.iterator();
            while (it.hasNext()) {
                EventCallBackListener next = it.next();
                if (next != null) {
                    next.a(objArr);
                }
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<EventCallBackListener> it = this.b.iterator();
            while (it.hasNext()) {
                EventCallBackListener next = it.next();
                if (next != null) {
                    next.ak_();
                }
            }
        }
    }

    public void b(View view) {
        synchronized (this) {
            Iterator<EventCallBackListener> it = this.b.iterator();
            while (it.hasNext()) {
                EventCallBackListener next = it.next();
                if (next != null) {
                    next.b(view);
                }
            }
        }
    }

    public void b(EventCallBackListener eventCallBackListener) {
        synchronized (this) {
            if (eventCallBackListener != null) {
                this.b.remove(eventCallBackListener);
            }
        }
    }

    public void b(Object... objArr) {
        synchronized (this) {
            Iterator<EventCallBackListener> it = this.b.iterator();
            while (it.hasNext()) {
                EventCallBackListener next = it.next();
                if (next != null) {
                    next.b(objArr);
                }
            }
        }
    }

    public void c() {
        synchronized (this) {
            Iterator<EventCallBackListener> it = this.b.iterator();
            while (it.hasNext()) {
                EventCallBackListener next = it.next();
                if (next != null) {
                    next.al_();
                }
            }
        }
    }

    public void d() {
        synchronized (this) {
            Iterator<EventCallBackListener> it = this.b.iterator();
            while (it.hasNext()) {
                EventCallBackListener next = it.next();
                if (next != null) {
                    next.am_();
                }
            }
        }
    }

    public void e() {
        synchronized (this) {
            Iterator<EventCallBackListener> it = this.b.iterator();
            while (it.hasNext()) {
                EventCallBackListener next = it.next();
                if (next != null) {
                    next.d();
                }
            }
        }
    }
}
