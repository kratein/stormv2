storm


To compile the storm topology you need to clone the repo

When done go to the directory storm_process_java

Launch the command __mvn -X clean install__

When the compilation is finish launch one more command to execute as a test the topology __mvn compile exec:java -Dstorm.topology=storm.starter.bigdata.TwitterMysqlTopology__

storm ui command: __/opt/storm/bin/storm nimbus | /opt/storm/bin/storm supervisor | /opt/storm/bin/storm ui__
Zookeeper command: __/opt/zookeeper/bin/zkServer.sh start zoo_sample.cfg__