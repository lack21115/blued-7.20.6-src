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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/Animation.class */
public final class Animation extends GeneratedMessageV3 implements AnimationOrBuilder {
    public static final int IMAGES_APNG2_FIELD_NUMBER = 1;
    public static final int IMAGES_GIF_FIELD_NUMBER = 2;
    public static final int IMAGES_MP4_FIELD_NUMBER = 3;
    public static final int PRIORITY_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private volatile Object imagesApng2_;
    private volatile Object imagesGif_;
    private volatile Object imagesMp4_;
    private byte memoizedIsInitialized;
    private boolean priority_;
    private static final Animation DEFAULT_INSTANCE = new Animation();
    private static final Parser<Animation> PARSER = new AbstractParser<Animation>() { // from class: cn.irisgw.live.Animation.1
        @Override // com.google.protobuf.Parser
        public Animation parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Animation(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/Animation$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AnimationOrBuilder {
        private Object imagesApng2_;
        private Object imagesGif_;
        private Object imagesMp4_;
        private boolean priority_;

        private Builder() {
            this.imagesApng2_ = "";
            this.imagesGif_ = "";
            this.imagesMp4_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.imagesApng2_ = "";
            this.imagesGif_ = "";
            this.imagesMp4_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_Animation_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = Animation.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Animation build() {
            Animation buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Animation buildPartial() {
            Animation animation = new Animation(this);
            animation.imagesApng2_ = this.imagesApng2_;
            animation.imagesGif_ = this.imagesGif_;
            animation.imagesMp4_ = this.imagesMp4_;
            animation.priority_ = this.priority_;
            onBuilt();
            return animation;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.imagesApng2_ = "";
            this.imagesGif_ = "";
            this.imagesMp4_ = "";
            this.priority_ = false;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearImagesApng2() {
            this.imagesApng2_ = Animation.getDefaultInstance().getImagesApng2();
            onChanged();
            return this;
        }

        public Builder clearImagesGif() {
            this.imagesGif_ = Animation.getDefaultInstance().getImagesGif();
            onChanged();
            return this;
        }

        public Builder clearImagesMp4() {
            this.imagesMp4_ = Animation.getDefaultInstance().getImagesMp4();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPriority() {
            this.priority_ = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Animation getDefaultInstanceForType() {
            return Animation.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_Animation_descriptor;
        }

        @Override // cn.irisgw.live.AnimationOrBuilder
        public String getImagesApng2() {
            Object obj = this.imagesApng2_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.imagesApng2_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.AnimationOrBuilder
        public ByteString getImagesApng2Bytes() {
            Object obj = this.imagesApng2_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imagesApng2_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.AnimationOrBuilder
        public String getImagesGif() {
            Object obj = this.imagesGif_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.imagesGif_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.AnimationOrBuilder
        public ByteString getImagesGifBytes() {
            Object obj = this.imagesGif_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imagesGif_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.AnimationOrBuilder
        public String getImagesMp4() {
            Object obj = this.imagesMp4_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.imagesMp4_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.AnimationOrBuilder
        public ByteString getImagesMp4Bytes() {
            Object obj = this.imagesMp4_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imagesMp4_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.AnimationOrBuilder
        public boolean getPriority() {
            return this.priority_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_Animation_fieldAccessorTable.ensureFieldAccessorsInitialized(Animation.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(Animation animation) {
            if (animation == Animation.getDefaultInstance()) {
                return this;
            }
            if (!animation.getImagesApng2().isEmpty()) {
                this.imagesApng2_ = animation.imagesApng2_;
                onChanged();
            }
            if (!animation.getImagesGif().isEmpty()) {
                this.imagesGif_ = animation.imagesGif_;
                onChanged();
            }
            if (!animation.getImagesMp4().isEmpty()) {
                this.imagesMp4_ = animation.imagesMp4_;
                onChanged();
            }
            if (animation.getPriority()) {
                setPriority(animation.getPriority());
            }
            mergeUnknownFields(animation.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.Animation.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.Animation.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.Animation r0 = (cn.irisgw.live.Animation) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.Animation$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.Animation r0 = (cn.irisgw.live.Animation) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.Animation$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.Animation.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.Animation$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Animation) {
                return mergeFrom((Animation) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setImagesApng2(String str) {
            if (str != null) {
                this.imagesApng2_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setImagesApng2Bytes(ByteString byteString) {
            if (byteString != null) {
                Animation.checkByteStringIsUtf8(byteString);
                this.imagesApng2_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setImagesGif(String str) {
            if (str != null) {
                this.imagesGif_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setImagesGifBytes(ByteString byteString) {
            if (byteString != null) {
                Animation.checkByteStringIsUtf8(byteString);
                this.imagesGif_ = byteString;
                onChanged();
                return this;
            }
            throw null;
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
                Animation.checkByteStringIsUtf8(byteString);
                this.imagesMp4_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPriority(boolean z) {
            this.priority_ = z;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private Animation() {
        this.memoizedIsInitialized = (byte) -1;
        this.imagesApng2_ = "";
        this.imagesGif_ = "";
        this.imagesMp4_ = "";
    }

    private Animation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.imagesApng2_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            this.imagesGif_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 26) {
                            this.imagesMp4_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 32) {
                            this.priority_ = codedInputStream.readBool();
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

    private Animation(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Animation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_Animation_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Animation animation) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(animation);
    }

    public static Animation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Animation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Animation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Animation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Animation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Animation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Animation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Animation) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Animation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Animation) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Animation parseFrom(InputStream inputStream) throws IOException {
        return (Animation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Animation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Animation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Animation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Animation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Animation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Animation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<Animation> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Animation) {
            Animation animation = (Animation) obj;
            return getImagesApng2().equals(animation.getImagesApng2()) && getImagesGif().equals(animation.getImagesGif()) && getImagesMp4().equals(animation.getImagesMp4()) && getPriority() == animation.getPriority() && this.unknownFields.equals(animation.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Animation getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.AnimationOrBuilder
    public String getImagesApng2() {
        Object obj = this.imagesApng2_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.imagesApng2_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.AnimationOrBuilder
    public ByteString getImagesApng2Bytes() {
        Object obj = this.imagesApng2_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.imagesApng2_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.AnimationOrBuilder
    public String getImagesGif() {
        Object obj = this.imagesGif_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.imagesGif_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.AnimationOrBuilder
    public ByteString getImagesGifBytes() {
        Object obj = this.imagesGif_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.imagesGif_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.AnimationOrBuilder
    public String getImagesMp4() {
        Object obj = this.imagesMp4_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.imagesMp4_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.AnimationOrBuilder
    public ByteString getImagesMp4Bytes() {
        Object obj = this.imagesMp4_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.imagesMp4_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Animation> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.AnimationOrBuilder
    public boolean getPriority() {
        return this.priority_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getImagesApng2Bytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.imagesApng2_);
        }
        int i3 = i2;
        if (!getImagesGifBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.imagesGif_);
        }
        int i4 = i3;
        if (!getImagesMp4Bytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.imagesMp4_);
        }
        boolean z = this.priority_;
        int i5 = i4;
        if (z) {
            i5 = i4 + CodedOutputStream.computeBoolSize(4, z);
        }
        int serializedSize = i5 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getImagesApng2().hashCode()) * 37) + 2) * 53) + getImagesGif().hashCode()) * 37) + 3) * 53) + getImagesMp4().hashCode()) * 37) + 4) * 53) + Internal.hashBoolean(getPriority())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_Animation_fieldAccessorTable.ensureFieldAccessorsInitialized(Animation.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Animation();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getImagesApng2Bytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.imagesApng2_);
        }
        if (!getImagesGifBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.imagesGif_);
        }
        if (!getImagesMp4Bytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.imagesMp4_);
        }
        boolean z = this.priority_;
        if (z) {
            codedOutputStream.writeBool(4, z);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
