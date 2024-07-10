package com.minhazul;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class CompanyRepository implements ReactivePanacheMongoRepository<Company> {
    public Uni<Void> seedData() {
        List<Company> companyList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            companyList.add(new Company("Company " + i, Arrays.asList("email" + i + "@email.com", "test" + i + "@test.com")));
        }
        return persist(companyList);
    }

    public Uni<List<Company>> findByEmailWithoutRegex(List<String> emails) {
        return find("emails in ?1", emails).list();
    }

    public Uni<List<Company>> findByEmailRegex(List<String> emails) {
        var modifiedEmail = emails.stream().map(email -> "/" + email + "/i").toArray();
        return find("emails in ?1", modifiedEmail).list();
    }

    public Uni<List<Company>> workingRegexFindInListSingle(String email) {
        return find("{ emails: { $in : [ /" + email + "/ ] } }").list();
    }

    public Uni<List<Company>> regexFindInListSingle(String email) {
        return find("emails in ?1", "/" + email + "/").list();
    }
}
