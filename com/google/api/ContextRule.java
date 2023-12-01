package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/ContextRule.class */
public final class ContextRule extends GeneratedMessageV3 implements ContextRuleOrBuilder {
    public static final int ALLOWED_REQUEST_EXTENSIONS_FIELD_NUMBER = 4;
    public static final int ALLOWED_RESPONSE_EXTENSIONS_FIELD_NUMBER = 5;
    private static final ContextRule DEFAULT_INSTANCE = new ContextRule();
    private static final Parser<ContextRule> PARSER = new AbstractParser<ContextRule>() { // from class: com.google.api.ContextRule.1
        @Override // com.google.protobuf.Parser
        public ContextRule parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ContextRule(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int PROVIDED_FIELD_NUMBER = 3;
    public static final int REQUESTED_FIELD_NUMBER = 2;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private LazyStringList allowedRequestExtensions_;
    private LazyStringList allowedResponseExtensions_;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private LazyStringList provided_;
    private LazyStringList requested_;
    private volatile Object selector_;

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/ContextRule$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ContextRuleOrBuilder {
        private LazyStringList allowedRequestExtensions_;
        private LazyStringList allowedResponseExtensions_;
        private int bitField0_;
        private LazyStringList provided_;
        private LazyStringList requested_;
        private Object selector_;

        private Builder() {
            this.selector_ = "";
            this.requested_ = LazyStringArrayList.EMPTY;
            this.provided_ = LazyStringArrayList.EMPTY;
            this.allowedRequestExtensions_ = LazyStringArrayList.EMPTY;
            this.allowedResponseExtensions_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.selector_ = "";
            this.requested_ = LazyStringArrayList.EMPTY;
            this.provided_ = LazyStringArrayList.EMPTY;
            this.allowedRequestExtensions_ = LazyStringArrayList.EMPTY;
            this.allowedResponseExtensions_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void ensureAllowedRequestExtensionsIsMutable() {
            if ((this.bitField0_ & 8) == 0) {
                this.allowedRequestExtensions_ = new LazyStringArrayList(this.allowedRequestExtensions_);
                this.bitField0_ |= 8;
            }
        }

        private void ensureAllowedResponseExtensionsIsMutable() {
            if ((this.bitField0_ & 16) == 0) {
                this.allowedResponseExtensions_ = new LazyStringArrayList(this.allowedResponseExtensions_);
                this.bitField0_ |= 16;
            }
        }

        private void ensureProvidedIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.provided_ = new LazyStringArrayList(this.provided_);
                this.bitField0_ |= 4;
            }
        }

        private void ensureRequestedIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.requested_ = new LazyStringArrayList(this.requested_);
                this.bitField0_ |= 2;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ContextProto.internal_static_google_api_ContextRule_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = ContextRule.alwaysUseFieldBuilders;
        }

        public Builder addAllAllowedRequestExtensions(Iterable<String> iterable) {
            ensureAllowedRequestExtensionsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.allowedRequestExtensions_);
            onChanged();
            return this;
        }

