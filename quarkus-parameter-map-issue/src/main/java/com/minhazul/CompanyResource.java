package com.minhazul;


import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;

@Path("/company")
@Produces(MediaType.APPLICATION_JSON)
public class CompanyResource {
    private final CompanyRepository companyRepository;

    public CompanyResource(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @POST
    @Path("seed")
    public Uni<String> seed() {
        return companyRepository.seedData().map(ignore -> "ok");
    }

    @POST
    @Path("findByName")
    public Uni<List<Company>> findByName() {
        return companyRepository.findByName("Company 1");
    }

    @POST
    @Path("workingFindByEmail")
    public Uni<List<Company>> findByNameRegex() {
        return companyRepository.workingFindByEmail("test1@test.com");
    }


    @POST
    @Path("issueFindByEmail")
    public Uni<List<Company>> issueFindByEmail() {
        return companyRepository.issueFindByEmail("test1@test.com");
    }
}
