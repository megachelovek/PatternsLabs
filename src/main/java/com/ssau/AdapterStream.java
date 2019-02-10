package com.ssau;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.*;
import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;

public class AdapterStream {
  public static OutputStream GetStreamFromStringArray(String[] arrayString) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    new ObjectOutputStream(out).writeObject(arrayString);
    return out;
  }
  public static String GetStringFromStream(InputStream inputStream) throws IOException, DecoderException, ClassNotFoundException {
    String inputString = inputStream.toString();
    ByteArrayInputStream in = new ByteArrayInputStream(Hex.decodeHex(inputString.toCharArray()));
    String result = Arrays.toString((String[]) new ObjectInputStream(in).readObject());
    return result;
  }
}
