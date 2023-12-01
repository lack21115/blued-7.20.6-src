package com.soft.blued.ui.find.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/JoyEntryModel.class */
public class JoyEntryModel implements Parcelable {
    public static final Parcelable.Creator<JoyEntryModel> CREATOR = new Parcelable.Creator<JoyEntryModel>() { // from class: com.soft.blued.ui.find.model.JoyEntryModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JoyEntryModel createFromParcel(Parcel parcel) {
            return new JoyEntryModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JoyEntryModel[] newArray(int i) {
            return new JoyEntryModel[i];
        }
    };
    public String color;
    public String icon;
    public String name;
    public String url;

    public JoyEntryModel() {
    }

    protected JoyEntryModel(Parcel parcel) {
        this.name = parcel.readString();
        this.url = parcel.readString();
        this.icon = parcel.readString();
        this.color = parcel.readString();
    }

    public JoyEntryModel(String str, String str2, String str3) {
        this.name = str;
        this.url = str2;
        this.icon = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeString(this.icon);
        parcel.writeString(this.color);
    }
}
