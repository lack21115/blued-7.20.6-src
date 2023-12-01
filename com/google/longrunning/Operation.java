package com.google.longrunning;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.rpc.Status;
import com.google.rpc.StatusOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-8110460-dex2jar.jar:com/google/longrunning/Operation.class */
public final class Operation extends GeneratedMessageV3 implements OperationOrBuilder {
    public static final int DONE_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int RESPONSE_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private boolean done_;
    private byte memoizedIsInitialized;
    private Any metadata_;
    private volatile Object name_;
    private int resultCase_;
    private Object result_;
    private static final Operation DEFAULT_INSTANCE = new Operation();
    private static final Parser<Operation> PARSER = new AbstractParser<Operation>() { // from class: com.google.longrunning.Operation.1
        @Override // com.google.protobuf.Parser
        public Operation parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Operation(codedInputStream, extensionRegistryLite);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.longrunning.Operation$2  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/google/longrunning/Operation$2.class */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$longrunning$Operation$ResultCase;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[ResultCase.values().length];
            $SwitchMap$com$google$longrunning$Operation$ResultCase = iArr;
            try {
                iArr[ResultCase.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$longrunning$Operation$ResultCase[ResultCase.RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$longrunning$Operation$ResultCase[ResultCase.RESULT_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/longrunning/Operation$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OperationOrBuilder {
        private boolean done_;
        private SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> errorBuilder_;
        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> metadataBuilder_;
        private Any metadata_;
        private Object name_;
        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> responseBuilder_;
        private int resultCase_;
        private Object result_;

        private Builder() {
            this.resultCase_ = 0;
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.resultCase_ = 0;
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return OperationsProto.internal_static_google_longrunning_Operation_descriptor;
        }

        private SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> getErrorFieldBuilder() {
            if (this.errorBuilder_ == null) {
                if (this.resultCase_ != 4) {
                    this.result_ = Status.getDefaultInstance();
                }
                this.errorBuilder_ = new SingleFieldBuilderV3<>((Status) this.result_, getParentForChildren(), isClean());
                this.result_ = null;
            }
            this.resultCase_ = 4;
            onChanged();
            return this.errorBuilder_;
        }

        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getMetadataFieldBuilder() {
            if (this.metadataBuilder_ == null) {
                this.metadataBuilder_ = new SingleFieldBuilderV3<>(getMetadata(), getParentForChildren(), isClean());
                this.metadata_ = null;
            }
            return this.metadataBuilder_;
        }

        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getResponseFieldBuilder() {
            if (this.responseBuilder_ == null) {
                if (this.resultCase_ != 5) {
                    this.result_ = Any.getDefaultInstance();
                }
                this.responseBuilder_ = new SingleFieldBuilderV3<>((Any) this.result_, getParentForChildren(), isClean());
                this.result_ = null;
            }
            this.resultCase_ = 5;
            onChanged();
            return this.responseBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = Operation.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Operation build() {
            Operation buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Operation buildPartial() {
            Operation operation = new Operation(this);
            operation.name_ = this.name_;
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                operation.metadata_ = this.metadata_;
            } else {
                operation.metadata_ = singleFieldBuilderV3.build();
            }
            operation.done_ = this.done_;
            if (this.resultCase_ == 4) {
                SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV32 = this.errorBuilder_;
                if (singleFieldBuilderV32 == null) {
                    operation.result_ = this.result_;
                } else {
                    operation.result_ = singleFieldBuilderV32.build();
                }
            }
            if (this.resultCase_ == 5) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV33 = this.responseBuilder_;
                if (singleFieldBuilderV33 == null) {
                    operation.result_ = this.result_;
                } else {
                    operation.result_ = singleFieldBuilderV33.build();
                }
            }
            operation.resultCase_ = this.resultCase_;
            onBuilt();
            return operation;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.name_ = "";
            if (this.metadataBuilder_ == null) {
                this.metadata_ = null;
            } else {
                this.metadata_ = null;
                this.metadataBuilder_ = null;
            }
            this.done_ = false;
            this.resultCase_ = 0;
            this.result_ = null;
            return this;
        }

        public Builder clearDone() {
            this.done_ = false;
            onChanged();
            return this;
        }

        public Builder clearError() {
            if (this.errorBuilder_ != null) {
                if (this.resultCase_ == 4) {
                    this.resultCase_ = 0;
                    this.result_ = null;
                }
                this.errorBuilder_.clear();
            } else if (this.resultCase_ == 4) {
                this.resultCase_ = 0;
                this.result_ = null;
                onChanged();
                return this;
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearMetadata() {
            if (this.metadataBuilder_ == null) {
                this.metadata_ = null;
                onChanged();
                return this;
            }
            this.metadata_ = null;
            this.metadataBuilder_ = null;
            return this;
        }

        public Builder clearName() {
            this.name_ = Operation.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearResponse() {
            if (this.responseBuilder_ != null) {
                if (this.resultCase_ == 5) {
                    this.resultCase_ = 0;
                    this.result_ = null;
                }
                this.responseBuilder_.clear();
            } else if (this.resultCase_ == 5) {
                this.resultCase_ = 0;
                this.result_ = null;
                onChanged();
                return this;
            }
            return this;
        }

        public Builder clearResult() {
            this.resultCase_ = 0;
            this.result_ = null;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2030clone() {
            return (Builder) super.mo2030clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Operation getDefaultInstanceForType() {
            return Operation.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return OperationsProto.internal_static_google_longrunning_Operation_descriptor;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public boolean getDone() {
            return this.done_;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public Status getError() {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
            return singleFieldBuilderV3 == null ? this.resultCase_ == 4 ? (Status) this.result_ : Status.getDefaultInstance() : this.resultCase_ == 4 ? singleFieldBuilderV3.getMessage() : Status.getDefaultInstance();
        }

        public Status.Builder getErrorBuilder() {
            return getErrorFieldBuilder().getBuilder();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public StatusOrBuilder getErrorOrBuilder() {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3;
            return (this.resultCase_ != 4 || (singleFieldBuilderV3 = this.errorBuilder_) == null) ? this.resultCase_ == 4 ? (Status) this.result_ : Status.getDefaultInstance() : singleFieldBuilderV3.getMessageOrBuilder();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public Any getMetadata() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Any any = this.metadata_;
                Any any2 = any;
                if (any == null) {
                    any2 = Any.getDefaultInstance();
                }
                return any2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Any.Builder getMetadataBuilder() {
            onChanged();
            return getMetadataFieldBuilder().getBuilder();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public AnyOrBuilder getMetadataOrBuilder() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Any any = this.metadata_;
            Any any2 = any;
            if (any == null) {
                any2 = Any.getDefaultInstance();
            }
            return any2;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public Any getResponse() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            return singleFieldBuilderV3 == null ? this.resultCase_ == 5 ? (Any) this.result_ : Any.getDefaultInstance() : this.resultCase_ == 5 ? singleFieldBuilderV3.getMessage() : Any.getDefaultInstance();
        }

        public Any.Builder getResponseBuilder() {
            return getResponseFieldBuilder().getBuilder();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public AnyOrBuilder getResponseOrBuilder() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3;
            return (this.resultCase_ != 5 || (singleFieldBuilderV3 = this.responseBuilder_) == null) ? this.resultCase_ == 5 ? (Any) this.result_ : Any.getDefaultInstance() : singleFieldBuilderV3.getMessageOrBuilder();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public ResultCase getResultCase() {
            return ResultCase.forNumber(this.resultCase_);
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public boolean hasError() {
            return this.resultCase_ == 4;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public boolean hasMetadata() {
            return (this.metadataBuilder_ == null && this.metadata_ == null) ? false : true;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public boolean hasResponse() {
            return this.resultCase_ == 5;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return OperationsProto.internal_static_google_longrunning_Operation_fieldAccessorTable.ensureFieldAccessorsInitialized(Operation.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeError(Status status) {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.resultCase_ != 4 || this.result_ == Status.getDefaultInstance()) {
                    this.result_ = status;
                } else {
                    this.result_ = Status.newBuilder((Status) this.result_).mergeFrom(status).buildPartial();
                }
                onChanged();
            } else {
                if (this.resultCase_ == 4) {
                    singleFieldBuilderV3.mergeFrom(status);
                }
                this.errorBuilder_.setMessage(status);
            }
            this.resultCase_ = 4;
            return this;
        }

        public Builder mergeFrom(Operation operation) {
            if (operation == Operation.getDefaultInstance()) {
                return this;
            }
            if (!operation.getName().isEmpty()) {
                this.name_ = operation.name_;
                onChanged();
            }
            if (operation.hasMetadata()) {
                mergeMetadata(operation.getMetadata());
            }
            if (operation.getDone()) {
                setDone(operation.getDone());
            }
            int i = AnonymousClass2.$SwitchMap$com$google$longrunning$Operation$ResultCase[operation.getResultCase().ordinal()];
            if (i == 1) {
                mergeError(operation.getError());
            } else if (i == 2) {
                mergeResponse(operation.getResponse());
            }
            mergeUnknownFields(operation.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.longrunning.Operation.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.longrunning.Operation.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.longrunning.Operation r0 = (com.google.longrunning.Operation) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.longrunning.Operation$Builder r0 = r0.mergeFrom(r1)
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
                com.google.longrunning.Operation r0 = (com.google.longrunning.Operation) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.longrunning.Operation$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.longrunning.Operation.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.longrunning.Operation$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Operation) {
                return mergeFrom((Operation) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeMetadata(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(any);
                return this;
            }
            Any any2 = this.metadata_;
            if (any2 != null) {
                this.metadata_ = Any.newBuilder(any2).mergeFrom(any).buildPartial();
            } else {
                this.metadata_ = any;
            }
            onChanged();
            return this;
        }

        public Builder mergeResponse(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.resultCase_ != 5 || this.result_ == Any.getDefaultInstance()) {
                    this.result_ = any;
                } else {
                    this.result_ = Any.newBuilder((Any) this.result_).mergeFrom(any).buildPartial();
                }
                onChanged();
            } else {
                if (this.resultCase_ == 5) {
                    singleFieldBuilderV3.mergeFrom(any);
                }
                this.responseBuilder_.setMessage(any);
            }
            this.resultCase_ = 5;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setDone(boolean z) {
            this.done_ = z;
            onChanged();
            return this;
        }

        public Builder setError(Status.Builder builder) {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.result_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.resultCase_ = 4;
            return this;
        }

        public Builder setError(Status status) {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(status);
            } else if (status == null) {
                throw null;
            } else {
                this.result_ = status;
                onChanged();
            }
            this.resultCase_ = 4;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setMetadata(Any.Builder builder) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.metadata_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setMetadata(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(any);
                return this;
            } else if (any != null) {
                this.metadata_ = any;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setName(String str) {
            if (str != null) {
                this.name_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNameBytes(ByteString byteString) {
            if (byteString != null) {
                Operation.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setResponse(Any.Builder builder) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.result_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.resultCase_ = 5;
            return this;
        }

        public Builder setResponse(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(any);
            } else if (any == null) {
                throw null;
            } else {
                this.result_ = any;
                onChanged();
            }
            this.resultCase_ = 5;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/longrunning/Operation$ResultCase.class */
    public enum ResultCase implements Internal.EnumLite {
        ERROR(4),
        RESPONSE(5),
        RESULT_NOT_SET(0);
        
        private final int value;

        ResultCase(int i) {
            this.value = i;
        }

        public static ResultCase forNumber(int i) {
            if (i != 0) {
                if (i != 4) {
                    if (i != 5) {
                        return null;
                    }
                    return RESPONSE;
                }
                return ERROR;
            }
            return RESULT_NOT_SET;
        }

        @Deprecated
        public static ResultCase valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    private Operation() {
        this.resultCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
    }

    private Operation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.name_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            Any.Builder builder = this.metadata_ != null ? this.metadata_.toBuilder() : null;
                            Any any = (Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                            this.metadata_ = any;
                            if (builder != null) {
                                builder.mergeFrom(any);
                                this.metadata_ = builder.buildPartial();
                            }
                        } else if (readTag == 24) {
                            this.done_ = codedInputStream.readBool();
                        } else if (readTag == 34) {
                            Status.Builder builder2 = this.resultCase_ == 4 ? ((Status) this.result_).toBuilder() : null;
                            MessageLite readMessage = codedInputStream.readMessage(Status.parser(), extensionRegistryLite);
                            this.result_ = readMessage;
                            if (builder2 != null) {
                                builder2.mergeFrom((Status) readMessage);
                                this.result_ = builder2.buildPartial();
                            }
                            this.resultCase_ = 4;
                        } else if (readTag == 42) {
                            Any.Builder builder3 = this.resultCase_ == 5 ? ((Any) this.result_).toBuilder() : null;
                            MessageLite readMessage2 = codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                            this.result_ = readMessage2;
                            if (builder3 != null) {
                                builder3.mergeFrom((Any) readMessage2);
                                this.result_ = builder3.buildPartial();
                            }
                            this.resultCase_ = 5;
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

    private Operation(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.resultCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Operation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return OperationsProto.internal_static_google_longrunning_Operation_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Operation operation) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(operation);
    }

    public static Operation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Operation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Operation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Operation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Operation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Operation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Operation) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Operation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Operation parseFrom(InputStream inputStream) throws IOException {
        return (Operation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Operation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Operation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Operation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Operation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Operation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<Operation> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Operation) {
            Operation operation = (Operation) obj;
            if (getName().equals(operation.getName()) && hasMetadata() == operation.hasMetadata()) {
                if ((!hasMetadata() || getMetadata().equals(operation.getMetadata())) && getDone() == operation.getDone() && getResultCase().equals(operation.getResultCase())) {
                    int i = this.resultCase_;
                    if (i != 4) {
                        if (i == 5 && !getResponse().equals(operation.getResponse())) {
                            return false;
                        }
                    } else if (!getError().equals(operation.getError())) {
                        return false;
                    }
                    return this.unknownFields.equals(operation.unknownFields);
                }
                return false;
            }
            return false;
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Operation getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public boolean getDone() {
        return this.done_;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public Status getError() {
        return this.resultCase_ == 4 ? (Status) this.result_ : Status.getDefaultInstance();
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public StatusOrBuilder getErrorOrBuilder() {
        return this.resultCase_ == 4 ? (Status) this.result_ : Status.getDefaultInstance();
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public Any getMetadata() {
        Any any = this.metadata_;
        Any any2 = any;
        if (any == null) {
            any2 = Any.getDefaultInstance();
        }
        return any2;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public AnyOrBuilder getMetadataOrBuilder() {
        return getMetadata();
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Operation> getParserForType() {
        return PARSER;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public Any getResponse() {
        return this.resultCase_ == 5 ? (Any) this.result_ : Any.getDefaultInstance();
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public AnyOrBuilder getResponseOrBuilder() {
        return this.resultCase_ == 5 ? (Any) this.result_ : Any.getDefaultInstance();
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public ResultCase getResultCase() {
        return ResultCase.forNumber(this.resultCase_);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getNameBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
        }
        int i3 = i2;
        if (this.metadata_ != null) {
            i3 = i2 + CodedOutputStream.computeMessageSize(2, getMetadata());
        }
        boolean z = this.done_;
        int i4 = i3;
        if (z) {
            i4 = i3 + CodedOutputStream.computeBoolSize(3, z);
        }
        int i5 = i4;
        if (this.resultCase_ == 4) {
            i5 = i4 + CodedOutputStream.computeMessageSize(4, (Status) this.result_);
        }
        int i6 = i5;
        if (this.resultCase_ == 5) {
            i6 = i5 + CodedOutputStream.computeMessageSize(5, (Any) this.result_);
        }
        int serializedSize = i6 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public boolean hasError() {
        return this.resultCase_ == 4;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public boolean hasMetadata() {
        return this.metadata_ != null;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public boolean hasResponse() {
        return this.resultCase_ == 5;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i;
        int hashCode;
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode2 = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        int i2 = hashCode2;
        if (hasMetadata()) {
            i2 = (((hashCode2 * 37) + 2) * 53) + getMetadata().hashCode();
        }
        int hashBoolean = (((i2 * 37) + 3) * 53) + Internal.hashBoolean(getDone());
        int i3 = this.resultCase_;
        if (i3 != 4) {
            if (i3 == 5) {
                i = ((hashBoolean * 37) + 5) * 53;
                hashCode = getResponse().hashCode();
            }
            int hashCode3 = (hashBoolean * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode3;
            return hashCode3;
        }
        i = ((hashBoolean * 37) + 4) * 53;
        hashCode = getError().hashCode();
        hashBoolean = i + hashCode;
        int hashCode32 = (hashBoolean * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode32;
        return hashCode32;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return OperationsProto.internal_static_google_longrunning_Operation_fieldAccessorTable.ensureFieldAccessorsInitialized(Operation.class, Builder.class);
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

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        if (this.metadata_ != null) {
            codedOutputStream.writeMessage(2, getMetadata());
        }
        boolean z = this.done_;
        if (z) {
            codedOutputStream.writeBool(3, z);
        }
        if (this.resultCase_ == 4) {
            codedOutputStream.writeMessage(4, (Status) this.result_);
        }
        if (this.resultCase_ == 5) {
            codedOutputStream.writeMessage(5, (Any) this.result_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
