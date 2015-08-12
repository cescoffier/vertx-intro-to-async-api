package io.vertx.blog.async;

import io.vertx.blog.async.step6.Hex;
import io.vertx.blog.async.step6.MD5;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class Step6Test {

  @Rule
  public RunTestOnContext rule = new RunTestOnContext();

  @Test
  public void test(TestContext context) {
    Async async = context.async();
    Vertx vertx = Vertx.vertx();
    MD5.create(vertx).md5("Hello",
        md5Result -> {
          if (md5Result.succeeded()) {
            Hex.create(vertx).hex(md5Result.result(), hexResult -> {
              System.out.println(hexResult.result());
              async.complete();
            });
          } else {
            System.err.println("Failed to compute the md5 checksum:" + md5Result.cause().getMessage());
            context.fail(md5Result.cause());
          }
        }
    );
  }


}