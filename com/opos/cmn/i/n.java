package com.opos.cmn.i;

import android.text.TextUtils;
import java.net.URLEncoder;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/n.class */
public class n {
    public static final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
}
