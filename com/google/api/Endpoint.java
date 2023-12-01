package com.google.api;

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

/* loaded from: source-8110460-dex2jar.jar:com/google/api/Endpoint.class */
public final class Endpoint extends GeneratedMessageV3 implements EndpointOrBuilder {
    public static final int ALIASES_FIELD_NUMBER = 2;
    public static final int ALLOW_CORS_FIELD_NUMBER = 5;
    public static final int FEATURES_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int TARGET_FIELD_NUMBER = 101;
    private static final long serialVersionUID = 0;
    private LazyStringList aliases_;
    private boolean allowCors_;
    private int bitField0_;
    private LazyStringList features_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private volatile Object target_;
    private static final Endpoint DEFAULT_INSTANCE = new Endpoint();
    private static final Parser<Endpoint> PARSER = new AbstractParser<Endpoint>() { // from class: com.google.api.Endpoint.1
        @Override // com.google.protobuf.Parser
        public Endpoint parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Endpoint(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/Endpoint$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EndpointOrBuilder {
        private LazyStringList aliases_;
        private boolean allowCors_;
        private int bitField0_;
        private LazyStringList features_;
        private Object name_;
        private Object target_;

        private Builder() {
            this.name_ = "";
            this.aliases_ = LazyStringArrayList.EMPTY;
            this.features_ = LazyStringArrayList.EMPTY;
            this.target_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.aliases_ = LazyStringArrayList.EMPTY;
            this.features_ = LazyStringArrayList.EMPTY;
            this.target_ = "";
            maybeForceBuilderInitialization();
        }

        private void ensureAliasesIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.aliases_ = new LazyStringArrayList(this.aliases_);
                this.bitField0_ |= 2;
            }
        }

        private void ensureFeaturesIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.features_ = new LazyStringArrayList(this.features_);
                this.bitField0_ |= 4;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EndpointProto.internal_static_google_api_Endpoint_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = Endpoint.alwaysUseFieldBuilders;
        }

        @Deprecated
        public Builder addAliases(String str) {
            if (str != null) {
                ensureAliasesIsMutable();
                this.aliases_.add((LazyStringList) str);
                onChanged();
                return this;
            }
            throw null;
        }

        @Deprecated
        public Builder addAliasesBytes(ByteString byteString) {
            if (byteString != null) {
                Endpoint.checkByteStringIsUtf8(byteString);
                ensureAliasesIsMutable();
                this.aliases_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        @Deprecated
        public Builder addAllAliases(Iterable<String> iterable) {
            ensureAliasesIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.aliases_);
            onChanged();
            return this;
        }

        public Builder addAllFeatures(Iterable<String> iterable) {
            ensureFeaturesIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.features_);
            onChanged();
            return this;
        }

