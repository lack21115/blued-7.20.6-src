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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CustomRank.class */
public final class CustomRank extends GeneratedMessageV3 implements CustomRankOrBuilder {
    public static final int END_TIME_FIELD_NUMBER = 2;
    public static final int RANK_INFO_FIELD_NUMBER = 3;
    public static final int START_TIME_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int endTime_;
    private byte memoizedIsInitialized;
    private List<RankInfo> rankInfo_;
    private int startTime_;
    private static final CustomRank DEFAULT_INSTANCE = new CustomRank();
    private static final Parser<CustomRank> PARSER = new AbstractParser<CustomRank>() { // from class: cn.irisgw.live.CustomRank.1
        /* renamed from: parsePartialFrom */
        public CustomRank m1910parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new CustomRank(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CustomRank$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CustomRankOrBuilder {
        private int bitField0_;
        private int endTime_;
        private RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> rankInfoBuilder_;
        private List<RankInfo> rankInfo_;
        private int startTime_;

        private Builder() {
            this.rankInfo_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.rankInfo_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureRankInfoIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.rankInfo_ = new ArrayList(this.rankInfo_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_CustomRank_descriptor;
        }

        private RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> getRankInfoFieldBuilder() {
            if (this.rankInfoBuilder_ == null) {
                List<RankInfo> list = this.rankInfo_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.rankInfoBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.rankInfo_ = null;
            }
            return this.rankInfoBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (CustomRank.alwaysUseFieldBuilders) {
                getRankInfoFieldBuilder();
            }
        }

        public Builder addAllRankInfo(Iterable<? extends RankInfo> iterable) {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureRankInfoIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.rankInfo_);
            onChanged();
            return this;
        }

        public Builder addRankInfo(int i, RankInfo.Builder builder) {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m1961build());
                return this;
            }
            ensureRankInfoIsMutable();
            this.rankInfo_.add(i, builder.m1961build());
            onChanged();
            return this;
        }

        public Builder addRankInfo(int i, RankInfo rankInfo) {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, rankInfo);
                return this;
            } else if (rankInfo != null) {
                ensureRankInfoIsMutable();
                this.rankInfo_.add(i, rankInfo);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addRankInfo(RankInfo.Builder builder) {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m1961build());
                return this;
            }
            ensureRankInfoIsMutable();
            this.rankInfo_.add(builder.m1961build());
            onChanged();
            return this;
        }

        public Builder addRankInfo(RankInfo rankInfo) {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(rankInfo);
                return this;
            } else if (rankInfo != null) {
                ensureRankInfoIsMutable();
                this.rankInfo_.add(rankInfo);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public RankInfo.Builder addRankInfoBuilder() {
            return getRankInfoFieldBuilder().addBuilder(RankInfo.getDefaultInstance());
        }

        public RankInfo.Builder addRankInfoBuilder(int i) {
            return getRankInfoFieldBuilder().addBuilder(i, RankInfo.getDefaultInstance());
        }

        /* renamed from: addRepeatedField */
        public Builder m1912addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public CustomRank m1914build() {
            CustomRank m1916buildPartial = m1916buildPartial();
            if (m1916buildPartial.isInitialized()) {
                return m1916buildPartial;
            }
            throw newUninitializedMessageException(m1916buildPartial);
        }

        /* renamed from: buildPartial */
        public CustomRank m1916buildPartial() {
            CustomRank customRank = new CustomRank(this);
            customRank.startTime_ = this.startTime_;
            customRank.endTime_ = this.endTime_;
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.rankInfo_ = Collections.unmodifiableList(this.rankInfo_);
                    this.bitField0_ &= -2;
                }
                customRank.rankInfo_ = this.rankInfo_;
            } else {
                customRank.rankInfo_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return customRank;
        }

        /* renamed from: clear */
        public Builder m1920clear() {
            super.clear();
            this.startTime_ = 0;
            this.endTime_ = 0;
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.rankInfo_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        public Builder clearEndTime() {
            this.endTime_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m1922clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m1925clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRankInfo() {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.rankInfo_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearStartTime() {
            this.startTime_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m1931clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public CustomRank m1933getDefaultInstanceForType() {
            return CustomRank.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_CustomRank_descriptor;
        }

        @Override // cn.irisgw.live.CustomRankOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // cn.irisgw.live.CustomRankOrBuilder
        public RankInfo getRankInfo(int i) {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.rankInfo_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public RankInfo.Builder getRankInfoBuilder(int i) {
            return getRankInfoFieldBuilder().getBuilder(i);
        }

        public List<RankInfo.Builder> getRankInfoBuilderList() {
            return getRankInfoFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.CustomRankOrBuilder
        public int getRankInfoCount() {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.rankInfo_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.CustomRankOrBuilder
        public List<RankInfo> getRankInfoList() {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.rankInfo_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.CustomRankOrBuilder
        public RankInfoOrBuilder getRankInfoOrBuilder(int i) {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.rankInfo_.get(i) : (RankInfoOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.CustomRankOrBuilder
        public List<? extends RankInfoOrBuilder> getRankInfoOrBuilderList() {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.rankInfo_);
        }

        @Override // cn.irisgw.live.CustomRankOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_CustomRank_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomRank.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(CustomRank customRank) {
            if (customRank == CustomRank.getDefaultInstance()) {
                return this;
            }
            if (customRank.getStartTime() != 0) {
                setStartTime(customRank.getStartTime());
            }
            if (customRank.getEndTime() != 0) {
                setEndTime(customRank.getEndTime());
            }
            if (this.rankInfoBuilder_ == null) {
                if (!customRank.rankInfo_.isEmpty()) {
                    if (this.rankInfo_.isEmpty()) {
                        this.rankInfo_ = customRank.rankInfo_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRankInfoIsMutable();
                        this.rankInfo_.addAll(customRank.rankInfo_);
                    }
                    onChanged();
                }
            } else if (!customRank.rankInfo_.isEmpty()) {
                if (this.rankInfoBuilder_.isEmpty()) {
                    this.rankInfoBuilder_.dispose();
                    RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = null;
                    this.rankInfoBuilder_ = null;
                    this.rankInfo_ = customRank.rankInfo_;
                    this.bitField0_ &= -2;
                    if (CustomRank.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getRankInfoFieldBuilder();
                    }
                    this.rankInfoBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.rankInfoBuilder_.addAllMessages(customRank.rankInfo_);
                }
            }
            m1942mergeUnknownFields(customRank.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.CustomRank.Builder m1939mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.CustomRank.access$2100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.CustomRank r0 = (cn.irisgw.live.CustomRank) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.CustomRank$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.CustomRank r0 = (cn.irisgw.live.CustomRank) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.CustomRank$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.CustomRank.Builder.m1939mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.CustomRank$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m1938mergeFrom(Message message) {
            if (message instanceof CustomRank) {
                return mergeFrom((CustomRank) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m1942mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeRankInfo(int i) {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureRankInfoIsMutable();
            this.rankInfo_.remove(i);
            onChanged();
            return this;
        }

        public Builder setEndTime(int i) {
            this.endTime_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m1944setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setRankInfo(int i, RankInfo.Builder builder) {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m1961build());
                return this;
            }
            ensureRankInfoIsMutable();
            this.rankInfo_.set(i, builder.m1961build());
            onChanged();
            return this;
        }

        public Builder setRankInfo(int i, RankInfo rankInfo) {
            RepeatedFieldBuilderV3<RankInfo, RankInfo.Builder, RankInfoOrBuilder> repeatedFieldBuilderV3 = this.rankInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, rankInfo);
                return this;
            } else if (rankInfo != null) {
                ensureRankInfoIsMutable();
                this.rankInfo_.set(i, rankInfo);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        /* renamed from: setRepeatedField */
        public Builder m1946setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setStartTime(int i) {
            this.startTime_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m1948setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CustomRank$RankInfo.class */
    public static final class RankInfo extends GeneratedMessageV3 implements RankInfoOrBuilder {
        public static final int IMAGE_FIELD_NUMBER = 2;
        public static final int SCORE_FIELD_NUMBER = 3;
        public static final int TITLE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object image_;
        private byte memoizedIsInitialized;
        private int score_;
        private volatile Object title_;
        private static final RankInfo DEFAULT_INSTANCE = new RankInfo();
        private static final Parser<RankInfo> PARSER = new AbstractParser<RankInfo>() { // from class: cn.irisgw.live.CustomRank.RankInfo.1
            /* renamed from: parsePartialFrom */
            public RankInfo m1957parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new RankInfo(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CustomRank$RankInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RankInfoOrBuilder {
            private Object image_;
            private int score_;
            private Object title_;

            private Builder() {
                this.title_ = "";
                this.image_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.title_ = "";
                this.image_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_CustomRank_RankInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = RankInfo.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m1959addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public RankInfo m1961build() {
                RankInfo m1963buildPartial = m1963buildPartial();
                if (m1963buildPartial.isInitialized()) {
                    return m1963buildPartial;
                }
                throw newUninitializedMessageException(m1963buildPartial);
            }

            /* renamed from: buildPartial */
            public RankInfo m1963buildPartial() {
                RankInfo rankInfo = new RankInfo(this);
                rankInfo.title_ = this.title_;
                rankInfo.image_ = this.image_;
                rankInfo.score_ = this.score_;
                onBuilt();
                return rankInfo;
            }

            /* renamed from: clear */
            public Builder m1967clear() {
                super.clear();
                this.title_ = "";
                this.image_ = "";
                this.score_ = 0;
                return this;
            }

            /* renamed from: clearField */
            public Builder m1969clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearImage() {
                this.image_ = RankInfo.getDefaultInstance().getImage();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m1972clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearScore() {
                this.score_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTitle() {
                this.title_ = RankInfo.getDefaultInstance().getTitle();
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m1978clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public RankInfo m1980getDefaultInstanceForType() {
                return RankInfo.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_CustomRank_RankInfo_descriptor;
            }

            @Override // cn.irisgw.live.CustomRank.RankInfoOrBuilder
            public String getImage() {
                Object obj = this.image_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.image_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.CustomRank.RankInfoOrBuilder
            public ByteString getImageBytes() {
                Object obj = this.image_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.image_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.CustomRank.RankInfoOrBuilder
            public int getScore() {
                return this.score_;
            }

            @Override // cn.irisgw.live.CustomRank.RankInfoOrBuilder
            public String getTitle() {
                Object obj = this.title_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.title_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.CustomRank.RankInfoOrBuilder
            public ByteString getTitleBytes() {
                Object obj = this.title_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.title_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_CustomRank_RankInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RankInfo.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(RankInfo rankInfo) {
                if (rankInfo == RankInfo.getDefaultInstance()) {
                    return this;
                }
                if (!rankInfo.getTitle().isEmpty()) {
                    this.title_ = rankInfo.title_;
                    onChanged();
                }
                if (!rankInfo.getImage().isEmpty()) {
                    this.image_ = rankInfo.image_;
                    onChanged();
                }
                if (rankInfo.getScore() != 0) {
                    setScore(rankInfo.getScore());
                }
                m1989mergeUnknownFields(rankInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.CustomRank.RankInfo.Builder m1986mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.CustomRank.RankInfo.access$800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.CustomRank$RankInfo r0 = (cn.irisgw.live.CustomRank.RankInfo) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.CustomRank$RankInfo$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.CustomRank$RankInfo r0 = (cn.irisgw.live.CustomRank.RankInfo) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.CustomRank$RankInfo$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.CustomRank.RankInfo.Builder.m1986mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.CustomRank$RankInfo$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m1985mergeFrom(Message message) {
                if (message instanceof RankInfo) {
                    return mergeFrom((RankInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m1989mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            /* renamed from: setField */
            public Builder m1991setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setImage(String str) {
                if (str != null) {
                    this.image_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setImageBytes(ByteString byteString) {
                if (byteString != null) {
                    RankInfo.checkByteStringIsUtf8(byteString);
                    this.image_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setRepeatedField */
            public Builder m1993setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setScore(int i) {
                this.score_ = i;
                onChanged();
                return this;
            }

            public Builder setTitle(String str) {
                if (str != null) {
                    this.title_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTitleBytes(ByteString byteString) {
                if (byteString != null) {
                    RankInfo.checkByteStringIsUtf8(byteString);
                    this.title_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setUnknownFields */
            public final Builder m1995setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private RankInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.title_ = "";
            this.image_ = "";
        }

        private RankInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.title_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.image_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 24) {
                                    this.score_ = codedInputStream.readUInt32();
                                } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
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

        private RankInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static RankInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_CustomRank_RankInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m1956toBuilder();
        }

        public static Builder newBuilder(RankInfo rankInfo) {
            return DEFAULT_INSTANCE.m1956toBuilder().mergeFrom(rankInfo);
        }

        public static RankInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static RankInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static RankInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (RankInfo) PARSER.parseFrom(byteString);
        }

        public static RankInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RankInfo) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static RankInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static RankInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static RankInfo parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static RankInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static RankInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (RankInfo) PARSER.parseFrom(byteBuffer);
        }

        public static RankInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RankInfo) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static RankInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (RankInfo) PARSER.parseFrom(bArr);
        }

        public static RankInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RankInfo) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<RankInfo> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof RankInfo) {
                RankInfo rankInfo = (RankInfo) obj;
                return getTitle().equals(rankInfo.getTitle()) && getImage().equals(rankInfo.getImage()) && getScore() == rankInfo.getScore() && this.unknownFields.equals(rankInfo.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public RankInfo m1951getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.CustomRank.RankInfoOrBuilder
        public String getImage() {
            Object obj = this.image_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.image_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.CustomRank.RankInfoOrBuilder
        public ByteString getImageBytes() {
            Object obj = this.image_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.image_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<RankInfo> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.CustomRank.RankInfoOrBuilder
        public int getScore() {
            return this.score_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getTitleBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.title_);
            }
            int i3 = i2;
            if (!getImageBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.image_);
            }
            int i4 = this.score_;
            int i5 = i3;
            if (i4 != 0) {
                i5 = i3 + CodedOutputStream.computeUInt32Size(3, i4);
            }
            int serializedSize = i5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.CustomRank.RankInfoOrBuilder
        public String getTitle() {
            Object obj = this.title_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.title_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.CustomRank.RankInfoOrBuilder
        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getTitle().hashCode()) * 37) + 2) * 53) + getImage().hashCode()) * 37) + 3) * 53) + getScore()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_CustomRank_RankInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RankInfo.class, Builder.class);
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
        public Builder m1954newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m1953newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new RankInfo();
        }

        /* renamed from: toBuilder */
        public Builder m1956toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getTitleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.title_);
            }
            if (!getImageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.image_);
            }
            int i = this.score_;
            if (i != 0) {
                codedOutputStream.writeUInt32(3, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CustomRank$RankInfoOrBuilder.class */
    public interface RankInfoOrBuilder extends MessageOrBuilder {
        String getImage();

        ByteString getImageBytes();

        int getScore();

        String getTitle();

        ByteString getTitleBytes();
    }

    private CustomRank() {
        this.memoizedIsInitialized = (byte) -1;
        this.rankInfo_ = Collections.emptyList();
    }

    private CustomRank(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.startTime_ = codedInputStream.readUInt32();
                        } else if (readTag == 16) {
                            this.endTime_ = codedInputStream.readUInt32();
                        } else if (readTag == 26) {
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.rankInfo_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.rankInfo_.add((RankInfo) codedInputStream.readMessage(RankInfo.parser(), extensionRegistryLite));
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
                    this.rankInfo_ = Collections.unmodifiableList(this.rankInfo_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.rankInfo_ = Collections.unmodifiableList(this.rankInfo_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private CustomRank(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static CustomRank getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_CustomRank_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m1909toBuilder();
    }

    public static Builder newBuilder(CustomRank customRank) {
        return DEFAULT_INSTANCE.m1909toBuilder().mergeFrom(customRank);
    }

    public static CustomRank parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CustomRank parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CustomRank parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CustomRank) PARSER.parseFrom(byteString);
    }

    public static CustomRank parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CustomRank) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CustomRank parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static CustomRank parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static CustomRank parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static CustomRank parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CustomRank parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CustomRank) PARSER.parseFrom(byteBuffer);
    }

    public static CustomRank parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CustomRank) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CustomRank parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CustomRank) PARSER.parseFrom(bArr);
    }

    public static CustomRank parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CustomRank) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<CustomRank> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CustomRank) {
            CustomRank customRank = (CustomRank) obj;
            return getStartTime() == customRank.getStartTime() && getEndTime() == customRank.getEndTime() && getRankInfoList().equals(customRank.getRankInfoList()) && this.unknownFields.equals(customRank.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public CustomRank m1904getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.CustomRankOrBuilder
    public int getEndTime() {
        return this.endTime_;
    }

    public Parser<CustomRank> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.CustomRankOrBuilder
    public RankInfo getRankInfo(int i) {
        return this.rankInfo_.get(i);
    }

    @Override // cn.irisgw.live.CustomRankOrBuilder
    public int getRankInfoCount() {
        return this.rankInfo_.size();
    }

    @Override // cn.irisgw.live.CustomRankOrBuilder
    public List<RankInfo> getRankInfoList() {
        return this.rankInfo_;
    }

    @Override // cn.irisgw.live.CustomRankOrBuilder
    public RankInfoOrBuilder getRankInfoOrBuilder(int i) {
        return this.rankInfo_.get(i);
    }

    @Override // cn.irisgw.live.CustomRankOrBuilder
    public List<? extends RankInfoOrBuilder> getRankInfoOrBuilderList() {
        return this.rankInfo_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.startTime_;
        int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
        int i3 = this.endTime_;
        int i4 = computeUInt32Size;
        int i5 = 0;
        if (i3 != 0) {
            i4 = computeUInt32Size + CodedOutputStream.computeUInt32Size(2, i3);
            i5 = 0;
        }
        while (i5 < this.rankInfo_.size()) {
            i4 += CodedOutputStream.computeMessageSize(3, this.rankInfo_.get(i5));
            i5++;
        }
        int serializedSize = i4 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.CustomRankOrBuilder
    public int getStartTime() {
        return this.startTime_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getStartTime()) * 37) + 2) * 53) + getEndTime();
        int i = hashCode;
        if (getRankInfoCount() > 0) {
            i = (((hashCode * 37) + 3) * 53) + getRankInfoList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_CustomRank_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomRank.class, Builder.class);
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
    public Builder m1907newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m1906newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new CustomRank();
    }

    /* renamed from: toBuilder */
    public Builder m1909toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.startTime_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.endTime_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.rankInfo_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(3, this.rankInfo_.get(i4));
                i3 = i4 + 1;
            }
        }
    }
}
