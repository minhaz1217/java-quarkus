package com.minhazul;


import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class CompanyRepository implements ReactivePanacheMongoRepository<Company> {
    public Uni<Void> seedData() {
        List<Company> companyList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            companyList.add(new Company("Company " + i, new Address("0123456789" + i, "test" + i + "@test.com")));
        }
        return persist(companyList);
    }

    public Uni<List<Company>> findByName(String name) {
        return find("name = ?1", name).list();
    }

    public Uni<List<Company>> workingFindByEmail(String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        return find("address.email = :email", map).list();
    }

    public Uni<List<Company>> issueFindByEmail(String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("address.email", email);
        return find("address.email = :address.email", map).list();
    }
}
