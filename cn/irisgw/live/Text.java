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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/Text.class */
public final class Text extends GeneratedMessageV3 implements TextOrBuilder {
    public static final int CHAT_BADGE_HEIGHT_FIELD_NUMBER = 16;
    public static final int CHAT_BADGE_LENGTH_FIELD_NUMBER = 15;
    public static final int CHAT_BADGE_URL_FIELD_NUMBER = 14;
    public static final int CHAT_FRAME_BORDER_COLOR_FIELD_NUMBER = 13;
    public static final int CHAT_FRAME_COLOR_TYPE_FIELD_NUMBER = 10;
    public static final int CHAT_FRAME_FIELD_NUMBER = 8;
    public static final int CHAT_FRAME_FRAME_COLOR_FIELD_NUMBER = 12;
    public static final int CHAT_FRAME_GRADIENT_TYPE_FIELD_NUMBER = 11;
    public static final int CHAT_FRAME_ICON_FIELD_NUMBER = 9;
    public static final int EMOJI_H_FIELD_NUMBER = 20;
    public static final int EMOJI_ID_FIELD_NUMBER = 17;
    public static final int EMOJI_URL_FIELD_NUMBER = 18;
    public static final int EMOJI_W_FIELD_NUMBER = 19;
    public static final int FANS_STATUS_FIELD_NUMBER = 4;
    public static final int FAN_CLUB_LEVEL_FIELD_NUMBER = 2;
    public static final int FAN_CLUB_NAME_FIELD_NUMBER = 1;
    public static final int IN_FAN_CLUB_FIELD_NUMBER = 3;
    public static final int LIANG_ID_FIELD_NUMBER = 6;
    public static final int LIANG_TYPE_FIELD_NUMBER = 5;
    public static final int RECHARGE_BADGE_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private int chatBadgeHeight_;
    private int chatBadgeLength_;
    private volatile Object chatBadgeUrl_;
    private LazyStringList chatFrameBorderColor_;
    private int chatFrameColorType_;
    private LazyStringList chatFrameFrameColor_;
    private int chatFrameGradientType_;
    private volatile Object chatFrameIcon_;
    private volatile Object chatFrame_;
    private int emojiH_;
    private int emojiId_;
    private volatile Object emojiUrl_;
    private int emojiW_;
    private int fanClubLevel_;
    private volatile Object fanClubName_;
    private int fansStatus_;
    private boolean inFanClub_;
    private volatile Object liangId_;
    private int liangType_;
    private byte memoizedIsInitialized;
    private int rechargeBadge_;
    private static final Text DEFAULT_INSTANCE = new Text();
    private static final Parser<Text> PARSER = new AbstractParser<Text>() { // from class: cn.irisgw.live.Text.1
        /* renamed from: parsePartialFrom */
        public Text m7644parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Text(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/Text$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TextOrBuilder {
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
        private int emojiH_;
        private int emojiId_;
        private Object emojiUrl_;
        private int emojiW_;
        private int fanClubLevel_;
        private Object fanClubName_;
        private int fansStatus_;
        private boolean inFanClub_;
        private Object liangId_;
        private int liangType_;
        private int rechargeBadge_;

        private Builder() {
            this.fanClubName_ = "";
            this.fansStatus_ = 0;
            this.liangType_ = 0;
            this.liangId_ = "";
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.chatBadgeUrl_ = "";
            this.emojiUrl_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.fanClubName_ = "";
            this.fansStatus_ = 0;
            this.liangType_ = 0;
            this.liangId_ = "";
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.chatBadgeUrl_ = "";
            this.emojiUrl_ = "";
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
            return LiveConstants.internal_static_cn_irisgw_live_Text_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = Text.alwaysUseFieldBuilders;
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
                Text.checkByteStringIsUtf8(byteString);
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
                Text.checkByteStringIsUtf8(byteString);
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: addRepeatedField */
        public Builder m7646addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public Text m7648build() {
            Text m7650buildPartial = m7650buildPartial();
            if (m7650buildPartial.isInitialized()) {
                return m7650buildPartial;
            }
            throw newUninitializedMessageException(m7650buildPartial);
        }

        /* renamed from: buildPartial */
        public Text m7650buildPartial() {
            Text text = new Text(this);
            text.fanClubName_ = this.fanClubName_;
            text.fanClubLevel_ = this.fanClubLevel_;
            text.inFanClub_ = this.inFanClub_;
            text.fansStatus_ = this.fansStatus_;
            text.liangType_ = this.liangType_;
            text.liangId_ = this.liangId_;
            text.rechargeBadge_ = this.rechargeBadge_;
            text.chatFrame_ = this.chatFrame_;
            text.chatFrameIcon_ = this.chatFrameIcon_;
            text.chatFrameColorType_ = this.chatFrameColorType_;
            text.chatFrameGradientType_ = this.chatFrameGradientType_;
            if ((this.bitField0_ & 1) != 0) {
                this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            text.chatFrameFrameColor_ = this.chatFrameFrameColor_;
            if ((this.bitField0_ & 2) != 0) {
                this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            text.chatFrameBorderColor_ = this.chatFrameBorderColor_;
            text.chatBadgeUrl_ = this.chatBadgeUrl_;
            text.chatBadgeLength_ = this.chatBadgeLength_;
            text.chatBadgeHeight_ = this.chatBadgeHeight_;
            text.emojiId_ = this.emojiId_;
            text.emojiUrl_ = this.emojiUrl_;
            text.emojiW_ = this.emojiW_;
            text.emojiH_ = this.emojiH_;
            onBuilt();
            return text;
        }

        /* renamed from: clear */
        public Builder m7654clear() {
            super.clear();
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
            this.bitField0_ &= -2;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            this.chatBadgeUrl_ = "";
            this.chatBadgeLength_ = 0;
            this.chatBadgeHeight_ = 0;
            this.emojiId_ = 0;
            this.emojiUrl_ = "";
            this.emojiW_ = 0;
            this.emojiH_ = 0;
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
            this.chatBadgeUrl_ = Text.getDefaultInstance().getChatBadgeUrl();
            onChanged();
            return this;
        }

        public Builder clearChatFrame() {
            this.chatFrame_ = Text.getDefaultInstance().getChatFrame();
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
            this.chatFrameIcon_ = Text.getDefaultInstance().getChatFrameIcon();
            onChanged();
            return this;
        }

        public Builder clearEmojiH() {
            this.emojiH_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEmojiId() {
            this.emojiId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEmojiUrl() {
            this.emojiUrl_ = Text.getDefaultInstance().getEmojiUrl();
            onChanged();
            return this;
        }

        public Builder clearEmojiW() {
            this.emojiW_ = 0;
            onChanged();
            return this;
        }

        public Builder clearFanClubLevel() {
            this.fanClubLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearFanClubName() {
            this.fanClubName_ = Text.getDefaultInstance().getFanClubName();
            onChanged();
            return this;
        }

        public Builder clearFansStatus() {
            this.fansStatus_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m7656clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearInFanClub() {
            this.inFanClub_ = false;
            onChanged();
            return this;
        }

        public Builder clearLiangId() {
            this.liangId_ = Text.getDefaultInstance().getLiangId();
            onChanged();
            return this;
        }

        public Builder clearLiangType() {
            this.liangType_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m7659clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRechargeBadge() {
            this.rechargeBadge_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m7665clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public int getChatBadgeHeight() {
            return this.chatBadgeHeight_;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public int getChatBadgeLength() {
            return this.chatBadgeLength_;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public String getChatBadgeUrl() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatBadgeUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public ByteString getChatBadgeUrlBytes() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatBadgeUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public String getChatFrame() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrame_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public String getChatFrameBorderColor(int i) {
            return (String) this.chatFrameBorderColor_.get(i);
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public ByteString getChatFrameBorderColorBytes(int i) {
            return this.chatFrameBorderColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public int getChatFrameBorderColorCount() {
            return this.chatFrameBorderColor_.size();
        }

        @Override // cn.irisgw.live.TextOrBuilder
        /* renamed from: getChatFrameBorderColorList */
        public ProtocolStringList mo7635getChatFrameBorderColorList() {
            return this.chatFrameBorderColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public ByteString getChatFrameBytes() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrame_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public int getChatFrameColorType() {
            return this.chatFrameColorType_;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public String getChatFrameFrameColor(int i) {
            return (String) this.chatFrameFrameColor_.get(i);
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public ByteString getChatFrameFrameColorBytes(int i) {
            return this.chatFrameFrameColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public int getChatFrameFrameColorCount() {
            return this.chatFrameFrameColor_.size();
        }

        @Override // cn.irisgw.live.TextOrBuilder
        /* renamed from: getChatFrameFrameColorList */
        public ProtocolStringList mo7636getChatFrameFrameColorList() {
            return this.chatFrameFrameColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public int getChatFrameGradientType() {
            return this.chatFrameGradientType_;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public String getChatFrameIcon() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrameIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.TextOrBuilder
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
        public Text m7667getDefaultInstanceForType() {
            return Text.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_Text_descriptor;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public int getEmojiH() {
            return this.emojiH_;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public int getEmojiId() {
            return this.emojiId_;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public String getEmojiUrl() {
            Object obj = this.emojiUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.emojiUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public ByteString getEmojiUrlBytes() {
            Object obj = this.emojiUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.emojiUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public int getEmojiW() {
            return this.emojiW_;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public int getFanClubLevel() {
            return this.fanClubLevel_;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public String getFanClubName() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fanClubName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public ByteString getFanClubNameBytes() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fanClubName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public FanStatus getFansStatus() {
            FanStatus valueOf = FanStatus.valueOf(this.fansStatus_);
            FanStatus fanStatus = valueOf;
            if (valueOf == null) {
                fanStatus = FanStatus.UNRECOGNIZED;
            }
            return fanStatus;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public int getFansStatusValue() {
            return this.fansStatus_;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public boolean getInFanClub() {
            return this.inFanClub_;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public String getLiangId() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liangId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public ByteString getLiangIdBytes() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liangId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public LiangType getLiangType() {
            LiangType valueOf = LiangType.valueOf(this.liangType_);
            LiangType liangType = valueOf;
            if (valueOf == null) {
                liangType = LiangType.UNRECOGNIZED;
            }
            return liangType;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public int getLiangTypeValue() {
            return this.liangType_;
        }

        @Override // cn.irisgw.live.TextOrBuilder
        public int getRechargeBadge() {
            return this.rechargeBadge_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_Text_fieldAccessorTable.ensureFieldAccessorsInitialized(Text.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(Text text) {
            if (text == Text.getDefaultInstance()) {
                return this;
            }
            if (!text.getFanClubName().isEmpty()) {
                this.fanClubName_ = text.fanClubName_;
                onChanged();
            }
            if (text.getFanClubLevel() != 0) {
                setFanClubLevel(text.getFanClubLevel());
            }
            if (text.getInFanClub()) {
                setInFanClub(text.getInFanClub());
            }
            if (text.fansStatus_ != 0) {
                setFansStatusValue(text.getFansStatusValue());
            }
            if (text.liangType_ != 0) {
                setLiangTypeValue(text.getLiangTypeValue());
            }
            if (!text.getLiangId().isEmpty()) {
                this.liangId_ = text.liangId_;
                onChanged();
            }
            if (text.getRechargeBadge() != 0) {
                setRechargeBadge(text.getRechargeBadge());
            }
            if (!text.getChatFrame().isEmpty()) {
                this.chatFrame_ = text.chatFrame_;
                onChanged();
            }
            if (!text.getChatFrameIcon().isEmpty()) {
                this.chatFrameIcon_ = text.chatFrameIcon_;
                onChanged();
            }
            if (text.getChatFrameColorType() != 0) {
                setChatFrameColorType(text.getChatFrameColorType());
            }
            if (text.getChatFrameGradientType() != 0) {
                setChatFrameGradientType(text.getChatFrameGradientType());
            }
            if (!text.chatFrameFrameColor_.isEmpty()) {
                if (this.chatFrameFrameColor_.isEmpty()) {
                    this.chatFrameFrameColor_ = text.chatFrameFrameColor_;
                    this.bitField0_ &= -2;
                } else {
                    ensureChatFrameFrameColorIsMutable();
                    this.chatFrameFrameColor_.addAll(text.chatFrameFrameColor_);
                }
                onChanged();
            }
            if (!text.chatFrameBorderColor_.isEmpty()) {
                if (this.chatFrameBorderColor_.isEmpty()) {
                    this.chatFrameBorderColor_ = text.chatFrameBorderColor_;
                    this.bitField0_ &= -3;
                } else {
                    ensureChatFrameBorderColorIsMutable();
                    this.chatFrameBorderColor_.addAll(text.chatFrameBorderColor_);
                }
                onChanged();
            }
            if (!text.getChatBadgeUrl().isEmpty()) {
                this.chatBadgeUrl_ = text.chatBadgeUrl_;
                onChanged();
            }
            if (text.getChatBadgeLength() != 0) {
                setChatBadgeLength(text.getChatBadgeLength());
            }
            if (text.getChatBadgeHeight() != 0) {
                setChatBadgeHeight(text.getChatBadgeHeight());
            }
            if (text.getEmojiId() != 0) {
                setEmojiId(text.getEmojiId());
            }
            if (!text.getEmojiUrl().isEmpty()) {
                this.emojiUrl_ = text.emojiUrl_;
                onChanged();
            }
            if (text.getEmojiW() != 0) {
                setEmojiW(text.getEmojiW());
            }
            if (text.getEmojiH() != 0) {
                setEmojiH(text.getEmojiH());
            }
            m7676mergeUnknownFields(text.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.Text.Builder m7673mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.Text.access$2500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.Text r0 = (cn.irisgw.live.Text) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.Text$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.Text r0 = (cn.irisgw.live.Text) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.Text$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.Text.Builder.m7673mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.Text$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m7672mergeFrom(Message message) {
            if (message instanceof Text) {
                return mergeFrom((Text) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m7676mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
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
                Text.checkByteStringIsUtf8(byteString);
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
                Text.checkByteStringIsUtf8(byteString);
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
                Text.checkByteStringIsUtf8(byteString);
                this.chatFrameIcon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setEmojiH(int i) {
            this.emojiH_ = i;
            onChanged();
            return this;
        }

        public Builder setEmojiId(int i) {
            this.emojiId_ = i;
            onChanged();
            return this;
        }

        public Builder setEmojiUrl(String str) {
            if (str != null) {
                this.emojiUrl_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setEmojiUrlBytes(ByteString byteString) {
            if (byteString != null) {
                Text.checkByteStringIsUtf8(byteString);
                this.emojiUrl_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setEmojiW(int i) {
            this.emojiW_ = i;
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
                Text.checkByteStringIsUtf8(byteString);
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
        public Builder m7678setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
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
                Text.checkByteStringIsUtf8(byteString);
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

        /* renamed from: setRepeatedField */
        public Builder m7680setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m7682setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private Text() {
        this.memoizedIsInitialized = (byte) -1;
        this.fanClubName_ = "";
        this.fansStatus_ = 0;
        this.liangType_ = 0;
        this.liangId_ = "";
        this.chatFrame_ = "";
        this.chatFrameIcon_ = "";
        this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
        this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
        this.chatBadgeUrl_ = "";
        this.emojiUrl_ = "";
    }

    private Text(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.fanClubName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 16:
                            this.fanClubLevel_ = codedInputStream.readInt32();
                            continue;
                        case 24:
                            this.inFanClub_ = codedInputStream.readBool();
                            continue;
                        case 32:
                            this.fansStatus_ = codedInputStream.readEnum();
                            continue;
                        case 40:
                            this.liangType_ = codedInputStream.readEnum();
                            continue;
                        case 50:
                            this.liangId_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 56:
                            this.rechargeBadge_ = codedInputStream.readInt32();
                            continue;
                        case 66:
                            this.chatFrame_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 74:
                            this.chatFrameIcon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 80:
                            this.chatFrameColorType_ = codedInputStream.readInt32();
                            continue;
                        case 88:
                            this.chatFrameGradientType_ = codedInputStream.readInt32();
                            continue;
                        case 98:
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameFrameColor_ = new LazyStringArrayList();
                                z4 = z2 | true;
                            }
                            this.chatFrameFrameColor_.add(readStringRequireUtf8);
                            z2 = z4;
                            continue;
                        case 106:
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameBorderColor_ = new LazyStringArrayList();
                                z5 = z2 | true;
                            }
                            this.chatFrameBorderColor_.add(readStringRequireUtf82);
                            z2 = z5;
                            continue;
                        case 114:
                            this.chatBadgeUrl_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 120:
                            this.chatBadgeLength_ = codedInputStream.readInt32();
                            continue;
                        case 128:
                            this.chatBadgeHeight_ = codedInputStream.readInt32();
                            continue;
                        case 136:
                            this.emojiId_ = codedInputStream.readUInt32();
                            continue;
                        case 146:
                            this.emojiUrl_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 152:
                            this.emojiW_ = codedInputStream.readUInt32();
                            continue;
                        case 160:
                            this.emojiH_ = codedInputStream.readUInt32();
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

    private Text(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Text getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_Text_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m7643toBuilder();
    }

    public static Builder newBuilder(Text text) {
        return DEFAULT_INSTANCE.m7643toBuilder().mergeFrom(text);
    }

    public static Text parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Text parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Text parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Text) PARSER.parseFrom(byteString);
    }

    public static Text parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Text) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Text parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Text parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Text parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Text parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Text parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Text) PARSER.parseFrom(byteBuffer);
    }

    public static Text parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Text) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Text parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Text) PARSER.parseFrom(bArr);
    }

    public static Text parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Text) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<Text> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Text) {
            Text text = (Text) obj;
            return getFanClubName().equals(text.getFanClubName()) && getFanClubLevel() == text.getFanClubLevel() && getInFanClub() == text.getInFanClub() && this.fansStatus_ == text.fansStatus_ && this.liangType_ == text.liangType_ && getLiangId().equals(text.getLiangId()) && getRechargeBadge() == text.getRechargeBadge() && getChatFrame().equals(text.getChatFrame()) && getChatFrameIcon().equals(text.getChatFrameIcon()) && getChatFrameColorType() == text.getChatFrameColorType() && getChatFrameGradientType() == text.getChatFrameGradientType() && mo7636getChatFrameFrameColorList().equals(text.mo7636getChatFrameFrameColorList()) && mo7635getChatFrameBorderColorList().equals(text.mo7635getChatFrameBorderColorList()) && getChatBadgeUrl().equals(text.getChatBadgeUrl()) && getChatBadgeLength() == text.getChatBadgeLength() && getChatBadgeHeight() == text.getChatBadgeHeight() && getEmojiId() == text.getEmojiId() && getEmojiUrl().equals(text.getEmojiUrl()) && getEmojiW() == text.getEmojiW() && getEmojiH() == text.getEmojiH() && this.unknownFields.equals(text.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public int getChatBadgeHeight() {
        return this.chatBadgeHeight_;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public int getChatBadgeLength() {
        return this.chatBadgeLength_;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public String getChatBadgeUrl() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatBadgeUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public ByteString getChatBadgeUrlBytes() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatBadgeUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public String getChatFrame() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrame_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public String getChatFrameBorderColor(int i) {
        return (String) this.chatFrameBorderColor_.get(i);
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public ByteString getChatFrameBorderColorBytes(int i) {
        return this.chatFrameBorderColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public int getChatFrameBorderColorCount() {
        return this.chatFrameBorderColor_.size();
    }

    @Override // cn.irisgw.live.TextOrBuilder
    /* renamed from: getChatFrameBorderColorList */
    public ProtocolStringList mo7635getChatFrameBorderColorList() {
        return this.chatFrameBorderColor_;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public ByteString getChatFrameBytes() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrame_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public int getChatFrameColorType() {
        return this.chatFrameColorType_;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public String getChatFrameFrameColor(int i) {
        return (String) this.chatFrameFrameColor_.get(i);
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public ByteString getChatFrameFrameColorBytes(int i) {
        return this.chatFrameFrameColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public int getChatFrameFrameColorCount() {
        return this.chatFrameFrameColor_.size();
    }

    @Override // cn.irisgw.live.TextOrBuilder
    /* renamed from: getChatFrameFrameColorList */
    public ProtocolStringList mo7636getChatFrameFrameColorList() {
        return this.chatFrameFrameColor_;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public int getChatFrameGradientType() {
        return this.chatFrameGradientType_;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public String getChatFrameIcon() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrameIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.TextOrBuilder
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
    public Text m7638getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public int getEmojiH() {
        return this.emojiH_;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public int getEmojiId() {
        return this.emojiId_;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public String getEmojiUrl() {
        Object obj = this.emojiUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.emojiUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public ByteString getEmojiUrlBytes() {
        Object obj = this.emojiUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.emojiUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public int getEmojiW() {
        return this.emojiW_;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public int getFanClubLevel() {
        return this.fanClubLevel_;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public String getFanClubName() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.fanClubName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public ByteString getFanClubNameBytes() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fanClubName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public FanStatus getFansStatus() {
        FanStatus valueOf = FanStatus.valueOf(this.fansStatus_);
        FanStatus fanStatus = valueOf;
        if (valueOf == null) {
            fanStatus = FanStatus.UNRECOGNIZED;
        }
        return fanStatus;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public int getFansStatusValue() {
        return this.fansStatus_;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public boolean getInFanClub() {
        return this.inFanClub_;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public String getLiangId() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.liangId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public ByteString getLiangIdBytes() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.liangId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public LiangType getLiangType() {
        LiangType valueOf = LiangType.valueOf(this.liangType_);
        LiangType liangType = valueOf;
        if (valueOf == null) {
            liangType = LiangType.UNRECOGNIZED;
        }
        return liangType;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public int getLiangTypeValue() {
        return this.liangType_;
    }

    public Parser<Text> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.TextOrBuilder
    public int getRechargeBadge() {
        return this.rechargeBadge_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !getFanClubNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.fanClubName_) + 0 : 0;
        int i2 = this.fanClubLevel_;
        int i3 = computeStringSize;
        if (i2 != 0) {
            i3 = computeStringSize + CodedOutputStream.computeInt32Size(2, i2);
        }
        boolean z = this.inFanClub_;
        int i4 = i3;
        if (z) {
            i4 = i3 + CodedOutputStream.computeBoolSize(3, z);
        }
        int i5 = i4;
        if (this.fansStatus_ != FanStatus.Out.getNumber()) {
            i5 = i4 + CodedOutputStream.computeEnumSize(4, this.fansStatus_);
        }
        int i6 = i5;
        if (this.liangType_ != LiangType.None.getNumber()) {
            i6 = i5 + CodedOutputStream.computeEnumSize(5, this.liangType_);
        }
        int i7 = i6;
        if (!getLiangIdBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(6, this.liangId_);
        }
        int i8 = this.rechargeBadge_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeInt32Size(7, i8);
        }
        int i10 = i9;
        if (!getChatFrameBytes().isEmpty()) {
            i10 = i9 + GeneratedMessageV3.computeStringSize(8, this.chatFrame_);
        }
        int i11 = i10;
        if (!getChatFrameIconBytes().isEmpty()) {
            i11 = i10 + GeneratedMessageV3.computeStringSize(9, this.chatFrameIcon_);
        }
        int i12 = this.chatFrameColorType_;
        int i13 = i11;
        if (i12 != 0) {
            i13 = i11 + CodedOutputStream.computeInt32Size(10, i12);
        }
        int i14 = this.chatFrameGradientType_;
        int i15 = i13;
        if (i14 != 0) {
            i15 = i13 + CodedOutputStream.computeInt32Size(11, i14);
        }
        int i16 = 0;
        for (int i17 = 0; i17 < this.chatFrameFrameColor_.size(); i17++) {
            i16 += computeStringSizeNoTag(this.chatFrameFrameColor_.getRaw(i17));
        }
        int size = mo7636getChatFrameFrameColorList().size();
        int i18 = 0;
        int i19 = 0;
        while (true) {
            int i20 = i19;
            if (i20 >= this.chatFrameBorderColor_.size()) {
                break;
            }
            i18 += computeStringSizeNoTag(this.chatFrameBorderColor_.getRaw(i20));
            i19 = i20 + 1;
        }
        int size2 = i15 + i16 + (size * 1) + i18 + (mo7635getChatFrameBorderColorList().size() * 1);
        int i21 = size2;
        if (!getChatBadgeUrlBytes().isEmpty()) {
            i21 = size2 + GeneratedMessageV3.computeStringSize(14, this.chatBadgeUrl_);
        }
        int i22 = this.chatBadgeLength_;
        int i23 = i21;
        if (i22 != 0) {
            i23 = i21 + CodedOutputStream.computeInt32Size(15, i22);
        }
        int i24 = this.chatBadgeHeight_;
        int i25 = i23;
        if (i24 != 0) {
            i25 = i23 + CodedOutputStream.computeInt32Size(16, i24);
        }
        int i26 = this.emojiId_;
        int i27 = i25;
        if (i26 != 0) {
            i27 = i25 + CodedOutputStream.computeUInt32Size(17, i26);
        }
        int i28 = i27;
        if (!getEmojiUrlBytes().isEmpty()) {
            i28 = i27 + GeneratedMessageV3.computeStringSize(18, this.emojiUrl_);
        }
        int i29 = this.emojiW_;
        int i30 = i28;
        if (i29 != 0) {
            i30 = i28 + CodedOutputStream.computeUInt32Size(19, i29);
        }
        int i31 = this.emojiH_;
        int i32 = i30;
        if (i31 != 0) {
            i32 = i30 + CodedOutputStream.computeUInt32Size(20, i31);
        }
        int serializedSize = i32 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getFanClubName().hashCode()) * 37) + 2) * 53) + getFanClubLevel()) * 37) + 3) * 53) + Internal.hashBoolean(getInFanClub())) * 37) + 4) * 53) + this.fansStatus_) * 37) + 5) * 53) + this.liangType_) * 37) + 6) * 53) + getLiangId().hashCode()) * 37) + 7) * 53) + getRechargeBadge()) * 37) + 8) * 53) + getChatFrame().hashCode()) * 37) + 9) * 53) + getChatFrameIcon().hashCode()) * 37) + 10) * 53) + getChatFrameColorType()) * 37) + 11) * 53) + getChatFrameGradientType();
        int i = hashCode;
        if (getChatFrameFrameColorCount() > 0) {
            i = (((hashCode * 37) + 12) * 53) + mo7636getChatFrameFrameColorList().hashCode();
        }
        int i2 = i;
        if (getChatFrameBorderColorCount() > 0) {
            i2 = (((i * 37) + 13) * 53) + mo7635getChatFrameBorderColorList().hashCode();
        }
        int hashCode2 = (((((((((((((((((((((((((((((i2 * 37) + 14) * 53) + getChatBadgeUrl().hashCode()) * 37) + 15) * 53) + getChatBadgeLength()) * 37) + 16) * 53) + getChatBadgeHeight()) * 37) + 17) * 53) + getEmojiId()) * 37) + 18) * 53) + getEmojiUrl().hashCode()) * 37) + 19) * 53) + getEmojiW()) * 37) + 20) * 53) + getEmojiH()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_Text_fieldAccessorTable.ensureFieldAccessorsInitialized(Text.class, Builder.class);
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
    public Builder m7641newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m7640newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Text();
    }

    /* renamed from: toBuilder */
    public Builder m7643toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i;
        if (!getFanClubNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.fanClubName_);
        }
        int i2 = this.fanClubLevel_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(2, i2);
        }
        boolean z = this.inFanClub_;
        if (z) {
            codedOutputStream.writeBool(3, z);
        }
        if (this.fansStatus_ != FanStatus.Out.getNumber()) {
            codedOutputStream.writeEnum(4, this.fansStatus_);
        }
        if (this.liangType_ != LiangType.None.getNumber()) {
            codedOutputStream.writeEnum(5, this.liangType_);
        }
        if (!getLiangIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.liangId_);
        }
        int i3 = this.rechargeBadge_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(7, i3);
        }
        if (!getChatFrameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.chatFrame_);
        }
        if (!getChatFrameIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.chatFrameIcon_);
        }
        int i4 = this.chatFrameColorType_;
        if (i4 != 0) {
            codedOutputStream.writeInt32(10, i4);
        }
        int i5 = this.chatFrameGradientType_;
        if (i5 != 0) {
            codedOutputStream.writeInt32(11, i5);
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.chatFrameFrameColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 12, this.chatFrameFrameColor_.getRaw(i7));
            i6 = i7 + 1;
        }
        for (i = 0; i < this.chatFrameBorderColor_.size(); i++) {
            GeneratedMessageV3.writeString(codedOutputStream, 13, this.chatFrameBorderColor_.getRaw(i));
        }
        if (!getChatBadgeUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 14, this.chatBadgeUrl_);
        }
        int i8 = this.chatBadgeLength_;
        if (i8 != 0) {
            codedOutputStream.writeInt32(15, i8);
        }
        int i9 = this.chatBadgeHeight_;
        if (i9 != 0) {
            codedOutputStream.writeInt32(16, i9);
        }
        int i10 = this.emojiId_;
        if (i10 != 0) {
            codedOutputStream.writeUInt32(17, i10);
        }
        if (!getEmojiUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 18, this.emojiUrl_);
        }
        int i11 = this.emojiW_;
        if (i11 != 0) {
            codedOutputStream.writeUInt32(19, i11);
        }
        int i12 = this.emojiH_;
        if (i12 != 0) {
            codedOutputStream.writeUInt32(20, i12);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
