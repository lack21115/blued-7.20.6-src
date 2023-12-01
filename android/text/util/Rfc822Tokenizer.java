package android.text.util;

import android.widget.MultiAutoCompleteTextView;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-9557208-dex2jar.jar:android/text/util/Rfc822Tokenizer.class */
public class Rfc822Tokenizer implements MultiAutoCompleteTextView.Tokenizer {
    private static void crunch(StringBuilder sb) {
        int i = 0;
        int length = sb.length();
        while (i < length) {
            if (sb.charAt(i) != 0) {
                i++;
            } else if (i == 0 || i == length - 1 || sb.charAt(i - 1) == ' ' || sb.charAt(i - 1) == 0 || sb.charAt(i + 1) == ' ' || sb.charAt(i + 1) == 0) {
                sb.deleteCharAt(i);
                length--;
            } else {
                i++;
            }
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            if (sb.charAt(i3) == 0) {
                sb.setCharAt(i3, ' ');
            }
            i2 = i3 + 1;
        }
    }

    public static void tokenize(CharSequence charSequence, Collection<Rfc822Token> collection) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int i = 0;
        int length = charSequence.length();
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt == ',' || charAt == ';') {
                while (true) {
                    i++;
                    if (i >= length || charSequence.charAt(i) != ' ') {
                        break;
                    }
                }
                crunch(sb);
                if (sb2.length() > 0) {
                    collection.add(new Rfc822Token(sb.toString(), sb2.toString(), sb3.toString()));
                } else if (sb.length() > 0) {
                    collection.add(new Rfc822Token(null, sb.toString(), sb3.toString()));
                }
                sb.setLength(0);
                sb2.setLength(0);
                sb3.setLength(0);
            } else if (charAt == '\"') {
                int i2 = i;
                int i3 = 1;
                while (true) {
                    int i4 = i2 + i3;
                    i = i4;
                    if (i4 >= length) {
                        break;
                    }
                    char charAt2 = charSequence.charAt(i4);
                    if (charAt2 == '\"') {
                        i = i4 + 1;
                        break;
                    } else if (charAt2 == '\\') {
                        if (i4 + 1 < length) {
                            sb.append(charSequence.charAt(i4 + 1));
                        }
                        i2 = i4;
                        i3 = 2;
                    } else {
                        sb.append(charAt2);
                        i2 = i4;
                        i3 = 1;
                    }
                }
            } else if (charAt == '(') {
                int i5 = 1;
                int i6 = i;
                int i7 = 1;
                while (true) {
                    int i8 = i6 + i7;
                    i = i8;
                    if (i8 < length) {
                        i = i8;
                        if (i5 > 0) {
                            char charAt3 = charSequence.charAt(i8);
                            if (charAt3 == ')') {
                                if (i5 > 1) {
                                    sb3.append(charAt3);
                                }
                                i5--;
                                i6 = i8;
                                i7 = 1;
                            } else if (charAt3 == '(') {
                                sb3.append(charAt3);
                                i5++;
                                i6 = i8;
                                i7 = 1;
                            } else if (charAt3 == '\\') {
                                if (i8 + 1 < length) {
                                    sb3.append(charSequence.charAt(i8 + 1));
                                }
                                i6 = i8;
                                i7 = 2;
                            } else {
                                sb3.append(charAt3);
                                i6 = i8;
                                i7 = 1;
                            }
                        }
                    }
                }
            } else if (charAt == '<') {
                int i9 = i;
                while (true) {
                    int i10 = i9 + 1;
                    i = i10;
                    if (i10 >= length) {
                        break;
                    }
                    char charAt4 = charSequence.charAt(i10);
                    if (charAt4 == '>') {
                        i = i10 + 1;
                        break;
                    } else {
                        sb2.append(charAt4);
                        i9 = i10;
                    }
                }
            } else if (charAt == ' ') {
                sb.append((char) 0);
                i++;
            } else {
                sb.append(charAt);
                i++;
            }
        }
        crunch(sb);
        if (sb2.length() > 0) {
            collection.add(new Rfc822Token(sb.toString(), sb2.toString(), sb3.toString()));
        } else if (sb.length() > 0) {
            collection.add(new Rfc822Token(null, sb.toString(), sb3.toString()));
        }
    }

    public static Rfc822Token[] tokenize(CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        tokenize(charSequence, arrayList);
        return (Rfc822Token[]) arrayList.toArray(new Rfc822Token[arrayList.size()]);
    }

    @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
    public int findTokenEnd(CharSequence charSequence, int i) {
        char charAt;
        int length = charSequence.length();
        while (i < length && (charAt = charSequence.charAt(i)) != ',' && charAt != ';') {
            if (charAt == '\"') {
                int i2 = i;
                int i3 = 1;
                while (true) {
                    int i4 = i2 + i3;
                    i = i4;
                    if (i4 >= length) {
                        break;
                    }
                    char charAt2 = charSequence.charAt(i4);
                    if (charAt2 == '\"') {
                        i = i4 + 1;
                        break;
                    } else if (charAt2 != '\\' || i4 + 1 >= length) {
                        i2 = i4;
                        i3 = 1;
                    } else {
                        i2 = i4;
                        i3 = 2;
                    }
                }
            } else if (charAt == '(') {
                int i5 = 1;
                int i6 = i;
                int i7 = 1;
                while (true) {
                    int i8 = i6 + i7;
                    i = i8;
                    if (i8 < length) {
                        i = i8;
                        if (i5 > 0) {
                            char charAt3 = charSequence.charAt(i8);
                            if (charAt3 == ')') {
                                i5--;
                                i6 = i8;
                                i7 = 1;
                            } else if (charAt3 == '(') {
                                i5++;
                                i6 = i8;
                                i7 = 1;
                            } else if (charAt3 != '\\' || i8 + 1 >= length) {
                                i6 = i8;
                                i7 = 1;
                            } else {
                                i6 = i8;
                                i7 = 2;
                            }
                        }
                    }
                }
            } else if (charAt == '<') {
                int i9 = i;
                while (true) {
                    int i10 = i9 + 1;
                    i = i10;
                    if (i10 >= length) {
                        break;
                    } else if (charSequence.charAt(i10) == '>') {
                        i = i10 + 1;
                        break;
                    } else {
                        i9 = i10;
                    }
                }
            } else {
                i++;
            }
        }
        return i;
    }

    @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
    public int findTokenStart(CharSequence charSequence, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            int findTokenEnd = findTokenEnd(charSequence, i3);
            i3 = findTokenEnd;
            if (findTokenEnd < i) {
                while (true) {
                    findTokenEnd++;
                    if (findTokenEnd >= i || charSequence.charAt(findTokenEnd) != ' ') {
                        break;
                    }
                }
                i3 = findTokenEnd;
                if (findTokenEnd < i) {
                    i2 = findTokenEnd;
                    i3 = findTokenEnd;
                }
            }
        }
        return i2;
    }

    @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
    public CharSequence terminateToken(CharSequence charSequence) {
        return ((Object) charSequence) + ", ";
    }
}
