package com.blued.android.module.common.utils.gaode;

import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/gaode/PositionPOIModel.class */
public class PositionPOIModel implements Serializable {
    public String address;
    public String area;
    public String city;
    public String distance;
    public String latitude;
    public String longitude;
    public boolean mark_visible;
    public String name;
    public String province;

    public double getLatitude() {
        try {
            return Double.parseDouble(this.latitude);
        } catch (Exception e) {
            return 0.0d;
        }
    }

    public double getLongitude() {
        try {
            return Double.parseDouble(this.longitude);
        } catch (Exception e) {
            return 0.0d;
        }
    }

    public void setLatitude(double d) {
        try {
            this.latitude = String.valueOf(d);
        } catch (Exception e) {
            this.latitude = "0";
        }
    }

    public void setLongitude(double d) {
        try {
            this.longitude = String.valueOf(d);
        } catch (Exception e) {
            this.longitude = "0";
        }
    }
}
