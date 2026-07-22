package com.resource;

import com.domain.Rule;
import com.dto.RuleDTO;
import com.service.RuleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/rules")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RuleResource {

    @Inject
    RuleService ruleService;

    @POST
    public Response createRule(RuleDTO ruleDTO) {
        Rule createdRule = ruleService.createRule(ruleDTO.getText(), ruleDTO.getDescription());
        RuleDTO createdRuleDTO = new RuleDTO(
                createdRule.id, createdRule.getName(), createdRule.getDescription());
        return Response
                .status(Response.Status.CREATED)
                .entity(createdRuleDTO)
                .build();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteRule(@PathParam("id") Long id) {
        ruleService.deleteRule(id);
        return Response.ok().build();
    }

    @Path("/{id}")
    @PUT
    public Response updateRule(@PathParam("id") Long id, RuleDTO ruleDTO) {
        ruleService.updateRule(id, ruleDTO);
        return Response.ok().build();
    }
}
