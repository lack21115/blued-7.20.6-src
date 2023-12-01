package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/graphics/drawable/DrawableContainer.class */
public class DrawableContainer extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    private DrawableContainerState f1578a;
    private Rect b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f1579c;
    private Drawable d;
    private boolean f;
    private boolean h;
    private Runnable i;
    private long j;
    private long k;
    private BlockInvalidateCallback l;
    private int e = 255;
    private int g = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/graphics/drawable/DrawableContainer$Api21Impl.class */
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean canApplyTheme(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void getOutline(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources getResources(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/graphics/drawable/DrawableContainer$BlockInvalidateCallback.class */
    public static class BlockInvalidateCallback implements Drawable.Callback {

        /* renamed from: a  reason: collision with root package name */
        private Drawable.Callback f1581a;

        BlockInvalidateCallback() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f1581a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f1581a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        public Drawable.Callback unwrap() {
            Drawable.Callback callback = this.f1581a;
            this.f1581a = null;
            return callback;
        }

        public BlockInvalidateCallback wrap(Drawable.Callback callback) {
            this.f1581a = callback;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/graphics/drawable/DrawableContainer$DrawableContainerState.class */
    public static abstract class DrawableContainerState extends Drawable.ConstantState {
        boolean A;
        int B;
        int C;
        int D;
        boolean E;
        ColorFilter F;
        boolean G;
        ColorStateList H;
        PorterDuff.Mode I;
        boolean J;
        boolean K;

        /* renamed from: c  reason: collision with root package name */
        final DrawableContainer f1582c;
        Resources d;
        int e;
        int f;
        int g;
        SparseArray<Drawable.ConstantState> h;
        Drawable[] i;
        int j;
        boolean k;
        boolean l;
        Rect m;
        boolean n;
        boolean o;
        int p;
        int q;
        int r;
        int s;
        boolean t;
        int u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        boolean z;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DrawableContainerState(DrawableContainerState drawableContainerState, DrawableContainer drawableContainer, Resources resources) {
            this.k = false;
            this.n = false;
            this.z = true;
            this.C = 0;
            this.D = 0;
            this.f1582c = drawableContainer;
            this.d = resources != null ? resources : drawableContainerState != null ? drawableContainerState.d : null;
            int a2 = DrawableContainer.a(resources, drawableContainerState != null ? drawableContainerState.e : 0);
            this.e = a2;
            if (drawableContainerState == null) {
                this.i = new Drawable[10];
                this.j = 0;
                return;
            }
            this.f = drawableContainerState.f;
            this.g = drawableContainerState.g;
            this.x = true;
            this.y = true;
            this.k = drawableContainerState.k;
            this.n = drawableContainerState.n;
            this.z = drawableContainerState.z;
            this.A = drawableContainerState.A;
            this.B = drawableContainerState.B;
            this.C = drawableContainerState.C;
            this.D = drawableContainerState.D;
            this.E = drawableContainerState.E;
            this.F = drawableContainerState.F;
            this.G = drawableContainerState.G;
            this.H = drawableContainerState.H;
            this.I = drawableContainerState.I;
            this.J = drawableContainerState.J;
            this.K = drawableContainerState.K;
            if (drawableContainerState.e == a2) {
                if (drawableContainerState.l) {
                    this.m = drawableContainerState.m != null ? new Rect(drawableContainerState.m) : null;
                    this.l = true;
                }
                if (drawableContainerState.o) {
                    this.p = drawableContainerState.p;
                    this.q = drawableContainerState.q;
                    this.r = drawableContainerState.r;
                    this.s = drawableContainerState.s;
                    this.o = true;
                }
            }
            if (drawableContainerState.t) {
                this.u = drawableContainerState.u;
                this.t = true;
            }
            if (drawableContainerState.v) {
                this.w = drawableContainerState.w;
                this.v = true;
            }
            Drawable[] drawableArr = drawableContainerState.i;
            this.i = new Drawable[drawableArr.length];
            this.j = drawableContainerState.j;
            SparseArray<Drawable.ConstantState> sparseArray = drawableContainerState.h;
            if (sparseArray != null) {
                this.h = sparseArray.m1025clone();
            } else {
                this.h = new SparseArray<>(this.j);
            }
            int i = this.j;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return;
                }
                if (drawableArr[i3] != null) {
                    Drawable.ConstantState constantState = drawableArr[i3].getConstantState();
                    if (constantState != null) {
                        this.h.put(i3, constantState);
                    } else {
                        this.i[i3] = drawableArr[i3];
                    }
                }
                i2 = i3 + 1;
            }
        }

        private Drawable a(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                DrawableCompat.setLayoutDirection(drawable, this.B);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f1582c);
            return mutate;
        }

        private void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.h;
            if (sparseArray == null) {
                return;
            }
            int size = sparseArray.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    this.h = null;
                    return;
                }
                this.i[this.h.keyAt(i2)] = a(this.h.valueAt(i2).newDrawable(this.d));
                i = i2 + 1;
            }
        }

        void a() {
            int i = this.j;
            Drawable[] drawableArr = this.i;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    this.A = true;
                    return;
                }
                if (drawableArr[i3] != null) {
                    drawableArr[i3].mutate();
                }
                i2 = i3 + 1;
            }
        }

        final void a(Resources.Theme theme) {
            if (theme == null) {
                return;
            }
            e();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    a(Api21Impl.getResources(theme));
                    return;
                }
                if (drawableArr[i3] != null && DrawableCompat.canApplyTheme(drawableArr[i3])) {
                    DrawableCompat.applyTheme(drawableArr[i3], theme);
                    this.g |= drawableArr[i3].getChangingConfigurations();
                }
                i2 = i3 + 1;
            }
        }

        final void a(Resources resources) {
            if (resources != null) {
                this.d = resources;
                int a2 = DrawableContainer.a(resources, this.e);
                int i = this.e;
                this.e = a2;
                if (i != a2) {
                    this.o = false;
                    this.l = false;
                }
            }
        }

        public final int addChild(Drawable drawable) {
            int i = this.j;
            if (i >= this.i.length) {
                growArray(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f1582c);
            this.i[i] = drawable;
            this.j++;
            this.g = drawable.getChangingConfigurations() | this.g;
            b();
            this.m = null;
            this.l = false;
            this.o = false;
            this.x = false;
            return i;
        }

        void b() {
            this.t = false;
            this.v = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int c() {
            return this.i.length;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.j;
            Drawable[] drawableArr = this.i;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return false;
                }
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.h.get(i3);
                    if (constantState != null && Api21Impl.canApplyTheme(constantState)) {
                        return true;
                    }
                } else if (DrawableCompat.canApplyTheme(drawable)) {
                    return true;
                }
                i2 = i3 + 1;
            }
        }

        public boolean canConstantState() {
            if (this.x) {
                return this.y;
            }
            e();
            this.x = true;
            int i = this.j;
            Drawable[] drawableArr = this.i;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    this.y = true;
                    return true;
                } else if (drawableArr[i3].getConstantState() == null) {
                    this.y = false;
                    return false;
                } else {
                    i2 = i3 + 1;
                }
            }
        }

        protected void d() {
            this.o = true;
            e();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            this.q = -1;
            this.p = -1;
            this.s = 0;
            this.r = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.p) {
                    this.p = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.q) {
                    this.q = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.r) {
                    this.r = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.s) {
                    this.s = minimumHeight;
                }
            }
        }

        final boolean d(int i, int i2) {
            int i3 = this.j;
            Drawable[] drawableArr = this.i;
            int i4 = 0;
            boolean z = false;
            while (true) {
                boolean z2 = z;
                if (i4 >= i3) {
                    this.B = i;
                    return z2;
                }
                boolean z3 = z2;
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? DrawableCompat.setLayoutDirection(drawableArr[i4], i) : false;
                    z3 = z2;
                    if (i4 == i2) {
                        z3 = layoutDirection;
                    }
                }
                i4++;
                z = z3;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f | this.g;
        }

        public final Drawable getChild(int i) {
            int indexOfKey;
            Drawable drawable = this.i[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.h;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable a2 = a(this.h.valueAt(indexOfKey).newDrawable(this.d));
            this.i[i] = a2;
            this.h.removeAt(indexOfKey);
            if (this.h.size() == 0) {
                this.h = null;
            }
            return a2;
        }

        public final int getChildCount() {
            return this.j;
        }

        public final int getConstantHeight() {
            if (!this.o) {
                d();
            }
            return this.q;
        }

        public final int getConstantMinimumHeight() {
            if (!this.o) {
                d();
            }
            return this.s;
        }

        public final int getConstantMinimumWidth() {
            if (!this.o) {
                d();
            }
            return this.r;
        }

        public final Rect getConstantPadding() {
            Rect rect = null;
            if (this.k) {
                return null;
            }
            if (this.m != null || this.l) {
                return this.m;
            }
            e();
            Rect rect2 = new Rect();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            int i2 = 0;
            while (i2 < i) {
                Rect rect3 = rect;
                if (drawableArr[i2].getPadding(rect2)) {
                    Rect rect4 = rect;
                    if (rect == null) {
                        rect4 = new Rect(0, 0, 0, 0);
                    }
                    if (rect2.left > rect4.left) {
                        rect4.left = rect2.left;
                    }
                    if (rect2.top > rect4.top) {
                        rect4.top = rect2.top;
                    }
                    if (rect2.right > rect4.right) {
                        rect4.right = rect2.right;
                    }
                    rect3 = rect4;
                    if (rect2.bottom > rect4.bottom) {
                        rect4.bottom = rect2.bottom;
                        rect3 = rect4;
                    }
                }
                i2++;
                rect = rect3;
            }
            this.l = true;
            this.m = rect;
            return rect;
        }

        public final int getConstantWidth() {
            if (!this.o) {
                d();
            }
            return this.p;
        }

        public final int getEnterFadeDuration() {
            return this.C;
        }

        public final int getExitFadeDuration() {
            return this.D;
        }

        public final int getOpacity() {
            if (this.t) {
                return this.u;
            }
            e();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    this.u = opacity;
                    this.t = true;
                    return opacity;
                }
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
                i2 = i3 + 1;
            }
        }

        public void growArray(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            Drawable[] drawableArr2 = this.i;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i);
            }
            this.i = drawableArr;
        }

        public final boolean isConstantSize() {
            return this.n;
        }

        public final boolean isStateful() {
            boolean z;
            if (this.v) {
                return this.w;
            }
            e();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                z = false;
                if (i3 >= i) {
                    break;
                } else if (drawableArr[i3].isStateful()) {
                    z = true;
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
            this.w = z;
            this.v = true;
            return z;
        }

        public final void setConstantSize(boolean z) {
            this.n = z;
        }

        public final void setEnterFadeDuration(int i) {
            this.C = i;
        }

        public final void setExitFadeDuration(int i) {
            this.D = i;
        }

        public final void setVariablePadding(boolean z) {
            this.k = z;
        }
    }

    static int a(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        int i2 = i;
        if (i == 0) {
            i2 = 160;
        }
        return i2;
    }

    private void a(Drawable drawable) {
        if (this.l == null) {
            this.l = new BlockInvalidateCallback();
        }
        drawable.setCallback(this.l.wrap(drawable.getCallback()));
        try {
            if (this.f1578a.C <= 0 && this.f) {
                drawable.setAlpha(this.e);
            }
            if (this.f1578a.G) {
                drawable.setColorFilter(this.f1578a.F);
            } else {
                if (this.f1578a.J) {
                    DrawableCompat.setTintList(drawable, this.f1578a.H);
                }
                if (this.f1578a.K) {
                    DrawableCompat.setTintMode(drawable, this.f1578a.I);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f1578a.z);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                DrawableCompat.setAutoMirrored(drawable, this.f1578a.E);
            }
            Rect rect = this.b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                DrawableCompat.setHotspotBounds(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.l.unwrap());
        }
    }

    private boolean a() {
        return isAutoMirrored() && DrawableCompat.getLayoutDirection(this) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Resources resources) {
        this.f1578a.a(resources);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DrawableContainerState drawableContainerState) {
        this.f1578a = drawableContainerState;
        int i = this.g;
        if (i >= 0) {
            Drawable child = drawableContainerState.getChild(i);
            this.f1579c = child;
            if (child != null) {
                a(child);
            }
        }
        this.d = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(boolean r8) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainer.a(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        if (i == this.g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f1578a.D > 0) {
            Drawable drawable = this.d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f1579c;
            if (drawable2 != null) {
                this.d = drawable2;
                this.k = this.f1578a.D + uptimeMillis;
            } else {
                this.d = null;
                this.k = 0L;
            }
        } else {
            Drawable drawable3 = this.f1579c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i < 0 || i >= this.f1578a.j) {
            this.f1579c = null;
            this.g = -1;
        } else {
            Drawable child = this.f1578a.getChild(i);
            this.f1579c = child;
            this.g = i;
            if (child != null) {
                if (this.f1578a.C > 0) {
                    this.j = uptimeMillis + this.f1578a.C;
                }
                a(child);
            }
        }
        if (this.j != 0 || this.k != 0) {
            Runnable runnable = this.i;
            if (runnable == null) {
                this.i = new Runnable() { // from class: androidx.appcompat.graphics.drawable.DrawableContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DrawableContainer.this.a(true);
                        DrawableContainer.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(runnable);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f1578a.a(theme);
    }

    DrawableContainerState c() {
        return this.f1578a;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f1578a.canApplyTheme();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f1579c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f1578a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f1578a.canConstantState()) {
            this.f1578a.f = getChangingConfigurations();
            return this.f1578a;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1579c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f1578a.isConstantSize()) {
            return this.f1578a.getConstantHeight();
        }
        Drawable drawable = this.f1579c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f1578a.isConstantSize()) {
            return this.f1578a.getConstantWidth();
        }
        Drawable drawable = this.f1579c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f1578a.isConstantSize()) {
            return this.f1578a.getConstantMinimumHeight();
        }
        Drawable drawable = this.f1579c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f1578a.isConstantSize()) {
            return this.f1578a.getConstantMinimumWidth();
        }
        Drawable drawable = this.f1579c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1579c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f1578a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f1579c;
        if (drawable != null) {
            Api21Impl.getOutline(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect constantPadding = this.f1578a.getConstantPadding();
        if (constantPadding != null) {
            rect.set(constantPadding);
            padding = (constantPadding.right | ((constantPadding.left | constantPadding.top) | constantPadding.bottom)) != 0;
        } else {
            Drawable drawable = this.f1579c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (a()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    public void invalidateDrawable(Drawable drawable) {
        DrawableContainerState drawableContainerState = this.f1578a;
        if (drawableContainerState != null) {
            drawableContainerState.b();
        }
        if (drawable != this.f1579c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1578a.E;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f1578a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.d = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f1579c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f) {
                this.f1579c.setAlpha(this.e);
            }
        }
        if (this.k != 0) {
            this.k = 0L;
            z = true;
        }
        if (this.j != 0) {
            this.j = 0L;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.h && super.mutate() == this) {
            DrawableContainerState c2 = c();
            c2.a();
            a(c2);
            this.h = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f1579c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i) {
        return this.f1578a.d(i, d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f1579c;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f1579c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.f1579c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f && this.e == i) {
            return;
        }
        this.f = true;
        this.e = i;
        Drawable drawable = this.f1579c;
        if (drawable != null) {
            if (this.j == 0) {
                drawable.setAlpha(i);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f1578a.E != z) {
            this.f1578a.E = z;
            Drawable drawable = this.f1579c;
            if (drawable != null) {
                DrawableCompat.setAutoMirrored(drawable, this.f1578a.E);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1578a.G = true;
        if (this.f1578a.F != colorFilter) {
            this.f1578a.F = colorFilter;
            Drawable drawable = this.f1579c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (this.f1578a.z != z) {
            this.f1578a.z = z;
            Drawable drawable = this.f1579c;
            if (drawable != null) {
                drawable.setDither(this.f1578a.z);
            }
        }
    }

    public void setEnterFadeDuration(int i) {
        this.f1578a.C = i;
    }

    public void setExitFadeDuration(int i) {
        this.f1578a.D = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.f1579c;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.b;
        if (rect == null) {
            this.b = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.f1579c;
        if (drawable != null) {
            DrawableCompat.setHotspotBounds(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1578a.J = true;
        if (this.f1578a.H != colorStateList) {
            this.f1578a.H = colorStateList;
            DrawableCompat.setTintList(this.f1579c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1578a.K = true;
        if (this.f1578a.I != mode) {
            this.f1578a.I = mode;
            DrawableCompat.setTintMode(this.f1579c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f1579c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f1579c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
