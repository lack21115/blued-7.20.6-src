package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import java.io.PrintStream;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/parse/KeyParser.class */
public class KeyParser {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/parse/KeyParser$DataType.class */
    public interface DataType {
        int get(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/parse/KeyParser$Ids.class */
    public interface Ids {
        int get(String str);
    }

    private static TypedBundle a(String str, Ids ids, DataType dataType) {
        TypedBundle typedBundle = new TypedBundle();
        try {
            CLObject parse = CLParser.parse(str);
            int size = parse.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                CLKey cLKey = (CLKey) parse.get(i2);
                String content = cLKey.content();
                CLElement value = cLKey.getValue();
                int i3 = ids.get(content);
                if (i3 == -1) {
                    PrintStream printStream = System.err;
                    printStream.println("unknown type " + content);
                } else {
                    int i4 = dataType.get(i3);
                    if (i4 == 1) {
                        typedBundle.add(i3, parse.getBoolean(i2));
                    } else if (i4 == 2) {
                        typedBundle.add(i3, value.getInt());
                        PrintStream printStream2 = System.out;
                        printStream2.println("parse " + content + " INT_MASK > " + value.getInt());
                    } else if (i4 == 4) {
                        typedBundle.add(i3, value.getFloat());
                        PrintStream printStream3 = System.out;
                        printStream3.println("parse " + content + " FLOAT_MASK > " + value.getFloat());
                    } else if (i4 == 8) {
                        typedBundle.add(i3, value.content());
                        PrintStream printStream4 = System.out;
                        printStream4.println("parse " + content + " STRING_MASK > " + value.content());
                    }
                }
                i = i2 + 1;
            }
        } catch (CLParsingException e) {
            e.printStackTrace();
        }
        return typedBundle;
    }

    public static void main(String[] strArr) {
        parseAttributes("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    public static TypedBundle parseAttributes(String str) {
        return a(str, new Ids() { // from class: androidx.constraintlayout.core.motion.parse.-$$Lambda$3GxY64POFStueXH2kP1zsUWp6NU
            @Override // androidx.constraintlayout.core.motion.parse.KeyParser.Ids
            public final int get(String str2) {
                return TypedValues.AttributesType.CC.getId(str2);
            }
        }, new DataType() { // from class: androidx.constraintlayout.core.motion.parse.-$$Lambda$04BnZsrrAfkOEWBFXt6E-8TFLHk
            @Override // androidx.constraintlayout.core.motion.parse.KeyParser.DataType
            public final int get(int i) {
                return TypedValues.AttributesType.CC.getType(i);
            }
        });
    }
}
