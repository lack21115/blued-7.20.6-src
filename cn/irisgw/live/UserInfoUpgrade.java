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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserInfoUpgrade.class */
public final class UserInfoUpgrade extends GeneratedMessageV3 implements UserInfoUpgradeOrBuilder {
    public static final int AVATAR_FRAME_IMG_FIELD_NUMBER = 7;
    public static final int CAN_EMOJI_FIELD_NUMBER = 10;
    public static final int CAN_KICK_FIELD_NUMBER = 9;
    public static final int CAN_MUTE_FIELD_NUMBER = 8;
    public static final int CHAT_FRAME_BORDER_COLOR_FIELD_NUMBER = 6;
    public static final int CHAT_FRAME_COLOR_TYPE_FIELD_NUMBER = 3;
    public static final int CHAT_FRAME_FIELD_NUMBER = 1;
    public static final int CHAT_FRAME_FRAME_COLOR_FIELD_NUMBER = 5;
    public static final int CHAT_FRAME_GRADIENT_TYPE_FIELD_NUMBER = 4;
    public static final int CHAT_FRAME_ICON_FIELD_NUMBER = 2;
    private static final UserInfoUpgrade DEFAULT_INSTANCE = new UserInfoUpgrade();
    private static final Parser<UserInfoUpgrade> PARSER = new AbstractParser<UserInfoUpgrade>() { // from class: cn.irisgw.live.UserInfoUpgrade.1
        /* renamed from: parsePartialFrom */
        public UserInfoUpgrade m7881parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new UserInfoUpgrade(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int PUSH_MILLISECOND_FIELD_NUMBER = 11;
    private static final long serialVersionUID = 0;
    private volatile Object avatarFrameImg_;
    private int canEmoji_;
    private int canKick_;
    private int canMute_;
    private LazyStringList chatFrameBorderColor_;
    private int chatFrameColorType_;
    private LazyStringList chatFrameFrameColor_;
    private int chatFrameGradientType_;
    private volatile Object chatFrameIcon_;
    private volatile Object chatFrame_;
    private byte memoizedIsInitialized;
    private long pushMillisecond_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserInfoUpgrade$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserInfoUpgradeOrBuilder {
        private Object avatarFrameImg_;
        private int bitField0_;
        private int canEmoji_;
        private int canKick_;
        private int canMute_;
        private LazyStringList chatFrameBorderColor_;
        private int chatFrameColorType_;
        private LazyStringList chatFrameFrameColor_;
        private int chatFrameGradientType_;
        private Object chatFrameIcon_;
        private Object chatFrame_;
        private long pushMillisecond_;

        private Builder() {
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.avatarFrameImg_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.avatarFrameImg_ = "";
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
            return LiveConstants.internal_static_cn_irisgw_live_UserInfoUpgrade_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = UserInfoUpgrade.alwaysUseFieldBuilders;
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
                UserInfoUpgrade.checkByteStringIsUtf8(byteString);
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
                UserInfoUpgrade.checkByteStringIsUtf8(byteString);
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: addRepeatedField */
        public Builder m7883addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public UserInfoUpgrade m7885build() {
            UserInfoUpgrade m7887buildPartial = m7887buildPartial();
            if (m7887buildPartial.isInitialized()) {
                return m7887buildPartial;
            }
            throw newUninitializedMessageException(m7887buildPartial);
        }

        /* renamed from: buildPartial */
        public UserInfoUpgrade m7887buildPartial() {
            UserInfoUpgrade userInfoUpgrade = new UserInfoUpgrade(this);
            userInfoUpgrade.chatFrame_ = this.chatFrame_;
            userInfoUpgrade.chatFrameIcon_ = this.chatFrameIcon_;
            userInfoUpgrade.chatFrameColorType_ = this.chatFrameColorType_;
            userInfoUpgrade.chatFrameGradientType_ = this.chatFrameGradientType_;
            if ((this.bitField0_ & 1) != 0) {
                this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            userInfoUpgrade.chatFrameFrameColor_ = this.chatFrameFrameColor_;
            if ((this.bitField0_ & 2) != 0) {
                this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            userInfoUpgrade.chatFrameBorderColor_ = this.chatFrameBorderColor_;
            userInfoUpgrade.avatarFrameImg_ = this.avatarFrameImg_;
            userInfoUpgrade.canMute_ = this.canMute_;
            userInfoUpgrade.canKick_ = this.canKick_;
            userInfoUpgrade.canEmoji_ = this.canEmoji_;
            userInfoUpgrade.pushMillisecond_ = this.pushMillisecond_;
            onBuilt();
            return userInfoUpgrade;
        }

        /* renamed from: clear */
        public Builder m7891clear() {
            super.clear();
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameColorType_ = 0;
            this.chatFrameGradientType_ = 0;
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            this.avatarFrameImg_ = "";
            this.canMute_ = 0;
            this.canKick_ = 0;
            this.canEmoji_ = 0;
            this.pushMillisecond_ = UserInfoUpgrade.serialVersionUID;
            return this;
        }

        public Builder clearAvatarFrameImg() {
            this.avatarFrameImg_ = UserInfoUpgrade.getDefaultInstance().getAvatarFrameImg();
            onChanged();
            return this;
        }

        public Builder clearCanEmoji() {
            this.canEmoji_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCanKick() {
            this.canKick_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCanMute() {
            this.canMute_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChatFrame() {
            this.chatFrame_ = UserInfoUpgrade.getDefaultInstance().getChatFrame();
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
            this.chatFrameIcon_ = UserInfoUpgrade.getDefaultInstance().getChatFrameIcon();
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m7893clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m7896clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPushMillisecond() {
            this.pushMillisecond_ = UserInfoUpgrade.serialVersionUID;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m7902clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public String getAvatarFrameImg() {
            Object obj = this.avatarFrameImg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatarFrameImg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public ByteString getAvatarFrameImgBytes() {
            Object obj = this.avatarFrameImg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatarFrameImg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public int getCanEmoji() {
            return this.canEmoji_;
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public int getCanKick() {
            return this.canKick_;
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public int getCanMute() {
            return this.canMute_;
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public String getChatFrame() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrame_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public String getChatFrameBorderColor(int i) {
            return (String) this.chatFrameBorderColor_.get(i);
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public ByteString getChatFrameBorderColorBytes(int i) {
            return this.chatFrameBorderColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public int getChatFrameBorderColorCount() {
            return this.chatFrameBorderColor_.size();
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        /* renamed from: getChatFrameBorderColorList */
        public ProtocolStringList mo7872getChatFrameBorderColorList() {
            return this.chatFrameBorderColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public ByteString getChatFrameBytes() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrame_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public int getChatFrameColorType() {
            return this.chatFrameColorType_;
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public String getChatFrameFrameColor(int i) {
            return (String) this.chatFrameFrameColor_.get(i);
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public ByteString getChatFrameFrameColorBytes(int i) {
            return this.chatFrameFrameColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public int getChatFrameFrameColorCount() {
            return this.chatFrameFrameColor_.size();
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        /* renamed from: getChatFrameFrameColorList */
        public ProtocolStringList mo7873getChatFrameFrameColorList() {
            return this.chatFrameFrameColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public int getChatFrameGradientType() {
            return this.chatFrameGradientType_;
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public String getChatFrameIcon() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrameIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
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
        public UserInfoUpgrade m7904getDefaultInstanceForType() {
            return UserInfoUpgrade.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_UserInfoUpgrade_descriptor;
        }

        @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
        public long getPushMillisecond() {
            return this.pushMillisecond_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_UserInfoUpgrade_fieldAccessorTable.ensureFieldAccessorsInitialized(UserInfoUpgrade.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(UserInfoUpgrade userInfoUpgrade) {
            if (userInfoUpgrade == UserInfoUpgrade.getDefaultInstance()) {
                return this;
            }
            if (!userInfoUpgrade.getChatFrame().isEmpty()) {
                this.chatFrame_ = userInfoUpgrade.chatFrame_;
                onChanged();
            }
            if (!userInfoUpgrade.getChatFrameIcon().isEmpty()) {
                this.chatFrameIcon_ = userInfoUpgrade.chatFrameIcon_;
                onChanged();
            }
            if (userInfoUpgrade.getChatFrameColorType() != 0) {
                setChatFrameColorType(userInfoUpgrade.getChatFrameColorType());
            }
            if (userInfoUpgrade.getChatFrameGradientType() != 0) {
                setChatFrameGradientType(userInfoUpgrade.getChatFrameGradientType());
            }
            if (!userInfoUpgrade.chatFrameFrameColor_.isEmpty()) {
                if (this.chatFrameFrameColor_.isEmpty()) {
                    this.chatFrameFrameColor_ = userInfoUpgrade.chatFrameFrameColor_;
                    this.bitField0_ &= -2;
                } else {
                    ensureChatFrameFrameColorIsMutable();
                    this.chatFrameFrameColor_.addAll(userInfoUpgrade.chatFrameFrameColor_);
                }
                onChanged();
            }
            if (!userInfoUpgrade.chatFrameBorderColor_.isEmpty()) {
                if (this.chatFrameBorderColor_.isEmpty()) {
                    this.chatFrameBorderColor_ = userInfoUpgrade.chatFrameBorderColor_;
                    this.bitField0_ &= -3;
                } else {
                    ensureChatFrameBorderColorIsMutable();
                    this.chatFrameBorderColor_.addAll(userInfoUpgrade.chatFrameBorderColor_);
                }
                onChanged();
            }
            if (!userInfoUpgrade.getAvatarFrameImg().isEmpty()) {
                this.avatarFrameImg_ = userInfoUpgrade.avatarFrameImg_;
                onChanged();
            }
            if (userInfoUpgrade.getCanMute() != 0) {
                setCanMute(userInfoUpgrade.getCanMute());
            }
            if (userInfoUpgrade.getCanKick() != 0) {
                setCanKick(userInfoUpgrade.getCanKick());
            }
            if (userInfoUpgrade.getCanEmoji() != 0) {
                setCanEmoji(userInfoUpgrade.getCanEmoji());
            }
            if (userInfoUpgrade.getPushMillisecond() != UserInfoUpgrade.serialVersionUID) {
                setPushMillisecond(userInfoUpgrade.getPushMillisecond());
            }
            m7913mergeUnknownFields(userInfoUpgrade.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.UserInfoUpgrade.Builder m7910mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.UserInfoUpgrade.access$1600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.UserInfoUpgrade r0 = (cn.irisgw.live.UserInfoUpgrade) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.UserInfoUpgrade$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.UserInfoUpgrade r0 = (cn.irisgw.live.UserInfoUpgrade) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.UserInfoUpgrade$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.UserInfoUpgrade.Builder.m7910mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.UserInfoUpgrade$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m7909mergeFrom(Message message) {
            if (message instanceof UserInfoUpgrade) {
                return mergeFrom((UserInfoUpgrade) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m7913mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setAvatarFrameImg(String str) {
            if (str != null) {
                this.avatarFrameImg_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAvatarFrameImgBytes(ByteString byteString) {
            if (byteString != null) {
                UserInfoUpgrade.checkByteStringIsUtf8(byteString);
                this.avatarFrameImg_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setCanEmoji(int i) {
            this.canEmoji_ = i;
            onChanged();
            return this;
        }

        public Builder setCanKick(int i) {
            this.canKick_ = i;
            onChanged();
            return this;
        }

        public Builder setCanMute(int i) {
            this.canMute_ = i;
            onChanged();
            return this;
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
                UserInfoUpgrade.checkByteStringIsUtf8(byteString);
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
                UserInfoUpgrade.checkByteStringIsUtf8(byteString);
                this.chatFrameIcon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setField */
        public Builder m7915setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setPushMillisecond(long j) {
            this.pushMillisecond_ = j;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m7917setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m7919setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private UserInfoUpgrade() {
        this.memoizedIsInitialized = (byte) -1;
        this.chatFrame_ = "";
        this.chatFrameIcon_ = "";
        this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
        this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
        this.avatarFrameImg_ = "";
    }

    private UserInfoUpgrade(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.chatFrame_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 18:
                            this.chatFrameIcon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 24:
                            this.chatFrameColorType_ = codedInputStream.readInt32();
                            continue;
                        case 32:
                            this.chatFrameGradientType_ = codedInputStream.readInt32();
                            continue;
                        case 42:
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameFrameColor_ = new LazyStringArrayList();
                                z4 = z2 | true;
                            }
                            this.chatFrameFrameColor_.add(readStringRequireUtf8);
                            z2 = z4;
                            continue;
                        case 50:
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameBorderColor_ = new LazyStringArrayList();
                                z5 = z2 | true;
                            }
                            this.chatFrameBorderColor_.add(readStringRequireUtf82);
                            z2 = z5;
                            continue;
                        case 58:
                            this.avatarFrameImg_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 64:
                            this.canMute_ = codedInputStream.readInt32();
                            continue;
                        case 72:
                            this.canKick_ = codedInputStream.readInt32();
                            continue;
                        case 80:
                            this.canEmoji_ = codedInputStream.readInt32();
                            continue;
                        case 88:
                            this.pushMillisecond_ = codedInputStream.readUInt64();
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

    private UserInfoUpgrade(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static UserInfoUpgrade getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_UserInfoUpgrade_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m7880toBuilder();
    }

    public static Builder newBuilder(UserInfoUpgrade userInfoUpgrade) {
        return DEFAULT_INSTANCE.m7880toBuilder().mergeFrom(userInfoUpgrade);
    }

    public static UserInfoUpgrade parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static UserInfoUpgrade parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static UserInfoUpgrade parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (UserInfoUpgrade) PARSER.parseFrom(byteString);
    }

    public static UserInfoUpgrade parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UserInfoUpgrade) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static UserInfoUpgrade parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static UserInfoUpgrade parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static UserInfoUpgrade parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static UserInfoUpgrade parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static UserInfoUpgrade parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (UserInfoUpgrade) PARSER.parseFrom(byteBuffer);
    }

    public static UserInfoUpgrade parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UserInfoUpgrade) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static UserInfoUpgrade parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (UserInfoUpgrade) PARSER.parseFrom(bArr);
    }

    public static UserInfoUpgrade parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UserInfoUpgrade) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<UserInfoUpgrade> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UserInfoUpgrade) {
            UserInfoUpgrade userInfoUpgrade = (UserInfoUpgrade) obj;
            return getChatFrame().equals(userInfoUpgrade.getChatFrame()) && getChatFrameIcon().equals(userInfoUpgrade.getChatFrameIcon()) && getChatFrameColorType() == userInfoUpgrade.getChatFrameColorType() && getChatFrameGradientType() == userInfoUpgrade.getChatFrameGradientType() && mo7873getChatFrameFrameColorList().equals(userInfoUpgrade.mo7873getChatFrameFrameColorList()) && mo7872getChatFrameBorderColorList().equals(userInfoUpgrade.mo7872getChatFrameBorderColorList()) && getAvatarFrameImg().equals(userInfoUpgrade.getAvatarFrameImg()) && getCanMute() == userInfoUpgrade.getCanMute() && getCanKick() == userInfoUpgrade.getCanKick() && getCanEmoji() == userInfoUpgrade.getCanEmoji() && getPushMillisecond() == userInfoUpgrade.getPushMillisecond() && this.unknownFields.equals(userInfoUpgrade.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public String getAvatarFrameImg() {
        Object obj = this.avatarFrameImg_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatarFrameImg_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public ByteString getAvatarFrameImgBytes() {
        Object obj = this.avatarFrameImg_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.avatarFrameImg_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public int getCanEmoji() {
        return this.canEmoji_;
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public int getCanKick() {
        return this.canKick_;
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public int getCanMute() {
        return this.canMute_;
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public String getChatFrame() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrame_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public String getChatFrameBorderColor(int i) {
        return (String) this.chatFrameBorderColor_.get(i);
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public ByteString getChatFrameBorderColorBytes(int i) {
        return this.chatFrameBorderColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public int getChatFrameBorderColorCount() {
        return this.chatFrameBorderColor_.size();
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    /* renamed from: getChatFrameBorderColorList */
    public ProtocolStringList mo7872getChatFrameBorderColorList() {
        return this.chatFrameBorderColor_;
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public ByteString getChatFrameBytes() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrame_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public int getChatFrameColorType() {
        return this.chatFrameColorType_;
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public String getChatFrameFrameColor(int i) {
        return (String) this.chatFrameFrameColor_.get(i);
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public ByteString getChatFrameFrameColorBytes(int i) {
        return this.chatFrameFrameColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public int getChatFrameFrameColorCount() {
        return this.chatFrameFrameColor_.size();
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    /* renamed from: getChatFrameFrameColorList */
    public ProtocolStringList mo7873getChatFrameFrameColorList() {
        return this.chatFrameFrameColor_;
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public int getChatFrameGradientType() {
        return this.chatFrameGradientType_;
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public String getChatFrameIcon() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrameIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
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
    public UserInfoUpgrade m7875getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<UserInfoUpgrade> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.UserInfoUpgradeOrBuilder
    public long getPushMillisecond() {
        return this.pushMillisecond_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !getChatFrameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.chatFrame_) + 0 : 0;
        int i2 = computeStringSize;
        if (!getChatFrameIconBytes().isEmpty()) {
            i2 = computeStringSize + GeneratedMessageV3.computeStringSize(2, this.chatFrameIcon_);
        }
        int i3 = this.chatFrameColorType_;
        int i4 = i2;
        if (i3 != 0) {
            i4 = i2 + CodedOutputStream.computeInt32Size(3, i3);
        }
        int i5 = this.chatFrameGradientType_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeInt32Size(4, i5);
        }
        int i7 = 0;
        for (int i8 = 0; i8 < this.chatFrameFrameColor_.size(); i8++) {
            i7 += computeStringSizeNoTag(this.chatFrameFrameColor_.getRaw(i8));
        }
        int size = mo7873getChatFrameFrameColorList().size();
        int i9 = 0;
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= this.chatFrameBorderColor_.size()) {
                break;
            }
            i9 += computeStringSizeNoTag(this.chatFrameBorderColor_.getRaw(i11));
            i10 = i11 + 1;
        }
        int size2 = i6 + i7 + (size * 1) + i9 + (mo7872getChatFrameBorderColorList().size() * 1);
        int i12 = size2;
        if (!getAvatarFrameImgBytes().isEmpty()) {
            i12 = size2 + GeneratedMessageV3.computeStringSize(7, this.avatarFrameImg_);
        }
        int i13 = this.canMute_;
        int i14 = i12;
        if (i13 != 0) {
            i14 = i12 + CodedOutputStream.computeInt32Size(8, i13);
        }
        int i15 = this.canKick_;
        int i16 = i14;
        if (i15 != 0) {
            i16 = i14 + CodedOutputStream.computeInt32Size(9, i15);
        }
        int i17 = this.canEmoji_;
        int i18 = i16;
        if (i17 != 0) {
            i18 = i16 + CodedOutputStream.computeInt32Size(10, i17);
        }
        long j = this.pushMillisecond_;
        int i19 = i18;
        if (j != serialVersionUID) {
            i19 = i18 + CodedOutputStream.computeUInt64Size(11, j);
        }
        int serializedSize = i19 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getChatFrame().hashCode()) * 37) + 2) * 53) + getChatFrameIcon().hashCode()) * 37) + 3) * 53) + getChatFrameColorType()) * 37) + 4) * 53) + getChatFrameGradientType();
        int i = hashCode;
        if (getChatFrameFrameColorCount() > 0) {
            i = (((hashCode * 37) + 5) * 53) + mo7873getChatFrameFrameColorList().hashCode();
        }
        int i2 = i;
        if (getChatFrameBorderColorCount() > 0) {
            i2 = (((i * 37) + 6) * 53) + mo7872getChatFrameBorderColorList().hashCode();
        }
        int hashCode2 = (((((((((((((((((((((i2 * 37) + 7) * 53) + getAvatarFrameImg().hashCode()) * 37) + 8) * 53) + getCanMute()) * 37) + 9) * 53) + getCanKick()) * 37) + 10) * 53) + getCanEmoji()) * 37) + 11) * 53) + Internal.hashLong(getPushMillisecond())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_UserInfoUpgrade_fieldAccessorTable.ensureFieldAccessorsInitialized(UserInfoUpgrade.class, Builder.class);
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
    public Builder m7878newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m7877newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new UserInfoUpgrade();
    }

    /* renamed from: toBuilder */
    public Builder m7880toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i;
        if (!getChatFrameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.chatFrame_);
        }
        if (!getChatFrameIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.chatFrameIcon_);
        }
        int i2 = this.chatFrameColorType_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(3, i2);
        }
        int i3 = this.chatFrameGradientType_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(4, i3);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.chatFrameFrameColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.chatFrameFrameColor_.getRaw(i5));
            i4 = i5 + 1;
        }
        for (i = 0; i < this.chatFrameBorderColor_.size(); i++) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.chatFrameBorderColor_.getRaw(i));
        }
        if (!getAvatarFrameImgBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.avatarFrameImg_);
        }
        int i6 = this.canMute_;
        if (i6 != 0) {
            codedOutputStream.writeInt32(8, i6);
        }
        int i7 = this.canKick_;
        if (i7 != 0) {
            codedOutputStream.writeInt32(9, i7);
        }
        int i8 = this.canEmoji_;
        if (i8 != 0) {
            codedOutputStream.writeInt32(10, i8);
        }
        long j = this.pushMillisecond_;
        if (j != serialVersionUID) {
            codedOutputStream.writeUInt64(11, j);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
