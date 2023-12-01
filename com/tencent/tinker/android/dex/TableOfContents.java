package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.Dex;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/TableOfContents.class */
public final class TableOfContents {
    public static final short SECTION_TYPE_ANNOTATIONS = 8196;
    public static final short SECTION_TYPE_ANNOTATIONSDIRECTORIES = 8198;
    public static final short SECTION_TYPE_ANNOTATIONSETREFLISTS = 4098;
    public static final short SECTION_TYPE_ANNOTATIONSETS = 4099;
    public static final short SECTION_TYPE_CLASSDATA = 8192;
    public static final short SECTION_TYPE_CLASSDEFS = 6;
    public static final short SECTION_TYPE_CODES = 8193;
    public static final short SECTION_TYPE_DEBUGINFOS = 8195;
    public static final short SECTION_TYPE_ENCODEDARRAYS = 8197;
    public static final short SECTION_TYPE_FIELDIDS = 4;
    public static final short SECTION_TYPE_HEADER = 0;
    public static final short SECTION_TYPE_MAPLIST = 4096;
    public static final short SECTION_TYPE_METHODIDS = 5;
    public static final short SECTION_TYPE_PROTOIDS = 3;
    public static final short SECTION_TYPE_STRINGDATAS = 8194;
    public static final short SECTION_TYPE_STRINGIDS = 1;
    public static final short SECTION_TYPE_TYPEIDS = 2;
    public static final short SECTION_TYPE_TYPELISTS = 4097;
    public final Section annotationsDirectories;
    public int checksum;
    public int dataOff;
    public int dataSize;
    public int fileSize;
    public int linkOff;
    public int linkSize;
    public final Section[] sections;
    public byte[] signature;
    public final Section header = new Section(0, true);
    public final Section stringIds = new Section(1, true);
    public final Section typeIds = new Section(2, true);
    public final Section protoIds = new Section(3, true);
    public final Section fieldIds = new Section(4, true);
    public final Section methodIds = new Section(5, true);
    public final Section classDefs = new Section(6, true);
    public final Section mapList = new Section(4096, true);
    public final Section typeLists = new Section(4097, true);
    public final Section annotationSetRefLists = new Section(4098, true);
    public final Section annotationSets = new Section(4099, true);
    public final Section classDatas = new Section(8192, false);
    public final Section codes = new Section(8193, true);
    public final Section stringDatas = new Section(8194, false);
    public final Section debugInfos = new Section(8195, false);
    public final Section annotations = new Section(8196, false);
    public final Section encodedArrays = new Section(8197, false);

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/TableOfContents$Section.class */
    public static class Section implements Comparable<Section> {
        public static final int UNDEF_INDEX = -1;
        public static final int UNDEF_OFFSET = -1;
        public int byteCount;
        public boolean isElementFourByteAligned;
        public int off;
        public int size;
        public final short type;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/TableOfContents$Section$Item.class */
        public static abstract class Item<T> implements Comparable<T> {
            public int off;

            public Item(int i) {
                this.off = i;
            }

            public abstract int byteCountInDex();

            /* JADX WARN: Multi-variable type inference failed */
            public boolean equals(Object obj) {
                return compareTo(obj) == 0;
            }

            public int hashCode() {
                return super.hashCode();
            }
        }

        public Section(int i, boolean z) {
            this.size = 0;
            this.off = -1;
            this.byteCount = 0;
            this.type = (short) i;
            this.isElementFourByteAligned = z;
            if (i == 0) {
                this.off = 0;
                this.size = 1;
                this.byteCount = 112;
            } else if (i == 4096) {
                this.size = 1;
            }
        }

