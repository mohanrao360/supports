package support.dao;

import org.springframework.stereotype.Repository;

import support.domain.entity.EquipmentLatestInfo;


@Repository("equipmentLatestInfoDao")
public class EquipmentLatestInfoDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return EquipmentLatestInfo.class;
  }
}
