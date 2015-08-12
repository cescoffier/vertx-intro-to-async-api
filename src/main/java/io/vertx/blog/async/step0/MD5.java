package io.vertx.blog.async.step0;

/**
 * Step 0 - traditional interface.
 */
public interface MD5 {

  static MD5 create() {
    return new MD5Impl();
  }

  String md5(String message);

}
