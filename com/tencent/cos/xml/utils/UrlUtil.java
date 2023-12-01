package com.tencent.cos.xml.utils;

import android.text.TextUtils;
import com.tencent.cos.xml.common.Range;
import com.tencent.cos.xml.model.tag.UrlUploadPolicy;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.http.HttpResult;
import com.tencent.qcloud.core.http.QCloudHttpClient;
import com.tencent.qcloud.core.util.QCloudHttpUtils;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/utils/UrlUtil.class */
public class UrlUtil {
    public static UrlUploadPolicy getUrlUploadPolicy(String str) {
        if (isUrl(str)) {
            try {
                URL url = new URL(str);
                try {
                    HttpResult executeNow = QCloudHttpClient.getDefault().resolveRequest(new HttpRequest.Builder().url(url).method("GET").addHeader("Range", new Range(0L, 1L).getRange()).build()).executeNow();
                    if (executeNow != null && executeNow.isSuccessful() && executeNow.headers() != null && executeNow.headers().size() > 0) {
                        String header = executeNow.header("Accept-Ranges");
                        String header2 = executeNow.header("Content-Range");
                        if (!"bytes".equals(header) || TextUtils.isEmpty(header2)) {
                            String header3 = executeNow.header("Content-Length");
                            if (!TextUtils.isEmpty(header3)) {
                                return new UrlUploadPolicy(UrlUploadPolicy.Type.ENTIRETY, Long.parseLong(header3));
                            }
                        } else {
                            long[] parseContentRange = QCloudHttpUtils.parseContentRange(header2);
                            if (parseContentRange != null) {
                                return new UrlUploadPolicy(UrlUploadPolicy.Type.RANGE, parseContentRange[2]);
                            }
                        }
                    }
                    return new UrlUploadPolicy(UrlUploadPolicy.Type.NOTSUPPORT, 0L);
                } catch (QCloudClientException | QCloudServiceException e) {
                    return new UrlUploadPolicy(UrlUploadPolicy.Type.NOTSUPPORT, 0L);
                }
            } catch (MalformedURLException e2) {
                return new UrlUploadPolicy(UrlUploadPolicy.Type.NOTSUPPORT, 0L);
            }
        }
        return new UrlUploadPolicy(UrlUploadPolicy.Type.NOTSUPPORT, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (android.webkit.URLUtil.isHttpUrl(r3) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isUrl(java.lang.String r3) {
        /*
            r0 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r4 = r0
            r0 = 0
            r5 = r0
            r0 = r4
            if (r0 == 0) goto Ld
            r0 = 0
            return r0
        Ld:
            r0 = r5
            r4 = r0
            java.util.regex.Pattern r0 = android.util.Patterns.WEB_URL
            r1 = r3
            java.util.regex.Matcher r0 = r0.matcher(r1)
            boolean r0 = r0.matches()
            if (r0 == 0) goto L2e
            r0 = r3
            boolean r0 = android.webkit.URLUtil.isHttpsUrl(r0)
            if (r0 != 0) goto L2c
            r0 = r5
            r4 = r0
            r0 = r3
            boolean r0 = android.webkit.URLUtil.isHttpUrl(r0)
            if (r0 == 0) goto L2e
        L2c:
            r0 = 1
            r4 = r0
        L2e:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cos.xml.utils.UrlUtil.isUrl(java.lang.String):boolean");
    }
}
