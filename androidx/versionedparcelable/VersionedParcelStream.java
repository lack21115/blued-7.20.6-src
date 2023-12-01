package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:androidx/versionedparcelable/VersionedParcelStream.class */
class VersionedParcelStream extends VersionedParcel {
    private static final Charset f = Charset.forName("UTF-16");
    int d;
    int e;
    private final DataInputStream g;
    private final DataOutputStream h;
    private DataInputStream i;
    private DataOutputStream j;
    private FieldBuffer k;
    private boolean l;
    private int m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/versionedparcelable/VersionedParcelStream$FieldBuffer.class */
    public static class FieldBuffer {

        /* renamed from: a  reason: collision with root package name */
        final ByteArrayOutputStream f3548a = new ByteArrayOutputStream();
        final DataOutputStream b = new DataOutputStream(this.f3548a);

        /* renamed from: c  reason: collision with root package name */
        private final int f3549c;
        private final DataOutputStream d;

        FieldBuffer(int i, DataOutputStream dataOutputStream) {
            this.f3549c = i;
            this.d = dataOutputStream;
        }

        void a() throws IOException {
            this.b.flush();
            int size = this.f3548a.size();
            this.d.writeInt((this.f3549c << 16) | (size >= 65535 ? 65535 : size));
            if (size >= 65535) {
                this.d.writeInt(size);
            }
            this.f3548a.writeTo(this.d);
        }
    }

    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private VersionedParcelStream(InputStream inputStream, OutputStream outputStream, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.d = 0;
        this.m = -1;
        this.e = -1;
        this.g = inputStream != null ? new DataInputStream(new FilterInputStream(inputStream) { // from class: androidx.versionedparcelable.VersionedParcelStream.1
            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (VersionedParcelStream.this.e == -1 || VersionedParcelStream.this.d < VersionedParcelStream.this.e) {
                    int read = super.read();
                    VersionedParcelStream.this.d++;
                    return read;
                }
                throw new IOException();
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (VersionedParcelStream.this.e == -1 || VersionedParcelStream.this.d < VersionedParcelStream.this.e) {
                    int read = super.read(bArr, i, i2);
                    if (read > 0) {
                        VersionedParcelStream.this.d += read;
                    }
                    return read;
                }
                throw new IOException();
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) throws IOException {
                if (VersionedParcelStream.this.e == -1 || VersionedParcelStream.this.d < VersionedParcelStream.this.e) {
                    long skip = super.skip(j);
                    if (skip > 0) {
                        VersionedParcelStream.this.d += (int) skip;
                    }
                    return skip;
                }
                throw new IOException();
            }
        }) : null;
        DataOutputStream dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : null;
        this.h = dataOutputStream;
        this.i = this.g;
        this.j = dataOutputStream;
    }

    private void a(int i, String str, Bundle bundle) {
        switch (i) {
            case 0:
                bundle.putParcelable(str, null);
                return;
            case 1:
                bundle.putBundle(str, readBundle());
                return;
            case 2:
                bundle.putBundle(str, readBundle());
                return;
            case 3:
                bundle.putString(str, readString());
                return;
            case 4:
                bundle.putStringArray(str, (String[]) b(new String[0]));
                return;
            case 5:
                bundle.putBoolean(str, readBoolean());
                return;
            case 6:
                bundle.putBooleanArray(str, c());
                return;
            case 7:
                bundle.putDouble(str, readDouble());
                return;
            case 8:
                bundle.putDoubleArray(str, g());
                return;
            case 9:
                bundle.putInt(str, readInt());
                return;
            case 10:
                bundle.putIntArray(str, d());
                return;
            case 11:
                bundle.putLong(str, readLong());
                return;
            case 12:
                bundle.putLongArray(str, e());
                return;
            case 13:
                bundle.putFloat(str, readFloat());
                return;
            case 14:
                bundle.putFloatArray(str, f());
                return;
            default:
                throw new RuntimeException("Unknown type " + i);
        }
    }

    private void a(Object obj) {
        if (obj == null) {
            writeInt(0);
        } else if (obj instanceof Bundle) {
            writeInt(1);
            writeBundle((Bundle) obj);
        } else if (obj instanceof String) {
            writeInt(3);
            writeString((String) obj);
        } else if (obj instanceof String[]) {
            writeInt(4);
            a((Object[]) ((String[]) obj));
        } else if (obj instanceof Boolean) {
            writeInt(5);
            writeBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            writeInt(6);
            a((boolean[]) obj);
        } else if (obj instanceof Double) {
            writeInt(7);
            writeDouble(((Double) obj).doubleValue());
        } else if (obj instanceof double[]) {
            writeInt(8);
            a((double[]) obj);
        } else if (obj instanceof Integer) {
            writeInt(9);
            writeInt(((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            writeInt(10);
            a((int[]) obj);
        } else if (obj instanceof Long) {
            writeInt(11);
            writeLong(((Long) obj).longValue());
        } else if (obj instanceof long[]) {
            writeInt(12);
            a((long[]) obj);
        } else if (obj instanceof Float) {
            writeInt(13);
            writeFloat(((Float) obj).floatValue());
        } else if (obj instanceof float[]) {
            writeInt(14);
            a((float[]) obj);
        } else {
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel a() {
        return new VersionedParcelStream(this.i, this.j, this.f3544a, this.b, this.f3545c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void a(CharSequence charSequence) {
        if (!this.l) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence b() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        FieldBuffer fieldBuffer = this.k;
        if (fieldBuffer != null) {
            try {
                if (fieldBuffer.f3548a.size() != 0) {
                    this.k.a();
                }
                this.k = null;
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean isStream() {
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        try {
            return this.i.readBoolean();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return bundle;
            }
            a(readInt(), readString(), bundle);
            i = i2 + 1;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        try {
            int readInt = this.i.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                this.i.readFully(bArr);
                return bArr;
            }
            return null;
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        try {
            return this.i.readDouble();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int i) {
        while (this.m != i) {
            try {
                if (String.valueOf(this.m).compareTo(String.valueOf(i)) > 0) {
                    return false;
                }
                if (this.d < this.e) {
                    this.g.skip(this.e - this.d);
                }
                this.e = -1;
                int readInt = this.g.readInt();
                this.d = 0;
                int i2 = readInt & 65535;
                int i3 = i2;
                if (i2 == 65535) {
                    i3 = this.g.readInt();
                }
                this.m = (readInt >> 16) & 65535;
                this.e = i3;
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        try {
            return this.i.readFloat();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        try {
            return this.i.readInt();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        try {
            return this.i.readLong();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        try {
            int readInt = this.i.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                this.i.readFully(bArr);
                return new String(bArr, f);
            }
            return null;
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int i) {
        closeField();
        FieldBuffer fieldBuffer = new FieldBuffer(i, this.h);
        this.k = fieldBuffer;
        this.j = fieldBuffer.b;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setSerializationFlags(boolean z, boolean z2) {
        if (!z) {
            throw new RuntimeException("Serialization of this object is not allowed");
        }
        this.l = z2;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean z) {
        try {
            this.j.writeBoolean(z);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle bundle) {
        try {
            if (bundle == null) {
                this.j.writeInt(-1);
                return;
            }
            Set<String> keySet = bundle.keySet();
            this.j.writeInt(keySet.size());
            for (String str : keySet) {
                writeString(str);
                a(bundle.get(str));
            }
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr) {
        try {
            if (bArr == null) {
                this.j.writeInt(-1);
                return;
            }
            this.j.writeInt(bArr.length);
            this.j.write(bArr);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr, int i, int i2) {
        try {
            if (bArr == null) {
                this.j.writeInt(-1);
                return;
            }
            this.j.writeInt(i2);
            this.j.write(bArr, i, i2);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double d) {
        try {
            this.j.writeDouble(d);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float f2) {
        try {
            this.j.writeFloat(f2);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int i) {
        try {
            this.j.writeInt(i);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long j) {
        try {
            this.j.writeLong(j);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable parcelable) {
        if (!this.l) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String str) {
        try {
            if (str == null) {
                this.j.writeInt(-1);
                return;
            }
            byte[] bytes = str.getBytes(f);
            this.j.writeInt(bytes.length);
            this.j.write(bytes);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder iBinder) {
        if (!this.l) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface iInterface) {
        if (!this.l) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }
}
