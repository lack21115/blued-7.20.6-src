package com.soft.blued.ui.msg.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/ShareToMsgEntity.class */
public class ShareToMsgEntity implements Parcelable {
    public static final Parcelable.Creator<ShareToMsgEntity> CREATOR = new Parcelable.Creator<ShareToMsgEntity>() { // from class: com.soft.blued.ui.msg.model.ShareToMsgEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareToMsgEntity createFromParcel(Parcel parcel) {
            return new ShareToMsgEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareToMsgEntity[] newArray(int i) {
            return new ShareToMsgEntity[i];
        }
    };
    public String description;
    public String gid;
    public String image;
    public List<String> imageList;
    public String isCreatorOrAdmin;
    public String name;
    public ShareToMsgEntity repost;
    public long sessionId;
    public ShareUserInfo shareUserInfo;
    public int share_from;
    public String title;
    public int type;
    public String url;

    public ShareToMsgEntity() {
    }

    public ShareToMsgEntity(Parcel parcel) {
        this.title = parcel.readString();
        this.name = parcel.readString();
        this.image = parcel.readString();
        if (this.imageList == null) {
            this.imageList = new ArrayList();
        }
        parcel.readStringList(this.imageList);
        this.url = parcel.readString();
        this.type = parcel.readInt();
        this.description = parcel.readString();
        this.share_from = parcel.readInt();
        this.gid = parcel.readString();
        this.isCreatorOrAdmin = parcel.readString();
        this.sessionId = parcel.readLong();
        this.repost = (ShareToMsgEntity) parcel.readParcelable(ShareToMsgEntity.class.getClassLoader());
        this.shareUserInfo = (ShareUserInfo) parcel.readParcelable(ShareUserInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.name);
        parcel.writeString(this.image);
        parcel.writeStringList(this.imageList);
        parcel.writeString(this.url);
        parcel.writeInt(this.type);
        parcel.writeString(this.description);
        parcel.writeInt(this.share_from);
        parcel.writeString(this.gid);
        parcel.writeString(this.isCreatorOrAdmin);
        parcel.writeLong(this.sessionId);
        parcel.writeParcelable(this.repost, 0);
        parcel.writeParcelable(this.shareUserInfo, 0);
    }
}
