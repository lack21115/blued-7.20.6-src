package com.google.cloud.audit;

import com.google.cloud.audit.AuthenticationInfo;
import com.google.cloud.audit.AuthorizationInfo;
import com.google.cloud.audit.RequestMetadata;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.rpc.Status;
import com.google.rpc.StatusOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/cloud/audit/AuditLog.class */
public final class AuditLog extends GeneratedMessageV3 implements AuditLogOrBuilder {
    public static final int AUTHENTICATION_INFO_FIELD_NUMBER = 3;
    public static final int AUTHORIZATION_INFO_FIELD_NUMBER = 9;
    public static final int METHOD_NAME_FIELD_NUMBER = 8;
    public static final int NUM_RESPONSE_ITEMS_FIELD_NUMBER = 12;
    public static final int REQUEST_FIELD_NUMBER = 16;
    public static final int REQUEST_METADATA_FIELD_NUMBER = 4;
    public static final int RESOURCE_NAME_FIELD_NUMBER = 11;
    public static final int RESPONSE_FIELD_NUMBER = 17;
    public static final int SERVICE_DATA_FIELD_NUMBER = 15;
    public static final int SERVICE_NAME_FIELD_NUMBER = 7;
    public static final int STATUS_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private AuthenticationInfo authenticationInfo_;
    private List<AuthorizationInfo> authorizationInfo_;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private volatile Object methodName_;
    private long numResponseItems_;
    private RequestMetadata requestMetadata_;
    private Struct request_;
    private volatile Object resourceName_;
    private Struct response_;
    private Any serviceData_;
    private volatile Object serviceName_;
    private Status status_;
    private static final AuditLog DEFAULT_INSTANCE = new AuditLog();
    private static final Parser<AuditLog> PARSER = new AbstractParser<AuditLog>() { // from class: com.google.cloud.audit.AuditLog.1
        @Override // com.google.protobuf.Parser
        public AuditLog parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new AuditLog(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-8110460-dex2jar.jar:com/google/cloud/audit/AuditLog$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuditLogOrBuilder {
        private SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> authenticationInfoBuilder_;
        private AuthenticationInfo authenticationInfo_;
        private RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> authorizationInfoBuilder_;
        private List<AuthorizationInfo> authorizationInfo_;
        private int bitField0_;
        private Object methodName_;
        private long numResponseItems_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> requestBuilder_;
        private SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> requestMetadataBuilder_;
        private RequestMetadata requestMetadata_;
        private Struct request_;
        private Object resourceName_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> responseBuilder_;
        private Struct response_;
        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> serviceDataBuilder_;
        private Any serviceData_;
        private Object serviceName_;
        private SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> statusBuilder_;
        private Status status_;

        private Builder() {
            this.serviceName_ = "";
            this.methodName_ = "";
            this.resourceName_ = "";
            this.authorizationInfo_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.serviceName_ = "";
            this.methodName_ = "";
            this.resourceName_ = "";
            this.authorizationInfo_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureAuthorizationInfoIsMutable() {
            if ((this.bitField0_ & 64) == 0) {
                this.authorizationInfo_ = new ArrayList(this.authorizationInfo_);
                this.bitField0_ |= 64;
            }
        }

        private SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> getAuthenticationInfoFieldBuilder() {
            if (this.authenticationInfoBuilder_ == null) {
                this.authenticationInfoBuilder_ = new SingleFieldBuilderV3<>(getAuthenticationInfo(), getParentForChildren(), isClean());
                this.authenticationInfo_ = null;
            }
            return this.authenticationInfoBuilder_;
        }

        private RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> getAuthorizationInfoFieldBuilder() {
            if (this.authorizationInfoBuilder_ == null) {
                this.authorizationInfoBuilder_ = new RepeatedFieldBuilderV3<>(this.authorizationInfo_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                this.authorizationInfo_ = null;
            }
            return this.authorizationInfoBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AuditLogProto.internal_static_google_cloud_audit_AuditLog_descriptor;
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getRequestFieldBuilder() {
            if (this.requestBuilder_ == null) {
                this.requestBuilder_ = new SingleFieldBuilderV3<>(getRequest(), getParentForChildren(), isClean());
                this.request_ = null;
            }
            return this.requestBuilder_;
        }

        private SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> getRequestMetadataFieldBuilder() {
            if (this.requestMetadataBuilder_ == null) {
                this.requestMetadataBuilder_ = new SingleFieldBuilderV3<>(getRequestMetadata(), getParentForChildren(), isClean());
                this.requestMetadata_ = null;
            }
            return this.requestMetadataBuilder_;
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getResponseFieldBuilder() {
            if (this.responseBuilder_ == null) {
                this.responseBuilder_ = new SingleFieldBuilderV3<>(getResponse(), getParentForChildren(), isClean());
                this.response_ = null;
            }
            return this.responseBuilder_;
        }

        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getServiceDataFieldBuilder() {
            if (this.serviceDataBuilder_ == null) {
                this.serviceDataBuilder_ = new SingleFieldBuilderV3<>(getServiceData(), getParentForChildren(), isClean());
                this.serviceData_ = null;
            }
            return this.serviceDataBuilder_;
        }

        private SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> getStatusFieldBuilder() {
            if (this.statusBuilder_ == null) {
                this.statusBuilder_ = new SingleFieldBuilderV3<>(getStatus(), getParentForChildren(), isClean());
                this.status_ = null;
            }
            return this.statusBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (AuditLog.alwaysUseFieldBuilders) {
                getAuthorizationInfoFieldBuilder();
            }
        }

        public Builder addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> iterable) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureAuthorizationInfoIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.authorizationInfo_);
            onChanged();
            return this;
        }

        public Builder addAuthorizationInfo(int i, AuthorizationInfo.Builder builder) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureAuthorizationInfoIsMutable();
            this.authorizationInfo_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, authorizationInfo);
                return this;
            } else if (authorizationInfo != null) {
                ensureAuthorizationInfoIsMutable();
                this.authorizationInfo_.add(i, authorizationInfo);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addAuthorizationInfo(AuthorizationInfo.Builder builder) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureAuthorizationInfoIsMutable();
            this.authorizationInfo_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addAuthorizationInfo(AuthorizationInfo authorizationInfo) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(authorizationInfo);
                return this;
            } else if (authorizationInfo != null) {
                ensureAuthorizationInfoIsMutable();
                this.authorizationInfo_.add(authorizationInfo);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public AuthorizationInfo.Builder addAuthorizationInfoBuilder() {
            return getAuthorizationInfoFieldBuilder().addBuilder(AuthorizationInfo.getDefaultInstance());
        }

        public AuthorizationInfo.Builder addAuthorizationInfoBuilder(int i) {
            return getAuthorizationInfoFieldBuilder().addBuilder(i, AuthorizationInfo.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AuditLog build() {
            AuditLog buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AuditLog buildPartial() {
            AuditLog auditLog = new AuditLog(this);
            auditLog.serviceName_ = this.serviceName_;
            auditLog.methodName_ = this.methodName_;
            auditLog.resourceName_ = this.resourceName_;
            auditLog.numResponseItems_ = this.numResponseItems_;
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
            if (singleFieldBuilderV3 == null) {
                auditLog.status_ = this.status_;
            } else {
                auditLog.status_ = singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV32 = this.authenticationInfoBuilder_;
            if (singleFieldBuilderV32 == null) {
                auditLog.authenticationInfo_ = this.authenticationInfo_;
            } else {
                auditLog.authenticationInfo_ = singleFieldBuilderV32.build();
            }
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 64) != 0) {
                    this.authorizationInfo_ = Collections.unmodifiableList(this.authorizationInfo_);
                    this.bitField0_ &= -65;
                }
                auditLog.authorizationInfo_ = this.authorizationInfo_;
            } else {
                auditLog.authorizationInfo_ = repeatedFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV33 = this.requestMetadataBuilder_;
            if (singleFieldBuilderV33 == null) {
                auditLog.requestMetadata_ = this.requestMetadata_;
            } else {
                auditLog.requestMetadata_ = singleFieldBuilderV33.build();
            }
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV34 = this.requestBuilder_;
            if (singleFieldBuilderV34 == null) {
                auditLog.request_ = this.request_;
            } else {
                auditLog.request_ = singleFieldBuilderV34.build();
            }
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV35 = this.responseBuilder_;
            if (singleFieldBuilderV35 == null) {
                auditLog.response_ = this.response_;
            } else {
                auditLog.response_ = singleFieldBuilderV35.build();
            }
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV36 = this.serviceDataBuilder_;
            if (singleFieldBuilderV36 == null) {
                auditLog.serviceData_ = this.serviceData_;
            } else {
                auditLog.serviceData_ = singleFieldBuilderV36.build();
            }
            auditLog.bitField0_ = 0;
            onBuilt();
            return auditLog;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.serviceName_ = "";
            this.methodName_ = "";
            this.resourceName_ = "";
            this.numResponseItems_ = 0L;
            if (this.statusBuilder_ == null) {
                this.status_ = null;
            } else {
                this.status_ = null;
                this.statusBuilder_ = null;
            }
            if (this.authenticationInfoBuilder_ == null) {
                this.authenticationInfo_ = null;
            } else {
                this.authenticationInfo_ = null;
                this.authenticationInfoBuilder_ = null;
            }
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.authorizationInfo_ = Collections.emptyList();
                this.bitField0_ &= -65;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            if (this.requestMetadataBuilder_ == null) {
                this.requestMetadata_ = null;
            } else {
                this.requestMetadata_ = null;
                this.requestMetadataBuilder_ = null;
            }
            if (this.requestBuilder_ == null) {
                this.request_ = null;
            } else {
                this.request_ = null;
                this.requestBuilder_ = null;
            }
            if (this.responseBuilder_ == null) {
                this.response_ = null;
            } else {
                this.response_ = null;
                this.responseBuilder_ = null;
            }
            if (this.serviceDataBuilder_ == null) {
                this.serviceData_ = null;
                return this;
            }
            this.serviceData_ = null;
            this.serviceDataBuilder_ = null;
            return this;
        }

        public Builder clearAuthenticationInfo() {
            if (this.authenticationInfoBuilder_ == null) {
                this.authenticationInfo_ = null;
                onChanged();
                return this;
            }
            this.authenticationInfo_ = null;
            this.authenticationInfoBuilder_ = null;
            return this;
        }

        public Builder clearAuthorizationInfo() {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.authorizationInfo_ = Collections.emptyList();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearMethodName() {
            this.methodName_ = AuditLog.getDefaultInstance().getMethodName();
            onChanged();
            return this;
        }

        public Builder clearNumResponseItems() {
            this.numResponseItems_ = 0L;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRequest() {
            if (this.requestBuilder_ == null) {
                this.request_ = null;
                onChanged();
                return this;
            }
            this.request_ = null;
            this.requestBuilder_ = null;
            return this;
        }

        public Builder clearRequestMetadata() {
            if (this.requestMetadataBuilder_ == null) {
                this.requestMetadata_ = null;
                onChanged();
                return this;
            }
            this.requestMetadata_ = null;
            this.requestMetadataBuilder_ = null;
            return this;
        }

        public Builder clearResourceName() {
            this.resourceName_ = AuditLog.getDefaultInstance().getResourceName();
            onChanged();
            return this;
        }

        public Builder clearResponse() {
            if (this.responseBuilder_ == null) {
                this.response_ = null;
                onChanged();
                return this;
            }
            this.response_ = null;
            this.responseBuilder_ = null;
            return this;
        }

        public Builder clearServiceData() {
            if (this.serviceDataBuilder_ == null) {
                this.serviceData_ = null;
                onChanged();
                return this;
            }
            this.serviceData_ = null;
            this.serviceDataBuilder_ = null;
            return this;
        }

        public Builder clearServiceName() {
            this.serviceName_ = AuditLog.getDefaultInstance().getServiceName();
            onChanged();
            return this;
        }

        public Builder clearStatus() {
            if (this.statusBuilder_ == null) {
                this.status_ = null;
                onChanged();
                return this;
            }
            this.status_ = null;
            this.statusBuilder_ = null;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public AuthenticationInfo getAuthenticationInfo() {
            SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                AuthenticationInfo authenticationInfo = this.authenticationInfo_;
                AuthenticationInfo authenticationInfo2 = authenticationInfo;
                if (authenticationInfo == null) {
                    authenticationInfo2 = AuthenticationInfo.getDefaultInstance();
                }
                return authenticationInfo2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public AuthenticationInfo.Builder getAuthenticationInfoBuilder() {
            onChanged();
            return getAuthenticationInfoFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public AuthenticationInfoOrBuilder getAuthenticationInfoOrBuilder() {
            SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            AuthenticationInfo authenticationInfo = this.authenticationInfo_;
            AuthenticationInfo authenticationInfo2 = authenticationInfo;
            if (authenticationInfo == null) {
                authenticationInfo2 = AuthenticationInfo.getDefaultInstance();
            }
            return authenticationInfo2;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public AuthorizationInfo getAuthorizationInfo(int i) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.authorizationInfo_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public AuthorizationInfo.Builder getAuthorizationInfoBuilder(int i) {
            return getAuthorizationInfoFieldBuilder().getBuilder(i);
        }

        public List<AuthorizationInfo.Builder> getAuthorizationInfoBuilderList() {
            return getAuthorizationInfoFieldBuilder().getBuilderList();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public int getAuthorizationInfoCount() {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.authorizationInfo_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public List<AuthorizationInfo> getAuthorizationInfoList() {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.authorizationInfo_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public AuthorizationInfoOrBuilder getAuthorizationInfoOrBuilder(int i) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.authorizationInfo_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public List<? extends AuthorizationInfoOrBuilder> getAuthorizationInfoOrBuilderList() {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.authorizationInfo_);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AuditLog getDefaultInstanceForType() {
            return AuditLog.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return AuditLogProto.internal_static_google_cloud_audit_AuditLog_descriptor;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public String getMethodName() {
            Object obj = this.methodName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.methodName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ByteString getMethodNameBytes() {
            Object obj = this.methodName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.methodName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public long getNumResponseItems() {
            return this.numResponseItems_;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Struct getRequest() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct = this.request_;
                Struct struct2 = struct;
                if (struct == null) {
                    struct2 = Struct.getDefaultInstance();
                }
                return struct2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Struct.Builder getRequestBuilder() {
            onChanged();
            return getRequestFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public RequestMetadata getRequestMetadata() {
            SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                RequestMetadata requestMetadata = this.requestMetadata_;
                RequestMetadata requestMetadata2 = requestMetadata;
                if (requestMetadata == null) {
                    requestMetadata2 = RequestMetadata.getDefaultInstance();
                }
                return requestMetadata2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public RequestMetadata.Builder getRequestMetadataBuilder() {
            onChanged();
            return getRequestMetadataFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public RequestMetadataOrBuilder getRequestMetadataOrBuilder() {
            SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            RequestMetadata requestMetadata = this.requestMetadata_;
            RequestMetadata requestMetadata2 = requestMetadata;
            if (requestMetadata == null) {
                requestMetadata2 = RequestMetadata.getDefaultInstance();
            }
            return requestMetadata2;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public StructOrBuilder getRequestOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Struct struct = this.request_;
            Struct struct2 = struct;
            if (struct == null) {
                struct2 = Struct.getDefaultInstance();
            }
            return struct2;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public String getResourceName() {
            Object obj = this.resourceName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.resourceName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ByteString getResourceNameBytes() {
            Object obj = this.resourceName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.resourceName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Struct getResponse() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct = this.response_;
                Struct struct2 = struct;
                if (struct == null) {
                    struct2 = Struct.getDefaultInstance();
                }
                return struct2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Struct.Builder getResponseBuilder() {
            onChanged();
            return getResponseFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public StructOrBuilder getResponseOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Struct struct = this.response_;
            Struct struct2 = struct;
            if (struct == null) {
                struct2 = Struct.getDefaultInstance();
            }
            return struct2;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Any getServiceData() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Any any = this.serviceData_;
                Any any2 = any;
                if (any == null) {
                    any2 = Any.getDefaultInstance();
                }
                return any2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Any.Builder getServiceDataBuilder() {
            onChanged();
            return getServiceDataFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public AnyOrBuilder getServiceDataOrBuilder() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Any any = this.serviceData_;
            Any any2 = any;
            if (any == null) {
                any2 = Any.getDefaultInstance();
            }
            return any2;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public String getServiceName() {
            Object obj = this.serviceName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.serviceName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ByteString getServiceNameBytes() {
            Object obj = this.serviceName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serviceName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Status getStatus() {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
            if (singleFieldBuilderV3 == null) {
                Status status = this.status_;
                Status status2 = status;
                if (status == null) {
                    status2 = Status.getDefaultInstance();
                }
                return status2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Status.Builder getStatusBuilder() {
            onChanged();
            return getStatusFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public StatusOrBuilder getStatusOrBuilder() {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Status status = this.status_;
            Status status2 = status;
            if (status == null) {
                status2 = Status.getDefaultInstance();
            }
            return status2;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasAuthenticationInfo() {
            return (this.authenticationInfoBuilder_ == null && this.authenticationInfo_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasRequest() {
            return (this.requestBuilder_ == null && this.request_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasRequestMetadata() {
            return (this.requestMetadataBuilder_ == null && this.requestMetadata_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasResponse() {
            return (this.responseBuilder_ == null && this.response_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasServiceData() {
            return (this.serviceDataBuilder_ == null && this.serviceData_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasStatus() {
            return (this.statusBuilder_ == null && this.status_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuditLogProto.internal_static_google_cloud_audit_AuditLog_fieldAccessorTable.ensureFieldAccessorsInitialized(AuditLog.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeAuthenticationInfo(AuthenticationInfo authenticationInfo) {
            SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(authenticationInfo);
                return this;
            }
            AuthenticationInfo authenticationInfo2 = this.authenticationInfo_;
            if (authenticationInfo2 != null) {
                this.authenticationInfo_ = AuthenticationInfo.newBuilder(authenticationInfo2).mergeFrom(authenticationInfo).buildPartial();
            } else {
                this.authenticationInfo_ = authenticationInfo;
            }
            onChanged();
            return this;
        }

        public Builder mergeFrom(AuditLog auditLog) {
            if (auditLog == AuditLog.getDefaultInstance()) {
                return this;
            }
            if (!auditLog.getServiceName().isEmpty()) {
                this.serviceName_ = auditLog.serviceName_;
                onChanged();
            }
            if (!auditLog.getMethodName().isEmpty()) {
                this.methodName_ = auditLog.methodName_;
                onChanged();
            }
            if (!auditLog.getResourceName().isEmpty()) {
                this.resourceName_ = auditLog.resourceName_;
                onChanged();
            }
            if (auditLog.getNumResponseItems() != 0) {
                setNumResponseItems(auditLog.getNumResponseItems());
            }
            if (auditLog.hasStatus()) {
                mergeStatus(auditLog.getStatus());
            }
            if (auditLog.hasAuthenticationInfo()) {
                mergeAuthenticationInfo(auditLog.getAuthenticationInfo());
            }
            if (this.authorizationInfoBuilder_ == null) {
                if (!auditLog.authorizationInfo_.isEmpty()) {
                    if (this.authorizationInfo_.isEmpty()) {
                        this.authorizationInfo_ = auditLog.authorizationInfo_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureAuthorizationInfoIsMutable();
                        this.authorizationInfo_.addAll(auditLog.authorizationInfo_);
                    }
                    onChanged();
                }
            } else if (!auditLog.authorizationInfo_.isEmpty()) {
                if (this.authorizationInfoBuilder_.isEmpty()) {
                    this.authorizationInfoBuilder_.dispose();
                    RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = null;
                    this.authorizationInfoBuilder_ = null;
                    this.authorizationInfo_ = auditLog.authorizationInfo_;
                    this.bitField0_ &= -65;
                    if (AuditLog.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getAuthorizationInfoFieldBuilder();
                    }
                    this.authorizationInfoBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.authorizationInfoBuilder_.addAllMessages(auditLog.authorizationInfo_);
                }
            }
            if (auditLog.hasRequestMetadata()) {
                mergeRequestMetadata(auditLog.getRequestMetadata());
            }
            if (auditLog.hasRequest()) {
                mergeRequest(auditLog.getRequest());
            }
            if (auditLog.hasResponse()) {
                mergeResponse(auditLog.getResponse());
            }
            if (auditLog.hasServiceData()) {
                mergeServiceData(auditLog.getServiceData());
            }
            mergeUnknownFields(auditLog.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.cloud.audit.AuditLog.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.cloud.audit.AuditLog.access$1800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.cloud.audit.AuditLog r0 = (com.google.cloud.audit.AuditLog) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.cloud.audit.AuditLog$Builder r0 = r0.mergeFrom(r1)
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
                com.google.cloud.audit.AuditLog r0 = (com.google.cloud.audit.AuditLog) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.cloud.audit.AuditLog$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.cloud.audit.AuditLog.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.cloud.audit.AuditLog$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof AuditLog) {
                return mergeFrom((AuditLog) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeRequest(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(struct);
                return this;
            }
            Struct struct2 = this.request_;
            if (struct2 != null) {
                this.request_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
            } else {
                this.request_ = struct;
            }
            onChanged();
            return this;
        }

        public Builder mergeRequestMetadata(RequestMetadata requestMetadata) {
            SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(requestMetadata);
                return this;
            }
            RequestMetadata requestMetadata2 = this.requestMetadata_;
            if (requestMetadata2 != null) {
                this.requestMetadata_ = RequestMetadata.newBuilder(requestMetadata2).mergeFrom(requestMetadata).buildPartial();
            } else {
                this.requestMetadata_ = requestMetadata;
            }
            onChanged();
            return this;
        }

        public Builder mergeResponse(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(struct);
                return this;
            }
            Struct struct2 = this.response_;
            if (struct2 != null) {
                this.response_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
            } else {
                this.response_ = struct;
            }
            onChanged();
            return this;
        }

        public Builder mergeServiceData(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(any);
                return this;
            }
            Any any2 = this.serviceData_;
            if (any2 != null) {
                this.serviceData_ = Any.newBuilder(any2).mergeFrom(any).buildPartial();
            } else {
                this.serviceData_ = any;
            }
            onChanged();
            return this;
        }

        public Builder mergeStatus(Status status) {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(status);
                return this;
            }
            Status status2 = this.status_;
            if (status2 != null) {
                this.status_ = Status.newBuilder(status2).mergeFrom(status).buildPartial();
            } else {
                this.status_ = status;
            }
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeAuthorizationInfo(int i) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureAuthorizationInfoIsMutable();
            this.authorizationInfo_.remove(i);
            onChanged();
            return this;
        }

        public Builder setAuthenticationInfo(AuthenticationInfo.Builder builder) {
            SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.authenticationInfo_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setAuthenticationInfo(AuthenticationInfo authenticationInfo) {
            SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(authenticationInfo);
                return this;
            } else if (authenticationInfo != null) {
                this.authenticationInfo_ = authenticationInfo;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setAuthorizationInfo(int i, AuthorizationInfo.Builder builder) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureAuthorizationInfoIsMutable();
            this.authorizationInfo_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, authorizationInfo);
                return this;
            } else if (authorizationInfo != null) {
                ensureAuthorizationInfoIsMutable();
                this.authorizationInfo_.set(i, authorizationInfo);
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

        public Builder setMethodName(String str) {
            if (str != null) {
                this.methodName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setMethodNameBytes(ByteString byteString) {
            if (byteString != null) {
                AuditLog.checkByteStringIsUtf8(byteString);
                this.methodName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNumResponseItems(long j) {
            this.numResponseItems_ = j;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setRequest(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.request_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setRequest(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(struct);
                return this;
            } else if (struct != null) {
                this.request_ = struct;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setRequestMetadata(RequestMetadata.Builder builder) {
            SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.requestMetadata_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setRequestMetadata(RequestMetadata requestMetadata) {
            SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(requestMetadata);
                return this;
            } else if (requestMetadata != null) {
                this.requestMetadata_ = requestMetadata;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setResourceName(String str) {
            if (str != null) {
                this.resourceName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setResourceNameBytes(ByteString byteString) {
            if (byteString != null) {
                AuditLog.checkByteStringIsUtf8(byteString);
                this.resourceName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setResponse(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.response_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setResponse(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(struct);
                return this;
            } else if (struct != null) {
                this.response_ = struct;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setServiceData(Any.Builder builder) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.serviceData_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setServiceData(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(any);
                return this;
            } else if (any != null) {
                this.serviceData_ = any;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setServiceName(String str) {
            if (str != null) {
                this.serviceName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setServiceNameBytes(ByteString byteString) {
            if (byteString != null) {
                AuditLog.checkByteStringIsUtf8(byteString);
                this.serviceName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setStatus(Status.Builder builder) {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.status_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setStatus(Status status) {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(status);
                return this;
            } else if (status != null) {
                this.status_ = status;
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

    private AuditLog() {
        this.memoizedIsInitialized = (byte) -1;
        this.serviceName_ = "";
        this.methodName_ = "";
        this.resourceName_ = "";
        this.authorizationInfo_ = Collections.emptyList();
    }

    private AuditLog(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Struct.Builder builder;
        Status.Builder builder2;
        AuthenticationInfo.Builder builder3;
        RequestMetadata.Builder builder4;
        Any.Builder builder5;
        Struct.Builder builder6;
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
                        case 18:
                            if (this.status_ != null) {
                                boolean z4 = z2;
                                builder2 = this.status_.toBuilder();
                            } else {
                                builder2 = null;
                            }
                            Status status = (Status) codedInputStream.readMessage(Status.parser(), extensionRegistryLite);
                            boolean z5 = z2;
                            this.status_ = status;
                            if (builder2 != null) {
                                builder2.mergeFrom(status);
                                boolean z6 = z2;
                                this.status_ = builder2.buildPartial();
                            } else {
                                continue;
                            }
                        case 26:
                            if (this.authenticationInfo_ != null) {
                                boolean z7 = z2;
                                builder3 = this.authenticationInfo_.toBuilder();
                            } else {
                                builder3 = null;
                            }
                            AuthenticationInfo authenticationInfo = (AuthenticationInfo) codedInputStream.readMessage(AuthenticationInfo.parser(), extensionRegistryLite);
                            boolean z8 = z2;
                            this.authenticationInfo_ = authenticationInfo;
                            if (builder3 != null) {
                                builder3.mergeFrom(authenticationInfo);
                                boolean z9 = z2;
                                this.authenticationInfo_ = builder3.buildPartial();
                            } else {
                                continue;
                            }
                        case 34:
                            if (this.requestMetadata_ != null) {
                                boolean z10 = z2;
                                builder4 = this.requestMetadata_.toBuilder();
                            } else {
                                builder4 = null;
                            }
                            RequestMetadata requestMetadata = (RequestMetadata) codedInputStream.readMessage(RequestMetadata.parser(), extensionRegistryLite);
                            boolean z11 = z2;
                            this.requestMetadata_ = requestMetadata;
                            if (builder4 != null) {
                                builder4.mergeFrom(requestMetadata);
                                boolean z12 = z2;
                                this.requestMetadata_ = builder4.buildPartial();
                            } else {
                                continue;
                            }
                        case 58:
                            this.serviceName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 66:
                            this.methodName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 74:
                            boolean z13 = z2;
                            if (!(z2 & true)) {
                                this.authorizationInfo_ = new ArrayList();
                                z13 = z2 | true;
                            }
                            this.authorizationInfo_.add(codedInputStream.readMessage(AuthorizationInfo.parser(), extensionRegistryLite));
                            z2 = z13;
                            continue;
                        case 90:
                            this.resourceName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 96:
                            this.numResponseItems_ = codedInputStream.readInt64();
                            continue;
                        case 122:
                            if (this.serviceData_ != null) {
                                boolean z14 = z2;
                                builder5 = this.serviceData_.toBuilder();
                            } else {
                                builder5 = null;
                            }
                            Any any = (Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                            boolean z15 = z2;
                            this.serviceData_ = any;
                            if (builder5 != null) {
                                builder5.mergeFrom(any);
                                boolean z16 = z2;
                                this.serviceData_ = builder5.buildPartial();
                            } else {
                                continue;
                            }
                        case 130:
                            if (this.request_ != null) {
                                boolean z17 = z2;
                                builder6 = this.request_.toBuilder();
                            } else {
                                builder6 = null;
                            }
                            Struct struct = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                            boolean z18 = z2;
                            this.request_ = struct;
                            if (builder6 != null) {
                                builder6.mergeFrom(struct);
                                boolean z19 = z2;
                                this.request_ = builder6.buildPartial();
                            } else {
                                continue;
                            }
                        case 138:
                            if (this.response_ != null) {
                                boolean z20 = z2;
                                builder = this.response_.toBuilder();
                            } else {
                                builder = null;
                            }
                            Struct struct2 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                            boolean z21 = z2;
                            this.response_ = struct2;
                            if (builder != null) {
                                builder.mergeFrom(struct2);
                                boolean z22 = z2;
                                this.response_ = builder.buildPartial();
                            } else {
                                continue;
                            }
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
                    this.authorizationInfo_ = Collections.unmodifiableList(this.authorizationInfo_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.authorizationInfo_ = Collections.unmodifiableList(this.authorizationInfo_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private AuditLog(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static AuditLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return AuditLogProto.internal_static_google_cloud_audit_AuditLog_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuditLog auditLog) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(auditLog);
    }

    public static AuditLog parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuditLog) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AuditLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuditLog) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AuditLog parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static AuditLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static AuditLog parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuditLog) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static AuditLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuditLog) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static AuditLog parseFrom(InputStream inputStream) throws IOException {
        return (AuditLog) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static AuditLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuditLog) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AuditLog parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static AuditLog parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static AuditLog parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static AuditLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<AuditLog> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AuditLog) {
            AuditLog auditLog = (AuditLog) obj;
            if (getServiceName().equals(auditLog.getServiceName()) && getMethodName().equals(auditLog.getMethodName()) && getResourceName().equals(auditLog.getResourceName()) && getNumResponseItems() == auditLog.getNumResponseItems() && hasStatus() == auditLog.hasStatus()) {
                if ((!hasStatus() || getStatus().equals(auditLog.getStatus())) && hasAuthenticationInfo() == auditLog.hasAuthenticationInfo()) {
                    if ((!hasAuthenticationInfo() || getAuthenticationInfo().equals(auditLog.getAuthenticationInfo())) && getAuthorizationInfoList().equals(auditLog.getAuthorizationInfoList()) && hasRequestMetadata() == auditLog.hasRequestMetadata()) {
                        if ((!hasRequestMetadata() || getRequestMetadata().equals(auditLog.getRequestMetadata())) && hasRequest() == auditLog.hasRequest()) {
                            if ((!hasRequest() || getRequest().equals(auditLog.getRequest())) && hasResponse() == auditLog.hasResponse()) {
                                if ((!hasResponse() || getResponse().equals(auditLog.getResponse())) && hasServiceData() == auditLog.hasServiceData()) {
                                    return (!hasServiceData() || getServiceData().equals(auditLog.getServiceData())) && this.unknownFields.equals(auditLog.unknownFields);
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return super.equals(obj);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public AuthenticationInfo getAuthenticationInfo() {
        AuthenticationInfo authenticationInfo = this.authenticationInfo_;
        AuthenticationInfo authenticationInfo2 = authenticationInfo;
        if (authenticationInfo == null) {
            authenticationInfo2 = AuthenticationInfo.getDefaultInstance();
        }
        return authenticationInfo2;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public AuthenticationInfoOrBuilder getAuthenticationInfoOrBuilder() {
        return getAuthenticationInfo();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public AuthorizationInfo getAuthorizationInfo(int i) {
        return this.authorizationInfo_.get(i);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public int getAuthorizationInfoCount() {
        return this.authorizationInfo_.size();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public List<AuthorizationInfo> getAuthorizationInfoList() {
        return this.authorizationInfo_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public AuthorizationInfoOrBuilder getAuthorizationInfoOrBuilder(int i) {
        return this.authorizationInfo_.get(i);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public List<? extends AuthorizationInfoOrBuilder> getAuthorizationInfoOrBuilderList() {
        return this.authorizationInfo_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public AuditLog getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public String getMethodName() {
        Object obj = this.methodName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.methodName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ByteString getMethodNameBytes() {
        Object obj = this.methodName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.methodName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public long getNumResponseItems() {
        return this.numResponseItems_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AuditLog> getParserForType() {
        return PARSER;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Struct getRequest() {
        Struct struct = this.request_;
        Struct struct2 = struct;
        if (struct == null) {
            struct2 = Struct.getDefaultInstance();
        }
        return struct2;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public RequestMetadata getRequestMetadata() {
        RequestMetadata requestMetadata = this.requestMetadata_;
        RequestMetadata requestMetadata2 = requestMetadata;
        if (requestMetadata == null) {
            requestMetadata2 = RequestMetadata.getDefaultInstance();
        }
        return requestMetadata2;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public RequestMetadataOrBuilder getRequestMetadataOrBuilder() {
        return getRequestMetadata();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public StructOrBuilder getRequestOrBuilder() {
        return getRequest();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public String getResourceName() {
        Object obj = this.resourceName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.resourceName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ByteString getResourceNameBytes() {
        Object obj = this.resourceName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.resourceName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Struct getResponse() {
        Struct struct = this.response_;
        Struct struct2 = struct;
        if (struct == null) {
            struct2 = Struct.getDefaultInstance();
        }
        return struct2;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public StructOrBuilder getResponseOrBuilder() {
        return getResponse();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.status_ != null ? CodedOutputStream.computeMessageSize(2, getStatus()) + 0 : 0;
        int i2 = computeMessageSize;
        if (this.authenticationInfo_ != null) {
            i2 = computeMessageSize + CodedOutputStream.computeMessageSize(3, getAuthenticationInfo());
        }
        int i3 = i2;
        if (this.requestMetadata_ != null) {
            i3 = i2 + CodedOutputStream.computeMessageSize(4, getRequestMetadata());
        }
        int i4 = i3;
        if (!getServiceNameBytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(7, this.serviceName_);
        }
        int i5 = i4;
        int i6 = 0;
        if (!getMethodNameBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(8, this.methodName_);
            i6 = 0;
        }
        while (i6 < this.authorizationInfo_.size()) {
            i5 += CodedOutputStream.computeMessageSize(9, this.authorizationInfo_.get(i6));
            i6++;
        }
        int i7 = i5;
        if (!getResourceNameBytes().isEmpty()) {
            i7 = i5 + GeneratedMessageV3.computeStringSize(11, this.resourceName_);
        }
        long j = this.numResponseItems_;
        int i8 = i7;
        if (j != 0) {
            i8 = i7 + CodedOutputStream.computeInt64Size(12, j);
        }
        int i9 = i8;
        if (this.serviceData_ != null) {
            i9 = i8 + CodedOutputStream.computeMessageSize(15, getServiceData());
        }
        int i10 = i9;
        if (this.request_ != null) {
            i10 = i9 + CodedOutputStream.computeMessageSize(16, getRequest());
        }
        int i11 = i10;
        if (this.response_ != null) {
            i11 = i10 + CodedOutputStream.computeMessageSize(17, getResponse());
        }
        int serializedSize = i11 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Any getServiceData() {
        Any any = this.serviceData_;
        Any any2 = any;
        if (any == null) {
            any2 = Any.getDefaultInstance();
        }
        return any2;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public AnyOrBuilder getServiceDataOrBuilder() {
        return getServiceData();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public String getServiceName() {
        Object obj = this.serviceName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.serviceName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ByteString getServiceNameBytes() {
        Object obj = this.serviceName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.serviceName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Status getStatus() {
        Status status = this.status_;
        Status status2 = status;
        if (status == null) {
            status2 = Status.getDefaultInstance();
        }
        return status2;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public StatusOrBuilder getStatusOrBuilder() {
        return getStatus();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasAuthenticationInfo() {
        return this.authenticationInfo_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasRequest() {
        return this.request_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasRequestMetadata() {
        return this.requestMetadata_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasResponse() {
        return this.response_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasServiceData() {
        return this.serviceData_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasStatus() {
        return this.status_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 7) * 53) + getServiceName().hashCode()) * 37) + 8) * 53) + getMethodName().hashCode()) * 37) + 11) * 53) + getResourceName().hashCode()) * 37) + 12) * 53) + Internal.hashLong(getNumResponseItems());
        int i = hashCode;
        if (hasStatus()) {
            i = (((hashCode * 37) + 2) * 53) + getStatus().hashCode();
        }
        int i2 = i;
        if (hasAuthenticationInfo()) {
            i2 = (((i * 37) + 3) * 53) + getAuthenticationInfo().hashCode();
        }
        int i3 = i2;
        if (getAuthorizationInfoCount() > 0) {
            i3 = (((i2 * 37) + 9) * 53) + getAuthorizationInfoList().hashCode();
        }
        int i4 = i3;
        if (hasRequestMetadata()) {
            i4 = (((i3 * 37) + 4) * 53) + getRequestMetadata().hashCode();
        }
        int i5 = i4;
        if (hasRequest()) {
            i5 = (((i4 * 37) + 16) * 53) + getRequest().hashCode();
        }
        int i6 = i5;
        if (hasResponse()) {
            i6 = (((i5 * 37) + 17) * 53) + getResponse().hashCode();
        }
        int i7 = i6;
        if (hasServiceData()) {
            i7 = (((i6 * 37) + 15) * 53) + getServiceData().hashCode();
        }
        int hashCode2 = (i7 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return AuditLogProto.internal_static_google_cloud_audit_AuditLog_fieldAccessorTable.ensureFieldAccessorsInitialized(AuditLog.class, Builder.class);
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
        if (this.status_ != null) {
            codedOutputStream.writeMessage(2, getStatus());
        }
        if (this.authenticationInfo_ != null) {
            codedOutputStream.writeMessage(3, getAuthenticationInfo());
        }
        if (this.requestMetadata_ != null) {
            codedOutputStream.writeMessage(4, getRequestMetadata());
        }
        if (!getServiceNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.serviceName_);
        }
        if (!getMethodNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.methodName_);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.authorizationInfo_.size()) {
                break;
            }
            codedOutputStream.writeMessage(9, this.authorizationInfo_.get(i2));
            i = i2 + 1;
        }
        if (!getResourceNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 11, this.resourceName_);
        }
        long j = this.numResponseItems_;
        if (j != 0) {
            codedOutputStream.writeInt64(12, j);
        }
        if (this.serviceData_ != null) {
            codedOutputStream.writeMessage(15, getServiceData());
        }
        if (this.request_ != null) {
            codedOutputStream.writeMessage(16, getRequest());
        }
        if (this.response_ != null) {
            codedOutputStream.writeMessage(17, getResponse());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
