package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/WatermarkSetting.class */
public class WatermarkSetting {
    public static final float CUSTOM_POSITION_NOT_SET = -1.0f;
    public static final String TAG = "WatermarkSetting";
    public boolean inJustDecodeBounds;
    public int mAlpha;
    public Context mContext;
    public float mCustomPositionX;
    public float mCustomPositionY;
    public boolean mIsCustomSizeSet;
    public Bitmap mResourceBitmap;
    public int mResourceId;
    public String mResourcePath;
    public Bitmap mTempBmp;
    public int mWatermarkHeight;
    public WATERMARK_LOCATION mWatermarkLocation;
    public WATERMARK_SIZE mWatermarkSize;
    public int mWatermarkWidth;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/WatermarkSetting$WATERMARK_LOCATION.class */
    public enum WATERMARK_LOCATION {
        NORTH_WEST,
        NORTH_EAST,
        SOUTH_WEST,
        SOUTH_EAST
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/WatermarkSetting$WATERMARK_SIZE.class */
    public enum WATERMARK_SIZE {
        LARGE,
        MEDIUM,
        SMALL
    }

    public WatermarkSetting(Context context) {
        this.mResourceId = -1;
        this.mResourcePath = null;
        this.mWatermarkLocation = WATERMARK_LOCATION.NORTH_EAST;
        this.mWatermarkSize = WATERMARK_SIZE.MEDIUM;
        this.mAlpha = 255;
        this.mWatermarkWidth = 64;
        this.mWatermarkHeight = 64;
        this.inJustDecodeBounds = true;
        this.mIsCustomSizeSet = false;
        this.mCustomPositionX = -1.0f;
        this.mCustomPositionY = -1.0f;
        setContext(context);
    }

    @Deprecated
    public WatermarkSetting(Context context, int i, WATERMARK_LOCATION watermark_location, int i2) {
        this(context, i, watermark_location, (WATERMARK_SIZE) null, i2);
    }

    @Deprecated
    public WatermarkSetting(Context context, int i, WATERMARK_LOCATION watermark_location, WATERMARK_SIZE watermark_size, int i2) {
        this.mResourceId = -1;
        this.mResourcePath = null;
        this.mWatermarkLocation = WATERMARK_LOCATION.NORTH_EAST;
        this.mWatermarkSize = WATERMARK_SIZE.MEDIUM;
        this.mAlpha = 255;
        this.mWatermarkWidth = 64;
        this.mWatermarkHeight = 64;
        this.inJustDecodeBounds = true;
        this.mIsCustomSizeSet = false;
        this.mCustomPositionX = -1.0f;
        this.mCustomPositionY = -1.0f;
        deprecatedInit(context, watermark_location, watermark_size, i2);
        setResourceId(i);
    }

    @Deprecated
    public WatermarkSetting(Context context, String str, WATERMARK_LOCATION watermark_location, WATERMARK_SIZE watermark_size, int i) {
        this.mResourceId = -1;
        this.mResourcePath = null;
        this.mWatermarkLocation = WATERMARK_LOCATION.NORTH_EAST;
        this.mWatermarkSize = WATERMARK_SIZE.MEDIUM;
        this.mAlpha = 255;
        this.mWatermarkWidth = 64;
        this.mWatermarkHeight = 64;
        this.inJustDecodeBounds = true;
        this.mIsCustomSizeSet = false;
        this.mCustomPositionX = -1.0f;
        this.mCustomPositionY = -1.0f;
        deprecatedInit(context, watermark_location, watermark_size, i);
        setResourcePath(str);
    }

    @Deprecated
    private void deprecatedInit(Context context, WATERMARK_LOCATION watermark_location, WATERMARK_SIZE watermark_size, int i) {
        setContext(context);
        setLocation(watermark_location);
        setSize(watermark_size);
        setAlpha(i);
    }

    private Bitmap getBitmap(int i, int i2) {
        Bitmap bitmap = this.mResourceBitmap;
        if (bitmap != null) {
            return h.a(bitmap, i, i2);
        }
        if (this.mResourceId != -1) {
            return h.a(this.mContext.getResources(), this.mResourceId, i, i2);
        }
        String str = this.mResourcePath;
        if (str != null) {
            return h.a(str, i, i2);
        }
        return null;
    }

