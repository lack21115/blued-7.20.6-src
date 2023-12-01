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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/WishingContest.class */
public final class WishingContest extends GeneratedMessageV3 implements WishingContestOrBuilder {
    public static final int COUNTDOWN_FIELD_NUMBER = 6;
    public static final int GOODS_COUNT_FIELD_NUMBER = 5;
    public static final int GOODS_ICON_FIELD_NUMBER = 4;
    public static final int GOODS_ID_FIELD_NUMBER = 2;
    public static final int GOODS_NAME_FIELD_NUMBER = 3;
    public static final int HTML_HREF_FIELD_NUMBER = 9;
    public static final int HTML_MSG_FIELD_NUMBER = 8;
    public static final int PUSH_MILLISECOND_FIELD_NUMBER = 11;
    public static final int PUSH_TIME_FIELD_NUMBER = 10;
    public static final int STATUS_FIELD_NUMBER = 1;
    public static final int TOOLS_TITLE_FIELD_NUMBER = 12;
    public static final int URL_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private int countdown_;
    private int goodsCount_;
    private volatile Object goodsIcon_;
    private int goodsId_;
    private volatile Object goodsName_;
    private volatile Object htmlHref_;
    private volatile Object htmlMsg_;
    private byte memoizedIsInitialized;
    private long pushMillisecond_;
    private int pushTime_;
    private int status_;
    private volatile Object toolsTitle_;
    private volatile Object url_;
    private static final WishingContest DEFAULT_INSTANCE = new WishingContest();
    private static final Parser<WishingContest> PARSER = new AbstractParser<WishingContest>() { // from class: cn.irisgw.live.WishingContest.1
        /* renamed from: parsePartialFrom */
        public WishingContest m8215parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new WishingContest(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/WishingContest$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WishingContestOrBuilder {
        private int countdown_;
        private int goodsCount_;
        private Object goodsIcon_;
        private int goodsId_;
        private Object goodsName_;
        private Object htmlHref_;
        private Object htmlMsg_;
        private long pushMillisecond_;
        private int pushTime_;
        private int status_;
        private Object toolsTitle_;
        private Object url_;

        private Builder() {
            this.goodsName_ = "";
            this.goodsIcon_ = "";
            this.url_ = "";
            this.htmlMsg_ = "";
            this.htmlHref_ = "";
            this.toolsTitle_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.goodsName_ = "";
            this.goodsIcon_ = "";
            this.url_ = "";
            this.htmlMsg_ = "";
            this.htmlHref_ = "";
            this.toolsTitle_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_WishingContest_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = WishingContest.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m8217addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public WishingContest m8219build() {
            WishingContest m8221buildPartial = m8221buildPartial();
            if (m8221buildPartial.isInitialized()) {
                return m8221buildPartial;
            }
            throw newUninitializedMessageException(m8221buildPartial);
        }

        /* renamed from: buildPartial */
        public WishingContest m8221buildPartial() {
            WishingContest wishingContest = new WishingContest(this);
            wishingContest.status_ = this.status_;
            wishingContest.goodsId_ = this.goodsId_;
            wishingContest.goodsName_ = this.goodsName_;
            wishingContest.goodsIcon_ = this.goodsIcon_;
            wishingContest.goodsCount_ = this.goodsCount_;
            wishingContest.countdown_ = this.countdown_;
            wishingContest.url_ = this.url_;
            wishingContest.htmlMsg_ = this.htmlMsg_;
            wishingContest.htmlHref_ = this.htmlHref_;
            wishingContest.pushTime_ = this.pushTime_;
            wishingContest.pushMillisecond_ = this.pushMillisecond_;
            wishingContest.toolsTitle_ = this.toolsTitle_;
            onBuilt();
            return wishingContest;
        }

        /* renamed from: clear */
        public Builder m8225clear() {
            super.clear();
            this.status_ = 0;
            this.goodsId_ = 0;
            this.goodsName_ = "";
            this.goodsIcon_ = "";
            this.goodsCount_ = 0;
            this.countdown_ = 0;
            this.url_ = "";
            this.htmlMsg_ = "";
            this.htmlHref_ = "";
            this.pushTime_ = 0;
            this.pushMillisecond_ = WishingContest.serialVersionUID;
            this.toolsTitle_ = "";
            return this;
        }

        public Builder clearCountdown() {
            this.countdown_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m8227clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGoodsCount() {
            this.goodsCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearGoodsIcon() {
            this.goodsIcon_ = WishingContest.getDefaultInstance().getGoodsIcon();
            onChanged();
            return this;
        }

        public Builder clearGoodsId() {
            this.goodsId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearGoodsName() {
            this.goodsName_ = WishingContest.getDefaultInstance().getGoodsName();
            onChanged();
            return this;
        }

        public Builder clearHtmlHref() {
            this.htmlHref_ = WishingContest.getDefaultInstance().getHtmlHref();
            onChanged();
            return this;
        }

        public Builder clearHtmlMsg() {
            this.htmlMsg_ = WishingContest.getDefaultInstance().getHtmlMsg();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m8230clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPushMillisecond() {
            this.pushMillisecond_ = WishingContest.serialVersionUID;
            onChanged();
            return this;
        }

        public Builder clearPushTime() {
            this.pushTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearStatus() {
            this.status_ = 0;
            onChanged();
            return this;
        }

        public Builder clearToolsTitle() {
            this.toolsTitle_ = WishingContest.getDefaultInstance().getToolsTitle();
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = WishingContest.getDefaultInstance().getUrl();
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m8236clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public int getCountdown() {
            return this.countdown_;
        }

        /* renamed from: getDefaultInstanceForType */
        public WishingContest m8238getDefaultInstanceForType() {
            return WishingContest.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_WishingContest_descriptor;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public int getGoodsCount() {
            return this.goodsCount_;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public String getGoodsIcon() {
            Object obj = this.goodsIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public ByteString getGoodsIconBytes() {
            Object obj = this.goodsIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public int getGoodsId() {
            return this.goodsId_;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public String getGoodsName() {
            Object obj = this.goodsName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public ByteString getGoodsNameBytes() {
            Object obj = this.goodsName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public String getHtmlHref() {
            Object obj = this.htmlHref_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.htmlHref_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public ByteString getHtmlHrefBytes() {
            Object obj = this.htmlHref_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.htmlHref_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public String getHtmlMsg() {
            Object obj = this.htmlMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.htmlMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public ByteString getHtmlMsgBytes() {
            Object obj = this.htmlMsg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.htmlMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public long getPushMillisecond() {
            return this.pushMillisecond_;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public int getPushTime() {
            return this.pushTime_;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public int getStatus() {
            return this.status_;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public String getToolsTitle() {
            Object obj = this.toolsTitle_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.toolsTitle_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public ByteString getToolsTitleBytes() {
            Object obj = this.toolsTitle_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.toolsTitle_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingContestOrBuilder
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
            return LiveConstants.internal_static_cn_irisgw_live_WishingContest_fieldAccessorTable.ensureFieldAccessorsInitialized(WishingContest.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(WishingContest wishingContest) {
            if (wishingContest == WishingContest.getDefaultInstance()) {
                return this;
            }
            if (wishingContest.getStatus() != 0) {
                setStatus(wishingContest.getStatus());
            }
            if (wishingContest.getGoodsId() != 0) {
                setGoodsId(wishingContest.getGoodsId());
            }
            if (!wishingContest.getGoodsName().isEmpty()) {
                this.goodsName_ = wishingContest.goodsName_;
                onChanged();
            }
            if (!wishingContest.getGoodsIcon().isEmpty()) {
                this.goodsIcon_ = wishingContest.goodsIcon_;
                onChanged();
            }
            if (wishingContest.getGoodsCount() != 0) {
                setGoodsCount(wishingContest.getGoodsCount());
            }
            if (wishingContest.getCountdown() != 0) {
                setCountdown(wishingContest.getCountdown());
            }
            if (!wishingContest.getUrl().isEmpty()) {
                this.url_ = wishingContest.url_;
                onChanged();
            }
            if (!wishingContest.getHtmlMsg().isEmpty()) {
                this.htmlMsg_ = wishingContest.htmlMsg_;
                onChanged();
            }
            if (!wishingContest.getHtmlHref().isEmpty()) {
                this.htmlHref_ = wishingContest.htmlHref_;
                onChanged();
            }
            if (wishingContest.getPushTime() != 0) {
                setPushTime(wishingContest.getPushTime());
            }
            if (wishingContest.getPushMillisecond() != WishingContest.serialVersionUID) {
                setPushMillisecond(wishingContest.getPushMillisecond());
            }
            if (!wishingContest.getToolsTitle().isEmpty()) {
                this.toolsTitle_ = wishingContest.toolsTitle_;
                onChanged();
            }
            m8247mergeUnknownFields(wishingContest.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.WishingContest.Builder m8244mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.WishingContest.access$1700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.WishingContest r0 = (cn.irisgw.live.WishingContest) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.WishingContest$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.WishingContest r0 = (cn.irisgw.live.WishingContest) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.WishingContest$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.WishingContest.Builder.m8244mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.WishingContest$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m8243mergeFrom(Message message) {
            if (message instanceof WishingContest) {
                return mergeFrom((WishingContest) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m8247mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setCountdown(int i) {
            this.countdown_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m8249setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGoodsCount(int i) {
            this.goodsCount_ = i;
            onChanged();
            return this;
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
                WishingContest.checkByteStringIsUtf8(byteString);
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
                WishingContest.checkByteStringIsUtf8(byteString);
                this.goodsName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHtmlHref(String str) {
            if (str != null) {
                this.htmlHref_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHtmlHrefBytes(ByteString byteString) {
            if (byteString != null) {
                WishingContest.checkByteStringIsUtf8(byteString);
                this.htmlHref_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHtmlMsg(String str) {
            if (str != null) {
                this.htmlMsg_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHtmlMsgBytes(ByteString byteString) {
            if (byteString != null) {
                WishingContest.checkByteStringIsUtf8(byteString);
                this.htmlMsg_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPushMillisecond(long j) {
            this.pushMillisecond_ = j;
            onChanged();
            return this;
        }

        public Builder setPushTime(int i) {
            this.pushTime_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m8251setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setStatus(int i) {
            this.status_ = i;
            onChanged();
            return this;
        }

        public Builder setToolsTitle(String str) {
            if (str != null) {
                this.toolsTitle_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setToolsTitleBytes(ByteString byteString) {
            if (byteString != null) {
                WishingContest.checkByteStringIsUtf8(byteString);
                this.toolsTitle_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setUnknownFields */
        public final Builder m8253setUnknownFields(UnknownFieldSet unknownFieldSet) {
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
                WishingContest.checkByteStringIsUtf8(byteString);
                this.url_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }
    }

    private WishingContest() {
        this.memoizedIsInitialized = (byte) -1;
        this.goodsName_ = "";
        this.goodsIcon_ = "";
        this.url_ = "";
        this.htmlMsg_ = "";
        this.htmlHref_ = "";
        this.toolsTitle_ = "";
    }

    private WishingContest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.goodsId_ = codedInputStream.readUInt32();
                            continue;
                        case 26:
                            this.goodsName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 34:
                            this.goodsIcon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 40:
                            this.goodsCount_ = codedInputStream.readUInt32();
                            continue;
                        case 48:
                            this.countdown_ = codedInputStream.readUInt32();
                            continue;
                        case 58:
                            this.url_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 66:
                            this.htmlMsg_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 74:
                            this.htmlHref_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 80:
                            this.pushTime_ = codedInputStream.readUInt32();
                            continue;
                        case 88:
                            this.pushMillisecond_ = codedInputStream.readUInt64();
                            continue;
                        case 98:
                            this.toolsTitle_ = codedInputStream.readStringRequireUtf8();
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

    private WishingContest(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static WishingContest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_WishingContest_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m8214toBuilder();
    }

    public static Builder newBuilder(WishingContest wishingContest) {
        return DEFAULT_INSTANCE.m8214toBuilder().mergeFrom(wishingContest);
    }

    public static WishingContest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static WishingContest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static WishingContest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (WishingContest) PARSER.parseFrom(byteString);
    }

    public static WishingContest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WishingContest) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static WishingContest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static WishingContest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static WishingContest parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static WishingContest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static WishingContest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (WishingContest) PARSER.parseFrom(byteBuffer);
    }

    public static WishingContest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WishingContest) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static WishingContest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (WishingContest) PARSER.parseFrom(bArr);
    }

    public static WishingContest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WishingContest) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<WishingContest> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof WishingContest) {
            WishingContest wishingContest = (WishingContest) obj;
            return getStatus() == wishingContest.getStatus() && getGoodsId() == wishingContest.getGoodsId() && getGoodsName().equals(wishingContest.getGoodsName()) && getGoodsIcon().equals(wishingContest.getGoodsIcon()) && getGoodsCount() == wishingContest.getGoodsCount() && getCountdown() == wishingContest.getCountdown() && getUrl().equals(wishingContest.getUrl()) && getHtmlMsg().equals(wishingContest.getHtmlMsg()) && getHtmlHref().equals(wishingContest.getHtmlHref()) && getPushTime() == wishingContest.getPushTime() && getPushMillisecond() == wishingContest.getPushMillisecond() && getToolsTitle().equals(wishingContest.getToolsTitle()) && this.unknownFields.equals(wishingContest.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public int getCountdown() {
        return this.countdown_;
    }

    /* renamed from: getDefaultInstanceForType */
    public WishingContest m8209getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public int getGoodsCount() {
        return this.goodsCount_;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public String getGoodsIcon() {
        Object obj = this.goodsIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.goodsIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public ByteString getGoodsIconBytes() {
        Object obj = this.goodsIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goodsIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public int getGoodsId() {
        return this.goodsId_;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public String getGoodsName() {
        Object obj = this.goodsName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.goodsName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public ByteString getGoodsNameBytes() {
        Object obj = this.goodsName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goodsName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public String getHtmlHref() {
        Object obj = this.htmlHref_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.htmlHref_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public ByteString getHtmlHrefBytes() {
        Object obj = this.htmlHref_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.htmlHref_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public String getHtmlMsg() {
        Object obj = this.htmlMsg_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.htmlMsg_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public ByteString getHtmlMsgBytes() {
        Object obj = this.htmlMsg_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.htmlMsg_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<WishingContest> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public long getPushMillisecond() {
        return this.pushMillisecond_;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public int getPushTime() {
        return this.pushTime_;
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
        int i4 = this.goodsId_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int i6 = i5;
        if (!getGoodsNameBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(3, this.goodsName_);
        }
        int i7 = i6;
        if (!getGoodsIconBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(4, this.goodsIcon_);
        }
        int i8 = this.goodsCount_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(5, i8);
        }
        int i10 = this.countdown_;
        int i11 = i9;
        if (i10 != 0) {
            i11 = i9 + CodedOutputStream.computeUInt32Size(6, i10);
        }
        int i12 = i11;
        if (!getUrlBytes().isEmpty()) {
            i12 = i11 + GeneratedMessageV3.computeStringSize(7, this.url_);
        }
        int i13 = i12;
        if (!getHtmlMsgBytes().isEmpty()) {
            i13 = i12 + GeneratedMessageV3.computeStringSize(8, this.htmlMsg_);
        }
        int i14 = i13;
        if (!getHtmlHrefBytes().isEmpty()) {
            i14 = i13 + GeneratedMessageV3.computeStringSize(9, this.htmlHref_);
        }
        int i15 = this.pushTime_;
        int i16 = i14;
        if (i15 != 0) {
            i16 = i14 + CodedOutputStream.computeUInt32Size(10, i15);
        }
        long j = this.pushMillisecond_;
        int i17 = i16;
        if (j != serialVersionUID) {
            i17 = i16 + CodedOutputStream.computeUInt64Size(11, j);
        }
        int i18 = i17;
        if (!getToolsTitleBytes().isEmpty()) {
            i18 = i17 + GeneratedMessageV3.computeStringSize(12, this.toolsTitle_);
        }
        int serializedSize = i18 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public int getStatus() {
        return this.status_;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public String getToolsTitle() {
        Object obj = this.toolsTitle_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.toolsTitle_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public ByteString getToolsTitleBytes() {
        Object obj = this.toolsTitle_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.toolsTitle_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingContestOrBuilder
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getStatus()) * 37) + 2) * 53) + getGoodsId()) * 37) + 3) * 53) + getGoodsName().hashCode()) * 37) + 4) * 53) + getGoodsIcon().hashCode()) * 37) + 5) * 53) + getGoodsCount()) * 37) + 6) * 53) + getCountdown()) * 37) + 7) * 53) + getUrl().hashCode()) * 37) + 8) * 53) + getHtmlMsg().hashCode()) * 37) + 9) * 53) + getHtmlHref().hashCode()) * 37) + 10) * 53) + getPushTime()) * 37) + 11) * 53) + Internal.hashLong(getPushMillisecond())) * 37) + 12) * 53) + getToolsTitle().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_WishingContest_fieldAccessorTable.ensureFieldAccessorsInitialized(WishingContest.class, Builder.class);
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
    public Builder m8212newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m8211newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new WishingContest();
    }

    /* renamed from: toBuilder */
    public Builder m8214toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.status_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.goodsId_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        if (!getGoodsNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.goodsName_);
        }
        if (!getGoodsIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.goodsIcon_);
        }
        int i3 = this.goodsCount_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(5, i3);
        }
        int i4 = this.countdown_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(6, i4);
        }
        if (!getUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.url_);
        }
        if (!getHtmlMsgBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.htmlMsg_);
        }
        if (!getHtmlHrefBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.htmlHref_);
        }
        int i5 = this.pushTime_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(10, i5);
        }
        long j = this.pushMillisecond_;
        if (j != serialVersionUID) {
            codedOutputStream.writeUInt64(11, j);
        }
        if (!getToolsTitleBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 12, this.toolsTitle_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
