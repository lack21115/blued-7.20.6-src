package com.opos.cmn.func.dl.base.exception;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/exception/DlException.class */
public final class DlException extends Exception implements Parcelable {
    public static final Parcelable.Creator<DlException> CREATOR = new Parcelable.Creator<DlException>() { // from class: com.opos.cmn.func.dl.base.exception.DlException.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DlException createFromParcel(Parcel parcel) {
            return new DlException(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DlException[] newArray(int i) {
            return new DlException[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f11233a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f11234c;

    public DlException() {
        this.f11234c = -1;
        this.f11233a = 1000;
        this.b = a.a(1000);
    }

    public DlException(int i) {
        this.f11234c = -1;
        this.f11233a = i;
        this.b = a.a(i);
    }

    public DlException(int i, int i2) {
        this.f11234c = -1;
        this.f11233a = i;
        this.f11234c = i2;
        this.b = a.a(i);
    }

    public DlException(int i, int i2, String str) {
        this.f11234c = -1;
        this.f11233a = i;
        this.f11234c = i2;
        this.b = TextUtils.isEmpty(str) ? a.a(i) : str;
    }

    public DlException(int i, Throwable th) {
        super(th);
        this.f11234c = -1;
        this.f11233a = i;
        this.b = th.getMessage();
    }

    public DlException(int i, Object... objArr) {
        this.f11234c = -1;
        this.f11233a = i;
        this.b = String.format(a.a(i), objArr);
    }

    private DlException(Parcel parcel) {
        this.f11234c = -1;
        this.f11233a = parcel.readInt();
        this.b = parcel.readString();
    }

    public final int a() {
        return this.f11233a;
    }

    public final String b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "DlException{code=" + this.f11233a + ", msg='" + this.b + "', httpCode=" + this.f11234c + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11233a);
        parcel.writeString(this.b);
        parcel.writeInt(this.f11234c);
    }
}
