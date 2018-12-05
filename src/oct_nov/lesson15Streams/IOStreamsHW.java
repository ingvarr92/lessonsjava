package oct_nov.lesson15Streams;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;

public class IOStreamsHW {
   private String path = new String();
    File file = new File(this.path);

    public IOStreamsHW(String path) {
        this.path = path;


    }
// InputStream
    // OutputStream
    //чтение и запись данных


    protected long readByte() throws IOException {

        long byteSum = 0;
        try(FileInputStream fileInputStream = new FileInputStream(this.file);){
            while (fileInputStream.available() > 0){
                int data = fileInputStream.read();
                byteSum +=data;
            }
            return byteSum;

        }

    }

    private void readByteArray (File file, Charset charset) throws IOException { // кодировка файлов
        try (InputStream in = new FileInputStream(file); ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();){
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf))>0){
                System.out.println(Arrays.toString(buf));
                byteArrayOutputStream.write(buf,0,len);
            }

            System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
            System.out.println(new String(byteArrayOutputStream.toByteArray(), charset));
        }
    }

    // запись файла

    private void writeToFile (File file, boolean append, Charset charset) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, append)){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++){
                sb.append("line ").append(i).append('\n');
            }

            byte[] bytes = sb.toString().getBytes((charset));
            fileOutputStream.write(bytes);

        }
    }



    public void writeWithBuffer (File file) throws IOException {
        try (FileOutputStream out = new FileOutputStream(file);
             BufferedOutputStream bout = new BufferedOutputStream(out);){ // размер буффера примерно 8 000 символов. Зависит от JVM
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++){
                sb.append("line ").append(i).append('\n');
            }

            byte[] buffer = sb.toString().getBytes();
            bout.write(buffer,0,buffer.length);

        }
    }

    private void readFromTwoFiles (File[] files, Charset charset) throws IOException {

        try(InputStream inputStream1 = new FileInputStream(files[0]);
            InputStream inputStream2 = new FileInputStream(files[1]);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
        )
        {
//            InputStream in1 = new FileInputStream("File1.txt"); // если больше двух файлов
//            InputStream in2 = new FileInputStream("File2.txt");
//            InputStream in3 = new FileInputStream("File3.txt");
//            Vector<InputStream> streams = new Vector<>();
//            streams.add(in1);
//            streams.add(in2);
//            streams.add(in3);
//            SequenceInputStream sequenceInputStream = new SequenceInputStream(streams.elements());




            SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream1,inputStream2); // если два файла
            byte[] buf = new byte[1024];
            int len;
            while ((len = sequenceInputStream.read(buf))>0){
                bout.write(buf,0,len);
            }
            System.out.println(new String(bout.toByteArray(),charset));
        }

    }

    private static void dataOutputStream (OutputStream out) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        dataOutputStream.writeInt(1233);
        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeUTF("Hello");

    }

    private static void dataInputStream (InputStream in) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(in);
        dataInputStream.readInt();

        boolean b = dataInputStream.readBoolean();

        int i = dataInputStream.readInt();

        String str = dataInputStream.readUTF();

        System.out.printf("%s %s", i , b);

    }


    public String readUrl(String url, Charset charset) throws IOException {
        HttpsURLConnection con = (HttpsURLConnection) new URL(url).openConnection();

        con.setRequestProperty("Accept-Charset",charset.name());
        try(InputStream in = con.getInputStream()){
            return readText(in, charset);
        }


    }
    private String readText(InputStream in, Charset charset) throws IOException {
        InputStreamReader reader = new InputStreamReader(in,charset);
        StringBuilder sb = new StringBuilder();
        char[] buf = new char[20];
        int len;
        while ((len = reader.read(buf))>0){
            sb.append(buf,0,len);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
//        PipedInputStream pipedInputStream;   // для многопоточних систем
//        PipedOutputStream pipedOutputStream;
//
//
//        FilterInputStream filterInputStream; // для собственной реализации. От них можно наследоватся и расширить функционал
//        FilterOutputStream filterOutputStream;


        IOStreamsHW ioStreams = new IOStreamsHW("file2.txt");
        // чтение по байту
        System.out.println(ioStreams.readByte());

//        File file = new File("file.txt");
//        File file2 = new File("file2.txt");
//        System.out.println(ioStreams.readByte(file));
//        ioStreams.readByteArray(file, Charset.forName("UTF-8"));
        //       ioStreams.writeToFile(file, false, Charset.forName("UTF-8"));
        //      ioStreams.writeWithBuffer(file);

//        File[] files = {file, file2};
//        ioStreams.readFromTwoFiles(files, Charset.forName("UTF-8"));
//            try(OutputStream out = new FileOutputStream(file)){
//                dataOutputStream(out);
//            }
//            try(InputStream in = new FileInputStream(file)) {
//                dataInputStream(in);
//            }

     //   System.out.println(ioStreams.readUrl("https://www.google.ru/_/chrome/newtab?rlz=1C1PRFI_enRU818RU819&ie=UTF-8",Charset.forName("UTF-8")));


    }
// RandomAccessFile посмотреть




}
