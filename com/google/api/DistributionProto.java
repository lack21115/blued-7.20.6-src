package com.google.api;

import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.TimestampProto;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/DistributionProto.class */
public final class DistributionProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_api_Distribution_BucketOptions_Explicit_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_Distribution_BucketOptions_Explicit_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_api_Distribution_BucketOptions_Exponential_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_Distribution_BucketOptions_Exponential_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_api_Distribution_BucketOptions_Linear_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_Distribution_BucketOptions_Linear_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_api_Distribution_BucketOptions_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_Distribution_BucketOptions_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_api_Distribution_Exemplar_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_Distribution_Exemplar_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_api_Distribution_Range_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_Distribution_Range_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_api_Distribution_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_api_Distribution_fieldAccessorTable;

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dgoogle/api/distribution.proto\u0012\ngoogle.api\u001a\u0019google/protobuf/any.proto\u001a\u001fgoogle/protobuf/timestamp.proto\"Ù\u0006\n\fDistribution\u0012\r\n\u0005count\u0018\u0001 \u0001(\u0003\u0012\f\n\u0004mean\u0018\u0002 \u0001(\u0001\u0012 \n\u0018sum_of_squared_deviation\u0018\u0003 \u0001(\u0001\u0012-\n\u0005range\u0018\u0004 \u0001(\u000b2\u001e.google.api.Distribution.Range\u0012>\n\u000ebucket_options\u0018\u0006 \u0001(\u000b2&.google.api.Distribution.BucketOptions\u0012\u0015\n\rbucket_counts\u0018\u0007 \u0003(\u0003\u00124\n\texemplars\u0018\n \u0003(\u000b2!.google.api.Distribution.Exemplar\u001a!\n\u0005Range\u0012\u000b\n\u0003min\u0018\u0001 \u0001(\u0001\u0012\u000b\n\u0003max\u0018\u0002 \u0001(\u0001\u001aµ\u0003\n\rBucketOptions\u0012G\n\u000elinear_buckets\u0018\u0001 \u0001(\u000b2-.google.api.Distribution.BucketOptions.LinearH��\u0012Q\n\u0013exponential_buckets\u0018\u0002 \u0001(\u000b22.google.api.Distribution.BucketOptions.ExponentialH��\u0012K\n\u0010explicit_buckets\u0018\u0003 \u0001(\u000b2/.google.api.Distribution.BucketOptions.ExplicitH��\u001aC\n\u0006Linear\u0012\u001a\n\u0012num_finite_buckets\u0018\u0001 \u0001(\u0005\u0012\r\n\u0005width\u0018\u0002 \u0001(\u0001\u0012\u000e\n\u0006offset\u0018\u0003 \u0001(\u0001\u001aO\n\u000bExponential\u0012\u001a\n\u0012num_finite_buckets\u0018\u0001 \u0001(\u0005\u0012\u0015\n\rgrowth_factor\u0018\u0002 \u0001(\u0001\u0012\r\n\u0005scale\u0018\u0003 \u0001(\u0001\u001a\u001a\n\bExplicit\u0012\u000e\n\u0006bounds\u0018\u0001 \u0003(\u0001B\t\n\u0007options\u001as\n\bExemplar\u0012\r\n\u0005value\u0018\u0001 \u0001(\u0001\u0012-\n\ttimestamp\u0018\u0002 \u0001(\u000b2\u001a.google.protobuf.Timestamp\u0012)\n\u000battachments\u0018\u0003 \u0003(\u000b2\u0014.google.protobuf.AnyBq\n\u000ecom.google.apiB\u0011DistributionProtoP\u0001ZCgoogle.golang.org/genproto/googleapis/api/distribution;distribution¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[]{AnyProto.getDescriptor(), TimestampProto.getDescriptor()}, new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: com.google.api.DistributionProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = DistributionProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_api_Distribution_descriptor = descriptor2;
        internal_static_google_api_Distribution_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Count", "Mean", "SumOfSquaredDeviation", "Range", "BucketOptions", "BucketCounts", "Exemplars"});
        Descriptors.Descriptor descriptor3 = internal_static_google_api_Distribution_descriptor.getNestedTypes().get(0);
        internal_static_google_api_Distribution_Range_descriptor = descriptor3;
        internal_static_google_api_Distribution_Range_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Min", "Max"});
        Descriptors.Descriptor descriptor4 = internal_static_google_api_Distribution_descriptor.getNestedTypes().get(1);
        internal_static_google_api_Distribution_BucketOptions_descriptor = descriptor4;
        internal_static_google_api_Distribution_BucketOptions_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"LinearBuckets", "ExponentialBuckets", "ExplicitBuckets", "Options"});
        Descriptors.Descriptor descriptor5 = internal_static_google_api_Distribution_BucketOptions_descriptor.getNestedTypes().get(0);
        internal_static_google_api_Distribution_BucketOptions_Linear_descriptor = descriptor5;
        internal_static_google_api_Distribution_BucketOptions_Linear_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"NumFiniteBuckets", "Width", "Offset"});
        Descriptors.Descriptor descriptor6 = internal_static_google_api_Distribution_BucketOptions_descriptor.getNestedTypes().get(1);
        internal_static_google_api_Distribution_BucketOptions_Exponential_descriptor = descriptor6;
        internal_static_google_api_Distribution_BucketOptions_Exponential_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{"NumFiniteBuckets", "GrowthFactor", "Scale"});
        Descriptors.Descriptor descriptor7 = internal_static_google_api_Distribution_BucketOptions_descriptor.getNestedTypes().get(2);
        internal_static_google_api_Distribution_BucketOptions_Explicit_descriptor = descriptor7;
        internal_static_google_api_Distribution_BucketOptions_Explicit_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor7, new String[]{"Bounds"});
        Descriptors.Descriptor descriptor8 = internal_static_google_api_Distribution_descriptor.getNestedTypes().get(2);
        internal_static_google_api_Distribution_Exemplar_descriptor = descriptor8;
        internal_static_google_api_Distribution_Exemplar_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor8, new String[]{"Value", "Timestamp", "Attachments"});
        AnyProto.getDescriptor();
        TimestampProto.getDescriptor();
    }

    private DistributionProto() {
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
