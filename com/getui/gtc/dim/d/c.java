package com.getui.gtc.dim.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.getui.gtc.dim.e.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/d/c.class */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.getui.gtc.dim.d.c.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ c[] newArray(int i) {
            return new c[i];
        }
    };
    private String parcelableClass;
    private List<Parcelable> parcelables;

    protected c(Parcel parcel) {
        try {
            String readString = parcel.readString();
            this.parcelableClass = readString;
            Field declaredField = Class.forName(readString).getDeclaredField("CREATOR");
            declaredField.setAccessible(true);
            ArrayList arrayList = new ArrayList();
            this.parcelables = arrayList;
            parcel.readTypedList(arrayList, (Parcelable.Creator) declaredField.get(null));
        } catch (Throwable th) {
            b.a(th);
        }
    }

    public c(List<Parcelable> list) {
        try {
            this.parcelables = list;
            this.parcelableClass = list.get(0).getClass().getName();
        } catch (Throwable th) {
            b.a(th);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Parcelable> getParcelables() {
        return this.parcelables;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.parcelableClass);
        parcel.writeTypedList(this.parcelables);
    }
}
