package io.vertx.blog.async.step3;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by clement on 11/08/2015.
 */
public class MD5Impl implements MD5 {

  private final Vertx vertx;

  public MD5Impl(Vertx vertx) {
    this.vertx = vertx;
  }

  public void md5(String message, Handler<String> resultHandler) {
    vertx.<String>executeBlocking(
        future -> {
          String result = DigestUtils.md5Hex(message);
          future.complete(result);
        },
        ar -> resultHandler.handle(ar.result())
    );
  }
}
