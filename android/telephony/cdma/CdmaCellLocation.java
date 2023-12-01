package android.telephony.cdma;

import android.os.Bundle;
import android.telephony.CellLocation;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/cdma/CdmaCellLocation.class */
public class CdmaCellLocation extends CellLocation {
    public static final int INVALID_LAT_LONG = Integer.MAX_VALUE;
    private int mBaseStationId;
    private int mBaseStationLatitude;
    private int mBaseStationLongitude;
    private int mNetworkId;
    private int mSystemId;

    public CdmaCellLocation() {
        this.mBaseStationId = -1;
        this.mBaseStationLatitude = Integer.MAX_VALUE;
        this.mBaseStationLongitude = Integer.MAX_VALUE;
        this.mSystemId = -1;
        this.mNetworkId = -1;
        this.mBaseStationId = -1;
        this.mBaseStationLatitude = Integer.MAX_VALUE;
        this.mBaseStationLongitude = Integer.MAX_VALUE;
        this.mSystemId = -1;
        this.mNetworkId = -1;
    }

    public CdmaCellLocation(Bundle bundle) {
        this.mBaseStationId = -1;
        this.mBaseStationLatitude = Integer.MAX_VALUE;
        this.mBaseStationLongitude = Integer.MAX_VALUE;
        this.mSystemId = -1;
        this.mNetworkId = -1;
        this.mBaseStationId = bundle.getInt("baseStationId", this.mBaseStationId);
        this.mBaseStationLatitude = bundle.getInt("baseStationLatitude", this.mBaseStationLatitude);
        this.mBaseStationLongitude = bundle.getInt("baseStationLongitude", this.mBaseStationLongitude);
        this.mSystemId = bundle.getInt("systemId", this.mSystemId);
        this.mNetworkId = bundle.getInt("networkId", this.mNetworkId);
    }

    public static double convertQuartSecToDecDegrees(int i) {
        if (Double.isNaN(i) || i < -2592000 || i > 2592000) {
            throw new IllegalArgumentException("Invalid coordiante value:" + i);
        }
        return i / 14400.0d;
    }

    private static boolean equalsHandlesNulls(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public boolean equals(Object obj) {
        try {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) obj;
            return obj != null && equalsHandlesNulls(Integer.valueOf(this.mBaseStationId), Integer.valueOf(cdmaCellLocation.mBaseStationId)) && equalsHandlesNulls(Integer.valueOf(this.mBaseStationLatitude), Integer.valueOf(cdmaCellLocation.mBaseStationLatitude)) && equalsHandlesNulls(Integer.valueOf(this.mBaseStationLongitude), Integer.valueOf(cdmaCellLocation.mBaseStationLongitude)) && equalsHandlesNulls(Integer.valueOf(this.mSystemId), Integer.valueOf(cdmaCellLocation.mSystemId)) && equalsHandlesNulls(Integer.valueOf(this.mNetworkId), Integer.valueOf(cdmaCellLocation.mNetworkId));
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override // android.telephony.CellLocation
    public void fillInNotifierBundle(Bundle bundle) {
        bundle.putInt("baseStationId", this.mBaseStationId);
        bundle.putInt("baseStationLatitude", this.mBaseStationLatitude);
        bundle.putInt("baseStationLongitude", this.mBaseStationLongitude);
        bundle.putInt("systemId", this.mSystemId);
        bundle.putInt("networkId", this.mNetworkId);
    }

    public int getBaseStationId() {
        return this.mBaseStationId;
    }

    public int getBaseStationLatitude() {
        return this.mBaseStationLatitude;
    }

    public int getBaseStationLongitude() {
        return this.mBaseStationLongitude;
    }

    public int getNetworkId() {
        return this.mNetworkId;
    }

    public int getSystemId() {
        return this.mSystemId;
    }

    public int hashCode() {
        return (((this.mBaseStationId ^ this.mBaseStationLatitude) ^ this.mBaseStationLongitude) ^ this.mSystemId) ^ this.mNetworkId;
    }

    @Override // android.telephony.CellLocation
    public boolean isEmpty() {
        return this.mBaseStationId == -1 && this.mBaseStationLatitude == Integer.MAX_VALUE && this.mBaseStationLongitude == Integer.MAX_VALUE && this.mSystemId == -1 && this.mNetworkId == -1;
    }

    public void setCellLocationData(int i, int i2, int i3) {
        this.mBaseStationId = i;
        this.mBaseStationLatitude = i2;
        this.mBaseStationLongitude = i3;
    }

    public void setCellLocationData(int i, int i2, int i3, int i4, int i5) {
        this.mBaseStationId = i;
        this.mBaseStationLatitude = i2;
        this.mBaseStationLongitude = i3;
        this.mSystemId = i4;
        this.mNetworkId = i5;
    }

    public void setStateInvalid() {
        this.mBaseStationId = -1;
        this.mBaseStationLatitude = Integer.MAX_VALUE;
        this.mBaseStationLongitude = Integer.MAX_VALUE;
        this.mSystemId = -1;
        this.mNetworkId = -1;
    }

    public String toString() {
        return "[" + this.mBaseStationId + "," + this.mBaseStationLatitude + "," + this.mBaseStationLongitude + "," + this.mSystemId + "," + this.mNetworkId + "]";
    }
}
