package android.content;

import android.net.Uri;
import com.android.internal.telephony.PhoneConstants;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: source-9557208-dex2jar.jar:android/content/UriMatcher.class */
public class UriMatcher {
    private static final int EXACT = 0;
    public static final int NO_MATCH = -1;
    private static final int NUMBER = 1;
    static final Pattern PATH_SPLIT_PATTERN = Pattern.compile(BridgeUtil.SPLIT_MARK);
    private static final int TEXT = 2;
    private ArrayList<UriMatcher> mChildren;
    private int mCode;
    private String mText;
    private int mWhich;

    private UriMatcher() {
        this.mCode = -1;
        this.mWhich = -1;
        this.mChildren = new ArrayList<>();
        this.mText = null;
    }

    public UriMatcher(int i) {
        this.mCode = i;
        this.mWhich = -1;
        this.mChildren = new ArrayList<>();
        this.mText = null;
    }

    public void addURI(String str, String str2, int i) {
        int i2;
        UriMatcher uriMatcher;
        if (i < 0) {
            throw new IllegalArgumentException("code " + i + " is invalid: it must be positive");
        }
        String[] strArr = null;
        if (str2 != null) {
            String str3 = str2;
            if (str2.length() > 0) {
                str3 = str2;
                if (str2.charAt(0) == '/') {
                    str3 = str2.substring(1);
                }
            }
            strArr = PATH_SPLIT_PATTERN.split(str3);
        }
        int length = strArr != null ? strArr.length : 0;
        UriMatcher uriMatcher2 = this;
        int i3 = -1;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                uriMatcher2.mCode = i;
                return;
            }
            String str4 = i4 < 0 ? str : strArr[i4];
            ArrayList<UriMatcher> arrayList = uriMatcher2.mChildren;
            int size = arrayList.size();
            int i5 = 0;
            while (true) {
                i2 = i5;
                uriMatcher = uriMatcher2;
                if (i2 >= size) {
                    break;
                }
                uriMatcher = arrayList.get(i2);
                if (str4.equals(uriMatcher.mText)) {
                    break;
                }
                i5 = i2 + 1;
            }
            uriMatcher2 = uriMatcher;
            if (i2 == size) {
                uriMatcher2 = new UriMatcher();
                if (str4.equals("#")) {
                    uriMatcher2.mWhich = 1;
                } else if (str4.equals(PhoneConstants.APN_TYPE_ALL)) {
                    uriMatcher2.mWhich = 2;
                } else {
                    uriMatcher2.mWhich = 0;
                }
                uriMatcher2.mText = str4;
                uriMatcher.mChildren.add(uriMatcher2);
            }
            i3 = i4 + 1;
        }
    }

    public int match(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        int size = pathSegments.size();
        UriMatcher uriMatcher = this;
        if (size == 0 && uri.getAuthority() == null) {
            return this.mCode;
        }
        int i = -1;
        while (true) {
            int i2 = i;
            if (i2 < size) {
                String authority = i2 < 0 ? uri.getAuthority() : pathSegments.get(i2);
                ArrayList<UriMatcher> arrayList = uriMatcher.mChildren;
                if (arrayList != null) {
                    UriMatcher uriMatcher2 = null;
                    int size2 = arrayList.size();
                    int i3 = 0;
                    while (true) {
                        uriMatcher = uriMatcher2;
                        if (i3 < size2) {
                            UriMatcher uriMatcher3 = arrayList.get(i3);
                            switch (uriMatcher3.mWhich) {
                                case 0:
                                    uriMatcher = uriMatcher2;
                                    if (uriMatcher3.mText.equals(authority)) {
                                        uriMatcher = uriMatcher3;
                                        break;
                                    }
                                    break;
                                case 1:
                                    int length = authority.length();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= length) {
                                            uriMatcher = uriMatcher3;
                                            break;
                                        } else {
                                            char charAt = authority.charAt(i5);
                                            uriMatcher = uriMatcher2;
                                            if (charAt < '0') {
                                                break;
                                            } else {
                                                uriMatcher = uriMatcher2;
                                                if (charAt > '9') {
                                                    break;
                                                } else {
                                                    i4 = i5 + 1;
                                                }
                                            }
                                        }
                                    }
                                case 2:
                                    uriMatcher = uriMatcher3;
                                    break;
                                default:
                                    uriMatcher = uriMatcher2;
                                    break;
                            }
                            if (uriMatcher == null) {
                                i3++;
                                uriMatcher2 = uriMatcher;
                            }
                        }
                    }
                    if (uriMatcher == null) {
                        return -1;
                    }
                    i = i2 + 1;
                }
            }
        }
        return uriMatcher.mCode;
    }
}
