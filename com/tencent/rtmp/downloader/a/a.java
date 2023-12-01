package com.tencent.rtmp.downloader.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.rtmp.TXPlayerAuthBuilder;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/downloader/a/a.class */
public class a extends TXVodDownloadDataSource implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.tencent.rtmp.downloader.a.a.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ a[] newArray(int i) {
            return new a[i];
        }
    };

    public a(int i, String str, int i2, String str2, String str3) {
        super(i, str, i2, str2, str3);
    }

    a(Parcel parcel) {
        this.appId = parcel.readInt();
        this.fileId = parcel.readString();
        this.pSign = parcel.readString();
        this.quality = parcel.readInt();
        this.userName = parcel.readString();
        if (TextUtils.isEmpty(this.pSign)) {
            return;
        }
        this.overlayKey = parcel.readString();
        this.overlayIv = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TXPlayerAuthBuilder tXPlayerAuthBuilder, int i) {
        super(tXPlayerAuthBuilder, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TXPlayerAuthBuilder tXPlayerAuthBuilder, String str) {
        super(tXPlayerAuthBuilder, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i) {
        return i == 1 ? "FLU" : i == 2 ? "SD" : i == 3 ? "HD" : i == 4 ? "FHD" : i == 5 ? "2K" : i == 6 ? "4K" : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean a(int i, String str) {
        boolean z;
        int i2 = 6;
        switch (str.hashCode()) {
            case 1625:
                if (str.equals("2K")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1687:
                if (str.equals("4K")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case PushConstants.DOWN_LOAD_LARGE_ICON_ERROR /* 2300 */:
                if (str.equals("HD")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2517:
                if (str.equals("OD")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2641:
                if (str.equals("SD")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 69570:
                if (str.equals("FHD")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 69711:
                if (str.equals("FLU")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 84178:
                if (str.equals("UNK")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 693628:
                if (str.equals("原画")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 853726:
                if (str.equals("标清")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 897060:
                if (str.equals("流畅")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1257005:
                if (str.equals("高清")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 21284245:
                if (str.equals("全高清")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
            case true:
                i2 = 1;
                break;
            case true:
            case true:
                i2 = 2;
                break;
            case true:
            case true:
                i2 = 3;
                break;
            case true:
            case true:
                i2 = 4;
                break;
            case true:
                i2 = 5;
                break;
            case true:
                break;
            case true:
            case true:
                i2 = 0;
                break;
            case true:
                i2 = 1000;
                break;
            default:
                i2 = -1;
                break;
        }
        return i == i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        this.overlayKey = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str) {
        this.overlayIv = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.appId);
        parcel.writeString(this.fileId);
        parcel.writeString(this.pSign);
        parcel.writeInt(this.quality);
        parcel.writeString(this.userName);
        if (TextUtils.isEmpty(this.pSign)) {
            return;
        }
        parcel.writeString(this.overlayKey);
        parcel.writeString(this.overlayIv);
    }
}
