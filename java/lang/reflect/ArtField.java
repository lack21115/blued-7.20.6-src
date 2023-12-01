package java.lang.reflect;

import com.android.dex.Dex;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/ArtField.class */
public final class ArtField {
    private int accessFlags;
    private Class<?> declaringClass;
    private int fieldDexIndex;
    private int offset;

    private ArtField() {
    }

    public int getAccessFlags() {
        return this.accessFlags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> getDeclaringClass() {
        return this.declaringClass;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getDexFieldIndex() {
        return this.fieldDexIndex;
    }

    public String getName() {
        if (this.fieldDexIndex == -1) {
            if (this.declaringClass.isProxy()) {
                return "throws";
            }
            throw new AssertionError();
        }
        Dex dex = this.declaringClass.getDex();
        return this.declaringClass.getDexCacheString(dex, dex.nameIndexFromFieldIndex(this.fieldDexIndex));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getOffset() {
        return this.offset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> getType() {
        if (this.fieldDexIndex == -1) {
            if (this.declaringClass.isProxy()) {
                return Class[][].class;
            }
            throw new AssertionError();
        }
        Dex dex = this.declaringClass.getDex();
        return this.declaringClass.getDexCacheType(dex, dex.typeIndexFromFieldIndex(this.fieldDexIndex));
    }
}
