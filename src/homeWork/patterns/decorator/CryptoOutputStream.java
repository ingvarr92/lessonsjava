package homeWork.patterns.decorator;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CryptoOutputStream extends FilterOutputStream {
    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field <tt>this.out</tt> for later use, or
     *            <code>null</code> if this instance is to be
     *            created without an underlying stream.
     */
    private byte [] password;
    private int pos;

    public CryptoOutputStream(OutputStream out, byte [] password) {
        super(out);
        this.password = password;
    }

    @Override
    public void write(int b) throws IOException {
        b=b^password[pos % password.length];
        pos++;
        super.write(b);
    }
//    Используя паттерн Decorator создать шифрующие с помощью XOR потоки ввода/вывода. Они должны наследовать FilterInputStream
//    и FilterOutputStream.
//    Конструктор этих потоков должен принимать пароль в виде массива байт и поток, который он декорирует.
//
//    Использование должно выглядеть следующим образом:
//    Трафик автоматически шифрует и дешифруется:
//    InputStream in = new CryptoInputStream(socket.getInputStream(), password);
//    OutputStream out = new CryptoOutputStream(socket.getOutputStream(), password);
//
//    Сохраняем в шифрованный файл и читаем из шифрованного файла:
//    InputStream in = new CryptoInputStream(new FileInputStream("test.bin"), password);
//    OutputStream out = new CryptoOutputStream(new FileOutputStream("test.bin"), password);

}
