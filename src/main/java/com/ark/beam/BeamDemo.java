package com.ark.beam;

import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;

public class BeamDemo {

    public static void main(String[] args) {
        System.out.println("Demo of pipe line options");
        PipelineOptions pipelineOptions = PipelineOptionsFactory.create();
        System.out.println("Job Name "+pipelineOptions.getJobName());
        System.out.println("Id "+pipelineOptions.getOptionsId());
        System.out.println("Temp Location "+pipelineOptions.getTempLocation());
    }

}
