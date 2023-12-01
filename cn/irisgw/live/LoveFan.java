package cn.irisgw.live;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LoveFan.class */
public final class LoveFan extends GeneratedMessageV3 implements LoveFanOrBuilder {
    public static final int AVATAR_FIELD_NUMBER = 3;
    public static final int IS_FOLLOWED_FIELD_NUMBER = 7;
    public static final int LAMP_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int PIC_FIELD_NUMBER = 5;
    public static final int STREAM_FIELD_NUMBER = 8;
    public static final int UID_FIELD_NUMBER = 1;
    public static final int VOICE_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private volatile Object avatar_;
    private boolean isFollowed_;
    private boolean lamp_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private volatile Object pic_;
    private volatile Object stream_;
    private int uid_;
    private boolean voice_;
    private static final LoveFan DEFAULT_INSTANCE = new LoveFan();
    private static final Parser<LoveFan> PARSER = new AbstractParser<LoveFan>() { // from class: cn.irisgw.live.LoveFan.1
        /* renamed from: parsePartialFrom */
        public LoveFan m5283parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LoveFan(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LoveFan$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LoveFanOrBuilder {
        private Object avatar_;
        private boolean isFollowed_;
        private boolean lamp_;
        private Object name_;
        private Object pic_;
        private Object stream_;
        private int uid_;
        private boolean voice_;

        private Builder() {
            this.name_ = "";
            this.avatar_ = "";
            this.pic_ = "";
            this.stream_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.avatar_ = "";
            this.pic_ = "";
            this.stream_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveFan_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LoveFan.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m5285addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LoveFan m5287build() {
            LoveFan m5289buildPartial = m5289buildPartial();
            if (m5289buildPartial.isInitialized()) {
                return m5289buildPartial;
            }
            throw newUninitializedMessageException(m5289buildPartial);
        }

        /* renamed from: buildPartial */
        public LoveFan m5289buildPartial() {
            LoveFan loveFan = new LoveFan(this);
            loveFan.uid_ = this.uid_;
            loveFan.name_ = this.name_;
            loveFan.avatar_ = this.avatar_;
            loveFan.voice_ = this.voice_;
            loveFan.pic_ = this.pic_;
            loveFan.lamp_ = this.lamp_;
            loveFan.isFollowed_ = this.isFollowed_;
            loveFan.stream_ = this.stream_;
            onBuilt();
            return loveFan;
        }

        /* renamed from: clear */
        public Builder m5293clear() {
            super.clear();
            this.uid_ = 0;
            this.name_ = "";
            this.avatar_ = "";
            this.voice_ = false;
            this.pic_ = "";
            this.lamp_ = false;
            this.isFollowed_ = false;
            this.stream_ = "";
            return this;
        }

        public Builder clearAvatar() {
            this.avatar_ = LoveFan.getDefaultInstance().getAvatar();
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m5295clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearIsFollowed() {
            this.isFollowed_ = false;
            onChanged();
            return this;
        }

        public Builder clearLamp() {
            this.lamp_ = false;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = LoveFan.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m5298clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPic() {
            this.pic_ = LoveFan.getDefaultInstance().getPic();
            onChanged();
            return this;
        }

        public Builder clearStream() {
            this.stream_ = LoveFan.getDefaultInstance().getStream();
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearVoice() {
            this.voice_ = false;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m5304clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.LoveFanOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LoveFanOrBuilder
        public ByteString getAvatarBytes() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* renamed from: getDefaultInstanceForType */
        public LoveFan m5306getDefaultInstanceForType() {
            return LoveFan.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveFan_descriptor;
        }

        @Override // cn.irisgw.live.LoveFanOrBuilder
        public boolean getIsFollowed() {
            return this.isFollowed_;
        }

        @Override // cn.irisgw.live.LoveFanOrBuilder
        public boolean getLamp() {
            return this.lamp_;
        }

        @Override // cn.irisgw.live.LoveFanOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LoveFanOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LoveFanOrBuilder
        public String getPic() {
            Object obj = this.pic_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.pic_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LoveFanOrBuilder
        public ByteString getPicBytes() {
            Object obj = this.pic_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.pic_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LoveFanOrBuilder
        public String getStream() {
            Object obj = this.stream_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.stream_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LoveFanOrBuilder
        public ByteString getStreamBytes() {
            Object obj = this.stream_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.stream_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LoveFanOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // cn.irisgw.live.LoveFanOrBuilder
        public boolean getVoice() {
            return this.voice_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveFan_fieldAccessorTable.ensureFieldAccessorsInitialized(LoveFan.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LoveFan loveFan) {
            if (loveFan == LoveFan.getDefaultInstance()) {
                return this;
            }
            if (loveFan.getUid() != 0) {
                setUid(loveFan.getUid());
            }
            if (!loveFan.getName().isEmpty()) {
                this.name_ = loveFan.name_;
                onChanged();
            }
            if (!loveFan.getAvatar().isEmpty()) {
                this.avatar_ = loveFan.avatar_;
                onChanged();
            }
            if (loveFan.getVoice()) {
                setVoice(loveFan.getVoice());
            }
            if (!loveFan.getPic().isEmpty()) {
                this.pic_ = loveFan.pic_;
                onChanged();
            }
            if (loveFan.getLamp()) {
                setLamp(loveFan.getLamp());
            }
            if (loveFan.getIsFollowed()) {
                setIsFollowed(loveFan.getIsFollowed());
            }
            if (!loveFan.getStream().isEmpty()) {
                this.stream_ = loveFan.stream_;
                onChanged();
            }
            m5315mergeUnknownFields(loveFan.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LoveFan.Builder m5312mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LoveFan.access$1300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LoveFan r0 = (cn.irisgw.live.LoveFan) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LoveFan$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LoveFan r0 = (cn.irisgw.live.LoveFan) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LoveFan$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LoveFan.Builder.m5312mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LoveFan$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m5311mergeFrom(Message message) {
            if (message instanceof LoveFan) {
                return mergeFrom((LoveFan) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m5315mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setAvatar(String str) {
            if (str != null) {
                this.avatar_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAvatarBytes(ByteString byteString) {
            if (byteString != null) {
                LoveFan.checkByteStringIsUtf8(byteString);
                this.avatar_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setField */
        public Builder m5317setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setIsFollowed(boolean z) {
            this.isFollowed_ = z;
            onChanged();
            return this;
        }

        public Builder setLamp(boolean z) {
            this.lamp_ = z;
            onChanged();
            return this;
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
                LoveFan.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPic(String str) {
            if (str != null) {
                this.pic_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPicBytes(ByteString byteString) {
            if (byteString != null) {
                LoveFan.checkByteStringIsUtf8(byteString);
                this.pic_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setRepeatedField */
        public Builder m5319setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
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
                LoveFan.checkByteStringIsUtf8(byteString);
                this.stream_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m5321setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setVoice(boolean z) {
            this.voice_ = z;
            onChanged();
            return this;
        }
    }

    private LoveFan() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.avatar_ = "";
        this.pic_ = "";
        this.stream_ = "";
    }

    private LoveFan(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.uid_ = codedInputStream.readUInt32();
                        } else if (readTag == 18) {
                            this.name_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 26) {
                            this.avatar_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 32) {
                            this.voice_ = codedInputStream.readBool();
                        } else if (readTag == 42) {
                            this.pic_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 48) {
                            this.lamp_ = codedInputStream.readBool();
                        } else if (readTag == 56) {
                            this.isFollowed_ = codedInputStream.readBool();
                        } else if (readTag == 66) {
                            this.stream_ = codedInputStream.readStringRequireUtf8();
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

    private LoveFan(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LoveFan getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LoveFan_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m5282toBuilder();
    }

    public static Builder newBuilder(LoveFan loveFan) {
        return DEFAULT_INSTANCE.m5282toBuilder().mergeFrom(loveFan);
    }

    public static LoveFan parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LoveFan parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LoveFan parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LoveFan) PARSER.parseFrom(byteString);
    }

    public static LoveFan parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoveFan) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LoveFan parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LoveFan parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LoveFan parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LoveFan parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LoveFan parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LoveFan) PARSER.parseFrom(byteBuffer);
    }

    public static LoveFan parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoveFan) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LoveFan parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LoveFan) PARSER.parseFrom(bArr);
    }

    public static LoveFan parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoveFan) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LoveFan> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoveFan) {
            LoveFan loveFan = (LoveFan) obj;
            return getUid() == loveFan.getUid() && getName().equals(loveFan.getName()) && getAvatar().equals(loveFan.getAvatar()) && getVoice() == loveFan.getVoice() && getPic().equals(loveFan.getPic()) && getLamp() == loveFan.getLamp() && getIsFollowed() == loveFan.getIsFollowed() && getStream().equals(loveFan.getStream()) && this.unknownFields.equals(loveFan.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LoveFanOrBuilder
    public String getAvatar() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatar_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LoveFanOrBuilder
    public ByteString getAvatarBytes() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.avatar_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    /* renamed from: getDefaultInstanceForType */
    public LoveFan m5277getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LoveFanOrBuilder
    public boolean getIsFollowed() {
        return this.isFollowed_;
    }

    @Override // cn.irisgw.live.LoveFanOrBuilder
    public boolean getLamp() {
        return this.lamp_;
    }

    @Override // cn.irisgw.live.LoveFanOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LoveFanOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<LoveFan> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.LoveFanOrBuilder
    public String getPic() {
        Object obj = this.pic_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.pic_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LoveFanOrBuilder
    public ByteString getPicBytes() {
        Object obj = this.pic_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.pic_ = copyFromUtf8;
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
        int i3 = this.uid_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = i2;
        if (!getNameBytes().isEmpty()) {
            i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.name_);
        }
        int i5 = i4;
        if (!getAvatarBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.avatar_);
        }
        boolean z = this.voice_;
        int i6 = i5;
        if (z) {
            i6 = i5 + CodedOutputStream.computeBoolSize(4, z);
        }
        int i7 = i6;
        if (!getPicBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.pic_);
        }
        boolean z2 = this.lamp_;
        int i8 = i7;
        if (z2) {
            i8 = i7 + CodedOutputStream.computeBoolSize(6, z2);
        }
        boolean z3 = this.isFollowed_;
        int i9 = i8;
        if (z3) {
            i9 = i8 + CodedOutputStream.computeBoolSize(7, z3);
        }
        int i10 = i9;
        if (!getStreamBytes().isEmpty()) {
            i10 = i9 + GeneratedMessageV3.computeStringSize(8, this.stream_);
        }
        int serializedSize = i10 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.LoveFanOrBuilder
    public String getStream() {
        Object obj = this.stream_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.stream_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LoveFanOrBuilder
    public ByteString getStreamBytes() {
        Object obj = this.stream_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.stream_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LoveFanOrBuilder
    public int getUid() {
        return this.uid_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.LoveFanOrBuilder
    public boolean getVoice() {
        return this.voice_;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getName().hashCode()) * 37) + 3) * 53) + getAvatar().hashCode()) * 37) + 4) * 53) + Internal.hashBoolean(getVoice())) * 37) + 5) * 53) + getPic().hashCode()) * 37) + 6) * 53) + Internal.hashBoolean(getLamp())) * 37) + 7) * 53) + Internal.hashBoolean(getIsFollowed())) * 37) + 8) * 53) + getStream().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LoveFan_fieldAccessorTable.ensureFieldAccessorsInitialized(LoveFan.class, Builder.class);
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
    public Builder m5280newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m5279newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LoveFan();
    }

    /* renamed from: toBuilder */
    public Builder m5282toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.uid_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.name_);
        }
        if (!getAvatarBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.avatar_);
        }
        boolean z = this.voice_;
        if (z) {
            codedOutputStream.writeBool(4, z);
        }
        if (!getPicBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.pic_);
        }
        boolean z2 = this.lamp_;
        if (z2) {
            codedOutputStream.writeBool(6, z2);
        }
        boolean z3 = this.isFollowed_;
        if (z3) {
            codedOutputStream.writeBool(7, z3);
        }
        if (!getStreamBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.stream_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
