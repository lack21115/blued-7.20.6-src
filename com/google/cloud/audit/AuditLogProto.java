package com.google.cloud.audit;

import com.google.api.AnnotationsProto;
import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.StructProto;
import com.google.rpc.StatusProto;

/* loaded from: source-8110460-dex2jar.jar:com/google/cloud/audit/AuditLogProto.class */
public final class AuditLogProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_cloud_audit_AuditLog_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_cloud_audit_AuditLog_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_cloud_audit_AuthenticationInfo_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_cloud_audit_AuthenticationInfo_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_cloud_audit_AuthorizationInfo_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_cloud_audit_AuthorizationInfo_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_cloud_audit_RequestMetadata_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_cloud_audit_RequestMetadata_fieldAccessorTable;

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"google/cloud/audit/audit_log.proto\u0012\u0012google.cloud.audit\u001a\u001cgoogle/api/annotations.proto\u001a\u0019google/protobuf/any.proto\u001a\u001cgoogle/protobuf/struct.proto\u001a\u0017google/rpc/status.proto\"Ô\u0003\n\bAuditLog\u0012\u0014\n\fservice_name\u0018\u0007 \u0001(\t\u0012\u0013\n\u000bmethod_name\u0018\b \u0001(\t\u0012\u0015\n\rresource_name\u0018\u000b \u0001(\t\u0012\u001a\n\u0012num_response_items\u0018\f \u0001(\u0003\u0012\"\n\u0006status\u0018\u0002 \u0001(\u000b2\u0012.google.rpc.Status\u0012C\n\u0013authentication_info\u0018\u0003 \u0001(\u000b2&.google.cloud.audit.AuthenticationInfo\u0012A\n\u0012authorization_info\u0018\t \u0003(\u000b2%.google.cloud.audit.AuthorizationInfo\u0012=\n\u0010request_metadata\u0018\u0004 \u0001(\u000b2#.google.cloud.audit.RequestMetadata\u0012(\n\u0007request\u0018\u0010 \u0001(\u000b2\u0017.google.protobuf.Struct\u0012)\n\bresponse\u0018\u0011 \u0001(\u000b2\u0017.google.protobuf.Struct\u0012*\n\fservice_data\u0018\u000f \u0001(\u000b2\u0014.google.protobuf.Any\"-\n\u0012AuthenticationInfo\u0012\u0017\n\u000fprincipal_email\u0018\u0001 \u0001(\t\"J\n\u0011AuthorizationInfo\u0012\u0010\n\bresource\u0018\u0001 \u0001(\t\u0012\u0012\n\npermission\u0018\u0002 \u0001(\t\u0012\u000f\n\u0007granted\u0018\u0003 \u0001(\b\"H\n\u000fRequestMetadata\u0012\u0011\n\tcaller_ip\u0018\u0001 \u0001(\t\u0012\"\n\u001acaller_supplied_user_agent\u0018\u0002 \u0001(\tBb\n\u0016com.google.cloud.auditB\rAuditLogProtoP\u0001Z7google.golang.org/genproto/googleapis/cloud/audit;auditb\u0006proto3"}, new Descriptors.FileDescriptor[]{AnnotationsProto.getDescriptor(), AnyProto.getDescriptor(), StructProto.getDescriptor(), StatusProto.getDescriptor()}, new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: com.google.cloud.audit.AuditLogProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = AuditLogProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_cloud_audit_AuditLog_descriptor = descriptor2;
        internal_static_google_cloud_audit_AuditLog_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"ServiceName", "MethodName", "ResourceName", "NumResponseItems", "Status", "AuthenticationInfo", "AuthorizationInfo", "RequestMetadata", "Request", "Response", "ServiceData"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_google_cloud_audit_AuthenticationInfo_descriptor = descriptor3;
        internal_static_google_cloud_audit_AuthenticationInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"PrincipalEmail"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_google_cloud_audit_AuthorizationInfo_descriptor = descriptor4;
        internal_static_google_cloud_audit_AuthorizationInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Resource", "Permission", "Granted"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(3);
        internal_static_google_cloud_audit_RequestMetadata_descriptor = descriptor5;
        internal_static_google_cloud_audit_RequestMetadata_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"CallerIp", "CallerSuppliedUserAgent"});
        AnnotationsProto.getDescriptor();
        AnyProto.getDescriptor();
        StructProto.getDescriptor();
        StatusProto.getDescriptor();
    }

    private AuditLogProto() {
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
