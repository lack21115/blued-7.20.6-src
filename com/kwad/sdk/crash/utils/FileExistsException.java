package com.kwad.sdk.crash.utils;

import java.io.File;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/utils/FileExistsException.class */
public class FileExistsException extends IOException {
    private static final long serialVersionUID = 1;

    public FileExistsException() {
    }

    public FileExistsException(File file) {
        super("File " + file + " already exists");
    }

    public FileExistsException(String str) {
        super(str);
    }
}
