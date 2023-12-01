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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ConstellationText.class */
public final class ConstellationText extends GeneratedMessageV3 implements ConstellationTextOrBuilder {
    public static final int ANCHOR_NAME_FIELD_NUMBER = 2;
    public static final int CONSTELLATION_NAME_FIELD_NUMBER = 5;
    public static final int IS_HIDE_FIELD_NUMBER = 3;
    public static final int LINK_FIELD_NUMBER = 7;
    public static final int LINK_TYPE_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int TYPE_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private volatile Object anchorName_;
    private volatile Object constellationName_;
    private int isHide_;
    private int linkType_;
    private volatile Object link_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int type_;
    private static final ConstellationText DEFAULT_INSTANCE = new ConstellationText();
    private static final Parser<ConstellationText> PARSER = new AbstractParser<ConstellationText>() { // from class: cn.irisgw.live.ConstellationText.1
        @Override // com.google.protobuf.Parser
        public ConstellationText parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ConstellationText(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ConstellationText$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ConstellationTextOrBuilder {
        private Object anchorName_;
        private Object constellationName_;
        private int isHide_;
        private int linkType_;
        private Object link_;
        private Object name_;
        private int type_;

        private Builder() {
            this.name_ = "";
            this.anchorName_ = "";
            this.constellationName_ = "";
            this.link_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.anchorName_ = "";
            this.constellationName_ = "";
            this.link_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ConstellationText_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = ConstellationText.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ConstellationText build() {
            ConstellationText buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ConstellationText buildPartial() {
            ConstellationText constellationText = new ConstellationText(this);
            constellationText.name_ = this.name_;
            constellationText.anchorName_ = this.anchorName_;
            constellationText.isHide_ = this.isHide_;
            constellationText.type_ = this.type_;
            constellationText.constellationName_ = this.constellationName_;
            constellationText.linkType_ = this.linkType_;
            constellationText.link_ = this.link_;
            onBuilt();
            return constellationText;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.name_ = "";
            this.anchorName_ = "";
            this.isHide_ = 0;
            this.type_ = 0;
            this.constellationName_ = "";
            this.linkType_ = 0;
            this.link_ = "";
            return this;
        }

        public Builder clearAnchorName() {
            this.anchorName_ = ConstellationText.getDefaultInstance().getAnchorName();
            onChanged();
            return this;
        }

        public Builder clearConstellationName() {
            this.constellationName_ = ConstellationText.getDefaultInstance().getConstellationName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearIsHide() {
            this.isHide_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLink() {
            this.link_ = ConstellationText.getDefaultInstance().getLink();
            onChanged();
            return this;
        }

        public Builder clearLinkType() {
            this.linkType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = ConstellationText.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.ConstellationTextOrBuilder
        public String getAnchorName() {
            Object obj = this.anchorName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.anchorName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ConstellationTextOrBuilder
        public ByteString getAnchorNameBytes() {
            Object obj = this.anchorName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.anchorName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ConstellationTextOrBuilder
        public String getConstellationName() {
            Object obj = this.constellationName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.constellationName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ConstellationTextOrBuilder
        public ByteString getConstellationNameBytes() {
            Object obj = this.constellationName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.constellationName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ConstellationText getDefaultInstanceForType() {
            return ConstellationText.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ConstellationText_descriptor;
        }

        @Override // cn.irisgw.live.ConstellationTextOrBuilder
        public int getIsHide() {
            return this.isHide_;
        }

        @Override // cn.irisgw.live.ConstellationTextOrBuilder
        public String getLink() {
            Object obj = this.link_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.link_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ConstellationTextOrBuilder
        public ByteString getLinkBytes() {
            Object obj = this.link_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.link_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ConstellationTextOrBuilder
        public int getLinkType() {
            return this.linkType_;
        }

        @Override // cn.irisgw.live.ConstellationTextOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ConstellationTextOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ConstellationTextOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ConstellationText_fieldAccessorTable.ensureFieldAccessorsInitialized(ConstellationText.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ConstellationText constellationText) {
            if (constellationText == ConstellationText.getDefaultInstance()) {
                return this;
            }
            if (!constellationText.getName().isEmpty()) {
                this.name_ = constellationText.name_;
                onChanged();
            }
            if (!constellationText.getAnchorName().isEmpty()) {
                this.anchorName_ = constellationText.anchorName_;
                onChanged();
            }
            if (constellationText.getIsHide() != 0) {
                setIsHide(constellationText.getIsHide());
            }
            if (constellationText.getType() != 0) {
                setType(constellationText.getType());
            }
            if (!constellationText.getConstellationName().isEmpty()) {
                this.constellationName_ = constellationText.constellationName_;
                onChanged();
            }
            if (constellationText.getLinkType() != 0) {
                setLinkType(constellationText.getLinkType());
            }
            if (!constellationText.getLink().isEmpty()) {
                this.link_ = constellationText.link_;
                onChanged();
            }
            mergeUnknownFields(constellationText.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ConstellationText.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ConstellationText.access$1200()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ConstellationText r0 = (cn.irisgw.live.ConstellationText) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ConstellationText$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ConstellationText r0 = (cn.irisgw.live.ConstellationText) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ConstellationText$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ConstellationText.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ConstellationText$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ConstellationText) {
                return mergeFrom((ConstellationText) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setAnchorName(String str) {
            if (str != null) {
                this.anchorName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAnchorNameBytes(ByteString byteString) {
            if (byteString != null) {
                ConstellationText.checkByteStringIsUtf8(byteString);
                this.anchorName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setConstellationName(String str) {
            if (str != null) {
                this.constellationName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setConstellationNameBytes(ByteString byteString) {
            if (byteString != null) {
                ConstellationText.checkByteStringIsUtf8(byteString);
                this.constellationName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setIsHide(int i) {
            this.isHide_ = i;
            onChanged();
            return this;
        }

        public Builder setLink(String str) {
            if (str != null) {
                this.link_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLinkBytes(ByteString byteString) {
            if (byteString != null) {
                ConstellationText.checkByteStringIsUtf8(byteString);
                this.link_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLinkType(int i) {
            this.linkType_ = i;
            onChanged();
            return this;
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
                ConstellationText.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setType(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private ConstellationText() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.anchorName_ = "";
        this.constellationName_ = "";
        this.link_ = "";
    }

    private ConstellationText(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            } else if (readTag == 18) {
                                this.anchorName_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.isHide_ = codedInputStream.readInt32();
                            } else if (readTag == 32) {
                                this.type_ = codedInputStream.readInt32();
                            } else if (readTag == 42) {
                                this.constellationName_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 48) {
                                this.linkType_ = codedInputStream.readInt32();
                            } else if (readTag == 58) {
                                this.link_ = codedInputStream.readStringRequireUtf8();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private ConstellationText(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ConstellationText getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ConstellationText_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ConstellationText constellationText) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(constellationText);
    }

    public static ConstellationText parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ConstellationText) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ConstellationText parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ConstellationText) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ConstellationText parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ConstellationText parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ConstellationText parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ConstellationText) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ConstellationText parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ConstellationText) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ConstellationText parseFrom(InputStream inputStream) throws IOException {
        return (ConstellationText) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ConstellationText parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ConstellationText) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ConstellationText parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ConstellationText parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ConstellationText parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ConstellationText parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ConstellationText> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConstellationText) {
            ConstellationText constellationText = (ConstellationText) obj;
            return getName().equals(constellationText.getName()) && getAnchorName().equals(constellationText.getAnchorName()) && getIsHide() == constellationText.getIsHide() && getType() == constellationText.getType() && getConstellationName().equals(constellationText.getConstellationName()) && getLinkType() == constellationText.getLinkType() && getLink().equals(constellationText.getLink()) && this.unknownFields.equals(constellationText.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.ConstellationTextOrBuilder
    public String getAnchorName() {
        Object obj = this.anchorName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.anchorName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ConstellationTextOrBuilder
    public ByteString getAnchorNameBytes() {
        Object obj = this.anchorName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.anchorName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ConstellationTextOrBuilder
    public String getConstellationName() {
        Object obj = this.constellationName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.constellationName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ConstellationTextOrBuilder
    public ByteString getConstellationNameBytes() {
        Object obj = this.constellationName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.constellationName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ConstellationText getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ConstellationTextOrBuilder
    public int getIsHide() {
        return this.isHide_;
    }

    @Override // cn.irisgw.live.ConstellationTextOrBuilder
    public String getLink() {
        Object obj = this.link_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.link_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ConstellationTextOrBuilder
    public ByteString getLinkBytes() {
        Object obj = this.link_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.link_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ConstellationTextOrBuilder
    public int getLinkType() {
        return this.linkType_;
    }

    @Override // cn.irisgw.live.ConstellationTextOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ConstellationTextOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ConstellationText> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getNameBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
        }
        int i3 = i2;
        if (!getAnchorNameBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.anchorName_);
        }
        int i4 = this.isHide_;
        int i5 = i3;
        if (i4 != 0) {
            i5 = i3 + CodedOutputStream.computeInt32Size(3, i4);
        }
        int i6 = this.type_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeInt32Size(4, i6);
        }
        int i8 = i7;
        if (!getConstellationNameBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(5, this.constellationName_);
        }
        int i9 = this.linkType_;
        int i10 = i8;
        if (i9 != 0) {
            i10 = i8 + CodedOutputStream.computeInt32Size(6, i9);
        }
        int i11 = i10;
        if (!getLinkBytes().isEmpty()) {
            i11 = i10 + GeneratedMessageV3.computeStringSize(7, this.link_);
        }
        int serializedSize = i11 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.ConstellationTextOrBuilder
    public int getType() {
        return this.type_;
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
        int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getAnchorName().hashCode()) * 37) + 3) * 53) + getIsHide()) * 37) + 4) * 53) + getType()) * 37) + 5) * 53) + getConstellationName().hashCode()) * 37) + 6) * 53) + getLinkType()) * 37) + 7) * 53) + getLink().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ConstellationText_fieldAccessorTable.ensureFieldAccessorsInitialized(ConstellationText.class, Builder.class);
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
        return new ConstellationText();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        if (!getAnchorNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.anchorName_);
        }
        int i = this.isHide_;
        if (i != 0) {
            codedOutputStream.writeInt32(3, i);
        }
        int i2 = this.type_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(4, i2);
        }
        if (!getConstellationNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.constellationName_);
        }
        int i3 = this.linkType_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(6, i3);
        }
        if (!getLinkBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.link_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
