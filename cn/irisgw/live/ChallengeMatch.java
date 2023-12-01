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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeMatch.class */
public final class ChallengeMatch extends GeneratedMessageV3 implements ChallengeMatchOrBuilder {
    public static final int CHALLENGE_INFO_FIELD_NUMBER = 1;
    public static final int COUNTDOWN_FIELD_NUMBER = 2;
    public static final int DESC_CONTENTS_FIELD_NUMBER = 9;
    public static final int DESC_LINK_FIELD_NUMBER = 10;
    public static final int EGG_ALERT_COUNTDOWN_FIELD_NUMBER = 4;
    public static final int EGG_ALERT_DELAY_FIELD_NUMBER = 5;
    public static final int EGG_DELAY_FIELD_NUMBER = 6;
    public static final int FULL_COUNTDOWN_FIELD_NUMBER = 3;
    public static final int MAX_EGG_COUNTDOWN_FIELD_NUMBER = 7;
    public static final int TARGET_EGG_SCORE_FIELD_NUMBER = 8;
    private static final long serialVersionUID = 0;
    private List<ChallengeInfo> challengeInfo_;
    private int countdown_;
    private volatile Object descContents_;
    private volatile Object descLink_;
    private int eggAlertCountdown_;
    private int eggAlertDelay_;
    private int eggDelay_;
    private int fullCountdown_;
    private int maxEggCountdown_;
    private byte memoizedIsInitialized;
    private int targetEggScore_;
    private static final ChallengeMatch DEFAULT_INSTANCE = new ChallengeMatch();
    private static final Parser<ChallengeMatch> PARSER = new AbstractParser<ChallengeMatch>() { // from class: cn.irisgw.live.ChallengeMatch.1
        @Override // com.google.protobuf.Parser
        public ChallengeMatch parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ChallengeMatch(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeMatch$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallengeMatchOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> challengeInfoBuilder_;
        private List<ChallengeInfo> challengeInfo_;
        private int countdown_;
        private Object descContents_;
        private Object descLink_;
        private int eggAlertCountdown_;
        private int eggAlertDelay_;
        private int eggDelay_;
        private int fullCountdown_;
        private int maxEggCountdown_;
        private int targetEggScore_;

        private Builder() {
            this.challengeInfo_ = Collections.emptyList();
            this.descContents_ = "";
            this.descLink_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.challengeInfo_ = Collections.emptyList();
            this.descContents_ = "";
            this.descLink_ = "";
            maybeForceBuilderInitialization();
        }

        private void ensureChallengeInfoIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.challengeInfo_ = new ArrayList(this.challengeInfo_);
                this.bitField0_ |= 1;
            }
        }

        private RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> getChallengeInfoFieldBuilder() {
            if (this.challengeInfoBuilder_ == null) {
                List<ChallengeInfo> list = this.challengeInfo_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.challengeInfoBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.challengeInfo_ = null;
            }
            return this.challengeInfoBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeMatch_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            if (ChallengeMatch.alwaysUseFieldBuilders) {
                getChallengeInfoFieldBuilder();
            }
        }

