package com.EmployeeApp.rest;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by abarajas on 6/23/17.
 */

@ApplicationPath("/")
public class EmployeeAppApplication extends ResourceConfig {

    public EmployeeAppApplication() {
        packages("com.EmployeeApp.rest");
//  Moxy Feature is discovered and registered automatically but you can still register it manually
//        register(MoxyJsonFeature.class);
        register(MOXyJsonConfigurationContextResolver.class);

    }

//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> s = new HashSet<>();
//        s.add(EmployeeResource.class);
//        return s;
//    }

}
