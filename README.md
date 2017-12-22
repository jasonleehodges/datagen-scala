<h1>datagen-scala</h1>
<p>This is a re-write of the <a href="https://github.com/jasonleehodges/datagen">module I created in Python.</a> 
At 10 million rows of fake data, even with 5 threads Python was taking hours. This Scala version can do the same work 
in minutes with only 1 thread.</p>

<p>The project is spun up using SBT and has some java-based dependencies that need to be compiled with the project. All of
that is in the SBT build file.</p>
