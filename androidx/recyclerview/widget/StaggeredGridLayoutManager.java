package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/StaggeredGridLayoutManager.class */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    /* renamed from: a  reason: collision with root package name */
    Span[] f3297a;
    OrientationHelper b;

    /* renamed from: c  reason: collision with root package name */
    OrientationHelper f3298c;
    private int j;
    private int k;
    private final LayoutState l;
    private BitSet m;
    private boolean o;
    private boolean p;
    private SavedState q;
    private int r;
    private int[] w;
    private int i = -1;
    boolean d = false;
    boolean e = false;
    int f = -1;
    int g = Integer.MIN_VALUE;
    LazySpanLookup h = new LazySpanLookup();
    private int n = 2;
    private final Rect s = new Rect();
    private final AnchorInfo t = new AnchorInfo();
    private boolean u = false;
    private boolean v = true;
    private final Runnable x = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.a();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/StaggeredGridLayoutManager$AnchorInfo.class */
    public class AnchorInfo {

        /* renamed from: a  reason: collision with root package name */
        int f3300a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3301c;
        boolean d;
        boolean e;
        int[] f;

        AnchorInfo() {
            a();
        }

        void a() {
            this.f3300a = -1;
            this.b = Integer.MIN_VALUE;
            this.f3301c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void a(int i) {
            if (this.f3301c) {
                this.b = StaggeredGridLayoutManager.this.b.getEndAfterPadding() - i;
            } else {
                this.b = StaggeredGridLayoutManager.this.b.getStartAfterPadding() + i;
            }
        }

        void a(Span[] spanArr) {
            int length = spanArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.f3297a.length];
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                this.f[i2] = spanArr[i2].a(Integer.MIN_VALUE);
                i = i2 + 1;
            }
        }

        void b() {
            this.b = this.f3301c ? StaggeredGridLayoutManager.this.b.getEndAfterPadding() : StaggeredGridLayoutManager.this.b.getStartAfterPadding();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/StaggeredGridLayoutManager$LayoutParams.class */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;

        /* renamed from: a  reason: collision with root package name */
        Span f3302a;
        boolean b;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final int getSpanIndex() {
            Span span = this.f3302a;
            if (span == null) {
                return -1;
            }
            return span.e;
        }

        public boolean isFullSpan() {
            return this.b;
        }

        public void setFullSpan(boolean z) {
            this.b = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/StaggeredGridLayoutManager$LazySpanLookup.class */
    public static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        int[] f3303a;
        List<FullSpanItem> b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };

            /* renamed from: a  reason: collision with root package name */
            int f3304a;
            int b;

            /* renamed from: c  reason: collision with root package name */
            int[] f3305c;
            boolean d;

            FullSpanItem() {
            }

            FullSpanItem(Parcel parcel) {
                this.f3304a = parcel.readInt();
                this.b = parcel.readInt();
                this.d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f3305c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i) {
                int[] iArr = this.f3305c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f3304a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.f3305c) + '}';
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        }

        LazySpanLookup() {
        }

        private void c(int i, int i2) {
            List<FullSpanItem> list = this.b;
            if (list == null) {
                return;
            }
            int size = list.size();
            while (true) {
                int i3 = size - 1;
                if (i3 < 0) {
                    return;
                }
                FullSpanItem fullSpanItem = this.b.get(i3);
                if (fullSpanItem.f3304a >= i) {
                    if (fullSpanItem.f3304a < i + i2) {
                        this.b.remove(i3);
                    } else {
                        fullSpanItem.f3304a -= i2;
                    }
                }
                size = i3;
            }
        }

        private void d(int i, int i2) {
            List<FullSpanItem> list = this.b;
            if (list == null) {
                return;
            }
            int size = list.size();
            while (true) {
                int i3 = size - 1;
                if (i3 < 0) {
                    return;
                }
                FullSpanItem fullSpanItem = this.b.get(i3);
                if (fullSpanItem.f3304a >= i) {
                    fullSpanItem.f3304a += i2;
                }
                size = i3;
            }
        }

        private int f(int i) {
            int i2;
            if (this.b == null) {
                return -1;
            }
            FullSpanItem fullSpanItem = getFullSpanItem(i);
            if (fullSpanItem != null) {
                this.b.remove(fullSpanItem);
            }
            int size = this.b.size();
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.b.get(i2).f3304a >= i) {
                    break;
                } else {
                    i3 = i2 + 1;
                }
            }
            if (i2 != -1) {
                FullSpanItem fullSpanItem2 = this.b.get(i2);
                this.b.remove(i2);
                return fullSpanItem2.f3304a;
            }
            return -1;
        }

        int a(int i) {
            List<FullSpanItem> list = this.b;
            if (list != null) {
                int size = list.size();
                while (true) {
                    int i2 = size - 1;
                    if (i2 < 0) {
                        break;
                    }
                    if (this.b.get(i2).f3304a >= i) {
                        this.b.remove(i2);
                    }
                    size = i2;
                }
            }
            return b(i);
        }

        void a() {
            int[] iArr = this.f3303a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = null;
        }

        void a(int i, int i2) {
            int[] iArr = this.f3303a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            e(i3);
            int[] iArr2 = this.f3303a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f3303a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            c(i, i2);
        }

        void a(int i, Span span) {
            e(i);
            this.f3303a[i] = span.e;
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    this.b.add(fullSpanItem);
                    return;
                }
                FullSpanItem fullSpanItem2 = this.b.get(i2);
                if (fullSpanItem2.f3304a == fullSpanItem.f3304a) {
                    this.b.remove(i2);
                }
                if (fullSpanItem2.f3304a >= fullSpanItem.f3304a) {
                    this.b.add(i2, fullSpanItem);
                    return;
                }
                i = i2 + 1;
            }
        }

        int b(int i) {
            int[] iArr = this.f3303a;
            if (iArr != null && i < iArr.length) {
                int f = f(i);
                if (f == -1) {
                    int[] iArr2 = this.f3303a;
                    Arrays.fill(iArr2, i, iArr2.length, -1);
                    return this.f3303a.length;
                }
                int i2 = f + 1;
                Arrays.fill(this.f3303a, i, i2, -1);
                return i2;
            }
            return -1;
        }

        void b(int i, int i2) {
            int[] iArr = this.f3303a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            e(i3);
            int[] iArr2 = this.f3303a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f3303a, i, i3, -1);
            d(i, i2);
        }

        int c(int i) {
            int[] iArr = this.f3303a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        int d(int i) {
            int length = this.f3303a.length;
            while (true) {
                int i2 = length;
                if (i2 > i) {
                    return i2;
                }
                length = i2 * 2;
            }
        }

        void e(int i) {
            int[] iArr = this.f3303a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.f3303a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[d(i)];
                this.f3303a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f3303a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
            return r0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem getFirstFullSpanItemInRange(int r4, int r5, int r6, boolean r7) {
            /*
                r3 = this;
                r0 = r3
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r0.b
                r10 = r0
                r0 = r10
                if (r0 != 0) goto Ld
                r0 = 0
                return r0
            Ld:
                r0 = r10
                int r0 = r0.size()
                r9 = r0
                r0 = 0
                r8 = r0
            L19:
                r0 = r8
                r1 = r9
                if (r0 >= r1) goto L6a
                r0 = r3
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r0.b
                r1 = r8
                java.lang.Object r0 = r0.get(r1)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r0
                r10 = r0
                r0 = r10
                int r0 = r0.f3304a
                r1 = r5
                if (r0 < r1) goto L3b
                r0 = 0
                return r0
            L3b:
                r0 = r10
                int r0 = r0.f3304a
                r1 = r4
                if (r0 < r1) goto L61
                r0 = r6
                if (r0 == 0) goto L5e
                r0 = r10
                int r0 = r0.b
                r1 = r6
                if (r0 == r1) goto L5e
                r0 = r7
                if (r0 == 0) goto L61
                r0 = r10
                boolean r0 = r0.d
                if (r0 == 0) goto L61
            L5e:
                r0 = r10
                return r0
            L61:
                r0 = r8
                r1 = 1
                int r0 = r0 + r1
                r8 = r0
                goto L19
            L6a:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.getFirstFullSpanItemInRange(int, int, int, boolean):androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem");
        }

        public FullSpanItem getFullSpanItem(int i) {
            List<FullSpanItem> list = this.b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            while (true) {
                int i2 = size - 1;
                if (i2 < 0) {
                    return null;
                }
                FullSpanItem fullSpanItem = this.b.get(i2);
                if (fullSpanItem.f3304a == i) {
                    return fullSpanItem;
                }
                size = i2;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/StaggeredGridLayoutManager$SavedState.class */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f3306a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f3307c;
        int[] d;
        int e;
        int[] f;
        List<LazySpanLookup.FullSpanItem> g;
        boolean h;
        boolean i;
        boolean j;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f3306a = parcel.readInt();
            this.b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f3307c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f3307c = savedState.f3307c;
            this.f3306a = savedState.f3306a;
            this.b = savedState.b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }

        void a() {
            this.d = null;
            this.f3307c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        void b() {
            this.d = null;
            this.f3307c = 0;
            this.f3306a = -1;
            this.b = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/StaggeredGridLayoutManager$Span.class */
    public class Span {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f3308a = new ArrayList<>();
        int b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f3309c = Integer.MIN_VALUE;
        int d = 0;
        final int e;

        Span(int i) {
            this.e = i;
        }

        int a(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f3308a.size() == 0) {
                return i;
            }
            a();
            return this.b;
        }

        int a(int i, int i2, boolean z) {
            return a(i, i2, z, true, false);
        }

        int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int startAfterPadding = StaggeredGridLayoutManager.this.b.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.b.getEndAfterPadding();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f3308a.get(i);
                int decoratedStart = StaggeredGridLayoutManager.this.b.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.b.getDecoratedEnd(view);
                boolean z4 = false;
                boolean z5 = !z3 ? decoratedStart >= endAfterPadding : decoratedStart > endAfterPadding;
                if (!z3 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (z2) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    } else {
                        if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        void a() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            View view = this.f3308a.get(0);
            LayoutParams c2 = c(view);
            this.b = StaggeredGridLayoutManager.this.b.getDecoratedStart(view);
            if (c2.b && (fullSpanItem = StaggeredGridLayoutManager.this.h.getFullSpanItem(c2.getViewLayoutPosition())) != null && fullSpanItem.b == -1) {
                this.b -= fullSpanItem.a(this.e);
            }
        }

        void a(View view) {
            LayoutParams c2 = c(view);
            c2.f3302a = this;
            this.f3308a.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.f3308a.size() == 1) {
                this.f3309c = Integer.MIN_VALUE;
            }
            if (c2.isItemRemoved() || c2.isItemChanged()) {
                this.d += StaggeredGridLayoutManager.this.b.getDecoratedMeasurement(view);
            }
        }

        void a(boolean z, int i) {
            int b = z ? b(Integer.MIN_VALUE) : a(Integer.MIN_VALUE);
            e();
            if (b == Integer.MIN_VALUE) {
                return;
            }
            if (!z || b >= StaggeredGridLayoutManager.this.b.getEndAfterPadding()) {
                if (z || b <= StaggeredGridLayoutManager.this.b.getStartAfterPadding()) {
                    int i2 = b;
                    if (i != Integer.MIN_VALUE) {
                        i2 = b + i;
                    }
                    this.f3309c = i2;
                    this.b = i2;
                }
            }
        }

        int b() {
            int i = this.b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            a();
            return this.b;
        }

        int b(int i) {
            int i2 = this.f3309c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f3308a.size() == 0) {
                return i;
            }
            c();
            return this.f3309c;
        }

        int b(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        void b(View view) {
            LayoutParams c2 = c(view);
            c2.f3302a = this;
            this.f3308a.add(view);
            this.f3309c = Integer.MIN_VALUE;
            if (this.f3308a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (c2.isItemRemoved() || c2.isItemChanged()) {
                this.d += StaggeredGridLayoutManager.this.b.getDecoratedMeasurement(view);
            }
        }

        LayoutParams c(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        void c() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            ArrayList<View> arrayList = this.f3308a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams c2 = c(view);
            this.f3309c = StaggeredGridLayoutManager.this.b.getDecoratedEnd(view);
            if (c2.b && (fullSpanItem = StaggeredGridLayoutManager.this.h.getFullSpanItem(c2.getViewLayoutPosition())) != null && fullSpanItem.b == 1) {
                this.f3309c += fullSpanItem.a(this.e);
            }
        }

        void c(int i) {
            this.b = i;
            this.f3309c = i;
        }

        int d() {
            int i = this.f3309c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            c();
            return this.f3309c;
        }

        void d(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                this.b = i2 + i;
            }
            int i3 = this.f3309c;
            if (i3 != Integer.MIN_VALUE) {
                this.f3309c = i3 + i;
            }
        }

        void e() {
            this.f3308a.clear();
            f();
            this.d = 0;
        }

        void f() {
            this.b = Integer.MIN_VALUE;
            this.f3309c = Integer.MIN_VALUE;
        }

        public int findFirstCompletelyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.d ? a(this.f3308a.size() - 1, -1, true) : a(0, this.f3308a.size(), true);
        }

        public int findFirstPartiallyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.d ? b(this.f3308a.size() - 1, -1, true) : b(0, this.f3308a.size(), true);
        }

        public int findFirstVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.d ? a(this.f3308a.size() - 1, -1, false) : a(0, this.f3308a.size(), false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.d ? a(0, this.f3308a.size(), true) : a(this.f3308a.size() - 1, -1, true);
        }

        public int findLastPartiallyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.d ? b(0, this.f3308a.size(), true) : b(this.f3308a.size() - 1, -1, true);
        }

        public int findLastVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.d ? a(0, this.f3308a.size(), false) : a(this.f3308a.size() - 1, -1, false);
        }

        void g() {
            int size = this.f3308a.size();
            View remove = this.f3308a.remove(size - 1);
            LayoutParams c2 = c(remove);
            c2.f3302a = null;
            if (c2.isItemRemoved() || c2.isItemChanged()) {
                this.d -= StaggeredGridLayoutManager.this.b.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.f3309c = Integer.MIN_VALUE;
        }

        public int getDeletedSize() {
            return this.d;
        }

        public View getFocusableViewAfter(int i, int i2) {
            View view;
            View view2 = null;
            if (i2 != -1) {
                int size = this.f3308a.size() - 1;
                View view3 = null;
                while (true) {
                    View view4 = view3;
                    view = view4;
                    if (size < 0) {
                        break;
                    }
                    View view5 = this.f3308a.get(size);
                    if (StaggeredGridLayoutManager.this.d) {
                        view = view4;
                        if (StaggeredGridLayoutManager.this.getPosition(view5) >= i) {
                            break;
                        }
                    }
                    if (!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.getPosition(view5) <= i) {
                        return view4;
                    }
                    view = view4;
                    if (!view5.hasFocusable()) {
                        break;
                    }
                    size--;
                    view3 = view5;
                }
            } else {
                int size2 = this.f3308a.size();
                int i3 = 0;
                while (true) {
                    view = view2;
                    if (i3 >= size2) {
                        break;
                    }
                    View view6 = this.f3308a.get(i3);
                    if (StaggeredGridLayoutManager.this.d) {
                        view = view2;
                        if (StaggeredGridLayoutManager.this.getPosition(view6) <= i) {
                            break;
                        }
                    }
                    if (!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.getPosition(view6) >= i) {
                        return view2;
                    }
                    view = view2;
                    if (!view6.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view2 = view6;
                }
            }
            return view;
        }

        void h() {
            View remove = this.f3308a.remove(0);
            LayoutParams c2 = c(remove);
            c2.f3302a = null;
            if (this.f3308a.size() == 0) {
                this.f3309c = Integer.MIN_VALUE;
            }
            if (c2.isItemRemoved() || c2.isItemChanged()) {
                this.d -= StaggeredGridLayoutManager.this.b.getDecoratedMeasurement(remove);
            }
            this.b = Integer.MIN_VALUE;
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.j = i2;
        setSpanCount(i);
        this.l = new LayoutState();
        i();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.l = new LayoutState();
        i();
    }

    private int a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int a(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        boolean z;
        Span span;
        int decoratedMeasurement;
        int i;
        int decoratedMeasurement2;
        int i2;
        this.m.set(0, this.i, true);
        int i3 = this.l.i ? layoutState.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : layoutState.e == 1 ? layoutState.g + layoutState.b : layoutState.f - layoutState.b;
        a(layoutState.e, i3);
        int endAfterPadding = this.e ? this.b.getEndAfterPadding() : this.b.getStartAfterPadding();
        boolean z2 = false;
        while (true) {
            z = z2;
            if (!layoutState.a(state) || (!this.l.i && this.m.isEmpty())) {
                break;
            }
            View a2 = layoutState.a(recycler);
            LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int c2 = this.h.c(viewLayoutPosition);
            boolean z3 = c2 == -1;
            if (z3) {
                span = layoutParams.b ? this.f3297a[0] : a(layoutState);
                this.h.a(viewLayoutPosition, span);
            } else {
                span = this.f3297a[c2];
            }
            layoutParams.f3302a = span;
            if (layoutState.e == 1) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
            a(a2, layoutParams, false);
            if (layoutState.e == 1) {
                int g = layoutParams.b ? g(endAfterPadding) : span.b(endAfterPadding);
                int decoratedMeasurement3 = this.b.getDecoratedMeasurement(a2);
                if (z3 && layoutParams.b) {
                    LazySpanLookup.FullSpanItem c3 = c(g);
                    c3.b = -1;
                    c3.f3304a = viewLayoutPosition;
                    this.h.addFullSpanItem(c3);
                }
                i = decoratedMeasurement3 + g;
                decoratedMeasurement = g;
            } else {
                int f = layoutParams.b ? f(endAfterPadding) : span.a(endAfterPadding);
                decoratedMeasurement = f - this.b.getDecoratedMeasurement(a2);
                if (z3 && layoutParams.b) {
                    LazySpanLookup.FullSpanItem d = d(f);
                    d.b = 1;
                    d.f3304a = viewLayoutPosition;
                    this.h.addFullSpanItem(d);
                }
                i = f;
            }
            if (layoutParams.b && layoutState.d == -1) {
                if (z3) {
                    this.u = true;
                } else {
                    if (!(layoutState.e == 1 ? e() : f())) {
                        LazySpanLookup.FullSpanItem fullSpanItem = this.h.getFullSpanItem(viewLayoutPosition);
                        if (fullSpanItem != null) {
                            fullSpanItem.d = true;
                        }
                        this.u = true;
                    }
                }
            }
            a(a2, layoutParams, layoutState);
            if (c() && this.j == 1) {
                int endAfterPadding2 = layoutParams.b ? this.f3298c.getEndAfterPadding() : this.f3298c.getEndAfterPadding() - (((this.i - 1) - span.e) * this.k);
                int decoratedMeasurement4 = this.f3298c.getDecoratedMeasurement(a2);
                int i4 = endAfterPadding2;
                i2 = endAfterPadding2 - decoratedMeasurement4;
                decoratedMeasurement2 = i4;
            } else {
                int startAfterPadding = layoutParams.b ? this.f3298c.getStartAfterPadding() : (span.e * this.k) + this.f3298c.getStartAfterPadding();
                decoratedMeasurement2 = this.f3298c.getDecoratedMeasurement(a2) + startAfterPadding;
                i2 = startAfterPadding;
            }
            if (this.j == 1) {
                layoutDecoratedWithMargins(a2, i2, decoratedMeasurement, decoratedMeasurement2, i);
            } else {
                layoutDecoratedWithMargins(a2, decoratedMeasurement, i2, i, decoratedMeasurement2);
            }
            if (layoutParams.b) {
                a(this.l.e, i3);
            } else {
                a(span, this.l.e, i3);
            }
            a(recycler, this.l);
            if (this.l.h && a2.hasFocusable()) {
                if (layoutParams.b) {
                    this.m.clear();
                } else {
                    this.m.set(span.e, false);
                }
            }
            z2 = true;
        }
        if (!z) {
            a(recycler, this.l);
        }
        int startAfterPadding2 = this.l.e == -1 ? this.b.getStartAfterPadding() - f(this.b.getStartAfterPadding()) : g(this.b.getEndAfterPadding()) - this.b.getEndAfterPadding();
        if (startAfterPadding2 > 0) {
            return Math.min(layoutState.b, startAfterPadding2);
        }
        return 0;
    }

    private int a(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.a(state, this.b, a(!this.v), b(!this.v), this, this.v, this.e);
    }

    private Span a(LayoutState layoutState) {
        int i;
        int i2;
        int i3 = -1;
        if (i(layoutState.e)) {
            i = this.i - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.i;
            i2 = 1;
        }
        int i4 = layoutState.e;
        Span span = null;
        if (i4 == 1) {
            int i5 = Integer.MAX_VALUE;
            int startAfterPadding = this.b.getStartAfterPadding();
            while (i != i3) {
                Span span2 = this.f3297a[i];
                int b = span2.b(startAfterPadding);
                int i6 = i5;
                if (b < i5) {
                    span = span2;
                    i6 = b;
                }
                i += i2;
                i5 = i6;
            }
            return span;
        }
        int i7 = Integer.MIN_VALUE;
        int endAfterPadding = this.b.getEndAfterPadding();
        Span span3 = null;
        while (i != i3) {
            Span span4 = this.f3297a[i];
            int a2 = span4.a(endAfterPadding);
            int i8 = i7;
            if (a2 > i7) {
                span3 = span4;
                i8 = a2;
            }
            i += i2;
            i7 = i8;
        }
        return span3;
    }

    private void a(int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.i) {
                return;
            }
            if (!this.f3297a[i4].f3308a.isEmpty()) {
                a(this.f3297a[i4], i, i2);
            }
            i3 = i4 + 1;
        }
    }

    private void a(View view) {
        int i = this.i;
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return;
            }
            this.f3297a[i2].b(view);
            i = i2;
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        calculateItemDecorationsForChild(view, this.s);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int a2 = a(i, layoutParams.leftMargin + this.s.left, layoutParams.rightMargin + this.s.right);
        int a3 = a(i2, layoutParams.topMargin + this.s.top, layoutParams.bottomMargin + this.s.bottom);
        if (z ? shouldReMeasureChild(view, a2, a3, layoutParams) : shouldMeasureChild(view, a2, a3, layoutParams)) {
            view.measure(a2, a3);
        }
    }

    private void a(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.e == 1) {
            if (layoutParams.b) {
                a(view);
            } else {
                layoutParams.f3302a.b(view);
            }
        } else if (layoutParams.b) {
            b(view);
        } else {
            layoutParams.f3302a.a(view);
        }
    }

    private void a(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.b) {
            if (this.j == 1) {
                a(view, this.r, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z);
            } else {
                a(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), this.r, z);
            }
        } else if (this.j == 1) {
            a(view, getChildMeasureSpec(this.k, getWidthMode(), 0, layoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z);
        } else {
            a(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), getChildMeasureSpec(this.k, getHeightMode(), 0, layoutParams.height, false), z);
        }
    }

    private void a(RecyclerView.Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.b.getDecoratedEnd(childAt) > i || this.b.getTransformedEndWithDecoration(childAt) > i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.b) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.i) {
                        for (int i4 = 0; i4 < this.i; i4++) {
                            this.f3297a[i4].h();
                        }
                    } else if (this.f3297a[i3].f3308a.size() == 1) {
                        return;
                    } else {
                        i2 = i3 + 1;
                    }
                }
            } else if (layoutParams.f3302a.f3308a.size() == 1) {
                return;
            } else {
                layoutParams.f3302a.h();
            }
            removeAndRecycleView(childAt, recycler);
        }
    }

    private void a(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (!layoutState.f3242a || layoutState.i) {
            return;
        }
        if (layoutState.b == 0) {
            if (layoutState.e == -1) {
                b(recycler, layoutState.g);
            } else {
                a(recycler, layoutState.f);
            }
        } else if (layoutState.e == -1) {
            int e = layoutState.f - e(layoutState.f);
            b(recycler, e < 0 ? layoutState.g : layoutState.g - Math.min(e, layoutState.b));
        } else {
            int h = h(layoutState.g) - layoutState.g;
            a(recycler, h < 0 ? layoutState.f : Math.min(h, layoutState.b) + layoutState.f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(androidx.recyclerview.widget.RecyclerView.Recycler r6, androidx.recyclerview.widget.RecyclerView.State r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 727
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    private void a(AnchorInfo anchorInfo) {
        if (this.q.f3307c > 0) {
            if (this.q.f3307c == this.i) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.i) {
                        break;
                    }
                    this.f3297a[i2].e();
                    int i3 = this.q.d[i2];
                    int i4 = i3;
                    if (i3 != Integer.MIN_VALUE) {
                        i4 = i3 + (this.q.i ? this.b.getEndAfterPadding() : this.b.getStartAfterPadding());
                    }
                    this.f3297a[i2].c(i4);
                    i = i2 + 1;
                }
            } else {
                this.q.a();
                SavedState savedState = this.q;
                savedState.f3306a = savedState.b;
            }
        }
        this.p = this.q.j;
        setReverseLayout(this.q.h);
        j();
        if (this.q.f3306a != -1) {
            this.f = this.q.f3306a;
            anchorInfo.f3301c = this.q.i;
        } else {
            anchorInfo.f3301c = this.e;
        }
        if (this.q.e > 1) {
            this.h.f3303a = this.q.f;
            this.h.b = this.q.g;
        }
    }

    private void a(Span span, int i, int i2) {
        int deletedSize = span.getDeletedSize();
        if (i == -1) {
            if (span.b() + deletedSize <= i2) {
                this.m.set(span.e, false);
            }
        } else if (span.d() - deletedSize >= i2) {
            this.m.set(span.e, false);
        }
    }

    private boolean a(Span span) {
        if (this.e) {
            if (span.d() < this.b.getEndAfterPadding()) {
                return !span.c(span.f3308a.get(span.f3308a.size() - 1)).b;
            }
            return false;
        } else if (span.b() > this.b.getStartAfterPadding()) {
            return !span.c(span.f3308a.get(0)).b;
        } else {
            return false;
        }
    }

    private int b(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.a(state, this.b, a(!this.v), b(!this.v), this, this.v);
    }

    private void b(int i) {
        this.l.e = i;
        this.l.d = this.e == (i == -1) ? 1 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r5, int r6, int r7) {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.e
            if (r0 == 0) goto L10
            r0 = r4
            int r0 = r0.g()
            r9 = r0
            goto L16
        L10:
            r0 = r4
            int r0 = r0.h()
            r9 = r0
        L16:
            r0 = r7
            r1 = 8
            if (r0 != r1) goto L34
            r0 = r5
            r1 = r6
            if (r0 >= r1) goto L29
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L39
        L29:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            r0 = r6
            r10 = r0
            goto L3c
        L34:
            r0 = r5
            r1 = r6
            int r0 = r0 + r1
            r8 = r0
        L39:
            r0 = r5
            r10 = r0
        L3c:
            r0 = r4
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r0 = r0.h
            r1 = r10
            int r0 = r0.b(r1)
            r0 = r7
            r1 = 1
            if (r0 == r1) goto L7a
            r0 = r7
            r1 = 2
            if (r0 == r1) goto L6e
            r0 = r7
            r1 = 8
            if (r0 == r1) goto L59
            goto L83
        L59:
            r0 = r4
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r0 = r0.h
            r1 = r5
            r2 = 1
            r0.a(r1, r2)
            r0 = r4
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r0 = r0.h
            r1 = r6
            r2 = 1
            r0.b(r1, r2)
            goto L83
        L6e:
            r0 = r4
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r0 = r0.h
            r1 = r5
            r2 = r6
            r0.a(r1, r2)
            goto L83
        L7a:
            r0 = r4
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r0 = r0.h
            r1 = r5
            r2 = r6
            r0.b(r1, r2)
        L83:
            r0 = r8
            r1 = r9
            if (r0 > r1) goto L8b
            return
        L8b:
            r0 = r4
            boolean r0 = r0.e
            if (r0 == 0) goto L9a
            r0 = r4
            int r0 = r0.h()
            r5 = r0
            goto L9f
        L9a:
            r0 = r4
            int r0 = r0.g()
            r5 = r0
        L9f:
            r0 = r10
            r1 = r5
            if (r0 > r1) goto La9
            r0 = r4
            r0.requestLayout()
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r5, androidx.recyclerview.widget.RecyclerView.State r6) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    private void b(View view) {
        int i = this.i;
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return;
            }
            this.f3297a[i2].a(view);
            i = i2;
        }
    }

    private void b(RecyclerView.Recycler recycler, int i) {
        int childCount = getChildCount();
        while (true) {
            int i2 = childCount - 1;
            if (i2 < 0) {
                return;
            }
            View childAt = getChildAt(i2);
            if (this.b.getDecoratedStart(childAt) < i || this.b.getTransformedStartWithDecoration(childAt) < i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.b) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= this.i) {
                        for (int i5 = 0; i5 < this.i; i5++) {
                            this.f3297a[i5].g();
                        }
                    } else if (this.f3297a[i4].f3308a.size() == 1) {
                        return;
                    } else {
                        i3 = i4 + 1;
                    }
                }
            } else if (layoutParams.f3302a.f3308a.size() == 1) {
                return;
            } else {
                layoutParams.f3302a.g();
            }
            removeAndRecycleView(childAt, recycler);
            childCount = i2;
        }
    }

    private void b(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int g = g(Integer.MIN_VALUE);
        if (g != Integer.MIN_VALUE && (endAfterPadding = this.b.getEndAfterPadding() - g) > 0) {
            int i = endAfterPadding - (-a(-endAfterPadding, recycler, state));
            if (!z || i <= 0) {
                return;
            }
            this.b.offsetChildren(i);
        }
    }

    private int c(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.b(state, this.b, a(!this.v), b(!this.v), this, this.v);
    }

    private LazySpanLookup.FullSpanItem c(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3305c = new int[this.i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.i) {
                return fullSpanItem;
            }
            fullSpanItem.f3305c[i3] = i - this.f3297a[i3].b(i);
            i2 = i3 + 1;
        }
    }

    private void c(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int f = f(Integer.MAX_VALUE);
        if (f != Integer.MAX_VALUE && (startAfterPadding = f - this.b.getStartAfterPadding()) > 0) {
            int a2 = startAfterPadding - a(startAfterPadding, recycler, state);
            if (!z || a2 <= 0) {
                return;
            }
            this.b.offsetChildren(-a2);
        }
    }

    private boolean c(RecyclerView.State state, AnchorInfo anchorInfo) {
        anchorInfo.f3300a = this.o ? l(state.getItemCount()) : k(state.getItemCount());
        anchorInfo.b = Integer.MIN_VALUE;
        return true;
    }

    private LazySpanLookup.FullSpanItem d(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3305c = new int[this.i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.i) {
                return fullSpanItem;
            }
            fullSpanItem.f3305c[i3] = this.f3297a[i3].a(i) - i;
            i2 = i3 + 1;
        }
    }

    private int e(int i) {
        int a2 = this.f3297a[0].a(i);
        int i2 = 1;
        while (i2 < this.i) {
            int a3 = this.f3297a[i2].a(i);
            int i3 = a2;
            if (a3 > a2) {
                i3 = a3;
            }
            i2++;
            a2 = i3;
        }
        return a2;
    }

    private int f(int i) {
        int a2 = this.f3297a[0].a(i);
        int i2 = 1;
        while (i2 < this.i) {
            int a3 = this.f3297a[i2].a(i);
            int i3 = a2;
            if (a3 < a2) {
                i3 = a3;
            }
            i2++;
            a2 = i3;
        }
        return a2;
    }

    private int g(int i) {
        int b = this.f3297a[0].b(i);
        int i2 = 1;
        while (i2 < this.i) {
            int b2 = this.f3297a[i2].b(i);
            int i3 = b;
            if (b2 > b) {
                i3 = b2;
            }
            i2++;
            b = i3;
        }
        return b;
    }

    private int h(int i) {
        int b = this.f3297a[0].b(i);
        int i2 = 1;
        while (i2 < this.i) {
            int b2 = this.f3297a[i2].b(i);
            int i3 = b;
            if (b2 < b) {
                i3 = b2;
            }
            i2++;
            b = i3;
        }
        return b;
    }

    private void i() {
        this.b = OrientationHelper.createOrientationHelper(this, this.j);
        this.f3298c = OrientationHelper.createOrientationHelper(this, 1 - this.j);
    }

    private boolean i(int i) {
        if (this.j == 0) {
            return (i == -1) != this.e;
        }
        return ((i == -1) == this.e) == c();
    }

    private int j(int i) {
        if (getChildCount() != 0) {
            return (i < h()) != this.e ? -1 : 1;
        }
        int i2 = -1;
        if (this.e) {
            i2 = 1;
        }
        return i2;
    }

    private void j() {
        if (this.j == 1 || !c()) {
            this.e = this.d;
        } else {
            this.e = !this.d;
        }
    }

    private int k(int i) {
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return 0;
            }
            int position = getPosition(getChildAt(i3));
            if (position >= 0 && position < i) {
                return position;
            }
            i2 = i3 + 1;
        }
    }

    private void k() {
        if (this.f3298c.getMode() == 1073741824) {
            return;
        }
        float f = 0.0f;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            float decoratedMeasurement = this.f3298c.getDecoratedMeasurement(childAt);
            if (decoratedMeasurement >= f) {
                float f2 = decoratedMeasurement;
                if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                    f2 = (decoratedMeasurement * 1.0f) / this.i;
                }
                f = Math.max(f, f2);
            }
            i = i2 + 1;
        }
        int i3 = this.k;
        int round = Math.round(f * this.i);
        int i4 = round;
        if (this.f3298c.getMode() == Integer.MIN_VALUE) {
            i4 = Math.min(round, this.f3298c.getTotalSpace());
        }
        a(i4);
        if (this.k == i3) {
            return;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt2 = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (!layoutParams.b) {
                if (c() && this.j == 1) {
                    childAt2.offsetLeftAndRight(((-((this.i - 1) - layoutParams.f3302a.e)) * this.k) - ((-((this.i - 1) - layoutParams.f3302a.e)) * i3));
                } else {
                    int i6 = layoutParams.f3302a.e * this.k;
                    int i7 = layoutParams.f3302a.e * i3;
                    if (this.j == 1) {
                        childAt2.offsetLeftAndRight(i6 - i7);
                    } else {
                        childAt2.offsetTopAndBottom(i6 - i7);
                    }
                }
            }
        }
    }

    private int l(int i) {
        int childCount = getChildCount();
        while (true) {
            int i2 = childCount - 1;
            if (i2 < 0) {
                return 0;
            }
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
            childCount = i2;
        }
    }

    private int m(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.j == 1) ? 1 : Integer.MIN_VALUE : this.j == 0 ? 1 : Integer.MIN_VALUE : this.j == 1 ? -1 : Integer.MIN_VALUE : this.j == 0 ? -1 : Integer.MIN_VALUE : (this.j != 1 && c()) ? -1 : 1 : (this.j != 1 && c()) ? 1 : -1;
    }

    int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        a(i, state);
        int a2 = a(recycler, this.l, state);
        if (this.l.b >= a2) {
            i = i < 0 ? -a2 : a2;
        }
        this.b.offsetChildren(-i);
        this.o = this.e;
        this.l.b = 0;
        a(recycler, this.l);
        return i;
    }

    View a(boolean z) {
        int startAfterPadding = this.b.getStartAfterPadding();
        int endAfterPadding = this.b.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            int decoratedStart = this.b.getDecoratedStart(childAt);
            View view2 = view;
            if (this.b.getDecoratedEnd(childAt) > startAfterPadding) {
                if (decoratedStart < endAfterPadding) {
                    if (decoratedStart < startAfterPadding && z) {
                        view2 = view;
                        if (view == null) {
                            view2 = childAt;
                        }
                    }
                    return childAt;
                }
                view2 = view;
            }
            i++;
            view = view2;
        }
        return view;
    }

    void a(int i) {
        this.k = i / this.i;
        this.r = View.MeasureSpec.makeMeasureSpec(i, this.f3298c.getMode());
    }

    void a(int i, RecyclerView.State state) {
        int h;
        int i2;
        if (i > 0) {
            h = g();
            i2 = 1;
        } else {
            h = h();
            i2 = -1;
        }
        this.l.f3242a = true;
        b(h, state);
        b(i2);
        LayoutState layoutState = this.l;
        layoutState.f3243c = h + layoutState.d;
        this.l.b = Math.abs(i);
    }

    void a(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (b(state, anchorInfo) || c(state, anchorInfo)) {
            return;
        }
        anchorInfo.b();
        anchorInfo.f3300a = 0;
    }

    boolean a() {
        int h;
        int g;
        if (getChildCount() == 0 || this.n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.e) {
            h = g();
            g = h();
        } else {
            h = h();
            g = g();
        }
        if (h == 0 && b() != null) {
            this.h.a();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (this.u) {
            int i = this.e ? -1 : 1;
            int i2 = g + 1;
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange = this.h.getFirstFullSpanItemInRange(h, i2, i, true);
            if (firstFullSpanItemInRange == null) {
                this.u = false;
                this.h.a(i2);
                return false;
            }
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange2 = this.h.getFirstFullSpanItemInRange(h, firstFullSpanItemInRange.f3304a, i * (-1), true);
            if (firstFullSpanItemInRange2 == null) {
                this.h.a(firstFullSpanItemInRange.f3304a);
            } else {
                this.h.a(firstFullSpanItemInRange2.f3304a + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e3, code lost:
        if (r0 == r0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010a, code lost:
        if (r0 == r0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x010d, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0112, code lost:
        r6 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.view.View b() {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b():android.view.View");
    }

    View b(boolean z) {
        int startAfterPadding = this.b.getStartAfterPadding();
        int endAfterPadding = this.b.getEndAfterPadding();
        int childCount = getChildCount() - 1;
        View view = null;
        while (true) {
            View view2 = view;
            if (childCount < 0) {
                return view2;
            }
            View childAt = getChildAt(childCount);
            int decoratedStart = this.b.getDecoratedStart(childAt);
            int decoratedEnd = this.b.getDecoratedEnd(childAt);
            View view3 = view2;
            if (decoratedEnd > startAfterPadding) {
                if (decoratedStart < endAfterPadding) {
                    if (decoratedEnd > endAfterPadding && z) {
                        view3 = view2;
                        if (view2 == null) {
                            view3 = childAt;
                        }
                    }
                    return childAt;
                }
                view3 = view2;
            }
            childCount--;
            view = view3;
        }
    }

    boolean b(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i;
        boolean z = false;
        if (state.isPreLayout() || (i = this.f) == -1) {
            return false;
        }
        if (i < 0 || i >= state.getItemCount()) {
            this.f = -1;
            this.g = Integer.MIN_VALUE;
            return false;
        }
        SavedState savedState = this.q;
        if (savedState != null && savedState.f3306a != -1 && this.q.f3307c >= 1) {
            anchorInfo.b = Integer.MIN_VALUE;
            anchorInfo.f3300a = this.f;
            return true;
        }
        View findViewByPosition = findViewByPosition(this.f);
        if (findViewByPosition == null) {
            anchorInfo.f3300a = this.f;
            int i2 = this.g;
            if (i2 == Integer.MIN_VALUE) {
                if (j(anchorInfo.f3300a) == 1) {
                    z = true;
                }
                anchorInfo.f3301c = z;
                anchorInfo.b();
            } else {
                anchorInfo.a(i2);
            }
            anchorInfo.d = true;
            return true;
        }
        anchorInfo.f3300a = this.e ? g() : h();
        if (this.g != Integer.MIN_VALUE) {
            if (anchorInfo.f3301c) {
                anchorInfo.b = (this.b.getEndAfterPadding() - this.g) - this.b.getDecoratedEnd(findViewByPosition);
                return true;
            }
            anchorInfo.b = (this.b.getStartAfterPadding() + this.g) - this.b.getDecoratedStart(findViewByPosition);
            return true;
        } else if (this.b.getDecoratedMeasurement(findViewByPosition) > this.b.getTotalSpace()) {
            anchorInfo.b = anchorInfo.f3301c ? this.b.getEndAfterPadding() : this.b.getStartAfterPadding();
            return true;
        } else {
            int decoratedStart = this.b.getDecoratedStart(findViewByPosition) - this.b.getStartAfterPadding();
            if (decoratedStart < 0) {
                anchorInfo.b = -decoratedStart;
                return true;
            }
            int endAfterPadding = this.b.getEndAfterPadding() - this.b.getDecoratedEnd(findViewByPosition);
            if (endAfterPadding < 0) {
                anchorInfo.b = endAfterPadding;
                return true;
            }
            anchorInfo.b = Integer.MIN_VALUE;
            return true;
        }
    }

    boolean c() {
        return getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.j == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.j == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i3;
        int b;
        int i4;
        if (this.j != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        a(i, state);
        int[] iArr = this.w;
        if (iArr == null || iArr.length < this.i) {
            this.w = new int[this.i];
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i3 = i6;
            if (i5 >= this.i) {
                break;
            }
            if (this.l.d == -1) {
                b = this.l.f;
                i4 = this.f3297a[i5].a(this.l.f);
            } else {
                b = this.f3297a[i5].b(this.l.g);
                i4 = this.l.g;
            }
            int i7 = b - i4;
            int i8 = i3;
            if (i7 >= 0) {
                this.w[i3] = i7;
                i8 = i3 + 1;
            }
            i5++;
            i6 = i8;
        }
        Arrays.sort(this.w, 0, i3);
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= i3 || !this.l.a(state)) {
                return;
            }
            layoutPrefetchRegistry.addPosition(this.l.f3243c, this.w[i10]);
            this.l.f3243c += this.l.d;
            i9 = i10 + 1;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return b(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return a(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return c(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        int j = j(i);
        PointF pointF = new PointF();
        if (j == 0) {
            return null;
        }
        if (this.j == 0) {
            pointF.x = j;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = j;
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return b(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return a(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return c(state);
    }

    int d() {
        View b = this.e ? b(true) : a(true);
        if (b == null) {
            return -1;
        }
        return getPosition(b);
    }

    boolean e() {
        int b = this.f3297a[0].b(Integer.MIN_VALUE);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.i) {
                return true;
            }
            if (this.f3297a[i2].b(Integer.MIN_VALUE) != b) {
                return false;
            }
            i = i2 + 1;
        }
    }

    boolean f() {
        int a2 = this.f3297a[0].a(Integer.MIN_VALUE);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.i) {
                return true;
            }
            if (this.f3297a[i2].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.i];
        } else if (iArr.length < this.i) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.i + ", array size:" + iArr.length);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.i) {
                return iArr;
            }
            iArr[i2] = this.f3297a[i2].findFirstCompletelyVisibleItemPosition();
            i = i2 + 1;
        }
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.i];
        } else if (iArr.length < this.i) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.i + ", array size:" + iArr.length);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.i) {
                return iArr;
            }
            iArr[i2] = this.f3297a[i2].findFirstVisibleItemPosition();
            i = i2 + 1;
        }
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.i];
        } else if (iArr.length < this.i) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.i + ", array size:" + iArr.length);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.i) {
                return iArr;
            }
            iArr[i2] = this.f3297a[i2].findLastCompletelyVisibleItemPosition();
            i = i2 + 1;
        }
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.i];
        } else if (iArr.length < this.i) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.i + ", array size:" + iArr.length);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.i) {
                return iArr;
            }
            iArr[i2] = this.f3297a[i2].findLastVisibleItemPosition();
            i = i2 + 1;
        }
    }

    int g() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.j == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.j == 1 ? this.i : super.getColumnCountForAccessibility(recycler, state);
    }

    public int getGapStrategy() {
        return this.n;
    }

    public int getOrientation() {
        return this.j;
    }

    public boolean getReverseLayout() {
        return this.d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.j == 0 ? this.i : super.getRowCountForAccessibility(recycler, state);
    }

    public int getSpanCount() {
        return this.i;
    }

    int h() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public void invalidateSpanAssignments() {
        this.h.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return this.n != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.i) {
                return;
            }
            this.f3297a[i3].d(i);
            i2 = i3 + 1;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.i) {
                return;
            }
            this.f3297a[i3].d(i);
            i2 = i3 + 1;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.x);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.i) {
                recyclerView.requestLayout();
                return;
            } else {
                this.f3297a[i2].e();
                i = i2 + 1;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        View focusableViewAfter;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        j();
        int m = m(i);
        if (m == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z = layoutParams.b;
        Span span = layoutParams.f3302a;
        int g = m == 1 ? g() : h();
        b(g, state);
        b(m);
        LayoutState layoutState = this.l;
        layoutState.f3243c = layoutState.d + g;
        this.l.b = (int) (this.b.getTotalSpace() * 0.33333334f);
        this.l.h = true;
        this.l.f3242a = false;
        a(recycler, this.l, state);
        this.o = this.e;
        if (!z && (focusableViewAfter = span.getFocusableViewAfter(g, m)) != null && focusableViewAfter != findContainingItemView) {
            return focusableViewAfter;
        }
        if (!i(m)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.i) {
                    break;
                }
                View focusableViewAfter2 = this.f3297a[i3].getFocusableViewAfter(g, m);
                if (focusableViewAfter2 != null && focusableViewAfter2 != findContainingItemView) {
                    return focusableViewAfter2;
                }
                i2 = i3 + 1;
            }
        } else {
            int i4 = this.i;
            while (true) {
                int i5 = i4 - 1;
                if (i5 < 0) {
                    break;
                }
                View focusableViewAfter3 = this.f3297a[i5].getFocusableViewAfter(g, m);
                if (focusableViewAfter3 != null && focusableViewAfter3 != findContainingItemView) {
                    return focusableViewAfter3;
                }
                i4 = i5;
            }
        }
        boolean z2 = (this.d ^ true) == (m == -1);
        if (!z) {
            View findViewByPosition = findViewByPosition(z2 ? span.findFirstPartiallyVisibleItemPosition() : span.findLastPartiallyVisibleItemPosition());
            if (findViewByPosition != null && findViewByPosition != findContainingItemView) {
                return findViewByPosition;
            }
        }
        if (!i(m)) {
            for (int i6 = 0; i6 < this.i; i6++) {
                View findViewByPosition2 = findViewByPosition(z2 ? this.f3297a[i6].findFirstPartiallyVisibleItemPosition() : this.f3297a[i6].findLastPartiallyVisibleItemPosition());
                if (findViewByPosition2 != null && findViewByPosition2 != findContainingItemView) {
                    return findViewByPosition2;
                }
            }
            return null;
        }
        int i7 = this.i;
        while (true) {
            int i8 = i7 - 1;
            if (i8 < 0) {
                return null;
            }
            if (i8 != span.e) {
                View findViewByPosition3 = findViewByPosition(z2 ? this.f3297a[i8].findFirstPartiallyVisibleItemPosition() : this.f3297a[i8].findLastPartiallyVisibleItemPosition());
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
            i7 = i8;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View a2 = a(false);
            View b = b(false);
            if (a2 == null || b == null) {
                return;
            }
            int position = getPosition(a2);
            int position2 = getPosition(b);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
                return;
            }
            accessibilityEvent.setFromIndex(position2);
            accessibilityEvent.setToIndex(position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.j == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.b ? this.i : 1, -1, -1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, layoutParams2.getSpanIndex(), layoutParams2.b ? this.i : 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        b(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.h.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        b(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        b(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        b(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        a(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.q = null;
        this.t.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.q = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        int a2;
        int i;
        int startAfterPadding;
        SavedState savedState = this.q;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.h = this.d;
        savedState2.i = this.o;
        savedState2.j = this.p;
        LazySpanLookup lazySpanLookup = this.h;
        if (lazySpanLookup == null || lazySpanLookup.f3303a == null) {
            savedState2.e = 0;
        } else {
            savedState2.f = this.h.f3303a;
            savedState2.e = savedState2.f.length;
            savedState2.g = this.h.b;
        }
        if (getChildCount() > 0) {
            savedState2.f3306a = this.o ? g() : h();
            savedState2.b = d();
            savedState2.f3307c = this.i;
            savedState2.d = new int[this.i];
            for (int i2 = 0; i2 < this.i; i2++) {
                if (this.o) {
                    a2 = this.f3297a[i2].b(Integer.MIN_VALUE);
                    i = a2;
                    if (a2 != Integer.MIN_VALUE) {
                        startAfterPadding = this.b.getEndAfterPadding();
                        i = a2 - startAfterPadding;
                        savedState2.d[i2] = i;
                    } else {
                        savedState2.d[i2] = i;
                    }
                } else {
                    a2 = this.f3297a[i2].a(Integer.MIN_VALUE);
                    i = a2;
                    if (a2 != Integer.MIN_VALUE) {
                        startAfterPadding = this.b.getStartAfterPadding();
                        i = a2 - startAfterPadding;
                        savedState2.d[i2] = i;
                    } else {
                        savedState2.d[i2] = i;
                    }
                }
            }
        } else {
            savedState2.f3306a = -1;
            savedState2.b = -1;
            savedState2.f3307c = 0;
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        SavedState savedState = this.q;
        if (savedState != null && savedState.f3306a != i) {
            this.q.b();
        }
        this.f = i;
        this.g = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        SavedState savedState = this.q;
        if (savedState != null) {
            savedState.b();
        }
        this.f = i;
        this.g = i2;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(i, recycler, state);
    }

    public void setGapStrategy(int i) {
        assertNotInLayoutOrScroll(null);
        if (i == this.n) {
            return;
        }
        if (i != 0 && i != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.n = i;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.j == 1) {
            int chooseSize = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int chooseSize2 = chooseSize(i, (this.k * this.i) + paddingLeft, getMinimumWidth());
            i4 = chooseSize;
            i3 = chooseSize2;
        } else {
            int chooseSize3 = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            int chooseSize4 = chooseSize(i2, (this.k * this.i) + paddingTop, getMinimumHeight());
            i3 = chooseSize3;
            i4 = chooseSize4;
        }
        setMeasuredDimension(i3, i4);
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i == this.j) {
            return;
        }
        this.j = i;
        OrientationHelper orientationHelper = this.b;
        this.b = this.f3298c;
        this.f3298c = orientationHelper;
        requestLayout();
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.q;
        if (savedState != null && savedState.h != z) {
            this.q.h = z;
        }
        this.d = z;
        requestLayout();
    }

    public void setSpanCount(int i) {
        assertNotInLayoutOrScroll(null);
        if (i == this.i) {
            return;
        }
        invalidateSpanAssignments();
        this.i = i;
        this.m = new BitSet(this.i);
        this.f3297a = new Span[this.i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.i) {
                requestLayout();
                return;
            } else {
                this.f3297a[i3] = new Span(i3);
                i2 = i3 + 1;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.q == null;
    }
}
