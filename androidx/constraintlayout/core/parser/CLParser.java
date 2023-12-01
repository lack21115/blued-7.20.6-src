package androidx.constraintlayout.core.parser;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLParser.class */
public class CLParser {

    /* renamed from: a  reason: collision with root package name */
    static boolean f2077a = false;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2078c = false;
    private int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.parser.CLParser$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLParser$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2079a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[TYPE.values().length];
            f2079a = iArr;
            try {
                iArr[TYPE.OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2079a[TYPE.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2079a[TYPE.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2079a[TYPE.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2079a[TYPE.KEY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2079a[TYPE.TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLParser$TYPE.class */
    public enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.b = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private CLElement a(int i, char c2, CLElement cLElement, char[] cArr) throws CLParsingException {
        CLElement cLElement2 = cLElement;
        if (c2 != '\t') {
            cLElement2 = cLElement;
            if (c2 != '\n') {
                cLElement2 = cLElement;
                if (c2 != '\r') {
                    cLElement2 = cLElement;
                    if (c2 != ' ') {
                        if (c2 != '\"' && c2 != '\'') {
                            if (c2 != '[') {
                                if (c2 != ']') {
                                    if (c2 == '{') {
                                        return a(cLElement, i, TYPE.OBJECT, true, cArr);
                                    }
                                    if (c2 != '}') {
                                        cLElement2 = cLElement;
                                        switch (c2) {
                                            case '+':
                                            case '-':
                                            case '.':
                                            case '0':
                                            case '1':
                                            case '2':
                                            case '3':
                                            case '4':
                                            case '5':
                                            case '6':
                                            case '7':
                                            case '8':
                                            case '9':
                                                return a(cLElement, i, TYPE.NUMBER, true, cArr);
                                            case ',':
                                            case ':':
                                                break;
                                            case '/':
                                                int i2 = i + 1;
                                                cLElement2 = cLElement;
                                                if (i2 < cArr.length) {
                                                    cLElement2 = cLElement;
                                                    if (cArr[i2] == '/') {
                                                        this.f2078c = true;
                                                        return cLElement;
                                                    }
                                                }
                                                break;
                                            default:
                                                if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                                                    return a(cLElement, i, TYPE.KEY, true, cArr);
                                                }
                                                CLElement a2 = a(cLElement, i, TYPE.TOKEN, true, cArr);
                                                CLToken cLToken = (CLToken) a2;
                                                if (cLToken.validate(c2, i)) {
                                                    return a2;
                                                }
                                                throw new CLParsingException("incorrect token <" + c2 + "> at line " + this.d, cLToken);
                                        }
                                    }
                                }
                                cLElement.setEnd(i - 1);
                                CLElement container = cLElement.getContainer();
                                container.setEnd(i);
                                return container;
                            }
                            return a(cLElement, i, TYPE.ARRAY, true, cArr);
                        } else if (cLElement instanceof CLObject) {
                            return a(cLElement, i, TYPE.KEY, true, cArr);
                        } else {
                            cLElement2 = a(cLElement, i, TYPE.STRING, true, cArr);
                        }
                    }
                }
            }
        }
        return cLElement2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [androidx.constraintlayout.core.parser.CLElement] */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.constraintlayout.core.parser.CLElement] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.constraintlayout.core.parser.CLElement] */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.constraintlayout.core.parser.CLElement] */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.constraintlayout.core.parser.CLElement] */
    private CLElement a(CLElement cLElement, int i, TYPE type, boolean z, char[] cArr) {
        CLObject allocate;
        if (f2077a) {
            System.out.println("CREATE " + type + " at " + cArr[i]);
        }
        switch (AnonymousClass1.f2079a[type.ordinal()]) {
            case 1:
                allocate = CLObject.allocate(cArr);
                i++;
                break;
            case 2:
                allocate = CLArray.allocate(cArr);
                i++;
                break;
            case 3:
                allocate = CLString.allocate(cArr);
                break;
            case 4:
                allocate = CLNumber.allocate(cArr);
                break;
            case 5:
                allocate = CLKey.allocate(cArr);
                break;
            case 6:
                allocate = CLToken.allocate(cArr);
                break;
            default:
                allocate = null;
                break;
        }
        if (allocate == null) {
            return null;
        }
        allocate.setLine(this.d);
        if (z) {
            allocate.setStart(i);
        }
        if (cLElement instanceof CLContainer) {
            allocate.setContainer((CLContainer) cLElement);
        }
        return allocate;
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0229, code lost:
        if (r0 == ':') goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0246, code lost:
        if (r0 == ']') goto L94;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.constraintlayout.core.parser.CLObject parse() throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 801
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.parser.CLParser.parse():androidx.constraintlayout.core.parser.CLObject");
    }
}
