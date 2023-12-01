package dalvik.system.profiler;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/BinaryHprof.class */
public final class BinaryHprof {
    public static final int ID_SIZE = 4;
    static String MAGIC = "JAVA PROFILE ";

    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/BinaryHprof$ControlSettings.class */
    public enum ControlSettings {
        ALLOC_TRACES(1),
        CPU_SAMPLING(2);
        
        public final int bitmask;

        ControlSettings(int i) {
            this.bitmask = i;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/BinaryHprof$Tag.class */
    public enum Tag {
        STRING_IN_UTF8(1, -4),
        LOAD_CLASS(2, 16),
        UNLOAD_CLASS(3, 4),
        STACK_FRAME(4, 24),
        STACK_TRACE(5, -12),
        ALLOC_SITES(6, -34),
        HEAP_SUMMARY(7, 24),
        START_THREAD(10, 24),
        END_THREAD(11, 4),
        HEAP_DUMP(12, 0),
        HEAP_DUMP_SEGMENT(28, 0),
        HEAP_DUMP_END(44, 0),
        CPU_SAMPLES(13, -8),
        CONTROL_SETTINGS(14, 6);
        
        private static final Map<Byte, Tag> BYTE_TO_TAG = new HashMap();
        public final int maximumSize;
        public final int minimumSize;
        public final byte tag;

        static {
            Tag[] values = values();
            int length = values.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Tag tag = values[i2];
                BYTE_TO_TAG.put(Byte.valueOf(tag.tag), tag);
                i = i2 + 1;
            }
        }

        Tag(int i, int i2) {
            this.tag = (byte) i;
            if (i2 > 0) {
                this.minimumSize = i2;
                this.maximumSize = i2;
                return;
            }
            this.minimumSize = -i2;
            this.maximumSize = 0;
        }

        public static Tag get(byte b) {
            return BYTE_TO_TAG.get(Byte.valueOf(b));
        }

        public String checkSize(int i) {
            String str;
            if (i < this.minimumSize) {
                str = "expected a minimial record size of " + this.minimumSize + " for " + this + " but received " + i;
            } else {
                str = null;
                if (this.maximumSize != 0) {
                    str = null;
                    if (i > this.maximumSize) {
                        return "expected a maximum record size of " + this.maximumSize + " for " + this + " but received " + i;
                    }
                }
            }
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        r0 = new java.lang.String(r0, 0, r9, "UTF-8");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
        if (r0.startsWith(dalvik.system.profiler.BinaryHprof.MAGIC) == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String readMagic(java.io.DataInputStream r7) {
        /*
            r0 = 512(0x200, float:7.175E-43)
            byte[] r0 = new byte[r0]     // Catch: java.io.IOException -> L3d
            r10 = r0
            r0 = 0
            r9 = r0
        L8:
            r0 = r9
            r1 = r10
            int r1 = r1.length     // Catch: java.io.IOException -> L3d
            if (r0 >= r1) goto L3b
            r0 = r7
            byte r0 = r0.readByte()     // Catch: java.io.IOException -> L3d
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L30
            java.lang.String r0 = new java.lang.String     // Catch: java.io.IOException -> L3d
            r1 = r0
            r2 = r10
            r3 = 0
            r4 = r9
            java.lang.String r5 = "UTF-8"
            r1.<init>(r2, r3, r4, r5)     // Catch: java.io.IOException -> L3d
            r7 = r0
            r0 = r7
            java.lang.String r1 = dalvik.system.profiler.BinaryHprof.MAGIC     // Catch: java.io.IOException -> L3d
            boolean r0 = r0.startsWith(r1)     // Catch: java.io.IOException -> L3d
            if (r0 == 0) goto L40
            r0 = r7
            return r0
        L30:
            r0 = r10
            r1 = r9
            r2 = r8
            r0[r1] = r2
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto L8
        L3b:
            r0 = 0
            return r0
        L3d:
            r7 = move-exception
            r0 = 0
            return r0
        L40:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dalvik.system.profiler.BinaryHprof.readMagic(java.io.DataInputStream):java.lang.String");
    }
}
