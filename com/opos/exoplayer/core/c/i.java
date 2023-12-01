package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.id3.CommentFrame;
import com.opos.exoplayer.core.metadata.id3.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final a.InterfaceC0667a f25245a = new a.InterfaceC0667a() { // from class: com.opos.exoplayer.core.c.i.1
        @Override // com.opos.exoplayer.core.metadata.id3.a.InterfaceC0667a
        public boolean a(int i, int i2, int i3, int i4, int i5) {
            if (i2 == 67 && i3 == 79 && i4 == 77) {
                return i5 == 77 || i == 2;
            }
            return false;
        }
    };
    private static final Pattern d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f25246c = -1;

    private boolean a(String str, String str2) {
        if ("iTunSMPB".equals(str)) {
            Matcher matcher = d.matcher(str2);
            if (matcher.find()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1), 16);
                    int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                    if (parseInt > 0 || parseInt2 > 0) {
                        this.b = parseInt;
                        this.f25246c = parseInt2;
                        return true;
                    }
                    return false;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public boolean a() {
        return (this.b == -1 || this.f25246c == -1) ? false : true;
    }

    public boolean a(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        if (i2 > 0 || i3 > 0) {
            this.b = i2;
            this.f25246c = i3;
            return true;
        }
        return false;
    }

    public boolean a(Metadata metadata) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= metadata.a()) {
                return false;
            }
            Metadata.Entry a2 = metadata.a(i2);
            if (a2 instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) a2;
                if (a(commentFrame.b, commentFrame.f25532c)) {
                    return true;
                }
            }
            i = i2 + 1;
        }
    }
}
