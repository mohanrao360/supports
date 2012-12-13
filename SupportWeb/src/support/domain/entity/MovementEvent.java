package support.domain.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import support.domain.enums.ContraAction;
import support.domain.enums.Direction;
import support.domain.enums.EquipmentCondition;
import support.domain.enums.EventType;
import support.domain.enums.LoadEmptyIndicator;
import support.domain.enums.WeightUnit;
import support.utils.TimestampUtil;


@Entity(name = "EQP_EVENT_LOG")
public class MovementEvent implements Serializable {

  private static final long serialVersionUID = -321023715030025820L;

  @Id
  @Column(name = "EVENT_TIMESTAMP")
  private String eventTimestamp;

  @Column(name = "CNTR_NUM")
  private String containerNumber;

  @Column(name = "EVENT_CRE_DT")
  private Date eventCreationDateTime;

  @Column(name = "FCIL_CDE")
  private String facilityCode;

  @Column(name = "EVENT_TYPE")
  @Type(type = "support.utils.GenericEnumUserType", parameters = {
      @Parameter(name = "enumClass", value = "support.domain.enums.EventType"),
      @Parameter(name = "identifierMethod", value = "getCode"),
      @Parameter(name = "valueOfMethod", value = "getEventTypeForCode") })
  private EventType eventType;

  @Column(name = "EVENT_DT_LOC")
  private Date eventDateTime;

  @Column(name = "SEAL_NUM")
  private String sealNumber;

  @Column(name = "SEAL_TYPE")
  private String sealType;

