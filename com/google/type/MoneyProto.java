package com.google.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;

/* loaded from: source-7994992-dex2jar.jar:com/google/type/MoneyProto.class */
public final class MoneyProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_type_Money_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_type_Money_fieldAccessorTable;

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017google/type/money.proto\u0012\u000bgoogle.type\"<\n\u0005Money\u0012\u0015\n\rcurrency_code\u0018\u0001 \u0001(\t\u0012\r\n\u0005units\u0018\u0002 \u0001(\u0003\u0012\r\n\u0005nanos\u0018\u0003 \u0001(\u0005B`\n\u000fcom.google.typeB\nMoneyProtoP\u0001Z6google.golang.org/genproto/googleapis/type/money;moneyø\u0001\u0001¢\u0002\u0003GTPb\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: com.google.type.MoneyProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = MoneyProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_type_Money_descriptor = descriptor2;
        internal_static_google_type_Money_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"CurrencyCode", "Units", "Nanos"});
    }

    private MoneyProto() {
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
