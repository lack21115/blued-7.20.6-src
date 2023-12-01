package android.graphics;

import android.graphics.FontListParser;
import android.graphics.LegacyFontListParser;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/FontListConverter.class */
public class FontListConverter {
    private String mFontDir;
    protected static final int[] WEIGHTS = {400, 700, 400, 700};
    protected static boolean[] ITALICS = {false, false, true, true};
    protected static final int DEFAULT_WEIGHT = WEIGHTS[0];
    public static final String[] STYLES = {"thin", "light", "medium", WbCloudFaceContant.BLACK};
    private HashMap<LegacyFontListParser.Family, List<LegacyFontListParser.Family>> mFamilyVariants = new HashMap<>();
    private List<LegacyFontListParser.Family> mFamilies = new ArrayList();

    public FontListConverter(LegacyFontListParser.Family family, String str) {
        this.mFamilies.add(family);
        this.mFontDir = str;
        findFamilyVariants();
    }

    public FontListConverter(List<LegacyFontListParser.Family> list, String str) {
        this.mFamilies.addAll(list);
        this.mFontDir = str;
        findFamilyVariants();
    }

    private List<FontListParser.Alias> adaptNamesetAliases(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() >= 2) {
            String str = list.get(0);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                FontListParser.Alias alias = new FontListParser.Alias();
                alias.name = list.get(i2);
                alias.toName = str;
                arrayList.add(alias);
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    private List<FontListParser.Alias> adaptNamesetAliases(List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            FontListParser.Alias alias = new FontListParser.Alias();
            alias.name = str2;
            alias.toName = str;
            arrayList.add(alias);
        }
        return arrayList;
    }

    private void findFamilyVariants() {
        for (LegacyFontListParser.Family family : this.mFamilies) {
            if (isNormalStyle(family)) {
                this.mFamilyVariants.put(family, findVariants(family, this.mFamilies));
            }
        }
    }

    private List<LegacyFontListParser.Family> findVariants(LegacyFontListParser.Family family, List<LegacyFontListParser.Family> list) {
        ArrayList arrayList = new ArrayList();
        String name = family.getName();
        for (LegacyFontListParser.Family family2 : list) {
            if (family2.getName().startsWith(name) && !isNormalStyle(family2)) {
                arrayList.add(family2);
            }
        }
        return arrayList;
    }

    private List<FontListParser.Alias> getAliasesForRelatedFamilies() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<LegacyFontListParser.Family, List<LegacyFontListParser.Family>> entry : this.mFamilyVariants.entrySet()) {
            String str = entry.getKey().nameset.get(0);
            for (LegacyFontListParser.Family family : entry.getValue()) {
                arrayList.addAll(adaptNamesetAliases(family.nameset, str));
            }
        }
        return arrayList;
    }

    public FontListParser.Config convert() {
        FontListParser.Config config = new FontListParser.Config();
        config.families.addAll(convertFamilies());
        config.aliases.addAll(createAliases());
        return config;
    }

    protected List<FontListParser.Family> convertFamilies() {
        ArrayList arrayList = new ArrayList();
        for (LegacyFontListParser.Family family : this.mFamilyVariants.keySet()) {
            arrayList.add(convertFamily(family));
        }
        return arrayList;
    }

    protected FontListParser.Family convertFamily(LegacyFontListParser.Family family) {
        List<String> list = family.nameset;
        List<String> list2 = family.fileset;
        String str = list.isEmpty() ? null : list.get(0);
        List<FontListParser.Font> convertFonts = convertFonts(list2);
        for (LegacyFontListParser.Family family2 : this.mFamilyVariants.get(family)) {
            convertFonts.addAll(convertFonts(family2.fileset));
        }
        return new FontListParser.Family(str, convertFonts, null, null);
    }

    protected List<FontListParser.Font> convertFonts(List<String> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            arrayList.add(new FontListParser.Font(this.mFontDir + File.separatorChar + list.get(i2), i2 < WEIGHTS.length ? WEIGHTS[i2] : DEFAULT_WEIGHT, i2 < ITALICS.length ? ITALICS[i2] : false));
            i = i2 + 1;
        }
    }

    protected List<FontListParser.Alias> createAliases() {
        ArrayList arrayList = new ArrayList();
        for (LegacyFontListParser.Family family : this.mFamilyVariants.keySet()) {
            if (isNormalStyle(family)) {
                arrayList.addAll(adaptNamesetAliases(family.nameset));
            }
        }
        arrayList.addAll(getAliasesForRelatedFamilies());
        return arrayList;
    }

    protected boolean isNormalStyle(LegacyFontListParser.Family family) {
        String name = family.getName();
        if (name == null) {
            return false;
        }
        String[] strArr = STYLES;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (name.endsWith('-' + strArr[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }
}
