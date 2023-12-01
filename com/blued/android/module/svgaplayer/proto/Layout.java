package com.blued.android.module.svgaplayer.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/proto/Layout.class */
public final class Layout extends Message<Layout, Builder> {
    public static final ProtoAdapter<Layout> ADAPTER = new ProtoAdapter_Layout();
    public static final Float DEFAULT_HEIGHT;
    public static final Float DEFAULT_WIDTH;
    public static final Float DEFAULT_X;
    public static final Float DEFAULT_Y;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float height;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float width;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float x;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float y;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/proto/Layout$Builder.class */
    public static final class Builder extends Message.Builder<Layout, Builder> {
        public Float height;
        public Float width;
        public Float x;
        public Float y;

        /* renamed from: build */
        public Layout m10553build() {
            return new Layout(this.x, this.y, this.width, this.height, super.buildUnknownFields());
        }

        public Builder height(Float f) {
            this.height = f;
            return this;
        }

        public Builder width(Float f) {
            this.width = f;
            return this;
        }

        public Builder x(Float f) {
            this.x = f;
            return this;
        }

        public Builder y(Float f) {
            this.y = f;
            return this;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/proto/Layout$ProtoAdapter_Layout.class */
    static final class ProtoAdapter_Layout extends ProtoAdapter<Layout> {
        ProtoAdapter_Layout() {
            super(FieldEncoding.LENGTH_DELIMITED, Layout.class);
        }

        /* renamed from: decode */
        public Layout m10554decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.m10553build();
                } else if (nextTag == 1) {
                    builder.x((Float) ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.y((Float) ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.width((Float) ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.height((Float) ProtoAdapter.FLOAT.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, Layout layout) throws IOException {
            if (layout.x != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, layout.x);
            }
            if (layout.y != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, layout.y);
            }
            if (layout.width != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, layout.width);
            }
            if (layout.height != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, layout.height);
            }
            protoWriter.writeBytes(layout.unknownFields());
        }

        public int encodedSize(Layout layout) {
            int i = 0;
            int encodedSizeWithTag = layout.x != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, layout.x) : 0;
            int encodedSizeWithTag2 = layout.y != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, layout.y) : 0;
            int encodedSizeWithTag3 = layout.width != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, layout.width) : 0;
            if (layout.height != null) {
                i = ProtoAdapter.FLOAT.encodedSizeWithTag(4, layout.height);
            }
            return encodedSizeWithTag + encodedSizeWithTag2 + encodedSizeWithTag3 + i + layout.unknownFields().size();
        }

        public Layout redact(Layout layout) {
            Builder m10552newBuilder = layout.m10552newBuilder();
            m10552newBuilder.clearUnknownFields();
            return m10552newBuilder.m10553build();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
        DEFAULT_WIDTH = valueOf;
        DEFAULT_HEIGHT = valueOf;
    }

    public Layout(Float f, Float f2, Float f3, Float f4) {
        this(f, f2, f3, f4, ByteString.EMPTY);
    }

    public Layout(Float f, Float f2, Float f3, Float f4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Layout) {
            Layout layout = (Layout) obj;
            return unknownFields().equals(layout.unknownFields()) && Internal.equals(this.x, layout.x) && Internal.equals(this.y, layout.y) && Internal.equals(this.width, layout.width) && Internal.equals(this.height, layout.height);
        }
        return false;
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        int i2 = i;
        if (i == 0) {
            int hashCode = unknownFields().hashCode();
            Float f = this.x;
            int i3 = 0;
            int hashCode2 = f != null ? f.hashCode() : 0;
            Float f2 = this.y;
            int hashCode3 = f2 != null ? f2.hashCode() : 0;
            Float f3 = this.width;
            int hashCode4 = f3 != null ? f3.hashCode() : 0;
            Float f4 = this.height;
            if (f4 != null) {
                i3 = f4.hashCode();
            }
            i2 = (((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + i3;
            ((Message) this).hashCode = i2;
        }
        return i2;
    }

    /* renamed from: newBuilder */
    public Builder m10552newBuilder() {
        Builder builder = new Builder();
        builder.x = this.x;
        builder.y = this.y;
        builder.width = this.width;
        builder.height = this.height;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.x != null) {
            sb.append(", x=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", y=");
            sb.append(this.y);
        }
        if (this.width != null) {
            sb.append(", width=");
            sb.append(this.width);
        }
        if (this.height != null) {
            sb.append(", height=");
            sb.append(this.height);
        }
        StringBuilder replace = sb.replace(0, 2, "Layout{");
        replace.append('}');
        return replace.toString();
    }
}
