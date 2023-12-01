package com.blued.das.apm;

import com.blued.das.CommonProtos;
import com.google.protobuf.AbstractMessageLite;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos.class */
public final class ApmProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fApmProtos.proto\u0012\u0011com.blued.das.apm\u001a\u0019google/protobuf/any.proto\u001a\u0012CommonProtos.proto\"ì\u0001\n\u0007Request\u0012%\n\u0004type\u0018\u0001 \u0001(\u000e2\u0017.com.blued.das.apm.Type\u0012\f\n\u0004time\u0018\u0002 \u0001(\u0003\u0012\r\n\u0005takes\u0018\u0003 \u0001(\u0005\u0012\f\n\u0004code\u0018\u0004 \u0001(\u0005\u0012\u0013\n\u000bdescription\u0018\u0005 \u0001(\t\u0012#\n\u0005extra\u0018\u0006 \u0001(\u000b2\u0014.google.protobuf.Any\u0012%\n\u0006common\u0018\u0007 \u0001(\u000b2\u0015.com.blued.das.Common\u0012\u0013\n\u000bclient_time\u0018\b \u0001(\u0003\u0012\u0019\n\u0011server_request_id\u0018\t \u0001(\t\"_\n\rHttpTypeProto\u0012\u000b\n\u0003url\u0018\u0001 \u0001(\t\u0012\u0015\n\rresponse_type\u0018\u0002 \u0001(\t\u0012\u0017\n\u000fresponse_length\u0018\u0003 \u0001(\u0005\u0012\u0011\n\tserver_ip\u0018\u0004 \u0001(\t\"\u001e\n\u000eAlertTypeProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\"J\n\u000bImTypeProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\f\n\u0004host\u0018\u0002 \u0001(\t\u0012\f\n\u0004port\u0018\u0003 \u0001(\u0005\u0012\u0011\n\tserver_ip\u0018\u0004 \u0001(\t\"ò\u0001\n\u0014GrpcRequestTypeProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\f\n\u0004host\u0018\u0002 \u0001(\t\u0012\f\n\u0004port\u0018\u0003 \u0001(\u0005\u0012\u0011\n\tserver_ip\u0018\u0004 \u0001(\t\u0012B\n\bbusiness\u0018\u0005 \u0001(\u000e20.com.blued.das.apm.GrpcRequestTypeProto.BUSINESS\"Y\n\bBUSINESS\u0012\u0014\n\u0010UNKNOWN_BUSINESS\u0010��\u0012\u0010\n\fPRIVATE_CHAT\u0010\u0001\u0012\u0006\n\u0002YY\u0010\u0002\u0012\r\n\tLIVE_CHAT\u0010\u0003\u0012\u000e\n\nGROUP_CHAT\u0010\u0004\"@\n\u000fSocketTypeProto\u0012\f\n\u0004host\u0018\u0001 \u0001(\t\u0012\f\n\u0004port\u0018\u0002 \u0001(\u0005\u0012\u0011\n\tserver_ip\u0018\u0003 \u0001(\t\"Ô\u0001\n\u0014GrpcConnectTypeProto\u0012\f\n\u0004host\u0018\u0001 \u0001(\t\u0012\f\n\u0004port\u0018\u0002 \u0001(\u0005\u0012\u0011\n\tserver_ip\u0018\u0003 \u0001(\t\u0012B\n\bbusiness\u0018\u0004 \u0001(\u000e20.com.blued.das.apm.GrpcConnectTypeProto.BUSINESS\"I\n\bBUSINESS\u0012\u0014\n\u0010UNKNOWN_BUSINESS\u0010��\u0012\u0010\n\fPRIVATE_CHAT\u0010\u0001\u0012\u0006\n\u0002YY\u0010\u0002\u0012\r\n\tLIVE_CHAT\u0010\u0003\"\u008f\u0001\n\u0011ErosGrpcTypeProto\u0012?\n\u0004type\u0018\u0004 \u0001(\u000e21.com.blued.das.apm.ErosGrpcTypeProto.ErosGrpcType\"9\n\fErosGrpcType\u0012\u0015\n\u0011UNKNOWN_EROS_TYPE\u0010��\u0012\b\n\u0004AUTH\u0010\u0001\u0012\b\n\u0004SEND\u0010\u0002\"\u0097\u0001\n\u0013ErosSocketTypeProto\u0012C\n\u0004type\u0018\u0004 \u0001(\u000e25.com.blued.das.apm.ErosSocketTypeProto.ErosSocketType\";\n\u000eErosSocketType\u0012\u0015\n\u0011UNKNOWN_EROS_TYPE\u0010��\u0012\b\n\u0004AUTH\u0010\u0001\u0012\b\n\u0004SEND\u0010\u0002\"\u001b\n\fWebTypeProto\u0012\u000b\n\u0003url\u0018\u0001 \u0001(\t\"\u0013\n\u0011OpenTimeTypeProto\"^\n\bRequests\u0012%\n\u0006common\u0018\u0001 \u0001(\u000b2\u0015.com.blued.das.Common\u0012+\n\u0007request\u0018\u0002 \u0003(\u000b2\u001a.com.blued.das.apm.Request\"\u0018\n\bResponse\u0012\f\n\u0004code\u0018\u0001 \u0001(\u0005*\u0098\u0001\n\u0004Type\u0012\u000b\n\u0007UNKNOWN\u0010��\u0012\b\n\u0004HTTP\u0010\u0001\u0012\u0006\n\u0002IM\u0010\u0002\u0012\n\n\u0006SOCKET\u0010\u0003\u0012\u0007\n\u0003WEB\u0010\u0004\u0012\r\n\tEROS_GRPC\u0010\u0005\u0012\u000f\n\u000bEROS_SOCKET\u0010\u0006\u0012\r\n\tOPEN_TIME\u0010\u0007\u0012\u0010\n\fGRPC_CONNECT\u0010\b\u0012\u0010\n\fGRPC_REQUEST\u0010\t\u0012\t\n\u0005ALERT\u0010\n2Z\n\rReportService\u0012I\n\u000bBatchReport\u0012\u001b.com.blued.das.apm.Requests\u001a\u001b.com.blued.das.apm.Response\"��B\u0006¢\u0002\u0003APMb\u0006proto3"}, new Descriptors.FileDescriptor[]{AnyProto.getDescriptor(), CommonProtos.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_blued_das_apm_AlertTypeProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_AlertTypeProto_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_apm_ErosGrpcTypeProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_ErosGrpcTypeProto_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_apm_ErosSocketTypeProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_ErosSocketTypeProto_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_apm_GrpcConnectTypeProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_GrpcConnectTypeProto_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_apm_GrpcRequestTypeProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_GrpcRequestTypeProto_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_apm_HttpTypeProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_HttpTypeProto_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_apm_ImTypeProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_ImTypeProto_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_apm_OpenTimeTypeProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_OpenTimeTypeProto_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_apm_Request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_Request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_apm_Requests_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_Requests_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_apm_Response_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_Response_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_apm_SocketTypeProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_SocketTypeProto_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_apm_WebTypeProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_WebTypeProto_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$AlertTypeProto.class */
    public static final class AlertTypeProto extends GeneratedMessageV3 implements AlertTypeProtoOrBuilder {
        public static final int NAME_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private static final AlertTypeProto DEFAULT_INSTANCE = new AlertTypeProto();
        private static final Parser<AlertTypeProto> PARSER = new AbstractParser<AlertTypeProto>() { // from class: com.blued.das.apm.ApmProtos.AlertTypeProto.1
            @Override // com.google.protobuf.Parser
            public AlertTypeProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AlertTypeProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$AlertTypeProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AlertTypeProtoOrBuilder {
            private Object name_;

            private Builder() {
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ApmProtos.internal_static_com_blued_das_apm_AlertTypeProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = AlertTypeProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AlertTypeProto build() {
                AlertTypeProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AlertTypeProto buildPartial() {
                AlertTypeProto alertTypeProto = new AlertTypeProto(this);
                alertTypeProto.name_ = this.name_;
                onBuilt();
                return alertTypeProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.name_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearName() {
                this.name_ = AlertTypeProto.getDefaultInstance().getName();
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

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AlertTypeProto getDefaultInstanceForType() {
                return AlertTypeProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ApmProtos.internal_static_com_blued_das_apm_AlertTypeProto_descriptor;
            }

            @Override // com.blued.das.apm.ApmProtos.AlertTypeProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.AlertTypeProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ApmProtos.internal_static_com_blued_das_apm_AlertTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(AlertTypeProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(AlertTypeProto alertTypeProto) {
                if (alertTypeProto == AlertTypeProto.getDefaultInstance()) {
                    return this;
                }
                if (!alertTypeProto.getName().isEmpty()) {
                    this.name_ = alertTypeProto.name_;
                    onChanged();
                }
                mergeUnknownFields(alertTypeProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.apm.ApmProtos.AlertTypeProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.apm.ApmProtos.AlertTypeProto.access$4400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.apm.ApmProtos$AlertTypeProto r0 = (com.blued.das.apm.ApmProtos.AlertTypeProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.apm.ApmProtos$AlertTypeProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.apm.ApmProtos$AlertTypeProto r0 = (com.blued.das.apm.ApmProtos.AlertTypeProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.apm.ApmProtos$AlertTypeProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.apm.ApmProtos.AlertTypeProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.apm.ApmProtos$AlertTypeProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof AlertTypeProto) {
                    return mergeFrom((AlertTypeProto) message);
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
                    AlertTypeProto.checkByteStringIsUtf8(byteString);
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private AlertTypeProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
        }

        private AlertTypeProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.name_ = codedInputStream.readStringRequireUtf8();
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

        private AlertTypeProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static AlertTypeProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApmProtos.internal_static_com_blued_das_apm_AlertTypeProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AlertTypeProto alertTypeProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(alertTypeProto);
        }

        public static AlertTypeProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AlertTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AlertTypeProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AlertTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AlertTypeProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AlertTypeProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AlertTypeProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AlertTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AlertTypeProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AlertTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static AlertTypeProto parseFrom(InputStream inputStream) throws IOException {
            return (AlertTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AlertTypeProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AlertTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AlertTypeProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AlertTypeProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AlertTypeProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AlertTypeProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<AlertTypeProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof AlertTypeProto) {
                AlertTypeProto alertTypeProto = (AlertTypeProto) obj;
                return getName().equals(alertTypeProto.getName()) && this.unknownFields.equals(alertTypeProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AlertTypeProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.apm.ApmProtos.AlertTypeProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.AlertTypeProtoOrBuilder
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
        public Parser<AlertTypeProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getNameBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
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
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApmProtos.internal_static_com_blued_das_apm_AlertTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(AlertTypeProto.class, Builder.class);
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
            return new AlertTypeProto();
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
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$AlertTypeProtoOrBuilder.class */
    public interface AlertTypeProtoOrBuilder extends MessageOrBuilder {
        String getName();

        ByteString getNameBytes();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$ErosGrpcTypeProto.class */
    public static final class ErosGrpcTypeProto extends GeneratedMessageV3 implements ErosGrpcTypeProtoOrBuilder {
        private static final ErosGrpcTypeProto DEFAULT_INSTANCE = new ErosGrpcTypeProto();
        private static final Parser<ErosGrpcTypeProto> PARSER = new AbstractParser<ErosGrpcTypeProto>() { // from class: com.blued.das.apm.ApmProtos.ErosGrpcTypeProto.1
            @Override // com.google.protobuf.Parser
            public ErosGrpcTypeProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ErosGrpcTypeProto(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TYPE_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int type_;

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$ErosGrpcTypeProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ErosGrpcTypeProtoOrBuilder {
            private int type_;

            private Builder() {
                this.type_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.type_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ApmProtos.internal_static_com_blued_das_apm_ErosGrpcTypeProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ErosGrpcTypeProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ErosGrpcTypeProto build() {
                ErosGrpcTypeProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ErosGrpcTypeProto buildPartial() {
                ErosGrpcTypeProto erosGrpcTypeProto = new ErosGrpcTypeProto(this);
                erosGrpcTypeProto.type_ = this.type_;
                onBuilt();
                return erosGrpcTypeProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.type_ = 0;
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

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ErosGrpcTypeProto getDefaultInstanceForType() {
                return ErosGrpcTypeProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ApmProtos.internal_static_com_blued_das_apm_ErosGrpcTypeProto_descriptor;
            }

            @Override // com.blued.das.apm.ApmProtos.ErosGrpcTypeProtoOrBuilder
            public ErosGrpcType getType() {
                ErosGrpcType valueOf = ErosGrpcType.valueOf(this.type_);
                ErosGrpcType erosGrpcType = valueOf;
                if (valueOf == null) {
                    erosGrpcType = ErosGrpcType.UNRECOGNIZED;
                }
                return erosGrpcType;
            }

            @Override // com.blued.das.apm.ApmProtos.ErosGrpcTypeProtoOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ApmProtos.internal_static_com_blued_das_apm_ErosGrpcTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ErosGrpcTypeProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(ErosGrpcTypeProto erosGrpcTypeProto) {
                if (erosGrpcTypeProto == ErosGrpcTypeProto.getDefaultInstance()) {
                    return this;
                }
                if (erosGrpcTypeProto.type_ != 0) {
                    setTypeValue(erosGrpcTypeProto.getTypeValue());
                }
                mergeUnknownFields(erosGrpcTypeProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.apm.ApmProtos.ErosGrpcTypeProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.apm.ApmProtos.ErosGrpcTypeProto.access$11700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.apm.ApmProtos$ErosGrpcTypeProto r0 = (com.blued.das.apm.ApmProtos.ErosGrpcTypeProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.apm.ApmProtos$ErosGrpcTypeProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.apm.ApmProtos$ErosGrpcTypeProto r0 = (com.blued.das.apm.ApmProtos.ErosGrpcTypeProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.apm.ApmProtos$ErosGrpcTypeProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.apm.ApmProtos.ErosGrpcTypeProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.apm.ApmProtos$ErosGrpcTypeProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ErosGrpcTypeProto) {
                    return mergeFrom((ErosGrpcTypeProto) message);
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setType(ErosGrpcType erosGrpcType) {
                if (erosGrpcType != null) {
                    this.type_ = erosGrpcType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTypeValue(int i) {
                this.type_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$ErosGrpcTypeProto$ErosGrpcType.class */
        public enum ErosGrpcType implements ProtocolMessageEnum {
            UNKNOWN_EROS_TYPE(0),
            AUTH(1),
            SEND(2),
            UNRECOGNIZED(-1);
            
            public static final int AUTH_VALUE = 1;
            public static final int SEND_VALUE = 2;
            public static final int UNKNOWN_EROS_TYPE_VALUE = 0;
            private final int value;
            private static final Internal.EnumLiteMap<ErosGrpcType> internalValueMap = new Internal.EnumLiteMap<ErosGrpcType>() { // from class: com.blued.das.apm.ApmProtos.ErosGrpcTypeProto.ErosGrpcType.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public ErosGrpcType findValueByNumber(int i) {
                    return ErosGrpcType.forNumber(i);
                }
            };
            private static final ErosGrpcType[] VALUES = values();

            ErosGrpcType(int i) {
                this.value = i;
            }

            public static ErosGrpcType forNumber(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return SEND;
                    }
                    return AUTH;
                }
                return UNKNOWN_EROS_TYPE;
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return ErosGrpcTypeProto.getDescriptor().getEnumTypes().get(0);
            }

            public static Internal.EnumLiteMap<ErosGrpcType> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static ErosGrpcType valueOf(int i) {
                return forNumber(i);
            }

            public static ErosGrpcType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

        private ErosGrpcTypeProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.type_ = 0;
        }

        private ErosGrpcTypeProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 32) {
                                this.type_ = codedInputStream.readEnum();
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

        private ErosGrpcTypeProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ErosGrpcTypeProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApmProtos.internal_static_com_blued_das_apm_ErosGrpcTypeProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ErosGrpcTypeProto erosGrpcTypeProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(erosGrpcTypeProto);
        }

        public static ErosGrpcTypeProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ErosGrpcTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ErosGrpcTypeProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ErosGrpcTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ErosGrpcTypeProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ErosGrpcTypeProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ErosGrpcTypeProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ErosGrpcTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ErosGrpcTypeProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ErosGrpcTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static ErosGrpcTypeProto parseFrom(InputStream inputStream) throws IOException {
            return (ErosGrpcTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ErosGrpcTypeProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ErosGrpcTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ErosGrpcTypeProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ErosGrpcTypeProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ErosGrpcTypeProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ErosGrpcTypeProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<ErosGrpcTypeProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ErosGrpcTypeProto) {
                ErosGrpcTypeProto erosGrpcTypeProto = (ErosGrpcTypeProto) obj;
                return this.type_ == erosGrpcTypeProto.type_ && this.unknownFields.equals(erosGrpcTypeProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ErosGrpcTypeProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ErosGrpcTypeProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.type_ != ErosGrpcType.UNKNOWN_EROS_TYPE.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(4, this.type_);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.apm.ApmProtos.ErosGrpcTypeProtoOrBuilder
        public ErosGrpcType getType() {
            ErosGrpcType valueOf = ErosGrpcType.valueOf(this.type_);
            ErosGrpcType erosGrpcType = valueOf;
            if (valueOf == null) {
                erosGrpcType = ErosGrpcType.UNRECOGNIZED;
            }
            return erosGrpcType;
        }

        @Override // com.blued.das.apm.ApmProtos.ErosGrpcTypeProtoOrBuilder
        public int getTypeValue() {
            return this.type_;
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
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 4) * 53) + this.type_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApmProtos.internal_static_com_blued_das_apm_ErosGrpcTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ErosGrpcTypeProto.class, Builder.class);
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
            return new ErosGrpcTypeProto();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.type_ != ErosGrpcType.UNKNOWN_EROS_TYPE.getNumber()) {
                codedOutputStream.writeEnum(4, this.type_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$ErosGrpcTypeProtoOrBuilder.class */
    public interface ErosGrpcTypeProtoOrBuilder extends MessageOrBuilder {
        ErosGrpcTypeProto.ErosGrpcType getType();

        int getTypeValue();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$ErosSocketTypeProto.class */
    public static final class ErosSocketTypeProto extends GeneratedMessageV3 implements ErosSocketTypeProtoOrBuilder {
        private static final ErosSocketTypeProto DEFAULT_INSTANCE = new ErosSocketTypeProto();
        private static final Parser<ErosSocketTypeProto> PARSER = new AbstractParser<ErosSocketTypeProto>() { // from class: com.blued.das.apm.ApmProtos.ErosSocketTypeProto.1
            @Override // com.google.protobuf.Parser
            public ErosSocketTypeProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ErosSocketTypeProto(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TYPE_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int type_;

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$ErosSocketTypeProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ErosSocketTypeProtoOrBuilder {
            private int type_;

            private Builder() {
                this.type_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.type_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ApmProtos.internal_static_com_blued_das_apm_ErosSocketTypeProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ErosSocketTypeProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ErosSocketTypeProto build() {
                ErosSocketTypeProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ErosSocketTypeProto buildPartial() {
                ErosSocketTypeProto erosSocketTypeProto = new ErosSocketTypeProto(this);
                erosSocketTypeProto.type_ = this.type_;
                onBuilt();
                return erosSocketTypeProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.type_ = 0;
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

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ErosSocketTypeProto getDefaultInstanceForType() {
                return ErosSocketTypeProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ApmProtos.internal_static_com_blued_das_apm_ErosSocketTypeProto_descriptor;
            }

            @Override // com.blued.das.apm.ApmProtos.ErosSocketTypeProtoOrBuilder
            public ErosSocketType getType() {
                ErosSocketType valueOf = ErosSocketType.valueOf(this.type_);
                ErosSocketType erosSocketType = valueOf;
                if (valueOf == null) {
                    erosSocketType = ErosSocketType.UNRECOGNIZED;
                }
                return erosSocketType;
            }

            @Override // com.blued.das.apm.ApmProtos.ErosSocketTypeProtoOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ApmProtos.internal_static_com_blued_das_apm_ErosSocketTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ErosSocketTypeProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(ErosSocketTypeProto erosSocketTypeProto) {
                if (erosSocketTypeProto == ErosSocketTypeProto.getDefaultInstance()) {
                    return this;
                }
                if (erosSocketTypeProto.type_ != 0) {
                    setTypeValue(erosSocketTypeProto.getTypeValue());
                }
                mergeUnknownFields(erosSocketTypeProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.apm.ApmProtos.ErosSocketTypeProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.apm.ApmProtos.ErosSocketTypeProto.access$12700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.apm.ApmProtos$ErosSocketTypeProto r0 = (com.blued.das.apm.ApmProtos.ErosSocketTypeProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.apm.ApmProtos$ErosSocketTypeProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.apm.ApmProtos$ErosSocketTypeProto r0 = (com.blued.das.apm.ApmProtos.ErosSocketTypeProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.apm.ApmProtos$ErosSocketTypeProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.apm.ApmProtos.ErosSocketTypeProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.apm.ApmProtos$ErosSocketTypeProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ErosSocketTypeProto) {
                    return mergeFrom((ErosSocketTypeProto) message);
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setType(ErosSocketType erosSocketType) {
                if (erosSocketType != null) {
                    this.type_ = erosSocketType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTypeValue(int i) {
                this.type_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$ErosSocketTypeProto$ErosSocketType.class */
        public enum ErosSocketType implements ProtocolMessageEnum {
            UNKNOWN_EROS_TYPE(0),
            AUTH(1),
            SEND(2),
            UNRECOGNIZED(-1);
            
            public static final int AUTH_VALUE = 1;
            public static final int SEND_VALUE = 2;
            public static final int UNKNOWN_EROS_TYPE_VALUE = 0;
            private final int value;
            private static final Internal.EnumLiteMap<ErosSocketType> internalValueMap = new Internal.EnumLiteMap<ErosSocketType>() { // from class: com.blued.das.apm.ApmProtos.ErosSocketTypeProto.ErosSocketType.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public ErosSocketType findValueByNumber(int i) {
                    return ErosSocketType.forNumber(i);
                }
            };
            private static final ErosSocketType[] VALUES = values();

            ErosSocketType(int i) {
                this.value = i;
            }

            public static ErosSocketType forNumber(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return SEND;
                    }
                    return AUTH;
                }
                return UNKNOWN_EROS_TYPE;
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return ErosSocketTypeProto.getDescriptor().getEnumTypes().get(0);
            }

            public static Internal.EnumLiteMap<ErosSocketType> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static ErosSocketType valueOf(int i) {
                return forNumber(i);
            }

            public static ErosSocketType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

        private ErosSocketTypeProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.type_ = 0;
        }

        private ErosSocketTypeProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 32) {
                                this.type_ = codedInputStream.readEnum();
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

        private ErosSocketTypeProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ErosSocketTypeProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApmProtos.internal_static_com_blued_das_apm_ErosSocketTypeProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ErosSocketTypeProto erosSocketTypeProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(erosSocketTypeProto);
        }

        public static ErosSocketTypeProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ErosSocketTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ErosSocketTypeProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ErosSocketTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ErosSocketTypeProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ErosSocketTypeProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ErosSocketTypeProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ErosSocketTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ErosSocketTypeProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ErosSocketTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static ErosSocketTypeProto parseFrom(InputStream inputStream) throws IOException {
            return (ErosSocketTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ErosSocketTypeProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ErosSocketTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ErosSocketTypeProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ErosSocketTypeProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ErosSocketTypeProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ErosSocketTypeProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<ErosSocketTypeProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ErosSocketTypeProto) {
                ErosSocketTypeProto erosSocketTypeProto = (ErosSocketTypeProto) obj;
                return this.type_ == erosSocketTypeProto.type_ && this.unknownFields.equals(erosSocketTypeProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ErosSocketTypeProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ErosSocketTypeProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.type_ != ErosSocketType.UNKNOWN_EROS_TYPE.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(4, this.type_);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.apm.ApmProtos.ErosSocketTypeProtoOrBuilder
        public ErosSocketType getType() {
            ErosSocketType valueOf = ErosSocketType.valueOf(this.type_);
            ErosSocketType erosSocketType = valueOf;
            if (valueOf == null) {
                erosSocketType = ErosSocketType.UNRECOGNIZED;
            }
            return erosSocketType;
        }

        @Override // com.blued.das.apm.ApmProtos.ErosSocketTypeProtoOrBuilder
        public int getTypeValue() {
            return this.type_;
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
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 4) * 53) + this.type_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApmProtos.internal_static_com_blued_das_apm_ErosSocketTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ErosSocketTypeProto.class, Builder.class);
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
            return new ErosSocketTypeProto();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.type_ != ErosSocketType.UNKNOWN_EROS_TYPE.getNumber()) {
                codedOutputStream.writeEnum(4, this.type_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$ErosSocketTypeProtoOrBuilder.class */
    public interface ErosSocketTypeProtoOrBuilder extends MessageOrBuilder {
        ErosSocketTypeProto.ErosSocketType getType();

        int getTypeValue();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$GrpcConnectTypeProto.class */
    public static final class GrpcConnectTypeProto extends GeneratedMessageV3 implements GrpcConnectTypeProtoOrBuilder {
        public static final int BUSINESS_FIELD_NUMBER = 4;
        public static final int HOST_FIELD_NUMBER = 1;
        public static final int PORT_FIELD_NUMBER = 2;
        public static final int SERVER_IP_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int business_;
        private volatile Object host_;
        private byte memoizedIsInitialized;
        private int port_;
        private volatile Object serverIp_;
        private static final GrpcConnectTypeProto DEFAULT_INSTANCE = new GrpcConnectTypeProto();
        private static final Parser<GrpcConnectTypeProto> PARSER = new AbstractParser<GrpcConnectTypeProto>() { // from class: com.blued.das.apm.ApmProtos.GrpcConnectTypeProto.1
            @Override // com.google.protobuf.Parser
            public GrpcConnectTypeProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new GrpcConnectTypeProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$GrpcConnectTypeProto$BUSINESS.class */
        public enum BUSINESS implements ProtocolMessageEnum {
            UNKNOWN_BUSINESS(0),
            PRIVATE_CHAT(1),
            YY(2),
            LIVE_CHAT(3),
            UNRECOGNIZED(-1);
            
            public static final int LIVE_CHAT_VALUE = 3;
            public static final int PRIVATE_CHAT_VALUE = 1;
            public static final int UNKNOWN_BUSINESS_VALUE = 0;
            public static final int YY_VALUE = 2;
            private final int value;
            private static final Internal.EnumLiteMap<BUSINESS> internalValueMap = new Internal.EnumLiteMap<BUSINESS>() { // from class: com.blued.das.apm.ApmProtos.GrpcConnectTypeProto.BUSINESS.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public BUSINESS findValueByNumber(int i) {
                    return BUSINESS.forNumber(i);
                }
            };
            private static final BUSINESS[] VALUES = values();

            BUSINESS(int i) {
                this.value = i;
            }

            public static BUSINESS forNumber(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                return null;
                            }
                            return LIVE_CHAT;
                        }
                        return YY;
                    }
                    return PRIVATE_CHAT;
                }
                return UNKNOWN_BUSINESS;
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return GrpcConnectTypeProto.getDescriptor().getEnumTypes().get(0);
            }

            public static Internal.EnumLiteMap<BUSINESS> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static BUSINESS valueOf(int i) {
                return forNumber(i);
            }

            public static BUSINESS valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$GrpcConnectTypeProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GrpcConnectTypeProtoOrBuilder {
            private int business_;
            private Object host_;
            private int port_;
            private Object serverIp_;

            private Builder() {
                this.host_ = "";
                this.serverIp_ = "";
                this.business_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.host_ = "";
                this.serverIp_ = "";
                this.business_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ApmProtos.internal_static_com_blued_das_apm_GrpcConnectTypeProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GrpcConnectTypeProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GrpcConnectTypeProto build() {
                GrpcConnectTypeProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GrpcConnectTypeProto buildPartial() {
                GrpcConnectTypeProto grpcConnectTypeProto = new GrpcConnectTypeProto(this);
                grpcConnectTypeProto.host_ = this.host_;
                grpcConnectTypeProto.port_ = this.port_;
                grpcConnectTypeProto.serverIp_ = this.serverIp_;
                grpcConnectTypeProto.business_ = this.business_;
                onBuilt();
                return grpcConnectTypeProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.host_ = "";
                this.port_ = 0;
                this.serverIp_ = "";
                this.business_ = 0;
                return this;
            }

            public Builder clearBusiness() {
                this.business_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearHost() {
                this.host_ = GrpcConnectTypeProto.getDefaultInstance().getHost();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPort() {
                this.port_ = 0;
                onChanged();
                return this;
            }

            public Builder clearServerIp() {
                this.serverIp_ = GrpcConnectTypeProto.getDefaultInstance().getServerIp();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
            public BUSINESS getBusiness() {
                BUSINESS valueOf = BUSINESS.valueOf(this.business_);
                BUSINESS business = valueOf;
                if (valueOf == null) {
                    business = BUSINESS.UNRECOGNIZED;
                }
                return business;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
            public int getBusinessValue() {
                return this.business_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GrpcConnectTypeProto getDefaultInstanceForType() {
                return GrpcConnectTypeProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ApmProtos.internal_static_com_blued_das_apm_GrpcConnectTypeProto_descriptor;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
            public String getHost() {
                Object obj = this.host_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.host_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
            public ByteString getHostBytes() {
                Object obj = this.host_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.host_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
            public int getPort() {
                return this.port_;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
            public String getServerIp() {
                Object obj = this.serverIp_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.serverIp_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
            public ByteString getServerIpBytes() {
                Object obj = this.serverIp_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.serverIp_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ApmProtos.internal_static_com_blued_das_apm_GrpcConnectTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(GrpcConnectTypeProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(GrpcConnectTypeProto grpcConnectTypeProto) {
                if (grpcConnectTypeProto == GrpcConnectTypeProto.getDefaultInstance()) {
                    return this;
                }
                if (!grpcConnectTypeProto.getHost().isEmpty()) {
                    this.host_ = grpcConnectTypeProto.host_;
                    onChanged();
                }
                if (grpcConnectTypeProto.getPort() != 0) {
                    setPort(grpcConnectTypeProto.getPort());
                }
                if (!grpcConnectTypeProto.getServerIp().isEmpty()) {
                    this.serverIp_ = grpcConnectTypeProto.serverIp_;
                    onChanged();
                }
                if (grpcConnectTypeProto.business_ != 0) {
                    setBusinessValue(grpcConnectTypeProto.getBusinessValue());
                }
                mergeUnknownFields(grpcConnectTypeProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.apm.ApmProtos.GrpcConnectTypeProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.apm.ApmProtos.GrpcConnectTypeProto.access$10500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.apm.ApmProtos$GrpcConnectTypeProto r0 = (com.blued.das.apm.ApmProtos.GrpcConnectTypeProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.apm.ApmProtos$GrpcConnectTypeProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.apm.ApmProtos$GrpcConnectTypeProto r0 = (com.blued.das.apm.ApmProtos.GrpcConnectTypeProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.apm.ApmProtos$GrpcConnectTypeProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.apm.ApmProtos.GrpcConnectTypeProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.apm.ApmProtos$GrpcConnectTypeProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof GrpcConnectTypeProto) {
                    return mergeFrom((GrpcConnectTypeProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBusiness(BUSINESS business) {
                if (business != null) {
                    this.business_ = business.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBusinessValue(int i) {
                this.business_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setHost(String str) {
                if (str != null) {
                    this.host_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setHostBytes(ByteString byteString) {
                if (byteString != null) {
                    GrpcConnectTypeProto.checkByteStringIsUtf8(byteString);
                    this.host_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPort(int i) {
                this.port_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setServerIp(String str) {
                if (str != null) {
                    this.serverIp_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setServerIpBytes(ByteString byteString) {
                if (byteString != null) {
                    GrpcConnectTypeProto.checkByteStringIsUtf8(byteString);
                    this.serverIp_ = byteString;
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

        private GrpcConnectTypeProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.host_ = "";
            this.serverIp_ = "";
            this.business_ = 0;
        }

        private GrpcConnectTypeProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.host_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.port_ = codedInputStream.readInt32();
                            } else if (readTag == 26) {
                                this.serverIp_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.business_ = codedInputStream.readEnum();
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

        private GrpcConnectTypeProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static GrpcConnectTypeProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApmProtos.internal_static_com_blued_das_apm_GrpcConnectTypeProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GrpcConnectTypeProto grpcConnectTypeProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(grpcConnectTypeProto);
        }

        public static GrpcConnectTypeProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GrpcConnectTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static GrpcConnectTypeProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GrpcConnectTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static GrpcConnectTypeProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static GrpcConnectTypeProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static GrpcConnectTypeProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GrpcConnectTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static GrpcConnectTypeProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GrpcConnectTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static GrpcConnectTypeProto parseFrom(InputStream inputStream) throws IOException {
            return (GrpcConnectTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static GrpcConnectTypeProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GrpcConnectTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static GrpcConnectTypeProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static GrpcConnectTypeProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static GrpcConnectTypeProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static GrpcConnectTypeProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<GrpcConnectTypeProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof GrpcConnectTypeProto) {
                GrpcConnectTypeProto grpcConnectTypeProto = (GrpcConnectTypeProto) obj;
                return getHost().equals(grpcConnectTypeProto.getHost()) && getPort() == grpcConnectTypeProto.getPort() && getServerIp().equals(grpcConnectTypeProto.getServerIp()) && this.business_ == grpcConnectTypeProto.business_ && this.unknownFields.equals(grpcConnectTypeProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
        public BUSINESS getBusiness() {
            BUSINESS valueOf = BUSINESS.valueOf(this.business_);
            BUSINESS business = valueOf;
            if (valueOf == null) {
                business = BUSINESS.UNRECOGNIZED;
            }
            return business;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
        public int getBusinessValue() {
            return this.business_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GrpcConnectTypeProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
        public String getHost() {
            Object obj = this.host_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.host_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
        public ByteString getHostBytes() {
            Object obj = this.host_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.host_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GrpcConnectTypeProto> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
        public int getPort() {
            return this.port_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getHostBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.host_);
            }
            int i3 = this.port_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeInt32Size(2, i3);
            }
            int i5 = i4;
            if (!getServerIpBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.serverIp_);
            }
            int i6 = i5;
            if (this.business_ != BUSINESS.UNKNOWN_BUSINESS.getNumber()) {
                i6 = i5 + CodedOutputStream.computeEnumSize(4, this.business_);
            }
            int serializedSize = i6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
        public String getServerIp() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.serverIp_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcConnectTypeProtoOrBuilder
        public ByteString getServerIpBytes() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serverIp_ = copyFromUtf8;
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
            int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getHost().hashCode()) * 37) + 2) * 53) + getPort()) * 37) + 3) * 53) + getServerIp().hashCode()) * 37) + 4) * 53) + this.business_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApmProtos.internal_static_com_blued_das_apm_GrpcConnectTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(GrpcConnectTypeProto.class, Builder.class);
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
            return new GrpcConnectTypeProto();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getHostBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.host_);
            }
            int i = this.port_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            if (!getServerIpBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.serverIp_);
            }
            if (this.business_ != BUSINESS.UNKNOWN_BUSINESS.getNumber()) {
                codedOutputStream.writeEnum(4, this.business_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$GrpcConnectTypeProtoOrBuilder.class */
    public interface GrpcConnectTypeProtoOrBuilder extends MessageOrBuilder {
        GrpcConnectTypeProto.BUSINESS getBusiness();

        int getBusinessValue();

        String getHost();

        ByteString getHostBytes();

        int getPort();

        String getServerIp();

        ByteString getServerIpBytes();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$GrpcRequestTypeProto.class */
    public static final class GrpcRequestTypeProto extends GeneratedMessageV3 implements GrpcRequestTypeProtoOrBuilder {
        public static final int BUSINESS_FIELD_NUMBER = 5;
        public static final int HOST_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int PORT_FIELD_NUMBER = 3;
        public static final int SERVER_IP_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int business_;
        private volatile Object host_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int port_;
        private volatile Object serverIp_;
        private static final GrpcRequestTypeProto DEFAULT_INSTANCE = new GrpcRequestTypeProto();
        private static final Parser<GrpcRequestTypeProto> PARSER = new AbstractParser<GrpcRequestTypeProto>() { // from class: com.blued.das.apm.ApmProtos.GrpcRequestTypeProto.1
            @Override // com.google.protobuf.Parser
            public GrpcRequestTypeProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new GrpcRequestTypeProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS.class */
        public enum BUSINESS implements ProtocolMessageEnum {
            UNKNOWN_BUSINESS(0),
            PRIVATE_CHAT(1),
            YY(2),
            LIVE_CHAT(3),
            GROUP_CHAT(4),
            UNRECOGNIZED(-1);
            
            public static final int GROUP_CHAT_VALUE = 4;
            public static final int LIVE_CHAT_VALUE = 3;
            public static final int PRIVATE_CHAT_VALUE = 1;
            public static final int UNKNOWN_BUSINESS_VALUE = 0;
            public static final int YY_VALUE = 2;
            private final int value;
            private static final Internal.EnumLiteMap<BUSINESS> internalValueMap = new Internal.EnumLiteMap<BUSINESS>() { // from class: com.blued.das.apm.ApmProtos.GrpcRequestTypeProto.BUSINESS.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public BUSINESS findValueByNumber(int i) {
                    return BUSINESS.forNumber(i);
                }
            };
            private static final BUSINESS[] VALUES = values();

            BUSINESS(int i) {
                this.value = i;
            }

            public static BUSINESS forNumber(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    return null;
                                }
                                return GROUP_CHAT;
                            }
                            return LIVE_CHAT;
                        }
                        return YY;
                    }
                    return PRIVATE_CHAT;
                }
                return UNKNOWN_BUSINESS;
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return GrpcRequestTypeProto.getDescriptor().getEnumTypes().get(0);
            }

            public static Internal.EnumLiteMap<BUSINESS> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static BUSINESS valueOf(int i) {
                return forNumber(i);
            }

            public static BUSINESS valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$GrpcRequestTypeProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GrpcRequestTypeProtoOrBuilder {
            private int business_;
            private Object host_;
            private Object name_;
            private int port_;
            private Object serverIp_;

            private Builder() {
                this.name_ = "";
                this.host_ = "";
                this.serverIp_ = "";
                this.business_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.name_ = "";
                this.host_ = "";
                this.serverIp_ = "";
                this.business_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ApmProtos.internal_static_com_blued_das_apm_GrpcRequestTypeProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GrpcRequestTypeProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GrpcRequestTypeProto build() {
                GrpcRequestTypeProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GrpcRequestTypeProto buildPartial() {
                GrpcRequestTypeProto grpcRequestTypeProto = new GrpcRequestTypeProto(this);
                grpcRequestTypeProto.name_ = this.name_;
                grpcRequestTypeProto.host_ = this.host_;
                grpcRequestTypeProto.port_ = this.port_;
                grpcRequestTypeProto.serverIp_ = this.serverIp_;
                grpcRequestTypeProto.business_ = this.business_;
                onBuilt();
                return grpcRequestTypeProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.name_ = "";
                this.host_ = "";
                this.port_ = 0;
                this.serverIp_ = "";
                this.business_ = 0;
                return this;
            }

            public Builder clearBusiness() {
                this.business_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearHost() {
                this.host_ = GrpcRequestTypeProto.getDefaultInstance().getHost();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = GrpcRequestTypeProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPort() {
                this.port_ = 0;
                onChanged();
                return this;
            }

            public Builder clearServerIp() {
                this.serverIp_ = GrpcRequestTypeProto.getDefaultInstance().getServerIp();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
            public BUSINESS getBusiness() {
                BUSINESS valueOf = BUSINESS.valueOf(this.business_);
                BUSINESS business = valueOf;
                if (valueOf == null) {
                    business = BUSINESS.UNRECOGNIZED;
                }
                return business;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
            public int getBusinessValue() {
                return this.business_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GrpcRequestTypeProto getDefaultInstanceForType() {
                return GrpcRequestTypeProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ApmProtos.internal_static_com_blued_das_apm_GrpcRequestTypeProto_descriptor;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
            public String getHost() {
                Object obj = this.host_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.host_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
            public ByteString getHostBytes() {
                Object obj = this.host_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.host_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
            public int getPort() {
                return this.port_;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
            public String getServerIp() {
                Object obj = this.serverIp_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.serverIp_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
            public ByteString getServerIpBytes() {
                Object obj = this.serverIp_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.serverIp_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ApmProtos.internal_static_com_blued_das_apm_GrpcRequestTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(GrpcRequestTypeProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(GrpcRequestTypeProto grpcRequestTypeProto) {
                if (grpcRequestTypeProto == GrpcRequestTypeProto.getDefaultInstance()) {
                    return this;
                }
                if (!grpcRequestTypeProto.getName().isEmpty()) {
                    this.name_ = grpcRequestTypeProto.name_;
                    onChanged();
                }
                if (!grpcRequestTypeProto.getHost().isEmpty()) {
                    this.host_ = grpcRequestTypeProto.host_;
                    onChanged();
                }
                if (grpcRequestTypeProto.getPort() != 0) {
                    setPort(grpcRequestTypeProto.getPort());
                }
                if (!grpcRequestTypeProto.getServerIp().isEmpty()) {
                    this.serverIp_ = grpcRequestTypeProto.serverIp_;
                    onChanged();
                }
                if (grpcRequestTypeProto.business_ != 0) {
                    setBusinessValue(grpcRequestTypeProto.getBusinessValue());
                }
                mergeUnknownFields(grpcRequestTypeProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.apm.ApmProtos.GrpcRequestTypeProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.apm.ApmProtos.GrpcRequestTypeProto.access$7500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.apm.ApmProtos$GrpcRequestTypeProto r0 = (com.blued.das.apm.ApmProtos.GrpcRequestTypeProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.apm.ApmProtos$GrpcRequestTypeProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.apm.ApmProtos$GrpcRequestTypeProto r0 = (com.blued.das.apm.ApmProtos.GrpcRequestTypeProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.apm.ApmProtos$GrpcRequestTypeProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.apm.ApmProtos.GrpcRequestTypeProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.apm.ApmProtos$GrpcRequestTypeProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof GrpcRequestTypeProto) {
                    return mergeFrom((GrpcRequestTypeProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBusiness(BUSINESS business) {
                if (business != null) {
                    this.business_ = business.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBusinessValue(int i) {
                this.business_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setHost(String str) {
                if (str != null) {
                    this.host_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setHostBytes(ByteString byteString) {
                if (byteString != null) {
                    GrpcRequestTypeProto.checkByteStringIsUtf8(byteString);
                    this.host_ = byteString;
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
                    GrpcRequestTypeProto.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPort(int i) {
                this.port_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setServerIp(String str) {
                if (str != null) {
                    this.serverIp_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setServerIpBytes(ByteString byteString) {
                if (byteString != null) {
                    GrpcRequestTypeProto.checkByteStringIsUtf8(byteString);
                    this.serverIp_ = byteString;
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

        private GrpcRequestTypeProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.host_ = "";
            this.serverIp_ = "";
            this.business_ = 0;
        }

        private GrpcRequestTypeProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.host_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.port_ = codedInputStream.readInt32();
                            } else if (readTag == 34) {
                                this.serverIp_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 40) {
                                this.business_ = codedInputStream.readEnum();
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

        private GrpcRequestTypeProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static GrpcRequestTypeProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApmProtos.internal_static_com_blued_das_apm_GrpcRequestTypeProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GrpcRequestTypeProto grpcRequestTypeProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(grpcRequestTypeProto);
        }

        public static GrpcRequestTypeProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GrpcRequestTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static GrpcRequestTypeProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GrpcRequestTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static GrpcRequestTypeProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static GrpcRequestTypeProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static GrpcRequestTypeProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GrpcRequestTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static GrpcRequestTypeProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GrpcRequestTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static GrpcRequestTypeProto parseFrom(InputStream inputStream) throws IOException {
            return (GrpcRequestTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static GrpcRequestTypeProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GrpcRequestTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static GrpcRequestTypeProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static GrpcRequestTypeProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static GrpcRequestTypeProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static GrpcRequestTypeProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<GrpcRequestTypeProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof GrpcRequestTypeProto) {
                GrpcRequestTypeProto grpcRequestTypeProto = (GrpcRequestTypeProto) obj;
                return getName().equals(grpcRequestTypeProto.getName()) && getHost().equals(grpcRequestTypeProto.getHost()) && getPort() == grpcRequestTypeProto.getPort() && getServerIp().equals(grpcRequestTypeProto.getServerIp()) && this.business_ == grpcRequestTypeProto.business_ && this.unknownFields.equals(grpcRequestTypeProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
        public BUSINESS getBusiness() {
            BUSINESS valueOf = BUSINESS.valueOf(this.business_);
            BUSINESS business = valueOf;
            if (valueOf == null) {
                business = BUSINESS.UNRECOGNIZED;
            }
            return business;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
        public int getBusinessValue() {
            return this.business_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GrpcRequestTypeProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
        public String getHost() {
            Object obj = this.host_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.host_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
        public ByteString getHostBytes() {
            Object obj = this.host_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.host_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
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
        public Parser<GrpcRequestTypeProto> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
        public int getPort() {
            return this.port_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getNameBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            int i3 = i2;
            if (!getHostBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.host_);
            }
            int i4 = this.port_;
            int i5 = i3;
            if (i4 != 0) {
                i5 = i3 + CodedOutputStream.computeInt32Size(3, i4);
            }
            int i6 = i5;
            if (!getServerIpBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.serverIp_);
            }
            int i7 = i6;
            if (this.business_ != BUSINESS.UNKNOWN_BUSINESS.getNumber()) {
                i7 = i6 + CodedOutputStream.computeEnumSize(5, this.business_);
            }
            int serializedSize = i7 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
        public String getServerIp() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.serverIp_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.GrpcRequestTypeProtoOrBuilder
        public ByteString getServerIpBytes() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serverIp_ = copyFromUtf8;
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
            int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getHost().hashCode()) * 37) + 3) * 53) + getPort()) * 37) + 4) * 53) + getServerIp().hashCode()) * 37) + 5) * 53) + this.business_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApmProtos.internal_static_com_blued_das_apm_GrpcRequestTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(GrpcRequestTypeProto.class, Builder.class);
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
            return new GrpcRequestTypeProto();
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
            if (!getHostBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.host_);
            }
            int i = this.port_;
            if (i != 0) {
                codedOutputStream.writeInt32(3, i);
            }
            if (!getServerIpBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.serverIp_);
            }
            if (this.business_ != BUSINESS.UNKNOWN_BUSINESS.getNumber()) {
                codedOutputStream.writeEnum(5, this.business_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$GrpcRequestTypeProtoOrBuilder.class */
    public interface GrpcRequestTypeProtoOrBuilder extends MessageOrBuilder {
        GrpcRequestTypeProto.BUSINESS getBusiness();

        int getBusinessValue();

        String getHost();

        ByteString getHostBytes();

        String getName();

        ByteString getNameBytes();

        int getPort();

        String getServerIp();

        ByteString getServerIpBytes();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$HttpTypeProto.class */
    public static final class HttpTypeProto extends GeneratedMessageV3 implements HttpTypeProtoOrBuilder {
        private static final HttpTypeProto DEFAULT_INSTANCE = new HttpTypeProto();
        private static final Parser<HttpTypeProto> PARSER = new AbstractParser<HttpTypeProto>() { // from class: com.blued.das.apm.ApmProtos.HttpTypeProto.1
            @Override // com.google.protobuf.Parser
            public HttpTypeProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new HttpTypeProto(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RESPONSE_LENGTH_FIELD_NUMBER = 3;
        public static final int RESPONSE_TYPE_FIELD_NUMBER = 2;
        public static final int SERVER_IP_FIELD_NUMBER = 4;
        public static final int URL_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int responseLength_;
        private volatile Object responseType_;
        private volatile Object serverIp_;
        private volatile Object url_;

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$HttpTypeProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HttpTypeProtoOrBuilder {
            private int responseLength_;
            private Object responseType_;
            private Object serverIp_;
            private Object url_;

            private Builder() {
                this.url_ = "";
                this.responseType_ = "";
                this.serverIp_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.url_ = "";
                this.responseType_ = "";
                this.serverIp_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ApmProtos.internal_static_com_blued_das_apm_HttpTypeProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = HttpTypeProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HttpTypeProto build() {
                HttpTypeProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HttpTypeProto buildPartial() {
                HttpTypeProto httpTypeProto = new HttpTypeProto(this);
                httpTypeProto.url_ = this.url_;
                httpTypeProto.responseType_ = this.responseType_;
                httpTypeProto.responseLength_ = this.responseLength_;
                httpTypeProto.serverIp_ = this.serverIp_;
                onBuilt();
                return httpTypeProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.url_ = "";
                this.responseType_ = "";
                this.responseLength_ = 0;
                this.serverIp_ = "";
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

            public Builder clearResponseLength() {
                this.responseLength_ = 0;
                onChanged();
                return this;
            }

            public Builder clearResponseType() {
                this.responseType_ = HttpTypeProto.getDefaultInstance().getResponseType();
                onChanged();
                return this;
            }

            public Builder clearServerIp() {
                this.serverIp_ = HttpTypeProto.getDefaultInstance().getServerIp();
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = HttpTypeProto.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HttpTypeProto getDefaultInstanceForType() {
                return HttpTypeProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ApmProtos.internal_static_com_blued_das_apm_HttpTypeProto_descriptor;
            }

            @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
            public int getResponseLength() {
                return this.responseLength_;
            }

            @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
            public String getResponseType() {
                Object obj = this.responseType_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.responseType_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
            public ByteString getResponseTypeBytes() {
                Object obj = this.responseType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.responseType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
            public String getServerIp() {
                Object obj = this.serverIp_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.serverIp_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
            public ByteString getServerIpBytes() {
                Object obj = this.serverIp_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.serverIp_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
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
                return ApmProtos.internal_static_com_blued_das_apm_HttpTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(HttpTypeProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(HttpTypeProto httpTypeProto) {
                if (httpTypeProto == HttpTypeProto.getDefaultInstance()) {
                    return this;
                }
                if (!httpTypeProto.getUrl().isEmpty()) {
                    this.url_ = httpTypeProto.url_;
                    onChanged();
                }
                if (!httpTypeProto.getResponseType().isEmpty()) {
                    this.responseType_ = httpTypeProto.responseType_;
                    onChanged();
                }
                if (httpTypeProto.getResponseLength() != 0) {
                    setResponseLength(httpTypeProto.getResponseLength());
                }
                if (!httpTypeProto.getServerIp().isEmpty()) {
                    this.serverIp_ = httpTypeProto.serverIp_;
                    onChanged();
                }
                mergeUnknownFields(httpTypeProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.apm.ApmProtos.HttpTypeProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.apm.ApmProtos.HttpTypeProto.access$3100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.apm.ApmProtos$HttpTypeProto r0 = (com.blued.das.apm.ApmProtos.HttpTypeProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.apm.ApmProtos$HttpTypeProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.apm.ApmProtos$HttpTypeProto r0 = (com.blued.das.apm.ApmProtos.HttpTypeProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.apm.ApmProtos$HttpTypeProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.apm.ApmProtos.HttpTypeProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.apm.ApmProtos$HttpTypeProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof HttpTypeProto) {
                    return mergeFrom((HttpTypeProto) message);
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setResponseLength(int i) {
                this.responseLength_ = i;
                onChanged();
                return this;
            }

            public Builder setResponseType(String str) {
                if (str != null) {
                    this.responseType_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setResponseTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    HttpTypeProto.checkByteStringIsUtf8(byteString);
                    this.responseType_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setServerIp(String str) {
                if (str != null) {
                    this.serverIp_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setServerIpBytes(ByteString byteString) {
                if (byteString != null) {
                    HttpTypeProto.checkByteStringIsUtf8(byteString);
                    this.serverIp_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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
                    HttpTypeProto.checkByteStringIsUtf8(byteString);
                    this.url_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }
        }

        private HttpTypeProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.url_ = "";
            this.responseType_ = "";
            this.serverIp_ = "";
        }

        private HttpTypeProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.url_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.responseType_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.responseLength_ = codedInputStream.readInt32();
                            } else if (readTag == 34) {
                                this.serverIp_ = codedInputStream.readStringRequireUtf8();
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

        private HttpTypeProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static HttpTypeProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApmProtos.internal_static_com_blued_das_apm_HttpTypeProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HttpTypeProto httpTypeProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(httpTypeProto);
        }

        public static HttpTypeProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (HttpTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static HttpTypeProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HttpTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static HttpTypeProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static HttpTypeProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static HttpTypeProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (HttpTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static HttpTypeProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HttpTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static HttpTypeProto parseFrom(InputStream inputStream) throws IOException {
            return (HttpTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static HttpTypeProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HttpTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static HttpTypeProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static HttpTypeProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static HttpTypeProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static HttpTypeProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<HttpTypeProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof HttpTypeProto) {
                HttpTypeProto httpTypeProto = (HttpTypeProto) obj;
                return getUrl().equals(httpTypeProto.getUrl()) && getResponseType().equals(httpTypeProto.getResponseType()) && getResponseLength() == httpTypeProto.getResponseLength() && getServerIp().equals(httpTypeProto.getServerIp()) && this.unknownFields.equals(httpTypeProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HttpTypeProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HttpTypeProto> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
        public int getResponseLength() {
            return this.responseLength_;
        }

        @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
        public String getResponseType() {
            Object obj = this.responseType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.responseType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
        public ByteString getResponseTypeBytes() {
            Object obj = this.responseType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.responseType_ = copyFromUtf8;
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
            int i2 = 0;
            if (!getUrlBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.url_);
            }
            int i3 = i2;
            if (!getResponseTypeBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.responseType_);
            }
            int i4 = this.responseLength_;
            int i5 = i3;
            if (i4 != 0) {
                i5 = i3 + CodedOutputStream.computeInt32Size(3, i4);
            }
            int i6 = i5;
            if (!getServerIpBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.serverIp_);
            }
            int serializedSize = i6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
        public String getServerIp() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.serverIp_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
        public ByteString getServerIpBytes() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serverIp_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.HttpTypeProtoOrBuilder
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
            int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUrl().hashCode()) * 37) + 2) * 53) + getResponseType().hashCode()) * 37) + 3) * 53) + getResponseLength()) * 37) + 4) * 53) + getServerIp().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApmProtos.internal_static_com_blued_das_apm_HttpTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(HttpTypeProto.class, Builder.class);
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
            return new HttpTypeProto();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.url_);
            }
            if (!getResponseTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.responseType_);
            }
            int i = this.responseLength_;
            if (i != 0) {
                codedOutputStream.writeInt32(3, i);
            }
            if (!getServerIpBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.serverIp_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$HttpTypeProtoOrBuilder.class */
    public interface HttpTypeProtoOrBuilder extends MessageOrBuilder {
        int getResponseLength();

        String getResponseType();

        ByteString getResponseTypeBytes();

        String getServerIp();

        ByteString getServerIpBytes();

        String getUrl();

        ByteString getUrlBytes();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$ImTypeProto.class */
    public static final class ImTypeProto extends GeneratedMessageV3 implements ImTypeProtoOrBuilder {
        public static final int HOST_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int PORT_FIELD_NUMBER = 3;
        public static final int SERVER_IP_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private volatile Object host_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int port_;
        private volatile Object serverIp_;
        private static final ImTypeProto DEFAULT_INSTANCE = new ImTypeProto();
        private static final Parser<ImTypeProto> PARSER = new AbstractParser<ImTypeProto>() { // from class: com.blued.das.apm.ApmProtos.ImTypeProto.1
            @Override // com.google.protobuf.Parser
            public ImTypeProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ImTypeProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$ImTypeProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ImTypeProtoOrBuilder {
            private Object host_;
            private Object name_;
            private int port_;
            private Object serverIp_;

            private Builder() {
                this.name_ = "";
                this.host_ = "";
                this.serverIp_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.name_ = "";
                this.host_ = "";
                this.serverIp_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ApmProtos.internal_static_com_blued_das_apm_ImTypeProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ImTypeProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ImTypeProto build() {
                ImTypeProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ImTypeProto buildPartial() {
                ImTypeProto imTypeProto = new ImTypeProto(this);
                imTypeProto.name_ = this.name_;
                imTypeProto.host_ = this.host_;
                imTypeProto.port_ = this.port_;
                imTypeProto.serverIp_ = this.serverIp_;
                onBuilt();
                return imTypeProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.name_ = "";
                this.host_ = "";
                this.port_ = 0;
                this.serverIp_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearHost() {
                this.host_ = ImTypeProto.getDefaultInstance().getHost();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = ImTypeProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPort() {
                this.port_ = 0;
                onChanged();
                return this;
            }

            public Builder clearServerIp() {
                this.serverIp_ = ImTypeProto.getDefaultInstance().getServerIp();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ImTypeProto getDefaultInstanceForType() {
                return ImTypeProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ApmProtos.internal_static_com_blued_das_apm_ImTypeProto_descriptor;
            }

            @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
            public String getHost() {
                Object obj = this.host_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.host_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
            public ByteString getHostBytes() {
                Object obj = this.host_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.host_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
            public int getPort() {
                return this.port_;
            }

            @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
            public String getServerIp() {
                Object obj = this.serverIp_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.serverIp_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
            public ByteString getServerIpBytes() {
                Object obj = this.serverIp_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.serverIp_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ApmProtos.internal_static_com_blued_das_apm_ImTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ImTypeProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(ImTypeProto imTypeProto) {
                if (imTypeProto == ImTypeProto.getDefaultInstance()) {
                    return this;
                }
                if (!imTypeProto.getName().isEmpty()) {
                    this.name_ = imTypeProto.name_;
                    onChanged();
                }
                if (!imTypeProto.getHost().isEmpty()) {
                    this.host_ = imTypeProto.host_;
                    onChanged();
                }
                if (imTypeProto.getPort() != 0) {
                    setPort(imTypeProto.getPort());
                }
                if (!imTypeProto.getServerIp().isEmpty()) {
                    this.serverIp_ = imTypeProto.serverIp_;
                    onChanged();
                }
                mergeUnknownFields(imTypeProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.apm.ApmProtos.ImTypeProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.apm.ApmProtos.ImTypeProto.access$5800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.apm.ApmProtos$ImTypeProto r0 = (com.blued.das.apm.ApmProtos.ImTypeProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.apm.ApmProtos$ImTypeProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.apm.ApmProtos$ImTypeProto r0 = (com.blued.das.apm.ApmProtos.ImTypeProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.apm.ApmProtos$ImTypeProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.apm.ApmProtos.ImTypeProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.apm.ApmProtos$ImTypeProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ImTypeProto) {
                    return mergeFrom((ImTypeProto) message);
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

            public Builder setHost(String str) {
                if (str != null) {
                    this.host_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setHostBytes(ByteString byteString) {
                if (byteString != null) {
                    ImTypeProto.checkByteStringIsUtf8(byteString);
                    this.host_ = byteString;
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
                    ImTypeProto.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPort(int i) {
                this.port_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setServerIp(String str) {
                if (str != null) {
                    this.serverIp_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setServerIpBytes(ByteString byteString) {
                if (byteString != null) {
                    ImTypeProto.checkByteStringIsUtf8(byteString);
                    this.serverIp_ = byteString;
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

        private ImTypeProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.host_ = "";
            this.serverIp_ = "";
        }

        private ImTypeProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.host_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.port_ = codedInputStream.readInt32();
                            } else if (readTag == 34) {
                                this.serverIp_ = codedInputStream.readStringRequireUtf8();
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

        private ImTypeProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ImTypeProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApmProtos.internal_static_com_blued_das_apm_ImTypeProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ImTypeProto imTypeProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(imTypeProto);
        }

        public static ImTypeProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ImTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ImTypeProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ImTypeProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ImTypeProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ImTypeProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ImTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ImTypeProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static ImTypeProto parseFrom(InputStream inputStream) throws IOException {
            return (ImTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ImTypeProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ImTypeProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ImTypeProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ImTypeProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ImTypeProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<ImTypeProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ImTypeProto) {
                ImTypeProto imTypeProto = (ImTypeProto) obj;
                return getName().equals(imTypeProto.getName()) && getHost().equals(imTypeProto.getHost()) && getPort() == imTypeProto.getPort() && getServerIp().equals(imTypeProto.getServerIp()) && this.unknownFields.equals(imTypeProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ImTypeProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
        public String getHost() {
            Object obj = this.host_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.host_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
        public ByteString getHostBytes() {
            Object obj = this.host_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.host_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
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
        public Parser<ImTypeProto> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
        public int getPort() {
            return this.port_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getNameBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            int i3 = i2;
            if (!getHostBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.host_);
            }
            int i4 = this.port_;
            int i5 = i3;
            if (i4 != 0) {
                i5 = i3 + CodedOutputStream.computeInt32Size(3, i4);
            }
            int i6 = i5;
            if (!getServerIpBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.serverIp_);
            }
            int serializedSize = i6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
        public String getServerIp() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.serverIp_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.ImTypeProtoOrBuilder
        public ByteString getServerIpBytes() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serverIp_ = copyFromUtf8;
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
            int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getHost().hashCode()) * 37) + 3) * 53) + getPort()) * 37) + 4) * 53) + getServerIp().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApmProtos.internal_static_com_blued_das_apm_ImTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ImTypeProto.class, Builder.class);
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
            return new ImTypeProto();
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
            if (!getHostBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.host_);
            }
            int i = this.port_;
            if (i != 0) {
                codedOutputStream.writeInt32(3, i);
            }
            if (!getServerIpBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.serverIp_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$ImTypeProtoOrBuilder.class */
    public interface ImTypeProtoOrBuilder extends MessageOrBuilder {
        String getHost();

        ByteString getHostBytes();

        String getName();

        ByteString getNameBytes();

        int getPort();

        String getServerIp();

        ByteString getServerIpBytes();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$OpenTimeTypeProto.class */
    public static final class OpenTimeTypeProto extends GeneratedMessageV3 implements OpenTimeTypeProtoOrBuilder {
        private static final OpenTimeTypeProto DEFAULT_INSTANCE = new OpenTimeTypeProto();
        private static final Parser<OpenTimeTypeProto> PARSER = new AbstractParser<OpenTimeTypeProto>() { // from class: com.blued.das.apm.ApmProtos.OpenTimeTypeProto.1
            @Override // com.google.protobuf.Parser
            public OpenTimeTypeProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new OpenTimeTypeProto(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$OpenTimeTypeProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OpenTimeTypeProtoOrBuilder {
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ApmProtos.internal_static_com_blued_das_apm_OpenTimeTypeProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = OpenTimeTypeProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OpenTimeTypeProto build() {
                OpenTimeTypeProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OpenTimeTypeProto buildPartial() {
                OpenTimeTypeProto openTimeTypeProto = new OpenTimeTypeProto(this);
                onBuilt();
                return openTimeTypeProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
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

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public OpenTimeTypeProto getDefaultInstanceForType() {
                return OpenTimeTypeProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ApmProtos.internal_static_com_blued_das_apm_OpenTimeTypeProto_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ApmProtos.internal_static_com_blued_das_apm_OpenTimeTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(OpenTimeTypeProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(OpenTimeTypeProto openTimeTypeProto) {
                if (openTimeTypeProto == OpenTimeTypeProto.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(openTimeTypeProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.apm.ApmProtos.OpenTimeTypeProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.apm.ApmProtos.OpenTimeTypeProto.access$14700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.apm.ApmProtos$OpenTimeTypeProto r0 = (com.blued.das.apm.ApmProtos.OpenTimeTypeProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.apm.ApmProtos$OpenTimeTypeProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.apm.ApmProtos$OpenTimeTypeProto r0 = (com.blued.das.apm.ApmProtos.OpenTimeTypeProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.apm.ApmProtos$OpenTimeTypeProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.apm.ApmProtos.OpenTimeTypeProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.apm.ApmProtos$OpenTimeTypeProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof OpenTimeTypeProto) {
                    return mergeFrom((OpenTimeTypeProto) message);
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private OpenTimeTypeProto() {
            this.memoizedIsInitialized = (byte) -1;
        }

        private OpenTimeTypeProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        if (readTag == 0 || !parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            z = true;
                        }
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

        private OpenTimeTypeProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static OpenTimeTypeProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApmProtos.internal_static_com_blued_das_apm_OpenTimeTypeProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(OpenTimeTypeProto openTimeTypeProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(openTimeTypeProto);
        }

        public static OpenTimeTypeProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OpenTimeTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static OpenTimeTypeProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OpenTimeTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static OpenTimeTypeProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static OpenTimeTypeProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static OpenTimeTypeProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OpenTimeTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static OpenTimeTypeProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OpenTimeTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static OpenTimeTypeProto parseFrom(InputStream inputStream) throws IOException {
            return (OpenTimeTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static OpenTimeTypeProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OpenTimeTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static OpenTimeTypeProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static OpenTimeTypeProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static OpenTimeTypeProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static OpenTimeTypeProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<OpenTimeTypeProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return !(obj instanceof OpenTimeTypeProto) ? super.equals(obj) : this.unknownFields.equals(((OpenTimeTypeProto) obj).unknownFields);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public OpenTimeTypeProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<OpenTimeTypeProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int serializedSize = this.unknownFields.getSerializedSize() + 0;
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
            int hashCode = ((779 + getDescriptor().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApmProtos.internal_static_com_blued_das_apm_OpenTimeTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(OpenTimeTypeProto.class, Builder.class);
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
            return new OpenTimeTypeProto();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$OpenTimeTypeProtoOrBuilder.class */
    public interface OpenTimeTypeProtoOrBuilder extends MessageOrBuilder {
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$Request.class */
    public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
        public static final int CLIENT_TIME_FIELD_NUMBER = 8;
        public static final int CODE_FIELD_NUMBER = 4;
        public static final int COMMON_FIELD_NUMBER = 7;
        public static final int DESCRIPTION_FIELD_NUMBER = 5;
        public static final int EXTRA_FIELD_NUMBER = 6;
        public static final int SERVER_REQUEST_ID_FIELD_NUMBER = 9;
        public static final int TAKES_FIELD_NUMBER = 3;
        public static final int TIME_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private long clientTime_;
        private int code_;
        private CommonProtos.Common common_;
        private volatile Object description_;
        private Any extra_;
        private byte memoizedIsInitialized;
        private volatile Object serverRequestId_;
        private int takes_;
        private long time_;
        private int type_;
        private static final Request DEFAULT_INSTANCE = new Request();
        private static final Parser<Request> PARSER = new AbstractParser<Request>() { // from class: com.blued.das.apm.ApmProtos.Request.1
            @Override // com.google.protobuf.Parser
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$Request$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestOrBuilder {
            private long clientTime_;
            private int code_;
            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
            private CommonProtos.Common common_;
            private Object description_;
            private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> extraBuilder_;
            private Any extra_;
            private Object serverRequestId_;
            private int takes_;
            private long time_;
            private int type_;

            private Builder() {
                this.type_ = 0;
                this.description_ = "";
                this.serverRequestId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.type_ = 0;
                this.description_ = "";
                this.serverRequestId_ = "";
                maybeForceBuilderInitialization();
            }

            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> getCommonFieldBuilder() {
                if (this.commonBuilder_ == null) {
                    this.commonBuilder_ = new SingleFieldBuilderV3<>(getCommon(), getParentForChildren(), isClean());
                    this.common_ = null;
                }
                return this.commonBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ApmProtos.internal_static_com_blued_das_apm_Request_descriptor;
            }

            private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getExtraFieldBuilder() {
                if (this.extraBuilder_ == null) {
                    this.extraBuilder_ = new SingleFieldBuilderV3<>(getExtra(), getParentForChildren(), isClean());
                    this.extra_ = null;
                }
                return this.extraBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Request.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Request build() {
                Request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Request buildPartial() {
                Request request = new Request(this);
                request.type_ = this.type_;
                request.time_ = this.time_;
                request.takes_ = this.takes_;
                request.code_ = this.code_;
                request.description_ = this.description_;
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    request.extra_ = this.extra_;
                } else {
                    request.extra_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV32 = this.commonBuilder_;
                if (singleFieldBuilderV32 == null) {
                    request.common_ = this.common_;
                } else {
                    request.common_ = singleFieldBuilderV32.build();
                }
                request.clientTime_ = this.clientTime_;
                request.serverRequestId_ = this.serverRequestId_;
                onBuilt();
                return request;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.type_ = 0;
                this.time_ = 0L;
                this.takes_ = 0;
                this.code_ = 0;
                this.description_ = "";
                if (this.extraBuilder_ == null) {
                    this.extra_ = null;
                } else {
                    this.extra_ = null;
                    this.extraBuilder_ = null;
                }
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                } else {
                    this.common_ = null;
                    this.commonBuilder_ = null;
                }
                this.clientTime_ = 0L;
                this.serverRequestId_ = "";
                return this;
            }

            public Builder clearClientTime() {
                this.clientTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearCode() {
                this.code_ = 0;
                onChanged();
                return this;
            }

            public Builder clearCommon() {
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                    onChanged();
                    return this;
                }
                this.common_ = null;
                this.commonBuilder_ = null;
                return this;
            }

            public Builder clearDescription() {
                this.description_ = Request.getDefaultInstance().getDescription();
                onChanged();
                return this;
            }

            public Builder clearExtra() {
                if (this.extraBuilder_ == null) {
                    this.extra_ = null;
                    onChanged();
                    return this;
                }
                this.extra_ = null;
                this.extraBuilder_ = null;
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

            public Builder clearServerRequestId() {
                this.serverRequestId_ = Request.getDefaultInstance().getServerRequestId();
                onChanged();
                return this;
            }

            public Builder clearTakes() {
                this.takes_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public long getClientTime() {
                return this.clientTime_;
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public int getCode() {
                return this.code_;
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public CommonProtos.Common getCommon() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    CommonProtos.Common common = this.common_;
                    CommonProtos.Common common2 = common;
                    if (common == null) {
                        common2 = CommonProtos.Common.getDefaultInstance();
                    }
                    return common2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public CommonProtos.Common.Builder getCommonBuilder() {
                onChanged();
                return getCommonFieldBuilder().getBuilder();
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                CommonProtos.Common common = this.common_;
                CommonProtos.Common common2 = common;
                if (common == null) {
                    common2 = CommonProtos.Common.getDefaultInstance();
                }
                return common2;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Request getDefaultInstanceForType() {
                return Request.getDefaultInstance();
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public String getDescription() {
                Object obj = this.description_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.description_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
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
                return ApmProtos.internal_static_com_blued_das_apm_Request_descriptor;
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public Any getExtra() {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Any any = this.extra_;
                    Any any2 = any;
                    if (any == null) {
                        any2 = Any.getDefaultInstance();
                    }
                    return any2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Any.Builder getExtraBuilder() {
                onChanged();
                return getExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public AnyOrBuilder getExtraOrBuilder() {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Any any = this.extra_;
                Any any2 = any;
                if (any == null) {
                    any2 = Any.getDefaultInstance();
                }
                return any2;
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public String getServerRequestId() {
                Object obj = this.serverRequestId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.serverRequestId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public ByteString getServerRequestIdBytes() {
                Object obj = this.serverRequestId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.serverRequestId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public int getTakes() {
                return this.takes_;
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public long getTime() {
                return this.time_;
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public Type getType() {
                Type valueOf = Type.valueOf(this.type_);
                Type type = valueOf;
                if (valueOf == null) {
                    type = Type.UNRECOGNIZED;
                }
                return type;
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
            public boolean hasExtra() {
                return (this.extraBuilder_ == null && this.extra_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ApmProtos.internal_static_com_blued_das_apm_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeCommon(CommonProtos.Common common) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(common);
                    return this;
                }
                CommonProtos.Common common2 = this.common_;
                if (common2 != null) {
                    this.common_ = CommonProtos.Common.newBuilder(common2).mergeFrom(common).buildPartial();
                } else {
                    this.common_ = common;
                }
                onChanged();
                return this;
            }

            public Builder mergeExtra(Any any) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(any);
                    return this;
                }
                Any any2 = this.extra_;
                if (any2 != null) {
                    this.extra_ = Any.newBuilder(any2).mergeFrom(any).buildPartial();
                } else {
                    this.extra_ = any;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(Request request) {
                if (request == Request.getDefaultInstance()) {
                    return this;
                }
                if (request.type_ != 0) {
                    setTypeValue(request.getTypeValue());
                }
                if (request.getTime() != 0) {
                    setTime(request.getTime());
                }
                if (request.getTakes() != 0) {
                    setTakes(request.getTakes());
                }
                if (request.getCode() != 0) {
                    setCode(request.getCode());
                }
                if (!request.getDescription().isEmpty()) {
                    this.description_ = request.description_;
                    onChanged();
                }
                if (request.hasExtra()) {
                    mergeExtra(request.getExtra());
                }
                if (request.hasCommon()) {
                    mergeCommon(request.getCommon());
                }
                if (request.getClientTime() != 0) {
                    setClientTime(request.getClientTime());
                }
                if (!request.getServerRequestId().isEmpty()) {
                    this.serverRequestId_ = request.serverRequestId_;
                    onChanged();
                }
                mergeUnknownFields(request.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.apm.ApmProtos.Request.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.apm.ApmProtos.Request.access$1600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.apm.ApmProtos$Request r0 = (com.blued.das.apm.ApmProtos.Request) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.apm.ApmProtos$Request$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.apm.ApmProtos$Request r0 = (com.blued.das.apm.ApmProtos.Request) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.apm.ApmProtos$Request$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.apm.ApmProtos.Request.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.apm.ApmProtos$Request$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Request) {
                    return mergeFrom((Request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setClientTime(long j) {
                this.clientTime_ = j;
                onChanged();
                return this;
            }

            public Builder setCode(int i) {
                this.code_ = i;
                onChanged();
                return this;
            }

            public Builder setCommon(CommonProtos.Common.Builder builder) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.common_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setCommon(CommonProtos.Common common) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(common);
                    return this;
                } else if (common != null) {
                    this.common_ = common;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
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
                    Request.checkByteStringIsUtf8(byteString);
                    this.description_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setExtra(Any.Builder builder) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.extra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setExtra(Any any) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(any);
                    return this;
                } else if (any != null) {
                    this.extra_ = any;
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

            public Builder setServerRequestId(String str) {
                if (str != null) {
                    this.serverRequestId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setServerRequestIdBytes(ByteString byteString) {
                if (byteString != null) {
                    Request.checkByteStringIsUtf8(byteString);
                    this.serverRequestId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTakes(int i) {
                this.takes_ = i;
                onChanged();
                return this;
            }

            public Builder setTime(long j) {
                this.time_ = j;
                onChanged();
                return this;
            }

            public Builder setType(Type type) {
                if (type != null) {
                    this.type_ = type.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTypeValue(int i) {
                this.type_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Request() {
            this.memoizedIsInitialized = (byte) -1;
            this.type_ = 0;
            this.description_ = "";
            this.serverRequestId_ = "";
        }

        private Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.type_ = codedInputStream.readEnum();
                            } else if (readTag == 16) {
                                this.time_ = codedInputStream.readInt64();
                            } else if (readTag == 24) {
                                this.takes_ = codedInputStream.readInt32();
                            } else if (readTag == 32) {
                                this.code_ = codedInputStream.readInt32();
                            } else if (readTag == 42) {
                                this.description_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 50) {
                                Any.Builder builder = this.extra_ != null ? this.extra_.toBuilder() : null;
                                Any any = (Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                                this.extra_ = any;
                                if (builder != null) {
                                    builder.mergeFrom(any);
                                    this.extra_ = builder.buildPartial();
                                }
                            } else if (readTag == 58) {
                                CommonProtos.Common.Builder builder2 = this.common_ != null ? this.common_.toBuilder() : null;
                                CommonProtos.Common common = (CommonProtos.Common) codedInputStream.readMessage(CommonProtos.Common.parser(), extensionRegistryLite);
                                this.common_ = common;
                                if (builder2 != null) {
                                    builder2.mergeFrom(common);
                                    this.common_ = builder2.buildPartial();
                                }
                            } else if (readTag == 64) {
                                this.clientTime_ = codedInputStream.readInt64();
                            } else if (readTag == 74) {
                                this.serverRequestId_ = codedInputStream.readStringRequireUtf8();
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

        private Request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApmProtos.internal_static_com_blued_das_apm_Request_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Request request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(request);
        }

        public static Request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Request parseFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Request> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Request) {
                Request request = (Request) obj;
                if (this.type_ == request.type_ && getTime() == request.getTime() && getTakes() == request.getTakes() && getCode() == request.getCode() && getDescription().equals(request.getDescription()) && hasExtra() == request.hasExtra()) {
                    if ((!hasExtra() || getExtra().equals(request.getExtra())) && hasCommon() == request.hasCommon()) {
                        return (!hasCommon() || getCommon().equals(request.getCommon())) && getClientTime() == request.getClientTime() && getServerRequestId().equals(request.getServerRequestId()) && this.unknownFields.equals(request.unknownFields);
                    }
                    return false;
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public long getClientTime() {
            return this.clientTime_;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public CommonProtos.Common getCommon() {
            CommonProtos.Common common = this.common_;
            CommonProtos.Common common2 = common;
            if (common == null) {
                common2 = CommonProtos.Common.getDefaultInstance();
            }
            return common2;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.description_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public ByteString getDescriptionBytes() {
            Object obj = this.description_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.description_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public Any getExtra() {
            Any any = this.extra_;
            Any any2 = any;
            if (any == null) {
                any2 = Any.getDefaultInstance();
            }
            return any2;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public AnyOrBuilder getExtraOrBuilder() {
            return getExtra();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Request> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.type_ != Type.UNKNOWN.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.type_);
            }
            long j = this.time_;
            int i3 = i2;
            if (j != 0) {
                i3 = i2 + CodedOutputStream.computeInt64Size(2, j);
            }
            int i4 = this.takes_;
            int i5 = i3;
            if (i4 != 0) {
                i5 = i3 + CodedOutputStream.computeInt32Size(3, i4);
            }
            int i6 = this.code_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeInt32Size(4, i6);
            }
            int i8 = i7;
            if (!getDescriptionBytes().isEmpty()) {
                i8 = i7 + GeneratedMessageV3.computeStringSize(5, this.description_);
            }
            int i9 = i8;
            if (this.extra_ != null) {
                i9 = i8 + CodedOutputStream.computeMessageSize(6, getExtra());
            }
            int i10 = i9;
            if (this.common_ != null) {
                i10 = i9 + CodedOutputStream.computeMessageSize(7, getCommon());
            }
            long j2 = this.clientTime_;
            int i11 = i10;
            if (j2 != 0) {
                i11 = i10 + CodedOutputStream.computeInt64Size(8, j2);
            }
            int i12 = i11;
            if (!getServerRequestIdBytes().isEmpty()) {
                i12 = i11 + GeneratedMessageV3.computeStringSize(9, this.serverRequestId_);
            }
            int serializedSize = i12 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public String getServerRequestId() {
            Object obj = this.serverRequestId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.serverRequestId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public ByteString getServerRequestIdBytes() {
            Object obj = this.serverRequestId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serverRequestId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public int getTakes() {
            return this.takes_;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public long getTime() {
            return this.time_;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public Type getType() {
            Type valueOf = Type.valueOf(this.type_);
            Type type = valueOf;
            if (valueOf == null) {
                type = Type.UNRECOGNIZED;
            }
            return type;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public boolean hasCommon() {
            return this.common_ != null;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestOrBuilder
        public boolean hasExtra() {
            return this.extra_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.type_) * 37) + 2) * 53) + Internal.hashLong(getTime())) * 37) + 3) * 53) + getTakes()) * 37) + 4) * 53) + getCode()) * 37) + 5) * 53) + getDescription().hashCode();
            int i = hashCode;
            if (hasExtra()) {
                i = (((hashCode * 37) + 6) * 53) + getExtra().hashCode();
            }
            int i2 = i;
            if (hasCommon()) {
                i2 = (((i * 37) + 7) * 53) + getCommon().hashCode();
            }
            int hashLong = (((((((((i2 * 37) + 8) * 53) + Internal.hashLong(getClientTime())) * 37) + 9) * 53) + getServerRequestId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashLong;
            return hashLong;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApmProtos.internal_static_com_blued_das_apm_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
            return new Request();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.type_ != Type.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(1, this.type_);
            }
            long j = this.time_;
            if (j != 0) {
                codedOutputStream.writeInt64(2, j);
            }
            int i = this.takes_;
            if (i != 0) {
                codedOutputStream.writeInt32(3, i);
            }
            int i2 = this.code_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(4, i2);
            }
            if (!getDescriptionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.description_);
            }
            if (this.extra_ != null) {
                codedOutputStream.writeMessage(6, getExtra());
            }
            if (this.common_ != null) {
                codedOutputStream.writeMessage(7, getCommon());
            }
            long j2 = this.clientTime_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(8, j2);
            }
            if (!getServerRequestIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.serverRequestId_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$RequestOrBuilder.class */
    public interface RequestOrBuilder extends MessageOrBuilder {
        long getClientTime();

        int getCode();

        CommonProtos.Common getCommon();

        CommonProtos.CommonOrBuilder getCommonOrBuilder();

        String getDescription();

        ByteString getDescriptionBytes();

        Any getExtra();

        AnyOrBuilder getExtraOrBuilder();

        String getServerRequestId();

        ByteString getServerRequestIdBytes();

        int getTakes();

        long getTime();

        Type getType();

        int getTypeValue();

        boolean hasCommon();

        boolean hasExtra();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$Requests.class */
    public static final class Requests extends GeneratedMessageV3 implements RequestsOrBuilder {
        public static final int COMMON_FIELD_NUMBER = 1;
        private static final Requests DEFAULT_INSTANCE = new Requests();
        private static final Parser<Requests> PARSER = new AbstractParser<Requests>() { // from class: com.blued.das.apm.ApmProtos.Requests.1
            @Override // com.google.protobuf.Parser
            public Requests parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Requests(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int REQUEST_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private CommonProtos.Common common_;
        private byte memoizedIsInitialized;
        private List<Request> request_;

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$Requests$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestsOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
            private CommonProtos.Common common_;
            private RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> requestBuilder_;
            private List<Request> request_;

            private Builder() {
                this.request_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.request_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void ensureRequestIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.request_ = new ArrayList(this.request_);
                    this.bitField0_ |= 1;
                }
            }

            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> getCommonFieldBuilder() {
                if (this.commonBuilder_ == null) {
                    this.commonBuilder_ = new SingleFieldBuilderV3<>(getCommon(), getParentForChildren(), isClean());
                    this.common_ = null;
                }
                return this.commonBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ApmProtos.internal_static_com_blued_das_apm_Requests_descriptor;
            }

            private RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> getRequestFieldBuilder() {
                if (this.requestBuilder_ == null) {
                    List<Request> list = this.request_;
                    boolean z = true;
                    if ((this.bitField0_ & 1) == 0) {
                        z = false;
                    }
                    this.requestBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                    this.request_ = null;
                }
                return this.requestBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (Requests.alwaysUseFieldBuilders) {
                    getRequestFieldBuilder();
                }
            }

            public Builder addAllRequest(Iterable<? extends Request> iterable) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                    return this;
                }
                ensureRequestIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.request_);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public Builder addRequest(int i, Request.Builder builder) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                    return this;
                }
                ensureRequestIsMutable();
                this.request_.add(i, builder.build());
                onChanged();
                return this;
            }

            public Builder addRequest(int i, Request request) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, request);
                    return this;
                } else if (request != null) {
                    ensureRequestIsMutable();
                    this.request_.add(i, request);
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder addRequest(Request.Builder builder) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                    return this;
                }
                ensureRequestIsMutable();
                this.request_.add(builder.build());
                onChanged();
                return this;
            }

            public Builder addRequest(Request request) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(request);
                    return this;
                } else if (request != null) {
                    ensureRequestIsMutable();
                    this.request_.add(request);
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Request.Builder addRequestBuilder() {
                return getRequestFieldBuilder().addBuilder(Request.getDefaultInstance());
            }

            public Request.Builder addRequestBuilder(int i) {
                return getRequestFieldBuilder().addBuilder(i, Request.getDefaultInstance());
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Requests build() {
                Requests buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Requests buildPartial() {
                Requests requests = new Requests(this);
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    requests.common_ = this.common_;
                } else {
                    requests.common_ = singleFieldBuilderV3.build();
                }
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.request_ = Collections.unmodifiableList(this.request_);
                        this.bitField0_ &= -2;
                    }
                    requests.request_ = this.request_;
                } else {
                    requests.request_ = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return requests;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                } else {
                    this.common_ = null;
                    this.commonBuilder_ = null;
                }
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.clear();
                    return this;
                }
                this.request_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearCommon() {
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                    onChanged();
                    return this;
                }
                this.common_ = null;
                this.commonBuilder_ = null;
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

            public Builder clearRequest() {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.clear();
                    return this;
                }
                this.request_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
            public CommonProtos.Common getCommon() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    CommonProtos.Common common = this.common_;
                    CommonProtos.Common common2 = common;
                    if (common == null) {
                        common2 = CommonProtos.Common.getDefaultInstance();
                    }
                    return common2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public CommonProtos.Common.Builder getCommonBuilder() {
                onChanged();
                return getCommonFieldBuilder().getBuilder();
            }

            @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
            public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                CommonProtos.Common common = this.common_;
                CommonProtos.Common common2 = common;
                if (common == null) {
                    common2 = CommonProtos.Common.getDefaultInstance();
                }
                return common2;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Requests getDefaultInstanceForType() {
                return Requests.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ApmProtos.internal_static_com_blued_das_apm_Requests_descriptor;
            }

            @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
            public Request getRequest(int i) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                return repeatedFieldBuilderV3 == null ? this.request_.get(i) : repeatedFieldBuilderV3.getMessage(i);
            }

            public Request.Builder getRequestBuilder(int i) {
                return getRequestFieldBuilder().getBuilder(i);
            }

            public List<Request.Builder> getRequestBuilderList() {
                return getRequestFieldBuilder().getBuilderList();
            }

            @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
            public int getRequestCount() {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                return repeatedFieldBuilderV3 == null ? this.request_.size() : repeatedFieldBuilderV3.getCount();
            }

            @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
            public List<Request> getRequestList() {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.request_) : repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
            public RequestOrBuilder getRequestOrBuilder(int i) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                return repeatedFieldBuilderV3 == null ? this.request_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
            public List<? extends RequestOrBuilder> getRequestOrBuilderList() {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.request_);
            }

            @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ApmProtos.internal_static_com_blued_das_apm_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(Requests.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeCommon(CommonProtos.Common common) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(common);
                    return this;
                }
                CommonProtos.Common common2 = this.common_;
                if (common2 != null) {
                    this.common_ = CommonProtos.Common.newBuilder(common2).mergeFrom(common).buildPartial();
                } else {
                    this.common_ = common;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(Requests requests) {
                if (requests == Requests.getDefaultInstance()) {
                    return this;
                }
                if (requests.hasCommon()) {
                    mergeCommon(requests.getCommon());
                }
                if (this.requestBuilder_ == null) {
                    if (!requests.request_.isEmpty()) {
                        if (this.request_.isEmpty()) {
                            this.request_ = requests.request_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRequestIsMutable();
                            this.request_.addAll(requests.request_);
                        }
                        onChanged();
                    }
                } else if (!requests.request_.isEmpty()) {
                    if (this.requestBuilder_.isEmpty()) {
                        this.requestBuilder_.dispose();
                        RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = null;
                        this.requestBuilder_ = null;
                        this.request_ = requests.request_;
                        this.bitField0_ &= -2;
                        if (Requests.alwaysUseFieldBuilders) {
                            repeatedFieldBuilderV3 = getRequestFieldBuilder();
                        }
                        this.requestBuilder_ = repeatedFieldBuilderV3;
                    } else {
                        this.requestBuilder_.addAllMessages(requests.request_);
                    }
                }
                mergeUnknownFields(requests.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.apm.ApmProtos.Requests.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.apm.ApmProtos.Requests.access$15900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.apm.ApmProtos$Requests r0 = (com.blued.das.apm.ApmProtos.Requests) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.apm.ApmProtos$Requests$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.apm.ApmProtos$Requests r0 = (com.blued.das.apm.ApmProtos.Requests) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.apm.ApmProtos$Requests$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.apm.ApmProtos.Requests.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.apm.ApmProtos$Requests$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Requests) {
                    return mergeFrom((Requests) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder removeRequest(int i) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.remove(i);
                    return this;
                }
                ensureRequestIsMutable();
                this.request_.remove(i);
                onChanged();
                return this;
            }

            public Builder setCommon(CommonProtos.Common.Builder builder) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.common_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setCommon(CommonProtos.Common common) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(common);
                    return this;
                } else if (common != null) {
                    this.common_ = common;
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

            public Builder setRequest(int i, Request.Builder builder) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                    return this;
                }
                ensureRequestIsMutable();
                this.request_.set(i, builder.build());
                onChanged();
                return this;
            }

            public Builder setRequest(int i, Request request) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, request);
                    return this;
                } else if (request != null) {
                    ensureRequestIsMutable();
                    this.request_.set(i, request);
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

        private Requests() {
            this.memoizedIsInitialized = (byte) -1;
            this.request_ = Collections.emptyList();
        }

        private Requests(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            CommonProtos.Common.Builder builder;
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
                                if (this.common_ != null) {
                                    boolean z4 = z2;
                                    builder = this.common_.toBuilder();
                                } else {
                                    builder = null;
                                }
                                CommonProtos.Common common = (CommonProtos.Common) codedInputStream.readMessage(CommonProtos.Common.parser(), extensionRegistryLite);
                                boolean z5 = z2;
                                this.common_ = common;
                                if (builder != null) {
                                    builder.mergeFrom(common);
                                    boolean z6 = z2;
                                    this.common_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                boolean z7 = z2;
                                if (!(z2 & true)) {
                                    this.request_ = new ArrayList();
                                    z7 = z2 | true;
                                }
                                this.request_.add((Request) codedInputStream.readMessage(Request.parser(), extensionRegistryLite));
                                z2 = z7;
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
                        this.request_ = Collections.unmodifiableList(this.request_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.request_ = Collections.unmodifiableList(this.request_);
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private Requests(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Requests getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApmProtos.internal_static_com_blued_das_apm_Requests_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Requests requests) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(requests);
        }

        public static Requests parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Requests) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Requests parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Requests) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Requests parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Requests parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Requests parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Requests) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Requests parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Requests) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Requests parseFrom(InputStream inputStream) throws IOException {
            return (Requests) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Requests parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Requests) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Requests parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Requests parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Requests parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Requests parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Requests> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Requests) {
                Requests requests = (Requests) obj;
                if (hasCommon() != requests.hasCommon()) {
                    return false;
                }
                return (!hasCommon() || getCommon().equals(requests.getCommon())) && getRequestList().equals(requests.getRequestList()) && this.unknownFields.equals(requests.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
        public CommonProtos.Common getCommon() {
            CommonProtos.Common common = this.common_;
            CommonProtos.Common common2 = common;
            if (common == null) {
                common2 = CommonProtos.Common.getDefaultInstance();
            }
            return common2;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
        public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Requests getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Requests> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
        public Request getRequest(int i) {
            return this.request_.get(i);
        }

        @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
        public int getRequestCount() {
            return this.request_.size();
        }

        @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
        public List<Request> getRequestList() {
            return this.request_;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
        public RequestOrBuilder getRequestOrBuilder(int i) {
            return this.request_.get(i);
        }

        @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
        public List<? extends RequestOrBuilder> getRequestOrBuilderList() {
            return this.request_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.common_ != null ? CodedOutputStream.computeMessageSize(1, getCommon()) + 0 : 0;
            for (int i2 = 0; i2 < this.request_.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, this.request_.get(i2));
            }
            int serializedSize = computeMessageSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.das.apm.ApmProtos.RequestsOrBuilder
        public boolean hasCommon() {
            return this.common_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            int i = hashCode;
            if (hasCommon()) {
                i = (((hashCode * 37) + 1) * 53) + getCommon().hashCode();
            }
            int i2 = i;
            if (getRequestCount() > 0) {
                i2 = (((i * 37) + 2) * 53) + getRequestList().hashCode();
            }
            int hashCode2 = (i2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApmProtos.internal_static_com_blued_das_apm_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(Requests.class, Builder.class);
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
            return new Requests();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.common_ != null) {
                codedOutputStream.writeMessage(1, getCommon());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.request_.size()) {
                    this.unknownFields.writeTo(codedOutputStream);
                    return;
                } else {
                    codedOutputStream.writeMessage(2, this.request_.get(i2));
                    i = i2 + 1;
                }
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$RequestsOrBuilder.class */
    public interface RequestsOrBuilder extends MessageOrBuilder {
        CommonProtos.Common getCommon();

        CommonProtos.CommonOrBuilder getCommonOrBuilder();

        Request getRequest(int i);

        int getRequestCount();

        List<Request> getRequestList();

        RequestOrBuilder getRequestOrBuilder(int i);

        List<? extends RequestOrBuilder> getRequestOrBuilderList();

        boolean hasCommon();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$Response.class */
    public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final Response DEFAULT_INSTANCE = new Response();
        private static final Parser<Response> PARSER = new AbstractParser<Response>() { // from class: com.blued.das.apm.ApmProtos.Response.1
            @Override // com.google.protobuf.Parser
            public Response parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Response(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        private int code_;
        private byte memoizedIsInitialized;

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$Response$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResponseOrBuilder {
            private int code_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ApmProtos.internal_static_com_blued_das_apm_Response_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Response.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Response build() {
                Response buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Response buildPartial() {
                Response response = new Response(this);
                response.code_ = this.code_;
                onBuilt();
                return response;
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

            @Override // com.blued.das.apm.ApmProtos.ResponseOrBuilder
            public int getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Response getDefaultInstanceForType() {
                return Response.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ApmProtos.internal_static_com_blued_das_apm_Response_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ApmProtos.internal_static_com_blued_das_apm_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Response response) {
                if (response == Response.getDefaultInstance()) {
                    return this;
                }
                if (response.getCode() != 0) {
                    setCode(response.getCode());
                }
                mergeUnknownFields(response.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.apm.ApmProtos.Response.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.apm.ApmProtos.Response.access$16900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.apm.ApmProtos$Response r0 = (com.blued.das.apm.ApmProtos.Response) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.apm.ApmProtos$Response$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.apm.ApmProtos$Response r0 = (com.blued.das.apm.ApmProtos.Response) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.apm.ApmProtos$Response$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.apm.ApmProtos.Response.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.apm.ApmProtos$Response$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Response) {
                    return mergeFrom((Response) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setCode(int i) {
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

        private Response() {
            this.memoizedIsInitialized = (byte) -1;
        }

        private Response(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.code_ = codedInputStream.readInt32();
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

        private Response(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Response getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApmProtos.internal_static_com_blued_das_apm_Response_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Response response) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(response);
        }

        public static Response parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Response parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Response parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Response parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Response parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Response parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Response parseFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Response parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Response parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Response parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Response parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Response parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Response> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Response) {
                Response response = (Response) obj;
                return getCode() == response.getCode() && this.unknownFields.equals(response.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.apm.ApmProtos.ResponseOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Response getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Response> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.code_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeInt32Size(1, i3);
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
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApmProtos.internal_static_com_blued_das_apm_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
            return new Response();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.code_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$ResponseOrBuilder.class */
    public interface ResponseOrBuilder extends MessageOrBuilder {
        int getCode();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$SocketTypeProto.class */
    public static final class SocketTypeProto extends GeneratedMessageV3 implements SocketTypeProtoOrBuilder {
        public static final int HOST_FIELD_NUMBER = 1;
        public static final int PORT_FIELD_NUMBER = 2;
        public static final int SERVER_IP_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private volatile Object host_;
        private byte memoizedIsInitialized;
        private int port_;
        private volatile Object serverIp_;
        private static final SocketTypeProto DEFAULT_INSTANCE = new SocketTypeProto();
        private static final Parser<SocketTypeProto> PARSER = new AbstractParser<SocketTypeProto>() { // from class: com.blued.das.apm.ApmProtos.SocketTypeProto.1
            @Override // com.google.protobuf.Parser
            public SocketTypeProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SocketTypeProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$SocketTypeProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SocketTypeProtoOrBuilder {
            private Object host_;
            private int port_;
            private Object serverIp_;

            private Builder() {
                this.host_ = "";
                this.serverIp_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.host_ = "";
                this.serverIp_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ApmProtos.internal_static_com_blued_das_apm_SocketTypeProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SocketTypeProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SocketTypeProto build() {
                SocketTypeProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SocketTypeProto buildPartial() {
                SocketTypeProto socketTypeProto = new SocketTypeProto(this);
                socketTypeProto.host_ = this.host_;
                socketTypeProto.port_ = this.port_;
                socketTypeProto.serverIp_ = this.serverIp_;
                onBuilt();
                return socketTypeProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.host_ = "";
                this.port_ = 0;
                this.serverIp_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearHost() {
                this.host_ = SocketTypeProto.getDefaultInstance().getHost();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPort() {
                this.port_ = 0;
                onChanged();
                return this;
            }

            public Builder clearServerIp() {
                this.serverIp_ = SocketTypeProto.getDefaultInstance().getServerIp();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SocketTypeProto getDefaultInstanceForType() {
                return SocketTypeProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ApmProtos.internal_static_com_blued_das_apm_SocketTypeProto_descriptor;
            }

            @Override // com.blued.das.apm.ApmProtos.SocketTypeProtoOrBuilder
            public String getHost() {
                Object obj = this.host_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.host_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.SocketTypeProtoOrBuilder
            public ByteString getHostBytes() {
                Object obj = this.host_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.host_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.apm.ApmProtos.SocketTypeProtoOrBuilder
            public int getPort() {
                return this.port_;
            }

            @Override // com.blued.das.apm.ApmProtos.SocketTypeProtoOrBuilder
            public String getServerIp() {
                Object obj = this.serverIp_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.serverIp_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.SocketTypeProtoOrBuilder
            public ByteString getServerIpBytes() {
                Object obj = this.serverIp_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.serverIp_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ApmProtos.internal_static_com_blued_das_apm_SocketTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SocketTypeProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(SocketTypeProto socketTypeProto) {
                if (socketTypeProto == SocketTypeProto.getDefaultInstance()) {
                    return this;
                }
                if (!socketTypeProto.getHost().isEmpty()) {
                    this.host_ = socketTypeProto.host_;
                    onChanged();
                }
                if (socketTypeProto.getPort() != 0) {
                    setPort(socketTypeProto.getPort());
                }
                if (!socketTypeProto.getServerIp().isEmpty()) {
                    this.serverIp_ = socketTypeProto.serverIp_;
                    onChanged();
                }
                mergeUnknownFields(socketTypeProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.apm.ApmProtos.SocketTypeProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.apm.ApmProtos.SocketTypeProto.access$9000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.apm.ApmProtos$SocketTypeProto r0 = (com.blued.das.apm.ApmProtos.SocketTypeProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.apm.ApmProtos$SocketTypeProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.apm.ApmProtos$SocketTypeProto r0 = (com.blued.das.apm.ApmProtos.SocketTypeProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.apm.ApmProtos$SocketTypeProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.apm.ApmProtos.SocketTypeProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.apm.ApmProtos$SocketTypeProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof SocketTypeProto) {
                    return mergeFrom((SocketTypeProto) message);
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

            public Builder setHost(String str) {
                if (str != null) {
                    this.host_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setHostBytes(ByteString byteString) {
                if (byteString != null) {
                    SocketTypeProto.checkByteStringIsUtf8(byteString);
                    this.host_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPort(int i) {
                this.port_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setServerIp(String str) {
                if (str != null) {
                    this.serverIp_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setServerIpBytes(ByteString byteString) {
                if (byteString != null) {
                    SocketTypeProto.checkByteStringIsUtf8(byteString);
                    this.serverIp_ = byteString;
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

        private SocketTypeProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.host_ = "";
            this.serverIp_ = "";
        }

        private SocketTypeProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.host_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 16) {
                                    this.port_ = codedInputStream.readInt32();
                                } else if (readTag == 26) {
                                    this.serverIp_ = codedInputStream.readStringRequireUtf8();
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

        private SocketTypeProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SocketTypeProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApmProtos.internal_static_com_blued_das_apm_SocketTypeProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SocketTypeProto socketTypeProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(socketTypeProto);
        }

        public static SocketTypeProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SocketTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SocketTypeProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SocketTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SocketTypeProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SocketTypeProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SocketTypeProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SocketTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SocketTypeProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SocketTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static SocketTypeProto parseFrom(InputStream inputStream) throws IOException {
            return (SocketTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SocketTypeProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SocketTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SocketTypeProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SocketTypeProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SocketTypeProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SocketTypeProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<SocketTypeProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof SocketTypeProto) {
                SocketTypeProto socketTypeProto = (SocketTypeProto) obj;
                return getHost().equals(socketTypeProto.getHost()) && getPort() == socketTypeProto.getPort() && getServerIp().equals(socketTypeProto.getServerIp()) && this.unknownFields.equals(socketTypeProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SocketTypeProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.apm.ApmProtos.SocketTypeProtoOrBuilder
        public String getHost() {
            Object obj = this.host_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.host_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.SocketTypeProtoOrBuilder
        public ByteString getHostBytes() {
            Object obj = this.host_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.host_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SocketTypeProto> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.apm.ApmProtos.SocketTypeProtoOrBuilder
        public int getPort() {
            return this.port_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getHostBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.host_);
            }
            int i3 = this.port_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeInt32Size(2, i3);
            }
            int i5 = i4;
            if (!getServerIpBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.serverIp_);
            }
            int serializedSize = i5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.apm.ApmProtos.SocketTypeProtoOrBuilder
        public String getServerIp() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.serverIp_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.SocketTypeProtoOrBuilder
        public ByteString getServerIpBytes() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serverIp_ = copyFromUtf8;
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
            int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getHost().hashCode()) * 37) + 2) * 53) + getPort()) * 37) + 3) * 53) + getServerIp().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApmProtos.internal_static_com_blued_das_apm_SocketTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SocketTypeProto.class, Builder.class);
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
            return new SocketTypeProto();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getHostBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.host_);
            }
            int i = this.port_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            if (!getServerIpBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.serverIp_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$SocketTypeProtoOrBuilder.class */
    public interface SocketTypeProtoOrBuilder extends MessageOrBuilder {
        String getHost();

        ByteString getHostBytes();

        int getPort();

        String getServerIp();

        ByteString getServerIpBytes();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$Type.class */
    public enum Type implements ProtocolMessageEnum {
        UNKNOWN(0),
        HTTP(1),
        IM(2),
        SOCKET(3),
        WEB(4),
        EROS_GRPC(5),
        EROS_SOCKET(6),
        OPEN_TIME(7),
        GRPC_CONNECT(8),
        GRPC_REQUEST(9),
        ALERT(10),
        UNRECOGNIZED(-1);
        
        public static final int ALERT_VALUE = 10;
        public static final int EROS_GRPC_VALUE = 5;
        public static final int EROS_SOCKET_VALUE = 6;
        public static final int GRPC_CONNECT_VALUE = 8;
        public static final int GRPC_REQUEST_VALUE = 9;
        public static final int HTTP_VALUE = 1;
        public static final int IM_VALUE = 2;
        public static final int OPEN_TIME_VALUE = 7;
        public static final int SOCKET_VALUE = 3;
        public static final int UNKNOWN_VALUE = 0;
        public static final int WEB_VALUE = 4;
        private final int value;
        private static final Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: com.blued.das.apm.ApmProtos.Type.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Type findValueByNumber(int i) {
                return Type.forNumber(i);
            }
        };
        private static final Type[] VALUES = values();

        Type(int i) {
            this.value = i;
        }

        public static Type forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN;
                case 1:
                    return HTTP;
                case 2:
                    return IM;
                case 3:
                    return SOCKET;
                case 4:
                    return WEB;
                case 5:
                    return EROS_GRPC;
                case 6:
                    return EROS_SOCKET;
                case 7:
                    return OPEN_TIME;
                case 8:
                    return GRPC_CONNECT;
                case 9:
                    return GRPC_REQUEST;
                case 10:
                    return ALERT;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ApmProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Type> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Type valueOf(int i) {
            return forNumber(i);
        }

        public static Type valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$WebTypeProto.class */
    public static final class WebTypeProto extends GeneratedMessageV3 implements WebTypeProtoOrBuilder {
        private static final WebTypeProto DEFAULT_INSTANCE = new WebTypeProto();
        private static final Parser<WebTypeProto> PARSER = new AbstractParser<WebTypeProto>() { // from class: com.blued.das.apm.ApmProtos.WebTypeProto.1
            @Override // com.google.protobuf.Parser
            public WebTypeProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WebTypeProto(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int URL_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object url_;

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$WebTypeProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WebTypeProtoOrBuilder {
            private Object url_;

            private Builder() {
                this.url_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.url_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ApmProtos.internal_static_com_blued_das_apm_WebTypeProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = WebTypeProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WebTypeProto build() {
                WebTypeProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WebTypeProto buildPartial() {
                WebTypeProto webTypeProto = new WebTypeProto(this);
                webTypeProto.url_ = this.url_;
                onBuilt();
                return webTypeProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.url_ = "";
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

            public Builder clearUrl() {
                this.url_ = WebTypeProto.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WebTypeProto getDefaultInstanceForType() {
                return WebTypeProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ApmProtos.internal_static_com_blued_das_apm_WebTypeProto_descriptor;
            }

            @Override // com.blued.das.apm.ApmProtos.WebTypeProtoOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.apm.ApmProtos.WebTypeProtoOrBuilder
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
                return ApmProtos.internal_static_com_blued_das_apm_WebTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(WebTypeProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(WebTypeProto webTypeProto) {
                if (webTypeProto == WebTypeProto.getDefaultInstance()) {
                    return this;
                }
                if (!webTypeProto.getUrl().isEmpty()) {
                    this.url_ = webTypeProto.url_;
                    onChanged();
                }
                mergeUnknownFields(webTypeProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.apm.ApmProtos.WebTypeProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.apm.ApmProtos.WebTypeProto.access$13700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.apm.ApmProtos$WebTypeProto r0 = (com.blued.das.apm.ApmProtos.WebTypeProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.apm.ApmProtos$WebTypeProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.apm.ApmProtos$WebTypeProto r0 = (com.blued.das.apm.ApmProtos.WebTypeProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.apm.ApmProtos$WebTypeProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.apm.ApmProtos.WebTypeProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.apm.ApmProtos$WebTypeProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof WebTypeProto) {
                    return mergeFrom((WebTypeProto) message);
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
                    WebTypeProto.checkByteStringIsUtf8(byteString);
                    this.url_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }
        }

        private WebTypeProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.url_ = "";
        }

        private WebTypeProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.url_ = codedInputStream.readStringRequireUtf8();
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

        private WebTypeProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static WebTypeProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApmProtos.internal_static_com_blued_das_apm_WebTypeProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WebTypeProto webTypeProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(webTypeProto);
        }

        public static WebTypeProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WebTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WebTypeProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WebTypeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WebTypeProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static WebTypeProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static WebTypeProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WebTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WebTypeProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WebTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static WebTypeProto parseFrom(InputStream inputStream) throws IOException {
            return (WebTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static WebTypeProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WebTypeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WebTypeProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static WebTypeProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static WebTypeProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static WebTypeProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<WebTypeProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof WebTypeProto) {
                WebTypeProto webTypeProto = (WebTypeProto) obj;
                return getUrl().equals(webTypeProto.getUrl()) && this.unknownFields.equals(webTypeProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WebTypeProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WebTypeProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getUrlBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.url_);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.das.apm.ApmProtos.WebTypeProtoOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.apm.ApmProtos.WebTypeProtoOrBuilder
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
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUrl().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApmProtos.internal_static_com_blued_das_apm_WebTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(WebTypeProto.class, Builder.class);
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
            return new WebTypeProto();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.url_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ApmProtos$WebTypeProtoOrBuilder.class */
    public interface WebTypeProtoOrBuilder extends MessageOrBuilder {
        String getUrl();

        ByteString getUrlBytes();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_das_apm_Request_descriptor = descriptor2;
        internal_static_com_blued_das_apm_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Type", "Time", "Takes", "Code", "Description", "Extra", "Common", "ClientTime", "ServerRequestId"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_blued_das_apm_HttpTypeProto_descriptor = descriptor3;
        internal_static_com_blued_das_apm_HttpTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Url", "ResponseType", "ResponseLength", "ServerIp"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_blued_das_apm_AlertTypeProto_descriptor = descriptor4;
        internal_static_com_blued_das_apm_AlertTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Name"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(3);
        internal_static_com_blued_das_apm_ImTypeProto_descriptor = descriptor5;
        internal_static_com_blued_das_apm_ImTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Name", "Host", "Port", "ServerIp"});
        Descriptors.Descriptor descriptor6 = getDescriptor().getMessageTypes().get(4);
        internal_static_com_blued_das_apm_GrpcRequestTypeProto_descriptor = descriptor6;
        internal_static_com_blued_das_apm_GrpcRequestTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{"Name", "Host", "Port", "ServerIp", "Business"});
        Descriptors.Descriptor descriptor7 = getDescriptor().getMessageTypes().get(5);
        internal_static_com_blued_das_apm_SocketTypeProto_descriptor = descriptor7;
        internal_static_com_blued_das_apm_SocketTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor7, new String[]{"Host", "Port", "ServerIp"});
        Descriptors.Descriptor descriptor8 = getDescriptor().getMessageTypes().get(6);
        internal_static_com_blued_das_apm_GrpcConnectTypeProto_descriptor = descriptor8;
        internal_static_com_blued_das_apm_GrpcConnectTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor8, new String[]{"Host", "Port", "ServerIp", "Business"});
        Descriptors.Descriptor descriptor9 = getDescriptor().getMessageTypes().get(7);
        internal_static_com_blued_das_apm_ErosGrpcTypeProto_descriptor = descriptor9;
        internal_static_com_blued_das_apm_ErosGrpcTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor9, new String[]{"Type"});
        Descriptors.Descriptor descriptor10 = getDescriptor().getMessageTypes().get(8);
        internal_static_com_blued_das_apm_ErosSocketTypeProto_descriptor = descriptor10;
        internal_static_com_blued_das_apm_ErosSocketTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor10, new String[]{"Type"});
        Descriptors.Descriptor descriptor11 = getDescriptor().getMessageTypes().get(9);
        internal_static_com_blued_das_apm_WebTypeProto_descriptor = descriptor11;
        internal_static_com_blued_das_apm_WebTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor11, new String[]{"Url"});
        Descriptors.Descriptor descriptor12 = getDescriptor().getMessageTypes().get(10);
        internal_static_com_blued_das_apm_OpenTimeTypeProto_descriptor = descriptor12;
        internal_static_com_blued_das_apm_OpenTimeTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor12, new String[0]);
        Descriptors.Descriptor descriptor13 = getDescriptor().getMessageTypes().get(11);
        internal_static_com_blued_das_apm_Requests_descriptor = descriptor13;
        internal_static_com_blued_das_apm_Requests_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor13, new String[]{"Common", "Request"});
        Descriptors.Descriptor descriptor14 = getDescriptor().getMessageTypes().get(12);
        internal_static_com_blued_das_apm_Response_descriptor = descriptor14;
        internal_static_com_blued_das_apm_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor14, new String[]{"Code"});
        AnyProto.getDescriptor();
        CommonProtos.getDescriptor();
    }

    private ApmProtos() {
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
