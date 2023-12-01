package com.google.api;

import com.google.api.LabelDescriptor;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Duration;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/MetricDescriptor.class */
public final class MetricDescriptor extends GeneratedMessageV3 implements MetricDescriptorOrBuilder {
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 7;
    public static final int LABELS_FIELD_NUMBER = 2;
    public static final int LAUNCH_STAGE_FIELD_NUMBER = 12;
    public static final int METADATA_FIELD_NUMBER = 10;
    public static final int METRIC_KIND_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int TYPE_FIELD_NUMBER = 8;
    public static final int UNIT_FIELD_NUMBER = 5;
    public static final int VALUE_TYPE_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object description_;
    private volatile Object displayName_;
    private List<LabelDescriptor> labels_;
    private int launchStage_;
    private byte memoizedIsInitialized;
    private MetricDescriptorMetadata metadata_;
    private int metricKind_;
    private volatile Object name_;
    private volatile Object type_;
    private volatile Object unit_;
    private int valueType_;
    private static final MetricDescriptor DEFAULT_INSTANCE = new MetricDescriptor();
    private static final Parser<MetricDescriptor> PARSER = new AbstractParser<MetricDescriptor>() { // from class: com.google.api.MetricDescriptor.1
        @Override // com.google.protobuf.Parser
        public MetricDescriptor parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new MetricDescriptor(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/MetricDescriptor$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MetricDescriptorOrBuilder {
        private int bitField0_;
        private Object description_;
        private Object displayName_;
        private RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> labelsBuilder_;
        private List<LabelDescriptor> labels_;
        private int launchStage_;
        private SingleFieldBuilderV3<MetricDescriptorMetadata, MetricDescriptorMetadata.Builder, MetricDescriptorMetadataOrBuilder> metadataBuilder_;
        private MetricDescriptorMetadata metadata_;
        private int metricKind_;
        private Object name_;
        private Object type_;
        private Object unit_;
        private int valueType_;

        private Builder() {
            this.name_ = "";
            this.type_ = "";
            this.labels_ = Collections.emptyList();
            this.metricKind_ = 0;
            this.valueType_ = 0;
            this.unit_ = "";
            this.description_ = "";
            this.displayName_ = "";
            this.launchStage_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.type_ = "";
            this.labels_ = Collections.emptyList();
            this.metricKind_ = 0;
            this.valueType_ = 0;
            this.unit_ = "";
            this.description_ = "";
            this.displayName_ = "";
            this.launchStage_ = 0;
            maybeForceBuilderInitialization();
        }

        private void ensureLabelsIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.labels_ = new ArrayList(this.labels_);
                this.bitField0_ |= 4;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MetricProto.internal_static_google_api_MetricDescriptor_descriptor;
        }

        private RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> getLabelsFieldBuilder() {
            if (this.labelsBuilder_ == null) {
                this.labelsBuilder_ = new RepeatedFieldBuilderV3<>(this.labels_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                this.labels_ = null;
            }
            return this.labelsBuilder_;
        }

        private SingleFieldBuilderV3<MetricDescriptorMetadata, MetricDescriptorMetadata.Builder, MetricDescriptorMetadataOrBuilder> getMetadataFieldBuilder() {
            if (this.metadataBuilder_ == null) {
                this.metadataBuilder_ = new SingleFieldBuilderV3<>(getMetadata(), getParentForChildren(), isClean());
                this.metadata_ = null;
            }
            return this.metadataBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (MetricDescriptor.alwaysUseFieldBuilders) {
                getLabelsFieldBuilder();
            }
        }

        public Builder addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureLabelsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.labels_);
            onChanged();
            return this;
        }

        public Builder addLabels(int i, LabelDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureLabelsIsMutable();
            this.labels_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addLabels(int i, LabelDescriptor labelDescriptor) {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, labelDescriptor);
                return this;
            } else if (labelDescriptor != null) {
                ensureLabelsIsMutable();
                this.labels_.add(i, labelDescriptor);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addLabels(LabelDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureLabelsIsMutable();
            this.labels_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addLabels(LabelDescriptor labelDescriptor) {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(labelDescriptor);
                return this;
            } else if (labelDescriptor != null) {
                ensureLabelsIsMutable();
                this.labels_.add(labelDescriptor);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public LabelDescriptor.Builder addLabelsBuilder() {
            return getLabelsFieldBuilder().addBuilder(LabelDescriptor.getDefaultInstance());
        }

        public LabelDescriptor.Builder addLabelsBuilder(int i) {
            return getLabelsFieldBuilder().addBuilder(i, LabelDescriptor.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MetricDescriptor build() {
            MetricDescriptor buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MetricDescriptor buildPartial() {
            MetricDescriptor metricDescriptor = new MetricDescriptor(this);
            metricDescriptor.name_ = this.name_;
            metricDescriptor.type_ = this.type_;
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 4) != 0) {
                    this.labels_ = Collections.unmodifiableList(this.labels_);
                    this.bitField0_ &= -5;
                }
                metricDescriptor.labels_ = this.labels_;
            } else {
                metricDescriptor.labels_ = repeatedFieldBuilderV3.build();
            }
            metricDescriptor.metricKind_ = this.metricKind_;
            metricDescriptor.valueType_ = this.valueType_;
            metricDescriptor.unit_ = this.unit_;
            metricDescriptor.description_ = this.description_;
            metricDescriptor.displayName_ = this.displayName_;
            SingleFieldBuilderV3<MetricDescriptorMetadata, MetricDescriptorMetadata.Builder, MetricDescriptorMetadataOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                metricDescriptor.metadata_ = this.metadata_;
            } else {
                metricDescriptor.metadata_ = singleFieldBuilderV3.build();
            }
            metricDescriptor.launchStage_ = this.launchStage_;
            metricDescriptor.bitField0_ = 0;
            onBuilt();
            return metricDescriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.name_ = "";
            this.type_ = "";
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.labels_ = Collections.emptyList();
                this.bitField0_ &= -5;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.metricKind_ = 0;
            this.valueType_ = 0;
            this.unit_ = "";
            this.description_ = "";
            this.displayName_ = "";
            if (this.metadataBuilder_ == null) {
                this.metadata_ = null;
            } else {
                this.metadata_ = null;
                this.metadataBuilder_ = null;
            }
            this.launchStage_ = 0;
            return this;
        }

        public Builder clearDescription() {
            this.description_ = MetricDescriptor.getDefaultInstance().getDescription();
            onChanged();
            return this;
        }

        public Builder clearDisplayName() {
            this.displayName_ = MetricDescriptor.getDefaultInstance().getDisplayName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearLabels() {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.labels_ = Collections.emptyList();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearLaunchStage() {
            this.launchStage_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMetadata() {
            if (this.metadataBuilder_ == null) {
                this.metadata_ = null;
                onChanged();
                return this;
            }
            this.metadata_ = null;
            this.metadataBuilder_ = null;
            return this;
        }

        public Builder clearMetricKind() {
            this.metricKind_ = 0;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = MetricDescriptor.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearType() {
            this.type_ = MetricDescriptor.getDefaultInstance().getType();
            onChanged();
            return this;
        }

        public Builder clearUnit() {
            this.unit_ = MetricDescriptor.getDefaultInstance().getUnit();
            onChanged();
            return this;
        }

        public Builder clearValueType() {
            this.valueType_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MetricDescriptor getDefaultInstanceForType() {
            return MetricDescriptor.getDefaultInstance();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.description_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getDescriptionBytes() {
            Object obj = this.description_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.description_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return MetricProto.internal_static_google_api_MetricDescriptor_descriptor;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getDisplayName() {
            Object obj = this.displayName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.displayName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getDisplayNameBytes() {
            Object obj = this.displayName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.displayName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public LabelDescriptor getLabels(int i) {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.labels_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public LabelDescriptor.Builder getLabelsBuilder(int i) {
            return getLabelsFieldBuilder().getBuilder(i);
        }

        public List<LabelDescriptor.Builder> getLabelsBuilderList() {
            return getLabelsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getLabelsCount() {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.labels_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public List<LabelDescriptor> getLabelsList() {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.labels_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public LabelDescriptorOrBuilder getLabelsOrBuilder(int i) {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.labels_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.labels_);
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public LaunchStage getLaunchStage() {
            LaunchStage valueOf = LaunchStage.valueOf(this.launchStage_);
            LaunchStage launchStage = valueOf;
            if (valueOf == null) {
                launchStage = LaunchStage.UNRECOGNIZED;
            }
            return launchStage;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getLaunchStageValue() {
            return this.launchStage_;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public MetricDescriptorMetadata getMetadata() {
            SingleFieldBuilderV3<MetricDescriptorMetadata, MetricDescriptorMetadata.Builder, MetricDescriptorMetadataOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                MetricDescriptorMetadata metricDescriptorMetadata = this.metadata_;
                MetricDescriptorMetadata metricDescriptorMetadata2 = metricDescriptorMetadata;
                if (metricDescriptorMetadata == null) {
                    metricDescriptorMetadata2 = MetricDescriptorMetadata.getDefaultInstance();
                }
                return metricDescriptorMetadata2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public MetricDescriptorMetadata.Builder getMetadataBuilder() {
            onChanged();
            return getMetadataFieldBuilder().getBuilder();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public MetricDescriptorMetadataOrBuilder getMetadataOrBuilder() {
            SingleFieldBuilderV3<MetricDescriptorMetadata, MetricDescriptorMetadata.Builder, MetricDescriptorMetadataOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            MetricDescriptorMetadata metricDescriptorMetadata = this.metadata_;
            MetricDescriptorMetadata metricDescriptorMetadata2 = metricDescriptorMetadata;
            if (metricDescriptorMetadata == null) {
                metricDescriptorMetadata2 = MetricDescriptorMetadata.getDefaultInstance();
            }
            return metricDescriptorMetadata2;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public MetricKind getMetricKind() {
            MetricKind valueOf = MetricKind.valueOf(this.metricKind_);
            MetricKind metricKind = valueOf;
            if (valueOf == null) {
                metricKind = MetricKind.UNRECOGNIZED;
            }
            return metricKind;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getMetricKindValue() {
            return this.metricKind_;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getUnit() {
            Object obj = this.unit_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.unit_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getUnitBytes() {
            Object obj = this.unit_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.unit_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ValueType getValueType() {
            ValueType valueOf = ValueType.valueOf(this.valueType_);
            ValueType valueType = valueOf;
            if (valueOf == null) {
                valueType = ValueType.UNRECOGNIZED;
            }
            return valueType;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getValueTypeValue() {
            return this.valueType_;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public boolean hasMetadata() {
            return (this.metadataBuilder_ == null && this.metadata_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MetricProto.internal_static_google_api_MetricDescriptor_fieldAccessorTable.ensureFieldAccessorsInitialized(MetricDescriptor.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(MetricDescriptor metricDescriptor) {
            if (metricDescriptor == MetricDescriptor.getDefaultInstance()) {
                return this;
            }
            if (!metricDescriptor.getName().isEmpty()) {
                this.name_ = metricDescriptor.name_;
                onChanged();
            }
            if (!metricDescriptor.getType().isEmpty()) {
                this.type_ = metricDescriptor.type_;
                onChanged();
            }
            if (this.labelsBuilder_ == null) {
                if (!metricDescriptor.labels_.isEmpty()) {
                    if (this.labels_.isEmpty()) {
                        this.labels_ = metricDescriptor.labels_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureLabelsIsMutable();
                        this.labels_.addAll(metricDescriptor.labels_);
                    }
                    onChanged();
                }
            } else if (!metricDescriptor.labels_.isEmpty()) {
                if (this.labelsBuilder_.isEmpty()) {
                    this.labelsBuilder_.dispose();
                    RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = null;
                    this.labelsBuilder_ = null;
                    this.labels_ = metricDescriptor.labels_;
                    this.bitField0_ &= -5;
                    if (MetricDescriptor.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getLabelsFieldBuilder();
                    }
                    this.labelsBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.labelsBuilder_.addAllMessages(metricDescriptor.labels_);
                }
            }
            if (metricDescriptor.metricKind_ != 0) {
                setMetricKindValue(metricDescriptor.getMetricKindValue());
            }
            if (metricDescriptor.valueType_ != 0) {
                setValueTypeValue(metricDescriptor.getValueTypeValue());
            }
            if (!metricDescriptor.getUnit().isEmpty()) {
                this.unit_ = metricDescriptor.unit_;
                onChanged();
            }
            if (!metricDescriptor.getDescription().isEmpty()) {
                this.description_ = metricDescriptor.description_;
                onChanged();
            }
            if (!metricDescriptor.getDisplayName().isEmpty()) {
                this.displayName_ = metricDescriptor.displayName_;
                onChanged();
            }
            if (metricDescriptor.hasMetadata()) {
                mergeMetadata(metricDescriptor.getMetadata());
            }
            if (metricDescriptor.launchStage_ != 0) {
                setLaunchStageValue(metricDescriptor.getLaunchStageValue());
            }
            mergeUnknownFields(metricDescriptor.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.MetricDescriptor.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.api.MetricDescriptor.access$2700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.api.MetricDescriptor r0 = (com.google.api.MetricDescriptor) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.api.MetricDescriptor$Builder r0 = r0.mergeFrom(r1)
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
                com.google.api.MetricDescriptor r0 = (com.google.api.MetricDescriptor) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.api.MetricDescriptor$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.MetricDescriptor.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.MetricDescriptor$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof MetricDescriptor) {
                return mergeFrom((MetricDescriptor) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
            SingleFieldBuilderV3<MetricDescriptorMetadata, MetricDescriptorMetadata.Builder, MetricDescriptorMetadataOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(metricDescriptorMetadata);
                return this;
            }
            MetricDescriptorMetadata metricDescriptorMetadata2 = this.metadata_;
            if (metricDescriptorMetadata2 != null) {
                this.metadata_ = MetricDescriptorMetadata.newBuilder(metricDescriptorMetadata2).mergeFrom(metricDescriptorMetadata).buildPartial();
            } else {
                this.metadata_ = metricDescriptorMetadata;
            }
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeLabels(int i) {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureLabelsIsMutable();
            this.labels_.remove(i);
            onChanged();
            return this;
        }

        public Builder setDescription(String str) {
            if (str != null) {
                this.description_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            if (byteString != null) {
                MetricDescriptor.checkByteStringIsUtf8(byteString);
                this.description_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDisplayName(String str) {
            if (str != null) {
                this.displayName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDisplayNameBytes(ByteString byteString) {
            if (byteString != null) {
                MetricDescriptor.checkByteStringIsUtf8(byteString);
                this.displayName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setLabels(int i, LabelDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureLabelsIsMutable();
            this.labels_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setLabels(int i, LabelDescriptor labelDescriptor) {
            RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, labelDescriptor);
                return this;
            } else if (labelDescriptor != null) {
                ensureLabelsIsMutable();
                this.labels_.set(i, labelDescriptor);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setLaunchStage(LaunchStage launchStage) {
            if (launchStage != null) {
                this.launchStage_ = launchStage.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLaunchStageValue(int i) {
            this.launchStage_ = i;
            onChanged();
            return this;
        }

        public Builder setMetadata(MetricDescriptorMetadata.Builder builder) {
            SingleFieldBuilderV3<MetricDescriptorMetadata, MetricDescriptorMetadata.Builder, MetricDescriptorMetadataOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.metadata_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
            SingleFieldBuilderV3<MetricDescriptorMetadata, MetricDescriptorMetadata.Builder, MetricDescriptorMetadataOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(metricDescriptorMetadata);
                return this;
            } else if (metricDescriptorMetadata != null) {
                this.metadata_ = metricDescriptorMetadata;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setMetricKind(MetricKind metricKind) {
            if (metricKind != null) {
                this.metricKind_ = metricKind.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setMetricKindValue(int i) {
            this.metricKind_ = i;
            onChanged();
            return this;
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
                MetricDescriptor.checkByteStringIsUtf8(byteString);
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

        public Builder setType(String str) {
            if (str != null) {
                this.type_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTypeBytes(ByteString byteString) {
            if (byteString != null) {
                MetricDescriptor.checkByteStringIsUtf8(byteString);
                this.type_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setUnit(String str) {
            if (str != null) {
                this.unit_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setUnitBytes(ByteString byteString) {
            if (byteString != null) {
                MetricDescriptor.checkByteStringIsUtf8(byteString);
                this.unit_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setValueType(ValueType valueType) {
            if (valueType != null) {
                this.valueType_ = valueType.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setValueTypeValue(int i) {
            this.valueType_ = i;
            onChanged();
            return this;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/MetricDescriptor$MetricDescriptorMetadata.class */
    public static final class MetricDescriptorMetadata extends GeneratedMessageV3 implements MetricDescriptorMetadataOrBuilder {
        public static final int INGEST_DELAY_FIELD_NUMBER = 3;
        public static final int LAUNCH_STAGE_FIELD_NUMBER = 1;
        public static final int SAMPLE_PERIOD_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private Duration ingestDelay_;
        private int launchStage_;
        private byte memoizedIsInitialized;
        private Duration samplePeriod_;
        private static final MetricDescriptorMetadata DEFAULT_INSTANCE = new MetricDescriptorMetadata();
        private static final Parser<MetricDescriptorMetadata> PARSER = new AbstractParser<MetricDescriptorMetadata>() { // from class: com.google.api.MetricDescriptor.MetricDescriptorMetadata.1
            @Override // com.google.protobuf.Parser
            public MetricDescriptorMetadata parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MetricDescriptorMetadata(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-8110460-dex2jar.jar:com/google/api/MetricDescriptor$MetricDescriptorMetadata$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MetricDescriptorMetadataOrBuilder {
            private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> ingestDelayBuilder_;
            private Duration ingestDelay_;
            private int launchStage_;
            private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> samplePeriodBuilder_;
            private Duration samplePeriod_;

            private Builder() {
                this.launchStage_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.launchStage_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MetricProto.internal_static_google_api_MetricDescriptor_MetricDescriptorMetadata_descriptor;
            }

            private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> getIngestDelayFieldBuilder() {
                if (this.ingestDelayBuilder_ == null) {
                    this.ingestDelayBuilder_ = new SingleFieldBuilderV3<>(getIngestDelay(), getParentForChildren(), isClean());
                    this.ingestDelay_ = null;
                }
                return this.ingestDelayBuilder_;
            }

            private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> getSamplePeriodFieldBuilder() {
                if (this.samplePeriodBuilder_ == null) {
                    this.samplePeriodBuilder_ = new SingleFieldBuilderV3<>(getSamplePeriod(), getParentForChildren(), isClean());
                    this.samplePeriod_ = null;
                }
                return this.samplePeriodBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = MetricDescriptorMetadata.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MetricDescriptorMetadata build() {
                MetricDescriptorMetadata buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MetricDescriptorMetadata buildPartial() {
                MetricDescriptorMetadata metricDescriptorMetadata = new MetricDescriptorMetadata(this);
                metricDescriptorMetadata.launchStage_ = this.launchStage_;
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
                if (singleFieldBuilderV3 == null) {
                    metricDescriptorMetadata.samplePeriod_ = this.samplePeriod_;
                } else {
                    metricDescriptorMetadata.samplePeriod_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV32 = this.ingestDelayBuilder_;
                if (singleFieldBuilderV32 == null) {
                    metricDescriptorMetadata.ingestDelay_ = this.ingestDelay_;
                } else {
                    metricDescriptorMetadata.ingestDelay_ = singleFieldBuilderV32.build();
                }
                onBuilt();
                return metricDescriptorMetadata;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.launchStage_ = 0;
                if (this.samplePeriodBuilder_ == null) {
                    this.samplePeriod_ = null;
                } else {
                    this.samplePeriod_ = null;
                    this.samplePeriodBuilder_ = null;
                }
                if (this.ingestDelayBuilder_ == null) {
                    this.ingestDelay_ = null;
                    return this;
                }
                this.ingestDelay_ = null;
                this.ingestDelayBuilder_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearIngestDelay() {
                if (this.ingestDelayBuilder_ == null) {
                    this.ingestDelay_ = null;
                    onChanged();
                    return this;
                }
                this.ingestDelay_ = null;
                this.ingestDelayBuilder_ = null;
                return this;
            }

            @Deprecated
            public Builder clearLaunchStage() {
                this.launchStage_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearSamplePeriod() {
                if (this.samplePeriodBuilder_ == null) {
                    this.samplePeriod_ = null;
                    onChanged();
                    return this;
                }
                this.samplePeriod_ = null;
                this.samplePeriodBuilder_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MetricDescriptorMetadata getDefaultInstanceForType() {
                return MetricDescriptorMetadata.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MetricProto.internal_static_google_api_MetricDescriptor_MetricDescriptorMetadata_descriptor;
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public Duration getIngestDelay() {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Duration duration = this.ingestDelay_;
                    Duration duration2 = duration;
                    if (duration == null) {
                        duration2 = Duration.getDefaultInstance();
                    }
                    return duration2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Duration.Builder getIngestDelayBuilder() {
                onChanged();
                return getIngestDelayFieldBuilder().getBuilder();
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public DurationOrBuilder getIngestDelayOrBuilder() {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Duration duration = this.ingestDelay_;
                Duration duration2 = duration;
                if (duration == null) {
                    duration2 = Duration.getDefaultInstance();
                }
                return duration2;
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            @Deprecated
            public LaunchStage getLaunchStage() {
                LaunchStage valueOf = LaunchStage.valueOf(this.launchStage_);
                LaunchStage launchStage = valueOf;
                if (valueOf == null) {
                    launchStage = LaunchStage.UNRECOGNIZED;
                }
                return launchStage;
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            @Deprecated
            public int getLaunchStageValue() {
                return this.launchStage_;
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public Duration getSamplePeriod() {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Duration duration = this.samplePeriod_;
                    Duration duration2 = duration;
                    if (duration == null) {
                        duration2 = Duration.getDefaultInstance();
                    }
                    return duration2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Duration.Builder getSamplePeriodBuilder() {
                onChanged();
                return getSamplePeriodFieldBuilder().getBuilder();
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public DurationOrBuilder getSamplePeriodOrBuilder() {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Duration duration = this.samplePeriod_;
                Duration duration2 = duration;
                if (duration == null) {
                    duration2 = Duration.getDefaultInstance();
                }
                return duration2;
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public boolean hasIngestDelay() {
                return (this.ingestDelayBuilder_ == null && this.ingestDelay_ == null) ? false : true;
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public boolean hasSamplePeriod() {
                return (this.samplePeriodBuilder_ == null && this.samplePeriod_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MetricProto.internal_static_google_api_MetricDescriptor_MetricDescriptorMetadata_fieldAccessorTable.ensureFieldAccessorsInitialized(MetricDescriptorMetadata.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(MetricDescriptorMetadata metricDescriptorMetadata) {
                if (metricDescriptorMetadata == MetricDescriptorMetadata.getDefaultInstance()) {
                    return this;
                }
                if (metricDescriptorMetadata.launchStage_ != 0) {
                    setLaunchStageValue(metricDescriptorMetadata.getLaunchStageValue());
                }
                if (metricDescriptorMetadata.hasSamplePeriod()) {
                    mergeSamplePeriod(metricDescriptorMetadata.getSamplePeriod());
                }
                if (metricDescriptorMetadata.hasIngestDelay()) {
                    mergeIngestDelay(metricDescriptorMetadata.getIngestDelay());
                }
                mergeUnknownFields(metricDescriptorMetadata.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.api.MetricDescriptor.MetricDescriptorMetadata.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.google.api.MetricDescriptor.MetricDescriptorMetadata.access$800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.google.api.MetricDescriptor$MetricDescriptorMetadata r0 = (com.google.api.MetricDescriptor.MetricDescriptorMetadata) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.google.api.MetricDescriptor$MetricDescriptorMetadata$Builder r0 = r0.mergeFrom(r1)
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
                    com.google.api.MetricDescriptor$MetricDescriptorMetadata r0 = (com.google.api.MetricDescriptor.MetricDescriptorMetadata) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.google.api.MetricDescriptor$MetricDescriptorMetadata$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.api.MetricDescriptor.MetricDescriptorMetadata.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.MetricDescriptor$MetricDescriptorMetadata$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof MetricDescriptorMetadata) {
                    return mergeFrom((MetricDescriptorMetadata) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeIngestDelay(Duration duration) {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(duration);
                    return this;
                }
                Duration duration2 = this.ingestDelay_;
                if (duration2 != null) {
                    this.ingestDelay_ = Duration.newBuilder(duration2).mergeFrom(duration).buildPartial();
                } else {
                    this.ingestDelay_ = duration;
                }
                onChanged();
                return this;
            }

            public Builder mergeSamplePeriod(Duration duration) {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(duration);
                    return this;
                }
                Duration duration2 = this.samplePeriod_;
                if (duration2 != null) {
                    this.samplePeriod_ = Duration.newBuilder(duration2).mergeFrom(duration).buildPartial();
                } else {
                    this.samplePeriod_ = duration;
                }
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setIngestDelay(Duration.Builder builder) {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.ingestDelay_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setIngestDelay(Duration duration) {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(duration);
                    return this;
                } else if (duration != null) {
                    this.ingestDelay_ = duration;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            @Deprecated
            public Builder setLaunchStage(LaunchStage launchStage) {
                if (launchStage != null) {
                    this.launchStage_ = launchStage.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Deprecated
            public Builder setLaunchStageValue(int i) {
                this.launchStage_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setSamplePeriod(Duration.Builder builder) {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.samplePeriod_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setSamplePeriod(Duration duration) {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(duration);
                    return this;
                } else if (duration != null) {
                    this.samplePeriod_ = duration;
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

        private MetricDescriptorMetadata() {
            this.memoizedIsInitialized = (byte) -1;
            this.launchStage_ = 0;
        }

        private MetricDescriptorMetadata(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 8) {
                                    this.launchStage_ = codedInputStream.readEnum();
                                } else if (readTag == 18) {
                                    Duration.Builder builder = this.samplePeriod_ != null ? this.samplePeriod_.toBuilder() : null;
                                    Duration duration = (Duration) codedInputStream.readMessage(Duration.parser(), extensionRegistryLite);
                                    this.samplePeriod_ = duration;
                                    if (builder != null) {
                                        builder.mergeFrom(duration);
                                        this.samplePeriod_ = builder.buildPartial();
                                    }
                                } else if (readTag == 26) {
                                    Duration.Builder builder2 = this.ingestDelay_ != null ? this.ingestDelay_.toBuilder() : null;
                                    Duration duration2 = (Duration) codedInputStream.readMessage(Duration.parser(), extensionRegistryLite);
                                    this.ingestDelay_ = duration2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(duration2);
                                        this.ingestDelay_ = builder2.buildPartial();
                                    }
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

        private MetricDescriptorMetadata(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MetricDescriptorMetadata getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MetricProto.internal_static_google_api_MetricDescriptor_MetricDescriptorMetadata_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MetricDescriptorMetadata metricDescriptorMetadata) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(metricDescriptorMetadata);
        }

        public static MetricDescriptorMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MetricDescriptorMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static MetricDescriptorMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static MetricDescriptorMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(InputStream inputStream) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MetricDescriptorMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static MetricDescriptorMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static MetricDescriptorMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<MetricDescriptorMetadata> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof MetricDescriptorMetadata) {
                MetricDescriptorMetadata metricDescriptorMetadata = (MetricDescriptorMetadata) obj;
                if (this.launchStage_ == metricDescriptorMetadata.launchStage_ && hasSamplePeriod() == metricDescriptorMetadata.hasSamplePeriod()) {
                    if ((!hasSamplePeriod() || getSamplePeriod().equals(metricDescriptorMetadata.getSamplePeriod())) && hasIngestDelay() == metricDescriptorMetadata.hasIngestDelay()) {
                        return (!hasIngestDelay() || getIngestDelay().equals(metricDescriptorMetadata.getIngestDelay())) && this.unknownFields.equals(metricDescriptorMetadata.unknownFields);
                    }
                    return false;
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MetricDescriptorMetadata getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public Duration getIngestDelay() {
            Duration duration = this.ingestDelay_;
            Duration duration2 = duration;
            if (duration == null) {
                duration2 = Duration.getDefaultInstance();
            }
            return duration2;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public DurationOrBuilder getIngestDelayOrBuilder() {
            return getIngestDelay();
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        @Deprecated
        public LaunchStage getLaunchStage() {
            LaunchStage valueOf = LaunchStage.valueOf(this.launchStage_);
            LaunchStage launchStage = valueOf;
            if (valueOf == null) {
                launchStage = LaunchStage.UNRECOGNIZED;
            }
            return launchStage;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        @Deprecated
        public int getLaunchStageValue() {
            return this.launchStage_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MetricDescriptorMetadata> getParserForType() {
            return PARSER;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public Duration getSamplePeriod() {
            Duration duration = this.samplePeriod_;
            Duration duration2 = duration;
            if (duration == null) {
                duration2 = Duration.getDefaultInstance();
            }
            return duration2;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public DurationOrBuilder getSamplePeriodOrBuilder() {
            return getSamplePeriod();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.launchStage_ != LaunchStage.LAUNCH_STAGE_UNSPECIFIED.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.launchStage_);
            }
            int i3 = i2;
            if (this.samplePeriod_ != null) {
                i3 = i2 + CodedOutputStream.computeMessageSize(2, getSamplePeriod());
            }
            int i4 = i3;
            if (this.ingestDelay_ != null) {
                i4 = i3 + CodedOutputStream.computeMessageSize(3, getIngestDelay());
            }
            int serializedSize = i4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public boolean hasIngestDelay() {
            return this.ingestDelay_ != null;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public boolean hasSamplePeriod() {
            return this.samplePeriod_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.launchStage_;
            int i = hashCode;
            if (hasSamplePeriod()) {
                i = (((hashCode * 37) + 2) * 53) + getSamplePeriod().hashCode();
            }
            int i2 = i;
            if (hasIngestDelay()) {
                i2 = (((i * 37) + 3) * 53) + getIngestDelay().hashCode();
            }
            int hashCode2 = (i2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MetricProto.internal_static_google_api_MetricDescriptor_MetricDescriptorMetadata_fieldAccessorTable.ensureFieldAccessorsInitialized(MetricDescriptorMetadata.class, Builder.class);
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
            if (this.launchStage_ != LaunchStage.LAUNCH_STAGE_UNSPECIFIED.getNumber()) {
                codedOutputStream.writeEnum(1, this.launchStage_);
            }
            if (this.samplePeriod_ != null) {
                codedOutputStream.writeMessage(2, getSamplePeriod());
            }
            if (this.ingestDelay_ != null) {
                codedOutputStream.writeMessage(3, getIngestDelay());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/MetricDescriptor$MetricDescriptorMetadataOrBuilder.class */
    public interface MetricDescriptorMetadataOrBuilder extends MessageOrBuilder {
        Duration getIngestDelay();

        DurationOrBuilder getIngestDelayOrBuilder();

        @Deprecated
        LaunchStage getLaunchStage();

        @Deprecated
        int getLaunchStageValue();

        Duration getSamplePeriod();

        DurationOrBuilder getSamplePeriodOrBuilder();

        boolean hasIngestDelay();

        boolean hasSamplePeriod();
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/MetricDescriptor$MetricKind.class */
    public enum MetricKind implements ProtocolMessageEnum {
        METRIC_KIND_UNSPECIFIED(0),
        GAUGE(1),
        DELTA(2),
        CUMULATIVE(3),
        UNRECOGNIZED(-1);
        
        public static final int CUMULATIVE_VALUE = 3;
        public static final int DELTA_VALUE = 2;
        public static final int GAUGE_VALUE = 1;
        public static final int METRIC_KIND_UNSPECIFIED_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<MetricKind> internalValueMap = new Internal.EnumLiteMap<MetricKind>() { // from class: com.google.api.MetricDescriptor.MetricKind.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MetricKind findValueByNumber(int i) {
                return MetricKind.forNumber(i);
            }
        };
        private static final MetricKind[] VALUES = values();

        MetricKind(int i) {
            this.value = i;
        }

        public static MetricKind forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return CUMULATIVE;
                    }
                    return DELTA;
                }
                return GAUGE;
            }
            return METRIC_KIND_UNSPECIFIED;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return MetricDescriptor.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<MetricKind> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static MetricKind valueOf(int i) {
            return forNumber(i);
        }

        public static MetricKind valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/MetricDescriptor$ValueType.class */
    public enum ValueType implements ProtocolMessageEnum {
        VALUE_TYPE_UNSPECIFIED(0),
        BOOL(1),
        INT64(2),
        DOUBLE(3),
        STRING(4),
        DISTRIBUTION(5),
        MONEY(6),
        UNRECOGNIZED(-1);
        
        public static final int BOOL_VALUE = 1;
        public static final int DISTRIBUTION_VALUE = 5;
        public static final int DOUBLE_VALUE = 3;
        public static final int INT64_VALUE = 2;
        public static final int MONEY_VALUE = 6;
        public static final int STRING_VALUE = 4;
        public static final int VALUE_TYPE_UNSPECIFIED_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<ValueType> internalValueMap = new Internal.EnumLiteMap<ValueType>() { // from class: com.google.api.MetricDescriptor.ValueType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ValueType findValueByNumber(int i) {
                return ValueType.forNumber(i);
            }
        };
        private static final ValueType[] VALUES = values();

        ValueType(int i) {
            this.value = i;
        }

        public static ValueType forNumber(int i) {
            switch (i) {
                case 0:
                    return VALUE_TYPE_UNSPECIFIED;
                case 1:
                    return BOOL;
                case 2:
                    return INT64;
                case 3:
                    return DOUBLE;
                case 4:
                    return STRING;
                case 5:
                    return DISTRIBUTION;
                case 6:
                    return MONEY;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return MetricDescriptor.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<ValueType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ValueType valueOf(int i) {
            return forNumber(i);
        }

        public static ValueType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }
    }

    private MetricDescriptor() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.type_ = "";
        this.labels_ = Collections.emptyList();
        this.metricKind_ = 0;
        this.valueType_ = 0;
        this.unit_ = "";
        this.description_ = "";
        this.displayName_ = "";
        this.launchStage_ = 0;
    }

    private MetricDescriptor(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        MetricDescriptorMetadata.Builder builder;
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
                            this.name_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 18:
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.labels_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.labels_.add(codedInputStream.readMessage(LabelDescriptor.parser(), extensionRegistryLite));
                            z2 = z4;
                            continue;
                        case 24:
                            this.metricKind_ = codedInputStream.readEnum();
                            continue;
                        case 32:
                            this.valueType_ = codedInputStream.readEnum();
                            continue;
                        case 42:
                            this.unit_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 50:
                            this.description_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 58:
                            this.displayName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 66:
                            this.type_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 82:
                            if (this.metadata_ != null) {
                                boolean z5 = z2;
                                builder = this.metadata_.toBuilder();
                            } else {
                                builder = null;
                            }
                            MetricDescriptorMetadata metricDescriptorMetadata = (MetricDescriptorMetadata) codedInputStream.readMessage(MetricDescriptorMetadata.parser(), extensionRegistryLite);
                            boolean z6 = z2;
                            this.metadata_ = metricDescriptorMetadata;
                            if (builder != null) {
                                builder.mergeFrom(metricDescriptorMetadata);
                                boolean z7 = z2;
                                this.metadata_ = builder.buildPartial();
                            } else {
                                continue;
                            }
                        case 96:
                            this.launchStage_ = codedInputStream.readEnum();
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
                    this.labels_ = Collections.unmodifiableList(this.labels_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.labels_ = Collections.unmodifiableList(this.labels_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private MetricDescriptor(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MetricDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return MetricProto.internal_static_google_api_MetricDescriptor_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MetricDescriptor metricDescriptor) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(metricDescriptor);
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MetricDescriptor) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static MetricDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MetricDescriptor) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static MetricDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(InputStream inputStream) throws IOException {
        return (MetricDescriptor) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static MetricDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static MetricDescriptor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static MetricDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<MetricDescriptor> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MetricDescriptor) {
            MetricDescriptor metricDescriptor = (MetricDescriptor) obj;
            if (getName().equals(metricDescriptor.getName()) && getType().equals(metricDescriptor.getType()) && getLabelsList().equals(metricDescriptor.getLabelsList()) && this.metricKind_ == metricDescriptor.metricKind_ && this.valueType_ == metricDescriptor.valueType_ && getUnit().equals(metricDescriptor.getUnit()) && getDescription().equals(metricDescriptor.getDescription()) && getDisplayName().equals(metricDescriptor.getDisplayName()) && hasMetadata() == metricDescriptor.hasMetadata()) {
                return (!hasMetadata() || getMetadata().equals(metricDescriptor.getMetadata())) && this.launchStage_ == metricDescriptor.launchStage_ && this.unknownFields.equals(metricDescriptor.unknownFields);
            }
            return false;
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public MetricDescriptor getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getDescription() {
        Object obj = this.description_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.description_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getDescriptionBytes() {
        Object obj = this.description_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.description_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getDisplayName() {
        Object obj = this.displayName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.displayName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getDisplayNameBytes() {
        Object obj = this.displayName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.displayName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public LabelDescriptor getLabels(int i) {
        return this.labels_.get(i);
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getLabelsCount() {
        return this.labels_.size();
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public List<LabelDescriptor> getLabelsList() {
        return this.labels_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public LabelDescriptorOrBuilder getLabelsOrBuilder(int i) {
        return this.labels_.get(i);
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
        return this.labels_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public LaunchStage getLaunchStage() {
        LaunchStage valueOf = LaunchStage.valueOf(this.launchStage_);
        LaunchStage launchStage = valueOf;
        if (valueOf == null) {
            launchStage = LaunchStage.UNRECOGNIZED;
        }
        return launchStage;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getLaunchStageValue() {
        return this.launchStage_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public MetricDescriptorMetadata getMetadata() {
        MetricDescriptorMetadata metricDescriptorMetadata = this.metadata_;
        MetricDescriptorMetadata metricDescriptorMetadata2 = metricDescriptorMetadata;
        if (metricDescriptorMetadata == null) {
            metricDescriptorMetadata2 = MetricDescriptorMetadata.getDefaultInstance();
        }
        return metricDescriptorMetadata2;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public MetricDescriptorMetadataOrBuilder getMetadataOrBuilder() {
        return getMetadata();
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public MetricKind getMetricKind() {
        MetricKind valueOf = MetricKind.valueOf(this.metricKind_);
        MetricKind metricKind = valueOf;
        if (valueOf == null) {
            metricKind = MetricKind.UNRECOGNIZED;
        }
        return metricKind;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getMetricKindValue() {
        return this.metricKind_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
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
    public Parser<MetricDescriptor> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !getNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
        for (int i2 = 0; i2 < this.labels_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, this.labels_.get(i2));
        }
        int i3 = computeStringSize;
        if (this.metricKind_ != MetricKind.METRIC_KIND_UNSPECIFIED.getNumber()) {
            i3 = computeStringSize + CodedOutputStream.computeEnumSize(3, this.metricKind_);
        }
        int i4 = i3;
        if (this.valueType_ != ValueType.VALUE_TYPE_UNSPECIFIED.getNumber()) {
            i4 = i3 + CodedOutputStream.computeEnumSize(4, this.valueType_);
        }
        int i5 = i4;
        if (!getUnitBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(5, this.unit_);
        }
        int i6 = i5;
        if (!getDescriptionBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(6, this.description_);
        }
        int i7 = i6;
        if (!getDisplayNameBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(7, this.displayName_);
        }
        int i8 = i7;
        if (!getTypeBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(8, this.type_);
        }
        int i9 = i8;
        if (this.metadata_ != null) {
            i9 = i8 + CodedOutputStream.computeMessageSize(10, getMetadata());
        }
        int i10 = i9;
        if (this.launchStage_ != LaunchStage.LAUNCH_STAGE_UNSPECIFIED.getNumber()) {
            i10 = i9 + CodedOutputStream.computeEnumSize(12, this.launchStage_);
        }
        int serializedSize = i10 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getType() {
        Object obj = this.type_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.type_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getTypeBytes() {
        Object obj = this.type_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.type_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getUnit() {
        Object obj = this.unit_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.unit_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getUnitBytes() {
        Object obj = this.unit_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.unit_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ValueType getValueType() {
        ValueType valueOf = ValueType.valueOf(this.valueType_);
        ValueType valueType = valueOf;
        if (valueOf == null) {
            valueType = ValueType.UNRECOGNIZED;
        }
        return valueType;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getValueTypeValue() {
        return this.valueType_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public boolean hasMetadata() {
        return this.metadata_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 8) * 53) + getType().hashCode();
        int i = hashCode;
        if (getLabelsCount() > 0) {
            i = (((hashCode * 37) + 2) * 53) + getLabelsList().hashCode();
        }
        int hashCode2 = (((((((((((((((((((i * 37) + 3) * 53) + this.metricKind_) * 37) + 4) * 53) + this.valueType_) * 37) + 5) * 53) + getUnit().hashCode()) * 37) + 6) * 53) + getDescription().hashCode()) * 37) + 7) * 53) + getDisplayName().hashCode();
        int i2 = hashCode2;
        if (hasMetadata()) {
            i2 = (((hashCode2 * 37) + 10) * 53) + getMetadata().hashCode();
        }
        int hashCode3 = (((((i2 * 37) + 12) * 53) + this.launchStage_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode3;
        return hashCode3;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return MetricProto.internal_static_google_api_MetricDescriptor_fieldAccessorTable.ensureFieldAccessorsInitialized(MetricDescriptor.class, Builder.class);
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
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.labels_.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, this.labels_.get(i2));
            i = i2 + 1;
        }
        if (this.metricKind_ != MetricKind.METRIC_KIND_UNSPECIFIED.getNumber()) {
            codedOutputStream.writeEnum(3, this.metricKind_);
        }
        if (this.valueType_ != ValueType.VALUE_TYPE_UNSPECIFIED.getNumber()) {
            codedOutputStream.writeEnum(4, this.valueType_);
        }
        if (!getUnitBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.unit_);
        }
        if (!getDescriptionBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.description_);
        }
        if (!getDisplayNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.displayName_);
        }
        if (!getTypeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.type_);
        }
        if (this.metadata_ != null) {
            codedOutputStream.writeMessage(10, getMetadata());
        }
        if (this.launchStage_ != LaunchStage.LAUNCH_STAGE_UNSPECIFIED.getNumber()) {
            codedOutputStream.writeEnum(12, this.launchStage_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
