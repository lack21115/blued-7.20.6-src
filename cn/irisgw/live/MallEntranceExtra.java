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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MallEntranceExtra.class */
public final class MallEntranceExtra extends GeneratedMessageV3 implements MallEntranceExtraOrBuilder {
    private static final MallEntranceExtra DEFAULT_INSTANCE = new MallEntranceExtra();
    private static final Parser<MallEntranceExtra> PARSER = new AbstractParser<MallEntranceExtra>() { // from class: cn.irisgw.live.MallEntranceExtra.1
        /* renamed from: parsePartialFrom */
        public MallEntranceExtra m5612parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new MallEntranceExtra(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int STATUS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private int status_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MallEntranceExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MallEntranceExtraOrBuilder {
        private int status_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_MallEntranceExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = MallEntranceExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m5614addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public MallEntranceExtra m5616build() {
            MallEntranceExtra m5618buildPartial = m5618buildPartial();
            if (m5618buildPartial.isInitialized()) {
                return m5618buildPartial;
            }
            throw newUninitializedMessageException(m5618buildPartial);
        }

        /* renamed from: buildPartial */
        public MallEntranceExtra m5618buildPartial() {
            MallEntranceExtra mallEntranceExtra = new MallEntranceExtra(this);
            mallEntranceExtra.status_ = this.status_;
            onBuilt();
            return mallEntranceExtra;
        }

        /* renamed from: clear */
        public Builder m5622clear() {
            super.clear();
            this.status_ = 0;
            return this;
        }

        /* renamed from: clearField */
        public Builder m5624clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m5627clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearStatus() {
            this.status_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m5633clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public MallEntranceExtra m5635getDefaultInstanceForType() {
            return MallEntranceExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_MallEntranceExtra_descriptor;
        }

        @Override // cn.irisgw.live.MallEntranceExtraOrBuilder
        public int getStatus() {
            return this.status_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_MallEntranceExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(MallEntranceExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(MallEntranceExtra mallEntranceExtra) {
            if (mallEntranceExtra == MallEntranceExtra.getDefaultInstance()) {
                return this;
            }
            if (mallEntranceExtra.getStatus() != 0) {
                setStatus(mallEntranceExtra.getStatus());
            }
            m5644mergeUnknownFields(mallEntranceExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.MallEntranceExtra.Builder m5641mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.MallEntranceExtra.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.MallEntranceExtra r0 = (cn.irisgw.live.MallEntranceExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.MallEntranceExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.MallEntranceExtra r0 = (cn.irisgw.live.MallEntranceExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.MallEntranceExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.MallEntranceExtra.Builder.m5641mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.MallEntranceExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m5640mergeFrom(Message message) {
            if (message instanceof MallEntranceExtra) {
                return mergeFrom((MallEntranceExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m5644mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m5646setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m5648setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setStatus(int i) {
            this.status_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m5650setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private MallEntranceExtra() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private MallEntranceExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.status_ = codedInputStream.readUInt32();
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

    private MallEntranceExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MallEntranceExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_MallEntranceExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m5611toBuilder();
    }

    public static Builder newBuilder(MallEntranceExtra mallEntranceExtra) {
        return DEFAULT_INSTANCE.m5611toBuilder().mergeFrom(mallEntranceExtra);
    }

    public static MallEntranceExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static MallEntranceExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MallEntranceExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MallEntranceExtra) PARSER.parseFrom(byteString);
    }

    public static MallEntranceExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MallEntranceExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static MallEntranceExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static MallEntranceExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static MallEntranceExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static MallEntranceExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MallEntranceExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MallEntranceExtra) PARSER.parseFrom(byteBuffer);
    }

    public static MallEntranceExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MallEntranceExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static MallEntranceExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MallEntranceExtra) PARSER.parseFrom(bArr);
    }

    public static MallEntranceExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MallEntranceExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<MallEntranceExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MallEntranceExtra) {
            MallEntranceExtra mallEntranceExtra = (MallEntranceExtra) obj;
            return getStatus() == mallEntranceExtra.getStatus() && this.unknownFields.equals(mallEntranceExtra.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public MallEntranceExtra m5606getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<MallEntranceExtra> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.status_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.MallEntranceExtraOrBuilder
    public int getStatus() {
        return this.status_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getStatus()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_MallEntranceExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(MallEntranceExtra.class, Builder.class);
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
    public Builder m5609newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m5608newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new MallEntranceExtra();
    }

    /* renamed from: toBuilder */
    public Builder m5611toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.status_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
