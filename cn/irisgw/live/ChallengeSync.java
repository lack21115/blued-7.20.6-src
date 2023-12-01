package cn.irisgw.live;

import cn.irisgw.live.ChallengeSyncInfo;
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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeSync.class */
public final class ChallengeSync extends GeneratedMessageV3 implements ChallengeSyncOrBuilder {
    public static final int CHALLENGE_INFO_FIELD_NUMBER = 1;
    public static final int COUNTDOWN_FIELD_NUMBER = 3;
    public static final int DESC_CONTENTS_FIELD_NUMBER = 17;
    public static final int DESC_LINK_FIELD_NUMBER = 18;
    public static final int EGG_ALERT_COUNTDOWN_FIELD_NUMBER = 5;
    public static final int EGG_ALERT_DELAY_FIELD_NUMBER = 6;
    public static final int EGG_COUNTDOWN_FIELD_NUMBER = 15;
    public static final int EGG_DELAY_FIELD_NUMBER = 7;
    public static final int FULL_COUNTDOWN_FIELD_NUMBER = 4;
    public static final int GREATER_SCORE_FIELD_NUMBER = 16;
    public static final int KILL_ALERT_COUNTDOWN_FIELD_NUMBER = 14;
    public static final int KILL_ALERT_DELAY_FIELD_NUMBER = 10;
    public static final int KILL_COUNTDOWN_FIELD_NUMBER = 13;
    public static final int KILL_DELAY_FIELD_NUMBER = 11;
    public static final int KILL_OPEN_FIELD_NUMBER = 12;
    public static final int MAX_EGG_COUNTDOWN_FIELD_NUMBER = 8;
    public static final int STAGE_FIELD_NUMBER = 2;
    public static final int TARGET_EGG_SCORE_FIELD_NUMBER = 9;
    private static final long serialVersionUID = 0;
    private List<ChallengeSyncInfo> challengeInfo_;
    private int countdown_;
    private volatile Object descContents_;
    private volatile Object descLink_;
    private int eggAlertCountdown_;
    private int eggAlertDelay_;
    private int eggCountdown_;
    private int eggDelay_;
    private int fullCountdown_;
    private int greaterScore_;
    private int killAlertCountdown_;
    private int killAlertDelay_;
    private int killCountdown_;
    private int killDelay_;
    private boolean killOpen_;
    private int maxEggCountdown_;
    private byte memoizedIsInitialized;
    private int stage_;
    private int targetEggScore_;
    private static final ChallengeSync DEFAULT_INSTANCE = new ChallengeSync();
    private static final Parser<ChallengeSync> PARSER = new AbstractParser<ChallengeSync>() { // from class: cn.irisgw.live.ChallengeSync.1
        @Override // com.google.protobuf.Parser
        public ChallengeSync parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ChallengeSync(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeSync$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallengeSyncOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> challengeInfoBuilder_;
        private List<ChallengeSyncInfo> challengeInfo_;
        private int countdown_;
        private Object descContents_;
        private Object descLink_;
        private int eggAlertCountdown_;
        private int eggAlertDelay_;
        private int eggCountdown_;
        private int eggDelay_;
        private int fullCountdown_;
        private int greaterScore_;
        private int killAlertCountdown_;
        private int killAlertDelay_;
        private int killCountdown_;
        private int killDelay_;
        private boolean killOpen_;
        private int maxEggCountdown_;
        private int stage_;
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

        private RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> getChallengeInfoFieldBuilder() {
            if (this.challengeInfoBuilder_ == null) {
                List<ChallengeSyncInfo> list = this.challengeInfo_;
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
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeSync_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            if (ChallengeSync.alwaysUseFieldBuilders) {
                getChallengeInfoFieldBuilder();
            }
        }

        public Builder addAllChallengeInfo(Iterable<? extends ChallengeSyncInfo> iterable) {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureChallengeInfoIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.challengeInfo_);
            onChanged();
            return this;
        }

        public Builder addChallengeInfo(int i, ChallengeSyncInfo.Builder builder) {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureChallengeInfoIsMutable();
            this.challengeInfo_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addChallengeInfo(int i, ChallengeSyncInfo challengeSyncInfo) {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, challengeSyncInfo);
                return this;
            } else if (challengeSyncInfo != null) {
                ensureChallengeInfoIsMutable();
                this.challengeInfo_.add(i, challengeSyncInfo);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addChallengeInfo(ChallengeSyncInfo.Builder builder) {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureChallengeInfoIsMutable();
            this.challengeInfo_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addChallengeInfo(ChallengeSyncInfo challengeSyncInfo) {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(challengeSyncInfo);
                return this;
            } else if (challengeSyncInfo != null) {
                ensureChallengeInfoIsMutable();
                this.challengeInfo_.add(challengeSyncInfo);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public ChallengeSyncInfo.Builder addChallengeInfoBuilder() {
            return getChallengeInfoFieldBuilder().addBuilder(ChallengeSyncInfo.getDefaultInstance());
        }

        public ChallengeSyncInfo.Builder addChallengeInfoBuilder(int i) {
            return getChallengeInfoFieldBuilder().addBuilder(i, ChallengeSyncInfo.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChallengeSync build() {
            ChallengeSync buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChallengeSync buildPartial() {
            ChallengeSync challengeSync = new ChallengeSync(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.challengeInfo_ = Collections.unmodifiableList(this.challengeInfo_);
                    this.bitField0_ &= -2;
                }
                challengeSync.challengeInfo_ = this.challengeInfo_;
            } else {
                challengeSync.challengeInfo_ = repeatedFieldBuilderV3.build();
            }
            challengeSync.stage_ = this.stage_;
            challengeSync.countdown_ = this.countdown_;
            challengeSync.fullCountdown_ = this.fullCountdown_;
            challengeSync.eggAlertCountdown_ = this.eggAlertCountdown_;
            challengeSync.eggAlertDelay_ = this.eggAlertDelay_;
            challengeSync.eggDelay_ = this.eggDelay_;
            challengeSync.maxEggCountdown_ = this.maxEggCountdown_;
            challengeSync.targetEggScore_ = this.targetEggScore_;
            challengeSync.killAlertDelay_ = this.killAlertDelay_;
            challengeSync.killDelay_ = this.killDelay_;
            challengeSync.killOpen_ = this.killOpen_;
            challengeSync.killCountdown_ = this.killCountdown_;
            challengeSync.killAlertCountdown_ = this.killAlertCountdown_;
            challengeSync.eggCountdown_ = this.eggCountdown_;
            challengeSync.greaterScore_ = this.greaterScore_;
            challengeSync.descContents_ = this.descContents_;
            challengeSync.descLink_ = this.descLink_;
            onBuilt();
            return challengeSync;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.challengeInfo_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.stage_ = 0;
            this.countdown_ = 0;
            this.fullCountdown_ = 0;
            this.eggAlertCountdown_ = 0;
            this.eggAlertDelay_ = 0;
            this.eggDelay_ = 0;
            this.maxEggCountdown_ = 0;
            this.targetEggScore_ = 0;
            this.killAlertDelay_ = 0;
            this.killDelay_ = 0;
            this.killOpen_ = false;
            this.killCountdown_ = 0;
            this.killAlertCountdown_ = 0;
            this.eggCountdown_ = 0;
            this.greaterScore_ = 0;
            this.descContents_ = "";
            this.descLink_ = "";
            return this;
        }

        public Builder clearChallengeInfo() {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
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
            this.descContents_ = ChallengeSync.getDefaultInstance().getDescContents();
            onChanged();
            return this;
        }

        public Builder clearDescLink() {
            this.descLink_ = ChallengeSync.getDefaultInstance().getDescLink();
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

        public Builder clearEggCountdown() {
            this.eggCountdown_ = 0;
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

        public Builder clearGreaterScore() {
            this.greaterScore_ = 0;
            onChanged();
            return this;
        }

        public Builder clearKillAlertCountdown() {
            this.killAlertCountdown_ = 0;
            onChanged();
            return this;
        }

        public Builder clearKillAlertDelay() {
            this.killAlertDelay_ = 0;
            onChanged();
            return this;
        }

        public Builder clearKillCountdown() {
            this.killCountdown_ = 0;
            onChanged();
            return this;
        }

        public Builder clearKillDelay() {
            this.killDelay_ = 0;
            onChanged();
            return this;
        }

        public Builder clearKillOpen() {
            this.killOpen_ = false;
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

        public Builder clearStage() {
            this.stage_ = 0;
            onChanged();
            return this;
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

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public ChallengeSyncInfo getChallengeInfo(int i) {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.challengeInfo_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public ChallengeSyncInfo.Builder getChallengeInfoBuilder(int i) {
            return getChallengeInfoFieldBuilder().getBuilder(i);
        }

        public List<ChallengeSyncInfo.Builder> getChallengeInfoBuilderList() {
            return getChallengeInfoFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getChallengeInfoCount() {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.challengeInfo_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public List<ChallengeSyncInfo> getChallengeInfoList() {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.challengeInfo_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public ChallengeSyncInfoOrBuilder getChallengeInfoOrBuilder(int i) {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.challengeInfo_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public List<? extends ChallengeSyncInfoOrBuilder> getChallengeInfoOrBuilderList() {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.challengeInfo_);
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getCountdown() {
            return this.countdown_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChallengeSync getDefaultInstanceForType() {
            return ChallengeSync.getDefaultInstance();
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public String getDescContents() {
            Object obj = this.descContents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.descContents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public ByteString getDescContentsBytes() {
            Object obj = this.descContents_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.descContents_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public String getDescLink() {
            Object obj = this.descLink_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.descLink_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
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
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeSync_descriptor;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getEggAlertCountdown() {
            return this.eggAlertCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getEggAlertDelay() {
            return this.eggAlertDelay_;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getEggCountdown() {
            return this.eggCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getEggDelay() {
            return this.eggDelay_;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getFullCountdown() {
            return this.fullCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getGreaterScore() {
            return this.greaterScore_;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getKillAlertCountdown() {
            return this.killAlertCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getKillAlertDelay() {
            return this.killAlertDelay_;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getKillCountdown() {
            return this.killCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getKillDelay() {
            return this.killDelay_;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public boolean getKillOpen() {
            return this.killOpen_;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getMaxEggCountdown() {
            return this.maxEggCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getStage() {
            return this.stage_;
        }

        @Override // cn.irisgw.live.ChallengeSyncOrBuilder
        public int getTargetEggScore() {
            return this.targetEggScore_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeSync_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeSync.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ChallengeSync challengeSync) {
            if (challengeSync == ChallengeSync.getDefaultInstance()) {
                return this;
            }
            if (this.challengeInfoBuilder_ == null) {
                if (!challengeSync.challengeInfo_.isEmpty()) {
                    if (this.challengeInfo_.isEmpty()) {
                        this.challengeInfo_ = challengeSync.challengeInfo_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureChallengeInfoIsMutable();
                        this.challengeInfo_.addAll(challengeSync.challengeInfo_);
                    }
                    onChanged();
                }
            } else if (!challengeSync.challengeInfo_.isEmpty()) {
                if (this.challengeInfoBuilder_.isEmpty()) {
                    this.challengeInfoBuilder_.dispose();
                    RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = null;
                    this.challengeInfoBuilder_ = null;
                    this.challengeInfo_ = challengeSync.challengeInfo_;
                    this.bitField0_ &= -2;
                    if (ChallengeSync.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getChallengeInfoFieldBuilder();
                    }
                    this.challengeInfoBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.challengeInfoBuilder_.addAllMessages(challengeSync.challengeInfo_);
                }
            }
            if (challengeSync.getStage() != 0) {
                setStage(challengeSync.getStage());
            }
            if (challengeSync.getCountdown() != 0) {
                setCountdown(challengeSync.getCountdown());
            }
            if (challengeSync.getFullCountdown() != 0) {
                setFullCountdown(challengeSync.getFullCountdown());
            }
            if (challengeSync.getEggAlertCountdown() != 0) {
                setEggAlertCountdown(challengeSync.getEggAlertCountdown());
            }
            if (challengeSync.getEggAlertDelay() != 0) {
                setEggAlertDelay(challengeSync.getEggAlertDelay());
            }
            if (challengeSync.getEggDelay() != 0) {
                setEggDelay(challengeSync.getEggDelay());
            }
            if (challengeSync.getMaxEggCountdown() != 0) {
                setMaxEggCountdown(challengeSync.getMaxEggCountdown());
            }
            if (challengeSync.getTargetEggScore() != 0) {
                setTargetEggScore(challengeSync.getTargetEggScore());
            }
            if (challengeSync.getKillAlertDelay() != 0) {
                setKillAlertDelay(challengeSync.getKillAlertDelay());
            }
            if (challengeSync.getKillDelay() != 0) {
                setKillDelay(challengeSync.getKillDelay());
            }
            if (challengeSync.getKillOpen()) {
                setKillOpen(challengeSync.getKillOpen());
            }
            if (challengeSync.getKillCountdown() != 0) {
                setKillCountdown(challengeSync.getKillCountdown());
            }
            if (challengeSync.getKillAlertCountdown() != 0) {
                setKillAlertCountdown(challengeSync.getKillAlertCountdown());
            }
            if (challengeSync.getEggCountdown() != 0) {
                setEggCountdown(challengeSync.getEggCountdown());
            }
            if (challengeSync.getGreaterScore() != 0) {
                setGreaterScore(challengeSync.getGreaterScore());
            }
            if (!challengeSync.getDescContents().isEmpty()) {
                this.descContents_ = challengeSync.descContents_;
                onChanged();
            }
            if (!challengeSync.getDescLink().isEmpty()) {
                this.descLink_ = challengeSync.descLink_;
                onChanged();
            }
            mergeUnknownFields(challengeSync.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ChallengeSync.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ChallengeSync.access$2400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ChallengeSync r0 = (cn.irisgw.live.ChallengeSync) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ChallengeSync$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ChallengeSync r0 = (cn.irisgw.live.ChallengeSync) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ChallengeSync$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ChallengeSync.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ChallengeSync$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ChallengeSync) {
                return mergeFrom((ChallengeSync) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeChallengeInfo(int i) {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureChallengeInfoIsMutable();
            this.challengeInfo_.remove(i);
            onChanged();
            return this;
        }

        public Builder setChallengeInfo(int i, ChallengeSyncInfo.Builder builder) {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureChallengeInfoIsMutable();
            this.challengeInfo_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setChallengeInfo(int i, ChallengeSyncInfo challengeSyncInfo) {
            RepeatedFieldBuilderV3<ChallengeSyncInfo, ChallengeSyncInfo.Builder, ChallengeSyncInfoOrBuilder> repeatedFieldBuilderV3 = this.challengeInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, challengeSyncInfo);
                return this;
            } else if (challengeSyncInfo != null) {
                ensureChallengeInfoIsMutable();
                this.challengeInfo_.set(i, challengeSyncInfo);
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
                ChallengeSync.checkByteStringIsUtf8(byteString);
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
                ChallengeSync.checkByteStringIsUtf8(byteString);
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

        public Builder setEggCountdown(int i) {
            this.eggCountdown_ = i;
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

        public Builder setGreaterScore(int i) {
            this.greaterScore_ = i;
            onChanged();
            return this;
        }

        public Builder setKillAlertCountdown(int i) {
            this.killAlertCountdown_ = i;
            onChanged();
            return this;
        }

        public Builder setKillAlertDelay(int i) {
            this.killAlertDelay_ = i;
            onChanged();
            return this;
        }

        public Builder setKillCountdown(int i) {
            this.killCountdown_ = i;
            onChanged();
            return this;
        }

        public Builder setKillDelay(int i) {
            this.killDelay_ = i;
            onChanged();
            return this;
        }

        public Builder setKillOpen(boolean z) {
            this.killOpen_ = z;
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

        public Builder setStage(int i) {
            this.stage_ = i;
            onChanged();
            return this;
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

    private ChallengeSync() {
        this.memoizedIsInitialized = (byte) -1;
        this.challengeInfo_ = Collections.emptyList();
        this.descContents_ = "";
        this.descLink_ = "";
    }

    private ChallengeSync(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.challengeInfo_.add((ChallengeSyncInfo) codedInputStream.readMessage(ChallengeSyncInfo.parser(), extensionRegistryLite));
                            z2 = z4;
                            continue;
                        case 16:
                            this.stage_ = codedInputStream.readUInt32();
                            continue;
                        case 24:
                            this.countdown_ = codedInputStream.readUInt32();
                            continue;
                        case 32:
                            this.fullCountdown_ = codedInputStream.readUInt32();
                            continue;
                        case 40:
                            this.eggAlertCountdown_ = codedInputStream.readUInt32();
                            continue;
                        case 48:
                            this.eggAlertDelay_ = codedInputStream.readUInt32();
                            continue;
                        case 56:
                            this.eggDelay_ = codedInputStream.readUInt32();
                            continue;
                        case 64:
                            this.maxEggCountdown_ = codedInputStream.readUInt32();
                            continue;
                        case 72:
                            this.targetEggScore_ = codedInputStream.readUInt32();
                            continue;
                        case 80:
                            this.killAlertDelay_ = codedInputStream.readUInt32();
                            continue;
                        case 88:
                            this.killDelay_ = codedInputStream.readUInt32();
                            continue;
                        case 96:
                            this.killOpen_ = codedInputStream.readBool();
                            continue;
                        case 104:
                            this.killCountdown_ = codedInputStream.readUInt32();
                            continue;
                        case 112:
                            this.killAlertCountdown_ = codedInputStream.readUInt32();
                            continue;
                        case 120:
                            this.eggCountdown_ = codedInputStream.readUInt32();
                            continue;
                        case 128:
                            this.greaterScore_ = codedInputStream.readUInt32();
                            continue;
                        case 138:
                            this.descContents_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 146:
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

    private ChallengeSync(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ChallengeSync getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeSync_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ChallengeSync challengeSync) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(challengeSync);
    }

    public static ChallengeSync parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ChallengeSync) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ChallengeSync parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeSync) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeSync parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ChallengeSync parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ChallengeSync parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ChallengeSync) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ChallengeSync parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeSync) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ChallengeSync parseFrom(InputStream inputStream) throws IOException {
        return (ChallengeSync) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ChallengeSync parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeSync) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeSync parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ChallengeSync parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ChallengeSync parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ChallengeSync parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ChallengeSync> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChallengeSync) {
            ChallengeSync challengeSync = (ChallengeSync) obj;
            return getChallengeInfoList().equals(challengeSync.getChallengeInfoList()) && getStage() == challengeSync.getStage() && getCountdown() == challengeSync.getCountdown() && getFullCountdown() == challengeSync.getFullCountdown() && getEggAlertCountdown() == challengeSync.getEggAlertCountdown() && getEggAlertDelay() == challengeSync.getEggAlertDelay() && getEggDelay() == challengeSync.getEggDelay() && getMaxEggCountdown() == challengeSync.getMaxEggCountdown() && getTargetEggScore() == challengeSync.getTargetEggScore() && getKillAlertDelay() == challengeSync.getKillAlertDelay() && getKillDelay() == challengeSync.getKillDelay() && getKillOpen() == challengeSync.getKillOpen() && getKillCountdown() == challengeSync.getKillCountdown() && getKillAlertCountdown() == challengeSync.getKillAlertCountdown() && getEggCountdown() == challengeSync.getEggCountdown() && getGreaterScore() == challengeSync.getGreaterScore() && getDescContents().equals(challengeSync.getDescContents()) && getDescLink().equals(challengeSync.getDescLink()) && this.unknownFields.equals(challengeSync.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public ChallengeSyncInfo getChallengeInfo(int i) {
        return this.challengeInfo_.get(i);
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getChallengeInfoCount() {
        return this.challengeInfo_.size();
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public List<ChallengeSyncInfo> getChallengeInfoList() {
        return this.challengeInfo_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public ChallengeSyncInfoOrBuilder getChallengeInfoOrBuilder(int i) {
        return this.challengeInfo_.get(i);
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public List<? extends ChallengeSyncInfoOrBuilder> getChallengeInfoOrBuilderList() {
        return this.challengeInfo_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getCountdown() {
        return this.countdown_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ChallengeSync getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public String getDescContents() {
        Object obj = this.descContents_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.descContents_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public ByteString getDescContentsBytes() {
        Object obj = this.descContents_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.descContents_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public String getDescLink() {
        Object obj = this.descLink_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.descLink_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public ByteString getDescLinkBytes() {
        Object obj = this.descLink_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.descLink_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getEggAlertCountdown() {
        return this.eggAlertCountdown_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getEggAlertDelay() {
        return this.eggAlertDelay_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getEggCountdown() {
        return this.eggCountdown_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getEggDelay() {
        return this.eggDelay_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getFullCountdown() {
        return this.fullCountdown_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getGreaterScore() {
        return this.greaterScore_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getKillAlertCountdown() {
        return this.killAlertCountdown_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getKillAlertDelay() {
        return this.killAlertDelay_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getKillCountdown() {
        return this.killCountdown_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getKillDelay() {
        return this.killDelay_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public boolean getKillOpen() {
        return this.killOpen_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getMaxEggCountdown() {
        return this.maxEggCountdown_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ChallengeSync> getParserForType() {
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
        int i4 = this.stage_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int i6 = this.countdown_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeUInt32Size(3, i6);
        }
        int i8 = this.fullCountdown_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(4, i8);
        }
        int i10 = this.eggAlertCountdown_;
        int i11 = i9;
        if (i10 != 0) {
            i11 = i9 + CodedOutputStream.computeUInt32Size(5, i10);
        }
        int i12 = this.eggAlertDelay_;
        int i13 = i11;
        if (i12 != 0) {
            i13 = i11 + CodedOutputStream.computeUInt32Size(6, i12);
        }
        int i14 = this.eggDelay_;
        int i15 = i13;
        if (i14 != 0) {
            i15 = i13 + CodedOutputStream.computeUInt32Size(7, i14);
        }
        int i16 = this.maxEggCountdown_;
        int i17 = i15;
        if (i16 != 0) {
            i17 = i15 + CodedOutputStream.computeUInt32Size(8, i16);
        }
        int i18 = this.targetEggScore_;
        int i19 = i17;
        if (i18 != 0) {
            i19 = i17 + CodedOutputStream.computeUInt32Size(9, i18);
        }
        int i20 = this.killAlertDelay_;
        int i21 = i19;
        if (i20 != 0) {
            i21 = i19 + CodedOutputStream.computeUInt32Size(10, i20);
        }
        int i22 = this.killDelay_;
        int i23 = i21;
        if (i22 != 0) {
            i23 = i21 + CodedOutputStream.computeUInt32Size(11, i22);
        }
        boolean z = this.killOpen_;
        int i24 = i23;
        if (z) {
            i24 = i23 + CodedOutputStream.computeBoolSize(12, z);
        }
        int i25 = this.killCountdown_;
        int i26 = i24;
        if (i25 != 0) {
            i26 = i24 + CodedOutputStream.computeUInt32Size(13, i25);
        }
        int i27 = this.killAlertCountdown_;
        int i28 = i26;
        if (i27 != 0) {
            i28 = i26 + CodedOutputStream.computeUInt32Size(14, i27);
        }
        int i29 = this.eggCountdown_;
        int i30 = i28;
        if (i29 != 0) {
            i30 = i28 + CodedOutputStream.computeUInt32Size(15, i29);
        }
        int i31 = this.greaterScore_;
        int i32 = i30;
        if (i31 != 0) {
            i32 = i30 + CodedOutputStream.computeUInt32Size(16, i31);
        }
        int i33 = i32;
        if (!getDescContentsBytes().isEmpty()) {
            i33 = i32 + GeneratedMessageV3.computeStringSize(17, this.descContents_);
        }
        int i34 = i33;
        if (!getDescLinkBytes().isEmpty()) {
            i34 = i33 + GeneratedMessageV3.computeStringSize(18, this.descLink_);
        }
        int serializedSize = i34 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
    public int getStage() {
        return this.stage_;
    }

    @Override // cn.irisgw.live.ChallengeSyncOrBuilder
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
        int stage = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((i * 37) + 2) * 53) + getStage()) * 37) + 3) * 53) + getCountdown()) * 37) + 4) * 53) + getFullCountdown()) * 37) + 5) * 53) + getEggAlertCountdown()) * 37) + 6) * 53) + getEggAlertDelay()) * 37) + 7) * 53) + getEggDelay()) * 37) + 8) * 53) + getMaxEggCountdown()) * 37) + 9) * 53) + getTargetEggScore()) * 37) + 10) * 53) + getKillAlertDelay()) * 37) + 11) * 53) + getKillDelay()) * 37) + 12) * 53) + Internal.hashBoolean(getKillOpen())) * 37) + 13) * 53) + getKillCountdown()) * 37) + 14) * 53) + getKillAlertCountdown()) * 37) + 15) * 53) + getEggCountdown()) * 37) + 16) * 53) + getGreaterScore()) * 37) + 17) * 53) + getDescContents().hashCode()) * 37) + 18) * 53) + getDescLink().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = stage;
        return stage;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeSync_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeSync.class, Builder.class);
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
        return new ChallengeSync();
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
        int i3 = this.stage_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(2, i3);
        }
        int i4 = this.countdown_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(3, i4);
        }
        int i5 = this.fullCountdown_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(4, i5);
        }
        int i6 = this.eggAlertCountdown_;
        if (i6 != 0) {
            codedOutputStream.writeUInt32(5, i6);
        }
        int i7 = this.eggAlertDelay_;
        if (i7 != 0) {
            codedOutputStream.writeUInt32(6, i7);
        }
        int i8 = this.eggDelay_;
        if (i8 != 0) {
            codedOutputStream.writeUInt32(7, i8);
        }
        int i9 = this.maxEggCountdown_;
        if (i9 != 0) {
            codedOutputStream.writeUInt32(8, i9);
        }
        int i10 = this.targetEggScore_;
        if (i10 != 0) {
            codedOutputStream.writeUInt32(9, i10);
        }
        int i11 = this.killAlertDelay_;
        if (i11 != 0) {
            codedOutputStream.writeUInt32(10, i11);
        }
        int i12 = this.killDelay_;
        if (i12 != 0) {
            codedOutputStream.writeUInt32(11, i12);
        }
        boolean z = this.killOpen_;
        if (z) {
            codedOutputStream.writeBool(12, z);
        }
        int i13 = this.killCountdown_;
        if (i13 != 0) {
            codedOutputStream.writeUInt32(13, i13);
        }
        int i14 = this.killAlertCountdown_;
        if (i14 != 0) {
            codedOutputStream.writeUInt32(14, i14);
        }
        int i15 = this.eggCountdown_;
        if (i15 != 0) {
            codedOutputStream.writeUInt32(15, i15);
        }
        int i16 = this.greaterScore_;
        if (i16 != 0) {
            codedOutputStream.writeUInt32(16, i16);
        }
        if (!getDescContentsBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 17, this.descContents_);
        }
        if (!getDescLinkBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 18, this.descLink_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
