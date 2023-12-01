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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PkTypeStart.class */
public final class PkTypeStart extends GeneratedMessageV3 implements PkTypeStartOrBuilder {
    public static final int COUNTDOWN_FIELD_NUMBER = 3;
    public static final int COUNT_FIELD_NUMBER = 1;
    public static final int LAST_FIELD_NUMBER = 5;
    public static final int PK_STATUS_FIELD_NUMBER = 4;
    public static final int RECORDS_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int count_;
    private int countdown_;
    private boolean last_;
    private byte memoizedIsInitialized;
    private boolean pkStatus_;
    private List<PkRecord> records_;
    private static final PkTypeStart DEFAULT_INSTANCE = new PkTypeStart();
    private static final Parser<PkTypeStart> PARSER = new AbstractParser<PkTypeStart>() { // from class: cn.irisgw.live.PkTypeStart.1
        /* renamed from: parsePartialFrom */
        public PkTypeStart m6740parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PkTypeStart(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PkTypeStart$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PkTypeStartOrBuilder {
        private int bitField0_;
        private int count_;
        private int countdown_;
        private boolean last_;
        private boolean pkStatus_;
        private RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> recordsBuilder_;
        private List<PkRecord> records_;

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
            return LiveConstants.internal_static_cn_irisgw_live_PkTypeStart_descriptor;
        }

        private RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> getRecordsFieldBuilder() {
            if (this.recordsBuilder_ == null) {
                List<PkRecord> list = this.records_;
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
            if (PkTypeStart.alwaysUseFieldBuilders) {
                getRecordsFieldBuilder();
            }
        }

        public Builder addAllRecords(Iterable<? extends PkRecord> iterable) {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureRecordsIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.records_);
            onChanged();
            return this;
        }

        public Builder addRecords(int i, PkRecord.Builder builder) {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m6791build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.add(i, builder.m6791build());
            onChanged();
            return this;
        }

        public Builder addRecords(int i, PkRecord pkRecord) {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, pkRecord);
                return this;
            } else if (pkRecord != null) {
                ensureRecordsIsMutable();
                this.records_.add(i, pkRecord);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addRecords(PkRecord.Builder builder) {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m6791build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.add(builder.m6791build());
            onChanged();
            return this;
        }

        public Builder addRecords(PkRecord pkRecord) {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(pkRecord);
                return this;
            } else if (pkRecord != null) {
                ensureRecordsIsMutable();
                this.records_.add(pkRecord);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public PkRecord.Builder addRecordsBuilder() {
            return getRecordsFieldBuilder().addBuilder(PkRecord.getDefaultInstance());
        }

        public PkRecord.Builder addRecordsBuilder(int i) {
            return getRecordsFieldBuilder().addBuilder(i, PkRecord.getDefaultInstance());
        }

        /* renamed from: addRepeatedField */
        public Builder m6742addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public PkTypeStart m6744build() {
            PkTypeStart m6746buildPartial = m6746buildPartial();
            if (m6746buildPartial.isInitialized()) {
                return m6746buildPartial;
            }
            throw newUninitializedMessageException(m6746buildPartial);
        }

        /* renamed from: buildPartial */
        public PkTypeStart m6746buildPartial() {
            PkTypeStart pkTypeStart = new PkTypeStart(this);
            pkTypeStart.count_ = this.count_;
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.records_ = Collections.unmodifiableList(this.records_);
                    this.bitField0_ &= -2;
                }
                pkTypeStart.records_ = this.records_;
            } else {
                pkTypeStart.records_ = repeatedFieldBuilderV3.build();
            }
            pkTypeStart.countdown_ = this.countdown_;
            pkTypeStart.pkStatus_ = this.pkStatus_;
            pkTypeStart.last_ = this.last_;
            onBuilt();
            return pkTypeStart;
        }

        /* renamed from: clear */
        public Builder m6750clear() {
            super.clear();
            this.count_ = 0;
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.records_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.countdown_ = 0;
            this.pkStatus_ = false;
            this.last_ = false;
            return this;
        }

        public Builder clearCount() {
            this.count_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCountdown() {
            this.countdown_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m6752clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearLast() {
            this.last_ = false;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m6755clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPkStatus() {
            this.pkStatus_ = false;
            onChanged();
            return this;
        }

        public Builder clearRecords() {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.records_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m6761clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.PkTypeStartOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // cn.irisgw.live.PkTypeStartOrBuilder
        public int getCountdown() {
            return this.countdown_;
        }

        /* renamed from: getDefaultInstanceForType */
        public PkTypeStart m6763getDefaultInstanceForType() {
            return PkTypeStart.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_PkTypeStart_descriptor;
        }

        @Override // cn.irisgw.live.PkTypeStartOrBuilder
        public boolean getLast() {
            return this.last_;
        }

        @Override // cn.irisgw.live.PkTypeStartOrBuilder
        public boolean getPkStatus() {
            return this.pkStatus_;
        }

        @Override // cn.irisgw.live.PkTypeStartOrBuilder
        public PkRecord getRecords(int i) {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public PkRecord.Builder getRecordsBuilder(int i) {
            return getRecordsFieldBuilder().getBuilder(i);
        }

        public List<PkRecord.Builder> getRecordsBuilderList() {
            return getRecordsFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.PkTypeStartOrBuilder
        public int getRecordsCount() {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.PkTypeStartOrBuilder
        public List<PkRecord> getRecordsList() {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.records_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.PkTypeStartOrBuilder
        public PkRecordOrBuilder getRecordsOrBuilder(int i) {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.get(i) : (PkRecordOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.PkTypeStartOrBuilder
        public List<? extends PkRecordOrBuilder> getRecordsOrBuilderList() {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.records_);
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PkTypeStart_fieldAccessorTable.ensureFieldAccessorsInitialized(PkTypeStart.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(PkTypeStart pkTypeStart) {
            if (pkTypeStart == PkTypeStart.getDefaultInstance()) {
                return this;
            }
            if (pkTypeStart.getCount() != 0) {
                setCount(pkTypeStart.getCount());
            }
            if (this.recordsBuilder_ == null) {
                if (!pkTypeStart.records_.isEmpty()) {
                    if (this.records_.isEmpty()) {
                        this.records_ = pkTypeStart.records_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRecordsIsMutable();
                        this.records_.addAll(pkTypeStart.records_);
                    }
                    onChanged();
                }
            } else if (!pkTypeStart.records_.isEmpty()) {
                if (this.recordsBuilder_.isEmpty()) {
                    this.recordsBuilder_.dispose();
                    RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = null;
                    this.recordsBuilder_ = null;
                    this.records_ = pkTypeStart.records_;
                    this.bitField0_ &= -2;
                    if (PkTypeStart.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getRecordsFieldBuilder();
                    }
                    this.recordsBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.recordsBuilder_.addAllMessages(pkTypeStart.records_);
                }
            }
            if (pkTypeStart.getCountdown() != 0) {
                setCountdown(pkTypeStart.getCountdown());
            }
            if (pkTypeStart.getPkStatus()) {
                setPkStatus(pkTypeStart.getPkStatus());
            }
            if (pkTypeStart.getLast()) {
                setLast(pkTypeStart.getLast());
            }
            m6772mergeUnknownFields(pkTypeStart.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.PkTypeStart.Builder m6769mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.PkTypeStart.access$2400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.PkTypeStart r0 = (cn.irisgw.live.PkTypeStart) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.PkTypeStart$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.PkTypeStart r0 = (cn.irisgw.live.PkTypeStart) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.PkTypeStart$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PkTypeStart.Builder.m6769mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PkTypeStart$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m6768mergeFrom(Message message) {
            if (message instanceof PkTypeStart) {
                return mergeFrom((PkTypeStart) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m6772mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeRecords(int i) {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.remove(i);
            onChanged();
            return this;
        }

        public Builder setCount(int i) {
            this.count_ = i;
            onChanged();
            return this;
        }

        public Builder setCountdown(int i) {
            this.countdown_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m6774setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setLast(boolean z) {
            this.last_ = z;
            onChanged();
            return this;
        }

        public Builder setPkStatus(boolean z) {
            this.pkStatus_ = z;
            onChanged();
            return this;
        }

        public Builder setRecords(int i, PkRecord.Builder builder) {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m6791build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.set(i, builder.m6791build());
            onChanged();
            return this;
        }

        public Builder setRecords(int i, PkRecord pkRecord) {
            RepeatedFieldBuilderV3<PkRecord, PkRecord.Builder, PkRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, pkRecord);
                return this;
            } else if (pkRecord != null) {
                ensureRecordsIsMutable();
                this.records_.set(i, pkRecord);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        /* renamed from: setRepeatedField */
        public Builder m6776setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m6778setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PkTypeStart$PkRecord.class */
    public static final class PkRecord extends GeneratedMessageV3 implements PkRecordOrBuilder {
        public static final int PK_RESULT_FIELD_NUMBER = 4;
        public static final int SCORE_FIELD_NUMBER = 2;
        public static final int UID_FIELD_NUMBER = 3;
        public static final int WIN_COUNT_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int pkResultMemoizedSerializedSize;
        private List<Integer> pkResult_;
        private long score_;
        private volatile Object uid_;
        private int winCount_;
        private static final Internal.ListAdapter.Converter<Integer, PkResult> pkResult_converter_ = new Internal.ListAdapter.Converter<Integer, PkResult>() { // from class: cn.irisgw.live.PkTypeStart.PkRecord.1
            public PkResult convert(Integer num) {
                PkResult valueOf = PkResult.valueOf(num.intValue());
                PkResult pkResult = valueOf;
                if (valueOf == null) {
                    pkResult = PkResult.UNRECOGNIZED;
                }
                return pkResult;
            }
        };
        private static final PkRecord DEFAULT_INSTANCE = new PkRecord();
        private static final Parser<PkRecord> PARSER = new AbstractParser<PkRecord>() { // from class: cn.irisgw.live.PkTypeStart.PkRecord.2
            /* renamed from: parsePartialFrom */
            public PkRecord m6787parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PkRecord(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PkTypeStart$PkRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PkRecordOrBuilder {
            private int bitField0_;
            private List<Integer> pkResult_;
            private long score_;
            private Object uid_;
            private int winCount_;

            private Builder() {
                this.uid_ = "";
                this.pkResult_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.uid_ = "";
                this.pkResult_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void ensurePkResultIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.pkResult_ = new ArrayList(this.pkResult_);
                    this.bitField0_ |= 1;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_PkTypeStart_PkRecord_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = PkRecord.alwaysUseFieldBuilders;
            }

            public Builder addAllPkResult(Iterable<? extends PkResult> iterable) {
                ensurePkResultIsMutable();
                for (PkResult pkResult : iterable) {
                    this.pkResult_.add(Integer.valueOf(pkResult.getNumber()));
                }
                onChanged();
                return this;
            }

            public Builder addAllPkResultValue(Iterable<Integer> iterable) {
                ensurePkResultIsMutable();
                for (Integer num : iterable) {
                    this.pkResult_.add(Integer.valueOf(num.intValue()));
                }
                onChanged();
                return this;
            }

            public Builder addPkResult(PkResult pkResult) {
                if (pkResult != null) {
                    ensurePkResultIsMutable();
                    this.pkResult_.add(Integer.valueOf(pkResult.getNumber()));
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder addPkResultValue(int i) {
                ensurePkResultIsMutable();
                this.pkResult_.add(Integer.valueOf(i));
                onChanged();
                return this;
            }

            /* renamed from: addRepeatedField */
            public Builder m6789addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public PkRecord m6791build() {
                PkRecord m6793buildPartial = m6793buildPartial();
                if (m6793buildPartial.isInitialized()) {
                    return m6793buildPartial;
                }
                throw newUninitializedMessageException(m6793buildPartial);
            }

            /* renamed from: buildPartial */
            public PkRecord m6793buildPartial() {
                PkRecord pkRecord = new PkRecord(this);
                pkRecord.winCount_ = this.winCount_;
                pkRecord.score_ = this.score_;
                pkRecord.uid_ = this.uid_;
                if ((this.bitField0_ & 1) != 0) {
                    this.pkResult_ = Collections.unmodifiableList(this.pkResult_);
                    this.bitField0_ &= -2;
                }
                pkRecord.pkResult_ = this.pkResult_;
                onBuilt();
                return pkRecord;
            }

            /* renamed from: clear */
            public Builder m6797clear() {
                super.clear();
                this.winCount_ = 0;
                this.score_ = PkRecord.serialVersionUID;
                this.uid_ = "";
                this.pkResult_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            /* renamed from: clearField */
            public Builder m6799clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            /* renamed from: clearOneof */
            public Builder m6802clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPkResult() {
                this.pkResult_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.score_ = PkRecord.serialVersionUID;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = PkRecord.getDefaultInstance().getUid();
                onChanged();
                return this;
            }

            public Builder clearWinCount() {
                this.winCount_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m6808clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public PkRecord m6810getDefaultInstanceForType() {
                return PkRecord.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_PkTypeStart_PkRecord_descriptor;
            }

            @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
            public PkResult getPkResult(int i) {
                return (PkResult) PkRecord.pkResult_converter_.convert(this.pkResult_.get(i));
            }

            @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
            public int getPkResultCount() {
                return this.pkResult_.size();
            }

            @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
            public List<PkResult> getPkResultList() {
                return new Internal.ListAdapter(this.pkResult_, PkRecord.pkResult_converter_);
            }

            @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
            public int getPkResultValue(int i) {
                return this.pkResult_.get(i).intValue();
            }

            @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
            public List<Integer> getPkResultValueList() {
                return Collections.unmodifiableList(this.pkResult_);
            }

            @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
            public long getScore() {
                return this.score_;
            }

            @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
            public String getUid() {
                Object obj = this.uid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.uid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
            public ByteString getUidBytes() {
                Object obj = this.uid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.uid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
            public int getWinCount() {
                return this.winCount_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_PkTypeStart_PkRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(PkRecord.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(PkRecord pkRecord) {
                if (pkRecord == PkRecord.getDefaultInstance()) {
                    return this;
                }
                if (pkRecord.getWinCount() != 0) {
                    setWinCount(pkRecord.getWinCount());
                }
                if (pkRecord.getScore() != PkRecord.serialVersionUID) {
                    setScore(pkRecord.getScore());
                }
                if (!pkRecord.getUid().isEmpty()) {
                    this.uid_ = pkRecord.uid_;
                    onChanged();
                }
                if (!pkRecord.pkResult_.isEmpty()) {
                    if (this.pkResult_.isEmpty()) {
                        this.pkResult_ = pkRecord.pkResult_;
                        this.bitField0_ &= -2;
                    } else {
                        ensurePkResultIsMutable();
                        this.pkResult_.addAll(pkRecord.pkResult_);
                    }
                    onChanged();
                }
                m6819mergeUnknownFields(pkRecord.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.PkTypeStart.PkRecord.Builder m6816mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.PkTypeStart.PkRecord.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.PkTypeStart$PkRecord r0 = (cn.irisgw.live.PkTypeStart.PkRecord) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.PkTypeStart$PkRecord$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.PkTypeStart$PkRecord r0 = (cn.irisgw.live.PkTypeStart.PkRecord) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.PkTypeStart$PkRecord$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PkTypeStart.PkRecord.Builder.m6816mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PkTypeStart$PkRecord$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m6815mergeFrom(Message message) {
                if (message instanceof PkRecord) {
                    return mergeFrom((PkRecord) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m6819mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            /* renamed from: setField */
            public Builder m6821setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setPkResult(int i, PkResult pkResult) {
                if (pkResult != null) {
                    ensurePkResultIsMutable();
                    this.pkResult_.set(i, Integer.valueOf(pkResult.getNumber()));
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPkResultValue(int i, int i2) {
                ensurePkResultIsMutable();
                this.pkResult_.set(i, Integer.valueOf(i2));
                onChanged();
                return this;
            }

            /* renamed from: setRepeatedField */
            public Builder m6823setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setScore(long j) {
                this.score_ = j;
                onChanged();
                return this;
            }

            public Builder setUid(String str) {
                if (str != null) {
                    this.uid_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUidBytes(ByteString byteString) {
                if (byteString != null) {
                    PkRecord.checkByteStringIsUtf8(byteString);
                    this.uid_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setUnknownFields */
            public final Builder m6825setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setWinCount(int i) {
                this.winCount_ = i;
                onChanged();
                return this;
            }
        }

        private PkRecord() {
            this.memoizedIsInitialized = (byte) -1;
            this.uid_ = "";
            this.pkResult_ = Collections.emptyList();
        }

        private PkRecord(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.winCount_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.score_ = codedInputStream.readUInt64();
                            } else if (readTag == 26) {
                                this.uid_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                int readEnum = codedInputStream.readEnum();
                                boolean z4 = z2;
                                if (!(z2 & true)) {
                                    this.pkResult_ = new ArrayList();
                                    z4 = z2 | true;
                                }
                                this.pkResult_.add(Integer.valueOf(readEnum));
                                z2 = z4;
                            } else if (readTag == 34) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                while (true) {
                                    boolean z5 = z2;
                                    if (codedInputStream.getBytesUntilLimit() <= 0) {
                                        break;
                                    }
                                    boolean z6 = z2;
                                    int readEnum2 = codedInputStream.readEnum();
                                    boolean z7 = z2;
                                    if (!(z2 & true)) {
                                        this.pkResult_ = new ArrayList();
                                        z7 = z2 | true;
                                    }
                                    this.pkResult_.add(Integer.valueOf(readEnum2));
                                    z2 = z7;
                                }
                                codedInputStream.popLimit(pushLimit);
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
                        this.pkResult_ = Collections.unmodifiableList(this.pkResult_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.pkResult_ = Collections.unmodifiableList(this.pkResult_);
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private PkRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static PkRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PkTypeStart_PkRecord_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m6786toBuilder();
        }

        public static Builder newBuilder(PkRecord pkRecord) {
            return DEFAULT_INSTANCE.m6786toBuilder().mergeFrom(pkRecord);
        }

        public static PkRecord parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static PkRecord parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PkRecord parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PkRecord) PARSER.parseFrom(byteString);
        }

        public static PkRecord parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PkRecord) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PkRecord parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static PkRecord parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static PkRecord parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static PkRecord parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PkRecord parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PkRecord) PARSER.parseFrom(byteBuffer);
        }

        public static PkRecord parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PkRecord) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static PkRecord parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PkRecord) PARSER.parseFrom(bArr);
        }

        public static PkRecord parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PkRecord) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<PkRecord> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof PkRecord) {
                PkRecord pkRecord = (PkRecord) obj;
                return getWinCount() == pkRecord.getWinCount() && getScore() == pkRecord.getScore() && getUid().equals(pkRecord.getUid()) && this.pkResult_.equals(pkRecord.pkResult_) && this.unknownFields.equals(pkRecord.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public PkRecord m6781getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Parser<PkRecord> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
        public PkResult getPkResult(int i) {
            return (PkResult) pkResult_converter_.convert(this.pkResult_.get(i));
        }

        @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
        public int getPkResultCount() {
            return this.pkResult_.size();
        }

        @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
        public List<PkResult> getPkResultList() {
            return new Internal.ListAdapter(this.pkResult_, pkResult_converter_);
        }

        @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
        public int getPkResultValue(int i) {
            return this.pkResult_.get(i).intValue();
        }

        @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
        public List<Integer> getPkResultValueList() {
            return this.pkResult_;
        }

        @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
        public long getScore() {
            return this.score_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.winCount_;
            int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
            long j = this.score_;
            int i3 = computeUInt32Size;
            if (j != serialVersionUID) {
                i3 = computeUInt32Size + CodedOutputStream.computeUInt64Size(2, j);
            }
            int i4 = i3;
            if (!getUidBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.uid_);
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.pkResult_.size(); i6++) {
                i5 += CodedOutputStream.computeEnumSizeNoTag(this.pkResult_.get(i6).intValue());
            }
            int i7 = i4 + i5;
            int i8 = i7;
            if (!getPkResultList().isEmpty()) {
                i8 = i7 + 1 + CodedOutputStream.computeUInt32SizeNoTag(i5);
            }
            this.pkResultMemoizedSerializedSize = i5;
            int serializedSize = i8 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
        public String getUid() {
            Object obj = this.uid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.uid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
        public ByteString getUidBytes() {
            Object obj = this.uid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.uid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.PkTypeStart.PkRecordOrBuilder
        public int getWinCount() {
            return this.winCount_;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getWinCount()) * 37) + 2) * 53) + Internal.hashLong(getScore())) * 37) + 3) * 53) + getUid().hashCode();
            int i = hashCode;
            if (getPkResultCount() > 0) {
                i = (((hashCode * 37) + 4) * 53) + this.pkResult_.hashCode();
            }
            int hashCode2 = (i * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PkTypeStart_PkRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(PkRecord.class, Builder.class);
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
        public Builder m6784newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m6783newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new PkRecord();
        }

        /* renamed from: toBuilder */
        public Builder m6786toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            int i = this.winCount_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            long j = this.score_;
            if (j != serialVersionUID) {
                codedOutputStream.writeUInt64(2, j);
            }
            if (!getUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.uid_);
            }
            if (getPkResultList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(34);
                codedOutputStream.writeUInt32NoTag(this.pkResultMemoizedSerializedSize);
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.pkResult_.size()) {
                    this.unknownFields.writeTo(codedOutputStream);
                    return;
                } else {
                    codedOutputStream.writeEnumNoTag(this.pkResult_.get(i3).intValue());
                    i2 = i3 + 1;
                }
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PkTypeStart$PkRecordOrBuilder.class */
    public interface PkRecordOrBuilder extends MessageOrBuilder {
        PkResult getPkResult(int i);

        int getPkResultCount();

        List<PkResult> getPkResultList();

        int getPkResultValue(int i);

        List<Integer> getPkResultValueList();

        long getScore();

        String getUid();

        ByteString getUidBytes();

        int getWinCount();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PkTypeStart$PkResult.class */
    public enum PkResult implements ProtocolMessageEnum {
        None(0),
        Win(1),
        Fail(2),
        Draw(3),
        UNRECOGNIZED(-1);
        
        public static final int Draw_VALUE = 3;
        public static final int Fail_VALUE = 2;
        public static final int None_VALUE = 0;
        public static final int Win_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<PkResult> internalValueMap = new Internal.EnumLiteMap<PkResult>() { // from class: cn.irisgw.live.PkTypeStart.PkResult.1
            /* renamed from: findValueByNumber */
            public PkResult m6827findValueByNumber(int i) {
                return PkResult.forNumber(i);
            }
        };
        private static final PkResult[] VALUES = values();

        PkResult(int i) {
            this.value = i;
        }

        public static PkResult forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return Draw;
                    }
                    return Fail;
                }
                return Win;
            }
            return None;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) PkTypeStart.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<PkResult> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static PkResult valueOf(int i) {
            return forNumber(i);
        }

        public static PkResult valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return (Descriptors.EnumValueDescriptor) getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    private PkTypeStart() {
        this.memoizedIsInitialized = (byte) -1;
        this.records_ = Collections.emptyList();
    }

    private PkTypeStart(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.count_ = codedInputStream.readUInt32();
                        } else if (readTag == 18) {
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.records_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.records_.add((PkRecord) codedInputStream.readMessage(PkRecord.parser(), extensionRegistryLite));
                            z2 = z4;
                        } else if (readTag == 24) {
                            this.countdown_ = codedInputStream.readUInt32();
                        } else if (readTag == 32) {
                            this.pkStatus_ = codedInputStream.readBool();
                        } else if (readTag == 40) {
                            this.last_ = codedInputStream.readBool();
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

    private PkTypeStart(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PkTypeStart getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_PkTypeStart_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m6739toBuilder();
    }

    public static Builder newBuilder(PkTypeStart pkTypeStart) {
        return DEFAULT_INSTANCE.m6739toBuilder().mergeFrom(pkTypeStart);
    }

    public static PkTypeStart parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PkTypeStart parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PkTypeStart parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PkTypeStart) PARSER.parseFrom(byteString);
    }

    public static PkTypeStart parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PkTypeStart) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PkTypeStart parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PkTypeStart parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PkTypeStart parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PkTypeStart parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PkTypeStart parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PkTypeStart) PARSER.parseFrom(byteBuffer);
    }

    public static PkTypeStart parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PkTypeStart) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PkTypeStart parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PkTypeStart) PARSER.parseFrom(bArr);
    }

    public static PkTypeStart parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PkTypeStart) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<PkTypeStart> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PkTypeStart) {
            PkTypeStart pkTypeStart = (PkTypeStart) obj;
            return getCount() == pkTypeStart.getCount() && getRecordsList().equals(pkTypeStart.getRecordsList()) && getCountdown() == pkTypeStart.getCountdown() && getPkStatus() == pkTypeStart.getPkStatus() && getLast() == pkTypeStart.getLast() && this.unknownFields.equals(pkTypeStart.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.PkTypeStartOrBuilder
    public int getCount() {
        return this.count_;
    }

    @Override // cn.irisgw.live.PkTypeStartOrBuilder
    public int getCountdown() {
        return this.countdown_;
    }

    /* renamed from: getDefaultInstanceForType */
    public PkTypeStart m6734getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.PkTypeStartOrBuilder
    public boolean getLast() {
        return this.last_;
    }

    public Parser<PkTypeStart> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.PkTypeStartOrBuilder
    public boolean getPkStatus() {
        return this.pkStatus_;
    }

    @Override // cn.irisgw.live.PkTypeStartOrBuilder
    public PkRecord getRecords(int i) {
        return this.records_.get(i);
    }

    @Override // cn.irisgw.live.PkTypeStartOrBuilder
    public int getRecordsCount() {
        return this.records_.size();
    }

    @Override // cn.irisgw.live.PkTypeStartOrBuilder
    public List<PkRecord> getRecordsList() {
        return this.records_;
    }

    @Override // cn.irisgw.live.PkTypeStartOrBuilder
    public PkRecordOrBuilder getRecordsOrBuilder(int i) {
        return this.records_.get(i);
    }

    @Override // cn.irisgw.live.PkTypeStartOrBuilder
    public List<? extends PkRecordOrBuilder> getRecordsOrBuilderList() {
        return this.records_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.count_;
        int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
        for (int i3 = 0; i3 < this.records_.size(); i3++) {
            computeUInt32Size += CodedOutputStream.computeMessageSize(2, this.records_.get(i3));
        }
        int i4 = this.countdown_;
        int i5 = computeUInt32Size;
        if (i4 != 0) {
            i5 = computeUInt32Size + CodedOutputStream.computeUInt32Size(3, i4);
        }
        boolean z = this.pkStatus_;
        int i6 = i5;
        if (z) {
            i6 = i5 + CodedOutputStream.computeBoolSize(4, z);
        }
        boolean z2 = this.last_;
        int i7 = i6;
        if (z2) {
            i7 = i6 + CodedOutputStream.computeBoolSize(5, z2);
        }
        int serializedSize = i7 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCount();
        int i = hashCode;
        if (getRecordsCount() > 0) {
            i = (((hashCode * 37) + 2) * 53) + getRecordsList().hashCode();
        }
        int countdown = (((((((((((((i * 37) + 3) * 53) + getCountdown()) * 37) + 4) * 53) + Internal.hashBoolean(getPkStatus())) * 37) + 5) * 53) + Internal.hashBoolean(getLast())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = countdown;
        return countdown;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_PkTypeStart_fieldAccessorTable.ensureFieldAccessorsInitialized(PkTypeStart.class, Builder.class);
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
    public Builder m6737newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m6736newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new PkTypeStart();
    }

    /* renamed from: toBuilder */
    public Builder m6739toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.count_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.records_.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, this.records_.get(i3));
            i2 = i3 + 1;
        }
        int i4 = this.countdown_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(3, i4);
        }
        boolean z = this.pkStatus_;
        if (z) {
            codedOutputStream.writeBool(4, z);
        }
        boolean z2 = this.last_;
        if (z2) {
            codedOutputStream.writeBool(5, z2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
