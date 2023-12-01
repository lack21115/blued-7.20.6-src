package com.bytedance.pangle.res.a;

import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/res/a/c.class */
public final class c {
    private static com.bytedance.pangle.util.e<Integer, byte[]> a(MappedByteBuffer mappedByteBuffer, int i, String str) {
        if (mappedByteBuffer.getInt(i) != 67324752) {
            throw new RuntimeException("Expected: 0x04034b50, got: " + mappedByteBuffer.getInt(i) + " FileName:" + str);
        }
        int i2 = mappedByteBuffer.getInt(i + 18);
        int i3 = mappedByteBuffer.getInt(i + 22);
        if (i2 != i3) {
            throw new RuntimeException(str + " is compressed. compressSize:" + i2 + " size:" + i3);
        }
        byte[] bArr = new byte[i3];
        int i4 = i + 30 + mappedByteBuffer.getShort(i + 26) + mappedByteBuffer.getShort(i + 28);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i3) {
                return new com.bytedance.pangle.util.e<>(Integer.valueOf(i4), bArr);
            }
            bArr[i6] = mappedByteBuffer.get(i4 + i6);
            i5 = i6 + 1;
        }
    }

    private static MappedByteBuffer a(File file) {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            FileChannel channel = randomAccessFile.getChannel();
            long size = channel.size();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, size);
            byte[] bArr = new byte[4194304];
            long j = size / STMobileHumanActionNative.ST_MOBILE_HAND_666;
            int i = (int) (size % STMobileHumanActionNative.ST_MOBILE_HAND_666);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= j) {
                    break;
                }
                map.get(bArr);
                i2 = i3 + 1;
            }
            if (i > 0) {
                map.get(new byte[i]);
            }
            map.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.close();
            return map;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private static void a(File file, HashSet<String> hashSet, h hVar) {
        int i;
        MappedByteBuffer a2 = a(file);
        int capacity = a2.capacity();
        if (capacity >= 22) {
            int i2 = capacity - 22;
            int min = Math.min(i2, 65535);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= min) {
                    break;
                }
                int i5 = i2 - i4;
                if (a2.getInt(i5) == 101010256 && a2.getShort(i5 + 20) == i4) {
                    i = i5;
                    break;
                }
                i3 = i4 + 1;
            }
        }
        i = -1;
        if (i == -1) {
            throw new Throwable("endOfCentralPosition == -1");
        }
        int i6 = a2.getInt(i + 12);
        int i7 = a2.getInt(i + 16);
        int i8 = i7;
        while (true) {
            int i9 = i8;
            if (i9 >= i6 + i7) {
                return;
            }
            if (a2.getInt(i9) != 33639248) {
                throw new RuntimeException("Expected: 0x02014b50, got: " + a2.getInt(i9));
            }
            int i10 = a2.getShort(i9 + 28);
            short s = a2.getShort(i9 + 30);
            byte[] bArr = new byte[i10];
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 >= i10) {
                    break;
                }
                bArr[i12] = a2.get(i9 + 46 + i12);
                i11 = i12 + 1;
            }
            String str = new String(bArr);
            int i13 = a2.getInt(i9 + 20);
            int i14 = a2.getInt(i9 + 24);
            if (hashSet.contains(str)) {
                if (i13 != i14) {
                    throw new Throwable(str + " is compressed.");
                }
                com.bytedance.pangle.util.e<Integer, byte[]> a3 = a(a2, a2.getInt(i9 + 42), str);
                try {
                    byte[] bArr2 = a3.b;
                    if (!TextUtils.isEmpty(str) && hVar.a(str)) {
                        if (str.equals(ShareConstants.RES_MANIFEST)) {
                            k.a(bArr2, hVar);
                        } else if ((str.endsWith(".xml") && str.startsWith("res/")) || TextUtils.equals(str, ShareConstants.RES_MANIFEST)) {
                            k.a(bArr2, hVar);
                        } else if (str.equals(ShareConstants.RES_ARSC)) {
                            new a(bArr2, hVar).a();
                        }
                    }
                    int i15 = 0;
                    while (true) {
                        int i16 = i15;
                        if (i16 < a3.b.length) {
                            a2.put(a3.f7895a.intValue() + i16, a3.b[i16]);
                            i15 = i16 + 1;
                        }
                    }
                } catch (Throwable th) {
                    throw new RuntimeException(th);
                }
            }
            i8 = i9 + i10 + 46 + s;
        }
    }

    /* JADX WARN: Finally extract failed */
    public final int a(File file, boolean z, StringBuilder sb) {
        ZipFile zipFile;
        Throwable th;
        String byteArrayOutputStream;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("assets/ZeusResMapping");
                if (entry == null) {
                    com.bytedance.pangle.util.g.a(zipFile2);
                    return 200;
                }
                if (z) {
                    File file2 = new File(file.getParentFile(), "resMappingBak");
                    if (!file2.exists()) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "resMappingBakFile is not exists. " + file2.getAbsolutePath());
                        sb.append("resMappingBakFile is not exists. ");
                        sb.append(file2.getAbsolutePath());
                        com.bytedance.pangle.util.g.a(zipFile2);
                        return 300;
                    }
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    FileChannel channel = fileInputStream.getChannel();
                    byteArrayOutputStream = Charset.defaultCharset().newDecoder().decode(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).asReadOnlyBuffer()).toString();
                    channel.close();
                    fileInputStream.close();
                } else {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    InputStream inputStream = zipFile2.getInputStream(entry);
                    if (inputStream != null) {
                        ReadableByteChannel newChannel = Channels.newChannel(inputStream);
                        WritableByteChannel newChannel2 = Channels.newChannel(byteArrayOutputStream2);
                        com.bytedance.pangle.util.h.a(newChannel, newChannel2);
                        newChannel.close();
                        newChannel2.close();
                    }
                    byteArrayOutputStream = byteArrayOutputStream2.toString();
                }
                if (TextUtils.isEmpty(byteArrayOutputStream)) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "zeusResMappingContent empty, useBakFile:".concat(String.valueOf(z)));
                    sb.append("zeusResMappingContent isEmpty. useBakFile:");
                    sb.append(z);
                    com.bytedance.pangle.util.g.a(zipFile2);
                    return 300;
                }
                JSONObject jSONObject = new JSONObject(byteArrayOutputStream);
                JSONObject jSONObject2 = new JSONObject(byteArrayOutputStream);
                JSONArray jSONArray = (JSONArray) jSONObject.get("fileNames");
                final HashSet hashSet = new HashSet();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    hashSet.add((String) jSONArray.get(i2));
                    i = i2 + 1;
                }
                final JSONObject jSONObject3 = (JSONObject) jSONObject.get("resMapping");
                final JSONObject jSONObject4 = (JSONObject) jSONObject2.get("resMapping");
                final int[] iArr = new int[1];
                iArr[0] = 0;
                a(file, hashSet, new h() { // from class: com.bytedance.pangle.res.a.c.1
                    @Override // com.bytedance.pangle.res.a.h
                    public final int a(int i3) {
                        String str = "0x" + Integer.toHexString(i3);
                        String str2 = (String) jSONObject3.opt(str);
                        if (str2 == null) {
                            return i3;
                        }
                        int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1], str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                        int i4 = identifier;
                        if (identifier == 0) {
                            i4 = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1].replaceAll("_", "."), str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                        }
                        if (i4 == 0) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "getIdentifier failed. resName is ".concat(String.valueOf(str2)));
                            return i3;
                        }
                        String str3 = "0x" + Integer.toHexString(i4);
                        jSONObject4.remove(str);
                        try {
                            jSONObject4.put(str3, str2);
                        } catch (Throwable th2) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "update resMappingBak failed.", th2);
                        }
                        if (i4 != i3) {
                            int[] iArr2 = iArr;
                            iArr2[0] = iArr2[0] + 1;
                        }
                        return i4;
                    }

                    @Override // com.bytedance.pangle.res.a.h
                    public final boolean a(String str) {
                        return hashSet.contains(str);
                    }
                });
                ZeusLogger.d(ZeusLogger.TAG_INSTALL, "modifyRes count = " + iArr[0]);
                if (com.bytedance.pangle.util.h.a(jSONObject2.toString(), new File(file.getParentFile(), "resMappingBak"), sb)) {
                    com.bytedance.pangle.util.g.a(zipFile2);
                    return 100;
                }
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "writeText failed." + sb.toString());
                sb.append("writeText failed.");
                com.bytedance.pangle.util.g.a(zipFile2);
                return 300;
            } catch (Throwable th2) {
                th = th2;
                zipFile = zipFile2;
                try {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "modifyRes failed. catch: " + th.getMessage());
                    sb.append("modifyRes failed. catch: ");
                    sb.append(th.getMessage());
                    if (zipFile != null) {
                        com.bytedance.pangle.util.g.a(zipFile);
                        return 300;
                    }
                    return 300;
                } catch (Throwable th3) {
                    if (zipFile != null) {
                        com.bytedance.pangle.util.g.a(zipFile);
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            zipFile = null;
            th = th4;
        }
    }
}
