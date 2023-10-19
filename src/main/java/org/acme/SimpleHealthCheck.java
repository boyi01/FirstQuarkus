package org.acme;


import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped  
public class SimpleHealthCheck implements HealthCheck {

    int counter = 0;
    @Override
    public HealthCheckResponse call() {

        counter++;
        if (counter> 5){
            return HealthCheckResponse.down("Counter to high");
        }
        return HealthCheckResponse.up("Simple health check");
    }
}