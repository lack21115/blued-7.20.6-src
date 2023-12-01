package com.blued.android.module.common.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/share/model/ShareEventToMsgEntity.class */
public class ShareEventToMsgEntity extends ShareToMsgEntity {
    public static final Parcelable.Creator<ShareEventToMsgEntity> CREATOR = new Parcelable.Creator<ShareEventToMsgEntity>() { // from class: com.blued.android.module.common.share.model.ShareEventToMsgEntity.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareEventToMsgEntity createFromParcel(Parcel parcel) {
            return new ShareEventToMsgEntity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareEventToMsgEntity[] newArray(int i) {
            return new ShareEventToMsgEntity[i];
        }
    };
    public String activityLocation;
    public String activityName;
    public String activityTime;
    public int isActivity;

    public ShareEventToMsgEntity() {
    }

    public ShareEventToMsgEntity(Parcel parcel) {
        super(parcel);
        this.isActivity = parcel.readInt();
        this.activityName = parcel.readString();
        this.activityTime = parcel.readString();
        this.activityLocation = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.isActivity);
        parcel.writeString(this.activityName);
        parcel.writeString(this.activityTime);
        parcel.writeString(this.activityLocation);
    }
}
