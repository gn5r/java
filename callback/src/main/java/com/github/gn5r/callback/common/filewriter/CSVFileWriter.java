package com.github.gn5r.callback.common.filewriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.core.io.ByteArrayResource;

public class CSVFileWriter<T> {

  private CSVFormat format;
  private Function<T, Object[]> values;

  public CSVFileWriter(Function<T, Object[]> values, String... header) {
    this.values = values;
    this.format = CSVFormat.DEFAULT.builder().setHeader(header).get();
  }

  public ByteArrayResource export(List<T> items) throws IOException {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(baos, StandardCharsets.UTF_8), this.format)) {
      for (T item : items) {
        csvPrinter.printRecord(values.apply(item));
      }
      csvPrinter.flush();
      return new ByteArrayResource(baos.toByteArray());
    }
  }

}
