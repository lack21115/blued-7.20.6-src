package cn.irisgw.live;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.AnyProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnect.class */
public final class LiveConnect {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011liveConnect.proto\u0012\u000ecn.irisgw.live\u001a\u0019google/protobuf/any.proto\"[\n\u000fLiveBasePackage\u0012\u0012\n\npackage_id\u0018\u0001 \u0001(\u0004\u0012\u0010\n\bneed_ack\u0018\u0002 \u0001(\b\u0012\"\n\u0004body\u0018\u0003 \u0001(\u000b2\u0014.google.protobuf.Any\"(\n\u0012LiveBasePackageAck\u0012\u0012\n\npackage_id\u0018\u0001 \u0001(\u0004\"{\n\u000bLiveSetting\u0012\u0013\n\u000bapp_version\u0018\u0001 \u0001(\t\u0012\u0010\n\bplatform\u0018\u0002 \u0001(\t\u0012\u0010\n\blanguage\u0018\u0003 \u0001(\t\u0012\u0012\n\nos_version\u0018\u0004 \u0001(\t\u0012\u000e\n\u0006device\u0018\u0005 \u0001(\t\u0012\u000f\n\u0007channel\u0018\u0006 \u0001(\t2L\n\rLiveConnector\u0012;\n\u0007Connect\u0012\u0014.google.protobuf.Any\u001a\u0014.google.protobuf.Any\"��(\u00010\u0001b\u0006proto3"}, new Descriptors.FileDescriptor[]{AnyProto.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveBasePackageAck_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveBasePackageAck_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveBasePackage_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveBasePackage_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveSetting_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveSetting_fieldAccessorTable;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnect$LiveBasePackage.class */
    public static final class LiveBasePackage extends GeneratedMessageV3 implements LiveBasePackageOrBuilder {
        public static final int BODY_FIELD_NUMBER = 3;
        public static final int NEED_ACK_FIELD_NUMBER = 2;
        public static final int PACKAGE_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private Any body_;
        private byte memoizedIsInitialized;
        private boolean needAck_;
        private long packageId_;
        private static final LiveBasePackage DEFAULT_INSTANCE = new LiveBasePackage();
        private static final Parser<LiveBasePackage> PARSER = new AbstractParser<LiveBasePackage>() { // from class: cn.irisgw.live.LiveConnect.LiveBasePackage.1
            /* renamed from: parsePartialFrom */
            public LiveBasePackage m4664parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LiveBasePackage(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnect$LiveBasePackage$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveBasePackageOrBuilder {
            private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> bodyBuilder_;
            private Any body_;
            private boolean needAck_;
            private long packageId_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getBodyFieldBuilder() {
                if (this.bodyBuilder_ == null) {
                    this.bodyBuilder_ = new SingleFieldBuilderV3<>(getBody(), getParentForChildren(), isClean());
                    this.body_ = null;
                }
                return this.bodyBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackage_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LiveBasePackage.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m4666addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public LiveBasePackage m4668build() {
                LiveBasePackage m4670buildPartial = m4670buildPartial();
                if (m4670buildPartial.isInitialized()) {
                    return m4670buildPartial;
                }
                throw newUninitializedMessageException(m4670buildPartial);
            }

            /* renamed from: buildPartial */
            public LiveBasePackage m4670buildPartial() {
                LiveBasePackage liveBasePackage = new LiveBasePackage(this);
                liveBasePackage.packageId_ = this.packageId_;
                liveBasePackage.needAck_ = this.needAck_;
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    liveBasePackage.body_ = this.body_;
                } else {
                    liveBasePackage.body_ = singleFieldBuilderV3.build();
                }
                onBuilt();
                return liveBasePackage;
            }

            /* renamed from: clear */
            public Builder m4674clear() {
                super.clear();
                this.packageId_ = LiveBasePackage.serialVersionUID;
                this.needAck_ = false;
                if (this.bodyBuilder_ == null) {
                    this.body_ = null;
                    return this;
                }
                this.body_ = null;
                this.bodyBuilder_ = null;
                return this;
            }

            public Builder clearBody() {
                if (this.bodyBuilder_ == null) {
                    this.body_ = null;
                    onChanged();
                    return this;
                }
                this.body_ = null;
                this.bodyBuilder_ = null;
                return this;
            }

            /* renamed from: clearField */
            public Builder m4676clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearNeedAck() {
                this.needAck_ = false;
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m4679clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPackageId() {
                this.packageId_ = LiveBasePackage.serialVersionUID;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m4685clone() {
                return (Builder) super.clone();
            }

            @Override // cn.irisgw.live.LiveConnect.LiveBasePackageOrBuilder
            public Any getBody() {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Any any = this.body_;
                    Any any2 = any;
                    if (any == null) {
                        any2 = Any.getDefaultInstance();
                    }
                    return any2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Any.Builder getBodyBuilder() {
                onChanged();
                return getBodyFieldBuilder().getBuilder();
            }

            @Override // cn.irisgw.live.LiveConnect.LiveBasePackageOrBuilder
            public AnyOrBuilder getBodyOrBuilder() {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Any any = this.body_;
                Any any2 = any;
                if (any == null) {
                    any2 = Any.getDefaultInstance();
                }
                return any2;
            }

            /* renamed from: getDefaultInstanceForType */
            public LiveBasePackage m4687getDefaultInstanceForType() {
                return LiveBasePackage.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackage_descriptor;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveBasePackageOrBuilder
            public boolean getNeedAck() {
                return this.needAck_;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveBasePackageOrBuilder
            public long getPackageId() {
                return this.packageId_;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveBasePackageOrBuilder
            public boolean hasBody() {
                return (this.bodyBuilder_ == null && this.body_ == null) ? false : true;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackage_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveBasePackage.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeBody(Any any) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(any);
                    return this;
                }
                Any any2 = this.body_;
                if (any2 != null) {
                    this.body_ = Any.newBuilder(any2).mergeFrom(any).buildPartial();
                } else {
                    this.body_ = any;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(LiveBasePackage liveBasePackage) {
                if (liveBasePackage == LiveBasePackage.getDefaultInstance()) {
                    return this;
                }
                if (liveBasePackage.getPackageId() != LiveBasePackage.serialVersionUID) {
                    setPackageId(liveBasePackage.getPackageId());
                }
                if (liveBasePackage.getNeedAck()) {
                    setNeedAck(liveBasePackage.getNeedAck());
                }
                if (liveBasePackage.hasBody()) {
                    mergeBody(liveBasePackage.getBody());
                }
                m4696mergeUnknownFields(liveBasePackage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.LiveConnect.LiveBasePackage.Builder m4693mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.LiveConnect.LiveBasePackage.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.LiveConnect$LiveBasePackage r0 = (cn.irisgw.live.LiveConnect.LiveBasePackage) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.LiveConnect$LiveBasePackage$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.LiveConnect$LiveBasePackage r0 = (cn.irisgw.live.LiveConnect.LiveBasePackage) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.LiveConnect$LiveBasePackage$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveConnect.LiveBasePackage.Builder.m4693mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveConnect$LiveBasePackage$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m4692mergeFrom(Message message) {
                if (message instanceof LiveBasePackage) {
                    return mergeFrom((LiveBasePackage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m4696mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBody(Any.Builder builder) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.body_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setBody(Any any) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(any);
                    return this;
                } else if (any != null) {
                    this.body_ = any;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            /* renamed from: setField */
            public Builder m4698setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setNeedAck(boolean z) {
                this.needAck_ = z;
                onChanged();
                return this;
            }

            public Builder setPackageId(long j) {
                this.packageId_ = j;
                onChanged();
                return this;
            }

            /* renamed from: setRepeatedField */
            public Builder m4700setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* renamed from: setUnknownFields */
            public final Builder m4702setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private LiveBasePackage() {
            this.memoizedIsInitialized = (byte) -1;
        }

        private LiveBasePackage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.packageId_ = codedInputStream.readUInt64();
                            } else if (readTag == 16) {
                                this.needAck_ = codedInputStream.readBool();
                            } else if (readTag == 26) {
                                Any.Builder builder = this.body_ != null ? this.body_.toBuilder() : null;
                                Any readMessage = codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                                this.body_ = readMessage;
                                if (builder != null) {
                                    builder.mergeFrom(readMessage);
                                    this.body_ = builder.buildPartial();
                                }
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (IOException e) {
                        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private LiveBasePackage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LiveBasePackage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackage_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m4663toBuilder();
        }

        public static Builder newBuilder(LiveBasePackage liveBasePackage) {
            return DEFAULT_INSTANCE.m4663toBuilder().mergeFrom(liveBasePackage);
        }

        public static LiveBasePackage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LiveBasePackage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveBasePackage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (LiveBasePackage) PARSER.parseFrom(byteString);
        }

        public static LiveBasePackage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LiveBasePackage) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LiveBasePackage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LiveBasePackage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static LiveBasePackage parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LiveBasePackage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveBasePackage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (LiveBasePackage) PARSER.parseFrom(byteBuffer);
        }

        public static LiveBasePackage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LiveBasePackage) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LiveBasePackage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (LiveBasePackage) PARSER.parseFrom(bArr);
        }

        public static LiveBasePackage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LiveBasePackage) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<LiveBasePackage> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof LiveBasePackage) {
                LiveBasePackage liveBasePackage = (LiveBasePackage) obj;
                if (getPackageId() == liveBasePackage.getPackageId() && getNeedAck() == liveBasePackage.getNeedAck() && hasBody() == liveBasePackage.hasBody()) {
                    return (!hasBody() || getBody().equals(liveBasePackage.getBody())) && this.unknownFields.equals(liveBasePackage.unknownFields);
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.LiveConnect.LiveBasePackageOrBuilder
        public Any getBody() {
            Any any = this.body_;
            Any any2 = any;
            if (any == null) {
                any2 = Any.getDefaultInstance();
            }
            return any2;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveBasePackageOrBuilder
        public AnyOrBuilder getBodyOrBuilder() {
            return getBody();
        }

        /* renamed from: getDefaultInstanceForType */
        public LiveBasePackage m4658getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveBasePackageOrBuilder
        public boolean getNeedAck() {
            return this.needAck_;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveBasePackageOrBuilder
        public long getPackageId() {
            return this.packageId_;
        }

        public Parser<LiveBasePackage> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            long j = this.packageId_;
            if (j != serialVersionUID) {
                i2 = 0 + CodedOutputStream.computeUInt64Size(1, j);
            }
            boolean z = this.needAck_;
            int i3 = i2;
            if (z) {
                i3 = i2 + CodedOutputStream.computeBoolSize(2, z);
            }
            int i4 = i3;
            if (this.body_ != null) {
                i4 = i3 + CodedOutputStream.computeMessageSize(3, getBody());
            }
            int serializedSize = i4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveBasePackageOrBuilder
        public boolean hasBody() {
            return this.body_ != null;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getPackageId())) * 37) + 2) * 53) + Internal.hashBoolean(getNeedAck());
            int i = hashCode;
            if (hasBody()) {
                i = (((hashCode * 37) + 3) * 53) + getBody().hashCode();
            }
            int hashCode2 = (i * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackage_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveBasePackage.class, Builder.class);
        }

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

        /* renamed from: newBuilderForType */
        public Builder m4661newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m4660newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new LiveBasePackage();
        }

        /* renamed from: toBuilder */
        public Builder m4663toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.packageId_;
            if (j != serialVersionUID) {
                codedOutputStream.writeUInt64(1, j);
            }
            boolean z = this.needAck_;
            if (z) {
                codedOutputStream.writeBool(2, z);
            }
            if (this.body_ != null) {
                codedOutputStream.writeMessage(3, getBody());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnect$LiveBasePackageAck.class */
    public static final class LiveBasePackageAck extends GeneratedMessageV3 implements LiveBasePackageAckOrBuilder {
        public static final int PACKAGE_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private long packageId_;
        private static final LiveBasePackageAck DEFAULT_INSTANCE = new LiveBasePackageAck();
        private static final Parser<LiveBasePackageAck> PARSER = new AbstractParser<LiveBasePackageAck>() { // from class: cn.irisgw.live.LiveConnect.LiveBasePackageAck.1
            /* renamed from: parsePartialFrom */
            public LiveBasePackageAck m4711parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LiveBasePackageAck(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnect$LiveBasePackageAck$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveBasePackageAckOrBuilder {
            private long packageId_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackageAck_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LiveBasePackageAck.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m4713addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public LiveBasePackageAck m4715build() {
                LiveBasePackageAck m4717buildPartial = m4717buildPartial();
                if (m4717buildPartial.isInitialized()) {
                    return m4717buildPartial;
                }
                throw newUninitializedMessageException(m4717buildPartial);
            }

            /* renamed from: buildPartial */
            public LiveBasePackageAck m4717buildPartial() {
                LiveBasePackageAck liveBasePackageAck = new LiveBasePackageAck(this);
                liveBasePackageAck.packageId_ = this.packageId_;
                onBuilt();
                return liveBasePackageAck;
            }

            /* renamed from: clear */
            public Builder m4721clear() {
                super.clear();
                this.packageId_ = LiveBasePackageAck.serialVersionUID;
                return this;
            }

            /* renamed from: clearField */
            public Builder m4723clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            /* renamed from: clearOneof */
            public Builder m4726clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPackageId() {
                this.packageId_ = LiveBasePackageAck.serialVersionUID;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m4732clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public LiveBasePackageAck m4734getDefaultInstanceForType() {
                return LiveBasePackageAck.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackageAck_descriptor;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveBasePackageAckOrBuilder
            public long getPackageId() {
                return this.packageId_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackageAck_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveBasePackageAck.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(LiveBasePackageAck liveBasePackageAck) {
                if (liveBasePackageAck == LiveBasePackageAck.getDefaultInstance()) {
                    return this;
                }
                if (liveBasePackageAck.getPackageId() != LiveBasePackageAck.serialVersionUID) {
                    setPackageId(liveBasePackageAck.getPackageId());
                }
                m4743mergeUnknownFields(liveBasePackageAck.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.LiveConnect.LiveBasePackageAck.Builder m4740mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.LiveConnect.LiveBasePackageAck.access$2000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.LiveConnect$LiveBasePackageAck r0 = (cn.irisgw.live.LiveConnect.LiveBasePackageAck) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.LiveConnect$LiveBasePackageAck$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.LiveConnect$LiveBasePackageAck r0 = (cn.irisgw.live.LiveConnect.LiveBasePackageAck) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.LiveConnect$LiveBasePackageAck$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveConnect.LiveBasePackageAck.Builder.m4740mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveConnect$LiveBasePackageAck$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m4739mergeFrom(Message message) {
                if (message instanceof LiveBasePackageAck) {
                    return mergeFrom((LiveBasePackageAck) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m4743mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            /* renamed from: setField */
            public Builder m4745setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setPackageId(long j) {
                this.packageId_ = j;
                onChanged();
                return this;
            }

            /* renamed from: setRepeatedField */
            public Builder m4747setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* renamed from: setUnknownFields */
            public final Builder m4749setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private LiveBasePackageAck() {
            this.memoizedIsInitialized = (byte) -1;
        }

        private LiveBasePackageAck(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.packageId_ = codedInputStream.readUInt64();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (IOException e) {
                        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private LiveBasePackageAck(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LiveBasePackageAck getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackageAck_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m4710toBuilder();
        }

        public static Builder newBuilder(LiveBasePackageAck liveBasePackageAck) {
            return DEFAULT_INSTANCE.m4710toBuilder().mergeFrom(liveBasePackageAck);
        }

        public static LiveBasePackageAck parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LiveBasePackageAck parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveBasePackageAck parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (LiveBasePackageAck) PARSER.parseFrom(byteString);
        }

        public static LiveBasePackageAck parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LiveBasePackageAck) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LiveBasePackageAck parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LiveBasePackageAck parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static LiveBasePackageAck parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LiveBasePackageAck parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveBasePackageAck parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (LiveBasePackageAck) PARSER.parseFrom(byteBuffer);
        }

        public static LiveBasePackageAck parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LiveBasePackageAck) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LiveBasePackageAck parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (LiveBasePackageAck) PARSER.parseFrom(bArr);
        }

        public static LiveBasePackageAck parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LiveBasePackageAck) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<LiveBasePackageAck> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof LiveBasePackageAck) {
                LiveBasePackageAck liveBasePackageAck = (LiveBasePackageAck) obj;
                return getPackageId() == liveBasePackageAck.getPackageId() && this.unknownFields.equals(liveBasePackageAck.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public LiveBasePackageAck m4705getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveBasePackageAckOrBuilder
        public long getPackageId() {
            return this.packageId_;
        }

        public Parser<LiveBasePackageAck> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            long j = this.packageId_;
            if (j != serialVersionUID) {
                i2 = 0 + CodedOutputStream.computeUInt64Size(1, j);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getPackageId())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackageAck_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveBasePackageAck.class, Builder.class);
        }

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

        /* renamed from: newBuilderForType */
        public Builder m4708newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m4707newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new LiveBasePackageAck();
        }

        /* renamed from: toBuilder */
        public Builder m4710toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.packageId_;
            if (j != serialVersionUID) {
                codedOutputStream.writeUInt64(1, j);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnect$LiveBasePackageAckOrBuilder.class */
    public interface LiveBasePackageAckOrBuilder extends MessageOrBuilder {
        long getPackageId();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnect$LiveBasePackageOrBuilder.class */
    public interface LiveBasePackageOrBuilder extends MessageOrBuilder {
        Any getBody();

        AnyOrBuilder getBodyOrBuilder();

        boolean getNeedAck();

        long getPackageId();

        boolean hasBody();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnect$LiveSetting.class */
    public static final class LiveSetting extends GeneratedMessageV3 implements LiveSettingOrBuilder {
        public static final int APP_VERSION_FIELD_NUMBER = 1;
        public static final int CHANNEL_FIELD_NUMBER = 6;
        public static final int DEVICE_FIELD_NUMBER = 5;
        public static final int LANGUAGE_FIELD_NUMBER = 3;
        public static final int OS_VERSION_FIELD_NUMBER = 4;
        public static final int PLATFORM_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object appVersion_;
        private volatile Object channel_;
        private volatile Object device_;
        private volatile Object language_;
        private byte memoizedIsInitialized;
        private volatile Object osVersion_;
        private volatile Object platform_;
        private static final LiveSetting DEFAULT_INSTANCE = new LiveSetting();
        private static final Parser<LiveSetting> PARSER = new AbstractParser<LiveSetting>() { // from class: cn.irisgw.live.LiveConnect.LiveSetting.1
            /* renamed from: parsePartialFrom */
            public LiveSetting m4758parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LiveSetting(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnect$LiveSetting$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveSettingOrBuilder {
            private Object appVersion_;
            private Object channel_;
            private Object device_;
            private Object language_;
            private Object osVersion_;
            private Object platform_;

            private Builder() {
                this.appVersion_ = "";
                this.platform_ = "";
                this.language_ = "";
                this.osVersion_ = "";
                this.device_ = "";
                this.channel_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.appVersion_ = "";
                this.platform_ = "";
                this.language_ = "";
                this.osVersion_ = "";
                this.device_ = "";
                this.channel_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConnect.internal_static_cn_irisgw_live_LiveSetting_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LiveSetting.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m4760addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public LiveSetting m4762build() {
                LiveSetting m4764buildPartial = m4764buildPartial();
                if (m4764buildPartial.isInitialized()) {
                    return m4764buildPartial;
                }
                throw newUninitializedMessageException(m4764buildPartial);
            }

            /* renamed from: buildPartial */
            public LiveSetting m4764buildPartial() {
                LiveSetting liveSetting = new LiveSetting(this);
                liveSetting.appVersion_ = this.appVersion_;
                liveSetting.platform_ = this.platform_;
                liveSetting.language_ = this.language_;
                liveSetting.osVersion_ = this.osVersion_;
                liveSetting.device_ = this.device_;
                liveSetting.channel_ = this.channel_;
                onBuilt();
                return liveSetting;
            }

            /* renamed from: clear */
            public Builder m4768clear() {
                super.clear();
                this.appVersion_ = "";
                this.platform_ = "";
                this.language_ = "";
                this.osVersion_ = "";
                this.device_ = "";
                this.channel_ = "";
                return this;
            }

            public Builder clearAppVersion() {
                this.appVersion_ = LiveSetting.getDefaultInstance().getAppVersion();
                onChanged();
                return this;
            }

            public Builder clearChannel() {
                this.channel_ = LiveSetting.getDefaultInstance().getChannel();
                onChanged();
                return this;
            }

            public Builder clearDevice() {
                this.device_ = LiveSetting.getDefaultInstance().getDevice();
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m4770clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearLanguage() {
                this.language_ = LiveSetting.getDefaultInstance().getLanguage();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m4773clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearOsVersion() {
                this.osVersion_ = LiveSetting.getDefaultInstance().getOsVersion();
                onChanged();
                return this;
            }

            public Builder clearPlatform() {
                this.platform_ = LiveSetting.getDefaultInstance().getPlatform();
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m4779clone() {
                return (Builder) super.clone();
            }

            @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
            public String getAppVersion() {
                Object obj = this.appVersion_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.appVersion_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
            public ByteString getAppVersionBytes() {
                Object obj = this.appVersion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appVersion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
            public String getChannel() {
                Object obj = this.channel_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.channel_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
            public ByteString getChannelBytes() {
                Object obj = this.channel_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.channel_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            /* renamed from: getDefaultInstanceForType */
            public LiveSetting m4781getDefaultInstanceForType() {
                return LiveSetting.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConnect.internal_static_cn_irisgw_live_LiveSetting_descriptor;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
            public String getDevice() {
                Object obj = this.device_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.device_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
            public ByteString getDeviceBytes() {
                Object obj = this.device_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.device_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
            public String getLanguage() {
                Object obj = this.language_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.language_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
            public ByteString getLanguageBytes() {
                Object obj = this.language_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.language_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
            public String getOsVersion() {
                Object obj = this.osVersion_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.osVersion_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
            public ByteString getOsVersionBytes() {
                Object obj = this.osVersion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.osVersion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
            public String getPlatform() {
                Object obj = this.platform_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.platform_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
            public ByteString getPlatformBytes() {
                Object obj = this.platform_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.platform_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConnect.internal_static_cn_irisgw_live_LiveSetting_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveSetting.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(LiveSetting liveSetting) {
                if (liveSetting == LiveSetting.getDefaultInstance()) {
                    return this;
                }
                if (!liveSetting.getAppVersion().isEmpty()) {
                    this.appVersion_ = liveSetting.appVersion_;
                    onChanged();
                }
                if (!liveSetting.getPlatform().isEmpty()) {
                    this.platform_ = liveSetting.platform_;
                    onChanged();
                }
                if (!liveSetting.getLanguage().isEmpty()) {
                    this.language_ = liveSetting.language_;
                    onChanged();
                }
                if (!liveSetting.getOsVersion().isEmpty()) {
                    this.osVersion_ = liveSetting.osVersion_;
                    onChanged();
                }
                if (!liveSetting.getDevice().isEmpty()) {
                    this.device_ = liveSetting.device_;
                    onChanged();
                }
                if (!liveSetting.getChannel().isEmpty()) {
                    this.channel_ = liveSetting.channel_;
                    onChanged();
                }
                m4790mergeUnknownFields(liveSetting.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.LiveConnect.LiveSetting.Builder m4787mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.LiveConnect.LiveSetting.access$3500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.LiveConnect$LiveSetting r0 = (cn.irisgw.live.LiveConnect.LiveSetting) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.LiveConnect$LiveSetting$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.LiveConnect$LiveSetting r0 = (cn.irisgw.live.LiveConnect.LiveSetting) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.LiveConnect$LiveSetting$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveConnect.LiveSetting.Builder.m4787mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveConnect$LiveSetting$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m4786mergeFrom(Message message) {
                if (message instanceof LiveSetting) {
                    return mergeFrom((LiveSetting) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m4790mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setAppVersion(String str) {
                if (str != null) {
                    this.appVersion_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAppVersionBytes(ByteString byteString) {
                if (byteString != null) {
                    LiveSetting.checkByteStringIsUtf8(byteString);
                    this.appVersion_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setChannel(String str) {
                if (str != null) {
                    this.channel_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setChannelBytes(ByteString byteString) {
                if (byteString != null) {
                    LiveSetting.checkByteStringIsUtf8(byteString);
                    this.channel_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDevice(String str) {
                if (str != null) {
                    this.device_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDeviceBytes(ByteString byteString) {
                if (byteString != null) {
                    LiveSetting.checkByteStringIsUtf8(byteString);
                    this.device_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setField */
            public Builder m4792setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setLanguage(String str) {
                if (str != null) {
                    this.language_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLanguageBytes(ByteString byteString) {
                if (byteString != null) {
                    LiveSetting.checkByteStringIsUtf8(byteString);
                    this.language_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOsVersion(String str) {
                if (str != null) {
                    this.osVersion_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOsVersionBytes(ByteString byteString) {
                if (byteString != null) {
                    LiveSetting.checkByteStringIsUtf8(byteString);
                    this.osVersion_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPlatform(String str) {
                if (str != null) {
                    this.platform_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPlatformBytes(ByteString byteString) {
                if (byteString != null) {
                    LiveSetting.checkByteStringIsUtf8(byteString);
                    this.platform_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setRepeatedField */
            public Builder m4794setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* renamed from: setUnknownFields */
            public final Builder m4796setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private LiveSetting() {
            this.memoizedIsInitialized = (byte) -1;
            this.appVersion_ = "";
            this.platform_ = "";
            this.language_ = "";
            this.osVersion_ = "";
            this.device_ = "";
            this.channel_ = "";
        }

        private LiveSetting(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.appVersion_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.platform_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.language_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                this.osVersion_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                this.device_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 50) {
                                this.channel_ = codedInputStream.readStringRequireUtf8();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private LiveSetting(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LiveSetting getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConnect.internal_static_cn_irisgw_live_LiveSetting_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m4757toBuilder();
        }

        public static Builder newBuilder(LiveSetting liveSetting) {
            return DEFAULT_INSTANCE.m4757toBuilder().mergeFrom(liveSetting);
        }

        public static LiveSetting parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LiveSetting parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveSetting parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (LiveSetting) PARSER.parseFrom(byteString);
        }

        public static LiveSetting parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LiveSetting) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LiveSetting parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LiveSetting parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static LiveSetting parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LiveSetting parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveSetting parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (LiveSetting) PARSER.parseFrom(byteBuffer);
        }

        public static LiveSetting parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LiveSetting) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LiveSetting parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (LiveSetting) PARSER.parseFrom(bArr);
        }

        public static LiveSetting parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LiveSetting) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<LiveSetting> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof LiveSetting) {
                LiveSetting liveSetting = (LiveSetting) obj;
                return getAppVersion().equals(liveSetting.getAppVersion()) && getPlatform().equals(liveSetting.getPlatform()) && getLanguage().equals(liveSetting.getLanguage()) && getOsVersion().equals(liveSetting.getOsVersion()) && getDevice().equals(liveSetting.getDevice()) && getChannel().equals(liveSetting.getChannel()) && this.unknownFields.equals(liveSetting.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
        public String getAppVersion() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.appVersion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
        public ByteString getAppVersionBytes() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
        public String getChannel() {
            Object obj = this.channel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.channel_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
        public ByteString getChannelBytes() {
            Object obj = this.channel_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.channel_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* renamed from: getDefaultInstanceForType */
        public LiveSetting m4752getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
        public String getDevice() {
            Object obj = this.device_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.device_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
        public ByteString getDeviceBytes() {
            Object obj = this.device_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.device_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
        public String getLanguage() {
            Object obj = this.language_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.language_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
        public ByteString getLanguageBytes() {
            Object obj = this.language_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.language_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
        public String getOsVersion() {
            Object obj = this.osVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.osVersion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
        public ByteString getOsVersionBytes() {
            Object obj = this.osVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.osVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<LiveSetting> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
        public String getPlatform() {
            Object obj = this.platform_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.platform_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveConnect.LiveSettingOrBuilder
        public ByteString getPlatformBytes() {
            Object obj = this.platform_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.platform_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getAppVersionBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.appVersion_);
            }
            int i3 = i2;
            if (!getPlatformBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.platform_);
            }
            int i4 = i3;
            if (!getLanguageBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.language_);
            }
            int i5 = i4;
            if (!getOsVersionBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.osVersion_);
            }
            int i6 = i5;
            if (!getDeviceBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.device_);
            }
            int i7 = i6;
            if (!getChannelBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(6, this.channel_);
            }
            int serializedSize = i7 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getAppVersion().hashCode()) * 37) + 2) * 53) + getPlatform().hashCode()) * 37) + 3) * 53) + getLanguage().hashCode()) * 37) + 4) * 53) + getOsVersion().hashCode()) * 37) + 5) * 53) + getDevice().hashCode()) * 37) + 6) * 53) + getChannel().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConnect.internal_static_cn_irisgw_live_LiveSetting_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveSetting.class, Builder.class);
        }

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

        /* renamed from: newBuilderForType */
        public Builder m4755newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m4754newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new LiveSetting();
        }

        /* renamed from: toBuilder */
        public Builder m4757toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getAppVersionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.appVersion_);
            }
            if (!getPlatformBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.platform_);
            }
            if (!getLanguageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.language_);
            }
            if (!getOsVersionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.osVersion_);
            }
            if (!getDeviceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.device_);
            }
            if (!getChannelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.channel_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnect$LiveSettingOrBuilder.class */
    public interface LiveSettingOrBuilder extends MessageOrBuilder {
        String getAppVersion();

        ByteString getAppVersionBytes();

        String getChannel();

        ByteString getChannelBytes();

        String getDevice();

        ByteString getDeviceBytes();

        String getLanguage();

        ByteString getLanguageBytes();

        String getOsVersion();

        ByteString getOsVersionBytes();

        String getPlatform();

        ByteString getPlatformBytes();
    }

    static {
        Descriptors.Descriptor descriptor2 = (Descriptors.Descriptor) getDescriptor().getMessageTypes().get(0);
        internal_static_cn_irisgw_live_LiveBasePackage_descriptor = descriptor2;
        internal_static_cn_irisgw_live_LiveBasePackage_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"PackageId", "NeedAck", "Body"});
        Descriptors.Descriptor descriptor3 = (Descriptors.Descriptor) getDescriptor().getMessageTypes().get(1);
        internal_static_cn_irisgw_live_LiveBasePackageAck_descriptor = descriptor3;
        internal_static_cn_irisgw_live_LiveBasePackageAck_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"PackageId"});
        Descriptors.Descriptor descriptor4 = (Descriptors.Descriptor) getDescriptor().getMessageTypes().get(2);
        internal_static_cn_irisgw_live_LiveSetting_descriptor = descriptor4;
        internal_static_cn_irisgw_live_LiveSetting_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"AppVersion", "Platform", "Language", "OsVersion", "Device", "Channel"});
        AnyProto.getDescriptor();
    }

    private LiveConnect() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
