package cn.irisgw.live;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/WinningPrize.class */
public final class WinningPrize extends GeneratedMessageV3 implements WinningPrizeOrBuilder {
    public static final int CHAT_FRAME_BORDER_COLOR_FIELD_NUMBER = 10;
    public static final int CHAT_FRAME_FRAME_COLOR_FIELD_NUMBER = 9;
    public static final int CHAT_FRAME_ICON_FIELD_NUMBER = 8;
    public static final int COUNT_FIELD_NUMBER = 1;
    public static final int EVENT_FIELD_NUMBER = 7;
    public static final int GOODS_ICON_FIELD_NUMBER = 4;
    public static final int GOODS_ID_FIELD_NUMBER = 2;
    public static final int GOODS_NAME_FIELD_NUMBER = 3;
    public static final int SOURCE_FIELD_NUMBER = 6;
    public static final int UID_FIELD_NUMBER = 11;
    public static final int USER_NAME_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private LazyStringList chatFrameBorderColor_;
    private LazyStringList chatFrameFrameColor_;
    private volatile Object chatFrameIcon_;
    private int count_;
    private volatile Object event_;
    private volatile Object goodsIcon_;
    private int goodsId_;
    private volatile Object goodsName_;
    private byte memoizedIsInitialized;
    private volatile Object source_;
    private int uid_;
    private volatile Object userName_;
    private static final WinningPrize DEFAULT_INSTANCE = new WinningPrize();
    private static final Parser<WinningPrize> PARSER = new AbstractParser<WinningPrize>() { // from class: cn.irisgw.live.WinningPrize.1
        /* renamed from: parsePartialFrom */
        public WinningPrize m8168parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new WinningPrize(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/WinningPrize$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WinningPrizeOrBuilder {
        private int bitField0_;
        private LazyStringList chatFrameBorderColor_;
        private LazyStringList chatFrameFrameColor_;
        private Object chatFrameIcon_;
        private int count_;
        private Object event_;
        private Object goodsIcon_;
        private int goodsId_;
        private Object goodsName_;
        private Object source_;
        private int uid_;
        private Object userName_;

        private Builder() {
            this.goodsName_ = "";
            this.goodsIcon_ = "";
            this.userName_ = "";
            this.source_ = "";
            this.event_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.goodsName_ = "";
            this.goodsIcon_ = "";
            this.userName_ = "";
            this.source_ = "";
            this.event_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void ensureChatFrameBorderColorIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.chatFrameBorderColor_ = new LazyStringArrayList(this.chatFrameBorderColor_);
                this.bitField0_ |= 2;
            }
        }

        private void ensureChatFrameFrameColorIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.chatFrameFrameColor_ = new LazyStringArrayList(this.chatFrameFrameColor_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_WinningPrize_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = WinningPrize.alwaysUseFieldBuilders;
        }

        public Builder addAllChatFrameBorderColor(Iterable<String> iterable) {
            ensureChatFrameBorderColorIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.chatFrameBorderColor_);
            onChanged();
            return this;
        }

        public Builder addAllChatFrameFrameColor(Iterable<String> iterable) {
            ensureChatFrameFrameColorIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.chatFrameFrameColor_);
            onChanged();
            return this;
        }

