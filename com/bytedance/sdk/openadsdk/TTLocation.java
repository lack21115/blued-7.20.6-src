package com.bytedance.sdk.openadsdk;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTLocation.class */
public class TTLocation implements LocationProvider {
    private double mb;
    private double ox;

    public TTLocation(double d, double d2) {
        this.mb = 0.0d;
        this.ox = 0.0d;
        this.mb = d;
        this.ox = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.mb;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.ox;
    }

    public void setLatitude(double d) {
        this.mb = d;
    }

    public void setLongitude(double d) {
        this.ox = d;
    }
}