        public Builder addAllChallengeInfo(Iterable<? extends ChallengeInfo> iterable) {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureChallengeInfoIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.challengeInfo_);
            onChanged();
            return this;
        }

        public Builder addChallengeInfo(int i, ChallengeInfo.Builder builder) {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureChallengeInfoIsMutable();
            this.challengeInfo_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addChallengeInfo(int i, ChallengeInfo challengeInfo) {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, challengeInfo);
                return this;
            } else if (challengeInfo != null) {
                ensureChallengeInfoIsMutable();
                this.challengeInfo_.add(i, challengeInfo);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addChallengeInfo(ChallengeInfo.Builder builder) {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureChallengeInfoIsMutable();
            this.challengeInfo_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addChallengeInfo(ChallengeInfo challengeInfo) {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(challengeInfo);
                return this;
            } else if (challengeInfo != null) {
                ensureChallengeInfoIsMutable();
                this.challengeInfo_.add(challengeInfo);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public ChallengeInfo.Builder addChallengeInfoBuilder() {
            return getChallengeInfoFieldBuilder().addBuilder(ChallengeInfo.getDefaultInstance());
        }

        public ChallengeInfo.Builder addChallengeInfoBuilder(int i) {
            return getChallengeInfoFieldBuilder().addBuilder(i, ChallengeInfo.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChallengeMatch build() {
            ChallengeMatch buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChallengeMatch buildPartial() {
            ChallengeMatch challengeMatch = new ChallengeMatch(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.challengeInfo_ = Collections.unmodifiableList(this.challengeInfo_);
                    this.bitField0_ &= -2;
                }
                challengeMatch.challengeInfo_ = this.challengeInfo_;
            } else {
                challengeMatch.challengeInfo_ = repeatedFieldBuilderV3.build();
            }
            challengeMatch.countdown_ = this.countdown_;
            challengeMatch.fullCountdown_ = this.fullCountdown_;
            challengeMatch.eggAlertCountdown_ = this.eggAlertCountdown_;
            challengeMatch.eggAlertDelay_ = this.eggAlertDelay_;
            challengeMatch.eggDelay_ = this.eggDelay_;
            challengeMatch.maxEggCountdown_ = this.maxEggCountdown_;
            challengeMatch.targetEggScore_ = this.targetEggScore_;
            challengeMatch.descContents_ = this.descContents_;
            challengeMatch.descLink_ = this.descLink_;
            onBuilt();
            return challengeMatch;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.challengeInfo_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.countdown_ = 0;
            this.fullCountdown_ = 0;
            this.eggAlertCountdown_ = 0;
            this.eggAlertDelay_ = 0;
            this.eggDelay_ = 0;
            this.maxEggCountdown_ = 0;
            this.targetEggScore_ = 0;
            this.descContents_ = "";
            this.descLink_ = "";
            return this;
        }

        public Builder clearChallengeInfo() {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.challengeInfo_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearCountdown() {
            this.countdown_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDescContents() {
            this.descContents_ = ChallengeMatch.getDefaultInstance().getDescContents();
            onChanged();
            return this;
        }

        public Builder clearDescLink() {
            this.descLink_ = ChallengeMatch.getDefaultInstance().getDescLink();
            onChanged();
            return this;
        }

        public Builder clearEggAlertCountdown() {
            this.eggAlertCountdown_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEggAlertDelay() {
            this.eggAlertDelay_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEggDelay() {
            this.eggDelay_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearFullCountdown() {
            this.fullCountdown_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMaxEggCountdown() {
            this.maxEggCountdown_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearTargetEggScore() {
            this.targetEggScore_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public ChallengeInfo getChallengeInfo(int i) {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.challengeInfo_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public ChallengeInfo.Builder getChallengeInfoBuilder(int i) {
            return getChallengeInfoFieldBuilder().getBuilder(i);
        }

        public List<ChallengeInfo.Builder> getChallengeInfoBuilderList() {
            return getChallengeInfoFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public int getChallengeInfoCount() {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.challengeInfo_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public List<ChallengeInfo> getChallengeInfoList() {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.challengeInfo_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public ChallengeInfoOrBuilder getChallengeInfoOrBuilder(int i) {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.challengeInfo_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public List<? extends ChallengeInfoOrBuilder> getChallengeInfoOrBuilderList() {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.challengeInfo_);
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public int getCountdown() {
            return this.countdown_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChallengeMatch getDefaultInstanceForType() {
            return ChallengeMatch.getDefaultInstance();
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public String getDescContents() {
            Object obj = this.descContents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.descContents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public ByteString getDescContentsBytes() {
            Object obj = this.descContents_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.descContents_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public String getDescLink() {
            Object obj = this.descLink_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.descLink_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public ByteString getDescLinkBytes() {
            Object obj = this.descLink_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.descLink_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeMatch_descriptor;
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public int getEggAlertCountdown() {
            return this.eggAlertCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public int getEggAlertDelay() {
            return this.eggAlertDelay_;
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public int getEggDelay() {
            return this.eggDelay_;
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public int getFullCountdown() {
            return this.fullCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public int getMaxEggCountdown() {
            return this.maxEggCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeMatchOrBuilder
        public int getTargetEggScore() {
            return this.targetEggScore_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeMatch_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeMatch.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ChallengeMatch challengeMatch) {
            if (challengeMatch == ChallengeMatch.getDefaultInstance()) {
                return this;
            }
            if (this.challengeInfoBuilder_ == null) {
                if (!challengeMatch.challengeInfo_.isEmpty()) {
                    if (this.challengeInfo_.isEmpty()) {
                        this.challengeInfo_ = challengeMatch.challengeInfo_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureChallengeInfoIsMutable();
                        this.challengeInfo_.addAll(challengeMatch.challengeInfo_);
                    }
                    onChanged();
                }
            } else if (!challengeMatch.challengeInfo_.isEmpty()) {
                if (this.challengeInfoBuilder_.isEmpty()) {
                    this.challengeInfoBuilder_.dispose();
                    RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = null;
                    this.challengeInfoBuilder_ = null;
                    this.challengeInfo_ = challengeMatch.challengeInfo_;
                    this.bitField0_ &= -2;
                    if (ChallengeMatch.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getChallengeInfoFieldBuilder();
                    }
                    this.challengeInfoBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.challengeInfoBuilder_.addAllMessages(challengeMatch.challengeInfo_);
                }
            }
            if (challengeMatch.getCountdown() != 0) {
                setCountdown(challengeMatch.getCountdown());
            }
            if (challengeMatch.getFullCountdown() != 0) {
                setFullCountdown(challengeMatch.getFullCountdown());
            }
            if (challengeMatch.getEggAlertCountdown() != 0) {
                setEggAlertCountdown(challengeMatch.getEggAlertCountdown());
            }
            if (challengeMatch.getEggAlertDelay() != 0) {
                setEggAlertDelay(challengeMatch.getEggAlertDelay());
            }
            if (challengeMatch.getEggDelay() != 0) {
                setEggDelay(challengeMatch.getEggDelay());
            }
            if (challengeMatch.getMaxEggCountdown() != 0) {
                setMaxEggCountdown(challengeMatch.getMaxEggCountdown());
            }
            if (challengeMatch.getTargetEggScore() != 0) {
                setTargetEggScore(challengeMatch.getTargetEggScore());
            }
            if (!challengeMatch.getDescContents().isEmpty()) {
                this.descContents_ = challengeMatch.descContents_;
                onChanged();
            }
            if (!challengeMatch.getDescLink().isEmpty()) {
                this.descLink_ = challengeMatch.descLink_;
                onChanged();
            }
            mergeUnknownFields(challengeMatch.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ChallengeMatch.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ChallengeMatch.access$3100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ChallengeMatch r0 = (cn.irisgw.live.ChallengeMatch) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ChallengeMatch$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ChallengeMatch r0 = (cn.irisgw.live.ChallengeMatch) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ChallengeMatch$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ChallengeMatch.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ChallengeMatch$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ChallengeMatch) {
                return mergeFrom((ChallengeMatch) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeChallengeInfo(int i) {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureChallengeInfoIsMutable();
            this.challengeInfo_.remove(i);
            onChanged();
            return this;
        }

        public Builder setChallengeInfo(int i, ChallengeInfo.Builder builder) {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureChallengeInfoIsMutable();
            this.challengeInfo_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setChallengeInfo(int i, ChallengeInfo challengeInfo) {
            RepeatedFieldBuilderV3<ChallengeInfo, ChallengeInfo.Builder, ChallengeInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, challengeInfo);
                return this;
            } else if (challengeInfo != null) {
                ensureChallengeInfoIsMutable();
                this.challengeInfo_.set(i, challengeInfo);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setCountdown(int i) {
            this.countdown_ = i;
            onChanged();
            return this;
        }

        public Builder setDescContents(String str) {
            if (str != null) {
                this.descContents_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDescContentsBytes(ByteString byteString) {
            if (byteString != null) {
                ChallengeMatch.checkByteStringIsUtf8(byteString);
                this.descContents_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDescLink(String str) {
            if (str != null) {
                this.descLink_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDescLinkBytes(ByteString byteString) {
            if (byteString != null) {
                ChallengeMatch.checkByteStringIsUtf8(byteString);
                this.descLink_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setEggAlertCountdown(int i) {
            this.eggAlertCountdown_ = i;
            onChanged();
            return this;
        }

        public Builder setEggAlertDelay(int i) {
            this.eggAlertDelay_ = i;
            onChanged();
            return this;
        }

        public Builder setEggDelay(int i) {
            this.eggDelay_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setFullCountdown(int i) {
            this.fullCountdown_ = i;
            onChanged();
            return this;
        }

        public Builder setMaxEggCountdown(int i) {
            this.maxEggCountdown_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setTargetEggScore(int i) {
            this.targetEggScore_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeMatch$ChallengeInfo.class */
    public static final class ChallengeInfo extends GeneratedMessageV3 implements ChallengeInfoOrBuilder {
        public static final int AVATAR_FIELD_NUMBER = 4;
        public static final int LID_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 5;
        public static final int SCORE_FIELD_NUMBER = 3;
        public static final int UID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object avatar_;
        private volatile Object lid_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private long score_;
        private int uid_;
        private static final ChallengeInfo DEFAULT_INSTANCE = new ChallengeInfo();
        private static final Parser<ChallengeInfo> PARSER = new AbstractParser<ChallengeInfo>() { // from class: cn.irisgw.live.ChallengeMatch.ChallengeInfo.1
            @Override // com.google.protobuf.Parser
            public ChallengeInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ChallengeInfo(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeMatch$ChallengeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallengeInfoOrBuilder {
            private Object avatar_;
            private Object lid_;
            private Object name_;
            private long score_;
            private int uid_;

            private Builder() {
                this.lid_ = "";
                this.avatar_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.lid_ = "";
                this.avatar_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_ChallengeMatch_ChallengeInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ChallengeInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChallengeInfo build() {
                ChallengeInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChallengeInfo buildPartial() {
                ChallengeInfo challengeInfo = new ChallengeInfo(this);
                challengeInfo.uid_ = this.uid_;
                challengeInfo.lid_ = this.lid_;
                challengeInfo.score_ = this.score_;
                challengeInfo.avatar_ = this.avatar_;
                challengeInfo.name_ = this.name_;
                onBuilt();
                return challengeInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.uid_ = 0;
                this.lid_ = "";
                this.score_ = 0L;
                this.avatar_ = "";
                this.name_ = "";
                return this;
            }

            public Builder clearAvatar() {
                this.avatar_ = ChallengeInfo.getDefaultInstance().getAvatar();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearLid() {
                this.lid_ = ChallengeInfo.getDefaultInstance().getLid();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = ChallengeInfo.getDefaultInstance().getName();
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
            public String getAvatar() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.avatar_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
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
            public ChallengeInfo getDefaultInstanceForType() {
                return ChallengeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_ChallengeMatch_ChallengeInfo_descriptor;
            }

            @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
            public String getLid() {
                Object obj = this.lid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.lid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
            public ByteString getLidBytes() {
                Object obj = this.lid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.lid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
            public long getScore() {
                return this.score_;
            }

            @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
            public int getUid() {
                return this.uid_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_ChallengeMatch_ChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeInfo.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(ChallengeInfo challengeInfo) {
                if (challengeInfo == ChallengeInfo.getDefaultInstance()) {
                    return this;
                }
                if (challengeInfo.getUid() != 0) {
                    setUid(challengeInfo.getUid());
                }
                if (!challengeInfo.getLid().isEmpty()) {
                    this.lid_ = challengeInfo.lid_;
                    onChanged();
                }
                if (challengeInfo.getScore() != 0) {
                    setScore(challengeInfo.getScore());
                }
                if (!challengeInfo.getAvatar().isEmpty()) {
                    this.avatar_ = challengeInfo.avatar_;
                    onChanged();
                }
                if (!challengeInfo.getName().isEmpty()) {
                    this.name_ = challengeInfo.name_;
                    onChanged();
                }
                mergeUnknownFields(challengeInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.ChallengeMatch.ChallengeInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.ChallengeMatch.ChallengeInfo.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.ChallengeMatch$ChallengeInfo r0 = (cn.irisgw.live.ChallengeMatch.ChallengeInfo) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.ChallengeMatch$ChallengeInfo$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.ChallengeMatch$ChallengeInfo r0 = (cn.irisgw.live.ChallengeMatch.ChallengeInfo) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.ChallengeMatch$ChallengeInfo$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ChallengeMatch.ChallengeInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ChallengeMatch$ChallengeInfo$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ChallengeInfo) {
                    return mergeFrom((ChallengeInfo) message);
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
                    ChallengeInfo.checkByteStringIsUtf8(byteString);
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
                    ChallengeInfo.checkByteStringIsUtf8(byteString);
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
                    ChallengeInfo.checkByteStringIsUtf8(byteString);
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
        }

        private ChallengeInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.lid_ = "";
            this.avatar_ = "";
            this.name_ = "";
        }

        private ChallengeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            } else if (readTag == 18) {
                                this.lid_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.score_ = codedInputStream.readUInt64();
                            } else if (readTag == 34) {
                                this.avatar_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
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

        private ChallengeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ChallengeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeMatch_ChallengeInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChallengeInfo challengeInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(challengeInfo);
        }

        public static ChallengeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ChallengeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ChallengeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ChallengeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ChallengeInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ChallengeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static ChallengeInfo parseFrom(InputStream inputStream) throws IOException {
            return (ChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ChallengeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ChallengeInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ChallengeInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ChallengeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ChallengeInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<ChallengeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ChallengeInfo) {
                ChallengeInfo challengeInfo = (ChallengeInfo) obj;
                return getUid() == challengeInfo.getUid() && getLid().equals(challengeInfo.getLid()) && getScore() == challengeInfo.getScore() && getAvatar().equals(challengeInfo.getAvatar()) && getName().equals(challengeInfo.getName()) && this.unknownFields.equals(challengeInfo.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
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
        public ChallengeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
        public String getLid() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.lid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
        public ByteString getLidBytes() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
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
        public Parser<ChallengeInfo> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
        public long getScore() {
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
            int i4 = i2;
            if (!getLidBytes().isEmpty()) {
                i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.lid_);
            }
            long j = this.score_;
            int i5 = i4;
            if (j != 0) {
                i5 = i4 + CodedOutputStream.computeUInt64Size(3, j);
            }
            int i6 = i5;
            if (!getAvatarBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.avatar_);
            }
            int i7 = i6;
            if (!getNameBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.name_);
            }
            int serializedSize = i7 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.ChallengeMatch.ChallengeInfoOrBuilder
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
            int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getLid().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getScore())) * 37) + 4) * 53) + getAvatar().hashCode()) * 37) + 5) * 53) + getName().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeMatch_ChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeInfo.class, Builder.class);
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
            return new ChallengeInfo();
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
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeMatch$ChallengeInfoOrBuilder.class */
    public interface ChallengeInfoOrBuilder extends MessageOrBuilder {
        String getAvatar();

        ByteString getAvatarBytes();

        String getLid();

        ByteString getLidBytes();

        String getName();

        ByteString getNameBytes();

        long getScore();

        int getUid();
    }

    private ChallengeMatch() {
        this.memoizedIsInitialized = (byte) -1;
        this.challengeInfo_ = Collections.emptyList();
        this.descContents_ = "";
        this.descLink_ = "";
    }

    private ChallengeMatch(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.challengeInfo_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.challengeInfo_.add((ChallengeInfo) codedInputStream.readMessage(ChallengeInfo.parser(), extensionRegistryLite));
                            z2 = z4;
                            continue;
                        case 16:
                            this.countdown_ = codedInputStream.readUInt32();
                            continue;
                        case 24:
                            this.fullCountdown_ = codedInputStream.readUInt32();
                            continue;
                        case 32:
                            this.eggAlertCountdown_ = codedInputStream.readUInt32();
                            continue;
                        case 40:
                            this.eggAlertDelay_ = codedInputStream.readUInt32();
                            continue;
                        case 48:
                            this.eggDelay_ = codedInputStream.readUInt32();
                            continue;
                        case 56:
                            this.maxEggCountdown_ = codedInputStream.readUInt32();
                            continue;
                        case 64:
                            this.targetEggScore_ = codedInputStream.readUInt32();
                            continue;
                        case 74:
                            this.descContents_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 82:
                            this.descLink_ = codedInputStream.readStringRequireUtf8();
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
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.challengeInfo_ = Collections.unmodifiableList(this.challengeInfo_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.challengeInfo_ = Collections.unmodifiableList(this.challengeInfo_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private ChallengeMatch(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ChallengeMatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeMatch_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ChallengeMatch challengeMatch) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(challengeMatch);
    }

    public static ChallengeMatch parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ChallengeMatch) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ChallengeMatch parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeMatch) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeMatch parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ChallengeMatch parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ChallengeMatch parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ChallengeMatch) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ChallengeMatch parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeMatch) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ChallengeMatch parseFrom(InputStream inputStream) throws IOException {
        return (ChallengeMatch) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ChallengeMatch parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeMatch) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeMatch parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ChallengeMatch parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ChallengeMatch parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ChallengeMatch parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ChallengeMatch> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChallengeMatch) {
            ChallengeMatch challengeMatch = (ChallengeMatch) obj;
            return getChallengeInfoList().equals(challengeMatch.getChallengeInfoList()) && getCountdown() == challengeMatch.getCountdown() && getFullCountdown() == challengeMatch.getFullCountdown() && getEggAlertCountdown() == challengeMatch.getEggAlertCountdown() && getEggAlertDelay() == challengeMatch.getEggAlertDelay() && getEggDelay() == challengeMatch.getEggDelay() && getMaxEggCountdown() == challengeMatch.getMaxEggCountdown() && getTargetEggScore() == challengeMatch.getTargetEggScore() && getDescContents().equals(challengeMatch.getDescContents()) && getDescLink().equals(challengeMatch.getDescLink()) && this.unknownFields.equals(challengeMatch.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public ChallengeInfo getChallengeInfo(int i) {
        return this.challengeInfo_.get(i);
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public int getChallengeInfoCount() {
        return this.challengeInfo_.size();
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public List<ChallengeInfo> getChallengeInfoList() {
        return this.challengeInfo_;
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public ChallengeInfoOrBuilder getChallengeInfoOrBuilder(int i) {
        return this.challengeInfo_.get(i);
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public List<? extends ChallengeInfoOrBuilder> getChallengeInfoOrBuilderList() {
        return this.challengeInfo_;
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public int getCountdown() {
        return this.countdown_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ChallengeMatch getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public String getDescContents() {
        Object obj = this.descContents_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.descContents_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public ByteString getDescContentsBytes() {
        Object obj = this.descContents_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.descContents_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public String getDescLink() {
        Object obj = this.descLink_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.descLink_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public ByteString getDescLinkBytes() {
        Object obj = this.descLink_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.descLink_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public int getEggAlertCountdown() {
        return this.eggAlertCountdown_;
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public int getEggAlertDelay() {
        return this.eggAlertDelay_;
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public int getEggDelay() {
        return this.eggDelay_;
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public int getFullCountdown() {
        return this.fullCountdown_;
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public int getMaxEggCountdown() {
        return this.maxEggCountdown_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ChallengeMatch> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.challengeInfo_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.challengeInfo_.get(i3));
        }
        int i4 = this.countdown_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int i6 = this.fullCountdown_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeUInt32Size(3, i6);
        }
        int i8 = this.eggAlertCountdown_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(4, i8);
        }
        int i10 = this.eggAlertDelay_;
        int i11 = i9;
        if (i10 != 0) {
            i11 = i9 + CodedOutputStream.computeUInt32Size(5, i10);
        }
        int i12 = this.eggDelay_;
        int i13 = i11;
        if (i12 != 0) {
            i13 = i11 + CodedOutputStream.computeUInt32Size(6, i12);
        }
        int i14 = this.maxEggCountdown_;
        int i15 = i13;
        if (i14 != 0) {
            i15 = i13 + CodedOutputStream.computeUInt32Size(7, i14);
        }
        int i16 = this.targetEggScore_;
        int i17 = i15;
        if (i16 != 0) {
            i17 = i15 + CodedOutputStream.computeUInt32Size(8, i16);
        }
        int i18 = i17;
        if (!getDescContentsBytes().isEmpty()) {
            i18 = i17 + GeneratedMessageV3.computeStringSize(9, this.descContents_);
        }
        int i19 = i18;
        if (!getDescLinkBytes().isEmpty()) {
            i19 = i18 + GeneratedMessageV3.computeStringSize(10, this.descLink_);
        }
        int serializedSize = i19 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.ChallengeMatchOrBuilder
    public int getTargetEggScore() {
        return this.targetEggScore_;
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
        if (getChallengeInfoCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getChallengeInfoList().hashCode();
        }
        int countdown = (((((((((((((((((((((((((((((((((((((i * 37) + 2) * 53) + getCountdown()) * 37) + 3) * 53) + getFullCountdown()) * 37) + 4) * 53) + getEggAlertCountdown()) * 37) + 5) * 53) + getEggAlertDelay()) * 37) + 6) * 53) + getEggDelay()) * 37) + 7) * 53) + getMaxEggCountdown()) * 37) + 8) * 53) + getTargetEggScore()) * 37) + 9) * 53) + getDescContents().hashCode()) * 37) + 10) * 53) + getDescLink().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = countdown;
        return countdown;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeMatch_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeMatch.class, Builder.class);
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
        return new ChallengeMatch();
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
            if (i2 >= this.challengeInfo_.size()) {
                break;
            }
            codedOutputStream.writeMessage(1, this.challengeInfo_.get(i2));
            i = i2 + 1;
        }
        int i3 = this.countdown_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(2, i3);
        }
        int i4 = this.fullCountdown_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(3, i4);
        }
        int i5 = this.eggAlertCountdown_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(4, i5);
        }
        int i6 = this.eggAlertDelay_;
        if (i6 != 0) {
            codedOutputStream.writeUInt32(5, i6);
        }
        int i7 = this.eggDelay_;
        if (i7 != 0) {
            codedOutputStream.writeUInt32(6, i7);
        }
        int i8 = this.maxEggCountdown_;
        if (i8 != 0) {
            codedOutputStream.writeUInt32(7, i8);
        }
        int i9 = this.targetEggScore_;
        if (i9 != 0) {
            codedOutputStream.writeUInt32(8, i9);
        }
        if (!getDescContentsBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.descContents_);
        }
        if (!getDescLinkBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 10, this.descLink_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
