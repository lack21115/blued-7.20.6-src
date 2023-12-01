package com.google.api;

import com.google.api.MetricRule;
import com.google.api.QuotaLimit;
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
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/Quota.class */
public final class Quota extends GeneratedMessageV3 implements QuotaOrBuilder {
    public static final int LIMITS_FIELD_NUMBER = 3;
    public static final int METRIC_RULES_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private List<QuotaLimit> limits_;
    private byte memoizedIsInitialized;
    private List<MetricRule> metricRules_;
    private static final Quota DEFAULT_INSTANCE = new Quota();
    private static final Parser<Quota> PARSER = new AbstractParser<Quota>() { // from class: com.google.api.Quota.1
        @Override // com.google.protobuf.Parser
        public Quota parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Quota(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/Quota$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuotaOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> limitsBuilder_;
        private List<QuotaLimit> limits_;
        private RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> metricRulesBuilder_;
        private List<MetricRule> metricRules_;

        private Builder() {
            this.limits_ = Collections.emptyList();
            this.metricRules_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.limits_ = Collections.emptyList();
            this.metricRules_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureLimitsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.limits_ = new ArrayList(this.limits_);
                this.bitField0_ |= 1;
            }
        }

        private void ensureMetricRulesIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.metricRules_ = new ArrayList(this.metricRules_);
                this.bitField0_ |= 2;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QuotaProto.internal_static_google_api_Quota_descriptor;
        }

        private RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> getLimitsFieldBuilder() {
            if (this.limitsBuilder_ == null) {
                List<QuotaLimit> list = this.limits_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.limitsBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.limits_ = null;
            }
            return this.limitsBuilder_;
        }

