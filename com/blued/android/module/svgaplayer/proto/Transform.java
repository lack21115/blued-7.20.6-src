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

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/proto/Transform.class */
public final class Transform extends Message<Transform, Builder> {
    public static final ProtoAdapter<Transform> ADAPTER = new ProtoAdapter_Transform();
    public static final Float DEFAULT_A;
    public static final Float DEFAULT_B;
    public static final Float DEFAULT_C;
    public static final Float DEFAULT_D;
    public static final Float DEFAULT_TX;
    public static final Float DEFAULT_TY;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float a;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float b;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float c;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float d;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    public final Float tx;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    public final Float ty;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/proto/Transform$Builder.class */
    public static final class Builder extends Message.Builder<Transform, Builder> {
        public Float a;
        public Float b;
        public Float c;
        public Float d;
        public Float tx;
        public Float ty;

        public Builder a(Float f) {
            this.a = f;
            return this;
        }

        public Builder b(Float f) {
            this.b = f;
            return this;
        }

        /* renamed from: build */
        public Transform m10596build() {
            return new Transform(this.a, this.b, this.c, this.d, this.tx, this.ty, super.buildUnknownFields());
        }

        public Builder c(Float f) {
            this.c = f;
            return this;
        }

        public Builder d(Float f) {
            this.d = f;
            return this;
        }

        public Builder tx(Float f) {
            this.tx = f;
            return this;
        }

        public Builder ty(Float f) {
            this.ty = f;
            return this;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/proto/Transform$ProtoAdapter_Transform.class */
    static final class ProtoAdapter_Transform extends ProtoAdapter<Transform> {
        ProtoAdapter_Transform() {
            super(FieldEncoding.LENGTH_DELIMITED, Transform.class);
        }

        /* renamed from: decode */
        public Transform m10597decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.m10596build();
                }
                switch (nextTag) {
                    case 1:
                        builder.a((Float) ProtoAdapter.FLOAT.decode(protoReader));
                        break;
                    case 2:
                        builder.b((Float) ProtoAdapter.FLOAT.decode(protoReader));
                        break;
                    case 3:
                        builder.c((Float) ProtoAdapter.FLOAT.decode(protoReader));
                        break;
                    case 4:
                        builder.d((Float) ProtoAdapter.FLOAT.decode(protoReader));
                        break;
                    case 5:
                        builder.tx((Float) ProtoAdapter.FLOAT.decode(protoReader));
                        break;
                    case 6:
                        builder.ty((Float) ProtoAdapter.FLOAT.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter protoWriter, Transform transform) throws IOException {
            if (transform.a != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, transform.a);
            }
            if (transform.b != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, transform.b);
            }
            if (transform.c != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, transform.c);
            }
            if (transform.d != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, transform.d);
            }
            if (transform.tx != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 5, transform.tx);
            }
            if (transform.ty != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 6, transform.ty);
            }
            protoWriter.writeBytes(transform.unknownFields());
        }

        public int encodedSize(Transform transform) {
            int i = 0;
            int encodedSizeWithTag = transform.a != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, transform.a) : 0;
            int encodedSizeWithTag2 = transform.b != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, transform.b) : 0;
            int encodedSizeWithTag3 = transform.c != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, transform.c) : 0;
            int encodedSizeWithTag4 = transform.d != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, transform.d) : 0;
            int encodedSizeWithTag5 = transform.tx != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(5, transform.tx) : 0;
            if (transform.ty != null) {
                i = ProtoAdapter.FLOAT.encodedSizeWithTag(6, transform.ty);
            }
            return encodedSizeWithTag + encodedSizeWithTag2 + encodedSizeWithTag3 + encodedSizeWithTag4 + encodedSizeWithTag5 + i + transform.unknownFields().size();
        }

        public Transform redact(Transform transform) {
            Builder m10595newBuilder = transform.m10595newBuilder();
            m10595newBuilder.clearUnknownFields();
            return m10595newBuilder.m10596build();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_A = valueOf;
        DEFAULT_B = valueOf;
        DEFAULT_C = valueOf;
        DEFAULT_D = valueOf;
        DEFAULT_TX = valueOf;
        DEFAULT_TY = valueOf;
    }

    public Transform(Float f, Float f2, Float f3, Float f4, Float f5, Float f6) {
        this(f, f2, f3, f4, f5, f6, ByteString.EMPTY);
    }

    public Transform(Float f, Float f2, Float f3, Float f4, Float f5, Float f6, ByteString byteString) {
        super(ADAPTER, byteString);
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.tx = f5;
        this.ty = f6;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Transform) {
            Transform transform = (Transform) obj;
            return unknownFields().equals(transform.unknownFields()) && Internal.equals(this.a, transform.a) && Internal.equals(this.b, transform.b) && Internal.equals(this.c, transform.c) && Internal.equals(this.d, transform.d) && Internal.equals(this.tx, transform.tx) && Internal.equals(this.ty, transform.ty);
        }
        return false;
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        int i2 = i;
        if (i == 0) {
            int hashCode = unknownFields().hashCode();
            Float f = this.a;
            int i3 = 0;
            int hashCode2 = f != null ? f.hashCode() : 0;
            Float f2 = this.b;
            int hashCode3 = f2 != null ? f2.hashCode() : 0;
            Float f3 = this.c;
            int hashCode4 = f3 != null ? f3.hashCode() : 0;
            Float f4 = this.d;
            int hashCode5 = f4 != null ? f4.hashCode() : 0;
            Float f5 = this.tx;
            int hashCode6 = f5 != null ? f5.hashCode() : 0;
            Float f6 = this.ty;
            if (f6 != null) {
                i3 = f6.hashCode();
            }
            i2 = (((((((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + hashCode5) * 37) + hashCode6) * 37) + i3;
            ((Message) this).hashCode = i2;
        }
        return i2;
    }

    /* renamed from: newBuilder */
    public Builder m10595newBuilder() {
        Builder builder = new Builder();
        builder.a = this.a;
        builder.b = this.b;
        builder.c = this.c;
        builder.d = this.d;
        builder.tx = this.tx;
        builder.ty = this.ty;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.a != null) {
            sb.append(", a=");
            sb.append(this.a);
        }
        if (this.b != null) {
            sb.append(", b=");
            sb.append(this.b);
        }
        if (this.c != null) {
            sb.append(", c=");
            sb.append(this.c);
        }
        if (this.d != null) {
            sb.append(", d=");
            sb.append(this.d);
        }
        if (this.tx != null) {
            sb.append(", tx=");
            sb.append(this.tx);
        }
        if (this.ty != null) {
            sb.append(", ty=");
            sb.append(this.ty);
        }
        StringBuilder replace = sb.replace(0, 2, "Transform{");
        replace.append('}');
        return replace.toString();
    }
}
