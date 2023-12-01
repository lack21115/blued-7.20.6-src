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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GoodsWallEntrance.class */
public final class GoodsWallEntrance extends GeneratedMessageV3 implements GoodsWallEntranceOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 4;
    public static final int ICON_FIELD_NUMBER = 2;
    public static final int PROGRESS_FIELD_NUMBER = 3;
    public static final int SHOW_FIELD_NUMBER = 5;
    public static final int TITLE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int count_;
    private volatile Object icon_;
    private byte memoizedIsInitialized;
    private int progress_;
    private int show_;
    private volatile Object title_;
    private static final GoodsWallEntrance DEFAULT_INSTANCE = new GoodsWallEntrance();
    private static final Parser<GoodsWallEntrance> PARSER = new AbstractParser<GoodsWallEntrance>() { // from class: cn.irisgw.live.GoodsWallEntrance.1
        /* renamed from: parsePartialFrom */
        public GoodsWallEntrance m2955parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new GoodsWallEntrance(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GoodsWallEntrance$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GoodsWallEntranceOrBuilder {
        private int count_;
        private Object icon_;
        private int progress_;
        private int show_;
        private Object title_;

        private Builder() {
            this.title_ = "";
            this.icon_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.title_ = "";
            this.icon_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_GoodsWallEntrance_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GoodsWallEntrance.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m2957addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public GoodsWallEntrance m2959build() {
            GoodsWallEntrance m2961buildPartial = m2961buildPartial();
            if (m2961buildPartial.isInitialized()) {
                return m2961buildPartial;
            }
            throw newUninitializedMessageException(m2961buildPartial);
        }

        /* renamed from: buildPartial */
        public GoodsWallEntrance m2961buildPartial() {
            GoodsWallEntrance goodsWallEntrance = new GoodsWallEntrance(this);
            goodsWallEntrance.title_ = this.title_;
            goodsWallEntrance.icon_ = this.icon_;
            goodsWallEntrance.progress_ = this.progress_;
            goodsWallEntrance.count_ = this.count_;
            goodsWallEntrance.show_ = this.show_;
            onBuilt();
            return goodsWallEntrance;
        }

        /* renamed from: clear */
        public Builder m2965clear() {
            super.clear();
            this.title_ = "";
            this.icon_ = "";
            this.progress_ = 0;
            this.count_ = 0;
            this.show_ = 0;
            return this;
        }

        public Builder clearCount() {
            this.count_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m2967clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearIcon() {
            this.icon_ = GoodsWallEntrance.getDefaultInstance().getIcon();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m2970clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearProgress() {
            this.progress_ = 0;
            onChanged();
            return this;
        }

        public Builder clearShow() {
            this.show_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTitle() {
            this.title_ = GoodsWallEntrance.getDefaultInstance().getTitle();
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m2976clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
        public int getCount() {
            return this.count_;
        }

        /* renamed from: getDefaultInstanceForType */
        public GoodsWallEntrance m2978getDefaultInstanceForType() {
            return GoodsWallEntrance.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_GoodsWallEntrance_descriptor;
        }

        @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
        public String getIcon() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.icon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
        public ByteString getIconBytes() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.icon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
        public int getProgress() {
            return this.progress_;
        }

        @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
        public int getShow() {
            return this.show_;
        }

        @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
        public String getTitle() {
            Object obj = this.title_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.title_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_GoodsWallEntrance_fieldAccessorTable.ensureFieldAccessorsInitialized(GoodsWallEntrance.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(GoodsWallEntrance goodsWallEntrance) {
            if (goodsWallEntrance == GoodsWallEntrance.getDefaultInstance()) {
                return this;
            }
            if (!goodsWallEntrance.getTitle().isEmpty()) {
                this.title_ = goodsWallEntrance.title_;
                onChanged();
            }
            if (!goodsWallEntrance.getIcon().isEmpty()) {
                this.icon_ = goodsWallEntrance.icon_;
                onChanged();
            }
            if (goodsWallEntrance.getProgress() != 0) {
                setProgress(goodsWallEntrance.getProgress());
            }
            if (goodsWallEntrance.getCount() != 0) {
                setCount(goodsWallEntrance.getCount());
            }
            if (goodsWallEntrance.getShow() != 0) {
                setShow(goodsWallEntrance.getShow());
            }
            m2987mergeUnknownFields(goodsWallEntrance.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.GoodsWallEntrance.Builder m2984mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.GoodsWallEntrance.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.GoodsWallEntrance r0 = (cn.irisgw.live.GoodsWallEntrance) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.GoodsWallEntrance$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.GoodsWallEntrance r0 = (cn.irisgw.live.GoodsWallEntrance) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.GoodsWallEntrance$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.GoodsWallEntrance.Builder.m2984mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.GoodsWallEntrance$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m2983mergeFrom(Message message) {
            if (message instanceof GoodsWallEntrance) {
                return mergeFrom((GoodsWallEntrance) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m2987mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setCount(int i) {
            this.count_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m2989setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setIcon(String str) {
            if (str != null) {
                this.icon_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setIconBytes(ByteString byteString) {
            if (byteString != null) {
                GoodsWallEntrance.checkByteStringIsUtf8(byteString);
                this.icon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setProgress(int i) {
            this.progress_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m2991setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setShow(int i) {
            this.show_ = i;
            onChanged();
            return this;
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
                GoodsWallEntrance.checkByteStringIsUtf8(byteString);
                this.title_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setUnknownFields */
        public final Builder m2993setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private GoodsWallEntrance() {
        this.memoizedIsInitialized = (byte) -1;
        this.title_ = "";
        this.icon_ = "";
    }

    private GoodsWallEntrance(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.title_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            this.icon_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 24) {
                            this.progress_ = codedInputStream.readInt32();
                        } else if (readTag == 32) {
                            this.count_ = codedInputStream.readInt32();
                        } else if (readTag == 40) {
                            this.show_ = codedInputStream.readInt32();
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (IOException e) {
                    throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private GoodsWallEntrance(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static GoodsWallEntrance getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_GoodsWallEntrance_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m2954toBuilder();
    }

    public static Builder newBuilder(GoodsWallEntrance goodsWallEntrance) {
        return DEFAULT_INSTANCE.m2954toBuilder().mergeFrom(goodsWallEntrance);
    }

    public static GoodsWallEntrance parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GoodsWallEntrance parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GoodsWallEntrance parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (GoodsWallEntrance) PARSER.parseFrom(byteString);
    }

    public static GoodsWallEntrance parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GoodsWallEntrance) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GoodsWallEntrance parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static GoodsWallEntrance parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static GoodsWallEntrance parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static GoodsWallEntrance parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GoodsWallEntrance parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (GoodsWallEntrance) PARSER.parseFrom(byteBuffer);
    }

    public static GoodsWallEntrance parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GoodsWallEntrance) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GoodsWallEntrance parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (GoodsWallEntrance) PARSER.parseFrom(bArr);
    }

    public static GoodsWallEntrance parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GoodsWallEntrance) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<GoodsWallEntrance> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoodsWallEntrance) {
            GoodsWallEntrance goodsWallEntrance = (GoodsWallEntrance) obj;
            return getTitle().equals(goodsWallEntrance.getTitle()) && getIcon().equals(goodsWallEntrance.getIcon()) && getProgress() == goodsWallEntrance.getProgress() && getCount() == goodsWallEntrance.getCount() && getShow() == goodsWallEntrance.getShow() && this.unknownFields.equals(goodsWallEntrance.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
    public int getCount() {
        return this.count_;
    }

    /* renamed from: getDefaultInstanceForType */
    public GoodsWallEntrance m2949getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
    public String getIcon() {
        Object obj = this.icon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.icon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
    public ByteString getIconBytes() {
        Object obj = this.icon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.icon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<GoodsWallEntrance> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
    public int getProgress() {
        return this.progress_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getTitleBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.title_);
        }
        int i3 = i2;
        if (!getIconBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.icon_);
        }
        int i4 = this.progress_;
        int i5 = i3;
        if (i4 != 0) {
            i5 = i3 + CodedOutputStream.computeInt32Size(3, i4);
        }
        int i6 = this.count_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeInt32Size(4, i6);
        }
        int i8 = this.show_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeInt32Size(5, i8);
        }
        int serializedSize = i9 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
    public int getShow() {
        return this.show_;
    }

    @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
    public String getTitle() {
        Object obj = this.title_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.title_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GoodsWallEntranceOrBuilder
    public ByteString getTitleBytes() {
        Object obj = this.title_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.title_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getTitle().hashCode()) * 37) + 2) * 53) + getIcon().hashCode()) * 37) + 3) * 53) + getProgress()) * 37) + 4) * 53) + getCount()) * 37) + 5) * 53) + getShow()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_GoodsWallEntrance_fieldAccessorTable.ensureFieldAccessorsInitialized(GoodsWallEntrance.class, Builder.class);
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
    public Builder m2952newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m2951newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new GoodsWallEntrance();
    }

    /* renamed from: toBuilder */
    public Builder m2954toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getTitleBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.title_);
        }
        if (!getIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.icon_);
        }
        int i = this.progress_;
        if (i != 0) {
            codedOutputStream.writeInt32(3, i);
        }
        int i2 = this.count_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(4, i2);
        }
        int i3 = this.show_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(5, i3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
