package app;

import io.jooby.JoobyTest;
import io.jooby.StatusCode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JoobyTest(App.class)
public class IntegrationSoma {

  static OkHttpClient client = new OkHttpClient();

  @Test
  public void soma(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/soma/3/4")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals("7.0", rsp.body().string());
      assertEquals(StatusCode.OK.value(), rsp.code());
    }
  }
}
