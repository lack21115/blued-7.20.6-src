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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GoodsSetAnimation.class */
public final class GoodsSetAnimation extends GeneratedMessageV3 implements GoodsSetAnimationOrBuilder {
    public static final int IMAGES_MP4_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private volatile Object imagesMp4_;
    private byte memoizedIsInitialized;
    private static final GoodsSetAnimation DEFAULT_INSTANCE = new GoodsSetAnimation();
    private static final Parser<GoodsSetAnimation> PARSER = new AbstractParser<GoodsSetAnimation>() { // from class: cn.irisgw.live.GoodsSetAnimation.1
        /* renamed from: parsePartialFrom */
        public GoodsSetAnimation m2908parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new GoodsSetAnimation(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GoodsSetAnimation$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GoodsSetAnimationOrBuilder {
        private Object imagesMp4_;

        private Builder() {
            this.imagesMp4_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.imagesMp4_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_GoodsSetAnimation_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GoodsSetAnimation.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m2910addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public GoodsSetAnimation m2912build() {
            GoodsSetAnimation m2914buildPartial = m2914buildPartial();
            if (m2914buildPartial.isInitialized()) {
                return m2914buildPartial;
            }
            throw newUninitializedMessageException(m2914buildPartial);
        }

        /* renamed from: buildPartial */
        public GoodsSetAnimation m2914buildPartial() {
            GoodsSetAnimation goodsSetAnimation = new GoodsSetAnimation(this);
            goodsSetAnimation.imagesMp4_ = this.imagesMp4_;
            onBuilt();
            return goodsSetAnimation;
        }

        /* renamed from: clear */
        public Builder m2918clear() {
            super.clear();
            this.imagesMp4_ = "";
            return this;
        }

        /* renamed from: clearField */
        public Builder m2920clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearImagesMp4() {
            this.imagesMp4_ = GoodsSetAnimation.getDefaultInstance().getImagesMp4();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m2923clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m2929clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public GoodsSetAnimation m2931getDefaultInstanceForType() {
            return GoodsSetAnimation.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_GoodsSetAnimation_descriptor;
        }

        @Override // cn.irisgw.live.GoodsSetAnimationOrBuilder
        public String getImagesMp4() {
            Object obj = this.imagesMp4_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.imagesMp4_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsSetAnimationOrBuilder
        public ByteString getImagesMp4Bytes() {
            Object obj = this.imagesMp4_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imagesMp4_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_GoodsSetAnimation_fieldAccessorTable.ensureFieldAccessorsInitialized(GoodsSetAnimation.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(GoodsSetAnimation goodsSetAnimation) {
            if (goodsSetAnimation == GoodsSetAnimation.getDefaultInstance()) {
                return this;
            }
            if (!goodsSetAnimation.getImagesMp4().isEmpty()) {
                this.imagesMp4_ = goodsSetAnimation.imagesMp4_;
                onChanged();
            }
            m2940mergeUnknownFields(goodsSetAnimation.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.GoodsSetAnimation.Builder m2937mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.GoodsSetAnimation.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.GoodsSetAnimation r0 = (cn.irisgw.live.GoodsSetAnimation) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.GoodsSetAnimation$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.GoodsSetAnimation r0 = (cn.irisgw.live.GoodsSetAnimation) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.GoodsSetAnimation$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.GoodsSetAnimation.Builder.m2937mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.GoodsSetAnimation$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m2936mergeFrom(Message message) {
            if (message instanceof GoodsSetAnimation) {
                return mergeFrom((GoodsSetAnimation) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m2940mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m2942setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setImagesMp4(String str) {
            if (str != null) {
                this.imagesMp4_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setImagesMp4Bytes(ByteString byteString) {
            if (byteString != null) {
                GoodsSetAnimation.checkByteStringIsUtf8(byteString);
                this.imagesMp4_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setRepeatedField */
        public Builder m2944setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m2946setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private GoodsSetAnimation() {
        this.memoizedIsInitialized = (byte) -1;
        this.imagesMp4_ = "";
    }

    private GoodsSetAnimation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        if (readTag == 10) {
                            this.imagesMp4_ = codedInputStream.readStringRequireUtf8();
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

    private GoodsSetAnimation(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static GoodsSetAnimation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_GoodsSetAnimation_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m2907toBuilder();
    }

    public static Builder newBuilder(GoodsSetAnimation goodsSetAnimation) {
        return DEFAULT_INSTANCE.m2907toBuilder().mergeFrom(goodsSetAnimation);
    }

    public static GoodsSetAnimation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GoodsSetAnimation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GoodsSetAnimation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (GoodsSetAnimation) PARSER.parseFrom(byteString);
    }

    public static GoodsSetAnimation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GoodsSetAnimation) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GoodsSetAnimation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static GoodsSetAnimation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static GoodsSetAnimation parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static GoodsSetAnimation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GoodsSetAnimation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (GoodsSetAnimation) PARSER.parseFrom(byteBuffer);
    }

    public static GoodsSetAnimation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GoodsSetAnimation) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GoodsSetAnimation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (GoodsSetAnimation) PARSER.parseFrom(bArr);
    }

    public static GoodsSetAnimation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GoodsSetAnimation) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<GoodsSetAnimation> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoodsSetAnimation) {
            GoodsSetAnimation goodsSetAnimation = (GoodsSetAnimation) obj;
            return getImagesMp4().equals(goodsSetAnimation.getImagesMp4()) && this.unknownFields.equals(goodsSetAnimation.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public GoodsSetAnimation m2902getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.GoodsSetAnimationOrBuilder
    public String getImagesMp4() {
        Object obj = this.imagesMp4_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.imagesMp4_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GoodsSetAnimationOrBuilder
    public ByteString getImagesMp4Bytes() {
        Object obj = this.imagesMp4_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.imagesMp4_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<GoodsSetAnimation> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getImagesMp4Bytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.imagesMp4_);
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
        int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getImagesMp4().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_GoodsSetAnimation_fieldAccessorTable.ensureFieldAccessorsInitialized(GoodsSetAnimation.class, Builder.class);
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
    public Builder m2905newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m2904newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new GoodsSetAnimation();
    }

    /* renamed from: toBuilder */
    public Builder m2907toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getImagesMp4Bytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.imagesMp4_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
