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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LoveOpenStatus.class */
public final class LoveOpenStatus extends GeneratedMessageV3 implements LoveOpenStatusOrBuilder {
    public static final int FAN_FIELD_NUMBER = 2;
    public static final int UID_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int fan_;
    private byte memoizedIsInitialized;
    private int uid_;
    private static final LoveOpenStatus DEFAULT_INSTANCE = new LoveOpenStatus();
    private static final Parser<LoveOpenStatus> PARSER = new AbstractParser<LoveOpenStatus>() { // from class: cn.irisgw.live.LoveOpenStatus.1
        /* renamed from: parsePartialFrom */
        public LoveOpenStatus m5471parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LoveOpenStatus(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LoveOpenStatus$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LoveOpenStatusOrBuilder {
        private int fan_;
        private int uid_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveOpenStatus_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LoveOpenStatus.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m5473addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LoveOpenStatus m5475build() {
            LoveOpenStatus m5477buildPartial = m5477buildPartial();
            if (m5477buildPartial.isInitialized()) {
                return m5477buildPartial;
            }
            throw newUninitializedMessageException(m5477buildPartial);
        }

        /* renamed from: buildPartial */
        public LoveOpenStatus m5477buildPartial() {
            LoveOpenStatus loveOpenStatus = new LoveOpenStatus(this);
            loveOpenStatus.uid_ = this.uid_;
            loveOpenStatus.fan_ = this.fan_;
            onBuilt();
            return loveOpenStatus;
        }

        /* renamed from: clear */
        public Builder m5481clear() {
            super.clear();
            this.uid_ = 0;
            this.fan_ = 0;
            return this;
        }

        public Builder clearFan() {
            this.fan_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m5483clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m5486clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m5492clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public LoveOpenStatus m5494getDefaultInstanceForType() {
            return LoveOpenStatus.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveOpenStatus_descriptor;
        }

        @Override // cn.irisgw.live.LoveOpenStatusOrBuilder
        public int getFan() {
            return this.fan_;
        }

        @Override // cn.irisgw.live.LoveOpenStatusOrBuilder
        public int getUid() {
            return this.uid_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveOpenStatus_fieldAccessorTable.ensureFieldAccessorsInitialized(LoveOpenStatus.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LoveOpenStatus loveOpenStatus) {
            if (loveOpenStatus == LoveOpenStatus.getDefaultInstance()) {
                return this;
            }
            if (loveOpenStatus.getUid() != 0) {
                setUid(loveOpenStatus.getUid());
            }
            if (loveOpenStatus.getFan() != 0) {
                setFan(loveOpenStatus.getFan());
            }
            m5503mergeUnknownFields(loveOpenStatus.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LoveOpenStatus.Builder m5500mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LoveOpenStatus.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LoveOpenStatus r0 = (cn.irisgw.live.LoveOpenStatus) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LoveOpenStatus$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LoveOpenStatus r0 = (cn.irisgw.live.LoveOpenStatus) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LoveOpenStatus$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LoveOpenStatus.Builder.m5500mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LoveOpenStatus$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m5499mergeFrom(Message message) {
            if (message instanceof LoveOpenStatus) {
                return mergeFrom((LoveOpenStatus) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m5503mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setFan(int i) {
            this.fan_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m5505setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m5507setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m5509setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LoveOpenStatus() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private LoveOpenStatus(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.uid_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.fan_ = codedInputStream.readUInt32();
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

    private LoveOpenStatus(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LoveOpenStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LoveOpenStatus_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m5470toBuilder();
    }

    public static Builder newBuilder(LoveOpenStatus loveOpenStatus) {
        return DEFAULT_INSTANCE.m5470toBuilder().mergeFrom(loveOpenStatus);
    }

    public static LoveOpenStatus parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LoveOpenStatus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LoveOpenStatus parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LoveOpenStatus) PARSER.parseFrom(byteString);
    }

    public static LoveOpenStatus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoveOpenStatus) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LoveOpenStatus parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LoveOpenStatus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LoveOpenStatus parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LoveOpenStatus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LoveOpenStatus parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LoveOpenStatus) PARSER.parseFrom(byteBuffer);
    }

    public static LoveOpenStatus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoveOpenStatus) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LoveOpenStatus parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LoveOpenStatus) PARSER.parseFrom(bArr);
    }

    public static LoveOpenStatus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoveOpenStatus) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LoveOpenStatus> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoveOpenStatus) {
            LoveOpenStatus loveOpenStatus = (LoveOpenStatus) obj;
            return getUid() == loveOpenStatus.getUid() && getFan() == loveOpenStatus.getFan() && this.unknownFields.equals(loveOpenStatus.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public LoveOpenStatus m5465getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LoveOpenStatusOrBuilder
    public int getFan() {
        return this.fan_;
    }

    public Parser<LoveOpenStatus> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.uid_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = this.fan_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int serializedSize = i5 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.LoveOpenStatusOrBuilder
    public int getUid() {
        return this.uid_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getFan()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LoveOpenStatus_fieldAccessorTable.ensureFieldAccessorsInitialized(LoveOpenStatus.class, Builder.class);
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
    public Builder m5468newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m5467newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LoveOpenStatus();
    }

    /* renamed from: toBuilder */
    public Builder m5470toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.uid_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.fan_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
