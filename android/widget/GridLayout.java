package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RemoteViews;
import com.android.internal.R;
import com.android.internal.content.NativeLibraryHelper;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RemoteViews.RemoteView
/* loaded from: source-4181928-dex2jar.jar:android/widget/GridLayout.class */
public class GridLayout extends ViewGroup {
    private static final int ALIGNMENT_MODE = 6;
    public static final int ALIGN_BOUNDS = 0;
    public static final int ALIGN_MARGINS = 1;
    private static final int CAN_STRETCH = 2;
    private static final int COLUMN_COUNT = 3;
    private static final int COLUMN_ORDER_PRESERVED = 4;
    private static final int DEFAULT_ALIGNMENT_MODE = 1;
    static final int DEFAULT_CONTAINER_MARGIN = 0;
    private static final int DEFAULT_COUNT = Integer.MIN_VALUE;
    private static final boolean DEFAULT_ORDER_PRESERVED = true;
    private static final int DEFAULT_ORIENTATION = 0;
    private static final boolean DEFAULT_USE_DEFAULT_MARGINS = false;
    public static final int HORIZONTAL = 0;
    private static final int INFLEXIBLE = 0;
    static final int MAX_SIZE = 100000;
    private static final int ORIENTATION = 0;
    private static final int ROW_COUNT = 1;
    private static final int ROW_ORDER_PRESERVED = 2;
    public static final int UNDEFINED = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH = 0;
    private static final int USE_DEFAULT_MARGINS = 5;
    public static final int VERTICAL = 1;
    int mAlignmentMode;
    int mDefaultGap;
    final Axis mHorizontalAxis;
    int mLastLayoutParamsHashCode;
    int mOrientation;
    Printer mPrinter;
    boolean mUseDefaultMargins;
    final Axis mVerticalAxis;
    static final Printer LOG_PRINTER = new LogPrinter(3, GridLayout.class.getName());
    static final Printer NO_PRINTER = new Printer() { // from class: android.widget.GridLayout.1
        @Override // android.util.Printer
        public void println(String str) {
        }
    };
    static final Alignment UNDEFINED_ALIGNMENT = new Alignment() { // from class: android.widget.GridLayout.2
        @Override // android.widget.GridLayout.Alignment
        public int getAlignmentValue(View view, int i, int i2) {
            return Integer.MIN_VALUE;
        }

        @Override // android.widget.GridLayout.Alignment
        int getGravityOffset(View view, int i) {
            return Integer.MIN_VALUE;
        }
    };
    private static final Alignment LEADING = new Alignment() { // from class: android.widget.GridLayout.3
        @Override // android.widget.GridLayout.Alignment
        public int getAlignmentValue(View view, int i, int i2) {
            return 0;
        }

        @Override // android.widget.GridLayout.Alignment
        int getGravityOffset(View view, int i) {
            return 0;
        }
    };
    private static final Alignment TRAILING = new Alignment() { // from class: android.widget.GridLayout.4
        @Override // android.widget.GridLayout.Alignment
        public int getAlignmentValue(View view, int i, int i2) {
            return i;
        }

        @Override // android.widget.GridLayout.Alignment
        int getGravityOffset(View view, int i) {
            return i;
        }
    };
    public static final Alignment TOP = LEADING;
    public static final Alignment BOTTOM = TRAILING;
    public static final Alignment START = LEADING;
    public static final Alignment END = TRAILING;
    public static final Alignment LEFT = createSwitchingAlignment(START, END);
    public static final Alignment RIGHT = createSwitchingAlignment(END, START);
    public static final Alignment CENTER = new Alignment() { // from class: android.widget.GridLayout.6
        @Override // android.widget.GridLayout.Alignment
        public int getAlignmentValue(View view, int i, int i2) {
            return i >> 1;
        }

        @Override // android.widget.GridLayout.Alignment
        int getGravityOffset(View view, int i) {
            return i >> 1;
        }
    };
    public static final Alignment BASELINE = new Alignment() { // from class: android.widget.GridLayout.7
        @Override // android.widget.GridLayout.Alignment
        public int getAlignmentValue(View view, int i, int i2) {
            int i3;
            if (view.getVisibility() == 8) {
                i3 = 0;
            } else {
                int baseline = view.getBaseline();
                i3 = baseline;
                if (baseline == -1) {
                    return Integer.MIN_VALUE;
                }
            }
            return i3;
        }

        @Override // android.widget.GridLayout.Alignment
        public Bounds getBounds() {
            return new Bounds() { // from class: android.widget.GridLayout.7.1
                private int size;

                @Override // android.widget.GridLayout.Bounds
                protected int getOffset(GridLayout gridLayout, View view, Alignment alignment, int i, boolean z) {
                    return Math.max(0, super.getOffset(gridLayout, view, alignment, i, z));
                }

                @Override // android.widget.GridLayout.Bounds
                protected void include(int i, int i2) {
                    super.include(i, i2);
                    this.size = Math.max(this.size, i + i2);
                }

                @Override // android.widget.GridLayout.Bounds
                protected void reset() {
                    super.reset();
                    this.size = Integer.MIN_VALUE;
                }

                @Override // android.widget.GridLayout.Bounds
                protected int size(boolean z) {
                    return Math.max(super.size(z), this.size);
                }
            };
        }

        @Override // android.widget.GridLayout.Alignment
        int getGravityOffset(View view, int i) {
            return 0;
        }
    };
    public static final Alignment FILL = new Alignment() { // from class: android.widget.GridLayout.8
        @Override // android.widget.GridLayout.Alignment
        public int getAlignmentValue(View view, int i, int i2) {
            return Integer.MIN_VALUE;
        }

        @Override // android.widget.GridLayout.Alignment
        int getGravityOffset(View view, int i) {
            return 0;
        }

        @Override // android.widget.GridLayout.Alignment
        public int getSizeInCell(View view, int i, int i2) {
            return i2;
        }
    };

    /* loaded from: source-4181928-dex2jar.jar:android/widget/GridLayout$Alignment.class */
    public static abstract class Alignment {
        Alignment() {
        }

        abstract int getAlignmentValue(View view, int i, int i2);

        Bounds getBounds() {
            return new Bounds();
        }

        abstract int getGravityOffset(View view, int i);

