package demo.domain;

import org.springframework.data.geo.Point;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "locations")
public interface SupplyLocationRepository extends PagingAndSortingRepository<SupplyLocation, Long>{

    @RestResource(rel = "by-location", description = @Description("Find by location, comma separated, e.g. 'lat,long', e.g. '50km'"))
    SupplyLocation findFirstByLocationNear(@Param("location") Point location);
}
