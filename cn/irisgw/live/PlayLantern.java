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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLantern.class */
public final class PlayLantern extends GeneratedMessageV3 implements PlayLanternOrBuilder {
    public static final int IMAGE_FIELD_NUMBER = 1;
    public static final int LANTERN_ID_FIELD_NUMBER = 3;
    public static final int PLAY_TIMES_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private List<resource> image_;
    private int lanternId_;
    private byte memoizedIsInitialized;
    private int playTimes_;
    private static final PlayLantern DEFAULT_INSTANCE = new PlayLantern();
    private static final Parser<PlayLantern> PARSER = new AbstractParser<PlayLantern>() { // from class: cn.irisgw.live.PlayLantern.1
        /* renamed from: parsePartialFrom */
        public PlayLantern m6836parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PlayLantern(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLantern$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayLanternOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> imageBuilder_;
        private List<resource> image_;
        private int lanternId_;
        private int playTimes_;

        private Builder() {
            this.image_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.image_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureImageIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.image_ = new ArrayList(this.image_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PlayLantern_descriptor;
        }

        private RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> getImageFieldBuilder() {
            if (this.imageBuilder_ == null) {
                List<resource> list = this.image_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.imageBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.image_ = null;
            }
            return this.imageBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (PlayLantern.alwaysUseFieldBuilders) {
                getImageFieldBuilder();
            }
        }

        public Builder addAllImage(Iterable<? extends resource> iterable) {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureImageIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.image_);
            onChanged();
            return this;
        }

        public Builder addImage(int i, resource.Builder builder) {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m6887build());
                return this;
            }
            ensureImageIsMutable();
            this.image_.add(i, builder.m6887build());
            onChanged();
            return this;
        }

