package com.tencent.cos.xml.model.tag;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/CORSConfiguration.class */
public class CORSConfiguration {
    public List<CORSRule> corsRules;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule.class */
    public static class CORSRule {
        public List<String> allowedHeader;
        public List<String> allowedMethod;
        public String allowedOrigin;
        public List<String> exposeHeader;
        public String id;
        public int maxAgeSeconds;

        public String toString() {
            StringBuilder sb = new StringBuilder("{CORSRule:\n");
            sb.append("ID:");
            sb.append(this.id);
            sb.append("\n");
            sb.append("AllowedOrigin:");
            sb.append(this.allowedOrigin);
            sb.append("\n");
            List<String> list = this.allowedMethod;
            if (list != null) {
                for (String str : list) {
                    if (str != null) {
                        sb.append("AllowedMethod:");
                        sb.append(str);
                        sb.append("\n");
                    }
                }
            }
            List<String> list2 = this.allowedHeader;
            if (list2 != null) {
                for (String str2 : list2) {
                    if (str2 != null) {
                        sb.append("AllowedHeader:");
                        sb.append(str2);
                        sb.append("\n");
                    }
                }
            }
            List<String> list3 = this.exposeHeader;
            if (list3 != null) {
                for (String str3 : list3) {
                    if (str3 != null) {
                        sb.append("ExposeHeader:");
                        sb.append(str3);
                        sb.append("\n");
                    }
                }
            }
            sb.append("MaxAgeSeconds:");
            sb.append(this.maxAgeSeconds);
            sb.append("\n");
            sb.append("}");
            return sb.toString();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{CORSConfiguration:\n");
        List<CORSRule> list = this.corsRules;
        if (list != null) {
            for (CORSRule cORSRule : list) {
                if (cORSRule != null) {
                    sb.append(cORSRule.toString());
                    sb.append("\n");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
