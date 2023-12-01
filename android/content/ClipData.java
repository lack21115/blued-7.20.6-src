package android.content;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.StrictMode;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.util.Log;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/content/ClipData.class */
public class ClipData implements Parcelable {
    final ClipDescription mClipDescription;
    final Bitmap mIcon;
    final ArrayList<Item> mItems;
    static final String[] MIMETYPES_TEXT_PLAIN = {"text/plain"};
    static final String[] MIMETYPES_TEXT_HTML = {ClipDescription.MIMETYPE_TEXT_HTML};
    static final String[] MIMETYPES_TEXT_URILIST = {ClipDescription.MIMETYPE_TEXT_URILIST};
    static final String[] MIMETYPES_TEXT_INTENT = {ClipDescription.MIMETYPE_TEXT_INTENT};
    public static final Parcelable.Creator<ClipData> CREATOR = new Parcelable.Creator<ClipData>() { // from class: android.content.ClipData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClipData createFromParcel(Parcel parcel) {
            return new ClipData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClipData[] newArray(int i) {
            return new ClipData[i];
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/content/ClipData$Item.class */
    public static class Item {
        final String mHtmlText;
        final Intent mIntent;
        final CharSequence mText;
        Uri mUri;

        public Item(Intent intent) {
            this.mText = null;
            this.mHtmlText = null;
            this.mIntent = intent;
            this.mUri = null;
        }

        public Item(Uri uri) {
            this.mText = null;
            this.mHtmlText = null;
            this.mIntent = null;
            this.mUri = uri;
        }

        public Item(CharSequence charSequence) {
            this.mText = charSequence;
            this.mHtmlText = null;
            this.mIntent = null;
            this.mUri = null;
        }

        public Item(CharSequence charSequence, Intent intent, Uri uri) {
            this.mText = charSequence;
            this.mHtmlText = null;
            this.mIntent = intent;
            this.mUri = uri;
        }

        public Item(CharSequence charSequence, String str) {
            this.mText = charSequence;
            this.mHtmlText = str;
            this.mIntent = null;
            this.mUri = null;
        }

        public Item(CharSequence charSequence, String str, Intent intent, Uri uri) {
            if (str != null && charSequence == null) {
                throw new IllegalArgumentException("Plain text must be supplied if HTML text is supplied");
            }
            this.mText = charSequence;
            this.mHtmlText = str;
            this.mIntent = intent;
            this.mUri = uri;
        }

        private CharSequence coerceToHtmlOrStyledText(Context context, boolean z) {
            String str;
            boolean z2;
            if (this.mUri == null) {
                return this.mIntent != null ? z ? uriToStyledText(this.mIntent.toUri(1)) : uriToHtml(this.mIntent.toUri(1)) : "";
            }
            String[] streamTypes = context.getContentResolver().getStreamTypes(this.mUri, "text/*");
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            if (streamTypes != null) {
                int length = streamTypes.length;
                int i = 0;
                while (true) {
                    z3 = z4;
                    z5 = z6;
                    if (i >= length) {
                        break;
                    }
                    String str2 = streamTypes[i];
                    if (ClipDescription.MIMETYPE_TEXT_HTML.equals(str2)) {
                        z2 = true;
                    } else {
                        z2 = z4;
                        if (str2.startsWith("text/")) {
                            z6 = true;
                            z2 = z4;
                        }
                    }
                    i++;
                    z4 = z2;
                }
            }
            if (z3 || z5) {
                FileInputStream fileInputStream = null;
                FileInputStream fileInputStream2 = null;
                FileInputStream fileInputStream3 = null;
                try {
                    try {
                        FileInputStream createInputStream = context.getContentResolver().openTypedAssetFileDescriptor(this.mUri, z3 ? ClipDescription.MIMETYPE_TEXT_HTML : "text/plain", null).createInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(createInputStream, "UTF-8");
                        StringBuilder sb = new StringBuilder(128);
                        char[] cArr = new char[8192];
                        while (true) {
                            int read = inputStreamReader.read(cArr);
                            if (read <= 0) {
                                break;
                            }
                            sb.append(cArr, 0, read);
                        }
                        String sb2 = sb.toString();
                        if (z3) {
                            if (z) {
                                try {
                                    CharSequence fromHtml = Html.fromHtml(sb2);
                                    if (fromHtml == null) {
                                        fromHtml = sb2;
                                    }
                                    if (createInputStream != null) {
                                        try {
                                            createInputStream.close();
                                        } catch (IOException e) {
                                        }
                                    }
                                    return fromHtml;
                                } catch (RuntimeException e2) {
                                    str = sb2;
                                    if (createInputStream != null) {
                                        try {
                                            createInputStream.close();
                                            return sb2;
                                        } catch (IOException e3) {
                                            return sb2;
                                        }
                                    }
                                }
                            } else {
                                String str3 = sb2.toString();
                                str = str3;
                                if (createInputStream != null) {
                                    try {
                                        createInputStream.close();
                                        return str3;
                                    } catch (IOException e4) {
                                        return str3;
                                    }
                                }
                            }
                        } else if (z) {
                            str = sb2;
                            if (createInputStream != null) {
                                try {
                                    createInputStream.close();
                                    return sb2;
                                } catch (IOException e5) {
                                    return sb2;
                                }
                            }
                        } else {
                            String escapeHtml = Html.escapeHtml(sb2);
                            str = escapeHtml;
                            if (createInputStream != null) {
                                try {
                                    createInputStream.close();
                                    return escapeHtml;
                                } catch (IOException e6) {
                                    return escapeHtml;
                                }
                            }
                        }
                    } catch (FileNotFoundException e7) {
                        if (0 != 0) {
                            try {
                                fileInputStream3.close();
                            } catch (IOException e8) {
                            }
                        }
                    } catch (IOException e9) {
                        Log.w("ClippedData", "Failure loading text", e9);
                        String escapeHtml2 = Html.escapeHtml(e9.toString());
                        str = escapeHtml2;
                        if (0 != 0) {
                            try {
                                fileInputStream.close();
                                return escapeHtml2;
                            } catch (IOException e10) {
                                return escapeHtml2;
                            }
                        }
                    }
                    return str;
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e11) {
                        }
                    }
                    throw th;
                }
            }
            if (z) {
                str = uriToStyledText(this.mUri.toString());
                return str;
            }
            return uriToHtml(this.mUri.toString());
        }

        private String uriToHtml(String str) {
            StringBuilder sb = new StringBuilder(256);
            sb.append("<a href=\"");
            sb.append(Html.escapeHtml(str));
            sb.append("\">");
            sb.append(Html.escapeHtml(str));
            sb.append("</a>");
            return sb.toString();
        }

        private CharSequence uriToStyledText(String str) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new URLSpan(str), 0, spannableStringBuilder.length(), 33);
            return spannableStringBuilder;
        }

        public String coerceToHtmlText(Context context) {
            String htmlText = getHtmlText();
            if (htmlText != null) {
                return htmlText;
            }
            CharSequence text = getText();
            if (text != null) {
                return text instanceof Spanned ? Html.toHtml((Spanned) text) : Html.escapeHtml(text);
            }
            CharSequence coerceToHtmlOrStyledText = coerceToHtmlOrStyledText(context, false);
            return coerceToHtmlOrStyledText != null ? coerceToHtmlOrStyledText.toString() : null;
        }

        public CharSequence coerceToStyledText(Context context) {
            CharSequence text = getText();
            if (!(text instanceof Spanned)) {
                String htmlText = getHtmlText();
                if (htmlText != null) {
                    try {
                        Spanned fromHtml = Html.fromHtml(htmlText);
                        if (fromHtml != null) {
                            return fromHtml;
                        }
                    } catch (RuntimeException e) {
                    }
                }
                if (text == null) {
                    return coerceToHtmlOrStyledText(context, true);
                }
            }
            return text;
        }

        public CharSequence coerceToText(Context context) {
            String text = getText();
            if (text == null) {
                Uri uri = getUri();
                if (uri == null) {
                    Intent intent = getIntent();
                    return intent != null ? intent.toUri(1) : "";
                }
                FileInputStream fileInputStream = null;
                FileInputStream fileInputStream2 = null;
                FileInputStream fileInputStream3 = null;
                try {
                    try {
                        FileInputStream createInputStream = context.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null).createInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(createInputStream, "UTF-8");
                        StringBuilder sb = new StringBuilder(128);
                        char[] cArr = new char[8192];
                        while (true) {
                            int read = inputStreamReader.read(cArr);
                            if (read <= 0) {
                                break;
                            }
                            sb.append(cArr, 0, read);
                        }
                        fileInputStream3 = createInputStream;
                        fileInputStream = createInputStream;
                        fileInputStream2 = createInputStream;
                        String sb2 = sb.toString();
                        text = sb2;
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                                return sb2;
                            } catch (IOException e) {
                                return sb2;
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                            } catch (IOException e3) {
                            }
                        }
                        return uri.toString();
                    } catch (IOException e4) {
                        Log.w("ClippedData", "Failure loading text", e4);
                        FileInputStream fileInputStream4 = fileInputStream;
                        String iOException = e4.toString();
                        text = iOException;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return iOException;
                            } catch (IOException e5) {
                                return iOException;
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            }
            return text;
        }

        public String getHtmlText() {
            return this.mHtmlText;
        }

        public Intent getIntent() {
            return this.mIntent;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public void toShortString(StringBuilder sb) {
            if (this.mHtmlText != null) {
                sb.append("H:");
                sb.append(this.mHtmlText);
            } else if (this.mText != null) {
                sb.append("T:");
                sb.append(this.mText);
            } else if (this.mUri != null) {
                sb.append("U:");
                sb.append(this.mUri);
            } else if (this.mIntent == null) {
                sb.append(WifiEnterpriseConfig.EMPTY_VALUE);
            } else {
                sb.append("I:");
                this.mIntent.toShortString(sb, true, true, true, true);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("ClipData.Item { ");
            toShortString(sb);
            sb.append(" }");
            return sb.toString();
        }
    }

    public ClipData(ClipData clipData) {
        this.mClipDescription = clipData.mClipDescription;
        this.mIcon = clipData.mIcon;
        this.mItems = new ArrayList<>(clipData.mItems);
    }

    public ClipData(ClipDescription clipDescription, Item item) {
        this.mClipDescription = clipDescription;
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        this.mIcon = null;
        this.mItems = new ArrayList<>();
        this.mItems.add(item);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClipData(Parcel parcel) {
        this.mClipDescription = new ClipDescription(parcel);
        if (parcel.readInt() != 0) {
            this.mIcon = Bitmap.CREATOR.createFromParcel(parcel);
        } else {
            this.mIcon = null;
        }
        this.mItems = new ArrayList<>();
        int readInt = parcel.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            this.mItems.add(new Item(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() != 0 ? Intent.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Uri.CREATOR.createFromParcel(parcel) : null));
            i = i2 + 1;
        }
    }

    public ClipData(CharSequence charSequence, String[] strArr, Item item) {
        this.mClipDescription = new ClipDescription(charSequence, strArr);
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        this.mIcon = null;
        this.mItems = new ArrayList<>();
        this.mItems.add(item);
    }

    public static ClipData newHtmlText(CharSequence charSequence, CharSequence charSequence2, String str) {
        return new ClipData(charSequence, MIMETYPES_TEXT_HTML, new Item(charSequence2, str));
    }

    public static ClipData newIntent(CharSequence charSequence, Intent intent) {
        return new ClipData(charSequence, MIMETYPES_TEXT_INTENT, new Item(intent));
    }

    public static ClipData newPlainText(CharSequence charSequence, CharSequence charSequence2) {
        return new ClipData(charSequence, MIMETYPES_TEXT_PLAIN, new Item(charSequence2));
    }

    public static ClipData newRawUri(CharSequence charSequence, Uri uri) {
        return new ClipData(charSequence, MIMETYPES_TEXT_URILIST, new Item(uri));
    }

    public static ClipData newUri(ContentResolver contentResolver, CharSequence charSequence, Uri uri) {
        int i = 2;
        Item item = new Item(uri);
        String[] strArr = null;
        if ("content".equals(uri.getScheme())) {
            String type = contentResolver.getType(uri);
            strArr = contentResolver.getStreamTypes(uri, "*/*");
            if (strArr != null) {
                int length = strArr.length;
                if (type == null) {
                    i = 1;
                }
                String[] strArr2 = new String[i + length];
                int i2 = 0;
                if (type != null) {
                    strArr2[0] = type;
                    i2 = 0 + 1;
                }
                System.arraycopy(strArr, 0, strArr2, i2, strArr.length);
                strArr2[strArr.length + i2] = ClipDescription.MIMETYPE_TEXT_URILIST;
                strArr = strArr2;
            } else if (type != null) {
                strArr = new String[]{type, ClipDescription.MIMETYPE_TEXT_URILIST};
            }
        }
        String[] strArr3 = strArr;
        if (strArr == null) {
            strArr3 = MIMETYPES_TEXT_URILIST;
        }
        return new ClipData(charSequence, strArr3, item);
    }

    public void addItem(Item item) {
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        this.mItems.add(item);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void fixUris(int i) {
        int size = this.mItems.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            Item item = this.mItems.get(i3);
            if (item.mIntent != null) {
                item.mIntent.fixUris(i);
            }
            if (item.mUri != null) {
                item.mUri = ContentProvider.maybeAddUserId(item.mUri, i);
            }
            i2 = i3 + 1;
        }
    }

    public void fixUrisLight(int i) {
        Uri data;
        int size = this.mItems.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            Item item = this.mItems.get(i3);
            if (item.mIntent != null && (data = item.mIntent.getData()) != null) {
                item.mIntent.setData(ContentProvider.maybeAddUserId(data, i));
            }
            if (item.mUri != null) {
                item.mUri = ContentProvider.maybeAddUserId(item.mUri, i);
            }
            i2 = i3 + 1;
        }
    }

    public ClipDescription getDescription() {
        return this.mClipDescription;
    }

    public Bitmap getIcon() {
        return this.mIcon;
    }

    public Item getItemAt(int i) {
        return this.mItems.get(i);
    }

    public int getItemCount() {
        return this.mItems.size();
    }

    public void prepareToLeaveProcess() {
        int size = this.mItems.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            Item item = this.mItems.get(i2);
            if (item.mIntent != null) {
                item.mIntent.prepareToLeaveProcess();
            }
            if (item.mUri != null && StrictMode.vmFileUriExposureEnabled()) {
                item.mUri.checkFileUriExposed("ClipData.Item.getUri()");
            }
            i = i2 + 1;
        }
    }

    public void toShortString(StringBuilder sb) {
        boolean z = this.mClipDescription != null ? !this.mClipDescription.toShortString(sb) : true;
        boolean z2 = z;
        if (this.mIcon != null) {
            if (!z) {
                sb.append(' ');
            }
            z2 = false;
            sb.append("I:");
            sb.append(this.mIcon.getWidth());
            sb.append('x');
            sb.append(this.mIcon.getHeight());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mItems.size()) {
                return;
            }
            if (!z2) {
                sb.append(' ');
            }
            z2 = false;
            sb.append('{');
            this.mItems.get(i2).toShortString(sb);
            sb.append('}');
            i = i2 + 1;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("ClipData { ");
        toShortString(sb);
        sb.append(" }");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.mClipDescription.writeToParcel(parcel, i);
        if (this.mIcon != null) {
            parcel.writeInt(1);
            this.mIcon.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        int size = this.mItems.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            Item item = this.mItems.get(i3);
            TextUtils.writeToParcel(item.mText, parcel, i);
            parcel.writeString(item.mHtmlText);
            if (item.mIntent != null) {
                parcel.writeInt(1);
                item.mIntent.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
            if (item.mUri != null) {
                parcel.writeInt(1);
                item.mUri.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
            i2 = i3 + 1;
        }
    }
}
