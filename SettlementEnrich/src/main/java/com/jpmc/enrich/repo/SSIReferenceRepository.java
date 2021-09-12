package com.jpmc.enrich.repo;


import com.jpmc.enrich.model.SSIReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SSIReferenceRepository extends JpaRepository<SSIReference,String> {

}
