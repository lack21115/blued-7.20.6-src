package com.sina.weibo.sdk.call;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/call/Position.class */
public class Position {
    private float mLatitude;
    private float mLongitude;
    private boolean mOffset;

    public Position(float f, float f2) {
        this.mLongitude = f;
        this.mLatitude = f2;
        this.mOffset = true;
    }

    public Position(float f, float f2, boolean z) {
        this.mLongitude = f;
        this.mLatitude = f2;
        this.mOffset = z;
    }

    boolean checkValid() {
        if (Float.isNaN(this.mLongitude)) {
            return false;
        }
        float f = this.mLongitude;
        if (f < -180.0f || f > 180.0f || Float.isNaN(this.mLatitude)) {
            return false;
        }
        float f2 = this.mLatitude;
        return f2 >= -180.0f && f2 <= 180.0f;
    }

    public float getLatitude() {
        return this.mLatitude;
    }

    public float getLongitude() {
        return this.mLongitude;
    }

    public String getStrLatitude() {
        return String.valueOf(this.mLatitude);
    }

    public String getStrLongitude() {
        return String.valueOf(this.mLongitude);
    }

    public String getStrOffset() {
        return this.mOffset ? "1" : "0";
    }

    public boolean isOffset() {
        return this.mOffset;
    }
}
