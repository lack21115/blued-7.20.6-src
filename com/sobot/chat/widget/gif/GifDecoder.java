package com.sobot.chat.widget.gif;

import android.graphics.Bitmap;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/gif/GifDecoder.class */
public class GifDecoder extends Thread {
    private static final int MaxStackSize = 4096;
    public static final int STATUS_FINISH = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARSING = 0;
    private int[] act;
    private GifAction action;
    private int bgColor;
    private int bgIndex;
    private byte[] block;
    private int blockSize;
    private GifFrame currentFrame;
    private int delay;
    private int dispose;
    private int frameCount;
    private int[] gct;
    private boolean gctFlag;
    private int gctSize;
    private byte[] gifData;
    private GifFrame gifFrame;
    public int height;
    private int ih;
    private Bitmap image;

    /* renamed from: in  reason: collision with root package name */
    private InputStream f28236in;
    private boolean interlace;
    private boolean isShow;
    private int iw;
    private int ix;
    private int iy;
    private int lastBgColor;
    private int lastDispose;
    private Bitmap lastImage;
    private int[] lct;
    private boolean lctFlag;
    private int lctSize;
    private int loopCount;
    private int lrh;
    private int lrw;
    private int lrx;
    private int lry;
    private int pixelAspect;
    private byte[] pixelStack;
    private byte[] pixels;
    private short[] prefix;
    private int status;
    private byte[] suffix;
    private int transIndex;
    private boolean transparency;
    public int width;

    public GifDecoder(InputStream inputStream, GifAction gifAction) {
        this.loopCount = 1;
        this.currentFrame = null;
        this.isShow = false;
        this.block = new byte[256];
        this.blockSize = 0;
        this.dispose = 0;
        this.lastDispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.action = null;
        this.gifData = null;
        this.f28236in = inputStream;
        this.action = gifAction;
    }

    public GifDecoder(byte[] bArr, GifAction gifAction) {
        this.loopCount = 1;
        this.currentFrame = null;
        this.isShow = false;
        this.block = new byte[256];
        this.blockSize = 0;
        this.dispose = 0;
        this.lastDispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.action = null;
        this.gifData = null;
        this.gifData = bArr;
        this.action = gifAction;
    }

