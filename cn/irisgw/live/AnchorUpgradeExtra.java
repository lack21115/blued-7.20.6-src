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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/AnchorUpgradeExtra.class */
public final class AnchorUpgradeExtra extends GeneratedMessageV3 implements AnchorUpgradeExtraOrBuilder {
    public static final int LEVEL_FIELD_NUMBER = 1;
    public static final int RESOURCE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int level_;
    private byte memoizedIsInitialized;
    private volatile Object resource_;
    private static final AnchorUpgradeExtra DEFAULT_INSTANCE = new AnchorUpgradeExtra();
    private static final Parser<AnchorUpgradeExtra> PARSER = new AbstractParser<AnchorUpgradeExtra>() { // from class: cn.irisgw.live.AnchorUpgradeExtra.1
        /* renamed from: parsePartialFrom */
        public AnchorUpgradeExtra m339parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new AnchorUpgradeExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/AnchorUpgradeExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AnchorUpgradeExtraOrBuilder {
        private int level_;
        private Object resource_;

        private Builder() {
            this.resource_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.resource_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_AnchorUpgradeExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = AnchorUpgradeExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m341addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public AnchorUpgradeExtra m343build() {
            AnchorUpgradeExtra m345buildPartial = m345buildPartial();
            if (m345buildPartial.isInitialized()) {
                return m345buildPartial;
            }
            throw newUninitializedMessageException(m345buildPartial);
        }

        /* renamed from: buildPartial */
        public AnchorUpgradeExtra m345buildPartial() {
            AnchorUpgradeExtra anchorUpgradeExtra = new AnchorUpgradeExtra(this);
            anchorUpgradeExtra.level_ = this.level_;
            anchorUpgradeExtra.resource_ = this.resource_;
            onBuilt();
            return anchorUpgradeExtra;
        }

        /* renamed from: clear */
        public Builder m349clear() {
            super.clear();
            this.level_ = 0;
            this.resource_ = "";
            return this;
        }

        /* renamed from: clearField */
        public Builder m351clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearLevel() {
            this.level_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m354clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearResource() {
            this.resource_ = AnchorUpgradeExtra.getDefaultInstance().getResource();
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m360clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public AnchorUpgradeExtra m362getDefaultInstanceForType() {
            return AnchorUpgradeExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_AnchorUpgradeExtra_descriptor;
        }

        @Override // cn.irisgw.live.AnchorUpgradeExtraOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // cn.irisgw.live.AnchorUpgradeExtraOrBuilder
        public String getResource() {
            Object obj = this.resource_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.resource_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.AnchorUpgradeExtraOrBuilder
        public ByteString getResourceBytes() {
            Object obj = this.resource_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.resource_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_AnchorUpgradeExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(AnchorUpgradeExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(AnchorUpgradeExtra anchorUpgradeExtra) {
            if (anchorUpgradeExtra == AnchorUpgradeExtra.getDefaultInstance()) {
                return this;
            }
            if (anchorUpgradeExtra.getLevel() != 0) {
                setLevel(anchorUpgradeExtra.getLevel());
            }
            if (!anchorUpgradeExtra.getResource().isEmpty()) {
                this.resource_ = anchorUpgradeExtra.resource_;
                onChanged();
            }
            m371mergeUnknownFields(anchorUpgradeExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.AnchorUpgradeExtra.Builder m368mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.AnchorUpgradeExtra.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.AnchorUpgradeExtra r0 = (cn.irisgw.live.AnchorUpgradeExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.AnchorUpgradeExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.AnchorUpgradeExtra r0 = (cn.irisgw.live.AnchorUpgradeExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.AnchorUpgradeExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.AnchorUpgradeExtra.Builder.m368mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.AnchorUpgradeExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m367mergeFrom(Message message) {
            if (message instanceof AnchorUpgradeExtra) {
                return mergeFrom((AnchorUpgradeExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m371mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m373setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setLevel(int i) {
            this.level_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m375setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setResource(String str) {
            if (str != null) {
                this.resource_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setResourceBytes(ByteString byteString) {
            if (byteString != null) {
                AnchorUpgradeExtra.checkByteStringIsUtf8(byteString);
                this.resource_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setUnknownFields */
        public final Builder m377setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private AnchorUpgradeExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.resource_ = "";
    }

    private AnchorUpgradeExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.level_ = codedInputStream.readUInt32();
                            } else if (readTag == 18) {
                                this.resource_ = codedInputStream.readStringRequireUtf8();
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

    private AnchorUpgradeExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static AnchorUpgradeExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_AnchorUpgradeExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m338toBuilder();
    }

    public static Builder newBuilder(AnchorUpgradeExtra anchorUpgradeExtra) {
        return DEFAULT_INSTANCE.m338toBuilder().mergeFrom(anchorUpgradeExtra);
    }

    public static AnchorUpgradeExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AnchorUpgradeExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AnchorUpgradeExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AnchorUpgradeExtra) PARSER.parseFrom(byteString);
    }

    public static AnchorUpgradeExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AnchorUpgradeExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static AnchorUpgradeExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static AnchorUpgradeExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static AnchorUpgradeExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static AnchorUpgradeExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AnchorUpgradeExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AnchorUpgradeExtra) PARSER.parseFrom(byteBuffer);
    }

    public static AnchorUpgradeExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AnchorUpgradeExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static AnchorUpgradeExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AnchorUpgradeExtra) PARSER.parseFrom(bArr);
    }

    public static AnchorUpgradeExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AnchorUpgradeExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<AnchorUpgradeExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AnchorUpgradeExtra) {
            AnchorUpgradeExtra anchorUpgradeExtra = (AnchorUpgradeExtra) obj;
            return getLevel() == anchorUpgradeExtra.getLevel() && getResource().equals(anchorUpgradeExtra.getResource()) && this.unknownFields.equals(anchorUpgradeExtra.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public AnchorUpgradeExtra m333getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.AnchorUpgradeExtraOrBuilder
    public int getLevel() {
        return this.level_;
    }

    public Parser<AnchorUpgradeExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.AnchorUpgradeExtraOrBuilder
    public String getResource() {
        Object obj = this.resource_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.resource_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.AnchorUpgradeExtraOrBuilder
    public ByteString getResourceBytes() {
        Object obj = this.resource_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.resource_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.level_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = i2;
        if (!getResourceBytes().isEmpty()) {
            i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.resource_);
        }
        int serializedSize = i4 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getLevel()) * 37) + 2) * 53) + getResource().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_AnchorUpgradeExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(AnchorUpgradeExtra.class, Builder.class);
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
    public Builder m336newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m335newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new AnchorUpgradeExtra();
    }

    /* renamed from: toBuilder */
    public Builder m338toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.level_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        if (!getResourceBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.resource_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
