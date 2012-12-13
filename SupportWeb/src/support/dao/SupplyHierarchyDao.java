package support.dao;

import org.springframework.stereotype.Repository;

import support.domain.entity.SupplyHierarchy;


@Repository
public class SupplyHierarchyDao extends AbstractBaseDao {

  public static final String FACILITY = "facility";

  @Override
  public Class<?> getDomainClass() {
    return SupplyHierarchy.class;
  }
  
}
