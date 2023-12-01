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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkEnd.class */
public final class MultiPkEnd extends GeneratedMessageV3 implements MultiPkEndOrBuilder {
    private static final MultiPkEnd DEFAULT_INSTANCE = new MultiPkEnd();
    private static final Parser<MultiPkEnd> PARSER = new AbstractParser<MultiPkEnd>() { // from class: cn.irisgw.live.MultiPkEnd.1
        /* renamed from: parsePartialFrom */
        public MultiPkEnd m5847parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new MultiPkEnd(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int USERS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<StartRecord> users_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkEnd$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MultiPkEndOrBuilder {
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
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkEnd_descriptor;
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
            if (MultiPkEnd.alwaysUseFieldBuilders) {
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
        public Builder m5849addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addUsers(int i, StartRecord.Builder builder) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m5898build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.add(i, builder.m5898build());
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
                repeatedFieldBuilderV3.addMessage(builder.m5898build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.add(builder.m5898build());
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
        public MultiPkEnd m5851build() {
            MultiPkEnd m5853buildPartial = m5853buildPartial();
            if (m5853buildPartial.isInitialized()) {
                return m5853buildPartial;
            }
            throw newUninitializedMessageException(m5853buildPartial);
        }

        /* renamed from: buildPartial */
        public MultiPkEnd m5853buildPartial() {
            MultiPkEnd multiPkEnd = new MultiPkEnd(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.users_ = Collections.unmodifiableList(this.users_);
                    this.bitField0_ &= -2;
                }
                multiPkEnd.users_ = this.users_;
            } else {
                multiPkEnd.users_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return multiPkEnd;
        }

        /* renamed from: clear */
        public Builder m5857clear() {
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

        /* renamed from: clearField */
        public Builder m5859clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m5862clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
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
        public Builder m5868clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public MultiPkEnd m5870getDefaultInstanceForType() {
            return MultiPkEnd.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkEnd_descriptor;
        }

        @Override // cn.irisgw.live.MultiPkEndOrBuilder
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

        @Override // cn.irisgw.live.MultiPkEndOrBuilder
        public int getUsersCount() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.users_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.MultiPkEndOrBuilder
        public List<StartRecord> getUsersList() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.users_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.MultiPkEndOrBuilder
        public StartRecordOrBuilder getUsersOrBuilder(int i) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.users_.get(i) : (StartRecordOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.MultiPkEndOrBuilder
        public List<? extends StartRecordOrBuilder> getUsersOrBuilderList() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.users_);
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkEnd_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiPkEnd.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(MultiPkEnd multiPkEnd) {
            if (multiPkEnd == MultiPkEnd.getDefaultInstance()) {
                return this;
            }
            if (this.usersBuilder_ == null) {
                if (!multiPkEnd.users_.isEmpty()) {
                    if (this.users_.isEmpty()) {
                        this.users_ = multiPkEnd.users_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUsersIsMutable();
                        this.users_.addAll(multiPkEnd.users_);
                    }
                    onChanged();
                }
            } else if (!multiPkEnd.users_.isEmpty()) {
                if (this.usersBuilder_.isEmpty()) {
                    this.usersBuilder_.dispose();
                    RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = null;
                    this.usersBuilder_ = null;
                    this.users_ = multiPkEnd.users_;
                    this.bitField0_ &= -2;
                    if (MultiPkEnd.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getUsersFieldBuilder();
                    }
                    this.usersBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.usersBuilder_.addAllMessages(multiPkEnd.users_);
                }
            }
            m5879mergeUnknownFields(multiPkEnd.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.MultiPkEnd.Builder m5876mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.MultiPkEnd.access$2800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.MultiPkEnd r0 = (cn.irisgw.live.MultiPkEnd) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.MultiPkEnd$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.MultiPkEnd r0 = (cn.irisgw.live.MultiPkEnd) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.MultiPkEnd$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.MultiPkEnd.Builder.m5876mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.MultiPkEnd$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m5875mergeFrom(Message message) {
            if (message instanceof MultiPkEnd) {
                return mergeFrom((MultiPkEnd) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m5879mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
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
        public Builder m5881setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m5883setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m5885setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setUsers(int i, StartRecord.Builder builder) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m5898build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.set(i, builder.m5898build());
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkEnd$StartRecord.class */
    public static final class StartRecord extends GeneratedMessageV3 implements StartRecordOrBuilder {
        public static final int DURATION_FIELD_NUMBER = 5;
        public static final int GROUP_ID_FIELD_NUMBER = 11;
        public static final int INTERACTION_TEXT_FIELD_NUMBER = 6;
        public static final int LID_FIELD_NUMBER = 2;
        public static final int MVP_AVATAR_FIELD_NUMBER = 8;
        public static final int MVP_HIDE_FIELD_NUMBER = 10;
        public static final int MVP_NAME_FIELD_NUMBER = 9;
        public static final int MVP_UID_FIELD_NUMBER = 7;
        public static final int RESULT_FIELD_NUMBER = 4;
        public static final int UID_FIELD_NUMBER = 1;
        public static final int WIN_STREAK_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int duration_;
        private int groupId_;
        private volatile Object interactionText_;
        private int lid_;
        private byte memoizedIsInitialized;
        private volatile Object mvpAvatar_;
        private boolean mvpHide_;
        private volatile Object mvpName_;
        private int mvpUid_;
        private int result_;
        private int uid_;
        private int winStreak_;
        private static final StartRecord DEFAULT_INSTANCE = new StartRecord();
        private static final Parser<StartRecord> PARSER = new AbstractParser<StartRecord>() { // from class: cn.irisgw.live.MultiPkEnd.StartRecord.1
            /* renamed from: parsePartialFrom */
            public StartRecord m5894parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StartRecord(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkEnd$StartRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StartRecordOrBuilder {
            private int duration_;
            private int groupId_;
            private Object interactionText_;
            private int lid_;
            private Object mvpAvatar_;
            private boolean mvpHide_;
            private Object mvpName_;
            private int mvpUid_;
            private int result_;
            private int uid_;
            private int winStreak_;

            private Builder() {
                this.interactionText_ = "";
                this.mvpAvatar_ = "";
                this.mvpName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.interactionText_ = "";
                this.mvpAvatar_ = "";
                this.mvpName_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_MultiPkEnd_StartRecord_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = StartRecord.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m5896addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public StartRecord m5898build() {
                StartRecord m5900buildPartial = m5900buildPartial();
                if (m5900buildPartial.isInitialized()) {
                    return m5900buildPartial;
                }
                throw newUninitializedMessageException(m5900buildPartial);
            }

            /* renamed from: buildPartial */
            public StartRecord m5900buildPartial() {
                StartRecord startRecord = new StartRecord(this);
                startRecord.uid_ = this.uid_;
                startRecord.lid_ = this.lid_;
                startRecord.winStreak_ = this.winStreak_;
                startRecord.result_ = this.result_;
                startRecord.duration_ = this.duration_;
                startRecord.interactionText_ = this.interactionText_;
                startRecord.mvpUid_ = this.mvpUid_;
                startRecord.mvpAvatar_ = this.mvpAvatar_;
                startRecord.mvpName_ = this.mvpName_;
                startRecord.mvpHide_ = this.mvpHide_;
                startRecord.groupId_ = this.groupId_;
                onBuilt();
                return startRecord;
            }

            /* renamed from: clear */
            public Builder m5904clear() {
                super.clear();
                this.uid_ = 0;
                this.lid_ = 0;
                this.winStreak_ = 0;
                this.result_ = 0;
                this.duration_ = 0;
                this.interactionText_ = "";
                this.mvpUid_ = 0;
                this.mvpAvatar_ = "";
                this.mvpName_ = "";
                this.mvpHide_ = false;
                this.groupId_ = 0;
                return this;
            }

            public Builder clearDuration() {
                this.duration_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m5906clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearGroupId() {
                this.groupId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearInteractionText() {
                this.interactionText_ = StartRecord.getDefaultInstance().getInteractionText();
                onChanged();
                return this;
            }

            public Builder clearLid() {
                this.lid_ = 0;
                onChanged();
                return this;
            }

            public Builder clearMvpAvatar() {
                this.mvpAvatar_ = StartRecord.getDefaultInstance().getMvpAvatar();
                onChanged();
                return this;
            }

            public Builder clearMvpHide() {
                this.mvpHide_ = false;
                onChanged();
                return this;
            }

            public Builder clearMvpName() {
                this.mvpName_ = StartRecord.getDefaultInstance().getMvpName();
                onChanged();
                return this;
            }

            public Builder clearMvpUid() {
                this.mvpUid_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m5909clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearResult() {
                this.result_ = 0;
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
            public Builder m5915clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public StartRecord m5917getDefaultInstanceForType() {
                return StartRecord.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_MultiPkEnd_StartRecord_descriptor;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public int getDuration() {
                return this.duration_;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public int getGroupId() {
                return this.groupId_;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public String getInteractionText() {
                Object obj = this.interactionText_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.interactionText_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public ByteString getInteractionTextBytes() {
                Object obj = this.interactionText_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.interactionText_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public int getLid() {
                return this.lid_;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public String getMvpAvatar() {
                Object obj = this.mvpAvatar_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.mvpAvatar_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public ByteString getMvpAvatarBytes() {
                Object obj = this.mvpAvatar_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.mvpAvatar_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public boolean getMvpHide() {
                return this.mvpHide_;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public String getMvpName() {
                Object obj = this.mvpName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.mvpName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public ByteString getMvpNameBytes() {
                Object obj = this.mvpName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.mvpName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public int getMvpUid() {
                return this.mvpUid_;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public int getResult() {
                return this.result_;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public int getUid() {
                return this.uid_;
            }

            @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
            public int getWinStreak() {
                return this.winStreak_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_MultiPkEnd_StartRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(StartRecord.class, Builder.class);
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
                if (startRecord.getWinStreak() != 0) {
                    setWinStreak(startRecord.getWinStreak());
                }
                if (startRecord.getResult() != 0) {
                    setResult(startRecord.getResult());
                }
                if (startRecord.getDuration() != 0) {
                    setDuration(startRecord.getDuration());
                }
                if (!startRecord.getInteractionText().isEmpty()) {
                    this.interactionText_ = startRecord.interactionText_;
                    onChanged();
                }
                if (startRecord.getMvpUid() != 0) {
                    setMvpUid(startRecord.getMvpUid());
                }
                if (!startRecord.getMvpAvatar().isEmpty()) {
                    this.mvpAvatar_ = startRecord.mvpAvatar_;
                    onChanged();
                }
                if (!startRecord.getMvpName().isEmpty()) {
                    this.mvpName_ = startRecord.mvpName_;
                    onChanged();
                }
                if (startRecord.getMvpHide()) {
                    setMvpHide(startRecord.getMvpHide());
                }
                if (startRecord.getGroupId() != 0) {
                    setGroupId(startRecord.getGroupId());
                }
                m5926mergeUnknownFields(startRecord.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.MultiPkEnd.StartRecord.Builder m5923mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.MultiPkEnd.StartRecord.access$1600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.MultiPkEnd$StartRecord r0 = (cn.irisgw.live.MultiPkEnd.StartRecord) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.MultiPkEnd$StartRecord$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.MultiPkEnd$StartRecord r0 = (cn.irisgw.live.MultiPkEnd.StartRecord) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.MultiPkEnd$StartRecord$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.MultiPkEnd.StartRecord.Builder.m5923mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.MultiPkEnd$StartRecord$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m5922mergeFrom(Message message) {
                if (message instanceof StartRecord) {
                    return mergeFrom((StartRecord) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m5926mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setDuration(int i) {
                this.duration_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setField */
            public Builder m5928setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setGroupId(int i) {
                this.groupId_ = i;
                onChanged();
                return this;
            }

            public Builder setInteractionText(String str) {
                if (str != null) {
                    this.interactionText_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setInteractionTextBytes(ByteString byteString) {
                if (byteString != null) {
                    StartRecord.checkByteStringIsUtf8(byteString);
                    this.interactionText_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLid(int i) {
                this.lid_ = i;
                onChanged();
                return this;
            }

            public Builder setMvpAvatar(String str) {
                if (str != null) {
                    this.mvpAvatar_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMvpAvatarBytes(ByteString byteString) {
                if (byteString != null) {
                    StartRecord.checkByteStringIsUtf8(byteString);
                    this.mvpAvatar_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMvpHide(boolean z) {
                this.mvpHide_ = z;
                onChanged();
                return this;
            }

            public Builder setMvpName(String str) {
                if (str != null) {
                    this.mvpName_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMvpNameBytes(ByteString byteString) {
                if (byteString != null) {
                    StartRecord.checkByteStringIsUtf8(byteString);
                    this.mvpName_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMvpUid(int i) {
                this.mvpUid_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setRepeatedField */
            public Builder m5930setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setResult(int i) {
                this.result_ = i;
                onChanged();
                return this;
            }

            public Builder setUid(int i) {
                this.uid_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setUnknownFields */
            public final Builder m5932setUnknownFields(UnknownFieldSet unknownFieldSet) {
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
            this.interactionText_ = "";
            this.mvpAvatar_ = "";
            this.mvpName_ = "";
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
                                    this.winStreak_ = codedInputStream.readUInt32();
                                    continue;
                                case 32:
                                    this.result_ = codedInputStream.readUInt32();
                                    continue;
                                case 40:
                                    this.duration_ = codedInputStream.readUInt32();
                                    continue;
                                case 50:
                                    this.interactionText_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 56:
                                    this.mvpUid_ = codedInputStream.readUInt32();
                                    continue;
                                case 66:
                                    this.mvpAvatar_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 74:
                                    this.mvpName_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 80:
                                    this.mvpHide_ = codedInputStream.readBool();
                                    continue;
                                case 88:
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
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkEnd_StartRecord_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m5893toBuilder();
        }

        public static Builder newBuilder(StartRecord startRecord) {
            return DEFAULT_INSTANCE.m5893toBuilder().mergeFrom(startRecord);
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
                return getUid() == startRecord.getUid() && getLid() == startRecord.getLid() && getWinStreak() == startRecord.getWinStreak() && getResult() == startRecord.getResult() && getDuration() == startRecord.getDuration() && getInteractionText().equals(startRecord.getInteractionText()) && getMvpUid() == startRecord.getMvpUid() && getMvpAvatar().equals(startRecord.getMvpAvatar()) && getMvpName().equals(startRecord.getMvpName()) && getMvpHide() == startRecord.getMvpHide() && getGroupId() == startRecord.getGroupId() && this.unknownFields.equals(startRecord.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public StartRecord m5888getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public int getDuration() {
            return this.duration_;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public String getInteractionText() {
            Object obj = this.interactionText_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.interactionText_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public ByteString getInteractionTextBytes() {
            Object obj = this.interactionText_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.interactionText_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public int getLid() {
            return this.lid_;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public String getMvpAvatar() {
            Object obj = this.mvpAvatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mvpAvatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public ByteString getMvpAvatarBytes() {
            Object obj = this.mvpAvatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mvpAvatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public boolean getMvpHide() {
            return this.mvpHide_;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public String getMvpName() {
            Object obj = this.mvpName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mvpName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public ByteString getMvpNameBytes() {
            Object obj = this.mvpName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mvpName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public int getMvpUid() {
            return this.mvpUid_;
        }

        public Parser<StartRecord> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public int getResult() {
            return this.result_;
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
            int i6 = this.winStreak_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeUInt32Size(3, i6);
            }
            int i8 = this.result_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeUInt32Size(4, i8);
            }
            int i10 = this.duration_;
            int i11 = i9;
            if (i10 != 0) {
                i11 = i9 + CodedOutputStream.computeUInt32Size(5, i10);
            }
            int i12 = i11;
            if (!getInteractionTextBytes().isEmpty()) {
                i12 = i11 + GeneratedMessageV3.computeStringSize(6, this.interactionText_);
            }
            int i13 = this.mvpUid_;
            int i14 = i12;
            if (i13 != 0) {
                i14 = i12 + CodedOutputStream.computeUInt32Size(7, i13);
            }
            int i15 = i14;
            if (!getMvpAvatarBytes().isEmpty()) {
                i15 = i14 + GeneratedMessageV3.computeStringSize(8, this.mvpAvatar_);
            }
            int i16 = i15;
            if (!getMvpNameBytes().isEmpty()) {
                i16 = i15 + GeneratedMessageV3.computeStringSize(9, this.mvpName_);
            }
            boolean z = this.mvpHide_;
            int i17 = i16;
            if (z) {
                i17 = i16 + CodedOutputStream.computeBoolSize(10, z);
            }
            int i18 = this.groupId_;
            int i19 = i17;
            if (i18 != 0) {
                i19 = i17 + CodedOutputStream.computeUInt32Size(11, i18);
            }
            int serializedSize = i19 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public int getUid() {
            return this.uid_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.MultiPkEnd.StartRecordOrBuilder
        public int getWinStreak() {
            return this.winStreak_;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getLid()) * 37) + 3) * 53) + getWinStreak()) * 37) + 4) * 53) + getResult()) * 37) + 5) * 53) + getDuration()) * 37) + 6) * 53) + getInteractionText().hashCode()) * 37) + 7) * 53) + getMvpUid()) * 37) + 8) * 53) + getMvpAvatar().hashCode()) * 37) + 9) * 53) + getMvpName().hashCode()) * 37) + 10) * 53) + Internal.hashBoolean(getMvpHide())) * 37) + 11) * 53) + getGroupId()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkEnd_StartRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(StartRecord.class, Builder.class);
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
        public Builder m5891newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m5890newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new StartRecord();
        }

        /* renamed from: toBuilder */
        public Builder m5893toBuilder() {
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
            int i3 = this.winStreak_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(3, i3);
            }
            int i4 = this.result_;
            if (i4 != 0) {
                codedOutputStream.writeUInt32(4, i4);
            }
            int i5 = this.duration_;
            if (i5 != 0) {
                codedOutputStream.writeUInt32(5, i5);
            }
            if (!getInteractionTextBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.interactionText_);
            }
            int i6 = this.mvpUid_;
            if (i6 != 0) {
                codedOutputStream.writeUInt32(7, i6);
            }
            if (!getMvpAvatarBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.mvpAvatar_);
            }
            if (!getMvpNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.mvpName_);
            }
            boolean z = this.mvpHide_;
            if (z) {
                codedOutputStream.writeBool(10, z);
            }
            int i7 = this.groupId_;
            if (i7 != 0) {
                codedOutputStream.writeUInt32(11, i7);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkEnd$StartRecordOrBuilder.class */
    public interface StartRecordOrBuilder extends MessageOrBuilder {
        int getDuration();

        int getGroupId();

        String getInteractionText();

        ByteString getInteractionTextBytes();

        int getLid();

        String getMvpAvatar();

        ByteString getMvpAvatarBytes();

        boolean getMvpHide();

        String getMvpName();

        ByteString getMvpNameBytes();

        int getMvpUid();

        int getResult();

        int getUid();

        int getWinStreak();
    }

    private MultiPkEnd() {
        this.memoizedIsInitialized = (byte) -1;
        this.users_ = Collections.emptyList();
    }

    private MultiPkEnd(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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

    private MultiPkEnd(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MultiPkEnd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_MultiPkEnd_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m5846toBuilder();
    }

    public static Builder newBuilder(MultiPkEnd multiPkEnd) {
        return DEFAULT_INSTANCE.m5846toBuilder().mergeFrom(multiPkEnd);
    }

    public static MultiPkEnd parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static MultiPkEnd parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiPkEnd parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MultiPkEnd) PARSER.parseFrom(byteString);
    }

    public static MultiPkEnd parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MultiPkEnd) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static MultiPkEnd parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static MultiPkEnd parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static MultiPkEnd parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static MultiPkEnd parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiPkEnd parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MultiPkEnd) PARSER.parseFrom(byteBuffer);
    }

    public static MultiPkEnd parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MultiPkEnd) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static MultiPkEnd parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MultiPkEnd) PARSER.parseFrom(bArr);
    }

    public static MultiPkEnd parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MultiPkEnd) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<MultiPkEnd> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiPkEnd) {
            MultiPkEnd multiPkEnd = (MultiPkEnd) obj;
            return getUsersList().equals(multiPkEnd.getUsersList()) && this.unknownFields.equals(multiPkEnd.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public MultiPkEnd m5841getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<MultiPkEnd> getParserForType() {
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
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.MultiPkEndOrBuilder
    public StartRecord getUsers(int i) {
        return this.users_.get(i);
    }

    @Override // cn.irisgw.live.MultiPkEndOrBuilder
    public int getUsersCount() {
        return this.users_.size();
    }

    @Override // cn.irisgw.live.MultiPkEndOrBuilder
    public List<StartRecord> getUsersList() {
        return this.users_;
    }

    @Override // cn.irisgw.live.MultiPkEndOrBuilder
    public StartRecordOrBuilder getUsersOrBuilder(int i) {
        return this.users_.get(i);
    }

    @Override // cn.irisgw.live.MultiPkEndOrBuilder
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
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_MultiPkEnd_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiPkEnd.class, Builder.class);
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
    public Builder m5844newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m5843newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new MultiPkEnd();
    }

    /* renamed from: toBuilder */
    public Builder m5846toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

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
