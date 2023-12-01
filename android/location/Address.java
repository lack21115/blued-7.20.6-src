package android.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.igexin.push.core.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/location/Address.class */
public class Address implements Parcelable {
    public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() { // from class: android.location.Address.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Address createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Address address = new Address(readString2.length() > 0 ? new Locale(readString, readString2) : new Locale(readString));
            int readInt = parcel.readInt();
            if (readInt > 0) {
                address.mAddressLines = new HashMap(readInt);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readInt) {
                        break;
                    }
                    int readInt2 = parcel.readInt();
                    address.mAddressLines.put(Integer.valueOf(readInt2), parcel.readString());
                    address.mMaxAddressLineIndex = Math.max(address.mMaxAddressLineIndex, readInt2);
                    i = i2 + 1;
                }
            } else {
                address.mAddressLines = null;
                address.mMaxAddressLineIndex = -1;
            }
            address.mFeatureName = parcel.readString();
            address.mAdminArea = parcel.readString();
            address.mSubAdminArea = parcel.readString();
            address.mLocality = parcel.readString();
            address.mSubLocality = parcel.readString();
            address.mThoroughfare = parcel.readString();
            address.mSubThoroughfare = parcel.readString();
            address.mPremises = parcel.readString();
            address.mPostalCode = parcel.readString();
            address.mCountryCode = parcel.readString();
            address.mCountryName = parcel.readString();
            address.mHasLatitude = parcel.readInt() != 0;
            if (address.mHasLatitude) {
                address.mLatitude = parcel.readDouble();
            }
            address.mHasLongitude = parcel.readInt() != 0;
            if (address.mHasLongitude) {
                address.mLongitude = parcel.readDouble();
            }
            address.mPhone = parcel.readString();
            address.mUrl = parcel.readString();
            address.mExtras = parcel.readBundle();
            return address;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Address[] newArray(int i) {
            return new Address[i];
        }
    };
    private HashMap<Integer, String> mAddressLines;
    private String mAdminArea;
    private String mCountryCode;
    private String mCountryName;
    private String mFeatureName;
    private double mLatitude;
    private Locale mLocale;
    private String mLocality;
    private double mLongitude;
    private String mPhone;
    private String mPostalCode;
    private String mPremises;
    private String mSubAdminArea;
    private String mSubLocality;
    private String mSubThoroughfare;
    private String mThoroughfare;
    private String mUrl;
    private int mMaxAddressLineIndex = -1;
    private boolean mHasLatitude = false;
    private boolean mHasLongitude = false;
    private Bundle mExtras = null;

    public Address(Locale locale) {
        this.mLocale = locale;
    }

    public void clearLatitude() {
        this.mHasLatitude = false;
    }

    public void clearLongitude() {
        this.mHasLongitude = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        if (this.mExtras != null) {
            return this.mExtras.describeContents();
        }
        return 0;
    }

    public String getAddressLine(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index = " + i + " < 0");
        }
        if (this.mAddressLines == null) {
            return null;
        }
        return this.mAddressLines.get(Integer.valueOf(i));
    }

    public String getAdminArea() {
        return this.mAdminArea;
    }

    public String getCountryCode() {
        return this.mCountryCode;
    }

    public String getCountryName() {
        return this.mCountryName;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getFeatureName() {
        return this.mFeatureName;
    }

    public double getLatitude() {
        if (this.mHasLatitude) {
            return this.mLatitude;
        }
        throw new IllegalStateException();
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public String getLocality() {
        return this.mLocality;
    }

    public double getLongitude() {
        if (this.mHasLongitude) {
            return this.mLongitude;
        }
        throw new IllegalStateException();
    }

    public int getMaxAddressLineIndex() {
        return this.mMaxAddressLineIndex;
    }

    public String getPhone() {
        return this.mPhone;
    }

    public String getPostalCode() {
        return this.mPostalCode;
    }

    public String getPremises() {
        return this.mPremises;
    }

    public String getSubAdminArea() {
        return this.mSubAdminArea;
    }

    public String getSubLocality() {
        return this.mSubLocality;
    }

    public String getSubThoroughfare() {
        return this.mSubThoroughfare;
    }

    public String getThoroughfare() {
        return this.mThoroughfare;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean hasLatitude() {
        return this.mHasLatitude;
    }

    public boolean hasLongitude() {
        return this.mHasLongitude;
    }

    public void setAddressLine(int i, String str) {
        if (i < 0) {
            throw new IllegalArgumentException("index = " + i + " < 0");
        }
        if (this.mAddressLines == null) {
            this.mAddressLines = new HashMap<>();
        }
        this.mAddressLines.put(Integer.valueOf(i), str);
        if (str != null) {
            this.mMaxAddressLineIndex = Math.max(this.mMaxAddressLineIndex, i);
            return;
        }
        this.mMaxAddressLineIndex = -1;
        for (Integer num : this.mAddressLines.keySet()) {
            this.mMaxAddressLineIndex = Math.max(this.mMaxAddressLineIndex, num.intValue());
        }
    }

    public void setAdminArea(String str) {
        this.mAdminArea = str;
    }

    public void setCountryCode(String str) {
        this.mCountryCode = str;
    }

    public void setCountryName(String str) {
        this.mCountryName = str;
    }

    public void setExtras(Bundle bundle) {
        this.mExtras = bundle == null ? null : new Bundle(bundle);
    }

    public void setFeatureName(String str) {
        this.mFeatureName = str;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
        this.mHasLatitude = true;
    }

    public void setLocality(String str) {
        this.mLocality = str;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
        this.mHasLongitude = true;
    }

    public void setPhone(String str) {
        this.mPhone = str;
    }

    public void setPostalCode(String str) {
        this.mPostalCode = str;
    }

    public void setPremises(String str) {
        this.mPremises = str;
    }

    public void setSubAdminArea(String str) {
        this.mSubAdminArea = str;
    }

    public void setSubLocality(String str) {
        this.mSubLocality = str;
    }

    public void setSubThoroughfare(String str) {
        this.mSubThoroughfare = str;
    }

    public void setThoroughfare(String str) {
        this.mThoroughfare = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address[addressLines=[");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > this.mMaxAddressLineIndex) {
                sb.append(']');
                sb.append(",feature=");
                sb.append(this.mFeatureName);
                sb.append(",admin=");
                sb.append(this.mAdminArea);
                sb.append(",sub-admin=");
                sb.append(this.mSubAdminArea);
                sb.append(",locality=");
                sb.append(this.mLocality);
                sb.append(",thoroughfare=");
                sb.append(this.mThoroughfare);
                sb.append(",postalCode=");
                sb.append(this.mPostalCode);
                sb.append(",countryCode=");
                sb.append(this.mCountryCode);
                sb.append(",countryName=");
                sb.append(this.mCountryName);
                sb.append(",hasLatitude=");
                sb.append(this.mHasLatitude);
                sb.append(",latitude=");
                sb.append(this.mLatitude);
                sb.append(",hasLongitude=");
                sb.append(this.mHasLongitude);
                sb.append(",longitude=");
                sb.append(this.mLongitude);
                sb.append(",phone=");
                sb.append(this.mPhone);
                sb.append(",url=");
                sb.append(this.mUrl);
                sb.append(",extras=");
                sb.append(this.mExtras);
                sb.append(']');
                return sb.toString();
            }
            if (i2 > 0) {
                sb.append(',');
            }
            sb.append(i2);
            sb.append(':');
            String str = this.mAddressLines.get(Integer.valueOf(i2));
            if (str == null) {
                sb.append(b.l);
            } else {
                sb.append('\"');
                sb.append(str);
                sb.append('\"');
            }
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mLocale.getLanguage());
        parcel.writeString(this.mLocale.getCountry());
        if (this.mAddressLines == null) {
            parcel.writeInt(0);
        } else {
            Set<Map.Entry<Integer, String>> entrySet = this.mAddressLines.entrySet();
            parcel.writeInt(entrySet.size());
            for (Map.Entry<Integer, String> entry : entrySet) {
                parcel.writeInt(entry.getKey().intValue());
                parcel.writeString(entry.getValue());
            }
        }
        parcel.writeString(this.mFeatureName);
        parcel.writeString(this.mAdminArea);
        parcel.writeString(this.mSubAdminArea);
        parcel.writeString(this.mLocality);
        parcel.writeString(this.mSubLocality);
        parcel.writeString(this.mThoroughfare);
        parcel.writeString(this.mSubThoroughfare);
        parcel.writeString(this.mPremises);
        parcel.writeString(this.mPostalCode);
        parcel.writeString(this.mCountryCode);
        parcel.writeString(this.mCountryName);
        parcel.writeInt(this.mHasLatitude ? 1 : 0);
        if (this.mHasLatitude) {
            parcel.writeDouble(this.mLatitude);
        }
        parcel.writeInt(this.mHasLongitude ? 1 : 0);
        if (this.mHasLongitude) {
            parcel.writeDouble(this.mLongitude);
        }
        parcel.writeString(this.mPhone);
        parcel.writeString(this.mUrl);
        parcel.writeBundle(this.mExtras);
    }
}
