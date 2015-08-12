package io.vertx.blog.async;

import io.vertx.blog.async.step0.MD5;
import org.junit.Test;

/**
 * Created by clement on 11/08/2015.
 */
public class Step0Test {


  @Test
  public void test() {
    String checksum = MD5.create().md5("Hello");
    System.out.println(checksum);
  }

}