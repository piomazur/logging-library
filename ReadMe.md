#Run with Docker Compose

To get the default distributions of Elasticsearch and Kibana up and running in Docker, you can use Docker Compose.

1. docker-compose up - to bring up the three-node Elasticsearch cluster and Kibana [Inside main project folder].
2. http://localhost:5601 - Kibana's address to load sample data and interact with the cluster. 
3. docker-compose down -v - to tear down the containers and volumes.








Reviewed links:


Structured logging

https://www.innoq.com/en/blog/structured-logging/ - usefull link as a starting point to structured logging, with overview of possible approaches - MDC vs logging-logstash-encoder. The MDC uses a ThreadLocal, so it is important to clear it after exiting the thread. The MDC is handy, it is complicated for multi-threaded applications and it does not work with reactive implementations out of the box, such as Spring WebFlux and Netty as requests are processed by multiple threads. The logstash-logback-encoder library has the concept of event specific custom fields and brings Markers to add additional fields to the generated JSON output and StructuredArguments use these markers to add data to the JSON output and to the actual log message.

More technical details along with list of possible appenders can be founded https://github.com/logstash/logstash-logback-encoder/blob/master/README.md

https://www.elastic.co/guide/en/elastic-stack-get-started/current/get-started-docker.html - quick setup of docker with ELK Stack, 

https://dzone.com/articles/logging-with-spring-boot-and-elastic-stack - handy todo list to integrate with elastic stack


Sanitization of log messages

1 KeyValueCollection - approach
https://docs.genesys.com/Documentation/PSDK/latest/Developer/LogSensitiveData - one of approach to data sanitization, through KeyValueCollection with predefined filtering masks, consider to use together with structured logging. 

2 Custom annotation - @Sanitize
Might be used with solution proposed by Andrzej, implement custom annotation with annotation processor which will idetify all fields to sanitize and on toString() method returnd will be masked string

3 https://docs.bmc.com/docs/AtriumOrchestratorPlatform/78/hiding-the-display-of-secure-data-in-log-files-559548709.html - masks the specific keywords in log files, through log_config.xml. Possible to define custom fields. No needed of additional implementention only log_config.xml must be distributed among projects. To check whether solution can be easly possible to introduce along with structured logging.




 