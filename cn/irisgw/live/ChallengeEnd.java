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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeEnd.class */
public final class ChallengeEnd extends GeneratedMessageV3 implements ChallengeEndOrBuilder {
    public static final int AGAIN_DISPLAY_FIELD_NUMBER = 6;
    public static final int KILL_DISPLAY_COUNTDOWN_FIELD_NUMBER = 3;
    public static final int KILL_FIELD_NUMBER = 2;
    public static final int MVP_DISPLAY_COUNTDOWN_FIELD_NUMBER = 5;
    public static final int RECORDS_FIELD_NUMBER = 1;
    public static final int RESULT_DISPLAY_COUNTDOWN_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private int againDisplay_;
    private int killDisplayCountdown_;
    private boolean kill_;
    private byte memoizedIsInitialized;
    private int mvpDisplayCountdown_;
    private List<ChallengeScoreResult> records_;
    private int resultDisplayCountdown_;
    private static final ChallengeEnd DEFAULT_INSTANCE = new ChallengeEnd();
    private static final Parser<ChallengeEnd> PARSER = new AbstractParser<ChallengeEnd>() { // from class: cn.irisgw.live.ChallengeEnd.1
        /* renamed from: parsePartialFrom */
        public ChallengeEnd m909parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ChallengeEnd(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeEnd$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallengeEndOrBuilder {
        private int againDisplay_;
        private int bitField0_;
        private int killDisplayCountdown_;
        private boolean kill_;
        private int mvpDisplayCountdown_;
        private RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> recordsBuilder_;
        private List<ChallengeScoreResult> records_;
        private int resultDisplayCountdown_;

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
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeEnd_descriptor;
        }

        private RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> getRecordsFieldBuilder() {
            if (this.recordsBuilder_ == null) {
                List<ChallengeScoreResult> list = this.records_;
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
            if (ChallengeEnd.alwaysUseFieldBuilders) {
                getRecordsFieldBuilder();
            }
        }

        public Builder addAllRecords(Iterable<? extends ChallengeScoreResult> iterable) {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureRecordsIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.records_);
            onChanged();
            return this;
        }

        public Builder addRecords(int i, ChallengeScoreResult.Builder builder) {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m962build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.add(i, builder.m962build());
            onChanged();
            return this;
        }

        public Builder addRecords(int i, ChallengeScoreResult challengeScoreResult) {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, challengeScoreResult);
                return this;
            } else if (challengeScoreResult != null) {
                ensureRecordsIsMutable();
                this.records_.add(i, challengeScoreResult);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addRecords(ChallengeScoreResult.Builder builder) {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m962build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.add(builder.m962build());
            onChanged();
            return this;
        }

        public Builder addRecords(ChallengeScoreResult challengeScoreResult) {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(challengeScoreResult);
                return this;
            } else if (challengeScoreResult != null) {
                ensureRecordsIsMutable();
                this.records_.add(challengeScoreResult);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public ChallengeScoreResult.Builder addRecordsBuilder() {
            return getRecordsFieldBuilder().addBuilder(ChallengeScoreResult.getDefaultInstance());
        }

        public ChallengeScoreResult.Builder addRecordsBuilder(int i) {
            return getRecordsFieldBuilder().addBuilder(i, ChallengeScoreResult.getDefaultInstance());
        }

        /* renamed from: addRepeatedField */
        public Builder m911addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public ChallengeEnd m913build() {
            ChallengeEnd m915buildPartial = m915buildPartial();
            if (m915buildPartial.isInitialized()) {
                return m915buildPartial;
            }
            throw newUninitializedMessageException(m915buildPartial);
        }

        /* renamed from: buildPartial */
        public ChallengeEnd m915buildPartial() {
            ChallengeEnd challengeEnd = new ChallengeEnd(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.records_ = Collections.unmodifiableList(this.records_);
                    this.bitField0_ &= -2;
                }
                challengeEnd.records_ = this.records_;
            } else {
                challengeEnd.records_ = repeatedFieldBuilderV3.build();
            }
            challengeEnd.kill_ = this.kill_;
            challengeEnd.killDisplayCountdown_ = this.killDisplayCountdown_;
            challengeEnd.resultDisplayCountdown_ = this.resultDisplayCountdown_;
            challengeEnd.mvpDisplayCountdown_ = this.mvpDisplayCountdown_;
            challengeEnd.againDisplay_ = this.againDisplay_;
            onBuilt();
            return challengeEnd;
        }

        /* renamed from: clear */
        public Builder m919clear() {
            super.clear();
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.records_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.kill_ = false;
            this.killDisplayCountdown_ = 0;
            this.resultDisplayCountdown_ = 0;
            this.mvpDisplayCountdown_ = 0;
            this.againDisplay_ = 0;
            return this;
        }

        public Builder clearAgainDisplay() {
            this.againDisplay_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m921clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearKill() {
            this.kill_ = false;
            onChanged();
            return this;
        }

        public Builder clearKillDisplayCountdown() {
            this.killDisplayCountdown_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMvpDisplayCountdown() {
            this.mvpDisplayCountdown_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m924clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRecords() {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.records_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearResultDisplayCountdown() {
            this.resultDisplayCountdown_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m930clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.ChallengeEndOrBuilder
        public int getAgainDisplay() {
            return this.againDisplay_;
        }

        /* renamed from: getDefaultInstanceForType */
        public ChallengeEnd m932getDefaultInstanceForType() {
            return ChallengeEnd.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeEnd_descriptor;
        }

        @Override // cn.irisgw.live.ChallengeEndOrBuilder
        public boolean getKill() {
            return this.kill_;
        }

        @Override // cn.irisgw.live.ChallengeEndOrBuilder
        public int getKillDisplayCountdown() {
            return this.killDisplayCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeEndOrBuilder
        public int getMvpDisplayCountdown() {
            return this.mvpDisplayCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeEndOrBuilder
        public ChallengeScoreResult getRecords(int i) {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public ChallengeScoreResult.Builder getRecordsBuilder(int i) {
            return getRecordsFieldBuilder().getBuilder(i);
        }

        public List<ChallengeScoreResult.Builder> getRecordsBuilderList() {
            return getRecordsFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.ChallengeEndOrBuilder
        public int getRecordsCount() {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.ChallengeEndOrBuilder
        public List<ChallengeScoreResult> getRecordsList() {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.records_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.ChallengeEndOrBuilder
        public ChallengeScoreResultOrBuilder getRecordsOrBuilder(int i) {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.records_.get(i) : (ChallengeScoreResultOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.ChallengeEndOrBuilder
        public List<? extends ChallengeScoreResultOrBuilder> getRecordsOrBuilderList() {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.records_);
        }

        @Override // cn.irisgw.live.ChallengeEndOrBuilder
        public int getResultDisplayCountdown() {
            return this.resultDisplayCountdown_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeEnd_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeEnd.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ChallengeEnd challengeEnd) {
            if (challengeEnd == ChallengeEnd.getDefaultInstance()) {
                return this;
            }
            if (this.recordsBuilder_ == null) {
                if (!challengeEnd.records_.isEmpty()) {
                    if (this.records_.isEmpty()) {
                        this.records_ = challengeEnd.records_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRecordsIsMutable();
                        this.records_.addAll(challengeEnd.records_);
                    }
                    onChanged();
                }
            } else if (!challengeEnd.records_.isEmpty()) {
                if (this.recordsBuilder_.isEmpty()) {
                    this.recordsBuilder_.dispose();
                    RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = null;
                    this.recordsBuilder_ = null;
                    this.records_ = challengeEnd.records_;
                    this.bitField0_ &= -2;
                    if (ChallengeEnd.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getRecordsFieldBuilder();
                    }
                    this.recordsBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.recordsBuilder_.addAllMessages(challengeEnd.records_);
                }
            }
            if (challengeEnd.getKill()) {
                setKill(challengeEnd.getKill());
            }
            if (challengeEnd.getKillDisplayCountdown() != 0) {
                setKillDisplayCountdown(challengeEnd.getKillDisplayCountdown());
            }
            if (challengeEnd.getResultDisplayCountdown() != 0) {
                setResultDisplayCountdown(challengeEnd.getResultDisplayCountdown());
            }
            if (challengeEnd.getMvpDisplayCountdown() != 0) {
                setMvpDisplayCountdown(challengeEnd.getMvpDisplayCountdown());
            }
            if (challengeEnd.getAgainDisplay() != 0) {
                setAgainDisplay(challengeEnd.getAgainDisplay());
            }
            m941mergeUnknownFields(challengeEnd.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ChallengeEnd.Builder m938mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ChallengeEnd.access$2700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ChallengeEnd r0 = (cn.irisgw.live.ChallengeEnd) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ChallengeEnd$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ChallengeEnd r0 = (cn.irisgw.live.ChallengeEnd) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ChallengeEnd$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ChallengeEnd.Builder.m938mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ChallengeEnd$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m937mergeFrom(Message message) {
            if (message instanceof ChallengeEnd) {
                return mergeFrom((ChallengeEnd) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m941mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeRecords(int i) {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.remove(i);
            onChanged();
            return this;
        }

        public Builder setAgainDisplay(int i) {
            this.againDisplay_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m943setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setKill(boolean z) {
            this.kill_ = z;
            onChanged();
            return this;
        }

        public Builder setKillDisplayCountdown(int i) {
            this.killDisplayCountdown_ = i;
            onChanged();
            return this;
        }

        public Builder setMvpDisplayCountdown(int i) {
            this.mvpDisplayCountdown_ = i;
            onChanged();
            return this;
        }

        public Builder setRecords(int i, ChallengeScoreResult.Builder builder) {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m962build());
                return this;
            }
            ensureRecordsIsMutable();
            this.records_.set(i, builder.m962build());
            onChanged();
            return this;
        }

        public Builder setRecords(int i, ChallengeScoreResult challengeScoreResult) {
            RepeatedFieldBuilderV3<ChallengeScoreResult, ChallengeScoreResult.Builder, ChallengeScoreResultOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, challengeScoreResult);
                return this;
            } else if (challengeScoreResult != null) {
                ensureRecordsIsMutable();
                this.records_.set(i, challengeScoreResult);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        /* renamed from: setRepeatedField */
        public Builder m945setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setResultDisplayCountdown(int i) {
            this.resultDisplayCountdown_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m947setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeEnd$ChallengeResultType.class */
    public enum ChallengeResultType implements ProtocolMessageEnum {
        Draw(0),
        Win(1),
        Lose(2),
        UNRECOGNIZED(-1);
        
        public static final int Draw_VALUE = 0;
        public static final int Lose_VALUE = 2;
        public static final int Win_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<ChallengeResultType> internalValueMap = new Internal.EnumLiteMap<ChallengeResultType>() { // from class: cn.irisgw.live.ChallengeEnd.ChallengeResultType.1
            /* renamed from: findValueByNumber */
            public ChallengeResultType m949findValueByNumber(int i) {
                return ChallengeResultType.forNumber(i);
            }
        };
        private static final ChallengeResultType[] VALUES = values();

        ChallengeResultType(int i) {
            this.value = i;
        }

        public static ChallengeResultType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return Lose;
                }
                return Win;
            }
            return Draw;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ChallengeEnd.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<ChallengeResultType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ChallengeResultType valueOf(int i) {
            return forNumber(i);
        }

        public static ChallengeResultType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeEnd$ChallengeScoreResult.class */
    public static final class ChallengeScoreResult extends GeneratedMessageV3 implements ChallengeScoreResultOrBuilder {
        public static final int HIDE_FIELD_NUMBER = 6;
        public static final int MVP_AVATAR_FIELD_NUMBER = 4;
        public static final int MVP_NAME_FIELD_NUMBER = 3;
        public static final int MVP_SCORE_FIELD_NUMBER = 5;
        public static final int SCORE_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private boolean hide_;
        private byte memoizedIsInitialized;
        private volatile Object mvpAvatar_;
        private volatile Object mvpName_;
        private int mvpScore_;
        private int score_;
        private int type_;
        private static final ChallengeScoreResult DEFAULT_INSTANCE = new ChallengeScoreResult();
        private static final Parser<ChallengeScoreResult> PARSER = new AbstractParser<ChallengeScoreResult>() { // from class: cn.irisgw.live.ChallengeEnd.ChallengeScoreResult.1
            /* renamed from: parsePartialFrom */
            public ChallengeScoreResult m958parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ChallengeScoreResult(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeEnd$ChallengeScoreResult$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallengeScoreResultOrBuilder {
            private boolean hide_;
            private Object mvpAvatar_;
            private Object mvpName_;
            private int mvpScore_;
            private int score_;
            private int type_;

            private Builder() {
                this.type_ = 0;
                this.mvpName_ = "";
                this.mvpAvatar_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.type_ = 0;
                this.mvpName_ = "";
                this.mvpAvatar_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_ChallengeEnd_ChallengeScoreResult_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ChallengeScoreResult.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m960addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public ChallengeScoreResult m962build() {
                ChallengeScoreResult m964buildPartial = m964buildPartial();
                if (m964buildPartial.isInitialized()) {
                    return m964buildPartial;
                }
                throw newUninitializedMessageException(m964buildPartial);
            }

            /* renamed from: buildPartial */
            public ChallengeScoreResult m964buildPartial() {
                ChallengeScoreResult challengeScoreResult = new ChallengeScoreResult(this);
                challengeScoreResult.score_ = this.score_;
                challengeScoreResult.type_ = this.type_;
                challengeScoreResult.mvpName_ = this.mvpName_;
                challengeScoreResult.mvpAvatar_ = this.mvpAvatar_;
                challengeScoreResult.mvpScore_ = this.mvpScore_;
                challengeScoreResult.hide_ = this.hide_;
                onBuilt();
                return challengeScoreResult;
            }

            /* renamed from: clear */
            public Builder m968clear() {
                super.clear();
                this.score_ = 0;
                this.type_ = 0;
                this.mvpName_ = "";
                this.mvpAvatar_ = "";
                this.mvpScore_ = 0;
                this.hide_ = false;
                return this;
            }

            /* renamed from: clearField */
            public Builder m970clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearHide() {
                this.hide_ = false;
                onChanged();
                return this;
            }

            public Builder clearMvpAvatar() {
                this.mvpAvatar_ = ChallengeScoreResult.getDefaultInstance().getMvpAvatar();
                onChanged();
                return this;
            }

            public Builder clearMvpName() {
                this.mvpName_ = ChallengeScoreResult.getDefaultInstance().getMvpName();
                onChanged();
                return this;
            }

            public Builder clearMvpScore() {
                this.mvpScore_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m973clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearScore() {
                this.score_ = 0;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m979clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public ChallengeScoreResult m981getDefaultInstanceForType() {
                return ChallengeScoreResult.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_ChallengeEnd_ChallengeScoreResult_descriptor;
            }

            @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
            public boolean getHide() {
                return this.hide_;
            }

            @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
            public String getMvpAvatar() {
                Object obj = this.mvpAvatar_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.mvpAvatar_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
            public ByteString getMvpAvatarBytes() {
                Object obj = this.mvpAvatar_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.mvpAvatar_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
            public String getMvpName() {
                Object obj = this.mvpName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.mvpName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
            public ByteString getMvpNameBytes() {
                Object obj = this.mvpName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.mvpName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
            public int getMvpScore() {
                return this.mvpScore_;
            }

            @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
            public int getScore() {
                return this.score_;
            }

            @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
            public ChallengeResultType getType() {
                ChallengeResultType valueOf = ChallengeResultType.valueOf(this.type_);
                ChallengeResultType challengeResultType = valueOf;
                if (valueOf == null) {
                    challengeResultType = ChallengeResultType.UNRECOGNIZED;
                }
                return challengeResultType;
            }

            @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_ChallengeEnd_ChallengeScoreResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeScoreResult.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(ChallengeScoreResult challengeScoreResult) {
                if (challengeScoreResult == ChallengeScoreResult.getDefaultInstance()) {
                    return this;
                }
                if (challengeScoreResult.getScore() != 0) {
                    setScore(challengeScoreResult.getScore());
                }
                if (challengeScoreResult.type_ != 0) {
                    setTypeValue(challengeScoreResult.getTypeValue());
                }
                if (!challengeScoreResult.getMvpName().isEmpty()) {
                    this.mvpName_ = challengeScoreResult.mvpName_;
                    onChanged();
                }
                if (!challengeScoreResult.getMvpAvatar().isEmpty()) {
                    this.mvpAvatar_ = challengeScoreResult.mvpAvatar_;
                    onChanged();
                }
                if (challengeScoreResult.getMvpScore() != 0) {
                    setMvpScore(challengeScoreResult.getMvpScore());
                }
                if (challengeScoreResult.getHide()) {
                    setHide(challengeScoreResult.getHide());
                }
                m990mergeUnknownFields(challengeScoreResult.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.ChallengeEnd.ChallengeScoreResult.Builder m987mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.ChallengeEnd.ChallengeScoreResult.access$1100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.ChallengeEnd$ChallengeScoreResult r0 = (cn.irisgw.live.ChallengeEnd.ChallengeScoreResult) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.ChallengeEnd$ChallengeScoreResult$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.ChallengeEnd$ChallengeScoreResult r0 = (cn.irisgw.live.ChallengeEnd.ChallengeScoreResult) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.ChallengeEnd$ChallengeScoreResult$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ChallengeEnd.ChallengeScoreResult.Builder.m987mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ChallengeEnd$ChallengeScoreResult$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m986mergeFrom(Message message) {
                if (message instanceof ChallengeScoreResult) {
                    return mergeFrom((ChallengeScoreResult) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m990mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            /* renamed from: setField */
            public Builder m992setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setHide(boolean z) {
                this.hide_ = z;
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
                    ChallengeScoreResult.checkByteStringIsUtf8(byteString);
                    this.mvpAvatar_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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
                    ChallengeScoreResult.checkByteStringIsUtf8(byteString);
                    this.mvpName_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMvpScore(int i) {
                this.mvpScore_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setRepeatedField */
            public Builder m994setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setScore(int i) {
                this.score_ = i;
                onChanged();
                return this;
            }

            public Builder setType(ChallengeResultType challengeResultType) {
                if (challengeResultType != null) {
                    this.type_ = challengeResultType.getNumber();
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

            /* renamed from: setUnknownFields */
            public final Builder m996setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private ChallengeScoreResult() {
            this.memoizedIsInitialized = (byte) -1;
            this.type_ = 0;
            this.mvpName_ = "";
            this.mvpAvatar_ = "";
        }

        private ChallengeScoreResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.score_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.type_ = codedInputStream.readEnum();
                            } else if (readTag == 26) {
                                this.mvpName_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                this.mvpAvatar_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 40) {
                                this.mvpScore_ = codedInputStream.readUInt32();
                            } else if (readTag == 48) {
                                this.hide_ = codedInputStream.readBool();
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

        private ChallengeScoreResult(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ChallengeScoreResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeEnd_ChallengeScoreResult_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m957toBuilder();
        }

        public static Builder newBuilder(ChallengeScoreResult challengeScoreResult) {
            return DEFAULT_INSTANCE.m957toBuilder().mergeFrom(challengeScoreResult);
        }

        public static ChallengeScoreResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ChallengeScoreResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ChallengeScoreResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ChallengeScoreResult) PARSER.parseFrom(byteString);
        }

        public static ChallengeScoreResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ChallengeScoreResult) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ChallengeScoreResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ChallengeScoreResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static ChallengeScoreResult parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ChallengeScoreResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ChallengeScoreResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ChallengeScoreResult) PARSER.parseFrom(byteBuffer);
        }

        public static ChallengeScoreResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ChallengeScoreResult) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ChallengeScoreResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ChallengeScoreResult) PARSER.parseFrom(bArr);
        }

        public static ChallengeScoreResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ChallengeScoreResult) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<ChallengeScoreResult> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ChallengeScoreResult) {
                ChallengeScoreResult challengeScoreResult = (ChallengeScoreResult) obj;
                return getScore() == challengeScoreResult.getScore() && this.type_ == challengeScoreResult.type_ && getMvpName().equals(challengeScoreResult.getMvpName()) && getMvpAvatar().equals(challengeScoreResult.getMvpAvatar()) && getMvpScore() == challengeScoreResult.getMvpScore() && getHide() == challengeScoreResult.getHide() && this.unknownFields.equals(challengeScoreResult.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public ChallengeScoreResult m952getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
        public boolean getHide() {
            return this.hide_;
        }

        @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
        public String getMvpAvatar() {
            Object obj = this.mvpAvatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mvpAvatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
        public ByteString getMvpAvatarBytes() {
            Object obj = this.mvpAvatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mvpAvatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
        public String getMvpName() {
            Object obj = this.mvpName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mvpName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
        public ByteString getMvpNameBytes() {
            Object obj = this.mvpName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mvpName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
        public int getMvpScore() {
            return this.mvpScore_;
        }

        public Parser<ChallengeScoreResult> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
        public int getScore() {
            return this.score_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.score_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
            }
            int i4 = i2;
            if (this.type_ != ChallengeResultType.Draw.getNumber()) {
                i4 = i2 + CodedOutputStream.computeEnumSize(2, this.type_);
            }
            int i5 = i4;
            if (!getMvpNameBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.mvpName_);
            }
            int i6 = i5;
            if (!getMvpAvatarBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.mvpAvatar_);
            }
            int i7 = this.mvpScore_;
            int i8 = i6;
            if (i7 != 0) {
                i8 = i6 + CodedOutputStream.computeUInt32Size(5, i7);
            }
            boolean z = this.hide_;
            int i9 = i8;
            if (z) {
                i9 = i8 + CodedOutputStream.computeBoolSize(6, z);
            }
            int serializedSize = i9 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
        public ChallengeResultType getType() {
            ChallengeResultType valueOf = ChallengeResultType.valueOf(this.type_);
            ChallengeResultType challengeResultType = valueOf;
            if (valueOf == null) {
                challengeResultType = ChallengeResultType.UNRECOGNIZED;
            }
            return challengeResultType;
        }

        @Override // cn.irisgw.live.ChallengeEnd.ChallengeScoreResultOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getScore()) * 37) + 2) * 53) + this.type_) * 37) + 3) * 53) + getMvpName().hashCode()) * 37) + 4) * 53) + getMvpAvatar().hashCode()) * 37) + 5) * 53) + getMvpScore()) * 37) + 6) * 53) + Internal.hashBoolean(getHide())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeEnd_ChallengeScoreResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeScoreResult.class, Builder.class);
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
        public Builder m955newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m954newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new ChallengeScoreResult();
        }

        /* renamed from: toBuilder */
        public Builder m957toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.score_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (this.type_ != ChallengeResultType.Draw.getNumber()) {
                codedOutputStream.writeEnum(2, this.type_);
            }
            if (!getMvpNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.mvpName_);
            }
            if (!getMvpAvatarBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.mvpAvatar_);
            }
            int i2 = this.mvpScore_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(5, i2);
            }
            boolean z = this.hide_;
            if (z) {
                codedOutputStream.writeBool(6, z);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeEnd$ChallengeScoreResultOrBuilder.class */
    public interface ChallengeScoreResultOrBuilder extends MessageOrBuilder {
        boolean getHide();

        String getMvpAvatar();

        ByteString getMvpAvatarBytes();

        String getMvpName();

        ByteString getMvpNameBytes();

        int getMvpScore();

        int getScore();

        ChallengeResultType getType();

        int getTypeValue();
    }

    private ChallengeEnd() {
        this.memoizedIsInitialized = (byte) -1;
        this.records_ = Collections.emptyList();
    }

    private ChallengeEnd(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        if (readTag != 0) {
                            if (readTag == 10) {
                                boolean z4 = z2;
                                if (!(z2 & true)) {
                                    this.records_ = new ArrayList();
                                    z4 = z2 | true;
                                }
                                this.records_.add((ChallengeScoreResult) codedInputStream.readMessage(ChallengeScoreResult.parser(), extensionRegistryLite));
                                z2 = z4;
                            } else if (readTag == 16) {
                                this.kill_ = codedInputStream.readBool();
                            } else if (readTag == 24) {
                                this.killDisplayCountdown_ = codedInputStream.readUInt32();
                            } else if (readTag == 32) {
                                this.resultDisplayCountdown_ = codedInputStream.readUInt32();
                            } else if (readTag == 40) {
                                this.mvpDisplayCountdown_ = codedInputStream.readUInt32();
                            } else if (readTag == 48) {
                                this.againDisplay_ = codedInputStream.readUInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
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

    private ChallengeEnd(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ChallengeEnd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeEnd_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m908toBuilder();
    }

    public static Builder newBuilder(ChallengeEnd challengeEnd) {
        return DEFAULT_INSTANCE.m908toBuilder().mergeFrom(challengeEnd);
    }

    public static ChallengeEnd parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ChallengeEnd parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeEnd parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ChallengeEnd) PARSER.parseFrom(byteString);
    }

    public static ChallengeEnd parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChallengeEnd) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ChallengeEnd parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ChallengeEnd parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ChallengeEnd parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ChallengeEnd parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeEnd parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ChallengeEnd) PARSER.parseFrom(byteBuffer);
    }

    public static ChallengeEnd parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChallengeEnd) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ChallengeEnd parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ChallengeEnd) PARSER.parseFrom(bArr);
    }

    public static ChallengeEnd parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChallengeEnd) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ChallengeEnd> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChallengeEnd) {
            ChallengeEnd challengeEnd = (ChallengeEnd) obj;
            return getRecordsList().equals(challengeEnd.getRecordsList()) && getKill() == challengeEnd.getKill() && getKillDisplayCountdown() == challengeEnd.getKillDisplayCountdown() && getResultDisplayCountdown() == challengeEnd.getResultDisplayCountdown() && getMvpDisplayCountdown() == challengeEnd.getMvpDisplayCountdown() && getAgainDisplay() == challengeEnd.getAgainDisplay() && this.unknownFields.equals(challengeEnd.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.ChallengeEndOrBuilder
    public int getAgainDisplay() {
        return this.againDisplay_;
    }

    /* renamed from: getDefaultInstanceForType */
    public ChallengeEnd m903getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ChallengeEndOrBuilder
    public boolean getKill() {
        return this.kill_;
    }

    @Override // cn.irisgw.live.ChallengeEndOrBuilder
    public int getKillDisplayCountdown() {
        return this.killDisplayCountdown_;
    }

    @Override // cn.irisgw.live.ChallengeEndOrBuilder
    public int getMvpDisplayCountdown() {
        return this.mvpDisplayCountdown_;
    }

    public Parser<ChallengeEnd> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.ChallengeEndOrBuilder
    public ChallengeScoreResult getRecords(int i) {
        return this.records_.get(i);
    }

    @Override // cn.irisgw.live.ChallengeEndOrBuilder
    public int getRecordsCount() {
        return this.records_.size();
    }

    @Override // cn.irisgw.live.ChallengeEndOrBuilder
    public List<ChallengeScoreResult> getRecordsList() {
        return this.records_;
    }

    @Override // cn.irisgw.live.ChallengeEndOrBuilder
    public ChallengeScoreResultOrBuilder getRecordsOrBuilder(int i) {
        return this.records_.get(i);
    }

    @Override // cn.irisgw.live.ChallengeEndOrBuilder
    public List<? extends ChallengeScoreResultOrBuilder> getRecordsOrBuilderList() {
        return this.records_;
    }

    @Override // cn.irisgw.live.ChallengeEndOrBuilder
    public int getResultDisplayCountdown() {
        return this.resultDisplayCountdown_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.records_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.records_.get(i3));
        }
        boolean z = this.kill_;
        int i4 = i2;
        if (z) {
            i4 = i2 + CodedOutputStream.computeBoolSize(2, z);
        }
        int i5 = this.killDisplayCountdown_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeUInt32Size(3, i5);
        }
        int i7 = this.resultDisplayCountdown_;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeUInt32Size(4, i7);
        }
        int i9 = this.mvpDisplayCountdown_;
        int i10 = i8;
        if (i9 != 0) {
            i10 = i8 + CodedOutputStream.computeUInt32Size(5, i9);
        }
        int i11 = this.againDisplay_;
        int i12 = i10;
        if (i11 != 0) {
            i12 = i10 + CodedOutputStream.computeUInt32Size(6, i11);
        }
        int serializedSize = i12 + this.unknownFields.getSerializedSize();
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
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (getRecordsCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getRecordsList().hashCode();
        }
        int hashBoolean = (((((((((((((((((((((i * 37) + 2) * 53) + Internal.hashBoolean(getKill())) * 37) + 3) * 53) + getKillDisplayCountdown()) * 37) + 4) * 53) + getResultDisplayCountdown()) * 37) + 5) * 53) + getMvpDisplayCountdown()) * 37) + 6) * 53) + getAgainDisplay()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashBoolean;
        return hashBoolean;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeEnd_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeEnd.class, Builder.class);
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
    public Builder m906newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m905newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new ChallengeEnd();
    }

    /* renamed from: toBuilder */
    public Builder m908toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

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
        boolean z = this.kill_;
        if (z) {
            codedOutputStream.writeBool(2, z);
        }
        int i3 = this.killDisplayCountdown_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(3, i3);
        }
        int i4 = this.resultDisplayCountdown_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(4, i4);
        }
        int i5 = this.mvpDisplayCountdown_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(5, i5);
        }
        int i6 = this.againDisplay_;
        if (i6 != 0) {
            codedOutputStream.writeUInt32(6, i6);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
