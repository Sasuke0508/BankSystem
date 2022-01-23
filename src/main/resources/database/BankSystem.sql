CREATE TABLE BankAccount (
  Id            varchar(255) NOT NULL, 
  EmployeeId    varchar(255) NOT NULL, 
  BranchId      varchar(255) NOT NULL, 
  HolderName    varchar(255), 
  AccountNumber varchar(255), 
  Status        bit(1) NOT NULL, 
  CreateDate    date, 
  ExpireDate    date, 
  CardNumber    varchar(255), 
  Balance       double NOT NULL, 
  Type          varchar(255), 
  Cvv           varchar(255), 
  CustomerId    varchar(255) NOT NULL, 
  PRIMARY KEY (Id)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE Branch (
  Id         varchar(255) NOT NULL, 
  Name       varchar(255), 
  Address    varchar(255), 
  CreateDate date, 
  PRIMARY KEY (Id)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Transaction` (
  Id                   varchar(255) NOT NULL, 
  EmployeeCreateId     varchar(255) NOT NULL, 
  BankAccountRecieveId varchar(255) NOT NULL, 
  BankAccountSendId    varchar(255) NOT NULL, 
  CreateDate           date, 
  Type                 varchar(255), 
  Amount               double NOT NULL, 
  Status               varchar(255), 
  Fee                  double NOT NULL, 
  Description          varchar(1000), 
  PRIMARY KEY (Id)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE Employee (
  Position   varchar(255), 
  Department varchar(255), 
  UserId     varchar(255) NOT NULL, 
  BranchId   varchar(255) NOT NULL, 
  PRIMARY KEY (UserId)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `User` (
  Id           varchar(255) NOT NULL, 
  BranchId     varchar(255) NOT NULL, 
  Name         varchar(255), 
  PhoneNumber  varchar(255), 
  DateOfBirth  date, 
  IdCardNumber varchar(255), 
  Email        varchar(255), 
  Address      varchar(255), 
  Password     varchar(255), 
  Gender       varchar(255), 
  Role         varchar(255), 
  CreateDate   date, 
  PRIMARY KEY (Id)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE Customer (
  MemberLevel varchar(255), 
  UserId      varchar(255) NOT NULL, 
  PRIMARY KEY (UserId)) ENGINE=InnoDB CHARACTER SET UTF8;
ALTER TABLE Employee ADD CONSTRAINT FKEmployee402129 FOREIGN KEY (UserId) REFERENCES `User` (Id);
ALTER TABLE Employee ADD CONSTRAINT FKEmployee811999 FOREIGN KEY (BranchId) REFERENCES Branch (Id);
ALTER TABLE `Transaction` ADD CONSTRAINT FKTransactio308648 FOREIGN KEY (BankAccountSendId) REFERENCES BankAccount (Id);
ALTER TABLE `Transaction` ADD CONSTRAINT FKTransactio761625 FOREIGN KEY (BankAccountRecieveId) REFERENCES BankAccount (Id);
ALTER TABLE BankAccount ADD CONSTRAINT FKBankAccoun240988 FOREIGN KEY (CustomerId) REFERENCES Customer (UserId);
ALTER TABLE BankAccount ADD CONSTRAINT FKBankAccoun621179 FOREIGN KEY (BranchId) REFERENCES Branch (Id);
ALTER TABLE `Transaction` ADD CONSTRAINT FKTransactio880706 FOREIGN KEY (EmployeeCreateId) REFERENCES Employee (UserId);
ALTER TABLE BankAccount ADD CONSTRAINT FKBankAccoun215850 FOREIGN KEY (EmployeeId) REFERENCES Employee (UserId);
ALTER TABLE Customer ADD CONSTRAINT FKCustomer697132 FOREIGN KEY (UserId) REFERENCES `User` (Id);
