package com.ark.beam.ex1;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.*;

import java.util.List;

public class BasicFilteringExample {
    public static void main(String[] args) {
        PipelineOptions pipelineOptions = PipelineOptionsFactory.create();
        Pipeline pipeline = Pipeline.create(pipelineOptions);
        List<Integer> data = DataSet.getData();
        pipeline.apply(Create.of(data))
                .apply(MapElements.via(new SimpleFunction<Integer, Integer>() {
                    public Integer apply(Integer input) {
                        System.out.println("Pre Filtered " + input);
                        return input;
                    }
                }))
                .apply(ParDo.of(new FilterData(5)))
                .apply(MapElements.via(new SimpleFunction<Integer, Integer>() {
                    public Integer apply(Integer input) {
                        System.out.println("Post Filtered " + input);
                        return input;
                    }
                }));
        pipeline.run();
    }

    private static class FilterData extends DoFn<Integer, Integer> {
        private int maxLimit = 10;

        public FilterData(int maxLimit) {
            this.maxLimit = maxLimit;
        }

        @ProcessElement
        public void processElement(ProcessContext context) {
            if (context.element() < maxLimit) {
                context.output(context.element());
            }

        }
    }
}
