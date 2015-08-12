package io.vertx.blog.async.step1;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Impl implements MD5 {

  public void md5(String message, Callback callback) {
    new Thread(() -> {
      String result = DigestUtils.md5Hex(message);
      // Called in the same thread.
      callback.onComputationCompleted(result);
    }).start();
  }
}
