package io.vertx.blog.async.step2;

import io.vertx.core.Handler;
import org.apache.commons.codec.digest.DigestUtils;

public class MD5Impl implements MD5 {

  public void md5(String message, Handler<String> resultHandler) {
    new Thread(() -> {
      String result = DigestUtils.md5Hex(message);
      // Called in the same thread.
      resultHandler.handle(result);
    }).start();
  }
}
