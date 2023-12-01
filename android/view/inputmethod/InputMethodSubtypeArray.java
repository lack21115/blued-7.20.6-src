package android.view.inputmethod;

import android.os.Parcel;
import android.util.Slog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/InputMethodSubtypeArray.class */
public class InputMethodSubtypeArray {
    private static final String TAG = "InputMethodSubtypeArray";
    private volatile byte[] mCompressedData;
    private final int mCount;
    private volatile int mDecompressedSize;
    private volatile InputMethodSubtype[] mInstance;
    private final Object mLockObject = new Object();

    public InputMethodSubtypeArray(Parcel parcel) {
        this.mCount = parcel.readInt();
        if (this.mCount > 0) {
            this.mDecompressedSize = parcel.readInt();
            this.mCompressedData = parcel.createByteArray();
        }
    }

    public InputMethodSubtypeArray(List<InputMethodSubtype> list) {
        if (list == null) {
            this.mCount = 0;
            return;
        }
        this.mCount = list.size();
        this.mInstance = (InputMethodSubtype[]) list.toArray(new InputMethodSubtype[this.mCount]);
    }

    private static byte[] compress(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr2;
        ByteArrayOutputStream byteArrayOutputStream3;
        try {
            ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream4);
                try {
                    gZIPOutputStream.write(bArr);
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e) {
                            Slog.e(TAG, "Failed to close the stream.", e);
                        }
                    }
                    if (byteArrayOutputStream4 != null) {
                        try {
                            byteArrayOutputStream4.close();
                        } catch (IOException e2) {
                            byteArrayOutputStream3 = null;
                            Slog.e(TAG, "Failed to close the stream.", e2);
                        }
                    }
                    byteArrayOutputStream3 = byteArrayOutputStream4;
                    bArr2 = null;
                    if (byteArrayOutputStream3 != null) {
                        bArr2 = byteArrayOutputStream3.toByteArray();
                    }
                } catch (IOException e3) {
                    byteArrayOutputStream2 = byteArrayOutputStream4;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e4) {
                            Slog.e(TAG, "Failed to close the stream.", e4);
                        }
                    }
                    bArr2 = null;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                            return null;
                        } catch (IOException e5) {
                            Slog.e(TAG, "Failed to close the stream.", e5);
                            return null;
                        }
                    }
                    return bArr2;
                } catch (Throwable th) {
                    byteArrayOutputStream = byteArrayOutputStream4;
                    th = th;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e6) {
                            Slog.e(TAG, "Failed to close the stream.", e6);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e7) {
                            Slog.e(TAG, "Failed to close the stream.", e7);
                        }
                    }
                    throw th;
                }
            } catch (IOException e8) {
                byteArrayOutputStream2 = byteArrayOutputStream4;
                gZIPOutputStream = null;
            } catch (Throwable th2) {
                byteArrayOutputStream = byteArrayOutputStream4;
                gZIPOutputStream = null;
                th = th2;
            }
        } catch (IOException e9) {
            gZIPOutputStream = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
            byteArrayOutputStream = null;
        }
        return bArr2;
    }

    private static byte[] decompress(byte[] bArr, int i) {
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        int i2;
        int read;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            } catch (IOException e) {
                gZIPInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            gZIPInputStream = null;
            byteArrayInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[i];
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= bArr2.length || (read = gZIPInputStream.read(bArr2, i2, bArr2.length - i2)) < 0) {
                    break;
                }
                i3 = i2 + read;
            }
            if (i == i2) {
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (IOException e3) {
                        Slog.e(TAG, "Failed to close the stream.", e3);
                    }
                }
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e4) {
                        Slog.e(TAG, "Failed to close the stream.", e4);
                    }
                }
                return bArr2;
            }
            if (gZIPInputStream != null) {
                try {
                    gZIPInputStream.close();
                } catch (IOException e5) {
                    Slog.e(TAG, "Failed to close the stream.", e5);
                }
            }
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                    return null;
                } catch (IOException e6) {
                    Slog.e(TAG, "Failed to close the stream.", e6);
                    return null;
                }
            }
            return null;
        } catch (IOException e7) {
            if (gZIPInputStream != null) {
                try {
                    gZIPInputStream.close();
                } catch (IOException e8) {
                    Slog.e(TAG, "Failed to close the stream.", e8);
                }
            }
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                    return null;
                } catch (IOException e9) {
                    Slog.e(TAG, "Failed to close the stream.", e9);
                    return null;
                }
            }
            return null;
        } catch (Throwable th3) {
            gZIPInputStream2 = gZIPInputStream;
            th = th3;
            if (gZIPInputStream2 != null) {
                try {
                    gZIPInputStream2.close();
                } catch (IOException e10) {
                    Slog.e(TAG, "Failed to close the stream.", e10);
                }
            }
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e11) {
                    Slog.e(TAG, "Failed to close the stream.", e11);
                }
            }
            throw th;
        }
    }

    private static byte[] marshall(InputMethodSubtype[] inputMethodSubtypeArr) {
        Parcel parcel = null;
        try {
            Parcel obtain = Parcel.obtain();
            obtain.writeTypedArray(inputMethodSubtypeArr, 0);
            parcel = obtain;
            byte[] marshall = obtain.marshall();
            if (obtain != null) {
                obtain.recycle();
            }
            return marshall;
        } catch (Throwable th) {
            if (parcel != null) {
                parcel.recycle();
            }
            throw th;
        }
    }

    private static InputMethodSubtype[] unmarshall(byte[] bArr) {
        Parcel parcel = null;
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            parcel = obtain;
            InputMethodSubtype[] inputMethodSubtypeArr = (InputMethodSubtype[]) obtain.createTypedArray(InputMethodSubtype.CREATOR);
            if (obtain != null) {
                obtain.recycle();
            }
            return inputMethodSubtypeArr;
        } catch (Throwable th) {
            if (parcel != null) {
                parcel.recycle();
            }
            throw th;
        }
    }

    public InputMethodSubtype get(int i) {
        if (i < 0 || this.mCount <= i) {
            throw new ArrayIndexOutOfBoundsException();
        }
        InputMethodSubtype[] inputMethodSubtypeArr = this.mInstance;
        InputMethodSubtype[] inputMethodSubtypeArr2 = inputMethodSubtypeArr;
        if (inputMethodSubtypeArr == null) {
            synchronized (this.mLockObject) {
                InputMethodSubtype[] inputMethodSubtypeArr3 = this.mInstance;
                inputMethodSubtypeArr2 = inputMethodSubtypeArr3;
                if (inputMethodSubtypeArr3 == null) {
                    byte[] decompress = decompress(this.mCompressedData, this.mDecompressedSize);
                    this.mCompressedData = null;
                    this.mDecompressedSize = 0;
                    if (decompress != null) {
                        inputMethodSubtypeArr2 = unmarshall(decompress);
                    } else {
                        Slog.e(TAG, "Failed to decompress data. Returns null as fallback.");
                        inputMethodSubtypeArr2 = new InputMethodSubtype[this.mCount];
                    }
                    this.mInstance = inputMethodSubtypeArr2;
                }
            }
        }
        return inputMethodSubtypeArr2[i];
    }

    public int getCount() {
        return this.mCount;
    }

    public void writeToParcel(Parcel parcel) {
        if (this.mCount == 0) {
            parcel.writeInt(this.mCount);
            return;
        }
        byte[] bArr = this.mCompressedData;
        int i = this.mDecompressedSize;
        byte[] bArr2 = bArr;
        int i2 = i;
        if (bArr == null) {
            bArr2 = bArr;
            i2 = i;
            if (i == 0) {
                synchronized (this.mLockObject) {
                    byte[] bArr3 = this.mCompressedData;
                    int i3 = this.mDecompressedSize;
                    bArr2 = bArr3;
                    i2 = i3;
                    if (bArr3 == null) {
                        bArr2 = bArr3;
                        i2 = i3;
                        if (i3 == 0) {
                            byte[] marshall = marshall(this.mInstance);
                            bArr2 = compress(marshall);
                            if (bArr2 == null) {
                                i2 = -1;
                                Slog.i(TAG, "Failed to compress data.");
                            } else {
                                i2 = marshall.length;
                            }
                            this.mDecompressedSize = i2;
                            this.mCompressedData = bArr2;
                        }
                    }
                }
            }
        }
        if (bArr2 == null || i2 <= 0) {
            Slog.i(TAG, "Unexpected state. Behaving as an empty array.");
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.mCount);
        parcel.writeInt(i2);
        parcel.writeByteArray(bArr2);
    }
}
