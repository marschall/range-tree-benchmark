package com.github.marschall.rangetree.benchmark;

import static java.nio.charset.StandardCharsets.US_ASCII;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.github.marschall.minicsv.CellSet;
import com.github.marschall.minicsv.CsvParser;
import com.github.marschall.rangetree.LLRBRangeTree;
import com.github.marschall.rangetree.Range;
import com.github.marschall.rangetree.RangeMap;
import com.github.marschall.rangetree.key.U96;

final class BinRangeParser {

  static RangeMap<U96, String> parse() throws IOException {
    RangeMap<U96, String> map = new LLRBRangeTree<>();
    Path latestCsv = Paths.get("src/main/resources/latest.csv");
    CsvParser parser = new CsvParser(',', true);
    parser.parse(latestCsv, US_ASCII, row -> {
      CellSet cellSet = row.getCellSet();
      cellSet.next(); // COMPANY_ID
      cellSet.next(); // COMPANY_NAME
      cellSet.next(); // ICA
      cellSet.next(); // ACCOUNT_RANGE_FROM
      int rangeFrom = cellSet.getInt();
      cellSet.next(); // ACCOUNT_RANGE_TO
      int rangeTo = cellSet.getInt();
      System.out.println(new Range(rangeFrom, rangeTo));
    });
    return map;
  }

  public static void main(String[] args) throws IOException {
    parse();
  }

}
