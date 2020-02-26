package example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

class InvokeTest {
  //private static final Logger logger = LoggerFactory.getLogger(Handler.class);
  private static final Logger logger = LogManager.getLogger(Handler.class);

  @Test
  void invokeTest() {
    SQSEvent event = new SQSEvent();
    event.setRecords(new ArrayList<SQSMessage>());
    Context context = new TestContext();
    String requestId = context.getAwsRequestId();
    Handler handler = new Handler();
    logger.warn("TESTING");
    String result = handler.handleRequest(event, context);
    assertEquals(result, requestId);
  }

}
