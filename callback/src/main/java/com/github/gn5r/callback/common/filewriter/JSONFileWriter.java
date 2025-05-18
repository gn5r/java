package com.github.gn5r.callback.common.filewriter;

import java.util.List;

import org.springframework.core.io.ByteArrayResource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONFileWriter<T> {

  private ObjectMapper objectMapper;

  public JSONFileWriter() {
    var dpp = new DefaultPrettyPrinter();
    dpp.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
    this.objectMapper = new ObjectMapper()
        .enable(SerializationFeature.INDENT_OUTPUT)
        .setDefaultPrettyPrinter(dpp);
  }

  public ByteArrayResource export(List<T> items) throws JsonProcessingException {
    var bytes = objectMapper.writeValueAsBytes(items);
    return new ByteArrayResource(bytes);
  }

}
