package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.StructProto;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/MonitoredResourceProto.class */
public final class MonitoredResourceProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_api_MonitoredResourceDescriptor_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_MonitoredResourceDescriptor_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_api_MonitoredResourceMetadata_UserLabelsEntry_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_MonitoredResourceMetadata_UserLabelsEntry_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_api_MonitoredResourceMetadata_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_MonitoredResourceMetadata_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_api_MonitoredResource_LabelsEntry_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_MonitoredResource_LabelsEntry_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_api_MonitoredResource_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_MonitoredResource_fieldAccessorTable;

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#google/api/monitored_resource.proto\u0012\ngoogle.api\u001a\u0016google/api/label.proto\u001a\u001dgoogle/api/launch_stage.proto\u001a\u001cgoogle/protobuf/struct.proto\"À\u0001\n\u001bMonitoredResourceDescriptor\u0012\f\n\u0004name\u0018\u0005 \u0001(\t\u0012\f\n\u0004type\u0018\u0001 \u0001(\t\u0012\u0014\n\fdisplay_name\u0018\u0002 \u0001(\t\u0012\u0013\n\u000bdescription\u0018\u0003 \u0001(\t\u0012+\n\u0006labels\u0018\u0004 \u0003(\u000b2\u001b.google.api.LabelDescriptor\u0012-\n\flaunch_stage\u0018\u0007 \u0001(\u000e2\u0017.google.api.LaunchStage\"\u008b\u0001\n\u0011MonitoredResource\u0012\f\n\u0004type\u0018\u0001 \u0001(\t\u00129\n\u0006labels\u0018\u0002 \u0003(\u000b2).google.api.MonitoredResource.LabelsEntry\u001a-\n\u000bLabelsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\"Ê\u0001\n\u0019MonitoredResourceMetadata\u0012.\n\rsystem_labels\u0018\u0001 \u0001(\u000b2\u0017.google.protobuf.Struct\u0012J\n\u000buser_labels\u0018\u0002 \u0003(\u000b25.google.api.MonitoredResourceMetadata.UserLabelsEntry\u001a1\n\u000fUserLabelsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001By\n\u000ecom.google.apiB\u0016MonitoredResourceProtoP\u0001ZCgoogle.golang.org/genproto/googleapis/api/monitoredres;monitoredresø\u0001\u0001¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[]{LabelProto.getDescriptor(), LaunchStageProto.getDescriptor(), StructProto.getDescriptor()}, new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: com.google.api.MonitoredResourceProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = MonitoredResourceProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_api_MonitoredResourceDescriptor_descriptor = descriptor2;
        internal_static_google_api_MonitoredResourceDescriptor_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Name", "Type", "DisplayName", "Description", "Labels", "LaunchStage"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_google_api_MonitoredResource_descriptor = descriptor3;
        internal_static_google_api_MonitoredResource_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Type", "Labels"});
        Descriptors.Descriptor descriptor4 = internal_static_google_api_MonitoredResource_descriptor.getNestedTypes().get(0);
        internal_static_google_api_MonitoredResource_LabelsEntry_descriptor = descriptor4;
        internal_static_google_api_MonitoredResource_LabelsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(2);
        internal_static_google_api_MonitoredResourceMetadata_descriptor = descriptor5;
        internal_static_google_api_MonitoredResourceMetadata_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"SystemLabels", "UserLabels"});
        Descriptors.Descriptor descriptor6 = internal_static_google_api_MonitoredResourceMetadata_descriptor.getNestedTypes().get(0);
        internal_static_google_api_MonitoredResourceMetadata_UserLabelsEntry_descriptor = descriptor6;
        internal_static_google_api_MonitoredResourceMetadata_UserLabelsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{"Key", "Value"});
        LabelProto.getDescriptor();
        LaunchStageProto.getDescriptor();
        StructProto.getDescriptor();
    }

    private MonitoredResourceProto() {
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
