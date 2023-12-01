package com.tencent.qcloud.core.auth;

import android.net.http.Headers;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.openalliance.ad.constant.t;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.HttpConfiguration;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.util.QCloudHttpUtils;
import com.tencent.qcloud.core.util.QCloudStringUtils;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/auth/COSXmlSignSourceProvider.class */
public class COSXmlSignSourceProvider implements QCloudSignSourceProvider {
    private Map<String, List<String>> headerPairs;
    private String signTime;
    private final List<String> needToSignHeaders = Arrays.asList("cache-control", Headers.CONTENT_DISPOSITION, Headers.CONTENT_ENCODING, Headers.CONTENT_LEN, "content-md5", Headers.CONTENT_TYPE, "expect", "expires", "host", "if-match", DownloadUtils.IF_MODIFIED_SINCE, "if-none-match", "if-unmodified-since", HttpHeaders.ReferrerPolicyValues.ORIGIN, "range", "response-cache-control", "response-content-disposition", "response-content-encoding", "response-content-language", "response-content-type", "response-expires", Headers.TRANSFER_ENCODING, "versionid");
    private Set<String> headerKeysRequiredToSign = new HashSet();
    private Set<String> parametersRequiredToSign = new HashSet();
    private Set<String> headerKeysSigned = new HashSet();
    private Set<String> parametersSigned = new HashSet();

