Introduction

The middleware API b2b gateway service is designed to process purchase order transactions coming from legacy B2B systems. To support large-scale enterprise workloads such as 10,000 requests per second, the system must be architected with scalability, resilience, and efficient resource utilization in mind.

⸻

1. Horizontal Scaling

The primary approach to handle high traffic is deploying multiple instances of the Spring Boot service behind a load balancer.

Using container orchestration platforms, new service instances can be dynamically added or removed based on CPU, memory, and request load.

This ensures that incoming requests are evenly distributed across available nodes.

⸻

2. Asynchronous Processing

The service currently uses Spring’s @Async processing model to decouple request acceptance from file transformation operations.

The transformation task is lightweighted to prevent blocking API threads.

Thread pool executor configuration can be tuned to optimize concurrency levels and reduce request latency.

⸻

3. Stateless API Gateway Design

The service follows a stateless architecture where transaction processing does not depend on session memory.

This enables horizontal scaling and simplifies load balancing.

Authentication is handled using OAuth2 JWT tokens, allowing independent request validation.

⸻

4. Efficient File Middleware Simulation

Legacy system integration is simulated through flat file generation inside a dedicated output directory.

In a production environment, this can be replaced with distributed storage systems or enterprise messaging middleware.

⸻

5. Caching Layer Optimization

Frequently accessed metadata can be stored in distributed caching systems such as Redis to reduce database query overhead.

Caching reduces latency and improves response time under heavy traffic conditions.

⸻

6. Message Queue Based Event Processing (Future Enhancement)

For AT&T-scale workloads, event-driven architecture can be introduced using messaging platforms such as RabbitMQ or Kafka.

This approach helps in:
•	Decoupling request ingestion from processing
•	Supporting burst traffic
•	Improving system durability

⸻

7. Database Performance Considerations

Transaction metadata should be indexed on unique purchase order numbers.

Connection pooling and query optimization should be applied.

Read/write separation can be considered for enterprise deployments.

⸻

8. Containerized Deployment

The application is containerized using Docker, allowing consistent deployment across environments.

Container orchestration platforms enable automated scaling and high availability.

⸻

Conclusion

The service is designed as a lightweight middleware gateway that can scale horizontally, process requests asynchronously, and support enterprise traffic loads. Future enhancements may include event-driven messaging, distributed caching, and advanced cloud-native deployment strategies.