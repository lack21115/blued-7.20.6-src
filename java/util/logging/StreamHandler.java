package java.util.logging;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/StreamHandler.class */
public class StreamHandler extends Handler {
    private OutputStream os;
    private Writer writer;
    private boolean writerNotInitialized;

    public StreamHandler() {
        initProperties("INFO", null, "java.util.logging.SimpleFormatter", null);
        this.os = null;
        this.writer = null;
        this.writerNotInitialized = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamHandler(OutputStream outputStream) {
        this();
        this.os = outputStream;
    }

    public StreamHandler(OutputStream outputStream, Formatter formatter) {
        this();
        if (outputStream == null) {
            throw new NullPointerException("os == null");
        }
        if (formatter == null) {
            throw new NullPointerException("formatter == null");
        }
        this.os = outputStream;
        internalSetFormatter(formatter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamHandler(String str, String str2, String str3, String str4) {
        initProperties(str, str2, str3, str4);
        this.os = null;
        this.writer = null;
        this.writerNotInitialized = true;
    }

    private void initializeWriter() {
        this.writerNotInitialized = false;
        if (getEncoding() == null) {
            this.writer = new OutputStreamWriter(this.os);
        } else {
            try {
                this.writer = new OutputStreamWriter(this.os, getEncoding());
            } catch (UnsupportedEncodingException e) {
            }
        }
        write(getFormatter().getHead(this));
    }

    private void write(String str) {
        try {
            this.writer.write(str);
        } catch (Exception e) {
            getErrorManager().error("Exception occurred when writing to the output stream", e, 1);
        }
    }

    @Override // java.util.logging.Handler
    public void close() {
        LogManager.getLogManager().checkAccess();
        close(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close(boolean z) {
        if (this.os != null) {
            if (this.writerNotInitialized) {
                initializeWriter();
            }
            write(getFormatter().getTail(this));
            try {
                this.writer.flush();
                if (z) {
                    this.writer.close();
                    this.writer = null;
                    this.os = null;
                }
            } catch (Exception e) {
                getErrorManager().error("Exception occurred when closing the output stream", e, 3);
            }
        }
    }

    @Override // java.util.logging.Handler
    public void flush() {
        if (this.os != null) {
            try {
                if (this.writer != null) {
                    this.writer.flush();
                } else {
                    this.os.flush();
                }
            } catch (Exception e) {
                getErrorManager().error("Exception occurred when flushing the output stream", e, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void internalSetOutputStream(OutputStream outputStream) {
        this.os = outputStream;
    }

    @Override // java.util.logging.Handler
    public boolean isLoggable(LogRecord logRecord) {
        return (logRecord == null || this.os == null || !super.isLoggable(logRecord)) ? false : true;
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        String str;
        synchronized (this) {
            try {
                if (isLoggable(logRecord)) {
                    if (this.writerNotInitialized) {
                        initializeWriter();
                    }
                    try {
                        str = getFormatter().format(logRecord);
                    } catch (Exception e) {
                        getErrorManager().error("Exception occurred when formatting the log record", e, 5);
                        str = null;
                    }
                    write(str);
                }
            } catch (Exception e2) {
                getErrorManager().error("Exception occurred when logging the record", e2, 0);
            }
        }
    }

    @Override // java.util.logging.Handler
    public void setEncoding(String str) throws UnsupportedEncodingException {
        flush();
        super.setEncoding(str);
        if (this.writer != null) {
            if (getEncoding() == null) {
                this.writer = new OutputStreamWriter(this.os);
                return;
            }
            try {
                this.writer = new OutputStreamWriter(this.os, getEncoding());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOutputStream(OutputStream outputStream) {
        if (outputStream == null) {
            throw new NullPointerException("os == null");
        }
        LogManager.getLogManager().checkAccess();
        close(true);
        this.writer = null;
        this.os = outputStream;
        this.writerNotInitialized = true;
    }
}
