package com.google.api;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/QuotaLimit.class */
public final class QuotaLimit extends GeneratedMessageV3 implements QuotaLimitOrBuilder {
    public static final int DEFAULT_LIMIT_FIELD_NUMBER = 3;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 12;
    public static final int DURATION_FIELD_NUMBER = 5;
    public static final int FREE_TIER_FIELD_NUMBER = 7;
    public static final int MAX_LIMIT_FIELD_NUMBER = 4;
    public static final int METRIC_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 6;
    public static final int UNIT_FIELD_NUMBER = 9;
    public static final int VALUES_FIELD_NUMBER = 10;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private long defaultLimit_;
    private volatile Object description_;
    private volatile Object displayName_;
    private volatile Object duration_;
    private long freeTier_;
    private long maxLimit_;
    private byte memoizedIsInitialized;
    private volatile Object metric_;
    private volatile Object name_;
    private volatile Object unit_;
    private MapField<String, Long> values_;
    private static final QuotaLimit DEFAULT_INSTANCE = new QuotaLimit();
    private static final Parser<QuotaLimit> PARSER = new AbstractParser<QuotaLimit>() { // from class: com.google.api.QuotaLimit.1
        @Override // com.google.protobuf.Parser
        public QuotaLimit parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new QuotaLimit(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/QuotaLimit$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuotaLimitOrBuilder {
        private int bitField0_;
        private long defaultLimit_;
        private Object description_;
        private Object displayName_;
        private Object duration_;
        private long freeTier_;
        private long maxLimit_;
        private Object metric_;
        private Object name_;
        private Object unit_;
        private MapField<String, Long> values_;

        private Builder() {
            this.name_ = "";
            this.description_ = "";
            this.duration_ = "";
            this.metric_ = "";
            this.unit_ = "";
            this.displayName_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.description_ = "";
            this.duration_ = "";
            this.metric_ = "";
            this.unit_ = "";
            this.displayName_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QuotaProto.internal_static_google_api_QuotaLimit_descriptor;
        }

        private MapField<String, Long> internalGetMutableValues() {
            onChanged();
            if (this.values_ == null) {
                this.values_ = MapField.newMapField(ValuesDefaultEntryHolder.defaultEntry);
            }
            if (!this.values_.isMutable()) {
                this.values_ = this.values_.copy();
            }
            return this.values_;
        }

        private MapField<String, Long> internalGetValues() {
            MapField<String, Long> mapField = this.values_;
            MapField<String, Long> mapField2 = mapField;
            if (mapField == null) {
                mapField2 = MapField.emptyMapField(ValuesDefaultEntryHolder.defaultEntry);
            }
            return mapField2;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = QuotaLimit.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public QuotaLimit build() {
            QuotaLimit buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public QuotaLimit buildPartial() {
            QuotaLimit quotaLimit = new QuotaLimit(this);
            quotaLimit.name_ = this.name_;
            quotaLimit.description_ = this.description_;
            quotaLimit.defaultLimit_ = this.defaultLimit_;
            quotaLimit.maxLimit_ = this.maxLimit_;
            quotaLimit.freeTier_ = this.freeTier_;
            quotaLimit.duration_ = this.duration_;
            quotaLimit.metric_ = this.metric_;
            quotaLimit.unit_ = this.unit_;
            quotaLimit.values_ = internalGetValues();
            quotaLimit.values_.makeImmutable();
            quotaLimit.displayName_ = this.displayName_;
            quotaLimit.bitField0_ = 0;
            onBuilt();
            return quotaLimit;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.name_ = "";
            this.description_ = "";
            this.defaultLimit_ = 0L;
            this.maxLimit_ = 0L;
            this.freeTier_ = 0L;
            this.duration_ = "";
            this.metric_ = "";
            this.unit_ = "";
            internalGetMutableValues().clear();
            this.displayName_ = "";
            return this;
        }

        public Builder clearDefaultLimit() {
            this.defaultLimit_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearDescription() {
            this.description_ = QuotaLimit.getDefaultInstance().getDescription();
            onChanged();
            return this;
        }

        public Builder clearDisplayName() {
            this.displayName_ = QuotaLimit.getDefaultInstance().getDisplayName();
            onChanged();
            return this;
        }

        public Builder clearDuration() {
            this.duration_ = QuotaLimit.getDefaultInstance().getDuration();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearFreeTier() {
            this.freeTier_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearMaxLimit() {
            this.maxLimit_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearMetric() {
            this.metric_ = QuotaLimit.getDefaultInstance().getMetric();
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = QuotaLimit.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearUnit() {
            this.unit_ = QuotaLimit.getDefaultInstance().getUnit();
            onChanged();
            return this;
        }

        public Builder clearValues() {
            internalGetMutableValues().getMutableMap().clear();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2030clone() {
            return (Builder) super.mo2030clone();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public boolean containsValues(String str) {
            if (str != null) {
                return internalGetValues().getMap().containsKey(str);
            }
            throw null;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuotaLimit getDefaultInstanceForType() {
            return QuotaLimit.getDefaultInstance();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getDefaultLimit() {
            return this.defaultLimit_;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.description_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
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
            return QuotaProto.internal_static_google_api_QuotaLimit_descriptor;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getDisplayName() {
            Object obj = this.displayName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.displayName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getDisplayNameBytes() {
            Object obj = this.displayName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.displayName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getDuration() {
            Object obj = this.duration_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.duration_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getDurationBytes() {
            Object obj = this.duration_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.duration_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getFreeTier() {
            return this.freeTier_;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getMaxLimit() {
            return this.maxLimit_;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getMetric() {
            Object obj = this.metric_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.metric_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getMetricBytes() {
            Object obj = this.metric_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.metric_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Deprecated
        public Map<String, Long> getMutableValues() {
            return internalGetMutableValues().getMutableMap();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getUnit() {
            Object obj = this.unit_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.unit_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getUnitBytes() {
            Object obj = this.unit_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.unit_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        @Deprecated
        public Map<String, Long> getValues() {
            return getValuesMap();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public int getValuesCount() {
            return internalGetValues().getMap().size();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public Map<String, Long> getValuesMap() {
            return internalGetValues().getMap();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getValuesOrDefault(String str, long j) {
            if (str != null) {
                Map<String, Long> map = internalGetValues().getMap();
                if (map.containsKey(str)) {
                    j = map.get(str).longValue();
                }
                return j;
            }
            throw null;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getValuesOrThrow(String str) {
            if (str != null) {
                Map<String, Long> map = internalGetValues().getMap();
                if (map.containsKey(str)) {
                    return map.get(str).longValue();
                }
                throw new IllegalArgumentException();
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuotaProto.internal_static_google_api_QuotaLimit_fieldAccessorTable.ensureFieldAccessorsInitialized(QuotaLimit.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public MapField internalGetMapField(int i) {
            if (i == 10) {
                return internalGetValues();
            }
            throw new RuntimeException("Invalid map field number: " + i);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public MapField internalGetMutableMapField(int i) {
            if (i == 10) {
                return internalGetMutableValues();
            }
            throw new RuntimeException("Invalid map field number: " + i);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(QuotaLimit quotaLimit) {
            if (quotaLimit == QuotaLimit.getDefaultInstance()) {
                return this;
            }
            if (!quotaLimit.getName().isEmpty()) {
                this.name_ = quotaLimit.name_;
                onChanged();
            }
            if (!quotaLimit.getDescription().isEmpty()) {
                this.description_ = quotaLimit.description_;
                onChanged();
            }
            if (quotaLimit.getDefaultLimit() != 0) {
                setDefaultLimit(quotaLimit.getDefaultLimit());
            }
            if (quotaLimit.getMaxLimit() != 0) {
                setMaxLimit(quotaLimit.getMaxLimit());
            }
            if (quotaLimit.getFreeTier() != 0) {
                setFreeTier(quotaLimit.getFreeTier());
            }
            if (!quotaLimit.getDuration().isEmpty()) {
                this.duration_ = quotaLimit.duration_;
                onChanged();
            }
            if (!quotaLimit.getMetric().isEmpty()) {
                this.metric_ = quotaLimit.metric_;
                onChanged();
            }
            if (!quotaLimit.getUnit().isEmpty()) {
                this.unit_ = quotaLimit.unit_;
                onChanged();
            }
            internalGetMutableValues().mergeFrom(quotaLimit.internalGetValues());
            if (!quotaLimit.getDisplayName().isEmpty()) {
                this.displayName_ = quotaLimit.displayName_;
                onChanged();
            }
            mergeUnknownFields(quotaLimit.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.QuotaLimit.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.api.QuotaLimit.access$1700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.api.QuotaLimit r0 = (com.google.api.QuotaLimit) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.api.QuotaLimit$Builder r0 = r0.mergeFrom(r1)
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
                com.google.api.QuotaLimit r0 = (com.google.api.QuotaLimit) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.api.QuotaLimit$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.QuotaLimit.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.QuotaLimit$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof QuotaLimit) {
                return mergeFrom((QuotaLimit) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder putAllValues(Map<String, Long> map) {
            internalGetMutableValues().getMutableMap().putAll(map);
            return this;
        }

        public Builder putValues(String str, long j) {
            if (str != null) {
                internalGetMutableValues().getMutableMap().put(str, Long.valueOf(j));
                return this;
            }
            throw null;
        }

        public Builder removeValues(String str) {
            if (str != null) {
                internalGetMutableValues().getMutableMap().remove(str);
                return this;
            }
            throw null;
        }

        public Builder setDefaultLimit(long j) {
            this.defaultLimit_ = j;
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
                QuotaLimit.checkByteStringIsUtf8(byteString);
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
                QuotaLimit.checkByteStringIsUtf8(byteString);
                this.displayName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDuration(String str) {
            if (str != null) {
                this.duration_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDurationBytes(ByteString byteString) {
            if (byteString != null) {
                QuotaLimit.checkByteStringIsUtf8(byteString);
                this.duration_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setFreeTier(long j) {
            this.freeTier_ = j;
            onChanged();
            return this;
        }

        public Builder setMaxLimit(long j) {
            this.maxLimit_ = j;
            onChanged();
            return this;
        }

        public Builder setMetric(String str) {
            if (str != null) {
                this.metric_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setMetricBytes(ByteString byteString) {
            if (byteString != null) {
                QuotaLimit.checkByteStringIsUtf8(byteString);
                this.metric_ = byteString;
                onChanged();
                return this;
            }
            throw null;
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
                QuotaLimit.checkByteStringIsUtf8(byteString);
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
                QuotaLimit.checkByteStringIsUtf8(byteString);
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/api/QuotaLimit$ValuesDefaultEntryHolder.class */
    public static final class ValuesDefaultEntryHolder {
        static final MapEntry<String, Long> defaultEntry = MapEntry.newDefaultInstance(QuotaProto.internal_static_google_api_QuotaLimit_ValuesEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);

        private ValuesDefaultEntryHolder() {
        }
    }

    private QuotaLimit() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.description_ = "";
        this.duration_ = "";
        this.metric_ = "";
        this.unit_ = "";
        this.displayName_ = "";
    }

    /* JADX WARN: Type inference failed for: r1v30, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    private QuotaLimit(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw null;
        }
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 18:
                                this.description_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 24:
                                this.defaultLimit_ = codedInputStream.readInt64();
                                continue;
                            case 32:
                                this.maxLimit_ = codedInputStream.readInt64();
                                continue;
                            case 42:
                                this.duration_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 50:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 56:
                                this.freeTier_ = codedInputStream.readInt64();
                                continue;
                            case 66:
                                this.metric_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 74:
                                this.unit_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 82:
                                boolean z3 = z2;
                                if (!(z2 & true)) {
                                    this.values_ = MapField.newMapField(ValuesDefaultEntryHolder.defaultEntry);
                                    z3 = z2 | true;
                                }
                                MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(ValuesDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                this.values_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                                z2 = z3;
                                continue;
                            case 98:
                                this.displayName_ = codedInputStream.readStringRequireUtf8();
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

    private QuotaLimit(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static QuotaLimit getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return QuotaProto.internal_static_google_api_QuotaLimit_descriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MapField<String, Long> internalGetValues() {
        MapField<String, Long> mapField = this.values_;
        MapField<String, Long> mapField2 = mapField;
        if (mapField == null) {
            mapField2 = MapField.emptyMapField(ValuesDefaultEntryHolder.defaultEntry);
        }
        return mapField2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(QuotaLimit quotaLimit) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(quotaLimit);
    }

    public static QuotaLimit parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (QuotaLimit) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static QuotaLimit parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (QuotaLimit) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static QuotaLimit parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static QuotaLimit parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static QuotaLimit parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (QuotaLimit) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static QuotaLimit parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (QuotaLimit) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static QuotaLimit parseFrom(InputStream inputStream) throws IOException {
        return (QuotaLimit) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static QuotaLimit parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (QuotaLimit) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static QuotaLimit parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static QuotaLimit parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static QuotaLimit parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static QuotaLimit parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<QuotaLimit> parser() {
        return PARSER;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public boolean containsValues(String str) {
        if (str != null) {
            return internalGetValues().getMap().containsKey(str);
        }
        throw null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof QuotaLimit) {
            QuotaLimit quotaLimit = (QuotaLimit) obj;
            return getName().equals(quotaLimit.getName()) && getDescription().equals(quotaLimit.getDescription()) && getDefaultLimit() == quotaLimit.getDefaultLimit() && getMaxLimit() == quotaLimit.getMaxLimit() && getFreeTier() == quotaLimit.getFreeTier() && getDuration().equals(quotaLimit.getDuration()) && getMetric().equals(quotaLimit.getMetric()) && getUnit().equals(quotaLimit.getUnit()) && internalGetValues().equals(quotaLimit.internalGetValues()) && getDisplayName().equals(quotaLimit.getDisplayName()) && this.unknownFields.equals(quotaLimit.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public QuotaLimit getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getDefaultLimit() {
        return this.defaultLimit_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getDescription() {
        Object obj = this.description_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.description_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getDescriptionBytes() {
        Object obj = this.description_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.description_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getDisplayName() {
        Object obj = this.displayName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.displayName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getDisplayNameBytes() {
        Object obj = this.displayName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.displayName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getDuration() {
        Object obj = this.duration_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.duration_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getDurationBytes() {
        Object obj = this.duration_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.duration_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getFreeTier() {
        return this.freeTier_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getMaxLimit() {
        return this.maxLimit_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getMetric() {
        Object obj = this.metric_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.metric_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getMetricBytes() {
        Object obj = this.metric_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.metric_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
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
    public Parser<QuotaLimit> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = getDescriptionBytes().isEmpty() ? 0 : 0 + GeneratedMessageV3.computeStringSize(2, this.description_);
        long j = this.defaultLimit_;
        int i2 = computeStringSize;
        if (j != 0) {
            i2 = computeStringSize + CodedOutputStream.computeInt64Size(3, j);
        }
        long j2 = this.maxLimit_;
        int i3 = i2;
        if (j2 != 0) {
            i3 = i2 + CodedOutputStream.computeInt64Size(4, j2);
        }
        int i4 = i3;
        if (!getDurationBytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(5, this.duration_);
        }
        int i5 = i4;
        if (!getNameBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(6, this.name_);
        }
        long j3 = this.freeTier_;
        int i6 = i5;
        if (j3 != 0) {
            i6 = i5 + CodedOutputStream.computeInt64Size(7, j3);
        }
        int i7 = i6;
        if (!getMetricBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(8, this.metric_);
        }
        int i8 = i7;
        if (!getUnitBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(9, this.unit_);
        }
        for (Map.Entry<String, Long> entry : internalGetValues().getMap().entrySet()) {
            i8 += CodedOutputStream.computeMessageSize(10, ValuesDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
        int i9 = i8;
        if (!getDisplayNameBytes().isEmpty()) {
            i9 = i8 + GeneratedMessageV3.computeStringSize(12, this.displayName_);
        }
        int serializedSize = i9 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getUnit() {
        Object obj = this.unit_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.unit_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
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

    @Override // com.google.api.QuotaLimitOrBuilder
    @Deprecated
    public Map<String, Long> getValues() {
        return getValuesMap();
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public int getValuesCount() {
        return internalGetValues().getMap().size();
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public Map<String, Long> getValuesMap() {
        return internalGetValues().getMap();
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getValuesOrDefault(String str, long j) {
        if (str != null) {
            Map<String, Long> map = internalGetValues().getMap();
            if (map.containsKey(str)) {
                j = map.get(str).longValue();
            }
            return j;
        }
        throw null;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getValuesOrThrow(String str) {
        if (str != null) {
            Map<String, Long> map = internalGetValues().getMap();
            if (map.containsKey(str)) {
                return map.get(str).longValue();
            }
            throw new IllegalArgumentException();
        }
        throw null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 6) * 53) + getName().hashCode()) * 37) + 2) * 53) + getDescription().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getDefaultLimit())) * 37) + 4) * 53) + Internal.hashLong(getMaxLimit())) * 37) + 7) * 53) + Internal.hashLong(getFreeTier())) * 37) + 5) * 53) + getDuration().hashCode()) * 37) + 8) * 53) + getMetric().hashCode()) * 37) + 9) * 53) + getUnit().hashCode();
        int i = hashCode;
        if (!internalGetValues().getMap().isEmpty()) {
            i = (((hashCode * 37) + 10) * 53) + internalGetValues().hashCode();
        }
        int hashCode2 = (((((i * 37) + 12) * 53) + getDisplayName().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return QuotaProto.internal_static_google_api_QuotaLimit_fieldAccessorTable.ensureFieldAccessorsInitialized(QuotaLimit.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public MapField internalGetMapField(int i) {
        if (i == 10) {
            return internalGetValues();
        }
        throw new RuntimeException("Invalid map field number: " + i);
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
        if (!getDescriptionBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.description_);
        }
        long j = this.defaultLimit_;
        if (j != 0) {
            codedOutputStream.writeInt64(3, j);
        }
        long j2 = this.maxLimit_;
        if (j2 != 0) {
            codedOutputStream.writeInt64(4, j2);
        }
        if (!getDurationBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.duration_);
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.name_);
        }
        long j3 = this.freeTier_;
        if (j3 != 0) {
            codedOutputStream.writeInt64(7, j3);
        }
        if (!getMetricBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.metric_);
        }
        if (!getUnitBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.unit_);
        }
        GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetValues(), ValuesDefaultEntryHolder.defaultEntry, 10);
        if (!getDisplayNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 12, this.displayName_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
