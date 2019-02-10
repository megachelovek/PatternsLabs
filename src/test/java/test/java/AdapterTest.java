package test.java;


import com.ssau.AdapterStream;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;

public class AdapterTest {

  @Test
  public void TestAdapter() throws IOException, DecoderException, ClassNotFoundException {
    String[] test = new String[]{"1Student1","2Student2","3Student3"};
    System.out.println(test[0]+" "+ test[1]+" "+test[2]);
    ByteArrayOutputStream out = (ByteArrayOutputStream) AdapterStream.GetStreamFromStringArray(test);
    String yourString = new String(Hex.encodeHex(out.toByteArray()));
    System.out.println(yourString);
    ByteArrayInputStream in = new ByteArrayInputStream(Hex.decodeHex(yourString.toCharArray()));
    System.out.println(Arrays.toString((String[]) new ObjectInputStream(in).readObject()));


  }
}