        public Builder addChatFrameBorderColor(String str) {
            if (str != null) {
                ensureChatFrameBorderColorIsMutable();
                this.chatFrameBorderColor_.add(str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addChatFrameBorderColorBytes(ByteString byteString) {
            if (byteString != null) {
                WinningPrize.checkByteStringIsUtf8(byteString);
                ensureChatFrameBorderColorIsMutable();
                this.chatFrameBorderColor_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addChatFrameFrameColor(String str) {
            if (str != null) {
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.add(str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addChatFrameFrameColorBytes(ByteString byteString) {
            if (byteString != null) {
                WinningPrize.checkByteStringIsUtf8(byteString);
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: addRepeatedField */
        public Builder m8170addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public WinningPrize m8172build() {
            WinningPrize m8174buildPartial = m8174buildPartial();
            if (m8174buildPartial.isInitialized()) {
                return m8174buildPartial;
            }
            throw newUninitializedMessageException(m8174buildPartial);
        }

        /* renamed from: buildPartial */
        public WinningPrize m8174buildPartial() {
            WinningPrize winningPrize = new WinningPrize(this);
            winningPrize.count_ = this.count_;
            winningPrize.goodsId_ = this.goodsId_;
            winningPrize.goodsName_ = this.goodsName_;
            winningPrize.goodsIcon_ = this.goodsIcon_;
            winningPrize.userName_ = this.userName_;
            winningPrize.source_ = this.source_;
            winningPrize.event_ = this.event_;
            winningPrize.chatFrameIcon_ = this.chatFrameIcon_;
            if ((this.bitField0_ & 1) != 0) {
                this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            winningPrize.chatFrameFrameColor_ = this.chatFrameFrameColor_;
            if ((this.bitField0_ & 2) != 0) {
                this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            winningPrize.chatFrameBorderColor_ = this.chatFrameBorderColor_;
            winningPrize.uid_ = this.uid_;
            onBuilt();
            return winningPrize;
        }

        /* renamed from: clear */
        public Builder m8178clear() {
            super.clear();
            this.count_ = 0;
            this.goodsId_ = 0;
            this.goodsName_ = "";
            this.goodsIcon_ = "";
            this.userName_ = "";
            this.source_ = "";
            this.event_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            this.uid_ = 0;
            return this;
        }

        public Builder clearChatFrameBorderColor() {
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearChatFrameFrameColor() {
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearChatFrameIcon() {
            this.chatFrameIcon_ = WinningPrize.getDefaultInstance().getChatFrameIcon();
            onChanged();
            return this;
        }

        public Builder clearCount() {
            this.count_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEvent() {
            this.event_ = WinningPrize.getDefaultInstance().getEvent();
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m8180clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGoodsIcon() {
            this.goodsIcon_ = WinningPrize.getDefaultInstance().getGoodsIcon();
            onChanged();
            return this;
        }

        public Builder clearGoodsId() {
            this.goodsId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearGoodsName() {
            this.goodsName_ = WinningPrize.getDefaultInstance().getGoodsName();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m8183clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearSource() {
            this.source_ = WinningPrize.getDefaultInstance().getSource();
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUserName() {
            this.userName_ = WinningPrize.getDefaultInstance().getUserName();
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m8189clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public String getChatFrameBorderColor(int i) {
            return (String) this.chatFrameBorderColor_.get(i);
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public ByteString getChatFrameBorderColorBytes(int i) {
            return this.chatFrameBorderColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public int getChatFrameBorderColorCount() {
            return this.chatFrameBorderColor_.size();
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        /* renamed from: getChatFrameBorderColorList */
        public ProtocolStringList mo8159getChatFrameBorderColorList() {
            return this.chatFrameBorderColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public String getChatFrameFrameColor(int i) {
            return (String) this.chatFrameFrameColor_.get(i);
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public ByteString getChatFrameFrameColorBytes(int i) {
            return this.chatFrameFrameColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public int getChatFrameFrameColorCount() {
            return this.chatFrameFrameColor_.size();
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        /* renamed from: getChatFrameFrameColorList */
        public ProtocolStringList mo8160getChatFrameFrameColorList() {
            return this.chatFrameFrameColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public String getChatFrameIcon() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrameIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public ByteString getChatFrameIconBytes() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrameIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public int getCount() {
            return this.count_;
        }

        /* renamed from: getDefaultInstanceForType */
        public WinningPrize m8191getDefaultInstanceForType() {
            return WinningPrize.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_WinningPrize_descriptor;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public String getEvent() {
            Object obj = this.event_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.event_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public ByteString getEventBytes() {
            Object obj = this.event_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.event_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public String getGoodsIcon() {
            Object obj = this.goodsIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public ByteString getGoodsIconBytes() {
            Object obj = this.goodsIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public int getGoodsId() {
            return this.goodsId_;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public String getGoodsName() {
            Object obj = this.goodsName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public ByteString getGoodsNameBytes() {
            Object obj = this.goodsName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public String getSource() {
            Object obj = this.source_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.source_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public ByteString getSourceBytes() {
            Object obj = this.source_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.source_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public String getUserName() {
            Object obj = this.userName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.userName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WinningPrizeOrBuilder
        public ByteString getUserNameBytes() {
            Object obj = this.userName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_WinningPrize_fieldAccessorTable.ensureFieldAccessorsInitialized(WinningPrize.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(WinningPrize winningPrize) {
            if (winningPrize == WinningPrize.getDefaultInstance()) {
                return this;
            }
            if (winningPrize.getCount() != 0) {
                setCount(winningPrize.getCount());
            }
            if (winningPrize.getGoodsId() != 0) {
                setGoodsId(winningPrize.getGoodsId());
            }
            if (!winningPrize.getGoodsName().isEmpty()) {
                this.goodsName_ = winningPrize.goodsName_;
                onChanged();
            }
            if (!winningPrize.getGoodsIcon().isEmpty()) {
                this.goodsIcon_ = winningPrize.goodsIcon_;
                onChanged();
            }
            if (!winningPrize.getUserName().isEmpty()) {
                this.userName_ = winningPrize.userName_;
                onChanged();
            }
            if (!winningPrize.getSource().isEmpty()) {
                this.source_ = winningPrize.source_;
                onChanged();
            }
            if (!winningPrize.getEvent().isEmpty()) {
                this.event_ = winningPrize.event_;
                onChanged();
            }
            if (!winningPrize.getChatFrameIcon().isEmpty()) {
                this.chatFrameIcon_ = winningPrize.chatFrameIcon_;
                onChanged();
            }
            if (!winningPrize.chatFrameFrameColor_.isEmpty()) {
                if (this.chatFrameFrameColor_.isEmpty()) {
                    this.chatFrameFrameColor_ = winningPrize.chatFrameFrameColor_;
                    this.bitField0_ &= -2;
                } else {
                    ensureChatFrameFrameColorIsMutable();
                    this.chatFrameFrameColor_.addAll(winningPrize.chatFrameFrameColor_);
                }
                onChanged();
            }
            if (!winningPrize.chatFrameBorderColor_.isEmpty()) {
                if (this.chatFrameBorderColor_.isEmpty()) {
                    this.chatFrameBorderColor_ = winningPrize.chatFrameBorderColor_;
                    this.bitField0_ &= -3;
                } else {
                    ensureChatFrameBorderColorIsMutable();
                    this.chatFrameBorderColor_.addAll(winningPrize.chatFrameBorderColor_);
                }
                onChanged();
            }
            if (winningPrize.getUid() != 0) {
                setUid(winningPrize.getUid());
            }
            m8200mergeUnknownFields(winningPrize.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.WinningPrize.Builder m8197mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.WinningPrize.access$1600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.WinningPrize r0 = (cn.irisgw.live.WinningPrize) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.WinningPrize$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.WinningPrize r0 = (cn.irisgw.live.WinningPrize) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.WinningPrize$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.WinningPrize.Builder.m8197mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.WinningPrize$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m8196mergeFrom(Message message) {
            if (message instanceof WinningPrize) {
                return mergeFrom((WinningPrize) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m8200mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setChatFrameBorderColor(int i, String str) {
            if (str != null) {
                ensureChatFrameBorderColorIsMutable();
                this.chatFrameBorderColor_.set(i, str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrameFrameColor(int i, String str) {
            if (str != null) {
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.set(i, str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrameIcon(String str) {
            if (str != null) {
                this.chatFrameIcon_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrameIconBytes(ByteString byteString) {
            if (byteString != null) {
                WinningPrize.checkByteStringIsUtf8(byteString);
                this.chatFrameIcon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setCount(int i) {
            this.count_ = i;
            onChanged();
            return this;
        }

        public Builder setEvent(String str) {
            if (str != null) {
                this.event_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setEventBytes(ByteString byteString) {
            if (byteString != null) {
                WinningPrize.checkByteStringIsUtf8(byteString);
                this.event_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setField */
        public Builder m8202setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
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
                WinningPrize.checkByteStringIsUtf8(byteString);
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
                WinningPrize.checkByteStringIsUtf8(byteString);
                this.goodsName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setRepeatedField */
        public Builder m8204setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setSource(String str) {
            if (str != null) {
                this.source_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setSourceBytes(ByteString byteString) {
            if (byteString != null) {
                WinningPrize.checkByteStringIsUtf8(byteString);
                this.source_ = byteString;
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
        public final Builder m8206setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setUserName(String str) {
            if (str != null) {
                this.userName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setUserNameBytes(ByteString byteString) {
            if (byteString != null) {
                WinningPrize.checkByteStringIsUtf8(byteString);
                this.userName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }
    }

    private WinningPrize() {
        this.memoizedIsInitialized = (byte) -1;
        this.goodsName_ = "";
        this.goodsIcon_ = "";
        this.userName_ = "";
        this.source_ = "";
        this.event_ = "";
        this.chatFrameIcon_ = "";
        this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
        this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
    }

    private WinningPrize(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw null;
        }
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            boolean z3 = z2;
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.count_ = codedInputStream.readUInt32();
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
                        case 42:
                            this.userName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 50:
                            this.source_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 58:
                            this.event_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 66:
                            this.chatFrameIcon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 74:
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameFrameColor_ = new LazyStringArrayList();
                                z4 = z2 | true;
                            }
                            this.chatFrameFrameColor_.add(readStringRequireUtf8);
                            z2 = z4;
                            continue;
                        case 82:
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameBorderColor_ = new LazyStringArrayList();
                                z5 = z2 | true;
                            }
                            this.chatFrameBorderColor_.add(readStringRequireUtf82);
                            z2 = z5;
                            continue;
                        case 88:
                            this.uid_ = codedInputStream.readUInt32();
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
            } catch (Throwable th) {
                if (z3 & true) {
                    this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                }
                if (z3 & true) {
                    this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
        }
        if (z2 & true) {
            this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private WinningPrize(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static WinningPrize getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_WinningPrize_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m8167toBuilder();
    }

    public static Builder newBuilder(WinningPrize winningPrize) {
        return DEFAULT_INSTANCE.m8167toBuilder().mergeFrom(winningPrize);
    }

    public static WinningPrize parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static WinningPrize parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static WinningPrize parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (WinningPrize) PARSER.parseFrom(byteString);
    }

    public static WinningPrize parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WinningPrize) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static WinningPrize parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static WinningPrize parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static WinningPrize parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static WinningPrize parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static WinningPrize parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (WinningPrize) PARSER.parseFrom(byteBuffer);
    }

    public static WinningPrize parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WinningPrize) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static WinningPrize parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (WinningPrize) PARSER.parseFrom(bArr);
    }

    public static WinningPrize parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WinningPrize) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<WinningPrize> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof WinningPrize) {
            WinningPrize winningPrize = (WinningPrize) obj;
            return getCount() == winningPrize.getCount() && getGoodsId() == winningPrize.getGoodsId() && getGoodsName().equals(winningPrize.getGoodsName()) && getGoodsIcon().equals(winningPrize.getGoodsIcon()) && getUserName().equals(winningPrize.getUserName()) && getSource().equals(winningPrize.getSource()) && getEvent().equals(winningPrize.getEvent()) && getChatFrameIcon().equals(winningPrize.getChatFrameIcon()) && mo8160getChatFrameFrameColorList().equals(winningPrize.mo8160getChatFrameFrameColorList()) && mo8159getChatFrameBorderColorList().equals(winningPrize.mo8159getChatFrameBorderColorList()) && getUid() == winningPrize.getUid() && this.unknownFields.equals(winningPrize.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public String getChatFrameBorderColor(int i) {
        return (String) this.chatFrameBorderColor_.get(i);
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public ByteString getChatFrameBorderColorBytes(int i) {
        return this.chatFrameBorderColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public int getChatFrameBorderColorCount() {
        return this.chatFrameBorderColor_.size();
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    /* renamed from: getChatFrameBorderColorList */
    public ProtocolStringList mo8159getChatFrameBorderColorList() {
        return this.chatFrameBorderColor_;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public String getChatFrameFrameColor(int i) {
        return (String) this.chatFrameFrameColor_.get(i);
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public ByteString getChatFrameFrameColorBytes(int i) {
        return this.chatFrameFrameColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public int getChatFrameFrameColorCount() {
        return this.chatFrameFrameColor_.size();
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    /* renamed from: getChatFrameFrameColorList */
    public ProtocolStringList mo8160getChatFrameFrameColorList() {
        return this.chatFrameFrameColor_;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public String getChatFrameIcon() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrameIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public ByteString getChatFrameIconBytes() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrameIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public int getCount() {
        return this.count_;
    }

    /* renamed from: getDefaultInstanceForType */
    public WinningPrize m8162getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public String getEvent() {
        Object obj = this.event_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.event_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public ByteString getEventBytes() {
        Object obj = this.event_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.event_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public String getGoodsIcon() {
        Object obj = this.goodsIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.goodsIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public ByteString getGoodsIconBytes() {
        Object obj = this.goodsIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goodsIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public int getGoodsId() {
        return this.goodsId_;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public String getGoodsName() {
        Object obj = this.goodsName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.goodsName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public ByteString getGoodsNameBytes() {
        Object obj = this.goodsName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goodsName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<WinningPrize> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.count_;
        int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
        int i3 = this.goodsId_;
        int i4 = computeUInt32Size;
        if (i3 != 0) {
            i4 = computeUInt32Size + CodedOutputStream.computeUInt32Size(2, i3);
        }
        int i5 = i4;
        if (!getGoodsNameBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.goodsName_);
        }
        int i6 = i5;
        if (!getGoodsIconBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.goodsIcon_);
        }
        int i7 = i6;
        if (!getUserNameBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.userName_);
        }
        int i8 = i7;
        if (!getSourceBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(6, this.source_);
        }
        int i9 = i8;
        if (!getEventBytes().isEmpty()) {
            i9 = i8 + GeneratedMessageV3.computeStringSize(7, this.event_);
        }
        int i10 = i9;
        if (!getChatFrameIconBytes().isEmpty()) {
            i10 = i9 + GeneratedMessageV3.computeStringSize(8, this.chatFrameIcon_);
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.chatFrameFrameColor_.size(); i12++) {
            i11 += computeStringSizeNoTag(this.chatFrameFrameColor_.getRaw(i12));
        }
        int size = mo8160getChatFrameFrameColorList().size();
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = i14;
            if (i15 >= this.chatFrameBorderColor_.size()) {
                break;
            }
            i13 += computeStringSizeNoTag(this.chatFrameBorderColor_.getRaw(i15));
            i14 = i15 + 1;
        }
        int size2 = i10 + i11 + (size * 1) + i13 + (mo8159getChatFrameBorderColorList().size() * 1);
        int i16 = this.uid_;
        int i17 = size2;
        if (i16 != 0) {
            i17 = size2 + CodedOutputStream.computeUInt32Size(11, i16);
        }
        int serializedSize = i17 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public String getSource() {
        Object obj = this.source_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.source_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public ByteString getSourceBytes() {
        Object obj = this.source_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.source_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public int getUid() {
        return this.uid_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public String getUserName() {
        Object obj = this.userName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.userName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WinningPrizeOrBuilder
    public ByteString getUserNameBytes() {
        Object obj = this.userName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.userName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCount()) * 37) + 2) * 53) + getGoodsId()) * 37) + 3) * 53) + getGoodsName().hashCode()) * 37) + 4) * 53) + getGoodsIcon().hashCode()) * 37) + 5) * 53) + getUserName().hashCode()) * 37) + 6) * 53) + getSource().hashCode()) * 37) + 7) * 53) + getEvent().hashCode()) * 37) + 8) * 53) + getChatFrameIcon().hashCode();
        int i = hashCode;
        if (getChatFrameFrameColorCount() > 0) {
            i = (((hashCode * 37) + 9) * 53) + mo8160getChatFrameFrameColorList().hashCode();
        }
        int i2 = i;
        if (getChatFrameBorderColorCount() > 0) {
            i2 = (((i * 37) + 10) * 53) + mo8159getChatFrameBorderColorList().hashCode();
        }
        int uid = (((((i2 * 37) + 11) * 53) + getUid()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = uid;
        return uid;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_WinningPrize_fieldAccessorTable.ensureFieldAccessorsInitialized(WinningPrize.class, Builder.class);
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
    public Builder m8165newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m8164newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new WinningPrize();
    }

    /* renamed from: toBuilder */
    public Builder m8167toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i;
        int i2 = this.count_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(1, i2);
        }
        int i3 = this.goodsId_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(2, i3);
        }
        if (!getGoodsNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.goodsName_);
        }
        if (!getGoodsIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.goodsIcon_);
        }
        if (!getUserNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.userName_);
        }
        if (!getSourceBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.source_);
        }
        if (!getEventBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.event_);
        }
        if (!getChatFrameIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.chatFrameIcon_);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.chatFrameFrameColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.chatFrameFrameColor_.getRaw(i5));
            i4 = i5 + 1;
        }
        for (i = 0; i < this.chatFrameBorderColor_.size(); i++) {
            GeneratedMessageV3.writeString(codedOutputStream, 10, this.chatFrameBorderColor_.getRaw(i));
        }
        int i6 = this.uid_;
        if (i6 != 0) {
            codedOutputStream.writeUInt32(11, i6);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
