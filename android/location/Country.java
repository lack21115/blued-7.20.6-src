package android.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.alipay.sdk.util.i;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/location/Country.class */
public class Country implements Parcelable {
    public static final int COUNTRY_SOURCE_LOCALE = 3;
    public static final int COUNTRY_SOURCE_LOCATION = 1;
    public static final int COUNTRY_SOURCE_NETWORK = 0;
    public static final int COUNTRY_SOURCE_SIM = 2;
    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() { // from class: android.location.Country.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Country createFromParcel(Parcel parcel) {
            return new Country(parcel.readString(), parcel.readInt(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Country[] newArray(int i) {
            return new Country[i];
        }
    };
    private final String mCountryIso;
    private int mHashCode;
    private final int mSource;
    private final long mTimestamp;

    public Country(Country country) {
        this.mCountryIso = country.mCountryIso;
        this.mSource = country.mSource;
        this.mTimestamp = country.mTimestamp;
    }

    public Country(String str, int i) {
        if (str == null || i < 0 || i > 3) {
            throw new IllegalArgumentException();
        }
        this.mCountryIso = str.toUpperCase(Locale.US);
        this.mSource = i;
        this.mTimestamp = SystemClock.elapsedRealtime();
    }

    private Country(String str, int i, long j) {
        if (str == null || i < 0 || i > 3) {
            throw new IllegalArgumentException();
        }
        this.mCountryIso = str.toUpperCase(Locale.US);
        this.mSource = i;
        this.mTimestamp = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Country) {
            Country country = (Country) obj;
            return this.mCountryIso.equals(country.getCountryIso()) && this.mSource == country.getSource();
        }
        return false;
    }

    public boolean equalsIgnoreSource(Country country) {
        return country != null && this.mCountryIso.equals(country.getCountryIso());
    }

    public final String getCountryIso() {
        return this.mCountryIso;
    }

    public final int getSource() {
        return this.mSource;
    }

    public final long getTimestamp() {
        return this.mTimestamp;
    }

    public int hashCode() {
        if (this.mHashCode == 0) {
            this.mHashCode = ((this.mCountryIso.hashCode() + 221) * 13) + this.mSource;
        }
        return this.mHashCode;
    }

    public String toString() {
        return "Country {ISO=" + this.mCountryIso + ", source=" + this.mSource + ", time=" + this.mTimestamp + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCountryIso);
        parcel.writeInt(this.mSource);
        parcel.writeLong(this.mTimestamp);
    }
}
