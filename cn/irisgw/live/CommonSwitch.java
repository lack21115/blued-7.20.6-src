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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CommonSwitch.class */
public final class CommonSwitch extends GeneratedMessageV3 implements CommonSwitchOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 3;
    public static final int EXTRA_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int STATUS_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile Object content_;
    private volatile Object extra_;
    private int id_;
    private byte memoizedIsInitialized;
    private int status_;
    private static final CommonSwitch DEFAULT_INSTANCE = new CommonSwitch();
    private static final Parser<CommonSwitch> PARSER = new AbstractParser<CommonSwitch>() { // from class: cn.irisgw.live.CommonSwitch.1
        /* renamed from: parsePartialFrom */
        public CommonSwitch m1722parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new CommonSwitch(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CommonSwitch$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommonSwitchOrBuilder {
        private Object content_;
        private Object extra_;
        private int id_;
        private int status_;

        private Builder() {
            this.content_ = "";
            this.extra_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.content_ = "";
            this.extra_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_CommonSwitch_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = CommonSwitch.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m1724addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public CommonSwitch m1726build() {
            CommonSwitch m1728buildPartial = m1728buildPartial();
            if (m1728buildPartial.isInitialized()) {
                return m1728buildPartial;
            }
            throw newUninitializedMessageException(m1728buildPartial);
        }

        /* renamed from: buildPartial */
        public CommonSwitch m1728buildPartial() {
            CommonSwitch commonSwitch = new CommonSwitch(this);
            commonSwitch.id_ = this.id_;
            commonSwitch.status_ = this.status_;
            commonSwitch.content_ = this.content_;
            commonSwitch.extra_ = this.extra_;
            onBuilt();
            return commonSwitch;
        }

        /* renamed from: clear */
        public Builder m1732clear() {
            super.clear();
            this.id_ = 0;
            this.status_ = 0;
            this.content_ = "";
            this.extra_ = "";
            return this;
        }

        public Builder clearContent() {
            this.content_ = CommonSwitch.getDefaultInstance().getContent();
            onChanged();
            return this;
        }

        public Builder clearExtra() {
            this.extra_ = CommonSwitch.getDefaultInstance().getExtra();
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m1734clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearId() {
            this.id_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m1737clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearStatus() {
            this.status_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m1743clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.CommonSwitchOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.content_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.CommonSwitchOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* renamed from: getDefaultInstanceForType */
        public CommonSwitch m1745getDefaultInstanceForType() {
            return CommonSwitch.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_CommonSwitch_descriptor;
        }

        @Override // cn.irisgw.live.CommonSwitchOrBuilder
        public String getExtra() {
            Object obj = this.extra_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.extra_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.CommonSwitchOrBuilder
        public ByteString getExtraBytes() {
            Object obj = this.extra_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.extra_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.CommonSwitchOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // cn.irisgw.live.CommonSwitchOrBuilder
        public int getStatus() {
            return this.status_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_CommonSwitch_fieldAccessorTable.ensureFieldAccessorsInitialized(CommonSwitch.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(CommonSwitch commonSwitch) {
            if (commonSwitch == CommonSwitch.getDefaultInstance()) {
                return this;
            }
            if (commonSwitch.getId() != 0) {
                setId(commonSwitch.getId());
            }
            if (commonSwitch.getStatus() != 0) {
                setStatus(commonSwitch.getStatus());
            }
            if (!commonSwitch.getContent().isEmpty()) {
                this.content_ = commonSwitch.content_;
                onChanged();
            }
            if (!commonSwitch.getExtra().isEmpty()) {
                this.extra_ = commonSwitch.extra_;
                onChanged();
            }
            m1754mergeUnknownFields(commonSwitch.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.CommonSwitch.Builder m1751mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.CommonSwitch.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.CommonSwitch r0 = (cn.irisgw.live.CommonSwitch) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.CommonSwitch$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.CommonSwitch r0 = (cn.irisgw.live.CommonSwitch) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.CommonSwitch$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.CommonSwitch.Builder.m1751mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.CommonSwitch$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m1750mergeFrom(Message message) {
            if (message instanceof CommonSwitch) {
                return mergeFrom((CommonSwitch) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m1754mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setContent(String str) {
            if (str != null) {
                this.content_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setContentBytes(ByteString byteString) {
            if (byteString != null) {
                CommonSwitch.checkByteStringIsUtf8(byteString);
                this.content_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setExtra(String str) {
            if (str != null) {
                this.extra_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setExtraBytes(ByteString byteString) {
            if (byteString != null) {
                CommonSwitch.checkByteStringIsUtf8(byteString);
                this.extra_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setField */
        public Builder m1756setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setId(int i) {
            this.id_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m1758setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setStatus(int i) {
            this.status_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m1760setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private CommonSwitch() {
        this.memoizedIsInitialized = (byte) -1;
        this.content_ = "";
        this.extra_ = "";
    }

    private CommonSwitch(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.id_ = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.status_ = codedInputStream.readInt32();
                        } else if (readTag == 26) {
                            this.content_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 34) {
                            this.extra_ = codedInputStream.readStringRequireUtf8();
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private CommonSwitch(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static CommonSwitch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_CommonSwitch_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m1721toBuilder();
    }

    public static Builder newBuilder(CommonSwitch commonSwitch) {
        return DEFAULT_INSTANCE.m1721toBuilder().mergeFrom(commonSwitch);
    }

    public static CommonSwitch parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CommonSwitch parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CommonSwitch parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CommonSwitch) PARSER.parseFrom(byteString);
    }

    public static CommonSwitch parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CommonSwitch) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CommonSwitch parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static CommonSwitch parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static CommonSwitch parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static CommonSwitch parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CommonSwitch parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CommonSwitch) PARSER.parseFrom(byteBuffer);
    }

    public static CommonSwitch parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CommonSwitch) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CommonSwitch parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CommonSwitch) PARSER.parseFrom(bArr);
    }

    public static CommonSwitch parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CommonSwitch) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<CommonSwitch> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CommonSwitch) {
            CommonSwitch commonSwitch = (CommonSwitch) obj;
            return getId() == commonSwitch.getId() && getStatus() == commonSwitch.getStatus() && getContent().equals(commonSwitch.getContent()) && getExtra().equals(commonSwitch.getExtra()) && this.unknownFields.equals(commonSwitch.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.CommonSwitchOrBuilder
    public String getContent() {
        Object obj = this.content_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.content_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.CommonSwitchOrBuilder
    public ByteString getContentBytes() {
        Object obj = this.content_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.content_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    /* renamed from: getDefaultInstanceForType */
    public CommonSwitch m1716getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.CommonSwitchOrBuilder
    public String getExtra() {
        Object obj = this.extra_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.extra_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.CommonSwitchOrBuilder
    public ByteString getExtraBytes() {
        Object obj = this.extra_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.extra_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.CommonSwitchOrBuilder
    public int getId() {
        return this.id_;
    }

    public Parser<CommonSwitch> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.id_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeInt32Size(1, i3);
        }
        int i4 = this.status_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeInt32Size(2, i4);
        }
        int i6 = i5;
        if (!getContentBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(3, this.content_);
        }
        int i7 = i6;
        if (!getExtraBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(4, this.extra_);
        }
        int serializedSize = i7 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.CommonSwitchOrBuilder
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
        int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getId()) * 37) + 2) * 53) + getStatus()) * 37) + 3) * 53) + getContent().hashCode()) * 37) + 4) * 53) + getExtra().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_CommonSwitch_fieldAccessorTable.ensureFieldAccessorsInitialized(CommonSwitch.class, Builder.class);
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
    public Builder m1719newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m1718newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new CommonSwitch();
    }

    /* renamed from: toBuilder */
    public Builder m1721toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.id_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        int i2 = this.status_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(2, i2);
        }
        if (!getContentBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.content_);
        }
        if (!getExtraBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.extra_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
