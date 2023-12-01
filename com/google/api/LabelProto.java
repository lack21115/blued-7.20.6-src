package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/LabelProto.class */
public final class LabelProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_api_LabelDescriptor_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_LabelDescriptor_fieldAccessorTable;

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016google/api/label.proto\u0012\ngoogle.api\"\u009c\u0001\n\u000fLabelDescriptor\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u00129\n\nvalue_type\u0018\u0002 \u0001(\u000e2%.google.api.LabelDescriptor.ValueType\u0012\u0013\n\u000bdescription\u0018\u0003 \u0001(\t\",\n\tValueType\u0012\n\n\u0006STRING\u0010��\u0012\b\n\u0004BOOL\u0010\u0001\u0012\t\n\u0005INT64\u0010\u0002B_\n\u000ecom.google.apiB\nLabelProtoP\u0001Z5google.golang.org/genproto/googleapis/api/label;labelø\u0001\u0001¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: com.google.api.LabelProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = LabelProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_api_LabelDescriptor_descriptor = descriptor2;
        internal_static_google_api_LabelDescriptor_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Key", "ValueType", "Description"});
    }

    private LabelProto() {
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
