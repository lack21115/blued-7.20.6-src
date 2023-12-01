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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/DrawGoods.class */
public final class DrawGoods extends GeneratedMessageV3 implements DrawGoodsOrBuilder {
    public static final int AVATAR_FRAME_URL_FIELD_NUMBER = 26;
    public static final int BEANS_CURRENT_COUNT_FIELD_NUMBER = 16;
    public static final int BG_COLOR_FIELD_NUMBER = 28;
    public static final int BG_IMG_FIELD_NUMBER = 27;
    public static final int CHAT_BADGE_HEIGHT_FIELD_NUMBER = 25;
    public static final int CHAT_BADGE_LENGTH_FIELD_NUMBER = 24;
    public static final int CHAT_BADGE_URL_FIELD_NUMBER = 23;
    public static final int CHAT_FRAME_BORDER_COLOR_FIELD_NUMBER = 22;
    public static final int CHAT_FRAME_COLOR_TYPE_FIELD_NUMBER = 19;
    public static final int CHAT_FRAME_FIELD_NUMBER = 17;
    public static final int CHAT_FRAME_FRAME_COLOR_FIELD_NUMBER = 21;
    public static final int CHAT_FRAME_GRADIENT_TYPE_FIELD_NUMBER = 20;
    public static final int CHAT_FRAME_ICON_FIELD_NUMBER = 18;
    public static final int DISCOUNT_ID_FIELD_NUMBER = 6;
    public static final int FANS_STATUS_FIELD_NUMBER = 13;
    public static final int FAN_CLUB_LEVEL_FIELD_NUMBER = 11;
    public static final int FAN_CLUB_NAME_FIELD_NUMBER = 10;
    public static final int GOODS_FIELD_NUMBER = 1;
    public static final int HEIGHT_FIELD_NUMBER = 3;
    public static final int IN_FAN_CLUB_FIELD_NUMBER = 12;
    public static final int LIANG_ID_FIELD_NUMBER = 14;
    public static final int LIANG_TYPE_FIELD_NUMBER = 15;
    public static final int LIVE_ID_FIELD_NUMBER = 9;
    public static final int PAY_CODE_FIELD_NUMBER = 5;
    public static final int PAY_TOKEN_FIELD_NUMBER = 4;
    public static final int REMEMBER_ME_FIELD_NUMBER = 7;
    public static final int TARGET_UID_FIELD_NUMBER = 8;
    public static final int WIDTH_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile Object avatarFrameUrl_;
    private long beansCurrentCount_;
    private LazyStringList bgColor_;
    private volatile Object bgImg_;
    private int chatBadgeHeight_;
    private int chatBadgeLength_;
    private volatile Object chatBadgeUrl_;
    private LazyStringList chatFrameBorderColor_;
    private int chatFrameColorType_;
    private LazyStringList chatFrameFrameColor_;
    private int chatFrameGradientType_;
    private volatile Object chatFrameIcon_;
    private volatile Object chatFrame_;
    private int discountId_;
    private int fanClubLevel_;
    private volatile Object fanClubName_;
    private int fansStatus_;
    private List<Goods> goods_;
    private int height_;
    private int inFanClub_;
    private int liangId_;
    private int liangType_;
    private int liveId_;
    private byte memoizedIsInitialized;
    private volatile Object payCode_;
    private volatile Object payToken_;
    private int rememberMe_;
    private int targetUid_;
    private int width_;
    private static final DrawGoods DEFAULT_INSTANCE = new DrawGoods();
    private static final Parser<DrawGoods> PARSER = new AbstractParser<DrawGoods>() { // from class: cn.irisgw.live.DrawGoods.1
        /* renamed from: parsePartialFrom */
        public DrawGoods m2007parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new DrawGoods(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/DrawGoods$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DrawGoodsOrBuilder {
        private Object avatarFrameUrl_;
        private long beansCurrentCount_;
        private LazyStringList bgColor_;
        private Object bgImg_;
        private int bitField0_;
        private int chatBadgeHeight_;
        private int chatBadgeLength_;
        private Object chatBadgeUrl_;
        private LazyStringList chatFrameBorderColor_;
        private int chatFrameColorType_;
        private LazyStringList chatFrameFrameColor_;
        private int chatFrameGradientType_;
        private Object chatFrameIcon_;
        private Object chatFrame_;
        private int discountId_;
        private int fanClubLevel_;
        private Object fanClubName_;
        private int fansStatus_;
        private RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> goodsBuilder_;
        private List<Goods> goods_;
        private int height_;
        private int inFanClub_;
        private int liangId_;
        private int liangType_;
        private int liveId_;
        private Object payCode_;
        private Object payToken_;
        private int rememberMe_;
        private int targetUid_;
        private int width_;

        private Builder() {
            this.goods_ = Collections.emptyList();
            this.payToken_ = "";
            this.payCode_ = "";
            this.fanClubName_ = "";
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.chatBadgeUrl_ = "";
            this.avatarFrameUrl_ = "";
            this.bgImg_ = "";
            this.bgColor_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.goods_ = Collections.emptyList();
            this.payToken_ = "";
            this.payCode_ = "";
            this.fanClubName_ = "";
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.chatBadgeUrl_ = "";
            this.avatarFrameUrl_ = "";
            this.bgImg_ = "";
            this.bgColor_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void ensureBgColorIsMutable() {
            if ((this.bitField0_ & 8) == 0) {
                this.bgColor_ = new LazyStringArrayList(this.bgColor_);
                this.bitField0_ |= 8;
            }
        }

        private void ensureChatFrameBorderColorIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.chatFrameBorderColor_ = new LazyStringArrayList(this.chatFrameBorderColor_);
                this.bitField0_ |= 4;
            }
        }

        private void ensureChatFrameFrameColorIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.chatFrameFrameColor_ = new LazyStringArrayList(this.chatFrameFrameColor_);
                this.bitField0_ |= 2;
            }
        }

        private void ensureGoodsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.goods_ = new ArrayList(this.goods_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_descriptor;
        }

        private RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> getGoodsFieldBuilder() {
            if (this.goodsBuilder_ == null) {
                List<Goods> list = this.goods_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.goodsBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.goods_ = null;
            }
            return this.goodsBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (DrawGoods.alwaysUseFieldBuilders) {
                getGoodsFieldBuilder();
            }
        }

        public Builder addAllBgColor(Iterable<String> iterable) {
            ensureBgColorIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.bgColor_);
            onChanged();
            return this;
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

