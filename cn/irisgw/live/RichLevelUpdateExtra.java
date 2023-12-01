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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/RichLevelUpdateExtra.class */
public final class RichLevelUpdateExtra extends GeneratedMessageV3 implements RichLevelUpdateExtraOrBuilder {
    public static final int GIFT_APNG_FIELD_NUMBER = 1;
    public static final int GIFT_MP4_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile Object giftApng_;
    private volatile Object giftMp4_;
    private byte memoizedIsInitialized;
    private static final RichLevelUpdateExtra DEFAULT_INSTANCE = new RichLevelUpdateExtra();
    private static final Parser<RichLevelUpdateExtra> PARSER = new AbstractParser<RichLevelUpdateExtra>() { // from class: cn.irisgw.live.RichLevelUpdateExtra.1
        /* renamed from: parsePartialFrom */
        public RichLevelUpdateExtra m7218parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RichLevelUpdateExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/RichLevelUpdateExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RichLevelUpdateExtraOrBuilder {
        private Object giftApng_;
        private Object giftMp4_;

        private Builder() {
            this.giftApng_ = "";
            this.giftMp4_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.giftApng_ = "";
            this.giftMp4_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_RichLevelUpdateExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = RichLevelUpdateExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m7220addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public RichLevelUpdateExtra m7222build() {
            RichLevelUpdateExtra m7224buildPartial = m7224buildPartial();
            if (m7224buildPartial.isInitialized()) {
                return m7224buildPartial;
            }
            throw newUninitializedMessageException(m7224buildPartial);
        }

        /* renamed from: buildPartial */
        public RichLevelUpdateExtra m7224buildPartial() {
            RichLevelUpdateExtra richLevelUpdateExtra = new RichLevelUpdateExtra(this);
            richLevelUpdateExtra.giftApng_ = this.giftApng_;
            richLevelUpdateExtra.giftMp4_ = this.giftMp4_;
            onBuilt();
            return richLevelUpdateExtra;
        }

        /* renamed from: clear */
        public Builder m7228clear() {
            super.clear();
            this.giftApng_ = "";
            this.giftMp4_ = "";
            return this;
        }

        /* renamed from: clearField */
        public Builder m7230clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGiftApng() {
            this.giftApng_ = RichLevelUpdateExtra.getDefaultInstance().getGiftApng();
            onChanged();
            return this;
        }

        public Builder clearGiftMp4() {
            this.giftMp4_ = RichLevelUpdateExtra.getDefaultInstance().getGiftMp4();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m7233clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m7239clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public RichLevelUpdateExtra m7241getDefaultInstanceForType() {
            return RichLevelUpdateExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_RichLevelUpdateExtra_descriptor;
        }

        @Override // cn.irisgw.live.RichLevelUpdateExtraOrBuilder
        public String getGiftApng() {
            Object obj = this.giftApng_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftApng_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.RichLevelUpdateExtraOrBuilder
        public ByteString getGiftApngBytes() {
            Object obj = this.giftApng_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftApng_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.RichLevelUpdateExtraOrBuilder
        public String getGiftMp4() {
            Object obj = this.giftMp4_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftMp4_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.RichLevelUpdateExtraOrBuilder
        public ByteString getGiftMp4Bytes() {
            Object obj = this.giftMp4_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftMp4_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_RichLevelUpdateExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(RichLevelUpdateExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(RichLevelUpdateExtra richLevelUpdateExtra) {
            if (richLevelUpdateExtra == RichLevelUpdateExtra.getDefaultInstance()) {
                return this;
            }
            if (!richLevelUpdateExtra.getGiftApng().isEmpty()) {
                this.giftApng_ = richLevelUpdateExtra.giftApng_;
                onChanged();
            }
            if (!richLevelUpdateExtra.getGiftMp4().isEmpty()) {
                this.giftMp4_ = richLevelUpdateExtra.giftMp4_;
                onChanged();
            }
            m7250mergeUnknownFields(richLevelUpdateExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.RichLevelUpdateExtra.Builder m7247mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.RichLevelUpdateExtra.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.RichLevelUpdateExtra r0 = (cn.irisgw.live.RichLevelUpdateExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.RichLevelUpdateExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.RichLevelUpdateExtra r0 = (cn.irisgw.live.RichLevelUpdateExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.RichLevelUpdateExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.RichLevelUpdateExtra.Builder.m7247mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.RichLevelUpdateExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m7246mergeFrom(Message message) {
            if (message instanceof RichLevelUpdateExtra) {
                return mergeFrom((RichLevelUpdateExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m7250mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m7252setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGiftApng(String str) {
            if (str != null) {
                this.giftApng_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftApngBytes(ByteString byteString) {
            if (byteString != null) {
                RichLevelUpdateExtra.checkByteStringIsUtf8(byteString);
                this.giftApng_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftMp4(String str) {
            if (str != null) {
                this.giftMp4_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftMp4Bytes(ByteString byteString) {
            if (byteString != null) {
                RichLevelUpdateExtra.checkByteStringIsUtf8(byteString);
                this.giftMp4_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setRepeatedField */
        public Builder m7254setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m7256setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private RichLevelUpdateExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.giftApng_ = "";
        this.giftMp4_ = "";
    }

    private RichLevelUpdateExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.giftApng_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.giftMp4_ = codedInputStream.readStringRequireUtf8();
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

    private RichLevelUpdateExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static RichLevelUpdateExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_RichLevelUpdateExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m7217toBuilder();
    }

    public static Builder newBuilder(RichLevelUpdateExtra richLevelUpdateExtra) {
        return DEFAULT_INSTANCE.m7217toBuilder().mergeFrom(richLevelUpdateExtra);
    }

    public static RichLevelUpdateExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static RichLevelUpdateExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static RichLevelUpdateExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RichLevelUpdateExtra) PARSER.parseFrom(byteString);
    }

    public static RichLevelUpdateExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RichLevelUpdateExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static RichLevelUpdateExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static RichLevelUpdateExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static RichLevelUpdateExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static RichLevelUpdateExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static RichLevelUpdateExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (RichLevelUpdateExtra) PARSER.parseFrom(byteBuffer);
    }

    public static RichLevelUpdateExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RichLevelUpdateExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static RichLevelUpdateExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RichLevelUpdateExtra) PARSER.parseFrom(bArr);
    }

    public static RichLevelUpdateExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RichLevelUpdateExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<RichLevelUpdateExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RichLevelUpdateExtra) {
            RichLevelUpdateExtra richLevelUpdateExtra = (RichLevelUpdateExtra) obj;
            return getGiftApng().equals(richLevelUpdateExtra.getGiftApng()) && getGiftMp4().equals(richLevelUpdateExtra.getGiftMp4()) && this.unknownFields.equals(richLevelUpdateExtra.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public RichLevelUpdateExtra m7212getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.RichLevelUpdateExtraOrBuilder
    public String getGiftApng() {
        Object obj = this.giftApng_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftApng_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.RichLevelUpdateExtraOrBuilder
    public ByteString getGiftApngBytes() {
        Object obj = this.giftApng_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftApng_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.RichLevelUpdateExtraOrBuilder
    public String getGiftMp4() {
        Object obj = this.giftMp4_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftMp4_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.RichLevelUpdateExtraOrBuilder
    public ByteString getGiftMp4Bytes() {
        Object obj = this.giftMp4_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftMp4_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<RichLevelUpdateExtra> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getGiftApngBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.giftApng_);
        }
        int i3 = i2;
        if (!getGiftMp4Bytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.giftMp4_);
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
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getGiftApng().hashCode()) * 37) + 2) * 53) + getGiftMp4().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_RichLevelUpdateExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(RichLevelUpdateExtra.class, Builder.class);
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
    public Builder m7215newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m7214newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new RichLevelUpdateExtra();
    }

    /* renamed from: toBuilder */
    public Builder m7217toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getGiftApngBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.giftApng_);
        }
        if (!getGiftMp4Bytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.giftMp4_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
