package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompatApi21;
import android.support.v4.media.MediaDescriptionCompatApi23;
import android.text.TextUtils;

/* loaded from: source-8756600-dex2jar.jar:android/support/v4/media/MediaDescriptionCompat.class */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() { // from class: android.support.v4.media.MediaDescriptionCompat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return Build.VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    private final CharSequence mDescription;
    private Object mDescriptionObj;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    /* loaded from: source-8756600-dex2jar.jar:android/support/v4/media/MediaDescriptionCompat$Builder.class */
    public static final class Builder {
        private CharSequence mDescription;
        private Bundle mExtras;
        private Bitmap mIcon;
        private Uri mIconUri;
        private String mMediaId;
        private Uri mMediaUri;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }

        public Builder setDescription(CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap) {
            this.mIcon = bitmap;
            return this;
        }

        public Builder setIconUri(Uri uri) {
            this.mIconUri = uri;
            return this;
        }

        public Builder setMediaId(String str) {
            this.mMediaId = str;
            return this;
        }

        public Builder setMediaUri(Uri uri) {
            this.mMediaUri = uri;
            return this;
        }

        public Builder setSubtitle(CharSequence charSequence) {
            this.mSubtitle = charSequence;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.mMediaId = parcel.readString();
        this.mTitle = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSubtitle = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = getClass().getClassLoader();
        this.mIcon = (Bitmap) parcel.readParcelable(classLoader);
        this.mIconUri = (Uri) parcel.readParcelable(classLoader);
        this.mExtras = parcel.readBundle(classLoader);
        this.mMediaUri = (Uri) parcel.readParcelable(classLoader);
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.mMediaId = str;
        this.mTitle = charSequence;
        this.mSubtitle = charSequence2;
        this.mDescription = charSequence3;
        this.mIcon = bitmap;
        this.mIconUri = uri;
        this.mExtras = bundle;
        this.mMediaUri = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.support.v4.media.MediaDescriptionCompat fromMediaDescription(java.lang.Object r3) {
        /*
            r0 = 0
            r6 = r0
            r0 = 0
            r5 = r0
            r0 = r6
            r4 = r0
            r0 = r3
            if (r0 == 0) goto Lcd
            r0 = r6
            r4 = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto Lcd
            android.support.v4.media.MediaDescriptionCompat$Builder r0 = new android.support.v4.media.MediaDescriptionCompat$Builder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            r1 = r3
            java.lang.String r1 = android.support.v4.media.MediaDescriptionCompatApi21.getMediaId(r1)
            android.support.v4.media.MediaDescriptionCompat$Builder r0 = r0.setMediaId(r1)
            r0 = r7
            r1 = r3
            java.lang.CharSequence r1 = android.support.v4.media.MediaDescriptionCompatApi21.getTitle(r1)
            android.support.v4.media.MediaDescriptionCompat$Builder r0 = r0.setTitle(r1)
            r0 = r7
            r1 = r3
            java.lang.CharSequence r1 = android.support.v4.media.MediaDescriptionCompatApi21.getSubtitle(r1)
            android.support.v4.media.MediaDescriptionCompat$Builder r0 = r0.setSubtitle(r1)
            r0 = r7
            r1 = r3
            java.lang.CharSequence r1 = android.support.v4.media.MediaDescriptionCompatApi21.getDescription(r1)
            android.support.v4.media.MediaDescriptionCompat$Builder r0 = r0.setDescription(r1)
            r0 = r7
            r1 = r3
            android.graphics.Bitmap r1 = android.support.v4.media.MediaDescriptionCompatApi21.getIconBitmap(r1)
            android.support.v4.media.MediaDescriptionCompat$Builder r0 = r0.setIconBitmap(r1)
            r0 = r7
            r1 = r3
            android.net.Uri r1 = android.support.v4.media.MediaDescriptionCompatApi21.getIconUri(r1)
            android.support.v4.media.MediaDescriptionCompat$Builder r0 = r0.setIconUri(r1)
            r0 = r3
            android.os.Bundle r0 = android.support.v4.media.MediaDescriptionCompatApi21.getExtras(r0)
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L73
            r0 = r6
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r0)
            r0 = r6
            java.lang.String r1 = "android.support.v4.media.description.MEDIA_URI"
            android.os.Parcelable r0 = r0.getParcelable(r1)
            android.net.Uri r0 = (android.net.Uri) r0
            r4 = r0
            goto L75
        L73:
            r0 = 0
            r4 = r0
        L75:
            r0 = r4
            if (r0 == 0) goto L99
            r0 = r6
            java.lang.String r1 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L8d
            r0 = r6
            int r0 = r0.size()
            r1 = 2
            if (r0 != r1) goto L8d
            goto L9b
        L8d:
            r0 = r6
            java.lang.String r1 = "android.support.v4.media.description.MEDIA_URI"
            r0.remove(r1)
            r0 = r6
            java.lang.String r1 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            r0.remove(r1)
        L99:
            r0 = r6
            r5 = r0
        L9b:
            r0 = r7
            r1 = r5
            android.support.v4.media.MediaDescriptionCompat$Builder r0 = r0.setExtras(r1)
            r0 = r4
            if (r0 == 0) goto Lb0
            r0 = r7
            r1 = r4
            android.support.v4.media.MediaDescriptionCompat$Builder r0 = r0.setMediaUri(r1)
            goto Lc2
        Lb0:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto Lc2
            r0 = r7
            r1 = r3
            android.net.Uri r1 = android.support.v4.media.MediaDescriptionCompatApi23.getMediaUri(r1)
            android.support.v4.media.MediaDescriptionCompat$Builder r0 = r0.setMediaUri(r1)
        Lc2:
            r0 = r7
            android.support.v4.media.MediaDescriptionCompat r0 = r0.build()
            r4 = r0
            r0 = r4
            r1 = r3
            r0.mDescriptionObj = r1
        Lcd:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.fromMediaDescription(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Object getMediaDescription() {
        if (this.mDescriptionObj != null || Build.VERSION.SDK_INT < 21) {
            return this.mDescriptionObj;
        }
        Object newInstance = MediaDescriptionCompatApi21.Builder.newInstance();
        MediaDescriptionCompatApi21.Builder.setMediaId(newInstance, this.mMediaId);
        MediaDescriptionCompatApi21.Builder.setTitle(newInstance, this.mTitle);
        MediaDescriptionCompatApi21.Builder.setSubtitle(newInstance, this.mSubtitle);
        MediaDescriptionCompatApi21.Builder.setDescription(newInstance, this.mDescription);
        MediaDescriptionCompatApi21.Builder.setIconBitmap(newInstance, this.mIcon);
        MediaDescriptionCompatApi21.Builder.setIconUri(newInstance, this.mIconUri);
        Bundle bundle = this.mExtras;
        Bundle bundle2 = bundle;
        if (Build.VERSION.SDK_INT < 23) {
            bundle2 = bundle;
            if (this.mMediaUri != null) {
                bundle2 = bundle;
                if (bundle == null) {
                    bundle2 = new Bundle();
                    bundle2.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
                }
                bundle2.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.mMediaUri);
            }
        }
        MediaDescriptionCompatApi21.Builder.setExtras(newInstance, bundle2);
        if (Build.VERSION.SDK_INT >= 23) {
            MediaDescriptionCompatApi23.Builder.setMediaUri(newInstance, this.mMediaUri);
        }
        Object build = MediaDescriptionCompatApi21.Builder.build(newInstance);
        this.mDescriptionObj = build;
        return build;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public String toString() {
        return ((Object) this.mTitle) + ", " + ((Object) this.mSubtitle) + ", " + ((Object) this.mDescription);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), parcel, i);
            return;
        }
        parcel.writeString(this.mMediaId);
        TextUtils.writeToParcel(this.mTitle, parcel, i);
        TextUtils.writeToParcel(this.mSubtitle, parcel, i);
        TextUtils.writeToParcel(this.mDescription, parcel, i);
        parcel.writeParcelable(this.mIcon, i);
        parcel.writeParcelable(this.mIconUri, i);
        parcel.writeBundle(this.mExtras);
        parcel.writeParcelable(this.mMediaUri, i);
    }
}
