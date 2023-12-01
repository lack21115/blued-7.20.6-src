package android.text.style;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.provider.Browser;
import android.text.ParcelableSpan;
import android.view.View;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/URLSpan.class */
public class URLSpan extends ClickableSpan implements ParcelableSpan {
    private final String mURL;

    public URLSpan(Parcel parcel) {
        this.mURL = parcel.readString();
    }

    public URLSpan(String str) {
        this.mURL = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.text.ParcelableSpan
    public int getSpanTypeId() {
        return 11;
    }

    public String getURL() {
        return this.mURL;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Uri parse = Uri.parse(getURL());
        Context context = view.getContext();
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
        context.startActivity(intent);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mURL);
    }
}
