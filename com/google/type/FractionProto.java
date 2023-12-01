package com.google.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;

/* loaded from: source-7994992-dex2jar.jar:com/google/type/FractionProto.class */
public final class FractionProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_type_Fraction_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_type_Fraction_fieldAccessorTable;

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001agoogle/type/fraction.proto\u0012\u000bgoogle.type\"2\n\bFraction\u0012\u0011\n\tnumerator\u0018\u0001 \u0001(\u0003\u0012\u0013\n\u000bdenominator\u0018\u0002 \u0001(\u0003Bf\n\u000fcom.google.typeB\rFractionProtoP\u0001Z<google.golang.org/genproto/googleapis/type/fraction;fraction¢\u0002\u0003GTPb\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: com.google.type.FractionProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = FractionProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_type_Fraction_descriptor = descriptor2;
        internal_static_google_type_Fraction_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Numerator", "Denominator"});
    }

    private FractionProto() {
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
