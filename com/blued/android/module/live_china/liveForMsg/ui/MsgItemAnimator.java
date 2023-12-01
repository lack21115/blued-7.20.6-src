package com.blued.android.module.live_china.liveForMsg.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/ui/MsgItemAnimator.class */
public class MsgItemAnimator extends SimpleItemAnimator {
    private static TimeInterpolator i;
    private ArrayList<RecyclerView.ViewHolder> j = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> k = new ArrayList<>();
    private ArrayList<MoveInfo> l = new ArrayList<>();
    private ArrayList<ChangeInfo> m = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.ViewHolder>> a = new ArrayList<>();
    ArrayList<ArrayList<MoveInfo>> b = new ArrayList<>();
    ArrayList<ArrayList<ChangeInfo>> c = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> d = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> e = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> f = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> g = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/ui/MsgItemAnimator$ChangeInfo.class */
    public static class ChangeInfo {
        public RecyclerView.ViewHolder a;
        public RecyclerView.ViewHolder b;
        public int c;
        public int d;
        public int e;
        public int f;

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.a = viewHolder;
            this.b = viewHolder2;
        }

        ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/ui/MsgItemAnimator$MoveInfo.class */
    public static class MoveInfo {
        public RecyclerView.ViewHolder a;
        public int b;
        public int c;
        public int d;
        public int e;

        MoveInfo(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.a = viewHolder;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    private void a(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        int size = list.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                return;
            }
            ChangeInfo changeInfo = list.get(i2);
            if (a(changeInfo, viewHolder) && changeInfo.a == null && changeInfo.b == null) {
                list.remove(changeInfo);
            }
            size = i2;
        }
    }

