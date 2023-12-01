package cn.irisgw.live;

import cn.irisgw.live.UserProfile;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveMessage.class */
public final class LiveMessage extends GeneratedMessageV3 implements LiveMessageOrBuilder {
    public static final int CONTENTS_FIELD_NUMBER = 6;
    public static final int EXTRA_FIELD_NUMBER = 8;
    public static final int FROM_FIELD_NUMBER = 4;
    public static final int LIVE_ID_FIELD_NUMBER = 2;
    public static final int MSG_ID_FIELD_NUMBER = 1;
    public static final int PROFILE_FIELD_NUMBER = 7;
    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private volatile Object contents_;
    private Any extra_;
    private int from_;
    private volatile Object liveId_;
    private byte memoizedIsInitialized;
    private long msgId_;
    private UserProfile profile_;
    private long timestamp_;
    private int type_;
    private static final LiveMessage DEFAULT_INSTANCE = new LiveMessage();
    private static final Parser<LiveMessage> PARSER = new AbstractParser<LiveMessage>() { // from class: cn.irisgw.live.LiveMessage.1
        @Override // com.google.protobuf.Parser
        public LiveMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LiveMessage(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveMessage$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveMessageOrBuilder {
        private Object contents_;
        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> extraBuilder_;
        private Any extra_;
        private int from_;
        private Object liveId_;
        private long msgId_;
        private SingleFieldBuilderV3<UserProfile, UserProfile.Builder, UserProfileOrBuilder> profileBuilder_;
        private UserProfile profile_;
        private long timestamp_;
        private int type_;

        private Builder() {
            this.liveId_ = "";
            this.type_ = 0;
            this.contents_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.liveId_ = "";
            this.type_ = 0;
            this.contents_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveMessage_descriptor;
        }

        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getExtraFieldBuilder() {
            if (this.extraBuilder_ == null) {
                this.extraBuilder_ = new SingleFieldBuilderV3<>(getExtra(), getParentForChildren(), isClean());
                this.extra_ = null;
            }
            return this.extraBuilder_;
        }

        private SingleFieldBuilderV3<UserProfile, UserProfile.Builder, UserProfileOrBuilder> getProfileFieldBuilder() {
            if (this.profileBuilder_ == null) {
                this.profileBuilder_ = new SingleFieldBuilderV3<>(getProfile(), getParentForChildren(), isClean());
                this.profile_ = null;
            }
            return this.profileBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LiveMessage.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LiveMessage build() {
            LiveMessage buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LiveMessage buildPartial() {
            LiveMessage liveMessage = new LiveMessage(this);
            liveMessage.msgId_ = this.msgId_;
            liveMessage.liveId_ = this.liveId_;
            liveMessage.timestamp_ = this.timestamp_;
            liveMessage.from_ = this.from_;
            liveMessage.type_ = this.type_;
            liveMessage.contents_ = this.contents_;
            SingleFieldBuilderV3<UserProfile, UserProfile.Builder, UserProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
            if (singleFieldBuilderV3 == null) {
                liveMessage.profile_ = this.profile_;
            } else {
                liveMessage.profile_ = singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV32 = this.extraBuilder_;
            if (singleFieldBuilderV32 == null) {
                liveMessage.extra_ = this.extra_;
            } else {
                liveMessage.extra_ = singleFieldBuilderV32.build();
            }
            onBuilt();
            return liveMessage;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.msgId_ = 0L;
            this.liveId_ = "";
            this.timestamp_ = 0L;
            this.from_ = 0;
            this.type_ = 0;
            this.contents_ = "";
            if (this.profileBuilder_ == null) {
                this.profile_ = null;
            } else {
                this.profile_ = null;
                this.profileBuilder_ = null;
            }
            if (this.extraBuilder_ == null) {
                this.extra_ = null;
                return this;
            }
            this.extra_ = null;
            this.extraBuilder_ = null;
            return this;
        }

        public Builder clearContents() {
            this.contents_ = LiveMessage.getDefaultInstance().getContents();
            onChanged();
            return this;
        }

        public Builder clearExtra() {
            if (this.extraBuilder_ == null) {
                this.extra_ = null;
                onChanged();
                return this;
            }
            this.extra_ = null;
            this.extraBuilder_ = null;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearFrom() {
            this.from_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLiveId() {
            this.liveId_ = LiveMessage.getDefaultInstance().getLiveId();
            onChanged();
            return this;
        }

        public Builder clearMsgId() {
            this.msgId_ = 0L;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearProfile() {
            if (this.profileBuilder_ == null) {
                this.profile_ = null;
                onChanged();
                return this;
            }
            this.profile_ = null;
            this.profileBuilder_ = null;
            return this;
        }

        public Builder clearTimestamp() {
            this.timestamp_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public String getContents() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.contents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public ByteString getContentsBytes() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.contents_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LiveMessage getDefaultInstanceForType() {
            return LiveMessage.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveMessage_descriptor;
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public Any getExtra() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
            if (singleFieldBuilderV3 == null) {
                Any any = this.extra_;
                Any any2 = any;
                if (any == null) {
                    any2 = Any.getDefaultInstance();
                }
                return any2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Any.Builder getExtraBuilder() {
            onChanged();
            return getExtraFieldBuilder().getBuilder();
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public AnyOrBuilder getExtraOrBuilder() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Any any = this.extra_;
            Any any2 = any;
            if (any == null) {
                any2 = Any.getDefaultInstance();
            }
            return any2;
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public int getFrom() {
            return this.from_;
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public String getLiveId() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liveId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public ByteString getLiveIdBytes() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liveId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public long getMsgId() {
            return this.msgId_;
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public UserProfile getProfile() {
            SingleFieldBuilderV3<UserProfile, UserProfile.Builder, UserProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
            if (singleFieldBuilderV3 == null) {
                UserProfile userProfile = this.profile_;
                UserProfile userProfile2 = userProfile;
                if (userProfile == null) {
                    userProfile2 = UserProfile.getDefaultInstance();
                }
                return userProfile2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public UserProfile.Builder getProfileBuilder() {
            onChanged();
            return getProfileFieldBuilder().getBuilder();
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public UserProfileOrBuilder getProfileOrBuilder() {
            SingleFieldBuilderV3<UserProfile, UserProfile.Builder, UserProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            UserProfile userProfile = this.profile_;
            UserProfile userProfile2 = userProfile;
            if (userProfile == null) {
                userProfile2 = UserProfile.getDefaultInstance();
            }
            return userProfile2;
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public LiveMsgType getType() {
            LiveMsgType valueOf = LiveMsgType.valueOf(this.type_);
            LiveMsgType liveMsgType = valueOf;
            if (valueOf == null) {
                liveMsgType = LiveMsgType.UNRECOGNIZED;
            }
            return liveMsgType;
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public boolean hasExtra() {
            return (this.extraBuilder_ == null && this.extra_ == null) ? false : true;
        }

        @Override // cn.irisgw.live.LiveMessageOrBuilder
        public boolean hasProfile() {
            return (this.profileBuilder_ == null && this.profile_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveMessage.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeExtra(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(any);
                return this;
            }
            Any any2 = this.extra_;
            if (any2 != null) {
                this.extra_ = Any.newBuilder(any2).mergeFrom(any).buildPartial();
            } else {
                this.extra_ = any;
            }
            onChanged();
            return this;
        }

        public Builder mergeFrom(LiveMessage liveMessage) {
            if (liveMessage == LiveMessage.getDefaultInstance()) {
                return this;
            }
            if (liveMessage.getMsgId() != 0) {
                setMsgId(liveMessage.getMsgId());
            }
            if (!liveMessage.getLiveId().isEmpty()) {
                this.liveId_ = liveMessage.liveId_;
                onChanged();
            }
            if (liveMessage.getTimestamp() != 0) {
                setTimestamp(liveMessage.getTimestamp());
            }
            if (liveMessage.getFrom() != 0) {
                setFrom(liveMessage.getFrom());
            }
            if (liveMessage.type_ != 0) {
                setTypeValue(liveMessage.getTypeValue());
            }
            if (!liveMessage.getContents().isEmpty()) {
                this.contents_ = liveMessage.contents_;
                onChanged();
            }
            if (liveMessage.hasProfile()) {
                mergeProfile(liveMessage.getProfile());
            }
            if (liveMessage.hasExtra()) {
                mergeExtra(liveMessage.getExtra());
            }
            mergeUnknownFields(liveMessage.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LiveMessage.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LiveMessage.access$1300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LiveMessage r0 = (cn.irisgw.live.LiveMessage) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LiveMessage$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LiveMessage r0 = (cn.irisgw.live.LiveMessage) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LiveMessage$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveMessage$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof LiveMessage) {
                return mergeFrom((LiveMessage) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeProfile(UserProfile userProfile) {
            SingleFieldBuilderV3<UserProfile, UserProfile.Builder, UserProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(userProfile);
                return this;
            }
            UserProfile userProfile2 = this.profile_;
            if (userProfile2 != null) {
                this.profile_ = UserProfile.newBuilder(userProfile2).mergeFrom(userProfile).buildPartial();
            } else {
                this.profile_ = userProfile;
            }
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
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
                LiveMessage.checkByteStringIsUtf8(byteString);
                this.contents_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setExtra(Any.Builder builder) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.extra_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setExtra(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(any);
                return this;
            } else if (any != null) {
                this.extra_ = any;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setFrom(int i) {
            this.from_ = i;
            onChanged();
            return this;
        }

        public Builder setLiveId(String str) {
            if (str != null) {
                this.liveId_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLiveIdBytes(ByteString byteString) {
            if (byteString != null) {
                LiveMessage.checkByteStringIsUtf8(byteString);
                this.liveId_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setMsgId(long j) {
            this.msgId_ = j;
            onChanged();
            return this;
        }

        public Builder setProfile(UserProfile.Builder builder) {
            SingleFieldBuilderV3<UserProfile, UserProfile.Builder, UserProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.profile_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setProfile(UserProfile userProfile) {
            SingleFieldBuilderV3<UserProfile, UserProfile.Builder, UserProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(userProfile);
                return this;
            } else if (userProfile != null) {
                this.profile_ = userProfile;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setTimestamp(long j) {
            this.timestamp_ = j;
            onChanged();
            return this;
        }

        public Builder setType(LiveMsgType liveMsgType) {
            if (liveMsgType != null) {
                this.type_ = liveMsgType.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTypeValue(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LiveMessage() {
        this.memoizedIsInitialized = (byte) -1;
        this.liveId_ = "";
        this.type_ = 0;
        this.contents_ = "";
    }

    private LiveMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        if (readTag == 8) {
                            this.msgId_ = codedInputStream.readUInt64();
                        } else if (readTag == 18) {
                            this.liveId_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 24) {
                            this.timestamp_ = codedInputStream.readUInt64();
                        } else if (readTag == 32) {
                            this.from_ = codedInputStream.readUInt32();
                        } else if (readTag == 40) {
                            this.type_ = codedInputStream.readEnum();
                        } else if (readTag == 50) {
                            this.contents_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 58) {
                            UserProfile.Builder builder = this.profile_ != null ? this.profile_.toBuilder() : null;
                            UserProfile userProfile = (UserProfile) codedInputStream.readMessage(UserProfile.parser(), extensionRegistryLite);
                            this.profile_ = userProfile;
                            if (builder != null) {
                                builder.mergeFrom(userProfile);
                                this.profile_ = builder.buildPartial();
                            }
                        } else if (readTag == 66) {
                            Any.Builder builder2 = this.extra_ != null ? this.extra_.toBuilder() : null;
                            Any any = (Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                            this.extra_ = any;
                            if (builder2 != null) {
                                builder2.mergeFrom(any);
                                this.extra_ = builder2.buildPartial();
                            }
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

    private LiveMessage(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LiveMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveMessage_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(LiveMessage liveMessage) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(liveMessage);
    }

    public static LiveMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LiveMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LiveMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LiveMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static LiveMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LiveMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LiveMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LiveMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LiveMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LiveMessage parseFrom(InputStream inputStream) throws IOException {
        return (LiveMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LiveMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LiveMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static LiveMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LiveMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LiveMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LiveMessage> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LiveMessage) {
            LiveMessage liveMessage = (LiveMessage) obj;
            if (getMsgId() == liveMessage.getMsgId() && getLiveId().equals(liveMessage.getLiveId()) && getTimestamp() == liveMessage.getTimestamp() && getFrom() == liveMessage.getFrom() && this.type_ == liveMessage.type_ && getContents().equals(liveMessage.getContents()) && hasProfile() == liveMessage.hasProfile()) {
                if ((!hasProfile() || getProfile().equals(liveMessage.getProfile())) && hasExtra() == liveMessage.hasExtra()) {
                    return (!hasExtra() || getExtra().equals(liveMessage.getExtra())) && this.unknownFields.equals(liveMessage.unknownFields);
                }
                return false;
            }
            return false;
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public String getContents() {
        Object obj = this.contents_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.contents_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public ByteString getContentsBytes() {
        Object obj = this.contents_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.contents_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public LiveMessage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public Any getExtra() {
        Any any = this.extra_;
        Any any2 = any;
        if (any == null) {
            any2 = Any.getDefaultInstance();
        }
        return any2;
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public AnyOrBuilder getExtraOrBuilder() {
        return getExtra();
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public int getFrom() {
        return this.from_;
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public String getLiveId() {
        Object obj = this.liveId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.liveId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public ByteString getLiveIdBytes() {
        Object obj = this.liveId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.liveId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public long getMsgId() {
        return this.msgId_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<LiveMessage> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public UserProfile getProfile() {
        UserProfile userProfile = this.profile_;
        UserProfile userProfile2 = userProfile;
        if (userProfile == null) {
            userProfile2 = UserProfile.getDefaultInstance();
        }
        return userProfile2;
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public UserProfileOrBuilder getProfileOrBuilder() {
        return getProfile();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        long j = this.msgId_;
        if (j != 0) {
            i2 = 0 + CodedOutputStream.computeUInt64Size(1, j);
        }
        int i3 = i2;
        if (!getLiveIdBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.liveId_);
        }
        long j2 = this.timestamp_;
        int i4 = i3;
        if (j2 != 0) {
            i4 = i3 + CodedOutputStream.computeUInt64Size(3, j2);
        }
        int i5 = this.from_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeUInt32Size(4, i5);
        }
        int i7 = i6;
        if (this.type_ != LiveMsgType.EMPTY_T.getNumber()) {
            i7 = i6 + CodedOutputStream.computeEnumSize(5, this.type_);
        }
        int i8 = i7;
        if (!getContentsBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(6, this.contents_);
        }
        int i9 = i8;
        if (this.profile_ != null) {
            i9 = i8 + CodedOutputStream.computeMessageSize(7, getProfile());
        }
        int i10 = i9;
        if (this.extra_ != null) {
            i10 = i9 + CodedOutputStream.computeMessageSize(8, getExtra());
        }
        int serializedSize = i10 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public LiveMsgType getType() {
        LiveMsgType valueOf = LiveMsgType.valueOf(this.type_);
        LiveMsgType liveMsgType = valueOf;
        if (valueOf == null) {
            liveMsgType = LiveMsgType.UNRECOGNIZED;
        }
        return liveMsgType;
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public int getTypeValue() {
        return this.type_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public boolean hasExtra() {
        return this.extra_ != null;
    }

    @Override // cn.irisgw.live.LiveMessageOrBuilder
    public boolean hasProfile() {
        return this.profile_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getMsgId())) * 37) + 2) * 53) + getLiveId().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getTimestamp())) * 37) + 4) * 53) + getFrom()) * 37) + 5) * 53) + this.type_) * 37) + 6) * 53) + getContents().hashCode();
        int i = hashCode;
        if (hasProfile()) {
            i = (((hashCode * 37) + 7) * 53) + getProfile().hashCode();
        }
        int i2 = i;
        if (hasExtra()) {
            i2 = (((i * 37) + 8) * 53) + getExtra().hashCode();
        }
        int hashCode2 = (i2 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveMessage.class, Builder.class);
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
        return new LiveMessage();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.msgId_;
        if (j != 0) {
            codedOutputStream.writeUInt64(1, j);
        }
        if (!getLiveIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.liveId_);
        }
        long j2 = this.timestamp_;
        if (j2 != 0) {
            codedOutputStream.writeUInt64(3, j2);
        }
        int i = this.from_;
        if (i != 0) {
            codedOutputStream.writeUInt32(4, i);
        }
        if (this.type_ != LiveMsgType.EMPTY_T.getNumber()) {
            codedOutputStream.writeEnum(5, this.type_);
        }
        if (!getContentsBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.contents_);
        }
        if (this.profile_ != null) {
            codedOutputStream.writeMessage(7, getProfile());
        }
        if (this.extra_ != null) {
            codedOutputStream.writeMessage(8, getExtra());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
