package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.reflect.Array;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/AndroidMessage.class */
public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.Builder<M, B>> extends Message<M, B> implements Parcelable {
    public static final Companion Companion = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/AndroidMessage$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> protoAdapter) {
            Intrinsics.e(protoAdapter, "adapter");
            return new ProtoAdapterCreator(protoAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/AndroidMessage$ProtoAdapterCreator.class */
    public static final class ProtoAdapterCreator<M> implements Parcelable.Creator<M> {
        private final ProtoAdapter<M> adapter;

        public ProtoAdapterCreator(ProtoAdapter<M> protoAdapter) {
            Intrinsics.e(protoAdapter, "adapter");
            this.adapter = protoAdapter;
        }

        @Override // android.os.Parcelable.Creator
        public M createFromParcel(Parcel parcel) {
            Intrinsics.e(parcel, "input");
            ProtoAdapter<M> protoAdapter = this.adapter;
            byte[] createByteArray = parcel.createByteArray();
            Intrinsics.c(createByteArray, "input.createByteArray()");
            return protoAdapter.decode(createByteArray);
        }

        @Override // android.os.Parcelable.Creator
        public M[] newArray(int i) {
            KClass<?> type = this.adapter.getType();
            Object newInstance = Array.newInstance(type == null ? null : JvmClassMappingKt.b(type), i);
            if (newInstance != null) {
                return (M[]) ((Object[]) newInstance);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<M of com.squareup.wire.AndroidMessage.ProtoAdapterCreator>");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected AndroidMessage(ProtoAdapter<M> protoAdapter, ByteString byteString) {
        super(protoAdapter, byteString);
        Intrinsics.e(protoAdapter, "adapter");
        Intrinsics.e(byteString, "unknownFields");
    }

    @JvmStatic
    public static final <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> protoAdapter) {
        return Companion.newCreator(protoAdapter);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.e(parcel, "dest");
        parcel.writeByteArray(encode());
    }
}
