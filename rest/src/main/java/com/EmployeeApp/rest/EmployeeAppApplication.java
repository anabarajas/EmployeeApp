package com.EmployeeApp.rest;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by abarajas on 6/23/17.
 */

@ApplicationPath("/")
public class EmployeeAppApplication extends ResourceConfig {

    public EmployeeAppApplication() {
        packages("com.EmployeeApp.rest");
    }

//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> s = new HashSet<>();
//        s.add(EmployeeResource.class);
//        return s;
//    }

}
