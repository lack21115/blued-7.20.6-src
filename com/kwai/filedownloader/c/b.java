package com.kwai.filedownloader.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/c/b.class */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwai.filedownloader.c.b.1
        private static b b(Parcel parcel) {
            return new b(parcel);
        }

        private static b[] da(int i) {
            return new b[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i) {
            return da(i);
        }
    };
    private HashMap<String, List<String>> aIH;

    public b() {
    }

    protected b(Parcel parcel) {
        this.aIH = parcel.readHashMap(String.class.getClassLoader());
    }

    public final HashMap<String, List<String>> IA() {
        return this.aIH;
    }

    public final void an(String str, String str2) {
        ao.eK(str);
        ao.eK(str2);
        if (this.aIH == null) {
            this.aIH = new HashMap<>();
        }
        List<String> list = this.aIH.get(str);
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
            this.aIH.put(str, arrayList);
        }
        if (arrayList.contains(str2)) {
            return;
        }
        arrayList.add(str2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void fu(String str) {
        HashMap<String, List<String>> hashMap = this.aIH;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(str);
    }

    public final String toString() {
        return this.aIH.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.aIH);
    }
}
