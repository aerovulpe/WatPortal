package me.aerovulpe.watportal.resources;

import static me.aerovulpe.watportal.Constants.BUILDINGS_RESOURCE;
import static me.aerovulpe.watportal.Constants.CODES_RESOURCE;
import static me.aerovulpe.watportal.Constants.COURSES_RESOURCE;
import static me.aerovulpe.watportal.Constants.EVENTS_RESOURCE;
import static me.aerovulpe.watportal.Constants.FOOD_RESOURCE;
import static me.aerovulpe.watportal.Constants.NEWS_RESOURCE;
import static me.aerovulpe.watportal.Constants.RESOURCES_RESOURCE;
import static me.aerovulpe.watportal.Constants.TERMS_RESOURCE;
import static me.aerovulpe.watportal.Constants.WEATHER_RESOURCE;

/**
 * Created by Aaron on 28/11/2014.
 */
public enum Resource {

    FOOD_MENU(FOOD_RESOURCE, "menu"),
    FOOD_NOTES(FOOD_RESOURCE, "notes"),
    FOOD_DIETS(FOOD_RESOURCE, "diets"),
    FOOD_OUTLETS(FOOD_RESOURCE, "outlets"),
    FOOD_LOCATIONS(FOOD_RESOURCE, "locations"),
    FOOD_WATCARD(FOOD_RESOURCE, "watcard"),
    FOOD_ANNOUNCEMENTS(FOOD_RESOURCE, "announcements"),
    FOOD_PRODUCTS(FOOD_RESOURCE + "/products"),

    COURSES_SUBJECT(COURSES_RESOURCE),
    COURSES_INFO(COURSES_RESOURCE),
    COURSES_SCHEDULE(COURSES_RESOURCE, "schedule"),
    COURSES_PREREQUISITES(COURSES_RESOURCE, "prerequisites"),
    COURSES_EXAMSCHEDULE(COURSES_RESOURCE, "examschedule"),

    EVENTS(EVENTS_RESOURCE),
    EVENTS_HOLIDAYS(EVENTS_RESOURCE, "holidays"),

    NEWS(NEWS_RESOURCE),

    WEATHER_CURRENT(WEATHER_RESOURCE, "current"),

    TERMS_LIST(TERMS_RESOURCE, "list"),
    TERMS_SCHEDULE(TERMS_RESOURCE, "schedule"),
    TERMS_EXAMSCHEDULE(TERMS_RESOURCE, "examschedule"),
    TERMS_INFOSESSIONS(TERMS_RESOURCE, "infosessions"),

    RESOURCES_TUTORS(RESOURCES_RESOURCE, "tutors"),
    RESOURCES_PRINTERS(RESOURCES_RESOURCE, "printers"),
    RESOURCES_INFOSESSIONS(RESOURCES_RESOURCE, "infosessions"),
    RESOURCES_GOOSEWATCH(RESOURCES_RESOURCE, "goosewatch"),

    CODES_UNITS(CODES_RESOURCE, "units"),
    CODES_TERMS(CODES_RESOURCE, "terms"),
    CODES_GROUPS(CODES_RESOURCE, "groups"),
    CODES_SUBJECTS(CODES_RESOURCE, "subjects"),
    CODES_INSTRUCTIONS(CODES_RESOURCE, "instructions"),

    BUILDINGS(BUILDINGS_RESOURCE),
    BUILDINGS_LIST(BUILDINGS_RESOURCE, "list"),
    BUILDINGS_COURSES(BUILDINGS_RESOURCE, "courses");


    private StringBuilder endpointBuilder;
    private String methodName;

    private boolean isBuilt = false;
    private int baseCount;

    Resource(String serviceName) {
        endpointBuilder = new StringBuilder();
        endpointBuilder.append(serviceName);
        baseCount = endpointBuilder.length();
    }

    Resource(String serviceName, String methodName) {
        this(serviceName);
        this.methodName = '/' + methodName;
    }

    public Resource addParams(String... params) {
        if (isBuilt)
            endpointBuilder.delete(baseCount, endpointBuilder.length());

        for (int i = 0; i < params.length; i++)
            endpointBuilder.append('/').append(params[i]);
        isBuilt = false;

        return this;
    }

    public String buildEndpoint() {
        if (isBuilt)
            endpointBuilder.delete(baseCount, endpointBuilder.length());

        if (methodName != null)
            endpointBuilder.append(methodName);
        endpointBuilder.append(".json");
        isBuilt = true;

        return endpointBuilder.toString();
    }

}

