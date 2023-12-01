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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ManagerCancelExtra.class */
public final class ManagerCancelExtra extends GeneratedMessageV3 implements ManagerCancelExtraOrBuilder {
    private static final ManagerCancelExtra DEFAULT_INSTANCE = new ManagerCancelExtra();
    private static final Parser<ManagerCancelExtra> PARSER = new AbstractParser<ManagerCancelExtra>() { // from class: cn.irisgw.live.ManagerCancelExtra.1
        /* renamed from: parsePartialFrom */
        public ManagerCancelExtra m5706parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ManagerCancelExtra(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int TO_UID_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private int toUid_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ManagerCancelExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ManagerCancelExtraOrBuilder {
        private int toUid_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ManagerCancelExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = ManagerCancelExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m5708addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public ManagerCancelExtra m5710build() {
            ManagerCancelExtra m5712buildPartial = m5712buildPartial();
            if (m5712buildPartial.isInitialized()) {
                return m5712buildPartial;
            }
            throw newUninitializedMessageException(m5712buildPartial);
        }

        /* renamed from: buildPartial */
        public ManagerCancelExtra m5712buildPartial() {
            ManagerCancelExtra managerCancelExtra = new ManagerCancelExtra(this);
            managerCancelExtra.toUid_ = this.toUid_;
            onBuilt();
            return managerCancelExtra;
        }

        /* renamed from: clear */
        public Builder m5716clear() {
            super.clear();
            this.toUid_ = 0;
            return this;
        }

        /* renamed from: clearField */
        public Builder m5718clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m5721clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearToUid() {
            this.toUid_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m5727clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public ManagerCancelExtra m5729getDefaultInstanceForType() {
            return ManagerCancelExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ManagerCancelExtra_descriptor;
        }

        @Override // cn.irisgw.live.ManagerCancelExtraOrBuilder
        public int getToUid() {
            return this.toUid_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ManagerCancelExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(ManagerCancelExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ManagerCancelExtra managerCancelExtra) {
            if (managerCancelExtra == ManagerCancelExtra.getDefaultInstance()) {
                return this;
            }
            if (managerCancelExtra.getToUid() != 0) {
                setToUid(managerCancelExtra.getToUid());
            }
            m5738mergeUnknownFields(managerCancelExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ManagerCancelExtra.Builder m5735mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ManagerCancelExtra.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ManagerCancelExtra r0 = (cn.irisgw.live.ManagerCancelExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ManagerCancelExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ManagerCancelExtra r0 = (cn.irisgw.live.ManagerCancelExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ManagerCancelExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ManagerCancelExtra.Builder.m5735mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ManagerCancelExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m5734mergeFrom(Message message) {
            if (message instanceof ManagerCancelExtra) {
                return mergeFrom((ManagerCancelExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m5738mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m5740setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m5742setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setToUid(int i) {
            this.toUid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m5744setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private ManagerCancelExtra() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private ManagerCancelExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.toUid_ = codedInputStream.readUInt32();
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

    private ManagerCancelExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ManagerCancelExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ManagerCancelExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m5705toBuilder();
    }

    public static Builder newBuilder(ManagerCancelExtra managerCancelExtra) {
        return DEFAULT_INSTANCE.m5705toBuilder().mergeFrom(managerCancelExtra);
    }

    public static ManagerCancelExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ManagerCancelExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ManagerCancelExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ManagerCancelExtra) PARSER.parseFrom(byteString);
    }

    public static ManagerCancelExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ManagerCancelExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ManagerCancelExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ManagerCancelExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ManagerCancelExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ManagerCancelExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ManagerCancelExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ManagerCancelExtra) PARSER.parseFrom(byteBuffer);
    }

    public static ManagerCancelExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ManagerCancelExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ManagerCancelExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ManagerCancelExtra) PARSER.parseFrom(bArr);
    }

    public static ManagerCancelExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ManagerCancelExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ManagerCancelExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ManagerCancelExtra) {
            ManagerCancelExtra managerCancelExtra = (ManagerCancelExtra) obj;
            return getToUid() == managerCancelExtra.getToUid() && this.unknownFields.equals(managerCancelExtra.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public ManagerCancelExtra m5700getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<ManagerCancelExtra> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.toUid_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.ManagerCancelExtraOrBuilder
    public int getToUid() {
        return this.toUid_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getToUid()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ManagerCancelExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(ManagerCancelExtra.class, Builder.class);
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
    public Builder m5703newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m5702newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new ManagerCancelExtra();
    }

    /* renamed from: toBuilder */
    public Builder m5705toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.toUid_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
