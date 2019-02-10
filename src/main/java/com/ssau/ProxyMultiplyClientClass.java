package com.ssau;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ProxyMultiplyClientClass {
  private String HOST_NAME= "localhost";
  private int SOCKET = 5000;
  public void ConnectToSetver(double firstArg,double secondArg) throws IOException {
    Socket socket = new Socket(HOST_NAME,SOCKET);
    double[] arrDouble = new double[]{firstArg,secondArg};
    byte[] bytes = new byte[arrDouble.length * 8];
    ByteBuffer buf = ByteBuffer.wrap(bytes);
    for (double l : arrDouble) {
      buf.putDouble(l);
    }
    OutputStream outStream = socket.getOutputStream();
    outStream.write(bytes);
  }
}