        int getSizeInCell(View view, int i, int i2) {
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/GridLayout$Arc.class */
    public static final class Arc {
        public final Interval span;
        public boolean valid = true;
        public final MutableInt value;

        public Arc(Interval interval, MutableInt mutableInt) {
            this.span = interval;
            this.value = mutableInt;
        }

        public String toString() {
            return this.span + " " + (!this.valid ? "+>" : "->") + " " + this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/GridLayout$Assoc.class */
    public static final class Assoc<K, V> extends ArrayList<Pair<K, V>> {
        private final Class<K> keyType;
        private final Class<V> valueType;

        private Assoc(Class<K> cls, Class<V> cls2) {
            this.keyType = cls;
            this.valueType = cls2;
        }

        public static <K, V> Assoc<K, V> of(Class<K> cls, Class<V> cls2) {
            return new Assoc<>(cls, cls2);
        }

        public PackedMap<K, V> pack() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance((Class<?>) this.keyType, size);
            Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) this.valueType, size);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return new PackedMap<>(objArr, objArr2);
                }
                objArr[i2] = get(i2).first;
                objArr2[i2] = get(i2).second;
                i = i2 + 1;
            }
        }

        public void put(K k, V v) {
            add(Pair.create(k, v));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/GridLayout$Axis.class */
    public final class Axis {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final int COMPLETE = 2;
        private static final int NEW = 0;
        private static final int PENDING = 1;
        public Arc[] arcs;
        public boolean arcsValid;
        PackedMap<Interval, MutableInt> backwardLinks;
        public boolean backwardLinksValid;
        public int definedCount;
        public int[] deltas;
        PackedMap<Interval, MutableInt> forwardLinks;
        public boolean forwardLinksValid;
        PackedMap<Spec, Bounds> groupBounds;
        public boolean groupBoundsValid;
        public boolean hasWeights;
        public boolean hasWeightsValid;
        public final boolean horizontal;
        public int[] leadingMargins;
        public boolean leadingMarginsValid;
        public int[] locations;
        public boolean locationsValid;
        private int maxIndex;
        boolean orderPreserved;
        public int[] originalMeasurements;
        private MutableInt parentMax;
        private MutableInt parentMin;
        public int[] trailingMargins;
        public boolean trailingMarginsValid;

        static {
            $assertionsDisabled = !GridLayout.class.desiredAssertionStatus();
        }

        private Axis(boolean z) {
            this.definedCount = Integer.MIN_VALUE;
            this.maxIndex = Integer.MIN_VALUE;
            this.groupBoundsValid = false;
            this.forwardLinksValid = false;
            this.backwardLinksValid = false;
            this.leadingMarginsValid = false;
            this.trailingMarginsValid = false;
            this.arcsValid = false;
            this.locationsValid = false;
            this.hasWeightsValid = false;
            this.orderPreserved = true;
            this.parentMin = new MutableInt(0);
            this.parentMax = new MutableInt(-100000);
            this.horizontal = z;
        }

        private void addComponentSizes(List<Arc> list, PackedMap<Interval, MutableInt> packedMap) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= packedMap.keys.length) {
                    return;
                }
                include(list, packedMap.keys[i2], packedMap.values[i2], false);
                i = i2 + 1;
            }
        }

        private String arcsToString(List<Arc> list) {
            int i;
            String str = this.horizontal ? "x" : "y";
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            StringBuilder sb2 = sb;
            for (Arc arc : list) {
                if (z) {
                    z = false;
                } else {
                    sb2 = sb2.append(", ");
                }
                int i2 = arc.span.min;
                int i3 = arc.span.max;
                sb2.append(i2 < i3 ? str + i3 + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + str + i2 + ">=" + arc.value.value : str + i2 + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + str + i3 + "<=" + (-i));
            }
            return sb2.toString();
        }

        private int calculateMaxIndex() {
            int i = -1;
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i2));
                Interval interval = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                i = Math.max(Math.max(Math.max(i, interval.min), interval.max), interval.size());
            }
            int i3 = i;
            if (i == -1) {
                i3 = Integer.MIN_VALUE;
            }
            return i3;
        }

        private float calculateTotalWeight() {
            float f = 0.0f;
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i));
                f += (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
            }
            return f;
        }

        private void computeArcs() {
            getForwardLinks();
            getBackwardLinks();
        }

        private void computeGroupBounds() {
            Bounds[] boundsArr = this.groupBounds.values;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= boundsArr.length) {
                    break;
                }
                boundsArr[i2].reset();
                i = i2 + 1;
            }
            int childCount = GridLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = GridLayout.this.getChildAt(i3);
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                Spec spec = this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec;
                this.groupBounds.getValue(i3).include(GridLayout.this, childAt, spec, this, spec.weight == 0.0f ? GridLayout.this.getMeasurementIncludingMargin(childAt, this.horizontal) : getOriginalMeasurements()[i3] + getDeltas()[i3]);
            }
        }

        private boolean computeHasWeights() {
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i));
                if ((this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight != 0.0f) {
                    return true;
                }
            }
            return false;
        }

        private void computeLinks(PackedMap<Interval, MutableInt> packedMap, boolean z) {
            MutableInt[] mutableIntArr = packedMap.values;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mutableIntArr.length) {
                    break;
                }
                mutableIntArr[i2].reset();
                i = i2 + 1;
            }
            Bounds[] boundsArr = getGroupBounds().values;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= boundsArr.length) {
                    return;
                }
                int size = boundsArr[i4].size(z);
                MutableInt value = packedMap.getValue(i4);
                int i5 = value.value;
                if (!z) {
                    size = -size;
                }
                value.value = Math.max(i5, size);
                i3 = i4 + 1;
            }
        }

        private void computeLocations(int[] iArr) {
            if (hasWeights()) {
                solveAndDistributeSpace(iArr);
            } else {
                solve(iArr);
            }
            if (this.orderPreserved) {
                return;
            }
            int i = iArr[0];
            int length = iArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = iArr[i2] - i;
            }
        }

        private void computeMargins(boolean z) {
            int[] iArr = z ? this.leadingMargins : this.trailingMargins;
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    Interval interval = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                    int i2 = z ? interval.min : interval.max;
                    iArr[i2] = Math.max(iArr[i2], GridLayout.this.getMargin1(childAt, this.horizontal, z));
                }
            }
        }

        private Arc[] createArcs() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            addComponentSizes(arrayList, getForwardLinks());
            addComponentSizes(arrayList2, getBackwardLinks());
            if (this.orderPreserved) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= getCount()) {
                        break;
                    }
                    include(arrayList, new Interval(i2, i2 + 1), new MutableInt(0));
                    i = i2 + 1;
                }
            }
            int count = getCount();
            include(arrayList, new Interval(0, count), this.parentMin, false);
            include(arrayList2, new Interval(count, 0), this.parentMax, false);
            return (Arc[]) GridLayout.append(topologicalSort(arrayList), topologicalSort(arrayList2));
        }

        private PackedMap<Spec, Bounds> createGroupBounds() {
            Assoc of = Assoc.of(Spec.class, Bounds.class);
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i));
                Spec spec = this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec;
                of.put(spec, GridLayout.this.getAlignment(spec.alignment, this.horizontal).getBounds());
            }
            return of.pack();
        }

        private PackedMap<Interval, MutableInt> createLinks(boolean z) {
            Assoc of = Assoc.of(Interval.class, MutableInt.class);
            Spec[] specArr = getGroupBounds().keys;
            int length = specArr.length;
            for (int i = 0; i < length; i++) {
                of.put(z ? specArr[i].span : specArr[i].span.inverse(), new MutableInt());
            }
            return of.pack();
        }

        private PackedMap<Interval, MutableInt> getBackwardLinks() {
            if (this.backwardLinks == null) {
                this.backwardLinks = createLinks(false);
            }
            if (!this.backwardLinksValid) {
                computeLinks(this.backwardLinks, false);
                this.backwardLinksValid = true;
            }
            return this.backwardLinks;
        }

        private PackedMap<Interval, MutableInt> getForwardLinks() {
            if (this.forwardLinks == null) {
                this.forwardLinks = createLinks(true);
            }
            if (!this.forwardLinksValid) {
                computeLinks(this.forwardLinks, true);
                this.forwardLinksValid = true;
            }
            return this.forwardLinks;
        }

        private int getMaxIndex() {
            if (this.maxIndex == Integer.MIN_VALUE) {
                this.maxIndex = Math.max(0, calculateMaxIndex());
            }
            return this.maxIndex;
        }

        private int getMeasure(int i, int i2) {
            setParentConstraints(i, i2);
            return size(getLocations());
        }

        private boolean hasWeights() {
            if (!this.hasWeightsValid) {
                this.hasWeights = computeHasWeights();
                this.hasWeightsValid = true;
            }
            return this.hasWeights;
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt) {
            include(list, interval, mutableInt, true);
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt, boolean z) {
            if (interval.size() == 0) {
                return;
            }
            if (z) {
                for (Arc arc : list) {
                    if (arc.span.equals(interval)) {
                        return;
                    }
                }
            }
            list.add(new Arc(interval, mutableInt));
        }

        private void init(int[] iArr) {
            Arrays.fill(iArr, 0);
        }

        private void logError(String str, Arc[] arcArr, boolean[] zArr) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arcArr.length) {
                    GridLayout.this.mPrinter.println(str + " constraints: " + arcsToString(arrayList) + " are inconsistent; permanently removing: " + arcsToString(arrayList2) + ". ");
                    return;
                }
                Arc arc = arcArr[i2];
                if (zArr[i2]) {
                    arrayList.add(arc);
                }
                if (!arc.valid) {
                    arrayList2.add(arc);
                }
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recordOriginalMeasurement(int i) {
            if (hasWeights()) {
                getOriginalMeasurements()[i] = GridLayout.this.getMeasurementIncludingMargin(GridLayout.this.getChildAt(i), this.horizontal);
            }
        }

        private boolean relax(int[] iArr, Arc arc) {
            if (arc.valid) {
                Interval interval = arc.span;
                int i = interval.min;
                int i2 = interval.max;
                int i3 = iArr[i] + arc.value.value;
                if (i3 > iArr[i2]) {
                    iArr[i2] = i3;
                    return true;
                }
                return false;
            }
            return false;
        }

        private void setParentConstraints(int i, int i2) {
            this.parentMin.value = i;
            this.parentMax.value = -i2;
            this.locationsValid = false;
        }

        private void shareOutDelta(int i, float f) {
            Arrays.fill(this.deltas, 0);
            int childCount = GridLayout.this.getChildCount();
            int i2 = i;
            int i3 = 0;
            while (i3 < childCount) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i3));
                float f2 = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
                int i4 = i2;
                float f3 = f;
                if (f2 != 0.0f) {
                    int round = Math.round((i2 * f2) / f);
                    this.deltas[i3] = round;
                    i4 = i2 - round;
                    f3 = f - f2;
                }
                i3++;
                i2 = i4;
                f = f3;
            }
        }

        private int size(int[] iArr) {
            return iArr[getCount()];
        }

        private boolean solve(int[] iArr) {
            return solve(getArcs(), iArr);
        }

        private boolean solve(Arc[] arcArr, int[] iArr) {
            return solve(arcArr, iArr, true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
            if (r11 != false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
            return false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
            r0 = new boolean[r9.length];
            r0 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x008d, code lost:
            r13 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
            if (r13 >= r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0094, code lost:
            r14 = 0;
            r0 = r9.length;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x009f, code lost:
            if (r14 >= r0) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a2, code lost:
            r0[r14] = r0[r14] | relax(r10, r9[r14]);
            r14 = r14 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00bf, code lost:
            r0 = r13 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00ca, code lost:
            if (r12 != 0) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cd, code lost:
            r19 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00d1, code lost:
            r0 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00d4, code lost:
            r13 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00d8, code lost:
            if (r13 >= r9.length) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
            if (r0[r13] == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00e3, code lost:
            r0 = r9[r13];
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00f9, code lost:
            if (r0.span.min >= r0.span.max) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00fc, code lost:
            r0 = r13 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0105, code lost:
            r0.valid = false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean solve(android.widget.GridLayout.Arc[] r9, int[] r10, boolean r11) {
            /*
                Method dump skipped, instructions count: 278
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.widget.GridLayout.Axis.solve(android.widget.GridLayout$Arc[], int[], boolean):boolean");
        }

        private void solveAndDistributeSpace(int[] iArr) {
            Arrays.fill(getDeltas(), 0);
            solve(iArr);
            int childCount = (this.parentMin.value * GridLayout.this.getChildCount()) + 1;
            if (childCount < 2) {
                return;
            }
            int i = 0;
            float calculateTotalWeight = calculateTotalWeight();
            int i2 = -1;
            boolean z = true;
            while (i < childCount) {
                int i3 = (i + childCount) / 2;
                invalidateValues();
                shareOutDelta(i3, calculateTotalWeight);
                z = solve(getArcs(), iArr, false);
                if (z) {
                    i2 = i3;
                    i = i3 + 1;
                } else {
                    childCount = i3;
                }
            }
            if (i2 <= 0 || z) {
                return;
            }
            invalidateValues();
            shareOutDelta(i2, calculateTotalWeight);
            solve(iArr);
        }

        private Arc[] topologicalSort(List<Arc> list) {
            return topologicalSort((Arc[]) list.toArray(new Arc[list.size()]));
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.GridLayout$Axis$1] */
        private Arc[] topologicalSort(final Arc[] arcArr) {
            return new Object() { // from class: android.widget.GridLayout.Axis.1
                static final /* synthetic */ boolean $assertionsDisabled;
                Arc[][] arcsByVertex;
                int cursor;
                Arc[] result;
                int[] visited;

                static {
                    $assertionsDisabled = !GridLayout.class.desiredAssertionStatus();
                }

                {
                    this.result = new Arc[arcArr.length];
                    this.cursor = this.result.length - 1;
                    this.arcsByVertex = Axis.this.groupArcsByFirstVertex(arcArr);
                    this.visited = new int[Axis.this.getCount() + 1];
                }

                Arc[] sort() {
                    int length = this.arcsByVertex.length;
                    for (int i = 0; i < length; i++) {
                        walk(i);
                    }
                    if ($assertionsDisabled || this.cursor == -1) {
                        return this.result;
                    }
                    throw new AssertionError();
                }

                void walk(int i) {
                    switch (this.visited[i]) {
                        case 0:
                            this.visited[i] = 1;
                            Arc[] arcArr2 = this.arcsByVertex[i];
                            int length = arcArr2.length;
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= length) {
                                    this.visited[i] = 2;
                                    return;
                                }
                                Arc arc = arcArr2[i3];
                                walk(arc.span.max);
                                Arc[] arcArr3 = this.result;
                                int i4 = this.cursor;
                                this.cursor = i4 - 1;
                                arcArr3[i4] = arc;
                                i2 = i3 + 1;
                            }
                        case 1:
                            if (!$assertionsDisabled) {
                                throw new AssertionError();
                            }
                            return;
                        default:
                            return;
                    }
                }
            }.sort();
        }

        public Arc[] getArcs() {
            if (this.arcs == null) {
                this.arcs = createArcs();
            }
            if (!this.arcsValid) {
                computeArcs();
                this.arcsValid = true;
            }
            return this.arcs;
        }

        public int getCount() {
            return Math.max(this.definedCount, getMaxIndex());
        }

        public int[] getDeltas() {
            if (this.deltas == null) {
                this.deltas = new int[GridLayout.this.getChildCount()];
            }
            return this.deltas;
        }

        public PackedMap<Spec, Bounds> getGroupBounds() {
            if (this.groupBounds == null) {
                this.groupBounds = createGroupBounds();
            }
            if (!this.groupBoundsValid) {
                computeGroupBounds();
                this.groupBoundsValid = true;
            }
            return this.groupBounds;
        }

        public int[] getLeadingMargins() {
            if (this.leadingMargins == null) {
                this.leadingMargins = new int[getCount() + 1];
            }
            if (!this.leadingMarginsValid) {
                computeMargins(true);
                this.leadingMarginsValid = true;
            }
            return this.leadingMargins;
        }

        public int[] getLocations() {
            if (this.locations == null) {
                this.locations = new int[getCount() + 1];
            }
            if (!this.locationsValid) {
                computeLocations(this.locations);
                this.locationsValid = true;
            }
            return this.locations;
        }

        public int getMeasure(int i) {
            int measure;
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return getMeasure(0, size);
                case 0:
                    measure = getMeasure(0, 100000);
                    break;
                case 1073741824:
                    return getMeasure(size, size);
                default:
                    measure = 0;
                    if (!$assertionsDisabled) {
                        throw new AssertionError();
                    }
                    break;
            }
            return measure;
        }

        public int[] getOriginalMeasurements() {
            if (this.originalMeasurements == null) {
                this.originalMeasurements = new int[GridLayout.this.getChildCount()];
            }
            return this.originalMeasurements;
        }

        public int[] getTrailingMargins() {
            if (this.trailingMargins == null) {
                this.trailingMargins = new int[getCount() + 1];
            }
            if (!this.trailingMarginsValid) {
                computeMargins(false);
                this.trailingMarginsValid = true;
            }
            return this.trailingMargins;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [android.widget.GridLayout$Arc[], android.widget.GridLayout$Arc[][]] */
        Arc[][] groupArcsByFirstVertex(Arc[] arcArr) {
            int count = getCount() + 1;
            ?? r0 = new Arc[count];
            int[] iArr = new int[count];
            int length = arcArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                int i3 = arcArr[i2].span.min;
                iArr[i3] = iArr[i3] + 1;
                i = i2 + 1;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= iArr.length) {
                    break;
                }
                r0[i5] = new Arc[iArr[i5]];
                i4 = i5 + 1;
            }
            Arrays.fill(iArr, 0);
            int length2 = arcArr.length;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= length2) {
                    return r0;
                }
                Arc arc = arcArr[i7];
                int i8 = arc.span.min;
                Arc[] arcArr2 = r0[i8];
                int i9 = iArr[i8];
                iArr[i8] = i9 + 1;
                arcArr2[i9] = arc;
                i6 = i7 + 1;
            }
        }

        public void invalidateStructure() {
            this.maxIndex = Integer.MIN_VALUE;
            this.groupBounds = null;
            this.forwardLinks = null;
            this.backwardLinks = null;
            this.leadingMargins = null;
            this.trailingMargins = null;
            this.arcs = null;
            this.locations = null;
            this.originalMeasurements = null;
            this.deltas = null;
            this.hasWeightsValid = false;
            invalidateValues();
        }

        public void invalidateValues() {
            this.groupBoundsValid = false;
            this.forwardLinksValid = false;
            this.backwardLinksValid = false;
            this.leadingMarginsValid = false;
            this.trailingMarginsValid = false;
            this.arcsValid = false;
            this.locationsValid = false;
        }

        public boolean isOrderPreserved() {
            return this.orderPreserved;
        }

        public void layout(int i) {
            setParentConstraints(i, i);
            getLocations();
        }

        public void setCount(int i) {
            if (i != Integer.MIN_VALUE && i < getMaxIndex()) {
                GridLayout.handleInvalidParams((this.horizontal ? "column" : "row") + "Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child");
            }
            this.definedCount = i;
        }

        public void setOrderPreserved(boolean z) {
            this.orderPreserved = z;
            invalidateStructure();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/GridLayout$Bounds.class */
    public static class Bounds {
        public int after;
        public int before;
        public int flexibility;

        private Bounds() {
            reset();
        }

        protected int getOffset(GridLayout gridLayout, View view, Alignment alignment, int i, boolean z) {
            return this.before - alignment.getAlignmentValue(view, i, gridLayout.getLayoutMode());
        }

        protected void include(int i, int i2) {
            this.before = Math.max(this.before, i);
            this.after = Math.max(this.after, i2);
        }

        protected final void include(GridLayout gridLayout, View view, Spec spec, Axis axis, int i) {
            this.flexibility &= spec.getFlexibility();
            int alignmentValue = gridLayout.getAlignment(spec.alignment, axis.horizontal).getAlignmentValue(view, i, gridLayout.getLayoutMode());
            include(alignmentValue, i - alignmentValue);
        }

        protected void reset() {
            this.before = Integer.MIN_VALUE;
            this.after = Integer.MIN_VALUE;
            this.flexibility = 2;
        }

        protected int size(boolean z) {
            if (z || !GridLayout.canStretch(this.flexibility)) {
                return this.before + this.after;
            }
            return 100000;
        }

        public String toString() {
            return "Bounds{before=" + this.before + ", after=" + this.after + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/GridLayout$Interval.class */
    public static final class Interval {
        public final int max;
        public final int min;

        public Interval(int i, int i2) {
            this.min = i;
            this.max = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Interval interval = (Interval) obj;
            return this.max == interval.max && this.min == interval.min;
        }

        public int hashCode() {
            return (this.min * 31) + this.max;
        }

        Interval inverse() {
            return new Interval(this.max, this.min);
        }

        int size() {
            return this.max - this.min;
        }

        public String toString() {
            return "[" + this.min + ", " + this.max + "]";
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/GridLayout$LayoutParams.class */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int BOTTOM_MARGIN = 6;
        private static final int COLUMN = 1;
        private static final int COLUMN_SPAN = 4;
        private static final int COLUMN_WEIGHT = 6;
        private static final int DEFAULT_COLUMN = Integer.MIN_VALUE;
        private static final int DEFAULT_HEIGHT = -2;
        private static final int DEFAULT_MARGIN = Integer.MIN_VALUE;
        private static final int DEFAULT_ROW = Integer.MIN_VALUE;
        private static final Interval DEFAULT_SPAN = new Interval(Integer.MIN_VALUE, -2147483647);
        private static final int DEFAULT_SPAN_SIZE = DEFAULT_SPAN.size();
        private static final int DEFAULT_WIDTH = -2;
        private static final int GRAVITY = 0;
        private static final int LEFT_MARGIN = 3;
        private static final int MARGIN = 2;
        private static final int RIGHT_MARGIN = 5;
        private static final int ROW = 2;
        private static final int ROW_SPAN = 3;
        private static final int ROW_WEIGHT = 5;
        private static final int TOP_MARGIN = 4;
        public Spec columnSpec;
        public Spec rowSpec;

        public LayoutParams() {
            this(Spec.UNDEFINED, Spec.UNDEFINED);
        }

        private LayoutParams(int i, int i2, int i3, int i4, int i5, int i6, Spec spec, Spec spec2) {
            super(i, i2);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            setMargins(i3, i4, i5, i6);
            this.rowSpec = spec;
            this.columnSpec = spec2;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            reInitSuper(context, attributeSet);
            init(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            this.rowSpec = layoutParams.rowSpec;
            this.columnSpec = layoutParams.columnSpec;
        }

        public LayoutParams(Spec spec, Spec spec2) {
            this(-2, -2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, spec, spec2);
        }

        private void init(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout_Layout);
            try {
                int i = obtainStyledAttributes.getInt(0, 0);
                this.columnSpec = GridLayout.spec(obtainStyledAttributes.getInt(1, Integer.MIN_VALUE), obtainStyledAttributes.getInt(4, DEFAULT_SPAN_SIZE), GridLayout.getAlignment(i, true), obtainStyledAttributes.getFloat(6, 0.0f));
                this.rowSpec = GridLayout.spec(obtainStyledAttributes.getInt(2, Integer.MIN_VALUE), obtainStyledAttributes.getInt(3, DEFAULT_SPAN_SIZE), GridLayout.getAlignment(i, false), obtainStyledAttributes.getFloat(5, 0.0f));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        private void reInitSuper(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewGroup_MarginLayout);
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, Integer.MIN_VALUE);
                this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(3, dimensionPixelSize);
                this.topMargin = obtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
                this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(5, dimensionPixelSize);
                this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) obj;
            return this.columnSpec.equals(layoutParams.columnSpec) && this.rowSpec.equals(layoutParams.rowSpec);
        }

        public int hashCode() {
            return (this.rowSpec.hashCode() * 31) + this.columnSpec.hashCode();
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            this.width = typedArray.getLayoutDimension(i, -2);
            this.height = typedArray.getLayoutDimension(i2, -2);
        }

        final void setColumnSpecSpan(Interval interval) {
            this.columnSpec = this.columnSpec.copyWriteSpan(interval);
        }

        public void setGravity(int i) {
            this.rowSpec = this.rowSpec.copyWriteAlignment(GridLayout.getAlignment(i, false));
            this.columnSpec = this.columnSpec.copyWriteAlignment(GridLayout.getAlignment(i, true));
        }

        final void setRowSpecSpan(Interval interval) {
            this.rowSpec = this.rowSpec.copyWriteSpan(interval);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/GridLayout$MutableInt.class */
    public static final class MutableInt {
        public int value;

        public MutableInt() {
            reset();
        }

        public MutableInt(int i) {
            this.value = i;
        }

        public void reset() {
            this.value = Integer.MIN_VALUE;
        }

        public String toString() {
            return Integer.toString(this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/GridLayout$PackedMap.class */
    public static final class PackedMap<K, V> {
        public final int[] index;
        public final K[] keys;
        public final V[] values;

        private PackedMap(K[] kArr, V[] vArr) {
            this.index = createIndex(kArr);
            this.keys = (K[]) compact(kArr, this.index);
            this.values = (V[]) compact(vArr, this.index);
        }

        private static <K> K[] compact(K[] kArr, int[] iArr) {
            int length = kArr.length;
            K[] kArr2 = (K[]) ((Object[]) Array.newInstance(kArr.getClass().getComponentType(), GridLayout.max2(iArr, -1) + 1));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return kArr2;
                }
                kArr2[iArr[i2]] = kArr[i2];
                i = i2 + 1;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r0v21, types: [java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Integer] */
        private static <K> int[] createIndex(K[] kArr) {
            int length = kArr.length;
            int[] iArr = new int[length];
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return iArr;
                }
                K k = kArr[i2];
                ?? r0 = (Integer) hashMap.get(k);
                V v = r0;
                if (r0 == 0) {
                    v = Integer.valueOf(hashMap.size());
                    hashMap.put(k, v);
                }
                iArr[i2] = v.intValue();
                i = i2 + 1;
            }
        }

        public V getValue(int i) {
            return this.values[this.index[i]];
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/GridLayout$Spec.class */
    public static class Spec {
        static final float DEFAULT_WEIGHT = 0.0f;
        static final Spec UNDEFINED = GridLayout.spec(Integer.MIN_VALUE);
        final Alignment alignment;
        final Interval span;
        final boolean startDefined;
        final float weight;

        private Spec(boolean z, int i, int i2, Alignment alignment, float f) {
            this(z, new Interval(i, i + i2), alignment, f);
        }

        private Spec(boolean z, Interval interval, Alignment alignment, float f) {
            this.startDefined = z;
            this.span = interval;
            this.alignment = alignment;
            this.weight = f;
        }

        final Spec copyWriteAlignment(Alignment alignment) {
            return new Spec(this.startDefined, this.span, alignment, this.weight);
        }

        final Spec copyWriteSpan(Interval interval) {
            return new Spec(this.startDefined, interval, this.alignment, this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Spec spec = (Spec) obj;
            return this.alignment.equals(spec.alignment) && this.span.equals(spec.span);
        }

        final int getFlexibility() {
            return (this.alignment == GridLayout.UNDEFINED_ALIGNMENT && this.weight == 0.0f) ? 0 : 2;
        }

        public int hashCode() {
            return (this.span.hashCode() * 31) + this.alignment.hashCode();
        }
    }

    public GridLayout(Context context) {
        this(context, null);
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mHorizontalAxis = new Axis(true);
        this.mVerticalAxis = new Axis(false);
        this.mOrientation = 0;
        this.mUseDefaultMargins = false;
        this.mAlignmentMode = 1;
        this.mLastLayoutParamsHashCode = 0;
        this.mPrinter = LOG_PRINTER;
        this.mDefaultGap = context.getResources().getDimensionPixelOffset(R.dimen.default_gap);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout, i, i2);
        try {
            setRowCount(obtainStyledAttributes.getInt(1, Integer.MIN_VALUE));
            setColumnCount(obtainStyledAttributes.getInt(3, Integer.MIN_VALUE));
            setOrientation(obtainStyledAttributes.getInt(0, 0));
            setUseDefaultMargins(obtainStyledAttributes.getBoolean(5, false));
            setAlignmentMode(obtainStyledAttributes.getInt(6, 1));
            setRowOrderPreserved(obtainStyledAttributes.getBoolean(2, true));
            setColumnOrderPreserved(obtainStyledAttributes.getBoolean(4, true));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static int adjust(int i, int i2) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i + i2), View.MeasureSpec.getMode(i));
    }

    static <T> T[] append(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length));
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    static boolean canStretch(int i) {
        return (i & 2) != 0;
    }

    private void checkLayoutParams(LayoutParams layoutParams, boolean z) {
        String str = z ? "column" : "row";
        Interval interval = (z ? layoutParams.columnSpec : layoutParams.rowSpec).span;
        if (interval.min != Integer.MIN_VALUE && interval.min < 0) {
            handleInvalidParams(str + " indices must be positive");
        }
        int i = (z ? this.mHorizontalAxis : this.mVerticalAxis).definedCount;
        if (i != Integer.MIN_VALUE) {
            if (interval.max > i) {
                handleInvalidParams(str + " indices (start + span) mustn't exceed the " + str + " count");
            }
            if (interval.size() > i) {
                handleInvalidParams(str + " span mustn't exceed the " + str + " count");
            }
        }
    }

    private static int clip(Interval interval, boolean z, int i) {
        int size = interval.size();
        if (i == 0) {
            return size;
        }
        return Math.min(size, i - (z ? Math.min(interval.min, i) : 0));
    }

    private int computeLayoutParamsHashCode() {
        int i = 1;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                i = (i * 31) + ((LayoutParams) childAt.getLayoutParams()).hashCode();
            }
        }
        return i;
    }

    private void consistencyCheck() {
        if (this.mLastLayoutParamsHashCode == 0) {
            validateLayoutParams();
            this.mLastLayoutParamsHashCode = computeLayoutParamsHashCode();
        } else if (this.mLastLayoutParamsHashCode != computeLayoutParamsHashCode()) {
            this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
            invalidateStructure();
            consistencyCheck();
        }
    }

    private static Alignment createSwitchingAlignment(final Alignment alignment, final Alignment alignment2) {
        return new Alignment() { // from class: android.widget.GridLayout.5
            @Override // android.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int i, int i2) {
                return (!view.isLayoutRtl() ? Alignment.this : alignment2).getAlignmentValue(view, i, i2);
            }

            @Override // android.widget.GridLayout.Alignment
            int getGravityOffset(View view, int i) {
                return (!view.isLayoutRtl() ? Alignment.this : alignment2).getGravityOffset(view, i);
            }
        };
    }

    private void drawLine(Canvas canvas, int i, int i2, int i3, int i4, Paint paint) {
        if (!isLayoutRtl()) {
            canvas.drawLine(i, i2, i3, i4, paint);
            return;
        }
        int width = getWidth();
        canvas.drawLine(width - i, i2, width - i3, i4, paint);
    }

    private static boolean fits(int[] iArr, int i, int i2, int i3) {
        if (i3 > iArr.length) {
            return false;
        }
        while (i2 < i3) {
            if (iArr[i2] > i) {
                return false;
            }
            i2++;
        }
        return true;
    }

    static Alignment getAlignment(int i, boolean z) {
        switch ((i & (z ? 7 : 112)) >> (z ? 0 : 4)) {
            case 1:
                return CENTER;
            case 3:
                return z ? LEFT : TOP;
            case 5:
                return z ? RIGHT : BOTTOM;
            case 7:
                return FILL;
            case 8388611:
                return START;
            case 8388613:
                return END;
            default:
                return UNDEFINED_ALIGNMENT;
        }
    }

    private int getDefaultMargin(View view, LayoutParams layoutParams, boolean z, boolean z2) {
        boolean z3;
        if (this.mUseDefaultMargins) {
            Spec spec = z ? layoutParams.columnSpec : layoutParams.rowSpec;
            Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
            Interval interval = spec.span;
            if ((z && isLayoutRtl()) ? !z2 : z2) {
                z3 = interval.min == 0;
            } else {
                z3 = true;
                if (interval.max != axis.getCount()) {
                    z3 = false;
                }
            }
            return getDefaultMargin(view, z3, z, z2);
        }
        return 0;
    }

    private int getDefaultMargin(View view, boolean z, boolean z2) {
        if (view.getClass() == Space.class) {
            return 0;
        }
        return this.mDefaultGap / 2;
    }

    private int getDefaultMargin(View view, boolean z, boolean z2, boolean z3) {
        return getDefaultMargin(view, z2, z3);
    }

    private int getMargin(View view, boolean z, boolean z2) {
        if (this.mAlignmentMode == 1) {
            return getMargin1(view, z, z2);
        }
        Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
        int[] leadingMargins = z2 ? axis.getLeadingMargins() : axis.getTrailingMargins();
        LayoutParams layoutParams = getLayoutParams(view);
        Spec spec = z ? layoutParams.columnSpec : layoutParams.rowSpec;
        return leadingMargins[z2 ? spec.span.min : spec.span.max];
    }

    private int getMeasurement(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int getTotalMargin(View view, boolean z) {
        return getMargin(view, z, true) + getMargin(view, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleInvalidParams(String str) {
        throw new IllegalArgumentException(str + ". ");
    }

    private void invalidateStructure() {
        this.mLastLayoutParamsHashCode = 0;
        this.mHorizontalAxis.invalidateStructure();
        this.mVerticalAxis.invalidateStructure();
        invalidateValues();
    }

    private void invalidateValues() {
        if (this.mHorizontalAxis == null || this.mVerticalAxis == null) {
            return;
        }
        this.mHorizontalAxis.invalidateValues();
        this.mVerticalAxis.invalidateValues();
    }

    static int max2(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = i;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return i2;
            }
            i2 = Math.max(i2, iArr[i4]);
            i3 = i4 + 1;
        }
    }

    private void measureChildWithMargins2(View view, int i, int i2, int i3, int i4) {
        view.measure(getChildMeasureSpec(i, getTotalMargin(view, true), i3), getChildMeasureSpec(i2, getTotalMargin(view, false), i4));
    }

    private void measureChildrenWithMargins(int i, int i2, boolean z) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = getLayoutParams(childAt);
                if (z) {
                    measureChildWithMargins2(childAt, i, i2, layoutParams.width, layoutParams.height);
                    this.mHorizontalAxis.recordOriginalMeasurement(i3);
                    this.mVerticalAxis.recordOriginalMeasurement(i3);
                } else {
                    boolean z2 = this.mOrientation == 0;
                    Spec spec = z2 ? layoutParams.columnSpec : layoutParams.rowSpec;
                    if (spec.alignment == FILL) {
                        Interval interval = spec.span;
                        int[] locations = (z2 ? this.mHorizontalAxis : this.mVerticalAxis).getLocations();
                        int totalMargin = (locations[interval.max] - locations[interval.min]) - getTotalMargin(childAt, z2);
                        if (z2) {
                            measureChildWithMargins2(childAt, i, i2, totalMargin, layoutParams.height);
                        } else {
                            measureChildWithMargins2(childAt, i, i2, layoutParams.width, totalMargin);
                        }
                    }
                }
            }
        }
    }

    private static void procrusteanFill(int[] iArr, int i, int i2, int i3) {
        int length = iArr.length;
        Arrays.fill(iArr, Math.min(i, length), Math.min(i2, length), i3);
    }

    private static void setCellGroup(LayoutParams layoutParams, int i, int i2, int i3, int i4) {
        layoutParams.setRowSpecSpan(new Interval(i, i + i2));
        layoutParams.setColumnSpecSpan(new Interval(i3, i3 + i4));
    }

    public static Spec spec(int i) {
        return spec(i, 1);
    }

    public static Spec spec(int i, float f) {
        return spec(i, 1, f);
    }

    public static Spec spec(int i, int i2) {
        return spec(i, i2, UNDEFINED_ALIGNMENT);
    }

    public static Spec spec(int i, int i2, float f) {
        return spec(i, i2, UNDEFINED_ALIGNMENT, f);
    }

    public static Spec spec(int i, int i2, Alignment alignment) {
        return spec(i, i2, alignment, 0.0f);
    }

    public static Spec spec(int i, int i2, Alignment alignment, float f) {
        return new Spec(i != Integer.MIN_VALUE, i, i2, alignment, f);
    }

    public static Spec spec(int i, Alignment alignment) {
        return spec(i, 1, alignment);
    }

    public static Spec spec(int i, Alignment alignment, float f) {
        return spec(i, 1, alignment, f);
    }

    private void validateLayoutParams() {
        boolean z = this.mOrientation == 0;
        Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
        int i = axis.definedCount != Integer.MIN_VALUE ? axis.definedCount : 0;
        int i2 = 0;
        int i3 = 0;
        int[] iArr = new int[i];
        int i4 = 0;
        int childCount = getChildCount();
        while (i4 < childCount) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
            Spec spec = z ? layoutParams.rowSpec : layoutParams.columnSpec;
            Interval interval = spec.span;
            boolean z2 = spec.startDefined;
            int size = interval.size();
            if (z2) {
                i2 = interval.min;
            }
            Spec spec2 = z ? layoutParams.columnSpec : layoutParams.rowSpec;
            Interval interval2 = spec2.span;
            boolean z3 = spec2.startDefined;
            int clip = clip(interval2, z3, i);
            if (z3) {
                i3 = interval2.min;
            }
            int i5 = i2;
            int i6 = i3;
            if (i != 0) {
                int i7 = i2;
                int i8 = i3;
                if (z2) {
                    i5 = i2;
                    i6 = i3;
                    if (!z3) {
                        i8 = i3;
                        i7 = i2;
                    }
                    procrusteanFill(iArr, i6, i6 + clip, i5 + size);
                }
                while (true) {
                    i5 = i7;
                    i6 = i8;
                    if (fits(iArr, i7, i8, i8 + clip)) {
                        break;
                    } else if (z3) {
                        i7++;
                    } else if (i8 + clip <= i) {
                        i8++;
                    } else {
                        i8 = 0;
                        i7++;
                    }
                }
                procrusteanFill(iArr, i6, i6 + clip, i5 + size);
            }
            if (z) {
                setCellGroup(layoutParams, i5, size, i6, clip);
            } else {
                setCellGroup(layoutParams, i6, clip, i5, size);
            }
            i3 = i6 + clip;
            i4++;
            i2 = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            checkLayoutParams(layoutParams2, true);
            checkLayoutParams(layoutParams2, false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    final Alignment getAlignment(Alignment alignment, boolean z) {
        return alignment != UNDEFINED_ALIGNMENT ? alignment : z ? START : BASELINE;
    }

    public int getAlignmentMode() {
        return this.mAlignmentMode;
    }

    public int getColumnCount() {
        return this.mHorizontalAxis.getCount();
    }

    final LayoutParams getLayoutParams(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    int getMargin1(View view, boolean z, boolean z2) {
        LayoutParams layoutParams = getLayoutParams(view);
        int i = z ? z2 ? layoutParams.leftMargin : layoutParams.rightMargin : z2 ? layoutParams.topMargin : layoutParams.bottomMargin;
        int i2 = i;
        if (i == Integer.MIN_VALUE) {
            i2 = getDefaultMargin(view, layoutParams, z, z2);
        }
        return i2;
    }

    final int getMeasurementIncludingMargin(View view, boolean z) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return getMeasurement(view, z) + getTotalMargin(view, z);
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public Printer getPrinter() {
        return this.mPrinter;
    }

    public int getRowCount() {
        return this.mVerticalAxis.getCount();
    }

    public boolean getUseDefaultMargins() {
        return this.mUseDefaultMargins;
    }

    public boolean isColumnOrderPreserved() {
        return this.mHorizontalAxis.isOrderPreserved();
    }

    public boolean isRowOrderPreserved() {
        return this.mVerticalAxis.isOrderPreserved();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void onChildVisibilityChanged(View view, int i, int i2) {
        super.onChildVisibilityChanged(view, i, i2);
        if (i == 8 || i2 == 8) {
            invalidateStructure();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void onDebugDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.argb(50, 255, 255, 255));
        Insets opticalInsets = getOpticalInsets();
        int paddingTop = getPaddingTop() + opticalInsets.top;
        int paddingLeft = getPaddingLeft() + opticalInsets.left;
        int width = getWidth();
        int paddingRight = getPaddingRight();
        int i = opticalInsets.right;
        int height = getHeight();
        int paddingBottom = getPaddingBottom();
        int i2 = opticalInsets.bottom;
        int[] iArr = this.mHorizontalAxis.locations;
        if (iArr != null) {
            for (int i3 : iArr) {
                int i4 = paddingLeft + i3;
                drawLine(canvas, i4, paddingTop, i4, (height - paddingBottom) - i2, paint);
            }
        }
        int[] iArr2 = this.mVerticalAxis.locations;
        if (iArr2 != null) {
            for (int i5 : iArr2) {
                int i6 = paddingTop + i5;
                drawLine(canvas, paddingLeft, i6, (width - paddingRight) - i, i6, paint);
            }
        }
        super.onDebugDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected void onDebugDrawMargins(Canvas canvas, Paint paint) {
        LayoutParams layoutParams = new LayoutParams();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return;
            }
            View childAt = getChildAt(i2);
            layoutParams.setMargins(getMargin1(childAt, true, true), getMargin1(childAt, false, true), getMargin1(childAt, true, false), getMargin1(childAt, false, false));
            layoutParams.onDebugDraw(childAt, canvas, paint);
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(GridLayout.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(GridLayout.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        consistencyCheck();
        int i5 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        this.mHorizontalAxis.layout((i5 - paddingLeft) - paddingRight);
        this.mVerticalAxis.layout(((i4 - i2) - paddingTop) - paddingBottom);
        int[] locations = this.mHorizontalAxis.getLocations();
        int[] locations2 = this.mVerticalAxis.getLocations();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = getLayoutParams(childAt);
                Spec spec = layoutParams.columnSpec;
                Spec spec2 = layoutParams.rowSpec;
                Interval interval = spec.span;
                Interval interval2 = spec2.span;
                int i7 = locations[interval.min];
                int i8 = locations2[interval2.min];
                int i9 = locations[interval.max];
                int i10 = locations2[interval2.max];
                int i11 = i9 - i7;
                int i12 = i10 - i8;
                int measurement = getMeasurement(childAt, true);
                int measurement2 = getMeasurement(childAt, false);
                Alignment alignment = getAlignment(spec.alignment, true);
                Alignment alignment2 = getAlignment(spec2.alignment, false);
                Bounds value = this.mHorizontalAxis.getGroupBounds().getValue(i6);
                Bounds value2 = this.mVerticalAxis.getGroupBounds().getValue(i6);
                int gravityOffset = alignment.getGravityOffset(childAt, i11 - value.size(true));
                int gravityOffset2 = alignment2.getGravityOffset(childAt, i12 - value2.size(true));
                int margin = getMargin(childAt, true, true);
                int margin2 = getMargin(childAt, false, true);
                int margin3 = getMargin(childAt, true, false);
                int margin4 = getMargin(childAt, false, false);
                int i13 = margin + margin3;
                int i14 = margin2 + margin4;
                int offset = value.getOffset(this, childAt, alignment, measurement + i13, true);
                int offset2 = value2.getOffset(this, childAt, alignment2, measurement2 + i14, false);
                int sizeInCell = alignment.getSizeInCell(childAt, measurement, i11 - i13);
                int sizeInCell2 = alignment2.getSizeInCell(childAt, measurement2, i12 - i14);
                int i15 = i7 + gravityOffset + offset;
                int i16 = !isLayoutRtl() ? paddingLeft + margin + i15 : (((i5 - sizeInCell) - paddingRight) - margin3) - i15;
                int i17 = paddingTop + i8 + gravityOffset2 + offset2 + margin2;
                if (sizeInCell != childAt.getMeasuredWidth() || sizeInCell2 != childAt.getMeasuredHeight()) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(sizeInCell, 1073741824), View.MeasureSpec.makeMeasureSpec(sizeInCell2, 1073741824));
                }
                childAt.layout(i16, i17, i16 + sizeInCell, i17 + sizeInCell2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measure;
        int measure2;
        consistencyCheck();
        invalidateValues();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int adjust = adjust(i, -paddingLeft);
        int adjust2 = adjust(i2, -paddingTop);
        measureChildrenWithMargins(adjust, adjust2, true);
        if (this.mOrientation == 0) {
            measure2 = this.mHorizontalAxis.getMeasure(adjust);
            measureChildrenWithMargins(adjust, adjust2, false);
            measure = this.mVerticalAxis.getMeasure(adjust2);
        } else {
            measure = this.mVerticalAxis.getMeasure(adjust2);
            measureChildrenWithMargins(adjust, adjust2, false);
            measure2 = this.mHorizontalAxis.getMeasure(adjust);
        }
        setMeasuredDimension(resolveSizeAndState(Math.max(measure2 + paddingLeft, getSuggestedMinimumWidth()), i, 0), resolveSizeAndState(Math.max(measure + paddingTop, getSuggestedMinimumHeight()), i2, 0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void onSetLayoutParams(View view, ViewGroup.LayoutParams layoutParams) {
        super.onSetLayoutParams(view, layoutParams);
        if (!checkLayoutParams(layoutParams)) {
            handleInvalidParams("supplied LayoutParams are of the wrong type");
        }
        invalidateStructure();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        invalidateStructure();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        invalidateStructure();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        invalidateValues();
    }

    public void setAlignmentMode(int i) {
        this.mAlignmentMode = i;
        requestLayout();
    }

    public void setColumnCount(int i) {
        this.mHorizontalAxis.setCount(i);
        invalidateStructure();
        requestLayout();
    }

    public void setColumnOrderPreserved(boolean z) {
        this.mHorizontalAxis.setOrderPreserved(z);
        invalidateStructure();
        requestLayout();
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            invalidateStructure();
            requestLayout();
        }
    }

    public void setPrinter(Printer printer) {
        Printer printer2 = printer;
        if (printer == null) {
            printer2 = NO_PRINTER;
        }
        this.mPrinter = printer2;
    }

    public void setRowCount(int i) {
        this.mVerticalAxis.setCount(i);
        invalidateStructure();
        requestLayout();
    }

    public void setRowOrderPreserved(boolean z) {
        this.mVerticalAxis.setOrderPreserved(z);
        invalidateStructure();
        requestLayout();
    }

    public void setUseDefaultMargins(boolean z) {
        this.mUseDefaultMargins = z;
        requestLayout();
    }
}
