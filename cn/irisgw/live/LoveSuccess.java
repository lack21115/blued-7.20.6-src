package cn.irisgw.live;

import cn.irisgw.live.LoveFan;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LoveSuccess.class */
public final class LoveSuccess extends GeneratedMessageV3 implements LoveSuccessOrBuilder {
    public static final int ANIME_URL_FIELD_NUMBER = 3;
    public static final int CHOOSER_FIELD_NUMBER = 2;
    public static final int CHOSEN_FIELD_NUMBER = 1;
    private static final LoveSuccess DEFAULT_INSTANCE = new LoveSuccess();
    private static final Parser<LoveSuccess> PARSER = new AbstractParser<LoveSuccess>() { // from class: cn.irisgw.live.LoveSuccess.1
        /* renamed from: parsePartialFrom */
        public LoveSuccess m5565parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LoveSuccess(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private volatile Object animeUrl_;
    private LoveFan chooser_;
    private LoveFan chosen_;
    private byte memoizedIsInitialized;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LoveSuccess$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LoveSuccessOrBuilder {
        private Object animeUrl_;
        private SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> chooserBuilder_;
        private LoveFan chooser_;
        private SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> chosenBuilder_;
        private LoveFan chosen_;

        private Builder() {
            this.animeUrl_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.animeUrl_ = "";
            maybeForceBuilderInitialization();
        }

        private SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> getChooserFieldBuilder() {
            if (this.chooserBuilder_ == null) {
                this.chooserBuilder_ = new SingleFieldBuilderV3<>(getChooser(), getParentForChildren(), isClean());
                this.chooser_ = null;
            }
            return this.chooserBuilder_;
        }

        private SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> getChosenFieldBuilder() {
            if (this.chosenBuilder_ == null) {
                this.chosenBuilder_ = new SingleFieldBuilderV3<>(getChosen(), getParentForChildren(), isClean());
                this.chosen_ = null;
            }
            return this.chosenBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveSuccess_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LoveSuccess.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m5567addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LoveSuccess m5569build() {
            LoveSuccess m5571buildPartial = m5571buildPartial();
            if (m5571buildPartial.isInitialized()) {
                return m5571buildPartial;
            }
            throw newUninitializedMessageException(m5571buildPartial);
        }

        /* renamed from: buildPartial */
        public LoveSuccess m5571buildPartial() {
            LoveSuccess loveSuccess = new LoveSuccess(this);
            SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> singleFieldBuilderV3 = this.chosenBuilder_;
            if (singleFieldBuilderV3 == null) {
                loveSuccess.chosen_ = this.chosen_;
            } else {
                loveSuccess.chosen_ = singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> singleFieldBuilderV32 = this.chooserBuilder_;
            if (singleFieldBuilderV32 == null) {
                loveSuccess.chooser_ = this.chooser_;
            } else {
                loveSuccess.chooser_ = singleFieldBuilderV32.build();
            }
            loveSuccess.animeUrl_ = this.animeUrl_;
            onBuilt();
            return loveSuccess;
        }

        /* renamed from: clear */
        public Builder m5575clear() {
            super.clear();
            if (this.chosenBuilder_ == null) {
                this.chosen_ = null;
            } else {
                this.chosen_ = null;
                this.chosenBuilder_ = null;
            }
            if (this.chooserBuilder_ == null) {
                this.chooser_ = null;
            } else {
                this.chooser_ = null;
                this.chooserBuilder_ = null;
            }
            this.animeUrl_ = "";
            return this;
        }

        public Builder clearAnimeUrl() {
            this.animeUrl_ = LoveSuccess.getDefaultInstance().getAnimeUrl();
            onChanged();
            return this;
        }

        public Builder clearChooser() {
            if (this.chooserBuilder_ == null) {
                this.chooser_ = null;
                onChanged();
                return this;
            }
            this.chooser_ = null;
            this.chooserBuilder_ = null;
            return this;
        }

        public Builder clearChosen() {
            if (this.chosenBuilder_ == null) {
                this.chosen_ = null;
                onChanged();
                return this;
            }
            this.chosen_ = null;
            this.chosenBuilder_ = null;
            return this;
        }

        /* renamed from: clearField */
        public Builder m5577clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m5580clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m5586clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.LoveSuccessOrBuilder
        public String getAnimeUrl() {
            Object obj = this.animeUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.animeUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LoveSuccessOrBuilder
        public ByteString getAnimeUrlBytes() {
            Object obj = this.animeUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.animeUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LoveSuccessOrBuilder
        public LoveFan getChooser() {
            SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> singleFieldBuilderV3 = this.chooserBuilder_;
            if (singleFieldBuilderV3 == null) {
                LoveFan loveFan = this.chooser_;
                LoveFan loveFan2 = loveFan;
                if (loveFan == null) {
                    loveFan2 = LoveFan.getDefaultInstance();
                }
                return loveFan2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public LoveFan.Builder getChooserBuilder() {
            onChanged();
            return getChooserFieldBuilder().getBuilder();
        }

        @Override // cn.irisgw.live.LoveSuccessOrBuilder
        public LoveFanOrBuilder getChooserOrBuilder() {
            SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> singleFieldBuilderV3 = this.chooserBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (LoveFanOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            LoveFan loveFan = this.chooser_;
            LoveFan loveFan2 = loveFan;
            if (loveFan == null) {
                loveFan2 = LoveFan.getDefaultInstance();
            }
            return loveFan2;
        }

        @Override // cn.irisgw.live.LoveSuccessOrBuilder
        public LoveFan getChosen() {
            SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> singleFieldBuilderV3 = this.chosenBuilder_;
            if (singleFieldBuilderV3 == null) {
                LoveFan loveFan = this.chosen_;
                LoveFan loveFan2 = loveFan;
                if (loveFan == null) {
                    loveFan2 = LoveFan.getDefaultInstance();
                }
                return loveFan2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public LoveFan.Builder getChosenBuilder() {
            onChanged();
            return getChosenFieldBuilder().getBuilder();
        }

        @Override // cn.irisgw.live.LoveSuccessOrBuilder
        public LoveFanOrBuilder getChosenOrBuilder() {
            SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> singleFieldBuilderV3 = this.chosenBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (LoveFanOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            LoveFan loveFan = this.chosen_;
            LoveFan loveFan2 = loveFan;
            if (loveFan == null) {
                loveFan2 = LoveFan.getDefaultInstance();
            }
            return loveFan2;
        }

        /* renamed from: getDefaultInstanceForType */
        public LoveSuccess m5588getDefaultInstanceForType() {
            return LoveSuccess.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveSuccess_descriptor;
        }

        @Override // cn.irisgw.live.LoveSuccessOrBuilder
        public boolean hasChooser() {
            return (this.chooserBuilder_ == null && this.chooser_ == null) ? false : true;
        }

        @Override // cn.irisgw.live.LoveSuccessOrBuilder
        public boolean hasChosen() {
            return (this.chosenBuilder_ == null && this.chosen_ == null) ? false : true;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveSuccess_fieldAccessorTable.ensureFieldAccessorsInitialized(LoveSuccess.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeChooser(LoveFan loveFan) {
            SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> singleFieldBuilderV3 = this.chooserBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(loveFan);
                return this;
            }
            LoveFan loveFan2 = this.chooser_;
            if (loveFan2 != null) {
                this.chooser_ = LoveFan.newBuilder(loveFan2).mergeFrom(loveFan).m5289buildPartial();
            } else {
                this.chooser_ = loveFan;
            }
            onChanged();
            return this;
        }

        public Builder mergeChosen(LoveFan loveFan) {
            SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> singleFieldBuilderV3 = this.chosenBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(loveFan);
                return this;
            }
            LoveFan loveFan2 = this.chosen_;
            if (loveFan2 != null) {
                this.chosen_ = LoveFan.newBuilder(loveFan2).mergeFrom(loveFan).m5289buildPartial();
            } else {
                this.chosen_ = loveFan;
            }
            onChanged();
            return this;
        }

        public Builder mergeFrom(LoveSuccess loveSuccess) {
            if (loveSuccess == LoveSuccess.getDefaultInstance()) {
                return this;
            }
            if (loveSuccess.hasChosen()) {
                mergeChosen(loveSuccess.getChosen());
            }
            if (loveSuccess.hasChooser()) {
                mergeChooser(loveSuccess.getChooser());
            }
            if (!loveSuccess.getAnimeUrl().isEmpty()) {
                this.animeUrl_ = loveSuccess.animeUrl_;
                onChanged();
            }
            m5597mergeUnknownFields(loveSuccess.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LoveSuccess.Builder m5594mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LoveSuccess.access$800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LoveSuccess r0 = (cn.irisgw.live.LoveSuccess) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LoveSuccess$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LoveSuccess r0 = (cn.irisgw.live.LoveSuccess) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LoveSuccess$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LoveSuccess.Builder.m5594mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LoveSuccess$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m5593mergeFrom(Message message) {
            if (message instanceof LoveSuccess) {
                return mergeFrom((LoveSuccess) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m5597mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setAnimeUrl(String str) {
            if (str != null) {
                this.animeUrl_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAnimeUrlBytes(ByteString byteString) {
            if (byteString != null) {
                LoveSuccess.checkByteStringIsUtf8(byteString);
                this.animeUrl_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChooser(LoveFan.Builder builder) {
            SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> singleFieldBuilderV3 = this.chooserBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.m5287build());
                return this;
            }
            this.chooser_ = builder.m5287build();
            onChanged();
            return this;
        }

        public Builder setChooser(LoveFan loveFan) {
            SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> singleFieldBuilderV3 = this.chooserBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(loveFan);
                return this;
            } else if (loveFan != null) {
                this.chooser_ = loveFan;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setChosen(LoveFan.Builder builder) {
            SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> singleFieldBuilderV3 = this.chosenBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.m5287build());
                return this;
            }
            this.chosen_ = builder.m5287build();
            onChanged();
            return this;
        }

        public Builder setChosen(LoveFan loveFan) {
            SingleFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> singleFieldBuilderV3 = this.chosenBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(loveFan);
                return this;
            } else if (loveFan != null) {
                this.chosen_ = loveFan;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        /* renamed from: setField */
        public Builder m5599setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m5601setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m5603setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LoveSuccess() {
        this.memoizedIsInitialized = (byte) -1;
        this.animeUrl_ = "";
    }

    private LoveSuccess(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                LoveFan.Builder m5282toBuilder = this.chosen_ != null ? this.chosen_.m5282toBuilder() : null;
                                LoveFan readMessage = codedInputStream.readMessage(LoveFan.parser(), extensionRegistryLite);
                                this.chosen_ = readMessage;
                                if (m5282toBuilder != null) {
                                    m5282toBuilder.mergeFrom(readMessage);
                                    this.chosen_ = m5282toBuilder.m5289buildPartial();
                                }
                            } else if (readTag == 18) {
                                LoveFan.Builder m5282toBuilder2 = this.chooser_ != null ? this.chooser_.m5282toBuilder() : null;
                                LoveFan readMessage2 = codedInputStream.readMessage(LoveFan.parser(), extensionRegistryLite);
                                this.chooser_ = readMessage2;
                                if (m5282toBuilder2 != null) {
                                    m5282toBuilder2.mergeFrom(readMessage2);
                                    this.chooser_ = m5282toBuilder2.m5289buildPartial();
                                }
                            } else if (readTag == 26) {
                                this.animeUrl_ = codedInputStream.readStringRequireUtf8();
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

    private LoveSuccess(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LoveSuccess getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LoveSuccess_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m5564toBuilder();
    }

    public static Builder newBuilder(LoveSuccess loveSuccess) {
        return DEFAULT_INSTANCE.m5564toBuilder().mergeFrom(loveSuccess);
    }

    public static LoveSuccess parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LoveSuccess parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LoveSuccess parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LoveSuccess) PARSER.parseFrom(byteString);
    }

    public static LoveSuccess parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoveSuccess) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LoveSuccess parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LoveSuccess parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LoveSuccess parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LoveSuccess parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LoveSuccess parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LoveSuccess) PARSER.parseFrom(byteBuffer);
    }

    public static LoveSuccess parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoveSuccess) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LoveSuccess parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LoveSuccess) PARSER.parseFrom(bArr);
    }

    public static LoveSuccess parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoveSuccess) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LoveSuccess> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoveSuccess) {
            LoveSuccess loveSuccess = (LoveSuccess) obj;
            if (hasChosen() != loveSuccess.hasChosen()) {
                return false;
            }
            if ((!hasChosen() || getChosen().equals(loveSuccess.getChosen())) && hasChooser() == loveSuccess.hasChooser()) {
                return (!hasChooser() || getChooser().equals(loveSuccess.getChooser())) && getAnimeUrl().equals(loveSuccess.getAnimeUrl()) && this.unknownFields.equals(loveSuccess.unknownFields);
            }
            return false;
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LoveSuccessOrBuilder
    public String getAnimeUrl() {
        Object obj = this.animeUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.animeUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LoveSuccessOrBuilder
    public ByteString getAnimeUrlBytes() {
        Object obj = this.animeUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.animeUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LoveSuccessOrBuilder
    public LoveFan getChooser() {
        LoveFan loveFan = this.chooser_;
        LoveFan loveFan2 = loveFan;
        if (loveFan == null) {
            loveFan2 = LoveFan.getDefaultInstance();
        }
        return loveFan2;
    }

    @Override // cn.irisgw.live.LoveSuccessOrBuilder
    public LoveFanOrBuilder getChooserOrBuilder() {
        return getChooser();
    }

    @Override // cn.irisgw.live.LoveSuccessOrBuilder
    public LoveFan getChosen() {
        LoveFan loveFan = this.chosen_;
        LoveFan loveFan2 = loveFan;
        if (loveFan == null) {
            loveFan2 = LoveFan.getDefaultInstance();
        }
        return loveFan2;
    }

    @Override // cn.irisgw.live.LoveSuccessOrBuilder
    public LoveFanOrBuilder getChosenOrBuilder() {
        return getChosen();
    }

    /* renamed from: getDefaultInstanceForType */
    public LoveSuccess m5559getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<LoveSuccess> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.chosen_ != null) {
            i2 = 0 + CodedOutputStream.computeMessageSize(1, getChosen());
        }
        int i3 = i2;
        if (this.chooser_ != null) {
            i3 = i2 + CodedOutputStream.computeMessageSize(2, getChooser());
        }
        int i4 = i3;
        if (!getAnimeUrlBytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.animeUrl_);
        }
        int serializedSize = i4 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.LoveSuccessOrBuilder
    public boolean hasChooser() {
        return this.chooser_ != null;
    }

    @Override // cn.irisgw.live.LoveSuccessOrBuilder
    public boolean hasChosen() {
        return this.chosen_ != null;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (hasChosen()) {
            i = (((hashCode * 37) + 1) * 53) + getChosen().hashCode();
        }
        int i2 = i;
        if (hasChooser()) {
            i2 = (((i * 37) + 2) * 53) + getChooser().hashCode();
        }
        int hashCode2 = (((((i2 * 37) + 3) * 53) + getAnimeUrl().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LoveSuccess_fieldAccessorTable.ensureFieldAccessorsInitialized(LoveSuccess.class, Builder.class);
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
    public Builder m5562newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m5561newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LoveSuccess();
    }

    /* renamed from: toBuilder */
    public Builder m5564toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.chosen_ != null) {
            codedOutputStream.writeMessage(1, getChosen());
        }
        if (this.chooser_ != null) {
            codedOutputStream.writeMessage(2, getChooser());
        }
        if (!getAnimeUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.animeUrl_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
