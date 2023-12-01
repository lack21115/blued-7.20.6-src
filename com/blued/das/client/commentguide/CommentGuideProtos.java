package com.blued.das.client.commentguide;

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
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/commentguide/CommentGuideProtos.class */
public final class CommentGuideProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018CommentGuideProtos.proto\u0012!com.blued.das.client.commentguide\"c\n\u0011CommentGuideProto\u00127\n\u0005event\u0018\u0001 \u0001(\u000e2(.com.blued.das.client.commentguide.Event\u0012\u0015\n\rshow_occasion\u0018\u0002 \u0001(\t*\u0095\u0001\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010��\u0012\u0017\n\u0013COMMENT_WINDOW_SHOW\u0010\u0001\u0012!\n\u001dCOMMENT_WINDOW_FEEDBACK_CLICK\u0010\u0002\u0012\u001d\n\u0019COMMENT_WINDOW_RATE_CLICK\u0010\u0003\u0012\u001e\n\u001aCOMMENT_WINDOW_CLOSE_CLICK\u0010\u0004B\u0010¢\u0002\rCOMMENT_GUIDEb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_das_client_commentguide_CommentGuideProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_commentguide_CommentGuideProto_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/commentguide/CommentGuideProtos$CommentGuideProto.class */
    public static final class CommentGuideProto extends GeneratedMessageV3 implements CommentGuideProtoOrBuilder {
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int SHOW_OCCASION_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int event_;
        private byte memoizedIsInitialized;
        private volatile Object showOccasion_;
        private static final CommentGuideProto DEFAULT_INSTANCE = new CommentGuideProto();
        private static final Parser<CommentGuideProto> PARSER = new AbstractParser<CommentGuideProto>() { // from class: com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProto.1
            @Override // com.google.protobuf.Parser
            public CommentGuideProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CommentGuideProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/commentguide/CommentGuideProtos$CommentGuideProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommentGuideProtoOrBuilder {
            private int event_;
            private Object showOccasion_;

            private Builder() {
                this.event_ = 0;
                this.showOccasion_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.showOccasion_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CommentGuideProtos.internal_static_com_blued_das_client_commentguide_CommentGuideProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CommentGuideProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CommentGuideProto build() {
                CommentGuideProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CommentGuideProto buildPartial() {
                CommentGuideProto commentGuideProto = new CommentGuideProto(this);
                commentGuideProto.event_ = this.event_;
                commentGuideProto.showOccasion_ = this.showOccasion_;
                onBuilt();
                return commentGuideProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.showOccasion_ = "";
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
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

            public Builder clearShowOccasion() {
                this.showOccasion_ = CommentGuideProto.getDefaultInstance().getShowOccasion();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CommentGuideProto getDefaultInstanceForType() {
                return CommentGuideProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CommentGuideProtos.internal_static_com_blued_das_client_commentguide_CommentGuideProto_descriptor;
            }

            @Override // com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                Event event = valueOf;
                if (valueOf == null) {
                    event = Event.UNRECOGNIZED;
                }
                return event;
            }

            @Override // com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProtoOrBuilder
            public String getShowOccasion() {
                Object obj = this.showOccasion_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.showOccasion_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProtoOrBuilder
            public ByteString getShowOccasionBytes() {
                Object obj = this.showOccasion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.showOccasion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CommentGuideProtos.internal_static_com_blued_das_client_commentguide_CommentGuideProto_fieldAccessorTable.ensureFieldAccessorsInitialized(CommentGuideProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CommentGuideProto commentGuideProto) {
                if (commentGuideProto == CommentGuideProto.getDefaultInstance()) {
                    return this;
                }
                if (commentGuideProto.event_ != 0) {
                    setEventValue(commentGuideProto.getEventValue());
                }
                if (!commentGuideProto.getShowOccasion().isEmpty()) {
                    this.showOccasion_ = commentGuideProto.showOccasion_;
                    onChanged();
                }
                mergeUnknownFields(commentGuideProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProto.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.client.commentguide.CommentGuideProtos$CommentGuideProto r0 = (com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.client.commentguide.CommentGuideProtos$CommentGuideProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.client.commentguide.CommentGuideProtos$CommentGuideProto r0 = (com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.client.commentguide.CommentGuideProtos$CommentGuideProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.client.commentguide.CommentGuideProtos$CommentGuideProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof CommentGuideProto) {
                    return mergeFrom((CommentGuideProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setEvent(Event event) {
                if (event != null) {
                    this.event_ = event.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEventValue(int i) {
                this.event_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setShowOccasion(String str) {
                if (str != null) {
                    this.showOccasion_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setShowOccasionBytes(ByteString byteString) {
                if (byteString != null) {
                    CommentGuideProto.checkByteStringIsUtf8(byteString);
                    this.showOccasion_ = byteString;
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

        private CommentGuideProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.showOccasion_ = "";
        }

        private CommentGuideProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.event_ = codedInputStream.readEnum();
                                } else if (readTag == 18) {
                                    this.showOccasion_ = codedInputStream.readStringRequireUtf8();
                                } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private CommentGuideProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static CommentGuideProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CommentGuideProtos.internal_static_com_blued_das_client_commentguide_CommentGuideProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CommentGuideProto commentGuideProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(commentGuideProto);
        }

        public static CommentGuideProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CommentGuideProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CommentGuideProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CommentGuideProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CommentGuideProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CommentGuideProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CommentGuideProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CommentGuideProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static CommentGuideProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CommentGuideProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static CommentGuideProto parseFrom(InputStream inputStream) throws IOException {
            return (CommentGuideProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CommentGuideProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CommentGuideProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CommentGuideProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static CommentGuideProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static CommentGuideProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CommentGuideProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<CommentGuideProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CommentGuideProto) {
                CommentGuideProto commentGuideProto = (CommentGuideProto) obj;
                return this.event_ == commentGuideProto.event_ && getShowOccasion().equals(commentGuideProto.getShowOccasion()) && this.unknownFields.equals(commentGuideProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CommentGuideProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            Event event = valueOf;
            if (valueOf == null) {
                event = Event.UNRECOGNIZED;
            }
            return event;
        }

        @Override // com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CommentGuideProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.event_ != Event.UNKNOWN_EVENT.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.event_);
            }
            int i3 = i2;
            if (!getShowOccasionBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.showOccasion_);
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProtoOrBuilder
        public String getShowOccasion() {
            Object obj = this.showOccasion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.showOccasion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.commentguide.CommentGuideProtos.CommentGuideProtoOrBuilder
        public ByteString getShowOccasionBytes() {
            Object obj = this.showOccasion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.showOccasion_ = copyFromUtf8;
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
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + getShowOccasion().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CommentGuideProtos.internal_static_com_blued_das_client_commentguide_CommentGuideProto_fieldAccessorTable.ensureFieldAccessorsInitialized(CommentGuideProto.class, Builder.class);
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
            return new CommentGuideProto();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.event_ != Event.UNKNOWN_EVENT.getNumber()) {
                codedOutputStream.writeEnum(1, this.event_);
            }
            if (!getShowOccasionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.showOccasion_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/commentguide/CommentGuideProtos$CommentGuideProtoOrBuilder.class */
    public interface CommentGuideProtoOrBuilder extends MessageOrBuilder {
        Event getEvent();

        int getEventValue();

        String getShowOccasion();

        ByteString getShowOccasionBytes();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/commentguide/CommentGuideProtos$Event.class */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        COMMENT_WINDOW_SHOW(1),
        COMMENT_WINDOW_FEEDBACK_CLICK(2),
        COMMENT_WINDOW_RATE_CLICK(3),
        COMMENT_WINDOW_CLOSE_CLICK(4),
        UNRECOGNIZED(-1);
        
        public static final int COMMENT_WINDOW_CLOSE_CLICK_VALUE = 4;
        public static final int COMMENT_WINDOW_FEEDBACK_CLICK_VALUE = 2;
        public static final int COMMENT_WINDOW_RATE_CLICK_VALUE = 3;
        public static final int COMMENT_WINDOW_SHOW_VALUE = 1;
        public static final int UNKNOWN_EVENT_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.blued.das.client.commentguide.CommentGuideProtos.Event.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Event findValueByNumber(int i) {
                return Event.forNumber(i);
            }
        };
        private static final Event[] VALUES = values();

        Event(int i) {
            this.value = i;
        }

        public static Event forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return COMMENT_WINDOW_CLOSE_CLICK;
                        }
                        return COMMENT_WINDOW_RATE_CLICK;
                    }
                    return COMMENT_WINDOW_FEEDBACK_CLICK;
                }
                return COMMENT_WINDOW_SHOW;
            }
            return UNKNOWN_EVENT;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return CommentGuideProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Event> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Event valueOf(int i) {
            return forNumber(i);
        }

        public static Event valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_das_client_commentguide_CommentGuideProto_descriptor = descriptor2;
        internal_static_com_blued_das_client_commentguide_CommentGuideProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Event", "ShowOccasion"});
    }

    private CommentGuideProtos() {
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
