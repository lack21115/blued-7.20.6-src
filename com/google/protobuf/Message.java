package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/Message.class */
public interface Message extends MessageLite, MessageOrBuilder {

    /* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/Message$Builder.class */
    public interface Builder extends MessageLite.Builder, MessageOrBuilder {
        Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        @Override // 
        Message build();

        @Override // 
        Message buildPartial();

        @Override // 
        Builder clear();

        Builder clearField(Descriptors.FieldDescriptor fieldDescriptor);

        Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor);

        @Override // 
        Builder clone();

        Descriptors.Descriptor getDescriptorForType();

        Builder getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor);

        Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i);

        @Override // 
        boolean mergeDelimitedFrom(InputStream inputStream) throws IOException;

        @Override // 
        boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        @Override // 
        Builder mergeFrom(ByteString byteString) throws InvalidProtocolBufferException;

        @Override // 
        Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        @Override // 
        Builder mergeFrom(CodedInputStream codedInputStream) throws IOException;

        @Override // 
        Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        Builder mergeFrom(Message message);

        @Override // 
        Builder mergeFrom(InputStream inputStream) throws IOException;

        @Override // 
        Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        @Override // 
        Builder mergeFrom(byte[] bArr) throws InvalidProtocolBufferException;

        @Override // 
        Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

        @Override // 
        Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        @Override // 
        Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet);

        Builder newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor);

        Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj);

        Builder setUnknownFields(UnknownFieldSet unknownFieldSet);
    }

    boolean equals(Object obj);

    @Override // 
    Parser<? extends Message> getParserForType();

    int hashCode();

    @Override // 
    Builder newBuilderForType();

    @Override // 
    Builder toBuilder();

    String toString();
}
