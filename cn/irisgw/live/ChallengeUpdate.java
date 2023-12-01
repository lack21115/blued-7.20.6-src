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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeUpdate.class */
public final class ChallengeUpdate extends GeneratedMessageV3 implements ChallengeUpdateOrBuilder {
    public static final int IS_EGG_FIELD_NUMBER = 2;
    public static final int RECORDS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private boolean isEgg_;
    private byte memoizedIsInitialized;
    private List<ChallengeScoreUpdate> records_;
    private static final ChallengeUpdate DEFAULT_INSTANCE = new ChallengeUpdate();
    private static final Parser<ChallengeUpdate> PARSER = new AbstractParser<ChallengeUpdate>() { // from class: cn.irisgw.live.ChallengeUpdate.1
        @Override // com.google.protobuf.Parser
        public ChallengeUpdate parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ChallengeUpdate(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeUpdate$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallengeUpdateOrBuilder {
        private int bitField0_;
        private boolean isEgg_;
        private RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> recordsBuilder_;
        private List<ChallengeScoreUpdate> records_;

        private Builder() {
            this.records_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.records_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureRecordsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.records_ = new ArrayList(this.records_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeUpdate_descriptor;
        }

        private RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> getRecordsFieldBuilder() {
            if (this.recordsBuilder_ == null) {
                List<ChallengeScoreUpdate> list = this.records_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.recordsBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.records_ = null;
            }
            return this.recordsBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (ChallengeUpdate.alwaysUseFieldBuilders) {
                getRecordsFieldBuilder();
            }
        }

        public Builder addAllRecords(Iterable<? extends ChallengeScoreUpdate> iterable) {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureRecordsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.records_);
            onChanged();
            return this;
        }

        public Builder addRecords(int i, ChallengeScoreUpdate.Builder builder) {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addRecords(int i, ChallengeScoreUpdate challengeScoreUpdate) {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, challengeScoreUpdate);
                return this;
            } else if (challengeScoreUpdate != null) {
                ensureRecordsIsMutable();
                this.records_.add(i, challengeScoreUpdate);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addRecords(ChallengeScoreUpdate.Builder builder) {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addRecords(ChallengeScoreUpdate challengeScoreUpdate) {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(challengeScoreUpdate);
                return this;
            } else if (challengeScoreUpdate != null) {
                ensureRecordsIsMutable();
                this.records_.add(challengeScoreUpdate);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public ChallengeScoreUpdate.Builder addRecordsBuilder() {
            return getRecordsFieldBuilder().addBuilder(ChallengeScoreUpdate.getDefaultInstance());
        }

        public ChallengeScoreUpdate.Builder addRecordsBuilder(int i) {
            return getRecordsFieldBuilder().addBuilder(i, ChallengeScoreUpdate.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChallengeUpdate build() {
            ChallengeUpdate buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChallengeUpdate buildPartial() {
            ChallengeUpdate challengeUpdate = new ChallengeUpdate(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.records_ = Collections.unmodifiableList(this.records_);
                    this.bitField0_ &= -2;
                }
                challengeUpdate.records_ = this.records_;
            } else {
                challengeUpdate.records_ = repeatedFieldBuilderV3.build();
            }
            challengeUpdate.isEgg_ = this.isEgg_;
            onBuilt();
            return challengeUpdate;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.records_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.isEgg_ = false;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearIsEgg() {
            this.isEgg_ = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRecords() {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.records_ = Collections.emptyList();
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
        public ChallengeUpdate getDefaultInstanceForType() {
            return ChallengeUpdate.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeUpdate_descriptor;
        }

        @Override // cn.irisgw.live.ChallengeUpdateOrBuilder
        public boolean getIsEgg() {
            return this.isEgg_;
        }

        @Override // cn.irisgw.live.ChallengeUpdateOrBuilder
        public ChallengeScoreUpdate getRecords(int i) {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public ChallengeScoreUpdate.Builder getRecordsBuilder(int i) {
            return getRecordsFieldBuilder().getBuilder(i);
        }

        public List<ChallengeScoreUpdate.Builder> getRecordsBuilderList() {
            return getRecordsFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.ChallengeUpdateOrBuilder
        public int getRecordsCount() {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.ChallengeUpdateOrBuilder
        public List<ChallengeScoreUpdate> getRecordsList() {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.records_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.ChallengeUpdateOrBuilder
        public ChallengeScoreUpdateOrBuilder getRecordsOrBuilder(int i) {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.ChallengeUpdateOrBuilder
        public List<? extends ChallengeScoreUpdateOrBuilder> getRecordsOrBuilderList() {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.records_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeUpdate_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeUpdate.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ChallengeUpdate challengeUpdate) {
            if (challengeUpdate == ChallengeUpdate.getDefaultInstance()) {
                return this;
            }
            if (this.recordsBuilder_ == null) {
                if (!challengeUpdate.records_.isEmpty()) {
                    if (this.records_.isEmpty()) {
                        this.records_ = challengeUpdate.records_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRecordsIsMutable();
                        this.records_.addAll(challengeUpdate.records_);
                    }
                    onChanged();
                }
            } else if (!challengeUpdate.records_.isEmpty()) {
                if (this.recordsBuilder_.isEmpty()) {
                    this.recordsBuilder_.dispose();
                    RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = null;
                    this.recordsBuilder_ = null;
                    this.records_ = challengeUpdate.records_;
                    this.bitField0_ &= -2;
                    if (ChallengeUpdate.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getRecordsFieldBuilder();
                    }
                    this.recordsBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.recordsBuilder_.addAllMessages(challengeUpdate.records_);
                }
            }
            if (challengeUpdate.getIsEgg()) {
                setIsEgg(challengeUpdate.getIsEgg());
            }
            mergeUnknownFields(challengeUpdate.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ChallengeUpdate.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ChallengeUpdate.access$2700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ChallengeUpdate r0 = (cn.irisgw.live.ChallengeUpdate) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ChallengeUpdate$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ChallengeUpdate r0 = (cn.irisgw.live.ChallengeUpdate) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ChallengeUpdate$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ChallengeUpdate.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ChallengeUpdate$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ChallengeUpdate) {
                return mergeFrom((ChallengeUpdate) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeRecords(int i) {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.remove(i);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setIsEgg(boolean z) {
            this.isEgg_ = z;
            onChanged();
            return this;
        }

        public Builder setRecords(int i, ChallengeScoreUpdate.Builder builder) {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setRecords(int i, ChallengeScoreUpdate challengeScoreUpdate) {
            RepeatedFieldBuilderV3<ChallengeScoreUpdate, ChallengeScoreUpdate.Builder, ChallengeScoreUpdateOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, challengeScoreUpdate);
                return this;
            } else if (challengeScoreUpdate != null) {
                ensureRecordsIsMutable();
                this.records_.set(i, challengeScoreUpdate);
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeUpdate$ChallengeScoreUpdate.class */
    public static final class ChallengeScoreUpdate extends GeneratedMessageV3 implements ChallengeScoreUpdateOrBuilder {
        public static final int EGG_SCORE_FIELD_NUMBER = 6;
        public static final int FIRST_BLOOD_DESC_FIELD_NUMBER = 8;
        public static final int FIRST_BLOOD_DISPLAY_COUNTDOWN_FIELD_NUMBER = 9;
        public static final int FIRST_BLOOD_USER_NAME_FIELD_NUMBER = 5;
        public static final int HIDE_FIELD_NUMBER = 7;
        public static final int INCR_SCORE_FIELD_NUMBER = 2;
        public static final int IS_FIRST_BLOOD_FIELD_NUMBER = 4;
        public static final int SCORE_FIELD_NUMBER = 1;
        public static final int USER_PROP_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int eggScore_;
        private volatile Object firstBloodDesc_;
        private int firstBloodDisplayCountdown_;
        private volatile Object firstBloodUserName_;
        private boolean hide_;
        private int incrScore_;
        private boolean isFirstBlood_;
        private byte memoizedIsInitialized;
        private int score_;
        private List<UserProp> userProp_;
        private static final ChallengeScoreUpdate DEFAULT_INSTANCE = new ChallengeScoreUpdate();
        private static final Parser<ChallengeScoreUpdate> PARSER = new AbstractParser<ChallengeScoreUpdate>() { // from class: cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdate.1
            @Override // com.google.protobuf.Parser
            public ChallengeScoreUpdate parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ChallengeScoreUpdate(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeUpdate$ChallengeScoreUpdate$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallengeScoreUpdateOrBuilder {
            private int bitField0_;
            private int eggScore_;
            private Object firstBloodDesc_;
            private int firstBloodDisplayCountdown_;
            private Object firstBloodUserName_;
            private boolean hide_;
            private int incrScore_;
            private boolean isFirstBlood_;
            private int score_;
            private RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> userPropBuilder_;
            private List<UserProp> userProp_;

            private Builder() {
                this.userProp_ = Collections.emptyList();
                this.firstBloodUserName_ = "";
                this.firstBloodDesc_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.userProp_ = Collections.emptyList();
                this.firstBloodUserName_ = "";
                this.firstBloodDesc_ = "";
                maybeForceBuilderInitialization();
            }

            private void ensureUserPropIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.userProp_ = new ArrayList(this.userProp_);
                    this.bitField0_ |= 1;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_ChallengeUpdate_ChallengeScoreUpdate_descriptor;
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
                if (ChallengeScoreUpdate.alwaysUseFieldBuilders) {
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
            public ChallengeScoreUpdate build() {
                ChallengeScoreUpdate buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChallengeScoreUpdate buildPartial() {
                ChallengeScoreUpdate challengeScoreUpdate = new ChallengeScoreUpdate(this);
                challengeScoreUpdate.score_ = this.score_;
                challengeScoreUpdate.incrScore_ = this.incrScore_;
                RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.userProp_ = Collections.unmodifiableList(this.userProp_);
                        this.bitField0_ &= -2;
                    }
                    challengeScoreUpdate.userProp_ = this.userProp_;
                } else {
                    challengeScoreUpdate.userProp_ = repeatedFieldBuilderV3.build();
                }
                challengeScoreUpdate.isFirstBlood_ = this.isFirstBlood_;
                challengeScoreUpdate.firstBloodUserName_ = this.firstBloodUserName_;
                challengeScoreUpdate.eggScore_ = this.eggScore_;
                challengeScoreUpdate.hide_ = this.hide_;
                challengeScoreUpdate.firstBloodDesc_ = this.firstBloodDesc_;
                challengeScoreUpdate.firstBloodDisplayCountdown_ = this.firstBloodDisplayCountdown_;
                onBuilt();
                return challengeScoreUpdate;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.score_ = 0;
                this.incrScore_ = 0;
                RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.userProp_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                this.isFirstBlood_ = false;
                this.firstBloodUserName_ = "";
                this.eggScore_ = 0;
                this.hide_ = false;
                this.firstBloodDesc_ = "";
                this.firstBloodDisplayCountdown_ = 0;
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

            public Builder clearFirstBloodDesc() {
                this.firstBloodDesc_ = ChallengeScoreUpdate.getDefaultInstance().getFirstBloodDesc();
                onChanged();
                return this;
            }

            public Builder clearFirstBloodDisplayCountdown() {
                this.firstBloodDisplayCountdown_ = 0;
                onChanged();
                return this;
            }

            public Builder clearFirstBloodUserName() {
                this.firstBloodUserName_ = ChallengeScoreUpdate.getDefaultInstance().getFirstBloodUserName();
                onChanged();
                return this;
            }

            public Builder clearHide() {
                this.hide_ = false;
                onChanged();
                return this;
            }

            public Builder clearIncrScore() {
                this.incrScore_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIsFirstBlood() {
                this.isFirstBlood_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearScore() {
                this.score_ = 0;
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

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChallengeScoreUpdate getDefaultInstanceForType() {
                return ChallengeScoreUpdate.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_ChallengeUpdate_ChallengeScoreUpdate_descriptor;
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public int getEggScore() {
                return this.eggScore_;
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public String getFirstBloodDesc() {
                Object obj = this.firstBloodDesc_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.firstBloodDesc_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public ByteString getFirstBloodDescBytes() {
                Object obj = this.firstBloodDesc_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.firstBloodDesc_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public int getFirstBloodDisplayCountdown() {
                return this.firstBloodDisplayCountdown_;
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public String getFirstBloodUserName() {
                Object obj = this.firstBloodUserName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.firstBloodUserName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public ByteString getFirstBloodUserNameBytes() {
                Object obj = this.firstBloodUserName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.firstBloodUserName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public boolean getHide() {
                return this.hide_;
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public int getIncrScore() {
                return this.incrScore_;
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public boolean getIsFirstBlood() {
                return this.isFirstBlood_;
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public int getScore() {
                return this.score_;
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
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

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public int getUserPropCount() {
                RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
                return repeatedFieldBuilderV3 == null ? this.userProp_.size() : repeatedFieldBuilderV3.getCount();
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public List<UserProp> getUserPropList() {
                RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
                return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.userProp_) : repeatedFieldBuilderV3.getMessageList();
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public UserPropOrBuilder getUserPropOrBuilder(int i) {
                RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
                return repeatedFieldBuilderV3 == null ? this.userProp_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
            public List<? extends UserPropOrBuilder> getUserPropOrBuilderList() {
                RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = this.userPropBuilder_;
                return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.userProp_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_ChallengeUpdate_ChallengeScoreUpdate_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeScoreUpdate.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(ChallengeScoreUpdate challengeScoreUpdate) {
                if (challengeScoreUpdate == ChallengeScoreUpdate.getDefaultInstance()) {
                    return this;
                }
                if (challengeScoreUpdate.getScore() != 0) {
                    setScore(challengeScoreUpdate.getScore());
                }
                if (challengeScoreUpdate.getIncrScore() != 0) {
                    setIncrScore(challengeScoreUpdate.getIncrScore());
                }
                if (this.userPropBuilder_ == null) {
                    if (!challengeScoreUpdate.userProp_.isEmpty()) {
                        if (this.userProp_.isEmpty()) {
                            this.userProp_ = challengeScoreUpdate.userProp_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureUserPropIsMutable();
                            this.userProp_.addAll(challengeScoreUpdate.userProp_);
                        }
                        onChanged();
                    }
                } else if (!challengeScoreUpdate.userProp_.isEmpty()) {
                    if (this.userPropBuilder_.isEmpty()) {
                        this.userPropBuilder_.dispose();
                        RepeatedFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> repeatedFieldBuilderV3 = null;
                        this.userPropBuilder_ = null;
                        this.userProp_ = challengeScoreUpdate.userProp_;
                        this.bitField0_ &= -2;
                        if (ChallengeScoreUpdate.alwaysUseFieldBuilders) {
                            repeatedFieldBuilderV3 = getUserPropFieldBuilder();
                        }
                        this.userPropBuilder_ = repeatedFieldBuilderV3;
                    } else {
                        this.userPropBuilder_.addAllMessages(challengeScoreUpdate.userProp_);
                    }
                }
                if (challengeScoreUpdate.getIsFirstBlood()) {
                    setIsFirstBlood(challengeScoreUpdate.getIsFirstBlood());
                }
                if (!challengeScoreUpdate.getFirstBloodUserName().isEmpty()) {
                    this.firstBloodUserName_ = challengeScoreUpdate.firstBloodUserName_;
                    onChanged();
                }
                if (challengeScoreUpdate.getEggScore() != 0) {
                    setEggScore(challengeScoreUpdate.getEggScore());
                }
                if (challengeScoreUpdate.getHide()) {
                    setHide(challengeScoreUpdate.getHide());
                }
                if (!challengeScoreUpdate.getFirstBloodDesc().isEmpty()) {
                    this.firstBloodDesc_ = challengeScoreUpdate.firstBloodDesc_;
                    onChanged();
                }
                if (challengeScoreUpdate.getFirstBloodDisplayCountdown() != 0) {
                    setFirstBloodDisplayCountdown(challengeScoreUpdate.getFirstBloodDisplayCountdown());
                }
                mergeUnknownFields(challengeScoreUpdate.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdate.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdate.access$1500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.ChallengeUpdate$ChallengeScoreUpdate r0 = (cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdate) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.ChallengeUpdate$ChallengeScoreUpdate$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.ChallengeUpdate$ChallengeScoreUpdate r0 = (cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdate) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.ChallengeUpdate$ChallengeScoreUpdate$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdate.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ChallengeUpdate$ChallengeScoreUpdate$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ChallengeScoreUpdate) {
                    return mergeFrom((ChallengeScoreUpdate) message);
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

            public Builder setEggScore(int i) {
                this.eggScore_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setFirstBloodDesc(String str) {
                if (str != null) {
                    this.firstBloodDesc_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFirstBloodDescBytes(ByteString byteString) {
                if (byteString != null) {
                    ChallengeScoreUpdate.checkByteStringIsUtf8(byteString);
                    this.firstBloodDesc_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFirstBloodDisplayCountdown(int i) {
                this.firstBloodDisplayCountdown_ = i;
                onChanged();
                return this;
            }

            public Builder setFirstBloodUserName(String str) {
                if (str != null) {
                    this.firstBloodUserName_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFirstBloodUserNameBytes(ByteString byteString) {
                if (byteString != null) {
                    ChallengeScoreUpdate.checkByteStringIsUtf8(byteString);
                    this.firstBloodUserName_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setHide(boolean z) {
                this.hide_ = z;
                onChanged();
                return this;
            }

            public Builder setIncrScore(int i) {
                this.incrScore_ = i;
                onChanged();
                return this;
            }

            public Builder setIsFirstBlood(boolean z) {
                this.isFirstBlood_ = z;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setScore(int i) {
                this.score_ = i;
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

        private ChallengeScoreUpdate() {
            this.memoizedIsInitialized = (byte) -1;
            this.userProp_ = Collections.emptyList();
            this.firstBloodUserName_ = "";
            this.firstBloodDesc_ = "";
        }

        private ChallengeScoreUpdate(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.score_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.incrScore_ = codedInputStream.readUInt32();
                            } else if (readTag == 26) {
                                boolean z4 = z2;
                                if (!(z2 & true)) {
                                    this.userProp_ = new ArrayList();
                                    z4 = z2 | true;
                                }
                                this.userProp_.add((UserProp) codedInputStream.readMessage(UserProp.parser(), extensionRegistryLite));
                                z2 = z4;
                            } else if (readTag == 32) {
                                this.isFirstBlood_ = codedInputStream.readBool();
                            } else if (readTag == 42) {
                                this.firstBloodUserName_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 48) {
                                this.eggScore_ = codedInputStream.readUInt32();
                            } else if (readTag == 56) {
                                this.hide_ = codedInputStream.readBool();
                            } else if (readTag == 66) {
                                this.firstBloodDesc_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 72) {
                                this.firstBloodDisplayCountdown_ = codedInputStream.readUInt32();
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

        private ChallengeScoreUpdate(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ChallengeScoreUpdate getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeUpdate_ChallengeScoreUpdate_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChallengeScoreUpdate challengeScoreUpdate) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(challengeScoreUpdate);
        }

        public static ChallengeScoreUpdate parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ChallengeScoreUpdate) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ChallengeScoreUpdate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChallengeScoreUpdate) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ChallengeScoreUpdate parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ChallengeScoreUpdate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ChallengeScoreUpdate parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ChallengeScoreUpdate) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ChallengeScoreUpdate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChallengeScoreUpdate) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static ChallengeScoreUpdate parseFrom(InputStream inputStream) throws IOException {
            return (ChallengeScoreUpdate) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ChallengeScoreUpdate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChallengeScoreUpdate) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ChallengeScoreUpdate parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ChallengeScoreUpdate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ChallengeScoreUpdate parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ChallengeScoreUpdate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<ChallengeScoreUpdate> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ChallengeScoreUpdate) {
                ChallengeScoreUpdate challengeScoreUpdate = (ChallengeScoreUpdate) obj;
                return getScore() == challengeScoreUpdate.getScore() && getIncrScore() == challengeScoreUpdate.getIncrScore() && getUserPropList().equals(challengeScoreUpdate.getUserPropList()) && getIsFirstBlood() == challengeScoreUpdate.getIsFirstBlood() && getFirstBloodUserName().equals(challengeScoreUpdate.getFirstBloodUserName()) && getEggScore() == challengeScoreUpdate.getEggScore() && getHide() == challengeScoreUpdate.getHide() && getFirstBloodDesc().equals(challengeScoreUpdate.getFirstBloodDesc()) && getFirstBloodDisplayCountdown() == challengeScoreUpdate.getFirstBloodDisplayCountdown() && this.unknownFields.equals(challengeScoreUpdate.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChallengeScoreUpdate getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public int getEggScore() {
            return this.eggScore_;
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public String getFirstBloodDesc() {
            Object obj = this.firstBloodDesc_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.firstBloodDesc_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public ByteString getFirstBloodDescBytes() {
            Object obj = this.firstBloodDesc_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.firstBloodDesc_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public int getFirstBloodDisplayCountdown() {
            return this.firstBloodDisplayCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public String getFirstBloodUserName() {
            Object obj = this.firstBloodUserName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.firstBloodUserName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public ByteString getFirstBloodUserNameBytes() {
            Object obj = this.firstBloodUserName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.firstBloodUserName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public boolean getHide() {
            return this.hide_;
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public int getIncrScore() {
            return this.incrScore_;
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public boolean getIsFirstBlood() {
            return this.isFirstBlood_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChallengeScoreUpdate> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public int getScore() {
            return this.score_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.score_;
            int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
            int i3 = this.incrScore_;
            int i4 = computeUInt32Size;
            int i5 = 0;
            if (i3 != 0) {
                i4 = computeUInt32Size + CodedOutputStream.computeUInt32Size(2, i3);
                i5 = 0;
            }
            while (i5 < this.userProp_.size()) {
                i4 += CodedOutputStream.computeMessageSize(3, this.userProp_.get(i5));
                i5++;
            }
            boolean z = this.isFirstBlood_;
            int i6 = i4;
            if (z) {
                i6 = i4 + CodedOutputStream.computeBoolSize(4, z);
            }
            int i7 = i6;
            if (!getFirstBloodUserNameBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.firstBloodUserName_);
            }
            int i8 = this.eggScore_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeUInt32Size(6, i8);
            }
            boolean z2 = this.hide_;
            int i10 = i9;
            if (z2) {
                i10 = i9 + CodedOutputStream.computeBoolSize(7, z2);
            }
            int i11 = i10;
            if (!getFirstBloodDescBytes().isEmpty()) {
                i11 = i10 + GeneratedMessageV3.computeStringSize(8, this.firstBloodDesc_);
            }
            int i12 = this.firstBloodDisplayCountdown_;
            int i13 = i11;
            if (i12 != 0) {
                i13 = i11 + CodedOutputStream.computeUInt32Size(9, i12);
            }
            int serializedSize = i13 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public UserProp getUserProp(int i) {
            return this.userProp_.get(i);
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public int getUserPropCount() {
            return this.userProp_.size();
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public List<UserProp> getUserPropList() {
            return this.userProp_;
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public UserPropOrBuilder getUserPropOrBuilder(int i) {
            return this.userProp_.get(i);
        }

        @Override // cn.irisgw.live.ChallengeUpdate.ChallengeScoreUpdateOrBuilder
        public List<? extends UserPropOrBuilder> getUserPropOrBuilderList() {
            return this.userProp_;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getScore()) * 37) + 2) * 53) + getIncrScore();
            int i = hashCode;
            if (getUserPropCount() > 0) {
                i = (((hashCode * 37) + 3) * 53) + getUserPropList().hashCode();
            }
            int hashBoolean = (((((((((((((((((((((((((i * 37) + 4) * 53) + Internal.hashBoolean(getIsFirstBlood())) * 37) + 5) * 53) + getFirstBloodUserName().hashCode()) * 37) + 6) * 53) + getEggScore()) * 37) + 7) * 53) + Internal.hashBoolean(getHide())) * 37) + 8) * 53) + getFirstBloodDesc().hashCode()) * 37) + 9) * 53) + getFirstBloodDisplayCountdown()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashBoolean;
            return hashBoolean;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeUpdate_ChallengeScoreUpdate_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeScoreUpdate.class, Builder.class);
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
            return new ChallengeScoreUpdate();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.score_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            int i2 = this.incrScore_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(2, i2);
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.userProp_.size()) {
                    break;
                }
                codedOutputStream.writeMessage(3, this.userProp_.get(i4));
                i3 = i4 + 1;
            }
            boolean z = this.isFirstBlood_;
            if (z) {
                codedOutputStream.writeBool(4, z);
            }
            if (!getFirstBloodUserNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.firstBloodUserName_);
            }
            int i5 = this.eggScore_;
            if (i5 != 0) {
                codedOutputStream.writeUInt32(6, i5);
            }
            boolean z2 = this.hide_;
            if (z2) {
                codedOutputStream.writeBool(7, z2);
            }
            if (!getFirstBloodDescBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.firstBloodDesc_);
            }
            int i6 = this.firstBloodDisplayCountdown_;
            if (i6 != 0) {
                codedOutputStream.writeUInt32(9, i6);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeUpdate$ChallengeScoreUpdateOrBuilder.class */
    public interface ChallengeScoreUpdateOrBuilder extends MessageOrBuilder {
        int getEggScore();

        String getFirstBloodDesc();

        ByteString getFirstBloodDescBytes();

        int getFirstBloodDisplayCountdown();

        String getFirstBloodUserName();

        ByteString getFirstBloodUserNameBytes();

        boolean getHide();

        int getIncrScore();

        boolean getIsFirstBlood();

        int getScore();

        UserProp getUserProp(int i);

        int getUserPropCount();

        List<UserProp> getUserPropList();

        UserPropOrBuilder getUserPropOrBuilder(int i);

        List<? extends UserPropOrBuilder> getUserPropOrBuilderList();
    }

    private ChallengeUpdate() {
        this.memoizedIsInitialized = (byte) -1;
        this.records_ = Collections.emptyList();
    }

    private ChallengeUpdate(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.records_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.records_.add((ChallengeScoreUpdate) codedInputStream.readMessage(ChallengeScoreUpdate.parser(), extensionRegistryLite));
                            z2 = z4;
                        } else if (readTag == 16) {
                            this.isEgg_ = codedInputStream.readBool();
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
                    this.records_ = Collections.unmodifiableList(this.records_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.records_ = Collections.unmodifiableList(this.records_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private ChallengeUpdate(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ChallengeUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeUpdate_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ChallengeUpdate challengeUpdate) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(challengeUpdate);
    }

    public static ChallengeUpdate parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ChallengeUpdate) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ChallengeUpdate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeUpdate) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeUpdate parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ChallengeUpdate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ChallengeUpdate parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ChallengeUpdate) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ChallengeUpdate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeUpdate) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ChallengeUpdate parseFrom(InputStream inputStream) throws IOException {
        return (ChallengeUpdate) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ChallengeUpdate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeUpdate) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeUpdate parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ChallengeUpdate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ChallengeUpdate parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ChallengeUpdate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ChallengeUpdate> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChallengeUpdate) {
            ChallengeUpdate challengeUpdate = (ChallengeUpdate) obj;
            return getRecordsList().equals(challengeUpdate.getRecordsList()) && getIsEgg() == challengeUpdate.getIsEgg() && this.unknownFields.equals(challengeUpdate.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ChallengeUpdate getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ChallengeUpdateOrBuilder
    public boolean getIsEgg() {
        return this.isEgg_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ChallengeUpdate> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.ChallengeUpdateOrBuilder
    public ChallengeScoreUpdate getRecords(int i) {
        return this.records_.get(i);
    }

    @Override // cn.irisgw.live.ChallengeUpdateOrBuilder
    public int getRecordsCount() {
        return this.records_.size();
    }

    @Override // cn.irisgw.live.ChallengeUpdateOrBuilder
    public List<ChallengeScoreUpdate> getRecordsList() {
        return this.records_;
    }

    @Override // cn.irisgw.live.ChallengeUpdateOrBuilder
    public ChallengeScoreUpdateOrBuilder getRecordsOrBuilder(int i) {
        return this.records_.get(i);
    }

    @Override // cn.irisgw.live.ChallengeUpdateOrBuilder
    public List<? extends ChallengeScoreUpdateOrBuilder> getRecordsOrBuilderList() {
        return this.records_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.records_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.records_.get(i3));
        }
        boolean z = this.isEgg_;
        int i4 = i2;
        if (z) {
            i4 = i2 + CodedOutputStream.computeBoolSize(2, z);
        }
        int serializedSize = i4 + this.unknownFields.getSerializedSize();
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
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (getRecordsCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getRecordsList().hashCode();
        }
        int hashBoolean = (((((i * 37) + 2) * 53) + Internal.hashBoolean(getIsEgg())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashBoolean;
        return hashBoolean;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeUpdate_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeUpdate.class, Builder.class);
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
        return new ChallengeUpdate();
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
            if (i2 >= this.records_.size()) {
                break;
            }
            codedOutputStream.writeMessage(1, this.records_.get(i2));
            i = i2 + 1;
        }
        boolean z = this.isEgg_;
        if (z) {
            codedOutputStream.writeBool(2, z);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