        public Builder addAllGoods(Iterable<? extends Goods> iterable) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureGoodsIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.goods_);
            onChanged();
            return this;
        }

        public Builder addBgColor(String str) {
            if (str != null) {
                ensureBgColorIsMutable();
                this.bgColor_.add(str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addBgColorBytes(ByteString byteString) {
            if (byteString != null) {
                DrawGoods.checkByteStringIsUtf8(byteString);
                ensureBgColorIsMutable();
                this.bgColor_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
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
                DrawGoods.checkByteStringIsUtf8(byteString);
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
                DrawGoods.checkByteStringIsUtf8(byteString);
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addGoods(int i, Goods.Builder builder) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m2058build());
                return this;
            }
            ensureGoodsIsMutable();
            this.goods_.add(i, builder.m2058build());
            onChanged();
            return this;
        }

        public Builder addGoods(int i, Goods goods) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, goods);
                return this;
            } else if (goods != null) {
                ensureGoodsIsMutable();
                this.goods_.add(i, goods);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addGoods(Goods.Builder builder) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m2058build());
                return this;
            }
            ensureGoodsIsMutable();
            this.goods_.add(builder.m2058build());
            onChanged();
            return this;
        }

        public Builder addGoods(Goods goods) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(goods);
                return this;
            } else if (goods != null) {
                ensureGoodsIsMutable();
                this.goods_.add(goods);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Goods.Builder addGoodsBuilder() {
            return getGoodsFieldBuilder().addBuilder(Goods.getDefaultInstance());
        }

        public Goods.Builder addGoodsBuilder(int i) {
            return getGoodsFieldBuilder().addBuilder(i, Goods.getDefaultInstance());
        }

        /* renamed from: addRepeatedField */
        public Builder m2009addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public DrawGoods m2011build() {
            DrawGoods m2013buildPartial = m2013buildPartial();
            if (m2013buildPartial.isInitialized()) {
                return m2013buildPartial;
            }
            throw newUninitializedMessageException(m2013buildPartial);
        }

        /* renamed from: buildPartial */
        public DrawGoods m2013buildPartial() {
            DrawGoods drawGoods = new DrawGoods(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.goods_ = Collections.unmodifiableList(this.goods_);
                    this.bitField0_ &= -2;
                }
                drawGoods.goods_ = this.goods_;
            } else {
                drawGoods.goods_ = repeatedFieldBuilderV3.build();
            }
            drawGoods.width_ = this.width_;
            drawGoods.height_ = this.height_;
            drawGoods.payToken_ = this.payToken_;
            drawGoods.payCode_ = this.payCode_;
            drawGoods.discountId_ = this.discountId_;
            drawGoods.rememberMe_ = this.rememberMe_;
            drawGoods.targetUid_ = this.targetUid_;
            drawGoods.liveId_ = this.liveId_;
            drawGoods.fanClubName_ = this.fanClubName_;
            drawGoods.fanClubLevel_ = this.fanClubLevel_;
            drawGoods.inFanClub_ = this.inFanClub_;
            drawGoods.fansStatus_ = this.fansStatus_;
            drawGoods.liangId_ = this.liangId_;
            drawGoods.liangType_ = this.liangType_;
            drawGoods.beansCurrentCount_ = this.beansCurrentCount_;
            drawGoods.chatFrame_ = this.chatFrame_;
            drawGoods.chatFrameIcon_ = this.chatFrameIcon_;
            drawGoods.chatFrameColorType_ = this.chatFrameColorType_;
            drawGoods.chatFrameGradientType_ = this.chatFrameGradientType_;
            if ((this.bitField0_ & 2) != 0) {
                this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            drawGoods.chatFrameFrameColor_ = this.chatFrameFrameColor_;
            if ((this.bitField0_ & 4) != 0) {
                this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                this.bitField0_ &= -5;
            }
            drawGoods.chatFrameBorderColor_ = this.chatFrameBorderColor_;
            drawGoods.chatBadgeUrl_ = this.chatBadgeUrl_;
            drawGoods.chatBadgeLength_ = this.chatBadgeLength_;
            drawGoods.chatBadgeHeight_ = this.chatBadgeHeight_;
            drawGoods.avatarFrameUrl_ = this.avatarFrameUrl_;
            drawGoods.bgImg_ = this.bgImg_;
            if ((this.bitField0_ & 8) != 0) {
                this.bgColor_ = this.bgColor_.getUnmodifiableView();
                this.bitField0_ &= -9;
            }
            drawGoods.bgColor_ = this.bgColor_;
            onBuilt();
            return drawGoods;
        }

        /* renamed from: clear */
        public Builder m2017clear() {
            super.clear();
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.goods_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.width_ = 0;
            this.height_ = 0;
            this.payToken_ = "";
            this.payCode_ = "";
            this.discountId_ = 0;
            this.rememberMe_ = 0;
            this.targetUid_ = 0;
            this.liveId_ = 0;
            this.fanClubName_ = "";
            this.fanClubLevel_ = 0;
            this.inFanClub_ = 0;
            this.fansStatus_ = 0;
            this.liangId_ = 0;
            this.liangType_ = 0;
            this.beansCurrentCount_ = DrawGoods.serialVersionUID;
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameColorType_ = 0;
            this.chatFrameGradientType_ = 0;
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -5;
            this.chatBadgeUrl_ = "";
            this.chatBadgeLength_ = 0;
            this.chatBadgeHeight_ = 0;
            this.avatarFrameUrl_ = "";
            this.bgImg_ = "";
            this.bgColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -9;
            return this;
        }

        public Builder clearAvatarFrameUrl() {
            this.avatarFrameUrl_ = DrawGoods.getDefaultInstance().getAvatarFrameUrl();
            onChanged();
            return this;
        }

        public Builder clearBeansCurrentCount() {
            this.beansCurrentCount_ = DrawGoods.serialVersionUID;
            onChanged();
            return this;
        }

        public Builder clearBgColor() {
            this.bgColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder clearBgImg() {
            this.bgImg_ = DrawGoods.getDefaultInstance().getBgImg();
            onChanged();
            return this;
        }

        public Builder clearChatBadgeHeight() {
            this.chatBadgeHeight_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChatBadgeLength() {
            this.chatBadgeLength_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChatBadgeUrl() {
            this.chatBadgeUrl_ = DrawGoods.getDefaultInstance().getChatBadgeUrl();
            onChanged();
            return this;
        }

        public Builder clearChatFrame() {
            this.chatFrame_ = DrawGoods.getDefaultInstance().getChatFrame();
            onChanged();
            return this;
        }

        public Builder clearChatFrameBorderColor() {
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearChatFrameColorType() {
            this.chatFrameColorType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChatFrameFrameColor() {
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearChatFrameGradientType() {
            this.chatFrameGradientType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChatFrameIcon() {
            this.chatFrameIcon_ = DrawGoods.getDefaultInstance().getChatFrameIcon();
            onChanged();
            return this;
        }

        public Builder clearDiscountId() {
            this.discountId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearFanClubLevel() {
            this.fanClubLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearFanClubName() {
            this.fanClubName_ = DrawGoods.getDefaultInstance().getFanClubName();
            onChanged();
            return this;
        }

        public Builder clearFansStatus() {
            this.fansStatus_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m2019clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGoods() {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.goods_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearHeight() {
            this.height_ = 0;
            onChanged();
            return this;
        }

        public Builder clearInFanClub() {
            this.inFanClub_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLiangId() {
            this.liangId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLiangType() {
            this.liangType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLiveId() {
            this.liveId_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m2022clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPayCode() {
            this.payCode_ = DrawGoods.getDefaultInstance().getPayCode();
            onChanged();
            return this;
        }

        public Builder clearPayToken() {
            this.payToken_ = DrawGoods.getDefaultInstance().getPayToken();
            onChanged();
            return this;
        }

        public Builder clearRememberMe() {
            this.rememberMe_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTargetUid() {
            this.targetUid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWidth() {
            this.width_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m2028clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public String getAvatarFrameUrl() {
            Object obj = this.avatarFrameUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatarFrameUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public ByteString getAvatarFrameUrlBytes() {
            Object obj = this.avatarFrameUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatarFrameUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public long getBeansCurrentCount() {
            return this.beansCurrentCount_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public String getBgColor(int i) {
            return (String) this.bgColor_.get(i);
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public ByteString getBgColorBytes(int i) {
            return this.bgColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getBgColorCount() {
            return this.bgColor_.size();
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        /* renamed from: getBgColorList */
        public ProtocolStringList mo1997getBgColorList() {
            return this.bgColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public String getBgImg() {
            Object obj = this.bgImg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.bgImg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public ByteString getBgImgBytes() {
            Object obj = this.bgImg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bgImg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getChatBadgeHeight() {
            return this.chatBadgeHeight_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getChatBadgeLength() {
            return this.chatBadgeLength_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public String getChatBadgeUrl() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatBadgeUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public ByteString getChatBadgeUrlBytes() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatBadgeUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public String getChatFrame() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrame_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public String getChatFrameBorderColor(int i) {
            return (String) this.chatFrameBorderColor_.get(i);
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public ByteString getChatFrameBorderColorBytes(int i) {
            return this.chatFrameBorderColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getChatFrameBorderColorCount() {
            return this.chatFrameBorderColor_.size();
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        /* renamed from: getChatFrameBorderColorList */
        public ProtocolStringList mo1998getChatFrameBorderColorList() {
            return this.chatFrameBorderColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public ByteString getChatFrameBytes() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrame_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getChatFrameColorType() {
            return this.chatFrameColorType_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public String getChatFrameFrameColor(int i) {
            return (String) this.chatFrameFrameColor_.get(i);
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public ByteString getChatFrameFrameColorBytes(int i) {
            return this.chatFrameFrameColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getChatFrameFrameColorCount() {
            return this.chatFrameFrameColor_.size();
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        /* renamed from: getChatFrameFrameColorList */
        public ProtocolStringList mo1999getChatFrameFrameColorList() {
            return this.chatFrameFrameColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getChatFrameGradientType() {
            return this.chatFrameGradientType_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public String getChatFrameIcon() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrameIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public ByteString getChatFrameIconBytes() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrameIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* renamed from: getDefaultInstanceForType */
        public DrawGoods m2030getDefaultInstanceForType() {
            return DrawGoods.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_descriptor;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getDiscountId() {
            return this.discountId_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getFanClubLevel() {
            return this.fanClubLevel_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public String getFanClubName() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fanClubName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public ByteString getFanClubNameBytes() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fanClubName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getFansStatus() {
            return this.fansStatus_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public Goods getGoods(int i) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.goods_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Goods.Builder getGoodsBuilder(int i) {
            return getGoodsFieldBuilder().getBuilder(i);
        }

        public List<Goods.Builder> getGoodsBuilderList() {
            return getGoodsFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getGoodsCount() {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.goods_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public List<Goods> getGoodsList() {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.goods_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public GoodsOrBuilder getGoodsOrBuilder(int i) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.goods_.get(i) : (GoodsOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public List<? extends GoodsOrBuilder> getGoodsOrBuilderList() {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.goods_);
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getHeight() {
            return this.height_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getInFanClub() {
            return this.inFanClub_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getLiangId() {
            return this.liangId_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getLiangType() {
            return this.liangType_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getLiveId() {
            return this.liveId_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public String getPayCode() {
            Object obj = this.payCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.payCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public ByteString getPayCodeBytes() {
            Object obj = this.payCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.payCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public String getPayToken() {
            Object obj = this.payToken_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.payToken_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public ByteString getPayTokenBytes() {
            Object obj = this.payToken_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.payToken_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getRememberMe() {
            return this.rememberMe_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
        }

        @Override // cn.irisgw.live.DrawGoodsOrBuilder
        public int getWidth() {
            return this.width_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_fieldAccessorTable.ensureFieldAccessorsInitialized(DrawGoods.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(DrawGoods drawGoods) {
            if (drawGoods == DrawGoods.getDefaultInstance()) {
                return this;
            }
            if (this.goodsBuilder_ == null) {
                if (!drawGoods.goods_.isEmpty()) {
                    if (this.goods_.isEmpty()) {
                        this.goods_ = drawGoods.goods_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureGoodsIsMutable();
                        this.goods_.addAll(drawGoods.goods_);
                    }
                    onChanged();
                }
            } else if (!drawGoods.goods_.isEmpty()) {
                if (this.goodsBuilder_.isEmpty()) {
                    this.goodsBuilder_.dispose();
                    RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = null;
                    this.goodsBuilder_ = null;
                    this.goods_ = drawGoods.goods_;
                    this.bitField0_ &= -2;
                    if (DrawGoods.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getGoodsFieldBuilder();
                    }
                    this.goodsBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.goodsBuilder_.addAllMessages(drawGoods.goods_);
                }
            }
            if (drawGoods.getWidth() != 0) {
                setWidth(drawGoods.getWidth());
            }
            if (drawGoods.getHeight() != 0) {
                setHeight(drawGoods.getHeight());
            }
            if (!drawGoods.getPayToken().isEmpty()) {
                this.payToken_ = drawGoods.payToken_;
                onChanged();
            }
            if (!drawGoods.getPayCode().isEmpty()) {
                this.payCode_ = drawGoods.payCode_;
                onChanged();
            }
            if (drawGoods.getDiscountId() != 0) {
                setDiscountId(drawGoods.getDiscountId());
            }
            if (drawGoods.getRememberMe() != 0) {
                setRememberMe(drawGoods.getRememberMe());
            }
            if (drawGoods.getTargetUid() != 0) {
                setTargetUid(drawGoods.getTargetUid());
            }
            if (drawGoods.getLiveId() != 0) {
                setLiveId(drawGoods.getLiveId());
            }
            if (!drawGoods.getFanClubName().isEmpty()) {
                this.fanClubName_ = drawGoods.fanClubName_;
                onChanged();
            }
            if (drawGoods.getFanClubLevel() != 0) {
                setFanClubLevel(drawGoods.getFanClubLevel());
            }
            if (drawGoods.getInFanClub() != 0) {
                setInFanClub(drawGoods.getInFanClub());
            }
            if (drawGoods.getFansStatus() != 0) {
                setFansStatus(drawGoods.getFansStatus());
            }
            if (drawGoods.getLiangId() != 0) {
                setLiangId(drawGoods.getLiangId());
            }
            if (drawGoods.getLiangType() != 0) {
                setLiangType(drawGoods.getLiangType());
            }
            if (drawGoods.getBeansCurrentCount() != DrawGoods.serialVersionUID) {
                setBeansCurrentCount(drawGoods.getBeansCurrentCount());
            }
            if (!drawGoods.getChatFrame().isEmpty()) {
                this.chatFrame_ = drawGoods.chatFrame_;
                onChanged();
            }
            if (!drawGoods.getChatFrameIcon().isEmpty()) {
                this.chatFrameIcon_ = drawGoods.chatFrameIcon_;
                onChanged();
            }
            if (drawGoods.getChatFrameColorType() != 0) {
                setChatFrameColorType(drawGoods.getChatFrameColorType());
            }
            if (drawGoods.getChatFrameGradientType() != 0) {
                setChatFrameGradientType(drawGoods.getChatFrameGradientType());
            }
            if (!drawGoods.chatFrameFrameColor_.isEmpty()) {
                if (this.chatFrameFrameColor_.isEmpty()) {
                    this.chatFrameFrameColor_ = drawGoods.chatFrameFrameColor_;
                    this.bitField0_ &= -3;
                } else {
                    ensureChatFrameFrameColorIsMutable();
                    this.chatFrameFrameColor_.addAll(drawGoods.chatFrameFrameColor_);
                }
                onChanged();
            }
            if (!drawGoods.chatFrameBorderColor_.isEmpty()) {
                if (this.chatFrameBorderColor_.isEmpty()) {
                    this.chatFrameBorderColor_ = drawGoods.chatFrameBorderColor_;
                    this.bitField0_ &= -5;
                } else {
                    ensureChatFrameBorderColorIsMutable();
                    this.chatFrameBorderColor_.addAll(drawGoods.chatFrameBorderColor_);
                }
                onChanged();
            }
            if (!drawGoods.getChatBadgeUrl().isEmpty()) {
                this.chatBadgeUrl_ = drawGoods.chatBadgeUrl_;
                onChanged();
            }
            if (drawGoods.getChatBadgeLength() != 0) {
                setChatBadgeLength(drawGoods.getChatBadgeLength());
            }
            if (drawGoods.getChatBadgeHeight() != 0) {
                setChatBadgeHeight(drawGoods.getChatBadgeHeight());
            }
            if (!drawGoods.getAvatarFrameUrl().isEmpty()) {
                this.avatarFrameUrl_ = drawGoods.avatarFrameUrl_;
                onChanged();
            }
            if (!drawGoods.getBgImg().isEmpty()) {
                this.bgImg_ = drawGoods.bgImg_;
                onChanged();
            }
            if (!drawGoods.bgColor_.isEmpty()) {
                if (this.bgColor_.isEmpty()) {
                    this.bgColor_ = drawGoods.bgColor_;
                    this.bitField0_ &= -9;
                } else {
                    ensureBgColorIsMutable();
                    this.bgColor_.addAll(drawGoods.bgColor_);
                }
                onChanged();
            }
            m2039mergeUnknownFields(drawGoods.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.DrawGoods.Builder m2036mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.DrawGoods.access$6100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.DrawGoods r0 = (cn.irisgw.live.DrawGoods) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.DrawGoods$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.DrawGoods r0 = (cn.irisgw.live.DrawGoods) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.DrawGoods$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.DrawGoods.Builder.m2036mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.DrawGoods$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m2035mergeFrom(Message message) {
            if (message instanceof DrawGoods) {
                return mergeFrom((DrawGoods) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m2039mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeGoods(int i) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureGoodsIsMutable();
            this.goods_.remove(i);
            onChanged();
            return this;
        }

        public Builder setAvatarFrameUrl(String str) {
            if (str != null) {
                this.avatarFrameUrl_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAvatarFrameUrlBytes(ByteString byteString) {
            if (byteString != null) {
                DrawGoods.checkByteStringIsUtf8(byteString);
                this.avatarFrameUrl_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setBeansCurrentCount(long j) {
            this.beansCurrentCount_ = j;
            onChanged();
            return this;
        }

        public Builder setBgColor(int i, String str) {
            if (str != null) {
                ensureBgColorIsMutable();
                this.bgColor_.set(i, str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setBgImg(String str) {
            if (str != null) {
                this.bgImg_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setBgImgBytes(ByteString byteString) {
            if (byteString != null) {
                DrawGoods.checkByteStringIsUtf8(byteString);
                this.bgImg_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatBadgeHeight(int i) {
            this.chatBadgeHeight_ = i;
            onChanged();
            return this;
        }

        public Builder setChatBadgeLength(int i) {
            this.chatBadgeLength_ = i;
            onChanged();
            return this;
        }

        public Builder setChatBadgeUrl(String str) {
            if (str != null) {
                this.chatBadgeUrl_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatBadgeUrlBytes(ByteString byteString) {
            if (byteString != null) {
                DrawGoods.checkByteStringIsUtf8(byteString);
                this.chatBadgeUrl_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrame(String str) {
            if (str != null) {
                this.chatFrame_ = str;
                onChanged();
                return this;
            }
            throw null;
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

        public Builder setChatFrameBytes(ByteString byteString) {
            if (byteString != null) {
                DrawGoods.checkByteStringIsUtf8(byteString);
                this.chatFrame_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrameColorType(int i) {
            this.chatFrameColorType_ = i;
            onChanged();
            return this;
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

        public Builder setChatFrameGradientType(int i) {
            this.chatFrameGradientType_ = i;
            onChanged();
            return this;
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
                DrawGoods.checkByteStringIsUtf8(byteString);
                this.chatFrameIcon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDiscountId(int i) {
            this.discountId_ = i;
            onChanged();
            return this;
        }

        public Builder setFanClubLevel(int i) {
            this.fanClubLevel_ = i;
            onChanged();
            return this;
        }

        public Builder setFanClubName(String str) {
            if (str != null) {
                this.fanClubName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setFanClubNameBytes(ByteString byteString) {
            if (byteString != null) {
                DrawGoods.checkByteStringIsUtf8(byteString);
                this.fanClubName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setFansStatus(int i) {
            this.fansStatus_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m2041setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGoods(int i, Goods.Builder builder) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m2058build());
                return this;
            }
            ensureGoodsIsMutable();
            this.goods_.set(i, builder.m2058build());
            onChanged();
            return this;
        }

        public Builder setGoods(int i, Goods goods) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, goods);
                return this;
            } else if (goods != null) {
                ensureGoodsIsMutable();
                this.goods_.set(i, goods);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setHeight(int i) {
            this.height_ = i;
            onChanged();
            return this;
        }

        public Builder setInFanClub(int i) {
            this.inFanClub_ = i;
            onChanged();
            return this;
        }

        public Builder setLiangId(int i) {
            this.liangId_ = i;
            onChanged();
            return this;
        }

        public Builder setLiangType(int i) {
            this.liangType_ = i;
            onChanged();
            return this;
        }

        public Builder setLiveId(int i) {
            this.liveId_ = i;
            onChanged();
            return this;
        }

        public Builder setPayCode(String str) {
            if (str != null) {
                this.payCode_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPayCodeBytes(ByteString byteString) {
            if (byteString != null) {
                DrawGoods.checkByteStringIsUtf8(byteString);
                this.payCode_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPayToken(String str) {
            if (str != null) {
                this.payToken_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPayTokenBytes(ByteString byteString) {
            if (byteString != null) {
                DrawGoods.checkByteStringIsUtf8(byteString);
                this.payToken_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRememberMe(int i) {
            this.rememberMe_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m2043setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setTargetUid(int i) {
            this.targetUid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m2045setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setWidth(int i) {
            this.width_ = i;
            onChanged();
            return this;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/DrawGoods$Goods.class */
    public static final class Goods extends GeneratedMessageV3 implements GoodsOrBuilder {
        public static final int CONTENTS_FIELD_NUMBER = 7;
        public static final int EFFECT_BEANS_FIELD_NUMBER = 6;
        public static final int EFFECT_EXPIRE_FIELD_NUMBER = 5;
        public static final int EFFECT_ID_FIELD_NUMBER = 4;
        public static final int GOODS_ID_FIELD_NUMBER = 2;
        public static final int HIT_ID_FIELD_NUMBER = 3;
        public static final int IMAGES_STATIC_FIELD_NUMBER = 8;
        public static final int PATH_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object contents_;
        private int effectBeans_;
        private int effectExpire_;
        private int effectId_;
        private int goodsId_;
        private int hitId_;
        private volatile Object imagesStatic_;
        private byte memoizedIsInitialized;
        private List<Path> path_;
        private static final Goods DEFAULT_INSTANCE = new Goods();
        private static final Parser<Goods> PARSER = new AbstractParser<Goods>() { // from class: cn.irisgw.live.DrawGoods.Goods.1
            /* renamed from: parsePartialFrom */
            public Goods m2054parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Goods(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/DrawGoods$Goods$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GoodsOrBuilder {
            private int bitField0_;
            private Object contents_;
            private int effectBeans_;
            private int effectExpire_;
            private int effectId_;
            private int goodsId_;
            private int hitId_;
            private Object imagesStatic_;
            private RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> pathBuilder_;
            private List<Path> path_;

            private Builder() {
                this.path_ = Collections.emptyList();
                this.contents_ = "";
                this.imagesStatic_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.path_ = Collections.emptyList();
                this.contents_ = "";
                this.imagesStatic_ = "";
                maybeForceBuilderInitialization();
            }

            private void ensurePathIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.path_ = new ArrayList(this.path_);
                    this.bitField0_ |= 1;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_Goods_descriptor;
            }

            private RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> getPathFieldBuilder() {
                if (this.pathBuilder_ == null) {
                    List<Path> list = this.path_;
                    boolean z = true;
                    if ((this.bitField0_ & 1) == 0) {
                        z = false;
                    }
                    this.pathBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                    this.path_ = null;
                }
                return this.pathBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (Goods.alwaysUseFieldBuilders) {
                    getPathFieldBuilder();
                }
            }

            public Builder addAllPath(Iterable<? extends Path> iterable) {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                    return this;
                }
                ensurePathIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.path_);
                onChanged();
                return this;
            }

            public Builder addPath(int i, Path.Builder builder) {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, builder.m2105build());
                    return this;
                }
                ensurePathIsMutable();
                this.path_.add(i, builder.m2105build());
                onChanged();
                return this;
            }

            public Builder addPath(int i, Path path) {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, path);
                    return this;
                } else if (path != null) {
                    ensurePathIsMutable();
                    this.path_.add(i, path);
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder addPath(Path.Builder builder) {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(builder.m2105build());
                    return this;
                }
                ensurePathIsMutable();
                this.path_.add(builder.m2105build());
                onChanged();
                return this;
            }

            public Builder addPath(Path path) {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(path);
                    return this;
                } else if (path != null) {
                    ensurePathIsMutable();
                    this.path_.add(path);
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Path.Builder addPathBuilder() {
                return getPathFieldBuilder().addBuilder(Path.getDefaultInstance());
            }

            public Path.Builder addPathBuilder(int i) {
                return getPathFieldBuilder().addBuilder(i, Path.getDefaultInstance());
            }

            /* renamed from: addRepeatedField */
            public Builder m2056addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public Goods m2058build() {
                Goods m2060buildPartial = m2060buildPartial();
                if (m2060buildPartial.isInitialized()) {
                    return m2060buildPartial;
                }
                throw newUninitializedMessageException(m2060buildPartial);
            }

            /* renamed from: buildPartial */
            public Goods m2060buildPartial() {
                Goods goods = new Goods(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) != 0) {
                        this.path_ = Collections.unmodifiableList(this.path_);
                        this.bitField0_ &= -2;
                    }
                    goods.path_ = this.path_;
                } else {
                    goods.path_ = repeatedFieldBuilderV3.build();
                }
                goods.goodsId_ = this.goodsId_;
                goods.hitId_ = this.hitId_;
                goods.effectId_ = this.effectId_;
                goods.effectExpire_ = this.effectExpire_;
                goods.effectBeans_ = this.effectBeans_;
                goods.contents_ = this.contents_;
                goods.imagesStatic_ = this.imagesStatic_;
                onBuilt();
                return goods;
            }

            /* renamed from: clear */
            public Builder m2064clear() {
                super.clear();
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.path_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                this.goodsId_ = 0;
                this.hitId_ = 0;
                this.effectId_ = 0;
                this.effectExpire_ = 0;
                this.effectBeans_ = 0;
                this.contents_ = "";
                this.imagesStatic_ = "";
                return this;
            }

            public Builder clearContents() {
                this.contents_ = Goods.getDefaultInstance().getContents();
                onChanged();
                return this;
            }

            public Builder clearEffectBeans() {
                this.effectBeans_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEffectExpire() {
                this.effectExpire_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEffectId() {
                this.effectId_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m2066clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearGoodsId() {
                this.goodsId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearHitId() {
                this.hitId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearImagesStatic() {
                this.imagesStatic_ = Goods.getDefaultInstance().getImagesStatic();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m2069clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPath() {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.clear();
                    return this;
                }
                this.path_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m2075clone() {
                return (Builder) super.clone();
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public String getContents() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.contents_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public ByteString getContentsBytes() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.contents_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            /* renamed from: getDefaultInstanceForType */
            public Goods m2077getDefaultInstanceForType() {
                return Goods.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_Goods_descriptor;
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public int getEffectBeans() {
                return this.effectBeans_;
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public int getEffectExpire() {
                return this.effectExpire_;
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public int getEffectId() {
                return this.effectId_;
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public int getGoodsId() {
                return this.goodsId_;
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public int getHitId() {
                return this.hitId_;
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public String getImagesStatic() {
                Object obj = this.imagesStatic_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.imagesStatic_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public ByteString getImagesStaticBytes() {
                Object obj = this.imagesStatic_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.imagesStatic_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public Path getPath(int i) {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                return repeatedFieldBuilderV3 == null ? this.path_.get(i) : repeatedFieldBuilderV3.getMessage(i);
            }

            public Path.Builder getPathBuilder(int i) {
                return getPathFieldBuilder().getBuilder(i);
            }

            public List<Path.Builder> getPathBuilderList() {
                return getPathFieldBuilder().getBuilderList();
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public int getPathCount() {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                return repeatedFieldBuilderV3 == null ? this.path_.size() : repeatedFieldBuilderV3.getCount();
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public List<Path> getPathList() {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.path_) : repeatedFieldBuilderV3.getMessageList();
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public PathOrBuilder getPathOrBuilder(int i) {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                return repeatedFieldBuilderV3 == null ? this.path_.get(i) : (PathOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
            public List<? extends PathOrBuilder> getPathOrBuilderList() {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.path_);
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_Goods_fieldAccessorTable.ensureFieldAccessorsInitialized(Goods.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Goods goods) {
                if (goods == Goods.getDefaultInstance()) {
                    return this;
                }
                if (this.pathBuilder_ == null) {
                    if (!goods.path_.isEmpty()) {
                        if (this.path_.isEmpty()) {
                            this.path_ = goods.path_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePathIsMutable();
                            this.path_.addAll(goods.path_);
                        }
                        onChanged();
                    }
                } else if (!goods.path_.isEmpty()) {
                    if (this.pathBuilder_.isEmpty()) {
                        this.pathBuilder_.dispose();
                        RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = null;
                        this.pathBuilder_ = null;
                        this.path_ = goods.path_;
                        this.bitField0_ &= -2;
                        if (Goods.alwaysUseFieldBuilders) {
                            repeatedFieldBuilderV3 = getPathFieldBuilder();
                        }
                        this.pathBuilder_ = repeatedFieldBuilderV3;
                    } else {
                        this.pathBuilder_.addAllMessages(goods.path_);
                    }
                }
                if (goods.getGoodsId() != 0) {
                    setGoodsId(goods.getGoodsId());
                }
                if (goods.getHitId() != 0) {
                    setHitId(goods.getHitId());
                }
                if (goods.getEffectId() != 0) {
                    setEffectId(goods.getEffectId());
                }
                if (goods.getEffectExpire() != 0) {
                    setEffectExpire(goods.getEffectExpire());
                }
                if (goods.getEffectBeans() != 0) {
                    setEffectBeans(goods.getEffectBeans());
                }
                if (!goods.getContents().isEmpty()) {
                    this.contents_ = goods.contents_;
                    onChanged();
                }
                if (!goods.getImagesStatic().isEmpty()) {
                    this.imagesStatic_ = goods.imagesStatic_;
                    onChanged();
                }
                m2086mergeUnknownFields(goods.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.DrawGoods.Goods.Builder m2083mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.DrawGoods.Goods.access$2300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.DrawGoods$Goods r0 = (cn.irisgw.live.DrawGoods.Goods) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.DrawGoods$Goods$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.DrawGoods$Goods r0 = (cn.irisgw.live.DrawGoods.Goods) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.DrawGoods$Goods$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.DrawGoods.Goods.Builder.m2083mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.DrawGoods$Goods$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m2082mergeFrom(Message message) {
                if (message instanceof Goods) {
                    return mergeFrom((Goods) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m2086mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder removePath(int i) {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.remove(i);
                    return this;
                }
                ensurePathIsMutable();
                this.path_.remove(i);
                onChanged();
                return this;
            }

            public Builder setContents(String str) {
                if (str != null) {
                    this.contents_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setContentsBytes(ByteString byteString) {
                if (byteString != null) {
                    Goods.checkByteStringIsUtf8(byteString);
                    this.contents_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEffectBeans(int i) {
                this.effectBeans_ = i;
                onChanged();
                return this;
            }

            public Builder setEffectExpire(int i) {
                this.effectExpire_ = i;
                onChanged();
                return this;
            }

            public Builder setEffectId(int i) {
                this.effectId_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setField */
            public Builder m2088setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setGoodsId(int i) {
                this.goodsId_ = i;
                onChanged();
                return this;
            }

            public Builder setHitId(int i) {
                this.hitId_ = i;
                onChanged();
                return this;
            }

            public Builder setImagesStatic(String str) {
                if (str != null) {
                    this.imagesStatic_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setImagesStaticBytes(ByteString byteString) {
                if (byteString != null) {
                    Goods.checkByteStringIsUtf8(byteString);
                    this.imagesStatic_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPath(int i, Path.Builder builder) {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, builder.m2105build());
                    return this;
                }
                ensurePathIsMutable();
                this.path_.set(i, builder.m2105build());
                onChanged();
                return this;
            }

            public Builder setPath(int i, Path path) {
                RepeatedFieldBuilderV3<Path, Path.Builder, PathOrBuilder> repeatedFieldBuilderV3 = this.pathBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, path);
                    return this;
                } else if (path != null) {
                    ensurePathIsMutable();
                    this.path_.set(i, path);
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            /* renamed from: setRepeatedField */
            public Builder m2090setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* renamed from: setUnknownFields */
            public final Builder m2092setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/DrawGoods$Goods$Path.class */
        public static final class Path extends GeneratedMessageV3 implements PathOrBuilder {
            private static final Path DEFAULT_INSTANCE = new Path();
            private static final Parser<Path> PARSER = new AbstractParser<Path>() { // from class: cn.irisgw.live.DrawGoods.Goods.Path.1
                /* renamed from: parsePartialFrom */
                public Path m2101parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Path(codedInputStream, extensionRegistryLite);
                }
            };
            public static final int X_FIELD_NUMBER = 1;
            public static final int Y_FIELD_NUMBER = 2;
            private static final long serialVersionUID = 0;
            private byte memoizedIsInitialized;
            private int x_;
            private int y_;

            /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/DrawGoods$Goods$Path$Builder.class */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PathOrBuilder {
                private int x_;
                private int y_;

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    maybeForceBuilderInitialization();
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_Goods_Path_descriptor;
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = Path.alwaysUseFieldBuilders;
                }

                /* renamed from: addRepeatedField */
                public Builder m2103addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.addRepeatedField(fieldDescriptor, obj);
                }

                /* renamed from: build */
                public Path m2105build() {
                    Path m2107buildPartial = m2107buildPartial();
                    if (m2107buildPartial.isInitialized()) {
                        return m2107buildPartial;
                    }
                    throw newUninitializedMessageException(m2107buildPartial);
                }

                /* renamed from: buildPartial */
                public Path m2107buildPartial() {
                    Path path = new Path(this);
                    path.x_ = this.x_;
                    path.y_ = this.y_;
                    onBuilt();
                    return path;
                }

                /* renamed from: clear */
                public Builder m2111clear() {
                    super.clear();
                    this.x_ = 0;
                    this.y_ = 0;
                    return this;
                }

                /* renamed from: clearField */
                public Builder m2113clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                    return (Builder) super.clearField(fieldDescriptor);
                }

                /* renamed from: clearOneof */
                public Builder m2116clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                    return (Builder) super.clearOneof(oneofDescriptor);
                }

                public Builder clearX() {
                    this.x_ = 0;
                    onChanged();
                    return this;
                }

                public Builder clearY() {
                    this.y_ = 0;
                    onChanged();
                    return this;
                }

                /* renamed from: clone */
                public Builder m2122clone() {
                    return (Builder) super.clone();
                }

                /* renamed from: getDefaultInstanceForType */
                public Path m2124getDefaultInstanceForType() {
                    return Path.getDefaultInstance();
                }

                public Descriptors.Descriptor getDescriptorForType() {
                    return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_Goods_Path_descriptor;
                }

                @Override // cn.irisgw.live.DrawGoods.Goods.PathOrBuilder
                public int getX() {
                    return this.x_;
                }

                @Override // cn.irisgw.live.DrawGoods.Goods.PathOrBuilder
                public int getY() {
                    return this.y_;
                }

                public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_Goods_Path_fieldAccessorTable.ensureFieldAccessorsInitialized(Path.class, Builder.class);
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Builder mergeFrom(Path path) {
                    if (path == Path.getDefaultInstance()) {
                        return this;
                    }
                    if (path.getX() != 0) {
                        setX(path.getX());
                    }
                    if (path.getY() != 0) {
                        setY(path.getY());
                    }
                    m2133mergeUnknownFields(path.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
                /* renamed from: mergeFrom */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public cn.irisgw.live.DrawGoods.Goods.Path.Builder m2130mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                    /*
                        r4 = this;
                        r0 = 0
                        r7 = r0
                        com.google.protobuf.Parser r0 = cn.irisgw.live.DrawGoods.Goods.Path.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                        r1 = r5
                        r2 = r6
                        java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                        cn.irisgw.live.DrawGoods$Goods$Path r0 = (cn.irisgw.live.DrawGoods.Goods.Path) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                        r5 = r0
                        r0 = r5
                        if (r0 == 0) goto L1a
                        r0 = r4
                        r1 = r5
                        cn.irisgw.live.DrawGoods$Goods$Path$Builder r0 = r0.mergeFrom(r1)
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
                        cn.irisgw.live.DrawGoods$Goods$Path r0 = (cn.irisgw.live.DrawGoods.Goods.Path) r0     // Catch: java.lang.Throwable -> L1c
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
                        cn.irisgw.live.DrawGoods$Goods$Path$Builder r0 = r0.mergeFrom(r1)
                    L3b:
                        r0 = r6
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.DrawGoods.Goods.Path.Builder.m2130mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.DrawGoods$Goods$Path$Builder");
                }

                /* renamed from: mergeFrom */
                public Builder m2129mergeFrom(Message message) {
                    if (message instanceof Path) {
                        return mergeFrom((Path) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                /* renamed from: mergeUnknownFields */
                public final Builder m2133mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.mergeUnknownFields(unknownFieldSet);
                }

                /* renamed from: setField */
                public Builder m2135setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.setField(fieldDescriptor, obj);
                }

                /* renamed from: setRepeatedField */
                public Builder m2137setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                    return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
                }

                /* renamed from: setUnknownFields */
                public final Builder m2139setUnknownFields(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.setUnknownFields(unknownFieldSet);
                }

                public Builder setX(int i) {
                    this.x_ = i;
                    onChanged();
                    return this;
                }

                public Builder setY(int i) {
                    this.y_ = i;
                    onChanged();
                    return this;
                }
            }

            private Path() {
                this.memoizedIsInitialized = (byte) -1;
            }

            private Path(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    if (readTag == 8) {
                                        this.x_ = codedInputStream.readUInt32();
                                    } else if (readTag == 16) {
                                        this.y_ = codedInputStream.readUInt32();
                                    } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                }
                                z = true;
                            } catch (IOException e) {
                                throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } finally {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            private Path(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            public static Path getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_Goods_Path_descriptor;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.m2100toBuilder();
            }

            public static Builder newBuilder(Path path) {
                return DEFAULT_INSTANCE.m2100toBuilder().mergeFrom(path);
            }

            public static Path parseDelimitedFrom(InputStream inputStream) throws IOException {
                return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static Path parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Path parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Path) PARSER.parseFrom(byteString);
            }

            public static Path parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Path) PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static Path parseFrom(CodedInputStream codedInputStream) throws IOException {
                return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static Path parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            public static Path parseFrom(InputStream inputStream) throws IOException {
                return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static Path parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Path parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Path) PARSER.parseFrom(byteBuffer);
            }

            public static Path parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Path) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static Path parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Path) PARSER.parseFrom(bArr);
            }

            public static Path parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Path) PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static Parser<Path> parser() {
                return PARSER;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof Path) {
                    Path path = (Path) obj;
                    return getX() == path.getX() && getY() == path.getY() && this.unknownFields.equals(path.unknownFields);
                }
                return super.equals(obj);
            }

            /* renamed from: getDefaultInstanceForType */
            public Path m2095getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            public Parser<Path> getParserForType() {
                return PARSER;
            }

            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                int i3 = this.x_;
                if (i3 != 0) {
                    i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
                }
                int i4 = this.y_;
                int i5 = i2;
                if (i4 != 0) {
                    i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
                }
                int serializedSize = i5 + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            @Override // cn.irisgw.live.DrawGoods.Goods.PathOrBuilder
            public int getX() {
                return this.x_;
            }

            @Override // cn.irisgw.live.DrawGoods.Goods.PathOrBuilder
            public int getY() {
                return this.y_;
            }

            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getX()) * 37) + 2) * 53) + getY()) * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode;
                return hashCode;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_Goods_Path_fieldAccessorTable.ensureFieldAccessorsInitialized(Path.class, Builder.class);
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
            public Builder m2098newBuilderForType() {
                return newBuilder();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: newBuilderForType */
            public Builder m2097newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent);
            }

            public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new Path();
            }

            /* renamed from: toBuilder */
            public Builder m2100toBuilder() {
                return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.x_;
                if (i != 0) {
                    codedOutputStream.writeUInt32(1, i);
                }
                int i2 = this.y_;
                if (i2 != 0) {
                    codedOutputStream.writeUInt32(2, i2);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }
        }

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/DrawGoods$Goods$PathOrBuilder.class */
        public interface PathOrBuilder extends MessageOrBuilder {
            int getX();

            int getY();
        }

        private Goods() {
            this.memoizedIsInitialized = (byte) -1;
            this.path_ = Collections.emptyList();
            this.contents_ = "";
            this.imagesStatic_ = "";
        }

        private Goods(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    boolean z4 = z2;
                                    if (!(z2 & true)) {
                                        this.path_ = new ArrayList();
                                        z4 = z2 | true;
                                    }
                                    this.path_.add((Path) codedInputStream.readMessage(Path.parser(), extensionRegistryLite));
                                    z2 = z4;
                                } else if (readTag == 16) {
                                    this.goodsId_ = codedInputStream.readUInt32();
                                } else if (readTag == 24) {
                                    this.hitId_ = codedInputStream.readUInt32();
                                } else if (readTag == 32) {
                                    this.effectId_ = codedInputStream.readUInt32();
                                } else if (readTag == 40) {
                                    this.effectExpire_ = codedInputStream.readUInt32();
                                } else if (readTag == 48) {
                                    this.effectBeans_ = codedInputStream.readUInt32();
                                } else if (readTag == 58) {
                                    this.contents_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 66) {
                                    this.imagesStatic_ = codedInputStream.readStringRequireUtf8();
                                } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z3 & true) {
                        this.path_ = Collections.unmodifiableList(this.path_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.path_ = Collections.unmodifiableList(this.path_);
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private Goods(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Goods getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_Goods_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m2053toBuilder();
        }

        public static Builder newBuilder(Goods goods) {
            return DEFAULT_INSTANCE.m2053toBuilder().mergeFrom(goods);
        }

        public static Goods parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Goods parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Goods parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Goods) PARSER.parseFrom(byteString);
        }

        public static Goods parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Goods) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Goods parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Goods parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Goods parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Goods parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Goods parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Goods) PARSER.parseFrom(byteBuffer);
        }

        public static Goods parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Goods) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Goods parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Goods) PARSER.parseFrom(bArr);
        }

        public static Goods parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Goods) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Goods> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Goods) {
                Goods goods = (Goods) obj;
                return getPathList().equals(goods.getPathList()) && getGoodsId() == goods.getGoodsId() && getHitId() == goods.getHitId() && getEffectId() == goods.getEffectId() && getEffectExpire() == goods.getEffectExpire() && getEffectBeans() == goods.getEffectBeans() && getContents().equals(goods.getContents()) && getImagesStatic().equals(goods.getImagesStatic()) && this.unknownFields.equals(goods.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public String getContents() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.contents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public ByteString getContentsBytes() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.contents_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* renamed from: getDefaultInstanceForType */
        public Goods m2048getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public int getEffectBeans() {
            return this.effectBeans_;
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public int getEffectExpire() {
            return this.effectExpire_;
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public int getEffectId() {
            return this.effectId_;
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public int getGoodsId() {
            return this.goodsId_;
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public int getHitId() {
            return this.hitId_;
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public String getImagesStatic() {
            Object obj = this.imagesStatic_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.imagesStatic_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public ByteString getImagesStaticBytes() {
            Object obj = this.imagesStatic_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imagesStatic_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<Goods> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public Path getPath(int i) {
            return this.path_.get(i);
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public int getPathCount() {
            return this.path_.size();
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public List<Path> getPathList() {
            return this.path_;
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public PathOrBuilder getPathOrBuilder(int i) {
            return this.path_.get(i);
        }

        @Override // cn.irisgw.live.DrawGoods.GoodsOrBuilder
        public List<? extends PathOrBuilder> getPathOrBuilderList() {
            return this.path_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.path_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.path_.get(i3));
            }
            int i4 = this.goodsId_;
            int i5 = i2;
            if (i4 != 0) {
                i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
            }
            int i6 = this.hitId_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeUInt32Size(3, i6);
            }
            int i8 = this.effectId_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeUInt32Size(4, i8);
            }
            int i10 = this.effectExpire_;
            int i11 = i9;
            if (i10 != 0) {
                i11 = i9 + CodedOutputStream.computeUInt32Size(5, i10);
            }
            int i12 = this.effectBeans_;
            int i13 = i11;
            if (i12 != 0) {
                i13 = i11 + CodedOutputStream.computeUInt32Size(6, i12);
            }
            int i14 = i13;
            if (!getContentsBytes().isEmpty()) {
                i14 = i13 + GeneratedMessageV3.computeStringSize(7, this.contents_);
            }
            int i15 = i14;
            if (!getImagesStaticBytes().isEmpty()) {
                i15 = i14 + GeneratedMessageV3.computeStringSize(8, this.imagesStatic_);
            }
            int serializedSize = i15 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            int i = hashCode;
            if (getPathCount() > 0) {
                i = (((hashCode * 37) + 1) * 53) + getPathList().hashCode();
            }
            int goodsId = (((((((((((((((((((((((((((((i * 37) + 2) * 53) + getGoodsId()) * 37) + 3) * 53) + getHitId()) * 37) + 4) * 53) + getEffectId()) * 37) + 5) * 53) + getEffectExpire()) * 37) + 6) * 53) + getEffectBeans()) * 37) + 7) * 53) + getContents().hashCode()) * 37) + 8) * 53) + getImagesStatic().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = goodsId;
            return goodsId;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_Goods_fieldAccessorTable.ensureFieldAccessorsInitialized(Goods.class, Builder.class);
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
        public Builder m2051newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m2050newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Goods();
        }

        /* renamed from: toBuilder */
        public Builder m2053toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.path_.size()) {
                    break;
                }
                codedOutputStream.writeMessage(1, this.path_.get(i2));
                i = i2 + 1;
            }
            int i3 = this.goodsId_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(2, i3);
            }
            int i4 = this.hitId_;
            if (i4 != 0) {
                codedOutputStream.writeUInt32(3, i4);
            }
            int i5 = this.effectId_;
            if (i5 != 0) {
                codedOutputStream.writeUInt32(4, i5);
            }
            int i6 = this.effectExpire_;
            if (i6 != 0) {
                codedOutputStream.writeUInt32(5, i6);
            }
            int i7 = this.effectBeans_;
            if (i7 != 0) {
                codedOutputStream.writeUInt32(6, i7);
            }
            if (!getContentsBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.contents_);
            }
            if (!getImagesStaticBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.imagesStatic_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/DrawGoods$GoodsOrBuilder.class */
    public interface GoodsOrBuilder extends MessageOrBuilder {
        String getContents();

        ByteString getContentsBytes();

        int getEffectBeans();

        int getEffectExpire();

        int getEffectId();

        int getGoodsId();

        int getHitId();

        String getImagesStatic();

        ByteString getImagesStaticBytes();

        Goods.Path getPath(int i);

        int getPathCount();

        List<Goods.Path> getPathList();

        Goods.PathOrBuilder getPathOrBuilder(int i);

        List<? extends Goods.PathOrBuilder> getPathOrBuilderList();
    }

    private DrawGoods() {
        this.memoizedIsInitialized = (byte) -1;
        this.goods_ = Collections.emptyList();
        this.payToken_ = "";
        this.payCode_ = "";
        this.fanClubName_ = "";
        this.chatFrame_ = "";
        this.chatFrameIcon_ = "";
        this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
        this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
        this.chatBadgeUrl_ = "";
        this.avatarFrameUrl_ = "";
        this.bgImg_ = "";
        this.bgColor_ = LazyStringArrayList.EMPTY;
    }

    private DrawGoods(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        case 10:
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.goods_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.goods_.add((Goods) codedInputStream.readMessage(Goods.parser(), extensionRegistryLite));
                            z2 = z4;
                            continue;
                        case 16:
                            this.width_ = codedInputStream.readUInt32();
                            continue;
                        case 24:
                            this.height_ = codedInputStream.readUInt32();
                            continue;
                        case 34:
                            this.payToken_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 42:
                            this.payCode_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 48:
                            this.discountId_ = codedInputStream.readUInt32();
                            continue;
                        case 56:
                            this.rememberMe_ = codedInputStream.readUInt32();
                            continue;
                        case 64:
                            this.targetUid_ = codedInputStream.readUInt32();
                            continue;
                        case 72:
                            this.liveId_ = codedInputStream.readUInt32();
                            continue;
                        case 82:
                            this.fanClubName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 88:
                            this.fanClubLevel_ = codedInputStream.readUInt32();
                            continue;
                        case 96:
                            this.inFanClub_ = codedInputStream.readUInt32();
                            continue;
                        case 104:
                            this.fansStatus_ = codedInputStream.readUInt32();
                            continue;
                        case 112:
                            this.liangId_ = codedInputStream.readUInt32();
                            continue;
                        case 120:
                            this.liangType_ = codedInputStream.readUInt32();
                            continue;
                        case 128:
                            this.beansCurrentCount_ = codedInputStream.readUInt64();
                            continue;
                        case 138:
                            this.chatFrame_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 146:
                            this.chatFrameIcon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 152:
                            this.chatFrameColorType_ = codedInputStream.readInt32();
                            continue;
                        case 160:
                            this.chatFrameGradientType_ = codedInputStream.readInt32();
                            continue;
                        case 170:
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameFrameColor_ = new LazyStringArrayList();
                                z5 = z2 | true;
                            }
                            this.chatFrameFrameColor_.add(readStringRequireUtf8);
                            z2 = z5;
                            continue;
                        case 178:
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            boolean z6 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameBorderColor_ = new LazyStringArrayList();
                                z6 = z2 | true;
                            }
                            this.chatFrameBorderColor_.add(readStringRequireUtf82);
                            z2 = z6;
                            continue;
                        case 186:
                            this.chatBadgeUrl_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 192:
                            this.chatBadgeLength_ = codedInputStream.readInt32();
                            continue;
                        case 200:
                            this.chatBadgeHeight_ = codedInputStream.readInt32();
                            continue;
                        case 210:
                            this.avatarFrameUrl_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 218:
                            this.bgImg_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 226:
                            String readStringRequireUtf83 = codedInputStream.readStringRequireUtf8();
                            boolean z7 = z2;
                            if (!(z2 & true)) {
                                this.bgColor_ = new LazyStringArrayList();
                                z7 = z2 | true;
                            }
                            this.bgColor_.add(readStringRequireUtf83);
                            z2 = z7;
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
                    this.goods_ = Collections.unmodifiableList(this.goods_);
                }
                if (z3 & true) {
                    this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                }
                if (z3 & true) {
                    this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                }
                if (z3 & true) {
                    this.bgColor_ = this.bgColor_.getUnmodifiableView();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.goods_ = Collections.unmodifiableList(this.goods_);
        }
        if (z2 & true) {
            this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
        }
        if (z2 & true) {
            this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
        }
        if (z2 & true) {
            this.bgColor_ = this.bgColor_.getUnmodifiableView();
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private DrawGoods(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static DrawGoods getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m2006toBuilder();
    }

    public static Builder newBuilder(DrawGoods drawGoods) {
        return DEFAULT_INSTANCE.m2006toBuilder().mergeFrom(drawGoods);
    }

    public static DrawGoods parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DrawGoods parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DrawGoods parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (DrawGoods) PARSER.parseFrom(byteString);
    }

    public static DrawGoods parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DrawGoods) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DrawGoods parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DrawGoods parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DrawGoods parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DrawGoods parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DrawGoods parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (DrawGoods) PARSER.parseFrom(byteBuffer);
    }

    public static DrawGoods parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DrawGoods) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DrawGoods parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (DrawGoods) PARSER.parseFrom(bArr);
    }

    public static DrawGoods parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DrawGoods) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<DrawGoods> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DrawGoods) {
            DrawGoods drawGoods = (DrawGoods) obj;
            return getGoodsList().equals(drawGoods.getGoodsList()) && getWidth() == drawGoods.getWidth() && getHeight() == drawGoods.getHeight() && getPayToken().equals(drawGoods.getPayToken()) && getPayCode().equals(drawGoods.getPayCode()) && getDiscountId() == drawGoods.getDiscountId() && getRememberMe() == drawGoods.getRememberMe() && getTargetUid() == drawGoods.getTargetUid() && getLiveId() == drawGoods.getLiveId() && getFanClubName().equals(drawGoods.getFanClubName()) && getFanClubLevel() == drawGoods.getFanClubLevel() && getInFanClub() == drawGoods.getInFanClub() && getFansStatus() == drawGoods.getFansStatus() && getLiangId() == drawGoods.getLiangId() && getLiangType() == drawGoods.getLiangType() && getBeansCurrentCount() == drawGoods.getBeansCurrentCount() && getChatFrame().equals(drawGoods.getChatFrame()) && getChatFrameIcon().equals(drawGoods.getChatFrameIcon()) && getChatFrameColorType() == drawGoods.getChatFrameColorType() && getChatFrameGradientType() == drawGoods.getChatFrameGradientType() && mo1999getChatFrameFrameColorList().equals(drawGoods.mo1999getChatFrameFrameColorList()) && mo1998getChatFrameBorderColorList().equals(drawGoods.mo1998getChatFrameBorderColorList()) && getChatBadgeUrl().equals(drawGoods.getChatBadgeUrl()) && getChatBadgeLength() == drawGoods.getChatBadgeLength() && getChatBadgeHeight() == drawGoods.getChatBadgeHeight() && getAvatarFrameUrl().equals(drawGoods.getAvatarFrameUrl()) && getBgImg().equals(drawGoods.getBgImg()) && mo1997getBgColorList().equals(drawGoods.mo1997getBgColorList()) && this.unknownFields.equals(drawGoods.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public String getAvatarFrameUrl() {
        Object obj = this.avatarFrameUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatarFrameUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public ByteString getAvatarFrameUrlBytes() {
        Object obj = this.avatarFrameUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.avatarFrameUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public long getBeansCurrentCount() {
        return this.beansCurrentCount_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public String getBgColor(int i) {
        return (String) this.bgColor_.get(i);
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public ByteString getBgColorBytes(int i) {
        return this.bgColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getBgColorCount() {
        return this.bgColor_.size();
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    /* renamed from: getBgColorList */
    public ProtocolStringList mo1997getBgColorList() {
        return this.bgColor_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public String getBgImg() {
        Object obj = this.bgImg_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.bgImg_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public ByteString getBgImgBytes() {
        Object obj = this.bgImg_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bgImg_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getChatBadgeHeight() {
        return this.chatBadgeHeight_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getChatBadgeLength() {
        return this.chatBadgeLength_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public String getChatBadgeUrl() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatBadgeUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public ByteString getChatBadgeUrlBytes() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatBadgeUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public String getChatFrame() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrame_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public String getChatFrameBorderColor(int i) {
        return (String) this.chatFrameBorderColor_.get(i);
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public ByteString getChatFrameBorderColorBytes(int i) {
        return this.chatFrameBorderColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getChatFrameBorderColorCount() {
        return this.chatFrameBorderColor_.size();
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    /* renamed from: getChatFrameBorderColorList */
    public ProtocolStringList mo1998getChatFrameBorderColorList() {
        return this.chatFrameBorderColor_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public ByteString getChatFrameBytes() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrame_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getChatFrameColorType() {
        return this.chatFrameColorType_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public String getChatFrameFrameColor(int i) {
        return (String) this.chatFrameFrameColor_.get(i);
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public ByteString getChatFrameFrameColorBytes(int i) {
        return this.chatFrameFrameColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getChatFrameFrameColorCount() {
        return this.chatFrameFrameColor_.size();
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    /* renamed from: getChatFrameFrameColorList */
    public ProtocolStringList mo1999getChatFrameFrameColorList() {
        return this.chatFrameFrameColor_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getChatFrameGradientType() {
        return this.chatFrameGradientType_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public String getChatFrameIcon() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrameIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public ByteString getChatFrameIconBytes() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrameIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    /* renamed from: getDefaultInstanceForType */
    public DrawGoods m2001getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getDiscountId() {
        return this.discountId_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getFanClubLevel() {
        return this.fanClubLevel_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public String getFanClubName() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.fanClubName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public ByteString getFanClubNameBytes() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fanClubName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getFansStatus() {
        return this.fansStatus_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public Goods getGoods(int i) {
        return this.goods_.get(i);
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getGoodsCount() {
        return this.goods_.size();
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public List<Goods> getGoodsList() {
        return this.goods_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public GoodsOrBuilder getGoodsOrBuilder(int i) {
        return this.goods_.get(i);
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public List<? extends GoodsOrBuilder> getGoodsOrBuilderList() {
        return this.goods_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getHeight() {
        return this.height_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getInFanClub() {
        return this.inFanClub_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getLiangId() {
        return this.liangId_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getLiangType() {
        return this.liangType_;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getLiveId() {
        return this.liveId_;
    }

    public Parser<DrawGoods> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public String getPayCode() {
        Object obj = this.payCode_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.payCode_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public ByteString getPayCodeBytes() {
        Object obj = this.payCode_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.payCode_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public String getPayToken() {
        Object obj = this.payToken_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.payToken_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public ByteString getPayTokenBytes() {
        Object obj = this.payToken_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.payToken_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getRememberMe() {
        return this.rememberMe_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.goods_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.goods_.get(i3));
        }
        int i4 = this.width_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int i6 = this.height_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeUInt32Size(3, i6);
        }
        int i8 = i7;
        if (!getPayTokenBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(4, this.payToken_);
        }
        int i9 = i8;
        if (!getPayCodeBytes().isEmpty()) {
            i9 = i8 + GeneratedMessageV3.computeStringSize(5, this.payCode_);
        }
        int i10 = this.discountId_;
        int i11 = i9;
        if (i10 != 0) {
            i11 = i9 + CodedOutputStream.computeUInt32Size(6, i10);
        }
        int i12 = this.rememberMe_;
        int i13 = i11;
        if (i12 != 0) {
            i13 = i11 + CodedOutputStream.computeUInt32Size(7, i12);
        }
        int i14 = this.targetUid_;
        int i15 = i13;
        if (i14 != 0) {
            i15 = i13 + CodedOutputStream.computeUInt32Size(8, i14);
        }
        int i16 = this.liveId_;
        int i17 = i15;
        if (i16 != 0) {
            i17 = i15 + CodedOutputStream.computeUInt32Size(9, i16);
        }
        int i18 = i17;
        if (!getFanClubNameBytes().isEmpty()) {
            i18 = i17 + GeneratedMessageV3.computeStringSize(10, this.fanClubName_);
        }
        int i19 = this.fanClubLevel_;
        int i20 = i18;
        if (i19 != 0) {
            i20 = i18 + CodedOutputStream.computeUInt32Size(11, i19);
        }
        int i21 = this.inFanClub_;
        int i22 = i20;
        if (i21 != 0) {
            i22 = i20 + CodedOutputStream.computeUInt32Size(12, i21);
        }
        int i23 = this.fansStatus_;
        int i24 = i22;
        if (i23 != 0) {
            i24 = i22 + CodedOutputStream.computeUInt32Size(13, i23);
        }
        int i25 = this.liangId_;
        int i26 = i24;
        if (i25 != 0) {
            i26 = i24 + CodedOutputStream.computeUInt32Size(14, i25);
        }
        int i27 = this.liangType_;
        int i28 = i26;
        if (i27 != 0) {
            i28 = i26 + CodedOutputStream.computeUInt32Size(15, i27);
        }
        long j = this.beansCurrentCount_;
        int i29 = i28;
        if (j != serialVersionUID) {
            i29 = i28 + CodedOutputStream.computeUInt64Size(16, j);
        }
        int i30 = i29;
        if (!getChatFrameBytes().isEmpty()) {
            i30 = i29 + GeneratedMessageV3.computeStringSize(17, this.chatFrame_);
        }
        int i31 = i30;
        if (!getChatFrameIconBytes().isEmpty()) {
            i31 = i30 + GeneratedMessageV3.computeStringSize(18, this.chatFrameIcon_);
        }
        int i32 = this.chatFrameColorType_;
        int i33 = i31;
        if (i32 != 0) {
            i33 = i31 + CodedOutputStream.computeInt32Size(19, i32);
        }
        int i34 = this.chatFrameGradientType_;
        int i35 = i33;
        if (i34 != 0) {
            i35 = i33 + CodedOutputStream.computeInt32Size(20, i34);
        }
        int i36 = 0;
        for (int i37 = 0; i37 < this.chatFrameFrameColor_.size(); i37++) {
            i36 += computeStringSizeNoTag(this.chatFrameFrameColor_.getRaw(i37));
        }
        int size = mo1999getChatFrameFrameColorList().size();
        int i38 = 0;
        for (int i39 = 0; i39 < this.chatFrameBorderColor_.size(); i39++) {
            i38 += computeStringSizeNoTag(this.chatFrameBorderColor_.getRaw(i39));
        }
        int size2 = i35 + i36 + (size * 2) + i38 + (mo1998getChatFrameBorderColorList().size() * 2);
        int i40 = size2;
        if (!getChatBadgeUrlBytes().isEmpty()) {
            i40 = size2 + GeneratedMessageV3.computeStringSize(23, this.chatBadgeUrl_);
        }
        int i41 = this.chatBadgeLength_;
        int i42 = i40;
        if (i41 != 0) {
            i42 = i40 + CodedOutputStream.computeInt32Size(24, i41);
        }
        int i43 = this.chatBadgeHeight_;
        int i44 = i42;
        if (i43 != 0) {
            i44 = i42 + CodedOutputStream.computeInt32Size(25, i43);
        }
        int i45 = i44;
        if (!getAvatarFrameUrlBytes().isEmpty()) {
            i45 = i44 + GeneratedMessageV3.computeStringSize(26, this.avatarFrameUrl_);
        }
        int i46 = i45;
        if (!getBgImgBytes().isEmpty()) {
            i46 = i45 + GeneratedMessageV3.computeStringSize(27, this.bgImg_);
        }
        int i47 = 0;
        int i48 = 0;
        while (true) {
            int i49 = i48;
            if (i49 >= this.bgColor_.size()) {
                int size3 = i46 + i47 + (mo1997getBgColorList().size() * 2) + this.unknownFields.getSerializedSize();
                this.memoizedSize = size3;
                return size3;
            }
            i47 += computeStringSizeNoTag(this.bgColor_.getRaw(i49));
            i48 = i49 + 1;
        }
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getTargetUid() {
        return this.targetUid_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.DrawGoodsOrBuilder
    public int getWidth() {
        return this.width_;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (getGoodsCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getGoodsList().hashCode();
        }
        int width = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((i * 37) + 2) * 53) + getWidth()) * 37) + 3) * 53) + getHeight()) * 37) + 4) * 53) + getPayToken().hashCode()) * 37) + 5) * 53) + getPayCode().hashCode()) * 37) + 6) * 53) + getDiscountId()) * 37) + 7) * 53) + getRememberMe()) * 37) + 8) * 53) + getTargetUid()) * 37) + 9) * 53) + getLiveId()) * 37) + 10) * 53) + getFanClubName().hashCode()) * 37) + 11) * 53) + getFanClubLevel()) * 37) + 12) * 53) + getInFanClub()) * 37) + 13) * 53) + getFansStatus()) * 37) + 14) * 53) + getLiangId()) * 37) + 15) * 53) + getLiangType()) * 37) + 16) * 53) + Internal.hashLong(getBeansCurrentCount())) * 37) + 17) * 53) + getChatFrame().hashCode()) * 37) + 18) * 53) + getChatFrameIcon().hashCode()) * 37) + 19) * 53) + getChatFrameColorType()) * 37) + 20) * 53) + getChatFrameGradientType();
        int i2 = width;
        if (getChatFrameFrameColorCount() > 0) {
            i2 = (((width * 37) + 21) * 53) + mo1999getChatFrameFrameColorList().hashCode();
        }
        int i3 = i2;
        if (getChatFrameBorderColorCount() > 0) {
            i3 = (((i2 * 37) + 22) * 53) + mo1998getChatFrameBorderColorList().hashCode();
        }
        int hashCode2 = (((((((((((((((((((i3 * 37) + 23) * 53) + getChatBadgeUrl().hashCode()) * 37) + 24) * 53) + getChatBadgeLength()) * 37) + 25) * 53) + getChatBadgeHeight()) * 37) + 26) * 53) + getAvatarFrameUrl().hashCode()) * 37) + 27) * 53) + getBgImg().hashCode();
        int i4 = hashCode2;
        if (getBgColorCount() > 0) {
            i4 = (((hashCode2 * 37) + 28) * 53) + mo1997getBgColorList().hashCode();
        }
        int hashCode3 = (i4 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode3;
        return hashCode3;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_DrawGoods_fieldAccessorTable.ensureFieldAccessorsInitialized(DrawGoods.class, Builder.class);
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
    public Builder m2004newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m2003newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new DrawGoods();
    }

    /* renamed from: toBuilder */
    public Builder m2006toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.goods_.size()) {
                break;
            }
            codedOutputStream.writeMessage(1, this.goods_.get(i2));
            i = i2 + 1;
        }
        int i3 = this.width_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(2, i3);
        }
        int i4 = this.height_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(3, i4);
        }
        if (!getPayTokenBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.payToken_);
        }
        if (!getPayCodeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.payCode_);
        }
        int i5 = this.discountId_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(6, i5);
        }
        int i6 = this.rememberMe_;
        if (i6 != 0) {
            codedOutputStream.writeUInt32(7, i6);
        }
        int i7 = this.targetUid_;
        if (i7 != 0) {
            codedOutputStream.writeUInt32(8, i7);
        }
        int i8 = this.liveId_;
        if (i8 != 0) {
            codedOutputStream.writeUInt32(9, i8);
        }
        if (!getFanClubNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 10, this.fanClubName_);
        }
        int i9 = this.fanClubLevel_;
        if (i9 != 0) {
            codedOutputStream.writeUInt32(11, i9);
        }
        int i10 = this.inFanClub_;
        if (i10 != 0) {
            codedOutputStream.writeUInt32(12, i10);
        }
        int i11 = this.fansStatus_;
        if (i11 != 0) {
            codedOutputStream.writeUInt32(13, i11);
        }
        int i12 = this.liangId_;
        if (i12 != 0) {
            codedOutputStream.writeUInt32(14, i12);
        }
        int i13 = this.liangType_;
        if (i13 != 0) {
            codedOutputStream.writeUInt32(15, i13);
        }
        long j = this.beansCurrentCount_;
        if (j != serialVersionUID) {
            codedOutputStream.writeUInt64(16, j);
        }
        if (!getChatFrameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 17, this.chatFrame_);
        }
        if (!getChatFrameIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 18, this.chatFrameIcon_);
        }
        int i14 = this.chatFrameColorType_;
        if (i14 != 0) {
            codedOutputStream.writeInt32(19, i14);
        }
        int i15 = this.chatFrameGradientType_;
        if (i15 != 0) {
            codedOutputStream.writeInt32(20, i15);
        }
        int i16 = 0;
        while (true) {
            int i17 = i16;
            if (i17 >= this.chatFrameFrameColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 21, this.chatFrameFrameColor_.getRaw(i17));
            i16 = i17 + 1;
        }
        int i18 = 0;
        while (true) {
            int i19 = i18;
            if (i19 >= this.chatFrameBorderColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 22, this.chatFrameBorderColor_.getRaw(i19));
            i18 = i19 + 1;
        }
        if (!getChatBadgeUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 23, this.chatBadgeUrl_);
        }
        int i20 = this.chatBadgeLength_;
        if (i20 != 0) {
            codedOutputStream.writeInt32(24, i20);
        }
        int i21 = this.chatBadgeHeight_;
        if (i21 != 0) {
            codedOutputStream.writeInt32(25, i21);
        }
        if (!getAvatarFrameUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 26, this.avatarFrameUrl_);
        }
        int i22 = 0;
        if (!getBgImgBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 27, this.bgImg_);
            i22 = 0;
        }
        while (i22 < this.bgColor_.size()) {
            GeneratedMessageV3.writeString(codedOutputStream, 28, this.bgColor_.getRaw(i22));
            i22++;
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
