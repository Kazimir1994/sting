package gmail.kazzimir.bortnik.sting.maingateway.gatewayrepository.impl;

import gmail.kazzimir.bortnik.sting.maingateway.gatewayrepository.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends MongoRepository<Route, String> {
}
