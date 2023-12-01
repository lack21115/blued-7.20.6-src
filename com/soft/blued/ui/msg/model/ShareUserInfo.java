package com.soft.blued.ui.msg.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/ShareUserInfo.class */
public class ShareUserInfo implements Parcelable {
    public static final Parcelable.Creator<ShareUserInfo> CREATOR = new Parcelable.Creator<ShareUserInfo>() { // from class: com.soft.blued.ui.msg.model.ShareUserInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareUserInfo createFromParcel(Parcel parcel) {
            return new ShareUserInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareUserInfo[] newArray(int i) {
            return new ShareUserInfo[i];
        }
    };
    public String age;
    public String avatar;
    public int badge;
    public int expire_type;
    public String height;
    public int is_hide_vip_look;
    public int is_vip_annual;
    public String nick;
    public String role;
    public int vip_exp_lvl;
    public int vip_grade;
    public String weight;

    public ShareUserInfo() {
    }

    protected ShareUserInfo(Parcel parcel) {
        this.nick = parcel.readString();
        this.avatar = parcel.readString();
        this.age = parcel.readString();
        this.height = parcel.readString();
        this.weight = parcel.readString();
        this.role = parcel.readString();
        this.badge = parcel.readInt();
        this.vip_grade = parcel.readInt();
        this.vip_exp_lvl = parcel.readInt();
        this.expire_type = parcel.readInt();
        this.is_hide_vip_look = parcel.readInt();
        this.is_vip_annual = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nick);
        parcel.writeString(this.avatar);
        parcel.writeString(this.age);
        parcel.writeString(this.height);
        parcel.writeString(this.weight);
        parcel.writeString(this.role);
        parcel.writeInt(this.badge);
        parcel.writeInt(this.vip_grade);
        parcel.writeInt(this.vip_exp_lvl);
        parcel.writeInt(this.expire_type);
        parcel.writeInt(this.is_hide_vip_look);
        parcel.writeInt(this.is_vip_annual);
    }
}
