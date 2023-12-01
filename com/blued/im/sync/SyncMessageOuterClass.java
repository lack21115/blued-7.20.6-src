package com.blued.im.sync;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncMessageOuterClass.class */
public final class SyncMessageOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011SyncMessage.proto\u0012\u0011com.blued.im.sync\"³\u0001\n\u000bSyncMessage\u0012\u0014\n\fsession_type\u0018\u0001 \u0001(\r\u0012\u0012\n\nsession_id\u0018\u0002 \u0001(\r\u0012\u000e\n\u0006msg_id\u0018\u0003 \u0001(\u0004\u0012\u0011\n\ttimestamp\u0018\u0004 \u0001(\u0004\u0012\u0010\n\bdistance\u0018\u0005 \u0001(\u0001\u0012\f\n\u0004body\u0018\u0006 \u0001(\t\u0012\u0012\n\n__COORDS__\u0018\u0007 \u0003(\u0001\u0012\u000f\n\u0007is_read\u0018\b \u0001(\r\u0012\u0012\n\nis_deleted\u0018\t \u0001(\rBFZ=git.ourbluecity.com/moka20477/Hermes-Sync-Main-Go/grpc/pbfile¢\u0002\u0004Syncb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_im_sync_SyncMessage_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_sync_SyncMessage_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncMessageOuterClass$SyncMessage.class */
    public static final class SyncMessage extends GeneratedMessageV3 implements SyncMessageOrBuilder {
        public static final int BODY_FIELD_NUMBER = 6;
        public static final int DISTANCE_FIELD_NUMBER = 5;
        public static final int IS_DELETED_FIELD_NUMBER = 9;
        public static final int IS_READ_FIELD_NUMBER = 8;
        public static final int MSG_ID_FIELD_NUMBER = 3;
        public static final int SESSION_ID_FIELD_NUMBER = 2;
        public static final int SESSION_TYPE_FIELD_NUMBER = 1;
        public static final int TIMESTAMP_FIELD_NUMBER = 4;
        public static final int __COORDS___FIELD_NUMBER = 7;
        private static final long serialVersionUID = 0;
        private int COORDSMemoizedSerializedSize;
        private Internal.DoubleList COORDS_;
        private volatile Object body_;
        private double distance_;
        private int isDeleted_;
        private int isRead_;
        private byte memoizedIsInitialized;
        private long msgId_;
        private int sessionId_;
        private int sessionType_;
        private long timestamp_;
        private static final SyncMessage DEFAULT_INSTANCE = new SyncMessage();
        private static final Parser<SyncMessage> PARSER = new AbstractParser<SyncMessage>() { // from class: com.blued.im.sync.SyncMessageOuterClass.SyncMessage.1
            @Override // com.google.protobuf.Parser
            public SyncMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SyncMessage(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncMessageOuterClass$SyncMessage$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SyncMessageOrBuilder {
            private Internal.DoubleList COORDS_;
            private int bitField0_;
            private Object body_;
            private double distance_;
            private int isDeleted_;
            private int isRead_;
            private long msgId_;
            private int sessionId_;
            private int sessionType_;
            private long timestamp_;

            private Builder() {
                this.body_ = "";
                this.COORDS_ = SyncMessage.access$1900();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.body_ = "";
                this.COORDS_ = SyncMessage.access$1900();
                maybeForceBuilderInitialization();
            }

            private void ensureCOORDSIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.COORDS_ = SyncMessage.mutableCopy(this.COORDS_);
                    this.bitField0_ |= 1;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SyncMessageOuterClass.internal_static_com_blued_im_sync_SyncMessage_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SyncMessage.alwaysUseFieldBuilders;
            }

            public Builder addAllCOORDS(Iterable<? extends Double> iterable) {
                ensureCOORDSIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.COORDS_);
                onChanged();
                return this;
            }

            public Builder addCOORDS(double d) {
                ensureCOORDSIsMutable();
                this.COORDS_.addDouble(d);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SyncMessage build() {
                SyncMessage buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SyncMessage buildPartial() {
                SyncMessage syncMessage = new SyncMessage(this);
                syncMessage.sessionType_ = this.sessionType_;
                syncMessage.sessionId_ = this.sessionId_;
                syncMessage.msgId_ = this.msgId_;
                syncMessage.timestamp_ = this.timestamp_;
                syncMessage.distance_ = this.distance_;
                syncMessage.body_ = this.body_;
                if ((this.bitField0_ & 1) != 0) {
                    this.COORDS_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                syncMessage.COORDS_ = this.COORDS_;
                syncMessage.isRead_ = this.isRead_;
                syncMessage.isDeleted_ = this.isDeleted_;
                onBuilt();
                return syncMessage;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.sessionType_ = 0;
                this.sessionId_ = 0;
                this.msgId_ = 0L;
                this.timestamp_ = 0L;
                this.distance_ = 0.0d;
                this.body_ = "";
                this.COORDS_ = SyncMessage.access$500();
                this.bitField0_ &= -2;
                this.isRead_ = 0;
                this.isDeleted_ = 0;
                return this;
            }

            public Builder clearBody() {
                this.body_ = SyncMessage.getDefaultInstance().getBody();
                onChanged();
                return this;
            }

            public Builder clearCOORDS() {
                this.COORDS_ = SyncMessage.access$2100();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearDistance() {
                this.distance_ = 0.0d;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearIsDeleted() {
                this.isDeleted_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIsRead() {
                this.isRead_ = 0;
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

            public Builder clearSessionId() {
                this.sessionId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSessionType() {
                this.sessionType_ = 0;
                onChanged();
                return this;
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

            @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
            public String getBody() {
                Object obj = this.body_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.body_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
            public ByteString getBodyBytes() {
                Object obj = this.body_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.body_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
            public double getCOORDS(int i) {
                return this.COORDS_.getDouble(i);
            }

            @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
            public int getCOORDSCount() {
                return this.COORDS_.size();
            }

            @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
            public List<Double> getCOORDSList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.COORDS_) : this.COORDS_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SyncMessage getDefaultInstanceForType() {
                return SyncMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SyncMessageOuterClass.internal_static_com_blued_im_sync_SyncMessage_descriptor;
            }

            @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
            public double getDistance() {
                return this.distance_;
            }

            @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
            public int getIsDeleted() {
                return this.isDeleted_;
            }

            @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
            public int getIsRead() {
                return this.isRead_;
            }

            @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
            public long getMsgId() {
                return this.msgId_;
            }

            @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
            public int getSessionId() {
                return this.sessionId_;
            }

            @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
            public int getSessionType() {
                return this.sessionType_;
            }

            @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SyncMessageOuterClass.internal_static_com_blued_im_sync_SyncMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncMessage.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(SyncMessage syncMessage) {
                if (syncMessage == SyncMessage.getDefaultInstance()) {
                    return this;
                }
                if (syncMessage.getSessionType() != 0) {
                    setSessionType(syncMessage.getSessionType());
                }
                if (syncMessage.getSessionId() != 0) {
                    setSessionId(syncMessage.getSessionId());
                }
                if (syncMessage.getMsgId() != 0) {
                    setMsgId(syncMessage.getMsgId());
                }
                if (syncMessage.getTimestamp() != 0) {
                    setTimestamp(syncMessage.getTimestamp());
                }
                if (syncMessage.getDistance() != 0.0d) {
                    setDistance(syncMessage.getDistance());
                }
                if (!syncMessage.getBody().isEmpty()) {
                    this.body_ = syncMessage.body_;
                    onChanged();
                }
                if (!syncMessage.COORDS_.isEmpty()) {
                    if (this.COORDS_.isEmpty()) {
                        this.COORDS_ = syncMessage.COORDS_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureCOORDSIsMutable();
                        this.COORDS_.addAll(syncMessage.COORDS_);
                    }
                    onChanged();
                }
                if (syncMessage.getIsRead() != 0) {
                    setIsRead(syncMessage.getIsRead());
                }
                if (syncMessage.getIsDeleted() != 0) {
                    setIsDeleted(syncMessage.getIsDeleted());
                }
                mergeUnknownFields(syncMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.sync.SyncMessageOuterClass.SyncMessage.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.sync.SyncMessageOuterClass.SyncMessage.access$1700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.sync.SyncMessageOuterClass$SyncMessage r0 = (com.blued.im.sync.SyncMessageOuterClass.SyncMessage) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.sync.SyncMessageOuterClass$SyncMessage$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.sync.SyncMessageOuterClass$SyncMessage r0 = (com.blued.im.sync.SyncMessageOuterClass.SyncMessage) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.sync.SyncMessageOuterClass$SyncMessage$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.sync.SyncMessageOuterClass.SyncMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.sync.SyncMessageOuterClass$SyncMessage$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof SyncMessage) {
                    return mergeFrom((SyncMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBody(String str) {
                if (str != null) {
                    this.body_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBodyBytes(ByteString byteString) {
                if (byteString != null) {
                    SyncMessage.checkByteStringIsUtf8(byteString);
                    this.body_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCOORDS(int i, double d) {
                ensureCOORDSIsMutable();
                this.COORDS_.setDouble(i, d);
                onChanged();
                return this;
            }

            public Builder setDistance(double d) {
                this.distance_ = d;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setIsDeleted(int i) {
                this.isDeleted_ = i;
                onChanged();
                return this;
            }

            public Builder setIsRead(int i) {
                this.isRead_ = i;
                onChanged();
                return this;
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

            public Builder setSessionId(int i) {
                this.sessionId_ = i;
                onChanged();
                return this;
            }

            public Builder setSessionType(int i) {
                this.sessionType_ = i;
                onChanged();
                return this;
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

        private SyncMessage() {
            this.COORDSMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.body_ = "";
            this.COORDS_ = emptyDoubleList();
        }

        private SyncMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 8) {
                                this.sessionType_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.sessionId_ = codedInputStream.readUInt32();
                            } else if (readTag == 24) {
                                this.msgId_ = codedInputStream.readUInt64();
                            } else if (readTag == 32) {
                                this.timestamp_ = codedInputStream.readUInt64();
                            } else if (readTag == 41) {
                                this.distance_ = codedInputStream.readDouble();
                            } else if (readTag == 50) {
                                this.body_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 64) {
                                this.isRead_ = codedInputStream.readUInt32();
                            } else if (readTag == 72) {
                                this.isDeleted_ = codedInputStream.readUInt32();
                            } else if (readTag == 57) {
                                boolean z4 = z2;
                                if (!(z2 & true)) {
                                    this.COORDS_ = newDoubleList();
                                    z4 = z2 | true;
                                }
                                this.COORDS_.addDouble(codedInputStream.readDouble());
                                z2 = z4;
                            } else if (readTag == 58) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                boolean z5 = z2;
                                if (!(z2 & true)) {
                                    z5 = z2;
                                    if (codedInputStream.getBytesUntilLimit() > 0) {
                                        boolean z6 = z2;
                                        this.COORDS_ = newDoubleList();
                                        z5 = z2 | true;
                                    }
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    boolean z7 = z5;
                                    this.COORDS_.addDouble(codedInputStream.readDouble());
                                }
                                codedInputStream.popLimit(pushLimit);
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
                        this.COORDS_.makeImmutable();
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.COORDS_.makeImmutable();
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private SyncMessage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.COORDSMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        static /* synthetic */ Internal.DoubleList access$1900() {
            return emptyDoubleList();
        }

        static /* synthetic */ Internal.DoubleList access$2100() {
            return emptyDoubleList();
        }

        static /* synthetic */ Internal.DoubleList access$500() {
            return emptyDoubleList();
        }

        public static SyncMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SyncMessageOuterClass.internal_static_com_blued_im_sync_SyncMessage_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SyncMessage syncMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(syncMessage);
        }

        public static SyncMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SyncMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SyncMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SyncMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SyncMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SyncMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SyncMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SyncMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SyncMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SyncMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static SyncMessage parseFrom(InputStream inputStream) throws IOException {
            return (SyncMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SyncMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SyncMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SyncMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SyncMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SyncMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SyncMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<SyncMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof SyncMessage) {
                SyncMessage syncMessage = (SyncMessage) obj;
                return getSessionType() == syncMessage.getSessionType() && getSessionId() == syncMessage.getSessionId() && getMsgId() == syncMessage.getMsgId() && getTimestamp() == syncMessage.getTimestamp() && Double.doubleToLongBits(getDistance()) == Double.doubleToLongBits(syncMessage.getDistance()) && getBody().equals(syncMessage.getBody()) && getCOORDSList().equals(syncMessage.getCOORDSList()) && getIsRead() == syncMessage.getIsRead() && getIsDeleted() == syncMessage.getIsDeleted() && this.unknownFields.equals(syncMessage.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
        public String getBody() {
            Object obj = this.body_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.body_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
        public ByteString getBodyBytes() {
            Object obj = this.body_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.body_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
        public double getCOORDS(int i) {
            return this.COORDS_.getDouble(i);
        }

        @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
        public int getCOORDSCount() {
            return this.COORDS_.size();
        }

        @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
        public List<Double> getCOORDSList() {
            return this.COORDS_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SyncMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
        public double getDistance() {
            return this.distance_;
        }

        @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
        public int getIsDeleted() {
            return this.isDeleted_;
        }

        @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
        public int getIsRead() {
            return this.isRead_;
        }

        @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
        public long getMsgId() {
            return this.msgId_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SyncMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.sessionType_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
            }
            int i4 = this.sessionId_;
            int i5 = i2;
            if (i4 != 0) {
                i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
            }
            long j = this.msgId_;
            int i6 = i5;
            if (j != 0) {
                i6 = i5 + CodedOutputStream.computeUInt64Size(3, j);
            }
            long j2 = this.timestamp_;
            int i7 = i6;
            if (j2 != 0) {
                i7 = i6 + CodedOutputStream.computeUInt64Size(4, j2);
            }
            double d = this.distance_;
            int i8 = i7;
            if (d != 0.0d) {
                i8 = i7 + CodedOutputStream.computeDoubleSize(5, d);
            }
            int i9 = i8;
            if (!getBodyBytes().isEmpty()) {
                i9 = i8 + GeneratedMessageV3.computeStringSize(6, this.body_);
            }
            int size = getCOORDSList().size() * 8;
            int i10 = i9 + size;
            int i11 = i10;
            if (!getCOORDSList().isEmpty()) {
                i11 = i10 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.COORDSMemoizedSerializedSize = size;
            int i12 = this.isRead_;
            int i13 = i11;
            if (i12 != 0) {
                i13 = i11 + CodedOutputStream.computeUInt32Size(8, i12);
            }
            int i14 = this.isDeleted_;
            int i15 = i13;
            if (i14 != 0) {
                i15 = i13 + CodedOutputStream.computeUInt32Size(9, i14);
            }
            int serializedSize = i15 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
        public int getSessionId() {
            return this.sessionId_;
        }

        @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
        public int getSessionType() {
            return this.sessionType_;
        }

        @Override // com.blued.im.sync.SyncMessageOuterClass.SyncMessageOrBuilder
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
            int hashCode = ((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getSessionType()) * 37) + 2) * 53) + getSessionId()) * 37) + 3) * 53) + Internal.hashLong(getMsgId())) * 37) + 4) * 53) + Internal.hashLong(getTimestamp())) * 37) + 5) * 53) + Internal.hashLong(Double.doubleToLongBits(getDistance()))) * 37) + 6) * 53) + getBody().hashCode();
            int i = hashCode;
            if (getCOORDSCount() > 0) {
                i = (((hashCode * 37) + 7) * 53) + getCOORDSList().hashCode();
            }
            int isRead = (((((((((i * 37) + 8) * 53) + getIsRead()) * 37) + 9) * 53) + getIsDeleted()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = isRead;
            return isRead;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SyncMessageOuterClass.internal_static_com_blued_im_sync_SyncMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncMessage.class, Builder.class);
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
            return new SyncMessage();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            int i = this.sessionType_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            int i2 = this.sessionId_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(2, i2);
            }
            long j = this.msgId_;
            if (j != 0) {
                codedOutputStream.writeUInt64(3, j);
            }
            long j2 = this.timestamp_;
            if (j2 != 0) {
                codedOutputStream.writeUInt64(4, j2);
            }
            double d = this.distance_;
            if (d != 0.0d) {
                codedOutputStream.writeDouble(5, d);
            }
            if (!getBodyBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.body_);
            }
            if (getCOORDSList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(58);
                codedOutputStream.writeUInt32NoTag(this.COORDSMemoizedSerializedSize);
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.COORDS_.size()) {
                    break;
                }
                codedOutputStream.writeDoubleNoTag(this.COORDS_.getDouble(i4));
                i3 = i4 + 1;
            }
            int i5 = this.isRead_;
            if (i5 != 0) {
                codedOutputStream.writeUInt32(8, i5);
            }
            int i6 = this.isDeleted_;
            if (i6 != 0) {
                codedOutputStream.writeUInt32(9, i6);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncMessageOuterClass$SyncMessageOrBuilder.class */
    public interface SyncMessageOrBuilder extends MessageOrBuilder {
        String getBody();

        ByteString getBodyBytes();

        double getCOORDS(int i);

        int getCOORDSCount();

        List<Double> getCOORDSList();

        double getDistance();

        int getIsDeleted();

        int getIsRead();

        long getMsgId();

        int getSessionId();

        int getSessionType();

        long getTimestamp();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_im_sync_SyncMessage_descriptor = descriptor2;
        internal_static_com_blued_im_sync_SyncMessage_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"SessionType", "SessionId", "MsgId", "Timestamp", "Distance", "Body", "COORDS", "IsRead", "IsDeleted"});
    }

    private SyncMessageOuterClass() {
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