    private boolean a(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (changeInfo.b == viewHolder) {
            changeInfo.b = null;
        } else if (changeInfo.a != viewHolder) {
            return false;
        } else {
            changeInfo.a = null;
            z = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    private void b(ChangeInfo changeInfo) {
        if (changeInfo.a != null) {
            a(changeInfo, changeInfo.a);
        }
        if (changeInfo.b != null) {
            a(changeInfo, changeInfo.b);
        }
    }

    private void c(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f.add(viewHolder);
        view.setPivotX(0.0f);
        animate.alpha(0.0f).scaleX(0.5f).scaleY(0.5f).translationX(-30.0f).setDuration(getRemoveDuration()).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.liveForMsg.ui.MsgItemAnimator.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                MsgItemAnimator.this.dispatchRemoveFinished(viewHolder);
                MsgItemAnimator.this.f.remove(viewHolder);
                MsgItemAnimator.this.a();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                MsgItemAnimator.this.dispatchRemoveStarting(viewHolder);
            }
        }).start();
    }

    private void d(RecyclerView.ViewHolder viewHolder) {
        if (i == null) {
            i = new DecelerateInterpolator(1.8f);
        }
        viewHolder.itemView.animate().setInterpolator(i);
        endAnimation(viewHolder);
    }

    void a() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    void a(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.d.add(viewHolder);
        view.setTranslationY(view.getHeight());
        animate.translationY(0.0f).setDuration(getMoveDuration()).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.liveForMsg.ui.MsgItemAnimator.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                MsgItemAnimator.this.dispatchAddFinished(viewHolder);
                MsgItemAnimator.this.d.remove(viewHolder);
                MsgItemAnimator.this.a();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                MsgItemAnimator.this.dispatchAddStarting(viewHolder);
            }
        }).start();
    }

    void a(final RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        final View view = viewHolder.itemView;
        final int i6 = i4 - i2;
        final int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.e.add(viewHolder);
        animate.setDuration(getMoveDuration()).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.liveForMsg.ui.MsgItemAnimator.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i6 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i7 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                MsgItemAnimator.this.dispatchMoveFinished(viewHolder);
                MsgItemAnimator.this.e.remove(viewHolder);
                MsgItemAnimator.this.a();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                MsgItemAnimator.this.dispatchMoveStarting(viewHolder);
            }
        }).start();
    }

    void a(final ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.a;
        View view = null;
        View view2 = viewHolder == null ? null : viewHolder.itemView;
        RecyclerView.ViewHolder viewHolder2 = changeInfo.b;
        if (viewHolder2 != null) {
            view = viewHolder2.itemView;
        }
        if (view2 != null) {
            final ViewPropertyAnimator duration = view2.animate().setDuration(getChangeDuration());
            this.g.add(changeInfo.a);
            duration.translationX(changeInfo.e - changeInfo.c);
            duration.translationY(changeInfo.f - changeInfo.d);
            final View view3 = view2;
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.liveForMsg.ui.MsgItemAnimator.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view3.setAlpha(1.0f);
                    view3.setTranslationX(0.0f);
                    view3.setTranslationY(0.0f);
                    MsgItemAnimator.this.dispatchChangeFinished(changeInfo.a, true);
                    MsgItemAnimator.this.g.remove(changeInfo.a);
                    MsgItemAnimator.this.a();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    MsgItemAnimator.this.dispatchChangeStarting(changeInfo.a, true);
                }
            }).start();
        }
        if (view != null) {
            final ViewPropertyAnimator animate = view.animate();
            this.g.add(changeInfo.b);
            final View view4 = view;
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.liveForMsg.ui.MsgItemAnimator.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view4.setAlpha(1.0f);
                    view4.setTranslationX(0.0f);
                    view4.setTranslationY(0.0f);
                    MsgItemAnimator.this.dispatchChangeFinished(changeInfo.b, false);
                    MsgItemAnimator.this.g.remove(changeInfo.b);
                    MsgItemAnimator.this.a();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    MsgItemAnimator.this.dispatchChangeStarting(changeInfo.b, false);
                }
            }).start();
        }
    }

    void a(List<RecyclerView.ViewHolder> list) {
        int size = list.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                return;
            }
            list.get(i2).itemView.animate().cancel();
            size = i2;
        }
    }

    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        d(viewHolder);
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setScaleX(1.0f);
        viewHolder.itemView.setScaleY(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(viewHolder.itemView.getHeight());
        this.k.add(viewHolder);
        return true;
    }

    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i2, i3, i4, i5);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        d(viewHolder);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            d(viewHolder2);
            viewHolder2.itemView.setTranslationX(-i6);
            viewHolder2.itemView.setTranslationY(-i7);
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.m.add(new ChangeInfo(viewHolder, viewHolder2, i2, i3, i4, i5));
        return true;
    }

    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        View view = viewHolder.itemView;
        int translationX = i2 + ((int) viewHolder.itemView.getTranslationX());
        int translationY = i3 + ((int) viewHolder.itemView.getTranslationY());
        d(viewHolder);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.l.add(new MoveInfo(viewHolder, translationX, translationY, i4, i5));
        return true;
    }

    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        d(viewHolder);
        this.j.add(viewHolder);
        return true;
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list);
    }

    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.l.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                break;
            }
            if (this.l.get(i2).a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(viewHolder);
                this.l.remove(i2);
            }
            size = i2;
        }
        a(this.m, viewHolder);
        if (this.j.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.k.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        int size2 = this.c.size();
        while (true) {
            int i3 = size2 - 1;
            if (i3 < 0) {
                break;
            }
            ArrayList<ChangeInfo> arrayList = this.c.get(i3);
            a(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.c.remove(i3);
            }
            size2 = i3;
        }
        int size3 = this.b.size();
        while (true) {
            int i4 = size3 - 1;
            if (i4 < 0) {
                break;
            }
            ArrayList<MoveInfo> arrayList2 = this.b.get(i4);
            int size4 = arrayList2.size();
            while (true) {
                int i5 = size4 - 1;
                if (i5 < 0) {
                    break;
                } else if (arrayList2.get(i5).a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(i5);
                    if (arrayList2.isEmpty()) {
                        this.b.remove(i4);
                    }
                } else {
                    size4 = i5;
                }
            }
            size3 = i4;
        }
        int size5 = this.a.size();
        while (true) {
            int i6 = size5 - 1;
            if (i6 < 0) {
                this.f.remove(viewHolder);
                this.d.remove(viewHolder);
                this.g.remove(viewHolder);
                this.e.remove(viewHolder);
                a();
                return;
            }
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.a.get(i6);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.a.remove(i6);
                }
            }
            size5 = i6;
        }
    }

    public void endAnimations() {
        int size = this.l.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                break;
            }
            MoveInfo moveInfo = this.l.get(i2);
            View view = moveInfo.a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(moveInfo.a);
            this.l.remove(i2);
            size = i2;
        }
        int size2 = this.j.size();
        while (true) {
            int i3 = size2 - 1;
            if (i3 < 0) {
                break;
            }
            dispatchRemoveFinished(this.j.get(i3));
            this.j.remove(i3);
            size2 = i3;
        }
        int size3 = this.k.size();
        while (true) {
            int i4 = size3 - 1;
            if (i4 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.k.get(i4);
            viewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
            this.k.remove(i4);
            size3 = i4;
        }
        int size4 = this.m.size();
        while (true) {
            int i5 = size4 - 1;
            if (i5 < 0) {
                break;
            }
            b(this.m.get(i5));
            size4 = i5;
        }
        this.m.clear();
        if (!isRunning()) {
            return;
        }
        int size5 = this.b.size();
        while (true) {
            int i6 = size5 - 1;
            if (i6 < 0) {
                break;
            }
            ArrayList<MoveInfo> arrayList = this.b.get(i6);
            int size6 = arrayList.size();
            while (true) {
                int i7 = size6 - 1;
                if (i7 >= 0) {
                    MoveInfo moveInfo2 = arrayList.get(i7);
                    View view2 = moveInfo2.a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(moveInfo2.a);
                    arrayList.remove(i7);
                    if (arrayList.isEmpty()) {
                        this.b.remove(arrayList);
                    }
                    size6 = i7;
                }
            }
            size5 = i6;
        }
        int size7 = this.a.size();
        while (true) {
            int i8 = size7 - 1;
            if (i8 < 0) {
                break;
            }
            ArrayList<RecyclerView.ViewHolder> arrayList2 = this.a.get(i8);
            int size8 = arrayList2.size();
            while (true) {
                int i9 = size8 - 1;
                if (i9 >= 0) {
                    RecyclerView.ViewHolder viewHolder2 = arrayList2.get(i9);
                    viewHolder2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList2.remove(i9);
                    if (arrayList2.isEmpty()) {
                        this.a.remove(arrayList2);
                    }
                    size8 = i9;
                }
            }
            size7 = i8;
        }
        int size9 = this.c.size();
        while (true) {
            int i10 = size9 - 1;
            if (i10 < 0) {
                a(this.f);
                a(this.e);
                a(this.d);
                a(this.g);
                dispatchAnimationsFinished();
                return;
            }
            ArrayList<ChangeInfo> arrayList3 = this.c.get(i10);
            int size10 = arrayList3.size();
            while (true) {
                int i11 = size10 - 1;
                if (i11 >= 0) {
                    b(arrayList3.get(i11));
                    if (arrayList3.isEmpty()) {
                        this.c.remove(arrayList3);
                    }
                    size10 = i11;
                }
            }
            size9 = i10;
        }
    }

    public boolean isRunning() {
        return (this.k.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.j.isEmpty() && this.e.isEmpty() && this.f.isEmpty() && this.d.isEmpty() && this.g.isEmpty() && this.b.isEmpty() && this.a.isEmpty() && this.c.isEmpty()) ? false : true;
    }

    public void runPendingAnimations() {
        boolean z = !this.j.isEmpty();
        boolean z2 = !this.l.isEmpty();
        boolean z3 = !this.m.isEmpty();
        boolean z4 = !this.k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.j.iterator();
            while (it.hasNext()) {
                c(it.next());
            }
            this.j.clear();
            if (z2) {
                final ArrayList<MoveInfo> arrayList = new ArrayList<>();
                arrayList.addAll(this.l);
                this.b.add(arrayList);
                this.l.clear();
                Runnable runnable = new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.ui.MsgItemAnimator.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            MoveInfo moveInfo = (MoveInfo) it2.next();
                            MsgItemAnimator.this.a(moveInfo.a, moveInfo.b, moveInfo.c, moveInfo.d, moveInfo.e);
                        }
                        arrayList.clear();
                        MsgItemAnimator.this.b.remove(arrayList);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList.get(0).a.itemView, runnable, getRemoveDuration());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<ChangeInfo> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.m);
                this.c.add(arrayList2);
                this.m.clear();
                Runnable runnable2 = new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.ui.MsgItemAnimator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            MsgItemAnimator.this.a((ChangeInfo) it2.next());
                        }
                        arrayList2.clear();
                        MsgItemAnimator.this.c.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList2.get(0).a.itemView, runnable2, getRemoveDuration());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.k);
                this.a.add(arrayList3);
                this.k.clear();
                Runnable runnable3 = new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.ui.MsgItemAnimator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            MsgItemAnimator.this.a((RecyclerView.ViewHolder) it2.next());
                        }
                        arrayList3.clear();
                        MsgItemAnimator.this.a.remove(arrayList3);
                    }
                };
                if (!z && !z2 && !z3) {
                    runnable3.run();
                    return;
                }
                if (z) {
                    getRemoveDuration();
                }
                Math.max(z2 ? getMoveDuration() : 0L, z3 ? getChangeDuration() : 0L);
                ViewCompat.postOnAnimationDelayed(arrayList3.get(0).itemView, runnable3, 0L);
            }
        }
    }
}
