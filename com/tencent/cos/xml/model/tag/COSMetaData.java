package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.crypto.Headers;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/COSMetaData.class */
public class COSMetaData {
    private Map<String, String> metaData = new HashMap();

    public String get(String str) {
        return this.metaData.get(str);
    }

    public Set<String> keySet() {
        return this.metaData.keySet();
    }

    public void put(String str, String str2) {
        String str3 = str;
        if (!str.startsWith(Headers.COS_USER_METADATA_PREFIX)) {
            str3 = Headers.COS_USER_METADATA_PREFIX + str;
        }
        this.metaData.put(str3, str2);
    }
}
