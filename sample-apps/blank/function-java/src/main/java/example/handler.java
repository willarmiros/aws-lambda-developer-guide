package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class Handler implements RequestHandler<SQSEvent, String>{
  // example.Handler::handleRequest

  @Override
  public String handleRequest(SQSEvent event, Context context)
  {
    LambdaLogger logger = context.getLogger();
    logger.log(event.toString());
    logger.log(context.toString());
    for(SQSMessage msg : event.getRecords()){
      logger.log(new String(msg.getBody()));
    }
    return "HELLO";
  }
}