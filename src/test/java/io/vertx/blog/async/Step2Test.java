package io.vertx.blog.async;

import io.vertx.blog.async.step2.MD5;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by clement on 11/08/2015.
 */
@RunWith(VertxUnitRunner.class)
public class Step2Test {


  @Test
  public void test(TestContext context) {
    Async async = context.async();
    MD5.create().md5("Hello", result -> {
      System.out.println(result);
      async.complete();
    });
  }

}