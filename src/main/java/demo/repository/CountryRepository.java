package demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import demo.model.Country;

@RepositoryRestResource(collectionResourceRel = "country", path = "country")

public interface CountryRepository extends PagingAndSortingRepository<Country, String> {
	List<Country> findBycountryId(@Param("countryId") String countryId);
	List<Country> findAll();

}