    private void decodeImageData() {
        int i;
        int i2;
        int i3;
        short s;
        int i4 = this.iw * this.ih;
        byte[] bArr = this.pixels;
        if (bArr == null || bArr.length < i4) {
            this.pixels = new byte[i4];
        }
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        int read = read();
        int i5 = 1 << read;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = read + 1;
        int i9 = (1 << i8) - 1;
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= i5) {
                break;
            }
            this.prefix[i11] = 0;
            this.suffix[i11] = (byte) i11;
            i10 = i11 + 1;
        }
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int i15 = -1;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        while (i16 < i4) {
            if (i17 != 0) {
                int i24 = i22;
                i = i17;
                i2 = i15;
                i3 = i24;
            } else if (i18 >= i12) {
                int i25 = i19 & i14;
                i19 >>= i12;
                i18 -= i12;
                if (i25 > i13 || i25 == i6) {
                    break;
                } else if (i25 == i5) {
                    i12 = i8;
                    i13 = i7;
                    i14 = i9;
                    i15 = -1;
                } else if (i15 == -1) {
                    this.pixelStack[i17] = this.suffix[i25];
                    i15 = i25;
                    i22 = i15;
                    i17++;
                } else {
                    if (i25 == i13) {
                        this.pixelStack[i17] = (byte) i22;
                        s = i15;
                        i17++;
                    } else {
                        s = i25;
                    }
                    while (s > i5) {
                        this.pixelStack[i17] = this.suffix[s];
                        s = this.prefix[s];
                        i17++;
                    }
                    int i26 = i5;
                    byte[] bArr2 = this.suffix;
                    int i27 = bArr2[s] & 255;
                    if (i13 >= 4096) {
                        break;
                    }
                    byte b = (byte) i27;
                    this.pixelStack[i17] = b;
                    this.prefix[i13] = (short) i15;
                    bArr2[i13] = b;
                    i13++;
                    int i28 = i12;
                    int i29 = i14;
                    if ((i13 & i14) == 0) {
                        i28 = i12;
                        i29 = i14;
                        if (i13 < 4096) {
                            i28 = i12 + 1;
                            i29 = i14 + i13;
                        }
                    }
                    i2 = i25;
                    i3 = i27;
                    i = i17 + 1;
                    i12 = i28;
                    i14 = i29;
                    i5 = i26;
                }
            } else {
                int i30 = i20;
                if (i20 == 0) {
                    i30 = readBlock();
                    if (i30 <= 0) {
                        break;
                    }
                    i21 = 0;
                }
                i19 += (this.block[i21] & 255) << i18;
                i18 += 8;
                i21++;
                i20 = i30 - 1;
            }
            int i31 = i - 1;
            this.pixels[i23] = this.pixelStack[i31];
            i16++;
            int i32 = i3;
            i15 = i2;
            i17 = i31;
            i22 = i32;
            i23++;
        }
        while (i23 < i4) {
            this.pixels[i23] = 0;
            i23++;
        }
    }

    private boolean err() {
        return this.status != 0;
    }

    private void init() {
        this.status = 0;
        this.frameCount = 0;
        this.gifFrame = null;
        this.gct = null;
        this.lct = null;
    }

    private int read() {
        try {
            return this.f28236in.read();
        } catch (Exception e) {
            this.status = 1;
            return 0;
        }
    }

    private int readBlock() {
        int read = read();
        this.blockSize = read;
        int i = 0;
        int i2 = 0;
        if (read > 0) {
            while (i2 < this.blockSize) {
                try {
                    int read2 = this.f28236in.read(this.block, i2, this.blockSize - i2);
                    if (read2 == -1) {
                        break;
                    }
                    i2 += read2;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            i = i2;
            if (i2 < this.blockSize) {
                this.status = 1;
                i = i2;
            }
        }
        return i;
    }

    private int readByte() {
        this.f28236in = new ByteArrayInputStream(this.gifData);
        this.gifData = null;
        return readStream();
    }

    private int[] readColorTable(int i) {
        int i2;
        int i3 = i * 3;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.f28236in.read(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        if (i2 < i3) {
            this.status = 1;
            return null;
        }
        int[] iArr = new int[256];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i) {
                return iArr;
            }
            int i7 = i4 + 1;
            byte b = bArr[i4];
            int i8 = i7 + 1;
            iArr[i6] = ((b & 255) << 16) | (-16777216) | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
            i4 = i8 + 1;
            i5 = i6 + 1;
        }
    }

    private void readContents() {
        boolean z = false;
        while (!z && !err()) {
            int read = read();
            if (read != 0) {
                if (read == 33) {
                    int read2 = read();
                    if (read2 == 249) {
                        readGraphicControlExt();
                    } else if (read2 != 255) {
                        skip();
                    } else {
                        readBlock();
                        String str = "";
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= 11) {
                                break;
                            }
                            str = str + ((char) this.block[i2]);
                            i = i2 + 1;
                        }
                        if (str.equals("NETSCAPE2.0")) {
                            readNetscapeExt();
                        } else {
                            skip();
                        }
                    }
                } else if (read == 44) {
                    readImage();
                } else if (read != 59) {
                    this.status = 1;
                } else {
                    z = true;
                }
            }
        }
    }

    private void readGraphicControlExt() {
        read();
        int read = read();
        int i = (read & 28) >> 2;
        this.dispose = i;
        boolean z = true;
        if (i == 0) {
            this.dispose = 1;
        }
        if ((read & 1) == 0) {
            z = false;
        }
        this.transparency = z;
        this.delay = readShort() * 10;
        this.transIndex = read();
        read();
    }

    private void readHeader() {
        String str = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 6) {
                break;
            }
            str = str + ((char) read());
            i = i2 + 1;
        }
        if (!str.startsWith("GIF")) {
            this.status = 1;
            return;
        }
        readLSD();
        if (!this.gctFlag || err()) {
            return;
        }
        int[] readColorTable = readColorTable(this.gctSize);
        this.gct = readColorTable;
        this.bgColor = readColorTable[this.bgIndex];
    }

    private void readImage() {
        this.ix = readShort();
        this.iy = readShort();
        this.iw = readShort();
        this.ih = readShort();
        int read = read();
        int i = 0;
        this.lctFlag = (read & 128) != 0;
        this.interlace = (read & 64) != 0;
        int i2 = 2 << (read & 7);
        this.lctSize = i2;
        if (this.lctFlag) {
            int[] readColorTable = readColorTable(i2);
            this.lct = readColorTable;
            this.act = readColorTable;
        } else {
            this.act = this.gct;
            if (this.bgIndex == this.transIndex) {
                this.bgColor = 0;
            }
        }
        if (this.transparency) {
            int[] iArr = this.act;
            int i3 = this.transIndex;
            i = iArr[i3];
            iArr[i3] = 0;
        }
        if (this.act == null) {
            this.status = 1;
        }
        if (err()) {
            return;
        }
        decodeImageData();
        skip();
        if (err()) {
            return;
        }
        this.frameCount++;
        this.image = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
        setPixels();
        GifFrame gifFrame = this.gifFrame;
        GifFrame gifFrame2 = gifFrame;
        if (gifFrame == null) {
            GifFrame gifFrame3 = new GifFrame(this.image, this.delay);
            this.gifFrame = gifFrame3;
            this.currentFrame = gifFrame3;
        } else {
            while (gifFrame2.nextFrame != null) {
                gifFrame2 = gifFrame2.nextFrame;
            }
            gifFrame2.nextFrame = new GifFrame(this.image, this.delay);
        }
        if (this.transparency) {
            this.act[this.transIndex] = i;
        }
        resetFrame();
        this.action.parseOk(true, this.frameCount);
    }

    private void readLSD() {
        this.width = readShort();
        this.height = readShort();
        int read = read();
        this.gctFlag = (read & 128) != 0;
        this.gctSize = 2 << (read & 7);
        this.bgIndex = read();
        this.pixelAspect = read();
    }

    private void readNetscapeExt() {
        do {
            readBlock();
            byte[] bArr = this.block;
            if (bArr[0] == 1) {
                this.loopCount = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    private int readShort() {
        return read() | (read() << 8);
    }

    private int readStream() {
        init();
        if (this.f28236in != null) {
            readHeader();
            if (!err()) {
                readContents();
                if (this.frameCount < 0) {
                    this.status = 1;
                    this.action.parseOk(false, -1);
                } else {
                    this.status = -1;
                    this.action.parseOk(true, -1);
                }
            }
            try {
                this.f28236in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.status = 2;
            this.action.parseOk(false, -1);
        }
        return this.status;
    }

    private void resetFrame() {
        this.lastDispose = this.dispose;
        this.lrx = this.ix;
        this.lry = this.iy;
        this.lrw = this.iw;
        this.lrh = this.ih;
        this.lastImage = this.image;
        this.lastBgColor = this.bgColor;
        this.dispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.lct = null;
    }

    private void setPixels() {
        int i;
        int i2;
        int i3;
        int[] iArr = new int[this.width * this.height];
        int i4 = this.lastDispose;
        int i5 = 0;
        if (i4 > 0) {
            if (i4 == 3) {
                int i6 = this.frameCount - 2;
                if (i6 > 0) {
                    this.lastImage = getFrameImage(i6 - 1);
                } else {
                    this.lastImage = null;
                }
            }
            Bitmap bitmap = this.lastImage;
            if (bitmap != null) {
                int i7 = this.width;
                bitmap.getPixels(iArr, 0, i7, 0, 0, i7, this.height);
                if (this.lastDispose == 2) {
                    int i8 = !this.transparency ? this.lastBgColor : 0;
                    int i9 = 0;
                    while (true) {
                        int i10 = i9;
                        if (i10 >= this.lrh) {
                            break;
                        }
                        int i11 = ((this.lry + i10) * this.width) + this.lrx;
                        int i12 = this.lrw;
                        int i13 = i11;
                        while (true) {
                            int i14 = i13;
                            if (i14 < i12 + i11) {
                                iArr[i14] = i8;
                                i13 = i14 + 1;
                            }
                        }
                        i9 = i10 + 1;
                    }
                }
            }
        }
        int i15 = 8;
        int i16 = 0;
        int i17 = 1;
        while (true) {
            int i18 = this.ih;
            if (i5 >= i18) {
                this.image = Bitmap.createBitmap(iArr, this.width, this.height, Bitmap.Config.ARGB_4444);
                return;
            }
            if (this.interlace) {
                i3 = i15;
                int i19 = i16;
                int i20 = i17;
                if (i16 >= i18) {
                    i20 = i17 + 1;
                    if (i20 == 2) {
                        i19 = 4;
                        i3 = i15;
                    } else if (i20 == 3) {
                        i3 = 4;
                        i19 = 2;
                    } else if (i20 != 4) {
                        i3 = i15;
                        i19 = i16;
                    } else {
                        i3 = 2;
                        i19 = 1;
                    }
                }
                i2 = i19;
                i17 = i20;
                i = i19 + i3;
            } else {
                i = i16;
                i2 = i5;
                i3 = i15;
            }
            int i21 = i2 + this.iy;
            if (i21 < this.height) {
                int i22 = this.width;
                int i23 = i21 * i22;
                int i24 = this.ix + i23;
                int i25 = this.iw + i24;
                int i26 = i25;
                if (i23 + i22 < i25) {
                    i26 = i23 + i22;
                }
                int i27 = this.iw * i5;
                while (true) {
                    int i28 = i27;
                    if (i24 < i26) {
                        int i29 = this.act[this.pixels[i28] & 255];
                        if (i29 != 0) {
                            iArr[i24] = i29;
                        }
                        i24++;
                        i27 = i28 + 1;
                    }
                }
            }
            i5++;
            i15 = i3;
            i16 = i;
        }
    }

    private void skip() {
        do {
            readBlock();
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    public void free() {
        GifFrame gifFrame = this.gifFrame;
        while (gifFrame != null) {
            gifFrame.image = null;
            gifFrame = this.gifFrame.nextFrame;
            this.gifFrame = gifFrame;
        }
        InputStream inputStream = this.f28236in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
            this.f28236in = null;
        }
        this.gifData = null;
    }

    public GifFrame getCurrentFrame() {
        return this.currentFrame;
    }

    public int getDelay(int i) {
        GifFrame frame;
        this.delay = -1;
        if (i >= 0 && i < this.frameCount && (frame = getFrame(i)) != null) {
            this.delay = frame.delay;
        }
        return this.delay;
    }

    public int[] getDelays() {
        GifFrame gifFrame = this.gifFrame;
        int[] iArr = new int[this.frameCount];
        int i = 0;
        while (true) {
            int i2 = i;
            if (gifFrame == null || i2 >= this.frameCount) {
                break;
            }
            iArr[i2] = gifFrame.delay;
            gifFrame = gifFrame.nextFrame;
            i = i2 + 1;
        }
        return iArr;
    }

    public GifFrame getFrame(int i) {
        GifFrame gifFrame = this.gifFrame;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (gifFrame == null) {
                return null;
            }
            if (i3 == i) {
                return gifFrame;
            }
            gifFrame = gifFrame.nextFrame;
            i2 = i3 + 1;
        }
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public Bitmap getFrameImage(int i) {
        GifFrame frame = getFrame(i);
        if (frame == null) {
            return null;
        }
        return frame.image;
    }

    public Bitmap getImage() {
        return getFrameImage(0);
    }

    public int getLoopCount() {
        return this.loopCount;
    }

    public int getStatus() {
        return this.status;
    }

    public GifFrame next() {
        if (!this.isShow) {
            this.isShow = true;
            return this.gifFrame;
        }
        if (this.status != 0) {
            GifFrame gifFrame = this.currentFrame.nextFrame;
            this.currentFrame = gifFrame;
            if (gifFrame == null) {
                this.currentFrame = this.gifFrame;
            }
        } else if (this.currentFrame.nextFrame != null) {
            this.currentFrame = this.currentFrame.nextFrame;
        }
        return this.currentFrame;
    }

    public boolean parseOk() {
        return this.status == -1;
    }

    public void reset() {
        this.currentFrame = this.gifFrame;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.f28236in != null) {
            readStream();
        } else if (this.gifData != null) {
            readByte();
        }
    }
}
