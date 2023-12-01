package cn.irisgw.live;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkStart.class */
public final class MultiPkStart extends GeneratedMessageV3 implements MultiPkStartOrBuilder {
    public static final int FIRST_KILL_MESSAGE_FIELD_NUMBER = 2;
    public static final int USERS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private volatile Object firstKillMessage_;
    private byte memoizedIsInitialized;
    private List<StartRecord> users_;
    private static final MultiPkStart DEFAULT_INSTANCE = new MultiPkStart();
    private static final Parser<MultiPkStart> PARSER = new AbstractParser<MultiPkStart>() { // from class: cn.irisgw.live.MultiPkStart.1
        /* renamed from: parsePartialFrom */
        public MultiPkStart m6129parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new MultiPkStart(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkStart$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MultiPkStartOrBuilder {
        private int bitField0_;
        private Object firstKillMessage_;
        private RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> usersBuilder_;
        private List<StartRecord> users_;

        private Builder() {
            this.users_ = Collections.emptyList();
            this.firstKillMessage_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.users_ = Collections.emptyList();
            this.firstKillMessage_ = "";
            maybeForceBuilderInitialization();
        }

        private void ensureUsersIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.users_ = new ArrayList(this.users_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkStart_descriptor;
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
            if (MultiPkStart.alwaysUseFieldBuilders) {
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
            AbstractMessageLite.Builder.addAll(iterable, this.users_);
            onChanged();
            return this;
        }

        /* renamed from: addRepeatedField */
        public Builder m6131addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addUsers(int i, StartRecord.Builder builder) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m6180build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.add(i, builder.m6180build());
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
                repeatedFieldBuilderV3.addMessage(builder.m6180build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.add(builder.m6180build());
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

        /* renamed from: build */
        public MultiPkStart m6133build() {
            MultiPkStart m6135buildPartial = m6135buildPartial();
            if (m6135buildPartial.isInitialized()) {
                return m6135buildPartial;
            }
            throw newUninitializedMessageException(m6135buildPartial);
        }

        /* renamed from: buildPartial */
        public MultiPkStart m6135buildPartial() {
            MultiPkStart multiPkStart = new MultiPkStart(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.users_ = Collections.unmodifiableList(this.users_);
                    this.bitField0_ &= -2;
                }
                multiPkStart.users_ = this.users_;
            } else {
                multiPkStart.users_ = repeatedFieldBuilderV3.build();
            }
            multiPkStart.firstKillMessage_ = this.firstKillMessage_;
            onBuilt();
            return multiPkStart;
        }

        /* renamed from: clear */
        public Builder m6139clear() {
            super.clear();
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.users_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.firstKillMessage_ = "";
            return this;
        }

        /* renamed from: clearField */
        public Builder m6141clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearFirstKillMessage() {
            this.firstKillMessage_ = MultiPkStart.getDefaultInstance().getFirstKillMessage();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m6144clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
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

        /* renamed from: clone */
        public Builder m6150clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public MultiPkStart m6152getDefaultInstanceForType() {
            return MultiPkStart.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkStart_descriptor;
        }

        @Override // cn.irisgw.live.MultiPkStartOrBuilder
        public String getFirstKillMessage() {
            Object obj = this.firstKillMessage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.firstKillMessage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.MultiPkStartOrBuilder
        public ByteString getFirstKillMessageBytes() {
            Object obj = this.firstKillMessage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.firstKillMessage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.MultiPkStartOrBuilder
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

        @Override // cn.irisgw.live.MultiPkStartOrBuilder
        public int getUsersCount() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.users_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.MultiPkStartOrBuilder
        public List<StartRecord> getUsersList() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.users_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.MultiPkStartOrBuilder
        public StartRecordOrBuilder getUsersOrBuilder(int i) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.users_.get(i) : (StartRecordOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.MultiPkStartOrBuilder
        public List<? extends StartRecordOrBuilder> getUsersOrBuilderList() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.users_);
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkStart_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiPkStart.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(MultiPkStart multiPkStart) {
            if (multiPkStart == MultiPkStart.getDefaultInstance()) {
                return this;
            }
            if (this.usersBuilder_ == null) {
                if (!multiPkStart.users_.isEmpty()) {
                    if (this.users_.isEmpty()) {
                        this.users_ = multiPkStart.users_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUsersIsMutable();
                        this.users_.addAll(multiPkStart.users_);
                    }
                    onChanged();
                }
            } else if (!multiPkStart.users_.isEmpty()) {
                if (this.usersBuilder_.isEmpty()) {
                    this.usersBuilder_.dispose();
                    RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = null;
                    this.usersBuilder_ = null;
                    this.users_ = multiPkStart.users_;
                    this.bitField0_ &= -2;
                    if (MultiPkStart.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getUsersFieldBuilder();
                    }
                    this.usersBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.usersBuilder_.addAllMessages(multiPkStart.users_);
                }
            }
            if (!multiPkStart.getFirstKillMessage().isEmpty()) {
                this.firstKillMessage_ = multiPkStart.firstKillMessage_;
                onChanged();
            }
            m6161mergeUnknownFields(multiPkStart.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.MultiPkStart.Builder m6158mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.MultiPkStart.access$2600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.MultiPkStart r0 = (cn.irisgw.live.MultiPkStart) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.MultiPkStart$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.MultiPkStart r0 = (cn.irisgw.live.MultiPkStart) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.MultiPkStart$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.MultiPkStart.Builder.m6158mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.MultiPkStart$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m6157mergeFrom(Message message) {
            if (message instanceof MultiPkStart) {
                return mergeFrom((MultiPkStart) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m6161mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
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

        /* renamed from: setField */
        public Builder m6163setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setFirstKillMessage(String str) {
            if (str != null) {
                this.firstKillMessage_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setFirstKillMessageBytes(ByteString byteString) {
            if (byteString != null) {
                MultiPkStart.checkByteStringIsUtf8(byteString);
                this.firstKillMessage_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setRepeatedField */
        public Builder m6165setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m6167setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setUsers(int i, StartRecord.Builder builder) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m6180build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.set(i, builder.m6180build());
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkStart$StartRecord.class */
    public static final class StartRecord extends GeneratedMessageV3 implements StartRecordOrBuilder {
        public static final int BUFF_TIME_FIELD_NUMBER = 9;
        public static final int DURATION_FIELD_NUMBER = 7;
        public static final int FB_TIME_FIELD_NUMBER = 8;
        public static final int GROUP_ID_FIELD_NUMBER = 10;
        public static final int LID_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int RANK_FIELD_NUMBER = 5;
        public static final int SCORE_FIELD_NUMBER = 6;
        public static final int UID_FIELD_NUMBER = 1;
        public static final int WIN_STREAK_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int buffTime_;
        private int duration_;
        private int fbTime_;
        private int groupId_;
        private int lid_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int rank_;
        private float score_;
        private int uid_;
        private int winStreak_;
        private static final StartRecord DEFAULT_INSTANCE = new StartRecord();
        private static final Parser<StartRecord> PARSER = new AbstractParser<StartRecord>() { // from class: cn.irisgw.live.MultiPkStart.StartRecord.1
            /* renamed from: parsePartialFrom */
            public StartRecord m6176parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StartRecord(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkStart$StartRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StartRecordOrBuilder {
            private int buffTime_;
            private int duration_;
            private int fbTime_;
            private int groupId_;
            private int lid_;
            private Object name_;
            private int rank_;
            private float score_;
            private int uid_;
            private int winStreak_;

            private Builder() {
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_MultiPkStart_StartRecord_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = StartRecord.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m6178addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public StartRecord m6180build() {
                StartRecord m6182buildPartial = m6182buildPartial();
                if (m6182buildPartial.isInitialized()) {
                    return m6182buildPartial;
                }
                throw newUninitializedMessageException(m6182buildPartial);
            }

            /* renamed from: buildPartial */
            public StartRecord m6182buildPartial() {
                StartRecord startRecord = new StartRecord(this);
                startRecord.uid_ = this.uid_;
                startRecord.lid_ = this.lid_;
                startRecord.name_ = this.name_;
                startRecord.winStreak_ = this.winStreak_;
                startRecord.rank_ = this.rank_;
                startRecord.score_ = this.score_;
                startRecord.duration_ = this.duration_;
                startRecord.fbTime_ = this.fbTime_;
                startRecord.buffTime_ = this.buffTime_;
                startRecord.groupId_ = this.groupId_;
                onBuilt();
                return startRecord;
            }

            /* renamed from: clear */
            public Builder m6186clear() {
                super.clear();
                this.uid_ = 0;
                this.lid_ = 0;
                this.name_ = "";
                this.winStreak_ = 0;
                this.rank_ = 0;
                this.score_ = 0.0f;
                this.duration_ = 0;
                this.fbTime_ = 0;
                this.buffTime_ = 0;
                this.groupId_ = 0;
                return this;
            }

            public Builder clearBuffTime() {
                this.buffTime_ = 0;
                onChanged();
                return this;
            }

            public Builder clearDuration() {
                this.duration_ = 0;
                onChanged();
                return this;
            }

            public Builder clearFbTime() {
                this.fbTime_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m6188clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearGroupId() {
                this.groupId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearLid() {
                this.lid_ = 0;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = StartRecord.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m6191clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
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

            public Builder clearWinStreak() {
                this.winStreak_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m6197clone() {
                return (Builder) super.clone();
            }

            @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
            public int getBuffTime() {
                return this.buffTime_;
            }

            /* renamed from: getDefaultInstanceForType */
            public StartRecord m6199getDefaultInstanceForType() {
                return StartRecord.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_MultiPkStart_StartRecord_descriptor;
            }

            @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
            public int getDuration() {
                return this.duration_;
            }

            @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
            public int getFbTime() {
                return this.fbTime_;
            }

            @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
            public int getGroupId() {
                return this.groupId_;
            }

            @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
            public int getLid() {
                return this.lid_;
            }

            @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
            public int getRank() {
                return this.rank_;
            }

            @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
            public float getScore() {
                return this.score_;
            }

            @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
            public int getUid() {
                return this.uid_;
            }

            @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
            public int getWinStreak() {
                return this.winStreak_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_MultiPkStart_StartRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(StartRecord.class, Builder.class);
            }

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
                if (!startRecord.getName().isEmpty()) {
                    this.name_ = startRecord.name_;
                    onChanged();
                }
                if (startRecord.getWinStreak() != 0) {
                    setWinStreak(startRecord.getWinStreak());
                }
                if (startRecord.getRank() != 0) {
                    setRank(startRecord.getRank());
                }
                if (startRecord.getScore() != 0.0f) {
                    setScore(startRecord.getScore());
                }
                if (startRecord.getDuration() != 0) {
                    setDuration(startRecord.getDuration());
                }
                if (startRecord.getFbTime() != 0) {
                    setFbTime(startRecord.getFbTime());
                }
                if (startRecord.getBuffTime() != 0) {
                    setBuffTime(startRecord.getBuffTime());
                }
                if (startRecord.getGroupId() != 0) {
                    setGroupId(startRecord.getGroupId());
                }
                m6208mergeUnknownFields(startRecord.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.MultiPkStart.StartRecord.Builder m6205mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.MultiPkStart.StartRecord.access$1500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.MultiPkStart$StartRecord r0 = (cn.irisgw.live.MultiPkStart.StartRecord) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.MultiPkStart$StartRecord$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.MultiPkStart$StartRecord r0 = (cn.irisgw.live.MultiPkStart.StartRecord) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.MultiPkStart$StartRecord$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.MultiPkStart.StartRecord.Builder.m6205mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.MultiPkStart$StartRecord$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m6204mergeFrom(Message message) {
                if (message instanceof StartRecord) {
                    return mergeFrom((StartRecord) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m6208mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBuffTime(int i) {
                this.buffTime_ = i;
                onChanged();
                return this;
            }

            public Builder setDuration(int i) {
                this.duration_ = i;
                onChanged();
                return this;
            }

            public Builder setFbTime(int i) {
                this.fbTime_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setField */
            public Builder m6210setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setGroupId(int i) {
                this.groupId_ = i;
                onChanged();
                return this;
            }

            public Builder setLid(int i) {
                this.lid_ = i;
                onChanged();
                return this;
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
                    StartRecord.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRank(int i) {
                this.rank_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setRepeatedField */
            public Builder m6212setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
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

            /* renamed from: setUnknownFields */
            public final Builder m6214setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setWinStreak(int i) {
                this.winStreak_ = i;
                onChanged();
                return this;
            }
        }

        private StartRecord() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
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
                            case 26:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 32:
                                this.winStreak_ = codedInputStream.readUInt32();
                                continue;
                            case 40:
                                this.rank_ = codedInputStream.readUInt32();
                                continue;
                            case 53:
                                this.score_ = codedInputStream.readFloat();
                                continue;
                            case 56:
                                this.duration_ = codedInputStream.readUInt32();
                                continue;
                            case 64:
                                this.fbTime_ = codedInputStream.readUInt32();
                                continue;
                            case 72:
                                this.buffTime_ = codedInputStream.readUInt32();
                                continue;
                            case 80:
                                this.groupId_ = codedInputStream.readUInt32();
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
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
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
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkStart_StartRecord_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m6175toBuilder();
        }

        public static Builder newBuilder(StartRecord startRecord) {
            return DEFAULT_INSTANCE.m6175toBuilder().mergeFrom(startRecord);
        }

        public static StartRecord parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static StartRecord parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static StartRecord parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StartRecord) PARSER.parseFrom(byteString);
        }

        public static StartRecord parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartRecord) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static StartRecord parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static StartRecord parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static StartRecord parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static StartRecord parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static StartRecord parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StartRecord) PARSER.parseFrom(byteBuffer);
        }

        public static StartRecord parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartRecord) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static StartRecord parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StartRecord) PARSER.parseFrom(bArr);
        }

        public static StartRecord parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StartRecord) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<StartRecord> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof StartRecord) {
                StartRecord startRecord = (StartRecord) obj;
                return getUid() == startRecord.getUid() && getLid() == startRecord.getLid() && getName().equals(startRecord.getName()) && getWinStreak() == startRecord.getWinStreak() && getRank() == startRecord.getRank() && Float.floatToIntBits(getScore()) == Float.floatToIntBits(startRecord.getScore()) && getDuration() == startRecord.getDuration() && getFbTime() == startRecord.getFbTime() && getBuffTime() == startRecord.getBuffTime() && getGroupId() == startRecord.getGroupId() && this.unknownFields.equals(startRecord.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
        public int getBuffTime() {
            return this.buffTime_;
        }

        /* renamed from: getDefaultInstanceForType */
        public StartRecord m6170getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
        public int getDuration() {
            return this.duration_;
        }

        @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
        public int getFbTime() {
            return this.fbTime_;
        }

        @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
        public int getLid() {
            return this.lid_;
        }

        @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<StartRecord> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
        public int getRank() {
            return this.rank_;
        }

        @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
        public float getScore() {
            return this.score_;
        }

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
            int i6 = i5;
            if (!getNameBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(3, this.name_);
            }
            int i7 = this.winStreak_;
            int i8 = i6;
            if (i7 != 0) {
                i8 = i6 + CodedOutputStream.computeUInt32Size(4, i7);
            }
            int i9 = this.rank_;
            int i10 = i8;
            if (i9 != 0) {
                i10 = i8 + CodedOutputStream.computeUInt32Size(5, i9);
            }
            float f = this.score_;
            int i11 = i10;
            if (f != 0.0f) {
                i11 = i10 + CodedOutputStream.computeFloatSize(6, f);
            }
            int i12 = this.duration_;
            int i13 = i11;
            if (i12 != 0) {
                i13 = i11 + CodedOutputStream.computeUInt32Size(7, i12);
            }
            int i14 = this.fbTime_;
            int i15 = i13;
            if (i14 != 0) {
                i15 = i13 + CodedOutputStream.computeUInt32Size(8, i14);
            }
            int i16 = this.buffTime_;
            int i17 = i15;
            if (i16 != 0) {
                i17 = i15 + CodedOutputStream.computeUInt32Size(9, i16);
            }
            int i18 = this.groupId_;
            int i19 = i17;
            if (i18 != 0) {
                i19 = i17 + CodedOutputStream.computeUInt32Size(10, i18);
            }
            int serializedSize = i19 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
        public int getUid() {
            return this.uid_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.MultiPkStart.StartRecordOrBuilder
        public int getWinStreak() {
            return this.winStreak_;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getLid()) * 37) + 3) * 53) + getName().hashCode()) * 37) + 4) * 53) + getWinStreak()) * 37) + 5) * 53) + getRank()) * 37) + 6) * 53) + Float.floatToIntBits(getScore())) * 37) + 7) * 53) + getDuration()) * 37) + 8) * 53) + getFbTime()) * 37) + 9) * 53) + getBuffTime()) * 37) + 10) * 53) + getGroupId()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkStart_StartRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(StartRecord.class, Builder.class);
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
        public Builder m6173newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m6172newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new StartRecord();
        }

        /* renamed from: toBuilder */
        public Builder m6175toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.uid_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            int i2 = this.lid_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(2, i2);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.name_);
            }
            int i3 = this.winStreak_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(4, i3);
            }
            int i4 = this.rank_;
            if (i4 != 0) {
                codedOutputStream.writeUInt32(5, i4);
            }
            float f = this.score_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(6, f);
            }
            int i5 = this.duration_;
            if (i5 != 0) {
                codedOutputStream.writeUInt32(7, i5);
            }
            int i6 = this.fbTime_;
            if (i6 != 0) {
                codedOutputStream.writeUInt32(8, i6);
            }
            int i7 = this.buffTime_;
            if (i7 != 0) {
                codedOutputStream.writeUInt32(9, i7);
            }
            int i8 = this.groupId_;
            if (i8 != 0) {
                codedOutputStream.writeUInt32(10, i8);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkStart$StartRecordOrBuilder.class */
    public interface StartRecordOrBuilder extends MessageOrBuilder {
        int getBuffTime();

        int getDuration();

        int getFbTime();

        int getGroupId();

        int getLid();

        String getName();

        ByteString getNameBytes();

        int getRank();

        float getScore();

        int getUid();

        int getWinStreak();
    }

    private MultiPkStart() {
        this.memoizedIsInitialized = (byte) -1;
        this.users_ = Collections.emptyList();
        this.firstKillMessage_ = "";
    }

    private MultiPkStart(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        } else if (readTag == 18) {
                            this.firstKillMessage_ = codedInputStream.readStringRequireUtf8();
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (IOException e) {
                    throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
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

    private MultiPkStart(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MultiPkStart getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_MultiPkStart_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m6128toBuilder();
    }

    public static Builder newBuilder(MultiPkStart multiPkStart) {
        return DEFAULT_INSTANCE.m6128toBuilder().mergeFrom(multiPkStart);
    }

    public static MultiPkStart parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static MultiPkStart parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiPkStart parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MultiPkStart) PARSER.parseFrom(byteString);
    }

    public static MultiPkStart parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MultiPkStart) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static MultiPkStart parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static MultiPkStart parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static MultiPkStart parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static MultiPkStart parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiPkStart parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MultiPkStart) PARSER.parseFrom(byteBuffer);
    }

    public static MultiPkStart parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MultiPkStart) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static MultiPkStart parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MultiPkStart) PARSER.parseFrom(bArr);
    }

    public static MultiPkStart parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MultiPkStart) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<MultiPkStart> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiPkStart) {
            MultiPkStart multiPkStart = (MultiPkStart) obj;
            return getUsersList().equals(multiPkStart.getUsersList()) && getFirstKillMessage().equals(multiPkStart.getFirstKillMessage()) && this.unknownFields.equals(multiPkStart.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public MultiPkStart m6123getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.MultiPkStartOrBuilder
    public String getFirstKillMessage() {
        Object obj = this.firstKillMessage_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.firstKillMessage_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.MultiPkStartOrBuilder
    public ByteString getFirstKillMessageBytes() {
        Object obj = this.firstKillMessage_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.firstKillMessage_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<MultiPkStart> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.users_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.users_.get(i3));
        }
        int i4 = i2;
        if (!getFirstKillMessageBytes().isEmpty()) {
            i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.firstKillMessage_);
        }
        int serializedSize = i4 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.MultiPkStartOrBuilder
    public StartRecord getUsers(int i) {
        return this.users_.get(i);
    }

    @Override // cn.irisgw.live.MultiPkStartOrBuilder
    public int getUsersCount() {
        return this.users_.size();
    }

    @Override // cn.irisgw.live.MultiPkStartOrBuilder
    public List<StartRecord> getUsersList() {
        return this.users_;
    }

    @Override // cn.irisgw.live.MultiPkStartOrBuilder
    public StartRecordOrBuilder getUsersOrBuilder(int i) {
        return this.users_.get(i);
    }

    @Override // cn.irisgw.live.MultiPkStartOrBuilder
    public List<? extends StartRecordOrBuilder> getUsersOrBuilderList() {
        return this.users_;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (getUsersCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getUsersList().hashCode();
        }
        int hashCode2 = (((((i * 37) + 2) * 53) + getFirstKillMessage().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_MultiPkStart_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiPkStart.class, Builder.class);
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
    public Builder m6126newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m6125newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new MultiPkStart();
    }

    /* renamed from: toBuilder */
    public Builder m6128toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.users_.size()) {
                break;
            }
            codedOutputStream.writeMessage(1, this.users_.get(i2));
            i = i2 + 1;
        }
        if (!getFirstKillMessageBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.firstKillMessage_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
