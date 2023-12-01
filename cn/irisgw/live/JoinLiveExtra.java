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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/JoinLiveExtra.class */
public final class JoinLiveExtra extends GeneratedMessageV3 implements JoinLiveExtraOrBuilder {
    public static final int ANCHOR_POCKET_TRAFFIC_CARD_FIELD_NUMBER = 22;
    public static final int ANCHOR_POCKET_TRAFFIC_CARD_NAME_FIELD_NUMBER = 23;
    public static final int AVATAR_FRAME_FIELD_NUMBER = 11;
    public static final int AVATAR_FRAME_TYPE_FIELD_NUMBER = 12;
    public static final int CHAT_BADGE_HEIGHT_FIELD_NUMBER = 21;
    public static final int CHAT_BADGE_LENGTH_FIELD_NUMBER = 20;
    public static final int CHAT_BADGE_URL_FIELD_NUMBER = 19;
    public static final int CHAT_FRAME_BORDER_COLOR_FIELD_NUMBER = 18;
    public static final int CHAT_FRAME_COLOR_TYPE_FIELD_NUMBER = 15;
    public static final int CHAT_FRAME_FIELD_NUMBER = 13;
    public static final int CHAT_FRAME_FRAME_COLOR_FIELD_NUMBER = 17;
    public static final int CHAT_FRAME_GRADIENT_TYPE_FIELD_NUMBER = 16;
    public static final int CHAT_FRAME_ICON_FIELD_NUMBER = 14;
    public static final int COUNT_FIELD_NUMBER = 1;
    public static final int EFFECTS_FIELD_NUMBER = 3;
    public static final int FANS_STATUS_FIELD_NUMBER = 7;
    public static final int FAN_CLUB_LEVEL_FIELD_NUMBER = 5;
    public static final int FAN_CLUB_NAME_FIELD_NUMBER = 4;
    public static final int IN_FAN_CLUB_FIELD_NUMBER = 6;
    public static final int LIANG_ID_FIELD_NUMBER = 9;
    public static final int LIANG_TYPE_FIELD_NUMBER = 8;
    public static final int NOBLE_JOIN_TEXT_FIELD_NUMBER = 24;
    public static final int REALTIME_COUNT_FIELD_NUMBER = 2;
    public static final int RECHARGE_BADGE_FIELD_NUMBER = 10;
    private static final long serialVersionUID = 0;
    private volatile Object anchorPocketTrafficCardName_;
    private int anchorPocketTrafficCard_;
    private int avatarFrameType_;
    private volatile Object avatarFrame_;
    private int chatBadgeHeight_;
    private int chatBadgeLength_;
    private volatile Object chatBadgeUrl_;
    private LazyStringList chatFrameBorderColor_;
    private int chatFrameColorType_;
    private LazyStringList chatFrameFrameColor_;
    private int chatFrameGradientType_;
    private volatile Object chatFrameIcon_;
    private volatile Object chatFrame_;
    private int count_;
    private JoinEffects effects_;
    private int fanClubLevel_;
    private volatile Object fanClubName_;
    private int fansStatus_;
    private boolean inFanClub_;
    private volatile Object liangId_;
    private int liangType_;
    private byte memoizedIsInitialized;
    private volatile Object nobleJoinText_;
    private int realtimeCount_;
    private int rechargeBadge_;
    private static final JoinLiveExtra DEFAULT_INSTANCE = new JoinLiveExtra();
    private static final Parser<JoinLiveExtra> PARSER = new AbstractParser<JoinLiveExtra>() { // from class: cn.irisgw.live.JoinLiveExtra.1
        /* renamed from: parsePartialFrom */
        public JoinLiveExtra m3615parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new JoinLiveExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/JoinLiveExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements JoinLiveExtraOrBuilder {
        private Object anchorPocketTrafficCardName_;
        private int anchorPocketTrafficCard_;
        private int avatarFrameType_;
        private Object avatarFrame_;
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
        private int count_;
        private SingleFieldBuilderV3<JoinEffects, JoinEffects.Builder, JoinEffectsOrBuilder> effectsBuilder_;
        private JoinEffects effects_;
        private int fanClubLevel_;
        private Object fanClubName_;
        private int fansStatus_;
        private boolean inFanClub_;
        private Object liangId_;
        private int liangType_;
        private Object nobleJoinText_;
        private int realtimeCount_;
        private int rechargeBadge_;

        private Builder() {
            this.fanClubName_ = "";
            this.fansStatus_ = 0;
            this.liangType_ = 0;
            this.liangId_ = "";
            this.avatarFrame_ = "";
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.chatBadgeUrl_ = "";
            this.anchorPocketTrafficCardName_ = "";
            this.nobleJoinText_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.fanClubName_ = "";
            this.fansStatus_ = 0;
            this.liangType_ = 0;
            this.liangId_ = "";
            this.avatarFrame_ = "";
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.chatBadgeUrl_ = "";
            this.anchorPocketTrafficCardName_ = "";
            this.nobleJoinText_ = "";
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
            return LiveConstants.internal_static_cn_irisgw_live_JoinLiveExtra_descriptor;
        }

        private SingleFieldBuilderV3<JoinEffects, JoinEffects.Builder, JoinEffectsOrBuilder> getEffectsFieldBuilder() {
            if (this.effectsBuilder_ == null) {
                this.effectsBuilder_ = new SingleFieldBuilderV3<>(getEffects(), getParentForChildren(), isClean());
                this.effects_ = null;
            }
            return this.effectsBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = JoinLiveExtra.alwaysUseFieldBuilders;
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
                JoinLiveExtra.checkByteStringIsUtf8(byteString);
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
                JoinLiveExtra.checkByteStringIsUtf8(byteString);
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: addRepeatedField */
        public Builder m3617addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public JoinLiveExtra m3619build() {
            JoinLiveExtra m3621buildPartial = m3621buildPartial();
            if (m3621buildPartial.isInitialized()) {
                return m3621buildPartial;
            }
            throw newUninitializedMessageException(m3621buildPartial);
        }

        /* renamed from: buildPartial */
        public JoinLiveExtra m3621buildPartial() {
            JoinLiveExtra joinLiveExtra = new JoinLiveExtra(this);
            joinLiveExtra.count_ = this.count_;
            joinLiveExtra.realtimeCount_ = this.realtimeCount_;
            SingleFieldBuilderV3<JoinEffects, JoinEffects.Builder, JoinEffectsOrBuilder> singleFieldBuilderV3 = this.effectsBuilder_;
            if (singleFieldBuilderV3 == null) {
                joinLiveExtra.effects_ = this.effects_;
            } else {
                joinLiveExtra.effects_ = singleFieldBuilderV3.build();
            }
            joinLiveExtra.fanClubName_ = this.fanClubName_;
            joinLiveExtra.fanClubLevel_ = this.fanClubLevel_;
            joinLiveExtra.inFanClub_ = this.inFanClub_;
            joinLiveExtra.fansStatus_ = this.fansStatus_;
            joinLiveExtra.liangType_ = this.liangType_;
            joinLiveExtra.liangId_ = this.liangId_;
            joinLiveExtra.rechargeBadge_ = this.rechargeBadge_;
            joinLiveExtra.avatarFrame_ = this.avatarFrame_;
            joinLiveExtra.avatarFrameType_ = this.avatarFrameType_;
            joinLiveExtra.chatFrame_ = this.chatFrame_;
            joinLiveExtra.chatFrameIcon_ = this.chatFrameIcon_;
            joinLiveExtra.chatFrameColorType_ = this.chatFrameColorType_;
            joinLiveExtra.chatFrameGradientType_ = this.chatFrameGradientType_;
            if ((this.bitField0_ & 1) != 0) {
                this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            joinLiveExtra.chatFrameFrameColor_ = this.chatFrameFrameColor_;
            if ((this.bitField0_ & 2) != 0) {
                this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            joinLiveExtra.chatFrameBorderColor_ = this.chatFrameBorderColor_;
            joinLiveExtra.chatBadgeUrl_ = this.chatBadgeUrl_;
            joinLiveExtra.chatBadgeLength_ = this.chatBadgeLength_;
            joinLiveExtra.chatBadgeHeight_ = this.chatBadgeHeight_;
            joinLiveExtra.anchorPocketTrafficCard_ = this.anchorPocketTrafficCard_;
            joinLiveExtra.anchorPocketTrafficCardName_ = this.anchorPocketTrafficCardName_;
            joinLiveExtra.nobleJoinText_ = this.nobleJoinText_;
            onBuilt();
            return joinLiveExtra;
        }

        /* renamed from: clear */
        public Builder m3625clear() {
            super.clear();
            this.count_ = 0;
            this.realtimeCount_ = 0;
            if (this.effectsBuilder_ == null) {
                this.effects_ = null;
            } else {
                this.effects_ = null;
                this.effectsBuilder_ = null;
            }
            this.fanClubName_ = "";
            this.fanClubLevel_ = 0;
            this.inFanClub_ = false;
            this.fansStatus_ = 0;
            this.liangType_ = 0;
            this.liangId_ = "";
            this.rechargeBadge_ = 0;
            this.avatarFrame_ = "";
            this.avatarFrameType_ = 0;
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameColorType_ = 0;
            this.chatFrameGradientType_ = 0;
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            this.chatBadgeUrl_ = "";
            this.chatBadgeLength_ = 0;
            this.chatBadgeHeight_ = 0;
            this.anchorPocketTrafficCard_ = 0;
            this.anchorPocketTrafficCardName_ = "";
            this.nobleJoinText_ = "";
            return this;
        }

        public Builder clearAnchorPocketTrafficCard() {
            this.anchorPocketTrafficCard_ = 0;
            onChanged();
            return this;
        }

        public Builder clearAnchorPocketTrafficCardName() {
            this.anchorPocketTrafficCardName_ = JoinLiveExtra.getDefaultInstance().getAnchorPocketTrafficCardName();
            onChanged();
            return this;
        }

        public Builder clearAvatarFrame() {
            this.avatarFrame_ = JoinLiveExtra.getDefaultInstance().getAvatarFrame();
            onChanged();
            return this;
        }

        public Builder clearAvatarFrameType() {
            this.avatarFrameType_ = 0;
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
            this.chatBadgeUrl_ = JoinLiveExtra.getDefaultInstance().getChatBadgeUrl();
            onChanged();
            return this;
        }

        public Builder clearChatFrame() {
            this.chatFrame_ = JoinLiveExtra.getDefaultInstance().getChatFrame();
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
            this.chatFrameIcon_ = JoinLiveExtra.getDefaultInstance().getChatFrameIcon();
            onChanged();
            return this;
        }

        public Builder clearCount() {
            this.count_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEffects() {
            if (this.effectsBuilder_ == null) {
                this.effects_ = null;
                onChanged();
                return this;
            }
            this.effects_ = null;
            this.effectsBuilder_ = null;
            return this;
        }

        public Builder clearFanClubLevel() {
            this.fanClubLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearFanClubName() {
            this.fanClubName_ = JoinLiveExtra.getDefaultInstance().getFanClubName();
            onChanged();
            return this;
        }

        public Builder clearFansStatus() {
            this.fansStatus_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m3627clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearInFanClub() {
            this.inFanClub_ = false;
            onChanged();
            return this;
        }

        public Builder clearLiangId() {
            this.liangId_ = JoinLiveExtra.getDefaultInstance().getLiangId();
            onChanged();
            return this;
        }

        public Builder clearLiangType() {
            this.liangType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearNobleJoinText() {
            this.nobleJoinText_ = JoinLiveExtra.getDefaultInstance().getNobleJoinText();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m3630clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRealtimeCount() {
            this.realtimeCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRechargeBadge() {
            this.rechargeBadge_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m3636clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getAnchorPocketTrafficCard() {
            return this.anchorPocketTrafficCard_;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public String getAnchorPocketTrafficCardName() {
            Object obj = this.anchorPocketTrafficCardName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.anchorPocketTrafficCardName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public ByteString getAnchorPocketTrafficCardNameBytes() {
            Object obj = this.anchorPocketTrafficCardName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.anchorPocketTrafficCardName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public String getAvatarFrame() {
            Object obj = this.avatarFrame_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatarFrame_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public ByteString getAvatarFrameBytes() {
            Object obj = this.avatarFrame_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatarFrame_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getAvatarFrameType() {
            return this.avatarFrameType_;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getChatBadgeHeight() {
            return this.chatBadgeHeight_;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getChatBadgeLength() {
            return this.chatBadgeLength_;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public String getChatBadgeUrl() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatBadgeUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public ByteString getChatBadgeUrlBytes() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatBadgeUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public String getChatFrame() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrame_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public String getChatFrameBorderColor(int i) {
            return (String) this.chatFrameBorderColor_.get(i);
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public ByteString getChatFrameBorderColorBytes(int i) {
            return this.chatFrameBorderColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getChatFrameBorderColorCount() {
            return this.chatFrameBorderColor_.size();
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        /* renamed from: getChatFrameBorderColorList */
        public ProtocolStringList mo3606getChatFrameBorderColorList() {
            return this.chatFrameBorderColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public ByteString getChatFrameBytes() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrame_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getChatFrameColorType() {
            return this.chatFrameColorType_;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public String getChatFrameFrameColor(int i) {
            return (String) this.chatFrameFrameColor_.get(i);
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public ByteString getChatFrameFrameColorBytes(int i) {
            return this.chatFrameFrameColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getChatFrameFrameColorCount() {
            return this.chatFrameFrameColor_.size();
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        /* renamed from: getChatFrameFrameColorList */
        public ProtocolStringList mo3607getChatFrameFrameColorList() {
            return this.chatFrameFrameColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getChatFrameGradientType() {
            return this.chatFrameGradientType_;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public String getChatFrameIcon() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrameIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public ByteString getChatFrameIconBytes() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrameIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getCount() {
            return this.count_;
        }

        /* renamed from: getDefaultInstanceForType */
        public JoinLiveExtra m3638getDefaultInstanceForType() {
            return JoinLiveExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_JoinLiveExtra_descriptor;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public JoinEffects getEffects() {
            SingleFieldBuilderV3<JoinEffects, JoinEffects.Builder, JoinEffectsOrBuilder> singleFieldBuilderV3 = this.effectsBuilder_;
            if (singleFieldBuilderV3 == null) {
                JoinEffects joinEffects = this.effects_;
                JoinEffects joinEffects2 = joinEffects;
                if (joinEffects == null) {
                    joinEffects2 = JoinEffects.getDefaultInstance();
                }
                return joinEffects2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public JoinEffects.Builder getEffectsBuilder() {
            onChanged();
            return getEffectsFieldBuilder().getBuilder();
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public JoinEffectsOrBuilder getEffectsOrBuilder() {
            SingleFieldBuilderV3<JoinEffects, JoinEffects.Builder, JoinEffectsOrBuilder> singleFieldBuilderV3 = this.effectsBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (JoinEffectsOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            JoinEffects joinEffects = this.effects_;
            JoinEffects joinEffects2 = joinEffects;
            if (joinEffects == null) {
                joinEffects2 = JoinEffects.getDefaultInstance();
            }
            return joinEffects2;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getFanClubLevel() {
            return this.fanClubLevel_;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public String getFanClubName() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fanClubName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public ByteString getFanClubNameBytes() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fanClubName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public FanStatus getFansStatus() {
            FanStatus valueOf = FanStatus.valueOf(this.fansStatus_);
            FanStatus fanStatus = valueOf;
            if (valueOf == null) {
                fanStatus = FanStatus.UNRECOGNIZED;
            }
            return fanStatus;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getFansStatusValue() {
            return this.fansStatus_;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public boolean getInFanClub() {
            return this.inFanClub_;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public String getLiangId() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liangId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public ByteString getLiangIdBytes() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liangId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public LiangType getLiangType() {
            LiangType valueOf = LiangType.valueOf(this.liangType_);
            LiangType liangType = valueOf;
            if (valueOf == null) {
                liangType = LiangType.UNRECOGNIZED;
            }
            return liangType;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getLiangTypeValue() {
            return this.liangType_;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public String getNobleJoinText() {
            Object obj = this.nobleJoinText_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.nobleJoinText_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public ByteString getNobleJoinTextBytes() {
            Object obj = this.nobleJoinText_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nobleJoinText_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getRealtimeCount() {
            return this.realtimeCount_;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public int getRechargeBadge() {
            return this.rechargeBadge_;
        }

        @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
        public boolean hasEffects() {
            return (this.effectsBuilder_ == null && this.effects_ == null) ? false : true;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_JoinLiveExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(JoinLiveExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeEffects(JoinEffects joinEffects) {
            SingleFieldBuilderV3<JoinEffects, JoinEffects.Builder, JoinEffectsOrBuilder> singleFieldBuilderV3 = this.effectsBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(joinEffects);
                return this;
            }
            JoinEffects joinEffects2 = this.effects_;
            if (joinEffects2 != null) {
                this.effects_ = JoinEffects.newBuilder(joinEffects2).mergeFrom(joinEffects).m3668buildPartial();
            } else {
                this.effects_ = joinEffects;
            }
            onChanged();
            return this;
        }

        public Builder mergeFrom(JoinLiveExtra joinLiveExtra) {
            if (joinLiveExtra == JoinLiveExtra.getDefaultInstance()) {
                return this;
            }
            if (joinLiveExtra.getCount() != 0) {
                setCount(joinLiveExtra.getCount());
            }
            if (joinLiveExtra.getRealtimeCount() != 0) {
                setRealtimeCount(joinLiveExtra.getRealtimeCount());
            }
            if (joinLiveExtra.hasEffects()) {
                mergeEffects(joinLiveExtra.getEffects());
            }
            if (!joinLiveExtra.getFanClubName().isEmpty()) {
                this.fanClubName_ = joinLiveExtra.fanClubName_;
                onChanged();
            }
            if (joinLiveExtra.getFanClubLevel() != 0) {
                setFanClubLevel(joinLiveExtra.getFanClubLevel());
            }
            if (joinLiveExtra.getInFanClub()) {
                setInFanClub(joinLiveExtra.getInFanClub());
            }
            if (joinLiveExtra.fansStatus_ != 0) {
                setFansStatusValue(joinLiveExtra.getFansStatusValue());
            }
            if (joinLiveExtra.liangType_ != 0) {
                setLiangTypeValue(joinLiveExtra.getLiangTypeValue());
            }
            if (!joinLiveExtra.getLiangId().isEmpty()) {
                this.liangId_ = joinLiveExtra.liangId_;
                onChanged();
            }
            if (joinLiveExtra.getRechargeBadge() != 0) {
                setRechargeBadge(joinLiveExtra.getRechargeBadge());
            }
            if (!joinLiveExtra.getAvatarFrame().isEmpty()) {
                this.avatarFrame_ = joinLiveExtra.avatarFrame_;
                onChanged();
            }
            if (joinLiveExtra.getAvatarFrameType() != 0) {
                setAvatarFrameType(joinLiveExtra.getAvatarFrameType());
            }
            if (!joinLiveExtra.getChatFrame().isEmpty()) {
                this.chatFrame_ = joinLiveExtra.chatFrame_;
                onChanged();
            }
            if (!joinLiveExtra.getChatFrameIcon().isEmpty()) {
                this.chatFrameIcon_ = joinLiveExtra.chatFrameIcon_;
                onChanged();
            }
            if (joinLiveExtra.getChatFrameColorType() != 0) {
                setChatFrameColorType(joinLiveExtra.getChatFrameColorType());
            }
            if (joinLiveExtra.getChatFrameGradientType() != 0) {
                setChatFrameGradientType(joinLiveExtra.getChatFrameGradientType());
            }
            if (!joinLiveExtra.chatFrameFrameColor_.isEmpty()) {
                if (this.chatFrameFrameColor_.isEmpty()) {
                    this.chatFrameFrameColor_ = joinLiveExtra.chatFrameFrameColor_;
                    this.bitField0_ &= -2;
                } else {
                    ensureChatFrameFrameColorIsMutable();
                    this.chatFrameFrameColor_.addAll(joinLiveExtra.chatFrameFrameColor_);
                }
                onChanged();
            }
            if (!joinLiveExtra.chatFrameBorderColor_.isEmpty()) {
                if (this.chatFrameBorderColor_.isEmpty()) {
                    this.chatFrameBorderColor_ = joinLiveExtra.chatFrameBorderColor_;
                    this.bitField0_ &= -3;
                } else {
                    ensureChatFrameBorderColorIsMutable();
                    this.chatFrameBorderColor_.addAll(joinLiveExtra.chatFrameBorderColor_);
                }
                onChanged();
            }
            if (!joinLiveExtra.getChatBadgeUrl().isEmpty()) {
                this.chatBadgeUrl_ = joinLiveExtra.chatBadgeUrl_;
                onChanged();
            }
            if (joinLiveExtra.getChatBadgeLength() != 0) {
                setChatBadgeLength(joinLiveExtra.getChatBadgeLength());
            }
            if (joinLiveExtra.getChatBadgeHeight() != 0) {
                setChatBadgeHeight(joinLiveExtra.getChatBadgeHeight());
            }
            if (joinLiveExtra.getAnchorPocketTrafficCard() != 0) {
                setAnchorPocketTrafficCard(joinLiveExtra.getAnchorPocketTrafficCard());
            }
            if (!joinLiveExtra.getAnchorPocketTrafficCardName().isEmpty()) {
                this.anchorPocketTrafficCardName_ = joinLiveExtra.anchorPocketTrafficCardName_;
                onChanged();
            }
            if (!joinLiveExtra.getNobleJoinText().isEmpty()) {
                this.nobleJoinText_ = joinLiveExtra.nobleJoinText_;
                onChanged();
            }
            m3647mergeUnknownFields(joinLiveExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.JoinLiveExtra.Builder m3644mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.JoinLiveExtra.access$5200()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.JoinLiveExtra r0 = (cn.irisgw.live.JoinLiveExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.JoinLiveExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.JoinLiveExtra r0 = (cn.irisgw.live.JoinLiveExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.JoinLiveExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.JoinLiveExtra.Builder.m3644mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.JoinLiveExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m3643mergeFrom(Message message) {
            if (message instanceof JoinLiveExtra) {
                return mergeFrom((JoinLiveExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m3647mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setAnchorPocketTrafficCard(int i) {
            this.anchorPocketTrafficCard_ = i;
            onChanged();
            return this;
        }

        public Builder setAnchorPocketTrafficCardName(String str) {
            if (str != null) {
                this.anchorPocketTrafficCardName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAnchorPocketTrafficCardNameBytes(ByteString byteString) {
            if (byteString != null) {
                JoinLiveExtra.checkByteStringIsUtf8(byteString);
                this.anchorPocketTrafficCardName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAvatarFrame(String str) {
            if (str != null) {
                this.avatarFrame_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAvatarFrameBytes(ByteString byteString) {
            if (byteString != null) {
                JoinLiveExtra.checkByteStringIsUtf8(byteString);
                this.avatarFrame_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAvatarFrameType(int i) {
            this.avatarFrameType_ = i;
            onChanged();
            return this;
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
                JoinLiveExtra.checkByteStringIsUtf8(byteString);
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
                JoinLiveExtra.checkByteStringIsUtf8(byteString);
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
                JoinLiveExtra.checkByteStringIsUtf8(byteString);
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

        public Builder setEffects(JoinEffects.Builder builder) {
            SingleFieldBuilderV3<JoinEffects, JoinEffects.Builder, JoinEffectsOrBuilder> singleFieldBuilderV3 = this.effectsBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.m3666build());
                return this;
            }
            this.effects_ = builder.m3666build();
            onChanged();
            return this;
        }

        public Builder setEffects(JoinEffects joinEffects) {
            SingleFieldBuilderV3<JoinEffects, JoinEffects.Builder, JoinEffectsOrBuilder> singleFieldBuilderV3 = this.effectsBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(joinEffects);
                return this;
            } else if (joinEffects != null) {
                this.effects_ = joinEffects;
                onChanged();
                return this;
            } else {
                throw null;
            }
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
                JoinLiveExtra.checkByteStringIsUtf8(byteString);
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

        /* renamed from: setField */
        public Builder m3649setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setInFanClub(boolean z) {
            this.inFanClub_ = z;
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
                JoinLiveExtra.checkByteStringIsUtf8(byteString);
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

        public Builder setNobleJoinText(String str) {
            if (str != null) {
                this.nobleJoinText_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNobleJoinTextBytes(ByteString byteString) {
            if (byteString != null) {
                JoinLiveExtra.checkByteStringIsUtf8(byteString);
                this.nobleJoinText_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRealtimeCount(int i) {
            this.realtimeCount_ = i;
            onChanged();
            return this;
        }

        public Builder setRechargeBadge(int i) {
            this.rechargeBadge_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m3651setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m3653setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/JoinLiveExtra$JoinEffects.class */
    public static final class JoinEffects extends GeneratedMessageV3 implements JoinEffectsOrBuilder {
        public static final int BACKGROUND_COLOR_FIELD_NUMBER = 3;
        public static final int CONTENTS_FIELD_NUMBER = 1;
        public static final int ENTRANCE_APNG_FIELD_NUMBER = 6;
        public static final int ENTRANCE_GIF_FIELD_NUMBER = 5;
        public static final int ENTRANCE_MP4_FIELD_NUMBER = 7;
        public static final int GIFT_APNG_FIELD_NUMBER = 4;
        public static final int MEDIUM_IMAGE_FIELD_NUMBER = 8;
        public static final int URL_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object backgroundColor_;
        private volatile Object contents_;
        private volatile Object entranceApng_;
        private volatile Object entranceGif_;
        private volatile Object entranceMp4_;
        private volatile Object giftApng_;
        private volatile Object mediumImage_;
        private byte memoizedIsInitialized;
        private volatile Object url_;
        private static final JoinEffects DEFAULT_INSTANCE = new JoinEffects();
        private static final Parser<JoinEffects> PARSER = new AbstractParser<JoinEffects>() { // from class: cn.irisgw.live.JoinLiveExtra.JoinEffects.1
            /* renamed from: parsePartialFrom */
            public JoinEffects m3662parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JoinEffects(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/JoinLiveExtra$JoinEffects$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements JoinEffectsOrBuilder {
            private Object backgroundColor_;
            private Object contents_;
            private Object entranceApng_;
            private Object entranceGif_;
            private Object entranceMp4_;
            private Object giftApng_;
            private Object mediumImage_;
            private Object url_;

            private Builder() {
                this.contents_ = "";
                this.url_ = "";
                this.backgroundColor_ = "";
                this.giftApng_ = "";
                this.entranceGif_ = "";
                this.entranceApng_ = "";
                this.entranceMp4_ = "";
                this.mediumImage_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.contents_ = "";
                this.url_ = "";
                this.backgroundColor_ = "";
                this.giftApng_ = "";
                this.entranceGif_ = "";
                this.entranceApng_ = "";
                this.entranceMp4_ = "";
                this.mediumImage_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_JoinLiveExtra_JoinEffects_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = JoinEffects.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m3664addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public JoinEffects m3666build() {
                JoinEffects m3668buildPartial = m3668buildPartial();
                if (m3668buildPartial.isInitialized()) {
                    return m3668buildPartial;
                }
                throw newUninitializedMessageException(m3668buildPartial);
            }

            /* renamed from: buildPartial */
            public JoinEffects m3668buildPartial() {
                JoinEffects joinEffects = new JoinEffects(this);
                joinEffects.contents_ = this.contents_;
                joinEffects.url_ = this.url_;
                joinEffects.backgroundColor_ = this.backgroundColor_;
                joinEffects.giftApng_ = this.giftApng_;
                joinEffects.entranceGif_ = this.entranceGif_;
                joinEffects.entranceApng_ = this.entranceApng_;
                joinEffects.entranceMp4_ = this.entranceMp4_;
                joinEffects.mediumImage_ = this.mediumImage_;
                onBuilt();
                return joinEffects;
            }

            /* renamed from: clear */
            public Builder m3672clear() {
                super.clear();
                this.contents_ = "";
                this.url_ = "";
                this.backgroundColor_ = "";
                this.giftApng_ = "";
                this.entranceGif_ = "";
                this.entranceApng_ = "";
                this.entranceMp4_ = "";
                this.mediumImage_ = "";
                return this;
            }

            public Builder clearBackgroundColor() {
                this.backgroundColor_ = JoinEffects.getDefaultInstance().getBackgroundColor();
                onChanged();
                return this;
            }

            public Builder clearContents() {
                this.contents_ = JoinEffects.getDefaultInstance().getContents();
                onChanged();
                return this;
            }

            public Builder clearEntranceApng() {
                this.entranceApng_ = JoinEffects.getDefaultInstance().getEntranceApng();
                onChanged();
                return this;
            }

            public Builder clearEntranceGif() {
                this.entranceGif_ = JoinEffects.getDefaultInstance().getEntranceGif();
                onChanged();
                return this;
            }

            public Builder clearEntranceMp4() {
                this.entranceMp4_ = JoinEffects.getDefaultInstance().getEntranceMp4();
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m3674clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearGiftApng() {
                this.giftApng_ = JoinEffects.getDefaultInstance().getGiftApng();
                onChanged();
                return this;
            }

            public Builder clearMediumImage() {
                this.mediumImage_ = JoinEffects.getDefaultInstance().getMediumImage();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m3677clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearUrl() {
                this.url_ = JoinEffects.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m3683clone() {
                return (Builder) super.clone();
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public String getBackgroundColor() {
                Object obj = this.backgroundColor_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.backgroundColor_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public ByteString getBackgroundColorBytes() {
                Object obj = this.backgroundColor_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.backgroundColor_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public String getContents() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.contents_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
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
            public JoinEffects m3685getDefaultInstanceForType() {
                return JoinEffects.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_JoinLiveExtra_JoinEffects_descriptor;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public String getEntranceApng() {
                Object obj = this.entranceApng_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.entranceApng_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public ByteString getEntranceApngBytes() {
                Object obj = this.entranceApng_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.entranceApng_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public String getEntranceGif() {
                Object obj = this.entranceGif_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.entranceGif_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public ByteString getEntranceGifBytes() {
                Object obj = this.entranceGif_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.entranceGif_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public String getEntranceMp4() {
                Object obj = this.entranceMp4_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.entranceMp4_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public ByteString getEntranceMp4Bytes() {
                Object obj = this.entranceMp4_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.entranceMp4_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public String getGiftApng() {
                Object obj = this.giftApng_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.giftApng_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public ByteString getGiftApngBytes() {
                Object obj = this.giftApng_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.giftApng_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public String getMediumImage() {
                Object obj = this.mediumImage_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.mediumImage_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public ByteString getMediumImageBytes() {
                Object obj = this.mediumImage_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.mediumImage_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
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
                return LiveConstants.internal_static_cn_irisgw_live_JoinLiveExtra_JoinEffects_fieldAccessorTable.ensureFieldAccessorsInitialized(JoinEffects.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(JoinEffects joinEffects) {
                if (joinEffects == JoinEffects.getDefaultInstance()) {
                    return this;
                }
                if (!joinEffects.getContents().isEmpty()) {
                    this.contents_ = joinEffects.contents_;
                    onChanged();
                }
                if (!joinEffects.getUrl().isEmpty()) {
                    this.url_ = joinEffects.url_;
                    onChanged();
                }
                if (!joinEffects.getBackgroundColor().isEmpty()) {
                    this.backgroundColor_ = joinEffects.backgroundColor_;
                    onChanged();
                }
                if (!joinEffects.getGiftApng().isEmpty()) {
                    this.giftApng_ = joinEffects.giftApng_;
                    onChanged();
                }
                if (!joinEffects.getEntranceGif().isEmpty()) {
                    this.entranceGif_ = joinEffects.entranceGif_;
                    onChanged();
                }
                if (!joinEffects.getEntranceApng().isEmpty()) {
                    this.entranceApng_ = joinEffects.entranceApng_;
                    onChanged();
                }
                if (!joinEffects.getEntranceMp4().isEmpty()) {
                    this.entranceMp4_ = joinEffects.entranceMp4_;
                    onChanged();
                }
                if (!joinEffects.getMediumImage().isEmpty()) {
                    this.mediumImage_ = joinEffects.mediumImage_;
                    onChanged();
                }
                m3694mergeUnknownFields(joinEffects.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.JoinLiveExtra.JoinEffects.Builder m3691mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.JoinLiveExtra.JoinEffects.access$1300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.JoinLiveExtra$JoinEffects r0 = (cn.irisgw.live.JoinLiveExtra.JoinEffects) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.JoinLiveExtra$JoinEffects$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.JoinLiveExtra$JoinEffects r0 = (cn.irisgw.live.JoinLiveExtra.JoinEffects) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.JoinLiveExtra$JoinEffects$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.JoinLiveExtra.JoinEffects.Builder.m3691mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.JoinLiveExtra$JoinEffects$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m3690mergeFrom(Message message) {
                if (message instanceof JoinEffects) {
                    return mergeFrom((JoinEffects) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m3694mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBackgroundColor(String str) {
                if (str != null) {
                    this.backgroundColor_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBackgroundColorBytes(ByteString byteString) {
                if (byteString != null) {
                    JoinEffects.checkByteStringIsUtf8(byteString);
                    this.backgroundColor_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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
                    JoinEffects.checkByteStringIsUtf8(byteString);
                    this.contents_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEntranceApng(String str) {
                if (str != null) {
                    this.entranceApng_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEntranceApngBytes(ByteString byteString) {
                if (byteString != null) {
                    JoinEffects.checkByteStringIsUtf8(byteString);
                    this.entranceApng_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEntranceGif(String str) {
                if (str != null) {
                    this.entranceGif_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEntranceGifBytes(ByteString byteString) {
                if (byteString != null) {
                    JoinEffects.checkByteStringIsUtf8(byteString);
                    this.entranceGif_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEntranceMp4(String str) {
                if (str != null) {
                    this.entranceMp4_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEntranceMp4Bytes(ByteString byteString) {
                if (byteString != null) {
                    JoinEffects.checkByteStringIsUtf8(byteString);
                    this.entranceMp4_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setField */
            public Builder m3696setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setGiftApng(String str) {
                if (str != null) {
                    this.giftApng_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setGiftApngBytes(ByteString byteString) {
                if (byteString != null) {
                    JoinEffects.checkByteStringIsUtf8(byteString);
                    this.giftApng_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMediumImage(String str) {
                if (str != null) {
                    this.mediumImage_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMediumImageBytes(ByteString byteString) {
                if (byteString != null) {
                    JoinEffects.checkByteStringIsUtf8(byteString);
                    this.mediumImage_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setRepeatedField */
            public Builder m3698setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* renamed from: setUnknownFields */
            public final Builder m3700setUnknownFields(UnknownFieldSet unknownFieldSet) {
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
                    JoinEffects.checkByteStringIsUtf8(byteString);
                    this.url_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }
        }

        private JoinEffects() {
            this.memoizedIsInitialized = (byte) -1;
            this.contents_ = "";
            this.url_ = "";
            this.backgroundColor_ = "";
            this.giftApng_ = "";
            this.entranceGif_ = "";
            this.entranceApng_ = "";
            this.entranceMp4_ = "";
            this.mediumImage_ = "";
        }

        private JoinEffects(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.contents_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.url_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.backgroundColor_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                this.giftApng_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                this.entranceGif_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 50) {
                                this.entranceApng_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 58) {
                                this.entranceMp4_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 66) {
                                this.mediumImage_ = codedInputStream.readStringRequireUtf8();
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

        private JoinEffects(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static JoinEffects getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_JoinLiveExtra_JoinEffects_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m3661toBuilder();
        }

        public static Builder newBuilder(JoinEffects joinEffects) {
            return DEFAULT_INSTANCE.m3661toBuilder().mergeFrom(joinEffects);
        }

        public static JoinEffects parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static JoinEffects parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static JoinEffects parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (JoinEffects) PARSER.parseFrom(byteString);
        }

        public static JoinEffects parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (JoinEffects) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static JoinEffects parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static JoinEffects parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static JoinEffects parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static JoinEffects parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static JoinEffects parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (JoinEffects) PARSER.parseFrom(byteBuffer);
        }

        public static JoinEffects parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (JoinEffects) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static JoinEffects parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (JoinEffects) PARSER.parseFrom(bArr);
        }

        public static JoinEffects parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (JoinEffects) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<JoinEffects> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof JoinEffects) {
                JoinEffects joinEffects = (JoinEffects) obj;
                return getContents().equals(joinEffects.getContents()) && getUrl().equals(joinEffects.getUrl()) && getBackgroundColor().equals(joinEffects.getBackgroundColor()) && getGiftApng().equals(joinEffects.getGiftApng()) && getEntranceGif().equals(joinEffects.getEntranceGif()) && getEntranceApng().equals(joinEffects.getEntranceApng()) && getEntranceMp4().equals(joinEffects.getEntranceMp4()) && getMediumImage().equals(joinEffects.getMediumImage()) && this.unknownFields.equals(joinEffects.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public String getBackgroundColor() {
            Object obj = this.backgroundColor_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.backgroundColor_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public ByteString getBackgroundColorBytes() {
            Object obj = this.backgroundColor_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.backgroundColor_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public String getContents() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.contents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
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
        public JoinEffects m3656getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public String getEntranceApng() {
            Object obj = this.entranceApng_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.entranceApng_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public ByteString getEntranceApngBytes() {
            Object obj = this.entranceApng_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.entranceApng_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public String getEntranceGif() {
            Object obj = this.entranceGif_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.entranceGif_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public ByteString getEntranceGifBytes() {
            Object obj = this.entranceGif_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.entranceGif_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public String getEntranceMp4() {
            Object obj = this.entranceMp4_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.entranceMp4_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public ByteString getEntranceMp4Bytes() {
            Object obj = this.entranceMp4_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.entranceMp4_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public String getGiftApng() {
            Object obj = this.giftApng_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftApng_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public ByteString getGiftApngBytes() {
            Object obj = this.giftApng_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftApng_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public String getMediumImage() {
            Object obj = this.mediumImage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mediumImage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public ByteString getMediumImageBytes() {
            Object obj = this.mediumImage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mediumImage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<JoinEffects> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getContentsBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.contents_);
            }
            int i3 = i2;
            if (!getUrlBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.url_);
            }
            int i4 = i3;
            if (!getBackgroundColorBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.backgroundColor_);
            }
            int i5 = i4;
            if (!getGiftApngBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.giftApng_);
            }
            int i6 = i5;
            if (!getEntranceGifBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.entranceGif_);
            }
            int i7 = i6;
            if (!getEntranceApngBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(6, this.entranceApng_);
            }
            int i8 = i7;
            if (!getEntranceMp4Bytes().isEmpty()) {
                i8 = i7 + GeneratedMessageV3.computeStringSize(7, this.entranceMp4_);
            }
            int i9 = i8;
            if (!getMediumImageBytes().isEmpty()) {
                i9 = i8 + GeneratedMessageV3.computeStringSize(8, this.mediumImage_);
            }
            int serializedSize = i9 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.JoinLiveExtra.JoinEffectsOrBuilder
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
            int hashCode = ((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getContents().hashCode()) * 37) + 2) * 53) + getUrl().hashCode()) * 37) + 3) * 53) + getBackgroundColor().hashCode()) * 37) + 4) * 53) + getGiftApng().hashCode()) * 37) + 5) * 53) + getEntranceGif().hashCode()) * 37) + 6) * 53) + getEntranceApng().hashCode()) * 37) + 7) * 53) + getEntranceMp4().hashCode()) * 37) + 8) * 53) + getMediumImage().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_JoinLiveExtra_JoinEffects_fieldAccessorTable.ensureFieldAccessorsInitialized(JoinEffects.class, Builder.class);
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
        public Builder m3659newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m3658newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new JoinEffects();
        }

        /* renamed from: toBuilder */
        public Builder m3661toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getContentsBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.contents_);
            }
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.url_);
            }
            if (!getBackgroundColorBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.backgroundColor_);
            }
            if (!getGiftApngBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.giftApng_);
            }
            if (!getEntranceGifBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.entranceGif_);
            }
            if (!getEntranceApngBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.entranceApng_);
            }
            if (!getEntranceMp4Bytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.entranceMp4_);
            }
            if (!getMediumImageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.mediumImage_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/JoinLiveExtra$JoinEffectsOrBuilder.class */
    public interface JoinEffectsOrBuilder extends MessageOrBuilder {
        String getBackgroundColor();

        ByteString getBackgroundColorBytes();

        String getContents();

        ByteString getContentsBytes();

        String getEntranceApng();

        ByteString getEntranceApngBytes();

        String getEntranceGif();

        ByteString getEntranceGifBytes();

        String getEntranceMp4();

        ByteString getEntranceMp4Bytes();

        String getGiftApng();

        ByteString getGiftApngBytes();

        String getMediumImage();

        ByteString getMediumImageBytes();

        String getUrl();

        ByteString getUrlBytes();
    }

    private JoinLiveExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.fanClubName_ = "";
        this.fansStatus_ = 0;
        this.liangType_ = 0;
        this.liangId_ = "";
        this.avatarFrame_ = "";
        this.chatFrame_ = "";
        this.chatFrameIcon_ = "";
        this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
        this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
        this.chatBadgeUrl_ = "";
        this.anchorPocketTrafficCardName_ = "";
        this.nobleJoinText_ = "";
    }

    private JoinLiveExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        JoinEffects.Builder builder;
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
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.count_ = codedInputStream.readUInt32();
                                continue;
                            case 16:
                                this.realtimeCount_ = codedInputStream.readUInt32();
                                continue;
                            case 26:
                                if (this.effects_ != null) {
                                    boolean z4 = z2;
                                    builder = this.effects_.m3661toBuilder();
                                } else {
                                    builder = null;
                                }
                                JoinEffects readMessage = codedInputStream.readMessage(JoinEffects.parser(), extensionRegistryLite);
                                boolean z5 = z2;
                                this.effects_ = readMessage;
                                if (builder != null) {
                                    builder.mergeFrom(readMessage);
                                    boolean z6 = z2;
                                    this.effects_ = builder.m3668buildPartial();
                                } else {
                                    continue;
                                }
                            case 34:
                                this.fanClubName_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 40:
                                this.fanClubLevel_ = codedInputStream.readInt32();
                                continue;
                            case 48:
                                this.inFanClub_ = codedInputStream.readBool();
                                continue;
                            case 56:
                                this.fansStatus_ = codedInputStream.readEnum();
                                continue;
                            case 64:
                                this.liangType_ = codedInputStream.readEnum();
                                continue;
                            case 74:
                                this.liangId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 80:
                                this.rechargeBadge_ = codedInputStream.readInt32();
                                continue;
                            case 90:
                                this.avatarFrame_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 96:
                                this.avatarFrameType_ = codedInputStream.readInt32();
                                continue;
                            case 106:
                                this.chatFrame_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 114:
                                this.chatFrameIcon_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 120:
                                this.chatFrameColorType_ = codedInputStream.readInt32();
                                continue;
                            case 128:
                                this.chatFrameGradientType_ = codedInputStream.readInt32();
                                continue;
                            case 138:
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                boolean z7 = z2;
                                if (!(z2 & true)) {
                                    this.chatFrameFrameColor_ = new LazyStringArrayList();
                                    z7 = z2 | true;
                                }
                                this.chatFrameFrameColor_.add(readStringRequireUtf8);
                                z2 = z7;
                                continue;
                            case 146:
                                String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                                boolean z8 = z2;
                                if (!(z2 & true)) {
                                    this.chatFrameBorderColor_ = new LazyStringArrayList();
                                    z8 = z2 | true;
                                }
                                this.chatFrameBorderColor_.add(readStringRequireUtf82);
                                z2 = z8;
                                continue;
                            case 154:
                                this.chatBadgeUrl_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 160:
                                this.chatBadgeLength_ = codedInputStream.readInt32();
                                continue;
                            case 168:
                                this.chatBadgeHeight_ = codedInputStream.readInt32();
                                continue;
                            case 176:
                                this.anchorPocketTrafficCard_ = codedInputStream.readInt32();
                                continue;
                            case 186:
                                this.anchorPocketTrafficCardName_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 194:
                                this.nobleJoinText_ = codedInputStream.readStringRequireUtf8();
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
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
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

    private JoinLiveExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static JoinLiveExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_JoinLiveExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m3614toBuilder();
    }

    public static Builder newBuilder(JoinLiveExtra joinLiveExtra) {
        return DEFAULT_INSTANCE.m3614toBuilder().mergeFrom(joinLiveExtra);
    }

    public static JoinLiveExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static JoinLiveExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static JoinLiveExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (JoinLiveExtra) PARSER.parseFrom(byteString);
    }

    public static JoinLiveExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JoinLiveExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static JoinLiveExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static JoinLiveExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static JoinLiveExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static JoinLiveExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static JoinLiveExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (JoinLiveExtra) PARSER.parseFrom(byteBuffer);
    }

    public static JoinLiveExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JoinLiveExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static JoinLiveExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (JoinLiveExtra) PARSER.parseFrom(bArr);
    }

    public static JoinLiveExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JoinLiveExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<JoinLiveExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof JoinLiveExtra) {
            JoinLiveExtra joinLiveExtra = (JoinLiveExtra) obj;
            if (getCount() == joinLiveExtra.getCount() && getRealtimeCount() == joinLiveExtra.getRealtimeCount() && hasEffects() == joinLiveExtra.hasEffects()) {
                return (!hasEffects() || getEffects().equals(joinLiveExtra.getEffects())) && getFanClubName().equals(joinLiveExtra.getFanClubName()) && getFanClubLevel() == joinLiveExtra.getFanClubLevel() && getInFanClub() == joinLiveExtra.getInFanClub() && this.fansStatus_ == joinLiveExtra.fansStatus_ && this.liangType_ == joinLiveExtra.liangType_ && getLiangId().equals(joinLiveExtra.getLiangId()) && getRechargeBadge() == joinLiveExtra.getRechargeBadge() && getAvatarFrame().equals(joinLiveExtra.getAvatarFrame()) && getAvatarFrameType() == joinLiveExtra.getAvatarFrameType() && getChatFrame().equals(joinLiveExtra.getChatFrame()) && getChatFrameIcon().equals(joinLiveExtra.getChatFrameIcon()) && getChatFrameColorType() == joinLiveExtra.getChatFrameColorType() && getChatFrameGradientType() == joinLiveExtra.getChatFrameGradientType() && mo3607getChatFrameFrameColorList().equals(joinLiveExtra.mo3607getChatFrameFrameColorList()) && mo3606getChatFrameBorderColorList().equals(joinLiveExtra.mo3606getChatFrameBorderColorList()) && getChatBadgeUrl().equals(joinLiveExtra.getChatBadgeUrl()) && getChatBadgeLength() == joinLiveExtra.getChatBadgeLength() && getChatBadgeHeight() == joinLiveExtra.getChatBadgeHeight() && getAnchorPocketTrafficCard() == joinLiveExtra.getAnchorPocketTrafficCard() && getAnchorPocketTrafficCardName().equals(joinLiveExtra.getAnchorPocketTrafficCardName()) && getNobleJoinText().equals(joinLiveExtra.getNobleJoinText()) && this.unknownFields.equals(joinLiveExtra.unknownFields);
            }
            return false;
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getAnchorPocketTrafficCard() {
        return this.anchorPocketTrafficCard_;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public String getAnchorPocketTrafficCardName() {
        Object obj = this.anchorPocketTrafficCardName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.anchorPocketTrafficCardName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public ByteString getAnchorPocketTrafficCardNameBytes() {
        Object obj = this.anchorPocketTrafficCardName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.anchorPocketTrafficCardName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public String getAvatarFrame() {
        Object obj = this.avatarFrame_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatarFrame_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public ByteString getAvatarFrameBytes() {
        Object obj = this.avatarFrame_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.avatarFrame_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getAvatarFrameType() {
        return this.avatarFrameType_;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getChatBadgeHeight() {
        return this.chatBadgeHeight_;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getChatBadgeLength() {
        return this.chatBadgeLength_;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public String getChatBadgeUrl() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatBadgeUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public ByteString getChatBadgeUrlBytes() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatBadgeUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public String getChatFrame() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrame_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public String getChatFrameBorderColor(int i) {
        return (String) this.chatFrameBorderColor_.get(i);
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public ByteString getChatFrameBorderColorBytes(int i) {
        return this.chatFrameBorderColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getChatFrameBorderColorCount() {
        return this.chatFrameBorderColor_.size();
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    /* renamed from: getChatFrameBorderColorList */
    public ProtocolStringList mo3606getChatFrameBorderColorList() {
        return this.chatFrameBorderColor_;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public ByteString getChatFrameBytes() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrame_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getChatFrameColorType() {
        return this.chatFrameColorType_;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public String getChatFrameFrameColor(int i) {
        return (String) this.chatFrameFrameColor_.get(i);
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public ByteString getChatFrameFrameColorBytes(int i) {
        return this.chatFrameFrameColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getChatFrameFrameColorCount() {
        return this.chatFrameFrameColor_.size();
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    /* renamed from: getChatFrameFrameColorList */
    public ProtocolStringList mo3607getChatFrameFrameColorList() {
        return this.chatFrameFrameColor_;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getChatFrameGradientType() {
        return this.chatFrameGradientType_;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public String getChatFrameIcon() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrameIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public ByteString getChatFrameIconBytes() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrameIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getCount() {
        return this.count_;
    }

    /* renamed from: getDefaultInstanceForType */
    public JoinLiveExtra m3609getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public JoinEffects getEffects() {
        JoinEffects joinEffects = this.effects_;
        JoinEffects joinEffects2 = joinEffects;
        if (joinEffects == null) {
            joinEffects2 = JoinEffects.getDefaultInstance();
        }
        return joinEffects2;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public JoinEffectsOrBuilder getEffectsOrBuilder() {
        return getEffects();
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getFanClubLevel() {
        return this.fanClubLevel_;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public String getFanClubName() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.fanClubName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public ByteString getFanClubNameBytes() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fanClubName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public FanStatus getFansStatus() {
        FanStatus valueOf = FanStatus.valueOf(this.fansStatus_);
        FanStatus fanStatus = valueOf;
        if (valueOf == null) {
            fanStatus = FanStatus.UNRECOGNIZED;
        }
        return fanStatus;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getFansStatusValue() {
        return this.fansStatus_;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public boolean getInFanClub() {
        return this.inFanClub_;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public String getLiangId() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.liangId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public ByteString getLiangIdBytes() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.liangId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public LiangType getLiangType() {
        LiangType valueOf = LiangType.valueOf(this.liangType_);
        LiangType liangType = valueOf;
        if (valueOf == null) {
            liangType = LiangType.UNRECOGNIZED;
        }
        return liangType;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getLiangTypeValue() {
        return this.liangType_;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public String getNobleJoinText() {
        Object obj = this.nobleJoinText_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.nobleJoinText_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public ByteString getNobleJoinTextBytes() {
        Object obj = this.nobleJoinText_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.nobleJoinText_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<JoinLiveExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getRealtimeCount() {
        return this.realtimeCount_;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public int getRechargeBadge() {
        return this.rechargeBadge_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.count_;
        int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
        int i3 = this.realtimeCount_;
        int i4 = computeUInt32Size;
        if (i3 != 0) {
            i4 = computeUInt32Size + CodedOutputStream.computeUInt32Size(2, i3);
        }
        int i5 = i4;
        if (this.effects_ != null) {
            i5 = i4 + CodedOutputStream.computeMessageSize(3, getEffects());
        }
        int i6 = i5;
        if (!getFanClubNameBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.fanClubName_);
        }
        int i7 = this.fanClubLevel_;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeInt32Size(5, i7);
        }
        boolean z = this.inFanClub_;
        int i9 = i8;
        if (z) {
            i9 = i8 + CodedOutputStream.computeBoolSize(6, z);
        }
        int i10 = i9;
        if (this.fansStatus_ != FanStatus.Out.getNumber()) {
            i10 = i9 + CodedOutputStream.computeEnumSize(7, this.fansStatus_);
        }
        int i11 = i10;
        if (this.liangType_ != LiangType.None.getNumber()) {
            i11 = i10 + CodedOutputStream.computeEnumSize(8, this.liangType_);
        }
        int i12 = i11;
        if (!getLiangIdBytes().isEmpty()) {
            i12 = i11 + GeneratedMessageV3.computeStringSize(9, this.liangId_);
        }
        int i13 = this.rechargeBadge_;
        int i14 = i12;
        if (i13 != 0) {
            i14 = i12 + CodedOutputStream.computeInt32Size(10, i13);
        }
        int i15 = i14;
        if (!getAvatarFrameBytes().isEmpty()) {
            i15 = i14 + GeneratedMessageV3.computeStringSize(11, this.avatarFrame_);
        }
        int i16 = this.avatarFrameType_;
        int i17 = i15;
        if (i16 != 0) {
            i17 = i15 + CodedOutputStream.computeInt32Size(12, i16);
        }
        int i18 = i17;
        if (!getChatFrameBytes().isEmpty()) {
            i18 = i17 + GeneratedMessageV3.computeStringSize(13, this.chatFrame_);
        }
        int i19 = i18;
        if (!getChatFrameIconBytes().isEmpty()) {
            i19 = i18 + GeneratedMessageV3.computeStringSize(14, this.chatFrameIcon_);
        }
        int i20 = this.chatFrameColorType_;
        int i21 = i19;
        if (i20 != 0) {
            i21 = i19 + CodedOutputStream.computeInt32Size(15, i20);
        }
        int i22 = this.chatFrameGradientType_;
        int i23 = i21;
        if (i22 != 0) {
            i23 = i21 + CodedOutputStream.computeInt32Size(16, i22);
        }
        int i24 = 0;
        for (int i25 = 0; i25 < this.chatFrameFrameColor_.size(); i25++) {
            i24 += computeStringSizeNoTag(this.chatFrameFrameColor_.getRaw(i25));
        }
        int size = mo3607getChatFrameFrameColorList().size();
        int i26 = 0;
        int i27 = 0;
        while (true) {
            int i28 = i27;
            if (i28 >= this.chatFrameBorderColor_.size()) {
                break;
            }
            i26 += computeStringSizeNoTag(this.chatFrameBorderColor_.getRaw(i28));
            i27 = i28 + 1;
        }
        int size2 = i23 + i24 + (size * 2) + i26 + (mo3606getChatFrameBorderColorList().size() * 2);
        int i29 = size2;
        if (!getChatBadgeUrlBytes().isEmpty()) {
            i29 = size2 + GeneratedMessageV3.computeStringSize(19, this.chatBadgeUrl_);
        }
        int i30 = this.chatBadgeLength_;
        int i31 = i29;
        if (i30 != 0) {
            i31 = i29 + CodedOutputStream.computeInt32Size(20, i30);
        }
        int i32 = this.chatBadgeHeight_;
        int i33 = i31;
        if (i32 != 0) {
            i33 = i31 + CodedOutputStream.computeInt32Size(21, i32);
        }
        int i34 = this.anchorPocketTrafficCard_;
        int i35 = i33;
        if (i34 != 0) {
            i35 = i33 + CodedOutputStream.computeInt32Size(22, i34);
        }
        int i36 = i35;
        if (!getAnchorPocketTrafficCardNameBytes().isEmpty()) {
            i36 = i35 + GeneratedMessageV3.computeStringSize(23, this.anchorPocketTrafficCardName_);
        }
        int i37 = i36;
        if (!getNobleJoinTextBytes().isEmpty()) {
            i37 = i36 + GeneratedMessageV3.computeStringSize(24, this.nobleJoinText_);
        }
        int serializedSize = i37 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.JoinLiveExtraOrBuilder
    public boolean hasEffects() {
        return this.effects_ != null;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCount()) * 37) + 2) * 53) + getRealtimeCount();
        int i = hashCode;
        if (hasEffects()) {
            i = (((hashCode * 37) + 3) * 53) + getEffects().hashCode();
        }
        int hashCode2 = (((((((((((((((((((((((((((((((((((((((((((((((((((i * 37) + 4) * 53) + getFanClubName().hashCode()) * 37) + 5) * 53) + getFanClubLevel()) * 37) + 6) * 53) + Internal.hashBoolean(getInFanClub())) * 37) + 7) * 53) + this.fansStatus_) * 37) + 8) * 53) + this.liangType_) * 37) + 9) * 53) + getLiangId().hashCode()) * 37) + 10) * 53) + getRechargeBadge()) * 37) + 11) * 53) + getAvatarFrame().hashCode()) * 37) + 12) * 53) + getAvatarFrameType()) * 37) + 13) * 53) + getChatFrame().hashCode()) * 37) + 14) * 53) + getChatFrameIcon().hashCode()) * 37) + 15) * 53) + getChatFrameColorType()) * 37) + 16) * 53) + getChatFrameGradientType();
        int i2 = hashCode2;
        if (getChatFrameFrameColorCount() > 0) {
            i2 = (((hashCode2 * 37) + 17) * 53) + mo3607getChatFrameFrameColorList().hashCode();
        }
        int i3 = i2;
        if (getChatFrameBorderColorCount() > 0) {
            i3 = (((i2 * 37) + 18) * 53) + mo3606getChatFrameBorderColorList().hashCode();
        }
        int hashCode3 = (((((((((((((((((((((((((i3 * 37) + 19) * 53) + getChatBadgeUrl().hashCode()) * 37) + 20) * 53) + getChatBadgeLength()) * 37) + 21) * 53) + getChatBadgeHeight()) * 37) + 22) * 53) + getAnchorPocketTrafficCard()) * 37) + 23) * 53) + getAnchorPocketTrafficCardName().hashCode()) * 37) + 24) * 53) + getNobleJoinText().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode3;
        return hashCode3;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_JoinLiveExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(JoinLiveExtra.class, Builder.class);
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
    public Builder m3612newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m3611newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new JoinLiveExtra();
    }

    /* renamed from: toBuilder */
    public Builder m3614toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i;
        int i2 = this.count_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(1, i2);
        }
        int i3 = this.realtimeCount_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(2, i3);
        }
        if (this.effects_ != null) {
            codedOutputStream.writeMessage(3, getEffects());
        }
        if (!getFanClubNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.fanClubName_);
        }
        int i4 = this.fanClubLevel_;
        if (i4 != 0) {
            codedOutputStream.writeInt32(5, i4);
        }
        boolean z = this.inFanClub_;
        if (z) {
            codedOutputStream.writeBool(6, z);
        }
        if (this.fansStatus_ != FanStatus.Out.getNumber()) {
            codedOutputStream.writeEnum(7, this.fansStatus_);
        }
        if (this.liangType_ != LiangType.None.getNumber()) {
            codedOutputStream.writeEnum(8, this.liangType_);
        }
        if (!getLiangIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.liangId_);
        }
        int i5 = this.rechargeBadge_;
        if (i5 != 0) {
            codedOutputStream.writeInt32(10, i5);
        }
        if (!getAvatarFrameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 11, this.avatarFrame_);
        }
        int i6 = this.avatarFrameType_;
        if (i6 != 0) {
            codedOutputStream.writeInt32(12, i6);
        }
        if (!getChatFrameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 13, this.chatFrame_);
        }
        if (!getChatFrameIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 14, this.chatFrameIcon_);
        }
        int i7 = this.chatFrameColorType_;
        if (i7 != 0) {
            codedOutputStream.writeInt32(15, i7);
        }
        int i8 = this.chatFrameGradientType_;
        if (i8 != 0) {
            codedOutputStream.writeInt32(16, i8);
        }
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= this.chatFrameFrameColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 17, this.chatFrameFrameColor_.getRaw(i10));
            i9 = i10 + 1;
        }
        for (i = 0; i < this.chatFrameBorderColor_.size(); i++) {
            GeneratedMessageV3.writeString(codedOutputStream, 18, this.chatFrameBorderColor_.getRaw(i));
        }
        if (!getChatBadgeUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 19, this.chatBadgeUrl_);
        }
        int i11 = this.chatBadgeLength_;
        if (i11 != 0) {
            codedOutputStream.writeInt32(20, i11);
        }
        int i12 = this.chatBadgeHeight_;
        if (i12 != 0) {
            codedOutputStream.writeInt32(21, i12);
        }
        int i13 = this.anchorPocketTrafficCard_;
        if (i13 != 0) {
            codedOutputStream.writeInt32(22, i13);
        }
        if (!getAnchorPocketTrafficCardNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 23, this.anchorPocketTrafficCardName_);
        }
        if (!getNobleJoinTextBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 24, this.nobleJoinText_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
