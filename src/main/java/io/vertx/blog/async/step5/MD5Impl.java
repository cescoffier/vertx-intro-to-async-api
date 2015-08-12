package io.vertx.blog.async.step5;

import io.vertx.core.AsyncResult;
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

  public void md5(String message, Handler<AsyncResult<String>> resultHandler) {
    vertx.executeBlocking(
        future -> {
          if (message == null) {
            future.fail(new NullPointerException("`message` must not be `null`"));
          } else {
            String result = DigestUtils.md5Hex(message);
            future.complete(result);
          }
        },
        resultHandler::handle
    );
  }
}
