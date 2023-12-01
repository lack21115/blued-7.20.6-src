package android.webkit;

import android.net.ParseException;
import android.net.Uri;
import android.net.WebAddress;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/URLUtil.class */
public final class URLUtil {
    static final String ASSET_BASE = "file:///android_asset/";
    static final String CONTENT_BASE = "content:";
    private static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);
    static final String FILE_BASE = "file://";
    private static final String LOGTAG = "webkit";
    static final String PROXY_BASE = "file:///cookieless_proxy/";
    static final String RESOURCE_BASE = "file:///android_res/";
    private static final boolean TRACE = false;

    public static String composeSearchUrl(String str, String str2, String str3) {
        int indexOf = str2.indexOf(str3);
        if (indexOf < 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2.substring(0, indexOf));
        try {
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append(str2.substring(str3.length() + indexOf));
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static byte[] decode(byte[] bArr) throws IllegalArgumentException {
        if (bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        while (i2 < bArr.length) {
            byte b = bArr[i2];
            byte b2 = b;
            int i3 = i2;
            if (b == 37) {
                if (bArr.length - i2 <= 2) {
                    throw new IllegalArgumentException("Invalid format");
                }
                b2 = (byte) ((parseHex(bArr[i2 + 1]) * 16) + parseHex(bArr[i2 + 2]));
                i3 = i2 + 2;
            }
            bArr2[i] = b2;
            i2 = i3 + 1;
            i++;
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    public static final String guessFileName(String str, String str2, String str3) {
        String substring;
        String str4;
        String str5 = null;
        if (0 == 0) {
            str5 = null;
            if (str2 != null) {
                String parseContentDisposition = parseContentDisposition(str2);
                str5 = parseContentDisposition;
                if (parseContentDisposition != null) {
                    int lastIndexOf = parseContentDisposition.lastIndexOf(47) + 1;
                    str5 = parseContentDisposition;
                    if (lastIndexOf > 0) {
                        str5 = parseContentDisposition.substring(lastIndexOf);
                    }
                }
            }
        }
        String str6 = str5;
        if (str5 == null) {
            String decode = Uri.decode(str);
            str6 = str5;
            if (decode != null) {
                int indexOf = decode.indexOf(63);
                String str7 = decode;
                if (indexOf > 0) {
                    str7 = decode.substring(0, indexOf);
                }
                str6 = str5;
                if (!str7.endsWith(BridgeUtil.SPLIT_MARK)) {
                    int lastIndexOf2 = str7.lastIndexOf(47) + 1;
                    str6 = str5;
                    if (lastIndexOf2 > 0) {
                        str6 = str7.substring(lastIndexOf2);
                    }
                }
            }
        }
        String str8 = str6;
        if (str6 == null) {
            str8 = "downloadfile";
        }
        int indexOf2 = str8.indexOf(46);
        if (indexOf2 < 0) {
            String str9 = null;
            if (str3 != null) {
                String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                str9 = extensionFromMimeType;
                if (extensionFromMimeType != null) {
                    str9 = "." + extensionFromMimeType;
                }
            }
            str4 = str9;
            substring = str8;
            if (str9 == null) {
                if (str3 == null || !str3.toLowerCase(Locale.ROOT).startsWith("text/")) {
                    str4 = ".bin";
                    substring = str8;
                } else if (str3.equalsIgnoreCase("text/html")) {
                    str4 = ".html";
                    substring = str8;
                } else {
                    str4 = ".txt";
                    substring = str8;
                }
            }
        } else {
            String str10 = null;
            if (str3 != null) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str8.substring(str8.lastIndexOf(46) + 1));
                str10 = null;
                if (mimeTypeFromExtension != null) {
                    str10 = null;
                    if (!mimeTypeFromExtension.equalsIgnoreCase(str3)) {
                        String extensionFromMimeType2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                        str10 = extensionFromMimeType2;
                        if (extensionFromMimeType2 != null) {
                            str10 = "." + extensionFromMimeType2;
                        }
                    }
                }
            }
            String str11 = str10;
            if (str10 == null) {
                str11 = str8.substring(indexOf2);
            }
            substring = str8.substring(0, indexOf2);
            str4 = str11;
        }
        return substring + str4;
    }

    public static String guessUrl(String str) {
        if (str.length() == 0 || str.startsWith("about:") || str.startsWith("data:") || str.startsWith("file:") || str.startsWith(BridgeUtil.JAVASCRIPT_STR)) {
            return str;
        }
        String str2 = str;
        if (str.endsWith(".")) {
            str2 = str.substring(0, str.length() - 1);
        }
        try {
            WebAddress webAddress = new WebAddress(str2);
            if (webAddress.getHost().indexOf(46) == -1) {
                webAddress.setHost("www." + webAddress.getHost() + ".com");
            }
            return webAddress.toString();
        } catch (ParseException e) {
            return str;
        }
    }

    public static boolean isAboutUrl(String str) {
        return str != null && str.startsWith("about:");
    }

    public static boolean isAssetUrl(String str) {
        return str != null && str.startsWith(ASSET_BASE);
    }

    public static boolean isContentUrl(String str) {
        return str != null && str.startsWith(CONTENT_BASE);
    }

    @Deprecated
    public static boolean isCookielessProxyUrl(String str) {
        return str != null && str.startsWith(PROXY_BASE);
    }

    public static boolean isDataUrl(String str) {
        return str != null && str.startsWith("data:");
    }

    public static boolean isFileUrl(String str) {
        return (str == null || !str.startsWith(FILE_BASE) || str.startsWith(ASSET_BASE) || str.startsWith(PROXY_BASE)) ? false : true;
    }

    public static boolean isHttpUrl(String str) {
        boolean z = false;
        if (str != null) {
            z = false;
            if (str.length() > 6) {
                z = false;
                if (str.substring(0, 7).equalsIgnoreCase("http://")) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static boolean isHttpsUrl(String str) {
        boolean z = false;
        if (str != null) {
            z = false;
            if (str.length() > 7) {
                z = false;
                if (str.substring(0, 8).equalsIgnoreCase("https://")) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static boolean isJavaScriptUrl(String str) {
        return str != null && str.startsWith(BridgeUtil.JAVASCRIPT_STR);
    }

    public static boolean isNetworkUrl(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return isHttpUrl(str) || isHttpsUrl(str);
    }

    public static boolean isResourceUrl(String str) {
        return str != null && str.startsWith(RESOURCE_BASE);
    }

    public static boolean isValidUrl(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return isAssetUrl(str) || isResourceUrl(str) || isFileUrl(str) || isAboutUrl(str) || isHttpUrl(str) || isHttpsUrl(str) || isJavaScriptUrl(str) || isContentUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String parseContentDisposition(String str) {
        try {
            Matcher matcher = CONTENT_DISPOSITION_PATTERN.matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
            return null;
        } catch (IllegalStateException e) {
            return null;
        }
    }

    private static int parseHex(byte b) {
        if (b < 48 || b > 57) {
            if (b < 65 || b > 70) {
                if (b < 97 || b > 102) {
                    throw new IllegalArgumentException("Invalid hex char '" + ((int) b) + "'");
                }
                return (b - 97) + 10;
            }
            return (b - 65) + 10;
        }
        return b - 48;
    }

    public static String stripAnchor(String str) {
        int indexOf = str.indexOf(35);
        String str2 = str;
        if (indexOf != -1) {
            str2 = str.substring(0, indexOf);
        }
        return str2;
    }

    static boolean verifyURLEncoding(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int indexOf = str.indexOf(37);
        while (true) {
            int i = indexOf;
            if (i < 0 || i >= length) {
                return true;
            }
            if (i >= length - 2) {
                return false;
            }
            int i2 = i + 1;
            try {
                parseHex((byte) str.charAt(i2));
                int i3 = i2 + 1;
                parseHex((byte) str.charAt(i3));
                indexOf = str.indexOf(37, i3 + 1);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
    }
}
