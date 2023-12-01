package cn.irisgw.live;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxExtra.class */
public final class BoxExtra extends GeneratedMessageV3 implements BoxExtraOrBuilder {
    public static final int BOXES_FIELD_NUMBER = 1;
    private static final BoxExtra DEFAULT_INSTANCE = new BoxExtra();
    private static final Parser<BoxExtra> PARSER = new AbstractParser<BoxExtra>() { // from class: cn.irisgw.live.BoxExtra.1
        /* renamed from: parsePartialFrom */
        public BoxExtra m625parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new BoxExtra(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private List<Box> boxes_;
    private byte memoizedIsInitialized;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxExtra$Box.class */
    public static final class Box extends GeneratedMessageV3 implements BoxOrBuilder {
        public static final int BOX_GIF_FIELD_NUMBER = 8;
        public static final int BOX_ID_FIELD_NUMBER = 2;
        public static final int BOX_IMAGE_FIELD_NUMBER = 3;
        public static final int DURATION_FIELD_NUMBER = 6;
        public static final int INDEX_FIELD_NUMBER = 7;
        public static final int PROGRESS_FIELD_NUMBER = 4;
        public static final int PROGRESS_FULL_GIF_FIELD_NUMBER = 5;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object boxGif_;
        private volatile Object boxId_;
        private volatile Object boxImage_;
        private int duration_;
        private int index_;
        private byte memoizedIsInitialized;
        private volatile Object progressFullGif_;
        private int progress_;
        private int type_;
        private static final Box DEFAULT_INSTANCE = new Box();
        private static final Parser<Box> PARSER = new AbstractParser<Box>() { // from class: cn.irisgw.live.BoxExtra.Box.1
            /* renamed from: parsePartialFrom */
            public Box m634parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Box(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxExtra$Box$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BoxOrBuilder {
            private Object boxGif_;
            private Object boxId_;
            private Object boxImage_;
            private int duration_;
            private int index_;
            private Object progressFullGif_;
            private int progress_;
            private int type_;

            private Builder() {
                this.boxId_ = "";
                this.boxImage_ = "";
                this.progressFullGif_ = "";
                this.boxGif_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.boxId_ = "";
                this.boxImage_ = "";
                this.progressFullGif_ = "";
                this.boxGif_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_BoxExtra_Box_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Box.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m636addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public Box m638build() {
                Box m640buildPartial = m640buildPartial();
                if (m640buildPartial.isInitialized()) {
                    return m640buildPartial;
                }
                throw newUninitializedMessageException(m640buildPartial);
            }

            /* renamed from: buildPartial */
            public Box m640buildPartial() {
                Box box = new Box(this);
                box.type_ = this.type_;
                box.boxId_ = this.boxId_;
                box.boxImage_ = this.boxImage_;
                box.progress_ = this.progress_;
                box.progressFullGif_ = this.progressFullGif_;
                box.duration_ = this.duration_;
                box.index_ = this.index_;
                box.boxGif_ = this.boxGif_;
                onBuilt();
                return box;
            }

            /* renamed from: clear */
            public Builder m644clear() {
                super.clear();
                this.type_ = 0;
                this.boxId_ = "";
                this.boxImage_ = "";
                this.progress_ = 0;
                this.progressFullGif_ = "";
                this.duration_ = 0;
                this.index_ = 0;
                this.boxGif_ = "";
                return this;
            }

            public Builder clearBoxGif() {
                this.boxGif_ = Box.getDefaultInstance().getBoxGif();
                onChanged();
                return this;
            }

            public Builder clearBoxId() {
                this.boxId_ = Box.getDefaultInstance().getBoxId();
                onChanged();
                return this;
            }

            public Builder clearBoxImage() {
                this.boxImage_ = Box.getDefaultInstance().getBoxImage();
                onChanged();
                return this;
            }

            public Builder clearDuration() {
                this.duration_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m646clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m649clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearProgress() {
                this.progress_ = 0;
                onChanged();
                return this;
            }

            public Builder clearProgressFullGif() {
                this.progressFullGif_ = Box.getDefaultInstance().getProgressFullGif();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m655clone() {
                return (Builder) super.clone();
            }

            @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
            public String getBoxGif() {
                Object obj = this.boxGif_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.boxGif_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
            public ByteString getBoxGifBytes() {
                Object obj = this.boxGif_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.boxGif_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
            public String getBoxId() {
                Object obj = this.boxId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.boxId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
            public ByteString getBoxIdBytes() {
                Object obj = this.boxId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.boxId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
            public String getBoxImage() {
                Object obj = this.boxImage_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.boxImage_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
            public ByteString getBoxImageBytes() {
                Object obj = this.boxImage_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.boxImage_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            /* renamed from: getDefaultInstanceForType */
            public Box m657getDefaultInstanceForType() {
                return Box.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_BoxExtra_Box_descriptor;
            }

            @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
            public int getDuration() {
                return this.duration_;
            }

            @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
            public int getIndex() {
                return this.index_;
            }

            @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
            public int getProgress() {
                return this.progress_;
            }

            @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
            public String getProgressFullGif() {
                Object obj = this.progressFullGif_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.progressFullGif_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
            public ByteString getProgressFullGifBytes() {
                Object obj = this.progressFullGif_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.progressFullGif_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
            public int getType() {
                return this.type_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_BoxExtra_Box_fieldAccessorTable.ensureFieldAccessorsInitialized(Box.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Box box) {
                if (box == Box.getDefaultInstance()) {
                    return this;
                }
                if (box.getType() != 0) {
                    setType(box.getType());
                }
                if (!box.getBoxId().isEmpty()) {
                    this.boxId_ = box.boxId_;
                    onChanged();
                }
                if (!box.getBoxImage().isEmpty()) {
                    this.boxImage_ = box.boxImage_;
                    onChanged();
                }
                if (box.getProgress() != 0) {
                    setProgress(box.getProgress());
                }
                if (!box.getProgressFullGif().isEmpty()) {
                    this.progressFullGif_ = box.progressFullGif_;
                    onChanged();
                }
                if (box.getDuration() != 0) {
                    setDuration(box.getDuration());
                }
                if (box.getIndex() != 0) {
                    setIndex(box.getIndex());
                }
                if (!box.getBoxGif().isEmpty()) {
                    this.boxGif_ = box.boxGif_;
                    onChanged();
                }
                m666mergeUnknownFields(box.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.BoxExtra.Box.Builder m663mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.BoxExtra.Box.access$1300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.BoxExtra$Box r0 = (cn.irisgw.live.BoxExtra.Box) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.BoxExtra$Box$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.BoxExtra$Box r0 = (cn.irisgw.live.BoxExtra.Box) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.BoxExtra$Box$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.BoxExtra.Box.Builder.m663mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.BoxExtra$Box$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m662mergeFrom(Message message) {
                if (message instanceof Box) {
                    return mergeFrom((Box) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m666mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBoxGif(String str) {
                if (str != null) {
                    this.boxGif_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBoxGifBytes(ByteString byteString) {
                if (byteString != null) {
                    Box.checkByteStringIsUtf8(byteString);
                    this.boxGif_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBoxId(String str) {
                if (str != null) {
                    this.boxId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBoxIdBytes(ByteString byteString) {
                if (byteString != null) {
                    Box.checkByteStringIsUtf8(byteString);
                    this.boxId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBoxImage(String str) {
                if (str != null) {
                    this.boxImage_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBoxImageBytes(ByteString byteString) {
                if (byteString != null) {
                    Box.checkByteStringIsUtf8(byteString);
                    this.boxImage_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDuration(int i) {
                this.duration_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setField */
            public Builder m668setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setIndex(int i) {
                this.index_ = i;
                onChanged();
                return this;
            }

            public Builder setProgress(int i) {
                this.progress_ = i;
                onChanged();
                return this;
            }

            public Builder setProgressFullGif(String str) {
                if (str != null) {
                    this.progressFullGif_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setProgressFullGifBytes(ByteString byteString) {
                if (byteString != null) {
                    Box.checkByteStringIsUtf8(byteString);
                    this.progressFullGif_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setRepeatedField */
            public Builder m670setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setType(int i) {
                this.type_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setUnknownFields */
            public final Builder m672setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Box() {
            this.memoizedIsInitialized = (byte) -1;
            this.boxId_ = "";
            this.boxImage_ = "";
            this.progressFullGif_ = "";
            this.boxGif_ = "";
        }

        private Box(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.type_ = codedInputStream.readUInt32();
                            } else if (readTag == 18) {
                                this.boxId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.boxImage_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.progress_ = codedInputStream.readUInt32();
                            } else if (readTag == 42) {
                                this.progressFullGif_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 48) {
                                this.duration_ = codedInputStream.readUInt32();
                            } else if (readTag == 56) {
                                this.index_ = codedInputStream.readUInt32();
                            } else if (readTag == 66) {
                                this.boxGif_ = codedInputStream.readStringRequireUtf8();
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

        private Box(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Box getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_BoxExtra_Box_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m633toBuilder();
        }

        public static Builder newBuilder(Box box) {
            return DEFAULT_INSTANCE.m633toBuilder().mergeFrom(box);
        }

        public static Box parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Box parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Box parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Box) PARSER.parseFrom(byteString);
        }

        public static Box parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Box) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Box parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Box parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Box parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Box parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Box parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Box) PARSER.parseFrom(byteBuffer);
        }

        public static Box parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Box) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Box parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Box) PARSER.parseFrom(bArr);
        }

        public static Box parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Box) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Box> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Box) {
                Box box = (Box) obj;
                return getType() == box.getType() && getBoxId().equals(box.getBoxId()) && getBoxImage().equals(box.getBoxImage()) && getProgress() == box.getProgress() && getProgressFullGif().equals(box.getProgressFullGif()) && getDuration() == box.getDuration() && getIndex() == box.getIndex() && getBoxGif().equals(box.getBoxGif()) && this.unknownFields.equals(box.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
        public String getBoxGif() {
            Object obj = this.boxGif_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.boxGif_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
        public ByteString getBoxGifBytes() {
            Object obj = this.boxGif_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.boxGif_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
        public String getBoxId() {
            Object obj = this.boxId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.boxId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
        public ByteString getBoxIdBytes() {
            Object obj = this.boxId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.boxId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
        public String getBoxImage() {
            Object obj = this.boxImage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.boxImage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
        public ByteString getBoxImageBytes() {
            Object obj = this.boxImage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.boxImage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* renamed from: getDefaultInstanceForType */
        public Box m628getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
        public int getDuration() {
            return this.duration_;
        }

        @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
        public int getIndex() {
            return this.index_;
        }

        public Parser<Box> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
        public int getProgress() {
            return this.progress_;
        }

        @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
        public String getProgressFullGif() {
            Object obj = this.progressFullGif_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.progressFullGif_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
        public ByteString getProgressFullGifBytes() {
            Object obj = this.progressFullGif_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.progressFullGif_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.type_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
            }
            int i4 = i2;
            if (!getBoxIdBytes().isEmpty()) {
                i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.boxId_);
            }
            int i5 = i4;
            if (!getBoxImageBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.boxImage_);
            }
            int i6 = this.progress_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeUInt32Size(4, i6);
            }
            int i8 = i7;
            if (!getProgressFullGifBytes().isEmpty()) {
                i8 = i7 + GeneratedMessageV3.computeStringSize(5, this.progressFullGif_);
            }
            int i9 = this.duration_;
            int i10 = i8;
            if (i9 != 0) {
                i10 = i8 + CodedOutputStream.computeUInt32Size(6, i9);
            }
            int i11 = this.index_;
            int i12 = i10;
            if (i11 != 0) {
                i12 = i10 + CodedOutputStream.computeUInt32Size(7, i11);
            }
            int i13 = i12;
            if (!getBoxGifBytes().isEmpty()) {
                i13 = i12 + GeneratedMessageV3.computeStringSize(8, this.boxGif_);
            }
            int serializedSize = i13 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.BoxExtra.BoxOrBuilder
        public int getType() {
            return this.type_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getType()) * 37) + 2) * 53) + getBoxId().hashCode()) * 37) + 3) * 53) + getBoxImage().hashCode()) * 37) + 4) * 53) + getProgress()) * 37) + 5) * 53) + getProgressFullGif().hashCode()) * 37) + 6) * 53) + getDuration()) * 37) + 7) * 53) + getIndex()) * 37) + 8) * 53) + getBoxGif().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_BoxExtra_Box_fieldAccessorTable.ensureFieldAccessorsInitialized(Box.class, Builder.class);
        }

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

        /* renamed from: newBuilderForType */
        public Builder m631newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m630newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Box();
        }

        /* renamed from: toBuilder */
        public Builder m633toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.type_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (!getBoxIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.boxId_);
            }
            if (!getBoxImageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.boxImage_);
            }
            int i2 = this.progress_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(4, i2);
            }
            if (!getProgressFullGifBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.progressFullGif_);
            }
            int i3 = this.duration_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(6, i3);
            }
            int i4 = this.index_;
            if (i4 != 0) {
                codedOutputStream.writeUInt32(7, i4);
            }
            if (!getBoxGifBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.boxGif_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxExtra$BoxOrBuilder.class */
    public interface BoxOrBuilder extends MessageOrBuilder {
        String getBoxGif();

        ByteString getBoxGifBytes();

        String getBoxId();

        ByteString getBoxIdBytes();

        String getBoxImage();

        ByteString getBoxImageBytes();

        int getDuration();

        int getIndex();

        int getProgress();

        String getProgressFullGif();

        ByteString getProgressFullGifBytes();

        int getType();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BoxExtraOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> boxesBuilder_;
        private List<Box> boxes_;

        private Builder() {
            this.boxes_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.boxes_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureBoxesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.boxes_ = new ArrayList(this.boxes_);
                this.bitField0_ |= 1;
            }
        }

        private RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> getBoxesFieldBuilder() {
            if (this.boxesBuilder_ == null) {
                List<Box> list = this.boxes_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.boxesBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.boxes_ = null;
            }
            return this.boxesBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_BoxExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            if (BoxExtra.alwaysUseFieldBuilders) {
                getBoxesFieldBuilder();
            }
        }

        public Builder addAllBoxes(Iterable<? extends Box> iterable) {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureBoxesIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.boxes_);
            onChanged();
            return this;
        }

        public Builder addBoxes(int i, Box.Builder builder) {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m638build());
                return this;
            }
            ensureBoxesIsMutable();
            this.boxes_.add(i, builder.m638build());
            onChanged();
            return this;
        }

        public Builder addBoxes(int i, Box box) {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, box);
                return this;
            } else if (box != null) {
                ensureBoxesIsMutable();
                this.boxes_.add(i, box);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addBoxes(Box.Builder builder) {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m638build());
                return this;
            }
            ensureBoxesIsMutable();
            this.boxes_.add(builder.m638build());
            onChanged();
            return this;
        }

