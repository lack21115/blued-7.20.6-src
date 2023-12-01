package com.tencent.cos.xml.model.tag;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/BucketLoggingStatus.class */
public class BucketLoggingStatus {
    public LoggingEnabled loggingEnabled;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/BucketLoggingStatus$LoggingEnabled.class */
    public static class LoggingEnabled {
        public String targetBucket;
        public String targetPrefix;

        public String toString() {
            return "{LoggingEnabled:\nTargetBucket:" + this.targetBucket + "\nTargetPrefix:" + this.targetPrefix + "\n}";
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{BucketLoggingStatus:\n");
        LoggingEnabled loggingEnabled = this.loggingEnabled;
        if (loggingEnabled != null) {
            sb.append(loggingEnabled.toString());
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