        public Builder addFeatures(String str) {
            if (str != null) {
                ensureFeaturesIsMutable();
                this.features_.add((LazyStringList) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addFeaturesBytes(ByteString byteString) {
            if (byteString != null) {
                Endpoint.checkByteStringIsUtf8(byteString);
                ensureFeaturesIsMutable();
                this.features_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Endpoint build() {
            Endpoint buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Endpoint buildPartial() {
            Endpoint endpoint = new Endpoint(this);
            endpoint.name_ = this.name_;
            if ((this.bitField0_ & 2) != 0) {
                this.aliases_ = this.aliases_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            endpoint.aliases_ = this.aliases_;
            if ((this.bitField0_ & 4) != 0) {
                this.features_ = this.features_.getUnmodifiableView();
                this.bitField0_ &= -5;
            }
            endpoint.features_ = this.features_;
            endpoint.target_ = this.target_;
            endpoint.allowCors_ = this.allowCors_;
            endpoint.bitField0_ = 0;
            onBuilt();
            return endpoint;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.name_ = "";
            this.aliases_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            this.features_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -5;
            this.target_ = "";
            this.allowCors_ = false;
            return this;
        }

        @Deprecated
        public Builder clearAliases() {
            this.aliases_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearAllowCors() {
            this.allowCors_ = false;
            onChanged();
            return this;
        }

        public Builder clearFeatures() {
            this.features_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearName() {
            this.name_ = Endpoint.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearTarget() {
            this.target_ = Endpoint.getDefaultInstance().getTarget();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public String getAliases(int i) {
            return this.aliases_.get(i);
        }

        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public ByteString getAliasesBytes(int i) {
            return this.aliases_.getByteString(i);
        }

        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public int getAliasesCount() {
            return this.aliases_.size();
        }

        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public ProtocolStringList getAliasesList() {
            return this.aliases_.getUnmodifiableView();
        }

        @Override // com.google.api.EndpointOrBuilder
        public boolean getAllowCors() {
            return this.allowCors_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Endpoint getDefaultInstanceForType() {
            return Endpoint.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return EndpointProto.internal_static_google_api_Endpoint_descriptor;
        }

        @Override // com.google.api.EndpointOrBuilder
        public String getFeatures(int i) {
            return this.features_.get(i);
        }

        @Override // com.google.api.EndpointOrBuilder
        public ByteString getFeaturesBytes(int i) {
            return this.features_.getByteString(i);
        }

        @Override // com.google.api.EndpointOrBuilder
        public int getFeaturesCount() {
            return this.features_.size();
        }

        @Override // com.google.api.EndpointOrBuilder
        public ProtocolStringList getFeaturesList() {
            return this.features_.getUnmodifiableView();
        }

        @Override // com.google.api.EndpointOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.EndpointOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.EndpointOrBuilder
        public String getTarget() {
            Object obj = this.target_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.target_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.EndpointOrBuilder
        public ByteString getTargetBytes() {
            Object obj = this.target_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.target_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EndpointProto.internal_static_google_api_Endpoint_fieldAccessorTable.ensureFieldAccessorsInitialized(Endpoint.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(Endpoint endpoint) {
            if (endpoint == Endpoint.getDefaultInstance()) {
                return this;
            }
            if (!endpoint.getName().isEmpty()) {
                this.name_ = endpoint.name_;
                onChanged();
            }
            if (!endpoint.aliases_.isEmpty()) {
                if (this.aliases_.isEmpty()) {
                    this.aliases_ = endpoint.aliases_;
                    this.bitField0_ &= -3;
                } else {
                    ensureAliasesIsMutable();
                    this.aliases_.addAll(endpoint.aliases_);
                }
                onChanged();
            }
            if (!endpoint.features_.isEmpty()) {
                if (this.features_.isEmpty()) {
                    this.features_ = endpoint.features_;
                    this.bitField0_ &= -5;
                } else {
                    ensureFeaturesIsMutable();
                    this.features_.addAll(endpoint.features_);
                }
                onChanged();
            }
            if (!endpoint.getTarget().isEmpty()) {
                this.target_ = endpoint.target_;
                onChanged();
            }
            if (endpoint.getAllowCors()) {
                setAllowCors(endpoint.getAllowCors());
            }
            mergeUnknownFields(endpoint.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.Endpoint.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.api.Endpoint.access$1100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.api.Endpoint r0 = (com.google.api.Endpoint) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.api.Endpoint$Builder r0 = r0.mergeFrom(r1)
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
                com.google.api.Endpoint r0 = (com.google.api.Endpoint) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.api.Endpoint$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Endpoint.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Endpoint$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Endpoint) {
                return mergeFrom((Endpoint) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        @Deprecated
        public Builder setAliases(int i, String str) {
            if (str != null) {
                ensureAliasesIsMutable();
                this.aliases_.set(i, (int) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAllowCors(boolean z) {
            this.allowCors_ = z;
            onChanged();
            return this;
        }

        public Builder setFeatures(int i, String str) {
            if (str != null) {
                ensureFeaturesIsMutable();
                this.features_.set(i, (int) str);
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
                Endpoint.checkByteStringIsUtf8(byteString);
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

        public Builder setTarget(String str) {
            if (str != null) {
                this.target_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTargetBytes(ByteString byteString) {
            if (byteString != null) {
                Endpoint.checkByteStringIsUtf8(byteString);
                this.target_ = byteString;
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

    private Endpoint() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.aliases_ = LazyStringArrayList.EMPTY;
        this.features_ = LazyStringArrayList.EMPTY;
        this.target_ = "";
    }

    private Endpoint(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        if (readTag == 10) {
                            this.name_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.aliases_ = new LazyStringArrayList();
                                z4 = z2 | true;
                            }
                            this.aliases_.add((LazyStringList) readStringRequireUtf8);
                            z2 = z4;
                        } else if (readTag == 34) {
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.features_ = new LazyStringArrayList();
                                z5 = z2 | true;
                            }
                            this.features_.add((LazyStringList) readStringRequireUtf82);
                            z2 = z5;
                        } else if (readTag == 40) {
                            this.allowCors_ = codedInputStream.readBool();
                        } else if (readTag == 810) {
                            this.target_ = codedInputStream.readStringRequireUtf8();
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
                    this.aliases_ = this.aliases_.getUnmodifiableView();
                }
                if (z3 & true) {
                    this.features_ = this.features_.getUnmodifiableView();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.aliases_ = this.aliases_.getUnmodifiableView();
        }
        if (z2 & true) {
            this.features_ = this.features_.getUnmodifiableView();
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private Endpoint(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Endpoint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return EndpointProto.internal_static_google_api_Endpoint_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Endpoint endpoint) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(endpoint);
    }

    public static Endpoint parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Endpoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Endpoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Endpoint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Endpoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Endpoint parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Endpoint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Endpoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Endpoint parseFrom(InputStream inputStream) throws IOException {
        return (Endpoint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Endpoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Endpoint parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Endpoint parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Endpoint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Endpoint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<Endpoint> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Endpoint) {
            Endpoint endpoint = (Endpoint) obj;
            return getName().equals(endpoint.getName()) && getAliasesList().equals(endpoint.getAliasesList()) && getFeaturesList().equals(endpoint.getFeaturesList()) && getTarget().equals(endpoint.getTarget()) && getAllowCors() == endpoint.getAllowCors() && this.unknownFields.equals(endpoint.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public String getAliases(int i) {
        return this.aliases_.get(i);
    }

    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public ByteString getAliasesBytes(int i) {
        return this.aliases_.getByteString(i);
    }

    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public int getAliasesCount() {
        return this.aliases_.size();
    }

    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public ProtocolStringList getAliasesList() {
        return this.aliases_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public boolean getAllowCors() {
        return this.allowCors_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Endpoint getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.api.EndpointOrBuilder
    public String getFeatures(int i) {
        return this.features_.get(i);
    }

    @Override // com.google.api.EndpointOrBuilder
    public ByteString getFeaturesBytes(int i) {
        return this.features_.getByteString(i);
    }

    @Override // com.google.api.EndpointOrBuilder
    public int getFeaturesCount() {
        return this.features_.size();
    }

    @Override // com.google.api.EndpointOrBuilder
    public ProtocolStringList getFeaturesList() {
        return this.features_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.EndpointOrBuilder
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
    public Parser<Endpoint> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !getNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.aliases_.size(); i3++) {
            i2 += computeStringSizeNoTag(this.aliases_.getRaw(i3));
        }
        int size = getAliasesList().size();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.features_.size()) {
                break;
            }
            i4 += computeStringSizeNoTag(this.features_.getRaw(i6));
            i5 = i6 + 1;
        }
        int size2 = computeStringSize + i2 + (size * 1) + i4 + (getFeaturesList().size() * 1);
        boolean z = this.allowCors_;
        int i7 = size2;
        if (z) {
            i7 = size2 + CodedOutputStream.computeBoolSize(5, z);
        }
        int i8 = i7;
        if (!getTargetBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(101, this.target_);
        }
        int serializedSize = i8 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.api.EndpointOrBuilder
    public String getTarget() {
        Object obj = this.target_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.target_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.EndpointOrBuilder
    public ByteString getTargetBytes() {
        Object obj = this.target_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.target_ = copyFromUtf8;
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
        int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        int i = hashCode;
        if (getAliasesCount() > 0) {
            i = (((hashCode * 37) + 2) * 53) + getAliasesList().hashCode();
        }
        int i2 = i;
        if (getFeaturesCount() > 0) {
            i2 = (((i * 37) + 4) * 53) + getFeaturesList().hashCode();
        }
        int hashCode2 = (((((((((i2 * 37) + 101) * 53) + getTarget().hashCode()) * 37) + 5) * 53) + Internal.hashBoolean(getAllowCors())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return EndpointProto.internal_static_google_api_Endpoint_fieldAccessorTable.ensureFieldAccessorsInitialized(Endpoint.class, Builder.class);
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
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.aliases_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.aliases_.getRaw(i3));
            i2 = i3 + 1;
        }
        for (i = 0; i < this.features_.size(); i++) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.features_.getRaw(i));
        }
        boolean z = this.allowCors_;
        if (z) {
            codedOutputStream.writeBool(5, z);
        }
        if (!getTargetBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 101, this.target_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
