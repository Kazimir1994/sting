package gmail.kazzimir.bortnik.sting.maingateway.maingatewayrepository.impl;

import gmail.kazzimir.bortnik.sting.maingateway.maingatewayrepository.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends MongoRepository<Route, String> {
}
