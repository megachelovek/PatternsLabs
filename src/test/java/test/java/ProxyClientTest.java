package test.java;


import com.ssau.ProxyMultiplyClientClass;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ProxyClientTest {

  @Test
  public void TestProxyClient() throws IOException, DecoderException, ClassNotFoundException {
    ProxyMultiplyClientClass.ConnectToServer(3333333,7777777);
    System.out.println();

  }
}
