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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LotteryEventExtra.class */
public final class LotteryEventExtra extends GeneratedMessageV3 implements LotteryEventExtraOrBuilder {
    public static final int ENTRANCE_STATUS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int entranceStatus_;
    private byte memoizedIsInitialized;
    private static final LotteryEventExtra DEFAULT_INSTANCE = new LotteryEventExtra();
    private static final Parser<LotteryEventExtra> PARSER = new AbstractParser<LotteryEventExtra>() { // from class: cn.irisgw.live.LotteryEventExtra.1
        /* renamed from: parsePartialFrom */
        public LotteryEventExtra m5236parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LotteryEventExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LotteryEventExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LotteryEventExtraOrBuilder {
        private int entranceStatus_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LotteryEventExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LotteryEventExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m5238addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LotteryEventExtra m5240build() {
            LotteryEventExtra m5242buildPartial = m5242buildPartial();
            if (m5242buildPartial.isInitialized()) {
                return m5242buildPartial;
            }
            throw newUninitializedMessageException(m5242buildPartial);
        }

        /* renamed from: buildPartial */
        public LotteryEventExtra m5242buildPartial() {
            LotteryEventExtra lotteryEventExtra = new LotteryEventExtra(this);
            lotteryEventExtra.entranceStatus_ = this.entranceStatus_;
            onBuilt();
            return lotteryEventExtra;
        }

        /* renamed from: clear */
        public Builder m5246clear() {
            super.clear();
            this.entranceStatus_ = 0;
            return this;
        }

        public Builder clearEntranceStatus() {
            this.entranceStatus_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m5248clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m5251clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m5257clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public LotteryEventExtra m5259getDefaultInstanceForType() {
            return LotteryEventExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LotteryEventExtra_descriptor;
        }

        @Override // cn.irisgw.live.LotteryEventExtraOrBuilder
        public int getEntranceStatus() {
            return this.entranceStatus_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LotteryEventExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(LotteryEventExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LotteryEventExtra lotteryEventExtra) {
            if (lotteryEventExtra == LotteryEventExtra.getDefaultInstance()) {
                return this;
            }
            if (lotteryEventExtra.getEntranceStatus() != 0) {
                setEntranceStatus(lotteryEventExtra.getEntranceStatus());
            }
            m5268mergeUnknownFields(lotteryEventExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LotteryEventExtra.Builder m5265mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LotteryEventExtra.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LotteryEventExtra r0 = (cn.irisgw.live.LotteryEventExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LotteryEventExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LotteryEventExtra r0 = (cn.irisgw.live.LotteryEventExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LotteryEventExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LotteryEventExtra.Builder.m5265mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LotteryEventExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m5264mergeFrom(Message message) {
            if (message instanceof LotteryEventExtra) {
                return mergeFrom((LotteryEventExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m5268mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setEntranceStatus(int i) {
            this.entranceStatus_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m5270setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m5272setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m5274setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LotteryEventExtra() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private LotteryEventExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw null;
        }
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.entranceStatus_ = codedInputStream.readUInt32();
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (IOException e) {
                    throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private LotteryEventExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LotteryEventExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LotteryEventExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m5235toBuilder();
    }

    public static Builder newBuilder(LotteryEventExtra lotteryEventExtra) {
        return DEFAULT_INSTANCE.m5235toBuilder().mergeFrom(lotteryEventExtra);
    }

    public static LotteryEventExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LotteryEventExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LotteryEventExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LotteryEventExtra) PARSER.parseFrom(byteString);
    }

    public static LotteryEventExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LotteryEventExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LotteryEventExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LotteryEventExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LotteryEventExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LotteryEventExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LotteryEventExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LotteryEventExtra) PARSER.parseFrom(byteBuffer);
    }

    public static LotteryEventExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LotteryEventExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LotteryEventExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LotteryEventExtra) PARSER.parseFrom(bArr);
    }

    public static LotteryEventExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LotteryEventExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LotteryEventExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LotteryEventExtra) {
            LotteryEventExtra lotteryEventExtra = (LotteryEventExtra) obj;
            return getEntranceStatus() == lotteryEventExtra.getEntranceStatus() && this.unknownFields.equals(lotteryEventExtra.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public LotteryEventExtra m5230getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LotteryEventExtraOrBuilder
    public int getEntranceStatus() {
        return this.entranceStatus_;
    }

    public Parser<LotteryEventExtra> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.entranceStatus_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getEntranceStatus()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LotteryEventExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(LotteryEventExtra.class, Builder.class);
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
    public Builder m5233newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m5232newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LotteryEventExtra();
    }

    /* renamed from: toBuilder */
    public Builder m5235toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.entranceStatus_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
