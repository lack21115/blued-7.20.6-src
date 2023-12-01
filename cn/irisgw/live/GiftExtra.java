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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GiftExtra.class */
public final class GiftExtra extends GeneratedMessageV3 implements GiftExtraOrBuilder {
    public static final int ALWAYS_SHOW_ANIMATION_FIELD_NUMBER = 37;
    public static final int ANIMATION_FIELD_NUMBER = 4;
    public static final int ANIM_CODE_FIELD_NUMBER = 12;
    public static final int ANIM_MANY_FIELD_NUMBER = 47;
    public static final int AVATAR_FRAME_URL_FIELD_NUMBER = 41;
    public static final int BEANS_COUNT_FIELD_NUMBER = 10;
    public static final int BEANS_CURRENT_COUNT_FIELD_NUMBER = 11;
    public static final int BG_COLOR_FIELD_NUMBER = 43;
    public static final int BG_IMG_FIELD_NUMBER = 42;
    public static final int CHAT_BADGE_HEIGHT_FIELD_NUMBER = 40;
    public static final int CHAT_BADGE_LENGTH_FIELD_NUMBER = 39;
    public static final int CHAT_BADGE_URL_FIELD_NUMBER = 38;
    public static final int CHAT_FRAME_BORDER_COLOR_FIELD_NUMBER = 32;
    public static final int CHAT_FRAME_COLOR_TYPE_FIELD_NUMBER = 29;
    public static final int CHAT_FRAME_FIELD_NUMBER = 33;
    public static final int CHAT_FRAME_FRAME_COLOR_FIELD_NUMBER = 31;
    public static final int CHAT_FRAME_GRADIENT_TYPE_FIELD_NUMBER = 30;
    public static final int CHAT_FRAME_ICON_FIELD_NUMBER = 34;
    public static final int FANS_STATUS_FIELD_NUMBER = 19;
    public static final int FAN_CLUB_LEVEL_FIELD_NUMBER = 17;
    public static final int FAN_CLUB_NAME_FIELD_NUMBER = 16;
    public static final int GIFT_BEANS_COUNT_FIELD_NUMBER = 36;
    public static final int GIFT_ID_FIELD_NUMBER = 6;
    public static final int GIFT_NAME_FIELD_NUMBER = 22;
    public static final int GIFT_PIC_APNG_FIELD_NUMBER = 3;
    public static final int GIFT_PIC_GIF_FIELD_NUMBER = 2;
    public static final int GIFT_PIC_MP4_FIELD_NUMBER = 15;
    public static final int GIFT_PIC_URL_FIELD_NUMBER = 1;
    public static final int GIFT_TYPE_FIELD_NUMBER = 5;
    public static final int HIT_BATCH_FIELD_NUMBER = 9;
    public static final int HIT_COUNT_FIELD_NUMBER = 7;
    public static final int HIT_ID_FIELD_NUMBER = 8;
    public static final int IN_FAN_CLUB_FIELD_NUMBER = 18;
    public static final int IS_DRAW_GOODS_FIELD_NUMBER = 24;
    public static final int IS_HELP_WISH_LIST_FIELD_NUMBER = 26;
    public static final int IS_LUCK_BAG_FIELD_NUMBER = 25;
    public static final int IS_REWARD_FIELD_NUMBER = 28;
    public static final int IS_VIBRATE_FIELD_NUMBER = 35;
    public static final int LANTERN_ID_FIELD_NUMBER = 45;
    public static final int LANTERN_IMAGE_FIELD_NUMBER = 44;
    public static final int LANTERN_PLAY_TIMES_FIELD_NUMBER = 46;
    public static final int LIANG_ID_FIELD_NUMBER = 21;
    public static final int LIANG_TYPE_FIELD_NUMBER = 20;
    public static final int RANDOM_NAME_FIELD_NUMBER = 48;
    public static final int RANDOM_STATIC_FIELD_NUMBER = 49;
    public static final int RECHARGE_BADGE_FIELD_NUMBER = 23;
    public static final int RESOURCE_URL_FIELD_NUMBER = 14;
    public static final int TYPE_NAME_FIELD_NUMBER = 13;
    private static final long serialVersionUID = 0;
    private boolean alwaysShowAnimation_;
    private volatile Object animCode_;
    private int animMany_;
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
    private long giftBeansCount_;
    private int giftId_;
    private volatile Object giftName_;
    private volatile Object giftPicApng_;
    private volatile Object giftPicGif_;
    private volatile Object giftPicMp4_;
    private volatile Object giftPicUrl_;
    private int giftType_;
    private int hitBatch_;
    private int hitCount_;
    private long hitId_;
    private boolean inFanClub_;
    private boolean isDrawGoods_;
    private boolean isHelpWishList_;
    private boolean isLuckBag_;
    private boolean isReward_;
    private boolean isVibrate_;
    private int lanternId_;
    private List<lantern_resource> lanternImage_;
    private int lanternPlayTimes_;
    private volatile Object liangId_;
    private int liangType_;
    private byte memoizedIsInitialized;
    private volatile Object randomName_;
    private volatile Object randomStatic_;
    private int rechargeBadge_;
    private volatile Object resourceUrl_;
    private volatile Object typeName_;
    private static final GiftExtra DEFAULT_INSTANCE = new GiftExtra();
    private static final Parser<GiftExtra> PARSER = new AbstractParser<GiftExtra>() { // from class: cn.irisgw.live.GiftExtra.1
        @Override // com.google.protobuf.Parser
        public GiftExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new GiftExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GiftExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GiftExtraOrBuilder {
        private boolean alwaysShowAnimation_;
        private Object animCode_;
        private int animMany_;
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
        private long giftBeansCount_;
        private int giftId_;
        private Object giftName_;
        private Object giftPicApng_;
        private Object giftPicGif_;
        private Object giftPicMp4_;
        private Object giftPicUrl_;
        private int giftType_;
        private int hitBatch_;
        private int hitCount_;
        private long hitId_;
        private boolean inFanClub_;
        private boolean isDrawGoods_;
        private boolean isHelpWishList_;
        private boolean isLuckBag_;
        private boolean isReward_;
        private boolean isVibrate_;
        private int lanternId_;
        private RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> lanternImageBuilder_;
        private List<lantern_resource> lanternImage_;
        private int lanternPlayTimes_;
        private Object liangId_;
        private int liangType_;
        private Object randomName_;
        private Object randomStatic_;
        private int rechargeBadge_;
        private Object resourceUrl_;
        private Object typeName_;

        private Builder() {
            this.giftPicUrl_ = "";
            this.giftPicGif_ = "";
            this.giftPicApng_ = "";
            this.animCode_ = "";
            this.typeName_ = "";
            this.resourceUrl_ = "";
            this.giftPicMp4_ = "";
            this.fanClubName_ = "";
            this.fansStatus_ = 0;
            this.liangType_ = 0;
            this.liangId_ = "";
            this.giftName_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatBadgeUrl_ = "";
            this.avatarFrameUrl_ = "";
            this.bgImg_ = "";
            this.bgColor_ = LazyStringArrayList.EMPTY;
            this.lanternImage_ = Collections.emptyList();
            this.randomName_ = "";
            this.randomStatic_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.giftPicUrl_ = "";
            this.giftPicGif_ = "";
            this.giftPicApng_ = "";
            this.animCode_ = "";
            this.typeName_ = "";
            this.resourceUrl_ = "";
            this.giftPicMp4_ = "";
            this.fanClubName_ = "";
            this.fansStatus_ = 0;
            this.liangType_ = 0;
            this.liangId_ = "";
            this.giftName_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatBadgeUrl_ = "";
            this.avatarFrameUrl_ = "";
            this.bgImg_ = "";
            this.bgColor_ = LazyStringArrayList.EMPTY;
            this.lanternImage_ = Collections.emptyList();
            this.randomName_ = "";
            this.randomStatic_ = "";
            maybeForceBuilderInitialization();
        }

        private void ensureBgColorIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.bgColor_ = new LazyStringArrayList(this.bgColor_);
                this.bitField0_ |= 4;
            }
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

        private void ensureLanternImageIsMutable() {
            if ((this.bitField0_ & 8) == 0) {
                this.lanternImage_ = new ArrayList(this.lanternImage_);
                this.bitField0_ |= 8;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_GiftExtra_descriptor;
        }

        private RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> getLanternImageFieldBuilder() {
            if (this.lanternImageBuilder_ == null) {
                this.lanternImageBuilder_ = new RepeatedFieldBuilderV3<>(this.lanternImage_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                this.lanternImage_ = null;
            }
            return this.lanternImageBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GiftExtra.alwaysUseFieldBuilders) {
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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
                GiftExtra.checkByteStringIsUtf8(byteString);
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
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
        public GiftExtra build() {
            GiftExtra buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GiftExtra buildPartial() {
            GiftExtra giftExtra = new GiftExtra(this);
            giftExtra.giftPicUrl_ = this.giftPicUrl_;
            giftExtra.giftPicGif_ = this.giftPicGif_;
            giftExtra.giftPicApng_ = this.giftPicApng_;
            giftExtra.animation_ = this.animation_;
            giftExtra.giftType_ = this.giftType_;
            giftExtra.giftId_ = this.giftId_;
            giftExtra.hitCount_ = this.hitCount_;
            giftExtra.hitId_ = this.hitId_;
            giftExtra.hitBatch_ = this.hitBatch_;
            giftExtra.beansCount_ = this.beansCount_;
            giftExtra.beansCurrentCount_ = this.beansCurrentCount_;
            giftExtra.animCode_ = this.animCode_;
            giftExtra.typeName_ = this.typeName_;
            giftExtra.resourceUrl_ = this.resourceUrl_;
            giftExtra.giftPicMp4_ = this.giftPicMp4_;
            giftExtra.fanClubName_ = this.fanClubName_;
            giftExtra.fanClubLevel_ = this.fanClubLevel_;
            giftExtra.inFanClub_ = this.inFanClub_;
            giftExtra.fansStatus_ = this.fansStatus_;
            giftExtra.liangType_ = this.liangType_;
            giftExtra.liangId_ = this.liangId_;
            giftExtra.giftName_ = this.giftName_;
            giftExtra.rechargeBadge_ = this.rechargeBadge_;
            giftExtra.isDrawGoods_ = this.isDrawGoods_;
            giftExtra.isLuckBag_ = this.isLuckBag_;
            giftExtra.isHelpWishList_ = this.isHelpWishList_;
            giftExtra.isReward_ = this.isReward_;
            giftExtra.chatFrameColorType_ = this.chatFrameColorType_;
            giftExtra.chatFrameGradientType_ = this.chatFrameGradientType_;
            if ((this.bitField0_ & 1) != 0) {
                this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            giftExtra.chatFrameFrameColor_ = this.chatFrameFrameColor_;
            if ((this.bitField0_ & 2) != 0) {
                this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            giftExtra.chatFrameBorderColor_ = this.chatFrameBorderColor_;
            giftExtra.chatFrame_ = this.chatFrame_;
            giftExtra.chatFrameIcon_ = this.chatFrameIcon_;
            giftExtra.isVibrate_ = this.isVibrate_;
            giftExtra.giftBeansCount_ = this.giftBeansCount_;
            giftExtra.alwaysShowAnimation_ = this.alwaysShowAnimation_;
            giftExtra.chatBadgeUrl_ = this.chatBadgeUrl_;
            giftExtra.chatBadgeLength_ = this.chatBadgeLength_;
            giftExtra.chatBadgeHeight_ = this.chatBadgeHeight_;
            giftExtra.avatarFrameUrl_ = this.avatarFrameUrl_;
            giftExtra.bgImg_ = this.bgImg_;
            if ((this.bitField0_ & 4) != 0) {
                this.bgColor_ = this.bgColor_.getUnmodifiableView();
                this.bitField0_ &= -5;
            }
            giftExtra.bgColor_ = this.bgColor_;
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 8) != 0) {
                    this.lanternImage_ = Collections.unmodifiableList(this.lanternImage_);
                    this.bitField0_ &= -9;
                }
                giftExtra.lanternImage_ = this.lanternImage_;
            } else {
                giftExtra.lanternImage_ = repeatedFieldBuilderV3.build();
            }
            giftExtra.lanternId_ = this.lanternId_;
            giftExtra.lanternPlayTimes_ = this.lanternPlayTimes_;
            giftExtra.animMany_ = this.animMany_;
            giftExtra.randomName_ = this.randomName_;
            giftExtra.randomStatic_ = this.randomStatic_;
            onBuilt();
            return giftExtra;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.giftPicUrl_ = "";
            this.giftPicGif_ = "";
            this.giftPicApng_ = "";
            this.animation_ = 0;
            this.giftType_ = 0;
            this.giftId_ = 0;
            this.hitCount_ = 0;
            this.hitId_ = 0L;
            this.hitBatch_ = 0;
            this.beansCount_ = 0L;
            this.beansCurrentCount_ = 0L;
            this.animCode_ = "";
            this.typeName_ = "";
            this.resourceUrl_ = "";
            this.giftPicMp4_ = "";
            this.fanClubName_ = "";
            this.fanClubLevel_ = 0;
            this.inFanClub_ = false;
            this.fansStatus_ = 0;
            this.liangType_ = 0;
            this.liangId_ = "";
            this.giftName_ = "";
            this.rechargeBadge_ = 0;
            this.isDrawGoods_ = false;
            this.isLuckBag_ = false;
            this.isHelpWishList_ = false;
            this.isReward_ = false;
            this.chatFrameColorType_ = 0;
            this.chatFrameGradientType_ = 0;
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.isVibrate_ = false;
            this.giftBeansCount_ = 0L;
            this.alwaysShowAnimation_ = false;
            this.chatBadgeUrl_ = "";
            this.chatBadgeLength_ = 0;
            this.chatBadgeHeight_ = 0;
            this.avatarFrameUrl_ = "";
            this.bgImg_ = "";
            this.bgColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -5;
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.lanternImage_ = Collections.emptyList();
                this.bitField0_ &= -9;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.lanternId_ = 0;
            this.lanternPlayTimes_ = 0;
            this.animMany_ = 0;
            this.randomName_ = "";
            this.randomStatic_ = "";
            return this;
        }

        public Builder clearAlwaysShowAnimation() {
            this.alwaysShowAnimation_ = false;
            onChanged();
            return this;
        }

        public Builder clearAnimCode() {
            this.animCode_ = GiftExtra.getDefaultInstance().getAnimCode();
            onChanged();
            return this;
        }

        public Builder clearAnimMany() {
            this.animMany_ = 0;
            onChanged();
            return this;
        }

        public Builder clearAnimation() {
            this.animation_ = 0;
            onChanged();
            return this;
        }

        public Builder clearAvatarFrameUrl() {
            this.avatarFrameUrl_ = GiftExtra.getDefaultInstance().getAvatarFrameUrl();
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
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearBgImg() {
            this.bgImg_ = GiftExtra.getDefaultInstance().getBgImg();
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
            this.chatBadgeUrl_ = GiftExtra.getDefaultInstance().getChatBadgeUrl();
            onChanged();
            return this;
        }

        public Builder clearChatFrame() {
            this.chatFrame_ = GiftExtra.getDefaultInstance().getChatFrame();
            onChanged();
            return this;
        }

        public Builder clearChatFrameBorderColor() {
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
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
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearChatFrameGradientType() {
            this.chatFrameGradientType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChatFrameIcon() {
            this.chatFrameIcon_ = GiftExtra.getDefaultInstance().getChatFrameIcon();
            onChanged();
            return this;
        }

        public Builder clearFanClubLevel() {
            this.fanClubLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearFanClubName() {
            this.fanClubName_ = GiftExtra.getDefaultInstance().getFanClubName();
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

        public Builder clearGiftBeansCount() {
            this.giftBeansCount_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearGiftId() {
            this.giftId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearGiftName() {
            this.giftName_ = GiftExtra.getDefaultInstance().getGiftName();
            onChanged();
            return this;
        }

        public Builder clearGiftPicApng() {
            this.giftPicApng_ = GiftExtra.getDefaultInstance().getGiftPicApng();
            onChanged();
            return this;
        }

        public Builder clearGiftPicGif() {
            this.giftPicGif_ = GiftExtra.getDefaultInstance().getGiftPicGif();
            onChanged();
            return this;
        }

        public Builder clearGiftPicMp4() {
            this.giftPicMp4_ = GiftExtra.getDefaultInstance().getGiftPicMp4();
            onChanged();
            return this;
        }

        public Builder clearGiftPicUrl() {
            this.giftPicUrl_ = GiftExtra.getDefaultInstance().getGiftPicUrl();
            onChanged();
            return this;
        }

        public Builder clearGiftType() {
            this.giftType_ = 0;
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

        public Builder clearIsDrawGoods() {
            this.isDrawGoods_ = false;
            onChanged();
            return this;
        }

        public Builder clearIsHelpWishList() {
            this.isHelpWishList_ = false;
            onChanged();
            return this;
        }

        public Builder clearIsLuckBag() {
            this.isLuckBag_ = false;
            onChanged();
            return this;
        }

        public Builder clearIsReward() {
            this.isReward_ = false;
            onChanged();
            return this;
        }

        public Builder clearIsVibrate() {
            this.isVibrate_ = false;
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
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder clearLanternPlayTimes() {
            this.lanternPlayTimes_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLiangId() {
            this.liangId_ = GiftExtra.getDefaultInstance().getLiangId();
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

        public Builder clearRandomName() {
            this.randomName_ = GiftExtra.getDefaultInstance().getRandomName();
            onChanged();
            return this;
        }

        public Builder clearRandomStatic() {
            this.randomStatic_ = GiftExtra.getDefaultInstance().getRandomStatic();
            onChanged();
            return this;
        }

        public Builder clearRechargeBadge() {
            this.rechargeBadge_ = 0;
            onChanged();
            return this;
        }

        public Builder clearResourceUrl() {
            this.resourceUrl_ = GiftExtra.getDefaultInstance().getResourceUrl();
            onChanged();
            return this;
        }

        public Builder clearTypeName() {
            this.typeName_ = GiftExtra.getDefaultInstance().getTypeName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public boolean getAlwaysShowAnimation() {
            return this.alwaysShowAnimation_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getAnimCode() {
            Object obj = this.animCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.animCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getAnimCodeBytes() {
            Object obj = this.animCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.animCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getAnimMany() {
            return this.animMany_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getAnimation() {
            return this.animation_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getAvatarFrameUrl() {
            Object obj = this.avatarFrameUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatarFrameUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getAvatarFrameUrlBytes() {
            Object obj = this.avatarFrameUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatarFrameUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public long getBeansCount() {
            return this.beansCount_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public long getBeansCurrentCount() {
            return this.beansCurrentCount_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getBgColor(int i) {
            return this.bgColor_.get(i);
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getBgColorBytes(int i) {
            return this.bgColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getBgColorCount() {
            return this.bgColor_.size();
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ProtocolStringList getBgColorList() {
            return this.bgColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getBgImg() {
            Object obj = this.bgImg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.bgImg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getBgImgBytes() {
            Object obj = this.bgImg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bgImg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getChatBadgeHeight() {
            return this.chatBadgeHeight_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getChatBadgeLength() {
            return this.chatBadgeLength_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getChatBadgeUrl() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatBadgeUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getChatBadgeUrlBytes() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatBadgeUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getChatFrame() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrame_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getChatFrameBorderColor(int i) {
            return this.chatFrameBorderColor_.get(i);
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getChatFrameBorderColorBytes(int i) {
            return this.chatFrameBorderColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getChatFrameBorderColorCount() {
            return this.chatFrameBorderColor_.size();
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ProtocolStringList getChatFrameBorderColorList() {
            return this.chatFrameBorderColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getChatFrameBytes() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrame_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getChatFrameColorType() {
            return this.chatFrameColorType_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getChatFrameFrameColor(int i) {
            return this.chatFrameFrameColor_.get(i);
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getChatFrameFrameColorBytes(int i) {
            return this.chatFrameFrameColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getChatFrameFrameColorCount() {
            return this.chatFrameFrameColor_.size();
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ProtocolStringList getChatFrameFrameColorList() {
            return this.chatFrameFrameColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getChatFrameGradientType() {
            return this.chatFrameGradientType_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getChatFrameIcon() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrameIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
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
        public GiftExtra getDefaultInstanceForType() {
            return GiftExtra.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_GiftExtra_descriptor;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getFanClubLevel() {
            return this.fanClubLevel_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getFanClubName() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fanClubName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getFanClubNameBytes() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fanClubName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public FanStatus getFansStatus() {
            FanStatus valueOf = FanStatus.valueOf(this.fansStatus_);
            FanStatus fanStatus = valueOf;
            if (valueOf == null) {
                fanStatus = FanStatus.UNRECOGNIZED;
            }
            return fanStatus;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getFansStatusValue() {
            return this.fansStatus_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public long getGiftBeansCount() {
            return this.giftBeansCount_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getGiftId() {
            return this.giftId_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getGiftName() {
            Object obj = this.giftName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getGiftNameBytes() {
            Object obj = this.giftName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getGiftPicApng() {
            Object obj = this.giftPicApng_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftPicApng_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getGiftPicApngBytes() {
            Object obj = this.giftPicApng_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftPicApng_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getGiftPicGif() {
            Object obj = this.giftPicGif_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftPicGif_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getGiftPicGifBytes() {
            Object obj = this.giftPicGif_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftPicGif_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getGiftPicMp4() {
            Object obj = this.giftPicMp4_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftPicMp4_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getGiftPicMp4Bytes() {
            Object obj = this.giftPicMp4_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftPicMp4_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getGiftPicUrl() {
            Object obj = this.giftPicUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftPicUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getGiftPicUrlBytes() {
            Object obj = this.giftPicUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftPicUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getGiftType() {
            return this.giftType_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getHitBatch() {
            return this.hitBatch_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getHitCount() {
            return this.hitCount_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public long getHitId() {
            return this.hitId_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public boolean getInFanClub() {
            return this.inFanClub_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public boolean getIsDrawGoods() {
            return this.isDrawGoods_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public boolean getIsHelpWishList() {
            return this.isHelpWishList_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public boolean getIsLuckBag() {
            return this.isLuckBag_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public boolean getIsReward() {
            return this.isReward_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public boolean getIsVibrate() {
            return this.isVibrate_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getLanternId() {
            return this.lanternId_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
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

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getLanternImageCount() {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            return repeatedFieldBuilderV3 == null ? this.lanternImage_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public List<lantern_resource> getLanternImageList() {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.lanternImage_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public lantern_resourceOrBuilder getLanternImageOrBuilder(int i) {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            return repeatedFieldBuilderV3 == null ? this.lanternImage_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public List<? extends lantern_resourceOrBuilder> getLanternImageOrBuilderList() {
            RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = this.lanternImageBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.lanternImage_);
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getLanternPlayTimes() {
            return this.lanternPlayTimes_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getLiangId() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liangId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getLiangIdBytes() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liangId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public LiangType getLiangType() {
            LiangType valueOf = LiangType.valueOf(this.liangType_);
            LiangType liangType = valueOf;
            if (valueOf == null) {
                liangType = LiangType.UNRECOGNIZED;
            }
            return liangType;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getLiangTypeValue() {
            return this.liangType_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getRandomName() {
            Object obj = this.randomName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.randomName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getRandomNameBytes() {
            Object obj = this.randomName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.randomName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getRandomStatic() {
            Object obj = this.randomStatic_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.randomStatic_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getRandomStaticBytes() {
            Object obj = this.randomStatic_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.randomStatic_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public int getRechargeBadge() {
            return this.rechargeBadge_;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getResourceUrl() {
            Object obj = this.resourceUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.resourceUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public ByteString getResourceUrlBytes() {
            Object obj = this.resourceUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.resourceUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
        public String getTypeName() {
            Object obj = this.typeName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.typeName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtraOrBuilder
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
            return LiveConstants.internal_static_cn_irisgw_live_GiftExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(GiftExtra.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(GiftExtra giftExtra) {
            if (giftExtra == GiftExtra.getDefaultInstance()) {
                return this;
            }
            if (!giftExtra.getGiftPicUrl().isEmpty()) {
                this.giftPicUrl_ = giftExtra.giftPicUrl_;
                onChanged();
            }
            if (!giftExtra.getGiftPicGif().isEmpty()) {
                this.giftPicGif_ = giftExtra.giftPicGif_;
                onChanged();
            }
            if (!giftExtra.getGiftPicApng().isEmpty()) {
                this.giftPicApng_ = giftExtra.giftPicApng_;
                onChanged();
            }
            if (giftExtra.getAnimation() != 0) {
                setAnimation(giftExtra.getAnimation());
            }
            if (giftExtra.getGiftType() != 0) {
                setGiftType(giftExtra.getGiftType());
            }
            if (giftExtra.getGiftId() != 0) {
                setGiftId(giftExtra.getGiftId());
            }
            if (giftExtra.getHitCount() != 0) {
                setHitCount(giftExtra.getHitCount());
            }
            if (giftExtra.getHitId() != 0) {
                setHitId(giftExtra.getHitId());
            }
            if (giftExtra.getHitBatch() != 0) {
                setHitBatch(giftExtra.getHitBatch());
            }
            if (giftExtra.getBeansCount() != 0) {
                setBeansCount(giftExtra.getBeansCount());
            }
            if (giftExtra.getBeansCurrentCount() != 0) {
                setBeansCurrentCount(giftExtra.getBeansCurrentCount());
            }
            if (!giftExtra.getAnimCode().isEmpty()) {
                this.animCode_ = giftExtra.animCode_;
                onChanged();
            }
            if (!giftExtra.getTypeName().isEmpty()) {
                this.typeName_ = giftExtra.typeName_;
                onChanged();
            }
            if (!giftExtra.getResourceUrl().isEmpty()) {
                this.resourceUrl_ = giftExtra.resourceUrl_;
                onChanged();
            }
            if (!giftExtra.getGiftPicMp4().isEmpty()) {
                this.giftPicMp4_ = giftExtra.giftPicMp4_;
                onChanged();
            }
            if (!giftExtra.getFanClubName().isEmpty()) {
                this.fanClubName_ = giftExtra.fanClubName_;
                onChanged();
            }
            if (giftExtra.getFanClubLevel() != 0) {
                setFanClubLevel(giftExtra.getFanClubLevel());
            }
            if (giftExtra.getInFanClub()) {
                setInFanClub(giftExtra.getInFanClub());
            }
            if (giftExtra.fansStatus_ != 0) {
                setFansStatusValue(giftExtra.getFansStatusValue());
            }
            if (giftExtra.liangType_ != 0) {
                setLiangTypeValue(giftExtra.getLiangTypeValue());
            }
            if (!giftExtra.getLiangId().isEmpty()) {
                this.liangId_ = giftExtra.liangId_;
                onChanged();
            }
            if (!giftExtra.getGiftName().isEmpty()) {
                this.giftName_ = giftExtra.giftName_;
                onChanged();
            }
            if (giftExtra.getRechargeBadge() != 0) {
                setRechargeBadge(giftExtra.getRechargeBadge());
            }
            if (giftExtra.getIsDrawGoods()) {
                setIsDrawGoods(giftExtra.getIsDrawGoods());
            }
            if (giftExtra.getIsLuckBag()) {
                setIsLuckBag(giftExtra.getIsLuckBag());
            }
            if (giftExtra.getIsHelpWishList()) {
                setIsHelpWishList(giftExtra.getIsHelpWishList());
            }
            if (giftExtra.getIsReward()) {
                setIsReward(giftExtra.getIsReward());
            }
            if (giftExtra.getChatFrameColorType() != 0) {
                setChatFrameColorType(giftExtra.getChatFrameColorType());
            }
            if (giftExtra.getChatFrameGradientType() != 0) {
                setChatFrameGradientType(giftExtra.getChatFrameGradientType());
            }
            if (!giftExtra.chatFrameFrameColor_.isEmpty()) {
                if (this.chatFrameFrameColor_.isEmpty()) {
                    this.chatFrameFrameColor_ = giftExtra.chatFrameFrameColor_;
                    this.bitField0_ &= -2;
                } else {
                    ensureChatFrameFrameColorIsMutable();
                    this.chatFrameFrameColor_.addAll(giftExtra.chatFrameFrameColor_);
                }
                onChanged();
            }
            if (!giftExtra.chatFrameBorderColor_.isEmpty()) {
                if (this.chatFrameBorderColor_.isEmpty()) {
                    this.chatFrameBorderColor_ = giftExtra.chatFrameBorderColor_;
                    this.bitField0_ &= -3;
                } else {
                    ensureChatFrameBorderColorIsMutable();
                    this.chatFrameBorderColor_.addAll(giftExtra.chatFrameBorderColor_);
                }
                onChanged();
            }
            if (!giftExtra.getChatFrame().isEmpty()) {
                this.chatFrame_ = giftExtra.chatFrame_;
                onChanged();
            }
            if (!giftExtra.getChatFrameIcon().isEmpty()) {
                this.chatFrameIcon_ = giftExtra.chatFrameIcon_;
                onChanged();
            }
            if (giftExtra.getIsVibrate()) {
                setIsVibrate(giftExtra.getIsVibrate());
            }
            if (giftExtra.getGiftBeansCount() != 0) {
                setGiftBeansCount(giftExtra.getGiftBeansCount());
            }
            if (giftExtra.getAlwaysShowAnimation()) {
                setAlwaysShowAnimation(giftExtra.getAlwaysShowAnimation());
            }
            if (!giftExtra.getChatBadgeUrl().isEmpty()) {
                this.chatBadgeUrl_ = giftExtra.chatBadgeUrl_;
                onChanged();
            }
            if (giftExtra.getChatBadgeLength() != 0) {
                setChatBadgeLength(giftExtra.getChatBadgeLength());
            }
            if (giftExtra.getChatBadgeHeight() != 0) {
                setChatBadgeHeight(giftExtra.getChatBadgeHeight());
            }
            if (!giftExtra.getAvatarFrameUrl().isEmpty()) {
                this.avatarFrameUrl_ = giftExtra.avatarFrameUrl_;
                onChanged();
            }
            if (!giftExtra.getBgImg().isEmpty()) {
                this.bgImg_ = giftExtra.bgImg_;
                onChanged();
            }
            if (!giftExtra.bgColor_.isEmpty()) {
                if (this.bgColor_.isEmpty()) {
                    this.bgColor_ = giftExtra.bgColor_;
                    this.bitField0_ &= -5;
                } else {
                    ensureBgColorIsMutable();
                    this.bgColor_.addAll(giftExtra.bgColor_);
                }
                onChanged();
            }
            if (this.lanternImageBuilder_ == null) {
                if (!giftExtra.lanternImage_.isEmpty()) {
                    if (this.lanternImage_.isEmpty()) {
                        this.lanternImage_ = giftExtra.lanternImage_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureLanternImageIsMutable();
                        this.lanternImage_.addAll(giftExtra.lanternImage_);
                    }
                    onChanged();
                }
            } else if (!giftExtra.lanternImage_.isEmpty()) {
                if (this.lanternImageBuilder_.isEmpty()) {
                    this.lanternImageBuilder_.dispose();
                    RepeatedFieldBuilderV3<lantern_resource, lantern_resource.Builder, lantern_resourceOrBuilder> repeatedFieldBuilderV3 = null;
                    this.lanternImageBuilder_ = null;
                    this.lanternImage_ = giftExtra.lanternImage_;
                    this.bitField0_ &= -9;
                    if (GiftExtra.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getLanternImageFieldBuilder();
                    }
                    this.lanternImageBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.lanternImageBuilder_.addAllMessages(giftExtra.lanternImage_);
                }
            }
            if (giftExtra.getLanternId() != 0) {
                setLanternId(giftExtra.getLanternId());
            }
            if (giftExtra.getLanternPlayTimes() != 0) {
                setLanternPlayTimes(giftExtra.getLanternPlayTimes());
            }
            if (giftExtra.getAnimMany() != 0) {
                setAnimMany(giftExtra.getAnimMany());
            }
            if (!giftExtra.getRandomName().isEmpty()) {
                this.randomName_ = giftExtra.randomName_;
                onChanged();
            }
            if (!giftExtra.getRandomStatic().isEmpty()) {
                this.randomStatic_ = giftExtra.randomStatic_;
                onChanged();
            }
            mergeUnknownFields(giftExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.GiftExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.GiftExtra.access$6300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.GiftExtra r0 = (cn.irisgw.live.GiftExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.GiftExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.GiftExtra r0 = (cn.irisgw.live.GiftExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.GiftExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.GiftExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.GiftExtra$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof GiftExtra) {
                return mergeFrom((GiftExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
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

        public Builder setAlwaysShowAnimation(boolean z) {
            this.alwaysShowAnimation_ = z;
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
                GiftExtra.checkByteStringIsUtf8(byteString);
                this.animCode_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAnimMany(int i) {
            this.animMany_ = i;
            onChanged();
            return this;
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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

        public Builder setGiftBeansCount(long j) {
            this.giftBeansCount_ = j;
            onChanged();
            return this;
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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

        public Builder setIsDrawGoods(boolean z) {
            this.isDrawGoods_ = z;
            onChanged();
            return this;
        }

        public Builder setIsHelpWishList(boolean z) {
            this.isHelpWishList_ = z;
            onChanged();
            return this;
        }

        public Builder setIsLuckBag(boolean z) {
            this.isLuckBag_ = z;
            onChanged();
            return this;
        }

        public Builder setIsReward(boolean z) {
            this.isReward_ = z;
            onChanged();
            return this;
        }

        public Builder setIsVibrate(boolean z) {
            this.isVibrate_ = z;
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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

        public Builder setRandomName(String str) {
            if (str != null) {
                this.randomName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRandomNameBytes(ByteString byteString) {
            if (byteString != null) {
                GiftExtra.checkByteStringIsUtf8(byteString);
                this.randomName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRandomStatic(String str) {
            if (str != null) {
                this.randomStatic_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRandomStaticBytes(ByteString byteString) {
            if (byteString != null) {
                GiftExtra.checkByteStringIsUtf8(byteString);
                this.randomStatic_ = byteString;
                onChanged();
                return this;
            }
            throw null;
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
                GiftExtra.checkByteStringIsUtf8(byteString);
                this.resourceUrl_ = byteString;
                onChanged();
                return this;
            }
            throw null;
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
                GiftExtra.checkByteStringIsUtf8(byteString);
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GiftExtra$lantern_resource.class */
    public static final class lantern_resource extends GeneratedMessageV3 implements lantern_resourceOrBuilder {
        public static final int IMG_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object img_;
        private byte memoizedIsInitialized;
        private static final lantern_resource DEFAULT_INSTANCE = new lantern_resource();
        private static final Parser<lantern_resource> PARSER = new AbstractParser<lantern_resource>() { // from class: cn.irisgw.live.GiftExtra.lantern_resource.1
            @Override // com.google.protobuf.Parser
            public lantern_resource parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new lantern_resource(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GiftExtra$lantern_resource$Builder.class */
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
                return LiveConstants.internal_static_cn_irisgw_live_GiftExtra_lantern_resource_descriptor;
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
                return LiveConstants.internal_static_cn_irisgw_live_GiftExtra_lantern_resource_descriptor;
            }

            @Override // cn.irisgw.live.GiftExtra.lantern_resourceOrBuilder
            public String getImg() {
                Object obj = this.img_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.img_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.GiftExtra.lantern_resourceOrBuilder
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
                return LiveConstants.internal_static_cn_irisgw_live_GiftExtra_lantern_resource_fieldAccessorTable.ensureFieldAccessorsInitialized(lantern_resource.class, Builder.class);
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
            public cn.irisgw.live.GiftExtra.lantern_resource.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.GiftExtra.lantern_resource.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.GiftExtra$lantern_resource r0 = (cn.irisgw.live.GiftExtra.lantern_resource) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.GiftExtra$lantern_resource$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.GiftExtra$lantern_resource r0 = (cn.irisgw.live.GiftExtra.lantern_resource) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.GiftExtra$lantern_resource$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.GiftExtra.lantern_resource.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.GiftExtra$lantern_resource$Builder");
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
            return LiveConstants.internal_static_cn_irisgw_live_GiftExtra_lantern_resource_descriptor;
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

        @Override // cn.irisgw.live.GiftExtra.lantern_resourceOrBuilder
        public String getImg() {
            Object obj = this.img_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.img_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GiftExtra.lantern_resourceOrBuilder
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
            return LiveConstants.internal_static_cn_irisgw_live_GiftExtra_lantern_resource_fieldAccessorTable.ensureFieldAccessorsInitialized(lantern_resource.class, Builder.class);
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GiftExtra$lantern_resourceOrBuilder.class */
    public interface lantern_resourceOrBuilder extends MessageOrBuilder {
        String getImg();

        ByteString getImgBytes();
    }

    private GiftExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.giftPicUrl_ = "";
        this.giftPicGif_ = "";
        this.giftPicApng_ = "";
        this.animCode_ = "";
        this.typeName_ = "";
        this.resourceUrl_ = "";
        this.giftPicMp4_ = "";
        this.fanClubName_ = "";
        this.fansStatus_ = 0;
        this.liangType_ = 0;
        this.liangId_ = "";
        this.giftName_ = "";
        this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
        this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
        this.chatFrame_ = "";
        this.chatFrameIcon_ = "";
        this.chatBadgeUrl_ = "";
        this.avatarFrameUrl_ = "";
        this.bgImg_ = "";
        this.bgColor_ = LazyStringArrayList.EMPTY;
        this.lanternImage_ = Collections.emptyList();
        this.randomName_ = "";
        this.randomStatic_ = "";
    }

    private GiftExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.giftPicUrl_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 18:
                            this.giftPicGif_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 26:
                            this.giftPicApng_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 32:
                            this.animation_ = codedInputStream.readUInt32();
                            continue;
                        case 40:
                            this.giftType_ = codedInputStream.readUInt32();
                            continue;
                        case 48:
                            this.giftId_ = codedInputStream.readUInt32();
                            continue;
                        case 56:
                            this.hitCount_ = codedInputStream.readUInt32();
                            continue;
                        case 64:
                            this.hitId_ = codedInputStream.readUInt64();
                            continue;
                        case 72:
                            this.hitBatch_ = codedInputStream.readUInt32();
                            continue;
                        case 80:
                            this.beansCount_ = codedInputStream.readUInt64();
                            continue;
                        case 88:
                            this.beansCurrentCount_ = codedInputStream.readUInt64();
                            continue;
                        case 98:
                            this.animCode_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 106:
                            this.typeName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 114:
                            this.resourceUrl_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 122:
                            this.giftPicMp4_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 130:
                            this.fanClubName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 136:
                            this.fanClubLevel_ = codedInputStream.readInt32();
                            continue;
                        case 144:
                            this.inFanClub_ = codedInputStream.readBool();
                            continue;
                        case 152:
                            this.fansStatus_ = codedInputStream.readEnum();
                            continue;
                        case 160:
                            this.liangType_ = codedInputStream.readEnum();
                            continue;
                        case 170:
                            this.liangId_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 178:
                            this.giftName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 184:
                            this.rechargeBadge_ = codedInputStream.readInt32();
                            continue;
                        case 192:
                            this.isDrawGoods_ = codedInputStream.readBool();
                            continue;
                        case 200:
                            this.isLuckBag_ = codedInputStream.readBool();
                            continue;
                        case 208:
                            this.isHelpWishList_ = codedInputStream.readBool();
                            continue;
                        case 224:
                            this.isReward_ = codedInputStream.readBool();
                            continue;
                        case 232:
                            this.chatFrameColorType_ = codedInputStream.readInt32();
                            continue;
                        case 240:
                            this.chatFrameGradientType_ = codedInputStream.readInt32();
                            continue;
                        case 250:
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameFrameColor_ = new LazyStringArrayList();
                                z4 = z2 | true;
                            }
                            this.chatFrameFrameColor_.add((LazyStringList) readStringRequireUtf8);
                            z2 = z4;
                            continue;
                        case 258:
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameBorderColor_ = new LazyStringArrayList();
                                z5 = z2 | true;
                            }
                            this.chatFrameBorderColor_.add((LazyStringList) readStringRequireUtf82);
                            z2 = z5;
                            continue;
                        case 266:
                            this.chatFrame_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 274:
                            this.chatFrameIcon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 280:
                            this.isVibrate_ = codedInputStream.readBool();
                            continue;
                        case 288:
                            this.giftBeansCount_ = codedInputStream.readUInt64();
                            continue;
                        case 296:
                            this.alwaysShowAnimation_ = codedInputStream.readBool();
                            continue;
                        case 306:
                            this.chatBadgeUrl_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 312:
                            this.chatBadgeLength_ = codedInputStream.readInt32();
                            continue;
                        case 320:
                            this.chatBadgeHeight_ = codedInputStream.readInt32();
                            continue;
                        case 330:
                            this.avatarFrameUrl_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 338:
                            this.bgImg_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 346:
                            String readStringRequireUtf83 = codedInputStream.readStringRequireUtf8();
                            boolean z6 = z2;
                            if (!(z2 & true)) {
                                this.bgColor_ = new LazyStringArrayList();
                                z6 = z2 | true;
                            }
                            this.bgColor_.add((LazyStringList) readStringRequireUtf83);
                            z2 = z6;
                            continue;
                        case 354:
                            boolean z7 = z2;
                            if (!(z2 & true)) {
                                this.lanternImage_ = new ArrayList();
                                z7 = z2 | true;
                            }
                            this.lanternImage_.add((lantern_resource) codedInputStream.readMessage(lantern_resource.parser(), extensionRegistryLite));
                            z2 = z7;
                            continue;
                        case 360:
                            this.lanternId_ = codedInputStream.readInt32();
                            continue;
                        case 368:
                            this.lanternPlayTimes_ = codedInputStream.readInt32();
                            continue;
                        case 376:
                            this.animMany_ = codedInputStream.readInt32();
                            continue;
                        case 386:
                            this.randomName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 394:
                            this.randomStatic_ = codedInputStream.readStringRequireUtf8();
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

    private GiftExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static GiftExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_GiftExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(GiftExtra giftExtra) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(giftExtra);
    }

    public static GiftExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GiftExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GiftExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GiftExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GiftExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GiftExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GiftExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GiftExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static GiftExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GiftExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static GiftExtra parseFrom(InputStream inputStream) throws IOException {
        return (GiftExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static GiftExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GiftExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GiftExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GiftExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GiftExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GiftExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<GiftExtra> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GiftExtra) {
            GiftExtra giftExtra = (GiftExtra) obj;
            return getGiftPicUrl().equals(giftExtra.getGiftPicUrl()) && getGiftPicGif().equals(giftExtra.getGiftPicGif()) && getGiftPicApng().equals(giftExtra.getGiftPicApng()) && getAnimation() == giftExtra.getAnimation() && getGiftType() == giftExtra.getGiftType() && getGiftId() == giftExtra.getGiftId() && getHitCount() == giftExtra.getHitCount() && getHitId() == giftExtra.getHitId() && getHitBatch() == giftExtra.getHitBatch() && getBeansCount() == giftExtra.getBeansCount() && getBeansCurrentCount() == giftExtra.getBeansCurrentCount() && getAnimCode().equals(giftExtra.getAnimCode()) && getTypeName().equals(giftExtra.getTypeName()) && getResourceUrl().equals(giftExtra.getResourceUrl()) && getGiftPicMp4().equals(giftExtra.getGiftPicMp4()) && getFanClubName().equals(giftExtra.getFanClubName()) && getFanClubLevel() == giftExtra.getFanClubLevel() && getInFanClub() == giftExtra.getInFanClub() && this.fansStatus_ == giftExtra.fansStatus_ && this.liangType_ == giftExtra.liangType_ && getLiangId().equals(giftExtra.getLiangId()) && getGiftName().equals(giftExtra.getGiftName()) && getRechargeBadge() == giftExtra.getRechargeBadge() && getIsDrawGoods() == giftExtra.getIsDrawGoods() && getIsLuckBag() == giftExtra.getIsLuckBag() && getIsHelpWishList() == giftExtra.getIsHelpWishList() && getIsReward() == giftExtra.getIsReward() && getChatFrameColorType() == giftExtra.getChatFrameColorType() && getChatFrameGradientType() == giftExtra.getChatFrameGradientType() && getChatFrameFrameColorList().equals(giftExtra.getChatFrameFrameColorList()) && getChatFrameBorderColorList().equals(giftExtra.getChatFrameBorderColorList()) && getChatFrame().equals(giftExtra.getChatFrame()) && getChatFrameIcon().equals(giftExtra.getChatFrameIcon()) && getIsVibrate() == giftExtra.getIsVibrate() && getGiftBeansCount() == giftExtra.getGiftBeansCount() && getAlwaysShowAnimation() == giftExtra.getAlwaysShowAnimation() && getChatBadgeUrl().equals(giftExtra.getChatBadgeUrl()) && getChatBadgeLength() == giftExtra.getChatBadgeLength() && getChatBadgeHeight() == giftExtra.getChatBadgeHeight() && getAvatarFrameUrl().equals(giftExtra.getAvatarFrameUrl()) && getBgImg().equals(giftExtra.getBgImg()) && getBgColorList().equals(giftExtra.getBgColorList()) && getLanternImageList().equals(giftExtra.getLanternImageList()) && getLanternId() == giftExtra.getLanternId() && getLanternPlayTimes() == giftExtra.getLanternPlayTimes() && getAnimMany() == giftExtra.getAnimMany() && getRandomName().equals(giftExtra.getRandomName()) && getRandomStatic().equals(giftExtra.getRandomStatic()) && this.unknownFields.equals(giftExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public boolean getAlwaysShowAnimation() {
        return this.alwaysShowAnimation_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getAnimCode() {
        Object obj = this.animCode_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.animCode_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getAnimCodeBytes() {
        Object obj = this.animCode_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.animCode_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getAnimMany() {
        return this.animMany_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getAnimation() {
        return this.animation_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getAvatarFrameUrl() {
        Object obj = this.avatarFrameUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatarFrameUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getAvatarFrameUrlBytes() {
        Object obj = this.avatarFrameUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.avatarFrameUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public long getBeansCount() {
        return this.beansCount_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public long getBeansCurrentCount() {
        return this.beansCurrentCount_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getBgColor(int i) {
        return this.bgColor_.get(i);
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getBgColorBytes(int i) {
        return this.bgColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getBgColorCount() {
        return this.bgColor_.size();
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ProtocolStringList getBgColorList() {
        return this.bgColor_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getBgImg() {
        Object obj = this.bgImg_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.bgImg_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getBgImgBytes() {
        Object obj = this.bgImg_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bgImg_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getChatBadgeHeight() {
        return this.chatBadgeHeight_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getChatBadgeLength() {
        return this.chatBadgeLength_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getChatBadgeUrl() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatBadgeUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getChatBadgeUrlBytes() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatBadgeUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getChatFrame() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrame_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getChatFrameBorderColor(int i) {
        return this.chatFrameBorderColor_.get(i);
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getChatFrameBorderColorBytes(int i) {
        return this.chatFrameBorderColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getChatFrameBorderColorCount() {
        return this.chatFrameBorderColor_.size();
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ProtocolStringList getChatFrameBorderColorList() {
        return this.chatFrameBorderColor_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getChatFrameBytes() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrame_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getChatFrameColorType() {
        return this.chatFrameColorType_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getChatFrameFrameColor(int i) {
        return this.chatFrameFrameColor_.get(i);
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getChatFrameFrameColorBytes(int i) {
        return this.chatFrameFrameColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getChatFrameFrameColorCount() {
        return this.chatFrameFrameColor_.size();
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ProtocolStringList getChatFrameFrameColorList() {
        return this.chatFrameFrameColor_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getChatFrameGradientType() {
        return this.chatFrameGradientType_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getChatFrameIcon() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrameIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
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
    public GiftExtra getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getFanClubLevel() {
        return this.fanClubLevel_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getFanClubName() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.fanClubName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getFanClubNameBytes() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fanClubName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public FanStatus getFansStatus() {
        FanStatus valueOf = FanStatus.valueOf(this.fansStatus_);
        FanStatus fanStatus = valueOf;
        if (valueOf == null) {
            fanStatus = FanStatus.UNRECOGNIZED;
        }
        return fanStatus;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getFansStatusValue() {
        return this.fansStatus_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public long getGiftBeansCount() {
        return this.giftBeansCount_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getGiftId() {
        return this.giftId_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getGiftName() {
        Object obj = this.giftName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getGiftNameBytes() {
        Object obj = this.giftName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getGiftPicApng() {
        Object obj = this.giftPicApng_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftPicApng_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getGiftPicApngBytes() {
        Object obj = this.giftPicApng_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftPicApng_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getGiftPicGif() {
        Object obj = this.giftPicGif_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftPicGif_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getGiftPicGifBytes() {
        Object obj = this.giftPicGif_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftPicGif_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getGiftPicMp4() {
        Object obj = this.giftPicMp4_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftPicMp4_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getGiftPicMp4Bytes() {
        Object obj = this.giftPicMp4_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftPicMp4_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getGiftPicUrl() {
        Object obj = this.giftPicUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftPicUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getGiftPicUrlBytes() {
        Object obj = this.giftPicUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftPicUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getGiftType() {
        return this.giftType_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getHitBatch() {
        return this.hitBatch_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getHitCount() {
        return this.hitCount_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public long getHitId() {
        return this.hitId_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public boolean getInFanClub() {
        return this.inFanClub_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public boolean getIsDrawGoods() {
        return this.isDrawGoods_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public boolean getIsHelpWishList() {
        return this.isHelpWishList_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public boolean getIsLuckBag() {
        return this.isLuckBag_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public boolean getIsReward() {
        return this.isReward_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public boolean getIsVibrate() {
        return this.isVibrate_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getLanternId() {
        return this.lanternId_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public lantern_resource getLanternImage(int i) {
        return this.lanternImage_.get(i);
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getLanternImageCount() {
        return this.lanternImage_.size();
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public List<lantern_resource> getLanternImageList() {
        return this.lanternImage_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public lantern_resourceOrBuilder getLanternImageOrBuilder(int i) {
        return this.lanternImage_.get(i);
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public List<? extends lantern_resourceOrBuilder> getLanternImageOrBuilderList() {
        return this.lanternImage_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getLanternPlayTimes() {
        return this.lanternPlayTimes_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getLiangId() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.liangId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getLiangIdBytes() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.liangId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public LiangType getLiangType() {
        LiangType valueOf = LiangType.valueOf(this.liangType_);
        LiangType liangType = valueOf;
        if (valueOf == null) {
            liangType = LiangType.UNRECOGNIZED;
        }
        return liangType;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getLiangTypeValue() {
        return this.liangType_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GiftExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getRandomName() {
        Object obj = this.randomName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.randomName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getRandomNameBytes() {
        Object obj = this.randomName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.randomName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getRandomStatic() {
        Object obj = this.randomStatic_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.randomStatic_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public ByteString getRandomStaticBytes() {
        Object obj = this.randomStatic_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.randomStatic_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public int getRechargeBadge() {
        return this.rechargeBadge_;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getResourceUrl() {
        Object obj = this.resourceUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.resourceUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
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
        int computeStringSize = !getGiftPicUrlBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.giftPicUrl_) + 0 : 0;
        int i2 = computeStringSize;
        if (!getGiftPicGifBytes().isEmpty()) {
            i2 = computeStringSize + GeneratedMessageV3.computeStringSize(2, this.giftPicGif_);
        }
        int i3 = i2;
        if (!getGiftPicApngBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(3, this.giftPicApng_);
        }
        int i4 = this.animation_;
        int i5 = i3;
        if (i4 != 0) {
            i5 = i3 + CodedOutputStream.computeUInt32Size(4, i4);
        }
        int i6 = this.giftType_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeUInt32Size(5, i6);
        }
        int i8 = this.giftId_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(6, i8);
        }
        int i10 = this.hitCount_;
        int i11 = i9;
        if (i10 != 0) {
            i11 = i9 + CodedOutputStream.computeUInt32Size(7, i10);
        }
        long j = this.hitId_;
        int i12 = i11;
        if (j != 0) {
            i12 = i11 + CodedOutputStream.computeUInt64Size(8, j);
        }
        int i13 = this.hitBatch_;
        int i14 = i12;
        if (i13 != 0) {
            i14 = i12 + CodedOutputStream.computeUInt32Size(9, i13);
        }
        long j2 = this.beansCount_;
        int i15 = i14;
        if (j2 != 0) {
            i15 = i14 + CodedOutputStream.computeUInt64Size(10, j2);
        }
        long j3 = this.beansCurrentCount_;
        int i16 = i15;
        if (j3 != 0) {
            i16 = i15 + CodedOutputStream.computeUInt64Size(11, j3);
        }
        int i17 = i16;
        if (!getAnimCodeBytes().isEmpty()) {
            i17 = i16 + GeneratedMessageV3.computeStringSize(12, this.animCode_);
        }
        int i18 = i17;
        if (!getTypeNameBytes().isEmpty()) {
            i18 = i17 + GeneratedMessageV3.computeStringSize(13, this.typeName_);
        }
        int i19 = i18;
        if (!getResourceUrlBytes().isEmpty()) {
            i19 = i18 + GeneratedMessageV3.computeStringSize(14, this.resourceUrl_);
        }
        int i20 = i19;
        if (!getGiftPicMp4Bytes().isEmpty()) {
            i20 = i19 + GeneratedMessageV3.computeStringSize(15, this.giftPicMp4_);
        }
        int i21 = i20;
        if (!getFanClubNameBytes().isEmpty()) {
            i21 = i20 + GeneratedMessageV3.computeStringSize(16, this.fanClubName_);
        }
        int i22 = this.fanClubLevel_;
        int i23 = i21;
        if (i22 != 0) {
            i23 = i21 + CodedOutputStream.computeInt32Size(17, i22);
        }
        boolean z = this.inFanClub_;
        int i24 = i23;
        if (z) {
            i24 = i23 + CodedOutputStream.computeBoolSize(18, z);
        }
        int i25 = i24;
        if (this.fansStatus_ != FanStatus.Out.getNumber()) {
            i25 = i24 + CodedOutputStream.computeEnumSize(19, this.fansStatus_);
        }
        int i26 = i25;
        if (this.liangType_ != LiangType.None.getNumber()) {
            i26 = i25 + CodedOutputStream.computeEnumSize(20, this.liangType_);
        }
        int i27 = i26;
        if (!getLiangIdBytes().isEmpty()) {
            i27 = i26 + GeneratedMessageV3.computeStringSize(21, this.liangId_);
        }
        int i28 = i27;
        if (!getGiftNameBytes().isEmpty()) {
            i28 = i27 + GeneratedMessageV3.computeStringSize(22, this.giftName_);
        }
        int i29 = this.rechargeBadge_;
        int i30 = i28;
        if (i29 != 0) {
            i30 = i28 + CodedOutputStream.computeInt32Size(23, i29);
        }
        boolean z2 = this.isDrawGoods_;
        int i31 = i30;
        if (z2) {
            i31 = i30 + CodedOutputStream.computeBoolSize(24, z2);
        }
        boolean z3 = this.isLuckBag_;
        int i32 = i31;
        if (z3) {
            i32 = i31 + CodedOutputStream.computeBoolSize(25, z3);
        }
        boolean z4 = this.isHelpWishList_;
        int i33 = i32;
        if (z4) {
            i33 = i32 + CodedOutputStream.computeBoolSize(26, z4);
        }
        boolean z5 = this.isReward_;
        int i34 = i33;
        if (z5) {
            i34 = i33 + CodedOutputStream.computeBoolSize(28, z5);
        }
        int i35 = this.chatFrameColorType_;
        int i36 = i34;
        if (i35 != 0) {
            i36 = i34 + CodedOutputStream.computeInt32Size(29, i35);
        }
        int i37 = this.chatFrameGradientType_;
        int i38 = i36;
        if (i37 != 0) {
            i38 = i36 + CodedOutputStream.computeInt32Size(30, i37);
        }
        int i39 = 0;
        for (int i40 = 0; i40 < this.chatFrameFrameColor_.size(); i40++) {
            i39 += computeStringSizeNoTag(this.chatFrameFrameColor_.getRaw(i40));
        }
        int size = getChatFrameFrameColorList().size();
        int i41 = 0;
        for (int i42 = 0; i42 < this.chatFrameBorderColor_.size(); i42++) {
            i41 += computeStringSizeNoTag(this.chatFrameBorderColor_.getRaw(i42));
        }
        int size2 = i38 + i39 + (size * 2) + i41 + (getChatFrameBorderColorList().size() * 2);
        int i43 = size2;
        if (!getChatFrameBytes().isEmpty()) {
            i43 = size2 + GeneratedMessageV3.computeStringSize(33, this.chatFrame_);
        }
        int i44 = i43;
        if (!getChatFrameIconBytes().isEmpty()) {
            i44 = i43 + GeneratedMessageV3.computeStringSize(34, this.chatFrameIcon_);
        }
        boolean z6 = this.isVibrate_;
        int i45 = i44;
        if (z6) {
            i45 = i44 + CodedOutputStream.computeBoolSize(35, z6);
        }
        long j4 = this.giftBeansCount_;
        int i46 = i45;
        if (j4 != 0) {
            i46 = i45 + CodedOutputStream.computeUInt64Size(36, j4);
        }
        boolean z7 = this.alwaysShowAnimation_;
        int i47 = i46;
        if (z7) {
            i47 = i46 + CodedOutputStream.computeBoolSize(37, z7);
        }
        int i48 = i47;
        if (!getChatBadgeUrlBytes().isEmpty()) {
            i48 = i47 + GeneratedMessageV3.computeStringSize(38, this.chatBadgeUrl_);
        }
        int i49 = this.chatBadgeLength_;
        int i50 = i48;
        if (i49 != 0) {
            i50 = i48 + CodedOutputStream.computeInt32Size(39, i49);
        }
        int i51 = this.chatBadgeHeight_;
        int i52 = i50;
        if (i51 != 0) {
            i52 = i50 + CodedOutputStream.computeInt32Size(40, i51);
        }
        int i53 = i52;
        if (!getAvatarFrameUrlBytes().isEmpty()) {
            i53 = i52 + GeneratedMessageV3.computeStringSize(41, this.avatarFrameUrl_);
        }
        int i54 = i53;
        if (!getBgImgBytes().isEmpty()) {
            i54 = i53 + GeneratedMessageV3.computeStringSize(42, this.bgImg_);
        }
        int i55 = 0;
        for (int i56 = 0; i56 < this.bgColor_.size(); i56++) {
            i55 += computeStringSizeNoTag(this.bgColor_.getRaw(i56));
        }
        int size3 = i54 + i55 + (getBgColorList().size() * 2);
        int i57 = 0;
        while (true) {
            int i58 = i57;
            if (i58 >= this.lanternImage_.size()) {
                break;
            }
            size3 += CodedOutputStream.computeMessageSize(44, this.lanternImage_.get(i58));
            i57 = i58 + 1;
        }
        int i59 = this.lanternId_;
        int i60 = size3;
        if (i59 != 0) {
            i60 = size3 + CodedOutputStream.computeInt32Size(45, i59);
        }
        int i61 = this.lanternPlayTimes_;
        int i62 = i60;
        if (i61 != 0) {
            i62 = i60 + CodedOutputStream.computeInt32Size(46, i61);
        }
        int i63 = this.animMany_;
        int i64 = i62;
        if (i63 != 0) {
            i64 = i62 + CodedOutputStream.computeInt32Size(47, i63);
        }
        int i65 = i64;
        if (!getRandomNameBytes().isEmpty()) {
            i65 = i64 + GeneratedMessageV3.computeStringSize(48, this.randomName_);
        }
        int i66 = i65;
        if (!getRandomStaticBytes().isEmpty()) {
            i66 = i65 + GeneratedMessageV3.computeStringSize(49, this.randomStatic_);
        }
        int serializedSize = i66 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
    public String getTypeName() {
        Object obj = this.typeName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.typeName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GiftExtraOrBuilder
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getGiftPicUrl().hashCode()) * 37) + 2) * 53) + getGiftPicGif().hashCode()) * 37) + 3) * 53) + getGiftPicApng().hashCode()) * 37) + 4) * 53) + getAnimation()) * 37) + 5) * 53) + getGiftType()) * 37) + 6) * 53) + getGiftId()) * 37) + 7) * 53) + getHitCount()) * 37) + 8) * 53) + Internal.hashLong(getHitId())) * 37) + 9) * 53) + getHitBatch()) * 37) + 10) * 53) + Internal.hashLong(getBeansCount())) * 37) + 11) * 53) + Internal.hashLong(getBeansCurrentCount())) * 37) + 12) * 53) + getAnimCode().hashCode()) * 37) + 13) * 53) + getTypeName().hashCode()) * 37) + 14) * 53) + getResourceUrl().hashCode()) * 37) + 15) * 53) + getGiftPicMp4().hashCode()) * 37) + 16) * 53) + getFanClubName().hashCode()) * 37) + 17) * 53) + getFanClubLevel()) * 37) + 18) * 53) + Internal.hashBoolean(getInFanClub())) * 37) + 19) * 53) + this.fansStatus_) * 37) + 20) * 53) + this.liangType_) * 37) + 21) * 53) + getLiangId().hashCode()) * 37) + 22) * 53) + getGiftName().hashCode()) * 37) + 23) * 53) + getRechargeBadge()) * 37) + 24) * 53) + Internal.hashBoolean(getIsDrawGoods())) * 37) + 25) * 53) + Internal.hashBoolean(getIsLuckBag())) * 37) + 26) * 53) + Internal.hashBoolean(getIsHelpWishList())) * 37) + 28) * 53) + Internal.hashBoolean(getIsReward())) * 37) + 29) * 53) + getChatFrameColorType()) * 37) + 30) * 53) + getChatFrameGradientType();
        int i = hashCode;
        if (getChatFrameFrameColorCount() > 0) {
            i = (((hashCode * 37) + 31) * 53) + getChatFrameFrameColorList().hashCode();
        }
        int i2 = i;
        if (getChatFrameBorderColorCount() > 0) {
            i2 = (((i * 37) + 32) * 53) + getChatFrameBorderColorList().hashCode();
        }
        int hashCode2 = (((((((((((((((((((((((((((((((((((((((i2 * 37) + 33) * 53) + getChatFrame().hashCode()) * 37) + 34) * 53) + getChatFrameIcon().hashCode()) * 37) + 35) * 53) + Internal.hashBoolean(getIsVibrate())) * 37) + 36) * 53) + Internal.hashLong(getGiftBeansCount())) * 37) + 37) * 53) + Internal.hashBoolean(getAlwaysShowAnimation())) * 37) + 38) * 53) + getChatBadgeUrl().hashCode()) * 37) + 39) * 53) + getChatBadgeLength()) * 37) + 40) * 53) + getChatBadgeHeight()) * 37) + 41) * 53) + getAvatarFrameUrl().hashCode()) * 37) + 42) * 53) + getBgImg().hashCode();
        int i3 = hashCode2;
        if (getBgColorCount() > 0) {
            i3 = (((hashCode2 * 37) + 43) * 53) + getBgColorList().hashCode();
        }
        int i4 = i3;
        if (getLanternImageCount() > 0) {
            i4 = (((i3 * 37) + 44) * 53) + getLanternImageList().hashCode();
        }
        int lanternId = (((((((((((((((((((((i4 * 37) + 45) * 53) + getLanternId()) * 37) + 46) * 53) + getLanternPlayTimes()) * 37) + 47) * 53) + getAnimMany()) * 37) + 48) * 53) + getRandomName().hashCode()) * 37) + 49) * 53) + getRandomStatic().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = lanternId;
        return lanternId;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_GiftExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(GiftExtra.class, Builder.class);
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
        return new GiftExtra();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i;
        if (!getGiftPicUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.giftPicUrl_);
        }
        if (!getGiftPicGifBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.giftPicGif_);
        }
        if (!getGiftPicApngBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.giftPicApng_);
        }
        int i2 = this.animation_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(4, i2);
        }
        int i3 = this.giftType_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(5, i3);
        }
        int i4 = this.giftId_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(6, i4);
        }
        int i5 = this.hitCount_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(7, i5);
        }
        long j = this.hitId_;
        if (j != 0) {
            codedOutputStream.writeUInt64(8, j);
        }
        int i6 = this.hitBatch_;
        if (i6 != 0) {
            codedOutputStream.writeUInt32(9, i6);
        }
        long j2 = this.beansCount_;
        if (j2 != 0) {
            codedOutputStream.writeUInt64(10, j2);
        }
        long j3 = this.beansCurrentCount_;
        if (j3 != 0) {
            codedOutputStream.writeUInt64(11, j3);
        }
        if (!getAnimCodeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 12, this.animCode_);
        }
        if (!getTypeNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 13, this.typeName_);
        }
        if (!getResourceUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 14, this.resourceUrl_);
        }
        if (!getGiftPicMp4Bytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 15, this.giftPicMp4_);
        }
        if (!getFanClubNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 16, this.fanClubName_);
        }
        int i7 = this.fanClubLevel_;
        if (i7 != 0) {
            codedOutputStream.writeInt32(17, i7);
        }
        boolean z = this.inFanClub_;
        if (z) {
            codedOutputStream.writeBool(18, z);
        }
        if (this.fansStatus_ != FanStatus.Out.getNumber()) {
            codedOutputStream.writeEnum(19, this.fansStatus_);
        }
        if (this.liangType_ != LiangType.None.getNumber()) {
            codedOutputStream.writeEnum(20, this.liangType_);
        }
        if (!getLiangIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 21, this.liangId_);
        }
        if (!getGiftNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 22, this.giftName_);
        }
        int i8 = this.rechargeBadge_;
        if (i8 != 0) {
            codedOutputStream.writeInt32(23, i8);
        }
        boolean z2 = this.isDrawGoods_;
        if (z2) {
            codedOutputStream.writeBool(24, z2);
        }
        boolean z3 = this.isLuckBag_;
        if (z3) {
            codedOutputStream.writeBool(25, z3);
        }
        boolean z4 = this.isHelpWishList_;
        if (z4) {
            codedOutputStream.writeBool(26, z4);
        }
        boolean z5 = this.isReward_;
        if (z5) {
            codedOutputStream.writeBool(28, z5);
        }
        int i9 = this.chatFrameColorType_;
        if (i9 != 0) {
            codedOutputStream.writeInt32(29, i9);
        }
        int i10 = this.chatFrameGradientType_;
        if (i10 != 0) {
            codedOutputStream.writeInt32(30, i10);
        }
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= this.chatFrameFrameColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 31, this.chatFrameFrameColor_.getRaw(i12));
            i11 = i12 + 1;
        }
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 >= this.chatFrameBorderColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 32, this.chatFrameBorderColor_.getRaw(i14));
            i13 = i14 + 1;
        }
        if (!getChatFrameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 33, this.chatFrame_);
        }
        if (!getChatFrameIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 34, this.chatFrameIcon_);
        }
        boolean z6 = this.isVibrate_;
        if (z6) {
            codedOutputStream.writeBool(35, z6);
        }
        long j4 = this.giftBeansCount_;
        if (j4 != 0) {
            codedOutputStream.writeUInt64(36, j4);
        }
        boolean z7 = this.alwaysShowAnimation_;
        if (z7) {
            codedOutputStream.writeBool(37, z7);
        }
        if (!getChatBadgeUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 38, this.chatBadgeUrl_);
        }
        int i15 = this.chatBadgeLength_;
        if (i15 != 0) {
            codedOutputStream.writeInt32(39, i15);
        }
        int i16 = this.chatBadgeHeight_;
        if (i16 != 0) {
            codedOutputStream.writeInt32(40, i16);
        }
        if (!getAvatarFrameUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 41, this.avatarFrameUrl_);
        }
        if (!getBgImgBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 42, this.bgImg_);
        }
        int i17 = 0;
        while (true) {
            int i18 = i17;
            if (i18 >= this.bgColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 43, this.bgColor_.getRaw(i18));
            i17 = i18 + 1;
        }
        for (i = 0; i < this.lanternImage_.size(); i++) {
            codedOutputStream.writeMessage(44, this.lanternImage_.get(i));
        }
        int i19 = this.lanternId_;
        if (i19 != 0) {
            codedOutputStream.writeInt32(45, i19);
        }
        int i20 = this.lanternPlayTimes_;
        if (i20 != 0) {
            codedOutputStream.writeInt32(46, i20);
        }
        int i21 = this.animMany_;
        if (i21 != 0) {
            codedOutputStream.writeInt32(47, i21);
        }
        if (!getRandomNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 48, this.randomName_);
        }
        if (!getRandomStaticBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 49, this.randomStatic_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
