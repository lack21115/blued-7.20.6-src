package android.mtp;

/* loaded from: source-9557208-dex2jar.jar:android/mtp/MtpObjectInfo.class */
public final class MtpObjectInfo {
    private int mAssociationDesc;
    private int mAssociationType;
    private int mCompressedSize;
    private long mDateCreated;
    private long mDateModified;
    private int mFormat;
    private int mHandle;
    private int mImagePixDepth;
    private int mImagePixHeight;
    private int mImagePixWidth;
    private String mKeywords;
    private String mName;
    private int mParent;
    private int mProtectionStatus;
    private int mSequenceNumber;
    private int mStorageId;
    private int mThumbCompressedSize;
    private int mThumbFormat;
    private int mThumbPixHeight;
    private int mThumbPixWidth;

    private MtpObjectInfo() {
    }

    public final int getAssociationDesc() {
        return this.mAssociationDesc;
    }

    public final int getAssociationType() {
        return this.mAssociationType;
    }

    public final int getCompressedSize() {
        return this.mCompressedSize;
    }

    public final long getDateCreated() {
        return this.mDateCreated;
    }

    public final long getDateModified() {
        return this.mDateModified;
    }

    public final int getFormat() {
        return this.mFormat;
    }

    public final int getImagePixDepth() {
        return this.mImagePixDepth;
    }

    public final int getImagePixHeight() {
        return this.mImagePixHeight;
    }

    public final int getImagePixWidth() {
        return this.mImagePixWidth;
    }

    public final String getKeywords() {
        return this.mKeywords;
    }

    public final String getName() {
        return this.mName;
    }

    public final int getObjectHandle() {
        return this.mHandle;
    }

    public final int getParent() {
        return this.mParent;
    }

    public final int getProtectionStatus() {
        return this.mProtectionStatus;
    }

    public final int getSequenceNumber() {
        return this.mSequenceNumber;
    }

    public final int getStorageId() {
        return this.mStorageId;
    }

    public final int getThumbCompressedSize() {
        return this.mThumbCompressedSize;
    }

    public final int getThumbFormat() {
        return this.mThumbFormat;
    }

    public final int getThumbPixHeight() {
        return this.mThumbPixHeight;
    }

    public final int getThumbPixWidth() {
        return this.mThumbPixWidth;
    }
}
