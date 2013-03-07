/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/12/31 19:33:33                          */
/*==============================================================*/


drop table if exists dbeqp.cntr_iso_type;

drop table if exists dbeqp.eqmt_event_association;

drop table if exists dbeqp.eqp_event_log;

drop table if exists dbeqp.eqp_latest_info;

drop table if exists dbeqp.eqp_rejection_dtl;

drop table if exists dbeqp.eqp_rejection;

drop table if exists dbeqp.container;

drop table if exists dbeqp.eqp_supply_hierarchy;

/*==============================================================*/
/* Table: SUP_PAYEMENT                                         */
/*==============================================================*/
CREATE TABLE dbeqp.SUP_PAYMENT (
  SUP_PAYEMENT_id int(11) NOT NULL AUTO_INCREMENT,
  SUP_ACCOUNT_ID int(11) NOT NULL,
  PAYMENT_DATE datetime NOT NULL,
  PAYMENT_TYPE varchar(10) NOT NULL,
  CONTACT_ID int(11) NOT NULL,
  AMMOUNT double(11,4) NOT NULL,
  CURRENCY varchar(10) NOT NULL,
  CURRENCY_RATE double(11,4) NOT NULL,
  START_DATE datetime NOT NULL,
  END_DATE datetime NOT NULL,
  CREATE_DT datetime ,
  UPDATE_DT datetime ,
  PRIMARY KEY (SUP_PAYEMENT_id)
) ;


/*==============================================================*/
/* Table: SUP_ACCOUNT                                         */
/*==============================================================*/

CREATE TABLE dbeqp.SUP_ACCOUNT (
  SUP_ACCOUNT_id int(11) NOT NULL AUTO_INCREMENT,
  ACT_HLDR_NAME varchar(50) NOT NULL DEFAULT '',
  ACT_HLDR_ADDR varchar(300) NOT NULL DEFAULT '',
  ACT_BRANCH varchar(50) NOT NULL DEFAULT '',
  ACT_NUM varchar(50) NOT NULL DEFAULT '',
  IFSC_CODE varchar(50) NOT NULL DEFAULT '',
  BANK_ADDR varchar(300) NOT NULL DEFAULT '',
  CREATE_DT datetime DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  PRIMARY KEY (SUP_ACCOUNT_id)
);
/*==============================================================*/
/* Table: SUP_ASSIGN                                         */
/*==============================================================*/
CREATE TABLE dbeqp.SUP_ASSIGN (
  SUP_ASSIGN_id int(11) NOT NULL AUTO_INCREMENT,
  TRAINER_ID int(11) NOT NULL,
  TRAINEE_ID int(11) NOT NULL,
  START_DT datetime NOT NULL,
  END_DT datetime NOT NULL,
  STATUS varchar(10) NOT NULL,
  SUPPORT_TYPE varchar(50) NOT NULL,
  CREATE_DT datetime DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  PRIMARY KEY (SUP_ASSIGN_id)
);

/*==============================================================*/
/* Table: SUP_CONTACT                                         */
/*==============================================================*/
CREATE TABLE dbeqp.SUP_CONTACT (
  SUP_CONTACT_id int(11) NOT NULL AUTO_INCREMENT,
  NAME varchar(100) NOT NULL DEFAULT '',
  MOBILE_NO varchar(15) DEFAULT NULL,
  LOCATION varchar(200) DEFAULT NULL,
  GMAIL_ID varchar(50) DEFAULT NULL,
  SKYPE_ID varchar(50) DEFAULT '',
  TUPE_OF_MEM varchar(50) NOT NULL DEFAULT '',
  JOIN_DT datetime DEFAULT NULL,
  CREATE_DT datetime DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  PRIMARY KEY (SUP_CONTACT_id)
);
/*==============================================================*/
/* Table: CNTR_ISO_TYPE                                         */
/*==============================================================*/
create table dbeqp.CNTR_ISO_TYPE
(
   ISO_CDE              char(4) not null,
   GROUP_CDE            char(4),
   DESCRIPTION          varchar(50),
   primary key (ISO_CDE)
);

