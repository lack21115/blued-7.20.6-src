package com.tencent.cos.xml.model.tag;

import com.alipay.sdk.util.i;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/InventoryConfiguration.class */
public class InventoryConfiguration {
    public static final String SCHEDULE_FREQUENCY_DAILY = "Daily";
    public static final String SCHEDULE_FREQUENCY_WEEKLY = "Weekly";
    public Destination destination;
    public Filter filter;
    public String id;
    public String includedObjectVersions;
    public boolean isEnabled;
    public OptionalFields optionalFields;
    public Schedule schedule;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/InventoryConfiguration$COSBucketDestination.class */
    public static class COSBucketDestination {
        public String accountId;
        public String bucket;
        public Encryption encryption;
        public String format;
        public String prefix;

        public void setBucket(String str, String str2) {
            if (str == null || str2 == null) {
                return;
            }
            this.bucket = String.format("qcs::cos:%s::%s", str, str2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{COSBucketDestination:\n");
            sb.append("Format:");
            sb.append(this.format);
            sb.append("\n");
            sb.append("AccountId:");
            sb.append(this.accountId);
            sb.append("\n");
            sb.append("Bucket:");
            sb.append(this.bucket);
            sb.append("\n");
            sb.append("Prefix:");
            sb.append(this.prefix);
            sb.append("\n");
            Encryption encryption = this.encryption;
            if (encryption != null) {
                sb.append(encryption.toString());
                sb.append("\n");
            }
            sb.append(i.d);
            return sb.toString();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/InventoryConfiguration$Destination.class */
    public static class Destination {
        public COSBucketDestination cosBucketDestination;

        public String toString() {
            StringBuilder sb = new StringBuilder("{Destination:\n");
            COSBucketDestination cOSBucketDestination = this.cosBucketDestination;
            if (cOSBucketDestination != null) {
                sb.append(cOSBucketDestination.toString());
                sb.append("\n");
            }
            sb.append(i.d);
            return sb.toString();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/InventoryConfiguration$Encryption.class */
    public static class Encryption {
        public String sSECOS;

        public String toString() {
            return "{Encryption:\nSSE-COS:" + this.sSECOS + "\n" + i.d;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/InventoryConfiguration$Field.class */
    public enum Field {
        SIZE("Size"),
        LastModified_Date("LastModifiedDate"),
        StroageClass("StorageClass"),
        ETAG(DownloadUtils.ETAG),
        IS_MULTIPARTUPLOADed("IsMultipartUploaded"),
        REPLICATION_STATUS("ReplicationStatus");
        
        String value;

        Field(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/InventoryConfiguration$Filter.class */
    public static class Filter {
        public String prefix;

        public String toString() {
            return "{Filter:\nPrefix:" + this.prefix + "\n" + i.d;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/InventoryConfiguration$Frequency.class */
    public enum Frequency {
        DAILY(InventoryConfiguration.SCHEDULE_FREQUENCY_DAILY);
        
        String value;

        Frequency(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/InventoryConfiguration$IncludedObjectVersions.class */
    public enum IncludedObjectVersions {
        ALL("All"),
        CURRENT("Current");
        
        private String desc;

        IncludedObjectVersions(String str) {
            this.desc = str;
        }

        public String getDesc() {
            return this.desc;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/InventoryConfiguration$OptionalFields.class */
    public static class OptionalFields {
        public Set<String> fields;

        public String toString() {
            StringBuilder sb = new StringBuilder("{OptionalFields:\n");
            Set<String> set = this.fields;
            if (set != null) {
                for (String str : set) {
                    sb.append("Field:");
                    sb.append(str);
                    sb.append("\n");
                }
            }
            sb.append(i.d);
            return sb.toString();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/InventoryConfiguration$Schedule.class */
    public static class Schedule {
        public String frequency;

        public String toString() {
            return "{Schedule:\nFrequency:" + this.frequency + "\n" + i.d;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{InventoryConfiguration:\n");
        sb.append("Id");
        sb.append(this.id);
        sb.append("\n");
        sb.append("IsEnabled:");
        sb.append(this.isEnabled);
        sb.append("\n");
        Destination destination = this.destination;
        if (destination != null) {
            sb.append(destination.toString());
            sb.append("\n");
        }
        Schedule schedule = this.schedule;
        if (schedule != null) {
            sb.append(schedule.toString());
            sb.append("\n");
        }
        Filter filter = this.filter;
        if (filter != null) {
            sb.append(filter.toString());
            sb.append("\n");
        }
        sb.append("IncludedObjectVersions:");
        sb.append(this.includedObjectVersions);
        sb.append("\n");
        OptionalFields optionalFields = this.optionalFields;
        if (optionalFields != null) {
            sb.append(optionalFields.toString());
            sb.append("\n");
        }
        sb.append(i.d);
        return sb.toString();
    }
}
