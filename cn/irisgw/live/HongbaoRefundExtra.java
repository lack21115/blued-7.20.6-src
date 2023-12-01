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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HongbaoRefundExtra.class */
public final class HongbaoRefundExtra extends GeneratedMessageV3 implements HongbaoRefundExtraOrBuilder {
    private static final HongbaoRefundExtra DEFAULT_INSTANCE = new HongbaoRefundExtra();
    private static final Parser<HongbaoRefundExtra> PARSER = new AbstractParser<HongbaoRefundExtra>() { // from class: cn.irisgw.live.HongbaoRefundExtra.1
        /* renamed from: parsePartialFrom */
        public HongbaoRefundExtra m3331parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new HongbaoRefundExtra(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int REFUND_BEANS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private long refundBeans_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HongbaoRefundExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HongbaoRefundExtraOrBuilder {
        private long refundBeans_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_HongbaoRefundExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = HongbaoRefundExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m3333addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public HongbaoRefundExtra m3335build() {
            HongbaoRefundExtra m3337buildPartial = m3337buildPartial();
            if (m3337buildPartial.isInitialized()) {
                return m3337buildPartial;
            }
            throw newUninitializedMessageException(m3337buildPartial);
        }

        /* renamed from: buildPartial */
        public HongbaoRefundExtra m3337buildPartial() {
            HongbaoRefundExtra hongbaoRefundExtra = new HongbaoRefundExtra(this);
            hongbaoRefundExtra.refundBeans_ = this.refundBeans_;
            onBuilt();
            return hongbaoRefundExtra;
        }

        /* renamed from: clear */
        public Builder m3341clear() {
            super.clear();
            this.refundBeans_ = HongbaoRefundExtra.serialVersionUID;
            return this;
        }

        /* renamed from: clearField */
        public Builder m3343clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m3346clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRefundBeans() {
            this.refundBeans_ = HongbaoRefundExtra.serialVersionUID;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m3352clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public HongbaoRefundExtra m3354getDefaultInstanceForType() {
            return HongbaoRefundExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_HongbaoRefundExtra_descriptor;
        }

        @Override // cn.irisgw.live.HongbaoRefundExtraOrBuilder
        public long getRefundBeans() {
            return this.refundBeans_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_HongbaoRefundExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(HongbaoRefundExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(HongbaoRefundExtra hongbaoRefundExtra) {
            if (hongbaoRefundExtra == HongbaoRefundExtra.getDefaultInstance()) {
                return this;
            }
            if (hongbaoRefundExtra.getRefundBeans() != HongbaoRefundExtra.serialVersionUID) {
                setRefundBeans(hongbaoRefundExtra.getRefundBeans());
            }
            m3363mergeUnknownFields(hongbaoRefundExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.HongbaoRefundExtra.Builder m3360mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.HongbaoRefundExtra.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.HongbaoRefundExtra r0 = (cn.irisgw.live.HongbaoRefundExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.HongbaoRefundExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.HongbaoRefundExtra r0 = (cn.irisgw.live.HongbaoRefundExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.HongbaoRefundExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.HongbaoRefundExtra.Builder.m3360mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.HongbaoRefundExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m3359mergeFrom(Message message) {
            if (message instanceof HongbaoRefundExtra) {
                return mergeFrom((HongbaoRefundExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m3363mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m3365setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setRefundBeans(long j) {
            this.refundBeans_ = j;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m3367setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m3369setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private HongbaoRefundExtra() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private HongbaoRefundExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.refundBeans_ = codedInputStream.readUInt64();
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

    private HongbaoRefundExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static HongbaoRefundExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_HongbaoRefundExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m3330toBuilder();
    }

    public static Builder newBuilder(HongbaoRefundExtra hongbaoRefundExtra) {
        return DEFAULT_INSTANCE.m3330toBuilder().mergeFrom(hongbaoRefundExtra);
    }

    public static HongbaoRefundExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static HongbaoRefundExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HongbaoRefundExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HongbaoRefundExtra) PARSER.parseFrom(byteString);
    }

    public static HongbaoRefundExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HongbaoRefundExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static HongbaoRefundExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static HongbaoRefundExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static HongbaoRefundExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static HongbaoRefundExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HongbaoRefundExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HongbaoRefundExtra) PARSER.parseFrom(byteBuffer);
    }

    public static HongbaoRefundExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HongbaoRefundExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static HongbaoRefundExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HongbaoRefundExtra) PARSER.parseFrom(bArr);
    }

    public static HongbaoRefundExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HongbaoRefundExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<HongbaoRefundExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HongbaoRefundExtra) {
            HongbaoRefundExtra hongbaoRefundExtra = (HongbaoRefundExtra) obj;
            return getRefundBeans() == hongbaoRefundExtra.getRefundBeans() && this.unknownFields.equals(hongbaoRefundExtra.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public HongbaoRefundExtra m3325getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<HongbaoRefundExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.HongbaoRefundExtraOrBuilder
    public long getRefundBeans() {
        return this.refundBeans_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        long j = this.refundBeans_;
        if (j != serialVersionUID) {
            i2 = 0 + CodedOutputStream.computeUInt64Size(1, j);
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
        int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getRefundBeans())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_HongbaoRefundExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(HongbaoRefundExtra.class, Builder.class);
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
    public Builder m3328newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m3327newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new HongbaoRefundExtra();
    }

    /* renamed from: toBuilder */
    public Builder m3330toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.refundBeans_;
        if (j != serialVersionUID) {
            codedOutputStream.writeUInt64(1, j);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
