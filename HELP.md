# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.5/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.5/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.5/reference/web/servlet.html)
* [Quartz Scheduler](https://docs.spring.io/spring-boot/3.5.5/reference/io/quartz.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

# PROJECT OVERVEIW

1. /users ->  paths = > create-user, delete-user, edit-user, update-user , request-access for privileges
2. /tasks -> paths -> get-task, create-task, update-task, delete-task

DB - in memory h2
Queue - Rabbit MQ
Cache - Redis
Scheduler - Quartz
AI - Spring AI for prioritization
UI - mnb-portal


Different user's can run there tasks ,
can define how frequent the task is to executed, daily, weekly, monthly, yearly
can define the task that needs to be executed, currently for demo we will call an external API on scheduled basis

Redis can help us in keeping the next scheduledFor instead of hitting the DB, 
Redis can keep the track of taskId and details, so that no redundant task by the same user is scheduled



