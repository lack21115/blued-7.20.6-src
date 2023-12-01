package androidx.palette.graphics;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/palette/graphics/ColorCutQuantizer.class */
public final class ColorCutQuantizer {
    private static final Comparator<Vbox> g = new Comparator<Vbox>() { // from class: androidx.palette.graphics.ColorCutQuantizer.1
        @Override // java.util.Comparator
        public int compare(Vbox vbox, Vbox vbox2) {
            return vbox2.a() - vbox.a();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int[] f3136a;
    final int[] b;

    /* renamed from: c  reason: collision with root package name */
    final List<Palette.Swatch> f3137c;
    final Palette.Filter[] e;
    private final float[] f = new float[3];
    final TimingLogger d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/palette/graphics/ColorCutQuantizer$Vbox.class */
    public class Vbox {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f3139c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;

        Vbox(int i, int i2) {
            this.b = i;
            this.f3139c = i2;
            d();
        }

        final int a() {
            return ((this.f - this.e) + 1) * ((this.h - this.g) + 1) * ((this.j - this.i) + 1);
        }

        final boolean b() {
            return c() > 1;
        }

        final int c() {
            return (this.f3139c + 1) - this.b;
        }

        final void d() {
            int[] iArr = ColorCutQuantizer.this.f3136a;
            int[] iArr2 = ColorCutQuantizer.this.b;
            int i = this.b;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i > this.f3139c) {
                    this.e = i2;
                    this.f = i5;
                    this.g = i3;
                    this.h = i6;
                    this.i = i4;
                    this.j = i7;
                    this.d = i9;
                    return;
                }
                int i10 = iArr[i];
                int i11 = i9 + iArr2[i10];
                int a2 = ColorCutQuantizer.a(i10);
                int b = ColorCutQuantizer.b(i10);
                int c2 = ColorCutQuantizer.c(i10);
                int i12 = i5;
                if (a2 > i5) {
                    i12 = a2;
                }
                int i13 = i2;
                if (a2 < i2) {
                    i13 = a2;
                }
                int i14 = i6;
                if (b > i6) {
                    i14 = b;
                }
                int i15 = i3;
                if (b < i3) {
                    i15 = b;
                }
                int i16 = i7;
                if (c2 > i7) {
                    i16 = c2;
                }
                int i17 = i4;
                if (c2 < i4) {
                    i17 = c2;
                }
                i++;
                i2 = i13;
                i3 = i15;
                i4 = i17;
                i5 = i12;
                i6 = i14;
                i7 = i16;
                i8 = i11;
            }
        }

        final Vbox e() {
            if (b()) {
                int g = g();
                Vbox vbox = new Vbox(g + 1, this.f3139c);
                this.f3139c = g;
                d();
                return vbox;
            }
            throw new IllegalStateException("Can not split a box with only 1 color");
        }

        final int f() {
            int i = this.f - this.e;
            int i2 = this.h - this.g;
            int i3 = this.j - this.i;
            if (i < i2 || i < i3) {
                return (i2 < i || i2 < i3) ? -1 : -2;
            }
            return -3;
        }

        final int g() {
            int f = f();
            int[] iArr = ColorCutQuantizer.this.f3136a;
            int[] iArr2 = ColorCutQuantizer.this.b;
            ColorCutQuantizer.a(iArr, f, this.b, this.f3139c);
            Arrays.sort(iArr, this.b, this.f3139c + 1);
            ColorCutQuantizer.a(iArr, f, this.b, this.f3139c);
            int i = this.d / 2;
            int i2 = this.b;
            int i3 = 0;
            while (true) {
                int i4 = this.f3139c;
                if (i2 > i4) {
                    return this.b;
                }
                i3 += iArr2[iArr[i2]];
                if (i3 >= i) {
                    return Math.min(i4 - 1, i2);
                }
                i2++;
            }
        }

        final Palette.Swatch h() {
            int[] iArr = ColorCutQuantizer.this.f3136a;
            int[] iArr2 = ColorCutQuantizer.this.b;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = this.b; i5 <= this.f3139c; i5++) {
                int i6 = iArr[i5];
                int i7 = iArr2[i6];
                i2 += i7;
                i += ColorCutQuantizer.a(i6) * i7;
                i3 += ColorCutQuantizer.b(i6) * i7;
                i4 += i7 * ColorCutQuantizer.c(i6);
            }
            float f = i2;
            return new Palette.Swatch(ColorCutQuantizer.a(Math.round(i / f), Math.round(i3 / f), Math.round(i4 / f)), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorCutQuantizer(int[] iArr, int i, Palette.Filter[] filterArr) {
        int i2;
        this.e = filterArr;
        int[] iArr2 = new int[32768];
        this.b = iArr2;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= iArr.length) {
                break;
            }
            int f = f(iArr[i4]);
            iArr[i4] = f;
            iArr2[f] = iArr2[f] + 1;
            i3 = i4 + 1;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i2 = i6;
            if (i5 >= 32768) {
                break;
            }
            if (iArr2[i5] > 0 && e(i5)) {
                iArr2[i5] = 0;
            }
            int i7 = i2;
            if (iArr2[i5] > 0) {
                i7 = i2 + 1;
            }
            i5++;
            i6 = i7;
        }
        int[] iArr3 = new int[i2];
        this.f3136a = iArr3;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i8 >= 32768) {
                break;
            }
            int i11 = i10;
            if (iArr2[i8] > 0) {
                iArr3[i10] = i8;
                i11 = i10 + 1;
            }
            i8++;
            i9 = i11;
        }
        if (i2 > i) {
            this.f3137c = d(i);
            return;
        }
        this.f3137c = new ArrayList();
        int i12 = 0;
        while (true) {
            int i13 = i12;
            if (i13 >= i2) {
                return;
            }
            int i14 = iArr3[i13];
            this.f3137c.add(new Palette.Swatch(g(i14), iArr2[i14]));
            i12 = i13 + 1;
        }
    }

    static int a(int i) {
        return (i >> 10) & 31;
    }

    static int a(int i, int i2, int i3) {
        return Color.rgb(b(i, 5, 8), b(i2, 5, 8), b(i3, 5, 8));
    }

    private List<Palette.Swatch> a(Collection<Vbox> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Vbox vbox : collection) {
            Palette.Swatch h = vbox.h();
            if (!a(h)) {
                arrayList.add(h);
            }
        }
        return arrayList;
    }

    private void a(PriorityQueue<Vbox> priorityQueue, int i) {
        Vbox poll;
        while (priorityQueue.size() < i && (poll = priorityQueue.poll()) != null && poll.b()) {
            priorityQueue.offer(poll.e());
            priorityQueue.offer(poll);
        }
    }

    static void a(int[] iArr, int i, int i2, int i3) {
        if (i == -2) {
            for (int i4 = i2; i4 <= i3; i4++) {
                int i5 = iArr[i4];
                iArr[i4] = c(i5) | (b(i5) << 10) | (a(i5) << 5);
            }
        } else if (i == -1) {
            while (i2 <= i3) {
                int i6 = iArr[i2];
                iArr[i2] = a(i6) | (c(i6) << 10) | (b(i6) << 5);
                i2++;
            }
        }
    }

    private boolean a(int i, float[] fArr) {
        Palette.Filter[] filterArr = this.e;
        if (filterArr == null || filterArr.length <= 0) {
            return false;
        }
        int length = filterArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (!this.e[i3].isAllowed(i, fArr)) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    private boolean a(Palette.Swatch swatch) {
        return a(swatch.getRgb(), swatch.getHsl());
    }

    static int b(int i) {
        return (i >> 5) & 31;
    }

    private static int b(int i, int i2, int i3) {
        return (i3 > i2 ? i << (i3 - i2) : i >> (i2 - i3)) & ((1 << i3) - 1);
    }

    static int c(int i) {
        return i & 31;
    }

    private List<Palette.Swatch> d(int i) {
        PriorityQueue<Vbox> priorityQueue = new PriorityQueue<>(i, g);
        priorityQueue.offer(new Vbox(0, this.f3136a.length - 1));
        a(priorityQueue, i);
        return a(priorityQueue);
    }

    private boolean e(int i) {
        int g2 = g(i);
        ColorUtils.colorToHSL(g2, this.f);
        return a(g2, this.f);
    }

    private static int f(int i) {
        return b(Color.blue(i), 8, 5) | (b(Color.red(i), 8, 5) << 10) | (b(Color.green(i), 8, 5) << 5);
    }

    private static int g(int i) {
        return a(a(i), b(i), c(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Palette.Swatch> a() {
        return this.f3137c;
    }
}
