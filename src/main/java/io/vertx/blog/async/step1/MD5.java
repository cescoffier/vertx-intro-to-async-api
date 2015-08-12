package io.vertx.blog.async.step1;

/**
 * Step 1 - Do not block the caller thread.
 */
public interface MD5 {

  static MD5 create() {
    return new MD5Impl();
  }

  interface Callback {
    void onComputationCompleted(String result);
  }

  void md5(String message, Callback retriever);

}
