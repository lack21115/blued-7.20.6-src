package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Atlas.class */
public class Atlas {
    public static final int FLAG_ADD_PADDING = 2;
    public static final int FLAG_ALLOW_ROTATIONS = 1;
    public static final int FLAG_DEFAULTS = 2;
    private final Policy mPolicy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.graphics.Atlas$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Atlas$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Atlas$Type = new int[Type.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0038 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003c -> B:21:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0040 -> B:19:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$graphics$Atlas$Type[Type.SliceMinArea.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$graphics$Atlas$Type[Type.SliceMaxArea.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$Atlas$Type[Type.SliceShortAxis.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$Atlas$Type[Type.SliceLongAxis.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Atlas$Entry.class */
    public static class Entry {
        public boolean rotated;
        public int x;
        public int y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Atlas$Policy.class */
    public static abstract class Policy {
        private Policy() {
        }

        /* synthetic */ Policy(AnonymousClass1 anonymousClass1) {
            this();
        }

        abstract Entry pack(int i, int i2, Entry entry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Atlas$SlicePolicy.class */
    public static class SlicePolicy extends Policy {
        private final boolean mAllowRotation;
        private final int mPadding;
        private final Cell mRoot;
        private final SplitDecision mSplitDecision;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/graphics/Atlas$SlicePolicy$Cell.class */
        public static class Cell {
            int height;
            Cell next;
            int width;
            int x;
            int y;

            private Cell() {
            }

            /* synthetic */ Cell(AnonymousClass1 anonymousClass1) {
                this();
            }

            public String toString() {
                return String.format("cell[x=%d y=%d width=%d height=%d", Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.width), Integer.valueOf(this.height));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/graphics/Atlas$SlicePolicy$LongerFreeAxisSplitDecision.class */
        public static class LongerFreeAxisSplitDecision implements SplitDecision {
            private LongerFreeAxisSplitDecision() {
            }

            /* synthetic */ LongerFreeAxisSplitDecision(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // android.graphics.Atlas.SlicePolicy.SplitDecision
            public boolean splitHorizontal(int i, int i2, int i3, int i4) {
                return i > i2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/graphics/Atlas$SlicePolicy$MaxAreaSplitDecision.class */
        public static class MaxAreaSplitDecision implements SplitDecision {
            private MaxAreaSplitDecision() {
            }

            /* synthetic */ MaxAreaSplitDecision(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // android.graphics.Atlas.SlicePolicy.SplitDecision
            public boolean splitHorizontal(int i, int i2, int i3, int i4) {
                return i3 * i2 <= i * i4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/graphics/Atlas$SlicePolicy$MinAreaSplitDecision.class */
        public static class MinAreaSplitDecision implements SplitDecision {
            private MinAreaSplitDecision() {
            }

            /* synthetic */ MinAreaSplitDecision(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // android.graphics.Atlas.SlicePolicy.SplitDecision
            public boolean splitHorizontal(int i, int i2, int i3, int i4) {
                return i3 * i2 > i * i4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/graphics/Atlas$SlicePolicy$ShorterFreeAxisSplitDecision.class */
        public static class ShorterFreeAxisSplitDecision implements SplitDecision {
            private ShorterFreeAxisSplitDecision() {
            }

            /* synthetic */ ShorterFreeAxisSplitDecision(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // android.graphics.Atlas.SlicePolicy.SplitDecision
            public boolean splitHorizontal(int i, int i2, int i3, int i4) {
                return i <= i2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/graphics/Atlas$SlicePolicy$SplitDecision.class */
        public interface SplitDecision {
            boolean splitHorizontal(int i, int i2, int i3, int i4);
        }

        SlicePolicy(int i, int i2, int i3, SplitDecision splitDecision) {
            super(null);
            this.mRoot = new Cell(null);
            this.mAllowRotation = (i3 & 1) != 0;
            this.mPadding = (i3 & 2) != 0 ? 1 : 0;
            Cell cell = new Cell(null);
            int i4 = this.mPadding;
            cell.y = i4;
            cell.x = i4;
            cell.width = i - (this.mPadding * 2);
            cell.height = i2 - (this.mPadding * 2);
            this.mRoot.next = cell;
            this.mSplitDecision = splitDecision;
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
            if (r7.height < r10) goto L23;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean insert(android.graphics.Atlas.SlicePolicy.Cell r7, android.graphics.Atlas.SlicePolicy.Cell r8, int r9, int r10, android.graphics.Atlas.Entry r11) {
            /*
                Method dump skipped, instructions count: 349
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.graphics.Atlas.SlicePolicy.insert(android.graphics.Atlas$SlicePolicy$Cell, android.graphics.Atlas$SlicePolicy$Cell, int, int, android.graphics.Atlas$Entry):boolean");
        }

        @Override // android.graphics.Atlas.Policy
        Entry pack(int i, int i2, Entry entry) {
            Cell cell = this.mRoot;
            for (Cell cell2 = this.mRoot.next; cell2 != null; cell2 = cell2.next) {
                if (insert(cell2, cell, i, i2, entry)) {
                    return entry;
                }
                cell = cell2;
            }
            return null;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Atlas$Type.class */
    public enum Type {
        SliceMinArea,
        SliceMaxArea,
        SliceShortAxis,
        SliceLongAxis
    }

    public Atlas(Type type, int i, int i2) {
        this(type, i, i2, 2);
    }

    public Atlas(Type type, int i, int i2, int i3) {
        this.mPolicy = findPolicy(type, i, i2, i3);
    }

    private static Policy findPolicy(Type type, int i, int i2, int i3) {
        switch (AnonymousClass1.$SwitchMap$android$graphics$Atlas$Type[type.ordinal()]) {
            case 1:
                return new SlicePolicy(i, i2, i3, new SlicePolicy.MinAreaSplitDecision(null));
            case 2:
                return new SlicePolicy(i, i2, i3, new SlicePolicy.MaxAreaSplitDecision(null));
            case 3:
                return new SlicePolicy(i, i2, i3, new SlicePolicy.ShorterFreeAxisSplitDecision(null));
            case 4:
                return new SlicePolicy(i, i2, i3, new SlicePolicy.LongerFreeAxisSplitDecision(null));
            default:
                return null;
        }
    }

    public Entry pack(int i, int i2) {
        return pack(i, i2, null);
    }

    public Entry pack(int i, int i2, Entry entry) {
        Entry entry2 = entry;
        if (entry == null) {
            entry2 = new Entry();
        }
        return this.mPolicy.pack(i, i2, entry2);
    }
}
