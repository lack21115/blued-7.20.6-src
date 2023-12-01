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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLanternUpdate.class */
public final class PlayLanternUpdate extends GeneratedMessageV3 implements PlayLanternUpdateOrBuilder {
    public static final int LANTERN_RESOURCE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<lantern> lanternResource_;
    private byte memoizedIsInitialized;
    private static final PlayLanternUpdate DEFAULT_INSTANCE = new PlayLanternUpdate();
    private static final Parser<PlayLanternUpdate> PARSER = new AbstractParser<PlayLanternUpdate>() { // from class: cn.irisgw.live.PlayLanternUpdate.1
        /* renamed from: parsePartialFrom */
        public PlayLanternUpdate m6930parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PlayLanternUpdate(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLanternUpdate$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayLanternUpdateOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> lanternResourceBuilder_;
        private List<lantern> lanternResource_;

        private Builder() {
            this.lanternResource_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.lanternResource_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureLanternResourceIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.lanternResource_ = new ArrayList(this.lanternResource_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_descriptor;
        }

        private RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> getLanternResourceFieldBuilder() {
            if (this.lanternResourceBuilder_ == null) {
                List<lantern> list = this.lanternResource_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.lanternResourceBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.lanternResource_ = null;
            }
            return this.lanternResourceBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (PlayLanternUpdate.alwaysUseFieldBuilders) {
                getLanternResourceFieldBuilder();
            }
        }

        public Builder addAllLanternResource(Iterable<? extends lantern> iterable) {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureLanternResourceIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.lanternResource_);
            onChanged();
            return this;
        }

        public Builder addLanternResource(int i, lantern.Builder builder) {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m6981build());
                return this;
            }
            ensureLanternResourceIsMutable();
            this.lanternResource_.add(i, builder.m6981build());
            onChanged();
            return this;
        }

