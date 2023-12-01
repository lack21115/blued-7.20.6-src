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
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkRank.class */
public final class MultiPkRank extends GeneratedMessageV3 implements MultiPkRankOrBuilder {
    private static final MultiPkRank DEFAULT_INSTANCE = new MultiPkRank();
    private static final Parser<MultiPkRank> PARSER = new AbstractParser<MultiPkRank>() { // from class: cn.irisgw.live.MultiPkRank.1
        @Override // com.google.protobuf.Parser
        public MultiPkRank parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new MultiPkRank(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int USERS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<StartRecord> users_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkRank$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MultiPkRankOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> usersBuilder_;
        private List<StartRecord> users_;

        private Builder() {
            this.users_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.users_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureUsersIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.users_ = new ArrayList(this.users_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkRank_descriptor;
        }

        private RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> getUsersFieldBuilder() {
            if (this.usersBuilder_ == null) {
                List<StartRecord> list = this.users_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.usersBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.users_ = null;
            }
            return this.usersBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (MultiPkRank.alwaysUseFieldBuilders) {
                getUsersFieldBuilder();
            }
        }

        public Builder addAllUsers(Iterable<? extends StartRecord> iterable) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureUsersIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.users_);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addUsers(int i, StartRecord.Builder builder) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addUsers(int i, StartRecord startRecord) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, startRecord);
                return this;
            } else if (startRecord != null) {
                ensureUsersIsMutable();
                this.users_.add(i, startRecord);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addUsers(StartRecord.Builder builder) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addUsers(StartRecord startRecord) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(startRecord);
                return this;
            } else if (startRecord != null) {
                ensureUsersIsMutable();
                this.users_.add(startRecord);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public StartRecord.Builder addUsersBuilder() {
            return getUsersFieldBuilder().addBuilder(StartRecord.getDefaultInstance());
        }

        public StartRecord.Builder addUsersBuilder(int i) {
            return getUsersFieldBuilder().addBuilder(i, StartRecord.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MultiPkRank build() {
            MultiPkRank buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MultiPkRank buildPartial() {
            MultiPkRank multiPkRank = new MultiPkRank(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.users_ = Collections.unmodifiableList(this.users_);
                    this.bitField0_ &= -2;
                }
                multiPkRank.users_ = this.users_;
            } else {
                multiPkRank.users_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return multiPkRank;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.users_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearUsers() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.users_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MultiPkRank getDefaultInstanceForType() {
            return MultiPkRank.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkRank_descriptor;
        }

        @Override // cn.irisgw.live.MultiPkRankOrBuilder
        public StartRecord getUsers(int i) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.users_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public StartRecord.Builder getUsersBuilder(int i) {
            return getUsersFieldBuilder().getBuilder(i);
        }

        public List<StartRecord.Builder> getUsersBuilderList() {
            return getUsersFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.MultiPkRankOrBuilder
        public int getUsersCount() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.users_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.MultiPkRankOrBuilder
        public List<StartRecord> getUsersList() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.users_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.MultiPkRankOrBuilder
        public StartRecordOrBuilder getUsersOrBuilder(int i) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.users_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.MultiPkRankOrBuilder
        public List<? extends StartRecordOrBuilder> getUsersOrBuilderList() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.users_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkRank_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiPkRank.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(MultiPkRank multiPkRank) {
            if (multiPkRank == MultiPkRank.getDefaultInstance()) {
                return this;
            }
            if (this.usersBuilder_ == null) {
                if (!multiPkRank.users_.isEmpty()) {
                    if (this.users_.isEmpty()) {
                        this.users_ = multiPkRank.users_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUsersIsMutable();
                        this.users_.addAll(multiPkRank.users_);
                    }
                    onChanged();
                }
            } else if (!multiPkRank.users_.isEmpty()) {
                if (this.usersBuilder_.isEmpty()) {
                    this.usersBuilder_.dispose();
                    RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = null;
                    this.usersBuilder_ = null;
                    this.users_ = multiPkRank.users_;
                    this.bitField0_ &= -2;
                    if (MultiPkRank.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getUsersFieldBuilder();
                    }
                    this.usersBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.usersBuilder_.addAllMessages(multiPkRank.users_);
                }
            }
            mergeUnknownFields(multiPkRank.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.MultiPkRank.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.MultiPkRank.access$2700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.MultiPkRank r0 = (cn.irisgw.live.MultiPkRank) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.MultiPkRank$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.MultiPkRank r0 = (cn.irisgw.live.MultiPkRank) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.MultiPkRank$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.MultiPkRank.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.MultiPkRank$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof MultiPkRank) {
                return mergeFrom((MultiPkRank) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeUsers(int i) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureUsersIsMutable();
            this.users_.remove(i);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setUsers(int i, StartRecord.Builder builder) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setUsers(int i, StartRecord startRecord) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, startRecord);
                return this;
            } else if (startRecord != null) {
                ensureUsersIsMutable();
                this.users_.set(i, startRecord);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkRank$StartRecord.class */
    public static final class StartRecord extends GeneratedMessageV3 implements StartRecordOrBuilder {
        public static final int FIRST_KILL_AVATAR_FIELD_NUMBER = 8;
        public static final int FIRST_KILL_HIDE_FIELD_NUMBER = 9;
        public static final int FIRST_KILL_NAME_FIELD_NUMBER = 7;
        public static final int FIRST_KILL_UID_FIELD_NUMBER = 6;
        public static final int GROUP_ID_FIELD_NUMBER = 10;
        public static final int GROUP_SCORE_FIELD_NUMBER = 11;
        public static final int INCR_SCORE_FIELD_NUMBER = 5;
        public static final int LID_FIELD_NUMBER = 2;
        public static final int RANK_FIELD_NUMBER = 3;
        public static final int SCORE_FIELD_NUMBER = 4;
        public static final int UID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object firstKillAvatar_;
        private boolean firstKillHide_;
        private volatile Object firstKillName_;
        private int firstKillUid_;
        private int groupId_;
        private int groupScore_;
        private float incrScore_;
        private int lid_;
        private byte memoizedIsInitialized;
        private int rank_;
        private float score_;
        private int uid_;
        private static final StartRecord DEFAULT_INSTANCE = new StartRecord();
        private static final Parser<StartRecord> PARSER = new AbstractParser<StartRecord>() { // from class: cn.irisgw.live.MultiPkRank.StartRecord.1
            @Override // com.google.protobuf.Parser
            public StartRecord parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StartRecord(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkRank$StartRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StartRecordOrBuilder {
            private Object firstKillAvatar_;
            private boolean firstKillHide_;
            private Object firstKillName_;
            private int firstKillUid_;
            private int groupId_;
            private int groupScore_;
            private float incrScore_;
            private int lid_;
            private int rank_;
            private float score_;
            private int uid_;

            private Builder() {
                this.firstKillName_ = "";
                this.firstKillAvatar_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.firstKillName_ = "";
                this.firstKillAvatar_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_MultiPkRank_StartRecord_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = StartRecord.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StartRecord build() {
                StartRecord buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StartRecord buildPartial() {
                StartRecord startRecord = new StartRecord(this);
                startRecord.uid_ = this.uid_;
                startRecord.lid_ = this.lid_;
                startRecord.rank_ = this.rank_;
                startRecord.score_ = this.score_;
                startRecord.incrScore_ = this.incrScore_;
                startRecord.firstKillUid_ = this.firstKillUid_;
                startRecord.firstKillName_ = this.firstKillName_;
                startRecord.firstKillAvatar_ = this.firstKillAvatar_;
                startRecord.firstKillHide_ = this.firstKillHide_;
                startRecord.groupId_ = this.groupId_;
                startRecord.groupScore_ = this.groupScore_;
                onBuilt();
                return startRecord;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.uid_ = 0;
                this.lid_ = 0;
                this.rank_ = 0;
                this.score_ = 0.0f;
                this.incrScore_ = 0.0f;
                this.firstKillUid_ = 0;
                this.firstKillName_ = "";
                this.firstKillAvatar_ = "";
                this.firstKillHide_ = false;
                this.groupId_ = 0;
                this.groupScore_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearFirstKillAvatar() {
                this.firstKillAvatar_ = StartRecord.getDefaultInstance().getFirstKillAvatar();
                onChanged();
                return this;
            }

            public Builder clearFirstKillHide() {
                this.firstKillHide_ = false;
                onChanged();
                return this;
            }

            public Builder clearFirstKillName() {
                this.firstKillName_ = StartRecord.getDefaultInstance().getFirstKillName();
                onChanged();
                return this;
            }

            public Builder clearFirstKillUid() {
                this.firstKillUid_ = 0;
                onChanged();
                return this;
            }

            public Builder clearGroupId() {
                this.groupId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearGroupScore() {
                this.groupScore_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIncrScore() {
                this.incrScore_ = 0.0f;
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

            public Builder clearRank() {
                this.rank_ = 0;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.score_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public StartRecord getDefaultInstanceForType() {
                return StartRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_MultiPkRank_StartRecord_descriptor;
            }

            @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
            public String getFirstKillAvatar() {
                Object obj = this.firstKillAvatar_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.firstKillAvatar_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
            public ByteString getFirstKillAvatarBytes() {
                Object obj = this.firstKillAvatar_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.firstKillAvatar_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
            public boolean getFirstKillHide() {
                return this.firstKillHide_;
            }

            @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
            public String getFirstKillName() {
                Object obj = this.firstKillName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.firstKillName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
            public ByteString getFirstKillNameBytes() {
                Object obj = this.firstKillName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.firstKillName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
            public int getFirstKillUid() {
                return this.firstKillUid_;
            }

            @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
            public int getGroupId() {
                return this.groupId_;
            }

            @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
            public int getGroupScore() {
                return this.groupScore_;
            }

            @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
            public float getIncrScore() {
                return this.incrScore_;
            }

            @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
            public int getLid() {
                return this.lid_;
            }

            @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
            public int getRank() {
                return this.rank_;
            }

            @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
            public float getScore() {
                return this.score_;
            }

            @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
            public int getUid() {
                return this.uid_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_MultiPkRank_StartRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(StartRecord.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(StartRecord startRecord) {
                if (startRecord == StartRecord.getDefaultInstance()) {
                    return this;
                }
                if (startRecord.getUid() != 0) {
                    setUid(startRecord.getUid());
                }
                if (startRecord.getLid() != 0) {
                    setLid(startRecord.getLid());
                }
                if (startRecord.getRank() != 0) {
                    setRank(startRecord.getRank());
                }
                if (startRecord.getScore() != 0.0f) {
                    setScore(startRecord.getScore());
                }
                if (startRecord.getIncrScore() != 0.0f) {
                    setIncrScore(startRecord.getIncrScore());
                }
                if (startRecord.getFirstKillUid() != 0) {
                    setFirstKillUid(startRecord.getFirstKillUid());
                }
                if (!startRecord.getFirstKillName().isEmpty()) {
                    this.firstKillName_ = startRecord.firstKillName_;
                    onChanged();
                }
                if (!startRecord.getFirstKillAvatar().isEmpty()) {
                    this.firstKillAvatar_ = startRecord.firstKillAvatar_;
                    onChanged();
                }
                if (startRecord.getFirstKillHide()) {
                    setFirstKillHide(startRecord.getFirstKillHide());
                }
                if (startRecord.getGroupId() != 0) {
                    setGroupId(startRecord.getGroupId());
                }
                if (startRecord.getGroupScore() != 0) {
                    setGroupScore(startRecord.getGroupScore());
                }
                mergeUnknownFields(startRecord.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.MultiPkRank.StartRecord.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.MultiPkRank.StartRecord.access$1600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.MultiPkRank$StartRecord r0 = (cn.irisgw.live.MultiPkRank.StartRecord) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.MultiPkRank$StartRecord$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.MultiPkRank$StartRecord r0 = (cn.irisgw.live.MultiPkRank.StartRecord) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.MultiPkRank$StartRecord$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.MultiPkRank.StartRecord.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.MultiPkRank$StartRecord$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof StartRecord) {
                    return mergeFrom((StartRecord) message);
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

            public Builder setFirstKillAvatar(String str) {
                if (str != null) {
                    this.firstKillAvatar_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFirstKillAvatarBytes(ByteString byteString) {
                if (byteString != null) {
                    StartRecord.checkByteStringIsUtf8(byteString);
                    this.firstKillAvatar_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFirstKillHide(boolean z) {
                this.firstKillHide_ = z;
                onChanged();
                return this;
            }

            public Builder setFirstKillName(String str) {
                if (str != null) {
                    this.firstKillName_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFirstKillNameBytes(ByteString byteString) {
                if (byteString != null) {
                    StartRecord.checkByteStringIsUtf8(byteString);
                    this.firstKillName_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFirstKillUid(int i) {
                this.firstKillUid_ = i;
                onChanged();
                return this;
            }

            public Builder setGroupId(int i) {
                this.groupId_ = i;
                onChanged();
                return this;
            }

            public Builder setGroupScore(int i) {
                this.groupScore_ = i;
                onChanged();
                return this;
            }

            public Builder setIncrScore(float f) {
                this.incrScore_ = f;
                onChanged();
                return this;
            }

            public Builder setLid(int i) {
                this.lid_ = i;
                onChanged();
                return this;
            }

            public Builder setRank(int i) {
                this.rank_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setScore(float f) {
                this.score_ = f;
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
        }

        private StartRecord() {
            this.memoizedIsInitialized = (byte) -1;
            this.firstKillName_ = "";
            this.firstKillAvatar_ = "";
        }

        private StartRecord(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.uid_ = codedInputStream.readUInt32();
                                    continue;
                                case 16:
                                    this.lid_ = codedInputStream.readUInt32();
                                    continue;
                                case 24:
                                    this.rank_ = codedInputStream.readUInt32();
                                    continue;
                                case 37:
                                    this.score_ = codedInputStream.readFloat();
                                    continue;
                                case 45:
                                    this.incrScore_ = codedInputStream.readFloat();
                                    continue;
                                case 48:
                                    this.firstKillUid_ = codedInputStream.readUInt32();
                                    continue;
                                case 58:
                                    this.firstKillName_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 66:
                                    this.firstKillAvatar_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 72:
                                    this.firstKillHide_ = codedInputStream.readBool();
                                    continue;
                                case 80:
                                    this.groupId_ = codedInputStream.readUInt32();
                                    continue;
                                case 88:
                                    this.groupScore_ = codedInputStream.readUInt32();
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private StartRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static StartRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkRank_StartRecord_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(StartRecord startRecord) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(startRecord);
        }

        public static StartRecord parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StartRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static StartRecord parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static StartRecord parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static StartRecord parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static StartRecord parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StartRecord) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static StartRecord parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartRecord) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static StartRecord parseFrom(InputStream inputStream) throws IOException {
            return (StartRecord) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static StartRecord parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StartRecord) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static StartRecord parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static StartRecord parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static StartRecord parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static StartRecord parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<StartRecord> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof StartRecord) {
                StartRecord startRecord = (StartRecord) obj;
                return getUid() == startRecord.getUid() && getLid() == startRecord.getLid() && getRank() == startRecord.getRank() && Float.floatToIntBits(getScore()) == Float.floatToIntBits(startRecord.getScore()) && Float.floatToIntBits(getIncrScore()) == Float.floatToIntBits(startRecord.getIncrScore()) && getFirstKillUid() == startRecord.getFirstKillUid() && getFirstKillName().equals(startRecord.getFirstKillName()) && getFirstKillAvatar().equals(startRecord.getFirstKillAvatar()) && getFirstKillHide() == startRecord.getFirstKillHide() && getGroupId() == startRecord.getGroupId() && getGroupScore() == startRecord.getGroupScore() && this.unknownFields.equals(startRecord.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public StartRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
        public String getFirstKillAvatar() {
            Object obj = this.firstKillAvatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.firstKillAvatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
        public ByteString getFirstKillAvatarBytes() {
            Object obj = this.firstKillAvatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.firstKillAvatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
        public boolean getFirstKillHide() {
            return this.firstKillHide_;
        }

        @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
        public String getFirstKillName() {
            Object obj = this.firstKillName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.firstKillName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
        public ByteString getFirstKillNameBytes() {
            Object obj = this.firstKillName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.firstKillName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
        public int getFirstKillUid() {
            return this.firstKillUid_;
        }

        @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
        public int getGroupScore() {
            return this.groupScore_;
        }

        @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
        public float getIncrScore() {
            return this.incrScore_;
        }

        @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
        public int getLid() {
            return this.lid_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<StartRecord> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
        public int getRank() {
            return this.rank_;
        }

        @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
        public float getScore() {
            return this.score_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.uid_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
            }
            int i4 = this.lid_;
            int i5 = i2;
            if (i4 != 0) {
                i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
            }
            int i6 = this.rank_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeUInt32Size(3, i6);
            }
            float f = this.score_;
            int i8 = i7;
            if (f != 0.0f) {
                i8 = i7 + CodedOutputStream.computeFloatSize(4, f);
            }
            float f2 = this.incrScore_;
            int i9 = i8;
            if (f2 != 0.0f) {
                i9 = i8 + CodedOutputStream.computeFloatSize(5, f2);
            }
            int i10 = this.firstKillUid_;
            int i11 = i9;
            if (i10 != 0) {
                i11 = i9 + CodedOutputStream.computeUInt32Size(6, i10);
            }
            int i12 = i11;
            if (!getFirstKillNameBytes().isEmpty()) {
                i12 = i11 + GeneratedMessageV3.computeStringSize(7, this.firstKillName_);
            }
            int i13 = i12;
            if (!getFirstKillAvatarBytes().isEmpty()) {
                i13 = i12 + GeneratedMessageV3.computeStringSize(8, this.firstKillAvatar_);
            }
            boolean z = this.firstKillHide_;
            int i14 = i13;
            if (z) {
                i14 = i13 + CodedOutputStream.computeBoolSize(9, z);
            }
            int i15 = this.groupId_;
            int i16 = i14;
            if (i15 != 0) {
                i16 = i14 + CodedOutputStream.computeUInt32Size(10, i15);
            }
            int i17 = this.groupScore_;
            int i18 = i16;
            if (i17 != 0) {
                i18 = i16 + CodedOutputStream.computeUInt32Size(11, i17);
            }
            int serializedSize = i18 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.MultiPkRank.StartRecordOrBuilder
        public int getUid() {
            return this.uid_;
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
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getLid()) * 37) + 3) * 53) + getRank()) * 37) + 4) * 53) + Float.floatToIntBits(getScore())) * 37) + 5) * 53) + Float.floatToIntBits(getIncrScore())) * 37) + 6) * 53) + getFirstKillUid()) * 37) + 7) * 53) + getFirstKillName().hashCode()) * 37) + 8) * 53) + getFirstKillAvatar().hashCode()) * 37) + 9) * 53) + Internal.hashBoolean(getFirstKillHide())) * 37) + 10) * 53) + getGroupId()) * 37) + 11) * 53) + getGroupScore()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkRank_StartRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(StartRecord.class, Builder.class);
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
            return new StartRecord();
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
            int i2 = this.lid_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(2, i2);
            }
            int i3 = this.rank_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(3, i3);
            }
            float f = this.score_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(4, f);
            }
            float f2 = this.incrScore_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(5, f2);
            }
            int i4 = this.firstKillUid_;
            if (i4 != 0) {
                codedOutputStream.writeUInt32(6, i4);
            }
            if (!getFirstKillNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.firstKillName_);
            }
            if (!getFirstKillAvatarBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.firstKillAvatar_);
            }
            boolean z = this.firstKillHide_;
            if (z) {
                codedOutputStream.writeBool(9, z);
            }
            int i5 = this.groupId_;
            if (i5 != 0) {
                codedOutputStream.writeUInt32(10, i5);
            }
            int i6 = this.groupScore_;
            if (i6 != 0) {
                codedOutputStream.writeUInt32(11, i6);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkRank$StartRecordOrBuilder.class */
    public interface StartRecordOrBuilder extends MessageOrBuilder {
        String getFirstKillAvatar();

        ByteString getFirstKillAvatarBytes();

        boolean getFirstKillHide();

        String getFirstKillName();

        ByteString getFirstKillNameBytes();

        int getFirstKillUid();

        int getGroupId();

        int getGroupScore();

        float getIncrScore();

        int getLid();

        int getRank();

        float getScore();

        int getUid();
    }

    private MultiPkRank() {
        this.memoizedIsInitialized = (byte) -1;
        this.users_ = Collections.emptyList();
    }

    private MultiPkRank(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        if (readTag == 10) {
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.users_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.users_.add((StartRecord) codedInputStream.readMessage(StartRecord.parser(), extensionRegistryLite));
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
                    this.users_ = Collections.unmodifiableList(this.users_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.users_ = Collections.unmodifiableList(this.users_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private MultiPkRank(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MultiPkRank getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_MultiPkRank_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MultiPkRank multiPkRank) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(multiPkRank);
    }

    public static MultiPkRank parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MultiPkRank) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static MultiPkRank parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiPkRank) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiPkRank parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static MultiPkRank parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static MultiPkRank parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MultiPkRank) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static MultiPkRank parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiPkRank) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static MultiPkRank parseFrom(InputStream inputStream) throws IOException {
        return (MultiPkRank) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static MultiPkRank parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiPkRank) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiPkRank parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static MultiPkRank parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static MultiPkRank parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static MultiPkRank parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<MultiPkRank> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiPkRank) {
            MultiPkRank multiPkRank = (MultiPkRank) obj;
            return getUsersList().equals(multiPkRank.getUsersList()) && this.unknownFields.equals(multiPkRank.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public MultiPkRank getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MultiPkRank> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.users_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.users_.get(i3));
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.MultiPkRankOrBuilder
    public StartRecord getUsers(int i) {
        return this.users_.get(i);
    }

    @Override // cn.irisgw.live.MultiPkRankOrBuilder
    public int getUsersCount() {
        return this.users_.size();
    }

    @Override // cn.irisgw.live.MultiPkRankOrBuilder
    public List<StartRecord> getUsersList() {
        return this.users_;
    }

    @Override // cn.irisgw.live.MultiPkRankOrBuilder
    public StartRecordOrBuilder getUsersOrBuilder(int i) {
        return this.users_.get(i);
    }

    @Override // cn.irisgw.live.MultiPkRankOrBuilder
    public List<? extends StartRecordOrBuilder> getUsersOrBuilderList() {
        return this.users_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (getUsersCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getUsersList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_MultiPkRank_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiPkRank.class, Builder.class);
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
        return new MultiPkRank();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.users_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(1, this.users_.get(i2));
                i = i2 + 1;
            }
        }
    }
}
