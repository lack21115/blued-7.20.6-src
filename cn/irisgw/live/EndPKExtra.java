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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/EndPKExtra.class */
public final class EndPKExtra extends GeneratedMessageV3 implements EndPKExtraOrBuilder {
    public static final int COUNTDOWN_FIELD_NUMBER = 3;
    private static final EndPKExtra DEFAULT_INSTANCE = new EndPKExtra();
    private static final Parser<EndPKExtra> PARSER = new AbstractParser<EndPKExtra>() { // from class: cn.irisgw.live.EndPKExtra.1
        /* renamed from: parsePartialFrom */
        public EndPKExtra m2148parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new EndPKExtra(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int PK_TYPE_FIELD_NUMBER = 5;
    public static final int RECORDS_FIELD_NUMBER = 4;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int WINNER_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private long countdown_;
    private byte memoizedIsInitialized;
    private int pkType_;
    private List<EndRecord> records_;
    private int type_;
    private int winner_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/EndPKExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EndPKExtraOrBuilder {
        private int bitField0_;
        private long countdown_;
        private int pkType_;
        private RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> recordsBuilder_;
        private List<EndRecord> records_;
        private int type_;
        private int winner_;

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
            return LiveConstants.internal_static_cn_irisgw_live_EndPKExtra_descriptor;
        }

        private RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> getRecordsFieldBuilder() {
            if (this.recordsBuilder_ == null) {
                List<EndRecord> list = this.records_;
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
            if (EndPKExtra.alwaysUseFieldBuilders) {
                getRecordsFieldBuilder();
            }
        }

        public Builder addAllRecords(Iterable<? extends EndRecord> iterable) {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureRecordsIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.records_);
            onChanged();
            return this;
        }

        public Builder addRecords(int i, EndRecord.Builder builder) {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m2199build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.add(i, builder.m2199build());
            onChanged();
            return this;
        }

        public Builder addRecords(int i, EndRecord endRecord) {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, endRecord);
                return this;
            } else if (endRecord != null) {
                ensureRecordsIsMutable();
                this.records_.add(i, endRecord);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addRecords(EndRecord.Builder builder) {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m2199build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.add(builder.m2199build());
            onChanged();
            return this;
        }

        public Builder addRecords(EndRecord endRecord) {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(endRecord);
                return this;
            } else if (endRecord != null) {
                ensureRecordsIsMutable();
                this.records_.add(endRecord);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public EndRecord.Builder addRecordsBuilder() {
            return getRecordsFieldBuilder().addBuilder(EndRecord.getDefaultInstance());
        }

        public EndRecord.Builder addRecordsBuilder(int i) {
            return getRecordsFieldBuilder().addBuilder(i, EndRecord.getDefaultInstance());
        }

        /* renamed from: addRepeatedField */
        public Builder m2150addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public EndPKExtra m2152build() {
            EndPKExtra m2154buildPartial = m2154buildPartial();
            if (m2154buildPartial.isInitialized()) {
                return m2154buildPartial;
            }
            throw newUninitializedMessageException(m2154buildPartial);
        }

        /* renamed from: buildPartial */
        public EndPKExtra m2154buildPartial() {
            EndPKExtra endPKExtra = new EndPKExtra(this);
            endPKExtra.type_ = this.type_;
            endPKExtra.winner_ = this.winner_;
            endPKExtra.countdown_ = this.countdown_;
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.records_ = Collections.unmodifiableList(this.records_);
                    this.bitField0_ &= -2;
                }
                endPKExtra.records_ = this.records_;
            } else {
                endPKExtra.records_ = repeatedFieldBuilderV3.build();
            }
            endPKExtra.pkType_ = this.pkType_;
            onBuilt();
            return endPKExtra;
        }

        /* renamed from: clear */
        public Builder m2158clear() {
            super.clear();
            this.type_ = 0;
            this.winner_ = 0;
            this.countdown_ = EndPKExtra.serialVersionUID;
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.records_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.pkType_ = 0;
            return this;
        }

        public Builder clearCountdown() {
            this.countdown_ = EndPKExtra.serialVersionUID;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m2160clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m2163clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPkType() {
            this.pkType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRecords() {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.records_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWinner() {
            this.winner_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m2169clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.EndPKExtraOrBuilder
        public long getCountdown() {
            return this.countdown_;
        }

        /* renamed from: getDefaultInstanceForType */
        public EndPKExtra m2171getDefaultInstanceForType() {
            return EndPKExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_EndPKExtra_descriptor;
        }

        @Override // cn.irisgw.live.EndPKExtraOrBuilder
        public int getPkType() {
            return this.pkType_;
        }

        @Override // cn.irisgw.live.EndPKExtraOrBuilder
        public EndRecord getRecords(int i) {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public EndRecord.Builder getRecordsBuilder(int i) {
            return getRecordsFieldBuilder().getBuilder(i);
        }

        public List<EndRecord.Builder> getRecordsBuilderList() {
            return getRecordsFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.EndPKExtraOrBuilder
        public int getRecordsCount() {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.EndPKExtraOrBuilder
        public List<EndRecord> getRecordsList() {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.records_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.EndPKExtraOrBuilder
        public EndRecordOrBuilder getRecordsOrBuilder(int i) {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.get(i) : (EndRecordOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.EndPKExtraOrBuilder
        public List<? extends EndRecordOrBuilder> getRecordsOrBuilderList() {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.records_);
        }

        @Override // cn.irisgw.live.EndPKExtraOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // cn.irisgw.live.EndPKExtraOrBuilder
        public int getWinner() {
            return this.winner_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_EndPKExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(EndPKExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(EndPKExtra endPKExtra) {
            if (endPKExtra == EndPKExtra.getDefaultInstance()) {
                return this;
            }
            if (endPKExtra.getType() != 0) {
                setType(endPKExtra.getType());
            }
            if (endPKExtra.getWinner() != 0) {
                setWinner(endPKExtra.getWinner());
            }
            if (endPKExtra.getCountdown() != EndPKExtra.serialVersionUID) {
                setCountdown(endPKExtra.getCountdown());
            }
            if (this.recordsBuilder_ == null) {
                if (!endPKExtra.records_.isEmpty()) {
                    if (this.records_.isEmpty()) {
                        this.records_ = endPKExtra.records_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRecordsIsMutable();
                        this.records_.addAll(endPKExtra.records_);
                    }
                    onChanged();
                }
            } else if (!endPKExtra.records_.isEmpty()) {
                if (this.recordsBuilder_.isEmpty()) {
                    this.recordsBuilder_.dispose();
                    RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = null;
                    this.recordsBuilder_ = null;
                    this.records_ = endPKExtra.records_;
                    this.bitField0_ &= -2;
                    if (EndPKExtra.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getRecordsFieldBuilder();
                    }
                    this.recordsBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.recordsBuilder_.addAllMessages(endPKExtra.records_);
                }
            }
            if (endPKExtra.getPkType() != 0) {
                setPkType(endPKExtra.getPkType());
            }
            m2180mergeUnknownFields(endPKExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.EndPKExtra.Builder m2177mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.EndPKExtra.access$3000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.EndPKExtra r0 = (cn.irisgw.live.EndPKExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.EndPKExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.EndPKExtra r0 = (cn.irisgw.live.EndPKExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.EndPKExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.EndPKExtra.Builder.m2177mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.EndPKExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m2176mergeFrom(Message message) {
            if (message instanceof EndPKExtra) {
                return mergeFrom((EndPKExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m2180mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeRecords(int i) {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.remove(i);
            onChanged();
            return this;
        }

        public Builder setCountdown(long j) {
            this.countdown_ = j;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m2182setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setPkType(int i) {
            this.pkType_ = i;
            onChanged();
            return this;
        }

        public Builder setRecords(int i, EndRecord.Builder builder) {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m2199build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.set(i, builder.m2199build());
            onChanged();
            return this;
        }

        public Builder setRecords(int i, EndRecord endRecord) {
            RepeatedFieldBuilderV3<EndRecord, EndRecord.Builder, EndRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, endRecord);
                return this;
            } else if (endRecord != null) {
                ensureRecordsIsMutable();
                this.records_.set(i, endRecord);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        /* renamed from: setRepeatedField */
        public Builder m2184setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setType(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m2186setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setWinner(int i) {
            this.winner_ = i;
            onChanged();
            return this;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/EndPKExtra$EndRecord.class */
    public static final class EndRecord extends GeneratedMessageV3 implements EndRecordOrBuilder {
        public static final int ANIM_CODE_FIELD_NUMBER = 4;
        public static final int AR_URL_FIELD_NUMBER = 3;
        public static final int AVATAR_FIELD_NUMBER = 6;
        private static final EndRecord DEFAULT_INSTANCE = new EndRecord();
        private static final Parser<EndRecord> PARSER = new AbstractParser<EndRecord>() { // from class: cn.irisgw.live.EndPKExtra.EndRecord.1
            /* renamed from: parsePartialFrom */
            public EndRecord m2195parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new EndRecord(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int SCORE_FIELD_NUMBER = 2;
        public static final int TARGET_BEANS_FIELD_NUMBER = 8;
        public static final int TARGET_STREAK_FIELD_NUMBER = 7;
        public static final int TOTAL_BEANS_FIELD_NUMBER = 9;
        public static final int UID_FIELD_NUMBER = 1;
        public static final int WIN_STREAK_FIELD_NUMBER = 5;
        private static final long serialVersionUID = 0;
        private volatile Object animCode_;
        private volatile Object arUrl_;
        private volatile Object avatar_;
        private byte memoizedIsInitialized;
        private int score_;
        private int targetBeans_;
        private int targetStreak_;
        private int totalBeans_;
        private int uid_;
        private int winStreak_;

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/EndPKExtra$EndRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EndRecordOrBuilder {
            private Object animCode_;
            private Object arUrl_;
            private Object avatar_;
            private int score_;
            private int targetBeans_;
            private int targetStreak_;
            private int totalBeans_;
            private int uid_;
            private int winStreak_;

            private Builder() {
                this.arUrl_ = "";
                this.animCode_ = "";
                this.avatar_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.arUrl_ = "";
                this.animCode_ = "";
                this.avatar_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_EndPKExtra_EndRecord_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = EndRecord.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m2197addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public EndRecord m2199build() {
                EndRecord m2201buildPartial = m2201buildPartial();
                if (m2201buildPartial.isInitialized()) {
                    return m2201buildPartial;
                }
                throw newUninitializedMessageException(m2201buildPartial);
            }

            /* renamed from: buildPartial */
            public EndRecord m2201buildPartial() {
                EndRecord endRecord = new EndRecord(this);
                endRecord.uid_ = this.uid_;
                endRecord.score_ = this.score_;
                endRecord.arUrl_ = this.arUrl_;
                endRecord.animCode_ = this.animCode_;
                endRecord.winStreak_ = this.winStreak_;
                endRecord.avatar_ = this.avatar_;
                endRecord.targetStreak_ = this.targetStreak_;
                endRecord.targetBeans_ = this.targetBeans_;
                endRecord.totalBeans_ = this.totalBeans_;
                onBuilt();
                return endRecord;
            }

            /* renamed from: clear */
            public Builder m2205clear() {
                super.clear();
                this.uid_ = 0;
                this.score_ = 0;
                this.arUrl_ = "";
                this.animCode_ = "";
                this.winStreak_ = 0;
                this.avatar_ = "";
                this.targetStreak_ = 0;
                this.targetBeans_ = 0;
                this.totalBeans_ = 0;
                return this;
            }

            public Builder clearAnimCode() {
                this.animCode_ = EndRecord.getDefaultInstance().getAnimCode();
                onChanged();
                return this;
            }

            public Builder clearArUrl() {
                this.arUrl_ = EndRecord.getDefaultInstance().getArUrl();
                onChanged();
                return this;
            }

            public Builder clearAvatar() {
                this.avatar_ = EndRecord.getDefaultInstance().getAvatar();
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m2207clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            /* renamed from: clearOneof */
            public Builder m2210clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearScore() {
                this.score_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTargetBeans() {
                this.targetBeans_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTargetStreak() {
                this.targetStreak_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTotalBeans() {
                this.totalBeans_ = 0;
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
            public Builder m2216clone() {
                return (Builder) super.clone();
            }

            @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
            public String getAnimCode() {
                Object obj = this.animCode_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.animCode_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
            public ByteString getAnimCodeBytes() {
                Object obj = this.animCode_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.animCode_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
            public String getArUrl() {
                Object obj = this.arUrl_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.arUrl_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
            public ByteString getArUrlBytes() {
                Object obj = this.arUrl_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.arUrl_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
            public String getAvatar() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.avatar_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
            public ByteString getAvatarBytes() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.avatar_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            /* renamed from: getDefaultInstanceForType */
            public EndRecord m2218getDefaultInstanceForType() {
                return EndRecord.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_EndPKExtra_EndRecord_descriptor;
            }

            @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
            public int getScore() {
                return this.score_;
            }

            @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
            public int getTargetBeans() {
                return this.targetBeans_;
            }

            @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
            public int getTargetStreak() {
                return this.targetStreak_;
            }

            @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
            public int getTotalBeans() {
                return this.totalBeans_;
            }

            @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
            public int getUid() {
                return this.uid_;
            }

            @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
            public int getWinStreak() {
                return this.winStreak_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_EndPKExtra_EndRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(EndRecord.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(EndRecord endRecord) {
                if (endRecord == EndRecord.getDefaultInstance()) {
                    return this;
                }
                if (endRecord.getUid() != 0) {
                    setUid(endRecord.getUid());
                }
                if (endRecord.getScore() != 0) {
                    setScore(endRecord.getScore());
                }
                if (!endRecord.getArUrl().isEmpty()) {
                    this.arUrl_ = endRecord.arUrl_;
                    onChanged();
                }
                if (!endRecord.getAnimCode().isEmpty()) {
                    this.animCode_ = endRecord.animCode_;
                    onChanged();
                }
                if (endRecord.getWinStreak() != 0) {
                    setWinStreak(endRecord.getWinStreak());
                }
                if (!endRecord.getAvatar().isEmpty()) {
                    this.avatar_ = endRecord.avatar_;
                    onChanged();
                }
                if (endRecord.getTargetStreak() != 0) {
                    setTargetStreak(endRecord.getTargetStreak());
                }
                if (endRecord.getTargetBeans() != 0) {
                    setTargetBeans(endRecord.getTargetBeans());
                }
                if (endRecord.getTotalBeans() != 0) {
                    setTotalBeans(endRecord.getTotalBeans());
                }
                m2227mergeUnknownFields(endRecord.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.EndPKExtra.EndRecord.Builder m2224mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.EndPKExtra.EndRecord.access$1400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.EndPKExtra$EndRecord r0 = (cn.irisgw.live.EndPKExtra.EndRecord) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.EndPKExtra$EndRecord$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.EndPKExtra$EndRecord r0 = (cn.irisgw.live.EndPKExtra.EndRecord) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.EndPKExtra$EndRecord$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.EndPKExtra.EndRecord.Builder.m2224mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.EndPKExtra$EndRecord$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m2223mergeFrom(Message message) {
                if (message instanceof EndRecord) {
                    return mergeFrom((EndRecord) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m2227mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setAnimCode(String str) {
                if (str != null) {
                    this.animCode_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAnimCodeBytes(ByteString byteString) {
                if (byteString != null) {
                    EndRecord.checkByteStringIsUtf8(byteString);
                    this.animCode_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setArUrl(String str) {
                if (str != null) {
                    this.arUrl_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setArUrlBytes(ByteString byteString) {
                if (byteString != null) {
                    EndRecord.checkByteStringIsUtf8(byteString);
                    this.arUrl_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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
                    EndRecord.checkByteStringIsUtf8(byteString);
                    this.avatar_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setField */
            public Builder m2229setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: setRepeatedField */
            public Builder m2231setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setScore(int i) {
                this.score_ = i;
                onChanged();
                return this;
            }

            public Builder setTargetBeans(int i) {
                this.targetBeans_ = i;
                onChanged();
                return this;
            }

            public Builder setTargetStreak(int i) {
                this.targetStreak_ = i;
                onChanged();
                return this;
            }

            public Builder setTotalBeans(int i) {
                this.totalBeans_ = i;
                onChanged();
                return this;
            }

            public Builder setUid(int i) {
                this.uid_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setUnknownFields */
            public final Builder m2233setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setWinStreak(int i) {
                this.winStreak_ = i;
                onChanged();
                return this;
            }
        }

        private EndRecord() {
            this.memoizedIsInitialized = (byte) -1;
            this.arUrl_ = "";
            this.animCode_ = "";
            this.avatar_ = "";
        }

        private EndRecord(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.uid_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.score_ = codedInputStream.readUInt32();
                            } else if (readTag == 26) {
                                this.arUrl_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                this.animCode_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 40) {
                                this.winStreak_ = codedInputStream.readUInt32();
                            } else if (readTag == 50) {
                                this.avatar_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 56) {
                                this.targetStreak_ = codedInputStream.readUInt32();
                            } else if (readTag == 64) {
                                this.targetBeans_ = codedInputStream.readUInt32();
                            } else if (readTag == 72) {
                                this.totalBeans_ = codedInputStream.readUInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
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

        private EndRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static EndRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_EndPKExtra_EndRecord_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m2194toBuilder();
        }

        public static Builder newBuilder(EndRecord endRecord) {
            return DEFAULT_INSTANCE.m2194toBuilder().mergeFrom(endRecord);
        }

        public static EndRecord parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static EndRecord parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static EndRecord parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EndRecord) PARSER.parseFrom(byteString);
        }

        public static EndRecord parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EndRecord) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static EndRecord parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static EndRecord parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static EndRecord parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static EndRecord parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static EndRecord parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EndRecord) PARSER.parseFrom(byteBuffer);
        }

        public static EndRecord parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EndRecord) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static EndRecord parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EndRecord) PARSER.parseFrom(bArr);
        }

        public static EndRecord parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EndRecord) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<EndRecord> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof EndRecord) {
                EndRecord endRecord = (EndRecord) obj;
                return getUid() == endRecord.getUid() && getScore() == endRecord.getScore() && getArUrl().equals(endRecord.getArUrl()) && getAnimCode().equals(endRecord.getAnimCode()) && getWinStreak() == endRecord.getWinStreak() && getAvatar().equals(endRecord.getAvatar()) && getTargetStreak() == endRecord.getTargetStreak() && getTargetBeans() == endRecord.getTargetBeans() && getTotalBeans() == endRecord.getTotalBeans() && this.unknownFields.equals(endRecord.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
        public String getAnimCode() {
            Object obj = this.animCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.animCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
        public ByteString getAnimCodeBytes() {
            Object obj = this.animCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.animCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
        public String getArUrl() {
            Object obj = this.arUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.arUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
        public ByteString getArUrlBytes() {
            Object obj = this.arUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.arUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
        public ByteString getAvatarBytes() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* renamed from: getDefaultInstanceForType */
        public EndRecord m2189getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Parser<EndRecord> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
        public int getScore() {
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
            int i4 = this.score_;
            int i5 = i2;
            if (i4 != 0) {
                i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
            }
            int i6 = i5;
            if (!getArUrlBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(3, this.arUrl_);
            }
            int i7 = i6;
            if (!getAnimCodeBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(4, this.animCode_);
            }
            int i8 = this.winStreak_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeUInt32Size(5, i8);
            }
            int i10 = i9;
            if (!getAvatarBytes().isEmpty()) {
                i10 = i9 + GeneratedMessageV3.computeStringSize(6, this.avatar_);
            }
            int i11 = this.targetStreak_;
            int i12 = i10;
            if (i11 != 0) {
                i12 = i10 + CodedOutputStream.computeUInt32Size(7, i11);
            }
            int i13 = this.targetBeans_;
            int i14 = i12;
            if (i13 != 0) {
                i14 = i12 + CodedOutputStream.computeUInt32Size(8, i13);
            }
            int i15 = this.totalBeans_;
            int i16 = i14;
            if (i15 != 0) {
                i16 = i14 + CodedOutputStream.computeUInt32Size(9, i15);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
        public int getTargetBeans() {
            return this.targetBeans_;
        }

        @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
        public int getTargetStreak() {
            return this.targetStreak_;
        }

        @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
        public int getTotalBeans() {
            return this.totalBeans_;
        }

        @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
        public int getUid() {
            return this.uid_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.EndPKExtra.EndRecordOrBuilder
        public int getWinStreak() {
            return this.winStreak_;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getScore()) * 37) + 3) * 53) + getArUrl().hashCode()) * 37) + 4) * 53) + getAnimCode().hashCode()) * 37) + 5) * 53) + getWinStreak()) * 37) + 6) * 53) + getAvatar().hashCode()) * 37) + 7) * 53) + getTargetStreak()) * 37) + 8) * 53) + getTargetBeans()) * 37) + 9) * 53) + getTotalBeans()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_EndPKExtra_EndRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(EndRecord.class, Builder.class);
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
        public Builder m2192newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m2191newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new EndRecord();
        }

        /* renamed from: toBuilder */
        public Builder m2194toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.uid_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            int i2 = this.score_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(2, i2);
            }
            if (!getArUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.arUrl_);
            }
            if (!getAnimCodeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.animCode_);
            }
            int i3 = this.winStreak_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(5, i3);
            }
            if (!getAvatarBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.avatar_);
            }
            int i4 = this.targetStreak_;
            if (i4 != 0) {
                codedOutputStream.writeUInt32(7, i4);
            }
            int i5 = this.targetBeans_;
            if (i5 != 0) {
                codedOutputStream.writeUInt32(8, i5);
            }
            int i6 = this.totalBeans_;
            if (i6 != 0) {
                codedOutputStream.writeUInt32(9, i6);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/EndPKExtra$EndRecordOrBuilder.class */
    public interface EndRecordOrBuilder extends MessageOrBuilder {
        String getAnimCode();

        ByteString getAnimCodeBytes();

        String getArUrl();

        ByteString getArUrlBytes();

        String getAvatar();

        ByteString getAvatarBytes();

        int getScore();

        int getTargetBeans();

        int getTargetStreak();

        int getTotalBeans();

        int getUid();

        int getWinStreak();
    }

    private EndPKExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.records_ = Collections.emptyList();
    }

    private EndPKExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.type_ = codedInputStream.readUInt32();
                        } else if (readTag == 16) {
                            this.winner_ = codedInputStream.readUInt32();
                        } else if (readTag == 24) {
                            this.countdown_ = codedInputStream.readUInt64();
                        } else if (readTag == 34) {
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.records_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.records_.add((EndRecord) codedInputStream.readMessage(EndRecord.parser(), extensionRegistryLite));
                            z2 = z4;
                        } else if (readTag == 40) {
                            this.pkType_ = codedInputStream.readUInt32();
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

    private EndPKExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static EndPKExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_EndPKExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m2147toBuilder();
    }

    public static Builder newBuilder(EndPKExtra endPKExtra) {
        return DEFAULT_INSTANCE.m2147toBuilder().mergeFrom(endPKExtra);
    }

    public static EndPKExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static EndPKExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EndPKExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (EndPKExtra) PARSER.parseFrom(byteString);
    }

    public static EndPKExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EndPKExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static EndPKExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static EndPKExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static EndPKExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static EndPKExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static EndPKExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (EndPKExtra) PARSER.parseFrom(byteBuffer);
    }

    public static EndPKExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EndPKExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static EndPKExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (EndPKExtra) PARSER.parseFrom(bArr);
    }

    public static EndPKExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EndPKExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<EndPKExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EndPKExtra) {
            EndPKExtra endPKExtra = (EndPKExtra) obj;
            return getType() == endPKExtra.getType() && getWinner() == endPKExtra.getWinner() && getCountdown() == endPKExtra.getCountdown() && getRecordsList().equals(endPKExtra.getRecordsList()) && getPkType() == endPKExtra.getPkType() && this.unknownFields.equals(endPKExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.EndPKExtraOrBuilder
    public long getCountdown() {
        return this.countdown_;
    }

    /* renamed from: getDefaultInstanceForType */
    public EndPKExtra m2142getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<EndPKExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.EndPKExtraOrBuilder
    public int getPkType() {
        return this.pkType_;
    }

    @Override // cn.irisgw.live.EndPKExtraOrBuilder
    public EndRecord getRecords(int i) {
        return this.records_.get(i);
    }

    @Override // cn.irisgw.live.EndPKExtraOrBuilder
    public int getRecordsCount() {
        return this.records_.size();
    }

    @Override // cn.irisgw.live.EndPKExtraOrBuilder
    public List<EndRecord> getRecordsList() {
        return this.records_;
    }

    @Override // cn.irisgw.live.EndPKExtraOrBuilder
    public EndRecordOrBuilder getRecordsOrBuilder(int i) {
        return this.records_.get(i);
    }

    @Override // cn.irisgw.live.EndPKExtraOrBuilder
    public List<? extends EndRecordOrBuilder> getRecordsOrBuilderList() {
        return this.records_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.type_;
        int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
        int i3 = this.winner_;
        int i4 = computeUInt32Size;
        if (i3 != 0) {
            i4 = computeUInt32Size + CodedOutputStream.computeUInt32Size(2, i3);
        }
        long j = this.countdown_;
        int i5 = i4;
        int i6 = 0;
        if (j != serialVersionUID) {
            i5 = i4 + CodedOutputStream.computeUInt64Size(3, j);
            i6 = 0;
        }
        while (i6 < this.records_.size()) {
            i5 += CodedOutputStream.computeMessageSize(4, this.records_.get(i6));
            i6++;
        }
        int i7 = this.pkType_;
        int i8 = i5;
        if (i7 != 0) {
            i8 = i5 + CodedOutputStream.computeUInt32Size(5, i7);
        }
        int serializedSize = i8 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.EndPKExtraOrBuilder
    public int getType() {
        return this.type_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.EndPKExtraOrBuilder
    public int getWinner() {
        return this.winner_;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getType()) * 37) + 2) * 53) + getWinner()) * 37) + 3) * 53) + Internal.hashLong(getCountdown());
        int i = hashCode;
        if (getRecordsCount() > 0) {
            i = (((hashCode * 37) + 4) * 53) + getRecordsList().hashCode();
        }
        int pkType = (((((i * 37) + 5) * 53) + getPkType()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = pkType;
        return pkType;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_EndPKExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(EndPKExtra.class, Builder.class);
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
    public Builder m2145newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m2144newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new EndPKExtra();
    }

    /* renamed from: toBuilder */
    public Builder m2147toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.type_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.winner_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        long j = this.countdown_;
        if (j != serialVersionUID) {
            codedOutputStream.writeUInt64(3, j);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.records_.size()) {
                break;
            }
            codedOutputStream.writeMessage(4, this.records_.get(i4));
            i3 = i4 + 1;
        }
        int i5 = this.pkType_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(5, i5);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
