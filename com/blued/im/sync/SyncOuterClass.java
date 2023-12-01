package com.blued.im.sync;

import com.blued.im.sync.SyncErrorCode;
import com.blued.im.sync.SyncMessageOuterClass;
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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncOuterClass.class */
public final class SyncOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\nSync.proto\u0012\u0011com.blued.im.sync\u001a\u0013SyncErrorCode.proto\u001a\u0011SyncMessage.proto\"³\u0001\n\u000bSyncRequest\u0012.\n\tsync_type\u0018\u0001 \u0001(\u000e2\u001b.com.blued.im.sync.SyncType\u0012\u0010\n\blocal_id\u0018\u0002 \u0001(\r\u0012\u0015\n\rsync_local_id\u0018\u0003 \u0001(\r\u0012\u0012\n\nsession_id\u0018\u0004 \u0001(\r\u0012\u0014\n\fsession_type\u0018\u0005 \u0001(\r\u0012\u0010\n\bstart_id\u0018\u0006 \u0001(\u0004\u0012\u000f\n\u0007stop_id\u0018\u0007 \u0001(\u0004\"¨\u0001\n\fSyncResponse\u0012+\n\u0005error\u0018\u0001 \u0001(\u000e2\u001c.com.blued.im.sync.ErrorCode\u0012\u0010\n\bcontinue\u0018\u0002 \u0001(\r\u0012\u0010\n\blocal_id\u0018\u0003 \u0001(\r\u0012\u0015\n\rsync_local_id\u0018\u0004 \u0001(\r\u00120\n\bmessages\u0018\u0005 \u0003(\u000b2\u001e.com.blued.im.sync.SyncMessage*L\n\bSyncType\u0012\u0007\n\u0003Pad\u0010��\u0012\u000b\n\u0007SyncAll\u0010\u0001\u0012\u000b\n\u0007SyncNew\u0010\u0002\u0012\r\n\tSyncRange\u0010\u0003\u0012\u000e\n\nSyncLatest\u0010\u00042Q\n\u0004Sync\u0012I\n\u0004Sync\u0012\u001e.com.blued.im.sync.SyncRequest\u001a\u001f.com.blued.im.sync.SyncResponse\"��BFZ=git.ourbluecity.com/moka20477/Hermes-Sync-Main-Go/grpc/pbfile¢\u0002\u0004Syncb\u0006proto3"}, new Descriptors.FileDescriptor[]{SyncErrorCode.getDescriptor(), SyncMessageOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_blued_im_sync_SyncRequest_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_sync_SyncRequest_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_sync_SyncResponse_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_sync_SyncResponse_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncOuterClass$SyncRequest.class */
    public static final class SyncRequest extends GeneratedMessageV3 implements SyncRequestOrBuilder {
        public static final int LOCAL_ID_FIELD_NUMBER = 2;
        public static final int SESSION_ID_FIELD_NUMBER = 4;
        public static final int SESSION_TYPE_FIELD_NUMBER = 5;
        public static final int START_ID_FIELD_NUMBER = 6;
        public static final int STOP_ID_FIELD_NUMBER = 7;
        public static final int SYNC_LOCAL_ID_FIELD_NUMBER = 3;
        public static final int SYNC_TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int localId_;
        private byte memoizedIsInitialized;
        private int sessionId_;
        private int sessionType_;
        private long startId_;
        private long stopId_;
        private int syncLocalId_;
        private int syncType_;
        private static final SyncRequest DEFAULT_INSTANCE = new SyncRequest();
        private static final Parser<SyncRequest> PARSER = new AbstractParser<SyncRequest>() { // from class: com.blued.im.sync.SyncOuterClass.SyncRequest.1
            @Override // com.google.protobuf.Parser
            public SyncRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SyncRequest(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncOuterClass$SyncRequest$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SyncRequestOrBuilder {
            private int localId_;
            private int sessionId_;
            private int sessionType_;
            private long startId_;
            private long stopId_;
            private int syncLocalId_;
            private int syncType_;

            private Builder() {
                this.syncType_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.syncType_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SyncOuterClass.internal_static_com_blued_im_sync_SyncRequest_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SyncRequest.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SyncRequest build() {
                SyncRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SyncRequest buildPartial() {
                SyncRequest syncRequest = new SyncRequest(this);
                syncRequest.syncType_ = this.syncType_;
                syncRequest.localId_ = this.localId_;
                syncRequest.syncLocalId_ = this.syncLocalId_;
                syncRequest.sessionId_ = this.sessionId_;
                syncRequest.sessionType_ = this.sessionType_;
                syncRequest.startId_ = this.startId_;
                syncRequest.stopId_ = this.stopId_;
                onBuilt();
                return syncRequest;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.syncType_ = 0;
                this.localId_ = 0;
                this.syncLocalId_ = 0;
                this.sessionId_ = 0;
                this.sessionType_ = 0;
                this.startId_ = 0L;
                this.stopId_ = 0L;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearLocalId() {
                this.localId_ = 0;
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

            public Builder clearStartId() {
                this.startId_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearStopId() {
                this.stopId_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearSyncLocalId() {
                this.syncLocalId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSyncType() {
                this.syncType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SyncRequest getDefaultInstanceForType() {
                return SyncRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SyncOuterClass.internal_static_com_blued_im_sync_SyncRequest_descriptor;
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
            public int getLocalId() {
                return this.localId_;
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
            public int getSessionId() {
                return this.sessionId_;
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
            public int getSessionType() {
                return this.sessionType_;
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
            public long getStartId() {
                return this.startId_;
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
            public long getStopId() {
                return this.stopId_;
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
            public int getSyncLocalId() {
                return this.syncLocalId_;
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
            public SyncType getSyncType() {
                SyncType valueOf = SyncType.valueOf(this.syncType_);
                SyncType syncType = valueOf;
                if (valueOf == null) {
                    syncType = SyncType.UNRECOGNIZED;
                }
                return syncType;
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
            public int getSyncTypeValue() {
                return this.syncType_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SyncOuterClass.internal_static_com_blued_im_sync_SyncRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncRequest.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(SyncRequest syncRequest) {
                if (syncRequest == SyncRequest.getDefaultInstance()) {
                    return this;
                }
                if (syncRequest.syncType_ != 0) {
                    setSyncTypeValue(syncRequest.getSyncTypeValue());
                }
                if (syncRequest.getLocalId() != 0) {
                    setLocalId(syncRequest.getLocalId());
                }
                if (syncRequest.getSyncLocalId() != 0) {
                    setSyncLocalId(syncRequest.getSyncLocalId());
                }
                if (syncRequest.getSessionId() != 0) {
                    setSessionId(syncRequest.getSessionId());
                }
                if (syncRequest.getSessionType() != 0) {
                    setSessionType(syncRequest.getSessionType());
                }
                if (syncRequest.getStartId() != 0) {
                    setStartId(syncRequest.getStartId());
                }
                if (syncRequest.getStopId() != 0) {
                    setStopId(syncRequest.getStopId());
                }
                mergeUnknownFields(syncRequest.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.sync.SyncOuterClass.SyncRequest.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.sync.SyncOuterClass.SyncRequest.access$1400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.sync.SyncOuterClass$SyncRequest r0 = (com.blued.im.sync.SyncOuterClass.SyncRequest) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.sync.SyncOuterClass$SyncRequest$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.sync.SyncOuterClass$SyncRequest r0 = (com.blued.im.sync.SyncOuterClass.SyncRequest) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.sync.SyncOuterClass$SyncRequest$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.sync.SyncOuterClass.SyncRequest.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.sync.SyncOuterClass$SyncRequest$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof SyncRequest) {
                    return mergeFrom((SyncRequest) message);
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

            public Builder setLocalId(int i) {
                this.localId_ = i;
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

            public Builder setStartId(long j) {
                this.startId_ = j;
                onChanged();
                return this;
            }

            public Builder setStopId(long j) {
                this.stopId_ = j;
                onChanged();
                return this;
            }

            public Builder setSyncLocalId(int i) {
                this.syncLocalId_ = i;
                onChanged();
                return this;
            }

            public Builder setSyncType(SyncType syncType) {
                if (syncType != null) {
                    this.syncType_ = syncType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSyncTypeValue(int i) {
                this.syncType_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private SyncRequest() {
            this.memoizedIsInitialized = (byte) -1;
            this.syncType_ = 0;
        }

        private SyncRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.syncType_ = codedInputStream.readEnum();
                                } else if (readTag == 16) {
                                    this.localId_ = codedInputStream.readUInt32();
                                } else if (readTag == 24) {
                                    this.syncLocalId_ = codedInputStream.readUInt32();
                                } else if (readTag == 32) {
                                    this.sessionId_ = codedInputStream.readUInt32();
                                } else if (readTag == 40) {
                                    this.sessionType_ = codedInputStream.readUInt32();
                                } else if (readTag == 48) {
                                    this.startId_ = codedInputStream.readUInt64();
                                } else if (readTag == 56) {
                                    this.stopId_ = codedInputStream.readUInt64();
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

        private SyncRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SyncRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SyncOuterClass.internal_static_com_blued_im_sync_SyncRequest_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SyncRequest syncRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(syncRequest);
        }

        public static SyncRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SyncRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SyncRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SyncRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SyncRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SyncRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SyncRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SyncRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SyncRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SyncRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static SyncRequest parseFrom(InputStream inputStream) throws IOException {
            return (SyncRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SyncRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SyncRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SyncRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SyncRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SyncRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SyncRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<SyncRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof SyncRequest) {
                SyncRequest syncRequest = (SyncRequest) obj;
                return this.syncType_ == syncRequest.syncType_ && getLocalId() == syncRequest.getLocalId() && getSyncLocalId() == syncRequest.getSyncLocalId() && getSessionId() == syncRequest.getSessionId() && getSessionType() == syncRequest.getSessionType() && getStartId() == syncRequest.getStartId() && getStopId() == syncRequest.getStopId() && this.unknownFields.equals(syncRequest.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SyncRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
        public int getLocalId() {
            return this.localId_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SyncRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.syncType_ != SyncType.Pad.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.syncType_);
            }
            int i3 = this.localId_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeUInt32Size(2, i3);
            }
            int i5 = this.syncLocalId_;
            int i6 = i4;
            if (i5 != 0) {
                i6 = i4 + CodedOutputStream.computeUInt32Size(3, i5);
            }
            int i7 = this.sessionId_;
            int i8 = i6;
            if (i7 != 0) {
                i8 = i6 + CodedOutputStream.computeUInt32Size(4, i7);
            }
            int i9 = this.sessionType_;
            int i10 = i8;
            if (i9 != 0) {
                i10 = i8 + CodedOutputStream.computeUInt32Size(5, i9);
            }
            long j = this.startId_;
            int i11 = i10;
            if (j != 0) {
                i11 = i10 + CodedOutputStream.computeUInt64Size(6, j);
            }
            long j2 = this.stopId_;
            int i12 = i11;
            if (j2 != 0) {
                i12 = i11 + CodedOutputStream.computeUInt64Size(7, j2);
            }
            int serializedSize = i12 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
        public int getSessionId() {
            return this.sessionId_;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
        public int getSessionType() {
            return this.sessionType_;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
        public long getStartId() {
            return this.startId_;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
        public long getStopId() {
            return this.stopId_;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
        public int getSyncLocalId() {
            return this.syncLocalId_;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
        public SyncType getSyncType() {
            SyncType valueOf = SyncType.valueOf(this.syncType_);
            SyncType syncType = valueOf;
            if (valueOf == null) {
                syncType = SyncType.UNRECOGNIZED;
            }
            return syncType;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncRequestOrBuilder
        public int getSyncTypeValue() {
            return this.syncType_;
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
            int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.syncType_) * 37) + 2) * 53) + getLocalId()) * 37) + 3) * 53) + getSyncLocalId()) * 37) + 4) * 53) + getSessionId()) * 37) + 5) * 53) + getSessionType()) * 37) + 6) * 53) + Internal.hashLong(getStartId())) * 37) + 7) * 53) + Internal.hashLong(getStopId())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SyncOuterClass.internal_static_com_blued_im_sync_SyncRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncRequest.class, Builder.class);
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
            return new SyncRequest();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.syncType_ != SyncType.Pad.getNumber()) {
                codedOutputStream.writeEnum(1, this.syncType_);
            }
            int i = this.localId_;
            if (i != 0) {
                codedOutputStream.writeUInt32(2, i);
            }
            int i2 = this.syncLocalId_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(3, i2);
            }
            int i3 = this.sessionId_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(4, i3);
            }
            int i4 = this.sessionType_;
            if (i4 != 0) {
                codedOutputStream.writeUInt32(5, i4);
            }
            long j = this.startId_;
            if (j != 0) {
                codedOutputStream.writeUInt64(6, j);
            }
            long j2 = this.stopId_;
            if (j2 != 0) {
                codedOutputStream.writeUInt64(7, j2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncOuterClass$SyncRequestOrBuilder.class */
    public interface SyncRequestOrBuilder extends MessageOrBuilder {
        int getLocalId();

        int getSessionId();

        int getSessionType();

        long getStartId();

        long getStopId();

        int getSyncLocalId();

        SyncType getSyncType();

        int getSyncTypeValue();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncOuterClass$SyncResponse.class */
    public static final class SyncResponse extends GeneratedMessageV3 implements SyncResponseOrBuilder {
        public static final int CONTINUE_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int LOCAL_ID_FIELD_NUMBER = 3;
        public static final int MESSAGES_FIELD_NUMBER = 5;
        public static final int SYNC_LOCAL_ID_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int continue_;
        private int error_;
        private int localId_;
        private byte memoizedIsInitialized;
        private List<SyncMessageOuterClass.SyncMessage> messages_;
        private int syncLocalId_;
        private static final SyncResponse DEFAULT_INSTANCE = new SyncResponse();
        private static final Parser<SyncResponse> PARSER = new AbstractParser<SyncResponse>() { // from class: com.blued.im.sync.SyncOuterClass.SyncResponse.1
            @Override // com.google.protobuf.Parser
            public SyncResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SyncResponse(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncOuterClass$SyncResponse$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SyncResponseOrBuilder {
            private int bitField0_;
            private int continue_;
            private int error_;
            private int localId_;
            private RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> messagesBuilder_;
            private List<SyncMessageOuterClass.SyncMessage> messages_;
            private int syncLocalId_;

            private Builder() {
                this.error_ = 0;
                this.messages_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.error_ = 0;
                this.messages_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void ensureMessagesIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.messages_ = new ArrayList(this.messages_);
                    this.bitField0_ |= 1;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SyncOuterClass.internal_static_com_blued_im_sync_SyncResponse_descriptor;
            }

            private RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> getMessagesFieldBuilder() {
                if (this.messagesBuilder_ == null) {
                    List<SyncMessageOuterClass.SyncMessage> list = this.messages_;
                    boolean z = true;
                    if ((this.bitField0_ & 1) == 0) {
                        z = false;
                    }
                    this.messagesBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                    this.messages_ = null;
                }
                return this.messagesBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (SyncResponse.alwaysUseFieldBuilders) {
                    getMessagesFieldBuilder();
                }
            }

            public Builder addAllMessages(Iterable<? extends SyncMessageOuterClass.SyncMessage> iterable) {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                    return this;
                }
                ensureMessagesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.messages_);
                onChanged();
                return this;
            }

            public Builder addMessages(int i, SyncMessageOuterClass.SyncMessage.Builder builder) {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                    return this;
                }
                ensureMessagesIsMutable();
                this.messages_.add(i, builder.build());
                onChanged();
                return this;
            }

            public Builder addMessages(int i, SyncMessageOuterClass.SyncMessage syncMessage) {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, syncMessage);
                    return this;
                } else if (syncMessage != null) {
                    ensureMessagesIsMutable();
                    this.messages_.add(i, syncMessage);
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder addMessages(SyncMessageOuterClass.SyncMessage.Builder builder) {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                    return this;
                }
                ensureMessagesIsMutable();
                this.messages_.add(builder.build());
                onChanged();
                return this;
            }

            public Builder addMessages(SyncMessageOuterClass.SyncMessage syncMessage) {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(syncMessage);
                    return this;
                } else if (syncMessage != null) {
                    ensureMessagesIsMutable();
                    this.messages_.add(syncMessage);
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public SyncMessageOuterClass.SyncMessage.Builder addMessagesBuilder() {
                return getMessagesFieldBuilder().addBuilder(SyncMessageOuterClass.SyncMessage.getDefaultInstance());
            }

            public SyncMessageOuterClass.SyncMessage.Builder addMessagesBuilder(int i) {
                return getMessagesFieldBuilder().addBuilder(i, SyncMessageOuterClass.SyncMessage.getDefaultInstance());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SyncResponse build() {
                SyncResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SyncResponse buildPartial() {
                SyncResponse syncResponse = new SyncResponse(this);
                syncResponse.error_ = this.error_;
                syncResponse.continue_ = this.continue_;
                syncResponse.localId_ = this.localId_;
                syncResponse.syncLocalId_ = this.syncLocalId_;
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.messages_ = Collections.unmodifiableList(this.messages_);
                        this.bitField0_ &= -2;
                    }
                    syncResponse.messages_ = this.messages_;
                } else {
                    syncResponse.messages_ = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return syncResponse;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.error_ = 0;
                this.continue_ = 0;
                this.localId_ = 0;
                this.syncLocalId_ = 0;
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.clear();
                    return this;
                }
                this.messages_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearContinue() {
                this.continue_ = 0;
                onChanged();
                return this;
            }

            public Builder clearError() {
                this.error_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearLocalId() {
                this.localId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearMessages() {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.clear();
                    return this;
                }
                this.messages_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearSyncLocalId() {
                this.syncLocalId_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
            public int getContinue() {
                return this.continue_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SyncResponse getDefaultInstanceForType() {
                return SyncResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SyncOuterClass.internal_static_com_blued_im_sync_SyncResponse_descriptor;
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
            public SyncErrorCode.ErrorCode getError() {
                SyncErrorCode.ErrorCode valueOf = SyncErrorCode.ErrorCode.valueOf(this.error_);
                SyncErrorCode.ErrorCode errorCode = valueOf;
                if (valueOf == null) {
                    errorCode = SyncErrorCode.ErrorCode.UNRECOGNIZED;
                }
                return errorCode;
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
            public int getErrorValue() {
                return this.error_;
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
            public int getLocalId() {
                return this.localId_;
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
            public SyncMessageOuterClass.SyncMessage getMessages(int i) {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                return repeatedFieldBuilderV3 == null ? this.messages_.get(i) : repeatedFieldBuilderV3.getMessage(i);
            }

            public SyncMessageOuterClass.SyncMessage.Builder getMessagesBuilder(int i) {
                return getMessagesFieldBuilder().getBuilder(i);
            }

            public List<SyncMessageOuterClass.SyncMessage.Builder> getMessagesBuilderList() {
                return getMessagesFieldBuilder().getBuilderList();
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
            public int getMessagesCount() {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                return repeatedFieldBuilderV3 == null ? this.messages_.size() : repeatedFieldBuilderV3.getCount();
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
            public List<SyncMessageOuterClass.SyncMessage> getMessagesList() {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.messages_) : repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
            public SyncMessageOuterClass.SyncMessageOrBuilder getMessagesOrBuilder(int i) {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                return repeatedFieldBuilderV3 == null ? this.messages_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
            public List<? extends SyncMessageOuterClass.SyncMessageOrBuilder> getMessagesOrBuilderList() {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.messages_);
            }

            @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
            public int getSyncLocalId() {
                return this.syncLocalId_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SyncOuterClass.internal_static_com_blued_im_sync_SyncResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncResponse.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(SyncResponse syncResponse) {
                if (syncResponse == SyncResponse.getDefaultInstance()) {
                    return this;
                }
                if (syncResponse.error_ != 0) {
                    setErrorValue(syncResponse.getErrorValue());
                }
                if (syncResponse.getContinue() != 0) {
                    setContinue(syncResponse.getContinue());
                }
                if (syncResponse.getLocalId() != 0) {
                    setLocalId(syncResponse.getLocalId());
                }
                if (syncResponse.getSyncLocalId() != 0) {
                    setSyncLocalId(syncResponse.getSyncLocalId());
                }
                if (this.messagesBuilder_ == null) {
                    if (!syncResponse.messages_.isEmpty()) {
                        if (this.messages_.isEmpty()) {
                            this.messages_ = syncResponse.messages_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMessagesIsMutable();
                            this.messages_.addAll(syncResponse.messages_);
                        }
                        onChanged();
                    }
                } else if (!syncResponse.messages_.isEmpty()) {
                    if (this.messagesBuilder_.isEmpty()) {
                        this.messagesBuilder_.dispose();
                        RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = null;
                        this.messagesBuilder_ = null;
                        this.messages_ = syncResponse.messages_;
                        this.bitField0_ &= -2;
                        if (SyncResponse.alwaysUseFieldBuilders) {
                            repeatedFieldBuilderV3 = getMessagesFieldBuilder();
                        }
                        this.messagesBuilder_ = repeatedFieldBuilderV3;
                    } else {
                        this.messagesBuilder_.addAllMessages(syncResponse.messages_);
                    }
                }
                mergeUnknownFields(syncResponse.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.sync.SyncOuterClass.SyncResponse.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.sync.SyncOuterClass.SyncResponse.access$2900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.sync.SyncOuterClass$SyncResponse r0 = (com.blued.im.sync.SyncOuterClass.SyncResponse) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.sync.SyncOuterClass$SyncResponse$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.sync.SyncOuterClass$SyncResponse r0 = (com.blued.im.sync.SyncOuterClass.SyncResponse) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.sync.SyncOuterClass$SyncResponse$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.sync.SyncOuterClass.SyncResponse.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.sync.SyncOuterClass$SyncResponse$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof SyncResponse) {
                    return mergeFrom((SyncResponse) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder removeMessages(int i) {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.remove(i);
                    return this;
                }
                ensureMessagesIsMutable();
                this.messages_.remove(i);
                onChanged();
                return this;
            }

            public Builder setContinue(int i) {
                this.continue_ = i;
                onChanged();
                return this;
            }

            public Builder setError(SyncErrorCode.ErrorCode errorCode) {
                if (errorCode != null) {
                    this.error_ = errorCode.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setErrorValue(int i) {
                this.error_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setLocalId(int i) {
                this.localId_ = i;
                onChanged();
                return this;
            }

            public Builder setMessages(int i, SyncMessageOuterClass.SyncMessage.Builder builder) {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                    return this;
                }
                ensureMessagesIsMutable();
                this.messages_.set(i, builder.build());
                onChanged();
                return this;
            }

            public Builder setMessages(int i, SyncMessageOuterClass.SyncMessage syncMessage) {
                RepeatedFieldBuilderV3<SyncMessageOuterClass.SyncMessage, SyncMessageOuterClass.SyncMessage.Builder, SyncMessageOuterClass.SyncMessageOrBuilder> repeatedFieldBuilderV3 = this.messagesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, syncMessage);
                    return this;
                } else if (syncMessage != null) {
                    ensureMessagesIsMutable();
                    this.messages_.set(i, syncMessage);
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

            public Builder setSyncLocalId(int i) {
                this.syncLocalId_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private SyncResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.error_ = 0;
            this.messages_ = Collections.emptyList();
        }

        private SyncResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.error_ = codedInputStream.readEnum();
                            } else if (readTag == 16) {
                                this.continue_ = codedInputStream.readUInt32();
                            } else if (readTag == 24) {
                                this.localId_ = codedInputStream.readUInt32();
                            } else if (readTag == 32) {
                                this.syncLocalId_ = codedInputStream.readUInt32();
                            } else if (readTag == 42) {
                                boolean z4 = z2;
                                if (!(z2 & true)) {
                                    this.messages_ = new ArrayList();
                                    z4 = z2 | true;
                                }
                                this.messages_.add((SyncMessageOuterClass.SyncMessage) codedInputStream.readMessage(SyncMessageOuterClass.SyncMessage.parser(), extensionRegistryLite));
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
                        this.messages_ = Collections.unmodifiableList(this.messages_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.messages_ = Collections.unmodifiableList(this.messages_);
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private SyncResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SyncResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SyncOuterClass.internal_static_com_blued_im_sync_SyncResponse_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SyncResponse syncResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(syncResponse);
        }

        public static SyncResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SyncResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SyncResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SyncResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SyncResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SyncResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SyncResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SyncResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SyncResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SyncResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static SyncResponse parseFrom(InputStream inputStream) throws IOException {
            return (SyncResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SyncResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SyncResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SyncResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SyncResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SyncResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SyncResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<SyncResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof SyncResponse) {
                SyncResponse syncResponse = (SyncResponse) obj;
                return this.error_ == syncResponse.error_ && getContinue() == syncResponse.getContinue() && getLocalId() == syncResponse.getLocalId() && getSyncLocalId() == syncResponse.getSyncLocalId() && getMessagesList().equals(syncResponse.getMessagesList()) && this.unknownFields.equals(syncResponse.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
        public int getContinue() {
            return this.continue_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SyncResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
        public SyncErrorCode.ErrorCode getError() {
            SyncErrorCode.ErrorCode valueOf = SyncErrorCode.ErrorCode.valueOf(this.error_);
            SyncErrorCode.ErrorCode errorCode = valueOf;
            if (valueOf == null) {
                errorCode = SyncErrorCode.ErrorCode.UNRECOGNIZED;
            }
            return errorCode;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
        public int getErrorValue() {
            return this.error_;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
        public int getLocalId() {
            return this.localId_;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
        public SyncMessageOuterClass.SyncMessage getMessages(int i) {
            return this.messages_.get(i);
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
        public int getMessagesCount() {
            return this.messages_.size();
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
        public List<SyncMessageOuterClass.SyncMessage> getMessagesList() {
            return this.messages_;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
        public SyncMessageOuterClass.SyncMessageOrBuilder getMessagesOrBuilder(int i) {
            return this.messages_.get(i);
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
        public List<? extends SyncMessageOuterClass.SyncMessageOrBuilder> getMessagesOrBuilderList() {
            return this.messages_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SyncResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = this.error_ != SyncErrorCode.ErrorCode.ErrorCodeOK.getNumber() ? CodedOutputStream.computeEnumSize(1, this.error_) + 0 : 0;
            int i2 = this.continue_;
            int i3 = computeEnumSize;
            if (i2 != 0) {
                i3 = computeEnumSize + CodedOutputStream.computeUInt32Size(2, i2);
            }
            int i4 = this.localId_;
            int i5 = i3;
            if (i4 != 0) {
                i5 = i3 + CodedOutputStream.computeUInt32Size(3, i4);
            }
            int i6 = this.syncLocalId_;
            int i7 = i5;
            int i8 = 0;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeUInt32Size(4, i6);
                i8 = 0;
            }
            while (i8 < this.messages_.size()) {
                i7 += CodedOutputStream.computeMessageSize(5, this.messages_.get(i8));
                i8++;
            }
            int serializedSize = i7 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.sync.SyncOuterClass.SyncResponseOrBuilder
        public int getSyncLocalId() {
            return this.syncLocalId_;
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
            int hashCode = ((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.error_) * 37) + 2) * 53) + getContinue()) * 37) + 3) * 53) + getLocalId()) * 37) + 4) * 53) + getSyncLocalId();
            int i = hashCode;
            if (getMessagesCount() > 0) {
                i = (((hashCode * 37) + 5) * 53) + getMessagesList().hashCode();
            }
            int hashCode2 = (i * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SyncOuterClass.internal_static_com_blued_im_sync_SyncResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncResponse.class, Builder.class);
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
            return new SyncResponse();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.error_ != SyncErrorCode.ErrorCode.ErrorCodeOK.getNumber()) {
                codedOutputStream.writeEnum(1, this.error_);
            }
            int i = this.continue_;
            if (i != 0) {
                codedOutputStream.writeUInt32(2, i);
            }
            int i2 = this.localId_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(3, i2);
            }
            int i3 = this.syncLocalId_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(4, i3);
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.messages_.size()) {
                    this.unknownFields.writeTo(codedOutputStream);
                    return;
                } else {
                    codedOutputStream.writeMessage(5, this.messages_.get(i5));
                    i4 = i5 + 1;
                }
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncOuterClass$SyncResponseOrBuilder.class */
    public interface SyncResponseOrBuilder extends MessageOrBuilder {
        int getContinue();

        SyncErrorCode.ErrorCode getError();

        int getErrorValue();

        int getLocalId();

        SyncMessageOuterClass.SyncMessage getMessages(int i);

        int getMessagesCount();

        List<SyncMessageOuterClass.SyncMessage> getMessagesList();

        SyncMessageOuterClass.SyncMessageOrBuilder getMessagesOrBuilder(int i);

        List<? extends SyncMessageOuterClass.SyncMessageOrBuilder> getMessagesOrBuilderList();

        int getSyncLocalId();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncOuterClass$SyncType.class */
    public enum SyncType implements ProtocolMessageEnum {
        Pad(0),
        SyncAll(1),
        SyncNew(2),
        SyncRange(3),
        SyncLatest(4),
        UNRECOGNIZED(-1);
        
        public static final int Pad_VALUE = 0;
        public static final int SyncAll_VALUE = 1;
        public static final int SyncLatest_VALUE = 4;
        public static final int SyncNew_VALUE = 2;
        public static final int SyncRange_VALUE = 3;
        private final int value;
        private static final Internal.EnumLiteMap<SyncType> internalValueMap = new Internal.EnumLiteMap<SyncType>() { // from class: com.blued.im.sync.SyncOuterClass.SyncType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public SyncType findValueByNumber(int i) {
                return SyncType.forNumber(i);
            }
        };
        private static final SyncType[] VALUES = values();

        SyncType(int i) {
            this.value = i;
        }

        public static SyncType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return SyncLatest;
                        }
                        return SyncRange;
                    }
                    return SyncNew;
                }
                return SyncAll;
            }
            return Pad;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return SyncOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<SyncType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static SyncType valueOf(int i) {
            return forNumber(i);
        }

        public static SyncType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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
        internal_static_com_blued_im_sync_SyncRequest_descriptor = descriptor2;
        internal_static_com_blued_im_sync_SyncRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"SyncType", "LocalId", "SyncLocalId", "SessionId", "SessionType", "StartId", "StopId"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_blued_im_sync_SyncResponse_descriptor = descriptor3;
        internal_static_com_blued_im_sync_SyncResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Error", "Continue", "LocalId", "SyncLocalId", "Messages"});
        SyncErrorCode.getDescriptor();
        SyncMessageOuterClass.getDescriptor();
    }

    private SyncOuterClass() {
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
