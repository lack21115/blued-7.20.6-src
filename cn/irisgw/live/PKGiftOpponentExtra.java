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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PKGiftOpponentExtra.class */
public final class PKGiftOpponentExtra extends GeneratedMessageV3 implements PKGiftOpponentExtraOrBuilder {
    public static final int ANIMATION_FIELD_NUMBER = 8;
    public static final int ANIM_CODE_FIELD_NUMBER = 9;
    public static final int GIFT_ID_FIELD_NUMBER = 1;
    public static final int GIFT_NAME_FIELD_NUMBER = 2;
    public static final int GIFT_PIC_APNG_FIELD_NUMBER = 6;
    public static final int GIFT_PIC_GIF_FIELD_NUMBER = 5;
    public static final int GIFT_PIC_MP4_FIELD_NUMBER = 7;
    public static final int GIFT_PIC_URL_FIELD_NUMBER = 4;
    public static final int GIFT_TYPE_FIELD_NUMBER = 3;
    public static final int RESOURCE_URL_FIELD_NUMBER = 10;
    private static final long serialVersionUID = 0;
    private volatile Object animCode_;
    private int animation_;
    private int giftId_;
    private volatile Object giftName_;
    private volatile Object giftPicApng_;
    private volatile Object giftPicGif_;
    private volatile Object giftPicMp4_;
    private volatile Object giftPicUrl_;
    private int giftType_;
    private byte memoizedIsInitialized;
    private volatile Object resourceUrl_;
    private static final PKGiftOpponentExtra DEFAULT_INSTANCE = new PKGiftOpponentExtra();
    private static final Parser<PKGiftOpponentExtra> PARSER = new AbstractParser<PKGiftOpponentExtra>() { // from class: cn.irisgw.live.PKGiftOpponentExtra.1
        @Override // com.google.protobuf.Parser
        public PKGiftOpponentExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PKGiftOpponentExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PKGiftOpponentExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PKGiftOpponentExtraOrBuilder {
        private Object animCode_;
        private int animation_;
        private int giftId_;
        private Object giftName_;
        private Object giftPicApng_;
        private Object giftPicGif_;
        private Object giftPicMp4_;
        private Object giftPicUrl_;
        private int giftType_;
        private Object resourceUrl_;

        private Builder() {
            this.giftName_ = "";
            this.giftPicUrl_ = "";
            this.giftPicGif_ = "";
            this.giftPicApng_ = "";
            this.giftPicMp4_ = "";
            this.animCode_ = "";
            this.resourceUrl_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.giftName_ = "";
            this.giftPicUrl_ = "";
            this.giftPicGif_ = "";
            this.giftPicApng_ = "";
            this.giftPicMp4_ = "";
            this.animCode_ = "";
            this.resourceUrl_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PKGiftOpponentExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = PKGiftOpponentExtra.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PKGiftOpponentExtra build() {
            PKGiftOpponentExtra buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PKGiftOpponentExtra buildPartial() {
            PKGiftOpponentExtra pKGiftOpponentExtra = new PKGiftOpponentExtra(this);
            pKGiftOpponentExtra.giftId_ = this.giftId_;
            pKGiftOpponentExtra.giftName_ = this.giftName_;
            pKGiftOpponentExtra.giftType_ = this.giftType_;
            pKGiftOpponentExtra.giftPicUrl_ = this.giftPicUrl_;
            pKGiftOpponentExtra.giftPicGif_ = this.giftPicGif_;
            pKGiftOpponentExtra.giftPicApng_ = this.giftPicApng_;
            pKGiftOpponentExtra.giftPicMp4_ = this.giftPicMp4_;
            pKGiftOpponentExtra.animation_ = this.animation_;
            pKGiftOpponentExtra.animCode_ = this.animCode_;
            pKGiftOpponentExtra.resourceUrl_ = this.resourceUrl_;
            onBuilt();
            return pKGiftOpponentExtra;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.giftId_ = 0;
            this.giftName_ = "";
            this.giftType_ = 0;
            this.giftPicUrl_ = "";
            this.giftPicGif_ = "";
            this.giftPicApng_ = "";
            this.giftPicMp4_ = "";
            this.animation_ = 0;
            this.animCode_ = "";
            this.resourceUrl_ = "";
            return this;
        }

        public Builder clearAnimCode() {
            this.animCode_ = PKGiftOpponentExtra.getDefaultInstance().getAnimCode();
            onChanged();
            return this;
        }

        public Builder clearAnimation() {
            this.animation_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGiftId() {
            this.giftId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearGiftName() {
            this.giftName_ = PKGiftOpponentExtra.getDefaultInstance().getGiftName();
            onChanged();
            return this;
        }

        public Builder clearGiftPicApng() {
            this.giftPicApng_ = PKGiftOpponentExtra.getDefaultInstance().getGiftPicApng();
            onChanged();
            return this;
        }

        public Builder clearGiftPicGif() {
            this.giftPicGif_ = PKGiftOpponentExtra.getDefaultInstance().getGiftPicGif();
            onChanged();
            return this;
        }

        public Builder clearGiftPicMp4() {
            this.giftPicMp4_ = PKGiftOpponentExtra.getDefaultInstance().getGiftPicMp4();
            onChanged();
            return this;
        }

        public Builder clearGiftPicUrl() {
            this.giftPicUrl_ = PKGiftOpponentExtra.getDefaultInstance().getGiftPicUrl();
            onChanged();
            return this;
        }

        public Builder clearGiftType() {
            this.giftType_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearResourceUrl() {
            this.resourceUrl_ = PKGiftOpponentExtra.getDefaultInstance().getResourceUrl();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public String getAnimCode() {
            Object obj = this.animCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.animCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public ByteString getAnimCodeBytes() {
            Object obj = this.animCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.animCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public int getAnimation() {
            return this.animation_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PKGiftOpponentExtra getDefaultInstanceForType() {
            return PKGiftOpponentExtra.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_PKGiftOpponentExtra_descriptor;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public int getGiftId() {
            return this.giftId_;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public String getGiftName() {
            Object obj = this.giftName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public ByteString getGiftNameBytes() {
            Object obj = this.giftName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public String getGiftPicApng() {
            Object obj = this.giftPicApng_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftPicApng_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public ByteString getGiftPicApngBytes() {
            Object obj = this.giftPicApng_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftPicApng_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public String getGiftPicGif() {
            Object obj = this.giftPicGif_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftPicGif_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public ByteString getGiftPicGifBytes() {
            Object obj = this.giftPicGif_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftPicGif_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public String getGiftPicMp4() {
            Object obj = this.giftPicMp4_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftPicMp4_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public ByteString getGiftPicMp4Bytes() {
            Object obj = this.giftPicMp4_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftPicMp4_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public String getGiftPicUrl() {
            Object obj = this.giftPicUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftPicUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public ByteString getGiftPicUrlBytes() {
            Object obj = this.giftPicUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftPicUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public int getGiftType() {
            return this.giftType_;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public String getResourceUrl() {
            Object obj = this.resourceUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.resourceUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
        public ByteString getResourceUrlBytes() {
            Object obj = this.resourceUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.resourceUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PKGiftOpponentExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(PKGiftOpponentExtra.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(PKGiftOpponentExtra pKGiftOpponentExtra) {
            if (pKGiftOpponentExtra == PKGiftOpponentExtra.getDefaultInstance()) {
                return this;
            }
            if (pKGiftOpponentExtra.getGiftId() != 0) {
                setGiftId(pKGiftOpponentExtra.getGiftId());
            }
            if (!pKGiftOpponentExtra.getGiftName().isEmpty()) {
                this.giftName_ = pKGiftOpponentExtra.giftName_;
                onChanged();
            }
            if (pKGiftOpponentExtra.getGiftType() != 0) {
                setGiftType(pKGiftOpponentExtra.getGiftType());
            }
            if (!pKGiftOpponentExtra.getGiftPicUrl().isEmpty()) {
                this.giftPicUrl_ = pKGiftOpponentExtra.giftPicUrl_;
                onChanged();
            }
            if (!pKGiftOpponentExtra.getGiftPicGif().isEmpty()) {
                this.giftPicGif_ = pKGiftOpponentExtra.giftPicGif_;
                onChanged();
            }
            if (!pKGiftOpponentExtra.getGiftPicApng().isEmpty()) {
                this.giftPicApng_ = pKGiftOpponentExtra.giftPicApng_;
                onChanged();
            }
            if (!pKGiftOpponentExtra.getGiftPicMp4().isEmpty()) {
                this.giftPicMp4_ = pKGiftOpponentExtra.giftPicMp4_;
                onChanged();
            }
            if (pKGiftOpponentExtra.getAnimation() != 0) {
                setAnimation(pKGiftOpponentExtra.getAnimation());
            }
            if (!pKGiftOpponentExtra.getAnimCode().isEmpty()) {
                this.animCode_ = pKGiftOpponentExtra.animCode_;
                onChanged();
            }
            if (!pKGiftOpponentExtra.getResourceUrl().isEmpty()) {
                this.resourceUrl_ = pKGiftOpponentExtra.resourceUrl_;
                onChanged();
            }
            mergeUnknownFields(pKGiftOpponentExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.PKGiftOpponentExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.PKGiftOpponentExtra.access$1500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.PKGiftOpponentExtra r0 = (cn.irisgw.live.PKGiftOpponentExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.PKGiftOpponentExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.PKGiftOpponentExtra r0 = (cn.irisgw.live.PKGiftOpponentExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.PKGiftOpponentExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PKGiftOpponentExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PKGiftOpponentExtra$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof PKGiftOpponentExtra) {
                return mergeFrom((PKGiftOpponentExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setAnimCode(String str) {
            if (str != null) {
                this.animCode_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAnimCodeBytes(ByteString byteString) {
            if (byteString != null) {
                PKGiftOpponentExtra.checkByteStringIsUtf8(byteString);
                this.animCode_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAnimation(int i) {
            this.animation_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGiftId(int i) {
            this.giftId_ = i;
            onChanged();
            return this;
        }

        public Builder setGiftName(String str) {
            if (str != null) {
                this.giftName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftNameBytes(ByteString byteString) {
            if (byteString != null) {
                PKGiftOpponentExtra.checkByteStringIsUtf8(byteString);
                this.giftName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftPicApng(String str) {
            if (str != null) {
                this.giftPicApng_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftPicApngBytes(ByteString byteString) {
            if (byteString != null) {
                PKGiftOpponentExtra.checkByteStringIsUtf8(byteString);
                this.giftPicApng_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftPicGif(String str) {
            if (str != null) {
                this.giftPicGif_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftPicGifBytes(ByteString byteString) {
            if (byteString != null) {
                PKGiftOpponentExtra.checkByteStringIsUtf8(byteString);
                this.giftPicGif_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftPicMp4(String str) {
            if (str != null) {
                this.giftPicMp4_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftPicMp4Bytes(ByteString byteString) {
            if (byteString != null) {
                PKGiftOpponentExtra.checkByteStringIsUtf8(byteString);
                this.giftPicMp4_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftPicUrl(String str) {
            if (str != null) {
                this.giftPicUrl_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftPicUrlBytes(ByteString byteString) {
            if (byteString != null) {
                PKGiftOpponentExtra.checkByteStringIsUtf8(byteString);
                this.giftPicUrl_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftType(int i) {
            this.giftType_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setResourceUrl(String str) {
            if (str != null) {
                this.resourceUrl_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setResourceUrlBytes(ByteString byteString) {
            if (byteString != null) {
                PKGiftOpponentExtra.checkByteStringIsUtf8(byteString);
                this.resourceUrl_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private PKGiftOpponentExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.giftName_ = "";
        this.giftPicUrl_ = "";
        this.giftPicGif_ = "";
        this.giftPicApng_ = "";
        this.giftPicMp4_ = "";
        this.animCode_ = "";
        this.resourceUrl_ = "";
    }

    private PKGiftOpponentExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.giftId_ = codedInputStream.readUInt32();
                            continue;
                        case 18:
                            this.giftName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 24:
                            this.giftType_ = codedInputStream.readUInt32();
                            continue;
                        case 34:
                            this.giftPicUrl_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 42:
                            this.giftPicGif_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 50:
                            this.giftPicApng_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 58:
                            this.giftPicMp4_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 64:
                            this.animation_ = codedInputStream.readUInt32();
                            continue;
                        case 74:
                            this.animCode_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 82:
                            this.resourceUrl_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        default:
                            if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                break;
                            } else {
                                continue;
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

    private PKGiftOpponentExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PKGiftOpponentExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_PKGiftOpponentExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(PKGiftOpponentExtra pKGiftOpponentExtra) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(pKGiftOpponentExtra);
    }

    public static PKGiftOpponentExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PKGiftOpponentExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PKGiftOpponentExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PKGiftOpponentExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PKGiftOpponentExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PKGiftOpponentExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PKGiftOpponentExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PKGiftOpponentExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PKGiftOpponentExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PKGiftOpponentExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PKGiftOpponentExtra parseFrom(InputStream inputStream) throws IOException {
        return (PKGiftOpponentExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PKGiftOpponentExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PKGiftOpponentExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PKGiftOpponentExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PKGiftOpponentExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PKGiftOpponentExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PKGiftOpponentExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<PKGiftOpponentExtra> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PKGiftOpponentExtra) {
            PKGiftOpponentExtra pKGiftOpponentExtra = (PKGiftOpponentExtra) obj;
            return getGiftId() == pKGiftOpponentExtra.getGiftId() && getGiftName().equals(pKGiftOpponentExtra.getGiftName()) && getGiftType() == pKGiftOpponentExtra.getGiftType() && getGiftPicUrl().equals(pKGiftOpponentExtra.getGiftPicUrl()) && getGiftPicGif().equals(pKGiftOpponentExtra.getGiftPicGif()) && getGiftPicApng().equals(pKGiftOpponentExtra.getGiftPicApng()) && getGiftPicMp4().equals(pKGiftOpponentExtra.getGiftPicMp4()) && getAnimation() == pKGiftOpponentExtra.getAnimation() && getAnimCode().equals(pKGiftOpponentExtra.getAnimCode()) && getResourceUrl().equals(pKGiftOpponentExtra.getResourceUrl()) && this.unknownFields.equals(pKGiftOpponentExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public String getAnimCode() {
        Object obj = this.animCode_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.animCode_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public ByteString getAnimCodeBytes() {
        Object obj = this.animCode_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.animCode_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public int getAnimation() {
        return this.animation_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PKGiftOpponentExtra getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public int getGiftId() {
        return this.giftId_;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public String getGiftName() {
        Object obj = this.giftName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public ByteString getGiftNameBytes() {
        Object obj = this.giftName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public String getGiftPicApng() {
        Object obj = this.giftPicApng_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftPicApng_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public ByteString getGiftPicApngBytes() {
        Object obj = this.giftPicApng_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftPicApng_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public String getGiftPicGif() {
        Object obj = this.giftPicGif_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftPicGif_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public ByteString getGiftPicGifBytes() {
        Object obj = this.giftPicGif_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftPicGif_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public String getGiftPicMp4() {
        Object obj = this.giftPicMp4_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftPicMp4_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public ByteString getGiftPicMp4Bytes() {
        Object obj = this.giftPicMp4_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftPicMp4_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public String getGiftPicUrl() {
        Object obj = this.giftPicUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftPicUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public ByteString getGiftPicUrlBytes() {
        Object obj = this.giftPicUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftPicUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public int getGiftType() {
        return this.giftType_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PKGiftOpponentExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public String getResourceUrl() {
        Object obj = this.resourceUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.resourceUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.PKGiftOpponentExtraOrBuilder
    public ByteString getResourceUrlBytes() {
        Object obj = this.resourceUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.resourceUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.giftId_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = i2;
        if (!getGiftNameBytes().isEmpty()) {
            i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.giftName_);
        }
        int i5 = this.giftType_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeUInt32Size(3, i5);
        }
        int i7 = i6;
        if (!getGiftPicUrlBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(4, this.giftPicUrl_);
        }
        int i8 = i7;
        if (!getGiftPicGifBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(5, this.giftPicGif_);
        }
        int i9 = i8;
        if (!getGiftPicApngBytes().isEmpty()) {
            i9 = i8 + GeneratedMessageV3.computeStringSize(6, this.giftPicApng_);
        }
        int i10 = i9;
        if (!getGiftPicMp4Bytes().isEmpty()) {
            i10 = i9 + GeneratedMessageV3.computeStringSize(7, this.giftPicMp4_);
        }
        int i11 = this.animation_;
        int i12 = i10;
        if (i11 != 0) {
            i12 = i10 + CodedOutputStream.computeUInt32Size(8, i11);
        }
        int i13 = i12;
        if (!getAnimCodeBytes().isEmpty()) {
            i13 = i12 + GeneratedMessageV3.computeStringSize(9, this.animCode_);
        }
        int i14 = i13;
        if (!getResourceUrlBytes().isEmpty()) {
            i14 = i13 + GeneratedMessageV3.computeStringSize(10, this.resourceUrl_);
        }
        int serializedSize = i14 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getGiftId()) * 37) + 2) * 53) + getGiftName().hashCode()) * 37) + 3) * 53) + getGiftType()) * 37) + 4) * 53) + getGiftPicUrl().hashCode()) * 37) + 5) * 53) + getGiftPicGif().hashCode()) * 37) + 6) * 53) + getGiftPicApng().hashCode()) * 37) + 7) * 53) + getGiftPicMp4().hashCode()) * 37) + 8) * 53) + getAnimation()) * 37) + 9) * 53) + getAnimCode().hashCode()) * 37) + 10) * 53) + getResourceUrl().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_PKGiftOpponentExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(PKGiftOpponentExtra.class, Builder.class);
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
        return new PKGiftOpponentExtra();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.giftId_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        if (!getGiftNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.giftName_);
        }
        int i2 = this.giftType_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(3, i2);
        }
        if (!getGiftPicUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.giftPicUrl_);
        }
        if (!getGiftPicGifBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.giftPicGif_);
        }
        if (!getGiftPicApngBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.giftPicApng_);
        }
        if (!getGiftPicMp4Bytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.giftPicMp4_);
        }
        int i3 = this.animation_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(8, i3);
        }
        if (!getAnimCodeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.animCode_);
        }
        if (!getResourceUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 10, this.resourceUrl_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
