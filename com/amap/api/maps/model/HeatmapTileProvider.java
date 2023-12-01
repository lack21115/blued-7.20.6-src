package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import androidx.collection.LongSparseArray;
import com.amap.api.col.p0003sl.df;
import com.amap.api.maps.AMapException;
import com.autonavi.amap.mapcore.DPoint;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/HeatmapTileProvider.class */
public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int MAX_RADIUS = 50;
    private static final int MAX_ZOOM_LEVEL = 21;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 256;
    private df mBounds;
    private int[] mColorMap;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private a mTree;

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/HeatmapTileProvider$Builder.class */
    public static class Builder {
        private Collection<WeightedLatLng> data;
        private int radius = 12;
        private Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double opacity = 0.6d;

        public HeatmapTileProvider build() {
            Collection<WeightedLatLng> collection = this.data;
            if (collection != null && collection.size() != 0) {
                try {
                    return new HeatmapTileProvider(this, (byte) 0);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            try {
                throw new AMapException("No input points.");
            } catch (AMapException e) {
                Log.e("amap", e.getErrorMessage());
                e.printStackTrace();
                return null;
            }
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.c(collection));
        }

        public Builder gradient(Gradient gradient) {
            this.gradient = gradient;
            return this;
        }

        public Builder radius(int i) {
            this.radius = Math.max(10, Math.min(i, 50));
            return this;
        }

        public Builder transparency(double d) {
            this.opacity = Math.max(0.0d, Math.min(d, 1.0d));
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.data = collection;
            return this;
        }
    }

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        Gradient gradient = builder.gradient;
        this.mGradient = gradient;
        if (gradient == null || !gradient.isAvailable()) {
            this.mGradient = DEFAULT_GRADIENT;
        }
        this.mOpacity = builder.opacity;
        int i = this.mRadius;
        this.mKernel = a(i, i / 3.0d);
        a(this.mGradient);
        b(this.mData);
    }

    /* synthetic */ HeatmapTileProvider(Builder builder, byte b) {
        this(builder);
    }

    private static double a(Collection<WeightedLatLng> collection, df dfVar, int i, int i2) {
        double d = dfVar.a;
        double d2 = dfVar.c;
        double d3 = dfVar.b;
        double d4 = d2 - d;
        double d5 = dfVar.d - d3;
        if (d4 <= d5) {
            d4 = d5;
        }
        double d6 = ((int) ((i2 / (i * 2)) + 0.5d)) / d4;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d7 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            double d8 = weightedLatLng.getPoint().x;
            double d9 = weightedLatLng.getPoint().y;
            int i3 = (int) ((d8 - d) * d6);
            int i4 = (int) ((d9 - d3) * d6);
            long j = i3;
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j);
            LongSparseArray longSparseArray3 = longSparseArray2;
            if (longSparseArray2 == null) {
                longSparseArray3 = new LongSparseArray();
                longSparseArray.put(j, longSparseArray3);
            }
            long j2 = i4;
            Double d10 = (Double) longSparseArray3.get(j2);
            Double d11 = d10;
            if (d10 == null) {
                d11 = Double.valueOf(0.0d);
            }
            Double valueOf = Double.valueOf(d11.doubleValue() + weightedLatLng.intensity);
            longSparseArray3.put(j2, valueOf);
            double d12 = d7;
            if (valueOf.doubleValue() > d7) {
                d12 = valueOf.doubleValue();
            }
            d7 = d12;
        }
        return d7;
    }

    private static Bitmap a(double[][] dArr, int[] iArr, double d) {
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

    private static Tile a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Tile.obtain(256, 256, byteArrayOutputStream.toByteArray());
    }

    private void a(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    private double[] a(int i) {
        int i2;
        double[] dArr = new double[21];
        int i3 = 5;
        while (true) {
            int i4 = i3;
            if (i4 >= 11) {
                break;
            }
            dArr[i4] = a(this.mData, this.mBounds, i, (int) (Math.pow(2.0d, i4) * 1280.0d));
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
        for (i2 = 11; i2 < 21; i2++) {
            dArr[i2] = dArr[10];
        }
        return dArr;
    }

    private static double[] a(int i, double d) {
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

    private static double[][] a(double[][] dArr, double[] dArr2) {
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

    private void b(Collection<WeightedLatLng> collection) {
        try {
            ArrayList arrayList = new ArrayList();
            for (WeightedLatLng weightedLatLng : collection) {
                if (weightedLatLng.latLng.latitude < 85.0d && weightedLatLng.latLng.latitude > -85.0d) {
                    arrayList.add(weightedLatLng);
                }
            }
            this.mData = arrayList;
            df d = d(arrayList);
            this.mBounds = d;
            this.mTree = new a(d);
            for (WeightedLatLng weightedLatLng2 : this.mData) {
                this.mTree.a(weightedLatLng2);
            }
            this.mMaxIntensity = a(this.mRadius);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> c(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : collection) {
            arrayList.add(new WeightedLatLng(latLng));
        }
        return arrayList;
    }

    private static df d(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d = next.getPoint().x;
        double d2 = next.getPoint().x;
        double d3 = next.getPoint().y;
        double d4 = next.getPoint().y;
        double d5 = d;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d6 = next2.getPoint().x;
            double d7 = next2.getPoint().y;
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
        return new df(d5, d2, d3, d4);
    }

    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int i, int i2, int i3) {
        int i4;
        double d;
        double pow = 1.0d / Math.pow(2.0d, i3);
        double d2 = (this.mRadius * pow) / 256.0d;
        double d3 = ((2.0d * d2) + pow) / ((i4 * 2) + 256);
        double d4 = (i * pow) - d2;
        double d5 = ((i + 1) * pow) + d2;
        double d6 = (i2 * pow) - d2;
        double d7 = ((i2 + 1) * pow) + d2;
        ArrayList<WeightedLatLng> arrayList = new ArrayList();
        if (d4 < 0.0d) {
            d = -1.0d;
            arrayList = this.mTree.a(new df(d4 + 1.0d, 1.0d, d6, d7));
        } else {
            d = 1.0d;
            if (d5 > 1.0d) {
                arrayList = this.mTree.a(new df(0.0d, d5 - 1.0d, d6, d7));
            } else {
                d = 0.0d;
            }
        }
        df dfVar = new df(d4, d5, d6, d7);
        if (dfVar.a(new df(this.mBounds.a - d2, this.mBounds.c + d2, this.mBounds.b - d2, this.mBounds.d + d2))) {
            Collection<WeightedLatLng> a = this.mTree.a(dfVar);
            if (a.isEmpty()) {
                return TileProvider.NO_TILE;
            }
            int i5 = this.mRadius;
            double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, (i5 * 2) + 256, (i5 * 2) + 256);
            for (WeightedLatLng weightedLatLng : a) {
                DPoint point = weightedLatLng.getPoint();
                int i6 = (int) ((point.x - d4) / d3);
                int i7 = (int) ((point.y - d6) / d3);
                double[] dArr2 = dArr[i6];
                dArr2[i7] = dArr2[i7] + weightedLatLng.intensity;
            }
            for (WeightedLatLng weightedLatLng2 : arrayList) {
                DPoint point2 = weightedLatLng2.getPoint();
                int i8 = (int) (((point2.x + d) - d4) / d3);
                int i9 = (int) ((point2.y - d6) / d3);
                double[] dArr3 = dArr[i8];
                dArr3[i9] = dArr3[i9] + weightedLatLng2.intensity;
            }
            return a(a(a(dArr, this.mKernel), this.mColorMap, this.mMaxIntensity[i3]));
        }
        return TileProvider.NO_TILE;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }
}
