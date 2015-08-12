package io.vertx.blog.async.step6;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

public interface Hex {

  static Hex create(Vertx vertx) {
    return new HexImpl(vertx);
  }

  void hex(byte[] bytes, Handler<AsyncResult<String>> resultHandler);
}
