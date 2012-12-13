package support.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import support.domain.enums.EquipmentType;
import support.domain.enums.SubEventType;


@Entity(name="EQMT_EVENT_ASSOCIATION")
public class EquipmentEvent implements Serializable{
  private static final long serialVersionUID = 4388775151562735529L;

  @Id
  @GenericGenerator(name="idGenerator", strategy="uuid")
  @GeneratedValue(generator="idGenerator")
  @Column(name = "EVENT_TIMESTAMP", nullable=false, updatable=false)
  private String eventTimestamp;
  
  @Column(name="EQMT_NUM", nullable=false, updatable=false)
  private String equipmentNumber;
  
  @Column(name="SEQ_NUM", nullable=false, updatable=false)
  private int sequenceNumber;
  
  @Column(name="EQMT_TYPE", nullable=false, updatable=false)
  @Type(type = "support.utils.GenericEnumUserType", parameters = {
      @Parameter(name = "enumClass", value = "support.domain.enums.EquipmentType"),
      @Parameter(name = "identifierMethod", value = "getCode"),
      @Parameter(name = "valueOfMethod", value = "getEquipmentTypeForCode") })
  private EquipmentType equipmentType;
  
  @Column(name="LOC", nullable=false)
  private String location;
  
  @Column(name="EVENT_DT_LOC", nullable=false)
  private Date eventDateTime;
  
  @Column(name="EVENT_TYPE", nullable=false)
  @Type(type = "support.utils.GenericEnumUserType", parameters = {
      @Parameter(name = "enumClass", value = "support.domain.enums.SubEventType"),
      @Parameter(name = "identifierMethod", value = "getCode"),
      @Parameter(name = "valueOfMethod", value = "getSubEventTypeForCode") })
  private SubEventType eventType;
  
  @Column(name="EQMT_TYPE_GRP_CDE", nullable=false)
  private String equipmentTypeGroupCode;
  
  @Column(name="EQMT_TYPE_CDE", nullable=false)
  private String equipmentTypeCode;
  
  @Column(name="MATERIAL")
  private String material;
  
  @Column(name = "DOC_NUM")
  private String documentNumber;
  
  @Column(name = "UPD_USER")
  private String updateUser;
  
  @Column(name = "REC_UPD_DT")
  private Date recordUpdateDateTime;

  public String getEventTimestamp() {
    return eventTimestamp;
  }

  public void setEventTimestamp(String eventTimestamp) {
    this.eventTimestamp = eventTimestamp;
  }

  public String getEquipmentNumber() {
    return equipmentNumber;
  }

  public void setEquipmentNumber(String equipmentNumber) {
    this.equipmentNumber = equipmentNumber;
  }

  public EquipmentType getEquipmentType() {
    return equipmentType;
  }

  public void setEquipmentType(EquipmentType equipmentType) {
    this.equipmentType = equipmentType;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Date getEventDateTime() {
    return eventDateTime;
  }

  public void setEventDateTime(Date eventDateTime) {
    this.eventDateTime = eventDateTime;
  }

  public SubEventType getEventType() {
    return eventType;
  }

  public void setEventType(SubEventType eventType) {
    this.eventType = eventType;
  }

  public String getEquipmentTypeGroupCode() {
    return equipmentTypeGroupCode;
  }

  public void setEquipmentTypeGroupCode(String equipmentTypeGroupCode) {
    this.equipmentTypeGroupCode = equipmentTypeGroupCode;
  }

  public String getEquipmentTypeCode() {
    return equipmentTypeCode;
  }

  public void setEquipmentTypeCode(String equipmentTypeCode) {
    this.equipmentTypeCode = equipmentTypeCode;
  }

  public int getSequenceNumber() {
    return sequenceNumber;
  }

  public void setSequenceNumber(int sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getRecordUpdateDateTime() {
    return recordUpdateDateTime;
  }

  public void setRecordUpdateDateTime(Date recordUpdateDateTime) {
    this.recordUpdateDateTime = recordUpdateDateTime;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }
  
}
