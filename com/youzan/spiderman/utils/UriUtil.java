package com.youzan.spiderman.utils;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/UriUtil.class */
public class UriUtil {
    public static String buildMimeType(String str) {
        return StringUtils.equals(str, Stone.CSS_SUFFIX) ? "text/css" : StringUtils.equals(str, Stone.JS_SUFFIX) ? "application/x-javascript" : StringUtils.equals(str, "ico") ? "image/x-icon" : String.format("image/%s", str);
    }

    public static String getMD5Content(Uri uri) {
        if (uri != null) {
            if (isScript(uri)) {
                Uri.Builder authority = new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority());
                for (String str : uri.getPathSegments()) {
                    authority.appendPath(str);
                }
                return authority.toString();
            }
            return uri.toString();
        }
        return "";
    }

    public static String getUriExtend(Uri uri) {
        int lastIndexOf;
        if (uri != null) {
            String lastPathSegment = uri.getLastPathSegment();
            return (TextUtils.isEmpty(lastPathSegment) || (lastIndexOf = lastPathSegment.lastIndexOf(".")) < 0) ? "" : lastPathSegment.substring(lastIndexOf + 1);
        }
        return "";
    }

    public static boolean isImg(Uri uri) {
        return isImg(getUriExtend(uri));
    }

    public static boolean isImg(String str) {
        String[] strArr = Stone.IMG_EXTEND_LIST;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (StringUtils.equals(str, strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean isScript(Uri uri) {
        return isScript(getUriExtend(uri));
    }

    public static boolean isScript(String str) {
        String[] strArr = Stone.SCRIPT_EXTEND_LIST;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (StringUtils.equals(str, strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }
}
