package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/DiffUtil.class */
public class DiffUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<Snake> f3202a = new Comparator<Snake>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Snake snake, Snake snake2) {
            int i = snake.f3209a - snake2.f3209a;
            int i2 = i;
            if (i == 0) {
                i2 = snake.b - snake2.b;
            }
            return i2;
        }
    };

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/DiffUtil$Callback.class */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        public Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/DiffUtil$DiffResult.class */
    public static class DiffResult {
        public static final int NO_POSITION = -1;

        /* renamed from: a  reason: collision with root package name */
        private final List<Snake> f3203a;
        private final int[] b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f3204c;
        private final Callback d;
        private final int e;
        private final int f;
        private final boolean g;

        DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z) {
            this.f3203a = list;
            this.b = iArr;
            this.f3204c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(this.f3204c, 0);
            this.d = callback;
            this.e = callback.getOldListSize();
            this.f = callback.getNewListSize();
            this.g = z;
            a();
            b();
        }

        private static PostponedUpdate a(List<PostponedUpdate> list, int i, boolean z) {
            int size = list.size();
            while (true) {
                int i2 = size - 1;
                if (i2 < 0) {
                    return null;
                }
                PostponedUpdate postponedUpdate = list.get(i2);
                if (postponedUpdate.f3205a == i && postponedUpdate.f3206c == z) {
                    list.remove(i2);
                    while (i2 < list.size()) {
                        list.get(i2).b += z ? 1 : -1;
                        i2++;
                    }
                    return postponedUpdate;
                }
                size = i2;
            }
        }

        private void a() {
            Snake snake = this.f3203a.isEmpty() ? null : this.f3203a.get(0);
            if (snake != null && snake.f3209a == 0 && snake.b == 0) {
                return;
            }
            Snake snake2 = new Snake();
            snake2.f3209a = 0;
            snake2.b = 0;
            snake2.d = false;
            snake2.f3210c = 0;
            snake2.e = false;
            this.f3203a.add(0, snake2);
        }

        private void a(int i, int i2, int i3) {
            if (this.b[i - 1] != 0) {
                return;
            }
            a(i, i2, i3, false);
        }

        private void a(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.g) {
                listUpdateCallback.onInserted(i, i2);
                return;
            }
            while (true) {
                i2--;
                if (i2 < 0) {
                    return;
                }
                int i4 = i3 + i2;
                int i5 = this.f3204c[i4] & 31;
                if (i5 == 0) {
                    listUpdateCallback.onInserted(i, 1);
                    for (PostponedUpdate postponedUpdate : list) {
                        postponedUpdate.b++;
                    }
                } else if (i5 == 4 || i5 == 8) {
                    int i6 = this.f3204c[i4] >> 5;
                    listUpdateCallback.onMoved(a(list, i6, true).b, i);
                    if (i5 == 4) {
                        listUpdateCallback.onChanged(i, 1, this.d.getChangePayload(i6, i4));
                    }
                } else if (i5 != 16) {
                    throw new IllegalStateException("unknown flag for pos " + i4 + " " + Long.toBinaryString(i5));
                } else {
                    list.add(new PostponedUpdate(i4, i, false));
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x0101, code lost:
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0101, code lost:
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean a(int r6, int r7, int r8, boolean r9) {
            /*
                Method dump skipped, instructions count: 279
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.DiffUtil.DiffResult.a(int, int, int, boolean):boolean");
        }

        private void b() {
            int i;
            int i2 = this.e;
            int i3 = this.f;
            int size = this.f3203a.size();
            while (true) {
                int i4 = size - 1;
                if (i4 < 0) {
                    return;
                }
                Snake snake = this.f3203a.get(i4);
                int i5 = snake.f3209a;
                int i6 = snake.f3210c;
                int i7 = snake.b;
                int i8 = snake.f3210c;
                if (this.g) {
                    while (true) {
                        if (i2 <= i5 + i6) {
                            break;
                        }
                        a(i2, i3, i4);
                        i2--;
                    }
                    for (i = i3; i > i7 + i8; i--) {
                        b(i2, i, i4);
                    }
                }
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 < snake.f3210c) {
                        int i11 = snake.f3209a + i10;
                        int i12 = snake.b + i10;
                        int i13 = this.d.areContentsTheSame(i11, i12) ? 1 : 2;
                        this.b[i11] = (i12 << 5) | i13;
                        this.f3204c[i12] = (i11 << 5) | i13;
                        i9 = i10 + 1;
                    }
                }
                i2 = snake.f3209a;
                i3 = snake.b;
                size = i4;
            }
        }

        private void b(int i, int i2, int i3) {
            if (this.f3204c[i2 - 1] != 0) {
                return;
            }
            a(i, i2, i3, true);
        }

        private void b(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.g) {
                listUpdateCallback.onRemoved(i, i2);
                return;
            }
            while (true) {
                i2--;
                if (i2 < 0) {
                    return;
                }
                int i4 = i3 + i2;
                int i5 = this.b[i4] & 31;
                if (i5 == 0) {
                    listUpdateCallback.onRemoved(i + i2, 1);
                    for (PostponedUpdate postponedUpdate : list) {
                        postponedUpdate.b--;
                    }
                } else if (i5 == 4 || i5 == 8) {
                    int i6 = this.b[i4] >> 5;
                    PostponedUpdate a2 = a(list, i6, false);
                    listUpdateCallback.onMoved(i + i2, a2.b - 1);
                    if (i5 == 4) {
                        listUpdateCallback.onChanged(a2.b - 1, 1, this.d.getChangePayload(i4, i6));
                    }
                } else if (i5 != 16) {
                    throw new IllegalStateException("unknown flag for pos " + i4 + " " + Long.toBinaryString(i5));
                } else {
                    list.add(new PostponedUpdate(i4, i + i2, true));
                }
            }
        }

        public int convertNewPositionToOld(int i) {
            if (i >= 0 && i < this.f) {
                int i2 = this.f3204c[i];
                if ((i2 & 31) == 0) {
                    return -1;
                }
                return i2 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", new list size = " + this.f);
        }

        public int convertOldPositionToNew(int i) {
            if (i >= 0 && i < this.e) {
                int i2 = this.b[i];
                if ((i2 & 31) == 0) {
                    return -1;
                }
                return i2 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", old list size = " + this.e);
        }

        public void dispatchUpdatesTo(ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            ArrayList arrayList = new ArrayList();
            int i = this.e;
            int i2 = this.f;
            int size = this.f3203a.size();
            while (true) {
                size--;
                if (size < 0) {
                    batchingListUpdateCallback.dispatchLastEvent();
                    return;
                }
                Snake snake = this.f3203a.get(size);
                int i3 = snake.f3210c;
                int i4 = snake.f3209a + i3;
                int i5 = snake.b + i3;
                if (i4 < i) {
                    b(arrayList, batchingListUpdateCallback, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    a(arrayList, batchingListUpdateCallback, i4, i2 - i5, i5);
                }
                int i6 = i3;
                while (true) {
                    int i7 = i6 - 1;
                    if (i7 >= 0) {
                        if ((this.b[snake.f3209a + i7] & 31) == 2) {
                            batchingListUpdateCallback.onChanged(snake.f3209a + i7, 1, this.d.getChangePayload(snake.f3209a + i7, snake.b + i7));
                        }
                        i6 = i7;
                    }
                }
                i = snake.f3209a;
                i2 = snake.b;
            }
        }

        public void dispatchUpdatesTo(RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/DiffUtil$ItemCallback.class */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(T t, T t2);

        public abstract boolean areItemsTheSame(T t, T t2);

        public Object getChangePayload(T t, T t2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/DiffUtil$PostponedUpdate.class */
    public static class PostponedUpdate {

        /* renamed from: a  reason: collision with root package name */
        int f3205a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3206c;

        public PostponedUpdate(int i, int i2, boolean z) {
            this.f3205a = i;
            this.b = i2;
            this.f3206c = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/DiffUtil$Range.class */
    public static class Range {

        /* renamed from: a  reason: collision with root package name */
        int f3207a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f3208c;
        int d;

        public Range() {
        }

        public Range(int i, int i2, int i3, int i4) {
            this.f3207a = i;
            this.b = i2;
            this.f3208c = i3;
            this.d = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/DiffUtil$Snake.class */
    public static class Snake {

        /* renamed from: a  reason: collision with root package name */
        int f3209a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f3210c;
        boolean d;
        boolean e;

        Snake() {
        }
    }

    private DiffUtil() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a1, code lost:
        if (r10[r0 - 1] < r10[r0 + 1]) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0175, code lost:
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0179, code lost:
        r16 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x017d, code lost:
        if (r16 > r14) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0180, code lost:
        r0 = r16 + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x018e, code lost:
        if (r0 == (r14 + r0)) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0198, code lost:
        if (r0 == (r0 + r0)) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x019b, code lost:
        r0 = r12 + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01b0, code lost:
        if (r11[r0 - 1] >= r11[r0 + 1]) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01b6, code lost:
        r9 = r11[(r12 + r0) + 1] - 1;
        r22 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01ca, code lost:
        r9 = r11[(r12 + r0) - 1];
        r22 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01d9, code lost:
        r0 = r9;
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01e0, code lost:
        r0 = r0 - r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01e2, code lost:
        if (r9 <= 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01e7, code lost:
        if (r0 <= 0) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01fa, code lost:
        if (r5.areItemsTheSame((r6 + r9) - 1, (r8 + r0) - 1) == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01fd, code lost:
        r9 = r9 - 1;
        r0 = r0;
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x020c, code lost:
        r0 = r12 + r0;
        r11[r0] = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x021c, code lost:
        if (r13 != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0223, code lost:
        if (r0 < r0) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x022a, code lost:
        if (r0 > r14) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0237, code lost:
        if (r10[r0] < r11[r0]) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x023a, code lost:
        r0 = new androidx.recyclerview.widget.DiffUtil.Snake();
        r0.f3209a = r11[r0];
        r0.b = r0.f3209a - r0;
        r0.f3210c = r10[r0] - r11[r0];
        r0.d = r22;
        r0.e = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0271, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0272, code lost:
        r0 = r16 + 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.recyclerview.widget.DiffUtil.Snake a(androidx.recyclerview.widget.DiffUtil.Callback r5, int r6, int r7, int r8, int r9, int[] r10, int[] r11, int r12) {
        /*
            Method dump skipped, instructions count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.DiffUtil.a(androidx.recyclerview.widget.DiffUtil$Callback, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.DiffUtil$Snake");
    }

    public static DiffResult calculateDiff(Callback callback) {
        return calculateDiff(callback, true);
    }

    public static DiffResult calculateDiff(Callback callback, boolean z) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int abs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int i = abs * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake a2 = a(callback, range.f3207a, range.b, range.f3208c, range.d, iArr, iArr2, abs);
            if (a2 != null) {
                if (a2.f3210c > 0) {
                    arrayList.add(a2);
                }
                a2.f3209a += range.f3207a;
                a2.b += range.f3208c;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.f3207a = range.f3207a;
                range2.f3208c = range.f3208c;
                if (a2.e) {
                    range2.b = a2.f3209a;
                    range2.d = a2.b;
                } else if (a2.d) {
                    range2.b = a2.f3209a - 1;
                    range2.d = a2.b;
                } else {
                    range2.b = a2.f3209a;
                    range2.d = a2.b - 1;
                }
                arrayList2.add(range2);
                if (!a2.e) {
                    range.f3207a = a2.f3209a + a2.f3210c;
                    range.f3208c = a2.b + a2.f3210c;
                } else if (a2.d) {
                    range.f3207a = a2.f3209a + a2.f3210c + 1;
                    range.f3208c = a2.b + a2.f3210c;
                } else {
                    range.f3207a = a2.f3209a + a2.f3210c;
                    range.f3208c = a2.b + a2.f3210c + 1;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, f3202a);
        return new DiffResult(callback, arrayList, iArr, iArr2, z);
    }
}
