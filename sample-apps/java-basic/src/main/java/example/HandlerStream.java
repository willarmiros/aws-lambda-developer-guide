package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;


import java.util.HashMap;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.lang.IllegalStateException;

// Handler value: example.Handler
public class HandlerStream implements RequestStreamHandler {
  Gson gson = new GsonBuilder().setPrettyPrinting().create();
  @Override
  public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException
  {
    // log execution details
    // process event
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("US-ASCII")));
    //PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, Charset.forName("US-ASCII"))));
    OutputStreamWriter writer = new OutputStreamWriter(outputStream, Charset.forName("US-ASCII"));
    try 
    {
      HashMap event = gson.fromJson(reader, HashMap.class);
      String output = gson.toJson(event);
      //writer.write(output, 0, output.length());
      outputStream.write(123);
      System.out.println("OUTPUT: " + output);
      System.out.println("EVENT TYPE: " + event.getClass().toString());
    }
    catch (IllegalStateException | JsonSyntaxException exception)
    {
      System.out.println(exception.toString());
    }
    System.out.println("STREAM TYPE: " + inputStream.getClass().toString());
  }
}