        public Builder addImage(int i, resource resourceVar) {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, resourceVar);
                return this;
            } else if (resourceVar != null) {
                ensureImageIsMutable();
                this.image_.add(i, resourceVar);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addImage(resource.Builder builder) {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m6887build());
                return this;
            }
            ensureImageIsMutable();
            this.image_.add(builder.m6887build());
            onChanged();
            return this;
        }

        public Builder addImage(resource resourceVar) {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(resourceVar);
                return this;
            } else if (resourceVar != null) {
                ensureImageIsMutable();
                this.image_.add(resourceVar);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public resource.Builder addImageBuilder() {
            return getImageFieldBuilder().addBuilder(resource.getDefaultInstance());
        }

        public resource.Builder addImageBuilder(int i) {
            return getImageFieldBuilder().addBuilder(i, resource.getDefaultInstance());
        }

        /* renamed from: addRepeatedField */
        public Builder m6838addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public PlayLantern m6840build() {
            PlayLantern m6842buildPartial = m6842buildPartial();
            if (m6842buildPartial.isInitialized()) {
                return m6842buildPartial;
            }
            throw newUninitializedMessageException(m6842buildPartial);
        }

        /* renamed from: buildPartial */
        public PlayLantern m6842buildPartial() {
            PlayLantern playLantern = new PlayLantern(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.image_ = Collections.unmodifiableList(this.image_);
                    this.bitField0_ &= -2;
                }
                playLantern.image_ = this.image_;
            } else {
                playLantern.image_ = repeatedFieldBuilderV3.build();
            }
            playLantern.lanternId_ = this.lanternId_;
            playLantern.playTimes_ = this.playTimes_;
            onBuilt();
            return playLantern;
        }

        /* renamed from: clear */
        public Builder m6846clear() {
            super.clear();
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.image_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.lanternId_ = 0;
            this.playTimes_ = 0;
            return this;
        }

        /* renamed from: clearField */
        public Builder m6848clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearImage() {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.image_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearLanternId() {
            this.lanternId_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m6851clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPlayTimes() {
            this.playTimes_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m6857clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public PlayLantern m6859getDefaultInstanceForType() {
            return PlayLantern.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_PlayLantern_descriptor;
        }

        @Override // cn.irisgw.live.PlayLanternOrBuilder
        public resource getImage(int i) {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            return repeatedFieldBuilderV3 == null ? this.image_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public resource.Builder getImageBuilder(int i) {
            return getImageFieldBuilder().getBuilder(i);
        }

        public List<resource.Builder> getImageBuilderList() {
            return getImageFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.PlayLanternOrBuilder
        public int getImageCount() {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            return repeatedFieldBuilderV3 == null ? this.image_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.PlayLanternOrBuilder
        public List<resource> getImageList() {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.image_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.PlayLanternOrBuilder
        public resourceOrBuilder getImageOrBuilder(int i) {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            return repeatedFieldBuilderV3 == null ? this.image_.get(i) : (resourceOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.PlayLanternOrBuilder
        public List<? extends resourceOrBuilder> getImageOrBuilderList() {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.image_);
        }

        @Override // cn.irisgw.live.PlayLanternOrBuilder
        public int getLanternId() {
            return this.lanternId_;
        }

        @Override // cn.irisgw.live.PlayLanternOrBuilder
        public int getPlayTimes() {
            return this.playTimes_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PlayLantern_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayLantern.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(PlayLantern playLantern) {
            if (playLantern == PlayLantern.getDefaultInstance()) {
                return this;
            }
            if (this.imageBuilder_ == null) {
                if (!playLantern.image_.isEmpty()) {
                    if (this.image_.isEmpty()) {
                        this.image_ = playLantern.image_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureImageIsMutable();
                        this.image_.addAll(playLantern.image_);
                    }
                    onChanged();
                }
            } else if (!playLantern.image_.isEmpty()) {
                if (this.imageBuilder_.isEmpty()) {
                    this.imageBuilder_.dispose();
                    RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = null;
                    this.imageBuilder_ = null;
                    this.image_ = playLantern.image_;
                    this.bitField0_ &= -2;
                    if (PlayLantern.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getImageFieldBuilder();
                    }
                    this.imageBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.imageBuilder_.addAllMessages(playLantern.image_);
                }
            }
            if (playLantern.getLanternId() != 0) {
                setLanternId(playLantern.getLanternId());
            }
            if (playLantern.getPlayTimes() != 0) {
                setPlayTimes(playLantern.getPlayTimes());
            }
            m6868mergeUnknownFields(playLantern.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.PlayLantern.Builder m6865mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.PlayLantern.access$1800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.PlayLantern r0 = (cn.irisgw.live.PlayLantern) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.PlayLantern$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.PlayLantern r0 = (cn.irisgw.live.PlayLantern) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.PlayLantern$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PlayLantern.Builder.m6865mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PlayLantern$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m6864mergeFrom(Message message) {
            if (message instanceof PlayLantern) {
                return mergeFrom((PlayLantern) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m6868mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeImage(int i) {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureImageIsMutable();
            this.image_.remove(i);
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m6870setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setImage(int i, resource.Builder builder) {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m6887build());
                return this;
            }
            ensureImageIsMutable();
            this.image_.set(i, builder.m6887build());
            onChanged();
            return this;
        }

        public Builder setImage(int i, resource resourceVar) {
            RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, resourceVar);
                return this;
            } else if (resourceVar != null) {
                ensureImageIsMutable();
                this.image_.set(i, resourceVar);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setLanternId(int i) {
            this.lanternId_ = i;
            onChanged();
            return this;
        }

        public Builder setPlayTimes(int i) {
            this.playTimes_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m6872setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m6874setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLantern$resource.class */
    public static final class resource extends GeneratedMessageV3 implements resourceOrBuilder {
        public static final int IMG_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object img_;
        private byte memoizedIsInitialized;
        private static final resource DEFAULT_INSTANCE = new resource();
        private static final Parser<resource> PARSER = new AbstractParser<resource>() { // from class: cn.irisgw.live.PlayLantern.resource.1
            /* renamed from: parsePartialFrom */
            public resource m6883parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new resource(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLantern$resource$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements resourceOrBuilder {
            private Object img_;

            private Builder() {
                this.img_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.img_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_PlayLantern_resource_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = resource.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m6885addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public resource m6887build() {
                resource m6889buildPartial = m6889buildPartial();
                if (m6889buildPartial.isInitialized()) {
                    return m6889buildPartial;
                }
                throw newUninitializedMessageException(m6889buildPartial);
            }

            /* renamed from: buildPartial */
            public resource m6889buildPartial() {
                resource resourceVar = new resource(this);
                resourceVar.img_ = this.img_;
                onBuilt();
                return resourceVar;
            }

            /* renamed from: clear */
            public Builder m6893clear() {
                super.clear();
                this.img_ = "";
                return this;
            }

            /* renamed from: clearField */
            public Builder m6895clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearImg() {
                this.img_ = resource.getDefaultInstance().getImg();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m6898clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* renamed from: clone */
            public Builder m6904clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public resource m6906getDefaultInstanceForType() {
                return resource.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_PlayLantern_resource_descriptor;
            }

            @Override // cn.irisgw.live.PlayLantern.resourceOrBuilder
            public String getImg() {
                Object obj = this.img_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.img_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.PlayLantern.resourceOrBuilder
            public ByteString getImgBytes() {
                Object obj = this.img_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.img_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_PlayLantern_resource_fieldAccessorTable.ensureFieldAccessorsInitialized(resource.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(resource resourceVar) {
                if (resourceVar == resource.getDefaultInstance()) {
                    return this;
                }
                if (!resourceVar.getImg().isEmpty()) {
                    this.img_ = resourceVar.img_;
                    onChanged();
                }
                m6915mergeUnknownFields(resourceVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.PlayLantern.resource.Builder m6912mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.PlayLantern.resource.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.PlayLantern$resource r0 = (cn.irisgw.live.PlayLantern.resource) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.PlayLantern$resource$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.PlayLantern$resource r0 = (cn.irisgw.live.PlayLantern.resource) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.PlayLantern$resource$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PlayLantern.resource.Builder.m6912mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PlayLantern$resource$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m6911mergeFrom(Message message) {
                if (message instanceof resource) {
                    return mergeFrom((resource) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m6915mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            /* renamed from: setField */
            public Builder m6917setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setImg(String str) {
                if (str != null) {
                    this.img_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setImgBytes(ByteString byteString) {
                if (byteString != null) {
                    resource.checkByteStringIsUtf8(byteString);
                    this.img_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setRepeatedField */
            public Builder m6919setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* renamed from: setUnknownFields */
            public final Builder m6921setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private resource() {
            this.memoizedIsInitialized = (byte) -1;
            this.img_ = "";
        }

        private resource(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.img_ = codedInputStream.readStringRequireUtf8();
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

        private resource(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static resource getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PlayLantern_resource_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m6882toBuilder();
        }

        public static Builder newBuilder(resource resourceVar) {
            return DEFAULT_INSTANCE.m6882toBuilder().mergeFrom(resourceVar);
        }

        public static resource parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static resource parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static resource parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (resource) PARSER.parseFrom(byteString);
        }

        public static resource parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (resource) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static resource parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static resource parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static resource parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static resource parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static resource parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (resource) PARSER.parseFrom(byteBuffer);
        }

        public static resource parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (resource) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static resource parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (resource) PARSER.parseFrom(bArr);
        }

        public static resource parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (resource) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<resource> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof resource) {
                resource resourceVar = (resource) obj;
                return getImg().equals(resourceVar.getImg()) && this.unknownFields.equals(resourceVar.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public resource m6877getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.PlayLantern.resourceOrBuilder
        public String getImg() {
            Object obj = this.img_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.img_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PlayLantern.resourceOrBuilder
        public ByteString getImgBytes() {
            Object obj = this.img_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.img_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<resource> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getImgBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.img_);
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
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getImg().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PlayLantern_resource_fieldAccessorTable.ensureFieldAccessorsInitialized(resource.class, Builder.class);
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
        public Builder m6880newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m6879newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new resource();
        }

        /* renamed from: toBuilder */
        public Builder m6882toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getImgBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.img_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLantern$resourceOrBuilder.class */
    public interface resourceOrBuilder extends MessageOrBuilder {
        String getImg();

        ByteString getImgBytes();
    }

    private PlayLantern() {
        this.memoizedIsInitialized = (byte) -1;
        this.image_ = Collections.emptyList();
    }

    private PlayLantern(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.image_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.image_.add((resource) codedInputStream.readMessage(resource.parser(), extensionRegistryLite));
                            z2 = z4;
                        } else if (readTag == 16) {
                            this.playTimes_ = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            this.lanternId_ = codedInputStream.readInt32();
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
                    this.image_ = Collections.unmodifiableList(this.image_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.image_ = Collections.unmodifiableList(this.image_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private PlayLantern(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PlayLantern getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_PlayLantern_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m6835toBuilder();
    }

    public static Builder newBuilder(PlayLantern playLantern) {
        return DEFAULT_INSTANCE.m6835toBuilder().mergeFrom(playLantern);
    }

    public static PlayLantern parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlayLantern parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlayLantern parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PlayLantern) PARSER.parseFrom(byteString);
    }

    public static PlayLantern parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PlayLantern) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlayLantern parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlayLantern parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PlayLantern parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PlayLantern parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlayLantern parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PlayLantern) PARSER.parseFrom(byteBuffer);
    }

    public static PlayLantern parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PlayLantern) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlayLantern parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PlayLantern) PARSER.parseFrom(bArr);
    }

    public static PlayLantern parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PlayLantern) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<PlayLantern> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PlayLantern) {
            PlayLantern playLantern = (PlayLantern) obj;
            return getImageList().equals(playLantern.getImageList()) && getLanternId() == playLantern.getLanternId() && getPlayTimes() == playLantern.getPlayTimes() && this.unknownFields.equals(playLantern.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public PlayLantern m6830getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.PlayLanternOrBuilder
    public resource getImage(int i) {
        return this.image_.get(i);
    }

    @Override // cn.irisgw.live.PlayLanternOrBuilder
    public int getImageCount() {
        return this.image_.size();
    }

    @Override // cn.irisgw.live.PlayLanternOrBuilder
    public List<resource> getImageList() {
        return this.image_;
    }

    @Override // cn.irisgw.live.PlayLanternOrBuilder
    public resourceOrBuilder getImageOrBuilder(int i) {
        return this.image_.get(i);
    }

    @Override // cn.irisgw.live.PlayLanternOrBuilder
    public List<? extends resourceOrBuilder> getImageOrBuilderList() {
        return this.image_;
    }

    @Override // cn.irisgw.live.PlayLanternOrBuilder
    public int getLanternId() {
        return this.lanternId_;
    }

    public Parser<PlayLantern> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.PlayLanternOrBuilder
    public int getPlayTimes() {
        return this.playTimes_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.image_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.image_.get(i3));
        }
        int i4 = this.playTimes_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeInt32Size(2, i4);
        }
        int i6 = this.lanternId_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeInt32Size(3, i6);
        }
        int serializedSize = i7 + this.unknownFields.getSerializedSize();
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
        if (getImageCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getImageList().hashCode();
        }
        int lanternId = (((((((((i * 37) + 3) * 53) + getLanternId()) * 37) + 2) * 53) + getPlayTimes()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = lanternId;
        return lanternId;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_PlayLantern_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayLantern.class, Builder.class);
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
    public Builder m6833newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m6832newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new PlayLantern();
    }

    /* renamed from: toBuilder */
    public Builder m6835toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.image_.size()) {
                break;
            }
            codedOutputStream.writeMessage(1, this.image_.get(i2));
            i = i2 + 1;
        }
        int i3 = this.playTimes_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(2, i3);
        }
        int i4 = this.lanternId_;
        if (i4 != 0) {
            codedOutputStream.writeInt32(3, i4);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
