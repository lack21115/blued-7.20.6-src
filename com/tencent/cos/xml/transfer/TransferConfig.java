package com.tencent.cos.xml.transfer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/TransferConfig.class */
public class TransferConfig {
    protected long divisionForCopy;
    protected long divisionForUpload;
    private boolean forceSimpleUpload;
    protected long sliceSizeForCopy;
    protected long sliceSizeForUpload;
    private boolean verifyCRC64;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/TransferConfig$Builder.class */
    public static class Builder {
        private long divisionForCopy = 5242880;
        private long sliceSizeForCopy = 5242880;
        private long divisionForUpload = 2097152;
        private long sliceSizeForUpload = 1048576;
        private boolean forceSimpleUpload = false;
        private boolean verifyCRC64 = true;

        private Builder setVerifyCRC64(boolean z) {
            this.verifyCRC64 = z;
            return this;
        }

        public TransferConfig build() {
            return new TransferConfig(this);
        }

        public Builder setDividsionForCopy(long j) {
            if (j > 0) {
                this.divisionForCopy = j;
            }
            return this;
        }

        public Builder setDivisionForUpload(long j) {
            if (j > 0) {
                this.divisionForUpload = j;
            }
            return this;
        }

        public Builder setForceSimpleUpload(boolean z) {
            this.forceSimpleUpload = z;
            return this;
        }

        public Builder setSliceSizeForCopy(long j) {
            if (j > 0) {
                this.sliceSizeForCopy = j;
            }
            return this;
        }

        public Builder setSliceSizeForUpload(long j) {
            if (j > 0) {
                this.sliceSizeForUpload = j;
            }
            return this;
        }
    }

    TransferConfig(Builder builder) {
        this.verifyCRC64 = true;
        this.divisionForCopy = builder.divisionForCopy;
        this.sliceSizeForCopy = builder.sliceSizeForCopy;
        this.divisionForUpload = builder.divisionForUpload;
        this.sliceSizeForUpload = builder.sliceSizeForUpload;
        this.forceSimpleUpload = builder.forceSimpleUpload;
        this.verifyCRC64 = builder.verifyCRC64;
    }

    public long getDivisionForCopy() {
        return this.divisionForCopy;
    }

    public boolean isForceSimpleUpload() {
        return this.forceSimpleUpload;
    }

    public boolean isVerifyCRC64() {
        return this.verifyCRC64;
    }
}
