package com.opos.mobad.interstitial;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.interstitial.a.n;
import com.opos.mobad.model.data.AdItemData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/InterstitialCreator.class */
public class InterstitialCreator implements Parcelable, com.opos.mobad.q.a.b.d {
    public static final Parcelable.Creator<InterstitialCreator> CREATOR = new Parcelable.Creator<InterstitialCreator>() { // from class: com.opos.mobad.interstitial.InterstitialCreator.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InterstitialCreator createFromParcel(Parcel parcel) {
            return new InterstitialCreator(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InterstitialCreator[] newArray(int i) {
            return new InterstitialCreator[i];
        }
    };

    public InterstitialCreator() {
    }

    protected InterstitialCreator(Parcel parcel) {
    }

    @Override // com.opos.mobad.q.a.b.d
    public com.opos.mobad.n.a a(Activity activity, AdItemData adItemData, com.opos.mobad.activity.webview.b bVar) {
        return n.a(activity, adItemData, adItemData.i().get(0), null, bVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
