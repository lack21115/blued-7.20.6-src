package java.net;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.Locale;
import libcore.net.MimeUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/net/DefaultFileNameMap.class */
public class DefaultFileNameMap implements FileNameMap {
    @Override // java.net.FileNameMap
    public String getContentTypeFor(String str) {
        if (str.endsWith(BridgeUtil.SPLIT_MARK)) {
            return MimeUtils.guessMimeTypeFromExtension("html");
        }
        int lastIndexOf = str.lastIndexOf(35);
        int i = lastIndexOf;
        if (lastIndexOf < 0) {
            i = str.length();
        }
        int lastIndexOf2 = str.lastIndexOf(46) + 1;
        return MimeUtils.guessMimeTypeFromExtension((lastIndexOf2 > str.lastIndexOf(47) ? str.substring(lastIndexOf2, i) : "").toLowerCase(Locale.US));
    }
}