        public Builder addLanternResource(int i, lantern lanternVar) {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, lanternVar);
                return this;
            } else if (lanternVar != null) {
                ensureLanternResourceIsMutable();
                this.lanternResource_.add(i, lanternVar);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addLanternResource(lantern.Builder builder) {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m6981build());
                return this;
            }
            ensureLanternResourceIsMutable();
            this.lanternResource_.add(builder.m6981build());
            onChanged();
            return this;
        }

        public Builder addLanternResource(lantern lanternVar) {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(lanternVar);
                return this;
            } else if (lanternVar != null) {
                ensureLanternResourceIsMutable();
                this.lanternResource_.add(lanternVar);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public lantern.Builder addLanternResourceBuilder() {
            return getLanternResourceFieldBuilder().addBuilder(lantern.getDefaultInstance());
        }

        public lantern.Builder addLanternResourceBuilder(int i) {
            return getLanternResourceFieldBuilder().addBuilder(i, lantern.getDefaultInstance());
        }

        /* renamed from: addRepeatedField */
        public Builder m6932addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public PlayLanternUpdate m6934build() {
            PlayLanternUpdate m6936buildPartial = m6936buildPartial();
            if (m6936buildPartial.isInitialized()) {
                return m6936buildPartial;
            }
            throw newUninitializedMessageException(m6936buildPartial);
        }

        /* renamed from: buildPartial */
        public PlayLanternUpdate m6936buildPartial() {
            PlayLanternUpdate playLanternUpdate = new PlayLanternUpdate(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.lanternResource_ = Collections.unmodifiableList(this.lanternResource_);
                    this.bitField0_ &= -2;
                }
                playLanternUpdate.lanternResource_ = this.lanternResource_;
            } else {
                playLanternUpdate.lanternResource_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return playLanternUpdate;
        }

        /* renamed from: clear */
        public Builder m6940clear() {
            super.clear();
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.lanternResource_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        /* renamed from: clearField */
        public Builder m6942clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearLanternResource() {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.lanternResource_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m6945clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m6951clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public PlayLanternUpdate m6953getDefaultInstanceForType() {
            return PlayLanternUpdate.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_descriptor;
        }

        @Override // cn.irisgw.live.PlayLanternUpdateOrBuilder
        public lantern getLanternResource(int i) {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            return repeatedFieldBuilderV3 == null ? this.lanternResource_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public lantern.Builder getLanternResourceBuilder(int i) {
            return getLanternResourceFieldBuilder().getBuilder(i);
        }

        public List<lantern.Builder> getLanternResourceBuilderList() {
            return getLanternResourceFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.PlayLanternUpdateOrBuilder
        public int getLanternResourceCount() {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            return repeatedFieldBuilderV3 == null ? this.lanternResource_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.PlayLanternUpdateOrBuilder
        public List<lantern> getLanternResourceList() {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.lanternResource_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.PlayLanternUpdateOrBuilder
        public lanternOrBuilder getLanternResourceOrBuilder(int i) {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            return repeatedFieldBuilderV3 == null ? this.lanternResource_.get(i) : (lanternOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.PlayLanternUpdateOrBuilder
        public List<? extends lanternOrBuilder> getLanternResourceOrBuilderList() {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.lanternResource_);
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayLanternUpdate.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(PlayLanternUpdate playLanternUpdate) {
            if (playLanternUpdate == PlayLanternUpdate.getDefaultInstance()) {
                return this;
            }
            if (this.lanternResourceBuilder_ == null) {
                if (!playLanternUpdate.lanternResource_.isEmpty()) {
                    if (this.lanternResource_.isEmpty()) {
                        this.lanternResource_ = playLanternUpdate.lanternResource_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureLanternResourceIsMutable();
                        this.lanternResource_.addAll(playLanternUpdate.lanternResource_);
                    }
                    onChanged();
                }
            } else if (!playLanternUpdate.lanternResource_.isEmpty()) {
                if (this.lanternResourceBuilder_.isEmpty()) {
                    this.lanternResourceBuilder_.dispose();
                    RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = null;
                    this.lanternResourceBuilder_ = null;
                    this.lanternResource_ = playLanternUpdate.lanternResource_;
                    this.bitField0_ &= -2;
                    if (PlayLanternUpdate.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getLanternResourceFieldBuilder();
                    }
                    this.lanternResourceBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.lanternResourceBuilder_.addAllMessages(playLanternUpdate.lanternResource_);
                }
            }
            m6962mergeUnknownFields(playLanternUpdate.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.PlayLanternUpdate.Builder m6959mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.PlayLanternUpdate.access$3100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.PlayLanternUpdate r0 = (cn.irisgw.live.PlayLanternUpdate) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.PlayLanternUpdate$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.PlayLanternUpdate r0 = (cn.irisgw.live.PlayLanternUpdate) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.PlayLanternUpdate$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PlayLanternUpdate.Builder.m6959mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PlayLanternUpdate$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m6958mergeFrom(Message message) {
            if (message instanceof PlayLanternUpdate) {
                return mergeFrom((PlayLanternUpdate) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m6962mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeLanternResource(int i) {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureLanternResourceIsMutable();
            this.lanternResource_.remove(i);
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m6964setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setLanternResource(int i, lantern.Builder builder) {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m6981build());
                return this;
            }
            ensureLanternResourceIsMutable();
            this.lanternResource_.set(i, builder.m6981build());
            onChanged();
            return this;
        }

        public Builder setLanternResource(int i, lantern lanternVar) {
            RepeatedFieldBuilderV3<lantern, lantern.Builder, lanternOrBuilder> repeatedFieldBuilderV3 = this.lanternResourceBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, lanternVar);
                return this;
            } else if (lanternVar != null) {
                ensureLanternResourceIsMutable();
                this.lanternResource_.set(i, lanternVar);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        /* renamed from: setRepeatedField */
        public Builder m6966setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m6968setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLanternUpdate$lantern.class */
    public static final class lantern extends GeneratedMessageV3 implements lanternOrBuilder {
        public static final int END_TIME_FIELD_NUMBER = 6;
        public static final int FREQUENCY_FIELD_NUMBER = 4;
        public static final int IMAGE_FIELD_NUMBER = 1;
        public static final int LANTERN_ID_FIELD_NUMBER = 2;
        public static final int PLAY_TIMES_FIELD_NUMBER = 3;
        public static final int START_TIME_FIELD_NUMBER = 5;
        public static final int TASK_ID_FIELD_NUMBER = 7;
        private static final long serialVersionUID = 0;
        private int endTime_;
        private int frequency_;
        private List<resource> image_;
        private int lanternId_;
        private byte memoizedIsInitialized;
        private int playTimes_;
        private int startTime_;
        private int taskId_;
        private static final lantern DEFAULT_INSTANCE = new lantern();
        private static final Parser<lantern> PARSER = new AbstractParser<lantern>() { // from class: cn.irisgw.live.PlayLanternUpdate.lantern.1
            /* renamed from: parsePartialFrom */
            public lantern m6977parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new lantern(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLanternUpdate$lantern$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements lanternOrBuilder {
            private int bitField0_;
            private int endTime_;
            private int frequency_;
            private RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> imageBuilder_;
            private List<resource> image_;
            private int lanternId_;
            private int playTimes_;
            private int startTime_;
            private int taskId_;

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
                return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_lantern_descriptor;
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
                if (lantern.alwaysUseFieldBuilders) {
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
                    repeatedFieldBuilderV3.addMessage(i, builder.m7028build());
                    return this;
                }
                ensureImageIsMutable();
                this.image_.add(i, builder.m7028build());
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
                    repeatedFieldBuilderV3.addMessage(builder.m7028build());
                    return this;
                }
                ensureImageIsMutable();
                this.image_.add(builder.m7028build());
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
            public Builder m6979addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public lantern m6981build() {
                lantern m6983buildPartial = m6983buildPartial();
                if (m6983buildPartial.isInitialized()) {
                    return m6983buildPartial;
                }
                throw newUninitializedMessageException(m6983buildPartial);
            }

            /* renamed from: buildPartial */
            public lantern m6983buildPartial() {
                lantern lanternVar = new lantern(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) != 0) {
                        this.image_ = Collections.unmodifiableList(this.image_);
                        this.bitField0_ &= -2;
                    }
                    lanternVar.image_ = this.image_;
                } else {
                    lanternVar.image_ = repeatedFieldBuilderV3.build();
                }
                lanternVar.lanternId_ = this.lanternId_;
                lanternVar.playTimes_ = this.playTimes_;
                lanternVar.frequency_ = this.frequency_;
                lanternVar.startTime_ = this.startTime_;
                lanternVar.endTime_ = this.endTime_;
                lanternVar.taskId_ = this.taskId_;
                onBuilt();
                return lanternVar;
            }

            /* renamed from: clear */
            public Builder m6987clear() {
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
                this.frequency_ = 0;
                this.startTime_ = 0;
                this.endTime_ = 0;
                this.taskId_ = 0;
                return this;
            }

            public Builder clearEndTime() {
                this.endTime_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m6989clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearFrequency() {
                this.frequency_ = 0;
                onChanged();
                return this;
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
            public Builder m6992clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPlayTimes() {
                this.playTimes_ = 0;
                onChanged();
                return this;
            }

            public Builder clearStartTime() {
                this.startTime_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTaskId() {
                this.taskId_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m6998clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public lantern m7000getDefaultInstanceForType() {
                return lantern.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_lantern_descriptor;
            }

            @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
            public int getEndTime() {
                return this.endTime_;
            }

            @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
            public int getFrequency() {
                return this.frequency_;
            }

            @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
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

            @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
            public int getImageCount() {
                RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
                return repeatedFieldBuilderV3 == null ? this.image_.size() : repeatedFieldBuilderV3.getCount();
            }

            @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
            public List<resource> getImageList() {
                RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
                return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.image_) : repeatedFieldBuilderV3.getMessageList();
            }

            @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
            public resourceOrBuilder getImageOrBuilder(int i) {
                RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
                return repeatedFieldBuilderV3 == null ? this.image_.get(i) : (resourceOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
            public List<? extends resourceOrBuilder> getImageOrBuilderList() {
                RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
                return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.image_);
            }

            @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
            public int getLanternId() {
                return this.lanternId_;
            }

            @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
            public int getPlayTimes() {
                return this.playTimes_;
            }

            @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
            public int getStartTime() {
                return this.startTime_;
            }

            @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
            public int getTaskId() {
                return this.taskId_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_lantern_fieldAccessorTable.ensureFieldAccessorsInitialized(lantern.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(lantern lanternVar) {
                if (lanternVar == lantern.getDefaultInstance()) {
                    return this;
                }
                if (this.imageBuilder_ == null) {
                    if (!lanternVar.image_.isEmpty()) {
                        if (this.image_.isEmpty()) {
                            this.image_ = lanternVar.image_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureImageIsMutable();
                            this.image_.addAll(lanternVar.image_);
                        }
                        onChanged();
                    }
                } else if (!lanternVar.image_.isEmpty()) {
                    if (this.imageBuilder_.isEmpty()) {
                        this.imageBuilder_.dispose();
                        RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = null;
                        this.imageBuilder_ = null;
                        this.image_ = lanternVar.image_;
                        this.bitField0_ &= -2;
                        if (lantern.alwaysUseFieldBuilders) {
                            repeatedFieldBuilderV3 = getImageFieldBuilder();
                        }
                        this.imageBuilder_ = repeatedFieldBuilderV3;
                    } else {
                        this.imageBuilder_.addAllMessages(lanternVar.image_);
                    }
                }
                if (lanternVar.getLanternId() != 0) {
                    setLanternId(lanternVar.getLanternId());
                }
                if (lanternVar.getPlayTimes() != 0) {
                    setPlayTimes(lanternVar.getPlayTimes());
                }
                if (lanternVar.getFrequency() != 0) {
                    setFrequency(lanternVar.getFrequency());
                }
                if (lanternVar.getStartTime() != 0) {
                    setStartTime(lanternVar.getStartTime());
                }
                if (lanternVar.getEndTime() != 0) {
                    setEndTime(lanternVar.getEndTime());
                }
                if (lanternVar.getTaskId() != 0) {
                    setTaskId(lanternVar.getTaskId());
                }
                m7009mergeUnknownFields(lanternVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.PlayLanternUpdate.lantern.Builder m7006mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.PlayLanternUpdate.lantern.access$2200()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.PlayLanternUpdate$lantern r0 = (cn.irisgw.live.PlayLanternUpdate.lantern) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.PlayLanternUpdate$lantern$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.PlayLanternUpdate$lantern r0 = (cn.irisgw.live.PlayLanternUpdate.lantern) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.PlayLanternUpdate$lantern$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PlayLanternUpdate.lantern.Builder.m7006mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PlayLanternUpdate$lantern$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m7005mergeFrom(Message message) {
                if (message instanceof lantern) {
                    return mergeFrom((lantern) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m7009mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
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

            public Builder setEndTime(int i) {
                this.endTime_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setField */
            public Builder m7011setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setFrequency(int i) {
                this.frequency_ = i;
                onChanged();
                return this;
            }

            public Builder setImage(int i, resource.Builder builder) {
                RepeatedFieldBuilderV3<resource, resource.Builder, resourceOrBuilder> repeatedFieldBuilderV3 = this.imageBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, builder.m7028build());
                    return this;
                }
                ensureImageIsMutable();
                this.image_.set(i, builder.m7028build());
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
            public Builder m7013setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setStartTime(int i) {
                this.startTime_ = i;
                onChanged();
                return this;
            }

            public Builder setTaskId(int i) {
                this.taskId_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setUnknownFields */
            public final Builder m7015setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private lantern() {
            this.memoizedIsInitialized = (byte) -1;
            this.image_ = Collections.emptyList();
        }

        private lantern(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.lanternId_ = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                this.playTimes_ = codedInputStream.readInt32();
                            } else if (readTag == 32) {
                                this.frequency_ = codedInputStream.readInt32();
                            } else if (readTag == 40) {
                                this.startTime_ = codedInputStream.readUInt32();
                            } else if (readTag == 48) {
                                this.endTime_ = codedInputStream.readUInt32();
                            } else if (readTag == 56) {
                                this.taskId_ = codedInputStream.readUInt32();
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

        private lantern(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static lantern getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_lantern_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m6976toBuilder();
        }

        public static Builder newBuilder(lantern lanternVar) {
            return DEFAULT_INSTANCE.m6976toBuilder().mergeFrom(lanternVar);
        }

        public static lantern parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static lantern parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static lantern parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (lantern) PARSER.parseFrom(byteString);
        }

        public static lantern parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (lantern) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static lantern parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static lantern parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static lantern parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static lantern parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static lantern parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (lantern) PARSER.parseFrom(byteBuffer);
        }

        public static lantern parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (lantern) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static lantern parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (lantern) PARSER.parseFrom(bArr);
        }

        public static lantern parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (lantern) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<lantern> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof lantern) {
                lantern lanternVar = (lantern) obj;
                return getImageList().equals(lanternVar.getImageList()) && getLanternId() == lanternVar.getLanternId() && getPlayTimes() == lanternVar.getPlayTimes() && getFrequency() == lanternVar.getFrequency() && getStartTime() == lanternVar.getStartTime() && getEndTime() == lanternVar.getEndTime() && getTaskId() == lanternVar.getTaskId() && this.unknownFields.equals(lanternVar.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public lantern m6971getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
        public int getFrequency() {
            return this.frequency_;
        }

        @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
        public resource getImage(int i) {
            return this.image_.get(i);
        }

        @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
        public int getImageCount() {
            return this.image_.size();
        }

        @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
        public List<resource> getImageList() {
            return this.image_;
        }

        @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
        public resourceOrBuilder getImageOrBuilder(int i) {
            return this.image_.get(i);
        }

        @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
        public List<? extends resourceOrBuilder> getImageOrBuilderList() {
            return this.image_;
        }

        @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
        public int getLanternId() {
            return this.lanternId_;
        }

        public Parser<lantern> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
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
            int i4 = this.lanternId_;
            int i5 = i2;
            if (i4 != 0) {
                i5 = i2 + CodedOutputStream.computeInt32Size(2, i4);
            }
            int i6 = this.playTimes_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeInt32Size(3, i6);
            }
            int i8 = this.frequency_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeInt32Size(4, i8);
            }
            int i10 = this.startTime_;
            int i11 = i9;
            if (i10 != 0) {
                i11 = i9 + CodedOutputStream.computeUInt32Size(5, i10);
            }
            int i12 = this.endTime_;
            int i13 = i11;
            if (i12 != 0) {
                i13 = i11 + CodedOutputStream.computeUInt32Size(6, i12);
            }
            int i14 = this.taskId_;
            int i15 = i13;
            if (i14 != 0) {
                i15 = i13 + CodedOutputStream.computeUInt32Size(7, i14);
            }
            int serializedSize = i15 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        @Override // cn.irisgw.live.PlayLanternUpdate.lanternOrBuilder
        public int getTaskId() {
            return this.taskId_;
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
            int lanternId = (((((((((((((((((((((((((i * 37) + 2) * 53) + getLanternId()) * 37) + 3) * 53) + getPlayTimes()) * 37) + 4) * 53) + getFrequency()) * 37) + 5) * 53) + getStartTime()) * 37) + 6) * 53) + getEndTime()) * 37) + 7) * 53) + getTaskId()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = lanternId;
            return lanternId;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_lantern_fieldAccessorTable.ensureFieldAccessorsInitialized(lantern.class, Builder.class);
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
        public Builder m6974newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m6973newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new lantern();
        }

        /* renamed from: toBuilder */
        public Builder m6976toBuilder() {
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
            int i3 = this.lanternId_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(2, i3);
            }
            int i4 = this.playTimes_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(3, i4);
            }
            int i5 = this.frequency_;
            if (i5 != 0) {
                codedOutputStream.writeInt32(4, i5);
            }
            int i6 = this.startTime_;
            if (i6 != 0) {
                codedOutputStream.writeUInt32(5, i6);
            }
            int i7 = this.endTime_;
            if (i7 != 0) {
                codedOutputStream.writeUInt32(6, i7);
            }
            int i8 = this.taskId_;
            if (i8 != 0) {
                codedOutputStream.writeUInt32(7, i8);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLanternUpdate$lanternOrBuilder.class */
    public interface lanternOrBuilder extends MessageOrBuilder {
        int getEndTime();

        int getFrequency();

        resource getImage(int i);

        int getImageCount();

        List<resource> getImageList();

        resourceOrBuilder getImageOrBuilder(int i);

        List<? extends resourceOrBuilder> getImageOrBuilderList();

        int getLanternId();

        int getPlayTimes();

        int getStartTime();

        int getTaskId();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLanternUpdate$resource.class */
    public static final class resource extends GeneratedMessageV3 implements resourceOrBuilder {
        public static final int IMG_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object img_;
        private byte memoizedIsInitialized;
        private static final resource DEFAULT_INSTANCE = new resource();
        private static final Parser<resource> PARSER = new AbstractParser<resource>() { // from class: cn.irisgw.live.PlayLanternUpdate.resource.1
            /* renamed from: parsePartialFrom */
            public resource m7024parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new resource(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLanternUpdate$resource$Builder.class */
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
                return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_resource_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = resource.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m7026addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public resource m7028build() {
                resource m7030buildPartial = m7030buildPartial();
                if (m7030buildPartial.isInitialized()) {
                    return m7030buildPartial;
                }
                throw newUninitializedMessageException(m7030buildPartial);
            }

            /* renamed from: buildPartial */
            public resource m7030buildPartial() {
                resource resourceVar = new resource(this);
                resourceVar.img_ = this.img_;
                onBuilt();
                return resourceVar;
            }

            /* renamed from: clear */
            public Builder m7034clear() {
                super.clear();
                this.img_ = "";
                return this;
            }

            /* renamed from: clearField */
            public Builder m7036clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearImg() {
                this.img_ = resource.getDefaultInstance().getImg();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m7039clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* renamed from: clone */
            public Builder m7045clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public resource m7047getDefaultInstanceForType() {
                return resource.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_resource_descriptor;
            }

            @Override // cn.irisgw.live.PlayLanternUpdate.resourceOrBuilder
            public String getImg() {
                Object obj = this.img_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.img_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.PlayLanternUpdate.resourceOrBuilder
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
                return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_resource_fieldAccessorTable.ensureFieldAccessorsInitialized(resource.class, Builder.class);
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
                m7056mergeUnknownFields(resourceVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.PlayLanternUpdate.resource.Builder m7053mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.PlayLanternUpdate.resource.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.PlayLanternUpdate$resource r0 = (cn.irisgw.live.PlayLanternUpdate.resource) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.PlayLanternUpdate$resource$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.PlayLanternUpdate$resource r0 = (cn.irisgw.live.PlayLanternUpdate.resource) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.PlayLanternUpdate$resource$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PlayLanternUpdate.resource.Builder.m7053mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PlayLanternUpdate$resource$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m7052mergeFrom(Message message) {
                if (message instanceof resource) {
                    return mergeFrom((resource) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m7056mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            /* renamed from: setField */
            public Builder m7058setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
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
            public Builder m7060setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* renamed from: setUnknownFields */
            public final Builder m7062setUnknownFields(UnknownFieldSet unknownFieldSet) {
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
            return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_resource_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m7023toBuilder();
        }

        public static Builder newBuilder(resource resourceVar) {
            return DEFAULT_INSTANCE.m7023toBuilder().mergeFrom(resourceVar);
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
        public resource m7018getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.PlayLanternUpdate.resourceOrBuilder
        public String getImg() {
            Object obj = this.img_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.img_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PlayLanternUpdate.resourceOrBuilder
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
            return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_resource_fieldAccessorTable.ensureFieldAccessorsInitialized(resource.class, Builder.class);
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
        public Builder m7021newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m7020newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new resource();
        }

        /* renamed from: toBuilder */
        public Builder m7023toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getImgBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.img_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLanternUpdate$resourceOrBuilder.class */
    public interface resourceOrBuilder extends MessageOrBuilder {
        String getImg();

        ByteString getImgBytes();
    }

    private PlayLanternUpdate() {
        this.memoizedIsInitialized = (byte) -1;
        this.lanternResource_ = Collections.emptyList();
    }

    private PlayLanternUpdate(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.lanternResource_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.lanternResource_.add((lantern) codedInputStream.readMessage(lantern.parser(), extensionRegistryLite));
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
                    this.lanternResource_ = Collections.unmodifiableList(this.lanternResource_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.lanternResource_ = Collections.unmodifiableList(this.lanternResource_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private PlayLanternUpdate(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PlayLanternUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m6929toBuilder();
    }

    public static Builder newBuilder(PlayLanternUpdate playLanternUpdate) {
        return DEFAULT_INSTANCE.m6929toBuilder().mergeFrom(playLanternUpdate);
    }

    public static PlayLanternUpdate parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlayLanternUpdate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlayLanternUpdate parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PlayLanternUpdate) PARSER.parseFrom(byteString);
    }

    public static PlayLanternUpdate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PlayLanternUpdate) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlayLanternUpdate parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlayLanternUpdate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PlayLanternUpdate parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PlayLanternUpdate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlayLanternUpdate parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PlayLanternUpdate) PARSER.parseFrom(byteBuffer);
    }

    public static PlayLanternUpdate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PlayLanternUpdate) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlayLanternUpdate parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PlayLanternUpdate) PARSER.parseFrom(bArr);
    }

    public static PlayLanternUpdate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PlayLanternUpdate) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<PlayLanternUpdate> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PlayLanternUpdate) {
            PlayLanternUpdate playLanternUpdate = (PlayLanternUpdate) obj;
            return getLanternResourceList().equals(playLanternUpdate.getLanternResourceList()) && this.unknownFields.equals(playLanternUpdate.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public PlayLanternUpdate m6924getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.PlayLanternUpdateOrBuilder
    public lantern getLanternResource(int i) {
        return this.lanternResource_.get(i);
    }

    @Override // cn.irisgw.live.PlayLanternUpdateOrBuilder
    public int getLanternResourceCount() {
        return this.lanternResource_.size();
    }

    @Override // cn.irisgw.live.PlayLanternUpdateOrBuilder
    public List<lantern> getLanternResourceList() {
        return this.lanternResource_;
    }

    @Override // cn.irisgw.live.PlayLanternUpdateOrBuilder
    public lanternOrBuilder getLanternResourceOrBuilder(int i) {
        return this.lanternResource_.get(i);
    }

    @Override // cn.irisgw.live.PlayLanternUpdateOrBuilder
    public List<? extends lanternOrBuilder> getLanternResourceOrBuilderList() {
        return this.lanternResource_;
    }

    public Parser<PlayLanternUpdate> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.lanternResource_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.lanternResource_.get(i3));
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
        if (getLanternResourceCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getLanternResourceList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_PlayLanternUpdate_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayLanternUpdate.class, Builder.class);
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
    public Builder m6927newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m6926newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new PlayLanternUpdate();
    }

    /* renamed from: toBuilder */
    public Builder m6929toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.lanternResource_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(1, this.lanternResource_.get(i2));
                i = i2 + 1;
            }
        }
    }
}
