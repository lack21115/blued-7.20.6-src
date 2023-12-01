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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/StartPKExtra.class */
public final class StartPKExtra extends GeneratedMessageV3 implements StartPKExtraOrBuilder {
    public static final int AVATAR_FIELD_NUMBER = 8;
    public static final int CONFERENCE_ID_FIELD_NUMBER = 3;
    public static final int CONFERENCE_TOKEN_FIELD_NUMBER = 4;
    public static final int COUNTDOWN_FIELD_NUMBER = 9;
    public static final int DELAY_FIELD_NUMBER = 10;
    public static final int FIRST_KILL_MESSAGE_FIELD_NUMBER = 12;
    public static final int LID_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 7;
    public static final int RECORDS_FIELD_NUMBER = 11;
    public static final int STREAM_FIELD_NUMBER = 1;
    public static final int TARGET_STREAM_FIELD_NUMBER = 2;
    public static final int UID_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private volatile Object avatar_;
    private volatile Object conferenceId_;
    private volatile Object conferenceToken_;
    private long countdown_;
    private long delay_;
    private volatile Object firstKillMessage_;
    private volatile Object lid_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List<StartRecord> records_;
    private volatile Object stream_;
    private volatile Object targetStream_;
    private volatile Object uid_;
    private static final StartPKExtra DEFAULT_INSTANCE = new StartPKExtra();
    private static final Parser<StartPKExtra> PARSER = new AbstractParser<StartPKExtra>() { // from class: cn.irisgw.live.StartPKExtra.1
        @Override // com.google.protobuf.Parser
        public StartPKExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new StartPKExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/StartPKExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StartPKExtraOrBuilder {
        private Object avatar_;
        private int bitField0_;
        private Object conferenceId_;
        private Object conferenceToken_;
        private long countdown_;
        private long delay_;
        private Object firstKillMessage_;
        private Object lid_;
        private Object name_;
        private RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> recordsBuilder_;
        private List<StartRecord> records_;
        private Object stream_;
        private Object targetStream_;
        private Object uid_;

        private Builder() {
            this.stream_ = "";
            this.targetStream_ = "";
            this.conferenceId_ = "";
            this.conferenceToken_ = "";
            this.uid_ = "";
            this.lid_ = "";
            this.name_ = "";
            this.avatar_ = "";
            this.records_ = Collections.emptyList();
            this.firstKillMessage_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.stream_ = "";
            this.targetStream_ = "";
            this.conferenceId_ = "";
            this.conferenceToken_ = "";
            this.uid_ = "";
            this.lid_ = "";
            this.name_ = "";
            this.avatar_ = "";
            this.records_ = Collections.emptyList();
            this.firstKillMessage_ = "";
            maybeForceBuilderInitialization();
        }

        private void ensureRecordsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.records_ = new ArrayList(this.records_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_StartPKExtra_descriptor;
        }

        private RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> getRecordsFieldBuilder() {
            if (this.recordsBuilder_ == null) {
                List<StartRecord> list = this.records_;
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
            if (StartPKExtra.alwaysUseFieldBuilders) {
                getRecordsFieldBuilder();
            }
        }

        public Builder addAllRecords(Iterable<? extends StartRecord> iterable) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureRecordsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.records_);
            onChanged();
            return this;
        }

        public Builder addRecords(int i, StartRecord.Builder builder) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addRecords(int i, StartRecord startRecord) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, startRecord);
                return this;
            } else if (startRecord != null) {
                ensureRecordsIsMutable();
                this.records_.add(i, startRecord);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addRecords(StartRecord.Builder builder) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addRecords(StartRecord startRecord) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(startRecord);
                return this;
            } else if (startRecord != null) {
                ensureRecordsIsMutable();
                this.records_.add(startRecord);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public StartRecord.Builder addRecordsBuilder() {
            return getRecordsFieldBuilder().addBuilder(StartRecord.getDefaultInstance());
        }

        public StartRecord.Builder addRecordsBuilder(int i) {
            return getRecordsFieldBuilder().addBuilder(i, StartRecord.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public StartPKExtra build() {
            StartPKExtra buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public StartPKExtra buildPartial() {
            StartPKExtra startPKExtra = new StartPKExtra(this);
            startPKExtra.stream_ = this.stream_;
            startPKExtra.targetStream_ = this.targetStream_;
            startPKExtra.conferenceId_ = this.conferenceId_;
            startPKExtra.conferenceToken_ = this.conferenceToken_;
            startPKExtra.uid_ = this.uid_;
            startPKExtra.lid_ = this.lid_;
            startPKExtra.name_ = this.name_;
            startPKExtra.avatar_ = this.avatar_;
            startPKExtra.countdown_ = this.countdown_;
            startPKExtra.delay_ = this.delay_;
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.records_ = Collections.unmodifiableList(this.records_);
                    this.bitField0_ &= -2;
                }
                startPKExtra.records_ = this.records_;
            } else {
                startPKExtra.records_ = repeatedFieldBuilderV3.build();
            }
            startPKExtra.firstKillMessage_ = this.firstKillMessage_;
            onBuilt();
            return startPKExtra;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.stream_ = "";
            this.targetStream_ = "";
            this.conferenceId_ = "";
            this.conferenceToken_ = "";
            this.uid_ = "";
            this.lid_ = "";
            this.name_ = "";
            this.avatar_ = "";
            this.countdown_ = 0L;
            this.delay_ = 0L;
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.records_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.firstKillMessage_ = "";
            return this;
        }

        public Builder clearAvatar() {
            this.avatar_ = StartPKExtra.getDefaultInstance().getAvatar();
            onChanged();
            return this;
        }

        public Builder clearConferenceId() {
            this.conferenceId_ = StartPKExtra.getDefaultInstance().getConferenceId();
            onChanged();
            return this;
        }

        public Builder clearConferenceToken() {
            this.conferenceToken_ = StartPKExtra.getDefaultInstance().getConferenceToken();
            onChanged();
            return this;
        }

        public Builder clearCountdown() {
            this.countdown_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearDelay() {
            this.delay_ = 0L;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearFirstKillMessage() {
            this.firstKillMessage_ = StartPKExtra.getDefaultInstance().getFirstKillMessage();
            onChanged();
            return this;
        }

        public Builder clearLid() {
            this.lid_ = StartPKExtra.getDefaultInstance().getLid();
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = StartPKExtra.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRecords() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.records_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearStream() {
            this.stream_ = StartPKExtra.getDefaultInstance().getStream();
            onChanged();
            return this;
        }

        public Builder clearTargetStream() {
            this.targetStream_ = StartPKExtra.getDefaultInstance().getTargetStream();
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = StartPKExtra.getDefaultInstance().getUid();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public ByteString getAvatarBytes() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public String getConferenceId() {
            Object obj = this.conferenceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.conferenceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public ByteString getConferenceIdBytes() {
            Object obj = this.conferenceId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.conferenceId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public String getConferenceToken() {
            Object obj = this.conferenceToken_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.conferenceToken_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public ByteString getConferenceTokenBytes() {
            Object obj = this.conferenceToken_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.conferenceToken_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public long getCountdown() {
            return this.countdown_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public StartPKExtra getDefaultInstanceForType() {
            return StartPKExtra.getDefaultInstance();
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public long getDelay() {
            return this.delay_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_StartPKExtra_descriptor;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public String getFirstKillMessage() {
            Object obj = this.firstKillMessage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.firstKillMessage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public ByteString getFirstKillMessageBytes() {
            Object obj = this.firstKillMessage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.firstKillMessage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public String getLid() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.lid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public ByteString getLidBytes() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public StartRecord getRecords(int i) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public StartRecord.Builder getRecordsBuilder(int i) {
            return getRecordsFieldBuilder().getBuilder(i);
        }

        public List<StartRecord.Builder> getRecordsBuilderList() {
            return getRecordsFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public int getRecordsCount() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public List<StartRecord> getRecordsList() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.records_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public StartRecordOrBuilder getRecordsOrBuilder(int i) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public List<? extends StartRecordOrBuilder> getRecordsOrBuilderList() {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.records_);
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public String getStream() {
            Object obj = this.stream_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.stream_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public ByteString getStreamBytes() {
            Object obj = this.stream_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.stream_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public String getTargetStream() {
            Object obj = this.targetStream_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetStream_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public ByteString getTargetStreamBytes() {
            Object obj = this.targetStream_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetStream_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public String getUid() {
            Object obj = this.uid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.uid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.StartPKExtraOrBuilder
        public ByteString getUidBytes() {
            Object obj = this.uid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.uid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_StartPKExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(StartPKExtra.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(StartPKExtra startPKExtra) {
            if (startPKExtra == StartPKExtra.getDefaultInstance()) {
                return this;
            }
            if (!startPKExtra.getStream().isEmpty()) {
                this.stream_ = startPKExtra.stream_;
                onChanged();
            }
            if (!startPKExtra.getTargetStream().isEmpty()) {
                this.targetStream_ = startPKExtra.targetStream_;
                onChanged();
            }
            if (!startPKExtra.getConferenceId().isEmpty()) {
                this.conferenceId_ = startPKExtra.conferenceId_;
                onChanged();
            }
            if (!startPKExtra.getConferenceToken().isEmpty()) {
                this.conferenceToken_ = startPKExtra.conferenceToken_;
                onChanged();
            }
            if (!startPKExtra.getUid().isEmpty()) {
                this.uid_ = startPKExtra.uid_;
                onChanged();
            }
            if (!startPKExtra.getLid().isEmpty()) {
                this.lid_ = startPKExtra.lid_;
                onChanged();
            }
            if (!startPKExtra.getName().isEmpty()) {
                this.name_ = startPKExtra.name_;
                onChanged();
            }
            if (!startPKExtra.getAvatar().isEmpty()) {
                this.avatar_ = startPKExtra.avatar_;
                onChanged();
            }
            if (startPKExtra.getCountdown() != 0) {
                setCountdown(startPKExtra.getCountdown());
            }
            if (startPKExtra.getDelay() != 0) {
                setDelay(startPKExtra.getDelay());
            }
            if (this.recordsBuilder_ == null) {
                if (!startPKExtra.records_.isEmpty()) {
                    if (this.records_.isEmpty()) {
                        this.records_ = startPKExtra.records_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRecordsIsMutable();
                        this.records_.addAll(startPKExtra.records_);
                    }
                    onChanged();
                }
            } else if (!startPKExtra.records_.isEmpty()) {
                if (this.recordsBuilder_.isEmpty()) {
                    this.recordsBuilder_.dispose();
                    RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = null;
                    this.recordsBuilder_ = null;
                    this.records_ = startPKExtra.records_;
                    this.bitField0_ &= -2;
                    if (StartPKExtra.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getRecordsFieldBuilder();
                    }
                    this.recordsBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.recordsBuilder_.addAllMessages(startPKExtra.records_);
                }
            }
            if (!startPKExtra.getFirstKillMessage().isEmpty()) {
                this.firstKillMessage_ = startPKExtra.firstKillMessage_;
                onChanged();
            }
            mergeUnknownFields(startPKExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.StartPKExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.StartPKExtra.access$3500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.StartPKExtra r0 = (cn.irisgw.live.StartPKExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.StartPKExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.StartPKExtra r0 = (cn.irisgw.live.StartPKExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.StartPKExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.StartPKExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.StartPKExtra$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof StartPKExtra) {
                return mergeFrom((StartPKExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeRecords(int i) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.remove(i);
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
                StartPKExtra.checkByteStringIsUtf8(byteString);
                this.avatar_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setConferenceId(String str) {
            if (str != null) {
                this.conferenceId_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setConferenceIdBytes(ByteString byteString) {
            if (byteString != null) {
                StartPKExtra.checkByteStringIsUtf8(byteString);
                this.conferenceId_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setConferenceToken(String str) {
            if (str != null) {
                this.conferenceToken_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setConferenceTokenBytes(ByteString byteString) {
            if (byteString != null) {
                StartPKExtra.checkByteStringIsUtf8(byteString);
                this.conferenceToken_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setCountdown(long j) {
            this.countdown_ = j;
            onChanged();
            return this;
        }

        public Builder setDelay(long j) {
            this.delay_ = j;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
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
                StartPKExtra.checkByteStringIsUtf8(byteString);
                this.firstKillMessage_ = byteString;
                onChanged();
                return this;
            }
            throw null;
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
                StartPKExtra.checkByteStringIsUtf8(byteString);
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
                StartPKExtra.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRecords(int i, StartRecord.Builder builder) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setRecords(int i, StartRecord startRecord) {
            RepeatedFieldBuilderV3<StartRecord, StartRecord.Builder, StartRecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, startRecord);
                return this;
            } else if (startRecord != null) {
                ensureRecordsIsMutable();
                this.records_.set(i, startRecord);
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

        public Builder setStream(String str) {
            if (str != null) {
                this.stream_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setStreamBytes(ByteString byteString) {
            if (byteString != null) {
                StartPKExtra.checkByteStringIsUtf8(byteString);
                this.stream_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTargetStream(String str) {
            if (str != null) {
                this.targetStream_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTargetStreamBytes(ByteString byteString) {
            if (byteString != null) {
                StartPKExtra.checkByteStringIsUtf8(byteString);
                this.targetStream_ = byteString;
                onChanged();
                return this;
            }
            throw null;
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
                StartPKExtra.checkByteStringIsUtf8(byteString);
                this.uid_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/StartPKExtra$StartRecord.class */
    public static final class StartRecord extends GeneratedMessageV3 implements StartRecordOrBuilder {
        public static final int AVATAR_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 8;
        public static final int SCORE_FIELD_NUMBER = 2;
        public static final int TARGET_BEANS_FIELD_NUMBER = 6;
        public static final int TARGET_STREAK_FIELD_NUMBER = 5;
        public static final int TOTAL_BEANS_FIELD_NUMBER = 7;
        public static final int UID_FIELD_NUMBER = 1;
        public static final int WIN_STREAK_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private volatile Object avatar_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int score_;
        private int targetBeans_;
        private int targetStreak_;
        private int totalBeans_;
        private int uid_;
        private int winStreak_;
        private static final StartRecord DEFAULT_INSTANCE = new StartRecord();
        private static final Parser<StartRecord> PARSER = new AbstractParser<StartRecord>() { // from class: cn.irisgw.live.StartPKExtra.StartRecord.1
            @Override // com.google.protobuf.Parser
            public StartRecord parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StartRecord(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/StartPKExtra$StartRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StartRecordOrBuilder {
            private Object avatar_;
            private Object name_;
            private int score_;
            private int targetBeans_;
            private int targetStreak_;
            private int totalBeans_;
            private int uid_;
            private int winStreak_;

            private Builder() {
                this.avatar_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.avatar_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_StartPKExtra_StartRecord_descriptor;
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
                startRecord.score_ = this.score_;
                startRecord.winStreak_ = this.winStreak_;
                startRecord.avatar_ = this.avatar_;
                startRecord.targetStreak_ = this.targetStreak_;
                startRecord.targetBeans_ = this.targetBeans_;
                startRecord.totalBeans_ = this.totalBeans_;
                startRecord.name_ = this.name_;
                onBuilt();
                return startRecord;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.uid_ = 0;
                this.score_ = 0;
                this.winStreak_ = 0;
                this.avatar_ = "";
                this.targetStreak_ = 0;
                this.targetBeans_ = 0;
                this.totalBeans_ = 0;
                this.name_ = "";
                return this;
            }

            public Builder clearAvatar() {
                this.avatar_ = StartRecord.getDefaultInstance().getAvatar();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearName() {
                this.name_ = StartRecord.getDefaultInstance().getName();
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
            public String getAvatar() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.avatar_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
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
            public StartRecord getDefaultInstanceForType() {
                return StartRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_StartPKExtra_StartRecord_descriptor;
            }

            @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
            public int getScore() {
                return this.score_;
            }

            @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
            public int getTargetBeans() {
                return this.targetBeans_;
            }

            @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
            public int getTargetStreak() {
                return this.targetStreak_;
            }

            @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
            public int getTotalBeans() {
                return this.totalBeans_;
            }

            @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
            public int getUid() {
                return this.uid_;
            }

            @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
            public int getWinStreak() {
                return this.winStreak_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_StartPKExtra_StartRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(StartRecord.class, Builder.class);
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
                if (startRecord.getScore() != 0) {
                    setScore(startRecord.getScore());
                }
                if (startRecord.getWinStreak() != 0) {
                    setWinStreak(startRecord.getWinStreak());
                }
                if (!startRecord.getAvatar().isEmpty()) {
                    this.avatar_ = startRecord.avatar_;
                    onChanged();
                }
                if (startRecord.getTargetStreak() != 0) {
                    setTargetStreak(startRecord.getTargetStreak());
                }
                if (startRecord.getTargetBeans() != 0) {
                    setTargetBeans(startRecord.getTargetBeans());
                }
                if (startRecord.getTotalBeans() != 0) {
                    setTotalBeans(startRecord.getTotalBeans());
                }
                if (!startRecord.getName().isEmpty()) {
                    this.name_ = startRecord.name_;
                    onChanged();
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
            public cn.irisgw.live.StartPKExtra.StartRecord.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.StartPKExtra.StartRecord.access$1300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.StartPKExtra$StartRecord r0 = (cn.irisgw.live.StartPKExtra.StartRecord) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.StartPKExtra$StartRecord$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.StartPKExtra$StartRecord r0 = (cn.irisgw.live.StartPKExtra.StartRecord) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.StartPKExtra$StartRecord$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.StartPKExtra.StartRecord.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.StartPKExtra$StartRecord$Builder");
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
                    StartRecord.checkByteStringIsUtf8(byteString);
                    this.avatar_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
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
            this.avatar_ = "";
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
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.uid_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.score_ = codedInputStream.readUInt32();
                            } else if (readTag == 24) {
                                this.winStreak_ = codedInputStream.readUInt32();
                            } else if (readTag == 34) {
                                this.avatar_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 40) {
                                this.targetStreak_ = codedInputStream.readUInt32();
                            } else if (readTag == 48) {
                                this.targetBeans_ = codedInputStream.readUInt32();
                            } else if (readTag == 56) {
                                this.totalBeans_ = codedInputStream.readUInt32();
                            } else if (readTag == 66) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
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

        private StartRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static StartRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_StartPKExtra_StartRecord_descriptor;
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
                return getUid() == startRecord.getUid() && getScore() == startRecord.getScore() && getWinStreak() == startRecord.getWinStreak() && getAvatar().equals(startRecord.getAvatar()) && getTargetStreak() == startRecord.getTargetStreak() && getTargetBeans() == startRecord.getTargetBeans() && getTotalBeans() == startRecord.getTotalBeans() && getName().equals(startRecord.getName()) && this.unknownFields.equals(startRecord.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
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
        public StartRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
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
        public Parser<StartRecord> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
        public int getScore() {
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
            int i4 = this.score_;
            int i5 = i2;
            if (i4 != 0) {
                i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
            }
            int i6 = this.winStreak_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeUInt32Size(3, i6);
            }
            int i8 = i7;
            if (!getAvatarBytes().isEmpty()) {
                i8 = i7 + GeneratedMessageV3.computeStringSize(4, this.avatar_);
            }
            int i9 = this.targetStreak_;
            int i10 = i8;
            if (i9 != 0) {
                i10 = i8 + CodedOutputStream.computeUInt32Size(5, i9);
            }
            int i11 = this.targetBeans_;
            int i12 = i10;
            if (i11 != 0) {
                i12 = i10 + CodedOutputStream.computeUInt32Size(6, i11);
            }
            int i13 = this.totalBeans_;
            int i14 = i12;
            if (i13 != 0) {
                i14 = i12 + CodedOutputStream.computeUInt32Size(7, i13);
            }
            int i15 = i14;
            if (!getNameBytes().isEmpty()) {
                i15 = i14 + GeneratedMessageV3.computeStringSize(8, this.name_);
            }
            int serializedSize = i15 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
        public int getTargetBeans() {
            return this.targetBeans_;
        }

        @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
        public int getTargetStreak() {
            return this.targetStreak_;
        }

        @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
        public int getTotalBeans() {
            return this.totalBeans_;
        }

        @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.StartPKExtra.StartRecordOrBuilder
        public int getWinStreak() {
            return this.winStreak_;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getScore()) * 37) + 3) * 53) + getWinStreak()) * 37) + 4) * 53) + getAvatar().hashCode()) * 37) + 5) * 53) + getTargetStreak()) * 37) + 6) * 53) + getTargetBeans()) * 37) + 7) * 53) + getTotalBeans()) * 37) + 8) * 53) + getName().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_StartPKExtra_StartRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(StartRecord.class, Builder.class);
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
            int i2 = this.score_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(2, i2);
            }
            int i3 = this.winStreak_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(3, i3);
            }
            if (!getAvatarBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.avatar_);
            }
            int i4 = this.targetStreak_;
            if (i4 != 0) {
                codedOutputStream.writeUInt32(5, i4);
            }
            int i5 = this.targetBeans_;
            if (i5 != 0) {
                codedOutputStream.writeUInt32(6, i5);
            }
            int i6 = this.totalBeans_;
            if (i6 != 0) {
                codedOutputStream.writeUInt32(7, i6);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.name_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/StartPKExtra$StartRecordOrBuilder.class */
    public interface StartRecordOrBuilder extends MessageOrBuilder {
        String getAvatar();

        ByteString getAvatarBytes();

        String getName();

        ByteString getNameBytes();

        int getScore();

        int getTargetBeans();

        int getTargetStreak();

        int getTotalBeans();

        int getUid();

        int getWinStreak();
    }

    private StartPKExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.stream_ = "";
        this.targetStream_ = "";
        this.conferenceId_ = "";
        this.conferenceToken_ = "";
        this.uid_ = "";
        this.lid_ = "";
        this.name_ = "";
        this.avatar_ = "";
        this.records_ = Collections.emptyList();
        this.firstKillMessage_ = "";
    }

    private StartPKExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                this.stream_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 18:
                                this.targetStream_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 26:
                                this.conferenceId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 34:
                                this.conferenceToken_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 42:
                                this.uid_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 50:
                                this.lid_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 58:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 66:
                                this.avatar_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 72:
                                this.countdown_ = codedInputStream.readUInt64();
                                continue;
                            case 80:
                                this.delay_ = codedInputStream.readUInt64();
                                continue;
                            case 90:
                                boolean z4 = z2;
                                if (!(z2 & true)) {
                                    this.records_ = new ArrayList();
                                    z4 = z2 | true;
                                }
                                this.records_.add((StartRecord) codedInputStream.readMessage(StartRecord.parser(), extensionRegistryLite));
                                z2 = z4;
                                continue;
                            case 98:
                                this.firstKillMessage_ = codedInputStream.readStringRequireUtf8();
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
                    }
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

    private StartPKExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static StartPKExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_StartPKExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(StartPKExtra startPKExtra) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(startPKExtra);
    }

    public static StartPKExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StartPKExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static StartPKExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StartPKExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static StartPKExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static StartPKExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static StartPKExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StartPKExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static StartPKExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StartPKExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static StartPKExtra parseFrom(InputStream inputStream) throws IOException {
        return (StartPKExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static StartPKExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StartPKExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static StartPKExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static StartPKExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static StartPKExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static StartPKExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<StartPKExtra> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StartPKExtra) {
            StartPKExtra startPKExtra = (StartPKExtra) obj;
            return getStream().equals(startPKExtra.getStream()) && getTargetStream().equals(startPKExtra.getTargetStream()) && getConferenceId().equals(startPKExtra.getConferenceId()) && getConferenceToken().equals(startPKExtra.getConferenceToken()) && getUid().equals(startPKExtra.getUid()) && getLid().equals(startPKExtra.getLid()) && getName().equals(startPKExtra.getName()) && getAvatar().equals(startPKExtra.getAvatar()) && getCountdown() == startPKExtra.getCountdown() && getDelay() == startPKExtra.getDelay() && getRecordsList().equals(startPKExtra.getRecordsList()) && getFirstKillMessage().equals(startPKExtra.getFirstKillMessage()) && this.unknownFields.equals(startPKExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public String getAvatar() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatar_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public ByteString getAvatarBytes() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.avatar_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public String getConferenceId() {
        Object obj = this.conferenceId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.conferenceId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public ByteString getConferenceIdBytes() {
        Object obj = this.conferenceId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.conferenceId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public String getConferenceToken() {
        Object obj = this.conferenceToken_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.conferenceToken_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public ByteString getConferenceTokenBytes() {
        Object obj = this.conferenceToken_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.conferenceToken_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public long getCountdown() {
        return this.countdown_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public StartPKExtra getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public long getDelay() {
        return this.delay_;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public String getFirstKillMessage() {
        Object obj = this.firstKillMessage_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.firstKillMessage_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public ByteString getFirstKillMessageBytes() {
        Object obj = this.firstKillMessage_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.firstKillMessage_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public String getLid() {
        Object obj = this.lid_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.lid_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public ByteString getLidBytes() {
        Object obj = this.lid_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.lid_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
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
    public Parser<StartPKExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public StartRecord getRecords(int i) {
        return this.records_.get(i);
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public int getRecordsCount() {
        return this.records_.size();
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public List<StartRecord> getRecordsList() {
        return this.records_;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public StartRecordOrBuilder getRecordsOrBuilder(int i) {
        return this.records_.get(i);
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public List<? extends StartRecordOrBuilder> getRecordsOrBuilderList() {
        return this.records_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !getStreamBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.stream_) + 0 : 0;
        int i2 = computeStringSize;
        if (!getTargetStreamBytes().isEmpty()) {
            i2 = computeStringSize + GeneratedMessageV3.computeStringSize(2, this.targetStream_);
        }
        int i3 = i2;
        if (!getConferenceIdBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(3, this.conferenceId_);
        }
        int i4 = i3;
        if (!getConferenceTokenBytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(4, this.conferenceToken_);
        }
        int i5 = i4;
        if (!getUidBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(5, this.uid_);
        }
        int i6 = i5;
        if (!getLidBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(6, this.lid_);
        }
        int i7 = i6;
        if (!getNameBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(7, this.name_);
        }
        int i8 = i7;
        if (!getAvatarBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(8, this.avatar_);
        }
        long j = this.countdown_;
        int i9 = i8;
        if (j != 0) {
            i9 = i8 + CodedOutputStream.computeUInt64Size(9, j);
        }
        long j2 = this.delay_;
        int i10 = i9;
        int i11 = 0;
        if (j2 != 0) {
            i10 = i9 + CodedOutputStream.computeUInt64Size(10, j2);
            i11 = 0;
        }
        while (i11 < this.records_.size()) {
            i10 += CodedOutputStream.computeMessageSize(11, this.records_.get(i11));
            i11++;
        }
        int i12 = i10;
        if (!getFirstKillMessageBytes().isEmpty()) {
            i12 = i10 + GeneratedMessageV3.computeStringSize(12, this.firstKillMessage_);
        }
        int serializedSize = i12 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public String getStream() {
        Object obj = this.stream_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.stream_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public ByteString getStreamBytes() {
        Object obj = this.stream_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.stream_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public String getTargetStream() {
        Object obj = this.targetStream_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.targetStream_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public ByteString getTargetStreamBytes() {
        Object obj = this.targetStream_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.targetStream_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public String getUid() {
        Object obj = this.uid_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.uid_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.StartPKExtraOrBuilder
    public ByteString getUidBytes() {
        Object obj = this.uid_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.uid_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getStream().hashCode()) * 37) + 2) * 53) + getTargetStream().hashCode()) * 37) + 3) * 53) + getConferenceId().hashCode()) * 37) + 4) * 53) + getConferenceToken().hashCode()) * 37) + 5) * 53) + getUid().hashCode()) * 37) + 6) * 53) + getLid().hashCode()) * 37) + 7) * 53) + getName().hashCode()) * 37) + 8) * 53) + getAvatar().hashCode()) * 37) + 9) * 53) + Internal.hashLong(getCountdown())) * 37) + 10) * 53) + Internal.hashLong(getDelay());
        int i = hashCode;
        if (getRecordsCount() > 0) {
            i = (((hashCode * 37) + 11) * 53) + getRecordsList().hashCode();
        }
        int hashCode2 = (((((i * 37) + 12) * 53) + getFirstKillMessage().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_StartPKExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(StartPKExtra.class, Builder.class);
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
        return new StartPKExtra();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getStreamBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.stream_);
        }
        if (!getTargetStreamBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.targetStream_);
        }
        if (!getConferenceIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.conferenceId_);
        }
        if (!getConferenceTokenBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.conferenceToken_);
        }
        if (!getUidBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.uid_);
        }
        if (!getLidBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.lid_);
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.name_);
        }
        if (!getAvatarBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.avatar_);
        }
        long j = this.countdown_;
        if (j != 0) {
            codedOutputStream.writeUInt64(9, j);
        }
        long j2 = this.delay_;
        if (j2 != 0) {
            codedOutputStream.writeUInt64(10, j2);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.records_.size()) {
                break;
            }
            codedOutputStream.writeMessage(11, this.records_.get(i2));
            i = i2 + 1;
        }
        if (!getFirstKillMessageBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 12, this.firstKillMessage_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
