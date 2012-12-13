package support.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import support.dao.ContainerDao;
import support.dao.EquipmentEventDao;
import support.domain.entity.Container;
import support.domain.entity.EquipmentEvent;
import support.domain.enums.ValidationType;
import support.validation.checks.AbstractValidationCheck;


@Service
@Scope("prototype")
public class EquipmentEventValidation extends EventValidationTemplate {
  @Autowired
  private ContainerDao containerDao;
  @Autowired
  private EquipmentEventDao equipmentEventDao;

  @Override
  protected void initializeRules(List<AbstractValidationCheck> rules) {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addToEventLog() {
    EquipmentEvent event = validationEnvironment.createEquipmentEventLog();
    equipmentEventDao.save(event);

  }

  @Override
  protected void updateOrCreateEquipment() {
    if (validationEnvironment.getValidationType() == ValidationType.CREATION
        || validationEnvironment.getValidationType() == ValidationType.TERMINATION) {
      Container containerInfo = validationEnvironment.getContainerInfo();
      containerDao.saveOrUpdate(containerInfo);
    }
  }
}
