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
    @Path("findByEmail")
    public Uni<List<Company>> findByEmail() {
        return companyRepository.findByEmailWithoutRegex(Arrays.asList("email1@email.com", "email2@email.com"));
    }

    @POST
    @Path("findByEmailRegex")
    public Uni<List<Company>> findByEmailRegex() {
        return companyRepository.findByEmailRegex(Arrays.asList("email"));
    }

    @POST
    @Path("workingRegexFindInListSingle")
    public Uni<List<Company>> workingRegexFindInListSingle() {
        return companyRepository.workingRegexFindInListSingle("@email.com");
    }

    @POST
    @Path("regexFindInListSingle")
    public Uni<List<Company>> regexFindInListSingle() {
        return companyRepository.regexFindInListSingle("@email.com");
    }

}
