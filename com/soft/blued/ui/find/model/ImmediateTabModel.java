package com.soft.blued.ui.find.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/ImmediateTabModel.class */
public class ImmediateTabModel implements Parcelable {
    public static final Parcelable.Creator<ImmediateTabModel> CREATOR = new Parcelable.Creator<ImmediateTabModel>() { // from class: com.soft.blued.ui.find.model.ImmediateTabModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImmediateTabModel createFromParcel(Parcel parcel) {
            return new ImmediateTabModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImmediateTabModel[] newArray(int i) {
            return new ImmediateTabModel[i];
        }
    };
    public List<Tab> conf;
    public String is_update;
    public Tab my;
    public List<UserFindResult> users;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/ImmediateTabModel$Tab.class */
    public static class Tab implements Parcelable {
        public static final Parcelable.Creator<Tab> CREATOR = new Parcelable.Creator<Tab>() { // from class: com.soft.blued.ui.find.model.ImmediateTabModel.Tab.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Tab createFromParcel(Parcel parcel) {
                return new Tab(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Tab[] newArray(int i) {
                return new Tab[i];
            }
        };
        public String background;
        public int background_id;
        public String item_id;
        public String name;
        public String pic;
        public int pic_id;
        public String small_pic;
        public int small_pic_id;

        public Tab() {
        }

        protected Tab(Parcel parcel) {
            this.item_id = parcel.readString();
            this.name = parcel.readString();
            this.pic = parcel.readString();
            this.background = parcel.readString();
            this.small_pic = parcel.readString();
            this.pic_id = parcel.readInt();
            this.small_pic_id = parcel.readInt();
            this.background_id = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.item_id);
            parcel.writeString(this.name);
            parcel.writeString(this.pic);
            parcel.writeString(this.background);
            parcel.writeString(this.small_pic);
            parcel.writeInt(this.pic_id);
            parcel.writeInt(this.small_pic_id);
            parcel.writeInt(this.background_id);
        }
    }

    public ImmediateTabModel() {
    }

    protected ImmediateTabModel(Parcel parcel) {
        this.is_update = parcel.readString();
        this.conf = parcel.readArrayList(Tab.class.getClassLoader());
        this.users = parcel.readArrayList(UserFindResult.class.getClassLoader());
        this.my = (Tab) parcel.readParcelable(Tab.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.is_update);
        parcel.writeList(this.conf);
        parcel.writeList(this.users);
        parcel.writeParcelable(this.my, i);
    }
}
