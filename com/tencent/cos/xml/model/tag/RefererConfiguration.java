package com.tencent.cos.xml.model.tag;

import com.google.common.net.HttpHeaders;
import com.tencent.cos.xml.model.bucket.PutBucketIntelligentTieringRequest;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RefererConfiguration.class */
public class RefererConfiguration {
    public List<Domain> domainList;
    public String emptyReferConfiguration;
    public String refererType;
    public String status;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RefererConfiguration$Domain.class */
    public static class Domain {
        public String domain;

        public Domain() {
        }

        public Domain(String str) {
            this.domain = str;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RefererConfiguration$RefererType.class */
    public enum RefererType {
        Black("Black-List"),
        White("White-List");
        
        private final String type;

        RefererType(String str) {
            this.type = str;
        }

        public static RefererType fromString(String str) {
            RefererType[] values = values();
            int length = values.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                RefererType refererType = values[i2];
                if (refererType.getTypeStr().equalsIgnoreCase(str)) {
                    return refererType;
                }
                i = i2 + 1;
            }
        }

        public String getTypeStr() {
            return this.type;
        }
    }

    public boolean getAllowEmptyRefer() {
        return HttpHeaders.ALLOW.equals(this.emptyReferConfiguration);
    }

    public boolean getEnabled() {
        return PutBucketIntelligentTieringRequest.STATUS_ENABLED.equals(this.status);
    }

    public RefererType getRefererType() {
        return RefererType.fromString(this.refererType);
    }

    public void setAllowEmptyRefer(boolean z) {
        if (z) {
            this.emptyReferConfiguration = HttpHeaders.ALLOW;
        } else {
            this.emptyReferConfiguration = "Deny";
        }
    }

    public void setEnabled(boolean z) {
        if (z) {
            this.status = PutBucketIntelligentTieringRequest.STATUS_ENABLED;
        } else {
            this.status = "Disabled";
        }
    }

    public void setRefererType(RefererType refererType) {
        this.refererType = refererType.getTypeStr();
    }
}