        public Builder addAllAllowedResponseExtensions(Iterable<String> iterable) {
            ensureAllowedResponseExtensionsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.allowedResponseExtensions_);
            onChanged();
            return this;
        }

        public Builder addAllProvided(Iterable<String> iterable) {
            ensureProvidedIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.provided_);
            onChanged();
            return this;
        }

        public Builder addAllRequested(Iterable<String> iterable) {
            ensureRequestedIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.requested_);
            onChanged();
            return this;
        }

        public Builder addAllowedRequestExtensions(String str) {
            if (str != null) {
                ensureAllowedRequestExtensionsIsMutable();
                this.allowedRequestExtensions_.add((LazyStringList) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addAllowedRequestExtensionsBytes(ByteString byteString) {
            if (byteString != null) {
                ContextRule.checkByteStringIsUtf8(byteString);
                ensureAllowedRequestExtensionsIsMutable();
                this.allowedRequestExtensions_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addAllowedResponseExtensions(String str) {
            if (str != null) {
                ensureAllowedResponseExtensionsIsMutable();
                this.allowedResponseExtensions_.add((LazyStringList) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addAllowedResponseExtensionsBytes(ByteString byteString) {
            if (byteString != null) {
                ContextRule.checkByteStringIsUtf8(byteString);
                ensureAllowedResponseExtensionsIsMutable();
                this.allowedResponseExtensions_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addProvided(String str) {
            if (str != null) {
                ensureProvidedIsMutable();
                this.provided_.add((LazyStringList) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addProvidedBytes(ByteString byteString) {
            if (byteString != null) {
                ContextRule.checkByteStringIsUtf8(byteString);
                ensureProvidedIsMutable();
                this.provided_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addRequested(String str) {
            if (str != null) {
                ensureRequestedIsMutable();
                this.requested_.add((LazyStringList) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addRequestedBytes(ByteString byteString) {
            if (byteString != null) {
                ContextRule.checkByteStringIsUtf8(byteString);
                ensureRequestedIsMutable();
                this.requested_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ContextRule build() {
            ContextRule buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ContextRule buildPartial() {
            ContextRule contextRule = new ContextRule(this);
            contextRule.selector_ = this.selector_;
            if ((this.bitField0_ & 2) != 0) {
                this.requested_ = this.requested_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            contextRule.requested_ = this.requested_;
            if ((this.bitField0_ & 4) != 0) {
                this.provided_ = this.provided_.getUnmodifiableView();
                this.bitField0_ &= -5;
            }
            contextRule.provided_ = this.provided_;
            if ((this.bitField0_ & 8) != 0) {
                this.allowedRequestExtensions_ = this.allowedRequestExtensions_.getUnmodifiableView();
                this.bitField0_ &= -9;
            }
            contextRule.allowedRequestExtensions_ = this.allowedRequestExtensions_;
            if ((this.bitField0_ & 16) != 0) {
                this.allowedResponseExtensions_ = this.allowedResponseExtensions_.getUnmodifiableView();
                this.bitField0_ &= -17;
            }
            contextRule.allowedResponseExtensions_ = this.allowedResponseExtensions_;
            contextRule.bitField0_ = 0;
            onBuilt();
            return contextRule;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.selector_ = "";
            this.requested_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            this.provided_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -5;
            this.allowedRequestExtensions_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -9;
            this.allowedResponseExtensions_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -17;
            return this;
        }

        public Builder clearAllowedRequestExtensions() {
            this.allowedRequestExtensions_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder clearAllowedResponseExtensions() {
            this.allowedResponseExtensions_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -17;
            onChanged();
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

        public Builder clearProvided() {
            this.provided_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearRequested() {
            this.requested_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearSelector() {
            this.selector_ = ContextRule.getDefaultInstance().getSelector();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getAllowedRequestExtensions(int i) {
            return this.allowedRequestExtensions_.get(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getAllowedRequestExtensionsBytes(int i) {
            return this.allowedRequestExtensions_.getByteString(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getAllowedRequestExtensionsCount() {
            return this.allowedRequestExtensions_.size();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ProtocolStringList getAllowedRequestExtensionsList() {
            return this.allowedRequestExtensions_.getUnmodifiableView();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getAllowedResponseExtensions(int i) {
            return this.allowedResponseExtensions_.get(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getAllowedResponseExtensionsBytes(int i) {
            return this.allowedResponseExtensions_.getByteString(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getAllowedResponseExtensionsCount() {
            return this.allowedResponseExtensions_.size();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ProtocolStringList getAllowedResponseExtensionsList() {
            return this.allowedResponseExtensions_.getUnmodifiableView();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ContextRule getDefaultInstanceForType() {
            return ContextRule.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return ContextProto.internal_static_google_api_ContextRule_descriptor;
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getProvided(int i) {
            return this.provided_.get(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getProvidedBytes(int i) {
            return this.provided_.getByteString(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getProvidedCount() {
            return this.provided_.size();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ProtocolStringList getProvidedList() {
            return this.provided_.getUnmodifiableView();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getRequested(int i) {
            return this.requested_.get(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getRequestedBytes(int i) {
            return this.requested_.getByteString(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getRequestedCount() {
            return this.requested_.size();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ProtocolStringList getRequestedList() {
            return this.requested_.getUnmodifiableView();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getSelector() {
            Object obj = this.selector_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.selector_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getSelectorBytes() {
            Object obj = this.selector_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.selector_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ContextProto.internal_static_google_api_ContextRule_fieldAccessorTable.ensureFieldAccessorsInitialized(ContextRule.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ContextRule contextRule) {
            if (contextRule == ContextRule.getDefaultInstance()) {
                return this;
            }
            if (!contextRule.getSelector().isEmpty()) {
                this.selector_ = contextRule.selector_;
                onChanged();
            }
            if (!contextRule.requested_.isEmpty()) {
                if (this.requested_.isEmpty()) {
                    this.requested_ = contextRule.requested_;
                    this.bitField0_ &= -3;
                } else {
                    ensureRequestedIsMutable();
                    this.requested_.addAll(contextRule.requested_);
                }
                onChanged();
            }
            if (!contextRule.provided_.isEmpty()) {
                if (this.provided_.isEmpty()) {
                    this.provided_ = contextRule.provided_;
                    this.bitField0_ &= -5;
                } else {
                    ensureProvidedIsMutable();
                    this.provided_.addAll(contextRule.provided_);
                }
                onChanged();
            }
            if (!contextRule.allowedRequestExtensions_.isEmpty()) {
                if (this.allowedRequestExtensions_.isEmpty()) {
                    this.allowedRequestExtensions_ = contextRule.allowedRequestExtensions_;
                    this.bitField0_ &= -9;
                } else {
                    ensureAllowedRequestExtensionsIsMutable();
                    this.allowedRequestExtensions_.addAll(contextRule.allowedRequestExtensions_);
                }
                onChanged();
            }
            if (!contextRule.allowedResponseExtensions_.isEmpty()) {
                if (this.allowedResponseExtensions_.isEmpty()) {
                    this.allowedResponseExtensions_ = contextRule.allowedResponseExtensions_;
                    this.bitField0_ &= -17;
                } else {
                    ensureAllowedResponseExtensionsIsMutable();
                    this.allowedResponseExtensions_.addAll(contextRule.allowedResponseExtensions_);
                }
                onChanged();
            }
            mergeUnknownFields(contextRule.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.ContextRule.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.api.ContextRule.access$1100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.api.ContextRule r0 = (com.google.api.ContextRule) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.api.ContextRule$Builder r0 = r0.mergeFrom(r1)
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
                com.google.api.ContextRule r0 = (com.google.api.ContextRule) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.api.ContextRule$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.ContextRule.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.ContextRule$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ContextRule) {
                return mergeFrom((ContextRule) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setAllowedRequestExtensions(int i, String str) {
            if (str != null) {
                ensureAllowedRequestExtensionsIsMutable();
                this.allowedRequestExtensions_.set(i, (int) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAllowedResponseExtensions(int i, String str) {
            if (str != null) {
                ensureAllowedResponseExtensionsIsMutable();
                this.allowedResponseExtensions_.set(i, (int) str);
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setProvided(int i, String str) {
            if (str != null) {
                ensureProvidedIsMutable();
                this.provided_.set(i, (int) str);
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setRequested(int i, String str) {
            if (str != null) {
                ensureRequestedIsMutable();
                this.requested_.set(i, (int) str);
                onChanged();
                return this;
            }
            throw null;
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
                ContextRule.checkByteStringIsUtf8(byteString);
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

    private ContextRule() {
        this.memoizedIsInitialized = (byte) -1;
        this.selector_ = "";
        this.requested_ = LazyStringArrayList.EMPTY;
        this.provided_ = LazyStringArrayList.EMPTY;
        this.allowedRequestExtensions_ = LazyStringArrayList.EMPTY;
        this.allowedResponseExtensions_ = LazyStringArrayList.EMPTY;
    }

    private ContextRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.selector_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                boolean z4 = z2;
                                if (!(z2 & true)) {
                                    this.requested_ = new LazyStringArrayList();
                                    z4 = z2 | true;
                                }
                                this.requested_.add((LazyStringList) readStringRequireUtf8);
                                z2 = z4;
                            } else if (readTag == 26) {
                                String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                                boolean z5 = z2;
                                if (!(z2 & true)) {
                                    this.provided_ = new LazyStringArrayList();
                                    z5 = z2 | true;
                                }
                                this.provided_.add((LazyStringList) readStringRequireUtf82);
                                z2 = z5;
                            } else if (readTag == 34) {
                                String readStringRequireUtf83 = codedInputStream.readStringRequireUtf8();
                                boolean z6 = z2;
                                if (!(z2 & true)) {
                                    this.allowedRequestExtensions_ = new LazyStringArrayList();
                                    z6 = z2 | true;
                                }
                                this.allowedRequestExtensions_.add((LazyStringList) readStringRequireUtf83);
                                z2 = z6;
                            } else if (readTag == 42) {
                                String readStringRequireUtf84 = codedInputStream.readStringRequireUtf8();
                                boolean z7 = z2;
                                if (!(z2 & true)) {
                                    this.allowedResponseExtensions_ = new LazyStringArrayList();
                                    z7 = z2 | true;
                                }
                                this.allowedResponseExtensions_.add((LazyStringList) readStringRequireUtf84);
                                z2 = z7;
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
                    this.requested_ = this.requested_.getUnmodifiableView();
                }
                if (z3 & true) {
                    this.provided_ = this.provided_.getUnmodifiableView();
                }
                if (z3 & true) {
                    this.allowedRequestExtensions_ = this.allowedRequestExtensions_.getUnmodifiableView();
                }
                if (z3 & true) {
                    this.allowedResponseExtensions_ = this.allowedResponseExtensions_.getUnmodifiableView();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.requested_ = this.requested_.getUnmodifiableView();
        }
        if (z2 & true) {
            this.provided_ = this.provided_.getUnmodifiableView();
        }
        if (z2 & true) {
            this.allowedRequestExtensions_ = this.allowedRequestExtensions_.getUnmodifiableView();
        }
        if (z2 & true) {
            this.allowedResponseExtensions_ = this.allowedResponseExtensions_.getUnmodifiableView();
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private ContextRule(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ContextRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return ContextProto.internal_static_google_api_ContextRule_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ContextRule contextRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(contextRule);
    }

    public static ContextRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ContextRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ContextRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ContextRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ContextRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ContextRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ContextRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ContextRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ContextRule parseFrom(InputStream inputStream) throws IOException {
        return (ContextRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ContextRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ContextRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ContextRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ContextRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ContextRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ContextRule> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ContextRule) {
            ContextRule contextRule = (ContextRule) obj;
            return getSelector().equals(contextRule.getSelector()) && getRequestedList().equals(contextRule.getRequestedList()) && getProvidedList().equals(contextRule.getProvidedList()) && getAllowedRequestExtensionsList().equals(contextRule.getAllowedRequestExtensionsList()) && getAllowedResponseExtensionsList().equals(contextRule.getAllowedResponseExtensionsList()) && this.unknownFields.equals(contextRule.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getAllowedRequestExtensions(int i) {
        return this.allowedRequestExtensions_.get(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getAllowedRequestExtensionsBytes(int i) {
        return this.allowedRequestExtensions_.getByteString(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getAllowedRequestExtensionsCount() {
        return this.allowedRequestExtensions_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ProtocolStringList getAllowedRequestExtensionsList() {
        return this.allowedRequestExtensions_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getAllowedResponseExtensions(int i) {
        return this.allowedResponseExtensions_.get(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getAllowedResponseExtensionsBytes(int i) {
        return this.allowedResponseExtensions_.getByteString(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getAllowedResponseExtensionsCount() {
        return this.allowedResponseExtensions_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ProtocolStringList getAllowedResponseExtensionsList() {
        return this.allowedResponseExtensions_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ContextRule getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ContextRule> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getProvided(int i) {
        return this.provided_.get(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getProvidedBytes(int i) {
        return this.provided_.getByteString(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getProvidedCount() {
        return this.provided_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ProtocolStringList getProvidedList() {
        return this.provided_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getRequested(int i) {
        return this.requested_.get(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getRequestedBytes(int i) {
        return this.requested_.getByteString(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getRequestedCount() {
        return this.requested_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ProtocolStringList getRequestedList() {
        return this.requested_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getSelector() {
        Object obj = this.selector_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.selector_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ContextRuleOrBuilder
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
        int i2 = 0;
        for (int i3 = 0; i3 < this.requested_.size(); i3++) {
            i2 += computeStringSizeNoTag(this.requested_.getRaw(i3));
        }
        int size = getRequestedList().size();
        int i4 = 0;
        for (int i5 = 0; i5 < this.provided_.size(); i5++) {
            i4 += computeStringSizeNoTag(this.provided_.getRaw(i5));
        }
        int size2 = getProvidedList().size();
        int i6 = 0;
        for (int i7 = 0; i7 < this.allowedRequestExtensions_.size(); i7++) {
            i6 += computeStringSizeNoTag(this.allowedRequestExtensions_.getRaw(i7));
        }
        int size3 = getAllowedRequestExtensionsList().size();
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= this.allowedResponseExtensions_.size()) {
                int size4 = computeStringSize + i2 + (size * 1) + i4 + (size2 * 1) + i6 + (size3 * 1) + i8 + (getAllowedResponseExtensionsList().size() * 1) + this.unknownFields.getSerializedSize();
                this.memoizedSize = size4;
                return size4;
            }
            i8 += computeStringSizeNoTag(this.allowedResponseExtensions_.getRaw(i10));
            i9 = i10 + 1;
        }
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
        int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getSelector().hashCode();
        int i = hashCode;
        if (getRequestedCount() > 0) {
            i = (((hashCode * 37) + 2) * 53) + getRequestedList().hashCode();
        }
        int i2 = i;
        if (getProvidedCount() > 0) {
            i2 = (((i * 37) + 3) * 53) + getProvidedList().hashCode();
        }
        int i3 = i2;
        if (getAllowedRequestExtensionsCount() > 0) {
            i3 = (((i2 * 37) + 4) * 53) + getAllowedRequestExtensionsList().hashCode();
        }
        int i4 = i3;
        if (getAllowedResponseExtensionsCount() > 0) {
            i4 = (((i3 * 37) + 5) * 53) + getAllowedResponseExtensionsList().hashCode();
        }
        int hashCode2 = (i4 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ContextProto.internal_static_google_api_ContextRule_fieldAccessorTable.ensureFieldAccessorsInitialized(ContextRule.class, Builder.class);
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
        if (!getSelectorBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.selector_);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.requested_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.requested_.getRaw(i3));
            i2 = i3 + 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.provided_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.provided_.getRaw(i5));
            i4 = i5 + 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.allowedRequestExtensions_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.allowedRequestExtensions_.getRaw(i7));
            i6 = i7 + 1;
        }
        for (i = 0; i < this.allowedResponseExtensions_.size(); i++) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.allowedResponseExtensions_.getRaw(i));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
