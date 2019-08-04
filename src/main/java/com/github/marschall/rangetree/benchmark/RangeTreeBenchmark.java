package com.github.marschall.rangetree.benchmark;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.github.marschall.rangetree.LLRBRangeTree;
import com.github.marschall.rangetree.RangeMap;
import com.github.marschall.rangetree.key.U96;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class RangeTreeBenchmark {

  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder()
        .include(".*RangeTreeBenchmark.*")
        .warmupIterations(5)
        .measurementIterations(5)
        .resultFormat(ResultFormatType.TEXT)
        .result("range-tree-result.txt")
        .build();
    new Runner(options).run();
  }

  private RangeMap<U96, String> tree;

  @Setup
  public void setup() {
    this.tree = new LLRBRangeTree<>();
  }

  @Benchmark
  public Object get() {
    return null;
  }

}
