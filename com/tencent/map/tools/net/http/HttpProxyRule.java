package com.tencent.map.tools.net.http;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/net/http/HttpProxyRule.class */
public class HttpProxyRule extends JsonComposer {
    @Json(name = "domain")
    public String domain;
    @Json(name = "proxy_domain")
    public String proxyDomain;

    public boolean match(String str) {
        Uri parse;
        String scheme;
        String host;
        if (str == null || (scheme = (parse = Uri.parse(str)).getScheme()) == null || !scheme.startsWith("http") || (host = parse.getHost()) == null || TextUtils.isEmpty(host)) {
            return false;
        }
        return host.matches(this.domain);
    }

    public String replaceHost(String str) {
        if (str == null) {
            return null;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String str2 = str;
        if (scheme != null) {
            if (!scheme.startsWith("http")) {
                return str;
            }
            String host = parse.getHost();
            str2 = str;
            if (host != null) {
                str2 = str;
                if (!TextUtils.isEmpty(host)) {
                    str2 = str;
                    if (host.matches(this.domain)) {
                        str2 = parse.buildUpon().encodedAuthority(this.proxyDomain).build().toString();
                    }
                }
            }
        }
        return str2;
    }
}
