package support.web.jsf.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import support.dao.SupplyHierarchyDao;
import support.domain.entity.SupplyHierarchy;
import support.domain.enums.Territory;
import support.service.FacilityService;


@Component("hierarchyBean")
@Scope("request")
public class HierarchyBean implements Serializable {
  private static final long serialVersionUID = -5650490585039961293L;
  private Collection<SupplyHierarchy> supplyHierarchies;
  
  @Autowired
  private SupplyHierarchyDao supplyHierarchyDao;
  
  @Resource(name = "facilityService")
  private FacilityService facilityService;

  public Collection<SupplyHierarchy> getSupplyHierarchies() {
    if(supplyHierarchies == null) {
      supplyHierarchies = supplyHierarchyDao.findAll();
    }
    return supplyHierarchies;
  }

  public List<SelectItem> getTerritories() {
    List<SelectItem> options = new ArrayList<SelectItem>();
    options.add(new SelectItem(""));
    for (Territory territory : Territory.values()) {
      options.add(new SelectItem(territory.name()));
    }
    return options;
  }
  
  public List<String> completeFacility(String query) {
    if (query.length() > 0 && query.length() < 5) {
      return facilityService.findFacilityCodesStartWith(query);
    }
    return null;
  }

}
