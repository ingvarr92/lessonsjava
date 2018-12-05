package lesson17Patterns.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteCountInputStream extends FilterInputStream { // базовый декоратор для всех потомков.
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected ByteCountInputStream(InputStream in) {
        super(in);
    }

    private long readByte;

    @Override
    public int read() throws IOException {

        int res = super.read();
        if (res >= 0) readByte++;
        return res;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int res = super.read(b,off,len);
        if (res > 0) readByte += res;
        return res;
    }
}
