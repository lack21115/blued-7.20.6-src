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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/WishingDraw.class */
public final class WishingDraw extends GeneratedMessageV3 implements WishingDrawOrBuilder {
    public static final int COUNTDOWN_FIELD_NUMBER = 4;
    public static final int GOODS_ICON_FIELD_NUMBER = 6;
    public static final int GOODS_ID_FIELD_NUMBER = 9;
    public static final int GOODS_NAME_FIELD_NUMBER = 5;
    public static final int SCORE_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 1;
    public static final int TARGET_SCORE_FIELD_NUMBER = 3;
    public static final int TIMES_FIELD_NUMBER = 7;
    public static final int TYPE_FIELD_NUMBER = 10;
    public static final int URL_FIELD_NUMBER = 8;
    private static final long serialVersionUID = 0;
    private int countdown_;
    private volatile Object goodsIcon_;
    private int goodsId_;
    private volatile Object goodsName_;
    private byte memoizedIsInitialized;
    private int score_;
    private int status_;
    private int targetScore_;
    private float times_;
    private int type_;
    private volatile Object url_;
    private static final WishingDraw DEFAULT_INSTANCE = new WishingDraw();
    private static final Parser<WishingDraw> PARSER = new AbstractParser<WishingDraw>() { // from class: cn.irisgw.live.WishingDraw.1
        /* renamed from: parsePartialFrom */
        public WishingDraw m8311parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new WishingDraw(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/WishingDraw$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WishingDrawOrBuilder {
        private int countdown_;
        private Object goodsIcon_;
        private int goodsId_;
        private Object goodsName_;
        private int score_;
        private int status_;
        private int targetScore_;
        private float times_;
        private int type_;
        private Object url_;

        private Builder() {
            this.goodsName_ = "";
            this.goodsIcon_ = "";
            this.url_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.goodsName_ = "";
            this.goodsIcon_ = "";
            this.url_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_WishingDraw_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = WishingDraw.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m8313addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public WishingDraw m8315build() {
            WishingDraw m8317buildPartial = m8317buildPartial();
            if (m8317buildPartial.isInitialized()) {
                return m8317buildPartial;
            }
            throw newUninitializedMessageException(m8317buildPartial);
        }

        /* renamed from: buildPartial */
        public WishingDraw m8317buildPartial() {
            WishingDraw wishingDraw = new WishingDraw(this);
            wishingDraw.status_ = this.status_;
            wishingDraw.score_ = this.score_;
            wishingDraw.targetScore_ = this.targetScore_;
            wishingDraw.countdown_ = this.countdown_;
            wishingDraw.goodsName_ = this.goodsName_;
            wishingDraw.goodsIcon_ = this.goodsIcon_;
            wishingDraw.times_ = this.times_;
            wishingDraw.url_ = this.url_;
            wishingDraw.goodsId_ = this.goodsId_;
            wishingDraw.type_ = this.type_;
            onBuilt();
            return wishingDraw;
        }

        /* renamed from: clear */
        public Builder m8321clear() {
            super.clear();
            this.status_ = 0;
            this.score_ = 0;
            this.targetScore_ = 0;
            this.countdown_ = 0;
            this.goodsName_ = "";
            this.goodsIcon_ = "";
            this.times_ = 0.0f;
            this.url_ = "";
            this.goodsId_ = 0;
            this.type_ = 0;
            return this;
        }

        public Builder clearCountdown() {
            this.countdown_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m8323clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGoodsIcon() {
            this.goodsIcon_ = WishingDraw.getDefaultInstance().getGoodsIcon();
            onChanged();
            return this;
        }

        public Builder clearGoodsId() {
            this.goodsId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearGoodsName() {
            this.goodsName_ = WishingDraw.getDefaultInstance().getGoodsName();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m8326clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearScore() {
            this.score_ = 0;
            onChanged();
            return this;
        }

        public Builder clearStatus() {
            this.status_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTargetScore() {
            this.targetScore_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTimes() {
            this.times_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = WishingDraw.getDefaultInstance().getUrl();
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m8332clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.WishingDrawOrBuilder
        public int getCountdown() {
            return this.countdown_;
        }

        /* renamed from: getDefaultInstanceForType */
        public WishingDraw m8334getDefaultInstanceForType() {
            return WishingDraw.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_WishingDraw_descriptor;
        }

        @Override // cn.irisgw.live.WishingDrawOrBuilder
        public String getGoodsIcon() {
            Object obj = this.goodsIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingDrawOrBuilder
        public ByteString getGoodsIconBytes() {
            Object obj = this.goodsIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WishingDrawOrBuilder
        public int getGoodsId() {
            return this.goodsId_;
        }

        @Override // cn.irisgw.live.WishingDrawOrBuilder
        public String getGoodsName() {
            Object obj = this.goodsName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingDrawOrBuilder
        public ByteString getGoodsNameBytes() {
            Object obj = this.goodsName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WishingDrawOrBuilder
        public int getScore() {
            return this.score_;
        }

        @Override // cn.irisgw.live.WishingDrawOrBuilder
        public int getStatus() {
            return this.status_;
        }

        @Override // cn.irisgw.live.WishingDrawOrBuilder
        public int getTargetScore() {
            return this.targetScore_;
        }

        @Override // cn.irisgw.live.WishingDrawOrBuilder
        public float getTimes() {
            return this.times_;
        }

        @Override // cn.irisgw.live.WishingDrawOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // cn.irisgw.live.WishingDrawOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingDrawOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_WishingDraw_fieldAccessorTable.ensureFieldAccessorsInitialized(WishingDraw.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(WishingDraw wishingDraw) {
            if (wishingDraw == WishingDraw.getDefaultInstance()) {
                return this;
            }
            if (wishingDraw.getStatus() != 0) {
                setStatus(wishingDraw.getStatus());
            }
            if (wishingDraw.getScore() != 0) {
                setScore(wishingDraw.getScore());
            }
            if (wishingDraw.getTargetScore() != 0) {
                setTargetScore(wishingDraw.getTargetScore());
            }
            if (wishingDraw.getCountdown() != 0) {
                setCountdown(wishingDraw.getCountdown());
            }
            if (!wishingDraw.getGoodsName().isEmpty()) {
                this.goodsName_ = wishingDraw.goodsName_;
                onChanged();
            }
            if (!wishingDraw.getGoodsIcon().isEmpty()) {
                this.goodsIcon_ = wishingDraw.goodsIcon_;
                onChanged();
            }
            if (wishingDraw.getTimes() != 0.0f) {
                setTimes(wishingDraw.getTimes());
            }
            if (!wishingDraw.getUrl().isEmpty()) {
                this.url_ = wishingDraw.url_;
                onChanged();
            }
            if (wishingDraw.getGoodsId() != 0) {
                setGoodsId(wishingDraw.getGoodsId());
            }
            if (wishingDraw.getType() != 0) {
                setType(wishingDraw.getType());
            }
            m8343mergeUnknownFields(wishingDraw.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.WishingDraw.Builder m8340mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.WishingDraw.access$1500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.WishingDraw r0 = (cn.irisgw.live.WishingDraw) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.WishingDraw$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.WishingDraw r0 = (cn.irisgw.live.WishingDraw) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.WishingDraw$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.WishingDraw.Builder.m8340mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.WishingDraw$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m8339mergeFrom(Message message) {
            if (message instanceof WishingDraw) {
                return mergeFrom((WishingDraw) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m8343mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setCountdown(int i) {
            this.countdown_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m8345setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGoodsIcon(String str) {
            if (str != null) {
                this.goodsIcon_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGoodsIconBytes(ByteString byteString) {
            if (byteString != null) {
                WishingDraw.checkByteStringIsUtf8(byteString);
                this.goodsIcon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGoodsId(int i) {
            this.goodsId_ = i;
            onChanged();
            return this;
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
                WishingDraw.checkByteStringIsUtf8(byteString);
                this.goodsName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setRepeatedField */
        public Builder m8347setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setScore(int i) {
            this.score_ = i;
            onChanged();
            return this;
        }

        public Builder setStatus(int i) {
            this.status_ = i;
            onChanged();
            return this;
        }

        public Builder setTargetScore(int i) {
            this.targetScore_ = i;
            onChanged();
            return this;
        }

        public Builder setTimes(float f) {
            this.times_ = f;
            onChanged();
            return this;
        }

        public Builder setType(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m8349setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setUrl(String str) {
            if (str != null) {
                this.url_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setUrlBytes(ByteString byteString) {
            if (byteString != null) {
                WishingDraw.checkByteStringIsUtf8(byteString);
                this.url_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }
    }

    private WishingDraw() {
        this.memoizedIsInitialized = (byte) -1;
        this.goodsName_ = "";
        this.goodsIcon_ = "";
        this.url_ = "";
    }

    private WishingDraw(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.status_ = codedInputStream.readUInt32();
                            continue;
                        case 16:
                            this.score_ = codedInputStream.readUInt32();
                            continue;
                        case 24:
                            this.targetScore_ = codedInputStream.readUInt32();
                            continue;
                        case 32:
                            this.countdown_ = codedInputStream.readUInt32();
                            continue;
                        case 42:
                            this.goodsName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 50:
                            this.goodsIcon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 61:
                            this.times_ = codedInputStream.readFloat();
                            continue;
                        case 66:
                            this.url_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 72:
                            this.goodsId_ = codedInputStream.readUInt32();
                            continue;
                        case 80:
                            this.type_ = codedInputStream.readInt32();
                            continue;
                        default:
                            if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                break;
                            } else {
                                continue;
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

    private WishingDraw(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static WishingDraw getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_WishingDraw_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m8310toBuilder();
    }

    public static Builder newBuilder(WishingDraw wishingDraw) {
        return DEFAULT_INSTANCE.m8310toBuilder().mergeFrom(wishingDraw);
    }

    public static WishingDraw parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static WishingDraw parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static WishingDraw parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (WishingDraw) PARSER.parseFrom(byteString);
    }

    public static WishingDraw parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WishingDraw) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static WishingDraw parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static WishingDraw parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static WishingDraw parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static WishingDraw parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static WishingDraw parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (WishingDraw) PARSER.parseFrom(byteBuffer);
    }

    public static WishingDraw parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WishingDraw) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static WishingDraw parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (WishingDraw) PARSER.parseFrom(bArr);
    }

    public static WishingDraw parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WishingDraw) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<WishingDraw> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof WishingDraw) {
            WishingDraw wishingDraw = (WishingDraw) obj;
            return getStatus() == wishingDraw.getStatus() && getScore() == wishingDraw.getScore() && getTargetScore() == wishingDraw.getTargetScore() && getCountdown() == wishingDraw.getCountdown() && getGoodsName().equals(wishingDraw.getGoodsName()) && getGoodsIcon().equals(wishingDraw.getGoodsIcon()) && Float.floatToIntBits(getTimes()) == Float.floatToIntBits(wishingDraw.getTimes()) && getUrl().equals(wishingDraw.getUrl()) && getGoodsId() == wishingDraw.getGoodsId() && getType() == wishingDraw.getType() && this.unknownFields.equals(wishingDraw.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.WishingDrawOrBuilder
    public int getCountdown() {
        return this.countdown_;
    }

    /* renamed from: getDefaultInstanceForType */
    public WishingDraw m8305getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.WishingDrawOrBuilder
    public String getGoodsIcon() {
        Object obj = this.goodsIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.goodsIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingDrawOrBuilder
    public ByteString getGoodsIconBytes() {
        Object obj = this.goodsIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goodsIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.WishingDrawOrBuilder
    public int getGoodsId() {
        return this.goodsId_;
    }

    @Override // cn.irisgw.live.WishingDrawOrBuilder
    public String getGoodsName() {
        Object obj = this.goodsName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.goodsName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingDrawOrBuilder
    public ByteString getGoodsNameBytes() {
        Object obj = this.goodsName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goodsName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<WishingDraw> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.WishingDrawOrBuilder
    public int getScore() {
        return this.score_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.status_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = this.score_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int i6 = this.targetScore_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeUInt32Size(3, i6);
        }
        int i8 = this.countdown_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(4, i8);
        }
        int i10 = i9;
        if (!getGoodsNameBytes().isEmpty()) {
            i10 = i9 + GeneratedMessageV3.computeStringSize(5, this.goodsName_);
        }
        int i11 = i10;
        if (!getGoodsIconBytes().isEmpty()) {
            i11 = i10 + GeneratedMessageV3.computeStringSize(6, this.goodsIcon_);
        }
        float f = this.times_;
        int i12 = i11;
        if (f != 0.0f) {
            i12 = i11 + CodedOutputStream.computeFloatSize(7, f);
        }
        int i13 = i12;
        if (!getUrlBytes().isEmpty()) {
            i13 = i12 + GeneratedMessageV3.computeStringSize(8, this.url_);
        }
        int i14 = this.goodsId_;
        int i15 = i13;
        if (i14 != 0) {
            i15 = i13 + CodedOutputStream.computeUInt32Size(9, i14);
        }
        int i16 = this.type_;
        int i17 = i15;
        if (i16 != 0) {
            i17 = i15 + CodedOutputStream.computeInt32Size(10, i16);
        }
        int serializedSize = i17 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.WishingDrawOrBuilder
    public int getStatus() {
        return this.status_;
    }

    @Override // cn.irisgw.live.WishingDrawOrBuilder
    public int getTargetScore() {
        return this.targetScore_;
    }

    @Override // cn.irisgw.live.WishingDrawOrBuilder
    public float getTimes() {
        return this.times_;
    }

    @Override // cn.irisgw.live.WishingDrawOrBuilder
    public int getType() {
        return this.type_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.WishingDrawOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingDrawOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getStatus()) * 37) + 2) * 53) + getScore()) * 37) + 3) * 53) + getTargetScore()) * 37) + 4) * 53) + getCountdown()) * 37) + 5) * 53) + getGoodsName().hashCode()) * 37) + 6) * 53) + getGoodsIcon().hashCode()) * 37) + 7) * 53) + Float.floatToIntBits(getTimes())) * 37) + 8) * 53) + getUrl().hashCode()) * 37) + 9) * 53) + getGoodsId()) * 37) + 10) * 53) + getType()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_WishingDraw_fieldAccessorTable.ensureFieldAccessorsInitialized(WishingDraw.class, Builder.class);
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
    public Builder m8308newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m8307newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new WishingDraw();
    }

    /* renamed from: toBuilder */
    public Builder m8310toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.status_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.score_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        int i3 = this.targetScore_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(3, i3);
        }
        int i4 = this.countdown_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(4, i4);
        }
        if (!getGoodsNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.goodsName_);
        }
        if (!getGoodsIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.goodsIcon_);
        }
        float f = this.times_;
        if (f != 0.0f) {
            codedOutputStream.writeFloat(7, f);
        }
        if (!getUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.url_);
        }
        int i5 = this.goodsId_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(9, i5);
        }
        int i6 = this.type_;
        if (i6 != 0) {
            codedOutputStream.writeInt32(10, i6);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
