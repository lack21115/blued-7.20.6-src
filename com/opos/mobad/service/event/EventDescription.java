package com.opos.mobad.service.event;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/event/EventDescription.class */
public class EventDescription implements Parcelable {
    public static final Parcelable.Creator<EventDescription> CREATOR = new Parcelable.Creator<EventDescription>() { // from class: com.opos.mobad.service.event.EventDescription.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventDescription createFromParcel(Parcel parcel) {
            return new EventDescription(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventDescription[] newArray(int i) {
            return new EventDescription[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f27342a;

    protected EventDescription(Parcel parcel) {
        this.f27342a = parcel.readString();
    }

    public EventDescription(String str) {
        this.f27342a = str;
    }

    public String a() {
        return this.f27342a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f27342a);
    }
}
