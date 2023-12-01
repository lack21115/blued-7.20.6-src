package cn.irisgw.live;

import com.google.protobuf.AbstractParser;
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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass.class */
public final class LiveChatOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eliveChat.proto\u0012\u000ecn.irisgw.live\"E\n\u000eLiveMsgRequest\u0012\u000f\n\u0007live_id\u0018\u0001 \u0001(\t\u0012\u0010\n\bcontents\u0018\u0002 \u0001(\t\u0012\u0010\n\bemoji_id\u0018\u0003 \u0001(\r\"s\n\u000fLiveMsgResponse\u0012,\n\u0004code\u0018\u0001 \u0001(\u000e2\u001e.cn.irisgw.live.SendStatusCode\u0012\u000e\n\u0006msg_id\u0018\u0002 \u0001(\u0004\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0004\u0012\u000f\n\u0007message\u0018\u0004 \u0001(\t\"I\n\u000fLiveLikeRequest\u0012\u000f\n\u0007live_id\u0018\u0001 \u0001(\t\u0012\r\n\u0005count\u0018\u0002 \u0001(\r\u0012\u0016\n\u000ehas_first_like\u0018\u0003 \u0001(\b\"@\n\u0010LiveLikeResponse\u0012,\n\u0004code\u0018\u0001 \u0001(\u000e2\u001e.cn.irisgw.live.SendStatusCode*.\n\u000eSendStatusCode\u0012\u000e\n\nSEND_EMPTY\u0010��\u0012\f\n\u0007SEND_OK\u0010È\u00012©\u0001\n\bLiveChat\u0012L\n\u0007SendMsg\u0012\u001e.cn.irisgw.live.LiveMsgRequest\u001a\u001f.cn.irisgw.live.LiveMsgResponse\"��\u0012O\n\bSendLike\u0012\u001f.cn.irisgw.live.LiveLikeRequest\u001a .cn.irisgw.live.LiveLikeResponse\"��b\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveLikeRequest_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveLikeRequest_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveLikeResponse_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveLikeResponse_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveMsgRequest_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveMsgRequest_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveMsgResponse_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveMsgResponse_fieldAccessorTable;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass$LiveLikeRequest.class */
    public static final class LiveLikeRequest extends GeneratedMessageV3 implements LiveLikeRequestOrBuilder {
        public static final int COUNT_FIELD_NUMBER = 2;
        public static final int HAS_FIRST_LIKE_FIELD_NUMBER = 3;
        public static final int LIVE_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int count_;
        private boolean hasFirstLike_;
        private volatile Object liveId_;
        private byte memoizedIsInitialized;
        private static final LiveLikeRequest DEFAULT_INSTANCE = new LiveLikeRequest();
        private static final Parser<LiveLikeRequest> PARSER = new AbstractParser<LiveLikeRequest>() { // from class: cn.irisgw.live.LiveChatOuterClass.LiveLikeRequest.1
            @Override // com.google.protobuf.Parser
            public LiveLikeRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LiveLikeRequest(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass$LiveLikeRequest$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveLikeRequestOrBuilder {
            private int count_;
            private boolean hasFirstLike_;
            private Object liveId_;

            private Builder() {
                this.liveId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.liveId_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeRequest_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LiveLikeRequest.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LiveLikeRequest build() {
                LiveLikeRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LiveLikeRequest buildPartial() {
                LiveLikeRequest liveLikeRequest = new LiveLikeRequest(this);
                liveLikeRequest.liveId_ = this.liveId_;
                liveLikeRequest.count_ = this.count_;
                liveLikeRequest.hasFirstLike_ = this.hasFirstLike_;
                onBuilt();
                return liveLikeRequest;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.liveId_ = "";
                this.count_ = 0;
                this.hasFirstLike_ = false;
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearHasFirstLike() {
                this.hasFirstLike_ = false;
                onChanged();
                return this;
            }

            public Builder clearLiveId() {
                this.liveId_ = LiveLikeRequest.getDefaultInstance().getLiveId();
                onChanged();
                return this;
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

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveLikeRequestOrBuilder
            public int getCount() {
                return this.count_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LiveLikeRequest getDefaultInstanceForType() {
                return LiveLikeRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeRequest_descriptor;
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveLikeRequestOrBuilder
            public boolean getHasFirstLike() {
                return this.hasFirstLike_;
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveLikeRequestOrBuilder
            public String getLiveId() {
                Object obj = this.liveId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.liveId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveLikeRequestOrBuilder
            public ByteString getLiveIdBytes() {
                Object obj = this.liveId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.liveId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveLikeRequest.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(LiveLikeRequest liveLikeRequest) {
                if (liveLikeRequest == LiveLikeRequest.getDefaultInstance()) {
                    return this;
                }
                if (!liveLikeRequest.getLiveId().isEmpty()) {
                    this.liveId_ = liveLikeRequest.liveId_;
                    onChanged();
                }
                if (liveLikeRequest.getCount() != 0) {
                    setCount(liveLikeRequest.getCount());
                }
                if (liveLikeRequest.getHasFirstLike()) {
                    setHasFirstLike(liveLikeRequest.getHasFirstLike());
                }
                mergeUnknownFields(liveLikeRequest.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.LiveChatOuterClass.LiveLikeRequest.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.LiveChatOuterClass.LiveLikeRequest.access$3800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.LiveChatOuterClass$LiveLikeRequest r0 = (cn.irisgw.live.LiveChatOuterClass.LiveLikeRequest) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.LiveChatOuterClass$LiveLikeRequest$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.LiveChatOuterClass$LiveLikeRequest r0 = (cn.irisgw.live.LiveChatOuterClass.LiveLikeRequest) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.LiveChatOuterClass$LiveLikeRequest$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveChatOuterClass.LiveLikeRequest.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveChatOuterClass$LiveLikeRequest$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof LiveLikeRequest) {
                    return mergeFrom((LiveLikeRequest) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setCount(int i) {
                this.count_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setHasFirstLike(boolean z) {
                this.hasFirstLike_ = z;
                onChanged();
                return this;
            }

            public Builder setLiveId(String str) {
                if (str != null) {
                    this.liveId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLiveIdBytes(ByteString byteString) {
                if (byteString != null) {
                    LiveLikeRequest.checkByteStringIsUtf8(byteString);
                    this.liveId_ = byteString;
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
        }

        private LiveLikeRequest() {
            this.memoizedIsInitialized = (byte) -1;
            this.liveId_ = "";
        }

        private LiveLikeRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.liveId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 16) {
                                    this.count_ = codedInputStream.readUInt32();
                                } else if (readTag == 24) {
                                    this.hasFirstLike_ = codedInputStream.readBool();
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

        private LiveLikeRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LiveLikeRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeRequest_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LiveLikeRequest liveLikeRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(liveLikeRequest);
        }

        public static LiveLikeRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LiveLikeRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LiveLikeRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveLikeRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveLikeRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LiveLikeRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LiveLikeRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LiveLikeRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LiveLikeRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveLikeRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static LiveLikeRequest parseFrom(InputStream inputStream) throws IOException {
            return (LiveLikeRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LiveLikeRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveLikeRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveLikeRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LiveLikeRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LiveLikeRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LiveLikeRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<LiveLikeRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof LiveLikeRequest) {
                LiveLikeRequest liveLikeRequest = (LiveLikeRequest) obj;
                return getLiveId().equals(liveLikeRequest.getLiveId()) && getCount() == liveLikeRequest.getCount() && getHasFirstLike() == liveLikeRequest.getHasFirstLike() && this.unknownFields.equals(liveLikeRequest.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveLikeRequestOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LiveLikeRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveLikeRequestOrBuilder
        public boolean getHasFirstLike() {
            return this.hasFirstLike_;
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveLikeRequestOrBuilder
        public String getLiveId() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liveId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveLikeRequestOrBuilder
        public ByteString getLiveIdBytes() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liveId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LiveLikeRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getLiveIdBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.liveId_);
            }
            int i3 = this.count_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeUInt32Size(2, i3);
            }
            boolean z = this.hasFirstLike_;
            int i5 = i4;
            if (z) {
                i5 = i4 + CodedOutputStream.computeBoolSize(3, z);
            }
            int serializedSize = i5 + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getLiveId().hashCode()) * 37) + 2) * 53) + getCount()) * 37) + 3) * 53) + Internal.hashBoolean(getHasFirstLike())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveLikeRequest.class, Builder.class);
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
            return new LiveLikeRequest();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getLiveIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.liveId_);
            }
            int i = this.count_;
            if (i != 0) {
                codedOutputStream.writeUInt32(2, i);
            }
            boolean z = this.hasFirstLike_;
            if (z) {
                codedOutputStream.writeBool(3, z);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass$LiveLikeRequestOrBuilder.class */
    public interface LiveLikeRequestOrBuilder extends MessageOrBuilder {
        int getCount();

        boolean getHasFirstLike();

        String getLiveId();

        ByteString getLiveIdBytes();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass$LiveLikeResponse.class */
    public static final class LiveLikeResponse extends GeneratedMessageV3 implements LiveLikeResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final LiveLikeResponse DEFAULT_INSTANCE = new LiveLikeResponse();
        private static final Parser<LiveLikeResponse> PARSER = new AbstractParser<LiveLikeResponse>() { // from class: cn.irisgw.live.LiveChatOuterClass.LiveLikeResponse.1
            @Override // com.google.protobuf.Parser
            public LiveLikeResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LiveLikeResponse(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        private int code_;
        private byte memoizedIsInitialized;

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass$LiveLikeResponse$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveLikeResponseOrBuilder {
            private int code_;

            private Builder() {
                this.code_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.code_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeResponse_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LiveLikeResponse.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LiveLikeResponse build() {
                LiveLikeResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LiveLikeResponse buildPartial() {
                LiveLikeResponse liveLikeResponse = new LiveLikeResponse(this);
                liveLikeResponse.code_ = this.code_;
                onBuilt();
                return liveLikeResponse;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.code_ = 0;
                return this;
            }

            public Builder clearCode() {
                this.code_ = 0;
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

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveLikeResponseOrBuilder
            public SendStatusCode getCode() {
                SendStatusCode valueOf = SendStatusCode.valueOf(this.code_);
                SendStatusCode sendStatusCode = valueOf;
                if (valueOf == null) {
                    sendStatusCode = SendStatusCode.UNRECOGNIZED;
                }
                return sendStatusCode;
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveLikeResponseOrBuilder
            public int getCodeValue() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LiveLikeResponse getDefaultInstanceForType() {
                return LiveLikeResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeResponse_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveLikeResponse.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(LiveLikeResponse liveLikeResponse) {
                if (liveLikeResponse == LiveLikeResponse.getDefaultInstance()) {
                    return this;
                }
                if (liveLikeResponse.code_ != 0) {
                    setCodeValue(liveLikeResponse.getCodeValue());
                }
                mergeUnknownFields(liveLikeResponse.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.LiveChatOuterClass.LiveLikeResponse.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.LiveChatOuterClass.LiveLikeResponse.access$4900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.LiveChatOuterClass$LiveLikeResponse r0 = (cn.irisgw.live.LiveChatOuterClass.LiveLikeResponse) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.LiveChatOuterClass$LiveLikeResponse$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.LiveChatOuterClass$LiveLikeResponse r0 = (cn.irisgw.live.LiveChatOuterClass.LiveLikeResponse) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.LiveChatOuterClass$LiveLikeResponse$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveChatOuterClass.LiveLikeResponse.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveChatOuterClass$LiveLikeResponse$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof LiveLikeResponse) {
                    return mergeFrom((LiveLikeResponse) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setCode(SendStatusCode sendStatusCode) {
                if (sendStatusCode != null) {
                    this.code_ = sendStatusCode.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCodeValue(int i) {
                this.code_ = i;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private LiveLikeResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.code_ = 0;
        }

        private LiveLikeResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.code_ = codedInputStream.readEnum();
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

        private LiveLikeResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LiveLikeResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeResponse_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LiveLikeResponse liveLikeResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(liveLikeResponse);
        }

        public static LiveLikeResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LiveLikeResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LiveLikeResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveLikeResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveLikeResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LiveLikeResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LiveLikeResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LiveLikeResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LiveLikeResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveLikeResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static LiveLikeResponse parseFrom(InputStream inputStream) throws IOException {
            return (LiveLikeResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LiveLikeResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveLikeResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveLikeResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LiveLikeResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LiveLikeResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LiveLikeResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<LiveLikeResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof LiveLikeResponse) {
                LiveLikeResponse liveLikeResponse = (LiveLikeResponse) obj;
                return this.code_ == liveLikeResponse.code_ && this.unknownFields.equals(liveLikeResponse.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveLikeResponseOrBuilder
        public SendStatusCode getCode() {
            SendStatusCode valueOf = SendStatusCode.valueOf(this.code_);
            SendStatusCode sendStatusCode = valueOf;
            if (valueOf == null) {
                sendStatusCode = SendStatusCode.UNRECOGNIZED;
            }
            return sendStatusCode;
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveLikeResponseOrBuilder
        public int getCodeValue() {
            return this.code_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LiveLikeResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LiveLikeResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.code_ != SendStatusCode.SEND_EMPTY.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.code_);
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
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.code_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveLikeResponse.class, Builder.class);
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
            return new LiveLikeResponse();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.code_ != SendStatusCode.SEND_EMPTY.getNumber()) {
                codedOutputStream.writeEnum(1, this.code_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass$LiveLikeResponseOrBuilder.class */
    public interface LiveLikeResponseOrBuilder extends MessageOrBuilder {
        SendStatusCode getCode();

        int getCodeValue();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass$LiveMsgRequest.class */
    public static final class LiveMsgRequest extends GeneratedMessageV3 implements LiveMsgRequestOrBuilder {
        public static final int CONTENTS_FIELD_NUMBER = 2;
        public static final int EMOJI_ID_FIELD_NUMBER = 3;
        public static final int LIVE_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object contents_;
        private int emojiId_;
        private volatile Object liveId_;
        private byte memoizedIsInitialized;
        private static final LiveMsgRequest DEFAULT_INSTANCE = new LiveMsgRequest();
        private static final Parser<LiveMsgRequest> PARSER = new AbstractParser<LiveMsgRequest>() { // from class: cn.irisgw.live.LiveChatOuterClass.LiveMsgRequest.1
            @Override // com.google.protobuf.Parser
            public LiveMsgRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LiveMsgRequest(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass$LiveMsgRequest$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveMsgRequestOrBuilder {
            private Object contents_;
            private int emojiId_;
            private Object liveId_;

            private Builder() {
                this.liveId_ = "";
                this.contents_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.liveId_ = "";
                this.contents_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgRequest_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LiveMsgRequest.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LiveMsgRequest build() {
                LiveMsgRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LiveMsgRequest buildPartial() {
                LiveMsgRequest liveMsgRequest = new LiveMsgRequest(this);
                liveMsgRequest.liveId_ = this.liveId_;
                liveMsgRequest.contents_ = this.contents_;
                liveMsgRequest.emojiId_ = this.emojiId_;
                onBuilt();
                return liveMsgRequest;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.liveId_ = "";
                this.contents_ = "";
                this.emojiId_ = 0;
                return this;
            }

            public Builder clearContents() {
                this.contents_ = LiveMsgRequest.getDefaultInstance().getContents();
                onChanged();
                return this;
            }

            public Builder clearEmojiId() {
                this.emojiId_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearLiveId() {
                this.liveId_ = LiveMsgRequest.getDefaultInstance().getLiveId();
                onChanged();
                return this;
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

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgRequestOrBuilder
            public String getContents() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.contents_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgRequestOrBuilder
            public ByteString getContentsBytes() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.contents_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LiveMsgRequest getDefaultInstanceForType() {
                return LiveMsgRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgRequest_descriptor;
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgRequestOrBuilder
            public int getEmojiId() {
                return this.emojiId_;
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgRequestOrBuilder
            public String getLiveId() {
                Object obj = this.liveId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.liveId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgRequestOrBuilder
            public ByteString getLiveIdBytes() {
                Object obj = this.liveId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.liveId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveMsgRequest.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(LiveMsgRequest liveMsgRequest) {
                if (liveMsgRequest == LiveMsgRequest.getDefaultInstance()) {
                    return this;
                }
                if (!liveMsgRequest.getLiveId().isEmpty()) {
                    this.liveId_ = liveMsgRequest.liveId_;
                    onChanged();
                }
                if (!liveMsgRequest.getContents().isEmpty()) {
                    this.contents_ = liveMsgRequest.contents_;
                    onChanged();
                }
                if (liveMsgRequest.getEmojiId() != 0) {
                    setEmojiId(liveMsgRequest.getEmojiId());
                }
                mergeUnknownFields(liveMsgRequest.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.LiveChatOuterClass.LiveMsgRequest.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.LiveChatOuterClass.LiveMsgRequest.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.LiveChatOuterClass$LiveMsgRequest r0 = (cn.irisgw.live.LiveChatOuterClass.LiveMsgRequest) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.LiveChatOuterClass$LiveMsgRequest$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.LiveChatOuterClass$LiveMsgRequest r0 = (cn.irisgw.live.LiveChatOuterClass.LiveMsgRequest) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.LiveChatOuterClass$LiveMsgRequest$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveChatOuterClass.LiveMsgRequest.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveChatOuterClass$LiveMsgRequest$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof LiveMsgRequest) {
                    return mergeFrom((LiveMsgRequest) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setContents(String str) {
                if (str != null) {
                    this.contents_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setContentsBytes(ByteString byteString) {
                if (byteString != null) {
                    LiveMsgRequest.checkByteStringIsUtf8(byteString);
                    this.contents_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEmojiId(int i) {
                this.emojiId_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setLiveId(String str) {
                if (str != null) {
                    this.liveId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLiveIdBytes(ByteString byteString) {
                if (byteString != null) {
                    LiveMsgRequest.checkByteStringIsUtf8(byteString);
                    this.liveId_ = byteString;
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
        }

        private LiveMsgRequest() {
            this.memoizedIsInitialized = (byte) -1;
            this.liveId_ = "";
            this.contents_ = "";
        }

        private LiveMsgRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.liveId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.contents_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 24) {
                                    this.emojiId_ = codedInputStream.readUInt32();
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

        private LiveMsgRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LiveMsgRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgRequest_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LiveMsgRequest liveMsgRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(liveMsgRequest);
        }

        public static LiveMsgRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LiveMsgRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LiveMsgRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveMsgRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveMsgRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LiveMsgRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LiveMsgRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LiveMsgRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LiveMsgRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveMsgRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static LiveMsgRequest parseFrom(InputStream inputStream) throws IOException {
            return (LiveMsgRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LiveMsgRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveMsgRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveMsgRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LiveMsgRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LiveMsgRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LiveMsgRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<LiveMsgRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof LiveMsgRequest) {
                LiveMsgRequest liveMsgRequest = (LiveMsgRequest) obj;
                return getLiveId().equals(liveMsgRequest.getLiveId()) && getContents().equals(liveMsgRequest.getContents()) && getEmojiId() == liveMsgRequest.getEmojiId() && this.unknownFields.equals(liveMsgRequest.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgRequestOrBuilder
        public String getContents() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.contents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgRequestOrBuilder
        public ByteString getContentsBytes() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.contents_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LiveMsgRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgRequestOrBuilder
        public int getEmojiId() {
            return this.emojiId_;
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgRequestOrBuilder
        public String getLiveId() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liveId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgRequestOrBuilder
        public ByteString getLiveIdBytes() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liveId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LiveMsgRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getLiveIdBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.liveId_);
            }
            int i3 = i2;
            if (!getContentsBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.contents_);
            }
            int i4 = this.emojiId_;
            int i5 = i3;
            if (i4 != 0) {
                i5 = i3 + CodedOutputStream.computeUInt32Size(3, i4);
            }
            int serializedSize = i5 + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getLiveId().hashCode()) * 37) + 2) * 53) + getContents().hashCode()) * 37) + 3) * 53) + getEmojiId()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveMsgRequest.class, Builder.class);
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
            return new LiveMsgRequest();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getLiveIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.liveId_);
            }
            if (!getContentsBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.contents_);
            }
            int i = this.emojiId_;
            if (i != 0) {
                codedOutputStream.writeUInt32(3, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass$LiveMsgRequestOrBuilder.class */
    public interface LiveMsgRequestOrBuilder extends MessageOrBuilder {
        String getContents();

        ByteString getContentsBytes();

        int getEmojiId();

        String getLiveId();

        ByteString getLiveIdBytes();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass$LiveMsgResponse.class */
    public static final class LiveMsgResponse extends GeneratedMessageV3 implements LiveMsgResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int MESSAGE_FIELD_NUMBER = 4;
        public static final int MSG_ID_FIELD_NUMBER = 2;
        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int code_;
        private byte memoizedIsInitialized;
        private volatile Object message_;
        private long msgId_;
        private long timestamp_;
        private static final LiveMsgResponse DEFAULT_INSTANCE = new LiveMsgResponse();
        private static final Parser<LiveMsgResponse> PARSER = new AbstractParser<LiveMsgResponse>() { // from class: cn.irisgw.live.LiveChatOuterClass.LiveMsgResponse.1
            @Override // com.google.protobuf.Parser
            public LiveMsgResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LiveMsgResponse(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass$LiveMsgResponse$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveMsgResponseOrBuilder {
            private int code_;
            private Object message_;
            private long msgId_;
            private long timestamp_;

            private Builder() {
                this.code_ = 0;
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.code_ = 0;
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgResponse_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LiveMsgResponse.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LiveMsgResponse build() {
                LiveMsgResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LiveMsgResponse buildPartial() {
                LiveMsgResponse liveMsgResponse = new LiveMsgResponse(this);
                liveMsgResponse.code_ = this.code_;
                liveMsgResponse.msgId_ = this.msgId_;
                liveMsgResponse.timestamp_ = this.timestamp_;
                liveMsgResponse.message_ = this.message_;
                onBuilt();
                return liveMsgResponse;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.code_ = 0;
                this.msgId_ = 0L;
                this.timestamp_ = 0L;
                this.message_ = "";
                return this;
            }

            public Builder clearCode() {
                this.code_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearMessage() {
                this.message_ = LiveMsgResponse.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public Builder clearMsgId() {
                this.msgId_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearTimestamp() {
                this.timestamp_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgResponseOrBuilder
            public SendStatusCode getCode() {
                SendStatusCode valueOf = SendStatusCode.valueOf(this.code_);
                SendStatusCode sendStatusCode = valueOf;
                if (valueOf == null) {
                    sendStatusCode = SendStatusCode.UNRECOGNIZED;
                }
                return sendStatusCode;
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgResponseOrBuilder
            public int getCodeValue() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LiveMsgResponse getDefaultInstanceForType() {
                return LiveMsgResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgResponse_descriptor;
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgResponseOrBuilder
            public String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgResponseOrBuilder
            public ByteString getMessageBytes() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.message_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgResponseOrBuilder
            public long getMsgId() {
                return this.msgId_;
            }

            @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgResponseOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveMsgResponse.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(LiveMsgResponse liveMsgResponse) {
                if (liveMsgResponse == LiveMsgResponse.getDefaultInstance()) {
                    return this;
                }
                if (liveMsgResponse.code_ != 0) {
                    setCodeValue(liveMsgResponse.getCodeValue());
                }
                if (liveMsgResponse.getMsgId() != 0) {
                    setMsgId(liveMsgResponse.getMsgId());
                }
                if (liveMsgResponse.getTimestamp() != 0) {
                    setTimestamp(liveMsgResponse.getTimestamp());
                }
                if (!liveMsgResponse.getMessage().isEmpty()) {
                    this.message_ = liveMsgResponse.message_;
                    onChanged();
                }
                mergeUnknownFields(liveMsgResponse.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.LiveChatOuterClass.LiveMsgResponse.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.LiveChatOuterClass.LiveMsgResponse.access$2500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.LiveChatOuterClass$LiveMsgResponse r0 = (cn.irisgw.live.LiveChatOuterClass.LiveMsgResponse) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.LiveChatOuterClass$LiveMsgResponse$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.LiveChatOuterClass$LiveMsgResponse r0 = (cn.irisgw.live.LiveChatOuterClass.LiveMsgResponse) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.LiveChatOuterClass$LiveMsgResponse$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveChatOuterClass.LiveMsgResponse.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveChatOuterClass$LiveMsgResponse$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof LiveMsgResponse) {
                    return mergeFrom((LiveMsgResponse) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setCode(SendStatusCode sendStatusCode) {
                if (sendStatusCode != null) {
                    this.code_ = sendStatusCode.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCodeValue(int i) {
                this.code_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setMessage(String str) {
                if (str != null) {
                    this.message_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMessageBytes(ByteString byteString) {
                if (byteString != null) {
                    LiveMsgResponse.checkByteStringIsUtf8(byteString);
                    this.message_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMsgId(long j) {
                this.msgId_ = j;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setTimestamp(long j) {
                this.timestamp_ = j;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private LiveMsgResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.code_ = 0;
            this.message_ = "";
        }

        private LiveMsgResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.code_ = codedInputStream.readEnum();
                            } else if (readTag == 16) {
                                this.msgId_ = codedInputStream.readUInt64();
                            } else if (readTag == 24) {
                                this.timestamp_ = codedInputStream.readUInt64();
                            } else if (readTag == 34) {
                                this.message_ = codedInputStream.readStringRequireUtf8();
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

        private LiveMsgResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LiveMsgResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgResponse_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LiveMsgResponse liveMsgResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(liveMsgResponse);
        }

        public static LiveMsgResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LiveMsgResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LiveMsgResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveMsgResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveMsgResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LiveMsgResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LiveMsgResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LiveMsgResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LiveMsgResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveMsgResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static LiveMsgResponse parseFrom(InputStream inputStream) throws IOException {
            return (LiveMsgResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LiveMsgResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveMsgResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveMsgResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LiveMsgResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LiveMsgResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LiveMsgResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<LiveMsgResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof LiveMsgResponse) {
                LiveMsgResponse liveMsgResponse = (LiveMsgResponse) obj;
                return this.code_ == liveMsgResponse.code_ && getMsgId() == liveMsgResponse.getMsgId() && getTimestamp() == liveMsgResponse.getTimestamp() && getMessage().equals(liveMsgResponse.getMessage()) && this.unknownFields.equals(liveMsgResponse.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgResponseOrBuilder
        public SendStatusCode getCode() {
            SendStatusCode valueOf = SendStatusCode.valueOf(this.code_);
            SendStatusCode sendStatusCode = valueOf;
            if (valueOf == null) {
                sendStatusCode = SendStatusCode.UNRECOGNIZED;
            }
            return sendStatusCode;
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgResponseOrBuilder
        public int getCodeValue() {
            return this.code_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LiveMsgResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgResponseOrBuilder
        public String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.message_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgResponseOrBuilder
        public ByteString getMessageBytes() {
            Object obj = this.message_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgResponseOrBuilder
        public long getMsgId() {
            return this.msgId_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LiveMsgResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.code_ != SendStatusCode.SEND_EMPTY.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.code_);
            }
            long j = this.msgId_;
            int i3 = i2;
            if (j != 0) {
                i3 = i2 + CodedOutputStream.computeUInt64Size(2, j);
            }
            long j2 = this.timestamp_;
            int i4 = i3;
            if (j2 != 0) {
                i4 = i3 + CodedOutputStream.computeUInt64Size(3, j2);
            }
            int i5 = i4;
            if (!getMessageBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.message_);
            }
            int serializedSize = i5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.LiveChatOuterClass.LiveMsgResponseOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
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
            int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.code_) * 37) + 2) * 53) + Internal.hashLong(getMsgId())) * 37) + 3) * 53) + Internal.hashLong(getTimestamp())) * 37) + 4) * 53) + getMessage().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveMsgResponse.class, Builder.class);
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
            return new LiveMsgResponse();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.code_ != SendStatusCode.SEND_EMPTY.getNumber()) {
                codedOutputStream.writeEnum(1, this.code_);
            }
            long j = this.msgId_;
            if (j != 0) {
                codedOutputStream.writeUInt64(2, j);
            }
            long j2 = this.timestamp_;
            if (j2 != 0) {
                codedOutputStream.writeUInt64(3, j2);
            }
            if (!getMessageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.message_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass$LiveMsgResponseOrBuilder.class */
    public interface LiveMsgResponseOrBuilder extends MessageOrBuilder {
        SendStatusCode getCode();

        int getCodeValue();

        String getMessage();

        ByteString getMessageBytes();

        long getMsgId();

        long getTimestamp();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatOuterClass$SendStatusCode.class */
    public enum SendStatusCode implements ProtocolMessageEnum {
        SEND_EMPTY(0),
        SEND_OK(200),
        UNRECOGNIZED(-1);
        
        public static final int SEND_EMPTY_VALUE = 0;
        public static final int SEND_OK_VALUE = 200;
        private final int value;
        private static final Internal.EnumLiteMap<SendStatusCode> internalValueMap = new Internal.EnumLiteMap<SendStatusCode>() { // from class: cn.irisgw.live.LiveChatOuterClass.SendStatusCode.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public SendStatusCode findValueByNumber(int i) {
                return SendStatusCode.forNumber(i);
            }
        };
        private static final SendStatusCode[] VALUES = values();

        SendStatusCode(int i) {
            this.value = i;
        }

        public static SendStatusCode forNumber(int i) {
            if (i != 0) {
                if (i != 200) {
                    return null;
                }
                return SEND_OK;
            }
            return SEND_EMPTY;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LiveChatOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<SendStatusCode> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static SendStatusCode valueOf(int i) {
            return forNumber(i);
        }

        public static SendStatusCode valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_cn_irisgw_live_LiveMsgRequest_descriptor = descriptor2;
        internal_static_cn_irisgw_live_LiveMsgRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"LiveId", "Contents", "EmojiId"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_cn_irisgw_live_LiveMsgResponse_descriptor = descriptor3;
        internal_static_cn_irisgw_live_LiveMsgResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Code", "MsgId", "Timestamp", "Message"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_cn_irisgw_live_LiveLikeRequest_descriptor = descriptor4;
        internal_static_cn_irisgw_live_LiveLikeRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"LiveId", "Count", "HasFirstLike"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(3);
        internal_static_cn_irisgw_live_LiveLikeResponse_descriptor = descriptor5;
        internal_static_cn_irisgw_live_LiveLikeResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Code"});
    }

    private LiveChatOuterClass() {
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
