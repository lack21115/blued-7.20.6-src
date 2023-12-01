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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/TagLocationExtra.class */
public final class TagLocationExtra extends GeneratedMessageV3 implements TagLocationExtraOrBuilder {
    public static final int ADD_FIELD_NUMBER = 4;
    public static final int IMAGE_FIELD_NUMBER = 3;
    public static final int PROPORTION_X_FIELD_NUMBER = 1;
    public static final int PROPORTION_Y_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int add_;
    private volatile Object image_;
    private byte memoizedIsInitialized;
    private float proportionX_;
    private float proportionY_;
    private static final TagLocationExtra DEFAULT_INSTANCE = new TagLocationExtra();
    private static final Parser<TagLocationExtra> PARSER = new AbstractParser<TagLocationExtra>() { // from class: cn.irisgw.live.TagLocationExtra.1
        @Override // com.google.protobuf.Parser
        public TagLocationExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new TagLocationExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/TagLocationExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TagLocationExtraOrBuilder {
        private int add_;
        private Object image_;
        private float proportionX_;
        private float proportionY_;

        private Builder() {
            this.image_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.image_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_TagLocationExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = TagLocationExtra.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TagLocationExtra build() {
            TagLocationExtra buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TagLocationExtra buildPartial() {
            TagLocationExtra tagLocationExtra = new TagLocationExtra(this);
            tagLocationExtra.proportionX_ = this.proportionX_;
            tagLocationExtra.proportionY_ = this.proportionY_;
            tagLocationExtra.image_ = this.image_;
            tagLocationExtra.add_ = this.add_;
            onBuilt();
            return tagLocationExtra;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.proportionX_ = 0.0f;
            this.proportionY_ = 0.0f;
            this.image_ = "";
            this.add_ = 0;
            return this;
        }

        public Builder clearAdd() {
            this.add_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearImage() {
            this.image_ = TagLocationExtra.getDefaultInstance().getImage();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearProportionX() {
            this.proportionX_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearProportionY() {
            this.proportionY_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.TagLocationExtraOrBuilder
        public int getAdd() {
            return this.add_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TagLocationExtra getDefaultInstanceForType() {
            return TagLocationExtra.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_TagLocationExtra_descriptor;
        }

        @Override // cn.irisgw.live.TagLocationExtraOrBuilder
        public String getImage() {
            Object obj = this.image_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.image_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.TagLocationExtraOrBuilder
        public ByteString getImageBytes() {
            Object obj = this.image_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.image_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.TagLocationExtraOrBuilder
        public float getProportionX() {
            return this.proportionX_;
        }

        @Override // cn.irisgw.live.TagLocationExtraOrBuilder
        public float getProportionY() {
            return this.proportionY_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_TagLocationExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(TagLocationExtra.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(TagLocationExtra tagLocationExtra) {
            if (tagLocationExtra == TagLocationExtra.getDefaultInstance()) {
                return this;
            }
            if (tagLocationExtra.getProportionX() != 0.0f) {
                setProportionX(tagLocationExtra.getProportionX());
            }
            if (tagLocationExtra.getProportionY() != 0.0f) {
                setProportionY(tagLocationExtra.getProportionY());
            }
            if (!tagLocationExtra.getImage().isEmpty()) {
                this.image_ = tagLocationExtra.image_;
                onChanged();
            }
            if (tagLocationExtra.getAdd() != 0) {
                setAdd(tagLocationExtra.getAdd());
            }
            mergeUnknownFields(tagLocationExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.TagLocationExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.TagLocationExtra.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.TagLocationExtra r0 = (cn.irisgw.live.TagLocationExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.TagLocationExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.TagLocationExtra r0 = (cn.irisgw.live.TagLocationExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.TagLocationExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.TagLocationExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.TagLocationExtra$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof TagLocationExtra) {
                return mergeFrom((TagLocationExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setAdd(int i) {
            this.add_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setImage(String str) {
            if (str != null) {
                this.image_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setImageBytes(ByteString byteString) {
            if (byteString != null) {
                TagLocationExtra.checkByteStringIsUtf8(byteString);
                this.image_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setProportionX(float f) {
            this.proportionX_ = f;
            onChanged();
            return this;
        }

        public Builder setProportionY(float f) {
            this.proportionY_ = f;
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

    private TagLocationExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.image_ = "";
    }

    private TagLocationExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        if (readTag == 13) {
                            this.proportionX_ = codedInputStream.readFloat();
                        } else if (readTag == 21) {
                            this.proportionY_ = codedInputStream.readFloat();
                        } else if (readTag == 26) {
                            this.image_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 32) {
                            this.add_ = codedInputStream.readUInt32();
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

    private TagLocationExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static TagLocationExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_TagLocationExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TagLocationExtra tagLocationExtra) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(tagLocationExtra);
    }

    public static TagLocationExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TagLocationExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TagLocationExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TagLocationExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TagLocationExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static TagLocationExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static TagLocationExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TagLocationExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static TagLocationExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TagLocationExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static TagLocationExtra parseFrom(InputStream inputStream) throws IOException {
        return (TagLocationExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static TagLocationExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TagLocationExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TagLocationExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static TagLocationExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static TagLocationExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static TagLocationExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<TagLocationExtra> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TagLocationExtra) {
            TagLocationExtra tagLocationExtra = (TagLocationExtra) obj;
            return Float.floatToIntBits(getProportionX()) == Float.floatToIntBits(tagLocationExtra.getProportionX()) && Float.floatToIntBits(getProportionY()) == Float.floatToIntBits(tagLocationExtra.getProportionY()) && getImage().equals(tagLocationExtra.getImage()) && getAdd() == tagLocationExtra.getAdd() && this.unknownFields.equals(tagLocationExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.TagLocationExtraOrBuilder
    public int getAdd() {
        return this.add_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public TagLocationExtra getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.TagLocationExtraOrBuilder
    public String getImage() {
        Object obj = this.image_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.image_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.TagLocationExtraOrBuilder
    public ByteString getImageBytes() {
        Object obj = this.image_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.image_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<TagLocationExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.TagLocationExtraOrBuilder
    public float getProportionX() {
        return this.proportionX_;
    }

    @Override // cn.irisgw.live.TagLocationExtraOrBuilder
    public float getProportionY() {
        return this.proportionY_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        float f = this.proportionX_;
        if (f != 0.0f) {
            i2 = 0 + CodedOutputStream.computeFloatSize(1, f);
        }
        float f2 = this.proportionY_;
        int i3 = i2;
        if (f2 != 0.0f) {
            i3 = i2 + CodedOutputStream.computeFloatSize(2, f2);
        }
        int i4 = i3;
        if (!getImageBytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.image_);
        }
        int i5 = this.add_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeUInt32Size(4, i5);
        }
        int serializedSize = i6 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Float.floatToIntBits(getProportionX())) * 37) + 2) * 53) + Float.floatToIntBits(getProportionY())) * 37) + 3) * 53) + getImage().hashCode()) * 37) + 4) * 53) + getAdd()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_TagLocationExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(TagLocationExtra.class, Builder.class);
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
        return new TagLocationExtra();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        float f = this.proportionX_;
        if (f != 0.0f) {
            codedOutputStream.writeFloat(1, f);
        }
        float f2 = this.proportionY_;
        if (f2 != 0.0f) {
            codedOutputStream.writeFloat(2, f2);
        }
        if (!getImageBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.image_);
        }
        int i = this.add_;
        if (i != 0) {
            codedOutputStream.writeUInt32(4, i);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
