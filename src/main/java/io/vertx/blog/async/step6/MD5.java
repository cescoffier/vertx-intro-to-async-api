package io.vertx.blog.async.step6;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

public interface MD5 {

  static MD5 create(Vertx vertx) {
    return new MD5Impl(vertx);
  }

  void md5(String message, Handler<AsyncResult<byte[]>> resultHandler);

}
