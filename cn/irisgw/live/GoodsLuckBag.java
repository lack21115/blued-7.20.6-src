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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GoodsLuckBag.class */
public final class GoodsLuckBag extends GeneratedMessageV3 implements GoodsLuckBagOrBuilder {
    public static final int ANIMATION_FIELD_NUMBER = 9;
    public static final int ANIM_CODE_FIELD_NUMBER = 7;
    public static final int AVATAR_FRAME_URL_FIELD_NUMBER = 26;
    public static final int BEANS_COUNT_FIELD_NUMBER = 5;
    public static final int BEANS_CURRENT_COUNT_FIELD_NUMBER = 6;
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
    public static final int FANS_STATUS_FIELD_NUMBER = 13;
    public static final int FAN_CLUB_LEVEL_FIELD_NUMBER = 11;
    public static final int FAN_CLUB_NAME_FIELD_NUMBER = 10;
    public static final int GOODS_FIELD_NUMBER = 1;
    public static final int HIT_BATCH_FIELD_NUMBER = 4;
    public static final int HIT_COUNT_FIELD_NUMBER = 2;
    public static final int HIT_ID_FIELD_NUMBER = 3;
    public static final int IN_FAN_CLUB_FIELD_NUMBER = 12;
    public static final int LANTERN_ID_FIELD_NUMBER = 30;
    public static final int LANTERN_IMAGE_FIELD_NUMBER = 29;
    public static final int LANTERN_PLAY_TIMES_FIELD_NUMBER = 31;
    public static final int LIANG_ID_FIELD_NUMBER = 15;
    public static final int LIANG_TYPE_FIELD_NUMBER = 14;
    public static final int RECHARGE_BADGE_FIELD_NUMBER = 16;
    public static final int TYPE_NAME_FIELD_NUMBER = 8;
    private static final long serialVersionUID = 0;
    private volatile Object animCode_;
    private int animation_;
    private volatile Object avatarFrameUrl_;
    private long beansCount_;
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
    private int fanClubLevel_;
    private volatile Object fanClubName_;
    private int fansStatus_;
    private List<Goods> goods_;
    private int hitBatch_;
    private int hitCount_;
    private long hitId_;
    private boolean inFanClub_;
    private int lanternId_;
    private List<lantern_resource> lanternImage_;
    private int lanternPlayTimes_;
    private volatile Object liangId_;
    private int liangType_;
    private byte memoizedIsInitialized;
    private int rechargeBadge_;
    private volatile Object typeName_;
    private static final GoodsLuckBag DEFAULT_INSTANCE = new GoodsLuckBag();
    private static final Parser<GoodsLuckBag> PARSER = new AbstractParser<GoodsLuckBag>() { // from class: cn.irisgw.live.GoodsLuckBag.1
        @Override // com.google.protobuf.Parser
        public GoodsLuckBag parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new GoodsLuckBag(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GoodsLuckBag$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GoodsLuckBagOrBuilder {
        private Object animCode_;
        private int animation_;
        private Object avatarFrameUrl_;
        private long beansCount_;
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
        private int fanClubLevel_;
        private Object fanClubName_;
        private int fansStatus_;
        private RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> goodsBuilder_;
        private List<Goods> goods_;
        private int hitBatch_;
        private int hitCount_;
        private long hitId_;
        private boolean inFanClub_;
        private int lanternId_;
        private RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> lanternImageBuilder_;
        private List<lantern_resource> lanternImage_;
        private int lanternPlayTimes_;
        private Object liangId_;
        private int liangType_;
        private int rechargeBadge_;
        private Object typeName_;

        private Builder() {
            this.goods_ = Collections.emptyList();
            this.animCode_ = "";
            this.typeName_ = "";
            this.fanClubName_ = "";
            this.fansStatus_ = 0;
            this.liangType_ = 0;
            this.liangId_ = "";
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.chatBadgeUrl_ = "";
            this.avatarFrameUrl_ = "";
            this.bgImg_ = "";
            this.bgColor_ = LazyStringArrayList.EMPTY;
            this.lanternImage_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.goods_ = Collections.emptyList();
            this.animCode_ = "";
            this.typeName_ = "";
            this.fanClubName_ = "";
            this.fansStatus_ = 0;
            this.liangType_ = 0;
            this.liangId_ = "";
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.chatBadgeUrl_ = "";
            this.avatarFrameUrl_ = "";
            this.bgImg_ = "";
            this.bgColor_ = LazyStringArrayList.EMPTY;
            this.lanternImage_ = Collections.emptyList();
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

        private void ensureLanternImageIsMutable() {
            if ((this.bitField0_ & 16) == 0) {
                this.lanternImage_ = new ArrayList(this.lanternImage_);
                this.bitField0_ |= 16;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_descriptor;
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

        private RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> getLanternImageFieldBuilder() {
            if (this.lanternImageBuilder_ == null) {
                this.lanternImageBuilder_ = new RepeatedFieldBuilderV3<>(this.lanternImage_, (this.bitField0_ & 16) != 0, getParentForChildren(), isClean());
                this.lanternImage_ = null;
            }
            return this.lanternImageBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GoodsLuckBag.alwaysUseFieldBuilders) {
                getGoodsFieldBuilder();
                getLanternImageFieldBuilder();
            }
        }

        public Builder addAllBgColor(Iterable<String> iterable) {
            ensureBgColorIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.bgColor_);
            onChanged();
            return this;
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

        public Builder addAllGoods(Iterable<? extends Goods> iterable) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureGoodsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.goods_);
            onChanged();
            return this;
        }

        public Builder addAllLanternImage(Iterable<? extends lantern_resource> iterable) {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureLanternImageIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.lanternImage_);
            onChanged();
            return this;
        }

        public Builder addBgColor(String str) {
            if (str != null) {
                ensureBgColorIsMutable();
                this.bgColor_.add((LazyStringList) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addBgColorBytes(ByteString byteString) {
            if (byteString != null) {
                GoodsLuckBag.checkByteStringIsUtf8(byteString);
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
                this.chatFrameBorderColor_.add((LazyStringList) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addChatFrameBorderColorBytes(ByteString byteString) {
            if (byteString != null) {
                GoodsLuckBag.checkByteStringIsUtf8(byteString);
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
                GoodsLuckBag.checkByteStringIsUtf8(byteString);
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
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureGoodsIsMutable();
            this.goods_.add(i, builder.build());
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
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureGoodsIsMutable();
            this.goods_.add(builder.build());
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

        public Builder addLanternImage(int i, lantern_resource.Builder builder) {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureLanternImageIsMutable();
            this.lanternImage_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addLanternImage(int i, lantern_resource lantern_resourceVar) {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, lantern_resourceVar);
                return this;
            } else if (lantern_resourceVar != null) {
                ensureLanternImageIsMutable();
                this.lanternImage_.add(i, lantern_resourceVar);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addLanternImage(lantern_resource.Builder builder) {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureLanternImageIsMutable();
            this.lanternImage_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addLanternImage(lantern_resource lantern_resourceVar) {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(lantern_resourceVar);
                return this;
            } else if (lantern_resourceVar != null) {
                ensureLanternImageIsMutable();
                this.lanternImage_.add(lantern_resourceVar);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public lantern_resource.Builder addLanternImageBuilder() {
            return getLanternImageFieldBuilder().addBuilder(lantern_resource.getDefaultInstance());
        }

        public lantern_resource.Builder addLanternImageBuilder(int i) {
            return getLanternImageFieldBuilder().addBuilder(i, lantern_resource.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GoodsLuckBag build() {
            GoodsLuckBag buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GoodsLuckBag buildPartial() {
            GoodsLuckBag goodsLuckBag = new GoodsLuckBag(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.goods_ = Collections.unmodifiableList(this.goods_);
                    this.bitField0_ &= -2;
                }
                goodsLuckBag.goods_ = this.goods_;
            } else {
                goodsLuckBag.goods_ = repeatedFieldBuilderV3.build();
            }
            goodsLuckBag.hitCount_ = this.hitCount_;
            goodsLuckBag.hitId_ = this.hitId_;
            goodsLuckBag.hitBatch_ = this.hitBatch_;
            goodsLuckBag.beansCount_ = this.beansCount_;
            goodsLuckBag.beansCurrentCount_ = this.beansCurrentCount_;
            goodsLuckBag.animCode_ = this.animCode_;
            goodsLuckBag.typeName_ = this.typeName_;
            goodsLuckBag.animation_ = this.animation_;
            goodsLuckBag.fanClubName_ = this.fanClubName_;
            goodsLuckBag.fanClubLevel_ = this.fanClubLevel_;
            goodsLuckBag.inFanClub_ = this.inFanClub_;
            goodsLuckBag.fansStatus_ = this.fansStatus_;
            goodsLuckBag.liangType_ = this.liangType_;
            goodsLuckBag.liangId_ = this.liangId_;
            goodsLuckBag.rechargeBadge_ = this.rechargeBadge_;
            goodsLuckBag.chatFrame_ = this.chatFrame_;
            goodsLuckBag.chatFrameIcon_ = this.chatFrameIcon_;
            goodsLuckBag.chatFrameColorType_ = this.chatFrameColorType_;
            goodsLuckBag.chatFrameGradientType_ = this.chatFrameGradientType_;
            if ((this.bitField0_ & 2) != 0) {
                this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            goodsLuckBag.chatFrameFrameColor_ = this.chatFrameFrameColor_;
            if ((this.bitField0_ & 4) != 0) {
                this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                this.bitField0_ &= -5;
            }
            goodsLuckBag.chatFrameBorderColor_ = this.chatFrameBorderColor_;
            goodsLuckBag.chatBadgeUrl_ = this.chatBadgeUrl_;
            goodsLuckBag.chatBadgeLength_ = this.chatBadgeLength_;
            goodsLuckBag.chatBadgeHeight_ = this.chatBadgeHeight_;
            goodsLuckBag.avatarFrameUrl_ = this.avatarFrameUrl_;
            goodsLuckBag.bgImg_ = this.bgImg_;
            if ((this.bitField0_ & 8) != 0) {
                this.bgColor_ = this.bgColor_.getUnmodifiableView();
                this.bitField0_ &= -9;
            }
            goodsLuckBag.bgColor_ = this.bgColor_;
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV32 = this.lanternImageBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                if ((this.bitField0_ & 16) != 0) {
                    this.lanternImage_ = Collections.unmodifiableList(this.lanternImage_);
                    this.bitField0_ &= -17;
                }
                goodsLuckBag.lanternImage_ = this.lanternImage_;
            } else {
                goodsLuckBag.lanternImage_ = repeatedFieldBuilderV32.build();
            }
            goodsLuckBag.lanternId_ = this.lanternId_;
            goodsLuckBag.lanternPlayTimes_ = this.lanternPlayTimes_;
            onBuilt();
            return goodsLuckBag;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.goods_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.hitCount_ = 0;
            this.hitId_ = 0L;
            this.hitBatch_ = 0;
            this.beansCount_ = 0L;
            this.beansCurrentCount_ = 0L;
            this.animCode_ = "";
            this.typeName_ = "";
            this.animation_ = 0;
            this.fanClubName_ = "";
            this.fanClubLevel_ = 0;
            this.inFanClub_ = false;
            this.fansStatus_ = 0;
            this.liangType_ = 0;
            this.liangId_ = "";
            this.rechargeBadge_ = 0;
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
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV32 = this.lanternImageBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                this.lanternImage_ = Collections.emptyList();
                this.bitField0_ &= -17;
            } else {
                repeatedFieldBuilderV32.clear();
            }
            this.lanternId_ = 0;
            this.lanternPlayTimes_ = 0;
            return this;
        }

        public Builder clearAnimCode() {
            this.animCode_ = GoodsLuckBag.getDefaultInstance().getAnimCode();
            onChanged();
            return this;
        }

        public Builder clearAnimation() {
            this.animation_ = 0;
            onChanged();
            return this;
        }

        public Builder clearAvatarFrameUrl() {
            this.avatarFrameUrl_ = GoodsLuckBag.getDefaultInstance().getAvatarFrameUrl();
            onChanged();
            return this;
        }

        public Builder clearBeansCount() {
            this.beansCount_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearBeansCurrentCount() {
            this.beansCurrentCount_ = 0L;
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
            this.bgImg_ = GoodsLuckBag.getDefaultInstance().getBgImg();
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
            this.chatBadgeUrl_ = GoodsLuckBag.getDefaultInstance().getChatBadgeUrl();
            onChanged();
            return this;
        }

        public Builder clearChatFrame() {
            this.chatFrame_ = GoodsLuckBag.getDefaultInstance().getChatFrame();
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
            this.chatFrameIcon_ = GoodsLuckBag.getDefaultInstance().getChatFrameIcon();
            onChanged();
            return this;
        }

        public Builder clearFanClubLevel() {
            this.fanClubLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearFanClubName() {
            this.fanClubName_ = GoodsLuckBag.getDefaultInstance().getFanClubName();
            onChanged();
            return this;
        }

        public Builder clearFansStatus() {
            this.fansStatus_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
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

        public Builder clearHitBatch() {
            this.hitBatch_ = 0;
            onChanged();
            return this;
        }

        public Builder clearHitCount() {
            this.hitCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearHitId() {
            this.hitId_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearInFanClub() {
            this.inFanClub_ = false;
            onChanged();
            return this;
        }

        public Builder clearLanternId() {
            this.lanternId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLanternImage() {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.lanternImage_ = Collections.emptyList();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder clearLanternPlayTimes() {
            this.lanternPlayTimes_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLiangId() {
            this.liangId_ = GoodsLuckBag.getDefaultInstance().getLiangId();
            onChanged();
            return this;
        }

        public Builder clearLiangType() {
            this.liangType_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRechargeBadge() {
            this.rechargeBadge_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTypeName() {
            this.typeName_ = GoodsLuckBag.getDefaultInstance().getTypeName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public String getAnimCode() {
            Object obj = this.animCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.animCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ByteString getAnimCodeBytes() {
            Object obj = this.animCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.animCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getAnimation() {
            return this.animation_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public String getAvatarFrameUrl() {
            Object obj = this.avatarFrameUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatarFrameUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ByteString getAvatarFrameUrlBytes() {
            Object obj = this.avatarFrameUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatarFrameUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public long getBeansCount() {
            return this.beansCount_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public long getBeansCurrentCount() {
            return this.beansCurrentCount_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public String getBgColor(int i) {
            return this.bgColor_.get(i);
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ByteString getBgColorBytes(int i) {
            return this.bgColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getBgColorCount() {
            return this.bgColor_.size();
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ProtocolStringList getBgColorList() {
            return this.bgColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public String getBgImg() {
            Object obj = this.bgImg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.bgImg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ByteString getBgImgBytes() {
            Object obj = this.bgImg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bgImg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getChatBadgeHeight() {
            return this.chatBadgeHeight_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getChatBadgeLength() {
            return this.chatBadgeLength_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public String getChatBadgeUrl() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatBadgeUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ByteString getChatBadgeUrlBytes() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatBadgeUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public String getChatFrame() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrame_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public String getChatFrameBorderColor(int i) {
            return this.chatFrameBorderColor_.get(i);
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ByteString getChatFrameBorderColorBytes(int i) {
            return this.chatFrameBorderColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getChatFrameBorderColorCount() {
            return this.chatFrameBorderColor_.size();
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ProtocolStringList getChatFrameBorderColorList() {
            return this.chatFrameBorderColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ByteString getChatFrameBytes() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrame_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getChatFrameColorType() {
            return this.chatFrameColorType_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public String getChatFrameFrameColor(int i) {
            return this.chatFrameFrameColor_.get(i);
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ByteString getChatFrameFrameColorBytes(int i) {
            return this.chatFrameFrameColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getChatFrameFrameColorCount() {
            return this.chatFrameFrameColor_.size();
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ProtocolStringList getChatFrameFrameColorList() {
            return this.chatFrameFrameColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getChatFrameGradientType() {
            return this.chatFrameGradientType_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public String getChatFrameIcon() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrameIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
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
        public GoodsLuckBag getDefaultInstanceForType() {
            return GoodsLuckBag.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_descriptor;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getFanClubLevel() {
            return this.fanClubLevel_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public String getFanClubName() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fanClubName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ByteString getFanClubNameBytes() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fanClubName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public FanStatus getFansStatus() {
            FanStatus valueOf = FanStatus.valueOf(this.fansStatus_);
            FanStatus fanStatus = valueOf;
            if (valueOf == null) {
                fanStatus = FanStatus.UNRECOGNIZED;
            }
            return fanStatus;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getFansStatusValue() {
            return this.fansStatus_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
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

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getGoodsCount() {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.goods_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public List<Goods> getGoodsList() {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.goods_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public GoodsOrBuilder getGoodsOrBuilder(int i) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.goods_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public List<? extends GoodsOrBuilder> getGoodsOrBuilderList() {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.goods_);
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getHitBatch() {
            return this.hitBatch_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getHitCount() {
            return this.hitCount_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public long getHitId() {
            return this.hitId_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public boolean getInFanClub() {
            return this.inFanClub_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getLanternId() {
            return this.lanternId_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public lantern_resource getLanternImage(int i) {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            return repeatedFieldBuilderV3 == null ? this.lanternImage_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public lantern_resource.Builder getLanternImageBuilder(int i) {
            return getLanternImageFieldBuilder().getBuilder(i);
        }

        public List<lantern_resource.Builder> getLanternImageBuilderList() {
            return getLanternImageFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getLanternImageCount() {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            return repeatedFieldBuilderV3 == null ? this.lanternImage_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public List<lantern_resource> getLanternImageList() {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.lanternImage_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public lantern_resourceOrBuilder getLanternImageOrBuilder(int i) {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            return repeatedFieldBuilderV3 == null ? this.lanternImage_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public List<? extends lantern_resourceOrBuilder> getLanternImageOrBuilderList() {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.lanternImage_);
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getLanternPlayTimes() {
            return this.lanternPlayTimes_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public String getLiangId() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liangId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ByteString getLiangIdBytes() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liangId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public LiangType getLiangType() {
            LiangType valueOf = LiangType.valueOf(this.liangType_);
            LiangType liangType = valueOf;
            if (valueOf == null) {
                liangType = LiangType.UNRECOGNIZED;
            }
            return liangType;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getLiangTypeValue() {
            return this.liangType_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public int getRechargeBadge() {
            return this.rechargeBadge_;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public String getTypeName() {
            Object obj = this.typeName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.typeName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
        public ByteString getTypeNameBytes() {
            Object obj = this.typeName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.typeName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_fieldAccessorTable.ensureFieldAccessorsInitialized(GoodsLuckBag.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(GoodsLuckBag goodsLuckBag) {
            if (goodsLuckBag == GoodsLuckBag.getDefaultInstance()) {
                return this;
            }
            if (this.goodsBuilder_ == null) {
                if (!goodsLuckBag.goods_.isEmpty()) {
                    if (this.goods_.isEmpty()) {
                        this.goods_ = goodsLuckBag.goods_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureGoodsIsMutable();
                        this.goods_.addAll(goodsLuckBag.goods_);
                    }
                    onChanged();
                }
            } else if (!goodsLuckBag.goods_.isEmpty()) {
                if (this.goodsBuilder_.isEmpty()) {
                    this.goodsBuilder_.dispose();
                    this.goodsBuilder_ = null;
                    this.goods_ = goodsLuckBag.goods_;
                    this.bitField0_ &= -2;
                    this.goodsBuilder_ = GoodsLuckBag.alwaysUseFieldBuilders ? getGoodsFieldBuilder() : null;
                } else {
                    this.goodsBuilder_.addAllMessages(goodsLuckBag.goods_);
                }
            }
            if (goodsLuckBag.getHitCount() != 0) {
                setHitCount(goodsLuckBag.getHitCount());
            }
            if (goodsLuckBag.getHitId() != 0) {
                setHitId(goodsLuckBag.getHitId());
            }
            if (goodsLuckBag.getHitBatch() != 0) {
                setHitBatch(goodsLuckBag.getHitBatch());
            }
            if (goodsLuckBag.getBeansCount() != 0) {
                setBeansCount(goodsLuckBag.getBeansCount());
            }
            if (goodsLuckBag.getBeansCurrentCount() != 0) {
                setBeansCurrentCount(goodsLuckBag.getBeansCurrentCount());
            }
            if (!goodsLuckBag.getAnimCode().isEmpty()) {
                this.animCode_ = goodsLuckBag.animCode_;
                onChanged();
            }
            if (!goodsLuckBag.getTypeName().isEmpty()) {
                this.typeName_ = goodsLuckBag.typeName_;
                onChanged();
            }
            if (goodsLuckBag.getAnimation() != 0) {
                setAnimation(goodsLuckBag.getAnimation());
            }
            if (!goodsLuckBag.getFanClubName().isEmpty()) {
                this.fanClubName_ = goodsLuckBag.fanClubName_;
                onChanged();
            }
            if (goodsLuckBag.getFanClubLevel() != 0) {
                setFanClubLevel(goodsLuckBag.getFanClubLevel());
            }
            if (goodsLuckBag.getInFanClub()) {
                setInFanClub(goodsLuckBag.getInFanClub());
            }
            if (goodsLuckBag.fansStatus_ != 0) {
                setFansStatusValue(goodsLuckBag.getFansStatusValue());
            }
            if (goodsLuckBag.liangType_ != 0) {
                setLiangTypeValue(goodsLuckBag.getLiangTypeValue());
            }
            if (!goodsLuckBag.getLiangId().isEmpty()) {
                this.liangId_ = goodsLuckBag.liangId_;
                onChanged();
            }
            if (goodsLuckBag.getRechargeBadge() != 0) {
                setRechargeBadge(goodsLuckBag.getRechargeBadge());
            }
            if (!goodsLuckBag.getChatFrame().isEmpty()) {
                this.chatFrame_ = goodsLuckBag.chatFrame_;
                onChanged();
            }
            if (!goodsLuckBag.getChatFrameIcon().isEmpty()) {
                this.chatFrameIcon_ = goodsLuckBag.chatFrameIcon_;
                onChanged();
            }
            if (goodsLuckBag.getChatFrameColorType() != 0) {
                setChatFrameColorType(goodsLuckBag.getChatFrameColorType());
            }
            if (goodsLuckBag.getChatFrameGradientType() != 0) {
                setChatFrameGradientType(goodsLuckBag.getChatFrameGradientType());
            }
            if (!goodsLuckBag.chatFrameFrameColor_.isEmpty()) {
                if (this.chatFrameFrameColor_.isEmpty()) {
                    this.chatFrameFrameColor_ = goodsLuckBag.chatFrameFrameColor_;
                    this.bitField0_ &= -3;
                } else {
                    ensureChatFrameFrameColorIsMutable();
                    this.chatFrameFrameColor_.addAll(goodsLuckBag.chatFrameFrameColor_);
                }
                onChanged();
            }
            if (!goodsLuckBag.chatFrameBorderColor_.isEmpty()) {
                if (this.chatFrameBorderColor_.isEmpty()) {
                    this.chatFrameBorderColor_ = goodsLuckBag.chatFrameBorderColor_;
                    this.bitField0_ &= -5;
                } else {
                    ensureChatFrameBorderColorIsMutable();
                    this.chatFrameBorderColor_.addAll(goodsLuckBag.chatFrameBorderColor_);
                }
                onChanged();
            }
            if (!goodsLuckBag.getChatBadgeUrl().isEmpty()) {
                this.chatBadgeUrl_ = goodsLuckBag.chatBadgeUrl_;
                onChanged();
            }
            if (goodsLuckBag.getChatBadgeLength() != 0) {
                setChatBadgeLength(goodsLuckBag.getChatBadgeLength());
            }
            if (goodsLuckBag.getChatBadgeHeight() != 0) {
                setChatBadgeHeight(goodsLuckBag.getChatBadgeHeight());
            }
            if (!goodsLuckBag.getAvatarFrameUrl().isEmpty()) {
                this.avatarFrameUrl_ = goodsLuckBag.avatarFrameUrl_;
                onChanged();
            }
            if (!goodsLuckBag.getBgImg().isEmpty()) {
                this.bgImg_ = goodsLuckBag.bgImg_;
                onChanged();
            }
            if (!goodsLuckBag.bgColor_.isEmpty()) {
                if (this.bgColor_.isEmpty()) {
                    this.bgColor_ = goodsLuckBag.bgColor_;
                    this.bitField0_ &= -9;
                } else {
                    ensureBgColorIsMutable();
                    this.bgColor_.addAll(goodsLuckBag.bgColor_);
                }
                onChanged();
            }
            if (this.lanternImageBuilder_ == null) {
                if (!goodsLuckBag.lanternImage_.isEmpty()) {
                    if (this.lanternImage_.isEmpty()) {
                        this.lanternImage_ = goodsLuckBag.lanternImage_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureLanternImageIsMutable();
                        this.lanternImage_.addAll(goodsLuckBag.lanternImage_);
                    }
                    onChanged();
                }
            } else if (!goodsLuckBag.lanternImage_.isEmpty()) {
                if (this.lanternImageBuilder_.isEmpty()) {
                    this.lanternImageBuilder_.dispose();
                    this.lanternImageBuilder_ = null;
                    this.lanternImage_ = goodsLuckBag.lanternImage_;
                    this.bitField0_ &= -17;
                    RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = null;
                    if (GoodsLuckBag.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getLanternImageFieldBuilder();
                    }
                    this.lanternImageBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.lanternImageBuilder_.addAllMessages(goodsLuckBag.lanternImage_);
                }
            }
            if (goodsLuckBag.getLanternId() != 0) {
                setLanternId(goodsLuckBag.getLanternId());
            }
            if (goodsLuckBag.getLanternPlayTimes() != 0) {
                setLanternPlayTimes(goodsLuckBag.getLanternPlayTimes());
            }
            mergeUnknownFields(goodsLuckBag.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.GoodsLuckBag.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.GoodsLuckBag.access$7400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.GoodsLuckBag r0 = (cn.irisgw.live.GoodsLuckBag) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.GoodsLuckBag$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.GoodsLuckBag r0 = (cn.irisgw.live.GoodsLuckBag) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.GoodsLuckBag$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.GoodsLuckBag.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.GoodsLuckBag$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof GoodsLuckBag) {
                return mergeFrom((GoodsLuckBag) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
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

        public Builder removeLanternImage(int i) {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureLanternImageIsMutable();
            this.lanternImage_.remove(i);
            onChanged();
            return this;
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
                GoodsLuckBag.checkByteStringIsUtf8(byteString);
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
                GoodsLuckBag.checkByteStringIsUtf8(byteString);
                this.avatarFrameUrl_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setBeansCount(long j) {
            this.beansCount_ = j;
            onChanged();
            return this;
        }

        public Builder setBeansCurrentCount(long j) {
            this.beansCurrentCount_ = j;
            onChanged();
            return this;
        }

        public Builder setBgColor(int i, String str) {
            if (str != null) {
                ensureBgColorIsMutable();
                this.bgColor_.set(i, (int) str);
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
                GoodsLuckBag.checkByteStringIsUtf8(byteString);
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
                GoodsLuckBag.checkByteStringIsUtf8(byteString);
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
                this.chatFrameBorderColor_.set(i, (int) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrameBytes(ByteString byteString) {
            if (byteString != null) {
                GoodsLuckBag.checkByteStringIsUtf8(byteString);
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
                this.chatFrameFrameColor_.set(i, (int) str);
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
                GoodsLuckBag.checkByteStringIsUtf8(byteString);
                this.chatFrameIcon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
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
                GoodsLuckBag.checkByteStringIsUtf8(byteString);
                this.fanClubName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setFansStatus(FanStatus fanStatus) {
            if (fanStatus != null) {
                this.fansStatus_ = fanStatus.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setFansStatusValue(int i) {
            this.fansStatus_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGoods(int i, Goods.Builder builder) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureGoodsIsMutable();
            this.goods_.set(i, builder.build());
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

        public Builder setHitBatch(int i) {
            this.hitBatch_ = i;
            onChanged();
            return this;
        }

        public Builder setHitCount(int i) {
            this.hitCount_ = i;
            onChanged();
            return this;
        }

        public Builder setHitId(long j) {
            this.hitId_ = j;
            onChanged();
            return this;
        }

        public Builder setInFanClub(boolean z) {
            this.inFanClub_ = z;
            onChanged();
            return this;
        }

        public Builder setLanternId(int i) {
            this.lanternId_ = i;
            onChanged();
            return this;
        }

        public Builder setLanternImage(int i, lantern_resource.Builder builder) {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureLanternImageIsMutable();
            this.lanternImage_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setLanternImage(int i, lantern_resource lantern_resourceVar) {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, lantern_resourceVar);
                return this;
            } else if (lantern_resourceVar != null) {
                ensureLanternImageIsMutable();
                this.lanternImage_.set(i, lantern_resourceVar);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setLanternPlayTimes(int i) {
            this.lanternPlayTimes_ = i;
            onChanged();
            return this;
        }

        public Builder setLiangId(String str) {
            if (str != null) {
                this.liangId_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLiangIdBytes(ByteString byteString) {
            if (byteString != null) {
                GoodsLuckBag.checkByteStringIsUtf8(byteString);
                this.liangId_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLiangType(LiangType liangType) {
            if (liangType != null) {
                this.liangType_ = liangType.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLiangTypeValue(int i) {
            this.liangType_ = i;
            onChanged();
            return this;
        }

        public Builder setRechargeBadge(int i) {
            this.rechargeBadge_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setTypeName(String str) {
            if (str != null) {
                this.typeName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTypeNameBytes(ByteString byteString) {
            if (byteString != null) {
                GoodsLuckBag.checkByteStringIsUtf8(byteString);
                this.typeName_ = byteString;
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GoodsLuckBag$Goods.class */
    public static final class Goods extends GeneratedMessageV3 implements GoodsOrBuilder {
        public static final int COUNT_FIELD_NUMBER = 13;
        public static final int GIFT_ID_FIELD_NUMBER = 6;
        public static final int GIFT_NAME_FIELD_NUMBER = 5;
        public static final int GIFT_PIC_APNG_FIELD_NUMBER = 3;
        public static final int GIFT_PIC_GIF_FIELD_NUMBER = 2;
        public static final int GIFT_PIC_MP4_FIELD_NUMBER = 7;
        public static final int GIFT_PIC_URL_FIELD_NUMBER = 1;
        public static final int GIFT_TYPE_FIELD_NUMBER = 4;
        public static final int IS_DRAW_GOODS_FIELD_NUMBER = 10;
        public static final int IS_LUCK_BAG_FIELD_NUMBER = 11;
        public static final int IS_VIBRATE_FIELD_NUMBER = 12;
        public static final int RESOURCE_URL_FIELD_NUMBER = 8;
        public static final int TYPE_FIELD_NUMBER = 9;
        private static final long serialVersionUID = 0;
        private int count_;
        private int giftId_;
        private volatile Object giftName_;
        private volatile Object giftPicApng_;
        private volatile Object giftPicGif_;
        private volatile Object giftPicMp4_;
        private volatile Object giftPicUrl_;
        private int giftType_;
        private boolean isDrawGoods_;
        private boolean isLuckBag_;
        private boolean isVibrate_;
        private byte memoizedIsInitialized;
        private volatile Object resourceUrl_;
        private volatile Object type_;
        private static final Goods DEFAULT_INSTANCE = new Goods();
        private static final Parser<Goods> PARSER = new AbstractParser<Goods>() { // from class: cn.irisgw.live.GoodsLuckBag.Goods.1
            @Override // com.google.protobuf.Parser
            public Goods parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Goods(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GoodsLuckBag$Goods$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GoodsOrBuilder {
            private int count_;
            private int giftId_;
            private Object giftName_;
            private Object giftPicApng_;
            private Object giftPicGif_;
            private Object giftPicMp4_;
            private Object giftPicUrl_;
            private int giftType_;
            private boolean isDrawGoods_;
            private boolean isLuckBag_;
            private boolean isVibrate_;
            private Object resourceUrl_;
            private Object type_;

            private Builder() {
                this.giftPicUrl_ = "";
                this.giftPicGif_ = "";
                this.giftPicApng_ = "";
                this.giftName_ = "";
                this.giftPicMp4_ = "";
                this.resourceUrl_ = "";
                this.type_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.giftPicUrl_ = "";
                this.giftPicGif_ = "";
                this.giftPicApng_ = "";
                this.giftName_ = "";
                this.giftPicMp4_ = "";
                this.resourceUrl_ = "";
                this.type_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_Goods_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Goods.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Goods build() {
                Goods buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Goods buildPartial() {
                Goods goods = new Goods(this);
                goods.giftPicUrl_ = this.giftPicUrl_;
                goods.giftPicGif_ = this.giftPicGif_;
                goods.giftPicApng_ = this.giftPicApng_;
                goods.giftType_ = this.giftType_;
                goods.giftName_ = this.giftName_;
                goods.giftId_ = this.giftId_;
                goods.giftPicMp4_ = this.giftPicMp4_;
                goods.resourceUrl_ = this.resourceUrl_;
                goods.type_ = this.type_;
                goods.isDrawGoods_ = this.isDrawGoods_;
                goods.isLuckBag_ = this.isLuckBag_;
                goods.isVibrate_ = this.isVibrate_;
                goods.count_ = this.count_;
                onBuilt();
                return goods;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.giftPicUrl_ = "";
                this.giftPicGif_ = "";
                this.giftPicApng_ = "";
                this.giftType_ = 0;
                this.giftName_ = "";
                this.giftId_ = 0;
                this.giftPicMp4_ = "";
                this.resourceUrl_ = "";
                this.type_ = "";
                this.isDrawGoods_ = false;
                this.isLuckBag_ = false;
                this.isVibrate_ = false;
                this.count_ = 0;
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
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
                this.giftName_ = Goods.getDefaultInstance().getGiftName();
                onChanged();
                return this;
            }

            public Builder clearGiftPicApng() {
                this.giftPicApng_ = Goods.getDefaultInstance().getGiftPicApng();
                onChanged();
                return this;
            }

            public Builder clearGiftPicGif() {
                this.giftPicGif_ = Goods.getDefaultInstance().getGiftPicGif();
                onChanged();
                return this;
            }

            public Builder clearGiftPicMp4() {
                this.giftPicMp4_ = Goods.getDefaultInstance().getGiftPicMp4();
                onChanged();
                return this;
            }

            public Builder clearGiftPicUrl() {
                this.giftPicUrl_ = Goods.getDefaultInstance().getGiftPicUrl();
                onChanged();
                return this;
            }

            public Builder clearGiftType() {
                this.giftType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIsDrawGoods() {
                this.isDrawGoods_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsLuckBag() {
                this.isLuckBag_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsVibrate() {
                this.isVibrate_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearResourceUrl() {
                this.resourceUrl_ = Goods.getDefaultInstance().getResourceUrl();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = Goods.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public int getCount() {
                return this.count_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Goods getDefaultInstanceForType() {
                return Goods.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_Goods_descriptor;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public int getGiftId() {
                return this.giftId_;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public String getGiftName() {
                Object obj = this.giftName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.giftName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public ByteString getGiftNameBytes() {
                Object obj = this.giftName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.giftName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public String getGiftPicApng() {
                Object obj = this.giftPicApng_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.giftPicApng_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public ByteString getGiftPicApngBytes() {
                Object obj = this.giftPicApng_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.giftPicApng_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public String getGiftPicGif() {
                Object obj = this.giftPicGif_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.giftPicGif_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public ByteString getGiftPicGifBytes() {
                Object obj = this.giftPicGif_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.giftPicGif_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public String getGiftPicMp4() {
                Object obj = this.giftPicMp4_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.giftPicMp4_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public ByteString getGiftPicMp4Bytes() {
                Object obj = this.giftPicMp4_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.giftPicMp4_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public String getGiftPicUrl() {
                Object obj = this.giftPicUrl_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.giftPicUrl_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public ByteString getGiftPicUrlBytes() {
                Object obj = this.giftPicUrl_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.giftPicUrl_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public int getGiftType() {
                return this.giftType_;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public boolean getIsDrawGoods() {
                return this.isDrawGoods_;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public boolean getIsLuckBag() {
                return this.isLuckBag_;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public boolean getIsVibrate() {
                return this.isVibrate_;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public String getResourceUrl() {
                Object obj = this.resourceUrl_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.resourceUrl_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public ByteString getResourceUrlBytes() {
                Object obj = this.resourceUrl_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.resourceUrl_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.type_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_Goods_fieldAccessorTable.ensureFieldAccessorsInitialized(Goods.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Goods goods) {
                if (goods == Goods.getDefaultInstance()) {
                    return this;
                }
                if (!goods.getGiftPicUrl().isEmpty()) {
                    this.giftPicUrl_ = goods.giftPicUrl_;
                    onChanged();
                }
                if (!goods.getGiftPicGif().isEmpty()) {
                    this.giftPicGif_ = goods.giftPicGif_;
                    onChanged();
                }
                if (!goods.getGiftPicApng().isEmpty()) {
                    this.giftPicApng_ = goods.giftPicApng_;
                    onChanged();
                }
                if (goods.getGiftType() != 0) {
                    setGiftType(goods.getGiftType());
                }
                if (!goods.getGiftName().isEmpty()) {
                    this.giftName_ = goods.giftName_;
                    onChanged();
                }
                if (goods.getGiftId() != 0) {
                    setGiftId(goods.getGiftId());
                }
                if (!goods.getGiftPicMp4().isEmpty()) {
                    this.giftPicMp4_ = goods.giftPicMp4_;
                    onChanged();
                }
                if (!goods.getResourceUrl().isEmpty()) {
                    this.resourceUrl_ = goods.resourceUrl_;
                    onChanged();
                }
                if (!goods.getType().isEmpty()) {
                    this.type_ = goods.type_;
                    onChanged();
                }
                if (goods.getIsDrawGoods()) {
                    setIsDrawGoods(goods.getIsDrawGoods());
                }
                if (goods.getIsLuckBag()) {
                    setIsLuckBag(goods.getIsLuckBag());
                }
                if (goods.getIsVibrate()) {
                    setIsVibrate(goods.getIsVibrate());
                }
                if (goods.getCount() != 0) {
                    setCount(goods.getCount());
                }
                mergeUnknownFields(goods.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.GoodsLuckBag.Goods.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.GoodsLuckBag.Goods.access$1800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.GoodsLuckBag$Goods r0 = (cn.irisgw.live.GoodsLuckBag.Goods) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.GoodsLuckBag$Goods$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.GoodsLuckBag$Goods r0 = (cn.irisgw.live.GoodsLuckBag.Goods) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.GoodsLuckBag$Goods$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.GoodsLuckBag.Goods.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.GoodsLuckBag$Goods$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Goods) {
                    return mergeFrom((Goods) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setCount(int i) {
                this.count_ = i;
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
                    Goods.checkByteStringIsUtf8(byteString);
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
                    Goods.checkByteStringIsUtf8(byteString);
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
                    Goods.checkByteStringIsUtf8(byteString);
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
                    Goods.checkByteStringIsUtf8(byteString);
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
                    Goods.checkByteStringIsUtf8(byteString);
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

            public Builder setIsDrawGoods(boolean z) {
                this.isDrawGoods_ = z;
                onChanged();
                return this;
            }

            public Builder setIsLuckBag(boolean z) {
                this.isLuckBag_ = z;
                onChanged();
                return this;
            }

            public Builder setIsVibrate(boolean z) {
                this.isVibrate_ = z;
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
                    Goods.checkByteStringIsUtf8(byteString);
                    this.resourceUrl_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setType(String str) {
                if (str != null) {
                    this.type_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    Goods.checkByteStringIsUtf8(byteString);
                    this.type_ = byteString;
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

        private Goods() {
            this.memoizedIsInitialized = (byte) -1;
            this.giftPicUrl_ = "";
            this.giftPicGif_ = "";
            this.giftPicApng_ = "";
            this.giftName_ = "";
            this.giftPicMp4_ = "";
            this.resourceUrl_ = "";
            this.type_ = "";
        }

        private Goods(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            case 10:
                                this.giftPicUrl_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 18:
                                this.giftPicGif_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 26:
                                this.giftPicApng_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 32:
                                this.giftType_ = codedInputStream.readUInt32();
                                continue;
                            case 42:
                                this.giftName_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 48:
                                this.giftId_ = codedInputStream.readUInt32();
                                continue;
                            case 58:
                                this.giftPicMp4_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 66:
                                this.resourceUrl_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 74:
                                this.type_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 80:
                                this.isDrawGoods_ = codedInputStream.readBool();
                                continue;
                            case 88:
                                this.isLuckBag_ = codedInputStream.readBool();
                                continue;
                            case 96:
                                this.isVibrate_ = codedInputStream.readBool();
                                continue;
                            case 104:
                                this.count_ = codedInputStream.readUInt32();
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

        private Goods(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Goods getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_Goods_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Goods goods) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(goods);
        }

        public static Goods parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Goods) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Goods parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Goods) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Goods parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Goods parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Goods parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Goods) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Goods parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Goods) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Goods parseFrom(InputStream inputStream) throws IOException {
            return (Goods) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Goods parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Goods) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Goods parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Goods parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Goods parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Goods parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Goods> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Goods) {
                Goods goods = (Goods) obj;
                return getGiftPicUrl().equals(goods.getGiftPicUrl()) && getGiftPicGif().equals(goods.getGiftPicGif()) && getGiftPicApng().equals(goods.getGiftPicApng()) && getGiftType() == goods.getGiftType() && getGiftName().equals(goods.getGiftName()) && getGiftId() == goods.getGiftId() && getGiftPicMp4().equals(goods.getGiftPicMp4()) && getResourceUrl().equals(goods.getResourceUrl()) && getType().equals(goods.getType()) && getIsDrawGoods() == goods.getIsDrawGoods() && getIsLuckBag() == goods.getIsLuckBag() && getIsVibrate() == goods.getIsVibrate() && getCount() == goods.getCount() && this.unknownFields.equals(goods.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Goods getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public int getGiftId() {
            return this.giftId_;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public String getGiftName() {
            Object obj = this.giftName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public ByteString getGiftNameBytes() {
            Object obj = this.giftName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public String getGiftPicApng() {
            Object obj = this.giftPicApng_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftPicApng_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public ByteString getGiftPicApngBytes() {
            Object obj = this.giftPicApng_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftPicApng_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public String getGiftPicGif() {
            Object obj = this.giftPicGif_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftPicGif_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public ByteString getGiftPicGifBytes() {
            Object obj = this.giftPicGif_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftPicGif_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public String getGiftPicMp4() {
            Object obj = this.giftPicMp4_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftPicMp4_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public ByteString getGiftPicMp4Bytes() {
            Object obj = this.giftPicMp4_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftPicMp4_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public String getGiftPicUrl() {
            Object obj = this.giftPicUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftPicUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public ByteString getGiftPicUrlBytes() {
            Object obj = this.giftPicUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftPicUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public int getGiftType() {
            return this.giftType_;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public boolean getIsDrawGoods() {
            return this.isDrawGoods_;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public boolean getIsLuckBag() {
            return this.isLuckBag_;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public boolean getIsVibrate() {
            return this.isVibrate_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Goods> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public String getResourceUrl() {
            Object obj = this.resourceUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.resourceUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
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
            if (!getGiftPicUrlBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.giftPicUrl_);
            }
            int i3 = i2;
            if (!getGiftPicGifBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.giftPicGif_);
            }
            int i4 = i3;
            if (!getGiftPicApngBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.giftPicApng_);
            }
            int i5 = this.giftType_;
            int i6 = i4;
            if (i5 != 0) {
                i6 = i4 + CodedOutputStream.computeUInt32Size(4, i5);
            }
            int i7 = i6;
            if (!getGiftNameBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.giftName_);
            }
            int i8 = this.giftId_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeUInt32Size(6, i8);
            }
            int i10 = i9;
            if (!getGiftPicMp4Bytes().isEmpty()) {
                i10 = i9 + GeneratedMessageV3.computeStringSize(7, this.giftPicMp4_);
            }
            int i11 = i10;
            if (!getResourceUrlBytes().isEmpty()) {
                i11 = i10 + GeneratedMessageV3.computeStringSize(8, this.resourceUrl_);
            }
            int i12 = i11;
            if (!getTypeBytes().isEmpty()) {
                i12 = i11 + GeneratedMessageV3.computeStringSize(9, this.type_);
            }
            boolean z = this.isDrawGoods_;
            int i13 = i12;
            if (z) {
                i13 = i12 + CodedOutputStream.computeBoolSize(10, z);
            }
            boolean z2 = this.isLuckBag_;
            int i14 = i13;
            if (z2) {
                i14 = i13 + CodedOutputStream.computeBoolSize(11, z2);
            }
            boolean z3 = this.isVibrate_;
            int i15 = i14;
            if (z3) {
                i15 = i14 + CodedOutputStream.computeBoolSize(12, z3);
            }
            int i16 = this.count_;
            int i17 = i15;
            if (i16 != 0) {
                i17 = i15 + CodedOutputStream.computeUInt32Size(13, i16);
            }
            int serializedSize = i17 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.GoodsOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
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
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getGiftPicUrl().hashCode()) * 37) + 2) * 53) + getGiftPicGif().hashCode()) * 37) + 3) * 53) + getGiftPicApng().hashCode()) * 37) + 4) * 53) + getGiftType()) * 37) + 5) * 53) + getGiftName().hashCode()) * 37) + 6) * 53) + getGiftId()) * 37) + 7) * 53) + getGiftPicMp4().hashCode()) * 37) + 8) * 53) + getResourceUrl().hashCode()) * 37) + 9) * 53) + getType().hashCode()) * 37) + 10) * 53) + Internal.hashBoolean(getIsDrawGoods())) * 37) + 11) * 53) + Internal.hashBoolean(getIsLuckBag())) * 37) + 12) * 53) + Internal.hashBoolean(getIsVibrate())) * 37) + 13) * 53) + getCount()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_Goods_fieldAccessorTable.ensureFieldAccessorsInitialized(Goods.class, Builder.class);
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
            return new Goods();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getGiftPicUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.giftPicUrl_);
            }
            if (!getGiftPicGifBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.giftPicGif_);
            }
            if (!getGiftPicApngBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.giftPicApng_);
            }
            int i = this.giftType_;
            if (i != 0) {
                codedOutputStream.writeUInt32(4, i);
            }
            if (!getGiftNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.giftName_);
            }
            int i2 = this.giftId_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(6, i2);
            }
            if (!getGiftPicMp4Bytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.giftPicMp4_);
            }
            if (!getResourceUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.resourceUrl_);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.type_);
            }
            boolean z = this.isDrawGoods_;
            if (z) {
                codedOutputStream.writeBool(10, z);
            }
            boolean z2 = this.isLuckBag_;
            if (z2) {
                codedOutputStream.writeBool(11, z2);
            }
            boolean z3 = this.isVibrate_;
            if (z3) {
                codedOutputStream.writeBool(12, z3);
            }
            int i3 = this.count_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(13, i3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GoodsLuckBag$GoodsOrBuilder.class */
    public interface GoodsOrBuilder extends MessageOrBuilder {
        int getCount();

        int getGiftId();

        String getGiftName();

        ByteString getGiftNameBytes();

        String getGiftPicApng();

        ByteString getGiftPicApngBytes();

        String getGiftPicGif();

        ByteString getGiftPicGifBytes();

        String getGiftPicMp4();

        ByteString getGiftPicMp4Bytes();

        String getGiftPicUrl();

        ByteString getGiftPicUrlBytes();

        int getGiftType();

        boolean getIsDrawGoods();

        boolean getIsLuckBag();

        boolean getIsVibrate();

        String getResourceUrl();

        ByteString getResourceUrlBytes();

        String getType();

        ByteString getTypeBytes();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GoodsLuckBag$lantern_resource.class */
    public static final class lantern_resource extends GeneratedMessageV3 implements lantern_resourceOrBuilder {
        public static final int IMG_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object img_;
        private byte memoizedIsInitialized;
        private static final lantern_resource DEFAULT_INSTANCE = new lantern_resource();
        private static final Parser<lantern_resource> PARSER = new AbstractParser<lantern_resource>() { // from class: cn.irisgw.live.GoodsLuckBag.lantern_resource.1
            @Override // com.google.protobuf.Parser
            public lantern_resource parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new lantern_resource(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GoodsLuckBag$lantern_resource$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements lantern_resourceOrBuilder {
            private Object img_;

            private Builder() {
                this.img_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.img_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_lantern_resource_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = lantern_resource.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public lantern_resource build() {
                lantern_resource buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public lantern_resource buildPartial() {
                lantern_resource lantern_resourceVar = new lantern_resource(this);
                lantern_resourceVar.img_ = this.img_;
                onBuilt();
                return lantern_resourceVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.img_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearImg() {
                this.img_ = lantern_resource.getDefaultInstance().getImg();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public lantern_resource getDefaultInstanceForType() {
                return lantern_resource.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_lantern_resource_descriptor;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.lantern_resourceOrBuilder
            public String getImg() {
                Object obj = this.img_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.img_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.GoodsLuckBag.lantern_resourceOrBuilder
            public ByteString getImgBytes() {
                Object obj = this.img_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.img_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_lantern_resource_fieldAccessorTable.ensureFieldAccessorsInitialized(lantern_resource.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(lantern_resource lantern_resourceVar) {
                if (lantern_resourceVar == lantern_resource.getDefaultInstance()) {
                    return this;
                }
                if (!lantern_resourceVar.getImg().isEmpty()) {
                    this.img_ = lantern_resourceVar.img_;
                    onChanged();
                }
                mergeUnknownFields(lantern_resourceVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.GoodsLuckBag.lantern_resource.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.GoodsLuckBag.lantern_resource.access$3300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.GoodsLuckBag$lantern_resource r0 = (cn.irisgw.live.GoodsLuckBag.lantern_resource) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.GoodsLuckBag$lantern_resource$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.GoodsLuckBag$lantern_resource r0 = (cn.irisgw.live.GoodsLuckBag.lantern_resource) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.GoodsLuckBag$lantern_resource$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.GoodsLuckBag.lantern_resource.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.GoodsLuckBag$lantern_resource$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof lantern_resource) {
                    return mergeFrom((lantern_resource) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setImg(String str) {
                if (str != null) {
                    this.img_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setImgBytes(ByteString byteString) {
                if (byteString != null) {
                    lantern_resource.checkByteStringIsUtf8(byteString);
                    this.img_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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

        private lantern_resource() {
            this.memoizedIsInitialized = (byte) -1;
            this.img_ = "";
        }

        private lantern_resource(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 10) {
                                this.img_ = codedInputStream.readStringRequireUtf8();
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

        private lantern_resource(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static lantern_resource getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_lantern_resource_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(lantern_resource lantern_resourceVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(lantern_resourceVar);
        }

        public static lantern_resource parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (lantern_resource) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static lantern_resource parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (lantern_resource) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static lantern_resource parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static lantern_resource parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static lantern_resource parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (lantern_resource) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static lantern_resource parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (lantern_resource) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static lantern_resource parseFrom(InputStream inputStream) throws IOException {
            return (lantern_resource) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static lantern_resource parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (lantern_resource) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static lantern_resource parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static lantern_resource parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static lantern_resource parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static lantern_resource parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<lantern_resource> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof lantern_resource) {
                lantern_resource lantern_resourceVar = (lantern_resource) obj;
                return getImg().equals(lantern_resourceVar.getImg()) && this.unknownFields.equals(lantern_resourceVar.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public lantern_resource getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.lantern_resourceOrBuilder
        public String getImg() {
            Object obj = this.img_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.img_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsLuckBag.lantern_resourceOrBuilder
        public ByteString getImgBytes() {
            Object obj = this.img_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.img_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<lantern_resource> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getImgBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.img_);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getImg().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_lantern_resource_fieldAccessorTable.ensureFieldAccessorsInitialized(lantern_resource.class, Builder.class);
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
            return new lantern_resource();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getImgBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.img_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GoodsLuckBag$lantern_resourceOrBuilder.class */
    public interface lantern_resourceOrBuilder extends MessageOrBuilder {
        String getImg();

        ByteString getImgBytes();
    }

    private GoodsLuckBag() {
        this.memoizedIsInitialized = (byte) -1;
        this.goods_ = Collections.emptyList();
        this.animCode_ = "";
        this.typeName_ = "";
        this.fanClubName_ = "";
        this.fansStatus_ = 0;
        this.liangType_ = 0;
        this.liangId_ = "";
        this.chatFrame_ = "";
        this.chatFrameIcon_ = "";
        this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
        this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
        this.chatBadgeUrl_ = "";
        this.avatarFrameUrl_ = "";
        this.bgImg_ = "";
        this.bgColor_ = LazyStringArrayList.EMPTY;
        this.lanternImage_ = Collections.emptyList();
    }

    private GoodsLuckBag(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.hitCount_ = codedInputStream.readUInt32();
                            continue;
                        case 24:
                            this.hitId_ = codedInputStream.readUInt64();
                            continue;
                        case 32:
                            this.hitBatch_ = codedInputStream.readUInt32();
                            continue;
                        case 40:
                            this.beansCount_ = codedInputStream.readUInt64();
                            continue;
                        case 48:
                            this.beansCurrentCount_ = codedInputStream.readUInt64();
                            continue;
                        case 58:
                            this.animCode_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 66:
                            this.typeName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 72:
                            this.animation_ = codedInputStream.readUInt32();
                            continue;
                        case 82:
                            this.fanClubName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 88:
                            this.fanClubLevel_ = codedInputStream.readInt32();
                            continue;
                        case 96:
                            this.inFanClub_ = codedInputStream.readBool();
                            continue;
                        case 104:
                            this.fansStatus_ = codedInputStream.readEnum();
                            continue;
                        case 112:
                            this.liangType_ = codedInputStream.readEnum();
                            continue;
                        case 122:
                            this.liangId_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 128:
                            this.rechargeBadge_ = codedInputStream.readInt32();
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
                            this.chatFrameFrameColor_.add((LazyStringList) readStringRequireUtf8);
                            z2 = z5;
                            continue;
                        case 178:
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            boolean z6 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameBorderColor_ = new LazyStringArrayList();
                                z6 = z2 | true;
                            }
                            this.chatFrameBorderColor_.add((LazyStringList) readStringRequireUtf82);
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
                            this.bgColor_.add((LazyStringList) readStringRequireUtf83);
                            z2 = z7;
                            continue;
                        case 234:
                            boolean z8 = z2;
                            if (!(z2 & true)) {
                                this.lanternImage_ = new ArrayList();
                                z8 = z2 | true;
                            }
                            this.lanternImage_.add((lantern_resource) codedInputStream.readMessage(lantern_resource.parser(), extensionRegistryLite));
                            z2 = z8;
                            continue;
                        case 240:
                            this.lanternId_ = codedInputStream.readInt32();
                            continue;
                        case 248:
                            this.lanternPlayTimes_ = codedInputStream.readInt32();
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
                if (z3 & true) {
                    this.lanternImage_ = Collections.unmodifiableList(this.lanternImage_);
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
        if (z2 & true) {
            this.lanternImage_ = Collections.unmodifiableList(this.lanternImage_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private GoodsLuckBag(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static GoodsLuckBag getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(GoodsLuckBag goodsLuckBag) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(goodsLuckBag);
    }

    public static GoodsLuckBag parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GoodsLuckBag) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GoodsLuckBag parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GoodsLuckBag) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GoodsLuckBag parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GoodsLuckBag parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GoodsLuckBag parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GoodsLuckBag) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static GoodsLuckBag parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GoodsLuckBag) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static GoodsLuckBag parseFrom(InputStream inputStream) throws IOException {
        return (GoodsLuckBag) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static GoodsLuckBag parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GoodsLuckBag) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GoodsLuckBag parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GoodsLuckBag parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GoodsLuckBag parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GoodsLuckBag parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<GoodsLuckBag> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoodsLuckBag) {
            GoodsLuckBag goodsLuckBag = (GoodsLuckBag) obj;
            return getGoodsList().equals(goodsLuckBag.getGoodsList()) && getHitCount() == goodsLuckBag.getHitCount() && getHitId() == goodsLuckBag.getHitId() && getHitBatch() == goodsLuckBag.getHitBatch() && getBeansCount() == goodsLuckBag.getBeansCount() && getBeansCurrentCount() == goodsLuckBag.getBeansCurrentCount() && getAnimCode().equals(goodsLuckBag.getAnimCode()) && getTypeName().equals(goodsLuckBag.getTypeName()) && getAnimation() == goodsLuckBag.getAnimation() && getFanClubName().equals(goodsLuckBag.getFanClubName()) && getFanClubLevel() == goodsLuckBag.getFanClubLevel() && getInFanClub() == goodsLuckBag.getInFanClub() && this.fansStatus_ == goodsLuckBag.fansStatus_ && this.liangType_ == goodsLuckBag.liangType_ && getLiangId().equals(goodsLuckBag.getLiangId()) && getRechargeBadge() == goodsLuckBag.getRechargeBadge() && getChatFrame().equals(goodsLuckBag.getChatFrame()) && getChatFrameIcon().equals(goodsLuckBag.getChatFrameIcon()) && getChatFrameColorType() == goodsLuckBag.getChatFrameColorType() && getChatFrameGradientType() == goodsLuckBag.getChatFrameGradientType() && getChatFrameFrameColorList().equals(goodsLuckBag.getChatFrameFrameColorList()) && getChatFrameBorderColorList().equals(goodsLuckBag.getChatFrameBorderColorList()) && getChatBadgeUrl().equals(goodsLuckBag.getChatBadgeUrl()) && getChatBadgeLength() == goodsLuckBag.getChatBadgeLength() && getChatBadgeHeight() == goodsLuckBag.getChatBadgeHeight() && getAvatarFrameUrl().equals(goodsLuckBag.getAvatarFrameUrl()) && getBgImg().equals(goodsLuckBag.getBgImg()) && getBgColorList().equals(goodsLuckBag.getBgColorList()) && getLanternImageList().equals(goodsLuckBag.getLanternImageList()) && getLanternId() == goodsLuckBag.getLanternId() && getLanternPlayTimes() == goodsLuckBag.getLanternPlayTimes() && this.unknownFields.equals(goodsLuckBag.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public String getAnimCode() {
        Object obj = this.animCode_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.animCode_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ByteString getAnimCodeBytes() {
        Object obj = this.animCode_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.animCode_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getAnimation() {
        return this.animation_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public String getAvatarFrameUrl() {
        Object obj = this.avatarFrameUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatarFrameUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ByteString getAvatarFrameUrlBytes() {
        Object obj = this.avatarFrameUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.avatarFrameUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public long getBeansCount() {
        return this.beansCount_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public long getBeansCurrentCount() {
        return this.beansCurrentCount_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public String getBgColor(int i) {
        return this.bgColor_.get(i);
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ByteString getBgColorBytes(int i) {
        return this.bgColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getBgColorCount() {
        return this.bgColor_.size();
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ProtocolStringList getBgColorList() {
        return this.bgColor_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public String getBgImg() {
        Object obj = this.bgImg_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.bgImg_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ByteString getBgImgBytes() {
        Object obj = this.bgImg_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bgImg_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getChatBadgeHeight() {
        return this.chatBadgeHeight_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getChatBadgeLength() {
        return this.chatBadgeLength_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public String getChatBadgeUrl() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatBadgeUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ByteString getChatBadgeUrlBytes() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatBadgeUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public String getChatFrame() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrame_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public String getChatFrameBorderColor(int i) {
        return this.chatFrameBorderColor_.get(i);
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ByteString getChatFrameBorderColorBytes(int i) {
        return this.chatFrameBorderColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getChatFrameBorderColorCount() {
        return this.chatFrameBorderColor_.size();
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ProtocolStringList getChatFrameBorderColorList() {
        return this.chatFrameBorderColor_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ByteString getChatFrameBytes() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrame_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getChatFrameColorType() {
        return this.chatFrameColorType_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public String getChatFrameFrameColor(int i) {
        return this.chatFrameFrameColor_.get(i);
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ByteString getChatFrameFrameColorBytes(int i) {
        return this.chatFrameFrameColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getChatFrameFrameColorCount() {
        return this.chatFrameFrameColor_.size();
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ProtocolStringList getChatFrameFrameColorList() {
        return this.chatFrameFrameColor_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getChatFrameGradientType() {
        return this.chatFrameGradientType_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public String getChatFrameIcon() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrameIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
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
    public GoodsLuckBag getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getFanClubLevel() {
        return this.fanClubLevel_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public String getFanClubName() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.fanClubName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ByteString getFanClubNameBytes() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fanClubName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public FanStatus getFansStatus() {
        FanStatus valueOf = FanStatus.valueOf(this.fansStatus_);
        FanStatus fanStatus = valueOf;
        if (valueOf == null) {
            fanStatus = FanStatus.UNRECOGNIZED;
        }
        return fanStatus;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getFansStatusValue() {
        return this.fansStatus_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public Goods getGoods(int i) {
        return this.goods_.get(i);
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getGoodsCount() {
        return this.goods_.size();
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public List<Goods> getGoodsList() {
        return this.goods_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public GoodsOrBuilder getGoodsOrBuilder(int i) {
        return this.goods_.get(i);
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public List<? extends GoodsOrBuilder> getGoodsOrBuilderList() {
        return this.goods_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getHitBatch() {
        return this.hitBatch_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getHitCount() {
        return this.hitCount_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public long getHitId() {
        return this.hitId_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public boolean getInFanClub() {
        return this.inFanClub_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getLanternId() {
        return this.lanternId_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public lantern_resource getLanternImage(int i) {
        return this.lanternImage_.get(i);
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getLanternImageCount() {
        return this.lanternImage_.size();
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public List<lantern_resource> getLanternImageList() {
        return this.lanternImage_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public lantern_resourceOrBuilder getLanternImageOrBuilder(int i) {
        return this.lanternImage_.get(i);
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public List<? extends lantern_resourceOrBuilder> getLanternImageOrBuilderList() {
        return this.lanternImage_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getLanternPlayTimes() {
        return this.lanternPlayTimes_;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public String getLiangId() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.liangId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ByteString getLiangIdBytes() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.liangId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public LiangType getLiangType() {
        LiangType valueOf = LiangType.valueOf(this.liangType_);
        LiangType liangType = valueOf;
        if (valueOf == null) {
            liangType = LiangType.UNRECOGNIZED;
        }
        return liangType;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getLiangTypeValue() {
        return this.liangType_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GoodsLuckBag> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public int getRechargeBadge() {
        return this.rechargeBadge_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.goods_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.goods_.get(i3));
        }
        int i4 = this.hitCount_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        long j = this.hitId_;
        int i6 = i5;
        if (j != 0) {
            i6 = i5 + CodedOutputStream.computeUInt64Size(3, j);
        }
        int i7 = this.hitBatch_;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeUInt32Size(4, i7);
        }
        long j2 = this.beansCount_;
        int i9 = i8;
        if (j2 != 0) {
            i9 = i8 + CodedOutputStream.computeUInt64Size(5, j2);
        }
        long j3 = this.beansCurrentCount_;
        int i10 = i9;
        if (j3 != 0) {
            i10 = i9 + CodedOutputStream.computeUInt64Size(6, j3);
        }
        int i11 = i10;
        if (!getAnimCodeBytes().isEmpty()) {
            i11 = i10 + GeneratedMessageV3.computeStringSize(7, this.animCode_);
        }
        int i12 = i11;
        if (!getTypeNameBytes().isEmpty()) {
            i12 = i11 + GeneratedMessageV3.computeStringSize(8, this.typeName_);
        }
        int i13 = this.animation_;
        int i14 = i12;
        if (i13 != 0) {
            i14 = i12 + CodedOutputStream.computeUInt32Size(9, i13);
        }
        int i15 = i14;
        if (!getFanClubNameBytes().isEmpty()) {
            i15 = i14 + GeneratedMessageV3.computeStringSize(10, this.fanClubName_);
        }
        int i16 = this.fanClubLevel_;
        int i17 = i15;
        if (i16 != 0) {
            i17 = i15 + CodedOutputStream.computeInt32Size(11, i16);
        }
        boolean z = this.inFanClub_;
        int i18 = i17;
        if (z) {
            i18 = i17 + CodedOutputStream.computeBoolSize(12, z);
        }
        int i19 = i18;
        if (this.fansStatus_ != FanStatus.Out.getNumber()) {
            i19 = i18 + CodedOutputStream.computeEnumSize(13, this.fansStatus_);
        }
        int i20 = i19;
        if (this.liangType_ != LiangType.None.getNumber()) {
            i20 = i19 + CodedOutputStream.computeEnumSize(14, this.liangType_);
        }
        int i21 = i20;
        if (!getLiangIdBytes().isEmpty()) {
            i21 = i20 + GeneratedMessageV3.computeStringSize(15, this.liangId_);
        }
        int i22 = this.rechargeBadge_;
        int i23 = i21;
        if (i22 != 0) {
            i23 = i21 + CodedOutputStream.computeInt32Size(16, i22);
        }
        int i24 = i23;
        if (!getChatFrameBytes().isEmpty()) {
            i24 = i23 + GeneratedMessageV3.computeStringSize(17, this.chatFrame_);
        }
        int i25 = i24;
        if (!getChatFrameIconBytes().isEmpty()) {
            i25 = i24 + GeneratedMessageV3.computeStringSize(18, this.chatFrameIcon_);
        }
        int i26 = this.chatFrameColorType_;
        int i27 = i25;
        if (i26 != 0) {
            i27 = i25 + CodedOutputStream.computeInt32Size(19, i26);
        }
        int i28 = this.chatFrameGradientType_;
        int i29 = i27;
        if (i28 != 0) {
            i29 = i27 + CodedOutputStream.computeInt32Size(20, i28);
        }
        int i30 = 0;
        for (int i31 = 0; i31 < this.chatFrameFrameColor_.size(); i31++) {
            i30 += computeStringSizeNoTag(this.chatFrameFrameColor_.getRaw(i31));
        }
        int size = getChatFrameFrameColorList().size();
        int i32 = 0;
        for (int i33 = 0; i33 < this.chatFrameBorderColor_.size(); i33++) {
            i32 += computeStringSizeNoTag(this.chatFrameBorderColor_.getRaw(i33));
        }
        int size2 = i29 + i30 + (size * 2) + i32 + (getChatFrameBorderColorList().size() * 2);
        int i34 = size2;
        if (!getChatBadgeUrlBytes().isEmpty()) {
            i34 = size2 + GeneratedMessageV3.computeStringSize(23, this.chatBadgeUrl_);
        }
        int i35 = this.chatBadgeLength_;
        int i36 = i34;
        if (i35 != 0) {
            i36 = i34 + CodedOutputStream.computeInt32Size(24, i35);
        }
        int i37 = this.chatBadgeHeight_;
        int i38 = i36;
        if (i37 != 0) {
            i38 = i36 + CodedOutputStream.computeInt32Size(25, i37);
        }
        int i39 = i38;
        if (!getAvatarFrameUrlBytes().isEmpty()) {
            i39 = i38 + GeneratedMessageV3.computeStringSize(26, this.avatarFrameUrl_);
        }
        int i40 = i39;
        if (!getBgImgBytes().isEmpty()) {
            i40 = i39 + GeneratedMessageV3.computeStringSize(27, this.bgImg_);
        }
        int i41 = 0;
        for (int i42 = 0; i42 < this.bgColor_.size(); i42++) {
            i41 += computeStringSizeNoTag(this.bgColor_.getRaw(i42));
        }
        int size3 = i40 + i41 + (getBgColorList().size() * 2);
        int i43 = 0;
        while (true) {
            int i44 = i43;
            if (i44 >= this.lanternImage_.size()) {
                break;
            }
            size3 += CodedOutputStream.computeMessageSize(29, this.lanternImage_.get(i44));
            i43 = i44 + 1;
        }
        int i45 = this.lanternId_;
        int i46 = size3;
        if (i45 != 0) {
            i46 = size3 + CodedOutputStream.computeInt32Size(30, i45);
        }
        int i47 = this.lanternPlayTimes_;
        int i48 = i46;
        if (i47 != 0) {
            i48 = i46 + CodedOutputStream.computeInt32Size(31, i47);
        }
        int serializedSize = i48 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public String getTypeName() {
        Object obj = this.typeName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.typeName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GoodsLuckBagOrBuilder
    public ByteString getTypeNameBytes() {
        Object obj = this.typeName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.typeName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
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
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (getGoodsCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getGoodsList().hashCode();
        }
        int hitCount = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((i * 37) + 2) * 53) + getHitCount()) * 37) + 3) * 53) + Internal.hashLong(getHitId())) * 37) + 4) * 53) + getHitBatch()) * 37) + 5) * 53) + Internal.hashLong(getBeansCount())) * 37) + 6) * 53) + Internal.hashLong(getBeansCurrentCount())) * 37) + 7) * 53) + getAnimCode().hashCode()) * 37) + 8) * 53) + getTypeName().hashCode()) * 37) + 9) * 53) + getAnimation()) * 37) + 10) * 53) + getFanClubName().hashCode()) * 37) + 11) * 53) + getFanClubLevel()) * 37) + 12) * 53) + Internal.hashBoolean(getInFanClub())) * 37) + 13) * 53) + this.fansStatus_) * 37) + 14) * 53) + this.liangType_) * 37) + 15) * 53) + getLiangId().hashCode()) * 37) + 16) * 53) + getRechargeBadge()) * 37) + 17) * 53) + getChatFrame().hashCode()) * 37) + 18) * 53) + getChatFrameIcon().hashCode()) * 37) + 19) * 53) + getChatFrameColorType()) * 37) + 20) * 53) + getChatFrameGradientType();
        int i2 = hitCount;
        if (getChatFrameFrameColorCount() > 0) {
            i2 = (((hitCount * 37) + 21) * 53) + getChatFrameFrameColorList().hashCode();
        }
        int i3 = i2;
        if (getChatFrameBorderColorCount() > 0) {
            i3 = (((i2 * 37) + 22) * 53) + getChatFrameBorderColorList().hashCode();
        }
        int hashCode2 = (((((((((((((((((((i3 * 37) + 23) * 53) + getChatBadgeUrl().hashCode()) * 37) + 24) * 53) + getChatBadgeLength()) * 37) + 25) * 53) + getChatBadgeHeight()) * 37) + 26) * 53) + getAvatarFrameUrl().hashCode()) * 37) + 27) * 53) + getBgImg().hashCode();
        int i4 = hashCode2;
        if (getBgColorCount() > 0) {
            i4 = (((hashCode2 * 37) + 28) * 53) + getBgColorList().hashCode();
        }
        int i5 = i4;
        if (getLanternImageCount() > 0) {
            i5 = (((i4 * 37) + 29) * 53) + getLanternImageList().hashCode();
        }
        int lanternId = (((((((((i5 * 37) + 30) * 53) + getLanternId()) * 37) + 31) * 53) + getLanternPlayTimes()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = lanternId;
        return lanternId;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_GoodsLuckBag_fieldAccessorTable.ensureFieldAccessorsInitialized(GoodsLuckBag.class, Builder.class);
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
        return new GoodsLuckBag();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.goods_.size()) {
                break;
            }
            codedOutputStream.writeMessage(1, this.goods_.get(i3));
            i2 = i3 + 1;
        }
        int i4 = this.hitCount_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(2, i4);
        }
        long j = this.hitId_;
        if (j != 0) {
            codedOutputStream.writeUInt64(3, j);
        }
        int i5 = this.hitBatch_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(4, i5);
        }
        long j2 = this.beansCount_;
        if (j2 != 0) {
            codedOutputStream.writeUInt64(5, j2);
        }
        long j3 = this.beansCurrentCount_;
        if (j3 != 0) {
            codedOutputStream.writeUInt64(6, j3);
        }
        if (!getAnimCodeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.animCode_);
        }
        if (!getTypeNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.typeName_);
        }
        int i6 = this.animation_;
        if (i6 != 0) {
            codedOutputStream.writeUInt32(9, i6);
        }
        if (!getFanClubNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 10, this.fanClubName_);
        }
        int i7 = this.fanClubLevel_;
        if (i7 != 0) {
            codedOutputStream.writeInt32(11, i7);
        }
        boolean z = this.inFanClub_;
        if (z) {
            codedOutputStream.writeBool(12, z);
        }
        if (this.fansStatus_ != FanStatus.Out.getNumber()) {
            codedOutputStream.writeEnum(13, this.fansStatus_);
        }
        if (this.liangType_ != LiangType.None.getNumber()) {
            codedOutputStream.writeEnum(14, this.liangType_);
        }
        if (!getLiangIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 15, this.liangId_);
        }
        int i8 = this.rechargeBadge_;
        if (i8 != 0) {
            codedOutputStream.writeInt32(16, i8);
        }
        if (!getChatFrameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 17, this.chatFrame_);
        }
        if (!getChatFrameIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 18, this.chatFrameIcon_);
        }
        int i9 = this.chatFrameColorType_;
        if (i9 != 0) {
            codedOutputStream.writeInt32(19, i9);
        }
        int i10 = this.chatFrameGradientType_;
        if (i10 != 0) {
            codedOutputStream.writeInt32(20, i10);
        }
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= this.chatFrameFrameColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 21, this.chatFrameFrameColor_.getRaw(i12));
            i11 = i12 + 1;
        }
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 >= this.chatFrameBorderColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 22, this.chatFrameBorderColor_.getRaw(i14));
            i13 = i14 + 1;
        }
        if (!getChatBadgeUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 23, this.chatBadgeUrl_);
        }
        int i15 = this.chatBadgeLength_;
        if (i15 != 0) {
            codedOutputStream.writeInt32(24, i15);
        }
        int i16 = this.chatBadgeHeight_;
        if (i16 != 0) {
            codedOutputStream.writeInt32(25, i16);
        }
        if (!getAvatarFrameUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 26, this.avatarFrameUrl_);
        }
        if (!getBgImgBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 27, this.bgImg_);
        }
        int i17 = 0;
        while (true) {
            int i18 = i17;
            if (i18 >= this.bgColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 28, this.bgColor_.getRaw(i18));
            i17 = i18 + 1;
        }
        for (i = 0; i < this.lanternImage_.size(); i++) {
            codedOutputStream.writeMessage(29, this.lanternImage_.get(i));
        }
        int i19 = this.lanternId_;
        if (i19 != 0) {
            codedOutputStream.writeInt32(30, i19);
        }
        int i20 = this.lanternPlayTimes_;
        if (i20 != 0) {
            codedOutputStream.writeInt32(31, i20);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