        private int remapTypeOrderId(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                default:
                    switch (i) {
                        case 4096:
                            return 17;
                        case 4097:
                            return 8;
                        case 4098:
                            return 11;
                        case 4099:
                            return 10;
                        default:
                            switch (i) {
                                case 8192:
                                    return 15;
                                case 8193:
                                    return 14;
                                case 8194:
                                    return 7;
                                case 8195:
                                    return 13;
                                case 8196:
                                    return 9;
                                case 8197:
                                    return 16;
                                case 8198:
                                    return 12;
                                default:
                                    throw new IllegalArgumentException("unknown section type: " + i);
                            }
                    }
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(Section section) {
            int i = this.off;
            int i2 = section.off;
            if (i != i2) {
                return i < i2 ? -1 : 1;
            }
            int remapTypeOrderId = remapTypeOrderId(this.type);
            int remapTypeOrderId2 = remapTypeOrderId(section.type);
            if (remapTypeOrderId != remapTypeOrderId2) {
                return remapTypeOrderId < remapTypeOrderId2 ? -1 : 1;
            }
            return 0;
        }

        public boolean exists() {
            return this.size > 0;
        }

        public String toString() {
            return String.format("Section[type=%#x,off=%#x,size=%#x]", Short.valueOf(this.type), Integer.valueOf(this.off), Integer.valueOf(this.size));
        }
    }

    public TableOfContents() {
        Section section = new Section(8198, true);
        this.annotationsDirectories = section;
        this.sections = new Section[]{this.header, this.stringIds, this.typeIds, this.protoIds, this.fieldIds, this.methodIds, this.classDefs, this.mapList, this.typeLists, this.annotationSetRefLists, this.annotationSets, this.classDatas, this.codes, this.stringDatas, this.debugInfos, this.annotations, this.encodedArrays, section};
        this.signature = new byte[20];
    }

