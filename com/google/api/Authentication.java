package com.google.api;

import com.google.api.AuthProvider;
import com.google.api.AuthenticationRule;
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

/* loaded from: source-8110460-dex2jar.jar:com/google/api/Authentication.class */
public final class Authentication extends GeneratedMessageV3 implements AuthenticationOrBuilder {
    private static final Authentication DEFAULT_INSTANCE = new Authentication();
    private static final Parser<Authentication> PARSER = new AbstractParser<Authentication>() { // from class: com.google.api.Authentication.1
        @Override // com.google.protobuf.Parser
        public Authentication parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Authentication(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int PROVIDERS_FIELD_NUMBER = 4;
    public static final int RULES_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<AuthProvider> providers_;
    private List<AuthenticationRule> rules_;

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/Authentication$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuthenticationOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> providersBuilder_;
        private List<AuthProvider> providers_;
        private RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> rulesBuilder_;
        private List<AuthenticationRule> rules_;

        private Builder() {
            this.rules_ = Collections.emptyList();
            this.providers_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.rules_ = Collections.emptyList();
            this.providers_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureProvidersIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.providers_ = new ArrayList(this.providers_);
                this.bitField0_ |= 2;
            }
        }

        private void ensureRulesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.rules_ = new ArrayList(this.rules_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AuthProto.internal_static_google_api_Authentication_descriptor;
        }

        private RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> getProvidersFieldBuilder() {
            if (this.providersBuilder_ == null) {
                this.providersBuilder_ = new RepeatedFieldBuilderV3<>(this.providers_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.providers_ = null;
            }
            return this.providersBuilder_;
        }

        private RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> getRulesFieldBuilder() {
            if (this.rulesBuilder_ == null) {
                List<AuthenticationRule> list = this.rules_;
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
            if (Authentication.alwaysUseFieldBuilders) {
                getRulesFieldBuilder();
                getProvidersFieldBuilder();
            }
        }

        public Builder addAllProviders(Iterable<? extends AuthProvider> iterable) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureProvidersIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.providers_);
            onChanged();
            return this;
        }

        public Builder addAllRules(Iterable<? extends AuthenticationRule> iterable) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureRulesIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.rules_);
            onChanged();
            return this;
        }

        public Builder addProviders(int i, AuthProvider.Builder builder) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureProvidersIsMutable();
            this.providers_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addProviders(int i, AuthProvider authProvider) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, authProvider);
                return this;
            } else if (authProvider != null) {
                ensureProvidersIsMutable();
                this.providers_.add(i, authProvider);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addProviders(AuthProvider.Builder builder) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureProvidersIsMutable();
            this.providers_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addProviders(AuthProvider authProvider) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(authProvider);
                return this;
            } else if (authProvider != null) {
                ensureProvidersIsMutable();
                this.providers_.add(authProvider);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public AuthProvider.Builder addProvidersBuilder() {
            return getProvidersFieldBuilder().addBuilder(AuthProvider.getDefaultInstance());
        }

        public AuthProvider.Builder addProvidersBuilder(int i) {
            return getProvidersFieldBuilder().addBuilder(i, AuthProvider.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addRules(int i, AuthenticationRule.Builder builder) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureRulesIsMutable();
            this.rules_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addRules(int i, AuthenticationRule authenticationRule) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, authenticationRule);
                return this;
            } else if (authenticationRule != null) {
                ensureRulesIsMutable();
                this.rules_.add(i, authenticationRule);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addRules(AuthenticationRule.Builder builder) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureRulesIsMutable();
            this.rules_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addRules(AuthenticationRule authenticationRule) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(authenticationRule);
                return this;
            } else if (authenticationRule != null) {
                ensureRulesIsMutable();
                this.rules_.add(authenticationRule);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public AuthenticationRule.Builder addRulesBuilder() {
            return getRulesFieldBuilder().addBuilder(AuthenticationRule.getDefaultInstance());
        }

        public AuthenticationRule.Builder addRulesBuilder(int i) {
            return getRulesFieldBuilder().addBuilder(i, AuthenticationRule.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Authentication build() {
            Authentication buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Authentication buildPartial() {
            Authentication authentication = new Authentication(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.rules_ = Collections.unmodifiableList(this.rules_);
                    this.bitField0_ &= -2;
                }
                authentication.rules_ = this.rules_;
            } else {
                authentication.rules_ = repeatedFieldBuilderV3.build();
            }
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV32 = this.providersBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.providers_ = Collections.unmodifiableList(this.providers_);
                    this.bitField0_ &= -3;
                }
                authentication.providers_ = this.providers_;
            } else {
                authentication.providers_ = repeatedFieldBuilderV32.build();
            }
            onBuilt();
            return authentication;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.rules_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV32 = this.providersBuilder_;
            if (repeatedFieldBuilderV32 != null) {
                repeatedFieldBuilderV32.clear();
                return this;
            }
            this.providers_ = Collections.emptyList();
            this.bitField0_ &= -3;
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

        public Builder clearProviders() {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.providers_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearRules() {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
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
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Authentication getDefaultInstanceForType() {
            return Authentication.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return AuthProto.internal_static_google_api_Authentication_descriptor;
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public AuthProvider getProviders(int i) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.providers_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public AuthProvider.Builder getProvidersBuilder(int i) {
            return getProvidersFieldBuilder().getBuilder(i);
        }

        public List<AuthProvider.Builder> getProvidersBuilderList() {
            return getProvidersFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public int getProvidersCount() {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.providers_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public List<AuthProvider> getProvidersList() {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.providers_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public AuthProviderOrBuilder getProvidersOrBuilder(int i) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.providers_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public List<? extends AuthProviderOrBuilder> getProvidersOrBuilderList() {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.providers_);
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public AuthenticationRule getRules(int i) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.rules_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public AuthenticationRule.Builder getRulesBuilder(int i) {
            return getRulesFieldBuilder().getBuilder(i);
        }

        public List<AuthenticationRule.Builder> getRulesBuilderList() {
            return getRulesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public int getRulesCount() {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.rules_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public List<AuthenticationRule> getRulesList() {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.rules_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public AuthenticationRuleOrBuilder getRulesOrBuilder(int i) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.rules_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public List<? extends AuthenticationRuleOrBuilder> getRulesOrBuilderList() {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.rules_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuthProto.internal_static_google_api_Authentication_fieldAccessorTable.ensureFieldAccessorsInitialized(Authentication.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(Authentication authentication) {
            if (authentication == Authentication.getDefaultInstance()) {
                return this;
            }
            if (this.rulesBuilder_ == null) {
                if (!authentication.rules_.isEmpty()) {
                    if (this.rules_.isEmpty()) {
                        this.rules_ = authentication.rules_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRulesIsMutable();
                        this.rules_.addAll(authentication.rules_);
                    }
                    onChanged();
                }
            } else if (!authentication.rules_.isEmpty()) {
                if (this.rulesBuilder_.isEmpty()) {
                    this.rulesBuilder_.dispose();
                    this.rulesBuilder_ = null;
                    this.rules_ = authentication.rules_;
                    this.bitField0_ &= -2;
                    this.rulesBuilder_ = Authentication.alwaysUseFieldBuilders ? getRulesFieldBuilder() : null;
                } else {
                    this.rulesBuilder_.addAllMessages(authentication.rules_);
                }
            }
            if (this.providersBuilder_ == null) {
                if (!authentication.providers_.isEmpty()) {
                    if (this.providers_.isEmpty()) {
                        this.providers_ = authentication.providers_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureProvidersIsMutable();
                        this.providers_.addAll(authentication.providers_);
                    }
                    onChanged();
                }
            } else if (!authentication.providers_.isEmpty()) {
                if (this.providersBuilder_.isEmpty()) {
                    this.providersBuilder_.dispose();
                    this.providersBuilder_ = null;
                    this.providers_ = authentication.providers_;
                    this.bitField0_ &= -3;
                    RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = null;
                    if (Authentication.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getProvidersFieldBuilder();
                    }
                    this.providersBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.providersBuilder_.addAllMessages(authentication.providers_);
                }
            }
            mergeUnknownFields(authentication.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.Authentication.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.api.Authentication.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.api.Authentication r0 = (com.google.api.Authentication) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.api.Authentication$Builder r0 = r0.mergeFrom(r1)
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
                com.google.api.Authentication r0 = (com.google.api.Authentication) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.api.Authentication$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Authentication.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Authentication$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Authentication) {
                return mergeFrom((Authentication) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeProviders(int i) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureProvidersIsMutable();
            this.providers_.remove(i);
            onChanged();
            return this;
        }

        public Builder removeRules(int i) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
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

        public Builder setProviders(int i, AuthProvider.Builder builder) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureProvidersIsMutable();
            this.providers_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setProviders(int i, AuthProvider authProvider) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, authProvider);
                return this;
            } else if (authProvider != null) {
                ensureProvidersIsMutable();
                this.providers_.set(i, authProvider);
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

        public Builder setRules(int i, AuthenticationRule.Builder builder) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureRulesIsMutable();
            this.rules_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setRules(int i, AuthenticationRule authenticationRule) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, authenticationRule);
                return this;
            } else if (authenticationRule != null) {
                ensureRulesIsMutable();
                this.rules_.set(i, authenticationRule);
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

    private Authentication() {
        this.memoizedIsInitialized = (byte) -1;
        this.rules_ = Collections.emptyList();
        this.providers_ = Collections.emptyList();
    }

    private Authentication(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.rules_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.rules_.add(codedInputStream.readMessage(AuthenticationRule.parser(), extensionRegistryLite));
                            z2 = z4;
                        } else if (readTag == 34) {
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.providers_ = new ArrayList();
                                z5 = z2 | true;
                            }
                            this.providers_.add(codedInputStream.readMessage(AuthProvider.parser(), extensionRegistryLite));
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
                    this.rules_ = Collections.unmodifiableList(this.rules_);
                }
                if (z3 & true) {
                    this.providers_ = Collections.unmodifiableList(this.providers_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.rules_ = Collections.unmodifiableList(this.rules_);
        }
        if (z2 & true) {
            this.providers_ = Collections.unmodifiableList(this.providers_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private Authentication(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Authentication getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return AuthProto.internal_static_google_api_Authentication_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Authentication authentication) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(authentication);
    }

    public static Authentication parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Authentication) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Authentication parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Authentication) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Authentication parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Authentication parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Authentication parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Authentication) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Authentication parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Authentication) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Authentication parseFrom(InputStream inputStream) throws IOException {
        return (Authentication) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Authentication parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Authentication) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Authentication parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Authentication parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Authentication parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Authentication parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<Authentication> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Authentication) {
            Authentication authentication = (Authentication) obj;
            return getRulesList().equals(authentication.getRulesList()) && getProvidersList().equals(authentication.getProvidersList()) && this.unknownFields.equals(authentication.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Authentication getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Authentication> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public AuthProvider getProviders(int i) {
        return this.providers_.get(i);
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public int getProvidersCount() {
        return this.providers_.size();
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public List<AuthProvider> getProvidersList() {
        return this.providers_;
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public AuthProviderOrBuilder getProvidersOrBuilder(int i) {
        return this.providers_.get(i);
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public List<? extends AuthProviderOrBuilder> getProvidersOrBuilderList() {
        return this.providers_;
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public AuthenticationRule getRules(int i) {
        return this.rules_.get(i);
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public int getRulesCount() {
        return this.rules_.size();
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public List<AuthenticationRule> getRulesList() {
        return this.rules_;
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public AuthenticationRuleOrBuilder getRulesOrBuilder(int i) {
        return this.rules_.get(i);
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public List<? extends AuthenticationRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
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
            if (i4 >= this.rules_.size()) {
                break;
            }
            i5 += CodedOutputStream.computeMessageSize(3, this.rules_.get(i4));
            i4++;
        }
        for (i = 0; i < this.providers_.size(); i++) {
            i2 += CodedOutputStream.computeMessageSize(4, this.providers_.get(i));
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
            i = (((hashCode * 37) + 3) * 53) + getRulesList().hashCode();
        }
        int i2 = i;
        if (getProvidersCount() > 0) {
            i2 = (((i * 37) + 4) * 53) + getProvidersList().hashCode();
        }
        int hashCode2 = (i2 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return AuthProto.internal_static_google_api_Authentication_fieldAccessorTable.ensureFieldAccessorsInitialized(Authentication.class, Builder.class);
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
            if (i3 >= this.rules_.size()) {
                break;
            }
            codedOutputStream.writeMessage(3, this.rules_.get(i3));
            i2 = i3 + 1;
        }
        for (i = 0; i < this.providers_.size(); i++) {
            codedOutputStream.writeMessage(4, this.providers_.get(i));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
