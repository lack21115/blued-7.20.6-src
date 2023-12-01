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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/IgnoreAnchorVoiceUpInviteExtra.class */
public final class IgnoreAnchorVoiceUpInviteExtra extends GeneratedMessageV3 implements IgnoreAnchorVoiceUpInviteExtraOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int count_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private static final IgnoreAnchorVoiceUpInviteExtra DEFAULT_INSTANCE = new IgnoreAnchorVoiceUpInviteExtra();
    private static final Parser<IgnoreAnchorVoiceUpInviteExtra> PARSER = new AbstractParser<IgnoreAnchorVoiceUpInviteExtra>() { // from class: cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtra.1
        /* renamed from: parsePartialFrom */
        public IgnoreAnchorVoiceUpInviteExtra m3519parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new IgnoreAnchorVoiceUpInviteExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/IgnoreAnchorVoiceUpInviteExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IgnoreAnchorVoiceUpInviteExtraOrBuilder {
        private int count_;
        private Object name_;

        private Builder() {
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_IgnoreAnchorVoiceUpInviteExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = IgnoreAnchorVoiceUpInviteExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m3521addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public IgnoreAnchorVoiceUpInviteExtra m3523build() {
            IgnoreAnchorVoiceUpInviteExtra m3525buildPartial = m3525buildPartial();
            if (m3525buildPartial.isInitialized()) {
                return m3525buildPartial;
            }
            throw newUninitializedMessageException(m3525buildPartial);
        }

        /* renamed from: buildPartial */
        public IgnoreAnchorVoiceUpInviteExtra m3525buildPartial() {
            IgnoreAnchorVoiceUpInviteExtra ignoreAnchorVoiceUpInviteExtra = new IgnoreAnchorVoiceUpInviteExtra(this);
            ignoreAnchorVoiceUpInviteExtra.name_ = this.name_;
            ignoreAnchorVoiceUpInviteExtra.count_ = this.count_;
            onBuilt();
            return ignoreAnchorVoiceUpInviteExtra;
        }

        /* renamed from: clear */
        public Builder m3529clear() {
            super.clear();
            this.name_ = "";
            this.count_ = 0;
            return this;
        }

        public Builder clearCount() {
            this.count_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m3531clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearName() {
            this.name_ = IgnoreAnchorVoiceUpInviteExtra.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m3534clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m3540clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtraOrBuilder
        public int getCount() {
            return this.count_;
        }

        /* renamed from: getDefaultInstanceForType */
        public IgnoreAnchorVoiceUpInviteExtra m3542getDefaultInstanceForType() {
            return IgnoreAnchorVoiceUpInviteExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_IgnoreAnchorVoiceUpInviteExtra_descriptor;
        }

        @Override // cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtraOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtraOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_IgnoreAnchorVoiceUpInviteExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(IgnoreAnchorVoiceUpInviteExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(IgnoreAnchorVoiceUpInviteExtra ignoreAnchorVoiceUpInviteExtra) {
            if (ignoreAnchorVoiceUpInviteExtra == IgnoreAnchorVoiceUpInviteExtra.getDefaultInstance()) {
                return this;
            }
            if (!ignoreAnchorVoiceUpInviteExtra.getName().isEmpty()) {
                this.name_ = ignoreAnchorVoiceUpInviteExtra.name_;
                onChanged();
            }
            if (ignoreAnchorVoiceUpInviteExtra.getCount() != 0) {
                setCount(ignoreAnchorVoiceUpInviteExtra.getCount());
            }
            m3551mergeUnknownFields(ignoreAnchorVoiceUpInviteExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtra.Builder m3548mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtra.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtra r0 = (cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtra r0 = (cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtra.Builder.m3548mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m3547mergeFrom(Message message) {
            if (message instanceof IgnoreAnchorVoiceUpInviteExtra) {
                return mergeFrom((IgnoreAnchorVoiceUpInviteExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m3551mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setCount(int i) {
            this.count_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m3553setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setName(String str) {
            if (str != null) {
                this.name_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNameBytes(ByteString byteString) {
            if (byteString != null) {
                IgnoreAnchorVoiceUpInviteExtra.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setRepeatedField */
        public Builder m3555setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m3557setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private IgnoreAnchorVoiceUpInviteExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
    }

    private IgnoreAnchorVoiceUpInviteExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 10) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.count_ = codedInputStream.readUInt32();
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

    private IgnoreAnchorVoiceUpInviteExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static IgnoreAnchorVoiceUpInviteExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_IgnoreAnchorVoiceUpInviteExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m3518toBuilder();
    }

    public static Builder newBuilder(IgnoreAnchorVoiceUpInviteExtra ignoreAnchorVoiceUpInviteExtra) {
        return DEFAULT_INSTANCE.m3518toBuilder().mergeFrom(ignoreAnchorVoiceUpInviteExtra);
    }

    public static IgnoreAnchorVoiceUpInviteExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static IgnoreAnchorVoiceUpInviteExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static IgnoreAnchorVoiceUpInviteExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (IgnoreAnchorVoiceUpInviteExtra) PARSER.parseFrom(byteString);
    }

    public static IgnoreAnchorVoiceUpInviteExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IgnoreAnchorVoiceUpInviteExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static IgnoreAnchorVoiceUpInviteExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static IgnoreAnchorVoiceUpInviteExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static IgnoreAnchorVoiceUpInviteExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static IgnoreAnchorVoiceUpInviteExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static IgnoreAnchorVoiceUpInviteExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (IgnoreAnchorVoiceUpInviteExtra) PARSER.parseFrom(byteBuffer);
    }

    public static IgnoreAnchorVoiceUpInviteExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IgnoreAnchorVoiceUpInviteExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static IgnoreAnchorVoiceUpInviteExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (IgnoreAnchorVoiceUpInviteExtra) PARSER.parseFrom(bArr);
    }

    public static IgnoreAnchorVoiceUpInviteExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IgnoreAnchorVoiceUpInviteExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<IgnoreAnchorVoiceUpInviteExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IgnoreAnchorVoiceUpInviteExtra) {
            IgnoreAnchorVoiceUpInviteExtra ignoreAnchorVoiceUpInviteExtra = (IgnoreAnchorVoiceUpInviteExtra) obj;
            return getName().equals(ignoreAnchorVoiceUpInviteExtra.getName()) && getCount() == ignoreAnchorVoiceUpInviteExtra.getCount() && this.unknownFields.equals(ignoreAnchorVoiceUpInviteExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtraOrBuilder
    public int getCount() {
        return this.count_;
    }

    /* renamed from: getDefaultInstanceForType */
    public IgnoreAnchorVoiceUpInviteExtra m3513getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtraOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.IgnoreAnchorVoiceUpInviteExtraOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<IgnoreAnchorVoiceUpInviteExtra> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getNameBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
        }
        int i3 = this.count_;
        int i4 = i2;
        if (i3 != 0) {
            i4 = i2 + CodedOutputStream.computeUInt32Size(2, i3);
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
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getCount()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_IgnoreAnchorVoiceUpInviteExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(IgnoreAnchorVoiceUpInviteExtra.class, Builder.class);
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
    public Builder m3516newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m3515newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new IgnoreAnchorVoiceUpInviteExtra();
    }

    /* renamed from: toBuilder */
    public Builder m3518toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        int i = this.count_;
        if (i != 0) {
            codedOutputStream.writeUInt32(2, i);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
