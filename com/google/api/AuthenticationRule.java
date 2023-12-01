package com.google.api;

import com.google.api.AuthRequirement;
import com.google.api.OAuthRequirements;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/AuthenticationRule.class */
public final class AuthenticationRule extends GeneratedMessageV3 implements AuthenticationRuleOrBuilder {
    public static final int ALLOW_WITHOUT_CREDENTIAL_FIELD_NUMBER = 5;
    public static final int OAUTH_FIELD_NUMBER = 2;
    public static final int REQUIREMENTS_FIELD_NUMBER = 7;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private boolean allowWithoutCredential_;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private OAuthRequirements oauth_;
    private List<AuthRequirement> requirements_;
    private volatile Object selector_;
    private static final AuthenticationRule DEFAULT_INSTANCE = new AuthenticationRule();
    private static final Parser<AuthenticationRule> PARSER = new AbstractParser<AuthenticationRule>() { // from class: com.google.api.AuthenticationRule.1
        @Override // com.google.protobuf.Parser
        public AuthenticationRule parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new AuthenticationRule(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/AuthenticationRule$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuthenticationRuleOrBuilder {
        private boolean allowWithoutCredential_;
        private int bitField0_;
        private SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> oauthBuilder_;
        private OAuthRequirements oauth_;
        private RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> requirementsBuilder_;
        private List<AuthRequirement> requirements_;
        private Object selector_;

        private Builder() {
            this.selector_ = "";
            this.requirements_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.selector_ = "";
            this.requirements_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureRequirementsIsMutable() {
            if ((this.bitField0_ & 8) == 0) {
                this.requirements_ = new ArrayList(this.requirements_);
                this.bitField0_ |= 8;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AuthProto.internal_static_google_api_AuthenticationRule_descriptor;
        }

        private SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> getOauthFieldBuilder() {
            if (this.oauthBuilder_ == null) {
                this.oauthBuilder_ = new SingleFieldBuilderV3<>(getOauth(), getParentForChildren(), isClean());
                this.oauth_ = null;
            }
            return this.oauthBuilder_;
        }

        private RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> getRequirementsFieldBuilder() {
            if (this.requirementsBuilder_ == null) {
                this.requirementsBuilder_ = new RepeatedFieldBuilderV3<>(this.requirements_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                this.requirements_ = null;
            }
            return this.requirementsBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (AuthenticationRule.alwaysUseFieldBuilders) {
                getRequirementsFieldBuilder();
            }
        }

        public Builder addAllRequirements(Iterable<? extends AuthRequirement> iterable) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureRequirementsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.requirements_);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addRequirements(int i, AuthRequirement.Builder builder) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureRequirementsIsMutable();
            this.requirements_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addRequirements(int i, AuthRequirement authRequirement) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, authRequirement);
                return this;
            } else if (authRequirement != null) {
                ensureRequirementsIsMutable();
                this.requirements_.add(i, authRequirement);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addRequirements(AuthRequirement.Builder builder) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureRequirementsIsMutable();
            this.requirements_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addRequirements(AuthRequirement authRequirement) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(authRequirement);
                return this;
            } else if (authRequirement != null) {
                ensureRequirementsIsMutable();
                this.requirements_.add(authRequirement);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public AuthRequirement.Builder addRequirementsBuilder() {
            return getRequirementsFieldBuilder().addBuilder(AuthRequirement.getDefaultInstance());
        }

        public AuthRequirement.Builder addRequirementsBuilder(int i) {
            return getRequirementsFieldBuilder().addBuilder(i, AuthRequirement.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AuthenticationRule build() {
            AuthenticationRule buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AuthenticationRule buildPartial() {
            AuthenticationRule authenticationRule = new AuthenticationRule(this);
            authenticationRule.selector_ = this.selector_;
            SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
            if (singleFieldBuilderV3 == null) {
                authenticationRule.oauth_ = this.oauth_;
            } else {
                authenticationRule.oauth_ = singleFieldBuilderV3.build();
            }
            authenticationRule.allowWithoutCredential_ = this.allowWithoutCredential_;
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 8) != 0) {
                    this.requirements_ = Collections.unmodifiableList(this.requirements_);
                    this.bitField0_ &= -9;
                }
                authenticationRule.requirements_ = this.requirements_;
            } else {
                authenticationRule.requirements_ = repeatedFieldBuilderV3.build();
            }
            authenticationRule.bitField0_ = 0;
            onBuilt();
            return authenticationRule;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.selector_ = "";
            if (this.oauthBuilder_ == null) {
                this.oauth_ = null;
            } else {
                this.oauth_ = null;
                this.oauthBuilder_ = null;
            }
            this.allowWithoutCredential_ = false;
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.requirements_ = Collections.emptyList();
            this.bitField0_ &= -9;
            return this;
        }

        public Builder clearAllowWithoutCredential() {
            this.allowWithoutCredential_ = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearOauth() {
            if (this.oauthBuilder_ == null) {
                this.oauth_ = null;
                onChanged();
                return this;
            }
            this.oauth_ = null;
            this.oauthBuilder_ = null;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRequirements() {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.requirements_ = Collections.emptyList();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder clearSelector() {
            this.selector_ = AuthenticationRule.getDefaultInstance().getSelector();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2030clone() {
            return (Builder) super.mo2030clone();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public boolean getAllowWithoutCredential() {
            return this.allowWithoutCredential_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AuthenticationRule getDefaultInstanceForType() {
            return AuthenticationRule.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return AuthProto.internal_static_google_api_AuthenticationRule_descriptor;
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public OAuthRequirements getOauth() {
            SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
            if (singleFieldBuilderV3 == null) {
                OAuthRequirements oAuthRequirements = this.oauth_;
                OAuthRequirements oAuthRequirements2 = oAuthRequirements;
                if (oAuthRequirements == null) {
                    oAuthRequirements2 = OAuthRequirements.getDefaultInstance();
                }
                return oAuthRequirements2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public OAuthRequirements.Builder getOauthBuilder() {
            onChanged();
            return getOauthFieldBuilder().getBuilder();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public OAuthRequirementsOrBuilder getOauthOrBuilder() {
            SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            OAuthRequirements oAuthRequirements = this.oauth_;
            OAuthRequirements oAuthRequirements2 = oAuthRequirements;
            if (oAuthRequirements == null) {
                oAuthRequirements2 = OAuthRequirements.getDefaultInstance();
            }
            return oAuthRequirements2;
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public AuthRequirement getRequirements(int i) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.requirements_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public AuthRequirement.Builder getRequirementsBuilder(int i) {
            return getRequirementsFieldBuilder().getBuilder(i);
        }

        public List<AuthRequirement.Builder> getRequirementsBuilderList() {
            return getRequirementsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public int getRequirementsCount() {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.requirements_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public List<AuthRequirement> getRequirementsList() {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.requirements_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public AuthRequirementOrBuilder getRequirementsOrBuilder(int i) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.requirements_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList() {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.requirements_);
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public String getSelector() {
            Object obj = this.selector_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.selector_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public ByteString getSelectorBytes() {
            Object obj = this.selector_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.selector_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public boolean hasOauth() {
            return (this.oauthBuilder_ == null && this.oauth_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuthProto.internal_static_google_api_AuthenticationRule_fieldAccessorTable.ensureFieldAccessorsInitialized(AuthenticationRule.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(AuthenticationRule authenticationRule) {
            if (authenticationRule == AuthenticationRule.getDefaultInstance()) {
                return this;
            }
            if (!authenticationRule.getSelector().isEmpty()) {
                this.selector_ = authenticationRule.selector_;
                onChanged();
            }
            if (authenticationRule.hasOauth()) {
                mergeOauth(authenticationRule.getOauth());
            }
            if (authenticationRule.getAllowWithoutCredential()) {
                setAllowWithoutCredential(authenticationRule.getAllowWithoutCredential());
            }
            if (this.requirementsBuilder_ == null) {
                if (!authenticationRule.requirements_.isEmpty()) {
                    if (this.requirements_.isEmpty()) {
                        this.requirements_ = authenticationRule.requirements_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureRequirementsIsMutable();
                        this.requirements_.addAll(authenticationRule.requirements_);
                    }
                    onChanged();
                }
            } else if (!authenticationRule.requirements_.isEmpty()) {
                if (this.requirementsBuilder_.isEmpty()) {
                    this.requirementsBuilder_.dispose();
                    RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = null;
                    this.requirementsBuilder_ = null;
                    this.requirements_ = authenticationRule.requirements_;
                    this.bitField0_ &= -9;
                    if (AuthenticationRule.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getRequirementsFieldBuilder();
                    }
                    this.requirementsBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.requirementsBuilder_.addAllMessages(authenticationRule.requirements_);
                }
            }
            mergeUnknownFields(authenticationRule.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.AuthenticationRule.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.api.AuthenticationRule.access$1100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.api.AuthenticationRule r0 = (com.google.api.AuthenticationRule) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.api.AuthenticationRule$Builder r0 = r0.mergeFrom(r1)
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
                com.google.api.AuthenticationRule r0 = (com.google.api.AuthenticationRule) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.api.AuthenticationRule$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.AuthenticationRule.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.AuthenticationRule$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof AuthenticationRule) {
                return mergeFrom((AuthenticationRule) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeOauth(OAuthRequirements oAuthRequirements) {
            SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(oAuthRequirements);
                return this;
            }
            OAuthRequirements oAuthRequirements2 = this.oauth_;
            if (oAuthRequirements2 != null) {
                this.oauth_ = OAuthRequirements.newBuilder(oAuthRequirements2).mergeFrom(oAuthRequirements).buildPartial();
            } else {
                this.oauth_ = oAuthRequirements;
            }
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeRequirements(int i) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureRequirementsIsMutable();
            this.requirements_.remove(i);
            onChanged();
            return this;
        }

        public Builder setAllowWithoutCredential(boolean z) {
            this.allowWithoutCredential_ = z;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setOauth(OAuthRequirements.Builder builder) {
            SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.oauth_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setOauth(OAuthRequirements oAuthRequirements) {
            SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(oAuthRequirements);
                return this;
            } else if (oAuthRequirements != null) {
                this.oauth_ = oAuthRequirements;
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

        public Builder setRequirements(int i, AuthRequirement.Builder builder) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureRequirementsIsMutable();
            this.requirements_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setRequirements(int i, AuthRequirement authRequirement) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, authRequirement);
                return this;
            } else if (authRequirement != null) {
                ensureRequirementsIsMutable();
                this.requirements_.set(i, authRequirement);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setSelector(String str) {
            if (str != null) {
                this.selector_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            if (byteString != null) {
                AuthenticationRule.checkByteStringIsUtf8(byteString);
                this.selector_ = byteString;
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

    private AuthenticationRule() {
        this.memoizedIsInitialized = (byte) -1;
        this.selector_ = "";
        this.requirements_ = Collections.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AuthenticationRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        OAuthRequirements.Builder builder;
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
                        if (readTag == 10) {
                            this.selector_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            if (this.oauth_ != null) {
                                boolean z4 = z2;
                                builder = this.oauth_.toBuilder();
                            } else {
                                builder = null;
                            }
                            OAuthRequirements oAuthRequirements = (OAuthRequirements) codedInputStream.readMessage(OAuthRequirements.parser(), extensionRegistryLite);
                            boolean z5 = z2;
                            this.oauth_ = oAuthRequirements;
                            if (builder != null) {
                                builder.mergeFrom(oAuthRequirements);
                                boolean z6 = z2;
                                this.oauth_ = builder.buildPartial();
                            }
                        } else if (readTag == 40) {
                            this.allowWithoutCredential_ = codedInputStream.readBool();
                        } else if (readTag == 58) {
                            boolean z7 = z2;
                            if (!(z2 & true)) {
                                this.requirements_ = new ArrayList();
                                z7 = z2 | true;
                            }
                            this.requirements_.add(codedInputStream.readMessage(AuthRequirement.parser(), extensionRegistryLite));
                            z2 = z7;
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
                    this.requirements_ = Collections.unmodifiableList(this.requirements_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.requirements_ = Collections.unmodifiableList(this.requirements_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private AuthenticationRule(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static AuthenticationRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return AuthProto.internal_static_google_api_AuthenticationRule_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuthenticationRule authenticationRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(authenticationRule);
    }

    public static AuthenticationRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuthenticationRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AuthenticationRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthenticationRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static AuthenticationRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuthenticationRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static AuthenticationRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthenticationRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(InputStream inputStream) throws IOException {
        return (AuthenticationRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static AuthenticationRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthenticationRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static AuthenticationRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static AuthenticationRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<AuthenticationRule> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AuthenticationRule) {
            AuthenticationRule authenticationRule = (AuthenticationRule) obj;
            if (getSelector().equals(authenticationRule.getSelector()) && hasOauth() == authenticationRule.hasOauth()) {
                return (!hasOauth() || getOauth().equals(authenticationRule.getOauth())) && getAllowWithoutCredential() == authenticationRule.getAllowWithoutCredential() && getRequirementsList().equals(authenticationRule.getRequirementsList()) && this.unknownFields.equals(authenticationRule.unknownFields);
            }
            return false;
        }
        return super.equals(obj);
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public boolean getAllowWithoutCredential() {
        return this.allowWithoutCredential_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public AuthenticationRule getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public OAuthRequirements getOauth() {
        OAuthRequirements oAuthRequirements = this.oauth_;
        OAuthRequirements oAuthRequirements2 = oAuthRequirements;
        if (oAuthRequirements == null) {
            oAuthRequirements2 = OAuthRequirements.getDefaultInstance();
        }
        return oAuthRequirements2;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public OAuthRequirementsOrBuilder getOauthOrBuilder() {
        return getOauth();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AuthenticationRule> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public AuthRequirement getRequirements(int i) {
        return this.requirements_.get(i);
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public int getRequirementsCount() {
        return this.requirements_.size();
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public List<AuthRequirement> getRequirementsList() {
        return this.requirements_;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public AuthRequirementOrBuilder getRequirementsOrBuilder(int i) {
        return this.requirements_.get(i);
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList() {
        return this.requirements_;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public String getSelector() {
        Object obj = this.selector_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.selector_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public ByteString getSelectorBytes() {
        Object obj = this.selector_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.selector_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !getSelectorBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.selector_) + 0 : 0;
        int i2 = computeStringSize;
        if (this.oauth_ != null) {
            i2 = computeStringSize + CodedOutputStream.computeMessageSize(2, getOauth());
        }
        boolean z = this.allowWithoutCredential_;
        int i3 = i2;
        int i4 = 0;
        if (z) {
            i3 = i2 + CodedOutputStream.computeBoolSize(5, z);
            i4 = 0;
        }
        while (i4 < this.requirements_.size()) {
            i3 += CodedOutputStream.computeMessageSize(7, this.requirements_.get(i4));
            i4++;
        }
        int serializedSize = i3 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public boolean hasOauth() {
        return this.oauth_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getSelector().hashCode();
        int i = hashCode;
        if (hasOauth()) {
            i = (((hashCode * 37) + 2) * 53) + getOauth().hashCode();
        }
        int hashBoolean = (((i * 37) + 5) * 53) + Internal.hashBoolean(getAllowWithoutCredential());
        int i2 = hashBoolean;
        if (getRequirementsCount() > 0) {
            i2 = (((hashBoolean * 37) + 7) * 53) + getRequirementsList().hashCode();
        }
        int hashCode2 = (i2 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return AuthProto.internal_static_google_api_AuthenticationRule_fieldAccessorTable.ensureFieldAccessorsInitialized(AuthenticationRule.class, Builder.class);
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
        if (!getSelectorBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.selector_);
        }
        if (this.oauth_ != null) {
            codedOutputStream.writeMessage(2, getOauth());
        }
        boolean z = this.allowWithoutCredential_;
        if (z) {
            codedOutputStream.writeBool(5, z);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.requirements_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(7, this.requirements_.get(i2));
                i = i2 + 1;
            }
        }
    }
}
