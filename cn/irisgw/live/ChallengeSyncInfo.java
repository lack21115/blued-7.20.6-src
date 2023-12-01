package cn.irisgw.live;

import cn.irisgw.live.UserProp;
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
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeSyncInfo.class */
public final class ChallengeSyncInfo extends GeneratedMessageV3 implements ChallengeSyncInfoOrBuilder {
    public static final int AVATAR_FIELD_NUMBER = 4;
    public static final int EGG_SCORE_FIELD_NUMBER = 6;
    public static final int LID_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 5;
    public static final int SCORE_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 1;
    public static final int USER_PROP_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private volatile Object avatar_;
    private int eggScore_;
    private volatile Object lid_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private long score_;
    private int uid_;
    private List<UserProp> userProp_;
    private static final ChallengeSyncInfo DEFAULT_INSTANCE = new ChallengeSyncInfo();
    private static final Parser<ChallengeSyncInfo> PARSER = new AbstractParser<ChallengeSyncInfo>() { // from class: cn.irisgw.live.ChallengeSyncInfo.1
        @Override // com.google.protobuf.Parser
        public ChallengeSyncInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ChallengeSyncInfo(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeSyncInfo$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallengeSyncInfoOrBuilder {
        private Object avatar_;
        private int bitField0_;
        private int eggScore_;
        private Object lid_;
        private Object name_;
        private long score_;
        private int uid_;
        private RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> userPropBuilder_;
        private List<UserProp> userProp_;

        private Builder() {
            this.lid_ = "";
            this.avatar_ = "";
            this.name_ = "";
            this.userProp_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.lid_ = "";
            this.avatar_ = "";
            this.name_ = "";
            this.userProp_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureUserPropIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.userProp_ = new ArrayList(this.userProp_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeSyncInfo_descriptor;
        }

        private RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> getUserPropFieldBuilder() {
            if (this.userPropBuilder_ == null) {
                List<UserProp> list = this.userProp_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.userPropBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.userProp_ = null;
            }
            return this.userPropBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (ChallengeSyncInfo.alwaysUseFieldBuilders) {
                getUserPropFieldBuilder();
            }
        }

        public Builder addAllUserProp(Iterable<? extends UserProp> iterable) {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureUserPropIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.userProp_);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addUserProp(int i, UserProp.Builder builder) {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureUserPropIsMutable();
            this.userProp_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addUserProp(int i, UserProp userProp) {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, userProp);
                return this;
            } else if (userProp != null) {
                ensureUserPropIsMutable();
                this.userProp_.add(i, userProp);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addUserProp(UserProp.Builder builder) {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureUserPropIsMutable();
            this.userProp_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addUserProp(UserProp userProp) {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(userProp);
                return this;
            } else if (userProp != null) {
                ensureUserPropIsMutable();
                this.userProp_.add(userProp);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public UserProp.Builder addUserPropBuilder() {
            return getUserPropFieldBuilder().addBuilder(UserProp.getDefaultInstance());
        }

        public UserProp.Builder addUserPropBuilder(int i) {
            return getUserPropFieldBuilder().addBuilder(i, UserProp.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChallengeSyncInfo build() {
            ChallengeSyncInfo buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChallengeSyncInfo buildPartial() {
            ChallengeSyncInfo challengeSyncInfo = new ChallengeSyncInfo(this);
            challengeSyncInfo.uid_ = this.uid_;
            challengeSyncInfo.lid_ = this.lid_;
            challengeSyncInfo.score_ = this.score_;
            challengeSyncInfo.avatar_ = this.avatar_;
            challengeSyncInfo.name_ = this.name_;
            challengeSyncInfo.eggScore_ = this.eggScore_;
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.userProp_ = Collections.unmodifiableList(this.userProp_);
                    this.bitField0_ &= -2;
                }
                challengeSyncInfo.userProp_ = this.userProp_;
            } else {
                challengeSyncInfo.userProp_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return challengeSyncInfo;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.uid_ = 0;
            this.lid_ = "";
            this.score_ = 0L;
            this.avatar_ = "";
            this.name_ = "";
            this.eggScore_ = 0;
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.userProp_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        public Builder clearAvatar() {
            this.avatar_ = ChallengeSyncInfo.getDefaultInstance().getAvatar();
            onChanged();
            return this;
        }

        public Builder clearEggScore() {
            this.eggScore_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearLid() {
            this.lid_ = ChallengeSyncInfo.getDefaultInstance().getLid();
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = ChallengeSyncInfo.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearScore() {
            this.score_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUserProp() {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.userProp_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public ByteString getAvatarBytes() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChallengeSyncInfo getDefaultInstanceForType() {
            return ChallengeSyncInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeSyncInfo_descriptor;
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public int getEggScore() {
            return this.eggScore_;
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public String getLid() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.lid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public ByteString getLidBytes() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public long getScore() {
            return this.score_;
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public UserProp getUserProp(int i) {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            return repeatedFieldBuilderV3 == null ? this.userProp_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public UserProp.Builder getUserPropBuilder(int i) {
            return getUserPropFieldBuilder().getBuilder(i);
        }

        public List<UserProp.Builder> getUserPropBuilderList() {
            return getUserPropFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public int getUserPropCount() {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            return repeatedFieldBuilderV3 == null ? this.userProp_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public List<UserProp> getUserPropList() {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.userProp_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public UserPropOrBuilder getUserPropOrBuilder(int i) {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            return repeatedFieldBuilderV3 == null ? this.userProp_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
        public List<? extends UserPropOrBuilder> getUserPropOrBuilderList() {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.userProp_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeSyncInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeSyncInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ChallengeSyncInfo challengeSyncInfo) {
            if (challengeSyncInfo == ChallengeSyncInfo.getDefaultInstance()) {
                return this;
            }
            if (challengeSyncInfo.getUid() != 0) {
                setUid(challengeSyncInfo.getUid());
            }
            if (!challengeSyncInfo.getLid().isEmpty()) {
                this.lid_ = challengeSyncInfo.lid_;
                onChanged();
            }
            if (challengeSyncInfo.getScore() != 0) {
                setScore(challengeSyncInfo.getScore());
            }
            if (!challengeSyncInfo.getAvatar().isEmpty()) {
                this.avatar_ = challengeSyncInfo.avatar_;
                onChanged();
            }
            if (!challengeSyncInfo.getName().isEmpty()) {
                this.name_ = challengeSyncInfo.name_;
                onChanged();
            }
            if (challengeSyncInfo.getEggScore() != 0) {
                setEggScore(challengeSyncInfo.getEggScore());
            }
            if (this.userPropBuilder_ == null) {
                if (!challengeSyncInfo.userProp_.isEmpty()) {
                    if (this.userProp_.isEmpty()) {
                        this.userProp_ = challengeSyncInfo.userProp_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUserPropIsMutable();
                        this.userProp_.addAll(challengeSyncInfo.userProp_);
                    }
                    onChanged();
                }
            } else if (!challengeSyncInfo.userProp_.isEmpty()) {
                if (this.userPropBuilder_.isEmpty()) {
                    this.userPropBuilder_.dispose();
                    RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = null;
                    this.userPropBuilder_ = null;
                    this.userProp_ = challengeSyncInfo.userProp_;
                    this.bitField0_ &= -2;
                    if (ChallengeSyncInfo.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getUserPropFieldBuilder();
                    }
                    this.userPropBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.userPropBuilder_.addAllMessages(challengeSyncInfo.userProp_);
                }
            }
            mergeUnknownFields(challengeSyncInfo.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ChallengeSyncInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ChallengeSyncInfo.access$1300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ChallengeSyncInfo r0 = (cn.irisgw.live.ChallengeSyncInfo) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ChallengeSyncInfo$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ChallengeSyncInfo r0 = (cn.irisgw.live.ChallengeSyncInfo) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ChallengeSyncInfo$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ChallengeSyncInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ChallengeSyncInfo$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ChallengeSyncInfo) {
                return mergeFrom((ChallengeSyncInfo) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeUserProp(int i) {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureUserPropIsMutable();
            this.userProp_.remove(i);
            onChanged();
            return this;
        }

        public Builder setAvatar(String str) {
            if (str != null) {
                this.avatar_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAvatarBytes(ByteString byteString) {
            if (byteString != null) {
                ChallengeSyncInfo.checkByteStringIsUtf8(byteString);
                this.avatar_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setEggScore(int i) {
            this.eggScore_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setLid(String str) {
            if (str != null) {
                this.lid_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLidBytes(ByteString byteString) {
            if (byteString != null) {
                ChallengeSyncInfo.checkByteStringIsUtf8(byteString);
                this.lid_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setName(String str) {
            if (str != null) {
                this.name_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNameBytes(ByteString byteString) {
            if (byteString != null) {
                ChallengeSyncInfo.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setScore(long j) {
            this.score_ = j;
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

        public Builder setUserProp(int i, UserProp.Builder builder) {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureUserPropIsMutable();
            this.userProp_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setUserProp(int i, UserProp userProp) {
            RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, userProp);
                return this;
            } else if (userProp != null) {
                ensureUserPropIsMutable();
                this.userProp_.set(i, userProp);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }
    }

    private ChallengeSyncInfo() {
        this.memoizedIsInitialized = (byte) -1;
        this.lid_ = "";
        this.avatar_ = "";
        this.name_ = "";
        this.userProp_ = Collections.emptyList();
    }

    private ChallengeSyncInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.uid_ = codedInputStream.readUInt32();
                        } else if (readTag == 18) {
                            this.lid_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 24) {
                            this.score_ = codedInputStream.readUInt64();
                        } else if (readTag == 34) {
                            this.avatar_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 42) {
                            this.name_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 48) {
                            this.eggScore_ = codedInputStream.readUInt32();
                        } else if (readTag == 58) {
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.userProp_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.userProp_.add((UserProp) codedInputStream.readMessage(UserProp.parser(), extensionRegistryLite));
                            z2 = z4;
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
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
                    this.userProp_ = Collections.unmodifiableList(this.userProp_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.userProp_ = Collections.unmodifiableList(this.userProp_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private ChallengeSyncInfo(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ChallengeSyncInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeSyncInfo_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ChallengeSyncInfo challengeSyncInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(challengeSyncInfo);
    }

    public static ChallengeSyncInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ChallengeSyncInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ChallengeSyncInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeSyncInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeSyncInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ChallengeSyncInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ChallengeSyncInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ChallengeSyncInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ChallengeSyncInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeSyncInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ChallengeSyncInfo parseFrom(InputStream inputStream) throws IOException {
        return (ChallengeSyncInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ChallengeSyncInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeSyncInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeSyncInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ChallengeSyncInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ChallengeSyncInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ChallengeSyncInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ChallengeSyncInfo> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChallengeSyncInfo) {
            ChallengeSyncInfo challengeSyncInfo = (ChallengeSyncInfo) obj;
            return getUid() == challengeSyncInfo.getUid() && getLid().equals(challengeSyncInfo.getLid()) && getScore() == challengeSyncInfo.getScore() && getAvatar().equals(challengeSyncInfo.getAvatar()) && getName().equals(challengeSyncInfo.getName()) && getEggScore() == challengeSyncInfo.getEggScore() && getUserPropList().equals(challengeSyncInfo.getUserPropList()) && this.unknownFields.equals(challengeSyncInfo.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public String getAvatar() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatar_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public ByteString getAvatarBytes() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.avatar_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ChallengeSyncInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public int getEggScore() {
        return this.eggScore_;
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public String getLid() {
        Object obj = this.lid_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.lid_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public ByteString getLidBytes() {
        Object obj = this.lid_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.lid_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ChallengeSyncInfo> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public long getScore() {
        return this.score_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.uid_;
        int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
        int i3 = computeUInt32Size;
        if (!getLidBytes().isEmpty()) {
            i3 = computeUInt32Size + GeneratedMessageV3.computeStringSize(2, this.lid_);
        }
        long j = this.score_;
        int i4 = i3;
        if (j != 0) {
            i4 = i3 + CodedOutputStream.computeUInt64Size(3, j);
        }
        int i5 = i4;
        if (!getAvatarBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.avatar_);
        }
        int i6 = i5;
        if (!getNameBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.name_);
        }
        int i7 = this.eggScore_;
        int i8 = i6;
        int i9 = 0;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeUInt32Size(6, i7);
            i9 = 0;
        }
        while (i9 < this.userProp_.size()) {
            i8 += CodedOutputStream.computeMessageSize(7, this.userProp_.get(i9));
            i9++;
        }
        int serializedSize = i8 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public int getUid() {
        return this.uid_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public UserProp getUserProp(int i) {
        return this.userProp_.get(i);
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public int getUserPropCount() {
        return this.userProp_.size();
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public List<UserProp> getUserPropList() {
        return this.userProp_;
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public UserPropOrBuilder getUserPropOrBuilder(int i) {
        return this.userProp_.get(i);
    }

    @Override // cn.irisgw.live.ChallengeSyncInfoOrBuilder
    public List<? extends UserPropOrBuilder> getUserPropOrBuilderList() {
        return this.userProp_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getLid().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getScore())) * 37) + 4) * 53) + getAvatar().hashCode()) * 37) + 5) * 53) + getName().hashCode()) * 37) + 6) * 53) + getEggScore();
        int i = hashCode;
        if (getUserPropCount() > 0) {
            i = (((hashCode * 37) + 7) * 53) + getUserPropList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeSyncInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeSyncInfo.class, Builder.class);
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
        return new ChallengeSyncInfo();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.uid_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        if (!getLidBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.lid_);
        }
        long j = this.score_;
        if (j != 0) {
            codedOutputStream.writeUInt64(3, j);
        }
        if (!getAvatarBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.avatar_);
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.name_);
        }
        int i2 = this.eggScore_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(6, i2);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.userProp_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(7, this.userProp_.get(i4));
                i3 = i4 + 1;
            }
        }
    }
}
