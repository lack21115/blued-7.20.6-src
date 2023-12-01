package com.google.api;

import com.google.protobuf.AnyProto;
import com.google.protobuf.ApiProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.TypeProto;
import com.google.protobuf.WrappersProto;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/ServiceProto.class */
public final class ServiceProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_api_Service_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_Service_fieldAccessorTable;

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018google/api/service.proto\u0012\ngoogle.api\u001a\u0015google/api/auth.proto\u001a\u0018google/api/backend.proto\u001a\u0018google/api/billing.proto\u001a\u0018google/api/context.proto\u001a\u0018google/api/control.proto\u001a\u001egoogle/api/documentation.proto\u001a\u0019google/api/endpoint.proto\u001a\u0015google/api/http.proto\u001a\u0016google/api/label.proto\u001a\u0014google/api/log.proto\u001a\u0018google/api/logging.proto\u001a\u0017google/api/metric.proto\u001a#google/api/monitored_resource.proto\u001a\u001bgoogle/api/monitoring.proto\u001a\u0016google/api/quota.proto\u001a\u0019google/api/resource.proto\u001a\u001cgoogle/api/source_info.proto\u001a!google/api/system_parameter.proto\u001a\u0016google/api/usage.proto\u001a\u0019google/protobuf/any.proto\u001a\u0019google/protobuf/api.proto\u001a\u001agoogle/protobuf/type.proto\u001a\u001egoogle/protobuf/wrappers.proto\"Ö\u0007\n\u0007Service\u00124\n\u000econfig_version\u0018\u0014 \u0001(\u000b2\u001c.google.protobuf.UInt32Value\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\n\n\u0002id\u0018! \u0001(\t\u0012\r\n\u0005title\u0018\u0002 \u0001(\t\u0012\u001b\n\u0013producer_project_id\u0018\u0016 \u0001(\t\u0012\"\n\u0004apis\u0018\u0003 \u0003(\u000b2\u0014.google.protobuf.Api\u0012$\n\u0005types\u0018\u0004 \u0003(\u000b2\u0015.google.protobuf.Type\u0012$\n\u0005enums\u0018\u0005 \u0003(\u000b2\u0015.google.protobuf.Enum\u00120\n\rdocumentation\u0018\u0006 \u0001(\u000b2\u0019.google.api.Documentation\u0012$\n\u0007backend\u0018\b \u0001(\u000b2\u0013.google.api.Backend\u0012\u001e\n\u0004http\u0018\t \u0001(\u000b2\u0010.google.api.Http\u0012 \n\u0005quota\u0018\n \u0001(\u000b2\u0011.google.api.Quota\u00122\n\u000eauthentication\u0018\u000b \u0001(\u000b2\u001a.google.api.Authentication\u0012$\n\u0007context\u0018\f \u0001(\u000b2\u0013.google.api.Context\u0012 \n\u0005usage\u0018\u000f \u0001(\u000b2\u0011.google.api.Usage\u0012'\n\tendpoints\u0018\u0012 \u0003(\u000b2\u0014.google.api.Endpoint\u0012$\n\u0007control\u0018\u0015 \u0001(\u000b2\u0013.google.api.Control\u0012'\n\u0004logs\u0018\u0017 \u0003(\u000b2\u0019.google.api.LogDescriptor\u0012-\n\u0007metrics\u0018\u0018 \u0003(\u000b2\u001c.google.api.MetricDescriptor\u0012D\n\u0013monitored_resources\u0018\u0019 \u0003(\u000b2'.google.api.MonitoredResourceDescriptor\u0012$\n\u0007billing\u0018\u001a \u0001(\u000b2\u0013.google.api.Billing\u0012$\n\u0007logging\u0018\u001b \u0001(\u000b2\u0013.google.api.Logging\u0012*\n\nmonitoring\u0018\u001c \u0001(\u000b2\u0016.google.api.Monitoring\u00127\n\u0011system_parameters\u0018\u001d \u0001(\u000b2\u001c.google.api.SystemParameters\u0012+\n\u000bsource_info\u0018% \u0001(\u000b2\u0016.google.api.SourceInfoBn\n\u000ecom.google.apiB\fServiceProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[]{AuthProto.getDescriptor(), BackendProto.getDescriptor(), BillingProto.getDescriptor(), ContextProto.getDescriptor(), ControlProto.getDescriptor(), DocumentationProto.getDescriptor(), EndpointProto.getDescriptor(), HttpProto.getDescriptor(), LabelProto.getDescriptor(), LogProto.getDescriptor(), LoggingProto.getDescriptor(), MetricProto.getDescriptor(), MonitoredResourceProto.getDescriptor(), MonitoringProto.getDescriptor(), QuotaProto.getDescriptor(), ResourceProto.getDescriptor(), SourceInfoProto.getDescriptor(), SystemParameterProto.getDescriptor(), UsageProto.getDescriptor(), AnyProto.getDescriptor(), ApiProto.getDescriptor(), TypeProto.getDescriptor(), WrappersProto.getDescriptor()}, new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: com.google.api.ServiceProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = ServiceProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_api_Service_descriptor = descriptor2;
        internal_static_google_api_Service_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"ConfigVersion", "Name", "Id", "Title", "ProducerProjectId", "Apis", "Types", "Enums", "Documentation", "Backend", "Http", "Quota", "Authentication", "Context", "Usage", "Endpoints", "Control", "Logs", "Metrics", "MonitoredResources", "Billing", "Logging", "Monitoring", "SystemParameters", "SourceInfo"});
        AuthProto.getDescriptor();
        BackendProto.getDescriptor();
        BillingProto.getDescriptor();
        ContextProto.getDescriptor();
        ControlProto.getDescriptor();
        DocumentationProto.getDescriptor();
        EndpointProto.getDescriptor();
        HttpProto.getDescriptor();
        LabelProto.getDescriptor();
        LogProto.getDescriptor();
        LoggingProto.getDescriptor();
        MetricProto.getDescriptor();
        MonitoredResourceProto.getDescriptor();
        MonitoringProto.getDescriptor();
        QuotaProto.getDescriptor();
        ResourceProto.getDescriptor();
        SourceInfoProto.getDescriptor();
        SystemParameterProto.getDescriptor();
        UsageProto.getDescriptor();
        AnyProto.getDescriptor();
        ApiProto.getDescriptor();
        TypeProto.getDescriptor();
        WrappersProto.getDescriptor();
    }

    private ServiceProto() {
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
