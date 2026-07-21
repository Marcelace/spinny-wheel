package com.resource;

import com.domain.Rule;
import com.dto.RuleDTO;
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

@Path("/")
public class WheelResource {

    @Inject
    Template wheel;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getWheel() throws JsonProcessingException {
        List<RuleDTO> rules = Rule.<Rule>listAll()
                .stream()
                .map(r -> new RuleDTO(
                        r.id,
                        r.getName(),
                        r.getDescription()
                ))
                .toList();

        String rulesJson = new ObjectMapper().writeValueAsString(rules);

        return wheel.data("rules", rulesJson);
    }
}
