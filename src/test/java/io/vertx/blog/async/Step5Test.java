package io.vertx.blog.async;

import io.vertx.blog.async.step5.MD5;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by clement on 11/08/2015.
 */
@RunWith(VertxUnitRunner.class)
public class Step5Test {

  @Rule
  public RunTestOnContext rule = new RunTestOnContext();

  @Test
  public void test(TestContext context) {
    Async async = context.async();
    MD5.create(Vertx.vertx()).md5("Hello", ar -> {
      System.out.println(ar.result());
      async.complete();
    });
  }

  @Test
  public void testWithNull(TestContext context) {
    Async async = context.async();
    MD5.create(Vertx.vertx()).md5(null, ar -> {
      if (ar.failed()) {
        System.err.println("Error caught: " + ar.cause().getMessage());
        async.complete();
      } else {
        context.fail("Failure expected");
      }
    });
  }


  @Test
  public void testWithCompletePattern(TestContext context) {
    Async async = context.async();
    MD5.create(Vertx.vertx()).md5("Hello", ar -> {
      if (ar.failed()) {
        System.err.println(ar.cause().getMessage());
        context.fail(ar.cause());
      } else {
        System.out.println(ar.result());
        async.complete();
      }
    });
  }

}