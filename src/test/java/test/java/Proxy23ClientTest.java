package test.java;


import com.ssau.ProxyMultiplyClientClass;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Proxy23ClientTest {

  @Test
  public void TestProxyClient() throws IOException, DecoderException, ClassNotFoundException {
    ProxyMultiplyClientClass clientClass = new ProxyMultiplyClientClass("127.0.0.1");
    double result = clientClass.ConnectToServer(3333333,7777777);
    System.out.println("Result = " + result);

  }
}
