package io.vertx.blog.async.step6;

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

  @Override
  public void md5(String message, Handler<AsyncResult<byte[]>> resultHandler) {
      vertx.executeBlocking(
          future -> {
            if (message == null) {
              future.fail(new NullPointerException("Message must not be null"));
            } else {
              final byte[] bytes = DigestUtils.md5(message);
              future.complete(bytes);
            }
          },
          resultHandler::handle);
  }
}
