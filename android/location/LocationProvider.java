package android.location;

import com.android.internal.location.ProviderProperties;

/* loaded from: source-9557208-dex2jar.jar:android/location/LocationProvider.class */
public class LocationProvider {
    public static final int AVAILABLE = 2;
    public static final String BAD_CHARS_REGEX = "[^a-zA-Z0-9]";
    public static final int OUT_OF_SERVICE = 0;
    public static final int TEMPORARILY_UNAVAILABLE = 1;
    private final String mName;
    private final ProviderProperties mProperties;

    public LocationProvider(String str, ProviderProperties providerProperties) {
        if (str.matches(BAD_CHARS_REGEX)) {
            throw new IllegalArgumentException("provider name contains illegal character: " + str);
        }
        this.mName = str;
        this.mProperties = providerProperties;
    }

    public static boolean propertiesMeetCriteria(String str, ProviderProperties providerProperties, Criteria criteria) {
        if (LocationManager.PASSIVE_PROVIDER.equals(str) || providerProperties == null) {
            return false;
        }
        if (criteria.getAccuracy() == 0 || criteria.getAccuracy() >= providerProperties.mAccuracy) {
            if (criteria.getPowerRequirement() == 0 || criteria.getPowerRequirement() >= providerProperties.mPowerRequirement) {
                if (!criteria.isAltitudeRequired() || providerProperties.mSupportsAltitude) {
                    if (!criteria.isSpeedRequired() || providerProperties.mSupportsSpeed) {
                        if (!criteria.isBearingRequired() || providerProperties.mSupportsBearing) {
                            return criteria.isCostAllowed() || !providerProperties.mHasMonetaryCost;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int getAccuracy() {
        return this.mProperties.mAccuracy;
    }

    public String getName() {
        return this.mName;
    }

    public int getPowerRequirement() {
        return this.mProperties.mPowerRequirement;
    }

    public boolean hasMonetaryCost() {
        return this.mProperties.mHasMonetaryCost;
    }

    public boolean meetsCriteria(Criteria criteria) {
        return propertiesMeetCriteria(this.mName, this.mProperties, criteria);
    }

    public boolean requiresCell() {
        return this.mProperties.mRequiresCell;
    }

    public boolean requiresNetwork() {
        return this.mProperties.mRequiresNetwork;
    }

    public boolean requiresSatellite() {
        return this.mProperties.mRequiresSatellite;
    }

    public boolean supportsAltitude() {
        return this.mProperties.mSupportsAltitude;
    }

    public boolean supportsBearing() {
        return this.mProperties.mSupportsBearing;
    }

    public boolean supportsSpeed() {
        return this.mProperties.mSupportsSpeed;
    }
}
