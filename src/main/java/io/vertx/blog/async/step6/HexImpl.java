package io.vertx.blog.async.step6;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

public class HexImpl implements Hex {

  private final Vertx vertx;

  public HexImpl(Vertx vertx) {
    this.vertx = vertx;
  }

  @Override
  public void hex(byte[] bytes, Handler<AsyncResult<String>> resultHandler) {
    vertx.executeBlocking(
        future -> {
          String hex = org.apache.commons.codec.binary.Hex.encodeHexString(bytes);
          future.complete(hex);
        },
        resultHandler::handle
    );
  }
}
