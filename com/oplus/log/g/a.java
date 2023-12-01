package com.oplus.log.g;

import com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto;
import java.io.File;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/g/a.class */
public interface a {
    b a(String str) throws IOException;

    b a(String str, File file) throws IOException;

    UserTraceConfigDto b(String str) throws IOException;
}
