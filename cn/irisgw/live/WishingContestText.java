package cn.irisgw.live;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
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
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/WishingContestText.class */
public final class WishingContestText extends GeneratedMessageV3 implements WishingContestTextOrBuilder {
    public static final int ANCHOR_BEANS_FIELD_NUMBER = 17;
    public static final int ANCHOR_FIELD_NUMBER = 6;
    public static final int ANCHOR_NAME_FIELD_NUMBER = 7;
    public static final int CHAT_FRAME_BORDER_COLOR_FIELD_NUMBER = 15;
    public static final int CHAT_FRAME_FRAME_COLOR_FIELD_NUMBER = 14;
    public static final int CHAT_FRAME_ICON_FIELD_NUMBER = 13;
    public static final int EVENT_FIELD_NUMBER = 1;
    public static final int GOODS_COUNT_FIELD_NUMBER = 10;
    public static final int GOODS_ID_FIELD_NUMBER = 9;
    public static final int GOODS_NAME_FIELD_NUMBER = 11;
    public static final int GOODS_URL_FIELD_NUMBER = 12;
    public static final int HIDE_FIELD_NUMBER = 16;
    public static final int LID_FIELD_NUMBER = 8;
    public static final int SCREEN_TYPE_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 18;
    public static final int UID_FIELD_NUMBER = 4;
    public static final int URL_FIELD_NUMBER = 2;
    public static final int USER_NAME_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int anchorBeans_;
    private volatile Object anchorName_;
    private int anchor_;
    private LazyStringList chatFrameBorderColor_;
    private LazyStringList chatFrameFrameColor_;
    private volatile Object chatFrameIcon_;
    private int event_;
    private int goodsCount_;
    private int goodsId_;
    private volatile Object goodsName_;
    private volatile Object goodsUrl_;
    private boolean hide_;
    private int lid_;
    private byte memoizedIsInitialized;
    private int screenType_;
    private int type_;
    private int uid_;
    private volatile Object url_;
    private volatile Object userName_;
    private static final WishingContestText DEFAULT_INSTANCE = new WishingContestText();
    private static final Parser<WishingContestText> PARSER = new AbstractParser<WishingContestText>() { // from class: cn.irisgw.live.WishingContestText.1
        @Override // com.google.protobuf.Parser
        public WishingContestText parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new WishingContestText(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/WishingContestText$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WishingContestTextOrBuilder {
        private int anchorBeans_;
        private Object anchorName_;
        private int anchor_;
        private int bitField0_;
        private LazyStringList chatFrameBorderColor_;
        private LazyStringList chatFrameFrameColor_;
        private Object chatFrameIcon_;
        private int event_;
        private int goodsCount_;
        private int goodsId_;
        private Object goodsName_;
        private Object goodsUrl_;
        private boolean hide_;
        private int lid_;
        private int screenType_;
        private int type_;
        private int uid_;
        private Object url_;
        private Object userName_;

        private Builder() {
            this.url_ = "";
            this.userName_ = "";
            this.anchorName_ = "";
            this.goodsName_ = "";
            this.goodsUrl_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.url_ = "";
            this.userName_ = "";
            this.anchorName_ = "";
            this.goodsName_ = "";
            this.goodsUrl_ = "";
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
            return LiveConstants.internal_static_cn_irisgw_live_WishingContestText_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = WishingContestText.alwaysUseFieldBuilders;
        }

        public Builder addAllChatFrameBorderColor(Iterable<String> iterable) {
            ensureChatFrameBorderColorIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.chatFrameBorderColor_);
            onChanged();
            return this;
        }

        public Builder addAllChatFrameFrameColor(Iterable<String> iterable) {
            ensureChatFrameFrameColorIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.chatFrameFrameColor_);
            onChanged();
            return this;
        }

        public Builder addChatFrameBorderColor(String str) {
            if (str != null) {
                ensureChatFrameBorderColorIsMutable();
                this.chatFrameBorderColor_.add((LazyStringList) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addChatFrameBorderColorBytes(ByteString byteString) {
            if (byteString != null) {
                WishingContestText.checkByteStringIsUtf8(byteString);
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
                this.chatFrameFrameColor_.add((LazyStringList) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addChatFrameFrameColorBytes(ByteString byteString) {
            if (byteString != null) {
                WishingContestText.checkByteStringIsUtf8(byteString);
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public WishingContestText build() {
            WishingContestText buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public WishingContestText buildPartial() {
            WishingContestText wishingContestText = new WishingContestText(this);
            wishingContestText.event_ = this.event_;
            wishingContestText.url_ = this.url_;
            wishingContestText.screenType_ = this.screenType_;
            wishingContestText.uid_ = this.uid_;
            wishingContestText.userName_ = this.userName_;
            wishingContestText.anchor_ = this.anchor_;
            wishingContestText.anchorName_ = this.anchorName_;
            wishingContestText.lid_ = this.lid_;
            wishingContestText.goodsId_ = this.goodsId_;
            wishingContestText.goodsCount_ = this.goodsCount_;
            wishingContestText.goodsName_ = this.goodsName_;
            wishingContestText.goodsUrl_ = this.goodsUrl_;
            wishingContestText.chatFrameIcon_ = this.chatFrameIcon_;
            if ((this.bitField0_ & 1) != 0) {
                this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            wishingContestText.chatFrameFrameColor_ = this.chatFrameFrameColor_;
            if ((this.bitField0_ & 2) != 0) {
                this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            wishingContestText.chatFrameBorderColor_ = this.chatFrameBorderColor_;
            wishingContestText.hide_ = this.hide_;
            wishingContestText.anchorBeans_ = this.anchorBeans_;
            wishingContestText.type_ = this.type_;
            onBuilt();
            return wishingContestText;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.event_ = 0;
            this.url_ = "";
            this.screenType_ = 0;
            this.uid_ = 0;
            this.userName_ = "";
            this.anchor_ = 0;
            this.anchorName_ = "";
            this.lid_ = 0;
            this.goodsId_ = 0;
            this.goodsCount_ = 0;
            this.goodsName_ = "";
            this.goodsUrl_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            this.hide_ = false;
            this.anchorBeans_ = 0;
            this.type_ = 0;
            return this;
        }

        public Builder clearAnchor() {
            this.anchor_ = 0;
            onChanged();
            return this;
        }

        public Builder clearAnchorBeans() {
            this.anchorBeans_ = 0;
            onChanged();
            return this;
        }

        public Builder clearAnchorName() {
            this.anchorName_ = WishingContestText.getDefaultInstance().getAnchorName();
            onChanged();
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
            this.chatFrameIcon_ = WishingContestText.getDefaultInstance().getChatFrameIcon();
            onChanged();
            return this;
        }

        public Builder clearEvent() {
            this.event_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGoodsCount() {
            this.goodsCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearGoodsId() {
            this.goodsId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearGoodsName() {
            this.goodsName_ = WishingContestText.getDefaultInstance().getGoodsName();
            onChanged();
            return this;
        }

        public Builder clearGoodsUrl() {
            this.goodsUrl_ = WishingContestText.getDefaultInstance().getGoodsUrl();
            onChanged();
            return this;
        }

        public Builder clearHide() {
            this.hide_ = false;
            onChanged();
            return this;
        }

        public Builder clearLid() {
            this.lid_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearScreenType() {
            this.screenType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = WishingContestText.getDefaultInstance().getUrl();
            onChanged();
            return this;
        }

        public Builder clearUserName() {
            this.userName_ = WishingContestText.getDefaultInstance().getUserName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public int getAnchor() {
            return this.anchor_;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public int getAnchorBeans() {
            return this.anchorBeans_;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public String getAnchorName() {
            Object obj = this.anchorName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.anchorName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public ByteString getAnchorNameBytes() {
            Object obj = this.anchorName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.anchorName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public String getChatFrameBorderColor(int i) {
            return this.chatFrameBorderColor_.get(i);
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public ByteString getChatFrameBorderColorBytes(int i) {
            return this.chatFrameBorderColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public int getChatFrameBorderColorCount() {
            return this.chatFrameBorderColor_.size();
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public ProtocolStringList getChatFrameBorderColorList() {
            return this.chatFrameBorderColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public String getChatFrameFrameColor(int i) {
            return this.chatFrameFrameColor_.get(i);
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public ByteString getChatFrameFrameColorBytes(int i) {
            return this.chatFrameFrameColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public int getChatFrameFrameColorCount() {
            return this.chatFrameFrameColor_.size();
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public ProtocolStringList getChatFrameFrameColorList() {
            return this.chatFrameFrameColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public String getChatFrameIcon() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrameIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public ByteString getChatFrameIconBytes() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrameIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WishingContestText getDefaultInstanceForType() {
            return WishingContestText.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_WishingContestText_descriptor;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public int getEvent() {
            return this.event_;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public int getGoodsCount() {
            return this.goodsCount_;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public int getGoodsId() {
            return this.goodsId_;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public String getGoodsName() {
            Object obj = this.goodsName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public ByteString getGoodsNameBytes() {
            Object obj = this.goodsName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public String getGoodsUrl() {
            Object obj = this.goodsUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public ByteString getGoodsUrlBytes() {
            Object obj = this.goodsUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public boolean getHide() {
            return this.hide_;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public int getLid() {
            return this.lid_;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public int getScreenType() {
            return this.screenType_;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public String getUserName() {
            Object obj = this.userName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.userName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.WishingContestTextOrBuilder
        public ByteString getUserNameBytes() {
            Object obj = this.userName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_WishingContestText_fieldAccessorTable.ensureFieldAccessorsInitialized(WishingContestText.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(WishingContestText wishingContestText) {
            if (wishingContestText == WishingContestText.getDefaultInstance()) {
                return this;
            }
            if (wishingContestText.getEvent() != 0) {
                setEvent(wishingContestText.getEvent());
            }
            if (!wishingContestText.getUrl().isEmpty()) {
                this.url_ = wishingContestText.url_;
                onChanged();
            }
            if (wishingContestText.getScreenType() != 0) {
                setScreenType(wishingContestText.getScreenType());
            }
            if (wishingContestText.getUid() != 0) {
                setUid(wishingContestText.getUid());
            }
            if (!wishingContestText.getUserName().isEmpty()) {
                this.userName_ = wishingContestText.userName_;
                onChanged();
            }
            if (wishingContestText.getAnchor() != 0) {
                setAnchor(wishingContestText.getAnchor());
            }
            if (!wishingContestText.getAnchorName().isEmpty()) {
                this.anchorName_ = wishingContestText.anchorName_;
                onChanged();
            }
            if (wishingContestText.getLid() != 0) {
                setLid(wishingContestText.getLid());
            }
            if (wishingContestText.getGoodsId() != 0) {
                setGoodsId(wishingContestText.getGoodsId());
            }
            if (wishingContestText.getGoodsCount() != 0) {
                setGoodsCount(wishingContestText.getGoodsCount());
            }
            if (!wishingContestText.getGoodsName().isEmpty()) {
                this.goodsName_ = wishingContestText.goodsName_;
                onChanged();
            }
            if (!wishingContestText.getGoodsUrl().isEmpty()) {
                this.goodsUrl_ = wishingContestText.goodsUrl_;
                onChanged();
            }
            if (!wishingContestText.getChatFrameIcon().isEmpty()) {
                this.chatFrameIcon_ = wishingContestText.chatFrameIcon_;
                onChanged();
            }
            if (!wishingContestText.chatFrameFrameColor_.isEmpty()) {
                if (this.chatFrameFrameColor_.isEmpty()) {
                    this.chatFrameFrameColor_ = wishingContestText.chatFrameFrameColor_;
                    this.bitField0_ &= -2;
                } else {
                    ensureChatFrameFrameColorIsMutable();
                    this.chatFrameFrameColor_.addAll(wishingContestText.chatFrameFrameColor_);
                }
                onChanged();
            }
            if (!wishingContestText.chatFrameBorderColor_.isEmpty()) {
                if (this.chatFrameBorderColor_.isEmpty()) {
                    this.chatFrameBorderColor_ = wishingContestText.chatFrameBorderColor_;
                    this.bitField0_ &= -3;
                } else {
                    ensureChatFrameBorderColorIsMutable();
                    this.chatFrameBorderColor_.addAll(wishingContestText.chatFrameBorderColor_);
                }
                onChanged();
            }
            if (wishingContestText.getHide()) {
                setHide(wishingContestText.getHide());
            }
            if (wishingContestText.getAnchorBeans() != 0) {
                setAnchorBeans(wishingContestText.getAnchorBeans());
            }
            if (wishingContestText.getType() != 0) {
                setType(wishingContestText.getType());
            }
            mergeUnknownFields(wishingContestText.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.WishingContestText.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.WishingContestText.access$2300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.WishingContestText r0 = (cn.irisgw.live.WishingContestText) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.WishingContestText$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.WishingContestText r0 = (cn.irisgw.live.WishingContestText) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.WishingContestText$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.WishingContestText.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.WishingContestText$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof WishingContestText) {
                return mergeFrom((WishingContestText) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setAnchor(int i) {
            this.anchor_ = i;
            onChanged();
            return this;
        }

        public Builder setAnchorBeans(int i) {
            this.anchorBeans_ = i;
            onChanged();
            return this;
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
                WishingContestText.checkByteStringIsUtf8(byteString);
                this.anchorName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrameBorderColor(int i, String str) {
            if (str != null) {
                ensureChatFrameBorderColorIsMutable();
                this.chatFrameBorderColor_.set(i, (int) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrameFrameColor(int i, String str) {
            if (str != null) {
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.set(i, (int) str);
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
                WishingContestText.checkByteStringIsUtf8(byteString);
                this.chatFrameIcon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setEvent(int i) {
            this.event_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGoodsCount(int i) {
            this.goodsCount_ = i;
            onChanged();
            return this;
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
                WishingContestText.checkByteStringIsUtf8(byteString);
                this.goodsName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGoodsUrl(String str) {
            if (str != null) {
                this.goodsUrl_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGoodsUrlBytes(ByteString byteString) {
            if (byteString != null) {
                WishingContestText.checkByteStringIsUtf8(byteString);
                this.goodsUrl_ = byteString;
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

        public Builder setLid(int i) {
            this.lid_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setScreenType(int i) {
            this.screenType_ = i;
            onChanged();
            return this;
        }

        public Builder setType(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
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
                WishingContestText.checkByteStringIsUtf8(byteString);
                this.url_ = byteString;
                onChanged();
                return this;
            }
            throw null;
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
                WishingContestText.checkByteStringIsUtf8(byteString);
                this.userName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }
    }

    private WishingContestText() {
        this.memoizedIsInitialized = (byte) -1;
        this.url_ = "";
        this.userName_ = "";
        this.anchorName_ = "";
        this.goodsName_ = "";
        this.goodsUrl_ = "";
        this.chatFrameIcon_ = "";
        this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
        this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
    }

    private WishingContestText(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.event_ = codedInputStream.readInt32();
                            continue;
                        case 18:
                            this.url_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 24:
                            this.screenType_ = codedInputStream.readInt32();
                            continue;
                        case 32:
                            this.uid_ = codedInputStream.readInt32();
                            continue;
                        case 42:
                            this.userName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 48:
                            this.anchor_ = codedInputStream.readInt32();
                            continue;
                        case 58:
                            this.anchorName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 64:
                            this.lid_ = codedInputStream.readInt32();
                            continue;
                        case 72:
                            this.goodsId_ = codedInputStream.readInt32();
                            continue;
                        case 80:
                            this.goodsCount_ = codedInputStream.readInt32();
                            continue;
                        case 90:
                            this.goodsName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 98:
                            this.goodsUrl_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 106:
                            this.chatFrameIcon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 114:
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameFrameColor_ = new LazyStringArrayList();
                                z4 = z2 | true;
                            }
                            this.chatFrameFrameColor_.add((LazyStringList) readStringRequireUtf8);
                            z2 = z4;
                            continue;
                        case 122:
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameBorderColor_ = new LazyStringArrayList();
                                z5 = z2 | true;
                            }
                            this.chatFrameBorderColor_.add((LazyStringList) readStringRequireUtf82);
                            z2 = z5;
                            continue;
                        case 128:
                            this.hide_ = codedInputStream.readBool();
                            continue;
                        case 136:
                            this.anchorBeans_ = codedInputStream.readInt32();
                            continue;
                        case 144:
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

    private WishingContestText(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static WishingContestText getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_WishingContestText_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(WishingContestText wishingContestText) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(wishingContestText);
    }

    public static WishingContestText parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (WishingContestText) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static WishingContestText parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WishingContestText) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static WishingContestText parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static WishingContestText parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static WishingContestText parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (WishingContestText) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static WishingContestText parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WishingContestText) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static WishingContestText parseFrom(InputStream inputStream) throws IOException {
        return (WishingContestText) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static WishingContestText parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WishingContestText) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static WishingContestText parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static WishingContestText parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static WishingContestText parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static WishingContestText parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<WishingContestText> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof WishingContestText) {
            WishingContestText wishingContestText = (WishingContestText) obj;
            return getEvent() == wishingContestText.getEvent() && getUrl().equals(wishingContestText.getUrl()) && getScreenType() == wishingContestText.getScreenType() && getUid() == wishingContestText.getUid() && getUserName().equals(wishingContestText.getUserName()) && getAnchor() == wishingContestText.getAnchor() && getAnchorName().equals(wishingContestText.getAnchorName()) && getLid() == wishingContestText.getLid() && getGoodsId() == wishingContestText.getGoodsId() && getGoodsCount() == wishingContestText.getGoodsCount() && getGoodsName().equals(wishingContestText.getGoodsName()) && getGoodsUrl().equals(wishingContestText.getGoodsUrl()) && getChatFrameIcon().equals(wishingContestText.getChatFrameIcon()) && getChatFrameFrameColorList().equals(wishingContestText.getChatFrameFrameColorList()) && getChatFrameBorderColorList().equals(wishingContestText.getChatFrameBorderColorList()) && getHide() == wishingContestText.getHide() && getAnchorBeans() == wishingContestText.getAnchorBeans() && getType() == wishingContestText.getType() && this.unknownFields.equals(wishingContestText.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public int getAnchor() {
        return this.anchor_;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public int getAnchorBeans() {
        return this.anchorBeans_;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public String getAnchorName() {
        Object obj = this.anchorName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.anchorName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public ByteString getAnchorNameBytes() {
        Object obj = this.anchorName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.anchorName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public String getChatFrameBorderColor(int i) {
        return this.chatFrameBorderColor_.get(i);
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public ByteString getChatFrameBorderColorBytes(int i) {
        return this.chatFrameBorderColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public int getChatFrameBorderColorCount() {
        return this.chatFrameBorderColor_.size();
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public ProtocolStringList getChatFrameBorderColorList() {
        return this.chatFrameBorderColor_;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public String getChatFrameFrameColor(int i) {
        return this.chatFrameFrameColor_.get(i);
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public ByteString getChatFrameFrameColorBytes(int i) {
        return this.chatFrameFrameColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public int getChatFrameFrameColorCount() {
        return this.chatFrameFrameColor_.size();
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public ProtocolStringList getChatFrameFrameColorList() {
        return this.chatFrameFrameColor_;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public String getChatFrameIcon() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrameIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public ByteString getChatFrameIconBytes() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrameIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public WishingContestText getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public int getEvent() {
        return this.event_;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public int getGoodsCount() {
        return this.goodsCount_;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public int getGoodsId() {
        return this.goodsId_;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public String getGoodsName() {
        Object obj = this.goodsName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.goodsName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public ByteString getGoodsNameBytes() {
        Object obj = this.goodsName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goodsName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public String getGoodsUrl() {
        Object obj = this.goodsUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.goodsUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public ByteString getGoodsUrlBytes() {
        Object obj = this.goodsUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goodsUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public boolean getHide() {
        return this.hide_;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public int getLid() {
        return this.lid_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<WishingContestText> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public int getScreenType() {
        return this.screenType_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.event_;
        int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
        int i3 = computeInt32Size;
        if (!getUrlBytes().isEmpty()) {
            i3 = computeInt32Size + GeneratedMessageV3.computeStringSize(2, this.url_);
        }
        int i4 = this.screenType_;
        int i5 = i3;
        if (i4 != 0) {
            i5 = i3 + CodedOutputStream.computeInt32Size(3, i4);
        }
        int i6 = this.uid_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeInt32Size(4, i6);
        }
        int i8 = i7;
        if (!getUserNameBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(5, this.userName_);
        }
        int i9 = this.anchor_;
        int i10 = i8;
        if (i9 != 0) {
            i10 = i8 + CodedOutputStream.computeInt32Size(6, i9);
        }
        int i11 = i10;
        if (!getAnchorNameBytes().isEmpty()) {
            i11 = i10 + GeneratedMessageV3.computeStringSize(7, this.anchorName_);
        }
        int i12 = this.lid_;
        int i13 = i11;
        if (i12 != 0) {
            i13 = i11 + CodedOutputStream.computeInt32Size(8, i12);
        }
        int i14 = this.goodsId_;
        int i15 = i13;
        if (i14 != 0) {
            i15 = i13 + CodedOutputStream.computeInt32Size(9, i14);
        }
        int i16 = this.goodsCount_;
        int i17 = i15;
        if (i16 != 0) {
            i17 = i15 + CodedOutputStream.computeInt32Size(10, i16);
        }
        int i18 = i17;
        if (!getGoodsNameBytes().isEmpty()) {
            i18 = i17 + GeneratedMessageV3.computeStringSize(11, this.goodsName_);
        }
        int i19 = i18;
        if (!getGoodsUrlBytes().isEmpty()) {
            i19 = i18 + GeneratedMessageV3.computeStringSize(12, this.goodsUrl_);
        }
        int i20 = i19;
        if (!getChatFrameIconBytes().isEmpty()) {
            i20 = i19 + GeneratedMessageV3.computeStringSize(13, this.chatFrameIcon_);
        }
        int i21 = 0;
        for (int i22 = 0; i22 < this.chatFrameFrameColor_.size(); i22++) {
            i21 += computeStringSizeNoTag(this.chatFrameFrameColor_.getRaw(i22));
        }
        int size = getChatFrameFrameColorList().size();
        int i23 = 0;
        int i24 = 0;
        while (true) {
            int i25 = i24;
            if (i25 >= this.chatFrameBorderColor_.size()) {
                break;
            }
            i23 += computeStringSizeNoTag(this.chatFrameBorderColor_.getRaw(i25));
            i24 = i25 + 1;
        }
        int size2 = i20 + i21 + (size * 1) + i23 + (getChatFrameBorderColorList().size() * 1);
        boolean z = this.hide_;
        int i26 = size2;
        if (z) {
            i26 = size2 + CodedOutputStream.computeBoolSize(16, z);
        }
        int i27 = this.anchorBeans_;
        int i28 = i26;
        if (i27 != 0) {
            i28 = i26 + CodedOutputStream.computeInt32Size(17, i27);
        }
        int i29 = this.type_;
        int i30 = i28;
        if (i29 != 0) {
            i30 = i28 + CodedOutputStream.computeInt32Size(18, i29);
        }
        int serializedSize = i30 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public int getType() {
        return this.type_;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public int getUid() {
        return this.uid_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public String getUserName() {
        Object obj = this.userName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.userName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.WishingContestTextOrBuilder
    public ByteString getUserNameBytes() {
        Object obj = this.userName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.userName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getEvent()) * 37) + 2) * 53) + getUrl().hashCode()) * 37) + 3) * 53) + getScreenType()) * 37) + 4) * 53) + getUid()) * 37) + 5) * 53) + getUserName().hashCode()) * 37) + 6) * 53) + getAnchor()) * 37) + 7) * 53) + getAnchorName().hashCode()) * 37) + 8) * 53) + getLid()) * 37) + 9) * 53) + getGoodsId()) * 37) + 10) * 53) + getGoodsCount()) * 37) + 11) * 53) + getGoodsName().hashCode()) * 37) + 12) * 53) + getGoodsUrl().hashCode()) * 37) + 13) * 53) + getChatFrameIcon().hashCode();
        int i = hashCode;
        if (getChatFrameFrameColorCount() > 0) {
            i = (((hashCode * 37) + 14) * 53) + getChatFrameFrameColorList().hashCode();
        }
        int i2 = i;
        if (getChatFrameBorderColorCount() > 0) {
            i2 = (((i * 37) + 15) * 53) + getChatFrameBorderColorList().hashCode();
        }
        int hashBoolean = (((((((((((((i2 * 37) + 16) * 53) + Internal.hashBoolean(getHide())) * 37) + 17) * 53) + getAnchorBeans()) * 37) + 18) * 53) + getType()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashBoolean;
        return hashBoolean;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_WishingContestText_fieldAccessorTable.ensureFieldAccessorsInitialized(WishingContestText.class, Builder.class);
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
        return new WishingContestText();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i;
        int i2 = this.event_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(1, i2);
        }
        if (!getUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.url_);
        }
        int i3 = this.screenType_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(3, i3);
        }
        int i4 = this.uid_;
        if (i4 != 0) {
            codedOutputStream.writeInt32(4, i4);
        }
        if (!getUserNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.userName_);
        }
        int i5 = this.anchor_;
        if (i5 != 0) {
            codedOutputStream.writeInt32(6, i5);
        }
        if (!getAnchorNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.anchorName_);
        }
        int i6 = this.lid_;
        if (i6 != 0) {
            codedOutputStream.writeInt32(8, i6);
        }
        int i7 = this.goodsId_;
        if (i7 != 0) {
            codedOutputStream.writeInt32(9, i7);
        }
        int i8 = this.goodsCount_;
        if (i8 != 0) {
            codedOutputStream.writeInt32(10, i8);
        }
        if (!getGoodsNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 11, this.goodsName_);
        }
        if (!getGoodsUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 12, this.goodsUrl_);
        }
        if (!getChatFrameIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 13, this.chatFrameIcon_);
        }
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= this.chatFrameFrameColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 14, this.chatFrameFrameColor_.getRaw(i10));
            i9 = i10 + 1;
        }
        for (i = 0; i < this.chatFrameBorderColor_.size(); i++) {
            GeneratedMessageV3.writeString(codedOutputStream, 15, this.chatFrameBorderColor_.getRaw(i));
        }
        boolean z = this.hide_;
        if (z) {
            codedOutputStream.writeBool(16, z);
        }
        int i11 = this.anchorBeans_;
        if (i11 != 0) {
            codedOutputStream.writeInt32(17, i11);
        }
        int i12 = this.type_;
        if (i12 != 0) {
            codedOutputStream.writeInt32(18, i12);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
