package com.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Map;

@Path("/wheel")
public class WheelResource {

    @Inject
    Template wheel;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance hello() throws JsonProcessingException {
        List<String> test = List.of("Springer ziehen wie Bauern", "Könige können 2 mal ziehen");
        List<Map<String, String>> rules = test.stream()
                .map(r -> Map.of("text", r))
                .toList();
        String rulesJson = new ObjectMapper().writeValueAsString(rules);
        return wheel.data("rules", rulesJson);
    }
}
