package com.tencent.connect.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/dataprovider/DataType.class */
public final class DataType {
    public static final int CONTENT_AND_IMAGE_PATH = 1;
    public static final int CONTENT_AND_VIDEO_PATH = 2;
    public static final int CONTENT_ONLY = 4;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/dataprovider/DataType$TextAndMediaPath.class */
    public static class TextAndMediaPath implements Parcelable {
        public static final Parcelable.Creator<TextAndMediaPath> CREATOR = new Parcelable.Creator<TextAndMediaPath>() { // from class: com.tencent.connect.dataprovider.DataType.TextAndMediaPath.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TextAndMediaPath createFromParcel(Parcel parcel) {
                return new TextAndMediaPath(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TextAndMediaPath[] newArray(int i) {
                return new TextAndMediaPath[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private String f22500a;
        private String b;

        private TextAndMediaPath(Parcel parcel) {
            this.f22500a = parcel.readString();
            this.b = parcel.readString();
        }

        public TextAndMediaPath(String str, String str2) {
            this.f22500a = str;
            this.b = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getMediaPath() {
            return this.b;
        }

        public String getText() {
            return this.f22500a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f22500a);
            parcel.writeString(this.b);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/dataprovider/DataType$TextOnly.class */
    public static class TextOnly implements Parcelable {
        public static final Parcelable.Creator<TextOnly> CREATOR = new Parcelable.Creator<TextOnly>() { // from class: com.tencent.connect.dataprovider.DataType.TextOnly.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TextOnly createFromParcel(Parcel parcel) {
                return new TextOnly(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TextOnly[] newArray(int i) {
                return new TextOnly[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private String f22501a;

        private TextOnly(Parcel parcel) {
            this.f22501a = parcel.readString();
        }

        public TextOnly(String str) {
            this.f22501a = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getText() {
            return this.f22501a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f22501a);
        }
    }
}
