package com.captain.esd_project;

import com.captain.esd_project.Util.CORSFilter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {
    public HelloApplication () {
        register(CORSFilter.class);
        packages("com.captain.esd_project");
    }
}