package homeWork.patterns.decorator;

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CryptoInputStream extends FilterInputStream {


    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    byte [] password;
    int pos = 0;
    protected CryptoInputStream(InputStream in, byte[] password) {
        super(in);
        this.password = password;
    }

    @Override
    public int read() throws IOException {
        int buf = super.read();
        buf = buf^password[pos%password.length];
        pos++;
        return buf;
    }
}
