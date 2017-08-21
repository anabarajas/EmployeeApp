package com.EmployeeApp.rest;

import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.ContextResolver;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abarajas on 6/23/17.
 */

@ApplicationPath("/")
public class EmployeeAppApplication extends ResourceConfig {

    public EmployeeAppApplication() {
        packages("com.EmployeeApp.rest");
        register(MOXyJsonContextResolver.class);

    }

//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> s = new HashSet<>();
//        s.add(EmployeeResource.class);
//        return s;
//    }

}