/*==============================================================*/
/* Table: CONTAINER                                             */
/*==============================================================*/
create table dbeqp.CONTAINER
(
   EQMT_NUM             varchar(10) not null,
   ISO_CDE              char(4) not null,
   GROUP_CDE            char(4) not null,
   CHK_DIGIT            char(1) not null,
   ACTIVE               boolean not null,
   CREATE_DT            timestamp,
   UPDATE_DT            timestamp,
   primary key (EQMT_NUM)
);

/*==============================================================*/
/* Table: EQMT_EVENT_ASSOCIATION                                */
/*==============================================================*/
create table dbeqp.EQMT_EVENT_ASSOCIATION
(
   EVENT_TIMESTAMP      char(32) not null,
   EQMT_NUM             varchar(10) not null,
   EQMT_TYPE            char(1) not null,
   SEQ_NUM              int,
   LOC                  char(5),
   EVENT_DT_LOC         datetime not null,
   EVENT_TYPE           char(2) not null,
   EQMT_TYPE_GRP_CDE    char(4) not null,
   EQMT_TYPE_CDE        char(4) not null,
   MATERIAL             varchar(20),
   DOC_NUM              varchar(20),
   UPD_USER             varchar(16),
   REC_UPD_DT           datetime,
   primary key (EVENT_TIMESTAMP)
);

/*==============================================================*/
/* Table: EQP_EVENT_LOG                                         */
/*==============================================================*/
create table dbeqp.EQP_EVENT_LOG
(
   EVENT_TIMESTAMP      char(32) not null,
   EVENT_CRE_DT         datetime not null,
   FCIL_CDE             char(5)  not null,
   EVENT_TYPE           char(2) not null,
   EVENT_DT_LOC         datetime  not null,
   CNTR_NUM             varchar(10) not null,
   CNTR_CHK_DIGIT       char(1),
   SEAL_NUM             varchar(12),
   SEAL_TYPE            char(2),
   CNTR_GRP_CDE         char(4),
   LOAD_EMPTY_IND       char(1),
   SVC_LOOP             varchar(4),
   VSL_CDE              varchar(3),
   VOY_NUM              varchar(3),
   DIR_BOUND            varchar(5),
   LOAD_PORT            varchar(3),
   DSGH_PORT            varchar(3),
   NEXT_LOCA            varchar(5),
   DOC_REF              varchar(12),
   DOC_TYPE             char(2),
   GROSS_WT             numeric(7,2),
   GROSS_WT_UNIT        enum('LBS','KT','KGS'),
   CNTR_COND            int,
   HZ_IND               boolean,
   REMARKS              blob,
   CONTRA_ACTION        char(1),
   POS_AT_ROUTE         char(2),
   NATURE               char(2),
   UPD_USER             varchar(16),
   REC_UPD_DT           datetime,
   primary key (EVENT_TIMESTAMP)
);

/*==============================================================*/
/* Table: EQP_LATEST_INFO                                       */
/*==============================================================*/
create table dbeqp.EQP_LATEST_INFO
(
   EQMT_NUM             varchar(10) not null,
   EQMT_TYPE            CHAR(1) not null,
   EVENT_TIMESTAMP      char(32) not null,
   EVENT_DT_LOC         datetime not null,
   EVENT_TYPE           char(2) not null,
   ISO_CDE              char(4),
   GROUP_CDE            char(4),
   ACTIVE               boolean,
   CURR_LOCA            char(5) not null,
   NEXT_LOCA            char(5),
   SVC_LOOP             varchar(4),
   VSL_CDE              varchar(3),
   VOY_NUM              varchar(3),
   DIR_BOUND            varchar(5),
   CONTRA_ACTION        char(1),
   DOC_REF              varchar(12),
   DOC_TYPE             char(2),
   LOAD_PORT            char(3),
   DSGH_PORT            char(3),
   UPD_USER             varchar(16),
   REC_UPD_DT           datetime,
   primary key (EQMT_NUM)
);

