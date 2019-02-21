package com.ssau;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ProxyMultiplyClientClass {
  private int  SOCKET = 5000;
  private String HOST_NAME;
  private double[] args;

  public ProxyMultiplyClientClass(String host){
    this.HOST_NAME = host;
  }

  public  double ConnectToServer(double firstArg,double secondArg) throws IOException {
    Socket clientSocket = new Socket(HOST_NAME,SOCKET);
    double[] arrDouble = new double[]{firstArg,secondArg};
    byte[] bytes = new byte[arrDouble.length * 8];
    ByteBuffer buf = ByteBuffer.wrap(bytes);
    for (double l : arrDouble) {
      buf.putDouble(l);
    }
    OutputStream outStream = clientSocket.getOutputStream();
    outStream.write(bytes);

    byte[] inputBytes = new byte[]{};
    InputStream inputStream =clientSocket.getInputStream();
    inputStream.read(inputBytes);
    ByteBuffer buf2 = ByteBuffer.wrap(bytes);
    double result;
    result = buf2.getDouble();

    return result;
  }
}