        private RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> getMetricRulesFieldBuilder() {
            if (this.metricRulesBuilder_ == null) {
                this.metricRulesBuilder_ = new RepeatedFieldBuilderV3<>(this.metricRules_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.metricRules_ = null;
            }
            return this.metricRulesBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (Quota.alwaysUseFieldBuilders) {
                getLimitsFieldBuilder();
                getMetricRulesFieldBuilder();
            }
        }

        public Builder addAllLimits(Iterable<? extends QuotaLimit> iterable) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureLimitsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.limits_);
            onChanged();
            return this;
        }

        public Builder addAllMetricRules(Iterable<? extends MetricRule> iterable) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureMetricRulesIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.metricRules_);
            onChanged();
            return this;
        }

        public Builder addLimits(int i, QuotaLimit.Builder builder) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureLimitsIsMutable();
            this.limits_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addLimits(int i, QuotaLimit quotaLimit) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, quotaLimit);
                return this;
            } else if (quotaLimit != null) {
                ensureLimitsIsMutable();
                this.limits_.add(i, quotaLimit);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addLimits(QuotaLimit.Builder builder) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureLimitsIsMutable();
            this.limits_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addLimits(QuotaLimit quotaLimit) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(quotaLimit);
                return this;
            } else if (quotaLimit != null) {
                ensureLimitsIsMutable();
                this.limits_.add(quotaLimit);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public QuotaLimit.Builder addLimitsBuilder() {
            return getLimitsFieldBuilder().addBuilder(QuotaLimit.getDefaultInstance());
        }

        public QuotaLimit.Builder addLimitsBuilder(int i) {
            return getLimitsFieldBuilder().addBuilder(i, QuotaLimit.getDefaultInstance());
        }

        public Builder addMetricRules(int i, MetricRule.Builder builder) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureMetricRulesIsMutable();
            this.metricRules_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addMetricRules(int i, MetricRule metricRule) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, metricRule);
                return this;
            } else if (metricRule != null) {
                ensureMetricRulesIsMutable();
                this.metricRules_.add(i, metricRule);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addMetricRules(MetricRule.Builder builder) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureMetricRulesIsMutable();
            this.metricRules_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addMetricRules(MetricRule metricRule) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(metricRule);
                return this;
            } else if (metricRule != null) {
                ensureMetricRulesIsMutable();
                this.metricRules_.add(metricRule);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public MetricRule.Builder addMetricRulesBuilder() {
            return getMetricRulesFieldBuilder().addBuilder(MetricRule.getDefaultInstance());
        }

        public MetricRule.Builder addMetricRulesBuilder(int i) {
            return getMetricRulesFieldBuilder().addBuilder(i, MetricRule.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Quota build() {
            Quota buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Quota buildPartial() {
            Quota quota = new Quota(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.limits_ = Collections.unmodifiableList(this.limits_);
                    this.bitField0_ &= -2;
                }
                quota.limits_ = this.limits_;
            } else {
                quota.limits_ = repeatedFieldBuilderV3.build();
            }
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV32 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.metricRules_ = Collections.unmodifiableList(this.metricRules_);
                    this.bitField0_ &= -3;
                }
                quota.metricRules_ = this.metricRules_;
            } else {
                quota.metricRules_ = repeatedFieldBuilderV32.build();
            }
            onBuilt();
            return quota;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.limits_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV32 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV32 != null) {
                repeatedFieldBuilderV32.clear();
                return this;
            }
            this.metricRules_ = Collections.emptyList();
            this.bitField0_ &= -3;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearLimits() {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.limits_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearMetricRules() {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.metricRules_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Quota getDefaultInstanceForType() {
            return Quota.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return QuotaProto.internal_static_google_api_Quota_descriptor;
        }

        @Override // com.google.api.QuotaOrBuilder
        public QuotaLimit getLimits(int i) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.limits_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public QuotaLimit.Builder getLimitsBuilder(int i) {
            return getLimitsFieldBuilder().getBuilder(i);
        }

        public List<QuotaLimit.Builder> getLimitsBuilderList() {
            return getLimitsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.QuotaOrBuilder
        public int getLimitsCount() {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.limits_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.QuotaOrBuilder
        public List<QuotaLimit> getLimitsList() {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.limits_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.QuotaOrBuilder
        public QuotaLimitOrBuilder getLimitsOrBuilder(int i) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.limits_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.QuotaOrBuilder
        public List<? extends QuotaLimitOrBuilder> getLimitsOrBuilderList() {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.limits_);
        }

        @Override // com.google.api.QuotaOrBuilder
        public MetricRule getMetricRules(int i) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.metricRules_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public MetricRule.Builder getMetricRulesBuilder(int i) {
            return getMetricRulesFieldBuilder().getBuilder(i);
        }

        public List<MetricRule.Builder> getMetricRulesBuilderList() {
            return getMetricRulesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.QuotaOrBuilder
        public int getMetricRulesCount() {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.metricRules_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.QuotaOrBuilder
        public List<MetricRule> getMetricRulesList() {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.metricRules_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.QuotaOrBuilder
        public MetricRuleOrBuilder getMetricRulesOrBuilder(int i) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.metricRules_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.QuotaOrBuilder
        public List<? extends MetricRuleOrBuilder> getMetricRulesOrBuilderList() {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.metricRules_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuotaProto.internal_static_google_api_Quota_fieldAccessorTable.ensureFieldAccessorsInitialized(Quota.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(Quota quota) {
            if (quota == Quota.getDefaultInstance()) {
                return this;
            }
            if (this.limitsBuilder_ == null) {
                if (!quota.limits_.isEmpty()) {
                    if (this.limits_.isEmpty()) {
                        this.limits_ = quota.limits_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureLimitsIsMutable();
                        this.limits_.addAll(quota.limits_);
                    }
                    onChanged();
                }
            } else if (!quota.limits_.isEmpty()) {
                if (this.limitsBuilder_.isEmpty()) {
                    this.limitsBuilder_.dispose();
                    this.limitsBuilder_ = null;
                    this.limits_ = quota.limits_;
                    this.bitField0_ &= -2;
                    this.limitsBuilder_ = Quota.alwaysUseFieldBuilders ? getLimitsFieldBuilder() : null;
                } else {
                    this.limitsBuilder_.addAllMessages(quota.limits_);
                }
            }
            if (this.metricRulesBuilder_ == null) {
                if (!quota.metricRules_.isEmpty()) {
                    if (this.metricRules_.isEmpty()) {
                        this.metricRules_ = quota.metricRules_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureMetricRulesIsMutable();
                        this.metricRules_.addAll(quota.metricRules_);
                    }
                    onChanged();
                }
            } else if (!quota.metricRules_.isEmpty()) {
                if (this.metricRulesBuilder_.isEmpty()) {
                    this.metricRulesBuilder_.dispose();
                    this.metricRulesBuilder_ = null;
                    this.metricRules_ = quota.metricRules_;
                    this.bitField0_ &= -3;
                    RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = null;
                    if (Quota.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getMetricRulesFieldBuilder();
                    }
                    this.metricRulesBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.metricRulesBuilder_.addAllMessages(quota.metricRules_);
                }
            }
            mergeUnknownFields(quota.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.Quota.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.api.Quota.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.api.Quota r0 = (com.google.api.Quota) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.api.Quota$Builder r0 = r0.mergeFrom(r1)
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
                com.google.api.Quota r0 = (com.google.api.Quota) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.api.Quota$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Quota.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Quota$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Quota) {
                return mergeFrom((Quota) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeLimits(int i) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureLimitsIsMutable();
            this.limits_.remove(i);
            onChanged();
            return this;
        }

        public Builder removeMetricRules(int i) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureMetricRulesIsMutable();
            this.metricRules_.remove(i);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setLimits(int i, QuotaLimit.Builder builder) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureLimitsIsMutable();
            this.limits_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setLimits(int i, QuotaLimit quotaLimit) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, quotaLimit);
                return this;
            } else if (quotaLimit != null) {
                ensureLimitsIsMutable();
                this.limits_.set(i, quotaLimit);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setMetricRules(int i, MetricRule.Builder builder) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureMetricRulesIsMutable();
            this.metricRules_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setMetricRules(int i, MetricRule metricRule) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, metricRule);
                return this;
            } else if (metricRule != null) {
                ensureMetricRulesIsMutable();
                this.metricRules_.set(i, metricRule);
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

    private Quota() {
        this.memoizedIsInitialized = (byte) -1;
        this.limits_ = Collections.emptyList();
        this.metricRules_ = Collections.emptyList();
    }

    private Quota(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        if (readTag == 26) {
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.limits_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.limits_.add(codedInputStream.readMessage(QuotaLimit.parser(), extensionRegistryLite));
                            z2 = z4;
                        } else if (readTag == 34) {
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.metricRules_ = new ArrayList();
                                z5 = z2 | true;
                            }
                            this.metricRules_.add(codedInputStream.readMessage(MetricRule.parser(), extensionRegistryLite));
                            z2 = z5;
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
                    this.limits_ = Collections.unmodifiableList(this.limits_);
                }
                if (z3 & true) {
                    this.metricRules_ = Collections.unmodifiableList(this.metricRules_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.limits_ = Collections.unmodifiableList(this.limits_);
        }
        if (z2 & true) {
            this.metricRules_ = Collections.unmodifiableList(this.metricRules_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private Quota(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Quota getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return QuotaProto.internal_static_google_api_Quota_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Quota quota) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(quota);
    }

    public static Quota parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Quota) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Quota parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Quota) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Quota parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Quota parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Quota parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Quota) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Quota parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Quota) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Quota parseFrom(InputStream inputStream) throws IOException {
        return (Quota) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Quota parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Quota) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Quota parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Quota parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Quota parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Quota parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<Quota> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Quota) {
            Quota quota = (Quota) obj;
            return getLimitsList().equals(quota.getLimitsList()) && getMetricRulesList().equals(quota.getMetricRulesList()) && this.unknownFields.equals(quota.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Quota getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.api.QuotaOrBuilder
    public QuotaLimit getLimits(int i) {
        return this.limits_.get(i);
    }

    @Override // com.google.api.QuotaOrBuilder
    public int getLimitsCount() {
        return this.limits_.size();
    }

    @Override // com.google.api.QuotaOrBuilder
    public List<QuotaLimit> getLimitsList() {
        return this.limits_;
    }

    @Override // com.google.api.QuotaOrBuilder
    public QuotaLimitOrBuilder getLimitsOrBuilder(int i) {
        return this.limits_.get(i);
    }

    @Override // com.google.api.QuotaOrBuilder
    public List<? extends QuotaLimitOrBuilder> getLimitsOrBuilderList() {
        return this.limits_;
    }

    @Override // com.google.api.QuotaOrBuilder
    public MetricRule getMetricRules(int i) {
        return this.metricRules_.get(i);
    }

    @Override // com.google.api.QuotaOrBuilder
    public int getMetricRulesCount() {
        return this.metricRules_.size();
    }

    @Override // com.google.api.QuotaOrBuilder
    public List<MetricRule> getMetricRulesList() {
        return this.metricRules_;
    }

    @Override // com.google.api.QuotaOrBuilder
    public MetricRuleOrBuilder getMetricRulesOrBuilder(int i) {
        return this.metricRules_.get(i);
    }

    @Override // com.google.api.QuotaOrBuilder
    public List<? extends MetricRuleOrBuilder> getMetricRulesOrBuilderList() {
        return this.metricRules_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Quota> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i;
        int i2;
        int i3 = this.memoizedSize;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i2 = i5;
            if (i4 >= this.limits_.size()) {
                break;
            }
            i5 += CodedOutputStream.computeMessageSize(3, this.limits_.get(i4));
            i4++;
        }
        for (i = 0; i < this.metricRules_.size(); i++) {
            i2 += CodedOutputStream.computeMessageSize(4, this.metricRules_.get(i));
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
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
        if (getLimitsCount() > 0) {
            i = (((hashCode * 37) + 3) * 53) + getLimitsList().hashCode();
        }
        int i2 = i;
        if (getMetricRulesCount() > 0) {
            i2 = (((i * 37) + 4) * 53) + getMetricRulesList().hashCode();
        }
        int hashCode2 = (i2 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return QuotaProto.internal_static_google_api_Quota_fieldAccessorTable.ensureFieldAccessorsInitialized(Quota.class, Builder.class);
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

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.limits_.size()) {
                break;
            }
            codedOutputStream.writeMessage(3, this.limits_.get(i3));
            i2 = i3 + 1;
        }
        for (i = 0; i < this.metricRules_.size(); i++) {
            codedOutputStream.writeMessage(4, this.metricRules_.get(i));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
