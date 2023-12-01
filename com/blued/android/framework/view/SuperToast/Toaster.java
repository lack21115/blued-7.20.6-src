package com.blued.android.framework.view.SuperToast;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.WindowManager;
import com.blued.android.framework.view.SuperToast.utils.AnimationUtils;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/Toaster.class */
public class Toaster extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static Toaster f10196a;
    private final PriorityQueue<SuperToast> b = new PriorityQueue<>(10, new SuperToastComparator());

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/Toaster$Messages.class */
    static final class Messages {
        private Messages() {
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/Toaster$SuperToastComparator.class */
    class SuperToastComparator implements Comparator<SuperToast> {
        private SuperToastComparator() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(SuperToast superToast, SuperToast superToast2) {
            if (!superToast.l() && superToast.j().n >= superToast2.j().n) {
                return (superToast.j().n <= superToast2.j().n && superToast.j().o <= superToast2.j().o) ? -1 : 1;
            }
            return -1;
        }
    }

    private Toaster() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Toaster a() {
        synchronized (Toaster.class) {
            try {
                if (f10196a != null) {
                    return f10196a;
                }
                Toaster toaster = new Toaster();
                f10196a = toaster;
                return toaster;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void a(SuperToast superToast, int i, long j) {
        Message obtainMessage = obtainMessage(i);
        obtainMessage.obj = superToast;
        sendMessageDelayed(obtainMessage, j);
    }

    private void c(SuperToast superToast) {
        if (superToast.l()) {
            return;
        }
        if (!(superToast instanceof SuperActivityToast)) {
            WindowManager windowManager = (WindowManager) superToast.getContext().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null) {
                windowManager.addView(superToast.k(), superToast.m());
            }
            a(superToast, 5395284, superToast.h() + 250);
            return;
        }
        SuperActivityToast superActivityToast = (SuperActivityToast) superToast;
        if (superActivityToast.d() == null) {
            Log.e(getClass().getName(), "The SuperActivityToast's ViewGroup was null, could not show.");
            return;
        }
        try {
            ((SuperActivityToast) superToast).d().addView(superToast.k());
            if (!((SuperActivityToast) superToast).b()) {
                AnimationUtils.a((SuperActivityToast) superToast).start();
            }
        } catch (IllegalStateException e) {
            Log.e(getClass().getName(), e.toString());
        }
        if (superActivityToast.c()) {
            return;
        }
        a(superToast, 5395284, superToast.h() + 250);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.b.isEmpty()) {
            return;
        }
        SuperToast peek = this.b.peek();
        if (peek.l()) {
            return;
        }
        Message obtainMessage = obtainMessage(4477780);
        obtainMessage.obj = peek;
        sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SuperToast superToast) {
        this.b.add(superToast);
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        removeMessages(4281172);
        removeMessages(4477780);
        removeMessages(5395284);
        Iterator<SuperToast> it = this.b.iterator();
        while (it.hasNext()) {
            SuperToast next = it.next();
            if (!(next instanceof SuperActivityToast)) {
                WindowManager windowManager = (WindowManager) next.getContext().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
                if (next.l()) {
                    try {
                        windowManager.removeView(next.k());
                    } catch (IllegalArgumentException | NullPointerException e) {
                        Log.e(getClass().getName(), e.toString());
                    }
                }
            } else if (next.l()) {
                try {
                    ((SuperActivityToast) next).d().removeView(next.k());
                    ((SuperActivityToast) next).d().invalidate();
                } catch (IllegalStateException | NullPointerException e2) {
                    Log.e(getClass().getName(), e2.toString());
                }
            }
        }
        this.b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final SuperToast superToast) {
        if (!(superToast instanceof SuperActivityToast)) {
            WindowManager windowManager = (WindowManager) superToast.getContext().getSystemService(Context.WINDOW_SERVICE);
            if (windowManager == null) {
                throw new IllegalStateException("The SuperToast's WindowManager was null when trying to remove the SuperToast.");
            }
            try {
                windowManager.removeView(superToast.k());
            } catch (IllegalArgumentException e) {
                Log.e(getClass().getName(), e.toString());
            }
            if (superToast.i() != null) {
                superToast.i().a(superToast.k(), superToast.j().m);
            }
            a(superToast, 4281172, 250L);
        } else if (!superToast.l()) {
            this.b.remove(superToast);
            return;
        } else {
            Animator b = AnimationUtils.b((SuperActivityToast) superToast);
            b.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.framework.view.SuperToast.Toaster.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (superToast.i() != null) {
                        superToast.i().a(superToast.k(), superToast.j().m);
                    }
                    ((SuperActivityToast) superToast).d().removeView(superToast.k());
                    Toaster.this.d();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            b.start();
        }
        this.b.poll();
    }

    public PriorityQueue<SuperToast> c() {
        return this.b;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        SuperToast superToast = (SuperToast) message.obj;
        int i = message.what;
        if (i == 4281172) {
            d();
        } else if (i == 4477780) {
            c(superToast);
        } else if (i != 5395284) {
            super.handleMessage(message);
        } else {
            b(superToast);
        }
    }
}
