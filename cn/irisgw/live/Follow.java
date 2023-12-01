package cn.irisgw.live;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/Follow.class */
public final class Follow extends GeneratedMessageV3 implements FollowOrBuilder {
    public static final int LIANG_ID_FIELD_NUMBER = 2;
    public static final int LIANG_TYPE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private volatile Object liangId_;
    private int liangType_;
    private byte memoizedIsInitialized;
    private static final Follow DEFAULT_INSTANCE = new Follow();
    private static final Parser<Follow> PARSER = new AbstractParser<Follow>() { // from class: cn.irisgw.live.Follow.1
        /* renamed from: parsePartialFrom */
        public Follow m2479parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Follow(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/Follow$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FollowOrBuilder {
        private Object liangId_;
        private int liangType_;

        private Builder() {
            this.liangType_ = 0;
            this.liangId_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.liangType_ = 0;
            this.liangId_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_Follow_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = Follow.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m2481addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public Follow m2483build() {
            Follow m2485buildPartial = m2485buildPartial();
            if (m2485buildPartial.isInitialized()) {
                return m2485buildPartial;
            }
            throw newUninitializedMessageException(m2485buildPartial);
        }

        /* renamed from: buildPartial */
        public Follow m2485buildPartial() {
            Follow follow = new Follow(this);
            follow.liangType_ = this.liangType_;
            follow.liangId_ = this.liangId_;
            onBuilt();
            return follow;
        }

        /* renamed from: clear */
        public Builder m2489clear() {
            super.clear();
            this.liangType_ = 0;
            this.liangId_ = "";
            return this;
        }

        /* renamed from: clearField */
        public Builder m2491clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearLiangId() {
            this.liangId_ = Follow.getDefaultInstance().getLiangId();
            onChanged();
            return this;
        }

        public Builder clearLiangType() {
            this.liangType_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m2494clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m2500clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public Follow m2502getDefaultInstanceForType() {
            return Follow.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_Follow_descriptor;
        }

        @Override // cn.irisgw.live.FollowOrBuilder
        public String getLiangId() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liangId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.FollowOrBuilder
        public ByteString getLiangIdBytes() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liangId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.FollowOrBuilder
        public LiangType getLiangType() {
            LiangType valueOf = LiangType.valueOf(this.liangType_);
            LiangType liangType = valueOf;
            if (valueOf == null) {
                liangType = LiangType.UNRECOGNIZED;
            }
            return liangType;
        }

        @Override // cn.irisgw.live.FollowOrBuilder
        public int getLiangTypeValue() {
            return this.liangType_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_Follow_fieldAccessorTable.ensureFieldAccessorsInitialized(Follow.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(Follow follow) {
            if (follow == Follow.getDefaultInstance()) {
                return this;
            }
            if (follow.liangType_ != 0) {
                setLiangTypeValue(follow.getLiangTypeValue());
            }
            if (!follow.getLiangId().isEmpty()) {
                this.liangId_ = follow.liangId_;
                onChanged();
            }
            m2511mergeUnknownFields(follow.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.Follow.Builder m2508mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.Follow.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.Follow r0 = (cn.irisgw.live.Follow) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.Follow$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.Follow r0 = (cn.irisgw.live.Follow) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.Follow$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.Follow.Builder.m2508mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.Follow$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m2507mergeFrom(Message message) {
            if (message instanceof Follow) {
                return mergeFrom((Follow) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m2511mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m2513setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
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
                Follow.checkByteStringIsUtf8(byteString);
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

        /* renamed from: setRepeatedField */
        public Builder m2515setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m2517setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private Follow() {
        this.memoizedIsInitialized = (byte) -1;
        this.liangType_ = 0;
        this.liangId_ = "";
    }

    private Follow(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (IOException e) {
                        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private Follow(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Follow getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_Follow_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m2478toBuilder();
    }

    public static Builder newBuilder(Follow follow) {
        return DEFAULT_INSTANCE.m2478toBuilder().mergeFrom(follow);
    }

    public static Follow parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Follow parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Follow parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Follow) PARSER.parseFrom(byteString);
    }

    public static Follow parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Follow) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Follow parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Follow parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Follow parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Follow parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Follow parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Follow) PARSER.parseFrom(byteBuffer);
    }

    public static Follow parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Follow) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Follow parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Follow) PARSER.parseFrom(bArr);
    }

    public static Follow parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Follow) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<Follow> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Follow) {
            Follow follow = (Follow) obj;
            return this.liangType_ == follow.liangType_ && getLiangId().equals(follow.getLiangId()) && this.unknownFields.equals(follow.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public Follow m2473getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.FollowOrBuilder
    public String getLiangId() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.liangId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.FollowOrBuilder
    public ByteString getLiangIdBytes() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.liangId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.FollowOrBuilder
    public LiangType getLiangType() {
        LiangType valueOf = LiangType.valueOf(this.liangType_);
        LiangType liangType = valueOf;
        if (valueOf == null) {
            liangType = LiangType.UNRECOGNIZED;
        }
        return liangType;
    }

    @Override // cn.irisgw.live.FollowOrBuilder
    public int getLiangTypeValue() {
        return this.liangType_;
    }

    public Parser<Follow> getParserForType() {
        return PARSER;
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
        int serializedSize = i3 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.liangType_) * 37) + 2) * 53) + getLiangId().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_Follow_fieldAccessorTable.ensureFieldAccessorsInitialized(Follow.class, Builder.class);
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
    public Builder m2476newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m2475newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Follow();
    }

    /* renamed from: toBuilder */
    public Builder m2478toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.liangType_ != LiangType.None.getNumber()) {
            codedOutputStream.writeEnum(1, this.liangType_);
        }
        if (!getLiangIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.liangId_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
