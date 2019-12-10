package gmail.kazzimir.bortnik.sting.maingateway.maingatewayrepository.model;

import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.Objects;

@Document(collection = "Routes")
public class Route {
    @Id
    private String id;

    @Field(value = "URL")
    private String uri;

    @Field(value = "order")
    private int order;

    @Field(value = "predicates")
    private Collection<PredicateDefinition> predicates;

    @Field(value = "filters")
    private Collection<FilterDefinition> filters;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Collection<PredicateDefinition> getPredicates() {
        return predicates;
    }

    public void setPredicates(Collection<PredicateDefinition> predicates) {
        this.predicates = predicates;
    }

    public Collection<FilterDefinition> getFilters() {
        return filters;
    }

    public void setFilters(Collection<FilterDefinition> filters) {
        this.filters = filters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return order == route.order &&
                Objects.equals(id, route.id) &&
                Objects.equals(uri, route.uri) &&
                Objects.equals(predicates, route.predicates) &&
                Objects.equals(filters, route.filters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uri, order, predicates, filters);
    }
}
