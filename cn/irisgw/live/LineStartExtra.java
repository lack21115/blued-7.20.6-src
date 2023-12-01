package cn.irisgw.live;

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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LineStartExtra.class */
public final class LineStartExtra extends GeneratedMessageV3 implements LineStartExtraOrBuilder {
    public static final int CONFERENCE_ID_FIELD_NUMBER = 3;
    public static final int CONFERENCE_TOKEN_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 6;
    public static final int STREAM_FIELD_NUMBER = 1;
    public static final int TARGET_STREAM_FIELD_NUMBER = 2;
    public static final int TARGET_TOKEN_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 8;
    public static final int UID_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private volatile Object conferenceId_;
    private volatile Object conferenceToken_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private volatile Object stream_;
    private volatile Object targetStream_;
    private volatile Object targetToken_;
    private int type_;
    private int uid_;
    private static final LineStartExtra DEFAULT_INSTANCE = new LineStartExtra();
    private static final Parser<LineStartExtra> PARSER = new AbstractParser<LineStartExtra>() { // from class: cn.irisgw.live.LineStartExtra.1
        @Override // com.google.protobuf.Parser
        public LineStartExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LineStartExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LineStartExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LineStartExtraOrBuilder {
        private Object conferenceId_;
        private Object conferenceToken_;
        private Object name_;
        private Object stream_;
        private Object targetStream_;
        private Object targetToken_;
        private int type_;
        private int uid_;

        private Builder() {
            this.stream_ = "";
            this.targetStream_ = "";
            this.conferenceId_ = "";
            this.conferenceToken_ = "";
            this.targetToken_ = "";
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.stream_ = "";
            this.targetStream_ = "";
            this.conferenceId_ = "";
            this.conferenceToken_ = "";
            this.targetToken_ = "";
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LineStartExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LineStartExtra.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LineStartExtra build() {
            LineStartExtra buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LineStartExtra buildPartial() {
            LineStartExtra lineStartExtra = new LineStartExtra(this);
            lineStartExtra.stream_ = this.stream_;
            lineStartExtra.targetStream_ = this.targetStream_;
            lineStartExtra.conferenceId_ = this.conferenceId_;
            lineStartExtra.conferenceToken_ = this.conferenceToken_;
            lineStartExtra.targetToken_ = this.targetToken_;
            lineStartExtra.name_ = this.name_;
            lineStartExtra.uid_ = this.uid_;
            lineStartExtra.type_ = this.type_;
            onBuilt();
            return lineStartExtra;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.stream_ = "";
            this.targetStream_ = "";
            this.conferenceId_ = "";
            this.conferenceToken_ = "";
            this.targetToken_ = "";
            this.name_ = "";
            this.uid_ = 0;
            this.type_ = 0;
            return this;
        }

        public Builder clearConferenceId() {
            this.conferenceId_ = LineStartExtra.getDefaultInstance().getConferenceId();
            onChanged();
            return this;
        }

        public Builder clearConferenceToken() {
            this.conferenceToken_ = LineStartExtra.getDefaultInstance().getConferenceToken();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearName() {
            this.name_ = LineStartExtra.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearStream() {
            this.stream_ = LineStartExtra.getDefaultInstance().getStream();
            onChanged();
            return this;
        }

        public Builder clearTargetStream() {
            this.targetStream_ = LineStartExtra.getDefaultInstance().getTargetStream();
            onChanged();
            return this;
        }

        public Builder clearTargetToken() {
            this.targetToken_ = LineStartExtra.getDefaultInstance().getTargetToken();
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public String getConferenceId() {
            Object obj = this.conferenceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.conferenceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public ByteString getConferenceIdBytes() {
            Object obj = this.conferenceId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.conferenceId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public String getConferenceToken() {
            Object obj = this.conferenceToken_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.conferenceToken_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public ByteString getConferenceTokenBytes() {
            Object obj = this.conferenceToken_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.conferenceToken_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LineStartExtra getDefaultInstanceForType() {
            return LineStartExtra.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LineStartExtra_descriptor;
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public String getStream() {
            Object obj = this.stream_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.stream_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public ByteString getStreamBytes() {
            Object obj = this.stream_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.stream_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public String getTargetStream() {
            Object obj = this.targetStream_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetStream_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public ByteString getTargetStreamBytes() {
            Object obj = this.targetStream_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetStream_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public String getTargetToken() {
            Object obj = this.targetToken_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetToken_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public ByteString getTargetTokenBytes() {
            Object obj = this.targetToken_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetToken_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // cn.irisgw.live.LineStartExtraOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LineStartExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(LineStartExtra.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LineStartExtra lineStartExtra) {
            if (lineStartExtra == LineStartExtra.getDefaultInstance()) {
                return this;
            }
            if (!lineStartExtra.getStream().isEmpty()) {
                this.stream_ = lineStartExtra.stream_;
                onChanged();
            }
            if (!lineStartExtra.getTargetStream().isEmpty()) {
                this.targetStream_ = lineStartExtra.targetStream_;
                onChanged();
            }
            if (!lineStartExtra.getConferenceId().isEmpty()) {
                this.conferenceId_ = lineStartExtra.conferenceId_;
                onChanged();
            }
            if (!lineStartExtra.getConferenceToken().isEmpty()) {
                this.conferenceToken_ = lineStartExtra.conferenceToken_;
                onChanged();
            }
            if (!lineStartExtra.getTargetToken().isEmpty()) {
                this.targetToken_ = lineStartExtra.targetToken_;
                onChanged();
            }
            if (!lineStartExtra.getName().isEmpty()) {
                this.name_ = lineStartExtra.name_;
                onChanged();
            }
            if (lineStartExtra.getUid() != 0) {
                setUid(lineStartExtra.getUid());
            }
            if (lineStartExtra.getType() != 0) {
                setType(lineStartExtra.getType());
            }
            mergeUnknownFields(lineStartExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LineStartExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LineStartExtra.access$1300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LineStartExtra r0 = (cn.irisgw.live.LineStartExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LineStartExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LineStartExtra r0 = (cn.irisgw.live.LineStartExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LineStartExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LineStartExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LineStartExtra$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof LineStartExtra) {
                return mergeFrom((LineStartExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setConferenceId(String str) {
            if (str != null) {
                this.conferenceId_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setConferenceIdBytes(ByteString byteString) {
            if (byteString != null) {
                LineStartExtra.checkByteStringIsUtf8(byteString);
                this.conferenceId_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setConferenceToken(String str) {
            if (str != null) {
                this.conferenceToken_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setConferenceTokenBytes(ByteString byteString) {
            if (byteString != null) {
                LineStartExtra.checkByteStringIsUtf8(byteString);
                this.conferenceToken_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
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
                LineStartExtra.checkByteStringIsUtf8(byteString);
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

        public Builder setStream(String str) {
            if (str != null) {
                this.stream_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setStreamBytes(ByteString byteString) {
            if (byteString != null) {
                LineStartExtra.checkByteStringIsUtf8(byteString);
                this.stream_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTargetStream(String str) {
            if (str != null) {
                this.targetStream_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTargetStreamBytes(ByteString byteString) {
            if (byteString != null) {
                LineStartExtra.checkByteStringIsUtf8(byteString);
                this.targetStream_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTargetToken(String str) {
            if (str != null) {
                this.targetToken_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTargetTokenBytes(ByteString byteString) {
            if (byteString != null) {
                LineStartExtra.checkByteStringIsUtf8(byteString);
                this.targetToken_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setType(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LineStartExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.stream_ = "";
        this.targetStream_ = "";
        this.conferenceId_ = "";
        this.conferenceToken_ = "";
        this.targetToken_ = "";
        this.name_ = "";
    }

    private LineStartExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.stream_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            this.targetStream_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 26) {
                            this.conferenceId_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 34) {
                            this.conferenceToken_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 42) {
                            this.targetToken_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 50) {
                            this.name_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 56) {
                            this.uid_ = codedInputStream.readUInt32();
                        } else if (readTag == 64) {
                            this.type_ = codedInputStream.readUInt32();
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

    private LineStartExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LineStartExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LineStartExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(LineStartExtra lineStartExtra) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(lineStartExtra);
    }

    public static LineStartExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LineStartExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LineStartExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LineStartExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LineStartExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static LineStartExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LineStartExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LineStartExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LineStartExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LineStartExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LineStartExtra parseFrom(InputStream inputStream) throws IOException {
        return (LineStartExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LineStartExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LineStartExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LineStartExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static LineStartExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LineStartExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LineStartExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LineStartExtra> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LineStartExtra) {
            LineStartExtra lineStartExtra = (LineStartExtra) obj;
            return getStream().equals(lineStartExtra.getStream()) && getTargetStream().equals(lineStartExtra.getTargetStream()) && getConferenceId().equals(lineStartExtra.getConferenceId()) && getConferenceToken().equals(lineStartExtra.getConferenceToken()) && getTargetToken().equals(lineStartExtra.getTargetToken()) && getName().equals(lineStartExtra.getName()) && getUid() == lineStartExtra.getUid() && getType() == lineStartExtra.getType() && this.unknownFields.equals(lineStartExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
    public String getConferenceId() {
        Object obj = this.conferenceId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.conferenceId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
    public ByteString getConferenceIdBytes() {
        Object obj = this.conferenceId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.conferenceId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
    public String getConferenceToken() {
        Object obj = this.conferenceToken_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.conferenceToken_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
    public ByteString getConferenceTokenBytes() {
        Object obj = this.conferenceToken_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.conferenceToken_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public LineStartExtra getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
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
    public Parser<LineStartExtra> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getStreamBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.stream_);
        }
        int i3 = i2;
        if (!getTargetStreamBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.targetStream_);
        }
        int i4 = i3;
        if (!getConferenceIdBytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.conferenceId_);
        }
        int i5 = i4;
        if (!getConferenceTokenBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.conferenceToken_);
        }
        int i6 = i5;
        if (!getTargetTokenBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.targetToken_);
        }
        int i7 = i6;
        if (!getNameBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(6, this.name_);
        }
        int i8 = this.uid_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(7, i8);
        }
        int i10 = this.type_;
        int i11 = i9;
        if (i10 != 0) {
            i11 = i9 + CodedOutputStream.computeUInt32Size(8, i10);
        }
        int serializedSize = i11 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
    public String getStream() {
        Object obj = this.stream_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.stream_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
    public ByteString getStreamBytes() {
        Object obj = this.stream_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.stream_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
    public String getTargetStream() {
        Object obj = this.targetStream_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.targetStream_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
    public ByteString getTargetStreamBytes() {
        Object obj = this.targetStream_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.targetStream_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
    public String getTargetToken() {
        Object obj = this.targetToken_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.targetToken_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
    public ByteString getTargetTokenBytes() {
        Object obj = this.targetToken_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.targetToken_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
    public int getType() {
        return this.type_;
    }

    @Override // cn.irisgw.live.LineStartExtraOrBuilder
    public int getUid() {
        return this.uid_;
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
        int hashCode = ((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getStream().hashCode()) * 37) + 2) * 53) + getTargetStream().hashCode()) * 37) + 3) * 53) + getConferenceId().hashCode()) * 37) + 4) * 53) + getConferenceToken().hashCode()) * 37) + 5) * 53) + getTargetToken().hashCode()) * 37) + 6) * 53) + getName().hashCode()) * 37) + 7) * 53) + getUid()) * 37) + 8) * 53) + getType()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LineStartExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(LineStartExtra.class, Builder.class);
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
        return new LineStartExtra();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getStreamBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.stream_);
        }
        if (!getTargetStreamBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.targetStream_);
        }
        if (!getConferenceIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.conferenceId_);
        }
        if (!getConferenceTokenBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.conferenceToken_);
        }
        if (!getTargetTokenBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.targetToken_);
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.name_);
        }
        int i = this.uid_;
        if (i != 0) {
            codedOutputStream.writeUInt32(7, i);
        }
        int i2 = this.type_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(8, i2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
