package io.vertx.blog.async.step2;

import io.vertx.core.Handler;

/**
 * Step 2 - Do not block the caller thread - using vert.x handler.
 */
public interface MD5 {

  static MD5 create() {
    return new MD5Impl();
  }

  void md5(String message, Handler<String> resultHandler);

}