/*==============================================================*/
/* Table: EQP_REJECTION                                         */
/*==============================================================*/
create table dbeqp.EQP_REJECTION
(
   EVENT_TIMESTAMP      char(32) not null,
   EVENT_CRE_DT         DATETIME,
   FCIL_CDE             char(5),
   EVENT_TYPE           char(2),
   EVENT_DT_LOC         DATETIME,
   CNTR_NUM             varchar(10),
   CNTR_CHK_DIGIT       char(1),
   SEAL_NUM             varchar(12),
   SEAL_TYPE            char(2),
   ISO_CDE              char(4),
   GROUP_CDE            char(4),
   LOAD_EMPTY_IND       char(1),
   SVC_LOOP             varchar(4),
   VSL_CDE              varchar(3),
   VOY_NUM              varchar(3),
   DIR_BOUND            varchar(5),
   LOAD_PORT            varchar(3),
   DSGH_PORT            varchar(3),
   NEXT_LOCA            varchar(5),
   DOC_REF              varchar(20),
   DOC_TYPE             char(2),
   GROSS_WT             numeric(7,2),
   GROSS_WT_UNIT        enum('LBS','KT','KGS'),
   CNTR_COND            int,
   HZ_IND               boolean,
   REMARKS              blob,
   POS_AT_ROUTE         char(2),
   NATURE               char(2),
   MATERIAL             varchar(12),
   UPD_USER             varchar(16),
   REC_UPD_DT           datetime,
   primary key (EVENT_TIMESTAMP)
);

/*==============================================================*/
/* Table: EQP_REJECTION_DTL                                     */
/*==============================================================*/
create table dbeqp.EQP_REJECTION_DTL
(
   ID                   char(32) not null,
   EVENT_TIMESTAMP      char(32),
   ERROR_CODE           char(4),
   RULE                 varchar(20),
   primary key (ID)
);

/*==============================================================*/
/* Table: EQP_SUPPLY_HIERARCHY                                  */
/*==============================================================*/
create table dbeqp.EQP_SUPPLY_HIERARCHY
(
   FACILITY             char(5) not null,
   OFFICE               char(3) not null,
   REGION               varchar(20) not null,
   REG_CDE              char(4),
   TERRITORY            char(3) not null,
   REC_UPD_DT           datetime,
   primary key (FACILITY)
);

alter table dbeqp.EQMT_EVENT_ASSOCIATION add constraint FK_Reference_4 foreign key (LOC)
      references dbeqp.EQP_SUPPLY_HIERARCHY (FACILITY) on delete restrict on update restrict;

alter table dbeqp.EQP_EVENT_LOG add constraint FK_Reference_3 foreign key (FCIL_CDE)
      references dbeqp.EQP_SUPPLY_HIERARCHY (FACILITY) on delete restrict on update restrict;

alter table dbeqp.EQP_LATEST_INFO add constraint FK_Reference_2 foreign key (EQMT_NUM)
      references dbeqp.CONTAINER (EQMT_NUM) on delete restrict on update restrict;

alter table dbeqp.EQP_REJECTION_DTL add constraint FK_Reference_5 foreign key (EVENT_TIMESTAMP)
      references dbeqp.EQP_REJECTION (EVENT_TIMESTAMP) on delete restrict on update restrict;
      
 CREATE TABLE `dbeqp`.`sup_transaction` (
	`SUP_TRANSACTION_id` INT(11) NOT NULL AUTO_INCREMENT,
	`SUP_ACCOUNT_ID` INT(11) NOT NULL,
	`AMOUNT` VARCHAR(300) NOT NULL DEFAULT '',
	`OPERATION` VARCHAR(50) NOT NULL DEFAULT '',
	`CREATE_DT` DATETIME NULL DEFAULT NULL,
	`UPDATE_DT` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`SUP_TRANSACTION_id`)
);

CREATE  TABLE `dbeqp`.`SUP_USER` (
  `SUP_USER_ID` INT NOT NULL AUTO_INCREMENT ,
  `SUP_USER_NAME` VARCHAR(45) NOT NULL ,
  `SUP_USER_PWD` VARCHAR(45) NULL ,
  `CREATE_DT` DATETIME NULL ,
  `UPDATE_DT` VARCHAR(45) NULL ,
  PRIMARY KEY (`SUP_USER_ID`) );

