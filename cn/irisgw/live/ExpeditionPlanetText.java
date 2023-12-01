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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ExpeditionPlanetText.class */
public final class ExpeditionPlanetText extends GeneratedMessageV3 implements ExpeditionPlanetTextOrBuilder {
    public static final int GOODS_COUNT_FIELD_NUMBER = 4;
    public static final int GOODS_IMAGE_FIELD_NUMBER = 3;
    public static final int GOODS_NAME_FIELD_NUMBER = 2;
    public static final int HIDE_FIELD_NUMBER = 7;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int TEXT_FIELD_NUMBER = 5;
    public static final int UID_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int goodsCount_;
    private volatile Object goodsImage_;
    private volatile Object goodsName_;
    private boolean hide_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private volatile Object text_;
    private int uid_;
    private static final ExpeditionPlanetText DEFAULT_INSTANCE = new ExpeditionPlanetText();
    private static final Parser<ExpeditionPlanetText> PARSER = new AbstractParser<ExpeditionPlanetText>() { // from class: cn.irisgw.live.ExpeditionPlanetText.1
        /* renamed from: parsePartialFrom */
        public ExpeditionPlanetText m2383parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ExpeditionPlanetText(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ExpeditionPlanetText$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ExpeditionPlanetTextOrBuilder {
        private int goodsCount_;
        private Object goodsImage_;
        private Object goodsName_;
        private boolean hide_;
        private Object name_;
        private Object text_;
        private int uid_;

        private Builder() {
            this.name_ = "";
            this.goodsName_ = "";
            this.goodsImage_ = "";
            this.text_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.goodsName_ = "";
            this.goodsImage_ = "";
            this.text_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetText_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = ExpeditionPlanetText.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m2385addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public ExpeditionPlanetText m2387build() {
            ExpeditionPlanetText m2389buildPartial = m2389buildPartial();
            if (m2389buildPartial.isInitialized()) {
                return m2389buildPartial;
            }
            throw newUninitializedMessageException(m2389buildPartial);
        }

        /* renamed from: buildPartial */
        public ExpeditionPlanetText m2389buildPartial() {
            ExpeditionPlanetText expeditionPlanetText = new ExpeditionPlanetText(this);
            expeditionPlanetText.name_ = this.name_;
            expeditionPlanetText.goodsName_ = this.goodsName_;
            expeditionPlanetText.goodsImage_ = this.goodsImage_;
            expeditionPlanetText.goodsCount_ = this.goodsCount_;
            expeditionPlanetText.text_ = this.text_;
            expeditionPlanetText.uid_ = this.uid_;
            expeditionPlanetText.hide_ = this.hide_;
            onBuilt();
            return expeditionPlanetText;
        }

        /* renamed from: clear */
        public Builder m2393clear() {
            super.clear();
            this.name_ = "";
            this.goodsName_ = "";
            this.goodsImage_ = "";
            this.goodsCount_ = 0;
            this.text_ = "";
            this.uid_ = 0;
            this.hide_ = false;
            return this;
        }

        /* renamed from: clearField */
        public Builder m2395clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGoodsCount() {
            this.goodsCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearGoodsImage() {
            this.goodsImage_ = ExpeditionPlanetText.getDefaultInstance().getGoodsImage();
            onChanged();
            return this;
        }

        public Builder clearGoodsName() {
            this.goodsName_ = ExpeditionPlanetText.getDefaultInstance().getGoodsName();
            onChanged();
            return this;
        }

        public Builder clearHide() {
            this.hide_ = false;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = ExpeditionPlanetText.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m2398clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearText() {
            this.text_ = ExpeditionPlanetText.getDefaultInstance().getText();
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m2404clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public ExpeditionPlanetText m2406getDefaultInstanceForType() {
            return ExpeditionPlanetText.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetText_descriptor;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
        public int getGoodsCount() {
            return this.goodsCount_;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
        public String getGoodsImage() {
            Object obj = this.goodsImage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsImage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
        public ByteString getGoodsImageBytes() {
            Object obj = this.goodsImage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsImage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
        public String getGoodsName() {
            Object obj = this.goodsName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
        public ByteString getGoodsNameBytes() {
            Object obj = this.goodsName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
        public boolean getHide() {
            return this.hide_;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
        public String getText() {
            Object obj = this.text_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.text_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
        public ByteString getTextBytes() {
            Object obj = this.text_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.text_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
        public int getUid() {
            return this.uid_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetText_fieldAccessorTable.ensureFieldAccessorsInitialized(ExpeditionPlanetText.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ExpeditionPlanetText expeditionPlanetText) {
            if (expeditionPlanetText == ExpeditionPlanetText.getDefaultInstance()) {
                return this;
            }
            if (!expeditionPlanetText.getName().isEmpty()) {
                this.name_ = expeditionPlanetText.name_;
                onChanged();
            }
            if (!expeditionPlanetText.getGoodsName().isEmpty()) {
                this.goodsName_ = expeditionPlanetText.goodsName_;
                onChanged();
            }
            if (!expeditionPlanetText.getGoodsImage().isEmpty()) {
                this.goodsImage_ = expeditionPlanetText.goodsImage_;
                onChanged();
            }
            if (expeditionPlanetText.getGoodsCount() != 0) {
                setGoodsCount(expeditionPlanetText.getGoodsCount());
            }
            if (!expeditionPlanetText.getText().isEmpty()) {
                this.text_ = expeditionPlanetText.text_;
                onChanged();
            }
            if (expeditionPlanetText.getUid() != 0) {
                setUid(expeditionPlanetText.getUid());
            }
            if (expeditionPlanetText.getHide()) {
                setHide(expeditionPlanetText.getHide());
            }
            m2415mergeUnknownFields(expeditionPlanetText.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ExpeditionPlanetText.Builder m2412mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ExpeditionPlanetText.access$1200()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ExpeditionPlanetText r0 = (cn.irisgw.live.ExpeditionPlanetText) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ExpeditionPlanetText$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ExpeditionPlanetText r0 = (cn.irisgw.live.ExpeditionPlanetText) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ExpeditionPlanetText$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ExpeditionPlanetText.Builder.m2412mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ExpeditionPlanetText$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m2411mergeFrom(Message message) {
            if (message instanceof ExpeditionPlanetText) {
                return mergeFrom((ExpeditionPlanetText) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m2415mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m2417setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGoodsCount(int i) {
            this.goodsCount_ = i;
            onChanged();
            return this;
        }

        public Builder setGoodsImage(String str) {
            if (str != null) {
                this.goodsImage_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGoodsImageBytes(ByteString byteString) {
            if (byteString != null) {
                ExpeditionPlanetText.checkByteStringIsUtf8(byteString);
                this.goodsImage_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGoodsName(String str) {
            if (str != null) {
                this.goodsName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGoodsNameBytes(ByteString byteString) {
            if (byteString != null) {
                ExpeditionPlanetText.checkByteStringIsUtf8(byteString);
                this.goodsName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHide(boolean z) {
            this.hide_ = z;
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
                ExpeditionPlanetText.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setRepeatedField */
        public Builder m2419setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setText(String str) {
            if (str != null) {
                this.text_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTextBytes(ByteString byteString) {
            if (byteString != null) {
                ExpeditionPlanetText.checkByteStringIsUtf8(byteString);
                this.text_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m2421setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private ExpeditionPlanetText() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.goodsName_ = "";
        this.goodsImage_ = "";
        this.text_ = "";
    }

    private ExpeditionPlanetText(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.goodsName_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.goodsImage_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.goodsCount_ = codedInputStream.readInt32();
                            } else if (readTag == 42) {
                                this.text_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 48) {
                                this.uid_ = codedInputStream.readInt32();
                            } else if (readTag == 56) {
                                this.hide_ = codedInputStream.readBool();
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

    private ExpeditionPlanetText(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ExpeditionPlanetText getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetText_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m2382toBuilder();
    }

    public static Builder newBuilder(ExpeditionPlanetText expeditionPlanetText) {
        return DEFAULT_INSTANCE.m2382toBuilder().mergeFrom(expeditionPlanetText);
    }

    public static ExpeditionPlanetText parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ExpeditionPlanetText parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ExpeditionPlanetText parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ExpeditionPlanetText) PARSER.parseFrom(byteString);
    }

    public static ExpeditionPlanetText parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ExpeditionPlanetText) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ExpeditionPlanetText parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ExpeditionPlanetText parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ExpeditionPlanetText parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ExpeditionPlanetText parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ExpeditionPlanetText parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ExpeditionPlanetText) PARSER.parseFrom(byteBuffer);
    }

    public static ExpeditionPlanetText parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ExpeditionPlanetText) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ExpeditionPlanetText parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ExpeditionPlanetText) PARSER.parseFrom(bArr);
    }

    public static ExpeditionPlanetText parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ExpeditionPlanetText) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ExpeditionPlanetText> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ExpeditionPlanetText) {
            ExpeditionPlanetText expeditionPlanetText = (ExpeditionPlanetText) obj;
            return getName().equals(expeditionPlanetText.getName()) && getGoodsName().equals(expeditionPlanetText.getGoodsName()) && getGoodsImage().equals(expeditionPlanetText.getGoodsImage()) && getGoodsCount() == expeditionPlanetText.getGoodsCount() && getText().equals(expeditionPlanetText.getText()) && getUid() == expeditionPlanetText.getUid() && getHide() == expeditionPlanetText.getHide() && this.unknownFields.equals(expeditionPlanetText.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public ExpeditionPlanetText m2377getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
    public int getGoodsCount() {
        return this.goodsCount_;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
    public String getGoodsImage() {
        Object obj = this.goodsImage_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.goodsImage_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
    public ByteString getGoodsImageBytes() {
        Object obj = this.goodsImage_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goodsImage_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
    public String getGoodsName() {
        Object obj = this.goodsName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.goodsName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
    public ByteString getGoodsNameBytes() {
        Object obj = this.goodsName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goodsName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
    public boolean getHide() {
        return this.hide_;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<ExpeditionPlanetText> getParserForType() {
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
        int i3 = i2;
        if (!getGoodsNameBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.goodsName_);
        }
        int i4 = i3;
        if (!getGoodsImageBytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.goodsImage_);
        }
        int i5 = this.goodsCount_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeInt32Size(4, i5);
        }
        int i7 = i6;
        if (!getTextBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.text_);
        }
        int i8 = this.uid_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeInt32Size(6, i8);
        }
        boolean z = this.hide_;
        int i10 = i9;
        if (z) {
            i10 = i9 + CodedOutputStream.computeBoolSize(7, z);
        }
        int serializedSize = i10 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
    public String getText() {
        Object obj = this.text_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.text_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
    public ByteString getTextBytes() {
        Object obj = this.text_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.text_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetTextOrBuilder
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
        int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getGoodsName().hashCode()) * 37) + 3) * 53) + getGoodsImage().hashCode()) * 37) + 4) * 53) + getGoodsCount()) * 37) + 5) * 53) + getText().hashCode()) * 37) + 6) * 53) + getUid()) * 37) + 7) * 53) + Internal.hashBoolean(getHide())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetText_fieldAccessorTable.ensureFieldAccessorsInitialized(ExpeditionPlanetText.class, Builder.class);
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
    public Builder m2380newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m2379newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new ExpeditionPlanetText();
    }

    /* renamed from: toBuilder */
    public Builder m2382toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        if (!getGoodsNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.goodsName_);
        }
        if (!getGoodsImageBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.goodsImage_);
        }
        int i = this.goodsCount_;
        if (i != 0) {
            codedOutputStream.writeInt32(4, i);
        }
        if (!getTextBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.text_);
        }
        int i2 = this.uid_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(6, i2);
        }
        boolean z = this.hide_;
        if (z) {
            codedOutputStream.writeBool(7, z);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