  @Column(name = "CNTR_GRP_CDE")
  private String containerGroupCode;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "LOAD_EMPTY_IND")
  private LoadEmptyIndicator loadEmptyIndicator;

  @Column(name = "SVC_LOOP")
  private String serviceLoop;

  @Column(name = "VSL_CDE")
  private String vesselCode;

  @Column(name = "VOY_NUM")
  private String voyageNumber;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "DIR_BOUND")
  private Direction directionBound;

  @Column(name = "LOAD_PORT")
  private String loadPort;

  @Column(name = "DSGH_PORT")
  private String dischargePort;

  @Column(name = "NEXT_LOCA")
  private String nextLocation;

  @Column(name = "DOC_REF")
  private String documentReference;

  @Column(name = "DOC_TYPE")
  private String documentType;

  @Column(name = "GROSS_WT")
  private Double grossWeight;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "GROSS_WT_UNIT")
  private WeightUnit grossWeightUnit;

  @Enumerated(value = EnumType.ORDINAL)
  @Column(name = "CNTR_COND")
  private EquipmentCondition containerCondition;

  @Column(name = "HZ_IND")
  private Boolean hazardIndicator;

  @Column(name = "REMARKS")
  private String remarks;

  @Column(name = "CONTRA_ACTION")
  @Type(type = "support.utils.GenericEnumUserType", parameters = {
      @Parameter(name = "enumClass", value = "support.domain.enums.ContraAction"),
      @Parameter(name = "identifierMethod", value = "getCode"),
      @Parameter(name = "valueOfMethod", value = "getContraActionForCode") })
  private ContraAction contraAction;

  @Column(name = "POS_AT_ROUTE")
  private String positionAtRoute;

  @Column(name = "NATURE")
  private String nature;

  @Column(name = "CNTR_CHK_DIGIT")
  private String containerCheckDigit;

  @Column(name = "UPD_USER")
  private String updateUser;

  @Column(name = "REC_UPD_DT")
  @Version
  private Timestamp recordUpdateDateTime;

  @PreUpdate
  protected void onUpdate() {
    recordUpdateDateTime = TimestampUtil.now();
  }

  public String getEventTimestamp() {
    return eventTimestamp;
  }

  public void setEventTimestamp(String eventTimestamp) {
    this.eventTimestamp = eventTimestamp;
  }

  public String getContainerNumber() {
    return containerNumber;
  }

  public void setContainerNumber(String containerNumber) {
    this.containerNumber = containerNumber;
  }

  public Date getEventCreationDateTime() {
    return eventCreationDateTime;
  }

  public void setEventCreationDateTime(Date eventCreationDateTime) {
    this.eventCreationDateTime = eventCreationDateTime;
  }

  public String getFacilityCode() {
    return facilityCode;
  }

  public void setFacilityCode(String facilityCode) {
    this.facilityCode = facilityCode;
  }

  public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  public Date getEventDateTime() {
    return eventDateTime;
  }

  public void setEventDateTime(Date eventDateTime) {
    this.eventDateTime = eventDateTime;
  }

  public String getSealNumber() {
    return sealNumber;
  }

  public void setSealNumber(String sealNumber) {
    this.sealNumber = sealNumber;
  }

  public String getSealType() {
    return sealType;
  }

  public void setSealType(String sealType) {
    this.sealType = sealType;
  }

  public String getContainerGroupCode() {
    return containerGroupCode;
  }

  public void setContainerGroupCode(String containerGroupCode) {
    this.containerGroupCode = containerGroupCode;
  }

  public LoadEmptyIndicator getLoadEmptyIndicator() {
    return loadEmptyIndicator;
  }

  public void setLoadEmptyIndicator(LoadEmptyIndicator loadEmptyIndicator) {
    this.loadEmptyIndicator = loadEmptyIndicator;
  }

  public String getServiceLoop() {
    return serviceLoop;
  }

  public void setServiceLoop(String serviceLoop) {
    this.serviceLoop = serviceLoop;
  }

  public String getVesselCode() {
    return vesselCode;
  }

  public void setVesselCode(String vesselCode) {
    this.vesselCode = vesselCode;
  }

  public String getVoyageNumber() {
    return voyageNumber;
  }

  public void setVoyageNumber(String voyageNumber) {
    this.voyageNumber = voyageNumber;
  }

  public Direction getDirectionBound() {
    return directionBound;
  }

  public void setDirectionBound(Direction directionBound) {
    this.directionBound = directionBound;
  }

  public String getLoadPort() {
    return loadPort;
  }

  public void setLoadPort(String loadPort) {
    this.loadPort = loadPort;
  }

  public String getDischargePort() {
    return dischargePort;
  }

  public void setDischargePort(String dischargePort) {
    this.dischargePort = dischargePort;
  }

  public String getNextLocation() {
    return nextLocation;
  }

  public void setNextLocation(String nextLocation) {
    this.nextLocation = nextLocation;
  }

  public String getDocumentReference() {
    return documentReference;
  }

  public void setDocumentReference(String documentReference) {
    this.documentReference = documentReference;
  }

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public Double getGrossWeight() {
    return grossWeight;
  }

  public void setGrossWeight(Double grossWeight) {
    this.grossWeight = grossWeight;
  }

  public WeightUnit getGrossWeightUnit() {
    return grossWeightUnit;
  }

  public void setGrossWeightUnit(WeightUnit grossWeightUnit) {
    this.grossWeightUnit = grossWeightUnit;
  }

  public EquipmentCondition getContainerCondition() {
    return containerCondition;
  }

  public void setContainerCondition(EquipmentCondition containerCondition) {
    this.containerCondition = containerCondition;
  }

  public Boolean getHazardIndicator() {
    return hazardIndicator;
  }

  public void setHazardIndicator(Boolean hazardIndicator) {
    this.hazardIndicator = hazardIndicator;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public ContraAction getContraAction() {
    return contraAction;
  }

  public void setContraAction(ContraAction contraAction) {
    this.contraAction = contraAction;
  }

  public String getPositionAtRoute() {
    return positionAtRoute;
  }

  public void setPositionAtRoute(String positionAtRoute) {
    this.positionAtRoute = positionAtRoute;
  }

  public String getNature() {
    return nature;
  }

  public void setNature(String nature) {
    this.nature = nature;
  }

  public String getContainerCheckDigit() {
    return containerCheckDigit;
  }

  public void setContainerCheckDigit(String containerCheckDigit) {
    this.containerCheckDigit = containerCheckDigit;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Timestamp getRecordUpdateDateTime() {
    return recordUpdateDateTime;
  }

  public void setRecordUpdateDateTime(Timestamp recordUpdateDateTime) {
    this.recordUpdateDateTime = recordUpdateDateTime;
  }
}
