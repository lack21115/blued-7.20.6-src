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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/Barrage.class */
public final class Barrage extends GeneratedMessageV3 implements BarrageOrBuilder {
    public static final int CHAT_BADGE_HEIGHT_FIELD_NUMBER = 16;
    public static final int CHAT_BADGE_LENGTH_FIELD_NUMBER = 15;
    public static final int CHAT_BADGE_URL_FIELD_NUMBER = 14;
    public static final int CHAT_FRAME_BORDER_COLOR_FIELD_NUMBER = 13;
    public static final int CHAT_FRAME_COLOR_TYPE_FIELD_NUMBER = 10;
    public static final int CHAT_FRAME_FIELD_NUMBER = 8;
    public static final int CHAT_FRAME_FRAME_COLOR_FIELD_NUMBER = 12;
    public static final int CHAT_FRAME_GRADIENT_TYPE_FIELD_NUMBER = 11;
    public static final int CHAT_FRAME_ICON_FIELD_NUMBER = 9;
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
    private int fanClubLevel_;
    private volatile Object fanClubName_;
    private int fansStatus_;
    private boolean inFanClub_;
    private volatile Object liangId_;
    private int liangType_;
    private byte memoizedIsInitialized;
    private int rechargeBadge_;
    private static final Barrage DEFAULT_INSTANCE = new Barrage();
    private static final Parser<Barrage> PARSER = new AbstractParser<Barrage>() { // from class: cn.irisgw.live.Barrage.1
        @Override // com.google.protobuf.Parser
        public Barrage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Barrage(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/Barrage$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BarrageOrBuilder {
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
            return LiveConstants.internal_static_cn_irisgw_live_Barrage_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = Barrage.alwaysUseFieldBuilders;
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
                Barrage.checkByteStringIsUtf8(byteString);
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
                Barrage.checkByteStringIsUtf8(byteString);
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
        public Barrage build() {
            Barrage buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Barrage buildPartial() {
            Barrage barrage = new Barrage(this);
            barrage.fanClubName_ = this.fanClubName_;
            barrage.fanClubLevel_ = this.fanClubLevel_;
            barrage.inFanClub_ = this.inFanClub_;
            barrage.fansStatus_ = this.fansStatus_;
            barrage.liangType_ = this.liangType_;
            barrage.liangId_ = this.liangId_;
            barrage.rechargeBadge_ = this.rechargeBadge_;
            barrage.chatFrame_ = this.chatFrame_;
            barrage.chatFrameIcon_ = this.chatFrameIcon_;
            barrage.chatFrameColorType_ = this.chatFrameColorType_;
            barrage.chatFrameGradientType_ = this.chatFrameGradientType_;
            if ((this.bitField0_ & 1) != 0) {
                this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            barrage.chatFrameFrameColor_ = this.chatFrameFrameColor_;
            if ((this.bitField0_ & 2) != 0) {
                this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            barrage.chatFrameBorderColor_ = this.chatFrameBorderColor_;
            barrage.chatBadgeUrl_ = this.chatBadgeUrl_;
            barrage.chatBadgeLength_ = this.chatBadgeLength_;
            barrage.chatBadgeHeight_ = this.chatBadgeHeight_;
            onBuilt();
            return barrage;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
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
            this.chatBadgeUrl_ = Barrage.getDefaultInstance().getChatBadgeUrl();
            onChanged();
            return this;
        }

        public Builder clearChatFrame() {
            this.chatFrame_ = Barrage.getDefaultInstance().getChatFrame();
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
            this.chatFrameIcon_ = Barrage.getDefaultInstance().getChatFrameIcon();
            onChanged();
            return this;
        }

        public Builder clearFanClubLevel() {
            this.fanClubLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearFanClubName() {
            this.fanClubName_ = Barrage.getDefaultInstance().getFanClubName();
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

        public Builder clearInFanClub() {
            this.inFanClub_ = false;
            onChanged();
            return this;
        }

        public Builder clearLiangId() {
            this.liangId_ = Barrage.getDefaultInstance().getLiangId();
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public int getChatBadgeHeight() {
            return this.chatBadgeHeight_;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public int getChatBadgeLength() {
            return this.chatBadgeLength_;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public String getChatBadgeUrl() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatBadgeUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public ByteString getChatBadgeUrlBytes() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatBadgeUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public String getChatFrame() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrame_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public String getChatFrameBorderColor(int i) {
            return this.chatFrameBorderColor_.get(i);
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public ByteString getChatFrameBorderColorBytes(int i) {
            return this.chatFrameBorderColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public int getChatFrameBorderColorCount() {
            return this.chatFrameBorderColor_.size();
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public ProtocolStringList getChatFrameBorderColorList() {
            return this.chatFrameBorderColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public ByteString getChatFrameBytes() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrame_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public int getChatFrameColorType() {
            return this.chatFrameColorType_;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public String getChatFrameFrameColor(int i) {
            return this.chatFrameFrameColor_.get(i);
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public ByteString getChatFrameFrameColorBytes(int i) {
            return this.chatFrameFrameColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public int getChatFrameFrameColorCount() {
            return this.chatFrameFrameColor_.size();
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public ProtocolStringList getChatFrameFrameColorList() {
            return this.chatFrameFrameColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public int getChatFrameGradientType() {
            return this.chatFrameGradientType_;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public String getChatFrameIcon() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrameIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
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
        public Barrage getDefaultInstanceForType() {
            return Barrage.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_Barrage_descriptor;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public int getFanClubLevel() {
            return this.fanClubLevel_;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public String getFanClubName() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fanClubName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public ByteString getFanClubNameBytes() {
            Object obj = this.fanClubName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fanClubName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public FanStatus getFansStatus() {
            FanStatus valueOf = FanStatus.valueOf(this.fansStatus_);
            FanStatus fanStatus = valueOf;
            if (valueOf == null) {
                fanStatus = FanStatus.UNRECOGNIZED;
            }
            return fanStatus;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public int getFansStatusValue() {
            return this.fansStatus_;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public boolean getInFanClub() {
            return this.inFanClub_;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public String getLiangId() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liangId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public ByteString getLiangIdBytes() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liangId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public LiangType getLiangType() {
            LiangType valueOf = LiangType.valueOf(this.liangType_);
            LiangType liangType = valueOf;
            if (valueOf == null) {
                liangType = LiangType.UNRECOGNIZED;
            }
            return liangType;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public int getLiangTypeValue() {
            return this.liangType_;
        }

        @Override // cn.irisgw.live.BarrageOrBuilder
        public int getRechargeBadge() {
            return this.rechargeBadge_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_Barrage_fieldAccessorTable.ensureFieldAccessorsInitialized(Barrage.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(Barrage barrage) {
            if (barrage == Barrage.getDefaultInstance()) {
                return this;
            }
            if (!barrage.getFanClubName().isEmpty()) {
                this.fanClubName_ = barrage.fanClubName_;
                onChanged();
            }
            if (barrage.getFanClubLevel() != 0) {
                setFanClubLevel(barrage.getFanClubLevel());
            }
            if (barrage.getInFanClub()) {
                setInFanClub(barrage.getInFanClub());
            }
            if (barrage.fansStatus_ != 0) {
                setFansStatusValue(barrage.getFansStatusValue());
            }
            if (barrage.liangType_ != 0) {
                setLiangTypeValue(barrage.getLiangTypeValue());
            }
            if (!barrage.getLiangId().isEmpty()) {
                this.liangId_ = barrage.liangId_;
                onChanged();
            }
            if (barrage.getRechargeBadge() != 0) {
                setRechargeBadge(barrage.getRechargeBadge());
            }
            if (!barrage.getChatFrame().isEmpty()) {
                this.chatFrame_ = barrage.chatFrame_;
                onChanged();
            }
            if (!barrage.getChatFrameIcon().isEmpty()) {
                this.chatFrameIcon_ = barrage.chatFrameIcon_;
                onChanged();
            }
            if (barrage.getChatFrameColorType() != 0) {
                setChatFrameColorType(barrage.getChatFrameColorType());
            }
            if (barrage.getChatFrameGradientType() != 0) {
                setChatFrameGradientType(barrage.getChatFrameGradientType());
            }
            if (!barrage.chatFrameFrameColor_.isEmpty()) {
                if (this.chatFrameFrameColor_.isEmpty()) {
                    this.chatFrameFrameColor_ = barrage.chatFrameFrameColor_;
                    this.bitField0_ &= -2;
                } else {
                    ensureChatFrameFrameColorIsMutable();
                    this.chatFrameFrameColor_.addAll(barrage.chatFrameFrameColor_);
                }
                onChanged();
            }
            if (!barrage.chatFrameBorderColor_.isEmpty()) {
                if (this.chatFrameBorderColor_.isEmpty()) {
                    this.chatFrameBorderColor_ = barrage.chatFrameBorderColor_;
                    this.bitField0_ &= -3;
                } else {
                    ensureChatFrameBorderColorIsMutable();
                    this.chatFrameBorderColor_.addAll(barrage.chatFrameBorderColor_);
                }
                onChanged();
            }
            if (!barrage.getChatBadgeUrl().isEmpty()) {
                this.chatBadgeUrl_ = barrage.chatBadgeUrl_;
                onChanged();
            }
            if (barrage.getChatBadgeLength() != 0) {
                setChatBadgeLength(barrage.getChatBadgeLength());
            }
            if (barrage.getChatBadgeHeight() != 0) {
                setChatBadgeHeight(barrage.getChatBadgeHeight());
            }
            mergeUnknownFields(barrage.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.Barrage.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.Barrage.access$2100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.Barrage r0 = (cn.irisgw.live.Barrage) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.Barrage$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.Barrage r0 = (cn.irisgw.live.Barrage) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.Barrage$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.Barrage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.Barrage$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Barrage) {
                return mergeFrom((Barrage) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
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
                Barrage.checkByteStringIsUtf8(byteString);
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
                Barrage.checkByteStringIsUtf8(byteString);
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
                Barrage.checkByteStringIsUtf8(byteString);
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
                Barrage.checkByteStringIsUtf8(byteString);
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
                Barrage.checkByteStringIsUtf8(byteString);
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private Barrage() {
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
    }

    private Barrage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.chatFrameFrameColor_.add((LazyStringList) readStringRequireUtf8);
                            z2 = z4;
                            continue;
                        case 106:
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameBorderColor_ = new LazyStringArrayList();
                                z5 = z2 | true;
                            }
                            this.chatFrameBorderColor_.add((LazyStringList) readStringRequireUtf82);
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

    private Barrage(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Barrage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_Barrage_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Barrage barrage) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(barrage);
    }

    public static Barrage parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Barrage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Barrage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Barrage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Barrage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Barrage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Barrage parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Barrage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Barrage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Barrage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Barrage parseFrom(InputStream inputStream) throws IOException {
        return (Barrage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Barrage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Barrage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Barrage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Barrage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Barrage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Barrage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<Barrage> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Barrage) {
            Barrage barrage = (Barrage) obj;
            return getFanClubName().equals(barrage.getFanClubName()) && getFanClubLevel() == barrage.getFanClubLevel() && getInFanClub() == barrage.getInFanClub() && this.fansStatus_ == barrage.fansStatus_ && this.liangType_ == barrage.liangType_ && getLiangId().equals(barrage.getLiangId()) && getRechargeBadge() == barrage.getRechargeBadge() && getChatFrame().equals(barrage.getChatFrame()) && getChatFrameIcon().equals(barrage.getChatFrameIcon()) && getChatFrameColorType() == barrage.getChatFrameColorType() && getChatFrameGradientType() == barrage.getChatFrameGradientType() && getChatFrameFrameColorList().equals(barrage.getChatFrameFrameColorList()) && getChatFrameBorderColorList().equals(barrage.getChatFrameBorderColorList()) && getChatBadgeUrl().equals(barrage.getChatBadgeUrl()) && getChatBadgeLength() == barrage.getChatBadgeLength() && getChatBadgeHeight() == barrage.getChatBadgeHeight() && this.unknownFields.equals(barrage.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public int getChatBadgeHeight() {
        return this.chatBadgeHeight_;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public int getChatBadgeLength() {
        return this.chatBadgeLength_;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public String getChatBadgeUrl() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatBadgeUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public ByteString getChatBadgeUrlBytes() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatBadgeUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public String getChatFrame() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrame_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public String getChatFrameBorderColor(int i) {
        return this.chatFrameBorderColor_.get(i);
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public ByteString getChatFrameBorderColorBytes(int i) {
        return this.chatFrameBorderColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public int getChatFrameBorderColorCount() {
        return this.chatFrameBorderColor_.size();
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public ProtocolStringList getChatFrameBorderColorList() {
        return this.chatFrameBorderColor_;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public ByteString getChatFrameBytes() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrame_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public int getChatFrameColorType() {
        return this.chatFrameColorType_;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public String getChatFrameFrameColor(int i) {
        return this.chatFrameFrameColor_.get(i);
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public ByteString getChatFrameFrameColorBytes(int i) {
        return this.chatFrameFrameColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public int getChatFrameFrameColorCount() {
        return this.chatFrameFrameColor_.size();
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public ProtocolStringList getChatFrameFrameColorList() {
        return this.chatFrameFrameColor_;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public int getChatFrameGradientType() {
        return this.chatFrameGradientType_;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public String getChatFrameIcon() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrameIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
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
    public Barrage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public int getFanClubLevel() {
        return this.fanClubLevel_;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public String getFanClubName() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.fanClubName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public ByteString getFanClubNameBytes() {
        Object obj = this.fanClubName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fanClubName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public FanStatus getFansStatus() {
        FanStatus valueOf = FanStatus.valueOf(this.fansStatus_);
        FanStatus fanStatus = valueOf;
        if (valueOf == null) {
            fanStatus = FanStatus.UNRECOGNIZED;
        }
        return fanStatus;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public int getFansStatusValue() {
        return this.fansStatus_;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public boolean getInFanClub() {
        return this.inFanClub_;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public String getLiangId() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.liangId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public ByteString getLiangIdBytes() {
        Object obj = this.liangId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.liangId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public LiangType getLiangType() {
        LiangType valueOf = LiangType.valueOf(this.liangType_);
        LiangType liangType = valueOf;
        if (valueOf == null) {
            liangType = LiangType.UNRECOGNIZED;
        }
        return liangType;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public int getLiangTypeValue() {
        return this.liangType_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Barrage> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.BarrageOrBuilder
    public int getRechargeBadge() {
        return this.rechargeBadge_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
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
        int size = getChatFrameFrameColorList().size();
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
        int size2 = i15 + i16 + (size * 1) + i18 + (getChatFrameBorderColorList().size() * 1);
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
        int serializedSize = i25 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getFanClubName().hashCode()) * 37) + 2) * 53) + getFanClubLevel()) * 37) + 3) * 53) + Internal.hashBoolean(getInFanClub())) * 37) + 4) * 53) + this.fansStatus_) * 37) + 5) * 53) + this.liangType_) * 37) + 6) * 53) + getLiangId().hashCode()) * 37) + 7) * 53) + getRechargeBadge()) * 37) + 8) * 53) + getChatFrame().hashCode()) * 37) + 9) * 53) + getChatFrameIcon().hashCode()) * 37) + 10) * 53) + getChatFrameColorType()) * 37) + 11) * 53) + getChatFrameGradientType();
        int i = hashCode;
        if (getChatFrameFrameColorCount() > 0) {
            i = (((hashCode * 37) + 12) * 53) + getChatFrameFrameColorList().hashCode();
        }
        int i2 = i;
        if (getChatFrameBorderColorCount() > 0) {
            i2 = (((i * 37) + 13) * 53) + getChatFrameBorderColorList().hashCode();
        }
        int hashCode2 = (((((((((((((i2 * 37) + 14) * 53) + getChatBadgeUrl().hashCode()) * 37) + 15) * 53) + getChatBadgeLength()) * 37) + 16) * 53) + getChatBadgeHeight()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_Barrage_fieldAccessorTable.ensureFieldAccessorsInitialized(Barrage.class, Builder.class);
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
        return new Barrage();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
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
        this.unknownFields.writeTo(codedOutputStream);
    }
}
