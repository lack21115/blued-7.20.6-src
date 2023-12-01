package com.google.api;

import com.google.api.Property;
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

/* loaded from: source-8110460-dex2jar.jar:com/google/api/ProjectProperties.class */
public final class ProjectProperties extends GeneratedMessageV3 implements ProjectPropertiesOrBuilder {
    private static final ProjectProperties DEFAULT_INSTANCE = new ProjectProperties();
    private static final Parser<ProjectProperties> PARSER = new AbstractParser<ProjectProperties>() { // from class: com.google.api.ProjectProperties.1
        @Override // com.google.protobuf.Parser
        public ProjectProperties parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProjectProperties(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int PROPERTIES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<Property> properties_;

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/ProjectProperties$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ProjectPropertiesOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> propertiesBuilder_;
        private List<Property> properties_;

        private Builder() {
            this.properties_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.properties_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensurePropertiesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.properties_ = new ArrayList(this.properties_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ConsumerProto.internal_static_google_api_ProjectProperties_descriptor;
        }

        private RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> getPropertiesFieldBuilder() {
            if (this.propertiesBuilder_ == null) {
                List<Property> list = this.properties_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.propertiesBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.properties_ = null;
            }
            return this.propertiesBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (ProjectProperties.alwaysUseFieldBuilders) {
                getPropertiesFieldBuilder();
            }
        }

        public Builder addAllProperties(Iterable<? extends Property> iterable) {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensurePropertiesIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.properties_);
            onChanged();
            return this;
        }

        public Builder addProperties(int i, Property.Builder builder) {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensurePropertiesIsMutable();
            this.properties_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addProperties(int i, Property property) {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, property);
                return this;
            } else if (property != null) {
                ensurePropertiesIsMutable();
                this.properties_.add(i, property);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addProperties(Property.Builder builder) {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensurePropertiesIsMutable();
            this.properties_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addProperties(Property property) {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(property);
                return this;
            } else if (property != null) {
                ensurePropertiesIsMutable();
                this.properties_.add(property);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Property.Builder addPropertiesBuilder() {
            return getPropertiesFieldBuilder().addBuilder(Property.getDefaultInstance());
        }

        public Property.Builder addPropertiesBuilder(int i) {
            return getPropertiesFieldBuilder().addBuilder(i, Property.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ProjectProperties build() {
            ProjectProperties buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ProjectProperties buildPartial() {
            ProjectProperties projectProperties = new ProjectProperties(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.properties_ = Collections.unmodifiableList(this.properties_);
                    this.bitField0_ &= -2;
                }
                projectProperties.properties_ = this.properties_;
            } else {
                projectProperties.properties_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return projectProperties;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.properties_ = Collections.emptyList();
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

        public Builder clearProperties() {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.properties_ = Collections.emptyList();
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
        public ProjectProperties getDefaultInstanceForType() {
            return ProjectProperties.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return ConsumerProto.internal_static_google_api_ProjectProperties_descriptor;
        }

        @Override // com.google.api.ProjectPropertiesOrBuilder
        public Property getProperties(int i) {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.properties_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Property.Builder getPropertiesBuilder(int i) {
            return getPropertiesFieldBuilder().getBuilder(i);
        }

        public List<Property.Builder> getPropertiesBuilderList() {
            return getPropertiesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ProjectPropertiesOrBuilder
        public int getPropertiesCount() {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.properties_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ProjectPropertiesOrBuilder
        public List<Property> getPropertiesList() {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.properties_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ProjectPropertiesOrBuilder
        public PropertyOrBuilder getPropertiesOrBuilder(int i) {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.properties_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.ProjectPropertiesOrBuilder
        public List<? extends PropertyOrBuilder> getPropertiesOrBuilderList() {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.properties_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ConsumerProto.internal_static_google_api_ProjectProperties_fieldAccessorTable.ensureFieldAccessorsInitialized(ProjectProperties.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ProjectProperties projectProperties) {
            if (projectProperties == ProjectProperties.getDefaultInstance()) {
                return this;
            }
            if (this.propertiesBuilder_ == null) {
                if (!projectProperties.properties_.isEmpty()) {
                    if (this.properties_.isEmpty()) {
                        this.properties_ = projectProperties.properties_;
                        this.bitField0_ &= -2;
                    } else {
                        ensurePropertiesIsMutable();
                        this.properties_.addAll(projectProperties.properties_);
                    }
                    onChanged();
                }
            } else if (!projectProperties.properties_.isEmpty()) {
                if (this.propertiesBuilder_.isEmpty()) {
                    this.propertiesBuilder_.dispose();
                    RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = null;
                    this.propertiesBuilder_ = null;
                    this.properties_ = projectProperties.properties_;
                    this.bitField0_ &= -2;
                    if (ProjectProperties.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getPropertiesFieldBuilder();
                    }
                    this.propertiesBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.propertiesBuilder_.addAllMessages(projectProperties.properties_);
                }
            }
            mergeUnknownFields(projectProperties.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.ProjectProperties.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.api.ProjectProperties.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.api.ProjectProperties r0 = (com.google.api.ProjectProperties) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.api.ProjectProperties$Builder r0 = r0.mergeFrom(r1)
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
                com.google.api.ProjectProperties r0 = (com.google.api.ProjectProperties) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.api.ProjectProperties$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.ProjectProperties.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.ProjectProperties$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ProjectProperties) {
                return mergeFrom((ProjectProperties) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeProperties(int i) {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensurePropertiesIsMutable();
            this.properties_.remove(i);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setProperties(int i, Property.Builder builder) {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensurePropertiesIsMutable();
            this.properties_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setProperties(int i, Property property) {
            RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, property);
                return this;
            } else if (property != null) {
                ensurePropertiesIsMutable();
                this.properties_.set(i, property);
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

    private ProjectProperties() {
        this.memoizedIsInitialized = (byte) -1;
        this.properties_ = Collections.emptyList();
    }

    private ProjectProperties(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.properties_ = new ArrayList();
                                    z4 = z2 | true;
                                }
                                this.properties_.add(codedInputStream.readMessage(Property.parser(), extensionRegistryLite));
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
                    this.properties_ = Collections.unmodifiableList(this.properties_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.properties_ = Collections.unmodifiableList(this.properties_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private ProjectProperties(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ProjectProperties getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return ConsumerProto.internal_static_google_api_ProjectProperties_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ProjectProperties projectProperties) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(projectProperties);
    }

    public static ProjectProperties parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ProjectProperties) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ProjectProperties parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ProjectProperties) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ProjectProperties parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ProjectProperties parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ProjectProperties parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ProjectProperties) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ProjectProperties parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ProjectProperties) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ProjectProperties parseFrom(InputStream inputStream) throws IOException {
        return (ProjectProperties) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ProjectProperties parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ProjectProperties) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ProjectProperties parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ProjectProperties parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ProjectProperties parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ProjectProperties parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ProjectProperties> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProjectProperties) {
            ProjectProperties projectProperties = (ProjectProperties) obj;
            return getPropertiesList().equals(projectProperties.getPropertiesList()) && this.unknownFields.equals(projectProperties.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ProjectProperties getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ProjectProperties> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.ProjectPropertiesOrBuilder
    public Property getProperties(int i) {
        return this.properties_.get(i);
    }

    @Override // com.google.api.ProjectPropertiesOrBuilder
    public int getPropertiesCount() {
        return this.properties_.size();
    }

    @Override // com.google.api.ProjectPropertiesOrBuilder
    public List<Property> getPropertiesList() {
        return this.properties_;
    }

    @Override // com.google.api.ProjectPropertiesOrBuilder
    public PropertyOrBuilder getPropertiesOrBuilder(int i) {
        return this.properties_.get(i);
    }

    @Override // com.google.api.ProjectPropertiesOrBuilder
    public List<? extends PropertyOrBuilder> getPropertiesOrBuilderList() {
        return this.properties_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.properties_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.properties_.get(i3));
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
        if (getPropertiesCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getPropertiesList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ConsumerProto.internal_static_google_api_ProjectProperties_fieldAccessorTable.ensureFieldAccessorsInitialized(ProjectProperties.class, Builder.class);
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
            if (i2 >= this.properties_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(1, this.properties_.get(i2));
                i = i2 + 1;
            }
        }
    }
}
