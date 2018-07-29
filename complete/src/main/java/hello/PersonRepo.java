package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

/*
This repository is an interface and will allow you to perform various operations involving 
Person objects. It gets these operations by extending MongoRepository, which in turn extends 
the PagingAndSortingRepository interface defined in Spring Data Commons.

At runtime, Spring Data REST will create an implementation of this interface automatically. 
Then it will use the @RepositoryRestResource annotation to direct Spring MVC to create RESTful
endpoints at /people.
  @reference: https://spring.io/guides/gs/accessing-mongodb-data-rest/
 */

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepo extends MongoRepository<Person, String> {
	List<Person> findByLastName(@RequestParam("name") String name);
}

/*
 * Testing 
 *   curl -i -X POST -H "Content-Type:application/json" -d "{  \"firstName\" : \"Frodo\",  \"lastName\" : \"Baggins\" }" http://localhost:8080/people
 */
