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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/IgnoreAudienceVoiceUpExtra.class */
public final class IgnoreAudienceVoiceUpExtra extends GeneratedMessageV3 implements IgnoreAudienceVoiceUpExtraOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 1;
    private static final IgnoreAudienceVoiceUpExtra DEFAULT_INSTANCE = new IgnoreAudienceVoiceUpExtra();
    private static final Parser<IgnoreAudienceVoiceUpExtra> PARSER = new AbstractParser<IgnoreAudienceVoiceUpExtra>() { // from class: cn.irisgw.live.IgnoreAudienceVoiceUpExtra.1
        /* renamed from: parsePartialFrom */
        public IgnoreAudienceVoiceUpExtra m3566parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new IgnoreAudienceVoiceUpExtra(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int UID_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int count_;
    private byte memoizedIsInitialized;
    private int uid_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/IgnoreAudienceVoiceUpExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IgnoreAudienceVoiceUpExtraOrBuilder {
        private int count_;
        private int uid_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_IgnoreAudienceVoiceUpExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = IgnoreAudienceVoiceUpExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m3568addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public IgnoreAudienceVoiceUpExtra m3570build() {
            IgnoreAudienceVoiceUpExtra m3572buildPartial = m3572buildPartial();
            if (m3572buildPartial.isInitialized()) {
                return m3572buildPartial;
            }
            throw newUninitializedMessageException(m3572buildPartial);
        }

        /* renamed from: buildPartial */
        public IgnoreAudienceVoiceUpExtra m3572buildPartial() {
            IgnoreAudienceVoiceUpExtra ignoreAudienceVoiceUpExtra = new IgnoreAudienceVoiceUpExtra(this);
            ignoreAudienceVoiceUpExtra.count_ = this.count_;
            ignoreAudienceVoiceUpExtra.uid_ = this.uid_;
            onBuilt();
            return ignoreAudienceVoiceUpExtra;
        }

        /* renamed from: clear */
        public Builder m3576clear() {
            super.clear();
            this.count_ = 0;
            this.uid_ = 0;
            return this;
        }

        public Builder clearCount() {
            this.count_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m3578clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m3581clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m3587clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.IgnoreAudienceVoiceUpExtraOrBuilder
        public int getCount() {
            return this.count_;
        }

        /* renamed from: getDefaultInstanceForType */
        public IgnoreAudienceVoiceUpExtra m3589getDefaultInstanceForType() {
            return IgnoreAudienceVoiceUpExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_IgnoreAudienceVoiceUpExtra_descriptor;
        }

        @Override // cn.irisgw.live.IgnoreAudienceVoiceUpExtraOrBuilder
        public int getUid() {
            return this.uid_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_IgnoreAudienceVoiceUpExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(IgnoreAudienceVoiceUpExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(IgnoreAudienceVoiceUpExtra ignoreAudienceVoiceUpExtra) {
            if (ignoreAudienceVoiceUpExtra == IgnoreAudienceVoiceUpExtra.getDefaultInstance()) {
                return this;
            }
            if (ignoreAudienceVoiceUpExtra.getCount() != 0) {
                setCount(ignoreAudienceVoiceUpExtra.getCount());
            }
            if (ignoreAudienceVoiceUpExtra.getUid() != 0) {
                setUid(ignoreAudienceVoiceUpExtra.getUid());
            }
            m3598mergeUnknownFields(ignoreAudienceVoiceUpExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.IgnoreAudienceVoiceUpExtra.Builder m3595mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.IgnoreAudienceVoiceUpExtra.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.IgnoreAudienceVoiceUpExtra r0 = (cn.irisgw.live.IgnoreAudienceVoiceUpExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.IgnoreAudienceVoiceUpExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.IgnoreAudienceVoiceUpExtra r0 = (cn.irisgw.live.IgnoreAudienceVoiceUpExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.IgnoreAudienceVoiceUpExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.IgnoreAudienceVoiceUpExtra.Builder.m3595mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.IgnoreAudienceVoiceUpExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m3594mergeFrom(Message message) {
            if (message instanceof IgnoreAudienceVoiceUpExtra) {
                return mergeFrom((IgnoreAudienceVoiceUpExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m3598mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setCount(int i) {
            this.count_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m3600setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m3602setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m3604setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private IgnoreAudienceVoiceUpExtra() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private IgnoreAudienceVoiceUpExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.count_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.uid_ = codedInputStream.readUInt32();
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

    private IgnoreAudienceVoiceUpExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static IgnoreAudienceVoiceUpExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_IgnoreAudienceVoiceUpExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m3565toBuilder();
    }

    public static Builder newBuilder(IgnoreAudienceVoiceUpExtra ignoreAudienceVoiceUpExtra) {
        return DEFAULT_INSTANCE.m3565toBuilder().mergeFrom(ignoreAudienceVoiceUpExtra);
    }

    public static IgnoreAudienceVoiceUpExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static IgnoreAudienceVoiceUpExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static IgnoreAudienceVoiceUpExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (IgnoreAudienceVoiceUpExtra) PARSER.parseFrom(byteString);
    }

    public static IgnoreAudienceVoiceUpExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IgnoreAudienceVoiceUpExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static IgnoreAudienceVoiceUpExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static IgnoreAudienceVoiceUpExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static IgnoreAudienceVoiceUpExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static IgnoreAudienceVoiceUpExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static IgnoreAudienceVoiceUpExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (IgnoreAudienceVoiceUpExtra) PARSER.parseFrom(byteBuffer);
    }

    public static IgnoreAudienceVoiceUpExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IgnoreAudienceVoiceUpExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static IgnoreAudienceVoiceUpExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (IgnoreAudienceVoiceUpExtra) PARSER.parseFrom(bArr);
    }

    public static IgnoreAudienceVoiceUpExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IgnoreAudienceVoiceUpExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<IgnoreAudienceVoiceUpExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IgnoreAudienceVoiceUpExtra) {
            IgnoreAudienceVoiceUpExtra ignoreAudienceVoiceUpExtra = (IgnoreAudienceVoiceUpExtra) obj;
            return getCount() == ignoreAudienceVoiceUpExtra.getCount() && getUid() == ignoreAudienceVoiceUpExtra.getUid() && this.unknownFields.equals(ignoreAudienceVoiceUpExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.IgnoreAudienceVoiceUpExtraOrBuilder
    public int getCount() {
        return this.count_;
    }

    /* renamed from: getDefaultInstanceForType */
    public IgnoreAudienceVoiceUpExtra m3560getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<IgnoreAudienceVoiceUpExtra> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.count_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = this.uid_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int serializedSize = i5 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.IgnoreAudienceVoiceUpExtraOrBuilder
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
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCount()) * 37) + 2) * 53) + getUid()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_IgnoreAudienceVoiceUpExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(IgnoreAudienceVoiceUpExtra.class, Builder.class);
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
    public Builder m3563newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m3562newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new IgnoreAudienceVoiceUpExtra();
    }

    /* renamed from: toBuilder */
    public Builder m3565toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.count_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.uid_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
