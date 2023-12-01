package com.blued.android.module.svgaplayer.proto;

import com.anythink.expressad.foundation.d.d;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/proto/SpriteEntity.class */
public final class SpriteEntity extends Message<SpriteEntity, Builder> {
    public static final ProtoAdapter<SpriteEntity> ADAPTER = new ProtoAdapter_SpriteEntity();
    public static final String DEFAULT_IMAGEKEY = "";
    public static final String DEFAULT_MATTEKEY = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.blued.android.module.svgaplayer.proto.FrameEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<FrameEntity> frames;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String imageKey;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String matteKey;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/proto/SpriteEntity$Builder.class */
    public static final class Builder extends Message.Builder<SpriteEntity, Builder> {
        public List<FrameEntity> frames = Internal.newMutableList();
        public String imageKey;
        public String matteKey;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public SpriteEntity build() {
            return new SpriteEntity(this.imageKey, this.frames, this.matteKey, super.buildUnknownFields());
        }

        public Builder frames(List<FrameEntity> list) {
            Internal.checkElementsNotNull(list);
            this.frames = list;
            return this;
        }

        public Builder imageKey(String str) {
            this.imageKey = str;
            return this;
        }

        public Builder matteKey(String str) {
            this.matteKey = str;
            return this;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/proto/SpriteEntity$ProtoAdapter_SpriteEntity.class */
    static final class ProtoAdapter_SpriteEntity extends ProtoAdapter<SpriteEntity> {
        ProtoAdapter_SpriteEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, SpriteEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SpriteEntity decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.imageKey(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.frames.add(FrameEntity.ADAPTER.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.matteKey(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SpriteEntity spriteEntity) throws IOException {
            if (spriteEntity.imageKey != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, (int) spriteEntity.imageKey);
            }
            FrameEntity.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, (int) spriteEntity.frames);
            if (spriteEntity.matteKey != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, (int) spriteEntity.matteKey);
            }
            protoWriter.writeBytes(spriteEntity.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(SpriteEntity spriteEntity) {
            int i = 0;
            int encodedSizeWithTag = spriteEntity.imageKey != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, spriteEntity.imageKey) : 0;
            int encodedSizeWithTag2 = FrameEntity.ADAPTER.asRepeated().encodedSizeWithTag(2, spriteEntity.frames);
            if (spriteEntity.matteKey != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(3, spriteEntity.matteKey);
            }
            return encodedSizeWithTag + encodedSizeWithTag2 + i + spriteEntity.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public SpriteEntity redact(SpriteEntity spriteEntity) {
            Builder newBuilder = spriteEntity.newBuilder();
            Internal.redactElements(newBuilder.frames, FrameEntity.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SpriteEntity(String str, List<FrameEntity> list, String str2) {
        this(str, list, str2, ByteString.EMPTY);
    }

    public SpriteEntity(String str, List<FrameEntity> list, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.imageKey = str;
        this.frames = Internal.immutableCopyOf(d.j, list);
        this.matteKey = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpriteEntity) {
            SpriteEntity spriteEntity = (SpriteEntity) obj;
            return unknownFields().equals(spriteEntity.unknownFields()) && Internal.equals(this.imageKey, spriteEntity.imageKey) && this.frames.equals(spriteEntity.frames) && Internal.equals(this.matteKey, spriteEntity.matteKey);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        int i2 = i;
        if (i == 0) {
            int hashCode = unknownFields().hashCode();
            String str = this.imageKey;
            int i3 = 0;
            int hashCode2 = str != null ? str.hashCode() : 0;
            int hashCode3 = this.frames.hashCode();
            String str2 = this.matteKey;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            i2 = (((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + i3;
            this.hashCode = i2;
        }
        return i2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.imageKey = this.imageKey;
        builder.frames = Internal.copyOf(d.j, this.frames);
        builder.matteKey = this.matteKey;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.imageKey != null) {
            sb.append(", imageKey=");
            sb.append(this.imageKey);
        }
        if (!this.frames.isEmpty()) {
            sb.append(", frames=");
            sb.append(this.frames);
        }
        if (this.matteKey != null) {
            sb.append(", matteKey=");
            sb.append(this.matteKey);
        }
        StringBuilder replace = sb.replace(0, 2, "SpriteEntity{");
        replace.append('}');
        return replace.toString();
    }
}
