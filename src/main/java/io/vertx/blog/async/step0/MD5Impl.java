package io.vertx.blog.async.step0;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by clement on 11/08/2015.
 */
public class MD5Impl implements MD5 {

  public String md5(String message) {
    return DigestUtils.md5Hex(message);
  }
}