    private void setContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Illegal context.");
        }
        this.mContext = context.getApplicationContext();
    }

    private void setWidthAndHeight(Bitmap bitmap) {
        if (this.mIsCustomSizeSet) {
            return;
        }
        if (this.inJustDecodeBounds) {
            this.mWatermarkWidth = 64;
        } else {
            this.mWatermarkWidth = h.a(bitmap.getWidth());
        }
        int round = Math.round(((this.mWatermarkWidth * bitmap.getHeight()) * 1.0f) / bitmap.getWidth());
        this.mWatermarkHeight = round;
        this.mWatermarkHeight = h.a(round);
    }

    public Pair<Float, Float> calculateWHRatio(int i, int i2) {
        float f;
        if (this.mIsCustomSizeSet) {
            int i3 = this.mWatermarkWidth;
            float f2 = 1.0f;
            float f3 = i3 < i ? i3 / i : 1.0f;
            int i4 = this.mWatermarkHeight;
            if (i4 < i2) {
                f2 = i4 / i2;
            }
            return new Pair<>(Float.valueOf(f3), Float.valueOf(f2));
        }
        float bmpWidth = getBmpWidth() / getBmpHeight();
        float f4 = WATERMARK_SIZE.MEDIUM == getWatermarkSize() ? 0.3f : WATERMARK_SIZE.SMALL == getWatermarkSize() ? 0.2f : 0.4f;
        if (i < i2) {
            f4 = (i / i2) * f4;
            f = f4 * bmpWidth;
        } else {
            f = bmpWidth * f4 * (i2 / i);
        }
        return new Pair<>(Float.valueOf(f / 2.0f), Float.valueOf(f4 / 2.0f));
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getBmpHeight() {
        return this.mWatermarkHeight;
    }

    public int getBmpWidth() {
        return this.mWatermarkWidth;
    }

    public float getCustomPositionX() {
        return this.mCustomPositionX;
    }

    public float getCustomPositionY() {
        return this.mCustomPositionY;
    }

    public Bitmap getSWWatermakBitmap(int i, int i2) {
        if (this.mContext == null) {
            return null;
        }
        int i3 = 64;
        int i4 = this.inJustDecodeBounds ? 64 : -1;
        if (!this.inJustDecodeBounds) {
            i3 = -1;
        }
        Bitmap bitmap = getBitmap(i4, i3);
        if (bitmap == null) {
            return null;
        }
        setWidthAndHeight(bitmap);
        Pair<Float, Float> calculateWHRatio = calculateWHRatio(i, i2);
        int a2 = h.a(i * calculateWHRatio.first.floatValue());
        int a3 = h.a(i2 * calculateWHRatio.second.floatValue());
        Bitmap bitmap2 = getBitmap(i, i2);
        if (bitmap2 == null) {
            return null;
        }
        e.h.c(TAG, "create scaled bitmap original width:" + bitmap2.getWidth() + " height:" + bitmap2.getHeight() + " scale to width:" + a2 + " height:" + a3);
        this.mTempBmp = Bitmap.createScaledBitmap(bitmap2, a2, a3, true);
        if (!bitmap2.isRecycled()) {
            bitmap2.recycle();
        }
        return this.mTempBmp;
    }

    public Bitmap getWatermarkBitmap() {
        if (this.mContext != null) {
            int i = 64;
            int i2 = this.inJustDecodeBounds ? 64 : -1;
            if (!this.inJustDecodeBounds) {
                i = -1;
            }
            Bitmap bitmap = getBitmap(i2, i);
            if (bitmap == null) {
                return null;
            }
            setWidthAndHeight(bitmap);
            e.f1313c.c(TAG, "mWatermarkWidth:" + this.mWatermarkWidth + ",mWatermarkHeight:" + this.mWatermarkHeight);
            return Bitmap.createScaledBitmap(bitmap, this.mWatermarkWidth, this.mWatermarkHeight, true);
        }
        return null;
    }

    public WATERMARK_LOCATION getWatermarkLocation() {
        return this.mWatermarkLocation;
    }

    public WATERMARK_SIZE getWatermarkSize() {
        return this.mWatermarkSize;
    }

    public boolean isCustomPositionSet() {
        return (this.mCustomPositionX == -1.0f && this.mCustomPositionY == -1.0f) ? false : true;
    }

    public void release() {
        Bitmap bitmap = this.mTempBmp;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mTempBmp.recycle();
        }
        this.mTempBmp = null;
    }

    public WatermarkSetting setAlpha(int i) {
        if (i >= 0 && i <= 255) {
            this.mAlpha = i;
            return this;
        }
        throw new IllegalArgumentException("alpha value should be [0...255]:" + i);
    }

    public WatermarkSetting setCustomPosition(float f, float f2) {
        if (f < 0.0f || f > 1.0f || f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("position values MUST be [0.0f-1.0f]");
        }
        this.mCustomPositionX = f;
        this.mCustomPositionY = f2;
        this.mWatermarkLocation = null;
        return this;
    }

    public WatermarkSetting setCustomSize(int i, int i2) {
        this.mWatermarkWidth = i;
        this.mWatermarkHeight = i2;
        this.mIsCustomSizeSet = true;
        return this;
    }

    public WatermarkSetting setInJustDecodeBoundsEnabled(boolean z) {
        this.inJustDecodeBounds = z;
        return this;
    }

    public WatermarkSetting setLocation(WATERMARK_LOCATION watermark_location) {
        if (watermark_location != null) {
            this.mWatermarkLocation = watermark_location;
            this.mCustomPositionX = -1.0f;
            this.mCustomPositionY = -1.0f;
            return this;
        }
        throw new IllegalArgumentException("Illegal watermark location.");
    }

    public WatermarkSetting setResourceBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.mResourceBitmap = bitmap;
            this.mResourceId = -1;
            this.mResourcePath = null;
            return this;
        }
        throw new IllegalArgumentException("Illegal resource bitmap");
    }

    public WatermarkSetting setResourceId(int i) {
        if (i >= 0) {
            this.mResourceId = i;
            this.mResourcePath = null;
            this.mResourceBitmap = null;
            return this;
        }
        throw new IllegalArgumentException("Illegal resource id.");
    }

    public WatermarkSetting setResourcePath(String str) {
        if (str != null) {
            this.mResourcePath = str;
            this.mResourceId = -1;
            this.mResourceBitmap = null;
            return this;
        }
        throw new IllegalArgumentException("Illegal resource path.");
    }

    public WatermarkSetting setSize(WATERMARK_SIZE watermark_size) {
        if (watermark_size != null) {
            this.mWatermarkSize = watermark_size;
            return this;
        }
        this.mWatermarkSize = WATERMARK_SIZE.MEDIUM;
        return this;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Size", this.mWatermarkSize);
            jSONObject.put("PositionX", this.mCustomPositionX);
            jSONObject.put("PositionY", this.mCustomPositionY);
            jSONObject.put("WatermarkLocation", this.mWatermarkLocation);
            jSONObject.put("Alpha", this.mAlpha);
            jSONObject.put("JustDecodeBounds", this.inJustDecodeBounds);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
