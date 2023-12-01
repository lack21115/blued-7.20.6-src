package com.blued.das.client.abtest;

import com.blued.das.CommonProtos;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientProtos.class */
public final class AbClientProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014AbClientProtos.proto\u0012\u001bcom.blued.das.client.abtest\u001a\u0012CommonProtos.proto\"T\n\u0007Request\u0012\u0013\n\u000bdecision_id\u0018\u0001 \u0001(\t\u0012\r\n\u0005token\u0018\u0002 \u0001(\t\u0012%\n\u0006common\u0018\u0003 \u0001(\u000b2\u0015.com.blued.das.Common\"~\n\bAbResult\u0012\u000b\n\u0003gid\u0018\u0001 \u0001(\u0003\u0012\u0012\n\nparam_type\u0018\u0002 \u0001(\u0005\u0012\u0013\n\u000bparam_value\u0018\u0003 \u0001(\t\u0012\u0010\n\bis_track\u0018\u0004 \u0001(\b\u0012\u0017\n\u000fis_group_freeze\u0018\u0005 \u0001(\b\u0012\u0011\n\tis_freeze\u0018\u0006 \u0001(\b\"Å\u0001\n\bResponse\u0012C\n\u0007results\u0018\u0001 \u0003(\u000b22.com.blued.das.client.abtest.Response.ResultsEntry\u0012\f\n\u0004code\u0018\u0002 \u0001(\u0005\u0012\u000f\n\u0007message\u0018\u0003 \u0001(\t\u001aU\n\fResultsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u00124\n\u0005value\u0018\u0002 \u0001(\u000b2%.com.blued.das.client.abtest.AbResult:\u00028\u00012o\n\u000fAbClientService\u0012\\\n\u000bgetAbResult\u0012$.com.blued.das.client.abtest.Request\u001a%.com.blued.das.client.abtest.Response\"��B\f¢\u0002\tAB_RESULTb\u0006proto3"}, new Descriptors.FileDescriptor[]{CommonProtos.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_blued_das_client_abtest_AbResult_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_abtest_AbResult_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_client_abtest_Request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_abtest_Request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_client_abtest_Response_ResultsEntry_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_abtest_Response_ResultsEntry_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_client_abtest_Response_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_abtest_Response_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientProtos$AbResult.class */
    public static final class AbResult extends GeneratedMessageV3 implements AbResultOrBuilder {
        public static final int GID_FIELD_NUMBER = 1;
        public static final int IS_FREEZE_FIELD_NUMBER = 6;
        public static final int IS_GROUP_FREEZE_FIELD_NUMBER = 5;
        public static final int IS_TRACK_FIELD_NUMBER = 4;
        public static final int PARAM_TYPE_FIELD_NUMBER = 2;
        public static final int PARAM_VALUE_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private long gid_;
        private boolean isFreeze_;
        private boolean isGroupFreeze_;
        private boolean isTrack_;
        private byte memoizedIsInitialized;
        private int paramType_;
        private volatile Object paramValue_;
        private static final AbResult DEFAULT_INSTANCE = new AbResult();
        private static final Parser<AbResult> PARSER = new AbstractParser<AbResult>() { // from class: com.blued.das.client.abtest.AbClientProtos.AbResult.1
            @Override // com.google.protobuf.Parser
            public AbResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AbResult(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientProtos$AbResult$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbResultOrBuilder {
            private long gid_;
            private boolean isFreeze_;
            private boolean isGroupFreeze_;
            private boolean isTrack_;
            private int paramType_;
            private Object paramValue_;

            private Builder() {
                this.paramValue_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.paramValue_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AbClientProtos.internal_static_com_blued_das_client_abtest_AbResult_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = AbResult.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbResult build() {
                AbResult buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbResult buildPartial() {
                AbResult abResult = new AbResult(this);
                abResult.gid_ = this.gid_;
                abResult.paramType_ = this.paramType_;
                abResult.paramValue_ = this.paramValue_;
                abResult.isTrack_ = this.isTrack_;
                abResult.isGroupFreeze_ = this.isGroupFreeze_;
                abResult.isFreeze_ = this.isFreeze_;
                onBuilt();
                return abResult;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.gid_ = 0L;
                this.paramType_ = 0;
                this.paramValue_ = "";
                this.isTrack_ = false;
                this.isGroupFreeze_ = false;
                this.isFreeze_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearGid() {
                this.gid_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearIsFreeze() {
                this.isFreeze_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsGroupFreeze() {
                this.isGroupFreeze_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsTrack() {
                this.isTrack_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearParamType() {
                this.paramType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearParamValue() {
                this.paramValue_ = AbResult.getDefaultInstance().getParamValue();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbResult getDefaultInstanceForType() {
                return AbResult.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbClientProtos.internal_static_com_blued_das_client_abtest_AbResult_descriptor;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
            public long getGid() {
                return this.gid_;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
            public boolean getIsFreeze() {
                return this.isFreeze_;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
            public boolean getIsGroupFreeze() {
                return this.isGroupFreeze_;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
            public boolean getIsTrack() {
                return this.isTrack_;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
            public int getParamType() {
                return this.paramType_;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
            public String getParamValue() {
                Object obj = this.paramValue_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.paramValue_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
            public ByteString getParamValueBytes() {
                Object obj = this.paramValue_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.paramValue_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbClientProtos.internal_static_com_blued_das_client_abtest_AbResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AbResult.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(AbResult abResult) {
                if (abResult == AbResult.getDefaultInstance()) {
                    return this;
                }
                if (abResult.getGid() != 0) {
                    setGid(abResult.getGid());
                }
                if (abResult.getParamType() != 0) {
                    setParamType(abResult.getParamType());
                }
                if (!abResult.getParamValue().isEmpty()) {
                    this.paramValue_ = abResult.paramValue_;
                    onChanged();
                }
                if (abResult.getIsTrack()) {
                    setIsTrack(abResult.getIsTrack());
                }
                if (abResult.getIsGroupFreeze()) {
                    setIsGroupFreeze(abResult.getIsGroupFreeze());
                }
                if (abResult.getIsFreeze()) {
                    setIsFreeze(abResult.getIsFreeze());
                }
                mergeUnknownFields(abResult.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.client.abtest.AbClientProtos.AbResult.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.client.abtest.AbClientProtos.AbResult.access$2700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.client.abtest.AbClientProtos$AbResult r0 = (com.blued.das.client.abtest.AbClientProtos.AbResult) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.client.abtest.AbClientProtos$AbResult$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.client.abtest.AbClientProtos$AbResult r0 = (com.blued.das.client.abtest.AbClientProtos.AbResult) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.client.abtest.AbClientProtos$AbResult$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.client.abtest.AbClientProtos.AbResult.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.client.abtest.AbClientProtos$AbResult$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof AbResult) {
                    return mergeFrom((AbResult) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setGid(long j) {
                this.gid_ = j;
                onChanged();
                return this;
            }

            public Builder setIsFreeze(boolean z) {
                this.isFreeze_ = z;
                onChanged();
                return this;
            }

            public Builder setIsGroupFreeze(boolean z) {
                this.isGroupFreeze_ = z;
                onChanged();
                return this;
            }

            public Builder setIsTrack(boolean z) {
                this.isTrack_ = z;
                onChanged();
                return this;
            }

            public Builder setParamType(int i) {
                this.paramType_ = i;
                onChanged();
                return this;
            }

            public Builder setParamValue(String str) {
                if (str != null) {
                    this.paramValue_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setParamValueBytes(ByteString byteString) {
                if (byteString != null) {
                    AbResult.checkByteStringIsUtf8(byteString);
                    this.paramValue_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private AbResult() {
            this.memoizedIsInitialized = (byte) -1;
            this.paramValue_ = "";
        }

        private AbResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.gid_ = codedInputStream.readInt64();
                            } else if (readTag == 16) {
                                this.paramType_ = codedInputStream.readInt32();
                            } else if (readTag == 26) {
                                this.paramValue_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.isTrack_ = codedInputStream.readBool();
                            } else if (readTag == 40) {
                                this.isGroupFreeze_ = codedInputStream.readBool();
                            } else if (readTag == 48) {
                                this.isFreeze_ = codedInputStream.readBool();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private AbResult(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static AbResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AbClientProtos.internal_static_com_blued_das_client_abtest_AbResult_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbResult abResult) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(abResult);
        }

        public static AbResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AbResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AbResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AbResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AbResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AbResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AbResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AbResult) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AbResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AbResult) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static AbResult parseFrom(InputStream inputStream) throws IOException {
            return (AbResult) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AbResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AbResult) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AbResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AbResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AbResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AbResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<AbResult> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof AbResult) {
                AbResult abResult = (AbResult) obj;
                return getGid() == abResult.getGid() && getParamType() == abResult.getParamType() && getParamValue().equals(abResult.getParamValue()) && getIsTrack() == abResult.getIsTrack() && getIsGroupFreeze() == abResult.getIsGroupFreeze() && getIsFreeze() == abResult.getIsFreeze() && this.unknownFields.equals(abResult.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbResult getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
        public long getGid() {
            return this.gid_;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
        public boolean getIsFreeze() {
            return this.isFreeze_;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
        public boolean getIsGroupFreeze() {
            return this.isGroupFreeze_;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
        public boolean getIsTrack() {
            return this.isTrack_;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
        public int getParamType() {
            return this.paramType_;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
        public String getParamValue() {
            Object obj = this.paramValue_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.paramValue_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.AbResultOrBuilder
        public ByteString getParamValueBytes() {
            Object obj = this.paramValue_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.paramValue_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbResult> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            long j = this.gid_;
            if (j != 0) {
                i2 = 0 + CodedOutputStream.computeInt64Size(1, j);
            }
            int i3 = this.paramType_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeInt32Size(2, i3);
            }
            int i5 = i4;
            if (!getParamValueBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.paramValue_);
            }
            boolean z = this.isTrack_;
            int i6 = i5;
            if (z) {
                i6 = i5 + CodedOutputStream.computeBoolSize(4, z);
            }
            boolean z2 = this.isGroupFreeze_;
            int i7 = i6;
            if (z2) {
                i7 = i6 + CodedOutputStream.computeBoolSize(5, z2);
            }
            boolean z3 = this.isFreeze_;
            int i8 = i7;
            if (z3) {
                i8 = i7 + CodedOutputStream.computeBoolSize(6, z3);
            }
            int serializedSize = i8 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getGid())) * 37) + 2) * 53) + getParamType()) * 37) + 3) * 53) + getParamValue().hashCode()) * 37) + 4) * 53) + Internal.hashBoolean(getIsTrack())) * 37) + 5) * 53) + Internal.hashBoolean(getIsGroupFreeze())) * 37) + 6) * 53) + Internal.hashBoolean(getIsFreeze())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbClientProtos.internal_static_com_blued_das_client_abtest_AbResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AbResult.class, Builder.class);
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

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AbResult();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.gid_;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            int i = this.paramType_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            if (!getParamValueBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.paramValue_);
            }
            boolean z = this.isTrack_;
            if (z) {
                codedOutputStream.writeBool(4, z);
            }
            boolean z2 = this.isGroupFreeze_;
            if (z2) {
                codedOutputStream.writeBool(5, z2);
            }
            boolean z3 = this.isFreeze_;
            if (z3) {
                codedOutputStream.writeBool(6, z3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientProtos$AbResultOrBuilder.class */
    public interface AbResultOrBuilder extends MessageOrBuilder {
        long getGid();

        boolean getIsFreeze();

        boolean getIsGroupFreeze();

        boolean getIsTrack();

        int getParamType();

        String getParamValue();

        ByteString getParamValueBytes();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientProtos$Request.class */
    public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
        public static final int COMMON_FIELD_NUMBER = 3;
        public static final int DECISION_ID_FIELD_NUMBER = 1;
        private static final Request DEFAULT_INSTANCE = new Request();
        private static final Parser<Request> PARSER = new AbstractParser<Request>() { // from class: com.blued.das.client.abtest.AbClientProtos.Request.1
            @Override // com.google.protobuf.Parser
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TOKEN_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private CommonProtos.Common common_;
        private volatile Object decisionId_;
        private byte memoizedIsInitialized;
        private volatile Object token_;

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientProtos$Request$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestOrBuilder {
            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
            private CommonProtos.Common common_;
            private Object decisionId_;
            private Object token_;

            private Builder() {
                this.decisionId_ = "";
                this.token_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.decisionId_ = "";
                this.token_ = "";
                maybeForceBuilderInitialization();
            }

            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> getCommonFieldBuilder() {
                if (this.commonBuilder_ == null) {
                    this.commonBuilder_ = new SingleFieldBuilderV3<>(getCommon(), getParentForChildren(), isClean());
                    this.common_ = null;
                }
                return this.commonBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AbClientProtos.internal_static_com_blued_das_client_abtest_Request_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Request.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Request build() {
                Request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Request buildPartial() {
                Request request = new Request(this);
                request.decisionId_ = this.decisionId_;
                request.token_ = this.token_;
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    request.common_ = this.common_;
                } else {
                    request.common_ = singleFieldBuilderV3.build();
                }
                onBuilt();
                return request;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.decisionId_ = "";
                this.token_ = "";
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                    return this;
                }
                this.common_ = null;
                this.commonBuilder_ = null;
                return this;
            }

            public Builder clearCommon() {
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                    onChanged();
                    return this;
                }
                this.common_ = null;
                this.commonBuilder_ = null;
                return this;
            }

            public Builder clearDecisionId() {
                this.decisionId_ = Request.getDefaultInstance().getDecisionId();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearToken() {
                this.token_ = Request.getDefaultInstance().getToken();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
            public CommonProtos.Common getCommon() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    CommonProtos.Common common = this.common_;
                    CommonProtos.Common common2 = common;
                    if (common == null) {
                        common2 = CommonProtos.Common.getDefaultInstance();
                    }
                    return common2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public CommonProtos.Common.Builder getCommonBuilder() {
                onChanged();
                return getCommonFieldBuilder().getBuilder();
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
            public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                CommonProtos.Common common = this.common_;
                CommonProtos.Common common2 = common;
                if (common == null) {
                    common2 = CommonProtos.Common.getDefaultInstance();
                }
                return common2;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
            public String getDecisionId() {
                Object obj = this.decisionId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.decisionId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
            public ByteString getDecisionIdBytes() {
                Object obj = this.decisionId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.decisionId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Request getDefaultInstanceForType() {
                return Request.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbClientProtos.internal_static_com_blued_das_client_abtest_Request_descriptor;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
            public String getToken() {
                Object obj = this.token_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.token_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
            public ByteString getTokenBytes() {
                Object obj = this.token_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.token_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbClientProtos.internal_static_com_blued_das_client_abtest_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeCommon(CommonProtos.Common common) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(common);
                    return this;
                }
                CommonProtos.Common common2 = this.common_;
                if (common2 != null) {
                    this.common_ = CommonProtos.Common.newBuilder(common2).mergeFrom(common).buildPartial();
                } else {
                    this.common_ = common;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(Request request) {
                if (request == Request.getDefaultInstance()) {
                    return this;
                }
                if (!request.getDecisionId().isEmpty()) {
                    this.decisionId_ = request.decisionId_;
                    onChanged();
                }
                if (!request.getToken().isEmpty()) {
                    this.token_ = request.token_;
                    onChanged();
                }
                if (request.hasCommon()) {
                    mergeCommon(request.getCommon());
                }
                mergeUnknownFields(request.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.client.abtest.AbClientProtos.Request.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.client.abtest.AbClientProtos.Request.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.client.abtest.AbClientProtos$Request r0 = (com.blued.das.client.abtest.AbClientProtos.Request) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.client.abtest.AbClientProtos$Request$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.client.abtest.AbClientProtos$Request r0 = (com.blued.das.client.abtest.AbClientProtos.Request) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.client.abtest.AbClientProtos$Request$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.client.abtest.AbClientProtos.Request.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.client.abtest.AbClientProtos$Request$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Request) {
                    return mergeFrom((Request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setCommon(CommonProtos.Common.Builder builder) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.common_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setCommon(CommonProtos.Common common) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(common);
                    return this;
                } else if (common != null) {
                    this.common_ = common;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setDecisionId(String str) {
                if (str != null) {
                    this.decisionId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDecisionIdBytes(ByteString byteString) {
                if (byteString != null) {
                    Request.checkByteStringIsUtf8(byteString);
                    this.decisionId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setToken(String str) {
                if (str != null) {
                    this.token_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTokenBytes(ByteString byteString) {
                if (byteString != null) {
                    Request.checkByteStringIsUtf8(byteString);
                    this.token_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Request() {
            this.memoizedIsInitialized = (byte) -1;
            this.decisionId_ = "";
            this.token_ = "";
        }

        private Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.decisionId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.token_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                CommonProtos.Common.Builder builder = this.common_ != null ? this.common_.toBuilder() : null;
                                CommonProtos.Common common = (CommonProtos.Common) codedInputStream.readMessage(CommonProtos.Common.parser(), extensionRegistryLite);
                                this.common_ = common;
                                if (builder != null) {
                                    builder.mergeFrom(common);
                                    this.common_ = builder.buildPartial();
                                }
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private Request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AbClientProtos.internal_static_com_blued_das_client_abtest_Request_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Request request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(request);
        }

        public static Request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Request parseFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Request> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Request) {
                Request request = (Request) obj;
                if (getDecisionId().equals(request.getDecisionId()) && getToken().equals(request.getToken()) && hasCommon() == request.hasCommon()) {
                    return (!hasCommon() || getCommon().equals(request.getCommon())) && this.unknownFields.equals(request.unknownFields);
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
        public CommonProtos.Common getCommon() {
            CommonProtos.Common common = this.common_;
            CommonProtos.Common common2 = common;
            if (common == null) {
                common2 = CommonProtos.Common.getDefaultInstance();
            }
            return common2;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
        public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
        public String getDecisionId() {
            Object obj = this.decisionId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.decisionId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
        public ByteString getDecisionIdBytes() {
            Object obj = this.decisionId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.decisionId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Request> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getDecisionIdBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.decisionId_);
            }
            int i3 = i2;
            if (!getTokenBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.token_);
            }
            int i4 = i3;
            if (this.common_ != null) {
                i4 = i3 + CodedOutputStream.computeMessageSize(3, getCommon());
            }
            int serializedSize = i4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
        public String getToken() {
            Object obj = this.token_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.token_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
        public ByteString getTokenBytes() {
            Object obj = this.token_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.token_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.RequestOrBuilder
        public boolean hasCommon() {
            return this.common_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getDecisionId().hashCode()) * 37) + 2) * 53) + getToken().hashCode();
            int i = hashCode;
            if (hasCommon()) {
                i = (((hashCode * 37) + 3) * 53) + getCommon().hashCode();
            }
            int hashCode2 = (i * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbClientProtos.internal_static_com_blued_das_client_abtest_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Request();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getDecisionIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.decisionId_);
            }
            if (!getTokenBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.token_);
            }
            if (this.common_ != null) {
                codedOutputStream.writeMessage(3, getCommon());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientProtos$RequestOrBuilder.class */
    public interface RequestOrBuilder extends MessageOrBuilder {
        CommonProtos.Common getCommon();

        CommonProtos.CommonOrBuilder getCommonOrBuilder();

        String getDecisionId();

        ByteString getDecisionIdBytes();

        String getToken();

        ByteString getTokenBytes();

        boolean hasCommon();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientProtos$Response.class */
    public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 2;
        public static final int MESSAGE_FIELD_NUMBER = 3;
        public static final int RESULTS_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int code_;
        private byte memoizedIsInitialized;
        private volatile Object message_;
        private MapField<String, AbResult> results_;
        private static final Response DEFAULT_INSTANCE = new Response();
        private static final Parser<Response> PARSER = new AbstractParser<Response>() { // from class: com.blued.das.client.abtest.AbClientProtos.Response.1
            @Override // com.google.protobuf.Parser
            public Response parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Response(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientProtos$Response$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResponseOrBuilder {
            private int bitField0_;
            private int code_;
            private Object message_;
            private MapField<String, AbResult> results_;

            private Builder() {
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AbClientProtos.internal_static_com_blued_das_client_abtest_Response_descriptor;
            }

            private MapField<String, AbResult> internalGetMutableResults() {
                onChanged();
                if (this.results_ == null) {
                    this.results_ = MapField.newMapField(ResultsDefaultEntryHolder.defaultEntry);
                }
                if (!this.results_.isMutable()) {
                    this.results_ = this.results_.copy();
                }
                return this.results_;
            }

            private MapField<String, AbResult> internalGetResults() {
                MapField<String, AbResult> mapField = this.results_;
                MapField<String, AbResult> mapField2 = mapField;
                if (mapField == null) {
                    mapField2 = MapField.emptyMapField(ResultsDefaultEntryHolder.defaultEntry);
                }
                return mapField2;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Response.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Response build() {
                Response buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Response buildPartial() {
                Response response = new Response(this);
                response.results_ = internalGetResults();
                response.results_.makeImmutable();
                response.code_ = this.code_;
                response.message_ = this.message_;
                onBuilt();
                return response;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                internalGetMutableResults().clear();
                this.code_ = 0;
                this.message_ = "";
                return this;
            }

            public Builder clearCode() {
                this.code_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearMessage() {
                this.message_ = Response.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearResults() {
                internalGetMutableResults().getMutableMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
            public boolean containsResults(String str) {
                if (str != null) {
                    return internalGetResults().getMap().containsKey(str);
                }
                throw null;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
            public int getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Response getDefaultInstanceForType() {
                return Response.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbClientProtos.internal_static_com_blued_das_client_abtest_Response_descriptor;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
            public String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
            public ByteString getMessageBytes() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.message_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Deprecated
            public Map<String, AbResult> getMutableResults() {
                return internalGetMutableResults().getMutableMap();
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
            @Deprecated
            public Map<String, AbResult> getResults() {
                return getResultsMap();
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
            public int getResultsCount() {
                return internalGetResults().getMap().size();
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
            public Map<String, AbResult> getResultsMap() {
                return internalGetResults().getMap();
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
            public AbResult getResultsOrDefault(String str, AbResult abResult) {
                if (str != null) {
                    Map<String, AbResult> map = internalGetResults().getMap();
                    if (map.containsKey(str)) {
                        abResult = map.get(str);
                    }
                    return abResult;
                }
                throw null;
            }

            @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
            public AbResult getResultsOrThrow(String str) {
                if (str != null) {
                    Map<String, AbResult> map = internalGetResults().getMap();
                    if (map.containsKey(str)) {
                        return map.get(str);
                    }
                    throw new IllegalArgumentException();
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbClientProtos.internal_static_com_blued_das_client_abtest_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMapField(int i) {
                if (i == 1) {
                    return internalGetResults();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMutableMapField(int i) {
                if (i == 1) {
                    return internalGetMutableResults();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Response response) {
                if (response == Response.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableResults().mergeFrom(response.internalGetResults());
                if (response.getCode() != 0) {
                    setCode(response.getCode());
                }
                if (!response.getMessage().isEmpty()) {
                    this.message_ = response.message_;
                    onChanged();
                }
                mergeUnknownFields(response.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.client.abtest.AbClientProtos.Response.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.client.abtest.AbClientProtos.Response.access$4200()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.client.abtest.AbClientProtos$Response r0 = (com.blued.das.client.abtest.AbClientProtos.Response) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.client.abtest.AbClientProtos$Response$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.client.abtest.AbClientProtos$Response r0 = (com.blued.das.client.abtest.AbClientProtos.Response) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.client.abtest.AbClientProtos$Response$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.client.abtest.AbClientProtos.Response.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.client.abtest.AbClientProtos$Response$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Response) {
                    return mergeFrom((Response) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder putAllResults(Map<String, AbResult> map) {
                internalGetMutableResults().getMutableMap().putAll(map);
                return this;
            }

            public Builder putResults(String str, AbResult abResult) {
                if (str != null) {
                    if (abResult != null) {
                        internalGetMutableResults().getMutableMap().put(str, abResult);
                        return this;
                    }
                    throw null;
                }
                throw null;
            }

            public Builder removeResults(String str) {
                if (str != null) {
                    internalGetMutableResults().getMutableMap().remove(str);
                    return this;
                }
                throw null;
            }

            public Builder setCode(int i) {
                this.code_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setMessage(String str) {
                if (str != null) {
                    this.message_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMessageBytes(ByteString byteString) {
                if (byteString != null) {
                    Response.checkByteStringIsUtf8(byteString);
                    this.message_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientProtos$Response$ResultsDefaultEntryHolder.class */
        public static final class ResultsDefaultEntryHolder {
            static final MapEntry<String, AbResult> defaultEntry = MapEntry.newDefaultInstance(AbClientProtos.internal_static_com_blued_das_client_abtest_Response_ResultsEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, AbResult.getDefaultInstance());

            private ResultsDefaultEntryHolder() {
            }
        }

        private Response() {
            this.memoizedIsInitialized = (byte) -1;
            this.message_ = "";
        }

        private Response(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                boolean z3 = z2;
                                if (!(z2 & true)) {
                                    this.results_ = MapField.newMapField(ResultsDefaultEntryHolder.defaultEntry);
                                    z3 = z2 | true;
                                }
                                MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(ResultsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                this.results_.getMutableMap().put((String) mapEntry.getKey(), (AbResult) mapEntry.getValue());
                                z2 = z3;
                            } else if (readTag == 16) {
                                this.code_ = codedInputStream.readInt32();
                            } else if (readTag == 26) {
                                this.message_ = codedInputStream.readStringRequireUtf8();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private Response(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Response getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AbClientProtos.internal_static_com_blued_das_client_abtest_Response_descriptor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<String, AbResult> internalGetResults() {
            MapField<String, AbResult> mapField = this.results_;
            MapField<String, AbResult> mapField2 = mapField;
            if (mapField == null) {
                mapField2 = MapField.emptyMapField(ResultsDefaultEntryHolder.defaultEntry);
            }
            return mapField2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Response response) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(response);
        }

        public static Response parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Response parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Response parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Response parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Response parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Response parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Response parseFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Response parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Response parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Response parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Response parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Response parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Response> parser() {
            return PARSER;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
        public boolean containsResults(String str) {
            if (str != null) {
                return internalGetResults().getMap().containsKey(str);
            }
            throw null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Response) {
                Response response = (Response) obj;
                return internalGetResults().equals(response.internalGetResults()) && getCode() == response.getCode() && getMessage().equals(response.getMessage()) && this.unknownFields.equals(response.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Response getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
        public String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.message_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
        public ByteString getMessageBytes() {
            Object obj = this.message_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Response> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
        @Deprecated
        public Map<String, AbResult> getResults() {
            return getResultsMap();
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
        public int getResultsCount() {
            return internalGetResults().getMap().size();
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
        public Map<String, AbResult> getResultsMap() {
            return internalGetResults().getMap();
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
        public AbResult getResultsOrDefault(String str, AbResult abResult) {
            if (str != null) {
                Map<String, AbResult> map = internalGetResults().getMap();
                if (map.containsKey(str)) {
                    abResult = map.get(str);
                }
                return abResult;
            }
            throw null;
        }

        @Override // com.blued.das.client.abtest.AbClientProtos.ResponseOrBuilder
        public AbResult getResultsOrThrow(String str) {
            if (str != null) {
                Map<String, AbResult> map = internalGetResults().getMap();
                if (map.containsKey(str)) {
                    return map.get(str);
                }
                throw new IllegalArgumentException();
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (Map.Entry<String, AbResult> entry : internalGetResults().getMap().entrySet()) {
                i2 += CodedOutputStream.computeMessageSize(1, ResultsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int i3 = this.code_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeInt32Size(2, i3);
            }
            int i5 = i4;
            if (!getMessageBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.message_);
            }
            int serializedSize = i5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            int i = hashCode;
            if (!internalGetResults().getMap().isEmpty()) {
                i = (((hashCode * 37) + 1) * 53) + internalGetResults().hashCode();
            }
            int code = (((((((((i * 37) + 2) * 53) + getCode()) * 37) + 3) * 53) + getMessage().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = code;
            return code;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbClientProtos.internal_static_com_blued_das_client_abtest_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public MapField internalGetMapField(int i) {
            if (i == 1) {
                return internalGetResults();
            }
            throw new RuntimeException("Invalid map field number: " + i);
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

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Response();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetResults(), ResultsDefaultEntryHolder.defaultEntry, 1);
            int i = this.code_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            if (!getMessageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.message_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientProtos$ResponseOrBuilder.class */
    public interface ResponseOrBuilder extends MessageOrBuilder {
        boolean containsResults(String str);

        int getCode();

        String getMessage();

        ByteString getMessageBytes();

        @Deprecated
        Map<String, AbResult> getResults();

        int getResultsCount();

        Map<String, AbResult> getResultsMap();

        AbResult getResultsOrDefault(String str, AbResult abResult);

        AbResult getResultsOrThrow(String str);
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_das_client_abtest_Request_descriptor = descriptor2;
        internal_static_com_blued_das_client_abtest_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"DecisionId", "Token", "Common"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_blued_das_client_abtest_AbResult_descriptor = descriptor3;
        internal_static_com_blued_das_client_abtest_AbResult_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Gid", "ParamType", "ParamValue", "IsTrack", "IsGroupFreeze", "IsFreeze"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_blued_das_client_abtest_Response_descriptor = descriptor4;
        internal_static_com_blued_das_client_abtest_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Results", "Code", "Message"});
        Descriptors.Descriptor descriptor5 = internal_static_com_blued_das_client_abtest_Response_descriptor.getNestedTypes().get(0);
        internal_static_com_blued_das_client_abtest_Response_ResultsEntry_descriptor = descriptor5;
        internal_static_com_blued_das_client_abtest_Response_ResultsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Key", "Value"});
        CommonProtos.getDescriptor();
    }

    private AbClientProtos() {
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
