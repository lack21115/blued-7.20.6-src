package android.webkit;

import android.text.TextUtils;
import com.android.internal.http.multipart.FilePart;
import com.android.internal.http.multipart.StringPart;
import java.util.regex.Pattern;
import libcore.net.MimeUtils;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/MimeTypeMap.class */
public class MimeTypeMap {
    private static final MimeTypeMap sMimeTypeMap = new MimeTypeMap();

    private MimeTypeMap() {
    }

    public static String getFileExtensionFromUrl(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf2 = str.lastIndexOf(35);
        String str2 = str;
        if (lastIndexOf2 > 0) {
            str2 = str.substring(0, lastIndexOf2);
        }
        int lastIndexOf3 = str2.lastIndexOf(63);
        String str3 = str2;
        if (lastIndexOf3 > 0) {
            str3 = str2.substring(0, lastIndexOf3);
        }
        int lastIndexOf4 = str3.lastIndexOf(47);
        if (lastIndexOf4 >= 0) {
            str3 = str3.substring(lastIndexOf4 + 1);
        }
        return (str3.isEmpty() || !Pattern.matches("[a-zA-Z_0-9\\.\\-\\(\\)\\%]+", str3) || (lastIndexOf = str3.lastIndexOf(46)) < 0) ? "" : str3.substring(lastIndexOf + 1);
    }

    public static MimeTypeMap getSingleton() {
        return sMimeTypeMap;
    }

    private static String mimeTypeFromExtension(String str) {
        return MimeUtils.guessMimeTypeFromExtension(str);
    }

    public String getExtensionFromMimeType(String str) {
        return MimeUtils.guessExtensionFromMimeType(str);
    }

    public String getMimeTypeFromExtension(String str) {
        return MimeUtils.guessMimeTypeFromExtension(str);
    }

    public boolean hasExtension(String str) {
        return MimeUtils.hasExtension(str);
    }

    public boolean hasMimeType(String str) {
        return MimeUtils.hasMimeType(str);
    }

    String remapGenericMimeType(String str, String str2, String str3) {
        String str4;
        if (StringPart.DEFAULT_CONTENT_TYPE.equals(str) || FilePart.DEFAULT_CONTENT_TYPE.equals(str)) {
            String str5 = null;
            if (str3 != null) {
                str5 = URLUtil.parseContentDisposition(str3);
            }
            if (str5 != null) {
                str2 = str5;
            }
            String mimeTypeFromExtension = getMimeTypeFromExtension(getFileExtensionFromUrl(str2));
            str4 = str;
            if (mimeTypeFromExtension != null) {
                str4 = mimeTypeFromExtension;
            }
        } else if ("text/vnd.wap.wml".equals(str)) {
            return StringPart.DEFAULT_CONTENT_TYPE;
        } else {
            str4 = str;
            if ("application/vnd.wap.xhtml+xml".equals(str)) {
                return "application/xhtml+xml";
            }
        }
        return str4;
    }
}
