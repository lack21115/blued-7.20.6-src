package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import com.tencent.map.sdk.utilities.heatmap.Gradient;
import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.mapsdk.internal.ca;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Tile;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/y1.class */
public class y1 extends HeatMapTileProvider {
    private static final boolean m = false;
    private static final int n = 256;
    private static final int o = 1280;
    private static final int p = 5;
    private static final int q = 11;
    private static final int r = 22;
    public static final double s = 1.0d;

    /* renamed from: a  reason: collision with root package name */
    private final HeatMapTileProvider.OnHeatMapReadyListener f24431a;
    private HeatMapTileProvider.HeatTileGenerator b;

    /* renamed from: c  reason: collision with root package name */
    private y5<z1> f24432c;
    private Collection<z1> d;
    private o5 e;
    private int f;
    private Gradient g;
    private int[] h;
    private double[] i;
    private double j;
    private double[] k;
    private boolean l;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/y1$a.class */
    public class a extends ca.i<Boolean> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            if (y1.this.l) {
                return Boolean.FALSE;
            }
            if (y1.this.b != null) {
                y1 y1Var = y1.this;
                y1Var.i = y1Var.b.generateKernel(y1.this.f);
            } else {
                y1 y1Var2 = y1.this;
                y1Var2.i = y1.a(y1Var2.f, y1.this.f / 3.0d);
            }
            y1 y1Var3 = y1.this;
            y1Var3.setGradient(y1Var3.g);
            y1 y1Var4 = y1.this;
            y1Var4.b(y1Var4.d);
            y1.this.l = true;
            if (y1.this.f24431a != null) {
                y1.this.f24431a.onHeatMapReady();
            }
            return Boolean.TRUE;
        }
    }

    public y1(HeatMapTileProvider.Builder builder) {
        this.d = c(builder.getData());
        this.f = builder.getRadius();
        this.g = builder.getGradient();
        this.j = builder.getOpacity();
        this.f24431a = builder.getReadyListener();
        this.b = builder.getHeatTileGenerator();
        a();
    }

    public static double a(Collection<z1> collection, o5 o5Var, int i, int i2) {
        double d = o5Var.f23983a;
        double d2 = o5Var.f23984c;
        double d3 = o5Var.b;
        double d4 = d2 - d;
        double d5 = o5Var.d - d3;
        if (d4 <= d5) {
            d4 = d5;
        }
        double d6 = ((int) ((i2 / (i * 2)) + 0.5d)) / d4;
        HashMap hashMap = new HashMap();
        double d7 = 0.0d;
        for (z1 z1Var : collection) {
            double d8 = z1Var.a().b;
            double d9 = z1Var.a().f23992c;
            int i3 = (int) ((d8 - d) * d6);
            int i4 = (int) ((d9 - d3) * d6);
            Map map = (Map) hashMap.get(Integer.valueOf(i3));
            HashMap hashMap2 = map;
            if (map == null) {
                hashMap2 = new HashMap();
                hashMap.put(Integer.valueOf(i3), hashMap2);
            }
            Double d10 = (Double) hashMap2.get(Integer.valueOf(i4));
            Double d11 = d10;
            if (d10 == null) {
                d11 = Double.valueOf(0.0d);
            }
            Double valueOf = Double.valueOf(d11.doubleValue() + z1Var.b());
            hashMap2.put(Integer.valueOf(i4), valueOf);
            if (valueOf.doubleValue() > d7) {
                d7 = valueOf.doubleValue();
            }
        }
        return d7;
    }

    public static Bitmap a(double[][] dArr, int[] iArr, double d) {
        int i = iArr[iArr.length - 1];
        double length = (iArr.length - 1) / d;
        int length2 = dArr.length;
        int[] iArr2 = new int[length2 * length2];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length2) {
                Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
                createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
                return createBitmap;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < length2) {
                    double d2 = dArr[i5][i3];
                    int i6 = (i3 * length2) + i5;
                    int i7 = (int) (d2 * length);
                    if (d2 == 0.0d) {
                        iArr2[i6] = 0;
                    } else if (i7 < iArr.length) {
                        iArr2[i6] = iArr[i7];
                    } else {
                        iArr2[i6] = i;
                    }
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 1;
        }
    }

    public static o5 a(Collection<z1> collection) {
        Iterator<z1> it = collection.iterator();
        z1 next = it.next();
        double d = next.a().b;
        double d2 = next.a().b;
        double d3 = next.a().f23992c;
        double d4 = next.a().f23992c;
        double d5 = d;
        while (it.hasNext()) {
            z1 next2 = it.next();
            double d6 = next2.a().b;
            double d7 = next2.a().f23992c;
            double d8 = d5;
            if (d6 < d5) {
                d8 = d6;
            }
            double d9 = d2;
            if (d6 > d2) {
                d9 = d6;
            }
            double d10 = d3;
            if (d7 < d3) {
                d10 = d7;
            }
            d5 = d8;
            d2 = d9;
            d3 = d10;
            if (d7 > d4) {
                d4 = d7;
                d5 = d8;
                d2 = d9;
                d3 = d10;
            }
        }
        return new o5(d5, d2, d3, d4);
    }

    private static Tile a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new Tile(256, 256, byteArrayOutputStream.toByteArray());
    }

    private void a() {
        if (this.d != null) {
            ca.a((ca.i) new a()).b((ca.d.b) Boolean.FALSE);
        }
    }

    private double[] a(int i) {
        int i2;
        double[] dArr = new double[22];
        int i3 = 5;
        while (true) {
            int i4 = i3;
            if (i4 >= 11) {
                break;
            }
            dArr[i4] = a(this.d, this.e, i, (int) (Math.pow(2.0d, i4 - 3) * 1280.0d));
            if (i4 == 5) {
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 < i4) {
                        dArr[i6] = dArr[i4];
                        i5 = i6 + 1;
                    }
                }
            }
            i3 = i4 + 1;
        }
        for (i2 = 11; i2 < 22; i2++) {
            dArr[i2] = dArr[10];
        }
        return dArr;
    }

    public static double[] a(int i, double d) {
        double[] dArr = new double[(i * 2) + 1];
        int i2 = -i;
        while (true) {
            int i3 = i2;
            if (i3 > i) {
                return dArr;
            }
            dArr[i3 + i] = Math.exp(((-i3) * i3) / ((2.0d * d) * d));
            i2 = i3 + 1;
        }
    }

    public static double[][] a(double[][] dArr, double[] dArr2) {
        int floor = (int) Math.floor(dArr2.length / 2.0d);
        int length = dArr.length;
        int i = length - (floor * 2);
        int i2 = (floor + i) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, length, length);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                break;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < length) {
                    double d = dArr[i4][i6];
                    if (d != 0.0d) {
                        int i7 = i4 + floor;
                        int i8 = i7;
                        if (i2 < i7) {
                            i8 = i2;
                        }
                        int i9 = i4 - floor;
                        int i10 = floor > i9 ? floor : i9;
                        while (true) {
                            int i11 = i10;
                            if (i11 < i8 + 1) {
                                double[] dArr4 = dArr3[i11];
                                dArr4[i6] = dArr4[i6] + (dArr2[i11 - i9] * d);
                                i10 = i11 + 1;
                            }
                        }
                    }
                    i5 = i6 + 1;
                }
            }
            i3 = i4 + 1;
        }
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, i, i);
        int i12 = floor;
        while (true) {
            int i13 = i12;
            if (i13 >= i2 + 1) {
                return dArr5;
            }
            int i14 = 0;
            while (true) {
                int i15 = i14;
                if (i15 < length) {
                    double d2 = dArr3[i13][i15];
                    if (d2 != 0.0d) {
                        int i16 = i15 + floor;
                        int i17 = i16;
                        if (i2 < i16) {
                            i17 = i2;
                        }
                        int i18 = i15 - floor;
                        int i19 = floor > i18 ? floor : i18;
                        while (true) {
                            int i20 = i19;
                            if (i20 < i17 + 1) {
                                double[] dArr6 = dArr5[i13 - floor];
                                int i21 = i20 - floor;
                                dArr6[i21] = dArr6[i21] + (dArr2[i20 - i18] * d2);
                                i19 = i20 + 1;
                            }
                        }
                    }
                    i14 = i15 + 1;
                }
            }
            i12 = i13 + 1;
        }
    }

    private static <T extends WeightedLatLng> Collection<z1> c(Collection<T> collection) {
        ArrayList arrayList = new ArrayList();
        for (T t : collection) {
            arrayList.add(new z1(t.getPoint(), t.getIntensity()));
        }
        return arrayList;
    }

    private static Collection<z1> wrapData(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : collection) {
            arrayList.add(new z1(latLng));
        }
        return arrayList;
    }

    public void b(Collection<z1> collection) {
        this.d = collection;
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("No input points.");
        }
        o5 a2 = a(this.d);
        this.e = a2;
        this.f24432c = new y5<>(a2);
        for (z1 z1Var : this.d) {
            this.f24432c.a((y5<z1>) z1Var);
        }
        this.k = a(this.f);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileProvider
    public Tile getTile(int i, int i2, int i3) {
        int i4;
        double d;
        if (!this.l) {
            na.g("TileOverlay", "热力图未初始化完成，返回空瓦块");
            return TileProvider.NO_TILE;
        }
        double pow = 1.0d / Math.pow(2.0d, i3);
        double d2 = (this.f * pow) / 256.0d;
        double d3 = ((2.0d * d2) + pow) / ((i4 * 2) + 256);
        double d4 = (i * pow) - d2;
        double d5 = ((i + 1) * pow) + d2;
        double d6 = (i2 * pow) - d2;
        double d7 = ((i2 + 1) * pow) + d2;
        ArrayList<z1> arrayList = new ArrayList();
        if (d4 < 0.0d) {
            arrayList = this.f24432c.a(new o5(d4 + 1.0d, 1.0d, d6, d7));
            d = -1.0d;
        } else if (d5 > 1.0d) {
            arrayList = this.f24432c.a(new o5(0.0d, d5 - 1.0d, d6, d7));
            d = 1.0d;
        } else {
            d = 0.0d;
        }
        o5 o5Var = new o5(d4, d5, d6, d7);
        o5 o5Var2 = this.e;
        if (!o5Var.b(new o5(o5Var2.f23983a - d2, o5Var2.f23984c + d2, o5Var2.b - d2, o5Var2.d + d2))) {
            na.g("TileOverlay", "热力图超出有效边界，返回空瓦块-" + i + ":" + i2 + ":" + i3);
            return TileProvider.NO_TILE;
        }
        Collection<z1> a2 = this.f24432c.a(o5Var);
        if (a2.isEmpty()) {
            na.g("TileOverlay", "热力图没有热力数据，返回空瓦块-" + i + ":" + i2 + ":" + i3);
            return TileProvider.NO_TILE;
        }
        int i5 = (this.f * 2) + 256;
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, i5, i5);
        for (z1 z1Var : a2) {
            p5 a3 = z1Var.a();
            int i6 = (int) ((a3.b - d4) / d3);
            int i7 = (int) ((a3.f23992c - d6) / d3);
            double[] dArr2 = dArr[i6];
            dArr2[i7] = dArr2[i7] + z1Var.b();
        }
        for (z1 z1Var2 : arrayList) {
            p5 a4 = z1Var2.a();
            int i8 = (int) (((a4.b + d) - d4) / d3);
            int i9 = (int) ((a4.f23992c - d6) / d3);
            double[] dArr3 = dArr[i8];
            dArr3[i9] = dArr3[i9] + z1Var2.b();
        }
        return a(a(a(dArr, this.i), this.h, this.k[i3]));
    }

    @Override // com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
    public void setData(Collection<LatLng> collection) {
        b(wrapData(collection));
    }

    @Override // com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
    public void setGradient(Gradient gradient) {
        this.g = gradient;
        HeatMapTileProvider.HeatTileGenerator heatTileGenerator = this.b;
        if (heatTileGenerator != null) {
            this.h = heatTileGenerator.generateColorMap(this.j);
        } else {
            this.h = gradient.generateColorMap(this.j);
        }
    }

    @Override // com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
    public void setHeatTileGenerator(HeatMapTileProvider.HeatTileGenerator heatTileGenerator) {
        this.b = heatTileGenerator;
        if (heatTileGenerator != null) {
            this.i = heatTileGenerator.generateKernel(this.f);
            this.h = this.b.generateColorMap(this.j);
        }
    }

    @Override // com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
    public void setOpacity(double d) {
        this.j = d;
        setGradient(this.g);
    }

    @Override // com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
    public void setRadius(int i) {
        if (i <= 0) {
            return;
        }
        this.f = i;
        HeatMapTileProvider.HeatTileGenerator heatTileGenerator = this.b;
        if (heatTileGenerator != null) {
            this.i = heatTileGenerator.generateKernel(i);
        } else {
            this.i = a(i, i / 3.0d);
        }
        this.k = a(this.f);
    }

    @Override // com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
    public <T extends WeightedLatLng> void setWeightedData(Collection<T> collection) {
        b(c(collection));
    }
}
