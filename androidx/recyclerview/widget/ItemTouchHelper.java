package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.text.Spanned;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ItemTouchHelper.class */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int START = 16;
    public static final int UP = 1;
    private ItemTouchHelperGestureListener A;
    private Rect C;
    private long D;

    /* renamed from: c  reason: collision with root package name */
    float f3227c;
    float d;
    float e;
    float f;
    Callback h;
    int i;
    RecyclerView k;
    VelocityTracker m;
    GestureDetectorCompat p;
    private float r;
    private float s;
    private float t;
    private float u;
    private int w;
    private List<RecyclerView.ViewHolder> x;
    private List<Integer> y;

    /* renamed from: a  reason: collision with root package name */
    final List<View> f3226a = new ArrayList();
    private final float[] q = new float[2];
    RecyclerView.ViewHolder b = null;
    int g = -1;
    private int v = 0;
    List<RecoverAnimation> j = new ArrayList();
    final Runnable l = new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.1
        @Override // java.lang.Runnable
        public void run() {
            if (ItemTouchHelper.this.b == null || !ItemTouchHelper.this.b()) {
                return;
            }
            if (ItemTouchHelper.this.b != null) {
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                itemTouchHelper.a(itemTouchHelper.b);
            }
            ItemTouchHelper.this.k.removeCallbacks(ItemTouchHelper.this.l);
            ViewCompat.postOnAnimation(ItemTouchHelper.this.k, this);
        }
    };
    private RecyclerView.ChildDrawingOrderCallback z = null;
    View n = null;
    int o = -1;
    private final RecyclerView.OnItemTouchListener B = new RecyclerView.OnItemTouchListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            RecoverAnimation b;
            ItemTouchHelper.this.p.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.g = motionEvent.getPointerId(0);
                ItemTouchHelper.this.f3227c = motionEvent.getX();
                ItemTouchHelper.this.d = motionEvent.getY();
                ItemTouchHelper.this.c();
                if (ItemTouchHelper.this.b == null && (b = ItemTouchHelper.this.b(motionEvent)) != null) {
                    ItemTouchHelper.this.f3227c -= b.l;
                    ItemTouchHelper.this.d -= b.m;
                    ItemTouchHelper.this.a(b.h, true);
                    if (ItemTouchHelper.this.f3226a.remove(b.h.itemView)) {
                        ItemTouchHelper.this.h.clearView(ItemTouchHelper.this.k, b.h);
                    }
                    ItemTouchHelper.this.a(b.h, b.i);
                    ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                    itemTouchHelper.a(motionEvent, itemTouchHelper.i, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper.this.g = -1;
                ItemTouchHelper.this.a((RecyclerView.ViewHolder) null, 0);
            } else if (ItemTouchHelper.this.g != -1 && (findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.g)) >= 0) {
                ItemTouchHelper.this.a(actionMasked, motionEvent, findPointerIndex);
            }
            if (ItemTouchHelper.this.m != null) {
                ItemTouchHelper.this.m.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.b != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.a((RecyclerView.ViewHolder) null, 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            ItemTouchHelper.this.p.onTouchEvent(motionEvent);
            if (ItemTouchHelper.this.m != null) {
                ItemTouchHelper.this.m.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.g == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.g);
            if (findPointerIndex >= 0) {
                ItemTouchHelper.this.a(actionMasked, motionEvent, findPointerIndex);
            }
            RecyclerView.ViewHolder viewHolder = ItemTouchHelper.this.b;
            if (viewHolder == null) {
                return;
            }
            int i = 0;
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (findPointerIndex >= 0) {
                        ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                        itemTouchHelper.a(motionEvent, itemTouchHelper.i, findPointerIndex);
                        ItemTouchHelper.this.a(viewHolder);
                        ItemTouchHelper.this.k.removeCallbacks(ItemTouchHelper.this.l);
                        ItemTouchHelper.this.l.run();
                        ItemTouchHelper.this.k.invalidate();
                        return;
                    }
                    return;
                } else if (actionMasked != 3) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    if (motionEvent.getPointerId(actionIndex) == ItemTouchHelper.this.g) {
                        if (actionIndex == 0) {
                            i = 1;
                        }
                        ItemTouchHelper.this.g = motionEvent.getPointerId(i);
                        ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                        itemTouchHelper2.a(motionEvent, itemTouchHelper2.i, actionIndex);
                        return;
                    }
                    return;
                } else if (ItemTouchHelper.this.m != null) {
                    ItemTouchHelper.this.m.clear();
                }
            }
            ItemTouchHelper.this.a((RecyclerView.ViewHolder) null, 0);
            ItemTouchHelper.this.g = -1;
        }
    };

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ItemTouchHelper$Callback.class */
    public static abstract class Callback {
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;

        /* renamed from: a  reason: collision with root package name */
        private static final Interpolator f3235a = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        };
        private static final Interpolator b = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private int f3236c = -1;

        private int a(RecyclerView recyclerView) {
            if (this.f3236c == -1) {
                this.f3236c = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f3236c;
        }

        public static int convertToRelativeDirection(int i, int i2) {
            int i3;
            int i4 = i & 789516;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & i4;
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= (-789517) & i6;
                i3 = (i6 & 789516) << 2;
            }
            return i5 | i3;
        }

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return ItemTouchUIUtilImpl.f3241a;
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public static int makeMovementFlags(int i, int i2) {
            int makeFlag = makeFlag(0, i2 | i);
            return makeFlag(2, i) | makeFlag(1, i2) | makeFlag;
        }

        final int a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            int size = list.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                RecoverAnimation recoverAnimation = list.get(i3);
                recoverAnimation.update();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, recoverAnimation.h, recoverAnimation.l, recoverAnimation.m, recoverAnimation.i, false);
                canvas.restoreToCount(save);
                i2 = i3 + 1;
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
        }

        void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            int size = list.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                RecoverAnimation recoverAnimation = list.get(i3);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.h, recoverAnimation.l, recoverAnimation.m, recoverAnimation.i, false);
                canvas.restoreToCount(save);
                i2 = i3 + 1;
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
            boolean z = false;
            for (int i4 = size - 1; i4 >= 0; i4--) {
                RecoverAnimation recoverAnimation2 = list.get(i4);
                if (recoverAnimation2.o && !recoverAnimation2.k) {
                    list.remove(i4);
                } else if (!recoverAnimation2.o) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        boolean b(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (a(recyclerView, viewHolder) & Spanned.SPAN_PRIORITY) != 0;
        }

        boolean c(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (a(recyclerView, viewHolder) & 65280) != 0;
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int i, int i2) {
            int width = viewHolder.itemView.getWidth();
            int height = viewHolder.itemView.getHeight();
            int left = i - viewHolder.itemView.getLeft();
            int top = i2 - viewHolder.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int i3 = -1;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= size) {
                    return viewHolder2;
                }
                RecyclerView.ViewHolder viewHolder3 = list.get(i5);
                RecyclerView.ViewHolder viewHolder4 = viewHolder2;
                int i6 = i3;
                if (left > 0) {
                    int right = viewHolder3.itemView.getRight() - (i + width);
                    viewHolder4 = viewHolder2;
                    i6 = i3;
                    if (right < 0) {
                        viewHolder4 = viewHolder2;
                        i6 = i3;
                        if (viewHolder3.itemView.getRight() > viewHolder.itemView.getRight()) {
                            int abs = Math.abs(right);
                            viewHolder4 = viewHolder2;
                            i6 = i3;
                            if (abs > i3) {
                                viewHolder4 = viewHolder3;
                                i6 = abs;
                            }
                        }
                    }
                }
                RecyclerView.ViewHolder viewHolder5 = viewHolder4;
                int i7 = i6;
                if (left < 0) {
                    int left2 = viewHolder3.itemView.getLeft() - i;
                    viewHolder5 = viewHolder4;
                    i7 = i6;
                    if (left2 > 0) {
                        viewHolder5 = viewHolder4;
                        i7 = i6;
                        if (viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft()) {
                            int abs2 = Math.abs(left2);
                            viewHolder5 = viewHolder4;
                            i7 = i6;
                            if (abs2 > i6) {
                                viewHolder5 = viewHolder3;
                                i7 = abs2;
                            }
                        }
                    }
                }
                RecyclerView.ViewHolder viewHolder6 = viewHolder5;
                int i8 = i7;
                if (top < 0) {
                    int top2 = viewHolder3.itemView.getTop() - i2;
                    viewHolder6 = viewHolder5;
                    i8 = i7;
                    if (top2 > 0) {
                        viewHolder6 = viewHolder5;
                        i8 = i7;
                        if (viewHolder3.itemView.getTop() < viewHolder.itemView.getTop()) {
                            int abs3 = Math.abs(top2);
                            viewHolder6 = viewHolder5;
                            i8 = i7;
                            if (abs3 > i7) {
                                viewHolder6 = viewHolder3;
                                i8 = abs3;
                            }
                        }
                    }
                }
                viewHolder2 = viewHolder6;
                i3 = i8;
                if (top > 0) {
                    int bottom = viewHolder3.itemView.getBottom() - (i2 + height);
                    viewHolder2 = viewHolder6;
                    i3 = i8;
                    if (bottom < 0) {
                        viewHolder2 = viewHolder6;
                        i3 = i8;
                        if (viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom()) {
                            int abs4 = Math.abs(bottom);
                            viewHolder2 = viewHolder6;
                            i3 = i8;
                            if (abs4 > i8) {
                                i3 = abs4;
                                viewHolder2 = viewHolder3;
                            }
                        }
                    }
                }
                i4 = i5 + 1;
            }
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            ItemTouchUIUtilImpl.f3241a.clearView(viewHolder.itemView);
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3;
            int i4 = i & 3158064;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & i4;
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= (-3158065) & i6;
                i3 = (i6 & 3158064) >> 2;
            }
            return i5 | i3;
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i == 8 ? 200L : 250L : i == 8 ? itemAnimator.getMoveDuration() : itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            int a2 = a(recyclerView);
            float f = 1.0f;
            int signum = (int) (((int) Math.signum(i2)) * a2 * b.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)));
            if (j <= 2000) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (signum * f3235a.getInterpolation(f));
            int i4 = interpolation;
            if (interpolation == 0) {
                if (i2 > 0) {
                    return 1;
                }
                i4 = -1;
            }
            return i4;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            ItemTouchUIUtilImpl.f3241a.onDraw(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            ItemTouchUIUtilImpl.f3241a.onDrawOver(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
                ItemTouchUIUtilImpl.f3241a.onSelected(viewHolder.itemView);
            }
        }

        public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ItemTouchHelper$ItemTouchHelperGestureListener.class */
    public class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean b = true;

        ItemTouchHelperGestureListener() {
        }

        void a() {
            this.b = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View a2;
            RecyclerView.ViewHolder childViewHolder;
            if (this.b && (a2 = ItemTouchHelper.this.a(motionEvent)) != null && (childViewHolder = ItemTouchHelper.this.k.getChildViewHolder(a2)) != null && ItemTouchHelper.this.h.b(ItemTouchHelper.this.k, childViewHolder) && motionEvent.getPointerId(0) == ItemTouchHelper.this.g) {
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.g);
                float x = motionEvent.getX(findPointerIndex);
                float y = motionEvent.getY(findPointerIndex);
                ItemTouchHelper.this.f3227c = x;
                ItemTouchHelper.this.d = y;
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                itemTouchHelper.f = 0.0f;
                itemTouchHelper.e = 0.0f;
                if (ItemTouchHelper.this.h.isLongPressDragEnabled()) {
                    ItemTouchHelper.this.a(childViewHolder, 2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ItemTouchHelper$RecoverAnimation.class */
    public static class RecoverAnimation implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private final ValueAnimator f3238a;
        private float b;
        final float d;
        final float e;
        final float f;
        final float g;
        final RecyclerView.ViewHolder h;
        final int i;
        final int j;
        boolean k;
        float l;
        float m;
        boolean n = false;
        boolean o = false;

        RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4) {
            this.i = i2;
            this.j = i;
            this.h = viewHolder;
            this.d = f;
            this.e = f2;
            this.f = f3;
            this.g = f4;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f3238a = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.setFraction(valueAnimator.getAnimatedFraction());
                }
            });
            this.f3238a.setTarget(viewHolder.itemView);
            this.f3238a.addListener(this);
            setFraction(0.0f);
        }

        public void cancel() {
            this.f3238a.cancel();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            setFraction(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.o) {
                this.h.setIsRecyclable(true);
            }
            this.o = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public void setDuration(long j) {
            this.f3238a.setDuration(j);
        }

        public void setFraction(float f) {
            this.b = f;
        }

        public void start() {
            this.h.setIsRecyclable(false);
            this.f3238a.start();
        }

        public void update() {
            float f = this.d;
            float f2 = this.f;
            if (f == f2) {
                this.l = this.h.itemView.getTranslationX();
            } else {
                this.l = f + (this.b * (f2 - f));
            }
            float f3 = this.e;
            float f4 = this.g;
            if (f3 == f4) {
                this.m = this.h.itemView.getTranslationY();
            } else {
                this.m = f3 + (this.b * (f4 - f3));
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ItemTouchHelper$SimpleCallback.class */
    public static abstract class SimpleCallback extends Callback {

        /* renamed from: a  reason: collision with root package name */
        private int f3240a;
        private int b;

        public SimpleCallback(int i, int i2) {
            this.f3240a = i2;
            this.b = i;
        }

        public int getDragDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.b;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.f3240a;
        }

        public void setDefaultDragDirs(int i) {
            this.b = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.f3240a = i;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ItemTouchHelper$ViewDropHandler.class */
    public interface ViewDropHandler {
        void prepareForDrop(View view, View view2, int i, int i2);
    }

    public ItemTouchHelper(Callback callback) {
        this.h = callback;
    }

    private void a(float[] fArr) {
        if ((this.i & 12) != 0) {
            fArr[0] = (this.t + this.e) - this.b.itemView.getLeft();
        } else {
            fArr[0] = this.b.itemView.getTranslationX();
        }
        if ((this.i & 3) != 0) {
            fArr[1] = (this.u + this.f) - this.b.itemView.getTop();
        } else {
            fArr[1] = this.b.itemView.getTranslationY();
        }
    }

    private static boolean a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    private int b(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 12) != 0) {
            int i2 = 8;
            int i3 = this.e > 0.0f ? 8 : 4;
            VelocityTracker velocityTracker = this.m;
            if (velocityTracker != null && this.g > -1) {
                velocityTracker.computeCurrentVelocity(1000, this.h.getSwipeVelocityThreshold(this.s));
                float xVelocity = this.m.getXVelocity(this.g);
                float yVelocity = this.m.getYVelocity(this.g);
                if (xVelocity <= 0.0f) {
                    i2 = 4;
                }
                float abs = Math.abs(xVelocity);
                if ((i2 & i) != 0 && i3 == i2 && abs >= this.h.getSwipeEscapeVelocity(this.r) && abs > Math.abs(yVelocity)) {
                    return i2;
                }
            }
            float width = this.k.getWidth();
            float swipeThreshold = this.h.getSwipeThreshold(viewHolder);
            if ((i & i3) == 0 || Math.abs(this.e) <= width * swipeThreshold) {
                return 0;
            }
            return i3;
        }
        return 0;
    }

    private List<RecyclerView.ViewHolder> b(RecyclerView.ViewHolder viewHolder) {
        List<RecyclerView.ViewHolder> list = this.x;
        if (list == null) {
            this.x = new ArrayList();
            this.y = new ArrayList();
        } else {
            list.clear();
            this.y.clear();
        }
        int boundingBoxMargin = this.h.getBoundingBoxMargin();
        int round = Math.round(this.t + this.e) - boundingBoxMargin;
        int round2 = Math.round(this.u + this.f) - boundingBoxMargin;
        int i = boundingBoxMargin * 2;
        int width = viewHolder.itemView.getWidth() + round + i;
        int height = viewHolder.itemView.getHeight() + round2 + i;
        int i2 = (round + width) / 2;
        int i3 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.k.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= childCount) {
                return this.x;
            }
            View childAt = layoutManager.getChildAt(i5);
            if (childAt != viewHolder.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.k.getChildViewHolder(childAt);
                if (this.h.canDropOver(this.k, this.b, childViewHolder)) {
                    int abs = Math.abs(i2 - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i3 - ((childAt.getTop() + childAt.getBottom()) / 2));
                    int i6 = (abs * abs) + (abs2 * abs2);
                    int size = this.x.size();
                    int i7 = 0;
                    for (int i8 = 0; i8 < size && i6 > this.y.get(i8).intValue(); i8++) {
                        i7++;
                    }
                    this.x.add(i7, childViewHolder);
                    this.y.add(i7, Integer.valueOf(i6));
                }
            }
            i4 = i5 + 1;
        }
    }

    private int c(RecyclerView.ViewHolder viewHolder) {
        if (this.v == 2) {
            return 0;
        }
        int movementFlags = this.h.getMovementFlags(this.k, viewHolder);
        int convertToAbsoluteDirection = (this.h.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.k)) & 65280) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i = (movementFlags & 65280) >> 8;
        if (Math.abs(this.e) > Math.abs(this.f)) {
            int b = b(viewHolder, convertToAbsoluteDirection);
            if (b > 0) {
                return (i & b) == 0 ? Callback.convertToRelativeDirection(b, ViewCompat.getLayoutDirection(this.k)) : b;
            }
            int c2 = c(viewHolder, convertToAbsoluteDirection);
            if (c2 > 0) {
                return c2;
            }
            return 0;
        }
        int c3 = c(viewHolder, convertToAbsoluteDirection);
        if (c3 > 0) {
            return c3;
        }
        int b2 = b(viewHolder, convertToAbsoluteDirection);
        if (b2 > 0) {
            int i2 = b2;
            if ((i & b2) == 0) {
                i2 = Callback.convertToRelativeDirection(b2, ViewCompat.getLayoutDirection(this.k));
            }
            return i2;
        }
        return 0;
    }

    private int c(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 3) != 0) {
            int i2 = 2;
            int i3 = this.f > 0.0f ? 2 : 1;
            VelocityTracker velocityTracker = this.m;
            if (velocityTracker != null && this.g > -1) {
                velocityTracker.computeCurrentVelocity(1000, this.h.getSwipeVelocityThreshold(this.s));
                float xVelocity = this.m.getXVelocity(this.g);
                float yVelocity = this.m.getYVelocity(this.g);
                if (yVelocity <= 0.0f) {
                    i2 = 1;
                }
                float abs = Math.abs(yVelocity);
                if ((i2 & i) != 0 && i2 == i3 && abs >= this.h.getSwipeEscapeVelocity(this.r) && abs > Math.abs(xVelocity)) {
                    return i2;
                }
            }
            float height = this.k.getHeight();
            float swipeThreshold = this.h.getSwipeThreshold(viewHolder);
            if ((i & i3) == 0 || Math.abs(this.f) <= height * swipeThreshold) {
                return 0;
            }
            return i3;
        }
        return 0;
    }

    private RecyclerView.ViewHolder c(MotionEvent motionEvent) {
        View a2;
        RecyclerView.LayoutManager layoutManager = this.k.getLayoutManager();
        int i = this.g;
        if (i == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        float x = motionEvent.getX(findPointerIndex);
        float f = this.f3227c;
        float y = motionEvent.getY(findPointerIndex);
        float f2 = this.d;
        float abs = Math.abs(x - f);
        float abs2 = Math.abs(y - f2);
        int i2 = this.w;
        if (abs >= i2 || abs2 >= i2) {
            if (abs <= abs2 || !layoutManager.canScrollHorizontally()) {
                if ((abs2 <= abs || !layoutManager.canScrollVertically()) && (a2 = a(motionEvent)) != null) {
                    return this.k.getChildViewHolder(a2);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private void d() {
        this.w = ViewConfiguration.get(this.k.getContext()).getScaledTouchSlop();
        this.k.addItemDecoration(this);
        this.k.addOnItemTouchListener(this.B);
        this.k.addOnChildAttachStateChangeListener(this);
        f();
    }

    private void e() {
        this.k.removeItemDecoration(this);
        this.k.removeOnItemTouchListener(this.B);
        this.k.removeOnChildAttachStateChangeListener(this);
        int size = this.j.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                this.j.clear();
                this.n = null;
                this.o = -1;
                h();
                g();
                return;
            }
            this.h.clearView(this.k, this.j.get(0).h);
            size = i;
        }
    }

    private void f() {
        this.A = new ItemTouchHelperGestureListener();
        this.p = new GestureDetectorCompat(this.k.getContext(), this.A);
    }

    private void g() {
        ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.A;
        if (itemTouchHelperGestureListener != null) {
            itemTouchHelperGestureListener.a();
            this.A = null;
        }
        if (this.p != null) {
            this.p = null;
        }
    }

    private void h() {
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
    }

    private void i() {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.z == null) {
            this.z = new RecyclerView.ChildDrawingOrderCallback() { // from class: androidx.recyclerview.widget.ItemTouchHelper.5
                @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
                public int onGetChildDrawingOrder(int i, int i2) {
                    if (ItemTouchHelper.this.n == null) {
                        return i2;
                    }
                    int i3 = ItemTouchHelper.this.o;
                    int i4 = i3;
                    if (i3 == -1) {
                        i4 = ItemTouchHelper.this.k.indexOfChild(ItemTouchHelper.this.n);
                        ItemTouchHelper.this.o = i4;
                    }
                    return i2 == i - 1 ? i4 : i2 < i4 ? i2 : i2 + 1;
                }
            };
        }
        this.k.setChildDrawingOrderCallback(this.z);
    }

    View a(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.b;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (a(view, x, y, this.t + this.e, this.u + this.f)) {
                return view;
            }
        }
        int size = this.j.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return this.k.findChildViewUnder(x, y);
            }
            RecoverAnimation recoverAnimation = this.j.get(i);
            View view2 = recoverAnimation.h.itemView;
            if (a(view2, x, y, recoverAnimation.l, recoverAnimation.m)) {
                return view2;
            }
            size = i;
        }
    }

    void a(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.ViewHolder c2;
        int a2;
        if (this.b != null || i != 2 || this.v == 2 || !this.h.isItemViewSwipeEnabled() || this.k.getScrollState() == 1 || (c2 = c(motionEvent)) == null || (a2 = (this.h.a(this.k, c2) & 65280) >> 8) == 0) {
            return;
        }
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.f3227c;
        float f2 = y - this.d;
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        int i3 = this.w;
        if (abs >= i3 || abs2 >= i3) {
            if (abs > abs2) {
                if (f < 0.0f && (a2 & 4) == 0) {
                    return;
                }
                if (f > 0.0f && (a2 & 8) == 0) {
                    return;
                }
            } else if (f2 < 0.0f && (a2 & 1) == 0) {
                return;
            } else {
                if (f2 > 0.0f && (a2 & 2) == 0) {
                    return;
                }
            }
            this.f = 0.0f;
            this.e = 0.0f;
            this.g = motionEvent.getPointerId(0);
            a(c2, 1);
        }
    }

    void a(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.f3227c;
        this.e = f;
        this.f = y - this.d;
        if ((i & 4) == 0) {
            this.e = Math.max(0.0f, f);
        }
        if ((i & 8) == 0) {
            this.e = Math.min(0.0f, this.e);
        }
        if ((i & 1) == 0) {
            this.f = Math.max(0.0f, this.f);
        }
        if ((i & 2) == 0) {
            this.f = Math.min(0.0f, this.f);
        }
    }

    void a(View view) {
        if (view == this.n) {
            this.n = null;
            if (this.z != null) {
                this.k.setChildDrawingOrderCallback(null);
            }
        }
    }

    void a(final RecoverAnimation recoverAnimation, final int i) {
        this.k.post(new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (ItemTouchHelper.this.k == null || !ItemTouchHelper.this.k.isAttachedToWindow() || recoverAnimation.n || recoverAnimation.h.getAdapterPosition() == -1) {
                    return;
                }
                RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.k.getItemAnimator();
                if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemTouchHelper.this.a()) {
                    ItemTouchHelper.this.h.onSwiped(recoverAnimation.h, i);
                } else {
                    ItemTouchHelper.this.k.post(this);
                }
            }
        });
    }

    void a(RecyclerView.ViewHolder viewHolder) {
        if (!this.k.isLayoutRequested() && this.v == 2) {
            float moveThreshold = this.h.getMoveThreshold(viewHolder);
            int i = (int) (this.t + this.e);
            int i2 = (int) (this.u + this.f);
            if (Math.abs(i2 - viewHolder.itemView.getTop()) >= viewHolder.itemView.getHeight() * moveThreshold || Math.abs(i - viewHolder.itemView.getLeft()) >= viewHolder.itemView.getWidth() * moveThreshold) {
                List<RecyclerView.ViewHolder> b = b(viewHolder);
                if (b.size() == 0) {
                    return;
                }
                RecyclerView.ViewHolder chooseDropTarget = this.h.chooseDropTarget(viewHolder, b, i, i2);
                if (chooseDropTarget == null) {
                    this.x.clear();
                    this.y.clear();
                    return;
                }
                int adapterPosition = chooseDropTarget.getAdapterPosition();
                int adapterPosition2 = viewHolder.getAdapterPosition();
                if (this.h.onMove(this.k, viewHolder, chooseDropTarget)) {
                    this.h.onMoved(this.k, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i, i2);
                }
            }
        }
    }

    void a(RecyclerView.ViewHolder viewHolder, int i) {
        boolean z;
        float signum;
        float f;
        if (viewHolder == this.b && i == this.v) {
            return;
        }
        this.D = Long.MIN_VALUE;
        int i2 = this.v;
        a(viewHolder, true);
        this.v = i;
        if (i == 2) {
            if (viewHolder == null) {
                throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            }
            this.n = viewHolder.itemView;
            i();
        }
        final RecyclerView.ViewHolder viewHolder2 = this.b;
        if (viewHolder2 != null) {
            if (viewHolder2.itemView.getParent() != null) {
                int c2 = i2 == 2 ? 0 : c(viewHolder2);
                h();
                if (c2 == 1 || c2 == 2) {
                    signum = Math.signum(this.f) * this.k.getHeight();
                    f = 0.0f;
                } else {
                    f = (c2 == 4 || c2 == 8 || c2 == 16 || c2 == 32) ? Math.signum(this.e) * this.k.getWidth() : 0.0f;
                    signum = 0.0f;
                }
                int i3 = i2 == 2 ? 8 : c2 > 0 ? 2 : 4;
                a(this.q);
                float[] fArr = this.q;
                float f2 = fArr[0];
                float f3 = fArr[1];
                final int i4 = c2;
                RecoverAnimation recoverAnimation = new RecoverAnimation(viewHolder2, i3, i2, f2, f3, f, signum) { // from class: androidx.recyclerview.widget.ItemTouchHelper.3
                    @Override // androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (this.n) {
                            return;
                        }
                        if (i4 <= 0) {
                            ItemTouchHelper.this.h.clearView(ItemTouchHelper.this.k, viewHolder2);
                        } else {
                            ItemTouchHelper.this.f3226a.add(viewHolder2.itemView);
                            this.k = true;
                            int i5 = i4;
                            if (i5 > 0) {
                                ItemTouchHelper.this.a(this, i5);
                            }
                        }
                        if (ItemTouchHelper.this.n == viewHolder2.itemView) {
                            ItemTouchHelper.this.a(viewHolder2.itemView);
                        }
                    }
                };
                recoverAnimation.setDuration(this.h.getAnimationDuration(this.k, i3, f - f2, signum - f3));
                this.j.add(recoverAnimation);
                recoverAnimation.start();
                z = true;
            } else {
                a(viewHolder2.itemView);
                this.h.clearView(this.k, viewHolder2);
                z = false;
            }
            this.b = null;
        } else {
            z = false;
        }
        if (viewHolder != null) {
            this.i = (this.h.a(this.k, viewHolder) & ((1 << ((i * 8) + 8)) - 1)) >> (this.v * 8);
            this.t = viewHolder.itemView.getLeft();
            this.u = viewHolder.itemView.getTop();
            this.b = viewHolder;
            if (i == 2) {
                viewHolder.itemView.performHapticFeedback(0);
            }
        }
        ViewParent parent = this.k.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(this.b != null);
        }
        if (!z) {
            this.k.getLayoutManager().requestSimpleAnimationsInNextLayout();
        }
        this.h.onSelectedChanged(this.b, this.v);
        this.k.invalidate();
    }

    void a(RecyclerView.ViewHolder viewHolder, boolean z) {
        int size = this.j.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            RecoverAnimation recoverAnimation = this.j.get(i);
            if (recoverAnimation.h == viewHolder) {
                recoverAnimation.n |= z;
                if (!recoverAnimation.o) {
                    recoverAnimation.cancel();
                }
                this.j.remove(i);
                return;
            }
            size = i;
        }
    }

    boolean a() {
        int size = this.j.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (!this.j.get(i2).o) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.k;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            e();
        }
        this.k = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.r = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
            this.s = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
            d();
        }
    }

    RecoverAnimation b(MotionEvent motionEvent) {
        if (this.j.isEmpty()) {
            return null;
        }
        View a2 = a(motionEvent);
        int size = this.j.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return null;
            }
            RecoverAnimation recoverAnimation = this.j.get(i);
            if (recoverAnimation.h.itemView == a2) {
                return recoverAnimation;
            }
            size = i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c0, code lost:
        if (r9 > 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x012c, code lost:
        if (r10 > 0) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean b() {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.b():boolean");
    }

    void c() {
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.m = VelocityTracker.obtain();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(View view) {
        a(view);
        RecyclerView.ViewHolder childViewHolder = this.k.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.b;
        if (viewHolder != null && childViewHolder == viewHolder) {
            a((RecyclerView.ViewHolder) null, 0);
            return;
        }
        a(childViewHolder, false);
        if (this.f3226a.remove(childViewHolder.itemView)) {
            this.h.clearView(this.k, childViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2;
        this.o = -1;
        if (this.b != null) {
            a(this.q);
            float[] fArr = this.q;
            f = fArr[0];
            f2 = fArr[1];
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.h.a(canvas, recyclerView, this.b, this.j, this.v, f, f2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2;
        if (this.b != null) {
            a(this.q);
            float[] fArr = this.q;
            f = fArr[0];
            f2 = fArr[1];
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.h.b(canvas, recyclerView, this.b, this.j, this.v, f, f2);
    }

    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        if (!this.h.b(this.k, viewHolder)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
        } else if (viewHolder.itemView.getParent() != this.k) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            c();
            this.f = 0.0f;
            this.e = 0.0f;
            a(viewHolder, 2);
        }
    }

    public void startSwipe(RecyclerView.ViewHolder viewHolder) {
        if (!this.h.c(this.k, viewHolder)) {
            Log.e("ItemTouchHelper", "Start swipe has been called but swiping is not enabled");
        } else if (viewHolder.itemView.getParent() != this.k) {
            Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        } else {
            c();
            this.f = 0.0f;
            this.e = 0.0f;
            a(viewHolder, 1);
        }
    }
}
