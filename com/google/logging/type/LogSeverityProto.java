package com.google.logging.type;

import com.google.api.AnnotationsProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;

/* loaded from: source-8110460-dex2jar.jar:com/google/logging/type/LogSeverityProto.class */
public final class LogSeverityProto {
    private static Descriptors.FileDescriptor descriptor;

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n&google/logging/type/log_severity.proto\u0012\u0013google.logging.type\u001a\u001cgoogle/api/annotations.proto*\u0082\u0001\n\u000bLogSeverity\u0012\u000b\n\u0007DEFAULT\u0010��\u0012\t\n\u0005DEBUG\u0010d\u0012\t\n\u0004INFO\u0010È\u0001\u0012\u000b\n\u0006NOTICE\u0010¬\u0002\u0012\f\n\u0007WARNING\u0010\u0090\u0003\u0012\n\n\u0005ERROR\u0010ô\u0003\u0012\r\n\bCRITICAL\u0010Ø\u0004\u0012\n\n\u0005ALERT\u0010¼\u0005\u0012\u000e\n\tEMERGENCY\u0010 \u0006B\u009f\u0001\n\u0017com.google.logging.typeB\u0010LogSeverityProtoP\u0001Z8google.golang.org/genproto/googleapis/logging/type;ltypeª\u0002\u0019Google.Cloud.Logging.TypeÊ\u0002\u0019Google\\Cloud\\Logging\\Typeb\u0006proto3"}, new Descriptors.FileDescriptor[]{AnnotationsProto.getDescriptor()}, new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: com.google.logging.type.LogSeverityProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = LogSeverityProto.descriptor = fileDescriptor;
                return null;
            }
        });
        AnnotationsProto.getDescriptor();
    }

    private LogSeverityProto() {
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
