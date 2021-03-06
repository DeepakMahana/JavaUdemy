package javaNIO;


import com.sun.beans.editors.ByteEditor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.RandomAccess;

public class Main {

    public static void main(String[] args) {

       // try {

            /*  Using FileInputStream to read File

            FileInputStream file = new FileInputStream("data.txt");
            FileChannel channel = file.getChannel();

           */

            /*  Using NIO Packages to read and write File

            Path dataPath = FileSystems.getDefault().getPath("data.txt");
            Files.write(dataPath, "\nLine 4".getBytes("UTF-8"), StandardOpenOption.APPEND);
            List<String> lines = Files.readAllLines(dataPath);
            for(String line : lines) {
                System.out.println(line);
            }

            */

       // } catch (IOException e){
       //     e.printStackTrace();
       // }

        // Write and Read into Binary File
        try(FileOutputStream binFile = new FileOutputStream("data.dat")){
            FileChannel binChannel = binFile.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(100);

          // Chaining Buffer Input
            byte[] outputBytes = "Hello World!".getBytes();
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);
            buffer.flip();

          /* Normal Buffer Input

            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            buffer.putInt(245);
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            buffer.putInt(1000);
            buffer.flip();

           */

            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("inputString = " + new String(inputString));
            System.out.println("int1 = " + readBuffer.getInt());
            System.out.println("int2 = " + readBuffer.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString2 = " + new String(inputString2));
            System.out.println("int3 = " + readBuffer.getInt());


         /*
            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
            buffer.put(outputBytes);

            buffer.flip();
            int numBytes = binChannel.write(buffer);
            System.out.println("numBytes written was: " + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            if(buffer.hasArray()){
                System.out.println("byte buffer = " + new String(buffer.array()));
                System.out.println("byte buffer = " + new String(outputBytes));
            }

            // Absolute Read
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt(0));
            System.out.println(intBuffer.getInt());

            // Relative Read
            //            intBuffer.flip();
            //            numBytesRead = channel.read(intBuffer);
            //            intBuffer.flip();
            //            System.out.println(intBuffer.getInt());
            //            intBuffer.flip();
            //            numBytesRead = channel.read(intBuffer);
            //            intBuffer.flip();
            //            System.out.println(intBuffer.getInt());

            channel.close();
            ra.close();

         */


//          System.out.println("outputBytes = " + new String(outputBytes));


         /* Random Access Read Write

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            byte[] b = new byte[outputBytes.length];
            ra.read(b);
            System.out.println(new String(b));

            long int1 = ra.readInt();
            long int2 = ra.readInt();
            System.out.println(int1);
            System.out.println(int2);

         */

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
