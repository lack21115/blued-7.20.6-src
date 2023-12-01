package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Parcelable;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/TencentMapResource.class */
public interface TencentMapResource {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/TencentMapResource$ResourceFrom.class */
    public @interface ResourceFrom {
        public static final int ASSET = -1;
        public static final int FILE = 2;
        public static final int JSON = 3;
        public static final int RAW = 1;
    }

    BitmapDescriptor createBitmapDescriptor(float f, int i);

    BitmapDescriptor createBitmapDescriptor(int i);

    BitmapDescriptor createBitmapDescriptor(int i, int i2);

    BitmapDescriptor createBitmapDescriptor(Bitmap bitmap, int i);

    BitmapDescriptor createBitmapDescriptor(Parcelable parcelable, int i);

    BitmapDescriptor createBitmapDescriptor(String str, int i);

    BitmapDescriptor createBitmapDescriptor(Bitmap[] bitmapArr, int i);

    MyLocationStyle getDefaultMyLocationStyle();

    int getScreenPixels();

    Typeface getTypeface();
}
