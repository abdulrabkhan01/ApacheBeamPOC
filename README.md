# ApacheBeamPOC
Doing POC for apache Beam

Basics of Apache Beam
-----------------------

Introduction: 
-------------
Open Source Library to define both batch and streaming, parallel data pipelines.
Pipelines specify the transformations on the data, the Pipelines executed by distributed
processing backends. (Apache beam does not execute the pipleline, it just used to define the pipeline)
Supported back ends for running apache beam pipelines


 <ul> Apache Flink </ul>
  <ul> Apache Spark </ul>
   <ul> Google Cloud Dataflow</ul>
    <ul> Apache Samza </ul>
     <ul> Hazlecast Jet </ul>
     <ul> Direct Runner</ul>
     <ul> Apache Nemo</ul>


Pipeline:
---------
It encapsulates the entire data processing task from start to finish.
READ DATA -> TRANSFORM -> PERSIST OUTPUT

PCollection:
-------------
Defines the distributed data set that Apache Beam Pipeline operates on. The data set can be bounded (i.e. coming from fixed source like file)
or unbounded(i.e. coming from like continously updating source, like subscriptions etc.)

Typical Beam Driver program work as follows:
----------------------------------------------
<ul>1- Create: a pipeline object and set execution options</ul>
<ul>2- Create: a PCollection Object for pipeline data (Either through IO/Memory)</ul>
<ul>3- Apply: PTransform to each PCollection, Transforms can chang, filer, group, analyze or process the PCollection without 
modifying then input collection.</ul>