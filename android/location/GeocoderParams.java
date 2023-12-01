package android.location;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/location/GeocoderParams.class */
public class GeocoderParams implements Parcelable {
    public static final Parcelable.Creator<GeocoderParams> CREATOR = new Parcelable.Creator<GeocoderParams>() { // from class: android.location.GeocoderParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeocoderParams createFromParcel(Parcel parcel) {
            GeocoderParams geocoderParams = new GeocoderParams();
            geocoderParams.mLocale = new Locale(parcel.readString(), parcel.readString(), parcel.readString());
            geocoderParams.mPackageName = parcel.readString();
            return geocoderParams;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeocoderParams[] newArray(int i) {
            return new GeocoderParams[i];
        }
    };
    private Locale mLocale;
    private String mPackageName;

    private GeocoderParams() {
    }

    public GeocoderParams(Context context, Locale locale) {
        this.mLocale = locale;
        this.mPackageName = context.getPackageName();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getClientPackage() {
        return this.mPackageName;
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mLocale.getLanguage());
        parcel.writeString(this.mLocale.getCountry());
        parcel.writeString(this.mLocale.getVariant());
        parcel.writeString(this.mPackageName);
    }
}
