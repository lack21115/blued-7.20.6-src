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

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/proto/MovieParams.class */
public final class MovieParams extends Message<MovieParams, Builder> {
    public static final ProtoAdapter<MovieParams> ADAPTER = new ProtoAdapter_MovieParams();
    public static final Integer DEFAULT_FPS;
    public static final Integer DEFAULT_FRAMES;
    public static final Float DEFAULT_VIEWBOXHEIGHT;
    public static final Float DEFAULT_VIEWBOXWIDTH;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer fps;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer frames;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float viewBoxHeight;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float viewBoxWidth;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/proto/MovieParams$Builder.class */
    public static final class Builder extends Message.Builder<MovieParams, Builder> {
        public Integer fps;
        public Integer frames;
        public Float viewBoxHeight;
        public Float viewBoxWidth;

        /* renamed from: build */
        public MovieParams m10561build() {
            return new MovieParams(this.viewBoxWidth, this.viewBoxHeight, this.fps, this.frames, super.buildUnknownFields());
        }

        public Builder fps(Integer num) {
            this.fps = num;
            return this;
        }

        public Builder frames(Integer num) {
            this.frames = num;
            return this;
        }

        public Builder viewBoxHeight(Float f) {
            this.viewBoxHeight = f;
            return this;
        }

        public Builder viewBoxWidth(Float f) {
            this.viewBoxWidth = f;
            return this;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/proto/MovieParams$ProtoAdapter_MovieParams.class */
    static final class ProtoAdapter_MovieParams extends ProtoAdapter<MovieParams> {
        ProtoAdapter_MovieParams() {
            super(FieldEncoding.LENGTH_DELIMITED, MovieParams.class);
        }

        /* renamed from: decode */
        public MovieParams m10562decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.m10561build();
                } else if (nextTag == 1) {
                    builder.viewBoxWidth((Float) ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.viewBoxHeight((Float) ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.fps((Integer) ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.frames((Integer) ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, MovieParams movieParams) throws IOException {
            if (movieParams.viewBoxWidth != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, movieParams.viewBoxWidth);
            }
            if (movieParams.viewBoxHeight != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, movieParams.viewBoxHeight);
            }
            if (movieParams.fps != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, movieParams.fps);
            }
            if (movieParams.frames != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, movieParams.frames);
            }
            protoWriter.writeBytes(movieParams.unknownFields());
        }

        public int encodedSize(MovieParams movieParams) {
            int i = 0;
            int encodedSizeWithTag = movieParams.viewBoxWidth != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, movieParams.viewBoxWidth) : 0;
            int encodedSizeWithTag2 = movieParams.viewBoxHeight != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, movieParams.viewBoxHeight) : 0;
            int encodedSizeWithTag3 = movieParams.fps != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, movieParams.fps) : 0;
            if (movieParams.frames != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(4, movieParams.frames);
            }
            return encodedSizeWithTag + encodedSizeWithTag2 + encodedSizeWithTag3 + i + movieParams.unknownFields().size();
        }

        public MovieParams redact(MovieParams movieParams) {
            Builder m10560newBuilder = movieParams.m10560newBuilder();
            m10560newBuilder.clearUnknownFields();
            return m10560newBuilder.m10561build();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_VIEWBOXWIDTH = valueOf;
        DEFAULT_VIEWBOXHEIGHT = valueOf;
        DEFAULT_FPS = 0;
        DEFAULT_FRAMES = 0;
    }

    public MovieParams(Float f, Float f2, Integer num, Integer num2) {
        this(f, f2, num, num2, ByteString.EMPTY);
    }

    public MovieParams(Float f, Float f2, Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.viewBoxWidth = f;
        this.viewBoxHeight = f2;
        this.fps = num;
        this.frames = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MovieParams) {
            MovieParams movieParams = (MovieParams) obj;
            return unknownFields().equals(movieParams.unknownFields()) && Internal.equals(this.viewBoxWidth, movieParams.viewBoxWidth) && Internal.equals(this.viewBoxHeight, movieParams.viewBoxHeight) && Internal.equals(this.fps, movieParams.fps) && Internal.equals(this.frames, movieParams.frames);
        }
        return false;
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        int i2 = i;
        if (i == 0) {
            int hashCode = unknownFields().hashCode();
            Float f = this.viewBoxWidth;
            int i3 = 0;
            int hashCode2 = f != null ? f.hashCode() : 0;
            Float f2 = this.viewBoxHeight;
            int hashCode3 = f2 != null ? f2.hashCode() : 0;
            Integer num = this.fps;
            int hashCode4 = num != null ? num.hashCode() : 0;
            Integer num2 = this.frames;
            if (num2 != null) {
                i3 = num2.hashCode();
            }
            i2 = (((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + i3;
            ((Message) this).hashCode = i2;
        }
        return i2;
    }

    /* renamed from: newBuilder */
    public Builder m10560newBuilder() {
        Builder builder = new Builder();
        builder.viewBoxWidth = this.viewBoxWidth;
        builder.viewBoxHeight = this.viewBoxHeight;
        builder.fps = this.fps;
        builder.frames = this.frames;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.viewBoxWidth != null) {
            sb.append(", viewBoxWidth=");
            sb.append(this.viewBoxWidth);
        }
        if (this.viewBoxHeight != null) {
            sb.append(", viewBoxHeight=");
            sb.append(this.viewBoxHeight);
        }
        if (this.fps != null) {
            sb.append(", fps=");
            sb.append(this.fps);
        }
        if (this.frames != null) {
            sb.append(", frames=");
            sb.append(this.frames);
        }
        StringBuilder replace = sb.replace(0, 2, "MovieParams{");
        replace.append('}');
        return replace.toString();
    }
}