    private String headersStringForKeys(Map<String, List<String>> map, Set<String> set, Set<String> set2) {
        StringBuilder sb = new StringBuilder();
        LinkedList<String> linkedList = new LinkedList();
        for (String str : set) {
            linkedList.add(QCloudHttpUtils.urlEncodeString(str).toLowerCase(Locale.ROOT));
        }
        Collections.sort(linkedList, new Comparator<String>() { // from class: com.tencent.qcloud.core.auth.COSXmlSignSourceProvider.2
            @Override // java.util.Comparator
            public int compare(String str2, String str3) {
                return str2.compareTo(str3);
            }
        });
        Set<String> keySet = map.keySet();
        HashMap hashMap = new HashMap();
        for (String str2 : keySet) {
            hashMap.put(str2.toLowerCase(Locale.ROOT), str2);
        }
        boolean z = true;
        for (String str3 : linkedList) {
            List<String> list = map.get(hashMap.get(str3));
            if (list != null) {
                Iterator<String> it = list.iterator();
                boolean z2 = z;
                while (true) {
                    z = z2;
                    if (it.hasNext()) {
                        String next = it.next();
                        if (!z2) {
                            sb.append('&');
                        }
                        set2.add(str3.toLowerCase(Locale.ROOT));
                        sb.append(str3.toLowerCase(Locale.ROOT));
                        sb.append('=');
                        z2 = false;
                        if (!TextUtils.isEmpty(next)) {
                            sb.append(QCloudHttpUtils.urlEncodeString(next));
                            z2 = false;
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    private String queryStringForKeys(URL url, Set<String> set, Set<String> set2) {
        StringBuilder sb = new StringBuilder();
        LinkedList<String> linkedList = new LinkedList();
        for (String str : set) {
            linkedList.add(str.toLowerCase(Locale.ROOT));
        }
        Collections.sort(linkedList, new Comparator<String>() { // from class: com.tencent.qcloud.core.auth.COSXmlSignSourceProvider.1
            @Override // java.util.Comparator
            public int compare(String str2, String str3) {
                return str2.compareTo(str3);
            }
        });
        Map<String, List<String>> decodedQueryPair = QCloudHttpUtils.getDecodedQueryPair(url);
        Set<String> keySet = decodedQueryPair.keySet();
        HashMap hashMap = new HashMap();
        for (String str2 : keySet) {
            hashMap.put(str2.toLowerCase(Locale.ROOT), str2);
        }
        boolean z = true;
        for (String str3 : linkedList) {
            List<String> list = decodedQueryPair.get(hashMap.get(str3));
            if (list != null) {
                Iterator<String> it = list.iterator();
                boolean z2 = z;
                while (true) {
                    z = z2;
                    if (it.hasNext()) {
                        String next = it.next();
                        if (!z2) {
                            sb.append('&');
                        }
                        set2.add(str3.toLowerCase(Locale.ROOT));
                        sb.append(str3.toLowerCase(Locale.ROOT));
                        sb.append('=');
                        z2 = false;
                        if (!TextUtils.isEmpty(next)) {
                            sb.append(QCloudHttpUtils.urlEncodeString(next));
                            z2 = false;
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    private String sortAndJoinSemicolon(Set<String> set) {
        if (set == null) {
            return "";
        }
        TreeSet<String> treeSet = new TreeSet(set);
        StringBuilder sb = new StringBuilder();
        for (String str : treeSet) {
            if (!QCloudStringUtils.isEmpty(sb.toString())) {
                sb.append(t.aE);
            }
            sb.append(str);
        }
        return sb.toString();
    }

    private Set<String> toLowerCase(Set<String> set) {
        if (set == null || set.size() <= 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (str != null) {
                hashSet.add(str.toLowerCase(Locale.ROOT));
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getRealHeaderList() {
        return sortAndJoinSemicolon(this.headerKeysSigned);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getRealParameterList() {
        return sortAndJoinSemicolon(this.parametersSigned);
    }

    public void header(String str) {
        this.headerKeysRequiredToSign.add(str);
    }

    public void headers(Set<String> set) {
        if (set != null) {
            this.headerKeysRequiredToSign.addAll(set);
        }
    }

    @Override // com.tencent.qcloud.core.auth.QCloudSignSourceProvider
    public <T> void onSignRequestSuccess(HttpRequest<T> httpRequest, QCloudCredentials qCloudCredentials, String str) {
    }

    public void parameter(String str) {
        this.parametersRequiredToSign.add(str);
    }

    public void parameters(Set<String> set) {
        if (set != null) {
            this.parametersRequiredToSign.addAll(set);
        }
    }

    public void setHeaderPairsForSign(Map<String, List<String>> map) {
        this.headerPairs = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSignTime(String str) {
        this.signTime = str;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudSignSourceProvider
    public <T> String source(HttpRequest<T> httpRequest) throws QCloudClientException {
        String contentType;
        if (httpRequest == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        hashSet.add("Content-Type");
        hashSet.add("Content-Length");
        for (String str : httpRequest.headers().keySet()) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            if (this.needToSignHeaders.contains(lowerCase) || lowerCase.startsWith(com.tencent.cos.xml.crypto.Headers.COS_PREFIX)) {
                hashSet.add(str);
            }
        }
        if (httpRequest.getNoSignHeaders() != null) {
            for (String str2 : httpRequest.getNoSignHeaders()) {
                hashSet.remove(str2);
            }
        }
        if (this.headerKeysRequiredToSign.size() < 1) {
            this.headerKeysRequiredToSign.addAll(hashSet);
        }
        if (this.parametersRequiredToSign.size() < 1) {
            Map<String, List<String>> queryPair = QCloudHttpUtils.getQueryPair(httpRequest.url());
            for (String str3 : httpRequest.getNoSignHeaders()) {
                queryPair.remove(QCloudHttpUtils.urlDecodeString(str3));
            }
            this.parametersRequiredToSign.addAll(queryPair.keySet());
        }
        if (this.headerKeysRequiredToSign.size() > 0) {
            Set<String> lowerCase2 = toLowerCase(this.headerKeysRequiredToSign);
            if (lowerCase2 != null && lowerCase2.contains("Content-Type".toLowerCase(Locale.ROOT)) && httpRequest.getRequestBody() != null && !httpRequest.headers().containsKey("Content-Type") && (contentType = httpRequest.contentType()) != null) {
                httpRequest.addHeader("Content-Type", contentType);
            }
            if (lowerCase2 != null && lowerCase2.contains("Content-Length".toLowerCase(Locale.ROOT)) && httpRequest.getRequestBody() != null) {
                try {
                    long contentLength = httpRequest.contentLength();
                    if (contentLength != -1) {
                        httpRequest.addHeader("Content-Length", Long.toString(contentLength));
                        httpRequest.removeHeader("Transfer-Encoding");
                    } else {
                        httpRequest.addHeader("Transfer-Encoding", DownloadUtils.VALUE_CHUNKED);
                        httpRequest.removeHeader("Content-Length");
                    }
                } catch (IOException e) {
                    throw new QCloudClientException("read content length fails", e);
                }
            }
            if (lowerCase2 != null && lowerCase2.contains("Date".toLowerCase(Locale.ROOT))) {
                httpRequest.addHeader("Date", HttpConfiguration.getGMTDate(new Date()));
            }
        }
        StringBuilder sb = new StringBuilder(httpRequest.method().toLowerCase(Locale.ROOT));
        sb.append("\n");
        sb.append(QCloudHttpUtils.urlDecodeString(httpRequest.url().getPath()));
        sb.append("\n");
        sb.append(queryStringForKeys(httpRequest.url(), this.parametersRequiredToSign, this.parametersSigned));
        sb.append("\n");
        Map<String, List<String>> map = this.headerPairs;
        Map<String, List<String>> headers = map != null ? map : httpRequest.headers();
        this.headerPairs = headers;
        sb.append(headers != null ? headersStringForKeys(headers, this.headerKeysRequiredToSign, this.headerKeysSigned) : "");
        sb.append("\n");
        return AuthConstants.SHA1 + "\n" + this.signTime + "\n" + Utils.encodeHexString(Utils.sha1(sb.toString())) + "\n";
    }
}
