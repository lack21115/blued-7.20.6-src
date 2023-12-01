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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MedalExtra.class */
public final class MedalExtra extends GeneratedMessageV3 implements MedalExtraOrBuilder {
    public static final int BADGES_FIELD_NUMBER = 1;
    private static final MedalExtra DEFAULT_INSTANCE = new MedalExtra();
    private static final Parser<MedalExtra> PARSER = new AbstractParser<MedalExtra>() { // from class: cn.irisgw.live.MedalExtra.1
        @Override // com.google.protobuf.Parser
        public MedalExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new MedalExtra(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private List<Badge> badges_;
    private byte memoizedIsInitialized;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MedalExtra$Badge.class */
    public static final class Badge extends GeneratedMessageV3 implements BadgeOrBuilder {
        public static final int ID_FIELD_NUMBER = 1;
        public static final int URL_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object id_;
        private byte memoizedIsInitialized;
        private volatile Object url_;
        private static final Badge DEFAULT_INSTANCE = new Badge();
        private static final Parser<Badge> PARSER = new AbstractParser<Badge>() { // from class: cn.irisgw.live.MedalExtra.Badge.1
            @Override // com.google.protobuf.Parser
            public Badge parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Badge(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MedalExtra$Badge$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BadgeOrBuilder {
            private Object id_;
            private Object url_;

            private Builder() {
                this.id_ = "";
                this.url_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.id_ = "";
                this.url_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_MedalExtra_Badge_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Badge.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Badge build() {
                Badge buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Badge buildPartial() {
                Badge badge = new Badge(this);
                badge.id_ = this.id_;
                badge.url_ = this.url_;
                onBuilt();
                return badge;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.id_ = "";
                this.url_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearId() {
                this.id_ = Badge.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearUrl() {
                this.url_ = Badge.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Badge getDefaultInstanceForType() {
                return Badge.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_MedalExtra_Badge_descriptor;
            }

            @Override // cn.irisgw.live.MedalExtra.BadgeOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.id_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.MedalExtra.BadgeOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.MedalExtra.BadgeOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.MedalExtra.BadgeOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.url_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_MedalExtra_Badge_fieldAccessorTable.ensureFieldAccessorsInitialized(Badge.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Badge badge) {
                if (badge == Badge.getDefaultInstance()) {
                    return this;
                }
                if (!badge.getId().isEmpty()) {
                    this.id_ = badge.id_;
                    onChanged();
                }
                if (!badge.getUrl().isEmpty()) {
                    this.url_ = badge.url_;
                    onChanged();
                }
                mergeUnknownFields(badge.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.MedalExtra.Badge.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.MedalExtra.Badge.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.MedalExtra$Badge r0 = (cn.irisgw.live.MedalExtra.Badge) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.MedalExtra$Badge$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.MedalExtra$Badge r0 = (cn.irisgw.live.MedalExtra.Badge) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.MedalExtra$Badge$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.MedalExtra.Badge.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.MedalExtra$Badge$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Badge) {
                    return mergeFrom((Badge) message);
                }
                super.mergeFrom(message);
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

            public Builder setId(String str) {
                if (str != null) {
                    this.id_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdBytes(ByteString byteString) {
                if (byteString != null) {
                    Badge.checkByteStringIsUtf8(byteString);
                    this.id_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setUrl(String str) {
                if (str != null) {
                    this.url_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUrlBytes(ByteString byteString) {
                if (byteString != null) {
                    Badge.checkByteStringIsUtf8(byteString);
                    this.url_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }
        }

        private Badge() {
            this.memoizedIsInitialized = (byte) -1;
            this.id_ = "";
            this.url_ = "";
        }

        private Badge(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.id_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.url_ = codedInputStream.readStringRequireUtf8();
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
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private Badge(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Badge getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_MedalExtra_Badge_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Badge badge) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(badge);
        }

        public static Badge parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Badge) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Badge parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Badge) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Badge parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Badge parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Badge parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Badge) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Badge parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Badge) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Badge parseFrom(InputStream inputStream) throws IOException {
            return (Badge) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Badge parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Badge) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Badge parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Badge parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Badge parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Badge parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Badge> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Badge) {
                Badge badge = (Badge) obj;
                return getId().equals(badge.getId()) && getUrl().equals(badge.getUrl()) && this.unknownFields.equals(badge.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Badge getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.MedalExtra.BadgeOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.MedalExtra.BadgeOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Badge> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getIdBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.id_);
            }
            int i3 = i2;
            if (!getUrlBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.url_);
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.MedalExtra.BadgeOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.MedalExtra.BadgeOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getId().hashCode()) * 37) + 2) * 53) + getUrl().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_MedalExtra_Badge_fieldAccessorTable.ensureFieldAccessorsInitialized(Badge.class, Builder.class);
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

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Badge();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.id_);
            }
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.url_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MedalExtra$BadgeOrBuilder.class */
    public interface BadgeOrBuilder extends MessageOrBuilder {
        String getId();

        ByteString getIdBytes();

        String getUrl();

        ByteString getUrlBytes();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MedalExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MedalExtraOrBuilder {
        private RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> badgesBuilder_;
        private List<Badge> badges_;
        private int bitField0_;

        private Builder() {
            this.badges_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.badges_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureBadgesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.badges_ = new ArrayList(this.badges_);
                this.bitField0_ |= 1;
            }
        }

        private RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> getBadgesFieldBuilder() {
            if (this.badgesBuilder_ == null) {
                List<Badge> list = this.badges_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.badgesBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.badges_ = null;
            }
            return this.badgesBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_MedalExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            if (MedalExtra.alwaysUseFieldBuilders) {
                getBadgesFieldBuilder();
            }
        }

        public Builder addAllBadges(Iterable<? extends Badge> iterable) {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureBadgesIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.badges_);
            onChanged();
            return this;
        }

        public Builder addBadges(int i, Badge.Builder builder) {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureBadgesIsMutable();
            this.badges_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addBadges(int i, Badge badge) {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, badge);
                return this;
            } else if (badge != null) {
                ensureBadgesIsMutable();
                this.badges_.add(i, badge);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addBadges(Badge.Builder builder) {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureBadgesIsMutable();
            this.badges_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addBadges(Badge badge) {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(badge);
                return this;
            } else if (badge != null) {
                ensureBadgesIsMutable();
                this.badges_.add(badge);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Badge.Builder addBadgesBuilder() {
            return getBadgesFieldBuilder().addBuilder(Badge.getDefaultInstance());
        }

        public Badge.Builder addBadgesBuilder(int i) {
            return getBadgesFieldBuilder().addBuilder(i, Badge.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MedalExtra build() {
            MedalExtra buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MedalExtra buildPartial() {
            MedalExtra medalExtra = new MedalExtra(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.badges_ = Collections.unmodifiableList(this.badges_);
                    this.bitField0_ &= -2;
                }
                medalExtra.badges_ = this.badges_;
            } else {
                medalExtra.badges_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return medalExtra;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.badges_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        public Builder clearBadges() {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.badges_ = Collections.emptyList();
            this.bitField0_ &= -2;
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.MedalExtraOrBuilder
        public Badge getBadges(int i) {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.badges_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Badge.Builder getBadgesBuilder(int i) {
            return getBadgesFieldBuilder().getBuilder(i);
        }

        public List<Badge.Builder> getBadgesBuilderList() {
            return getBadgesFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.MedalExtraOrBuilder
        public int getBadgesCount() {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.badges_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.MedalExtraOrBuilder
        public List<Badge> getBadgesList() {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.badges_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.MedalExtraOrBuilder
        public BadgeOrBuilder getBadgesOrBuilder(int i) {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.badges_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.MedalExtraOrBuilder
        public List<? extends BadgeOrBuilder> getBadgesOrBuilderList() {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.badges_);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MedalExtra getDefaultInstanceForType() {
            return MedalExtra.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_MedalExtra_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_MedalExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalExtra.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(MedalExtra medalExtra) {
            if (medalExtra == MedalExtra.getDefaultInstance()) {
                return this;
            }
            if (this.badgesBuilder_ == null) {
                if (!medalExtra.badges_.isEmpty()) {
                    if (this.badges_.isEmpty()) {
                        this.badges_ = medalExtra.badges_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureBadgesIsMutable();
                        this.badges_.addAll(medalExtra.badges_);
                    }
                    onChanged();
                }
            } else if (!medalExtra.badges_.isEmpty()) {
                if (this.badgesBuilder_.isEmpty()) {
                    this.badgesBuilder_.dispose();
                    RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = null;
                    this.badgesBuilder_ = null;
                    this.badges_ = medalExtra.badges_;
                    this.bitField0_ &= -2;
                    if (MedalExtra.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getBadgesFieldBuilder();
                    }
                    this.badgesBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.badgesBuilder_.addAllMessages(medalExtra.badges_);
                }
            }
            mergeUnknownFields(medalExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.MedalExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.MedalExtra.access$1800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.MedalExtra r0 = (cn.irisgw.live.MedalExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.MedalExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.MedalExtra r0 = (cn.irisgw.live.MedalExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.MedalExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.MedalExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.MedalExtra$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof MedalExtra) {
                return mergeFrom((MedalExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeBadges(int i) {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureBadgesIsMutable();
            this.badges_.remove(i);
            onChanged();
            return this;
        }

        public Builder setBadges(int i, Badge.Builder builder) {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureBadgesIsMutable();
            this.badges_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setBadges(int i, Badge badge) {
            RepeatedFieldBuilderV3<Badge, Badge.Builder, BadgeOrBuilder> repeatedFieldBuilderV3 = this.badgesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, badge);
                return this;
            } else if (badge != null) {
                ensureBadgesIsMutable();
                this.badges_.set(i, badge);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
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

    private MedalExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.badges_ = Collections.emptyList();
    }

    private MedalExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.badges_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.badges_.add((Badge) codedInputStream.readMessage(Badge.parser(), extensionRegistryLite));
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
                    this.badges_ = Collections.unmodifiableList(this.badges_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.badges_ = Collections.unmodifiableList(this.badges_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private MedalExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MedalExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_MedalExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MedalExtra medalExtra) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(medalExtra);
    }

    public static MedalExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MedalExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static MedalExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MedalExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MedalExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static MedalExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static MedalExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MedalExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static MedalExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MedalExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static MedalExtra parseFrom(InputStream inputStream) throws IOException {
        return (MedalExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static MedalExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MedalExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MedalExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static MedalExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static MedalExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static MedalExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<MedalExtra> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MedalExtra) {
            MedalExtra medalExtra = (MedalExtra) obj;
            return getBadgesList().equals(medalExtra.getBadgesList()) && this.unknownFields.equals(medalExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.MedalExtraOrBuilder
    public Badge getBadges(int i) {
        return this.badges_.get(i);
    }

    @Override // cn.irisgw.live.MedalExtraOrBuilder
    public int getBadgesCount() {
        return this.badges_.size();
    }

    @Override // cn.irisgw.live.MedalExtraOrBuilder
    public List<Badge> getBadgesList() {
        return this.badges_;
    }

    @Override // cn.irisgw.live.MedalExtraOrBuilder
    public BadgeOrBuilder getBadgesOrBuilder(int i) {
        return this.badges_.get(i);
    }

    @Override // cn.irisgw.live.MedalExtraOrBuilder
    public List<? extends BadgeOrBuilder> getBadgesOrBuilderList() {
        return this.badges_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public MedalExtra getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MedalExtra> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.badges_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.badges_.get(i3));
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
        if (getBadgesCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getBadgesList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_MedalExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalExtra.class, Builder.class);
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

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new MedalExtra();
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
            if (i2 >= this.badges_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(1, this.badges_.get(i2));
                i = i2 + 1;
            }
        }
    }
}
