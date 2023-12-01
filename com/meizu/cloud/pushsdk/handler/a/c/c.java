package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushsdk.handler.MessageV3;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/c/c.class */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.c.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c[] newArray(int i) {
            return new c[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private MessageV3 f24141a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f24142c;
    private int d;

    protected c(Parcel parcel) {
        this.f24141a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.b = parcel.readString();
        this.f24142c = parcel.readInt();
        this.d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f24141a = messageV3;
    }

    public MessageV3 a() {
        return this.f24141a;
    }

    public void a(int i) {
        this.f24142c = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public int b() {
        return this.f24142c;
    }

    public void b(int i) {
        this.d = i;
    }

    public int c() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f24141a + ", notificationPkg='" + this.b + "', notificationId='" + this.f24142c + "', state='" + this.d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f24141a, i);
        parcel.writeString(this.b);
        parcel.writeInt(this.f24142c);
        parcel.writeInt(this.d);
    }
}
