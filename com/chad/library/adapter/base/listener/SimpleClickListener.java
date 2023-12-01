package com.chad.library.adapter.base.listener;

import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/listener/SimpleClickListener.class */
public abstract class SimpleClickListener implements RecyclerView.OnItemTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public static String f7964a = "SimpleClickListener";
    protected BaseQuickAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private GestureDetectorCompat f7965c;
    private RecyclerView d;
    private boolean e = false;
    private boolean f = false;
    private View g = null;

    /* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/listener/SimpleClickListener$ItemTouchHelperGestureListener.class */
    class ItemTouchHelperGestureListener implements GestureDetector.OnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SimpleClickListener f7966a;
        private RecyclerView b;

        private void a(final View view) {
            if (view != null) {
                view.postDelayed(new Runnable() { // from class: com.chad.library.adapter.base.listener.SimpleClickListener.ItemTouchHelperGestureListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        View view2 = view;
                        if (view2 != null) {
                            view2.setPressed(false);
                        }
                    }
                }, 50L);
            }
            this.f7966a.e = false;
            this.f7966a.g = null;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.f7966a.e = true;
            this.f7966a.g = this.b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0105  */
        /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        @Override // android.view.GestureDetector.OnGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onLongPress(android.view.MotionEvent r7) {
            /*
                Method dump skipped, instructions count: 395
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chad.library.adapter.base.listener.SimpleClickListener.ItemTouchHelperGestureListener.onLongPress(android.view.MotionEvent):void");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            if (!this.f7966a.e || this.f7966a.g == null) {
                return;
            }
            this.f7966a.f = true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (!this.f7966a.e || this.f7966a.g == null) {
                return true;
            }
            if (this.b.getScrollState() != 0) {
                return false;
            }
            View view = this.f7966a.g;
            BaseViewHolder baseViewHolder = (BaseViewHolder) this.b.getChildViewHolder(view);
            if (this.f7966a.a(baseViewHolder.getLayoutPosition())) {
                return false;
            }
            HashSet<Integer> childClickViewIds = baseViewHolder.getChildClickViewIds();
            Set<Integer> nestViews = baseViewHolder.getNestViews();
            if (childClickViewIds == null || childClickViewIds.size() <= 0) {
                this.f7966a.a(motionEvent, view);
                this.f7966a.g.setPressed(true);
                if (childClickViewIds != null && childClickViewIds.size() > 0) {
                    for (Integer num : childClickViewIds) {
                        View findViewById = view.findViewById(num.intValue());
                        if (findViewById != null) {
                            findViewById.setPressed(false);
                        }
                    }
                }
                SimpleClickListener simpleClickListener = this.f7966a;
                simpleClickListener.a(simpleClickListener.b, view, baseViewHolder.getLayoutPosition() - this.f7966a.b.getHeaderLayoutCount());
            } else {
                for (Integer num2 : childClickViewIds) {
                    View findViewById2 = view.findViewById(num2.intValue());
                    if (findViewById2 != null) {
                        if (this.f7966a.a(findViewById2, motionEvent) && findViewById2.isEnabled()) {
                            if (nestViews == null || !nestViews.contains(num2)) {
                                this.f7966a.a(motionEvent, findViewById2);
                                findViewById2.setPressed(true);
                                SimpleClickListener simpleClickListener2 = this.f7966a;
                                simpleClickListener2.c(simpleClickListener2.b, findViewById2, baseViewHolder.getLayoutPosition() - this.f7966a.b.getHeaderLayoutCount());
                                a(findViewById2);
                                return true;
                            }
                            return false;
                        }
                        findViewById2.setPressed(false);
                    }
                }
                this.f7966a.a(motionEvent, view);
                this.f7966a.g.setPressed(true);
                for (Integer num3 : childClickViewIds) {
                    View findViewById3 = view.findViewById(num3.intValue());
                    if (findViewById3 != null) {
                        findViewById3.setPressed(false);
                    }
                }
                SimpleClickListener simpleClickListener3 = this.f7966a;
                simpleClickListener3.a(simpleClickListener3.b, view, baseViewHolder.getLayoutPosition() - this.f7966a.b.getHeaderLayoutCount());
            }
            a(view);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent, View view) {
        if (Build.VERSION.SDK_INT < 21 || view == null || view.getBackground() == null) {
            return;
        }
        view.getBackground().setHotspot(motionEvent.getRawX(), motionEvent.getY() - view.getY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i) {
        boolean z = false;
        if (this.b == null) {
            RecyclerView recyclerView = this.d;
            if (recyclerView == null) {
                return false;
            }
            this.b = (BaseQuickAdapter) recyclerView.getAdapter();
        }
        int itemViewType = this.b.getItemViewType(i);
        if (itemViewType == 1365 || itemViewType == 273 || itemViewType == 819 || itemViewType == 546) {
            z = true;
        }
        return z;
    }

    public abstract void a(BaseQuickAdapter baseQuickAdapter, View view, int i);

    public boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        if (view == null || !view.isShown()) {
            return false;
        }
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getRawX() >= ((float) i) && motionEvent.getRawX() <= ((float) (i + view.getWidth())) && motionEvent.getRawY() >= ((float) i2) && motionEvent.getRawY() <= ((float) (i2 + view.getHeight()));
    }

    public abstract void b(BaseQuickAdapter baseQuickAdapter, View view, int i);

    public abstract void c(BaseQuickAdapter baseQuickAdapter, View view, int i);

    public abstract void d(BaseQuickAdapter baseQuickAdapter, View view, int i);

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f7965c.onTouchEvent(motionEvent);
    }
}
