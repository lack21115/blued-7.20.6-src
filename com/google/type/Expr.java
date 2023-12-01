package com.google.type;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-7994992-dex2jar.jar:com/google/type/Expr.class */
public final class Expr extends GeneratedMessageV3 implements ExprOrBuilder {
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int EXPRESSION_FIELD_NUMBER = 1;
    public static final int LOCATION_FIELD_NUMBER = 4;
    public static final int TITLE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile Object description_;
    private volatile Object expression_;
    private volatile Object location_;
    private byte memoizedIsInitialized;
    private volatile Object title_;
    private static final Expr DEFAULT_INSTANCE = new Expr();
    private static final Parser<Expr> PARSER = new AbstractParser<Expr>() { // from class: com.google.type.Expr.1
        @Override // com.google.protobuf.Parser
        public Expr parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Expr(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-7994992-dex2jar.jar:com/google/type/Expr$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ExprOrBuilder {
        private Object description_;
        private Object expression_;
        private Object location_;
        private Object title_;

        private Builder() {
            this.expression_ = "";
            this.title_ = "";
            this.description_ = "";
            this.location_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.expression_ = "";
            this.title_ = "";
            this.description_ = "";
            this.location_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ExprProto.internal_static_google_type_Expr_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = Expr.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Expr build() {
            Expr buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Expr buildPartial() {
            Expr expr = new Expr(this);
            expr.expression_ = this.expression_;
            expr.title_ = this.title_;
            expr.description_ = this.description_;
            expr.location_ = this.location_;
            onBuilt();
            return expr;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.expression_ = "";
            this.title_ = "";
            this.description_ = "";
            this.location_ = "";
            return this;
        }

        public Builder clearDescription() {
            this.description_ = Expr.getDefaultInstance().getDescription();
            onChanged();
            return this;
        }

        public Builder clearExpression() {
            this.expression_ = Expr.getDefaultInstance().getExpression();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearLocation() {
            this.location_ = Expr.getDefaultInstance().getLocation();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearTitle() {
            this.title_ = Expr.getDefaultInstance().getTitle();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Expr getDefaultInstanceForType() {
            return Expr.getDefaultInstance();
        }

        @Override // com.google.type.ExprOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.description_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.ExprOrBuilder
        public ByteString getDescriptionBytes() {
            Object obj = this.description_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.description_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return ExprProto.internal_static_google_type_Expr_descriptor;
        }

        @Override // com.google.type.ExprOrBuilder
        public String getExpression() {
            Object obj = this.expression_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.expression_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.ExprOrBuilder
        public ByteString getExpressionBytes() {
            Object obj = this.expression_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.expression_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.ExprOrBuilder
        public String getLocation() {
            Object obj = this.location_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.location_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.ExprOrBuilder
        public ByteString getLocationBytes() {
            Object obj = this.location_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.location_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.ExprOrBuilder
        public String getTitle() {
            Object obj = this.title_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.title_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.ExprOrBuilder
        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExprProto.internal_static_google_type_Expr_fieldAccessorTable.ensureFieldAccessorsInitialized(Expr.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.type.Expr.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.type.Expr.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.type.Expr r0 = (com.google.type.Expr) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.type.Expr$Builder r0 = r0.mergeFrom(r1)
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
                com.google.type.Expr r0 = (com.google.type.Expr) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.type.Expr$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.type.Expr.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.type.Expr$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Expr) {
                return mergeFrom((Expr) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Expr expr) {
            if (expr == Expr.getDefaultInstance()) {
                return this;
            }
            if (!expr.getExpression().isEmpty()) {
                this.expression_ = expr.expression_;
                onChanged();
            }
            if (!expr.getTitle().isEmpty()) {
                this.title_ = expr.title_;
                onChanged();
            }
            if (!expr.getDescription().isEmpty()) {
                this.description_ = expr.description_;
                onChanged();
            }
            if (!expr.getLocation().isEmpty()) {
                this.location_ = expr.location_;
                onChanged();
            }
            mergeUnknownFields(expr.unknownFields);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setDescription(String str) {
            if (str != null) {
                this.description_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            if (byteString != null) {
                Expr.checkByteStringIsUtf8(byteString);
                this.description_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setExpression(String str) {
            if (str != null) {
                this.expression_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setExpressionBytes(ByteString byteString) {
            if (byteString != null) {
                Expr.checkByteStringIsUtf8(byteString);
                this.expression_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setLocation(String str) {
            if (str != null) {
                this.location_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLocationBytes(ByteString byteString) {
            if (byteString != null) {
                Expr.checkByteStringIsUtf8(byteString);
                this.location_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setTitle(String str) {
            if (str != null) {
                this.title_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTitleBytes(ByteString byteString) {
            if (byteString != null) {
                Expr.checkByteStringIsUtf8(byteString);
                this.title_ = byteString;
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

    private Expr() {
        this.memoizedIsInitialized = (byte) -1;
        this.expression_ = "";
        this.title_ = "";
        this.description_ = "";
        this.location_ = "";
    }

    private Expr(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.expression_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            this.title_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 26) {
                            this.description_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 34) {
                            this.location_ = codedInputStream.readStringRequireUtf8();
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

    private Expr(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Expr getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return ExprProto.internal_static_google_type_Expr_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Expr expr) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(expr);
    }

    public static Expr parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Expr) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Expr parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Expr) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Expr parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Expr parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Expr parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Expr) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Expr parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Expr) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Expr parseFrom(InputStream inputStream) throws IOException {
        return (Expr) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Expr parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Expr) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Expr parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Expr parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Expr parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Expr parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<Expr> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Expr) {
            Expr expr = (Expr) obj;
            return getExpression().equals(expr.getExpression()) && getTitle().equals(expr.getTitle()) && getDescription().equals(expr.getDescription()) && getLocation().equals(expr.getLocation()) && this.unknownFields.equals(expr.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Expr getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.type.ExprOrBuilder
    public String getDescription() {
        Object obj = this.description_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.description_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.ExprOrBuilder
    public ByteString getDescriptionBytes() {
        Object obj = this.description_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.description_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.ExprOrBuilder
    public String getExpression() {
        Object obj = this.expression_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.expression_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.ExprOrBuilder
    public ByteString getExpressionBytes() {
        Object obj = this.expression_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.expression_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.ExprOrBuilder
    public String getLocation() {
        Object obj = this.location_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.location_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.ExprOrBuilder
    public ByteString getLocationBytes() {
        Object obj = this.location_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.location_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Expr> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getExpressionBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.expression_);
        }
        int i3 = i2;
        if (!getTitleBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.title_);
        }
        int i4 = i3;
        if (!getDescriptionBytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.description_);
        }
        int i5 = i4;
        if (!getLocationBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.location_);
        }
        int serializedSize = i5 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.type.ExprOrBuilder
    public String getTitle() {
        Object obj = this.title_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.title_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.ExprOrBuilder
    public ByteString getTitleBytes() {
        Object obj = this.title_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.title_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
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
        int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getExpression().hashCode()) * 37) + 2) * 53) + getTitle().hashCode()) * 37) + 3) * 53) + getDescription().hashCode()) * 37) + 4) * 53) + getLocation().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ExprProto.internal_static_google_type_Expr_fieldAccessorTable.ensureFieldAccessorsInitialized(Expr.class, Builder.class);
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
        if (!getExpressionBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.expression_);
        }
        if (!getTitleBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.title_);
        }
        if (!getDescriptionBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.description_);
        }
        if (!getLocationBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.location_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
