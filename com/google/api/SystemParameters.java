package com.google.api;

import com.google.api.SystemParameterRule;
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

/* loaded from: source-8110460-dex2jar.jar:com/google/api/SystemParameters.class */
public final class SystemParameters extends GeneratedMessageV3 implements SystemParametersOrBuilder {
    private static final SystemParameters DEFAULT_INSTANCE = new SystemParameters();
    private static final Parser<SystemParameters> PARSER = new AbstractParser<SystemParameters>() { // from class: com.google.api.SystemParameters.1
        @Override // com.google.protobuf.Parser
        public SystemParameters parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new SystemParameters(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int RULES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<SystemParameterRule> rules_;

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/SystemParameters$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SystemParametersOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> rulesBuilder_;
        private List<SystemParameterRule> rules_;

        private Builder() {
            this.rules_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.rules_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureRulesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.rules_ = new ArrayList(this.rules_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SystemParameterProto.internal_static_google_api_SystemParameters_descriptor;
        }

        private RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> getRulesFieldBuilder() {
            if (this.rulesBuilder_ == null) {
                List<SystemParameterRule> list = this.rules_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.rulesBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.rules_ = null;
            }
            return this.rulesBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (SystemParameters.alwaysUseFieldBuilders) {
                getRulesFieldBuilder();
            }
        }

        public Builder addAllRules(Iterable<? extends SystemParameterRule> iterable) {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureRulesIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.rules_);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addRules(int i, SystemParameterRule.Builder builder) {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureRulesIsMutable();
            this.rules_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addRules(int i, SystemParameterRule systemParameterRule) {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, systemParameterRule);
                return this;
            } else if (systemParameterRule != null) {
                ensureRulesIsMutable();
                this.rules_.add(i, systemParameterRule);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addRules(SystemParameterRule.Builder builder) {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureRulesIsMutable();
            this.rules_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addRules(SystemParameterRule systemParameterRule) {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(systemParameterRule);
                return this;
            } else if (systemParameterRule != null) {
                ensureRulesIsMutable();
                this.rules_.add(systemParameterRule);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public SystemParameterRule.Builder addRulesBuilder() {
            return getRulesFieldBuilder().addBuilder(SystemParameterRule.getDefaultInstance());
        }

        public SystemParameterRule.Builder addRulesBuilder(int i) {
            return getRulesFieldBuilder().addBuilder(i, SystemParameterRule.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SystemParameters build() {
            SystemParameters buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SystemParameters buildPartial() {
            SystemParameters systemParameters = new SystemParameters(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.rules_ = Collections.unmodifiableList(this.rules_);
                    this.bitField0_ &= -2;
                }
                systemParameters.rules_ = this.rules_;
            } else {
                systemParameters.rules_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return systemParameters;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.rules_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRules() {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.rules_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2030clone() {
            return (Builder) super.mo2030clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SystemParameters getDefaultInstanceForType() {
            return SystemParameters.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return SystemParameterProto.internal_static_google_api_SystemParameters_descriptor;
        }

        @Override // com.google.api.SystemParametersOrBuilder
        public SystemParameterRule getRules(int i) {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.rules_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public SystemParameterRule.Builder getRulesBuilder(int i) {
            return getRulesFieldBuilder().getBuilder(i);
        }

        public List<SystemParameterRule.Builder> getRulesBuilderList() {
            return getRulesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.SystemParametersOrBuilder
        public int getRulesCount() {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.rules_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.SystemParametersOrBuilder
        public List<SystemParameterRule> getRulesList() {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.rules_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.SystemParametersOrBuilder
        public SystemParameterRuleOrBuilder getRulesOrBuilder(int i) {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.rules_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.SystemParametersOrBuilder
        public List<? extends SystemParameterRuleOrBuilder> getRulesOrBuilderList() {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.rules_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SystemParameterProto.internal_static_google_api_SystemParameters_fieldAccessorTable.ensureFieldAccessorsInitialized(SystemParameters.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(SystemParameters systemParameters) {
            if (systemParameters == SystemParameters.getDefaultInstance()) {
                return this;
            }
            if (this.rulesBuilder_ == null) {
                if (!systemParameters.rules_.isEmpty()) {
                    if (this.rules_.isEmpty()) {
                        this.rules_ = systemParameters.rules_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRulesIsMutable();
                        this.rules_.addAll(systemParameters.rules_);
                    }
                    onChanged();
                }
            } else if (!systemParameters.rules_.isEmpty()) {
                if (this.rulesBuilder_.isEmpty()) {
                    this.rulesBuilder_.dispose();
                    RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = null;
                    this.rulesBuilder_ = null;
                    this.rules_ = systemParameters.rules_;
                    this.bitField0_ &= -2;
                    if (SystemParameters.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getRulesFieldBuilder();
                    }
                    this.rulesBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.rulesBuilder_.addAllMessages(systemParameters.rules_);
                }
            }
            mergeUnknownFields(systemParameters.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.SystemParameters.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.api.SystemParameters.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.api.SystemParameters r0 = (com.google.api.SystemParameters) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.api.SystemParameters$Builder r0 = r0.mergeFrom(r1)
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
                com.google.api.SystemParameters r0 = (com.google.api.SystemParameters) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.api.SystemParameters$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.SystemParameters.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.SystemParameters$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof SystemParameters) {
                return mergeFrom((SystemParameters) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeRules(int i) {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureRulesIsMutable();
            this.rules_.remove(i);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setRules(int i, SystemParameterRule.Builder builder) {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureRulesIsMutable();
            this.rules_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setRules(int i, SystemParameterRule systemParameterRule) {
            RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, systemParameterRule);
                return this;
            } else if (systemParameterRule != null) {
                ensureRulesIsMutable();
                this.rules_.set(i, systemParameterRule);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private SystemParameters() {
        this.memoizedIsInitialized = (byte) -1;
        this.rules_ = Collections.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SystemParameters(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.rules_ = new ArrayList();
                                    z4 = z2 | true;
                                }
                                this.rules_.add(codedInputStream.readMessage(SystemParameterRule.parser(), extensionRegistryLite));
                                z2 = z4;
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
                    this.rules_ = Collections.unmodifiableList(this.rules_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.rules_ = Collections.unmodifiableList(this.rules_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private SystemParameters(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static SystemParameters getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return SystemParameterProto.internal_static_google_api_SystemParameters_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(SystemParameters systemParameters) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(systemParameters);
    }

    public static SystemParameters parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SystemParameters) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static SystemParameters parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SystemParameters) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static SystemParameters parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static SystemParameters parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static SystemParameters parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SystemParameters) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static SystemParameters parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SystemParameters) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static SystemParameters parseFrom(InputStream inputStream) throws IOException {
        return (SystemParameters) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static SystemParameters parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SystemParameters) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static SystemParameters parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static SystemParameters parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static SystemParameters parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static SystemParameters parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<SystemParameters> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SystemParameters) {
            SystemParameters systemParameters = (SystemParameters) obj;
            return getRulesList().equals(systemParameters.getRulesList()) && this.unknownFields.equals(systemParameters.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public SystemParameters getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<SystemParameters> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.SystemParametersOrBuilder
    public SystemParameterRule getRules(int i) {
        return this.rules_.get(i);
    }

    @Override // com.google.api.SystemParametersOrBuilder
    public int getRulesCount() {
        return this.rules_.size();
    }

    @Override // com.google.api.SystemParametersOrBuilder
    public List<SystemParameterRule> getRulesList() {
        return this.rules_;
    }

    @Override // com.google.api.SystemParametersOrBuilder
    public SystemParameterRuleOrBuilder getRulesOrBuilder(int i) {
        return this.rules_.get(i);
    }

    @Override // com.google.api.SystemParametersOrBuilder
    public List<? extends SystemParameterRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.rules_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.rules_.get(i3));
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
        if (getRulesCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getRulesList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return SystemParameterProto.internal_static_google_api_SystemParameters_fieldAccessorTable.ensureFieldAccessorsInitialized(SystemParameters.class, Builder.class);
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
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.rules_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(1, this.rules_.get(i2));
                i = i2 + 1;
            }
        }
    }
}