    private Section getSection(short s) {
        Section[] sectionArr = this.sections;
        int length = sectionArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                throw new IllegalArgumentException("No such map item: " + ((int) s));
            }
            Section section = sectionArr[i2];
            if (section.type == s) {
                return section;
            }
            i = i2 + 1;
        }
    }

    private void readHeader(Dex.Section section) throws UnsupportedEncodingException {
        byte[] readByteArray = section.readByteArray(8);
        if (DexFormat.magicToApi(readByteArray) != 13) {
            throw new DexException("Unexpected magic: " + Arrays.toString(readByteArray));
        }
        this.checksum = section.readInt();
        this.signature = section.readByteArray(20);
        this.fileSize = section.readInt();
        int readInt = section.readInt();
        if (readInt != 112) {
            throw new DexException("Unexpected header: 0x" + Integer.toHexString(readInt));
        }
        int readInt2 = section.readInt();
        if (readInt2 != 305419896) {
            throw new DexException("Unexpected endian tag: 0x" + Integer.toHexString(readInt2));
        }
        this.linkSize = section.readInt();
        this.linkOff = section.readInt();
        this.mapList.off = section.readInt();
        if (this.mapList.off == 0) {
            throw new DexException("Cannot merge dex files that do not contain a map");
        }
        this.stringIds.size = section.readInt();
        this.stringIds.off = section.readInt();
        this.typeIds.size = section.readInt();
        this.typeIds.off = section.readInt();
        this.protoIds.size = section.readInt();
        this.protoIds.off = section.readInt();
        this.fieldIds.size = section.readInt();
        this.fieldIds.off = section.readInt();
        this.methodIds.size = section.readInt();
        this.methodIds.off = section.readInt();
        this.classDefs.size = section.readInt();
        this.classDefs.off = section.readInt();
        this.dataSize = section.readInt();
        this.dataOff = section.readInt();
    }

    private void readMap(Dex.Section section) throws IOException {
        int readInt = section.readInt();
        Section section2 = null;
        int i = 0;
        while (i < readInt) {
            short readShort = section.readShort();
            section.readShort();
            Section section3 = getSection(readShort);
            int readInt2 = section.readInt();
            int readInt3 = section.readInt();
            if ((section3.size != 0 && section3.size != readInt2) || (section3.off != -1 && section3.off != readInt3)) {
                throw new DexException("Unexpected map value for 0x" + Integer.toHexString(readShort));
            }
            section3.size = readInt2;
            section3.off = readInt3;
            if (section2 != null && section2.off > section3.off) {
                throw new DexException("Map is unsorted at " + section2 + ", " + section3);
            }
            i++;
            section2 = section3;
        }
        this.header.off = 0;
        Arrays.sort(this.sections);
        int i2 = 1;
        while (true) {
            int i3 = i2;
            Section[] sectionArr = this.sections;
            if (i3 >= sectionArr.length) {
                return;
            }
            if (sectionArr[i3].off == -1) {
                Section[] sectionArr2 = this.sections;
                sectionArr2[i3].off = sectionArr2[i3 - 1].off;
            }
            i2 = i3 + 1;
        }
    }

    public void computeSizesFromOffsets() {
        int i = this.fileSize;
        int length = this.sections.length;
        while (true) {
            int i2 = length - 1;
            if (i2 < 0) {
                int i3 = this.header.byteCount + this.stringIds.byteCount + this.typeIds.byteCount + this.protoIds.byteCount + this.fieldIds.byteCount + this.methodIds.byteCount + this.classDefs.byteCount;
                this.dataOff = i3;
                this.dataSize = this.fileSize - i3;
                return;
            }
            Section section = this.sections[i2];
            if (section.off != -1) {
                if (section.off > i) {
                    throw new DexException("Map is unsorted at " + section);
                }
                section.byteCount = i - section.off;
                i = section.off;
            }
            length = i2;
        }
    }

    public Section getSectionByType(int i) {
        switch (i) {
            case 0:
                return this.header;
            case 1:
                return this.stringIds;
            case 2:
                return this.typeIds;
            case 3:
                return this.protoIds;
            case 4:
                return this.fieldIds;
            case 5:
                return this.methodIds;
            case 6:
                return this.classDefs;
            default:
                switch (i) {
                    case 4096:
                        return this.mapList;
                    case 4097:
                        return this.typeLists;
                    case 4098:
                        return this.annotationSetRefLists;
                    case 4099:
                        return this.annotationSets;
                    default:
                        switch (i) {
                            case 8192:
                                return this.classDatas;
                            case 8193:
                                return this.codes;
                            case 8194:
                                return this.stringDatas;
                            case 8195:
                                return this.debugInfos;
                            case 8196:
                                return this.annotations;
                            case 8197:
                                return this.encodedArrays;
                            case 8198:
                                return this.annotationsDirectories;
                            default:
                                throw new IllegalArgumentException("unknown section type: " + i);
                        }
                }
        }
    }

    public void readFrom(Dex dex) throws IOException {
        readHeader(dex.openSection(this.header));
        readMap(dex.openSection(this.mapList.off));
        computeSizesFromOffsets();
    }

    public void writeHeader(Dex.Section section) throws IOException {
        section.write(DexFormat.apiToMagic(13).getBytes("UTF-8"));
        section.writeInt(this.checksum);
        section.write(this.signature);
        section.writeInt(this.fileSize);
        section.writeInt(112);
        section.writeInt(DexFormat.ENDIAN_TAG);
        section.writeInt(this.linkSize);
        section.writeInt(this.linkOff);
        section.writeInt(this.mapList.off);
        section.writeInt(this.stringIds.size);
        section.writeInt(this.stringIds.exists() ? this.stringIds.off : 0);
        section.writeInt(this.typeIds.size);
        section.writeInt(this.typeIds.exists() ? this.typeIds.off : 0);
        section.writeInt(this.protoIds.size);
        section.writeInt(this.protoIds.exists() ? this.protoIds.off : 0);
        section.writeInt(this.fieldIds.size);
        section.writeInt(this.fieldIds.exists() ? this.fieldIds.off : 0);
        section.writeInt(this.methodIds.size);
        section.writeInt(this.methodIds.exists() ? this.methodIds.off : 0);
        section.writeInt(this.classDefs.size);
        int i = 0;
        if (this.classDefs.exists()) {
            i = this.classDefs.off;
        }
        section.writeInt(i);
        section.writeInt(this.dataSize);
        section.writeInt(this.dataOff);
    }

    public void writeMap(Dex.Section section) throws IOException {
        int i;
        Section[] sectionArr = this.sections;
        int length = sectionArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= length) {
                break;
            }
            int i4 = i;
            if (sectionArr[i2].exists()) {
                i4 = i + 1;
            }
            i2++;
            i3 = i4;
        }
        section.writeInt(i);
        Section[] sectionArr2 = this.sections;
        int length2 = sectionArr2.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length2) {
                return;
            }
            Section section2 = sectionArr2[i6];
            if (section2.exists()) {
                section.writeShort(section2.type);
                section.writeShort((short) 0);
                section.writeInt(section2.size);
                section.writeInt(section2.off);
            }
            i5 = i6 + 1;
        }
    }
}
