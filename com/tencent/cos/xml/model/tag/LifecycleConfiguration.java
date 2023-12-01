package com.tencent.cos.xml.model.tag;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/LifecycleConfiguration.class */
public class LifecycleConfiguration {
    public List<Rule> rules;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/LifecycleConfiguration$AbortIncompleteMultiUpload.class */
    public static class AbortIncompleteMultiUpload {
        public int daysAfterInitiation;

        public String toString() {
            return "{AbortIncompleteMultiUpload:\nDaysAfterInitiation:" + this.daysAfterInitiation + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/LifecycleConfiguration$Expiration.class */
    public static class Expiration {
        public String date;
        public int days;
        public String expiredObjectDeleteMarker;

        public String toString() {
            return "{Expiration:\nDays:" + this.days + "\nDate:" + this.date + "\nExpiredObjectDeleteMarker:" + this.expiredObjectDeleteMarker + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/LifecycleConfiguration$Filter.class */
    public static class Filter {
        public String prefix;

        public String toString() {
            return "{Filter:\nPrefix:" + this.prefix + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionExpiration.class */
    public static class NoncurrentVersionExpiration {
        public int noncurrentDays;

        public String toString() {
            return "{NoncurrentVersionExpiration:\nNoncurrentDays:" + this.noncurrentDays + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionTransition.class */
    public static class NoncurrentVersionTransition {
        public int noncurrentDays;
        public String storageClass;

        public String toString() {
            return "{NoncurrentVersionTransition:\nNoncurrentDays:" + this.noncurrentDays + "\nStorageClass:" + this.storageClass + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule.class */
    public static class Rule {
        public AbortIncompleteMultiUpload abortIncompleteMultiUpload;
        public Expiration expiration;
        public Filter filter;
        public String id;
        public NoncurrentVersionExpiration noncurrentVersionExpiration;
        public NoncurrentVersionTransition noncurrentVersionTransition;
        public String status;
        public Transition transition;

        public String toString() {
            StringBuilder sb = new StringBuilder("{Rule:\n");
            sb.append("Id:");
            sb.append(this.id);
            sb.append("\n");
            Filter filter = this.filter;
            if (filter != null) {
                sb.append(filter.toString());
                sb.append("\n");
            }
            sb.append("Status:");
            sb.append(this.status);
            sb.append("\n");
            Transition transition = this.transition;
            if (transition != null) {
                sb.append(transition.toString());
                sb.append("\n");
            }
            Expiration expiration = this.expiration;
            if (expiration != null) {
                sb.append(expiration.toString());
                sb.append("\n");
            }
            NoncurrentVersionExpiration noncurrentVersionExpiration = this.noncurrentVersionExpiration;
            if (noncurrentVersionExpiration != null) {
                sb.append(noncurrentVersionExpiration.toString());
                sb.append("\n");
            }
            NoncurrentVersionTransition noncurrentVersionTransition = this.noncurrentVersionTransition;
            if (noncurrentVersionTransition != null) {
                sb.append(noncurrentVersionTransition.toString());
                sb.append("\n");
            }
            AbortIncompleteMultiUpload abortIncompleteMultiUpload = this.abortIncompleteMultiUpload;
            if (abortIncompleteMultiUpload != null) {
                sb.append(abortIncompleteMultiUpload.toString());
                sb.append("\n");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/LifecycleConfiguration$Transition.class */
    public static class Transition {
        public String date;
        public int days;
        public String storageClass;

        public String toString() {
            return "{Transition:\nDays:" + this.days + "\nDate:" + this.date + "\nStorageClass:" + this.storageClass + "\n}";
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{LifecycleConfiguration:\n");
        List<Rule> list = this.rules;
        if (list != null) {
            for (Rule rule : list) {
                if (rule != null) {
                    sb.append(rule.toString());
                    sb.append("\n");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
