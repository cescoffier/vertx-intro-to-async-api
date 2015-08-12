package io.vertx.blog.async;

import io.vertx.blog.async.step3.MD5;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class Step3Test {


  @Rule
  public RunTestOnContext rule = new RunTestOnContext();


  @Test
  public void test(TestContext context) {
    Async async = context.async();
    MD5.create(Vertx.vertx()).md5("Hello", result -> {
      System.out.println(result);
      async.complete();
    });
  }

}