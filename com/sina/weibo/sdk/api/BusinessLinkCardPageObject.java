package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/BusinessLinkCardPageObject.class */
public class BusinessLinkCardPageObject extends BaseMediaObject {
    public static final Parcelable.Creator<BusinessLinkCardPageObject> CREATOR = new Parcelable.Creator<BusinessLinkCardPageObject>() { // from class: com.sina.weibo.sdk.api.BusinessLinkCardPageObject.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BusinessLinkCardPageObject createFromParcel(Parcel parcel) {
            return new BusinessLinkCardPageObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BusinessLinkCardPageObject[] newArray(int i) {
            return new BusinessLinkCardPageObject[i];
        }
    };
    public String[] nineImageLocalPath;
    public String[] nineImageUrlPath;
    public byte[] nineThumbData_1;
    public byte[] nineThumbData_2;
    public byte[] nineThumbData_3;
    public byte[] nineThumbData_4;
    public byte[] nineThumbData_5;
    public byte[] nineThumbData_6;
    public byte[] nineThumbData_7;
    public byte[] nineThumbData_8;
    public byte[] nineThumbData_9;

    public BusinessLinkCardPageObject() {
        this.nineImageUrlPath = new String[9];
        this.nineImageLocalPath = new String[9];
    }

    public BusinessLinkCardPageObject(Parcel parcel) {
        this.nineImageUrlPath = new String[9];
        this.nineImageLocalPath = new String[9];
        this.nineImageUrlPath = parcel.createStringArray();
        this.nineImageLocalPath = parcel.createStringArray();
        this.nineThumbData_1 = parcel.createByteArray();
        this.nineThumbData_2 = parcel.createByteArray();
        this.nineThumbData_3 = parcel.createByteArray();
        this.nineThumbData_4 = parcel.createByteArray();
        this.nineThumbData_5 = parcel.createByteArray();
        this.nineThumbData_6 = parcel.createByteArray();
        this.nineThumbData_7 = parcel.createByteArray();
        this.nineThumbData_8 = parcel.createByteArray();
        this.nineThumbData_9 = parcel.createByteArray();
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public boolean checkArgs() {
        return super.checkArgs();
    }

    public String[] getNineImageLocalPath() {
        return this.nineImageLocalPath;
    }

    public String[] getNineImageUrlPath() {
        return this.nineImageUrlPath;
    }

    public byte[] getNineThumbData_1() {
        return this.nineThumbData_1;
    }

    public byte[] getNineThumbData_2() {
        return this.nineThumbData_2;
    }

    public byte[] getNineThumbData_3() {
        return this.nineThumbData_3;
    }

    public byte[] getNineThumbData_4() {
        return this.nineThumbData_4;
    }

    public byte[] getNineThumbData_5() {
        return this.nineThumbData_5;
    }

    public byte[] getNineThumbData_6() {
        return this.nineThumbData_6;
    }

    public byte[] getNineThumbData_7() {
        return this.nineThumbData_7;
    }

    public byte[] getNineThumbData_8() {
        return this.nineThumbData_8;
    }

    public byte[] getNineThumbData_9() {
        return this.nineThumbData_9;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public int getObjType() {
        return 8;
    }

    public void setNineImageLocalPath(String[] strArr) {
        this.nineImageLocalPath = strArr;
    }

    public void setNineImageUrlPath(String[] strArr) {
        this.nineImageUrlPath = strArr;
    }

    public void setNineThumbData_1(byte[] bArr) {
        this.nineThumbData_1 = bArr;
    }

    public void setNineThumbData_2(byte[] bArr) {
        this.nineThumbData_2 = bArr;
    }

    public void setNineThumbData_3(byte[] bArr) {
        this.nineThumbData_3 = bArr;
    }

    public void setNineThumbData_4(byte[] bArr) {
        this.nineThumbData_4 = bArr;
    }

    public void setNineThumbData_5(byte[] bArr) {
        this.nineThumbData_5 = bArr;
    }

    public void setNineThumbData_6(byte[] bArr) {
        this.nineThumbData_6 = bArr;
    }

    public void setNineThumbData_7(byte[] bArr) {
        this.nineThumbData_7 = bArr;
    }

    public void setNineThumbData_8(byte[] bArr) {
        this.nineThumbData_8 = bArr;
    }

    public void setNineThumbData_9(byte[] bArr) {
        this.nineThumbData_9 = bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public BaseMediaObject toExtraMediaObject(String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public String toExtraMediaString() {
        return "";
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(this.nineImageUrlPath);
        parcel.writeStringArray(this.nineImageLocalPath);
        parcel.writeByteArray(this.nineThumbData_1);
        parcel.writeByteArray(this.nineThumbData_2);
        parcel.writeByteArray(this.nineThumbData_3);
        parcel.writeByteArray(this.nineThumbData_4);
        parcel.writeByteArray(this.nineThumbData_5);
        parcel.writeByteArray(this.nineThumbData_6);
        parcel.writeByteArray(this.nineThumbData_7);
        parcel.writeByteArray(this.nineThumbData_8);
        parcel.writeByteArray(this.nineThumbData_9);
    }
}
