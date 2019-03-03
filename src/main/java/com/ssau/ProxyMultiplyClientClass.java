package com.ssau;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ProxyMultiplyClientClass {
  private int  SOCKET = 5000;
  private String HOST_NAME;
  private double[] args;
  String data;

  public ProxyMultiplyClientClass(String host){
    this.HOST_NAME = host;
  }

  public  String ConnectToServer(double firstArg,double secondArg) throws IOException {
    Socket clientSocket = new Socket(HOST_NAME,SOCKET);
    double[] arrDouble = new double[]{firstArg,secondArg};
    Gson gson = new Gson();
    String json = gson.toJson(arrDouble);
    BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
    pw.println(json);

    data = br.readLine();
    br.close();
    pw.close();
    clientSocket.close();

    return data;
  }
}
