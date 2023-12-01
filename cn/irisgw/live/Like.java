package cn.irisgw.live;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/Like.class */
public final class Like extends GeneratedMessageV3 implements LikeOrBuilder {
    public static final int FANS_STATUS_FIELD_NUMBER = 7;
    public static final int FAN_CLUB_LEVEL_FIELD_NUMBER = 5;
    public static final int FAN_CLUB_NAME_FIELD_NUMBER = 4;
    public static final int IN_FAN_CLUB_FIELD_NUMBER = 6;
    public static final int LIANG_ID_FIELD_NUMBER = 2;
    public static final int LIANG_TYPE_FIELD_NUMBER = 1;
    public static final int RECHARGE_BADGE_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int fanClubLevel_;
    private volatile Object fanClubName_;
    private int fansStatus_;
    private boolean inFanClub_;
    private volatile Object liangId_;
    private int liangType_;
    private byte memoizedIsInitialized;
    private int rechargeBadge_;
    private static final Like DEFAULT_INSTANCE = new Like();
    private static final Parser<Like> PARSER = new AbstractParser<Like>() { // from class: cn.irisgw.live.Like.1
        /* renamed from: parsePartialFrom */
        public Like m3901parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Like(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/Like$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LikeOrBuilder {
        private int fanClubLevel_;
        private Object fanClubName_;
        private int fansStatus_;
        private boolean inFanClub_;
        private Object liangId_;
        private int liangType_;
        private int rechargeBadge_;

        private Builder() {
            this.liangType_ = 0;
            this.liangId_ = "";
            this.fanClubName_ = "";
            this.fansStatus_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.liangType_ = 0;
            this.liangId_ = "";
            this.fanClubName_ = "";
            this.fansStatus_ = 0;
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_Like_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = Like.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m3903addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public Like m3905build() {
            Like m3907buildPartial = m3907buildPartial();
            if (m3907buildPartial.isInitialized()) {
                return m3907buildPartial;
            }
            throw newUninitializedMessageException(m3907buildPartial);
        }

        /* renamed from: buildPartial */
        public Like m3907buildPartial() {
            Like like = new Like(this);
            like.liangType_ = this.liangType_;
            like.liangId_ = this.liangId_;
            like.rechargeBadge_ = this.rechargeBadge_;
            like.fanClubName_ = this.fanClubName_;
            like.fanClubLevel_ = this.fanClubLevel_;
            like.inFanClub_ = this.inFanClub_;
            like.fansStatus_ = this.fansStatus_;
            onBuilt();
            return like;
        }

        /* renamed from: clear */
        public Builder m3911clear() {
            super.clear();
            this.liangType_ = 0;
            this.liangId_ = "";
            this.rechargeBadge_ = 0;
            this.fanClubName_ = "";
            this.fanClubLevel_ = 0;
            this.inFanClub_ = false;
            this.fansStatus_ = 0;
            return this;
        }

        public Builder clearFanClubLevel() {
            this.fanClubLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearFanClubName() {
            this.fanClubName_ = Like.getDefaultInstance().getFanClubName();
            onChanged();
            return this;
        }

        public Builder clearFansStatus() {
            this.fansStatus_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m3913clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearInFanClub() {
            this.inFanClub_ = false;
            onChanged();
            return this;
        }

        public Builder clearLiangId() {
            this.liangId_ = Like.getDefaultInstance().getLiangId();
            onChanged();
            return this;
        }

        public Builder clearLiangType() {
            this.liangType_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m3916clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRechargeBadge() {
            this.rechargeBadge_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m3922clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public Like m3924getDefaultInstanceForType() {
            return Like.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_Like_descriptor;
        }

        @Override // cn.irisgw.live.LikeOrBuilder
        public int getFanClubLevel() {
            return this.fanClubLevel_;
        }

        @Override // cn.irisgw.live.LikeOrBuilder
        public String getFanClubName() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fanClubName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LikeOrBuilder
        public ByteString getFanClubNameBytes() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fanClubName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LikeOrBuilder
        public FanStatus getFansStatus() {
            FanStatus valueOf = FanStatus.valueOf(this.fansStatus_);
            FanStatus fanStatus = valueOf;
            if (valueOf == null) {
                fanStatus = FanStatus.UNRECOGNIZED;
            }
            return fanStatus;
        }

        @Override // cn.irisgw.live.LikeOrBuilder
        public int getFansStatusValue() {
            return this.fansStatus_;
        }

        @Override // cn.irisgw.live.LikeOrBuilder
        public boolean getInFanClub() {
            return this.inFanClub_;
        }

        @Override // cn.irisgw.live.LikeOrBuilder
        public String getLiangId() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liangId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LikeOrBuilder
        public ByteString getLiangIdBytes() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liangId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LikeOrBuilder
        public LiangType getLiangType() {
            LiangType valueOf = LiangType.valueOf(this.liangType_);
            LiangType liangType = valueOf;
            if (valueOf == null) {
                liangType = LiangType.UNRECOGNIZED;
            }
            return liangType;
        }

        @Override // cn.irisgw.live.LikeOrBuilder
        public int getLiangTypeValue() {
            return this.liangType_;
        }

        @Override // cn.irisgw.live.LikeOrBuilder
        public int getRechargeBadge() {
            return this.rechargeBadge_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_Like_fieldAccessorTable.ensureFieldAccessorsInitialized(Like.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(Like like) {
            if (like == Like.getDefaultInstance()) {
                return this;
            }
            if (like.liangType_ != 0) {
                setLiangTypeValue(like.getLiangTypeValue());
            }
            if (!like.getLiangId().isEmpty()) {
                this.liangId_ = like.liangId_;
                onChanged();
            }
            if (like.getRechargeBadge() != 0) {
                setRechargeBadge(like.getRechargeBadge());
            }
            if (!like.getFanClubName().isEmpty()) {
                this.fanClubName_ = like.fanClubName_;
                onChanged();
            }
            if (like.getFanClubLevel() != 0) {
                setFanClubLevel(like.getFanClubLevel());
            }
            if (like.getInFanClub()) {
                setInFanClub(like.getInFanClub());
            }
            if (like.fansStatus_ != 0) {
                setFansStatusValue(like.getFansStatusValue());
            }
            m3933mergeUnknownFields(like.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.Like.Builder m3930mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.Like.access$1200()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.Like r0 = (cn.irisgw.live.Like) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.Like$Builder r0 = r0.mergeFrom(r1)
            L1a:
                r0 = r4
                return r0
            L1c:
                r6 = move-exception
                r0 = r7
                r5 = r0
                goto L31
            L22:
                r6 = move-exception
                r0 = r6
                com.google.protobuf.MessageLite r0 = r0.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L1c
                cn.irisgw.live.Like r0 = (cn.irisgw.live.Like) r0     // Catch: java.lang.Throwable -> L1c
                r5 = r0
                r0 = r6
                java.io.IOException r0 = r0.unwrapIOException()     // Catch: java.lang.Throwable -> L30
                throw r0     // Catch: java.lang.Throwable -> L30
            L30:
                r6 = move-exception
            L31:
                r0 = r5
                if (r0 == 0) goto L3b
                r0 = r4
                r1 = r5
                cn.irisgw.live.Like$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.Like.Builder.m3930mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.Like$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m3929mergeFrom(Message message) {
            if (message instanceof Like) {
                return mergeFrom((Like) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m3933mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setFanClubLevel(int i) {
            this.fanClubLevel_ = i;
            onChanged();
            return this;
        }

        public Builder setFanClubName(String str) {
            if (str != null) {
                this.fanClubName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setFanClubNameBytes(ByteString byteString) {
            if (byteString != null) {
                Like.checkByteStringIsUtf8(byteString);
                this.fanClubName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setFansStatus(FanStatus fanStatus) {
            if (fanStatus != null) {
                this.fansStatus_ = fanStatus.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setFansStatusValue(int i) {
            this.fansStatus_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m3935setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setInFanClub(boolean z) {
            this.inFanClub_ = z;
            onChanged();
            return this;
        }

        public Builder setLiangId(String str) {
            if (str != null) {
                this.liangId_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLiangIdBytes(ByteString byteString) {
            if (byteString != null) {
                Like.checkByteStringIsUtf8(byteString);
                this.liangId_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLiangType(LiangType liangType) {
            if (liangType != null) {
                this.liangType_ = liangType.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLiangTypeValue(int i) {
            this.liangType_ = i;
            onChanged();
            return this;
        }

        public Builder setRechargeBadge(int i) {
            this.rechargeBadge_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m3937setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m3939setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private Like() {
        this.memoizedIsInitialized = (byte) -1;
        this.liangType_ = 0;
        this.liangId_ = "";
        this.fanClubName_ = "";
        this.fansStatus_ = 0;
    }

    private Like(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw null;
        }
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.liangType_ = codedInputStream.readEnum();
                            } else if (readTag == 18) {
                                this.liangId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.rechargeBadge_ = codedInputStream.readInt32();
                            } else if (readTag == 34) {
                                this.fanClubName_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 40) {
                                this.fanClubLevel_ = codedInputStream.readInt32();
                            } else if (readTag == 48) {
                                this.inFanClub_ = codedInputStream.readBool();
                            } else if (readTag == 56) {
                                this.fansStatus_ = codedInputStream.readEnum();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private Like(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Like getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_Like_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m3900toBuilder();
    }

    public static Builder newBuilder(Like like) {
        return DEFAULT_INSTANCE.m3900toBuilder().mergeFrom(like);
    }

    public static Like parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Like parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Like parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Like) PARSER.parseFrom(byteString);
    }

    public static Like parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Like) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Like parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Like parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Like parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Like parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Like parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Like) PARSER.parseFrom(byteBuffer);
    }

    public static Like parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Like) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Like parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Like) PARSER.parseFrom(bArr);
    }

    public static Like parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Like) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<Like> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Like) {
            Like like = (Like) obj;
            return this.liangType_ == like.liangType_ && getLiangId().equals(like.getLiangId()) && getRechargeBadge() == like.getRechargeBadge() && getFanClubName().equals(like.getFanClubName()) && getFanClubLevel() == like.getFanClubLevel() && getInFanClub() == like.getInFanClub() && this.fansStatus_ == like.fansStatus_ && this.unknownFields.equals(like.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public Like m3895getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LikeOrBuilder
    public int getFanClubLevel() {
        return this.fanClubLevel_;
    }

    @Override // cn.irisgw.live.LikeOrBuilder
    public String getFanClubName() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.fanClubName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LikeOrBuilder
    public ByteString getFanClubNameBytes() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fanClubName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LikeOrBuilder
    public FanStatus getFansStatus() {
        FanStatus valueOf = FanStatus.valueOf(this.fansStatus_);
        FanStatus fanStatus = valueOf;
        if (valueOf == null) {
            fanStatus = FanStatus.UNRECOGNIZED;
        }
        return fanStatus;
    }

    @Override // cn.irisgw.live.LikeOrBuilder
    public int getFansStatusValue() {
        return this.fansStatus_;
    }

    @Override // cn.irisgw.live.LikeOrBuilder
    public boolean getInFanClub() {
        return this.inFanClub_;
    }

    @Override // cn.irisgw.live.LikeOrBuilder
    public String getLiangId() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.liangId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LikeOrBuilder
    public ByteString getLiangIdBytes() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.liangId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LikeOrBuilder
    public LiangType getLiangType() {
        LiangType valueOf = LiangType.valueOf(this.liangType_);
        LiangType liangType = valueOf;
        if (valueOf == null) {
            liangType = LiangType.UNRECOGNIZED;
        }
        return liangType;
    }

    @Override // cn.irisgw.live.LikeOrBuilder
    public int getLiangTypeValue() {
        return this.liangType_;
    }

    public Parser<Like> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.LikeOrBuilder
    public int getRechargeBadge() {
        return this.rechargeBadge_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.liangType_ != LiangType.None.getNumber()) {
            i2 = 0 + CodedOutputStream.computeEnumSize(1, this.liangType_);
        }
        int i3 = i2;
        if (!getLiangIdBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.liangId_);
        }
        int i4 = this.rechargeBadge_;
        int i5 = i3;
        if (i4 != 0) {
            i5 = i3 + CodedOutputStream.computeInt32Size(3, i4);
        }
        int i6 = i5;
        if (!getFanClubNameBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.fanClubName_);
        }
        int i7 = this.fanClubLevel_;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeInt32Size(5, i7);
        }
        boolean z = this.inFanClub_;
        int i9 = i8;
        if (z) {
            i9 = i8 + CodedOutputStream.computeBoolSize(6, z);
        }
        int i10 = i9;
        if (this.fansStatus_ != FanStatus.Out.getNumber()) {
            i10 = i9 + CodedOutputStream.computeEnumSize(7, this.fansStatus_);
        }
        int serializedSize = i10 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.liangType_) * 37) + 2) * 53) + getLiangId().hashCode()) * 37) + 3) * 53) + getRechargeBadge()) * 37) + 4) * 53) + getFanClubName().hashCode()) * 37) + 5) * 53) + getFanClubLevel()) * 37) + 6) * 53) + Internal.hashBoolean(getInFanClub())) * 37) + 7) * 53) + this.fansStatus_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_Like_fieldAccessorTable.ensureFieldAccessorsInitialized(Like.class, Builder.class);
    }

    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    /* renamed from: newBuilderForType */
    public Builder m3898newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m3897newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Like();
    }

    /* renamed from: toBuilder */
    public Builder m3900toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.liangType_ != LiangType.None.getNumber()) {
            codedOutputStream.writeEnum(1, this.liangType_);
        }
        if (!getLiangIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.liangId_);
        }
        int i = this.rechargeBadge_;
        if (i != 0) {
            codedOutputStream.writeInt32(3, i);
        }
        if (!getFanClubNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.fanClubName_);
        }
        int i2 = this.fanClubLevel_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(5, i2);
        }
        boolean z = this.inFanClub_;
        if (z) {
            codedOutputStream.writeBool(6, z);
        }
        if (this.fansStatus_ != FanStatus.Out.getNumber()) {
            codedOutputStream.writeEnum(7, this.fansStatus_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
