package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/webserverpic/WebServerPic.class */
public class WebServerPic {
    public static final Parcelable.Creator<WebServerPic> CREATOR = new WebServerPicCreator();

    /* renamed from: a  reason: collision with root package name */
    private final Uri f9061a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9062c;

    public WebServerPic(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebServerPic(Uri uri, int i, int i2) throws IllegalArgumentException {
        this.f9061a = uri;
        this.b = i;
        this.f9062c = i2;
        if (uri == null) {
            throw new IllegalArgumentException("url is not able to be null");
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height should be positive or 0");
        }
    }

    public final int getHeight() {
        return this.f9062c;
    }

    public final Uri getUrl() {
        return this.f9061a;
    }

    public final int getWidth() {
        return this.b;
    }

    public final String toString() {
        return String.format(Locale.ENGLISH, "Image %dx%d %s", Integer.valueOf(this.b), Integer.valueOf(this.f9062c), this.f9061a.toString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUrl(), i, false);
        SafeParcelWriter.writeInt(parcel, 2, getWidth());
        SafeParcelWriter.writeInt(parcel, 3, getHeight());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