        public Builder addBoxes(Box box) {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(box);
                return this;
            } else if (box != null) {
                ensureBoxesIsMutable();
                this.boxes_.add(box);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Box.Builder addBoxesBuilder() {
            return getBoxesFieldBuilder().addBuilder(Box.getDefaultInstance());
        }

        public Box.Builder addBoxesBuilder(int i) {
            return getBoxesFieldBuilder().addBuilder(i, Box.getDefaultInstance());
        }

        /* renamed from: addRepeatedField */
        public Builder m674addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public BoxExtra m676build() {
            BoxExtra m678buildPartial = m678buildPartial();
            if (m678buildPartial.isInitialized()) {
                return m678buildPartial;
            }
            throw newUninitializedMessageException(m678buildPartial);
        }

        /* renamed from: buildPartial */
        public BoxExtra m678buildPartial() {
            BoxExtra boxExtra = new BoxExtra(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.boxes_ = Collections.unmodifiableList(this.boxes_);
                    this.bitField0_ &= -2;
                }
                boxExtra.boxes_ = this.boxes_;
            } else {
                boxExtra.boxes_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return boxExtra;
        }

        /* renamed from: clear */
        public Builder m682clear() {
            super.clear();
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.boxes_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        public Builder clearBoxes() {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.boxes_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m684clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m687clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m693clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.BoxExtraOrBuilder
        public Box getBoxes(int i) {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.boxes_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Box.Builder getBoxesBuilder(int i) {
            return getBoxesFieldBuilder().getBuilder(i);
        }

        public List<Box.Builder> getBoxesBuilderList() {
            return getBoxesFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.BoxExtraOrBuilder
        public int getBoxesCount() {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.boxes_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.BoxExtraOrBuilder
        public List<Box> getBoxesList() {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.boxes_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.BoxExtraOrBuilder
        public BoxOrBuilder getBoxesOrBuilder(int i) {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.boxes_.get(i) : (BoxOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.BoxExtraOrBuilder
        public List<? extends BoxOrBuilder> getBoxesOrBuilderList() {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.boxes_);
        }

        /* renamed from: getDefaultInstanceForType */
        public BoxExtra m695getDefaultInstanceForType() {
            return BoxExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_BoxExtra_descriptor;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_BoxExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(BoxExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(BoxExtra boxExtra) {
            if (boxExtra == BoxExtra.getDefaultInstance()) {
                return this;
            }
            if (this.boxesBuilder_ == null) {
                if (!boxExtra.boxes_.isEmpty()) {
                    if (this.boxes_.isEmpty()) {
                        this.boxes_ = boxExtra.boxes_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureBoxesIsMutable();
                        this.boxes_.addAll(boxExtra.boxes_);
                    }
                    onChanged();
                }
            } else if (!boxExtra.boxes_.isEmpty()) {
                if (this.boxesBuilder_.isEmpty()) {
                    this.boxesBuilder_.dispose();
                    RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = null;
                    this.boxesBuilder_ = null;
                    this.boxes_ = boxExtra.boxes_;
                    this.bitField0_ &= -2;
                    if (BoxExtra.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getBoxesFieldBuilder();
                    }
                    this.boxesBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.boxesBuilder_.addAllMessages(boxExtra.boxes_);
                }
            }
            m704mergeUnknownFields(boxExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.BoxExtra.Builder m701mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.BoxExtra.access$2600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.BoxExtra r0 = (cn.irisgw.live.BoxExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.BoxExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.BoxExtra r0 = (cn.irisgw.live.BoxExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.BoxExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.BoxExtra.Builder.m701mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.BoxExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m700mergeFrom(Message message) {
            if (message instanceof BoxExtra) {
                return mergeFrom((BoxExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m704mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeBoxes(int i) {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureBoxesIsMutable();
            this.boxes_.remove(i);
            onChanged();
            return this;
        }

        public Builder setBoxes(int i, Box.Builder builder) {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m638build());
                return this;
            }
            ensureBoxesIsMutable();
            this.boxes_.set(i, builder.m638build());
            onChanged();
            return this;
        }

        public Builder setBoxes(int i, Box box) {
            RepeatedFieldBuilderV3<Box, Box.Builder, BoxOrBuilder> repeatedFieldBuilderV3 = this.boxesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, box);
                return this;
            } else if (box != null) {
                ensureBoxesIsMutable();
                this.boxes_.set(i, box);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        /* renamed from: setField */
        public Builder m706setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m708setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m710setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private BoxExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.boxes_ = Collections.emptyList();
    }

    private BoxExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw null;
        }
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            boolean z3 = z2;
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.boxes_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.boxes_.add((Box) codedInputStream.readMessage(Box.parser(), extensionRegistryLite));
                            z2 = z4;
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.boxes_ = Collections.unmodifiableList(this.boxes_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.boxes_ = Collections.unmodifiableList(this.boxes_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private BoxExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static BoxExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_BoxExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m624toBuilder();
    }

    public static Builder newBuilder(BoxExtra boxExtra) {
        return DEFAULT_INSTANCE.m624toBuilder().mergeFrom(boxExtra);
    }

    public static BoxExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static BoxExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BoxExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BoxExtra) PARSER.parseFrom(byteString);
    }

    public static BoxExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BoxExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BoxExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static BoxExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static BoxExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static BoxExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BoxExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BoxExtra) PARSER.parseFrom(byteBuffer);
    }

    public static BoxExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BoxExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static BoxExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BoxExtra) PARSER.parseFrom(bArr);
    }

    public static BoxExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BoxExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<BoxExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BoxExtra) {
            BoxExtra boxExtra = (BoxExtra) obj;
            return getBoxesList().equals(boxExtra.getBoxesList()) && this.unknownFields.equals(boxExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.BoxExtraOrBuilder
    public Box getBoxes(int i) {
        return this.boxes_.get(i);
    }

    @Override // cn.irisgw.live.BoxExtraOrBuilder
    public int getBoxesCount() {
        return this.boxes_.size();
    }

    @Override // cn.irisgw.live.BoxExtraOrBuilder
    public List<Box> getBoxesList() {
        return this.boxes_;
    }

    @Override // cn.irisgw.live.BoxExtraOrBuilder
    public BoxOrBuilder getBoxesOrBuilder(int i) {
        return this.boxes_.get(i);
    }

    @Override // cn.irisgw.live.BoxExtraOrBuilder
    public List<? extends BoxOrBuilder> getBoxesOrBuilderList() {
        return this.boxes_;
    }

    /* renamed from: getDefaultInstanceForType */
    public BoxExtra m619getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<BoxExtra> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.boxes_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.boxes_.get(i3));
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (getBoxesCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getBoxesList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_BoxExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(BoxExtra.class, Builder.class);
    }

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

    /* renamed from: newBuilderForType */
    public Builder m622newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m621newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new BoxExtra();
    }

    /* renamed from: toBuilder */
    public Builder m624toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.boxes_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(1, this.boxes_.get(i2));
                i = i2 + 1;
            }
        }
    }
}
